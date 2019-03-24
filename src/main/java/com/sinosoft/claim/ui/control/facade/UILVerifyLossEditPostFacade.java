package com.sinosoft.claim.ui.control.facade;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.VerifyLossDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLcarLossDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIVerifyLossAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriVerifyLossViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAVerifyLossViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP Post 车险理赔核损编辑界面
 * <p>Title: 车险理赔核损编辑界面信息</p>
 * <p>Description: 车险理赔核损编辑界面信息</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author liubvo
 * @version 1.0
 */  
public class UILVerifyLossEditPostFacade  extends Action {
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
     throws  Exception
  {
     
    String forward = ""; //向前流转
    try {

      String registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo"); //报案号
      String claimNo = httpServletRequest.getParameter("prpLverifyLossClaimNo"); //赔案号
      String nextHandlerCode = httpServletRequest.getParameter("nextHandlerCode");
      String nextHandlerName = httpServletRequest.getParameter("nextHandlerName");
      String flowID = httpServletRequest.getParameter("swfLogFlowID");
      String LogNo = httpServletRequest.getParameter("swfLogLogNo"); 
      String nodeType = httpServletRequest.getParameter("nodeType");
      String riskCodeTemp = httpServletRequest.getParameter("prpLverifyLossRiskCode");
      //String insureCarFlag=httpServletRequest.getParameter("prpLverifyLossInsureCarFlag"); //是否为本保单车辆
      //String lossItemCode=httpServletRequest.getParameter("prpLverifyLossLossItemCode");   //损失标的
      //String lossItemName=httpServletRequest.getParameter("prpLverifyLossLossItemName");   //车牌名称
      int nextNodeNo = 0;
      httpServletRequest.setAttribute("registNo", registNo);
      httpServletRequest.setAttribute("claimNo", claimNo);
      UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
      Collection nextNodeList  = new ArrayList();
      //reason: 核损防止重复提交
		String strLastAccessedTime = ""
				+ httpServletRequest.getSession().getLastAccessedTime()
				/ 1000;
		String oldLastAccessedTime = (String) httpServletRequest
				.getSession().getAttribute("oldVerifyLossLastAccessedTime");
		if (oldLastAccessedTime ==null || "".equals(oldLastAccessedTime)) {
			// modify by ww add begin 2005-11-15
			// reason: 核损防止重复提交
			httpServletRequest.getSession().setAttribute(
					"oldVerifyLossLastAccessedTime", strLastAccessedTime);
			
			//防止回退刷新再提交，或多人同时操作提交同一案件。
			UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
			String condition = "flowId ='"+flowID+"' and  logno= "+ LogNo+"  and nodeStatus in ('4','5')";
		    Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
		    if(certifyNodeList!=null&&certifyNodeList.size()>0){
		    	   throw new UserException(1,3,"工作流","该案件核损节点已处理！");
		    }
	  	    //用viewHelper整理界面输入
			//add by miaowenjun 20060925 start 农险走自己的viewhelper 
	        AgriVerifyLossViewHelper agriVerifyLossViewHelper = new AgriVerifyLossViewHelper();
	        DAAVerifyLossViewHelper dAAVerifyLossViewHelper = new DAAVerifyLossViewHelper();
	        VerifyLossDto verifyLossDto = new VerifyLossDto();
			String riskCode = httpServletRequest.getParameter("prpLverifyLossRiskCode");
			String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
			if("I".equals(riskType)||"H".equals(riskType)|| "Q".equals(riskType)|| "Z".equals(riskType)|| "Y".equals(riskType)){
				verifyLossDto = agriVerifyLossViewHelper.viewToDto(httpServletRequest);
			}else{
				verifyLossDto = dAAVerifyLossViewHelper.viewToDto(httpServletRequest);
			}
			//add by miaowenjun 20060925 end 农险走自己的viewhelper
	        //保存核损信息
	  	    UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
	  	    //工作流处理过程
	        //-----------------------------------------------------
	        // 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码
	          WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
	          SwfLogDto swfLogDtoDealNode = new SwfLogDto();
	
	          swfLogDtoDealNode.setLossItemCode(verifyLossDto.getPrpLverifyLossDto().getLossItemCode());
	          swfLogDtoDealNode.setTypeFlag(verifyLossDto.getPrpLclaimStatusDto().getTypeFlag());
	          swfLogDtoDealNode.setLossItemName(verifyLossDto.getPrpLverifyLossDto().getLossItemName());
	          //保存是否保单车辆的标志
	          swfLogDtoDealNode.setInsureCarFlag(verifyLossDto.getPrpLverifyLossDto().getInsureCarFlag());
	        
	
	          swfLogDtoDealNode.setNodeType(nodeType);
	          String statusTemp = httpServletRequest.getParameter("buttonSaveType");
	          swfLogDtoDealNode.setNodeStatus(statusTemp) ;
	          swfLogDtoDealNode.setRiskCode(riskCodeTemp);
	          if (claimNo!=null&&claimNo.length()>0) {
	            swfLogDtoDealNode.setBusinessNo(claimNo);
	            swfLogDtoDealNode.setNextBusinessNo(claimNo);
	          } else {
	            swfLogDtoDealNode.setBusinessNo(registNo);
	            swfLogDtoDealNode.setNextBusinessNo(registNo);
	          }
	          swfLogDtoDealNode.setKeyIn(registNo);
	          swfLogDtoDealNode.setKeyOut(registNo);
	          swfLogDtoDealNode.setFlowID(flowID);
	          swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(LogNo)));
	          //因为有条件限制，所以有条件的业务主键传入
	          swfLogDtoDealNode.setConditionBusinessNo(registNo);
	          //因为人到人的原因
	          if (swfLogDtoDealNode.getNodeStatus().equals("4"))
	          {
	        	  if(httpServletRequest.getParameter("nextNodeNo") != null){
    				  nextNodeNo= Integer.parseInt(httpServletRequest.getParameter("nextNodeNo"));
	        	  }
	           //可增加回勘的下一个节点
	            
	           SwfLogDto swfLogNextNode = new SwfLogDto();
	           if(verifyLossDto.getPrpLcarLossDtoList()!=null&&verifyLossDto.getPrpLcarLossDtoList().size()>0&&(!nodeType.equals("backc"))){
	             PrpLcarLossDto prpLcarLossDto= (PrpLcarLossDto)verifyLossDto.getPrpLcarLossDtoList().get(0);
	             if(prpLcarLossDto.getBackCheckFlag().equals("1")){
	               //需要增加修复验车
	               swfLogNextNode = new SwfLogDto(); 
	               swfLogNextNode.setNodeNo(0);
	               swfLogNextNode.setNodeType("backc");
	               //swfLogNextNode.setLossItemCode(lossItemCode);
	               //swfLogNextNode.setLossItemName(lossItemName);
	               //swfLogNextNode.setTypeFlag(verifyLossDto.getPrpLclaimStatusDto().getTypeFlag());
	               nextNodeList.add(swfLogNextNode);
	             } 
	           }     
	           
	           if (nextNodeList.size()>0){       
	           swfLogDtoDealNode.setSwfLogList(nextNodeList);
	           swfLogDtoDealNode.setNextNodeListType("1"); 
	          }
	          swfLogDtoDealNode.setNodeNo(nextNodeNo);
	          swfLogDtoDealNode.setHandlerCode(nextHandlerCode);
	          swfLogDtoDealNode.setHandlerName(nextHandlerName);
	          /*if("D".equals(riskType)){
	        	  *//*************人伤提交流程控制****************//*
		          swfLogDtoDealNode.setNextNodeListType("1");// 如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
		          swfLogDtoDealNode.setSwfLogList(nextNodeList); //设置下一个节点
		          *//******************************//*
	          }*/
	          }
	        
			  //退回，提交定损，并且设置为定损的回退标志
			  if (swfLogDtoDealNode.getNodeStatus().equals("5")) {
	            
			  	if(nodeType!=null && nodeType.trim().equals("propv")){
					//设置要退回的节点				
					swfLogDtoDealNode.setNodeType("propc");
					//swfLogDtoDealNode.setBusinessType("verif") ;
			  		swfLogDtoDealNode.setNextNodeListType("1");//如果得1，就是需要指定要回退的节点，如果不是，就是swflog表中寻找回退的节点
			    }				
			  }
			
	          WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
	          
	          if(swfLogDtoDealNode.getNodeStatus().equals("4")){
	        	  if("D".equals(riskType)){
						/***************除去车险多余的节点start*******************/
						ArrayList<SwfLogDto> list = null;
						ArrayList<SwfPathLogDto>  listPath=null;
						SwfLogDto swfLogdto=null;
						SwfPathLogDto swfPathLogdto=null;
						list = workFlowDto.getSubmitSwfLogDtoList();
						listPath =workFlowDto.getSubmitSwfPathLogDtoList();
						ArrayList<SwfLogDto> listNext=new ArrayList<SwfLogDto>();
						ArrayList<SwfPathLogDto> listpathNext=new ArrayList<SwfPathLogDto>();
						if(list!=null&&!list.isEmpty()){
							for(int i=0;i<list.size();i++){
								swfLogdto =list.get(i);
								if("certi".equals((swfLogdto.getNodeType()))){
									listNext.add(swfLogdto);
								}
							}
							if(!listNext.isEmpty()){
								int nodeno=listNext.get(0).getLogNo();
								for(int i=0;i<listPath.size();i++){
									swfPathLogdto =listPath.get(i);
									if(nodeno==swfPathLogdto.getEndNodeNo()){
										listpathNext.add(swfPathLogdto);
									}
								}
							}
						}
						
						if(listNext.isEmpty()){
							workFlowDto.setSubmitSwfLogDtoList(null);
							workFlowDto.setSubmitSwfPathLogDtoList(null);
						}else{
							workFlowDto.setSubmitSwfLogDtoList(listNext);
							workFlowDto.setSubmitSwfPathLogDtoList(listpathNext);
						}
						/***************除去车险多余的节点end*******************/
					}
	          }
	          
	          
	          
	          
	          
	          //如果是得5的话，提交定损，并且设置为定损的回退标志，以及flagtype也需要设置
	          //------------------------------------------------------------
	
	  	     //凡是处理过的定损一直是正在处理的过程，一直到整个流程结束的情况
	        //       如果提交的话，那么自己的状态还是2
	       /*
	        if (workFlowDto.getUpdate()&&workFlowDto.getSubmit())
	        {
	        workFlowDto.getUpdateSwfLogDto().setNodeStatus("2");
	        }
	       */
	  	    if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate()) ||(workFlowDto.getSubmit())||(workFlowDto.getClose()))
	        {
	          uiVerifyLossAction.save(verifyLossDto,workFlowDto);
	  	      user.setUserMessage(registNo);
	        } else {
	          uiVerifyLossAction.save(verifyLossDto);
	          user.setUserMessage(registNo+";注意:没有发现与工作流流程相关任何数据！！");
	        }
	     // }isTokenValid
	  	    
	  	   //调用过河兵同步状态接口 start
			if(swfLogDtoDealNode.getNodeStatus().equals("4")){
				try{
	  	    		UIClaimSynStatusFacade uiClaimSynStatusFacade = new UIClaimSynStatusFacade();
		  		    uiClaimSynStatusFacade.synRegistStatus(registNo, "1");
	  	    	}catch(Exception e){
	  	    		e.printStackTrace();
	  	    	}
			}
			//调用过河兵同步状态接口 end
	
		    String verifyLossSaveMessage = "q"+registNo;
		    ActionMessages messages = new ActionMessages();
		    Object obj_msg = verifyLossSaveMessage;
	
		    if(httpServletRequest.getParameter("buttonSaveType").trim().equals("4")){
		      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.verifyLoss.submit"));
		    }else {
		      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.verifyLoss.save"));
		    }
		    messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLclaim.registNo"));
		    saveMessages( httpServletRequest, messages );
		    forward="success";
		} else {
			throw new UserException(1, 3, "工作流", "请不要重复提交");
		}
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.verifyLossBeforeEdit.editVerifyLoss");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(SQLException sqle)
    {
      StringWriter stringWriter = new StringWriter();
      sqle.printStackTrace(new PrintWriter(stringWriter));
      sqle.printStackTrace();
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.verifyLossBeforeEdit.editVerifyLoss");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",stringWriter.toString() ) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch (Exception e) {
      StringWriter stringWriter = new StringWriter();
      e.printStackTrace(new PrintWriter(stringWriter));
      e.printStackTrace();
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.verifyLossBeforeEdit.editVerifyLoss");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",stringWriter.toString()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    finally {
    }
     
    return actionMapping.findForward(forward);
  }
}
//
