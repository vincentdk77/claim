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
	 * 理赔系统改派列表查询 数据校验
	 * @param scheduleGetBackQueryReqInfo
	 * @throws Exception 
	 */
	public void getScheduleGetBackQueryCheck(
			ScheduleGetBackQueryReqInfo scheduleGetBackQueryReqInfo) throws Exception {
		if(isEmpty(scheduleGetBackQueryReqInfo.getNodeType())){throw new Exception("调度去向类型是必传参数，请检查！");}
		if(!"check".equals(scheduleGetBackQueryReqInfo.getNodeType())){throw new Exception("调度去向类型传入有误，请检查！");}
		if(scheduleGetBackQueryReqInfo.getPageNo()<=0){throw new Exception("页数有误，请检查！");}
		if(scheduleGetBackQueryReqInfo.getRecordPerPage()<0){
			throw new Exception("每页记录数有误，请检查！");
		}
		if(isEmpty(scheduleGetBackQueryReqInfo.getComCode())){throw new Exception("机构代码是必传参数，请检查！");}
		if(isEmpty(scheduleGetBackQueryReqInfo.getUserCode())){throw new Exception("员工代码是必传参数，请检查！");}
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
        	//接口文档写反了这两对参数，所以对应的反着传数
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
         //当前页号
        scheduleGetBackQueryMainDtoInfo.setPageNo(pageRecord.getPageNo());
         //一页的条数
        scheduleGetBackQueryMainDtoInfo.setRecordPerPage(pageRecord.getRowsPerPage());
         //查询出来的结果的总数
        scheduleGetBackQueryMainDtoInfo.setTotalCount(pageRecord.getCount());
         //返回总的页数
        scheduleGetBackQueryMainDtoInfo.setTotalPage(pageRecord.getTotalPageCount());
		return scheduleGetBackQueryMainDtoInfo;
	}
	/**
	 * 理赔系统改派详细历史信息 数据校验
	 * @param scheduleGetBackDetailReqInfo
	 * @throws Exception 
	 */
	public void getScheduleGetBackDetailCheck(
			ScheduleGetBackDetailReqInfo scheduleGetBackDetailReqInfo) throws Exception {
		if(isEmpty(scheduleGetBackDetailReqInfo.getRegistNo())){throw new Exception("报案登记号是必传参数，请检查！");}
		if(isEmpty(scheduleGetBackDetailReqInfo.getUserCode())){throw new Exception("用户代码是必传参数，请检查！");}
		if(isEmpty(scheduleGetBackDetailReqInfo.getComCode())){throw new Exception("机构代码是必传参数，请检查！");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getFlowInTime())){throw new Exception("调度时间是必传参数，请检查！");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getHandlerCode())){throw new Exception("调度操作员代码是必传参数，请检查！");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getHandlerName())){throw new Exception("调度操作员名称是必传参数，请检查！");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getBeforeHandlerCode())){throw new Exception("查勘/定损人员代码是必传参数，请检查！");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getBeforeHandlerName())){throw new Exception("查勘/定损人员名称是必传参数，请检查！");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getLossItemCode())){throw new Exception("调度对象代码是必传参数，请检查！");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getLossItemName())){throw new Exception("调度对象名称是必传参数，请检查！");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getFlowId())){throw new Exception("节点ID是必传参数，请检查！");}
//		if(isEmpty(scheduleGetBackDetailReqInfo.getLogNo())){throw new Exception("节点序号是必传参数，请检查！");}
		
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
	 * 理赔系统改派数据校验
	 * @param scheduleGetBackReqInfo
	 * @throws Exception 
	 */
	public void saveScheduleGetBackCheck(
			ScheduleGetBackReqInfo scheduleGetBackReqInfo) throws Exception {
	if(isEmpty(scheduleGetBackReqInfo.getRegistNo())){throw new Exception("报案号是必传参数，请检查！");}
	if(isEmpty(scheduleGetBackReqInfo.getRiskCode())){throw new Exception("险种代码是必传参数，请检查！");}
	if(isEmpty(scheduleGetBackReqInfo.getScheduleObjectID())){throw new Exception("查勘处理单位代码是必传参数，请检查！");}
	if(isEmpty(scheduleGetBackReqInfo.getScheduleObjectName())){throw new Exception("查勘处理单位名称是必传参数，请检查！");}
	if(isEmpty(scheduleGetBackReqInfo.getCheckSite())){throw new Exception("查勘地址是必传参数，请检查！");}
	if(isEmpty(scheduleGetBackReqInfo.getNextHandlerCode())){throw new Exception("查勘人员代码是必传参数，请检查！");}
	if(isEmpty(scheduleGetBackReqInfo.getNextHandlerName())){throw new Exception("查勘人员名称是必传参数，请检查！");}
	if(isEmpty(scheduleGetBackReqInfo.getFlowId())){throw new Exception("节点ID是必传参数，请检查！");}
	if(isEmpty(scheduleGetBackReqInfo.getLogNo())){throw new Exception("节点序号是必传参数，请检查！");}
	if(isEmpty(scheduleGetBackReqInfo.getOperatorCode())){throw new Exception("操作人员代码是必传参数，请检查！");}
	if(isEmpty(scheduleGetBackReqInfo.getInputDate())){throw new Exception("操作日期是必传参数，请检查！");}
	if(isEmpty(scheduleGetBackReqInfo.getInputHour())){throw new Exception("操作时间是必传参数，请检查！");}
	}
	public ScheduleDto agriViewToDto(
			ScheduleGetBackReqInfo scheduleGetBackReqInfo) throws SQLException, UserException, Exception {
		ScheduleDto scheduleDto = new ScheduleDto();
		//TODO 
		
		
		
		return scheduleDto;
	}
}
