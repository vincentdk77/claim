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
 * �ַ�HTTP Post �����������༭����
 * <p>Title: �����������༭������Ϣ</p>
 * <p>Description: �����������༭������Ϣ</p>
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
     
    String forward = ""; //��ǰ��ת
    try {

      String registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo"); //������
      String claimNo = httpServletRequest.getParameter("prpLverifyLossClaimNo"); //�ⰸ��
      String nextHandlerCode = httpServletRequest.getParameter("nextHandlerCode");
      String nextHandlerName = httpServletRequest.getParameter("nextHandlerName");
      String flowID = httpServletRequest.getParameter("swfLogFlowID");
      String LogNo = httpServletRequest.getParameter("swfLogLogNo"); 
      String nodeType = httpServletRequest.getParameter("nodeType");
      String riskCodeTemp = httpServletRequest.getParameter("prpLverifyLossRiskCode");
      //String insureCarFlag=httpServletRequest.getParameter("prpLverifyLossInsureCarFlag"); //�Ƿ�Ϊ����������
      //String lossItemCode=httpServletRequest.getParameter("prpLverifyLossLossItemCode");   //��ʧ���
      //String lossItemName=httpServletRequest.getParameter("prpLverifyLossLossItemName");   //��������
      int nextNodeNo = 0;
      httpServletRequest.setAttribute("registNo", registNo);
      httpServletRequest.setAttribute("claimNo", claimNo);
      UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
      Collection nextNodeList  = new ArrayList();
      //reason: �����ֹ�ظ��ύ
		String strLastAccessedTime = ""
				+ httpServletRequest.getSession().getLastAccessedTime()
				/ 1000;
		String oldLastAccessedTime = (String) httpServletRequest
				.getSession().getAttribute("oldVerifyLossLastAccessedTime");
		if (oldLastAccessedTime ==null || "".equals(oldLastAccessedTime)) {
			// modify by ww add begin 2005-11-15
			// reason: �����ֹ�ظ��ύ
			httpServletRequest.getSession().setAttribute(
					"oldVerifyLossLastAccessedTime", strLastAccessedTime);
			
			//��ֹ����ˢ�����ύ�������ͬʱ�����ύͬһ������
			UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
			String condition = "flowId ='"+flowID+"' and  logno= "+ LogNo+"  and nodeStatus in ('4','5')";
		    Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
		    if(certifyNodeList!=null&&certifyNodeList.size()>0){
		    	   throw new UserException(1,3,"������","�ð�������ڵ��Ѵ���");
		    }
	  	    //��viewHelper�����������
			//add by miaowenjun 20060925 start ũ�����Լ���viewhelper 
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
			//add by miaowenjun 20060925 end ũ�����Լ���viewhelper
	        //���������Ϣ
	  	    UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
	  	    //�������������
	        //-----------------------------------------------------
	        // 1requst����,2���ڵ�Ľڵ�����,3���ڵ���Ҫ���µ�״̬,4���ڵ��ҵ�����,5�Ժ�ڵ��ҵ�����,6���ڵ��ҵ���������,7�Ժ�ڵ��ҵ����������
	          WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
	          SwfLogDto swfLogDtoDealNode = new SwfLogDto();
	
	          swfLogDtoDealNode.setLossItemCode(verifyLossDto.getPrpLverifyLossDto().getLossItemCode());
	          swfLogDtoDealNode.setTypeFlag(verifyLossDto.getPrpLclaimStatusDto().getTypeFlag());
	          swfLogDtoDealNode.setLossItemName(verifyLossDto.getPrpLverifyLossDto().getLossItemName());
	          //�����Ƿ񱣵������ı�־
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
	          //��Ϊ���������ƣ�������������ҵ����������
	          swfLogDtoDealNode.setConditionBusinessNo(registNo);
	          //��Ϊ�˵��˵�ԭ��
	          if (swfLogDtoDealNode.getNodeStatus().equals("4"))
	          {
	        	  if(httpServletRequest.getParameter("nextNodeNo") != null){
    				  nextNodeNo= Integer.parseInt(httpServletRequest.getParameter("nextNodeNo"));
	        	  }
	           //�����ӻؿ�����һ���ڵ�
	            
	           SwfLogDto swfLogNextNode = new SwfLogDto();
	           if(verifyLossDto.getPrpLcarLossDtoList()!=null&&verifyLossDto.getPrpLcarLossDtoList().size()>0&&(!nodeType.equals("backc"))){
	             PrpLcarLossDto prpLcarLossDto= (PrpLcarLossDto)verifyLossDto.getPrpLcarLossDtoList().get(0);
	             if(prpLcarLossDto.getBackCheckFlag().equals("1")){
	               //��Ҫ�����޸��鳵
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
	        	  *//*************�����ύ���̿���****************//*
		          swfLogDtoDealNode.setNextNodeListType("1");// �����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
		          swfLogDtoDealNode.setSwfLogList(nextNodeList); //������һ���ڵ�
		          *//******************************//*
	          }*/
	          }
	        
			  //�˻أ��ύ���𣬲�������Ϊ����Ļ��˱�־
			  if (swfLogDtoDealNode.getNodeStatus().equals("5")) {
	            
			  	if(nodeType!=null && nodeType.trim().equals("propv")){
					//����Ҫ�˻صĽڵ�				
					swfLogDtoDealNode.setNodeType("propc");
					//swfLogDtoDealNode.setBusinessType("verif") ;
			  		swfLogDtoDealNode.setNextNodeListType("1");//�����1��������Ҫָ��Ҫ���˵Ľڵ㣬������ǣ�����swflog����Ѱ�һ��˵Ľڵ�
			    }				
			  }
			
	          WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
	          
	          if(swfLogDtoDealNode.getNodeStatus().equals("4")){
	        	  if("D".equals(riskType)){
						/***************��ȥ���ն���Ľڵ�start*******************/
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
						/***************��ȥ���ն���Ľڵ�end*******************/
					}
	          }
	          
	          
	          
	          
	          
	          //����ǵ�5�Ļ����ύ���𣬲�������Ϊ����Ļ��˱�־���Լ�flagtypeҲ��Ҫ����
	          //------------------------------------------------------------
	
	  	     //���Ǵ�����Ķ���һֱ�����ڴ���Ĺ��̣�һֱ���������̽��������
	        //       ����ύ�Ļ�����ô�Լ���״̬����2
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
	          user.setUserMessage(registNo+";ע��:û�з����빤������������κ����ݣ���");
	        }
	     // }isTokenValid
	  	    
	  	   //���ù��ӱ�ͬ��״̬�ӿ� start
			if(swfLogDtoDealNode.getNodeStatus().equals("4")){
				try{
	  	    		UIClaimSynStatusFacade uiClaimSynStatusFacade = new UIClaimSynStatusFacade();
		  		    uiClaimSynStatusFacade.synRegistStatus(registNo, "1");
	  	    	}catch(Exception e){
	  	    		e.printStackTrace();
	  	    	}
			}
			//���ù��ӱ�ͬ��״̬�ӿ� end
	
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
			throw new UserException(1, 3, "������", "�벻Ҫ�ظ��ύ");
		}
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
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
      //������Ϣ����
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
      //������Ϣ����
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
