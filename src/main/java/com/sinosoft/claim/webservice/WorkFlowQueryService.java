package com.sinosoft.claim.webservice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.gyic.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLPrpDriskFacade;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpDclassDto;
import com.sinosoft.claim.dto.domain.PrpDriskDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.util.CallCenterInterfaceLogger;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.platform.bl.facade.BLPowerFacade;
import com.sinosoft.platform.bl.facade.BLPrpDclassFacade;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class WorkFlowQueryService {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	public SwfFlowDtoInfo getWorkFlowList (SwfFlowDtoReqInfo swfFlowDtoReqInfo){
		long serial = System.currentTimeMillis();
		logger.log("����ϵͳ���̲�ѯ�б�",1,serial,swfFlowDtoReqInfo);
		SwfFlowDtoInfo swfFlowDtoInfo = null;
		DBManager dbManager = new DBManager();
		ResultSet resultSet= null; 
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			if(swfFlowDtoReqInfo.getPageNo()<0){
				throw new Exception("ҳ�봫���������飡");
			}
			if(swfFlowDtoReqInfo.getRecordPerPage()<0){
				throw new Exception("ÿҳ��¼�������������飡");
			}
			if(swfFlowDtoReqInfo.getCaseType()==null){
				throw new Exception("����״̬�����������飡");
			}
			if(!"0".equals(swfFlowDtoReqInfo.getCaseType())&&(swfFlowDtoReqInfo.getRiskCategory()==null||"".equals(swfFlowDtoReqInfo.getRiskCategory())||
					swfFlowDtoReqInfo.getRiskCode()==null||"".equals(swfFlowDtoReqInfo.getRiskCode()))){
				throw new Exception("����״̬��δ�᰸ʱ,����Ϊ�ա�������Ϊ�գ����飡");
			}
			if(swfFlowDtoReqInfo.getRiskCategory()!=null&&!"".equals(swfFlowDtoReqInfo.getRiskCategory())&&
					swfFlowDtoReqInfo.getRiskCode()!=null&&!"".equals(swfFlowDtoReqInfo.getRiskCode())){
				String strSql = "select c.riskcategory from prpdrisk r,prpdclass c "
				+" where r.classcode = c.classcode "
				+" and r.riskcode = '"+swfFlowDtoReqInfo.getRiskCode()+"' "
				+" and r.validstatus = '1' "
				+" and c.validstatus = '1'";
				resultSet = dbManager.executeQuery(strSql);
				resultSet.next();
				String riskCategory = dbManager.getString(resultSet, 1);
				if(!swfFlowDtoReqInfo.getRiskCategory().equals(riskCategory)){
					throw new Exception("���ִ��������ִ��಻ƥ�䣬���飡");
				}
			}
			if(swfFlowDtoReqInfo.getUsercode()==null||"".equals(swfFlowDtoReqInfo.getUsercode())){
				throw new Exception("�û������������飡");
			}
			if(swfFlowDtoReqInfo.getComcode()==null||"".equals(swfFlowDtoReqInfo.getComcode())){
				throw new Exception("���������������飡");
			}
			String registNo = StringUtils.rightTrim(swfFlowDtoReqInfo.getRegistNo());
			String policyNo = StringUtils.rightTrim(swfFlowDtoReqInfo.getPolicyNo());
			String licenseNo = StringUtils.rightTrim(swfFlowDtoReqInfo.getLicenseNo());
			String caseType = StringUtils.rightTrim(swfFlowDtoReqInfo.getCaseType());
			String flowinTime = StringUtils.rightTrim(swfFlowDtoReqInfo.getFlowinTime());
			String insuredName = StringUtils.rightTrim(swfFlowDtoReqInfo.getInsuredName());
			String riskCategory = StringUtils.rightTrim(swfFlowDtoReqInfo.getRiskCategory());
			String riskCode = StringUtils.rightTrim(swfFlowDtoReqInfo.getRiskCode());
			String usercode = StringUtils.rightTrim(swfFlowDtoReqInfo.getUsercode());
			String comcode = StringUtils.rightTrim(swfFlowDtoReqInfo.getComcode());
			int pageNo = 1;
			int recordPerPage = 20;
			if(swfFlowDtoReqInfo.getPageNo()!=0){
				pageNo = swfFlowDtoReqInfo.getPageNo();
			}
			if(swfFlowDtoReqInfo.getRecordPerPage()!=0){
				recordPerPage = swfFlowDtoReqInfo.getRecordPerPage();
			}
			String strTableName = "Swflog";//���̲�ѯʹ�õı�δת����ѯ��swflog����ת����ѯ��swflogstore
			String conditions = " 1=1  ";
			String swflogCondition = "";
			String swflogStoreCondition = "";
			if (policyNo.length() > 0) {
				conditions = conditions
						+ " and registno in (select registno from "
						+ "prplregistrpolicy where 1=1 "
						+ StringConvert.convertString(" policyNo", policyNo,"=")
						+ ") ";
			}
			if (caseType != null && !caseType.equals("") && caseType.equals("1")) {
					strTableName = "SwflogStore";
			}
			com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
			UserDto userDto = new UserDto();
			userDto.setUserCode(usercode);
			userDto.setComCode(comcode);
			if(!new BLPowerFacade().isSuperUser(userDto.getComCode(), userDto.getUserCode())){ 
				conditions = conditions + " and (exists(select 1 from " + strTableName + " g where g.registno= " + strTableName + ".registno ";
				conditions = conditions
						+ uiPowerInterface.addPower(userDto, strTableName, "", "handleDept").replaceAll(strTableName, "g");
				//�Ż�sql����start
				if (insuredName.length() > 0) {
					conditions = conditions
							+ StringConvert.convertString(" g.insuredName", insuredName,"=");
				}
				if (licenseNo.length() > 0) {
					conditions = conditions
							+ StringConvert.convertString(" g.lossitemName", licenseNo,"=");
				}
				if (riskCode.length() > 0) {
					conditions = conditions
							+ StringConvert.convertString(" g.riskCode", riskCode,"=");
				}
				if (registNo.length() > 0) {
					conditions = conditions
							+ StringConvert.convertString(" g.RegistNO", registNo,"=");
				}
				conditions = conditions + ")";
				//�Ż�sql����end
				conditions = conditions
				+ uiPowerInterface.addPower(userDto, "vv","", "ComCode").replaceAll("AND", "or").replaceAll("vv", strTableName)+")";
			}
			conditions = conditions + " and nodeType='regis'";
			if (insuredName.length() > 0) {
				conditions = conditions
						+ StringConvert.convertString(" insuredName", insuredName,"=");
			}
			if (licenseNo.length() > 0) {
				conditions = conditions
						+ StringConvert.convertString(" lossitemName", licenseNo,"=");
			}
			if (riskCode.length() > 0) {
				conditions = conditions
						+ StringConvert.convertString(" riskCode", riskCode,"=");
			}
			if (registNo.length() > 0) {
				conditions = conditions
						+ StringConvert.convertString("RegistNO", registNo,"=");
			}
			if (flowinTime != null && flowinTime.length() > 0) {
				conditions = conditions
						+ " And to_Date (Flowintime,'yyyy-MM-dd HH24:mi:ss') >= to_date('" + flowinTime + " 00:00:00','yyyy-MM-dd HH24:mi:ss')";
			}
			if (caseType != null && caseType.equals("")) {
				swflogCondition = conditions;
				swflogStoreCondition = conditions.replaceAll("Swflog", "SwflogStore");
			}
			conditions += " and dataFlag is null "; 
			conditions = conditions + " order by handleTime desc";
			// ��ѯ������Ϣ
			UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

			PageRecord pageRecord = null;
			if (caseType != null ) {
				//�ѽ᰸ת��
				if(caseType.equals("1")){
					pageRecord = (PageRecord) uiWorkFlowAction.findStoreNodesByConditions(
							conditions, pageNo, recordPerPage);
				//δ�᰸ת��
				}else if(caseType.equals("0")){
					pageRecord = (PageRecord) uiWorkFlowAction.findNodesByConditions(
							conditions, pageNo, recordPerPage);
				//���а���
				}else{
					BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
					pageRecord = (PageRecord) blSwfLogFacade.findAllStatusByConditions(
							swflogCondition,swflogStoreCondition, pageNo, recordPerPage);
				}
		    }
			swfFlowDtoInfo = new SwfFlowDtoInfo();
			ArrayList swfLogList = new ArrayList();
			swfLogList = (ArrayList) pageRecord.getResult();
			SwfFlowDto[] swfFlowDtoList = new SwfFlowDto[swfLogList.size()];
			
			for(int i =0;i<swfLogList.size();i++){
				SwfFlowDto swfFlowDto = new SwfFlowDto();
				SwfLogDto swfLogDto = (SwfLogDto) swfLogList.get(i);
				String otherFlag = getOtherFlag(swfLogDto);
				String[] policyNos = getPolicyNos(swfLogDto);
				String riskCodeName = getRiskCodeName(swfLogDto);
				swfFlowDto.setOtherFlag(otherFlag);
				swfFlowDto.setRegistNo(swfLogDto.getRegistNo());
				swfFlowDto.setPolicyNo(policyNos);
				swfFlowDto.setInsuredName(swfLogDto.getInsuredName());
				swfFlowDto.setItemName(swfLogDto.getLossItemName());
				swfFlowDto.setHandlerCode(swfLogDto.getHandlerCode());
				swfFlowDto.setHandlerName(swfLogDto.getHandlerName());
				swfFlowDto.setReportDate(swfLogDto.getSubmitTime());
				swfFlowDto.setRiskCode(swfLogDto.getRiskCode());
				swfFlowDto.setRiskName(riskCodeName);
				swfFlowDtoList[i] = swfFlowDto;
			}
			
			
			// ��ѯ������һҳ�Ľṹ��
			swfFlowDtoInfo.setSwfFlowDtoList(swfFlowDtoList);
			// ��ǰҳ��
			swfFlowDtoInfo.setPageNo(pageRecord.getPageNo());
			// һҳ������
			swfFlowDtoInfo.setRecordPerPage(pageRecord.getRowsPerPage());
			// ��ѯ�����Ľ��������
			swfFlowDtoInfo.setTotalCount(pageRecord.getCount());
			// �����ܵ�ҳ��
			swfFlowDtoInfo.setTotalPage(pageRecord.getTotalPageCount());
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("����ϵͳ���̲�ѯ�б�",serial,e);
		}finally{
		      try {
				dbManager.close();
				if(resultSet!=null){
					resultSet.close();
				}
			} catch (Exception e) {
				logger.log("����ϵͳ���̲�ѯ�б�",serial,e);
				e.printStackTrace();
			}
		}
		
		logger.log("����ϵͳ���̲�ѯ�б�",0,serial,swfFlowDtoInfo);
		return swfFlowDtoInfo;
	}
	private String getRiskCodeName(SwfLogDto swfLogDto) throws Exception {
		String riskCodeName = "";
		UICodeAction uiCodeAction = new UICodeAction();
		String strTemp = uiCodeAction.translateRiskCode(swfLogDto.getRiskCode(), true);
		if (strTemp != null && strTemp.length() > 4)
			strTemp = strTemp.substring(0, 4);
		riskCodeName = strTemp;
		return riskCodeName;
	}
	private String[] getPolicyNos(SwfLogDto swfLogDto) throws SQLException, Exception {
		String[] policyNos = null;
		UIPrpLregistRPolicyAction uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction();
		String strSql = " registno='" + swfLogDto.getRegistNo()+ "'";// and validstatus='1'";
		// ȡ�ö�������ı�����Ϣ
		Collection relatePolicyList = uiPrpLregistRPolicyAction.findByConditions(strSql);
		policyNos = new String[relatePolicyList.size()];
		Iterator it = relatePolicyList.iterator();
		int i = 0;
		while(it.hasNext()){
			PrpLRegistRPolicyDto prpLRegistRPolicyDto = (PrpLRegistRPolicyDto) it.next();
			policyNos[i++] = prpLRegistRPolicyDto.getPolicyNo();
		}
		return policyNos;
	}

	private String getOtherFlag(SwfLogDto swfLogDto) throws Exception {
		String otherFlag = "";
		ArrayList prpLclaimList = new ArrayList();
		UICodeAction uiCodeAction = new UICodeAction();

		UIClaimAction uiClaimAction = new UIClaimAction();
		BLSwfLogFacade blSwflogFacade = new BLSwfLogFacade();			

		// �����ж��Ƿ��Ǳ���ע��������Ǳ���ע���Ļ����϶�û����
		if ("6".equals(swfLogDto.getNodeStatus())) {
			otherFlag = "����ע��";
		}
		// �ж��Ƿ�Ϊ����ע��,Ŀǰ�����ε�����Ϊ����ǿ������ʾһ���ǲ����ģ���Ҫ���ơ�
		
		prpLclaimList =	(ArrayList)uiClaimAction.findByConditions("prplclaim.registNo='" +swfLogDto.getRegistNo() + "'"); 
		if(prpLclaimList != null &&	prpLclaimList.size() > 0){ 
			for(int i = 0 ; i < prpLclaimList.size(); i ++){
				PrpLclaimDto prpLclaimDto = (PrpLclaimDto)prpLclaimList.get(i);
				if(i > 0){
					otherFlag = otherFlag + "/";
				}else{							
					otherFlag = "";													
				}
				if(prpLclaimDto.getCancelDate() != null && !prpLclaimDto.getCancelDate().toString().equals("")){
					otherFlag = otherFlag + "����ע��"; 
				}
				else if(prpLclaimDto.getEndCaseDate() != null && !prpLclaimDto.getEndCaseDate().toString().equals("")){
					otherFlag = otherFlag + "�ѽ᰸"; 
				}			
				else{
					otherFlag = "";
				}
			}
			//������δ�᰸�İ���״̬��ʾ���ڵ�
			if(otherFlag == null || "".equals(otherFlag)){
				otherFlag = "������(" + blSwflogFacade.getMaxNodeName(swfLogDto.getFlowID()) + ")";
			 }
		 }
	     //�ѱ���δ�����İ���״̬��ʾ���ڵ�
		 if(otherFlag == null || "".equals(otherFlag)){
			 otherFlag = "δ����(" + blSwflogFacade.getMaxNodeName(swfLogDto.getFlowID()) + ")";
		 }
		return otherFlag;
	}
}
