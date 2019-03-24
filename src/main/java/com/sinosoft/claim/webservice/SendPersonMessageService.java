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
 * ��Ϣ������Ա��Ϣ�ӿ�
 * @author Administrator
 *
 */
public class SendPersonMessageService {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	/**
	 * ���������Ա��Ϣ
	 * @param registNo
	 * @return
	 */
	public SendUserMessageDtoInfo[] getUserMessage (String registNo){
		long serial = System.currentTimeMillis();
		logger.log("���������Ա��Ϣ", 1,serial, "[registNo:"+registNo+"]");
		SendUserMessageDtoInfo[] sendUserMessageDtoInfos =null;
		ArrayList<SendUserMessageDtoInfo> sendUserMessageDtoInfoList = new ArrayList<SendUserMessageDtoInfo>();
		try {
			if(registNo==null||registNo.trim().length()==0){
				throw new Exception("���������Ǳش�����������");
			}
			registNo = registNo.trim();
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
			if(prpLregistDto==null){
				throw new Exception("�����Ų����ڣ�����");
			}
			//���汨���������Ϣ
			if(prpLregistDto!=null){
				SendUserMessageDtoInfo sendUserMessageDtoInfo = new SendUserMessageDtoInfo();
				sendUserMessageDtoInfo.setUserType("1");
				sendUserMessageDtoInfo.setUserTypeName("������");
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
				sendUserMessageDtoInfo.setUserTypeName("��������");
				sendUserMessageDtoInfo.setUserName(prpCinsuredSchema.getInsuredName());
				sendUserMessageDtoInfo.setPhoneNumber(prpCinsuredSchema.getMobile());
				sendUserMessageDtoInfoList.add(sendUserMessageDtoInfo);
			}
			
			
//			//��ѯֱ���ϼ����㵥λ
//			BLPrpDcompanyFacade prpDcompany = new BLPrpDcompanyFacade();   
//		    String upperComCode = prpDcompany.getCenterCode(prpLregistDto.getComCode());
			//ת�ӱ����˺ͶԽ���
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
						sendUserMessageDtoInfo.setUserTypeName("�Խ���");
						sendUserMessageDtoInfo.setUserName(staffName0);
						sendUserMessageDtoInfo.setPhoneNumber(staffPhone0);
						sendUserMessageDtoInfoList.add(sendUserMessageDtoInfo);
					}else{
						staffName1 = prpLJobLinkerDto.getStaffName();
						staffPhone1 = prpLJobLinkerDto.getStaffPhone();
						SendUserMessageDtoInfo sendUserMessageDtoInfo = new SendUserMessageDtoInfo();
						sendUserMessageDtoInfo.setUserType("4");
						sendUserMessageDtoInfo.setUserTypeName("ת����");
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
						sendUserMessageDtoInfo.setUserTypeName("�Խ���");
						sendUserMessageDtoInfo.setUserName(staffName0);
						sendUserMessageDtoInfo.setPhoneNumber(staffPhone0);
						sendUserMessageDtoInfoList.add(sendUserMessageDtoInfo);
					}else{
						staffName1 = prpLJobLinkerDto.getStaffName();
						staffPhone1 = prpLJobLinkerDto.getStaffPhone();
						SendUserMessageDtoInfo sendUserMessageDtoInfo = new SendUserMessageDtoInfo();
						sendUserMessageDtoInfo.setUserType("4");
						sendUserMessageDtoInfo.setUserTypeName("ת����");
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
			logger.log("���������Ա��Ϣ",serial,e);
		}
		logger.log("���������Ա��Ϣ", 0,serial, sendUserMessageDtoInfos);
		return sendUserMessageDtoInfos;
		
	}
}
