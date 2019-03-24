package com.sinosoft.claimciplatform.bl.action.custom;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.sinosoft.ciplatform.dto.custom.ReCase;
import com.sinosoft.claim.bl.action.custom.BLCompensateAction;
import com.sinosoft.claim.bl.action.custom.BLPolicyAction;
import com.sinosoft.claim.bl.action.domain.BLPrpCitemCarAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLRegistRPolicyAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLlossAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLltextAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpersonLossAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLregistAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLthirdPartyAction;
import com.sinosoft.claim.bl.facade.BLPrpLdriverFacade;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto;
import com.sinosoft.claim.dto.domain.CiClaimCrashDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLdriverDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claim.ui.model.CiClaimCompelcrashFindByConditionsCommand;
import com.sinosoft.claim.ui.model.CiClaimCompelcrashUpdateCommand;
import com.sinosoft.claim.ui.model.CiClaimCrashInsertCommand;
import com.sinosoft.claimciplatform.dto.custom.AccidentInfor;
import com.sinosoft.claimciplatform.dto.custom.CancelCase;
import com.sinosoft.claimciplatform.dto.custom.Claim;
import com.sinosoft.claimciplatform.dto.custom.ClaimHistoryDto;
import com.sinosoft.claimciplatform.dto.custom.ClaimHistoryInfor;
import com.sinosoft.claimciplatform.dto.custom.CompelCrashDto;
import com.sinosoft.claimciplatform.dto.custom.CompensateVeric;
import com.sinosoft.claimciplatform.dto.custom.EndCase;
import com.sinosoft.claimciplatform.dto.custom.EndCaseAppend;
import com.sinosoft.claimciplatform.dto.custom.Iconstants;
import com.sinosoft.claimciplatform.dto.custom.LossSituation;
import com.sinosoft.claimciplatform.dto.custom.PayRefInfo;
import com.sinosoft.claimciplatform.dto.custom.PlatFormParam;
import com.sinosoft.claimciplatform.dto.custom.Regist;
import com.sinosoft.claimciplatform.dto.custom.ThirdCar;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLCIClaimPlatFormInterfaceActionImplDubang extends
		BLCIClaimPlatFormInterfaceAction {

	protected PlatFormParam getPlatFormParam(DBManager dbManager,
			String policyNo) throws SQLException, Exception {
		/**
		 * 获得平台参数
		 */

		PlatFormParam platFormParam = new PlatFormParam();
		BLPolicyAction blPolicyAction = new BLPolicyAction();
		String str = "";
	
//			PolicyDto policyDto = blPolicyAction.findByPrimaryKey(dbManager,
//				policyNo);
//           String comcode = policyDto.getPrpCmainDto().getComCode();	
//			if ("233".equals(comcode.substring(0, 3))) {
//				str = "ZJ";
//			}
//			if ("211".equals(comcode.substring(0, 3))) {
//				str = "BJ";
//			}
	
//			str = policyNo;
	System.out.println("======gggggggggggggggg====="+"ciplatform." + str + "URL");
		platFormParam.setUrl(AppConfig.get("sysconst." + str + "URL"));
		platFormParam.setUserName(AppConfig.get("sysconst." + str + "User"));
		platFormParam.setUserPwd(AppConfig.get("sysconst." + str + "Pwd"));
		return platFormParam;
	}

	protected Regist getRegist(DBManager dbManager, String registNo)
			throws SQLException, Exception {
		/**
		 * 获得单报案对象（从效率考虑不需要获得报案复合对象）
		 */
		PrpLregistDto prpLregistDto = new BLPrpLregistAction()
				.findByPrimaryKey(dbManager, registNo);

		/**
		 * 获得保单号
		 */
		String policyNo = getPolicyNo(dbManager, registNo);
		/**
		 * 获得保单标的车对象
		 */
		PrpCitemCarDto prpCitemCarDto = new BLPrpCitemCarAction()
				.findByPrimaryKey(dbManager, policyNo, 1);

		String licenseNo = "";
		Date damageStartDate = new Date();
		String damageStartHour = null;

		/**
		 * 出险时间（年月日时分）
		 */
		if (prpLregistDto != null) {
			damageStartDate = prpLregistDto.getDamageStartDate();
			damageStartHour = prpLregistDto.getDamageStartHour();
			// licenseNo = prpLregistDto.getLicenseNo();
		}
		licenseNo = prpCitemCarDto.getLicenseNo();

		// System.out.println("System.out.println();===="+damageStartDate);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd");
		String damageDate = dateFormat2.format(dateFormat1.parse(damageStartDate.toString()))+
					(damageStartHour.split(":")[0])+ 
					(damageStartHour.split(":")[1]);

		// System.out.println("damageDate (regist ) ==="+damageDate);

		Regist regist = new Regist();
		regist.setRegistNo(registNo);
		regist.setPolicyNO(policyNo);
		regist.setLicenseNo(licenseNo);
		regist.setLicenseType(prpCitemCarDto.getLicenseKindCode());
		regist.setDamageDate(damageDate);
		regist.setThirdCarList(getThirdCarList(dbManager, registNo));
		regist.setClaimNo(getClaimNo(dbManager, registNo));

		return regist;
	}

	protected Claim getClaim(DBManager dbManager, String claimNo)
			throws SQLException, Exception {

		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(
				dbManager, claimNo);
		PrpLregistDto prpLregistDto = new BLPrpLregistAction()
				.findByPrimaryKey(dbManager, prpLclaimDto.getRegistNo());
		PrpCitemCarDto prpCitemCarDto = new BLPrpCitemCarAction()
				.findByPrimaryKey(dbManager, getPolicyNo(dbManager,
						prpLclaimDto.getRegistNo()), 1);
		DateTime damageStartDate = new DateTime();
		String damageStartHour = null;
		String licenseNo = "";
		if (prpLregistDto != null) {
			damageStartDate = prpLregistDto.getReportDate();
			damageStartHour = prpLregistDto.getReportHour();
			// licenseNo = prpLregistDto.getLicenseNo();
		}
		licenseNo = prpCitemCarDto.getLicenseNo();

		Date damageDate = new Date((damageStartDate.getYear() - 1900),
				(damageStartDate.getMonth() - 1), damageStartDate.getDate(),
				Integer.parseInt(damageStartHour.split(":")[0]), Integer
						.parseInt(damageStartHour.split(":")[1]));

		// System.out.println("damageDate (claim ) ==="+damageDate);

		Claim claim = new Claim();
		claim.setClaimNo(claimNo);
		claim.setRegistNo(prpLclaimDto.getRegistNo());
		claim.setPolicyNO(getPolicyNo(dbManager, prpLclaimDto.getRegistNo()));
		claim.setCaseType(Iconstants.CaseType.NORMAL);
		claim.setDamageDate(damageDate  + "");
		claim.setLicenseNo(licenseNo);
		if (prpCitemCarDto.getLicenseKindCode() == null
				|| prpCitemCarDto.getLicenseKindCode().length() == 0) {
			claim.setLicenseType("02");
		} else {
			claim.setLicenseType(prpCitemCarDto.getLicenseKindCode());
		}
		claim.setUnClaimAmount(prpLclaimDto.getSumClaim());
		claim.setThirdCarList(getThirdCarList(dbManager, claim.getRegistNo()));
		return claim;
	}

	protected CancelCase getCancelClaimCase(DBManager dbManager, String claimNo)
			throws SQLException, Exception {
		CancelCase cancelCase = new CancelCase();
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(
				dbManager, claimNo);
		// System.out.println("claimNo-===="+claimNo
		// +"R:"+prpLclaimDto.getRegistNo() +"P:"+ prpLclaimDto.getPolicyNo());
		cancelCase.setClaimNo(claimNo);
		cancelCase.setRegistNo(prpLclaimDto.getRegistNo());
		cancelCase.setPolicyNO(prpLclaimDto.getPolicyNo());
		return cancelCase;
	}

	protected CancelCase getCancelRegistCase(DBManager dbManager,
			String registNo) throws SQLException, Exception {
		CancelCase cancelCase = new CancelCase();
		List prpLclaimList = (ArrayList) new BLPrpLclaimAction()
				.findByConditions(dbManager, " registno='" + registNo
						+ "' and riskcode='0590'");
		if (prpLclaimList != null && prpLclaimList.size() > 0) {
			PrpLclaimDto prpLclaimDto = (PrpLclaimDto) prpLclaimList.get(0);
			cancelCase.setClaimNo(prpLclaimDto.getClaimNo());
		} else {
			cancelCase.setClaimNo(null);
		}
		cancelCase.setRegistNo(registNo);
		cancelCase.setPolicyNO(getPolicyNo(dbManager, registNo));
		return cancelCase;
	}

	protected EndCase getEndCase(DBManager dbManager, String claimNo)
			throws SQLException, Exception {
		EndCase endCase = new EndCase();
		AccidentInfor accidentInfor = new AccidentInfor(); // 出险信息
		String accidentDesc = ""; // 出险经过
		boolean isInsuredDuty = true; // 是否事故责任
		double sumPaid = 0d; // 赔款金额
		List prpLpersonLossList = new ArrayList();
		LossSituation lossSituationD = new LossSituation(); // 死亡伤残赔偿损失情况
		double sumLossD = 0d; // 死亡伤残损失金额
		double sumPayD = 0d; // 死亡伤残赔款金额
		LossSituation lossSituationM = new LossSituation(); // 医疗费用赔偿损失情况
		double sumLossM = 0d; // 医疗费用损失金额
		double sumPayM = 0d; // 医疗费用赔款金额
		LossSituation lossSituationP = new LossSituation(); // 财产损失赔偿损失情况
		double sumLossP = 0d; // 财产损失损失金额
		double sumPayP = 0d; // 财产损失赔款金额
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(
				dbManager, claimNo);
		String registNo = "";
		String indemnityduty = "";
		String caseType = "";
		String policyNo = "";
		String riskCode = "";
		DateTime claimDate = new DateTime();
		if (prpLclaimDto != null) {
			registNo = prpLclaimDto.getRegistNo();
			// 获取责任划分
			indemnityduty = prpLclaimDto.getIndemnityDuty();
			caseType = prpLclaimDto.getCaseType();
			policyNo = prpLclaimDto.getPolicyNo();
			// 获取险种代码
			riskCode = prpLclaimDto.getRiskCode();
			// 获取立案时间
			claimDate = prpLclaimDto.getClaimDate();
		}
		PrpLregistDto prpLregistDto = new BLPrpLregistAction()
				.findByPrimaryKey(dbManager, registNo);
		// PrpCitemCarDto prpCitemCarDto = new
		// BLPrpCitemCarAction().findByPrimaryKey(dbManager,
		// getPolicyNo(dbManager, prpLregistDto.getRegistNo()), 1);
		DateTime reportDateTemp = new DateTime();
		DateTime damageStartDate = new DateTime();
		String damageStartHour = "";
		String reportStartHour = "";
		String licenseNo = "";
		String accidentdep = "";
		String accidentPlace = "";
		if (prpLregistDto != null) {
			// 获取报案日期，报案时间
			reportDateTemp = prpLregistDto.getReportDate();
			reportStartHour = prpLregistDto.getReportHour();
			// 获取车牌号码
			// licenseNo = prpLregistDto.getLicenseNo();
			// 获取事故处理部门
			accidentdep = prpLregistDto.getHandleUnit();

			damageStartDate = prpLregistDto.getDamageStartDate();
			damageStartHour = prpLregistDto.getDamageStartHour();
			// 获取出险地点
			accidentPlace = prpLregistDto.getDamageAddress();
		}

		// 要传递的报案时间（年月日时分）
		Date reportDate = new Date((reportDateTemp.getYear() - 1900),
				(reportDateTemp.getMonth() - 1), reportDateTemp.getDate(),
				Integer.parseInt(reportStartHour.split(":")[0]), Integer
						.parseInt(reportStartHour.split(":")[1]));

		// 获取出险经过
		String conditions = " claimno='" + claimNo
				+ "' and texttype='09' order by lineno";
		List prpLltextList = (ArrayList) new BLPrpLltextAction()
				.findByConditions(dbManager, conditions);
		for (Iterator iter = prpLltextList.iterator(); iter.hasNext();) {
			PrpLltextDto prpLltextDto = (PrpLltextDto) iter.next();
			accidentDesc += prpLltextDto.getContext();
		}
		// 获取拒赔原因
		String cancelReason = "";
		if ("1".equals(caseType)) {
			conditions = " claimno='" + claimNo
					+ "' and texttype='10' order by lineno";
			prpLltextList = (ArrayList) new BLPrpLltextAction()
					.findByConditions(dbManager, conditions);
			for (Iterator iter = prpLltextList.iterator(); iter.hasNext();) {
				PrpLltextDto prpLltextDto = (PrpLltextDto) iter.next();
				cancelReason += prpLltextDto.getContext();
			}
		}

		// 获取出险日期，出险时间
		Date damageDate = new Date((damageStartDate.getYear() - 1900),
				(damageStartDate.getMonth() - 1), damageStartDate.getDate(),
				Integer.parseInt(damageStartHour.split(":")[0]), Integer
						.parseInt(damageStartHour.split(":")[1]));

		// System.out.println("damageDate (endcase ) ==="+damageDate);

		double indemnitydutyrate = 0d;
		DateTime endCaseDate = new DateTime();
		// 获取赔款金额,结案日期,责任赔偿比例
		List compensateList = (ArrayList) new BLCompensateAction()
				.findPrpLcompensateOfValidUndwrtByClaimNo(dbManager, claimNo);
		for (int i = 0; i < compensateList.size(); i++) {
			PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto) compensateList
					.get(i);
			sumPaid += prpLcompensateDto.getSumPaid();
			endCaseDate = prpLcompensateDto.getUnderWriteEndDate();
			indemnitydutyrate = ((PrpLcompensateDto) compensateList.get(0))
					.getIndemnityDutyRate() / 100;
			if (indemnitydutyrate == 0) {
				isInsuredDuty = false;
			}
		}
		// 获取死亡伤残赔偿
		String conditionsD = "feecategory='D' and policyno='"
				+ policyNo
				+ "' and compensateno in (select compensateno from prplcompensate where underwriteflag='1' or underwriteflag='3')";
		prpLpersonLossList = (ArrayList) new BLPrpLpersonLossAction()
				.findByConditions(dbManager, conditionsD);
		for (Iterator iter = prpLpersonLossList.iterator(); iter.hasNext();) {
			PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto) iter
					.next();
			sumLossD += prpLpersonLossDto.getSumLoss();
			sumPayD += prpLpersonLossDto.getSumRealPay();
		}
		lossSituationD.setRiskcodeType(Iconstants.RiskCodeType.COMPEL_THIRD);
		lossSituationD.setIndemnitydutyrate(indemnitydutyrate);
		lossSituationD.setLossType(Iconstants.LossType.DEATH_CRIPPLE);
		lossSituationD.setPolicyNo(policyNo);
		lossSituationD.setRiskcode(riskCode);
		lossSituationD.setSumLoss(sumLossD);
		lossSituationD.setSumPay(sumPayD);
		// 获取医疗费用赔偿
		String conditionsM = "feecategory='M' and policyno='"
				+ policyNo
				+ "' and compensateno in (select compensateno from prplcompensate where underwriteflag='1' or underwriteflag='3')";
		prpLpersonLossList = (ArrayList) new BLPrpLpersonLossAction()
				.findByConditions(dbManager, conditionsM);
		for (Iterator iter = prpLpersonLossList.iterator(); iter.hasNext();) {
			PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto) iter
					.next();
			sumLossM += prpLpersonLossDto.getSumLoss();
			sumPayM += prpLpersonLossDto.getSumRealPay();
		}
		lossSituationM.setRiskcodeType(Iconstants.RiskCodeType.COMPEL_THIRD);
		lossSituationM.setIndemnitydutyrate(indemnitydutyrate);
		lossSituationM.setLossType(Iconstants.LossType.MEDICAL);
		lossSituationM.setPolicyNo(policyNo);
		lossSituationM.setRiskcode(riskCode);
		lossSituationM.setSumLoss(sumLossM);
		lossSituationM.setSumPay(sumPayM);
		// 获取财产损失赔偿
		String conditionsP = "policyno='"
				+ policyNo
				+ "' and compensateno in (select compensateno from prplcompensate where underwriteflag='1' or underwriteflag='3')";
		List prpLlossList = (ArrayList) new BLPrpLlossAction()
				.findByConditions(dbManager, conditionsP);
		for (Iterator iter = prpLlossList.iterator(); iter.hasNext();) {
			PrpLlossDto prpLlossDto = (PrpLlossDto) iter.next();
			sumLossP += prpLlossDto.getSumLoss();
			sumPayP += prpLlossDto.getSumRealPay();
		}
		lossSituationP.setIndemnitydutyrate(indemnitydutyrate);
		lossSituationP.setLossType(Iconstants.LossType.PROPERTY);
		lossSituationP.setPolicyNo(policyNo);
		lossSituationP.setRiskcode(riskCode);
		lossSituationP.setRiskcodeType(Iconstants.RiskCodeType.COMPEL_THIRD);
		lossSituationP.setSumLoss(sumLossP);
		lossSituationP.setSumPay(sumPayP);
		// 获取号牌类型
		PrpCitemCarDto prpCitemCarDto = new BLPrpCitemCarAction()
				.findByPrimaryKey(dbManager, policyNo, 1);
		licenseNo = prpCitemCarDto.getLicenseNo();
		String licenseType = "";
		if (prpCitemCarDto != null)
			licenseType = prpCitemCarDto.getLicenseKindCode();

		List thirdCarLicenseNoList = getThirdCarList(dbManager, registNo);

		accidentInfor.setIndemnityDuty(indemnityduty);
		accidentInfor.setAccidentPlace(accidentPlace);
		accidentInfor.setAccidentTime(damageDate+ "");
		accidentInfor.setAccidentdep(accidentdep);
		accidentInfor.setAccidentDesc(accidentDesc);

		// 获取驾驶员信息
		String driverName = "";
		String certiType = "";
		String certiCode = "";
		PrpLdriverDto prpLdriverDto = new BLPrpLdriverFacade()
				.findByPrimaryKey(registNo, 1);
		if (prpLdriverDto != null) {
			driverName = prpLdriverDto.getDriverName();
			certiType = prpLdriverDto.getIdentifyType();
			certiCode = prpLdriverDto.getIdentifyNumber();
		} else {
			driverName = "无";
			certiType = "99";
			certiCode = "0";
		}
		// System.out.println("====certiType==============="+certiType);

		// System.out.println("policyNo:"+policyNo+"Iconstants.CaseType.NORMAL:"+Iconstants.CaseType.NORMAL+"registNo:"+registNo);
		// System.out.println("certiCode:"+certiCode+"certiType"+certiType+"claimNo:"+claimNo+"claimDate:"+claimDate);
		// System.out.println("damageDate:"+damageDate+"driverName:"+driverName+"endCaseDate:"+endCaseDate+"isInsuredDuty:"+isInsuredDuty);
		// System.out.println("licenseNo:"+licenseNo+"licenseType:"+licenseType+"reportDate:"+reportDate+"sumPaid:"+sumPaid);
		// System.out.println("accidentInfor:"+accidentInfor.getAccidentdep()+"++"+accidentInfor.getAccidentDesc()+"++"+
		// accidentInfor.getAccidentPlace()+"++"+accidentInfor.getIndemnityDuty()+"++"+accidentInfor.getAccidentTime());
		// System.out.println(lossSituationD.getIndemnitydutyrate()+"++"+lossSituationD.getLossType()+"++"+lossSituationD.getRiskcodeType()+"++"+lossSituationD.getSumLoss()+"++"+lossSituationD.getSumPay()+"++"+lossSituationD.getLossSituationDetailList());
		// System.out.println(lossSituationM.getIndemnitydutyrate()+"++"+lossSituationM.getLossType()+"++"+lossSituationM.getRiskcodeType()+"++"+lossSituationM.getSumLoss()+"++"+lossSituationM.getSumPay()+"++"+lossSituationM.getLossSituationDetailList());
		// System.out.println(lossSituationP.getIndemnitydutyrate()+"++"+lossSituationP.getLossType()+"++"+lossSituationP.getRiskcodeType()+"++"+lossSituationP.getSumLoss()+"++"+lossSituationP.getSumPay()+"++"+lossSituationP.getLossSituationDetailList());

		endCase.setAccidentInfor(accidentInfor);
		endCase.setCaseType(Iconstants.CaseType.NORMAL);
		endCase.setCertiCode(certiCode);
		endCase.setCertiType(certiType);
		endCase.setClaimNo(claimNo);
		endCase.setClaimTime(claimDate+ "");
		endCase.setDamageDate(damageDate+ "");
		endCase.setDriverName(driverName);
		endCase.setEndCaseTime(endCaseDate+ "");
		//endCase.setInsuredDuty(isInsuredDuty+ "");
		endCase.setLicenseNo(licenseNo);
		endCase.setLicenseType(licenseType); // licenseType
		endCase.setPolicyNo(policyNo);
		endCase.setPrepayreason("");
		endCase.setRefusereason(cancelReason);
		endCase.setRegistNo(registNo);
		endCase.setRegistTime(reportDate+ "");
		endCase.setSumPaid(sumPaid);
		endCase.setThirdCarList(thirdCarLicenseNoList);
		endCase.addLossSituation(lossSituationD);
		endCase.addLossSituation(lossSituationM);
		endCase.addLossSituation(lossSituationP);
		return endCase;
	}

	/**
	 * 获取三者车信息
	 * 
	 * @param dbManager
	 * @param registNo
	 * @return thirdCarList
	 * @throws SQLException
	 * @throws Exception
	 */
	private List getThirdCarList(DBManager dbManager, String registNo)
			throws SQLException, Exception {
		List thirdCarList = new ArrayList();
		Collection thirdCarCollection = new BLPrpLthirdPartyAction()
				.findByConditions(dbManager, " registno='" + registNo
						+ "' and serialno<>'1'");
		for (Iterator iter = thirdCarCollection.iterator(); iter.hasNext();) {
			PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto) iter
					.next();
			thirdCarList.add(new ThirdCar(prpLthirdPartyDto.getLicenseNo()));
		}
		return thirdCarList;
	}

	private String getClaimNo(DBManager dbManager, String registNo)
			throws Exception {
		String claimNo = "";
		BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
		List prpLclaimList = new ArrayList();
		prpLclaimList = (ArrayList) blPrpLclaimAction.findByConditions(
				dbManager, " registno='" + registNo + "' and riskcode='0590'");
		if (prpLclaimList != null && prpLclaimList.size() > 0) {
			claimNo = ((PrpLclaimDto) prpLclaimList.get(0)).getClaimNo();
		}
		return claimNo;
	}

	/**
	 * 根据报案号获得保单号
	 * 
	 * @param dbManager
	 * @param registNo
	 * @return policyNo
	 * @throws SQLException
	 * @throws Exception
	 */
	private String getPolicyNo(DBManager dbManager, String registNo)
			throws SQLException, Exception {
		String policyNo = "";
		List prpLregistRPolicyList = new ArrayList();
		BLPrpLRegistRPolicyAction blPrpLRegistRPolicyAction = new BLPrpLRegistRPolicyAction();
		prpLregistRPolicyList = (ArrayList) blPrpLRegistRPolicyAction
				.findByConditions(dbManager, " registno='" + registNo
						+ "' and policytype='3'");
		if (prpLregistRPolicyList != null)
			policyNo = ((PrpLRegistRPolicyDto) prpLregistRPolicyList.get(0))
					.getPolicyNo();
		return policyNo;
	}

	/**
	 * 保存上传信息返回的历史记录
	 */

	protected void saveClaimHistoryInfo(DBManager dbManager,
			ClaimHistoryDto claimHistory,CompelCrashDto compelCrashDto) throws SQLException, Exception {
		ArrayList aClaimList = claimHistory.getOwnClaimHistory();
		for (int i = 0; i < aClaimList.size(); i++) {
			ClaimHistoryInfor claimHistoryInfor = (ClaimHistoryInfor) aClaimList
					.get(i);
			CiClaimCrashDto ciClaimCrashDto = new CiClaimCrashDto();
			trasferClaimHistoryInfoToCiClaimCrashDto(ciClaimCrashDto,
					claimHistoryInfor);
			System.out.println("======aClaimList===="+compelCrashDto.getOwnAccidentInfor().getPolicyCode());
			ciClaimCrashDto.setPolicyNo(compelCrashDto.getOwnAccidentInfor().getPolicyCode());
			ciClaimCrashDto.setAccidentNo(claimHistory.getAccidentNo());
			ciClaimCrashDto.setActorFlag("1");
			ciClaimCrashDto.setSerialNo(i);
			CiClaimCrashInsertCommand ciClaimCrashInsertCommand = new CiClaimCrashInsertCommand(
					ciClaimCrashDto);
			ciClaimCrashInsertCommand.execute();
		}

		ArrayList bClaimList = claimHistory.getOtherClaimHistory();
		for (int i = 0; i < bClaimList.size(); i++) {
			ClaimHistoryInfor claimHistoryInfor = (ClaimHistoryInfor) bClaimList
					.get(i);
			CiClaimCrashDto ciClaimCrashDto = new CiClaimCrashDto();
			trasferClaimHistoryInfoToCiClaimCrashDto(ciClaimCrashDto,
					claimHistoryInfor);
			ciClaimCrashDto.setPolicyNo(compelCrashDto.getOtherAccidentInfor().getPolicyCode());
			ciClaimCrashDto.setAccidentNo(claimHistory.getAccidentNo());
			ciClaimCrashDto.setActorFlag("2");
			ciClaimCrashDto.setSerialNo(i);
			CiClaimCrashInsertCommand ciClaimCrashInsertCommand = new CiClaimCrashInsertCommand(
					ciClaimCrashDto);
			ciClaimCrashInsertCommand.execute();
		}

	}
	/**
	 * 获得强制保险平台需要的案后重开对象
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected  ReCase getReCase(DBManager dbManager, String claimNo)throws SQLException, Exception{
		
		ReCase reCase = new ReCase();
		
		//1.取立案信息
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(
				dbManager, claimNo);
		String policyNo = prpLclaimDto.getPolicyNo();
	    UIRecaseAction  uiRecaseAction  =new  UIRecaseAction ();
	    String conditions="claimNo ='"+claimNo+"'";
	    int maxSerialNo=0;
	    if(uiRecaseAction.findByConditions(conditions)!=null){
	       maxSerialNo =  uiRecaseAction.getMaxSerialNo(claimNo);
	    }
	    ReCaseDto   recaseDto =  new ReCaseDto();
	    recaseDto=(ReCaseDto)uiRecaseAction.findByPrimaryKey(claimNo, maxSerialNo);
		//5.设置值
	    reCase.setReOpenCause(recaseDto.getPrpLrecaseDto().getReCaseReason());
//		String reOpenHour=new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_MINUTE).toString().substring(11, 16);
//		String reOpenDate=formatDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY),(reOpenHour.split(":")[0]), 
//				(reOpenHour.split(":")[1]));
		Date reOpenDate=new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_MINUTE);
		reCase.setReOpenDate(reOpenDate);
		reCase.setClaimNo(claimNo);
		reCase.setPolicyNo(policyNo);
		reCase.setRegistNo(prpLclaimDto.getRegistNo());
		return reCase;
	}
	/**
	 * 获得强制保险平台需要的案后重开对象(buchuan)
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected  ReCase getReCase(DBManager dbManager, String claimNo,int serlalNo)throws SQLException, Exception{
		
		ReCase reCase = new ReCase();
		
		//1.取立案信息
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(
				dbManager, claimNo);
		String policyNo = prpLclaimDto.getPolicyNo();
	    UIRecaseAction  uiRecaseAction  =new  UIRecaseAction ();
	    ReCaseDto   recaseDto =  new ReCaseDto();
	    recaseDto=(ReCaseDto)uiRecaseAction.findByPrimaryKey(claimNo, serlalNo);
		//5.设置值
	    reCase.setReOpenCause(recaseDto.getPrpLrecaseDto().getReCaseReason());
//		String reOpenHour=new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_MINUTE).toString().substring(11, 16);
//		String reOpenDate=formatDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY),(reOpenHour.split(":")[0]), 
//				(reOpenHour.split(":")[1]));
		Date reOpenDate=new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_MINUTE);
		reCase.setReOpenDate(reOpenDate);
		reCase.setClaimNo(claimNo);
		reCase.setPolicyNo(policyNo);
		reCase.setRegistNo(prpLclaimDto.getRegistNo());
		return reCase;
	}
	/**
	 * 获得强制保险平台需要的赔付登记对象
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected PayRefInfo getPayRefInfo(DBManager dbManager,
			String claimNo,String payRefNo) throws SQLException, Exception {
		return new PayRefInfo();
	}
	/**
	 * 回写事故号
	 */

	protected void backWriteAccidentNo(DBManager dbManager, String ownRegist,
			String otherRegsit, String accidentNo) throws SQLException,
			Exception {
		String conditions1 = "registNo='" + ownRegist
				+ "' and relatedRegistNo='" + otherRegsit + "'";
		updateAccidentNo(conditions1, accidentNo);
		String conditions2 = "registNo='" + otherRegsit
				+ "' and relatedRegistNo='" + ownRegist + "'";
		updateAccidentNo(conditions2, accidentNo);

	}

	private void trasferClaimHistoryInfoToCiClaimCrashDto(
			CiClaimCrashDto ciClaimCrashDto, ClaimHistoryInfor claimHistoryInfor) {
		System.out.println("========guolei=="+claimHistoryInfor.getClaimCompanyCode());
		ciClaimCrashDto
				.setClaimCompany(claimHistoryInfor.getClaimCompanyCode());
		ciClaimCrashDto.setClaimDate(new DateTime(claimHistoryInfor
				.getClaimDate()));
		ciClaimCrashDto.setClaimStatus(claimHistoryInfor.getStatus());
		ciClaimCrashDto.setDamageDate(new DateTime(claimHistoryInfor
				.getAccidentTime()));
		ciClaimCrashDto.setEndCaseDate(new DateTime(claimHistoryInfor
				.getEndcaseDate()));
		ciClaimCrashDto.setReportDate(new DateTime(claimHistoryInfor
				.getReportTime()));
		ciClaimCrashDto.setSumClaim(claimHistoryInfor.getUnclaimAmount());
		ciClaimCrashDto.setSumPaid(claimHistoryInfor.getClaimAmount());
	}
	/**
	 * 获得强制保险平台需要的结案追加对象
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected  EndCaseAppend getEndCaseAppend(DBManager dbManager, String claimNo)throws SQLException, Exception{
		return null;
	}
	
		
	private void updateAccidentNo(String conditions, String accidentNo)
			throws SQLException, Exception {
		CiClaimCompelcrashFindByConditionsCommand ciClaimCompelcrashFindByConditionsCommand = new CiClaimCompelcrashFindByConditionsCommand(
				conditions);
		Collection ciClaimCompelcrashDtoCollection = (Collection) ciClaimCompelcrashFindByConditionsCommand
				.execute();
		if (ciClaimCompelcrashDtoCollection.size() > 0) {
			for (Iterator it = ciClaimCompelcrashDtoCollection.iterator(); it
					.hasNext();) {
				CiClaimCompelcrashDto ciClaimCompelcrashDto = (CiClaimCompelcrashDto) it
						.next();
				ciClaimCompelcrashDto.setAccidentNo(accidentNo);
				
				CiClaimCompelcrashUpdateCommand ciClaimCompelcrashUpdateCommand = new CiClaimCompelcrashUpdateCommand(
						ciClaimCompelcrashDto);
				ciClaimCompelcrashUpdateCommand.execute();
			}
		}

	}
	
	/**
	 * 将DateTime类型的日期转换成yyyyMMddHHmm格式的字符串
	 * @author sinosoft_guoyuan
	 * @param Date
	 * @return String
	 */
	private String FormateDate(DateTime iDate) throws Exception{
		String strDate  = "";
		
		return strDate;
	}
	public static void main(String[] args){
		DateTime test = new DateTime();
		test.setTime(System.currentTimeMillis());
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmm");
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyyMMdd HH:mm");
		Date date = new Date();
		date.setTime(test.getTime());
		try {
			System.err.println(dateFormat2.format(date));
			System.err.println("" + dateFormat2.format(dateFormat3.parse(dateFormat1.format(date) + " 03:" + "  65")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected CompensateVeric getCompensateVeric(DBManager dbManager,
			String compensateNo) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
