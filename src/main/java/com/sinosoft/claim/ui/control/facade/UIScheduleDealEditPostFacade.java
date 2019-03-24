package com.sinosoft.claim.ui.control.facade;

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


import com.sinosoft.assistant.services.PushCaseWsImpl;
import com.sinosoft.assistant.services.PushCaseWsImplServiceLocator;
import com.sinosoft.claim.SMSService.SMSDto;
import com.sinosoft.claim.SMSService.SendSMS;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLRegistFacade;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriScheduleViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAReturnVisitViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAScheduleViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.ui.model.SwfLogFindByPrimaryKeyCommand;
import com.sinosoft.claim.zdyApp.ZdyAppCaseDto;
import com.sinosoft.claim.zdyApp.ZdyAppCaseTransFacade;
import com.sinosoft.prpall.blsvr.cb.BLPrpCinsured;
import com.sinosoft.prpall.schema.PrpCinsuredSchema;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP GET ������Ƚڵ�ı�������
 * <p>Title: ������Ƚڵ�ı�������</p>
 * <p>Description: ������Ƚڵ�ı�������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */

public class UIScheduleDealEditPostFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {
    int nextNodeNo=0;
    String[] nextHandlerCode=httpServletRequest.getParameterValues("nextHandlerCode");      //ָ����һ���ڵ�����˴���
    String[] nextHandlerName=httpServletRequest.getParameterValues("nextHandlerName");      //ָ����һ���ڵ����������
    String[] strNextNode=httpServletRequest.getParameterValues("nextNodeNo");               //ָ����һ���ڵ���
    
    //�������ѡ��
    String[] selectSend=httpServletRequest.getParameterValues("prpLscheduleItemSelectSend");//ѡ����е���
    String[] prpLscheduleItemItemNo=httpServletRequest.getParameterValues("prpLscheduleItemItemNo");//���ȱ�׺�
    String[] prpLscheduleItemLicenseNo =httpServletRequest.getParameterValues("prpLscheduleItemLicenseNo");//���ƺ���
    String[] prpLscheduleInsureCarFlag =httpServletRequest.getParameterValues("prpLscheduleItemInsureCarFlag");//�Ƿ�Ϊ������Ͷ������
    String[] surveyTimes=httpServletRequest.getParameterValues("prpLscheduleItemSurveyTimes");//�Ƿ�Ϊ�Ѿ����ȹ��ģ�
    String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //����������
    String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //������logno
    String  msg="";
    String[] prpLscheduleItemScheduleObjectID     =httpServletRequest.getParameterValues("prpLscheduleItemScheduleObjectID");
    String  prpLscheduleMainWFScheduleID   = httpServletRequest.getParameter("prpLscheduleMainWFScheduleID");
    String  activeSchedule = "";//�鿱֪ͨ���Ƚ��ж������
    //�鿱���ȵ�ѡ��
    String  checkSelectSend=httpServletRequest.getParameter("checkSelectSend");
    String oldcheckFlag =httpServletRequest.getParameter("prpLscheduleMainWFScheduleFlag");
    String endflag =httpServletRequest.getParameter("endflag");
    boolean selectCheckNow=false;
    //��Ҫ���泵�ƺ��룬
    String forward="";
    
    //add by miaowenjun 20060928
    String riskCode = httpServletRequest.getParameter("prpLscheduleMainWFRiskCode");
    String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
    
    //�����������
    String strClauseType = httpServletRequest.getParameter("clauseType");
    
     try{         
     String registNo = httpServletRequest.getParameter("prpLscheduleMainWFRegistNo"); //������
     int scheduleID = -1; //���Ⱥ�
     UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
     UIScheduleAction uiScheduleAction = new UIScheduleAction();
     ActionMessages messages = new ActionMessages();
     
     //modify by ww add begin 2005-11-15
     //reason: ��ֹ�ظ��ύ
     String strLastAccessedTime = "" + httpServletRequest.getSession().getLastAccessedTime()/1000;
     String oldLastAccessedTime = (String)httpServletRequest.getSession().getAttribute("oldScheduleLastAccessedTime");
      //modify by ww add end 2005-11-15  
     //if(isTokenValid(httpServletRequest,true)){
     //System.out.println("oldScheduleLastAccessedTime:"+oldLastAccessedTime);
     if(oldLastAccessedTime.trim().equals("")){
         
         //modify by ww add begin 2005-11-15
         //reason: ��ֹ�ظ��ύ
        httpServletRequest.getSession().setAttribute ("oldScheduleLastAccessedTime",strLastAccessedTime);
         //modify by ww add end 2005-11-15
        
        //Modify by wangwei add start 2006-02-16
    	//Reason:�ѵ��Ȱ��������ڴ����Ϊ������
    	String buttonSaveType = httpServletRequest.getParameter("buttonSaveType");
    	if ("20".equals(buttonSaveType)) {
    		 //�����ݿ��в�ѯ���������Ĺ������ڵ�
    		SwfLogFindByPrimaryKeyCommand swfLogFindByPrimaryKeyCommand = new SwfLogFindByPrimaryKeyCommand(swfLogFlowID, Integer.parseInt(swfLogLogNo));
            SwfLogDto swfLogDto= (SwfLogDto) swfLogFindByPrimaryKeyCommand.execute();
            WorkFlowDto workFlowDto = new WorkFlowDto();
            UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
            swfLogDto.setNodeStatus("0");
 			swfLogDto.setHandlerCode("");
 			swfLogDto.setHandlerName("");
 			swfLogDto.setFlowStatus("1");
            workFlowDto.setUpdate (true);
            workFlowDto.setUpdateSwfLogDto(swfLogDto);
            uiWorkFlowAction.deal(workFlowDto);
            messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.schedule.back"));
            saveMessages( httpServletRequest, messages );
            return actionMapping.findForward("success"); 
    	}
        //Modify by wangwei add end 2006-02-16
        
       //�ж����������͵ı���
       String editType=httpServletRequest.getParameter("saveType");
     
       scheduleID=1;
     
       httpServletRequest.setAttribute("registNo", registNo);
       httpServletRequest.setAttribute("scheduleID",String.valueOf( scheduleID));	
       httpServletRequest.setAttribute("isSave", "1");
       //2.��viewHelper�����������
       //modify by miaowenjun 20060928 ũ�����Լ���viewhelper
       AgriScheduleViewHelper agriScheduleViewHelper = new AgriScheduleViewHelper();
       DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
       ScheduleDto scheduleDto = new ScheduleDto();
       //����⽡�գ�Ҳ��ũ�յ�viewhelper modified by xiatian 
       if("I".equals(riskType)||"H".equals(riskType)||"Q".equals(riskType)||"Z".equals(riskType)||"Y".equals(riskType)||"E".equals(riskType)){
    	   scheduleDto = agriScheduleViewHelper.viewToDto(httpServletRequest);
    	   //���ɻط���Ϣ begin
    	   DAAReturnVisitViewHelper daaReturnVisitViewHelper = new DAAReturnVisitViewHelper();
    	   PrplreturnvisitswflogDto prplreturnvisitswflogDto  = daaReturnVisitViewHelper.setReturnVisitSwflogDto(httpServletRequest, registNo, "sched", "0");
    	   scheduleDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
    	   //���ɻط���Ϣ end
       }else{
    	   scheduleDto = dAAScheduleViewHelper.viewToDto(httpServletRequest);
       }
       WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();

       //System.out.println("editType.========"+editType);
       //���ȸ���
       if (editType.equals("GETBACKEDIT"))
       {
    	//�ж����������͵ĸ��ɣ��Ƕ���ģ�����
       	String getbackNodeType= httpServletRequest.getParameter( "getbackNodeType");
       	//System.out .println(getbackNodeType);
       	String scheduleObjectID="";
       	if (!"check".equals( getbackNodeType)){ //�������
       		scheduleDto.setPrpLscheduleMainWFDto(null );
       		if (scheduleDto.getPrpLscheduleItemDtoList()!=null&&scheduleDto.getPrpLscheduleItemDtoList().size() >0 ){
       			scheduleDto.setPrpLscheduleItemDto((PrpLscheduleItemDto) scheduleDto.getPrpLscheduleItemDtoList().iterator() .next()   );
       			scheduleObjectID=scheduleDto.getPrpLscheduleItemDto().getScheduleObjectID() ;
       		}
       		httpServletRequest.setAttribute("nodeType1", editType);
       	}else
       	{ //�鿱���� 
       		scheduleObjectID=scheduleDto.getPrpLscheduleMainWFDto().getScheduleObjectID() ;
       		httpServletRequest.setAttribute("nodeType1", "sched");
       	}
       	//Ŀǰ����ֻ����ҵ�����ݣ����ǣ�������޸Ľڵ��ϵ��˵Ļ�������
         String newHandlerCode="";
         String scheduleType=     httpServletRequest.getParameter("scheduleType"            );
         WorkFlowDto workFlowDto = new WorkFlowDto();
         //��û�������˲���
         newHandlerCode= httpServletRequest.getParameter("newHandlerCode");   
        
         
         //System.out.println(newHandlerCode+"4543543");
         //if (newHandlerCode.length()>0 || ){
         	//�����û�����������ĺ���Ҳ���Խ��е��õ�
         System.out.println("�¸�������Ա����:"+newHandlerCode);
       workFlowDto =workFlowViewHelper.changeFlowNodeHandler(swfLogFlowID, swfLogLogNo,newHandlerCode,user.getUserName() +"�����˵��ȸ�����Ա"+newHandlerCode ,scheduleObjectID);
          //}
         
         //������������أ���
         
         
         if (workFlowViewHelper.checkDealDto(workFlowDto)){
         	//�����ɺ�������ɴ�����
         	if (workFlowDto.getUpdateSwfLogDto() !=null){
         		workFlowDto.getUpdateSwfLogDto().setNodeStatus( "0");
         	}
            uiScheduleAction.changeSave(scheduleDto,workFlowDto);
         }else{
           uiScheduleAction.changeSave(scheduleDto);
         }

       } 
       //��������
       else {
           //4.�����ǹ���������Ĺ���
           //-----------------------------------------------------
           // 1requst����,2���ڵ�Ľڵ�����,3���ڵ���Ҫ���µ�״̬,4���ڵ��ҵ�����,5�Ժ�ڵ��ҵ�����,6���ڵ��ҵ���������,7�Ժ�ڵ��ҵ����������
                   
           String scheduleType = httpServletRequest.getParameter("scheduleType"); //��������
           boolean finishSchedule=true;//�Ƿ���ɵ���
           SwfLogDto swfLogDtoDealNode = new SwfLogDto();
           
           swfLogDtoDealNode.setNodeStatus(scheduleDto.getPrpLclaimStatusDto().getStatus());
           swfLogDtoDealNode.setFlowID(swfLogFlowID);
           swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
           swfLogDtoDealNode.setNextBusinessNo(registNo);
           swfLogDtoDealNode.setKeyIn(registNo);
           swfLogDtoDealNode.setKeyOut(registNo);
           
           SwfLogDto swfLogDtoTemp = new UIWorkFlowAction().findNodeByPrimaryKey(swfLogDtoDealNode.getFlowID(),swfLogDtoDealNode.getLogNo());
           swfLogDtoDealNode.setNodeStatus(scheduleDto.getPrpLclaimStatusDto().getStatus());
           if("sched".equals(swfLogDtoTemp.getNodeType())){
        	   activeSchedule = swfLogDtoTemp.getTypeFlag();
           }
           //�������Ͳ�ͬ��������ͬ
           Collection nextNodeList = new ArrayList();
			if ("15".equals(activeSchedule)) {
			}// ���ٲ鿱��
			else {
				if ("0".equals(oldcheckFlag)
						&& "1".equals(checkSelectSend)) {
					// ѡ���˲鿱����
					SwfLogDto swfLogNextNode = new SwfLogDto();
					String nextHandlerCode1 = httpServletRequest
							.getParameter("nextHandlerCode1");
					String nextHandlerName1 = httpServletRequest
							.getParameter("nextHandlerName1");

					swfLogNextNode.setNodeNo(0);
					swfLogNextNode.setNodeType("check");
					swfLogNextNode.setHandlerCode(nextHandlerCode1);
					swfLogNextNode.setHandlerName(nextHandlerName1);
					swfLogNextNode.setNewHandleDept(scheduleDto
							.getPrpLscheduleMainWFDto()
							.getScheduleObjectID());
					nextNodeList.add(swfLogNextNode);

					selectCheckNow = true;// ��ʾ����ѡ���˲鿱����
				}
			}
			// ��Ϊ�˵��˵�ԭ��,������2��Ϊ��ֹһ���鿱������ô���������������ȣ�����ֱ�ӵ�����
          int maxRow = 0;
          //�⽡�ղ���Ҫ��Ӷ������ modified by xiatian 
          if(!"Q".equals(riskType)&&!"Y".equals(riskType)&&!"Z".equals(riskType)&&!"E".equals(riskType)){
        	  maxRow =Integer.parseInt((String)httpServletRequest.getParameter("maxrow")) ;
          }
            //������־λ
            String[] exigenceGree          =httpServletRequest.getParameterValues("exigenceGree"      );
            //���ȱ�Ĳ��ֿ�ʼ
            int itemNo=0;
            //�������ѡ���˲鿱���ȣ���ȫ�������������۶����Ƿ�ѡ���ˣ�����Ϊ���Ⱦ���û�����
            //endflag=1,��ʾ������
            if (selectCheckNow&& "0".equals(endflag)) finishSchedule=false;
            //���ûѡ�鿱���ȣ���û�����
            if ("0".equals(checkSelectSend ))  finishSchedule=false;
            //������ȣ��ڶ����Ƚ���������������Ⱥ󣬲����µ�check�����⡣��������
            
             for(int index=0;index<maxRow;index++) {
                 
               //ֻҪ����һ��û�е��ȵĶ����ģ�������Ϊ�������û�����	
               if (selectSend[index].equals("0")) {
                   finishSchedule=false;
               }
               
               if (selectSend[index].equals("1")&&surveyTimes[index].equals("0")) {
                  SwfLogDto swfLogNextNode = new SwfLogDto();
                  swfLogNextNode.setNodeNo(0);
                  swfLogNextNode.setNodeType(strNextNode[index]);//�ڽ�����jsָ���˸����������ͣ��綨������ʲô�ġ�
                  swfLogNextNode.setHandlerCode(nextHandlerCode[index]);
                  swfLogNextNode.setHandlerName(nextHandlerName[index]);
                  //������Ⱥ����itemitemNo�ĺ���
                  swfLogNextNode.setScheduleID(scheduleID) ;
                  swfLogNextNode.setLossItemCode(prpLscheduleItemItemNo[index]);
                  //modify by miaowenjun 20060928 ũ��û����Щ����
                  if(!"I".equals(riskType)&&!"H".equals(riskType)){
	                  //���泵�Ƶĺ���
	                  swfLogNextNode.setLossItemName(prpLscheduleItemLicenseNo[index]);
	                  //�����Ƿ񱣵������ı�־
	                  swfLogNextNode.setInsureCarFlag(prpLscheduleInsureCarFlag[index]) ;
                  }
                  //������־λ
                  swfLogNextNode.setExigenceGree(exigenceGree[index]);
                  swfLogNextNode.setNewHandleDept(prpLscheduleItemScheduleObjectID[index] );
                  
                  //Modify by wangwei add start 2006-01-14
                  //Reason: F22(�����������������α�������),��ĳ�û�ж����ڴ��Զ�������
                  if ("F22".equals(strClauseType) && "1".equals(prpLscheduleItemItemNo[index])) {
                     swfLogNextNode.setNodeStatus("6"); 
                  }
                  //Modify by wangwei add start 2006-01-14
                  
                  nextNodeList.add(swfLogNextNode);
               }
            }
             
           if (nextNodeList.size() >0){
           swfLogDtoDealNode.setNextNodeListType("1");//�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
           swfLogDtoDealNode.setSwfLogList(nextNodeList);
           }
           
           // �����̵����⴦��
           WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
           
           /*
           if (finishSchedule&&"1".equals(endflag)){
           	swfLogDtoDealNode.setNodeStatus("2");
           	WorkFlowDto workFlowDtoTemp = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
           	workFlowDto.setSubmit(workFlowDtoTemp.getSubmit());
           	workFlowDto.setSubmitSwfLogDtoList(workFlowDtoTemp.getSubmitSwfLogDtoList() );
        	workFlowDto.setSubmitSwfPathLogDtoList(workFlowDtoTemp.getSubmitSwfPathLogDtoList() );
           	
           }*/
          
         
             //3.���������Ϣ,û����ɵĻ�������״̬Ϊ2,δ��ɲ鿱�ģ�û�� �����ж����������ģ��������ڴ����״̬
             if (!finishSchedule&&workFlowDto.getUpdate()){
                workFlowDto.getUpdateSwfLogDto().setNodeStatus("2");
              }else{
                if (workFlowDto.getUpdate() ){ //���֮ǰ�Ƿ��в鿱�����һ�û�����Ľڵ�
                	//˫������,���ڲ鿱���ɳ��յ�����������,�б���(commiflag=2)�ύʱ�����жϲ鿱�Ƿ����� add by liyanjie 2005-12-20
                	if(!"2".equals(scheduleDto.getPrpLscheduleMainWFDto().getCommiFlag())){ //if �ж�add by liyanjie 2005-12-20 
                		msg=workFlowViewHelper.checkNodeSubmit(swfLogFlowID,swfLogLogNo);
                		
                		if (!msg.equals("") ) workFlowDto.getUpdateSwfLogDto().setNodeStatus("2");
                	}
              }
          
          }

            if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate()) ||(workFlowDto.getSubmit())||(workFlowDto.getClose()))
            {
            	 if ("1".equals(endflag)&&workFlowDto.getUpdateSwfLogDto() !=null){
            	 	//System.out .println("43543543543"+workFlowDto.getUpdateSwfLogDto().getNodeStatus()) ;
            	 	if (workFlowDto.getUpdateSwfLogDto().getNodeStatus().equals( "4")){
                   	workFlowDto.setClose(true);
                   }else{
                   	workFlowDto.setClose(false);
                   }
            	 }  
               uiScheduleAction.save(scheduleDto,workFlowDto);
               //פ��ԱApp��������
               BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
          	   PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
          	   String result = null;
               String caseReportCd =  prpLregistDto.getRegistNo();
               String insuredName = prpLregistDto.getInsuredName();
               String damageStartDate = prpLregistDto.getDamageStartDate()+"";
               String damageAddress = prpLregistDto.getDamageAddress();
               String surveyUserCd = httpServletRequest
          		.getParameter("nextHandlerCode1");
               String riskCode1 = prpLregistDto.getRiskCode();
               String pushContent = "�𾴵Ŀͻ������ı���������" 
          			              + "�������ţ�"+caseReportCd;
               if("31".equals(riskCode1.substring(0, 2)) || "32".equals(riskCode1.substring(0, 2))){
            	   String data = "<PUSHCASE>" + "<CASE_REPORT_CD>"
									+ caseReportCd + "</CASE_REPORT_CD>"
									+ "<RISK_CODE>" + riskCode1
									+ "</RISK_CODE>" + "<INSURED_NAME>"
									+ insuredName + "</INSURED_NAME>"
									+ "<DAMAGE_START_DATE>" + damageStartDate
									+ "</DAMAGE_START_DATE>"
									+ "<DAMAGE_ADDRESS>" + damageAddress
									+ "</DAMAGE_ADDRESS>" + "<SURVEY_USER_CD>"
									+ surveyUserCd + "</SURVEY_USER_CD>"
									+ "<PUSH_CONTENT>" + pushContent
									+ "</PUSH_CONTENT>" + "</PUSHCASE>";
							System.err.print(data);
							try{
								PushCaseWsImplServiceLocator service = new PushCaseWsImplServiceLocator();
								PushCaseWsImpl impl = service
										.getacceptPushCaseService();
								result = impl.accept(data);
								System.err.print("result==" + result);
								String transFlag = null;// �������ͱ�־��פ��ԱApp��
								if ("SUCCESS".equals(result)) {
									transFlag = "1";
								} else {
									transFlag = "0";
								}
								DateTime transDate = new DateTime(DateTime
										.current().toString(),
										DateTime.YEAR_TO_SECOND);// ��������ʱ�䣨פ��ԱApp��
								ZdyAppCaseDto zdyAppCaseDto = new ZdyAppCaseDto();
								zdyAppCaseDto.setRegistNo(caseReportCd);
								zdyAppCaseDto.setData(data);
								zdyAppCaseDto.setTransFlag(transFlag);
								zdyAppCaseDto.setTransDate(transDate);
								ZdyAppCaseTransFacade zdyAppCaseTransFacade = new ZdyAppCaseTransFacade();
								try {
									zdyAppCaseTransFacade.insert(zdyAppCaseDto);
								} catch (Exception zdyexception) {
									System.out.println("פ��Ա������Ϣ�������ݴ洢�쳣");
									zdyexception.printStackTrace();
								}
								if ("SUCCESS".equals(result)) {
									result = "������Ϣ����פ��ԱApp�ӿڳɹ�!";
								} else {
									//result = "������Ϣ����ʧ��!";  
								} 
							}catch(Exception ZDYAppception){
								result = "������Ϣ����פ��ԱApp�ӿ�ʧ��!";
								System.out.println("������Ϣ����פ��ԱApp�ӿ�ʧ��!");
								ZDYAppception.printStackTrace();
							}
							System.err.print(result);
							user.setUserMessage("������:" + registNo + " " + msg+ result);	
               }else{
            	   user.setUserMessage("������:"+registNo+" "+msg);
               }
            }else
            {
                 uiScheduleAction.save(scheduleDto,workFlowDto);
                 user.setUserMessage("������:"+registNo+";ע��:û�з����빤������������κ����ݣ���");
            }
            httpServletRequest.setAttribute("nodeType1", "sched");
        }
         messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.schedule.submit"));
     } else {//�ظ��ύ
     	 messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.again.value"));
      }
      saveMessages( httpServletRequest, messages );
      forward="success";
    }

    catch(UserException usee)
    {
      usee.printStackTrace();
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.claimBeforeEdit.queryClaimList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }

    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.claimBeforeEdit.queryClaimList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    finally
    {

    }

    return actionMapping.findForward(forward);
  }

}
