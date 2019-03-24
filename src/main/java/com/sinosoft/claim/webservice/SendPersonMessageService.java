package com.sinosoft.claim.webservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpLJobLinkerFacade;
import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLScheduleFacade;
import com.sinosoft.claim.dto.domain.PrpLJobLinkerDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.util.CallCenterInterfaceLogger;
import com.sinosoft.prpall.blsvr.cb.BLPrpCinsured;
import com.sinosoft.prpall.schema.PrpCinsuredSchema;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * 短息发送人员信息接口
 * @author Administrator
 *
 */
public class SendPersonMessageService {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	/**
	 * 理赔短信人员信息
	 * @param registNo
	 * @return
	 */
	public SendUserMessageDtoInfo[] getUserMessage (String registNo){
		long serial = System.currentTimeMillis();
		logger.log("理赔短信人员信息", 1,serial, "[registNo:"+registNo+"]");
		SendUserMessageDtoInfo[] sendUserMessageDtoInfos =null;
		ArrayList<SendUserMessageDtoInfo> sendUserMessageDtoInfoList = new ArrayList<SendUserMessageDtoInfo>();
		try {
			if(registNo==null||registNo.trim().length()==0){
				throw new Exception("报案号码是必传参数，请检查");
			}
			registNo = registNo.trim();
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
			if(prpLregistDto==null){
				throw new Exception("报案号不存在，请检查");
			}
			//保存报案人相关信息
			if(prpLregistDto!=null){
				SendUserMessageDtoInfo sendUserMessageDtoInfo = new SendUserMessageDtoInfo();
				sendUserMessageDtoInfo.setUserType("1");
				sendUserMessageDtoInfo.setUserTypeName("报案人");
				sendUserMessageDtoInfo.setUserName(prpLregistDto.getReportorName());
				sendUserMessageDtoInfo.setPhoneNumber(prpLregistDto.getPhoneNumber());
				sendUserMessageDtoInfoList.add(sendUserMessageDtoInfo);
			}
			
			
			BLScheduleFacade blScheduleFacade = new BLScheduleFacade();
			String isWhere = " registNo = '" + registNo + "'";
			ArrayList blScheduleDtoList = (ArrayList)blScheduleFacade.findByConditions(isWhere);
			PrpLscheduleMainWFDto prpLscheduleMainWFDto = null;
			if(blScheduleDtoList.size() > 0){
				prpLscheduleMainWFDto = (PrpLscheduleMainWFDto)blScheduleDtoList.get(0);
			}
			BLPrpCinsured blPrpCinsured = new BLPrpCinsured();
			isWhere = " policyNo = '" + prpLregistDto.getPolicyNo() + "' and insuredflag ='1' ";
			blPrpCinsured.query(isWhere);
			PrpCinsuredSchema prpCinsuredSchema = new PrpCinsuredSchema();
			if(blPrpCinsured.getSize() > 0){
				prpCinsuredSchema = blPrpCinsured.getArr(0);
				SendUserMessageDtoInfo sendUserMessageDtoInfo = new SendUserMessageDtoInfo();
				sendUserMessageDtoInfo.setUserType("2");
				sendUserMessageDtoInfo.setUserTypeName("被保险人");
				sendUserMessageDtoInfo.setUserName(prpCinsuredSchema.getInsuredName());
				sendUserMessageDtoInfo.setPhoneNumber(prpCinsuredSchema.getMobile());
				sendUserMessageDtoInfoList.add(sendUserMessageDtoInfo);
			}
			
			
//			//查询直接上级核算单位
//			BLPrpDcompanyFacade prpDcompany = new BLPrpDcompanyFacade();   
//		    String upperComCode = prpDcompany.getCenterCode(prpLregistDto.getComCode());
			//转接报案人和对接人
			String staffName0 = "";
			String staffName1 = "";
			String staffPhone0 = "";
			String staffPhone1 = "";
			BLPrpLJobLinkerFacade blPrpLJobLinkerFacade = new BLPrpLJobLinkerFacade();
			String riskCode = prpLscheduleMainWFDto.getRiskCode();
			String conditions = "";
			Collection<PrpLJobLinkerDto> prpLJobLinkerDtoList = null;
			if("0310".equals(riskCode)||"0312".equals(riskCode)){
			conditions = " classcode = '99' and month='"+prpLscheduleMainWFDto.getInputDate().toString(DateTime.YEAR_TO_MONTH)+"' and handledept='"+prpLscheduleMainWFDto.getScheduleObjectID()+"'" ;
		    prpLJobLinkerDtoList = blPrpLJobLinkerFacade.findByConditions(conditions);
			if(prpLJobLinkerDtoList.size()>0){
				Iterator itr = prpLJobLinkerDtoList.iterator();
				while(itr.hasNext()){
					PrpLJobLinkerDto prpLJobLinkerDto = (PrpLJobLinkerDto)itr.next();
					if("0".equals(prpLJobLinkerDto.getStaffPosition())){
						staffName0 = prpLJobLinkerDto.getStaffName();
						staffPhone0 = prpLJobLinkerDto.getStaffPhone();
						SendUserMessageDtoInfo sendUserMessageDtoInfo = new SendUserMessageDtoInfo();
						sendUserMessageDtoInfo.setUserType("3");
						sendUserMessageDtoInfo.setUserTypeName("对接人");
						sendUserMessageDtoInfo.setUserName(staffName0);
						sendUserMessageDtoInfo.setPhoneNumber(staffPhone0);
						sendUserMessageDtoInfoList.add(sendUserMessageDtoInfo);
					}else{
						staffName1 = prpLJobLinkerDto.getStaffName();
						staffPhone1 = prpLJobLinkerDto.getStaffPhone();
						SendUserMessageDtoInfo sendUserMessageDtoInfo = new SendUserMessageDtoInfo();
						sendUserMessageDtoInfo.setUserType("4");
						sendUserMessageDtoInfo.setUserTypeName("转接人");
						sendUserMessageDtoInfo.setUserName(staffName1);
						sendUserMessageDtoInfo.setPhoneNumber(staffPhone1);
						sendUserMessageDtoInfoList.add(sendUserMessageDtoInfo);
					}
				}
			}
			}else{
			conditions = " classcode = '"+ prpLscheduleMainWFDto.getRiskCode().substring(0,2) +"' and month='"+prpLscheduleMainWFDto.getInputDate().toString(DateTime.YEAR_TO_MONTH)+"' and handledept='"+prpLscheduleMainWFDto.getScheduleObjectID()+"'" ;
		    prpLJobLinkerDtoList = blPrpLJobLinkerFacade.findByConditions(conditions);
			if(prpLJobLinkerDtoList.size()>0){
				Iterator itr = prpLJobLinkerDtoList.iterator();
				while(itr.hasNext()){
					PrpLJobLinkerDto prpLJobLinkerDto = (PrpLJobLinkerDto)itr.next();
					if("0".equals(prpLJobLinkerDto.getStaffPosition())){
						staffName0 = prpLJobLinkerDto.getStaffName();
						staffPhone0 = prpLJobLinkerDto.getStaffPhone();
						SendUserMessageDtoInfo sendUserMessageDtoInfo = new SendUserMessageDtoInfo();
						sendUserMessageDtoInfo.setUserType("3");
						sendUserMessageDtoInfo.setUserTypeName("对接人");
						sendUserMessageDtoInfo.setUserName(staffName0);
						sendUserMessageDtoInfo.setPhoneNumber(staffPhone0);
						sendUserMessageDtoInfoList.add(sendUserMessageDtoInfo);
					}else{
						staffName1 = prpLJobLinkerDto.getStaffName();
						staffPhone1 = prpLJobLinkerDto.getStaffPhone();
						SendUserMessageDtoInfo sendUserMessageDtoInfo = new SendUserMessageDtoInfo();
						sendUserMessageDtoInfo.setUserType("4");
						sendUserMessageDtoInfo.setUserTypeName("转接人");
						sendUserMessageDtoInfo.setUserName(staffName1);
						sendUserMessageDtoInfo.setPhoneNumber(staffPhone1);
						sendUserMessageDtoInfoList.add(sendUserMessageDtoInfo);
					}
				}
			}
			}
			
			BLPrpLRegistRPolicyFacade blPrpLRegistRPolicyFacade = new BLPrpLRegistRPolicyFacade();
			String sql = " registno = '"+registNo+"' and validstatus = '1' ";
			ArrayList registPolicyList = (ArrayList) blPrpLRegistRPolicyFacade.findByConditions(sql);
			String[] policyNos = new String[registPolicyList.size()];
			for(int i =0;i<registPolicyList.size();i++){
				PrpLRegistRPolicyDto prpLRegistRPolicyDto =(PrpLRegistRPolicyDto)registPolicyList.get(i);
				policyNos[i] = prpLRegistRPolicyDto.getPolicyNo();
			}
			sendUserMessageDtoInfos = new SendUserMessageDtoInfo[sendUserMessageDtoInfoList.size()];
			for(int i=0;i<sendUserMessageDtoInfoList.size();i++){
				sendUserMessageDtoInfoList.get(i).setPolicyNo(policyNos);
				sendUserMessageDtoInfos[i] = sendUserMessageDtoInfoList.get(i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("理赔短信人员信息",serial,e);
		}
		logger.log("理赔短信人员信息", 0,serial, sendUserMessageDtoInfos);
		return sendUserMessageDtoInfos;
		
	}
}
