package com.sinosoft.claim.webservice;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.reins.utility.ui.control.facade.UICodeFacade;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;

public class UIScheduleGetBackCheckAndTrans {
	/**
	 * ����ϵͳ�����б��ѯ ����У��
	 * @param scheduleGetBackQueryReqInfo
	 * @throws Exception 
	 */
	public void getScheduleGetBackQueryCheck(
			ScheduleGetBackQueryReqInfo scheduleGetBackQueryReqInfo) throws Exception {
		if(isEmpty(scheduleGetBackQueryReqInfo.getNodeType())){throw new Exception("����ȥ�������Ǳش����������飡");}
		if(!"check".equals(scheduleGetBackQueryReqInfo.getNodeType())){throw new Exception("����ȥ�����ʹ����������飡");}
		if(scheduleGetBackQueryReqInfo.getPageNo()<=0){throw new Exception("ҳ���������飡");}
		if(scheduleGetBackQueryReqInfo.getRecordPerPage()<0){
			throw new Exception("ÿҳ��¼���������飡");
		}
		if(isEmpty(scheduleGetBackQueryReqInfo.getComCode())){throw new Exception("���������Ǳش����������飡");}
		if(isEmpty(scheduleGetBackQueryReqInfo.getUserCode())){throw new Exception("Ա�������Ǳش����������飡");}
	}
	private boolean isEmpty(String str){
		if(str==null||str.trim().length()==0){
			return true;
		}else{
			return false;
		}
	}
	public ScheduleGetBackQueryMainDtoInfo getScheduleGetBackQueryTrans(
			PageRecord pageRecord) {
		ScheduleGetBackQueryMainDtoInfo scheduleGetBackQueryMainDtoInfo = new ScheduleGetBackQueryMainDtoInfo();
		ArrayList swfLogList=(ArrayList)pageRecord.getResult();
		ScheduleGetBackQueryDetailDtoInfo[] scheduleGetBackQueryDetailDtoInfoList = new ScheduleGetBackQueryDetailDtoInfo[swfLogList.size()];
        for(int i =0;i<swfLogList.size();i++){
        	SwfLogDto swfLogDto = (SwfLogDto) swfLogList.get(i);
        	ScheduleGetBackQueryDetailDtoInfo scheduleGetBackQueryDetailDtoInfo = new ScheduleGetBackQueryDetailDtoInfo();
        	scheduleGetBackQueryDetailDtoInfo.setRegistNo(swfLogDto.getRegistNo());
        	scheduleGetBackQueryDetailDtoInfo.setFlowInTime(swfLogDto.getFlowInTime());
        	//�ӿ��ĵ�д���������Բ��������Զ�Ӧ�ķ��Ŵ���
        	scheduleGetBackQueryDetailDtoInfo.setHandlerCode(swfLogDto.getBeforeHandlerCode());
        	scheduleGetBackQueryDetailDtoInfo.setHandlerName(swfLogDto.getBeforeHandlerName());
        	scheduleGetBackQueryDetailDtoInfo.setBeforeHandlerCode(swfLogDto.getHandlerCode());
        	scheduleGetBackQueryDetailDtoInfo.setBeforeHandlerName(swfLogDto.getHandlerName());
        	scheduleGetBackQueryDetailDtoInfo.setLossItemCode(swfLogDto.getLossItemCode());
        	scheduleGetBackQueryDetailDtoInfo.setLossItemName(swfLogDto.getLossItemName());
        	scheduleGetBackQueryDetailDtoInfo.setFlowId(swfLogDto.getFlowID());
        	scheduleGetBackQueryDetailDtoInfo.setLogNo(String.valueOf(swfLogDto.getLogNo()));
        	scheduleGetBackQueryDetailDtoInfoList[i] = scheduleGetBackQueryDetailDtoInfo;
        }
        scheduleGetBackQueryMainDtoInfo.setScheduleGetBackQueryDetailDtoInfoList(scheduleGetBackQueryDetailDtoInfoList);
         //��ǰҳ��
        scheduleGetBackQueryMainDtoInfo.setPageNo(pageRecord.getPageNo());
         //һҳ������
        scheduleGetBackQueryMainDtoInfo.setRecordPerPage(pageRecord.getRowsPerPage());
         //��ѯ�����Ľ��������
        scheduleGetBackQueryMainDtoInfo.setTotalCount(pageRecord.getCount());
         //�����ܵ�ҳ��
        scheduleGetBackQueryMainDtoInfo.setTotalPage(pageRecord.getTotalPageCount());
		return scheduleGetBackQueryMainDtoInfo;
	}
	/**
	 * ����ϵͳ������ϸ��ʷ��Ϣ ����У��
	 * @param scheduleGetBackDetailReqInfo
	 * @throws Exception 
	 */
	public void getScheduleGetBackDetailCheck(
			ScheduleGetBackDetailReqInfo scheduleGetBackDetailReqInfo) throws Exception {
		if(isEmpty(scheduleGetBackDetailReqInfo.getRegistNo())){throw new Exception("�����ǼǺ��Ǳش����������飡");}
		if(isEmpty(scheduleGetBackDetailReqInfo.getUserCode())){throw new Exception("�û������Ǳش����������飡");}
		if(isEmpty(scheduleGetBackDetailReqInfo.getComCode())){throw new Exception("���������Ǳش����������飡");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getFlowInTime())){throw new Exception("����ʱ���Ǳش����������飡");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getHandlerCode())){throw new Exception("���Ȳ���Ա�����Ǳش����������飡");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getHandlerName())){throw new Exception("���Ȳ���Ա�����Ǳش����������飡");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getBeforeHandlerCode())){throw new Exception("�鿱/������Ա�����Ǳش����������飡");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getBeforeHandlerName())){throw new Exception("�鿱/������Ա�����Ǳش����������飡");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getLossItemCode())){throw new Exception("���ȶ�������Ǳش����������飡");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getLossItemName())){throw new Exception("���ȶ��������Ǳش����������飡");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getFlowId())){throw new Exception("�ڵ�ID�Ǳش����������飡");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getLogNo())){throw new Exception("�ڵ�����Ǳش����������飡");}
		
	}
	public ScheduleGetBackDetailDtoInfo getScheduleGetBackQueryTrans(
			PrpLscheduleMainWFDto prpLscheduleMainWFDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		ScheduleGetBackDetailDtoInfo scheduleGetBackDetailDtoInfo= new ScheduleGetBackDetailDtoInfo();
		scheduleGetBackDetailDtoInfo.setRegistNo(prpLscheduleMainWFDto.getRegistNo());
		scheduleGetBackDetailDtoInfo.setPolicyNo(prpLscheduleMainWFDto.getPolicyNo());
		scheduleGetBackDetailDtoInfo.setLinkerName(prpLscheduleMainWFDto.getLinkerName());
		scheduleGetBackDetailDtoInfo.setPhoneNumber(prpLscheduleMainWFDto.getPhoneNumber());
		scheduleGetBackDetailDtoInfo.setAgentCode(prpLscheduleMainWFDto.getAgentCode());
		scheduleGetBackDetailDtoInfo.setAgentName(prpLscheduleMainWFDto.getAgentName());
		scheduleGetBackDetailDtoInfo.setComCode(prpLscheduleMainWFDto.getClaimComCode());
		scheduleGetBackDetailDtoInfo.setComName(uiCodeAction.translateComCode(prpLscheduleMainWFDto.getClaimComCode(), true));
		scheduleGetBackDetailDtoInfo.setOperatorCode(prpLscheduleMainWFDto.getOperatorCode());
		scheduleGetBackDetailDtoInfo.setOperatorName(uiCodeAction.translateUserCode(prpLscheduleMainWFDto.getOperatorCode(), true));
		scheduleGetBackDetailDtoInfo.setEstimateLoss(""+prpLscheduleMainWFDto.getEstimateLoss());
		scheduleGetBackDetailDtoInfo.setInputDate(prpLscheduleMainWFDto.getInputDate().toString());
		scheduleGetBackDetailDtoInfo.setInputHour(prpLscheduleMainWFDto.getInputHour()+":"+
				prpLscheduleMainWFDto.getInputMinute());
		scheduleGetBackDetailDtoInfo.setSurveyNo(""+prpLscheduleMainWFDto.getSurveyNo());
		scheduleGetBackDetailDtoInfo.setRegistText(prpLscheduleMainWFDto.getRegistText());
		
		
		scheduleGetBackDetailDtoInfo.setScheduleObjectID(prpLscheduleMainWFDto.getScheduleObjectID());
		scheduleGetBackDetailDtoInfo.setScheduleObjectName(prpLscheduleMainWFDto.getScheduleObjectName());
		scheduleGetBackDetailDtoInfo.setCheckSite(prpLscheduleMainWFDto.getCheckSite());
		scheduleGetBackDetailDtoInfo.setCheckInfo(prpLscheduleMainWFDto.getCheckInfo());
		scheduleGetBackDetailDtoInfo.setNextHandlerCode(prpLscheduleMainWFDto.getNextHandlerCode());
		scheduleGetBackDetailDtoInfo.setNextHandlerName(prpLscheduleMainWFDto.getNextHandlerName());
		scheduleGetBackDetailDtoInfo.setFlag(prpLscheduleMainWFDto.getFlag());
		scheduleGetBackDetailDtoInfo.setCheckYesNo(prpLscheduleMainWFDto.getScheduleFlag());
		
		
		return scheduleGetBackDetailDtoInfo;
	}
	/**
	 * ����ϵͳ��������У��
	 * @param scheduleGetBackReqInfo
	 * @throws Exception 
	 */
	public void saveScheduleGetBackCheck(
			ScheduleGetBackReqInfo scheduleGetBackReqInfo) throws Exception {
	if(isEmpty(scheduleGetBackReqInfo.getRegistNo())){throw new Exception("�������Ǳش����������飡");}
	if(isEmpty(scheduleGetBackReqInfo.getRiskCode())){throw new Exception("���ִ����Ǳش����������飡");}
	if(isEmpty(scheduleGetBackReqInfo.getScheduleObjectID())){throw new Exception("�鿱����λ�����Ǳش����������飡");}
	if(isEmpty(scheduleGetBackReqInfo.getScheduleObjectName())){throw new Exception("�鿱����λ�����Ǳش����������飡");}
	if(isEmpty(scheduleGetBackReqInfo.getCheckSite())){throw new Exception("�鿱��ַ�Ǳش����������飡");}
	if(isEmpty(scheduleGetBackReqInfo.getNextHandlerCode())){throw new Exception("�鿱��Ա�����Ǳش����������飡");}
	if(isEmpty(scheduleGetBackReqInfo.getNextHandlerName())){throw new Exception("�鿱��Ա�����Ǳش����������飡");}
	if(isEmpty(scheduleGetBackReqInfo.getFlowId())){throw new Exception("�ڵ�ID�Ǳش����������飡");}
	if(isEmpty(scheduleGetBackReqInfo.getLogNo())){throw new Exception("�ڵ�����Ǳش����������飡");}
	if(isEmpty(scheduleGetBackReqInfo.getOperatorCode())){throw new Exception("������Ա�����Ǳش����������飡");}
	if(isEmpty(scheduleGetBackReqInfo.getInputDate())){throw new Exception("���������Ǳش����������飡");}
	if(isEmpty(scheduleGetBackReqInfo.getInputHour())){throw new Exception("����ʱ���Ǳش����������飡");}
	}
	public ScheduleDto agriViewToDto(
			ScheduleGetBackReqInfo scheduleGetBackReqInfo) throws SQLException, UserException, Exception {
		ScheduleDto scheduleDto = new ScheduleDto();
		//TODO 
		
		
		
		return scheduleDto;
	}
}
