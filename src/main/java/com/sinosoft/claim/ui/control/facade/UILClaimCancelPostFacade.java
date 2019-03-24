package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

import com.sinosoft.bz.common.RequestType;
import com.sinosoft.ciplatform.bl.facade.BLCIClaimSYXPlatFormInterfaceFacade;
import com.sinosoft.ciplatform.bl.facade.BLCIPlatformConfigFacade;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.claim.bl.facade.BLPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcertifyImgFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UIEndcaseAction;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAClaimViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormCheckAction;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimPlatFormInterfaceFacade;
import com.sinosoft.claimciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.image.bl.facade.BLPrpdcertifycheckFacade;
import com.sinosoft.image.bl.facade.BLPrpdimagecodeFacade;
import com.sinosoft.image.dto.domain.PrpdimagecodeDto;
import com.sinosoft.platform.bl.facade.BLPrpDriskConfigFacade;
import com.sinosoft.platform.dto.domain.PrpDriskConfigDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utiall.dbsvr.DBPrpDcompany;
import com.sinosoft.utiall.dbsvr.DBPrpDuser;

//设置工作流测试
//import com.sinosoft.function.workflow.client.SharkClient;

/**
 * 分发HTTP Post 车险理赔立案拒赔界面
 * <p>Title: 车险理赔立案拒赔界面信息</p>
 * <p>Description: 车险理赔立案拒赔界面信息保存</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author lijiyuan,lixiang
 * @version 1.0
 */

public class UILClaimCancelPostFacade
extends Action {
    public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws
      Exception {

     

    String forward = ""; //向前流转

    try {
      //用viewHelper整理界面输入
       String caseType=((String)httpServletRequest.getParameter("caseType"));
         
       DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
       UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();
       UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
       ClaimDto claimDto = dAAClaimViewHelper.cancelViewToDto(httpServletRequest);
       //以下为工作流使用中的
       String editType = httpServletRequest.getParameter("editType");
       String nodeType=httpServletRequest.getParameter("nodeType");
	   String strClaimNo=httpServletRequest.getParameter("prpLclaimClaimNo");
       String businessNo=httpServletRequest.getParameter("businessNo");
       String prpLcancelclaimPrintFlag=httpServletRequest.getParameter("prpLcancelclaimPrintFlag");
	   String status=httpServletRequest.getParameter("status");
       String strCaseType="";
       String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //工作流号码
       String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //工作流logno
       ActionMessages messages = new ActionMessages();
       ActionMessage message;
       
       //影像系统添加
       BLPrpdimagecodeFacade blPrpdimagecodeFacade = new BLPrpdimagecodeFacade();
       BLPrpdcertifycheckFacade blPrpdcertifycheckFacade = new BLPrpdcertifycheckFacade();
       PrpdimagecodeDto prpdimagecodeDto = new PrpdimagecodeDto();
       DBPrpDuser dbPrpDuser = new DBPrpDuser();
       DBPrpDcompany dbprpDcompany = new DBPrpDcompany();
       String role = "";
       String appcode = "";
       String appname = "";  
       String username="";
       String comcode = "";
       String comname= "";
       int t = 0;
       t = dbPrpDuser.getInfo(user.getUserCode());
       username=dbPrpDuser.getUserName();
       t = dbprpDcompany.getInfo(dbPrpDuser.getComCode());
       comcode = dbPrpDuser.getComCode();
       comname= dbprpDcompany.getComCName();
       String result = "";
       String imgRiskCode = BusinessRuleUtil.getRiskCode(claimDto.getPrpLclaimDto().getClaimNo(),"ClaimNo" );
     
       //防止重复提交
       String strLastAccessedTime = String.valueOf(httpServletRequest.getSession().getLastAccessedTime()/ 1000);
       String oldLastAccessedTime = (String) httpServletRequest.getSession().getAttribute("oldCancelAccessedTime");
	   if (oldLastAccessedTime !=null && !oldLastAccessedTime.trim().equals("")) {
	    	   throw new UserException(1, 3, "工作流", "请不要重复提交");
	   }
	   httpServletRequest.getSession().setAttribute("oldCancelAccessedTime", strLastAccessedTime);
	   //防止回退刷新再提交，或多人同时操作提交同一案件。
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		String condition = "flowId ='"+swfLogFlowID+"' and  logno= "+ swfLogLogNo+"  and nodeStatus = '4'";
	    Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
	    if(certifyNodeList!=null&&certifyNodeList.size()>0){
	    	   throw new UserException(1,3,"工作流","该案件注销/拒赔节点已处理！");
	    }
       //Reason: 注销/拒赔添加退回功能
       String strSubmitType = httpServletRequest.getParameter("submitType"); //提交类型
       uiWorkFlowAction = new UIWorkFlowAction();
       if ("5".equals(strSubmitType.trim())) {
           uiWorkFlowAction.cancelBack(swfLogFlowID, Integer.parseInt(swfLogLogNo));
           UIPrpLregistRPolicyAction  uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction(); 
           PrpLRegistRPolicyDto prpLRegistRPolicyDto = uiPrpLregistRPolicyAction
						.findByPrimaryKey(claimDto.getPrpLclaimDto()
								.getRegistNo(), claimDto.getPrpLclaimDto()
								.getPolicyNo());
				if (prpLRegistRPolicyDto != null) {
					prpLRegistRPolicyDto.setCancelReason("");
					prpLRegistRPolicyDto.setCancelReasonName("");
					new BLPrpLRegistRPolicyFacade()
							.update(prpLRegistRPolicyDto);
				}
           messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.claimCancel.cancelback"));
           saveMessages( httpServletRequest, messages );
           return actionMapping.findForward("success");
       }
       //Modify by ww add end 2005-11-24
       
       String registNo= httpServletRequest.getParameter("prpLclaimRegistNo");
//       String conditions=" businessNo = '"+registNo+"'  and ValidStatus ='1' and typeCode ='0102' ";
//       BLPrpLcertifyImgFacade blPrpLcertifyImgFacade = new BLPrpLcertifyImgFacade();
//       ArrayList<PrpLcertifyImgDto> PrpLcertifyImgDtoList = (ArrayList<PrpLcertifyImgDto>) blPrpLcertifyImgFacade.findByConditions(conditions);
//       if(null == PrpLcertifyImgDtoList || PrpLcertifyImgDtoList.size()==0){
//    	   throw new UserException(1,3,"立案注销","至少上传一张注销照片！");
//       }
       if(imgRiskCode!=null)
       {
 		  prpdimagecodeDto = blPrpdimagecodeFacade.findByPrimaryKey(imgRiskCode,"0000000000");
		  role = prpdimagecodeDto.getClaimrole();
		  appcode=prpdimagecodeDto.getClaimcode();
		  appname=prpdimagecodeDto.getClaimname();
		  //String businessno= "1111111111";
		  String businessno = registNo;
		   StringBuffer s = new StringBuffer();
		   s.append("<?xml version='1.0' encoding='UTF-8'?><root><BASE_DATA>");
		   s.append("<USER_CODE>");
		   s.append(user.getUserCode());
		   s.append("</USER_CODE>");
		   
		   s.append("<USER_NAME>");
		   s.append(username);
		   s.append("</USER_NAME>");
		   
		   s.append("<ORG_CODE>");
		   s.append(comcode);
		   s.append("</ORG_CODE>");
		   
		   s.append("<ORG_NAME>");
		   s.append(comname);
		   s.append("</ORG_NAME>");
		   
		   s.append("<ROLE_CODE>");
		   s.append(role);
		   s.append("</ROLE_CODE>");
		   
		   s.append("</BASE_DATA><META_DATA><BATCH>");
		   
		   s.append("<APP_CODE>");
		   s.append(appcode);
		   s.append("</APP_CODE>");
		   
		   s.append("<APP_NAME>");
		   s.append(appname);
		   s.append("</APP_NAME>");
		   
		   s.append("<BUSI_NO>");
		   s.append(businessno);
		   s.append("</BUSI_NO>");
		   
		   s.append("</BATCH></META_DATA></root>");
		   try{
			   System.err.println(s.toString());
			   result = blPrpdimagecodeFacade.imageStatistics(s.toString());
			   //System.err.println(result);
			   String newxml = blPrpdimagecodeFacade.html2xml(result);
			   String nodeID = "";
			   String strWaning = "";
			   Collection nodes =  new ArrayList();
			   if(caseType.equals("0") )
			   {
				   nodes = blPrpdcertifycheckFacade.findAllByPrimaryKey(imgRiskCode,"claim_close");
			   }else
			   {
				   nodes = blPrpdcertifycheckFacade.findAllByPrimaryKey(imgRiskCode,"claim_reject");
			   }
			   HashMap hm = blPrpdimagecodeFacade.imageNodeCheck(newxml,nodes);
			   strWaning = blPrpdcertifycheckFacade.checkMustUpload(nodes,hm);
			   if(!strWaning.equals(""))
			   {
				   throw new UserException(1, 3, "单证信息", strWaning);
			   }
			}catch (Exception e){
			e.printStackTrace();
			throw e;
		}
		   
       }

       //保存立案拒赔注销信息
       //在uiCLaimAcction里自动识别是否要怎么保存的具体操作
       //工作流处理过程,如果是ADD的类型，则先指定要到注销/核赔的申请，如果是注销核赔的确定，
       //直接完成注销核赔的确认
       //-----------------------------------------------------
       // 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码
        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        SwfLogDto swfLogNextNode= new SwfLogDto();
        Collection nextNodeList = new ArrayList();
        UIClaimAction uiClaimAction = new UIClaimAction(); 
    	
        //申请登记

        if (swfLogFlowID!=null && swfLogLogNo!=null&&!swfLogFlowID.equals("null")&& !swfLogLogNo.equals("null"))
        {
          swfLogDtoDealNode.setFlowID(swfLogFlowID);
          swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
        }

        if (editType.equals("ADD"))
        {
          swfLogDtoDealNode.setNodeType(nodeType);
          swfLogDtoDealNode.setNodeStatus("4");
          swfLogDtoDealNode.setBusinessNo(businessNo);
          swfLogDtoDealNode.setNextBusinessNo(claimDto.getPrpLclaimDto().getClaimNo() ); 
          
          //设置流转到注销/拒赔的受理节点去
          swfLogNextNode.setNodeNo(0);
         
          swfLogNextNode.setNodeType("cance");
          swfLogNextNode.setKeyIn(claimDto.getPrpLclaimDto().getClaimNo());
          swfLogNextNode.setPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());
          swfLogNextNode.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
          
          //判断是注销还是拒赔，是要放在工作流上的
          swfLogNextNode.setTypeFlag( caseType);
          nextNodeList.add(swfLogNextNode);
          swfLogDtoDealNode.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
          swfLogDtoDealNode.setSwfLogList(nextNodeList);
          //保存注销原因
          UIPrpLregistRPolicyAction  uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction(); 
          PrpLRegistRPolicyDto  prpLRegistRPolicyDto = uiPrpLregistRPolicyAction.findByPrimaryKey(claimDto.getPrpLclaimDto().getRegistNo(),claimDto.getPrpLclaimDto().getPolicyNo());
          if (prpLRegistRPolicyDto!=null ){
          	prpLRegistRPolicyDto.setCancelReason(httpServletRequest.getParameter("CancelReason"));
          	prpLRegistRPolicyDto.setCancelReasonName(httpServletRequest.getParameter("CancelReasonName"));
          	claimDto.setPrpLRegistRPolicyDto(prpLRegistRPolicyDto);
          }
         }//直接接收或退回
        else
        {
          swfLogDtoDealNode.setNodeType("cance");
          swfLogDtoDealNode.setNodeStatus("2");
          swfLogDtoDealNode.setBusinessNo(claimDto.getPrpLclaimDto().getClaimNo() );
          swfLogDtoDealNode.setTypeFlag(caseType);
          
          
          //	生成陪案号
            UIBillAction uiBillAction = new UIBillAction();
            String tableName = "prplcaseno";
            String comCode = user.getComCode();
            String riskCode = BusinessRuleUtil.getRiskCode(claimDto.getPrpLclaimDto().getClaimNo(),"ClaimNo" );
            int year =DateTime.current() .getYear() ;
            String caseNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
            
            claimDto.getPrpLclaimDto().setCaseNo(caseNo );
          
            claimDto.getPrpLclaimDto().setEndCaseDate( new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND ));
            claimDto.getPrpLclaimDto().setEndCaserCode(user.getUserCode() );
          
            claimDto.getPrpLclaimDto().setCaseNo(caseNo );
          //最后通过的时候才写这个数据的的
          
            claimDto.getPrpLclaimDto().setCancelDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
            claimDto.getPrpLclaimDto().setCaseType(caseType);
            
           
            UIPrpLregistRPolicyAction  uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction(); 
            
            PrpLRegistRPolicyDto  prpLRegistRPolicyDto = uiPrpLregistRPolicyAction.findByPrimaryKey(claimDto.getPrpLclaimDto().getRegistNo(),claimDto.getPrpLclaimDto().getPolicyNo());
            if (prpLRegistRPolicyDto!=null ){
            	prpLRegistRPolicyDto.setValidStatus("0");
            	prpLRegistRPolicyDto.setClaimNo(strClaimNo);
            	prpLRegistRPolicyDto.setCancelReason(httpServletRequest.getParameter("CancelReason"));
              	prpLRegistRPolicyDto.setCancelReasonName(httpServletRequest.getParameter("CancelReasonName"));
            	claimDto.setPrpLRegistRPolicyDto(prpLRegistRPolicyDto);
            }
            //需要增加是否需要结束流程的判断如果需要结束则，才结束工作流程。
            
            /*
            String sqlstr="registNo='"+claimDto.getPrpLclaimDto().getRegistNo()+"' and claimNo<>'"
			+claimDto.getPrpLclaimDto().getClaimNo()+"' and  endcasedate is null  ";
            Collection claimList1 = uiClaimAction.findByConditions(sqlstr);
            if(claimList1==null||claimList1.size() ==0){
            	//判断报案中是否还有没立案的数据。。。
            		sqlstr="registNo='"+claimDto.getPrpLclaimDto().getRegistNo()+"' and claimNo<>'"
				+claimDto.getPrpLclaimDto().getClaimNo()+"' and  validstatus='1' ";
	            
            	Collection registRPolciyList1 =uiPrpLregistRPolicyAction.findByConditions(sqlstr);
            	if(registRPolciyList1==null||registRPolciyList1.size() ==0){
            		swfLogDtoDealNode.setNodeStatus("4");
                	swfLogDtoDealNode.setEndFlag("1");
            	}
            }
            */
            swfLogDtoDealNode.setNodeStatus("4");
        	swfLogDtoDealNode.setEndFlag("1");
          
        }
        //考虑 到后来几乎都是用clamno做keyin的数值的。。
        swfLogDtoDealNode.setKeyIn(claimDto.getPrpLclaimDto().getClaimNo() );
        swfLogDtoDealNode.setKeyOut(claimDto.getPrpLclaimDto().getClaimNo() );
        WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
        //------------------------------------------------------------
        //保存立案信息并查找工作流程

        if (editType.equals("ADD")){
        	//add by lixiang start at 2006-6-22
        	//reason:注销/拒赔后，当任务没有被全部注销/拒赔时，可以继续操作，不受流程的申请的影响。
        	//如果是在理算节点回退的去更新理算节点状态
//        	if(!"compe".equals(nodeType)){
        		workFlowDto.setUpdate( false);
        		workFlowDto.setUpdateSwfLogDto( null);
//        	}
            //add by lixiang end at 2006-6-22
        	
          
        }else{
        	if (workFlowDto.getUpdateSwfLogDto()!=null){
        		workFlowDto.getUpdateSwfLogDto().setNodeStatus( "4");
        		//不更新另一个节点
        		if("compe".equals(nodeType)){
        			workFlowDto.setUpdateSwfLog2Dto(null);
        		}
        		else{
        			 //add by lixiang start at 2006-7-13
                    //reason:注销/拒赔通过后，将此任务的立案工作流节点变成 4，说明已经提交。
             	   	
             		String strSql="flowid='"+swfLogFlowID+"' and nodeType='claim' and nodestatus='2' and keyOut='"
     				             +claimDto.getPrpLclaimDto().getClaimNo()+"'";
             		ArrayList claimSwfLogList =(ArrayList)uiWorkFlowAction.findNodesByConditions( strSql);
             		if (claimSwfLogList !=null&&claimSwfLogList .size() >0){
             			((SwfLogDto)claimSwfLogList.get( 0)).setNodeStatus( "4");
             			 workFlowDto.setUpdateSwfLog2Dto((SwfLogDto)claimSwfLogList.get( 0));
             		}
                   	
                    //add by lixiang end at 2006-7-13
                   
        		}
              
        	}
        }
     	if (workFlowViewHelper.checkDealDto(workFlowDto))
        {    
			uiClaimAction.save(claimDto,workFlowDto);
			/************ 立案注销送审核平台start *****************/
			int vericLogNo = 0;
			if (workFlowDto.getSubmitSwfLogDtoList() != null
					&& workFlowDto.getSubmitSwfLogDtoList().size() > 0) {
				vericLogNo = ((SwfLogDto) workFlowDto
						.getSubmitSwfLogDtoList().get(0)).getLogNo();
			}
			
			UIWorkFlowApprovalInterFaceFacade uiWorkFlowApprovalInterFaceFacade = new UIWorkFlowApprovalInterFaceFacade();
			String UWflowID = uiWorkFlowApprovalInterFaceFacade
			                      .submitApprovalPlatform("ClaimCance", swfLogDtoDealNode.getFlowID(),String.valueOf(vericLogNo),
			                    		  strClaimNo, claimDto.getPrpLclaimDto().getRiskCode(), claimDto.getPrpLclaimDto().getClassCode(), 
			                    		  claimDto.getPrpLclaimDto().getComCode(), user.getUserCode(),
			                    		  claimDto.getPrpLclaimDto().getMakeCom(), user.getUserCode(), user.getUserCode(), "");
			
			if (UWflowID.length() < 15) {
				String msg = "案件'" + strClaimNo
						+ "'提交双核系统失败，请重新提交或者与管理员联系!";
				throw new UserException(1, 3, "工作流", msg);
			}
			/************ 立案注销送审核平台end ****************/
        }else
        {
        	uiClaimAction.save(claimDto);
        }

     	
     	
      strCaseType =claimDto.getPrpLclaimDto().getCaseType();
     if (editType.equals("ADD"))
      {
        message = new ActionMessage("prompt.claimCancel.cancelsuccess");
      }
      else
      {
        message = new ActionMessage("prompt.claimCancel.refusalsuccess");
      }


      messages.add( ActionMessages.GLOBAL_MESSAGE, message );
      saveMessages( httpServletRequest, messages );
      
	if (prpLcancelclaimPrintFlag!=null&&prpLcancelclaimPrintFlag.equals("1"))
	        httpServletResponse.sendRedirect("/claim/ClaimPrint.do?printType=Canceltrans&ClaimNo=" + strClaimNo);
      else
	       forward = "success";

	  
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.claimBeforeEdit.editClaim");
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
      ActionError error = new ActionError("title.claimBeforeEdit.editClaim");
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
      ActionError error = new ActionError("title.claimBeforeEdit.editClaim");
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
