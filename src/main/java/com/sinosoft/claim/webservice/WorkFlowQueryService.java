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
		logger.log("理赔系统流程查询列表",1,serial,swfFlowDtoReqInfo);
		SwfFlowDtoInfo swfFlowDtoInfo = null;
		DBManager dbManager = new DBManager();
		ResultSet resultSet= null; 
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			if(swfFlowDtoReqInfo.getPageNo()<0){
				throw new Exception("页码传入有误，请检查！");
			}
			if(swfFlowDtoReqInfo.getRecordPerPage()<0){
				throw new Exception("每页记录数传入有误，请检查！");
			}
			if(swfFlowDtoReqInfo.getCaseType()==null){
				throw new Exception("案件状态传入有误，请检查！");
			}
			if(!"0".equals(swfFlowDtoReqInfo.getCaseType())&&(swfFlowDtoReqInfo.getRiskCategory()==null||"".equals(swfFlowDtoReqInfo.getRiskCategory())||
					swfFlowDtoReqInfo.getRiskCode()==null||"".equals(swfFlowDtoReqInfo.getRiskCode()))){
				throw new Exception("案件状态是未结案时,可以为空。否则不能为空，请检查！");
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
					throw new Exception("险种代码与险种大类不匹配，请检查！");
				}
			}
			if(swfFlowDtoReqInfo.getUsercode()==null||"".equals(swfFlowDtoReqInfo.getUsercode())){
				throw new Exception("用户代码有误，请检查！");
			}
			if(swfFlowDtoReqInfo.getComcode()==null||"".equals(swfFlowDtoReqInfo.getComcode())){
				throw new Exception("机构代码有误，请检查！");
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
			String strTableName = "Swflog";//流程查询使用的表，未转储查询表swflog，已转储查询表swflogstore
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
				//优化sql条件start
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
				//优化sql条件end
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
			// 查询流程信息
			UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

			PageRecord pageRecord = null;
			if (caseType != null ) {
				//已结案转储
				if(caseType.equals("1")){
					pageRecord = (PageRecord) uiWorkFlowAction.findStoreNodesByConditions(
							conditions, pageNo, recordPerPage);
				//未结案转储
				}else if(caseType.equals("0")){
					pageRecord = (PageRecord) uiWorkFlowAction.findNodesByConditions(
							conditions, pageNo, recordPerPage);
				//所有案件
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
			
			
			// 查询出来的一页的结构集
			swfFlowDtoInfo.setSwfFlowDtoList(swfFlowDtoList);
			// 当前页号
			swfFlowDtoInfo.setPageNo(pageRecord.getPageNo());
			// 一页的条数
			swfFlowDtoInfo.setRecordPerPage(pageRecord.getRowsPerPage());
			// 查询出来的结果的总数
			swfFlowDtoInfo.setTotalCount(pageRecord.getCount());
			// 返回总的页数
			swfFlowDtoInfo.setTotalPage(pageRecord.getTotalPageCount());
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("理赔系统流程查询列表",serial,e);
		}finally{
		      try {
				dbManager.close();
				if(resultSet!=null){
					resultSet.close();
				}
			} catch (Exception e) {
				logger.log("理赔系统流程查询列表",serial,e);
				e.printStackTrace();
			}
		}
		
		logger.log("理赔系统流程查询列表",0,serial,swfFlowDtoInfo);
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
		// 取得多个关联的保单信息
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

		// 首先判断是否是报案注销，如果是报案注销的话，肯定没立案
		if ("6".equals(swfLogDto.getNodeStatus())) {
			otherFlag = "报案注销";
		}
		// 判断是否为立案注销,目前先屏蔽掉，因为增加强三后，显示一个是不够的，需要完善。
		
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
					otherFlag = otherFlag + "立案注销"; 
				}
				else if(prpLclaimDto.getEndCaseDate() != null && !prpLclaimDto.getEndCaseDate().toString().equals("")){
					otherFlag = otherFlag + "已结案"; 
				}			
				else{
					otherFlag = "";
				}
			}
			//已立案未结案的案件状态显示最后节点
			if(otherFlag == null || "".equals(otherFlag)){
				otherFlag = "已立案(" + blSwflogFacade.getMaxNodeName(swfLogDto.getFlowID()) + ")";
			 }
		 }
	     //已报案未立案的案件状态显示最后节点
		 if(otherFlag == null || "".equals(otherFlag)){
			 otherFlag = "未立案(" + blSwflogFacade.getMaxNodeName(swfLogDto.getFlowID()) + ")";
		 }
		return otherFlag;
	}
}
