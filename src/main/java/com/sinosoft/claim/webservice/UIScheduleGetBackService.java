package com.sinosoft.claim.webservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.bl.facade.BLPrpLscheduleMainWFFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.action.UserToPrpDuser;
import com.sinosoft.claim.ui.control.viewHelper.AgriScheduleViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAReturnVisitViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAScheduleViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.ui.model.SwfLogFindByPrimaryKeyCommand;
import com.sinosoft.claim.util.CallCenterInterfaceLogger;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.platform.ui.control.action.UIPowerAction;
import com.sinosoft.sysframework.common.Constants;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * ����ϵͳ���ɽӿ�
 */
public class UIScheduleGetBackService {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	/**
	 * ����ϵͳ�����б��ѯ
	 * @param scheduleGetBackQueryReqInfo
	 * @return
	 */
	public ScheduleGetBackQueryMainDtoInfo getScheduleGetBackQuery (ScheduleGetBackQueryReqInfo scheduleGetBackQueryReqInfo){
		long serial = System.currentTimeMillis();
		logger.log("����ϵͳ���ɽӿ�",1,serial,scheduleGetBackQueryReqInfo);
		ScheduleGetBackQueryMainDtoInfo scheduleGetBackQueryMainDtoInfo = null;
		try {
			UIScheduleGetBackCheckAndTrans checkAndTrans = new UIScheduleGetBackCheckAndTrans();
			checkAndTrans.getScheduleGetBackQueryCheck(scheduleGetBackQueryReqInfo);
			String registNo = scheduleGetBackQueryReqInfo.getRegistNo();
			String licenseNo = scheduleGetBackQueryReqInfo.getLicenseNo();
			String handlerCode = scheduleGetBackQueryReqInfo.getHandlerCode();
			String NhandlerCode = scheduleGetBackQueryReqInfo.getNhandlerCode();
			String startDate = scheduleGetBackQueryReqInfo.getStartDate();
			String endDate = scheduleGetBackQueryReqInfo.getEndDate();
			String nodeType = scheduleGetBackQueryReqInfo.getNodeType();
			int pageNo = scheduleGetBackQueryReqInfo.getPageNo();
			int recordPerPage =20;
			if(scheduleGetBackQueryReqInfo.getRecordPerPage()!=0){
				recordPerPage = scheduleGetBackQueryReqInfo.getRecordPerPage();
			}


	          //˵��:�ܹ�ȡ�ص���������ǻ�û�б��鿱������ĵ�������
	          //��ʱ����Ҫ��ѯ���������Ժ��ڼ��뻻�˵Ĳ��������Ǵӹ�������ȡ�ð�
	        	   //�����ǳ��ղ��е��ȣ����Ա����ж��ǳ��յ����֡�
	        String  conditions = " (nodeType='"+nodeType+"' and nodestatus<'4' and dataflag is null) ";
	        conditions= conditions + StringConvert.convertString("registNo",registNo,"=");
	        conditions= conditions + StringConvert.convertString("BeforeHandlerCode",handlerCode ,"=");
	        conditions= conditions + StringConvert.convertString("handlerCode",NhandlerCode,"=");
	        conditions= conditions + StringConvert.convertString("lossItemCode",licenseNo,"=");
	        if (startDate!=null &&startDate.trim().length()>0 )
	        {
	           conditions =conditions+ " and (flowintime>='"+startDate+"') ";
	        }
	        if ( endDate!=null&&endDate.trim().length()>0 )
	        {
	           conditions =conditions+ "  and (flowintime<='"+new DateTime(endDate,DateTime.YEAR_TO_DAY ).addDay(1).toString()  +"') ";
	        }
	        UIPowerInterface uiPowerInterface = new UIPowerInterface();
	        UserDto userDto = new UserDto(); 
	        userDto.setComCode(scheduleGetBackQueryReqInfo.getComCode());
	       userDto.setUserCode(scheduleGetBackQueryReqInfo.getUserCode());
	        UICodeAction uiCodeAction = new UICodeAction();
	        String strRiskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");          
	        //conditions = conditions+uiPowerInterface.addPower(userDto.getUserCode(),"lpdd","swflog",strRiskCode);
	        conditions = conditions + uiPowerInterface.addPower(userDto,"swflog","","ComCode");
	        conditions = conditions +  " and registno not in (select registno from prplcombine)" ;//���еİ������ܸĵ���
	        conditions=conditions+  " order by flowintime desc";
	        UIWorkFlowAction uiWorkFlowAction= new UIWorkFlowAction();
	        //System.out.println("zhouTest:"+conditions);
	        PageRecord pageRecord = (PageRecord)uiWorkFlowAction.findNodesByConditions(conditions,pageNo,recordPerPage) ;
	        scheduleGetBackQueryMainDtoInfo =  checkAndTrans.getScheduleGetBackQueryTrans(pageRecord);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("����ϵͳ���ɽӿ�",serial,e);
		}
		logger.log("����ϵͳ���ɽӿ�",0,serial,scheduleGetBackQueryMainDtoInfo);
		return scheduleGetBackQueryMainDtoInfo;
		
	}
	/**
	 * ����ϵͳ������ϸ��ʷ��Ϣ
	 * @param scheduleGetBackDetailReqInfo
	 * @return
	 */
	public ScheduleGetBackDetailDtoInfo getScheduleGetBackDetail (ScheduleGetBackDetailReqInfo scheduleGetBackDetailReqInfo){
		long serial = System.currentTimeMillis();
		logger.log("����ϵͳ������ϸ��ʷ��Ϣ",1,serial,scheduleGetBackDetailReqInfo);
		ScheduleGetBackDetailDtoInfo scheduleGetBackDetailDtoInfo = null;
		try {
			UIScheduleGetBackCheckAndTrans checkAndTrans = new UIScheduleGetBackCheckAndTrans();
			checkAndTrans.getScheduleGetBackDetailCheck(scheduleGetBackDetailReqInfo);
		    UserDto   user     = new UserDto();
		    user.setUserCode(scheduleGetBackDetailReqInfo.getUserCode());
		    user.setComCode(scheduleGetBackDetailReqInfo.getComCode());
		    
		    String  registNo = scheduleGetBackDetailReqInfo.getRegistNo();
		    UIPowerAction.checkPower(UserToPrpDuser.convert(user),Constants.TASK_CLAIM_SCHEDULE_QUERY);
		    int intscheduleID= 1;
		      UIScheduleAction uiScheduleAction = new UIScheduleAction();
		      ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(intscheduleID,registNo);
		      
		      
		      PrpLscheduleMainWFDto prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto() ;
		      UIRegistAction uiRegistAction = new UIRegistAction();
		      RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		      String policyNo = registDto.getPrpLregistDto().getPolicyNo();
		      //��ѯ������Ϣ
		      UIPolicyAction uiPolicyAction = new UIPolicyAction();
		      PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(policyNo);
		      UICodeAction uiCodeAction = new UICodeAction();
		      
		      //����鲻����ô�죿 д����Ҫע���
		      String agentCode="";
		      
		      if (policyDto.getPrpCmainDto()!=null){
		         agentCode = policyDto.getPrpCmainDto().getAgentCode();         //�����˴���
		      }

		      if (agentCode==null) agentCode="";
		      //��������Ϣ
		      prpLscheduleMainWFDto.setAgentCode(agentCode);
		      prpLscheduleMainWFDto.setAgentName(uiCodeAction.translateAgentName(agentCode));
		      
		      PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
		      prpLregistDto.setReportHour(StringConvert.toStandardTime(prpLregistDto.getReportHour()));
		      prpLregistDto.setReportMinute(prpLregistDto.getReportHour().substring(3,5));
		      prpLregistDto.setReportHour(prpLregistDto.getReportHour().substring(0,2));
		      prpLregistDto.setDamageStartHour(StringConvert.toStandardTime(prpLregistDto.getDamageStartHour()));
		      prpLregistDto.setDamageStartMinute(prpLregistDto.getDamageStartHour().substring(3,5));
		      prpLregistDto.setDamageStartHour(prpLregistDto.getDamageStartHour().substring(0,2));
		     
		      prpLscheduleMainWFDto.setLinkerName(registDto.getPrpLregistDto().getLinkerName()  ) ;
		      prpLscheduleMainWFDto.setPhoneNumber(registDto.getPrpLregistDto().getPhoneNumber()  ) ;
		      if(user != null){
		    	  prpLscheduleMainWFDto.setOperatorName(user.getUserName() );
		      }
		      prpLscheduleMainWFDto.setLicenseNo(registDto.getPrpLregistDto() .getLicenseNo() );
		      prpLscheduleMainWFDto.setEstimateLoss( registDto.getPrpLregistDto() .getEstimateLoss() );
		      
		      if ("_".equals(prpLscheduleMainWFDto.getScheduleObjectID())){
		      	prpLscheduleMainWFDto.setScheduleObjectID("");
		      }
		      
		       //�������ļ������б�׼������
		      PrpLregistTextDto prpLregistTextDto  = new PrpLregistTextDto();
		      if(registDto.getPrpLregistTextDtoList() != null){
		        Iterator iterator = registDto.getPrpLregistTextDtoList().iterator();
		        while(iterator.hasNext()){
		          PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto)iterator.next();
		          if(StringUtils.rightTrim(prpLregistTextDtoTemp.getTextType()).equals("1"))
		          {
		    				prpLscheduleMainWFDto.setRegistText(prpLscheduleMainWFDto.getRegistText()+prpLregistTextDtoTemp.getContext() );
		    		}
		        }
		      } 
		    
	
		      scheduleGetBackDetailDtoInfo =checkAndTrans.getScheduleGetBackQueryTrans(prpLscheduleMainWFDto);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("����ϵͳ������ϸ��ʷ��Ϣ",serial,e);
		}
		logger.log("����ϵͳ������ϸ��ʷ��Ϣ",0,serial,scheduleGetBackDetailDtoInfo);
		return scheduleGetBackDetailDtoInfo;
		
	}
	/**
	 * ����ϵͳ����
	 * @param scheduleGetBackReqInfo
	 * @return
	 */
	public String saveScheduleGetBack(ScheduleGetBackReqInfo scheduleGetBackReqInfo){
		long serial = System.currentTimeMillis();
		logger.log("����ϵͳ����",1,serial,scheduleGetBackReqInfo);
		String  msg="";
		try {

			UIScheduleGetBackCheckAndTrans checkAndTrans = new UIScheduleGetBackCheckAndTrans();
			checkAndTrans.saveScheduleGetBackCheck(scheduleGetBackReqInfo);
			int nextNodeNo=0;
			String registNo = scheduleGetBackReqInfo.getRegistNo();
			msg = "�����ţ�"+registNo+" ";
			String riskCode = scheduleGetBackReqInfo.getRiskCode();
			String scheduleObjectID = scheduleGetBackReqInfo.getScheduleObjectID();
			String ScheduleObjectName = scheduleGetBackReqInfo.getScheduleObjectName();
			String checkSite = scheduleGetBackReqInfo.getCheckSite();
			String checkInfo = scheduleGetBackReqInfo.getCheckInfo();
			String nextHandlerCode = scheduleGetBackReqInfo.getNextHandlerCode();
			String nextHandlerName = scheduleGetBackReqInfo.getNextHandlerName();
			String flag = scheduleGetBackReqInfo.getFlag();
			String flowId = scheduleGetBackReqInfo.getFlowId();
			String logNo = scheduleGetBackReqInfo.getLogNo();
			String operatorCode = scheduleGetBackReqInfo.getOperatorCode();
			String inputDate = scheduleGetBackReqInfo.getInputDate();
			String inputHour = scheduleGetBackReqInfo.getInputHour();
		    UserDto   user     = new UserDto();
		    user.setUserCode(operatorCode);
		    user.setUserName(new UICodeAction().translateUserCode(user.getUserCode(), true));
		    
		    UIScheduleAction uiScheduleAction = new UIScheduleAction();
		     
		    int  scheduleID =1 ;
		    ScheduleDto scheduleDto = new ScheduleDto();
		    WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
		    BLPrpLscheduleMainWFFacade blPrpLscheduleMainWFFacade = new BLPrpLscheduleMainWFFacade();
		    PrpLscheduleMainWFDto prpLscheduleMainWFDto = blPrpLscheduleMainWFFacade.findByPrimaryKey(scheduleID, registNo);
		    if(prpLscheduleMainWFDto ==null){
		    	return msg+"������Ϣ�����ύʧ��";
		    }
		    
		    prpLscheduleMainWFDto.setRiskCode(riskCode);
		    prpLscheduleMainWFDto.setScheduleObjectID(scheduleObjectID);
		    prpLscheduleMainWFDto.setScheduleObjectName(ScheduleObjectName);
		    prpLscheduleMainWFDto.setCheckSite(checkSite);
		    prpLscheduleMainWFDto.setCheckInfo(checkInfo);
		    prpLscheduleMainWFDto.setNextHandlerCode(nextHandlerCode);
		    prpLscheduleMainWFDto.setNextHandlerName(nextHandlerName);
		    prpLscheduleMainWFDto.setFlag(flag);
		    prpLscheduleMainWFDto.setOperatorCode(user.getUserCode());
		    prpLscheduleMainWFDto.setOperatorName(user.getUserName());
		    prpLscheduleMainWFDto.setInputDate(new DateTime(inputDate,DateTime.YEAR_TO_DAY));
		    String[] str = inputHour.split(":");
		    prpLscheduleMainWFDto.setInputHour(Integer.parseInt(str[0]));
		    prpLscheduleMainWFDto.setInputMinute(Integer.parseInt(str[1]));
		    
		    scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
		    
		    WorkFlowDto workFlowDto = new WorkFlowDto();
		    System.out.println("�¸�������Ա����:"+nextHandlerCode);
		    workFlowDto =workFlowViewHelper.changeFlowNodeHandler(flowId, logNo,nextHandlerCode,user.getUserName() +"�����˵��ȸ�����Ա"+nextHandlerCode ,scheduleObjectID); 
		    if (workFlowViewHelper.checkDealDto(workFlowDto)){
		      if (workFlowDto.getUpdateSwfLogDto() !=null){
		         workFlowDto.getUpdateSwfLogDto().setNodeStatus( "0");
		       }
		         uiScheduleAction.changeSave(scheduleDto,workFlowDto);
		     }else{
		         uiScheduleAction.changeSave(scheduleDto);
		    }
		msg = msg+"������Ϣ�����ύ�ɹ�";	
		} catch (Exception e) {
			e.printStackTrace();
			msg = msg+"������Ϣ�����ύʧ��";
			logger.log("����ϵͳ����",serial,e);
		}
		logger.log("����ϵͳ����",0,serial,msg);
		return msg;
		
	}
}
