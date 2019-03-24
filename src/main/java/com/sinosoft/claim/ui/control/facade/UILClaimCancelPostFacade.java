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

//���ù���������
//import com.sinosoft.function.workflow.client.SharkClient;

/**
 * �ַ�HTTP Post �������������������
 * <p>Title: ���������������������Ϣ</p>
 * <p>Description: ���������������������Ϣ����</p>
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

     

    String forward = ""; //��ǰ��ת

    try {
      //��viewHelper�����������
       String caseType=((String)httpServletRequest.getParameter("caseType"));
         
       DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
       UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();
       UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
       ClaimDto claimDto = dAAClaimViewHelper.cancelViewToDto(httpServletRequest);
       //����Ϊ������ʹ���е�
       String editType = httpServletRequest.getParameter("editType");
       String nodeType=httpServletRequest.getParameter("nodeType");
	   String strClaimNo=httpServletRequest.getParameter("prpLclaimClaimNo");
       String businessNo=httpServletRequest.getParameter("businessNo");
       String prpLcancelclaimPrintFlag=httpServletRequest.getParameter("prpLcancelclaimPrintFlag");
	   String status=httpServletRequest.getParameter("status");
       String strCaseType="";
       String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //����������
       String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //������logno
       ActionMessages messages = new ActionMessages();
       ActionMessage message;
       
       //Ӱ��ϵͳ���
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
     
       //��ֹ�ظ��ύ
       String strLastAccessedTime = String.valueOf(httpServletRequest.getSession().getLastAccessedTime()/ 1000);
       String oldLastAccessedTime = (String) httpServletRequest.getSession().getAttribute("oldCancelAccessedTime");
	   if (oldLastAccessedTime !=null && !oldLastAccessedTime.trim().equals("")) {
	    	   throw new UserException(1, 3, "������", "�벻Ҫ�ظ��ύ");
	   }
	   httpServletRequest.getSession().setAttribute("oldCancelAccessedTime", strLastAccessedTime);
	   //��ֹ����ˢ�����ύ�������ͬʱ�����ύͬһ������
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		String condition = "flowId ='"+swfLogFlowID+"' and  logno= "+ swfLogLogNo+"  and nodeStatus = '4'";
	    Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
	    if(certifyNodeList!=null&&certifyNodeList.size()>0){
	    	   throw new UserException(1,3,"������","�ð���ע��/����ڵ��Ѵ���");
	    }
       //Reason: ע��/��������˻ع���
       String strSubmitType = httpServletRequest.getParameter("submitType"); //�ύ����
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
//    	   throw new UserException(1,3,"����ע��","�����ϴ�һ��ע����Ƭ��");
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
				   throw new UserException(1, 3, "��֤��Ϣ", strWaning);
			   }
			}catch (Exception e){
			e.printStackTrace();
			throw e;
		}
		   
       }

       //������������ע����Ϣ
       //��uiCLaimAcction���Զ�ʶ���Ƿ�Ҫ��ô����ľ������
       //�������������,�����ADD�����ͣ�����ָ��Ҫ��ע��/��������룬�����ע�������ȷ����
       //ֱ�����ע�������ȷ��
       //-----------------------------------------------------
       // 1requst����,2���ڵ�Ľڵ�����,3���ڵ���Ҫ���µ�״̬,4���ڵ��ҵ�����,5�Ժ�ڵ��ҵ�����,6���ڵ��ҵ���������,7�Ժ�ڵ��ҵ����������
        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        SwfLogDto swfLogNextNode= new SwfLogDto();
        Collection nextNodeList = new ArrayList();
        UIClaimAction uiClaimAction = new UIClaimAction(); 
    	
        //����Ǽ�

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
          
          //������ת��ע��/���������ڵ�ȥ
          swfLogNextNode.setNodeNo(0);
         
          swfLogNextNode.setNodeType("cance");
          swfLogNextNode.setKeyIn(claimDto.getPrpLclaimDto().getClaimNo());
          swfLogNextNode.setPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());
          swfLogNextNode.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
          
          //�ж���ע�����Ǿ��⣬��Ҫ���ڹ������ϵ�
          swfLogNextNode.setTypeFlag( caseType);
          nextNodeList.add(swfLogNextNode);
          swfLogDtoDealNode.setNextNodeListType("1");//�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
          swfLogDtoDealNode.setSwfLogList(nextNodeList);
          //����ע��ԭ��
          UIPrpLregistRPolicyAction  uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction(); 
          PrpLRegistRPolicyDto  prpLRegistRPolicyDto = uiPrpLregistRPolicyAction.findByPrimaryKey(claimDto.getPrpLclaimDto().getRegistNo(),claimDto.getPrpLclaimDto().getPolicyNo());
          if (prpLRegistRPolicyDto!=null ){
          	prpLRegistRPolicyDto.setCancelReason(httpServletRequest.getParameter("CancelReason"));
          	prpLRegistRPolicyDto.setCancelReasonName(httpServletRequest.getParameter("CancelReasonName"));
          	claimDto.setPrpLRegistRPolicyDto(prpLRegistRPolicyDto);
          }
         }//ֱ�ӽ��ջ��˻�
        else
        {
          swfLogDtoDealNode.setNodeType("cance");
          swfLogDtoDealNode.setNodeStatus("2");
          swfLogDtoDealNode.setBusinessNo(claimDto.getPrpLclaimDto().getClaimNo() );
          swfLogDtoDealNode.setTypeFlag(caseType);
          
          
          //	�����㰸��
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
          //���ͨ����ʱ���д������ݵĵ�
          
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
            //��Ҫ�����Ƿ���Ҫ�������̵��ж������Ҫ�����򣬲Ž����������̡�
            
            /*
            String sqlstr="registNo='"+claimDto.getPrpLclaimDto().getRegistNo()+"' and claimNo<>'"
			+claimDto.getPrpLclaimDto().getClaimNo()+"' and  endcasedate is null  ";
            Collection claimList1 = uiClaimAction.findByConditions(sqlstr);
            if(claimList1==null||claimList1.size() ==0){
            	//�жϱ������Ƿ���û���������ݡ�����
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
        //���� ����������������clamno��keyin����ֵ�ġ���
        swfLogDtoDealNode.setKeyIn(claimDto.getPrpLclaimDto().getClaimNo() );
        swfLogDtoDealNode.setKeyOut(claimDto.getPrpLclaimDto().getClaimNo() );
        WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
        //------------------------------------------------------------
        //����������Ϣ�����ҹ�������

        if (editType.equals("ADD")){
        	//add by lixiang start at 2006-6-22
        	//reason:ע��/����󣬵�����û�б�ȫ��ע��/����ʱ�����Լ����������������̵������Ӱ�졣
        	//�����������ڵ���˵�ȥ��������ڵ�״̬
//        	if(!"compe".equals(nodeType)){
        		workFlowDto.setUpdate( false);
        		workFlowDto.setUpdateSwfLogDto( null);
//        	}
            //add by lixiang end at 2006-6-22
        	
          
        }else{
        	if (workFlowDto.getUpdateSwfLogDto()!=null){
        		workFlowDto.getUpdateSwfLogDto().setNodeStatus( "4");
        		//��������һ���ڵ�
        		if("compe".equals(nodeType)){
        			workFlowDto.setUpdateSwfLog2Dto(null);
        		}
        		else{
        			 //add by lixiang start at 2006-7-13
                    //reason:ע��/����ͨ���󣬽�������������������ڵ��� 4��˵���Ѿ��ύ��
             	   	
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
			/************ ����ע�������ƽ̨start *****************/
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
				String msg = "����'" + strClaimNo
						+ "'�ύ˫��ϵͳʧ�ܣ��������ύ���������Ա��ϵ!";
				throw new UserException(1, 3, "������", msg);
			}
			/************ ����ע�������ƽ̨end ****************/
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
      //������Ϣ����
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
      //������Ϣ����
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
      //������Ϣ����
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
