package com.sinosoft.claimciplatform.bl.action.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.sinosoft.bz.common.BZAppConfig;
import com.sinosoft.bz.common.RequestType;
import com.sinosoft.ciplatform.bl.action.custom.BLCIClaimPlatFormInvok;
import com.sinosoft.ciplatform.dto.custom.Accounts;
import com.sinosoft.ciplatform.dto.custom.ReturnAccountsInfo;
import com.sinosoft.ciplatform.dto.custom.ReCase;
import com.sinosoft.claim.bl.action.custom.BLCompensateAction;
import com.sinosoft.claim.bl.action.custom.BLPolicyAction;
import com.sinosoft.claim.bl.action.domain.BLPrpCitemCarAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLFirstVeriOpinionAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLRegistRPolicyAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLchargeAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcompensateAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLlossAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLltextAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpersonLossAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLprepayAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLrecaseAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLregistAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLregistTextAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLthirdPartyAction;
import com.sinosoft.claim.bl.facade.BLPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLRecoveryOrPayFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLdriverFacade;
import com.sinosoft.claim.bl.facade.BLPrpLlossFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpersonLossFacade;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto;
import com.sinosoft.claim.dto.domain.CiClaimCrashDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpLFirstVeriOpinionDto;
import com.sinosoft.claim.dto.domain.PrpLRecoveryOrPayDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLdriverDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLnodutyLossDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcharge;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLnodutyLoss;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claim.ui.model.CiClaimCompelcrashFindByConditionsCommand;
import com.sinosoft.claim.ui.model.CiClaimCompelcrashUpdateCommand;
import com.sinosoft.claim.ui.model.CiClaimCrashInsertCommand;
import com.sinosoft.claimciplatform.bl.action.domain.BLCIClaimUploadLogAction;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimPlatFormInterfaceFacade;
import com.sinosoft.claimciplatform.dto.custom.AccidentInfor;
import com.sinosoft.claimciplatform.dto.custom.CancelCase;
import com.sinosoft.claimciplatform.dto.custom.Claim;
import com.sinosoft.claimciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.claimciplatform.dto.custom.ClaimCover;
import com.sinosoft.claimciplatform.dto.custom.ClaimHistoryDto;
import com.sinosoft.claimciplatform.dto.custom.ClaimHistoryInfor;
import com.sinosoft.claimciplatform.dto.custom.CompelCrashDto;
import com.sinosoft.claimciplatform.dto.custom.CompensateVeric;
import com.sinosoft.claimciplatform.dto.custom.EndCase;
import com.sinosoft.claimciplatform.dto.custom.EndCaseAppSituation;
import com.sinosoft.claimciplatform.dto.custom.EndCaseAppend;
import com.sinosoft.claimciplatform.dto.custom.Iconstants;
import com.sinosoft.claimciplatform.dto.custom.LossSituation;
import com.sinosoft.claimciplatform.dto.custom.LossSituationDetail;
import com.sinosoft.ciplatform.dto.custom.Paydata;
import com.sinosoft.claimciplatform.dto.custom.PayRefInfo;
import com.sinosoft.claimciplatform.dto.custom.PlatFormParam;
import com.sinosoft.claimciplatform.dto.custom.RecoveryOrPay;
import com.sinosoft.claimciplatform.dto.custom.Regist;
import com.sinosoft.claimciplatform.dto.domain.CIClaimThirdCarDto;
import com.sinosoft.claimciplatform.util.CodeTransfer;
import com.sinosoft.sff.blsvr.BLPrpJpayRefRec;
import com.sinosoft.sff.schema.PrpJpayRefRecSchema;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.string.Str;

public class BLCIClaimPlatFormInterfaceActionImplGuoYuan extends
		BLCIClaimPlatFormInterfaceAction {
	/**
	 * 获得平台参数
	 * @param dbManager
	 * @param policyNo 保单号
	 * @return PlatFormParam 平台参数对象
	 */
	protected PlatFormParam getPlatFormParam(DBManager dbManager,
			String policyNo) throws SQLException, Exception {	
		PlatFormParam platFormParam = new PlatFormParam();
		BLPolicyAction blPolicyAction = new BLPolicyAction();
		BLPrpDcompanyFacade blPrpDcompanyFacade = new BLPrpDcompanyFacade();
		String strComCode = "";
		PrpCmainDto prpCmainDto = blPolicyAction.findPrpCmainDtoByPrimaryKey(dbManager, policyNo);
		strComCode = prpCmainDto.getComCode();
		//取省分机构代码
		PrpDcompanyDto prpDcompany = null;
		String comLevel = "";
		if("00".equals(strComCode.substring(0, 2))){
			while (!"2".equals(comLevel)) {
				prpDcompany = blPrpDcompanyFacade.findByPrimaryKey(strComCode);
				comLevel = prpDcompany.getComLevel();
				if (!"2".equals(comLevel)) {
					strComCode = prpDcompany.getUpperComCode();
				}
			}
		}else{
			while(!"3".equals(comLevel)){
				prpDcompany = blPrpDcompanyFacade.findByPrimaryKey(strComCode);
				comLevel = prpDcompany.getComLevel();
				if(!"3".equals(comLevel)){
					strComCode = prpDcompany.getUpperComCode();
				}			
			}
		}
		platFormParam.setComCode(strComCode);
		platFormParam.setUrl(BZAppConfig.getProperty(strComCode, "URL"));
		platFormParam.setUserName(BZAppConfig.getProperty(strComCode, "USER"));
		platFormParam.setUserPwd(BZAppConfig.getProperty(strComCode, "PASSWORD"));
		platFormParam.setUseFlag(BZAppConfig.getProperty(strComCode, "USEFLAG"));
		platFormParam.setRiskcode(BZAppConfig.getProperty(strComCode, "RISKCODE"));
		return platFormParam;
	}
	
	/**
	 * 提供获得平台参数的默认实现
	 * 若项目组平台参数获取策略不同（如从配置文件中读取或从数据库中读取），则在子类中重新覆写该方法即可。
	 * @return
	 * @throws Exception
	 */
	public PlatFormParam getPlatFormParam(String policyNo) throws Exception{	
		PlatFormParam platFormParam = new PlatFormParam();
		BLPolicyFacade blPolicyAction = new BLPolicyFacade();
		BLPrpDcompanyFacade blPrpDcompanyFacade = new BLPrpDcompanyFacade();
		String strComCode = "";
		PrpCmainDto prpCmainDto = blPolicyAction.findPrpCmainDtoByPrimaryKey( policyNo);
		strComCode = prpCmainDto.getComCode();
		//取省分机构代码
		PrpDcompanyDto prpDcompany = null;
		String comLevel = "";
		while(!"2".equals(comLevel)){
			prpDcompany = blPrpDcompanyFacade.findByPrimaryKey(strComCode);
			comLevel = prpDcompany.getComLevel();
			if(!"2".equals(comLevel)){
				strComCode = prpDcompany.getUpperComCode();
			}			
		}
		
		platFormParam.setComCode(strComCode);
		platFormParam.setUrl(BZAppConfig.getProperty(strComCode, "URL"));
		platFormParam.setUserName(BZAppConfig.getProperty(strComCode, "USER"));
		platFormParam.setUserPwd(BZAppConfig.getProperty(strComCode, "PASSWORD"));
		platFormParam.setUseFlag(BZAppConfig.getProperty(strComCode, "USEFLAG"));
		platFormParam.setRiskcode(BZAppConfig.getProperty(strComCode, "RISKCODE"));
		return platFormParam;
	}
	/**
	 * 获得单报案对象（从效率考虑不需要获得报案复合对象）
	 * @param dbManager 
	 * @param registNo 报案号
	 * @return Regist 上传平台－报案信息对象
	 */
	protected Regist getRegist(DBManager dbManager, String registNo)
			throws SQLException, Exception {
		
		//获得单报案对象（从效率考虑不需要获得报案复合对象）
		PrpLregistDto prpLregistDto = new BLPrpLregistAction()
				.findByPrimaryKey(dbManager, registNo);

		//获得保单号
		String policyNo = getPolicyNo(dbManager, registNo);
		
		//获得保单标的车对象
		PrpCitemCarDto prpCitemCarDto = new BLPrpCitemCarAction()
				.findByPrimaryKey(dbManager, policyNo, 1);

		String licenseNo = "";
		DateTime damageStartDate = null;
		String damageStartHour = null;
		DateTime reportDate = null;
		String reportHour = null;

		//出险时间（年月日时分）
		if (prpLregistDto != null) {
			damageStartDate = prpLregistDto.getDamageStartDate();
			damageStartHour = prpLregistDto.getDamageStartHour();
			reportDate = prpLregistDto.getReportDate();
			reportHour = prpLregistDto.getReportHour();
			licenseNo = prpLregistDto.getLicenseNo();
		}
		String damageDate = formatDate(damageStartDate,
				(damageStartHour.split(":")[0]), 
				(damageStartHour.split(":")[1]));
		String strReportDate = formatDate(reportDate,
				(reportHour.split(":")[0]), 
				(reportHour.split(":")[1]));
		//号牌号码
		//licenseNo = prpCitemCarDto.getLicenseNo();


		Regist regist = new Regist();
		regist.setRegistNo(registNo);
		regist.setPolicyNO(policyNo);
		regist.setLicenseNo(licenseNo);		
		regist.setDamageDate(damageDate);
		regist.setReportDate(strReportDate);
		//号牌种类代码
		regist.setLicenseType(prpCitemCarDto.getLicenseKindCode());
		//三者车信息列表
		regist.setThirdCarList(getThirdCarList(dbManager, registNo));
		//出险地点
		regist.setDamageAddress(prpLregistDto.getDamageAddress());
		//互碰自赔标志
		regist.setSelfPayFlag(CodeTransfer.SelfPayFlag.covrentPlatFormCode(prpLregistDto.getClaimType()));
		
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
		
		//车牌号码
		String licenseNo = "";
			
		//出险时间
		DateTime damageStartDate = new DateTime();
		String damageStartHour = null;
		if (prpLregistDto != null) {
			damageStartDate = prpLregistDto.getDamageStartDate();
			damageStartHour = prpLregistDto.getDamageStartHour();
			licenseNo = prpLregistDto.getLicenseNo();
		}	
		String damageDate = formatDate(damageStartDate,damageStartHour.split(":")[0],damageStartHour.split(":")[1]);
		String claimDate = new SimpleDateFormat("yyyyMMddHHmm").format(prpLclaimDto.getClaimDate());
		//案件类型
		String strCaseType = Iconstants.CaseType.NORMAL;
		if("4".equals(prpLclaimDto.getIndemnityDuty())){
			//无责赔案
			strCaseType = Iconstants.CaseType.IRRESPONSIBILITY;
		}

		Claim claim = new Claim();
		claim.setClaimNo(claimNo);
		claim.setRegistNo(prpLclaimDto.getRegistNo());
		claim.setPolicyNO(prpLclaimDto.getPolicyNo());
		claim.setCaseType(strCaseType);
		claim.setDamageDate(damageDate);
		claim.setClaimDate(claimDate);
		claim.setLicenseNo(licenseNo);
		claim.setLicenseType(prpCitemCarDto.getLicenseKindCode());
		claim.setUnClaimAmount(prpLclaimDto.getSumClaim());
		claim.setThirdCarList(getThirdCarList(dbManager, claim.getRegistNo()));
		//出险地点
		claim.setDamageAddress(prpLclaimDto.getDamageAddress());
		//互碰自赔标志
		claim.setSelfPayFlag(CodeTransfer.SelfPayFlag.covrentPlatFormCode(prpLclaimDto.getClaimType()));
		return claim;
	}

	protected CancelCase getCancelClaimCase(DBManager dbManager, String businessNo)
			throws SQLException, Exception {
		CancelCase cancelCase = new CancelCase();
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(
				dbManager, businessNo);
		if(prpLclaimDto != null){
			cancelCase.setClaimNo(businessNo);
			cancelCase.setRegistNo(prpLclaimDto.getRegistNo());
			cancelCase.setPolicyNO(prpLclaimDto.getPolicyNo());
			cancelCase.setCancelType("2");
			PrpLRegistRPolicyDto prpLRegistRPolicyDto = new BLPrpLRegistRPolicyAction()
				.findByPrimaryKey(dbManager, prpLclaimDto.getRegistNo(), prpLclaimDto.getPolicyNo());
			cancelCase.setCancelReason(prpLRegistRPolicyDto.getCancelReason());
			cancelCase.setCancelReasonName(prpLRegistRPolicyDto.getCancelReasonName());
			
			Collection prpLregistTextList = new BLPrpLltextAction()
					.findByConditions(dbManager, "texttype='10' and claimno='"
							+ cancelCase.getClaimNo() + "'");
			StringBuffer context = new StringBuffer();
			if (prpLregistTextList != null) {
				Iterator iterator = prpLregistTextList.iterator();
				while (iterator.hasNext()) {
					PrpLltextDto PrpLltextDto = (PrpLltextDto) iterator
							.next();
						context.append("  ");
						context.append(PrpLltextDto.getContext());
						context.append("\t");
				}
			}
			cancelCase.setCancelDesc(context.toString());
		}else {
			PrpLregistDto prpLregistDto = new BLPrpLregistAction().findByPrimaryKey(dbManager, businessNo);
			cancelCase.setClaimNo("");
			cancelCase.setRegistNo(prpLregistDto.getRegistNo());
			cancelCase.setCancelType("1");
			String conditions = " registno = '"+prpLregistDto.getRegistNo()+"' and riskcode='0507' and validstatus = '0' ";
			ArrayList prpLRegistRPolicyDtoList = (ArrayList)new BLPrpLRegistRPolicyAction()
				.findByConditions(dbManager, conditions);
			PrpLRegistRPolicyDto prpLRegistRPolicyDto = (PrpLRegistRPolicyDto)prpLRegistRPolicyDtoList.get(0);
			cancelCase.setCancelReason(prpLRegistRPolicyDto.getCancelReason());
			cancelCase.setCancelReasonName(prpLRegistRPolicyDto.getCancelReasonName());
			cancelCase.setPolicyNO(prpLRegistRPolicyDto.getPolicyNo());
			Collection prpLregistTextList = new BLPrpLregistTextAction()
				.findByConditions(dbManager, "texttype='2' and registno='" + cancelCase.getRegistNo() + "'");
			StringBuffer context = new StringBuffer();
			if( prpLregistTextList != null )
			{
				Iterator iterator = prpLregistTextList.iterator();
				while(iterator.hasNext()){
					PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto)iterator.next();
					if( "2".equals(prpLregistTextDto.getTextType()) ){
						context.append("  ");
						context.append(prpLregistTextDto.getContext());
						context.append("\t");
					
					}
				}
			}
			cancelCase.setCancelDesc(context.toString());
		}		
		
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
		String isInsuredDuty = "1"; // 是否事故责任
		double sumPaid = 0d; // 赔款金额
		List prpLpersonLossList = new ArrayList();
		List prpLchargeList = new ArrayList();
		List prpLnodutyLossList = new ArrayList();
		LossSituation lossSituationD = new LossSituation(); // 死亡伤残赔偿损失情况
		double sumLossD = 0d; // 死亡伤残损失金额
		double sumPayD = 0d; // 死亡伤残赔款金额
		LossSituation lossSituationM = new LossSituation(); // 医疗费用赔偿损失情况
		double sumLossM = 0d; // 医疗费用损失金额
		double sumPayM = 0d; // 医疗费用赔款金额
		LossSituation lossSituationP = new LossSituation(); // 财产损失赔偿损失情况
		double sumLossP = 0d; // 财产损失损失金额
		double sumPayP = 0d; // 财产损失赔款金额
		double nodutyPaid = 0D;//无责代赔金额
		double indemnitydutyrate = 0d;
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(
				dbManager, claimNo);
		String registNo = "";
		String indemnityduty = "";
		String caseType = "";
		String policyNo = "";
		String riskCode = "";
		String claimDate = "";
		String endCaseDate = "";
		String endCaseNo = "";
		String selfPayFlag = Iconstants.SelfPayFlag.NOTSELFPAYFLAG;
		if (prpLclaimDto != null) {
			registNo = prpLclaimDto.getRegistNo();
			// 获取责任划分
			//indemnityduty = prpLclaimDto.getIndemnityDuty();
			caseType = prpLclaimDto.getCaseType();
			policyNo = prpLclaimDto.getPolicyNo();
			// 获取险种代码
			riskCode = prpLclaimDto.getRiskCode();
			// 获取立案时间
			claimDate = formatDate(prpLclaimDto.getClaimDate());
			//结案时间
			endCaseDate = formatDate(prpLclaimDto.getEndCaseDate());
			//赔案号
			endCaseNo = prpLclaimDto.getCaseNo();
		}
		PrpLregistDto prpLregistDto = new BLPrpLregistAction()
				.findByPrimaryKey(dbManager, registNo);
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
			accidentdep = UICodeAction.getInstance().translateCodeCode("HandleUnit", prpLregistDto.getHandleUnit(), true);

			damageStartDate = prpLregistDto.getDamageStartDate();
			damageStartHour = prpLregistDto.getDamageStartHour();
			// 获取出险地点
			accidentPlace = prpLregistDto.getDamageAddress();
		}

		// 要传递的报案时间（年月日时分）
		String reportDate = formatDate(reportDateTemp,reportStartHour.split(":")[0], reportStartHour.split(":")[1]);

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
		String damageDate = formatDate(damageStartDate,damageStartHour.split(":")[0],damageStartHour.split(":")[1]);

		//有责交通死亡标志
		String accidentDeath = "0"; 
		String compensateNo = "";
		
		// 获取赔款金额,结案日期,责任赔偿比例
		List compensateList = (ArrayList) new BLCompensateAction()
				.findPrpLcompensateOfValidUndwrtByClaimNo(dbManager, claimNo);
		//结案上传是只上传第一张计算书
		for (int i = 0; i < compensateList.size(); i++) {
			PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto) compensateList.get(i);
			sumPaid += prpLcompensateDto.getSumDutyPaid();
			indemnityduty = ((PrpLcompensateDto) compensateList.get(0)).getIndemnityDuty();
			indemnitydutyrate = ((PrpLcompensateDto) compensateList.get(0))
			.getIndemnityDutyRate() / 100;
			compensateNo += "'" + prpLcompensateDto.getCompensateNo() + "',";
			//其中一个理算为互碰自赔时，全案就为互碰自赔案件
			if(Iconstants.SelfPayFlag.ISSELFPAYFLAG.equals(CodeTransfer.SelfPayFlag.covrentPlatFormCode(prpLcompensateDto.getClaimType()))){
				selfPayFlag = Iconstants.SelfPayFlag.ISSELFPAYFLAG;
			}
			if("1".equals(prpLcompensateDto.getWoundGrade()) && !"4".equals(indemnityduty)){
				accidentDeath = "1";
			}
		}
		compensateNo = compensateNo.substring(0,compensateNo.length() - 1);
		//1.获取死亡伤残赔偿
		//1.1正常死亡伤残赔偿
		String conditionsD = "feecategory='D'"
				+ " and compensateno in (" + compensateNo + ")";
		prpLpersonLossList = (ArrayList) new BLPrpLpersonLossAction()
				.findByConditions(dbManager, conditionsD);
		for (Iterator iter = prpLpersonLossList.iterator(); iter.hasNext();) {
			PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto) iter
					.next();
			
			LossSituationDetail lossSituationDetail = new LossSituationDetail();			
			lossSituationDetail.setLossType("4".equals(indemnityduty)?Iconstants.LossType.NODUTY_DEATH_CRIPPLE:Iconstants.LossType.DEATH_CRIPPLE);
			lossSituationDetail.setLossTypeDetail(CodeTransfer.PersonFeeTypeDetail.covrentPlatFormCode(prpLpersonLossDto.getLiabDetailCode()));
			if(prpLpersonLossDto.getLiabDetailCode().equals("213")){
				//死亡伤残费的其他，代码是99，财产损失、医疗费用的其他，代码是9。此处特殊处理
				lossSituationDetail.setLossTypeDetail("99");
			}
			lossSituationDetail.setSumLoss(prpLpersonLossDto.getSumLoss());
			lossSituationDetail.setSumPay(prpLpersonLossDto.getSumRealPay());
			lossSituationDetail.setIndemnitydutyrate(indemnitydutyrate);
			lossSituationD.addLossSituationDetail(lossSituationDetail);
			
			sumLossD += prpLpersonLossDto.getSumLoss();
			sumPayD += prpLpersonLossDto.getSumRealPay();
			
		}
		//1.2无保险死亡伤残代赔
		String nodutyConditionD = " paidType='noInsD' and compensateno in (" + compensateNo + ")";
		prpLnodutyLossList = (ArrayList)new DBPrpLnodutyLoss(dbManager).findByConditions(nodutyConditionD);
		for(Iterator iter = prpLnodutyLossList.iterator(); iter.hasNext();){
			PrpLnodutyLossDto prpLnodutyLossDto = (PrpLnodutyLossDto)iter.next();
			LossSituationDetail lossSituationDetail = new LossSituationDetail();			
			lossSituationDetail.setLossType("4".equals(indemnityduty)?Iconstants.LossType.NODUTY_DEATH_CRIPPLE:Iconstants.LossType.DEATH_CRIPPLE);
			lossSituationDetail.setLossTypeDetail("99");
			lossSituationDetail.setSumLoss(prpLnodutyLossDto.getVerifyPaid());
			lossSituationDetail.setSumPay(prpLnodutyLossDto.getRealPaid());
			lossSituationDetail.setIndemnitydutyrate(indemnitydutyrate);
			lossSituationD.addLossSituationDetail(lossSituationDetail);
			
			sumLossD += prpLnodutyLossDto.getVerifyPaid();
			sumPayD += prpLnodutyLossDto.getRealPaid();
		}
		//1.3死亡伤残汇总
		if(prpLpersonLossList.size() > 0 || prpLnodutyLossList.size() > 0){
			lossSituationD.setIndemnitydutyrate(indemnitydutyrate);
			lossSituationD.setLossType("4".equals(indemnityduty)?Iconstants.LossType.NODUTY_DEATH_CRIPPLE:Iconstants.LossType.DEATH_CRIPPLE);
			lossSituationD.setPolicyNo(policyNo);
			lossSituationD.setRiskcode(riskCode);
			lossSituationD.setRiskcodeType(CodeTransfer.RiskCodeType.covrentPlatFormCode(riskCode));
			lossSituationD.setSumLoss(sumLossD);
			lossSituationD.setSumPay(sumPayD);
			endCase.addLossSituation(lossSituationD);
		}
		
		//2.获取医疗费用赔偿
		//2.1获取医疗赔偿
		String conditionsM = "feecategory='M' and policyno='"
				+ policyNo
				+ "' and compensateno in (" + compensateNo + ")";
		prpLpersonLossList = (ArrayList) new BLPrpLpersonLossAction()
				.findByConditions(dbManager, conditionsM);
		for (Iterator iter = prpLpersonLossList.iterator(); iter.hasNext();) {
			PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto) iter
					.next();
			sumLossM += prpLpersonLossDto.getSumLoss();
			sumPayM += prpLpersonLossDto.getSumRealPay();
			
			LossSituationDetail lossSituationDetail = new LossSituationDetail();			
			lossSituationDetail.setLossType("4".equals(indemnityduty)?Iconstants.LossType.NODUTYMEDICAL:Iconstants.LossType.MEDICAL);
			lossSituationDetail.setLossTypeDetail(CodeTransfer.PersonFeeTypeDetail.covrentPlatFormCode(prpLpersonLossDto.getLiabDetailCode()));
			lossSituationDetail.setSumLoss(prpLpersonLossDto.getSumLoss());
			lossSituationDetail.setSumPay(prpLpersonLossDto.getSumRealPay());
			lossSituationDetail.setIndemnitydutyrate(indemnitydutyrate);
			lossSituationM.addLossSituationDetail(lossSituationDetail);
		}
		//2.2获取无保险医疗代赔
		String nodutyConditionM = " paidType='noInsM' and compensateno in (" + compensateNo + ")";
		prpLnodutyLossList = (ArrayList)new DBPrpLnodutyLoss(dbManager).findByConditions(nodutyConditionM);
		for(Iterator iter = prpLnodutyLossList.iterator(); iter.hasNext();){
			PrpLnodutyLossDto prpLnodutyLossDto = (PrpLnodutyLossDto)iter.next();
			LossSituationDetail lossSituationDetail = new LossSituationDetail();			
			lossSituationDetail.setLossType("4".equals(indemnityduty)?Iconstants.LossType.NODUTYMEDICAL:Iconstants.LossType.MEDICAL);
			lossSituationDetail.setLossTypeDetail("99");
			lossSituationDetail.setSumLoss(prpLnodutyLossDto.getVerifyPaid());
			lossSituationDetail.setSumPay(prpLnodutyLossDto.getRealPaid());
			lossSituationDetail.setIndemnitydutyrate(indemnitydutyrate);
			lossSituationM.addLossSituationDetail(lossSituationDetail);
			
			sumLossM += prpLnodutyLossDto.getVerifyPaid();
			sumPayM += prpLnodutyLossDto.getRealPaid();
		}
		//2.3医疗赔偿汇总
		if(prpLpersonLossList.size() > 0 || prpLnodutyLossList.size() > 0){
			lossSituationM.setIndemnitydutyrate(indemnitydutyrate);
			lossSituationM.setLossType("4".equals(indemnityduty)?Iconstants.LossType.NODUTYMEDICAL:Iconstants.LossType.MEDICAL);
			lossSituationM.setPolicyNo(policyNo);
			lossSituationM.setRiskcode(riskCode);
			lossSituationM.setRiskcodeType(CodeTransfer.RiskCodeType.covrentPlatFormCode(riskCode));
			lossSituationM.setSumLoss(sumLossM);
			lossSituationM.setSumPay(sumPayM);
			endCase.addLossSituation(lossSituationM);
		}
		
		//3.获取财产损失赔偿
		//3.1获取财产损失赔偿
		String conditionsP = "policyno='"
				+ policyNo
				+ "' and compensateno in (" + compensateNo + ")";
		List prpLlossList = (ArrayList) new BLPrpLlossAction()
				.findByConditions(dbManager, conditionsP);
		for (Iterator iter = prpLlossList.iterator(); iter.hasNext();) {
			PrpLlossDto prpLlossDto = (PrpLlossDto) iter.next();
			sumLossP += prpLlossDto.getSumLoss();
			sumPayP += prpLlossDto.getSumRealPay();
			
			LossSituationDetail lossSituationDetail = new LossSituationDetail();			
			lossSituationDetail.setLossType("4".equals(indemnityduty)?Iconstants.LossType.NODUTY_PROPERTY:Iconstants.LossType.PROPERTY);
			lossSituationDetail.setLossTypeDetail(Iconstants.LossTypeProp.LOSSTYPEPROP_CAR);
			lossSituationDetail.setSumLoss(prpLlossDto.getSumLoss());
			lossSituationDetail.setSumPay(prpLlossDto.getSumRealPay());
			lossSituationDetail.setIndemnitydutyrate(indemnitydutyrate);
			lossSituationP.addLossSituationDetail(lossSituationDetail);
		}
		//3.2获取计入赔款施救费
		String conditionCharge = "policyno='"
				+ policyNo
				+ "' and sumrealpay<>0"
				+ " and compensateno in (" + compensateNo + ")";
		prpLchargeList = (ArrayList) new BLPrpLchargeAction().findByConditions(
				dbManager, conditionCharge);
		for (Iterator iter = prpLchargeList.iterator(); iter.hasNext();) {
			PrpLchargeDto prpLcharge = (PrpLchargeDto) iter.next();

			sumLossP += prpLcharge.getChargeAmount();
			sumPayP += prpLcharge.getSumRealPay();

			LossSituationDetail lossSituationDetail = new LossSituationDetail();
			lossSituationDetail
					.setLossType("4".equals(indemnityduty)?Iconstants.LossType.NODUTY_PROPERTY:Iconstants.LossType.PROPERTY);
			lossSituationDetail
					.setLossTypeDetail(Iconstants.LossTypeProp.LOSSTYPEPROP_OTHER);
			lossSituationDetail.setSumLoss(prpLcharge.getChargeAmount());
			lossSituationDetail.setSumPay(prpLcharge.getSumRealPay());
			lossSituationDetail.setIndemnitydutyrate(indemnitydutyrate);
			lossSituationP.addLossSituationDetail(lossSituationDetail);
		}
		//3.3获取无保险财产代赔
		String nodutyConditionP = " paidType in('noInsP','noDuty') and compensateno in (" + compensateNo + ")";
		prpLnodutyLossList = (ArrayList)new DBPrpLnodutyLoss(dbManager).findByConditions(nodutyConditionP);
		for(Iterator iter = prpLnodutyLossList.iterator(); iter.hasNext();){
			PrpLnodutyLossDto prpLnodutyLossDto = (PrpLnodutyLossDto)iter.next();
			LossSituationDetail lossSituationDetail = new LossSituationDetail();			
			lossSituationDetail.setLossType("4".equals(indemnityduty)?Iconstants.LossType.NODUTY_PROPERTY:Iconstants.LossType.PROPERTY);
			lossSituationDetail.setLossTypeDetail(Iconstants.LossTypeProp.LOSSTYPEPROP_OTHER);
			lossSituationDetail.setSumLoss(prpLnodutyLossDto.getVerifyPaid());
			lossSituationDetail.setSumPay(prpLnodutyLossDto.getRealPaid());
			lossSituationDetail.setIndemnitydutyrate(indemnitydutyrate);
			lossSituationP.addLossSituationDetail(lossSituationDetail);
			
			sumLossP += prpLnodutyLossDto.getVerifyPaid();
			sumPayP += prpLnodutyLossDto.getRealPaid();
			if("noDuty".equals(prpLnodutyLossDto.getPaidType())){
				nodutyPaid += prpLnodutyLossDto.getRealPaid();
			}

		}
		//3.4财产赔偿汇总
		if(prpLlossList.size() > 0 || prpLchargeList.size() > 0 || prpLnodutyLossList.size() > 0){
			lossSituationP.setIndemnitydutyrate(indemnitydutyrate);
			lossSituationP.setLossType("4".equals(indemnityduty)?Iconstants.LossType.NODUTY_PROPERTY:Iconstants.LossType.PROPERTY);
			lossSituationP.setPolicyNo(policyNo);
			lossSituationP.setRiskcode(riskCode);
			lossSituationP.setRiskcodeType(CodeTransfer.RiskCodeType.covrentPlatFormCode(riskCode));
			lossSituationP.setSumLoss(sumLossP);
			lossSituationP.setSumPay(sumPayP);
			endCase.addLossSituation(lossSituationP);
		}
		
		// 获取号牌类型
		PrpCitemCarDto prpCitemCarDto = new BLPrpCitemCarAction()
				.findByPrimaryKey(dbManager, policyNo, 1);
		licenseNo = prpCitemCarDto.getLicenseNo();
		String licenseType = "";
		if (prpCitemCarDto != null)
			licenseType = prpCitemCarDto.getLicenseKindCode();

		List thirdCarLicenseNoList = getThirdCarList(dbManager, registNo);

		endCase.setIndemnityDuty(CodeTransfer.IndemnityDuty.covrentPlatFormCode(indemnityduty));
		endCase.setDamageAdress(accidentPlace);
		endCase.setDamageDate(damageDate);
		endCase.setHandleComcode(accidentdep);
		endCase.setDamageDescription(accidentDesc);

		// 获取驾驶员信息
		String driverName = "";
		String certiType = "";
		String certiCode = "";
		String strDriverWhere = " registNo = '" + registNo + "'";
		Collection driverCollection = new BLPrpLdriverFacade()
				.findByConditions(strDriverWhere);
		
		PrpLdriverDto prpLdriverDto = null;
		if(driverCollection.size() > 0){
			prpLdriverDto = (PrpLdriverDto)driverCollection.iterator().next();
		}
		if (prpLdriverDto != null) {
			driverName = prpLdriverDto.getDriverName();
			certiType = CodeTransfer.CertiType.covrentPlatFormCode(prpLdriverDto.getIdentifyType());
			certiCode = prpLdriverDto.getIdentifyNumber();
		} else {
			driverName = "无";
			certiType = "99";
			certiCode = "0";
		}
		//取案件类型
		String strCaseType = Iconstants.CaseType.NORMAL;
		if("4".equals(indemnityduty)){
			//无责赔案
			strCaseType = Iconstants.CaseType.IRRESPONSIBILITY;
		}else{
			BLPrpLprepayAction blPrpLprepayAction = new BLPrpLprepayAction();
			String strPrePayWhere = " underwriteflag In ('1','3') " +
					"And casetype='8' " +
					"And  claimno='" + claimNo + "'";
			if(blPrpLprepayAction.findByConditions(dbManager, strPrePayWhere).size() > 0){
				strCaseType = Iconstants.CaseType.PRE_PAY;
			}
		}
		endCase.setNodutyPaid(nodutyPaid);
		endCase.setEndcaseNo(endCaseNo);
		endCase.setAccidentDeath(accidentDeath);
		endCase.setCaseType(strCaseType);
		endCase.setCertiCode(certiCode);
		endCase.setCertiType(certiType);
		endCase.setClaimNo(claimNo);
		endCase.setClaimTime(claimDate);
		endCase.setDriverName(driverName);
		endCase.setEndCaseTime(endCaseDate);
		endCase.setIsInsuredDuty(isInsuredDuty);
		endCase.setLicenseNo(licenseNo);
		endCase.setLicenseType(licenseType); // licenseType
		endCase.setPolicyNo(policyNo);
		endCase.setPrepayreason("");
		endCase.setRefusereason(cancelReason);
		endCase.setRegistNo(registNo);
		endCase.setRegistTime(reportDate);
		endCase.setSumPaid(sumPaid);
		endCase.setSelfPayFlag(selfPayFlag);
		endCase.setThirdCarList(thirdCarLicenseNoList);
		return endCase;
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
		PayRefInfo payRefInfo = new PayRefInfo();
		ResultSet rs = null;
		//取上传序号
		String serialNo = null;
		String strSql = " Select Max(uploadSerialNo) From (							       "+
			" select uploadSerialNo from prplcompensate where claimno = '" + claimNo + "'  "+
			" Union All                                                                    "+
			" select uploadSerialNo from prplprepay where claimno = '" + claimNo + "'      "+
			" )                                                                            ";
		rs = dbManager.executeQuery(strSql);
		if(rs.next()){
			serialNo = (rs.getInt(1) + 1) + "";
		}
		//取实付金额、实付时间
		DateTime payRefdate = new DateTime();
		Paydata payData = null;
		List<Paydata> payDataList = new ArrayList<Paydata>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm");
		double payRefFee = 0D;
		//String payType = "1";
		String compensateNos = "";
		String preCompensateNos = "";
		strSql ="Select rec.certino,rec.payrefreason,cl.endcasedate as endcasedate,      "+
				"Sum(rec.payreffee),lr.recoverycode                                      "+
				" From prplclaim cl, prpjpayrefrec rec, PrpLRecoveryOrPay lr             "+
				"Where rec.claimno = cl.claimno                                          "+
				"  And lr.compensateno (+) = rec.certino                                 "+
				"  And lr.serialno(+) = rec.recoveryserialno                             "+
//				"  And (substr(rec.flag, 1, 1) not in ('1', '2') Or rec.flag is null)    "+
				"  And rec.payrefreason In ('P50', 'P60', 'P97', 'Z03','P63')                  "+
				//"  And rec.payrefno = '" + payRefNo + "'                                 "+
				"  And cl.claimno = '" + claimNo + "'                                    "+
				"Group By rec.certino, rec.payrefreason, cl.endcasedate, lr.recoverycode ";
			
		rs = dbManager.executeQuery(strSql);
		while(rs.next()){
			payRefFee += rs.getDouble(4);
			
			if(payRefdate.isEmpty()){
				//预赔从prplprepay表取实付时间
				if("P50".equals(rs.getString(2))){
					BLPrpLprepayAction blPrpLprepayAction = new BLPrpLprepayAction();
					PrpLprepayDto prpLprepayDto = blPrpLprepayAction.findByPrimaryKey(dbManager, rs.getString(1));
					payRefdate = prpLprepayDto.getPayRefDate();
				}else{
				//实赔从prplcompensate表取实付时间
					BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
					PrpLcompensateDto prpLcompensateDto = blPrpLcompensateAction.findByPrimaryKey(dbManager, rs.getString(1));
					payRefdate = prpLcompensateDto.getPayrefDate();
				}
			}
			if("P60".equals(rs.getString(2))){
				compensateNos += "'" + rs.getString(1) + "',";
			}else{
				preCompensateNos += "'" + rs.getString(1) + "',";
			}
			
			payData = new Paydata();
			payData.setClaimAmount(rs.getDouble(4));
			payData.setRecoveryCode(rs.getString(5)==null?"":rs.getString(5));
			payDataList.add(payData);
			
		}
		/**
		 * 赔付登记待修改
		 * 存在精度问题可能提示赔款超过14位
		 */
		payRefFee=Str.round(payRefFee,2);
		/**赔偿支付时间*/
		for(Iterator itr = payDataList.iterator();itr.hasNext();){
			((Paydata)itr.next()).setPayDate(payRefdate);
		}
		/**格式化计算书号和预赔计算书号*/
		if(compensateNos.length() > 1){
			compensateNos = compensateNos.substring(0, compensateNos.length() - 1);
		}
		if(preCompensateNos.length() > 1){
			preCompensateNos = preCompensateNos.substring(0, preCompensateNos.length() - 1);
		}
		/**赔款支付账户信息*/
		String bankName = "";
		String accountName = "";
		strSql = "select c.bankname,a.accountname from accbankcode c,accbankaccount a,PrpJpayRefMain m,PrpJpayRefDetail d " +
				"where m.payrefno = d.payrefno " +
				"and d.bankcode = c.bankcode " +
				"and a.bankcode = d.bankcode " +
				"and m.payrefunit = a.centercode " +
				"and a.accountcode = d.accountno " +
				"and d.payrefno='"+ payRefNo +"'";
		rs = dbManager.executeQuery(strSql);
		if(rs.next()){
			bankName = rs.getString(1);
			//accountName = rs.getString(2);/**该字段超出平台规定的30字节，由于本地数据库中该字段没有规律截取，故暂且不上传平台*/
		}
		if(rs!=null){
			rs.close();
		}
		/**
		 * 赔付登记待修改
		 * 此处存在负数赔案没有支付信息
		 */
		//增加收款明细列表信息
		List<Paydata> payDataList1 = new ArrayList<Paydata>();
		double claimAmount = 0D;
		DateTime paydate = new DateTime(); 
		String queryPayment = "select bankaccount,banktype,receiverfullname,certiftype,certifno,payamount, paydate, inputdate from prplpay " +
		  "where " +
				" prplpay.claimno = '"+claimNo+"'" +
				"and prplpay.paymenttype in ('P50', 'P60', 'P97', 'Z03','P63')";
		rs = dbManager.executeQuery(queryPayment);
		while(rs.next()){
			payData = new Paydata();
			payData.setRBankAcountName(rs.getString(3));
			payData.setRBankCentiType(rs.getString(4));
			payData.setRBankCenticode(rs.getString(5));
			/**
			 * 因为存在证件号码为空的数据（支付录入没有复现问题）
			 * 所以在这里处理下
			 */
			if(null==payData.getRBankCenticode() || "".equals(payData.getRBankCenticode())
				||null==payData.getRBankCentiType() || "".equals(payData.getRBankCentiType())	){
				payData.setRBankCenticode("0");
				payData.setRBankCentiType("99");
			}
			payData.setClaimAmount(rs.getDouble(6));
			payData.setPayDate(rs.getDate(7));
			if("".equals(payData.getPayDate()) || payData.getPayDate()==null){
				payData.setPayDate(rs.getDate(8));
			}
			payDataList1.add(payData);
		}
		
		/**
		 * 增加负数赔案支付信息（预赔没有负数所以在这里不查询P50）
		 * 1、根据立案号取实收实付表取负数信息，
		 * 2、取得负数的理算书号查询是否录入了负数的支付信息
		 * 3、根据负数的支付编号查询是否是正负合并录入
		 */
		BLPrpJpayRefRec blPrpJpayRefRec = new BLPrpJpayRefRec();
		String strRefRec =  " claimno='"+claimNo+"' AND payreffee<0  and payrefreason in ( 'P60', 'P97', 'Z03','P63') and substr(payrefstate,1,1)='1' and payrefdate is not null "
		+" and exists (select 1 from prplcompensate  where prplcompensate.compensateno=prpjpayrefrec.certino and prplcompensate.claimno=prpjpayrefrec.claimno and prplcompensate.sumpaid<0) ";
		blPrpJpayRefRec.query(strRefRec);
		//遍历负数信息
		for(int i =0;i<blPrpJpayRefRec.getSize();i++){
			PrpJpayRefRecSchema prpJpayRefRecSchema = blPrpJpayRefRec.getArr(i);
			//通过理算书和立案号查询正负合并信息
			BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
			String strPaymain=" paymentno in ( select serialno from prplpay where claimno='"+prpJpayRefRecSchema.getClaimNo()+"' and compensateno='"+prpJpayRefRecSchema.getCertiNo()+"' and  paymenttype='"+prpJpayRefRecSchema.getPayRefReason()+"' ) and payamount=0 ";
			Collection collection = blPrpLpaymainFacade.findByConditions(strPaymain);
			if(collection!=null && collection.size()>0){
				blPrpJpayRefRec.remove(i);
				i--;
			}
		}
		/**
		 * 剔除正负合并后如果存在正数支付信息则拷贝正数的收款人名称、证件类型、证件号码
		 * 若没有正数支付信息则写死
		 */
		for(int i =0;i<blPrpJpayRefRec.getSize();i++){
			PrpJpayRefRecSchema prpJpayRefRecSchema = blPrpJpayRefRec.getArr(i);
			if(payDataList1.size()>0){
				Paydata payDataPlus=payDataList1.get(0);
				payData = new Paydata();
				payData.setRBankAcountName(payDataPlus.getRBankAcountName());
				payData.setRBankCentiType(payDataPlus.getRBankCentiType());
				payData.setRBankCenticode(payDataPlus.getRBankCenticode());
				payData.setClaimAmount(Double.parseDouble(prpJpayRefRecSchema.getPayRefFee()));
				if(prpJpayRefRecSchema.getPayRefDatetime()==null || "".equals(prpJpayRefRecSchema.getPayRefDatetime()) || prpJpayRefRecSchema.getPayRefDatetime().length()<19){
					payData.setPayDate(new SimpleDateFormat("yyyy-MM-dd").parse(prpJpayRefRecSchema.getPayRefDate()));
				}else{
					payData.setPayDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(prpJpayRefRecSchema.getPayRefDatetime()));
				}
				payDataList1.add(payData);
			}else{
				payData = new Paydata();
				payData.setRBankAcountName(prpJpayRefRecSchema.getInsuredName());
				payData.setRBankCentiType("99");
				payData.setRBankCenticode("0");
				payData.setClaimAmount(Double.parseDouble(prpJpayRefRecSchema.getPayRefFee()));
				if(prpJpayRefRecSchema.getPayRefDatetime()==null || "".equals(prpJpayRefRecSchema.getPayRefDatetime()) || prpJpayRefRecSchema.getPayRefDatetime().length()<19){
					payData.setPayDate(new SimpleDateFormat("yyyy-MM-dd").parse(prpJpayRefRecSchema.getPayRefDate()));
				}else{
					payData.setPayDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(prpJpayRefRecSchema.getPayRefDatetime()));
				}
				payDataList1.add(payData);
			}
			
		}
		
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(
				dbManager, claimNo);
		payRefInfo.setPolicyNO(prpLclaimDto.getPolicyNo());
		payRefInfo.setClaimNo(claimNo);
		payRefInfo.setRegistNo(prpLclaimDto.getRegistNo());
		payRefInfo.setPayAmount(payRefFee);
		payRefInfo.setBankName(bankName);
		payRefInfo.setAccountName(accountName);
		payRefInfo.setPayDataList(payDataList1);
		
		payRefInfo.setCompensateNos(compensateNos);
		payRefInfo.setPreCompensateNos(preCompensateNos);
		payRefInfo.setSerialNo(serialNo);
		
		return payRefInfo;
	}
	
	
	@Override
	/**
	 * 
	 * 获得强制保险理算核赔信息
	 */
	protected  CompensateVeric getCompensateVeric(DBManager dbManager,
			String compensateNo) throws SQLException, Exception {
		
		ResultSet rs = null;
		CompensateVeric compensateVeric = null;
		CompensateVeric compensateVeric1 = new CompensateVeric();
		ArrayList compensateVericList = new ArrayList();
		PrpLcompensateDto prpLcompensateDto1 = null;
		BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
		BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
		PrpLcompensateDto prpLcompensateDto = blPrpLcompensateAction.findByPrimaryKey(dbManager,compensateNo);
		PrpLclaimDto prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(prpLcompensateDto.getClaimNo());
		String conditions = " claimNo = '" + prpLclaimDto.getClaimNo() +"' ";
		ArrayList prpLcompensateDtoList = (ArrayList)blPrpLcompensateAction.findByConditions(dbManager, conditions);
		compensateVeric1.setRegistNo(prpLclaimDto.getRegistNo());
		compensateVeric1.setClaimType("2".equals(prpLclaimDto.getClaimType())?"1":"0");
		compensateVeric1.setClaimNo(prpLcompensateDto.getClaimNo());
		compensateVeric1.setPolicyNo(prpLcompensateDto.getPolicyNo());
		compensateVeric1.setCompensateNo(compensateNo);
		//是否涉诉 1是0否
		String isInvolving = "";
		String conditionsF = " registNo='"+prpLclaimDto.getRegistNo()+"' and nodetype='compp' and suggestiontype = '3'";
		ArrayList<PrpLFirstVeriOpinionDto> firstVeriOpinionList = (ArrayList)new BLPrpLFirstVeriOpinionAction().findByConditions(dbManager, conditionsF);
		if(firstVeriOpinionList!=null && firstVeriOpinionList.size()>0){
			isInvolving = "1";
		}else{
			isInvolving = "0";
		}
		compensateVeric1.setIsInvolving(isInvolving);
		if(prpLcompensateDtoList.size() > 0){	
			for(int index1 = 0;index1 < prpLcompensateDtoList.size();index1++){
				compensateVeric = new CompensateVeric();
				prpLcompensateDto1 = (PrpLcompensateDto)prpLcompensateDtoList.get(index1);
				compensateVeric.setCompensateNo(prpLcompensateDto1.getCompensateNo());
				compensateVeric.setClaimNo(prpLcompensateDto1.getClaimNo());
				compensateVeric.setPolicyNo(prpLcompensateDto1.getPolicyNo());
				compensateVeric.setRegistNo(prpLclaimDto.getRegistNo());
				compensateVeric.setClaimType("2".equals(prpLclaimDto.getClaimType())?"1":"0");
				compensateNo = prpLcompensateDto1.getCompensateNo();
				String handleText = "";
				String strSql = " Select n.handletext "+
								" from UwNotion n "+
								" Where n.flowid = (select distinct g.flowid "+
								" from Wflog g "+
									" where  g.businessNo = '"+compensateNo+"') "+
									" and n.logno = "+
									"	(Select max(n.logno) "+
									"	from UwNotion n "+
									"	Where n.flowid = "+
									"		(select distinct g.flowid "+
									"				from Wflog g "+
									"				where g.businessNo = '"+compensateNo+"')) ";
				rs = dbManager.executeQuery(strSql);
				while(rs.next()){
					handleText += rs.getString(1);
				}
				rs.close();
				compensateVeric.setUnderWriteDesc(handleText);
				compensateVeric.setSumPaid(prpLcompensateDto1.getSumDutyPaid());
				compensateVeric.setOtherFee(String.valueOf(prpLcompensateDto1.getSumNoDutyFee()));
				compensateVeric.setUnderWriteEnd(new SimpleDateFormat("yyyyMMddHHmm").format(prpLcompensateDto1.getUnderWriteEndDate()));
				ArrayList<ClaimCover> claimCoverList = new ArrayList();
				ArrayList<RecoveryOrPay> recoveryOrPayList = new ArrayList();
				ClaimCover claimCover = null;
				RecoveryOrPay recoveryOrPay = null;
				BLPrpLRecoveryOrPayFacade blPrpLRecoveryOrPayFacade = new BLPrpLRecoveryOrPayFacade();
				conditions = " compensateNo = '"+compensateNo+"' ";
				ArrayList<PrpLRecoveryOrPayDto> prpLRecoveryOrPayList = (ArrayList)blPrpLRecoveryOrPayFacade.findByConditions(conditions);
				PrpLRecoveryOrPayDto prpLRecoveryOrPayDto = null;
				double claimCoverAmountProp = 0.0;
				boolean isTrue = false;
				if("001".equals(compensateNo.substring(compensateNo.lastIndexOf("-")+1, compensateNo.length())) && prpLcompensateDtoList.size() == 1){
					String messageException = "";
					ArrayList recoveryCodeList = checkRecoveryCode(getClaimCode(dbManager, compensateVeric.getRegistNo(), compensateVeric.getClaimNo()),prpLclaimDto.getRegistNo());
					for(int i=0;i<recoveryCodeList.size();i++){
						Accounts accountsDto =  (Accounts)recoveryCodeList.get(i);
						boolean isFalse = false;
						for(int j=0;j<prpLRecoveryOrPayList.size();j++){
							prpLRecoveryOrPayDto = prpLRecoveryOrPayList.get(i);
							if(accountsDto.getAccountsNo().equals(prpLRecoveryOrPayDto.getRecoveryCode())){
								isFalse = true;
								break;
							}
						}
						if(!isFalse){
							messageException += "没有录入清算码"+accountsDto.getAccountsNo()+"的清付信息,请退回理算重新录入！\n";
						}
					}
					if(!"".equals(messageException)){
						throw new Exception(messageException);
					}
				}
				//代为案件
				if(prpLRecoveryOrPayList.size()>0){
					//清付信息,自付信息
					for(int i = 0;i < prpLRecoveryOrPayList.size();i++){
						prpLRecoveryOrPayDto = prpLRecoveryOrPayList.get(i);
						if("2".equals(prpLRecoveryOrPayDto.getRecoveryOrPayFlag())){
							recoveryOrPay = new RecoveryOrPay();
							claimCoverAmountProp += prpLRecoveryOrPayDto.getRecoveryOrPayAmount();
							recoveryOrPay.setSerialNo(prpLRecoveryOrPayDto.getSerialNo());
							recoveryOrPay.setRecoveryOrPayFlag(prpLRecoveryOrPayDto.getRecoveryOrPayFlag());
							recoveryOrPay.setRecoveryOrPayType(prpLRecoveryOrPayDto.getRecoveryOrPayType());
							recoveryOrPay.setRecoveryOrPayMan(prpLRecoveryOrPayDto.getRecoveryOrPayMan());
							recoveryOrPay.setRecoveryCode(prpLRecoveryOrPayDto.getRecoveryCode());
							recoveryOrPay.setRecoveryOrPayAmount(prpLRecoveryOrPayDto.getRecoveryOrPayAmount());
							recoveryOrPay.setRecoveryRemark(prpLRecoveryOrPayDto.getRecoveryRemark());
							recoveryOrPayList.add(recoveryOrPay);
							isTrue = true;
						}
					}
					if(isTrue){
						claimCover = new ClaimCover();
						claimCover.setRecoveryOrPayFlag("2");
						claimCover.setCoverageCode(("0507".equals(prpLcompensateDto1.getRiskCode())||"0597".equals(prpLcompensateDto1.getRiskCode()))?"100":prpLcompensateDto1.getRiskCode());
						claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
						claimCover.setLossFeeType("3");
						claimCover.setClaimAmount(Double.parseDouble(new DecimalFormat("0.00").format(claimCoverAmountProp)));
						claimCoverList.add(claimCover);
					}
		
				}
				//自付信息
				//财产损失
				BLPrpLlossFacade blPrpLlossFacade = new BLPrpLlossFacade();
				PrpLlossDto prpLlossDto = null;
				double sunRealPaid = 0.0;
				conditions = " compensateNo = '"+compensateNo+"' and kindCode<>'M' ";
				ArrayList<PrpLlossDto> prpLlossDtoList = (ArrayList)blPrpLlossFacade.findByConditions(conditions);
				if(prpLlossDtoList.size()>0){
					for(int i = 0;i < prpLlossDtoList.size();i++){
						prpLlossDto = prpLlossDtoList.get(i);
						sunRealPaid += prpLlossDto.getSumAllRealpay();
					}
					claimCover = new ClaimCover();
					claimCover.setRecoveryOrPayFlag("3");
					claimCover.setCoverageCode(("0507".equals(prpLcompensateDto1.getRiskCode())||"0597".equals(prpLcompensateDto1.getRiskCode()))?"100":prpLcompensateDto1.getRiskCode());
					claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
					claimCover.setLossFeeType("3");
					claimCover.setClaimAmount(Double.parseDouble(new DecimalFormat("0.00").format(sunRealPaid-claimCoverAmountProp)));
					claimCoverList.add(claimCover);
				}
				
				//死亡伤残
				BLPrpLpersonLossFacade blPersonLossFacade = new BLPrpLpersonLossFacade();
				PrpLpersonLossDto prpLpersonLossDto = null;
				sunRealPaid = 0.0; 
				conditions = " compensateNo = '"+compensateNo+"' and feecategory = 'D' ";
				ArrayList<PrpLpersonLossDto> prpLpersonLossDtoList = (ArrayList)blPersonLossFacade.findByConditions(conditions);
				if(prpLpersonLossDtoList.size()>0){
					for(int i = 0; i < prpLpersonLossDtoList.size();i++){
						prpLpersonLossDto = prpLpersonLossDtoList.get(i);
						sunRealPaid += prpLpersonLossDto.getSumAllRealPay();
					}
					claimCover = new ClaimCover();
					claimCover.setRecoveryOrPayFlag("3");
					claimCover.setCoverageCode(("0507".equals(prpLcompensateDto1.getRiskCode())||"0597".equals(prpLcompensateDto1.getRiskCode()))?"100":prpLcompensateDto1.getRiskCode());
					claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
					claimCover.setLossFeeType("1");
					claimCover.setClaimAmount(Double.parseDouble(new DecimalFormat("0.00").format(sunRealPaid)));
					claimCoverList.add(claimCover);
				}
				//医疗费用
				sunRealPaid = 0.0; 
				conditions = " compensateNo = '"+compensateNo+"' and feecategory = 'M' ";
				prpLpersonLossDtoList = (ArrayList)blPersonLossFacade.findByConditions(conditions);
				if(prpLpersonLossDtoList.size()>0){
					for(int i = 0; i < prpLpersonLossDtoList.size();i++){
						prpLpersonLossDto = prpLpersonLossDtoList.get(i);
						sunRealPaid += prpLpersonLossDto.getSumAllRealPay();
					}
					claimCover = new ClaimCover();
					claimCover.setRecoveryOrPayFlag("3");
					claimCover.setCoverageCode(("0507".equals(prpLcompensateDto1.getRiskCode())||"0597".equals(prpLcompensateDto1.getRiskCode()))?"100":prpLcompensateDto1.getRiskCode());
					claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
					claimCover.setLossFeeType("2");
					claimCover.setClaimAmount(Double.parseDouble(new DecimalFormat("0.00").format(sunRealPaid)));
					claimCoverList.add(claimCover);
				}
				//无责代赔
				sunRealPaid = 0.0;
				String nodutyConditionP = " compensateNo = '"+compensateNo+"' ";
				ArrayList<PrpLnodutyLossDto> prpLnodutyLossList = (ArrayList)new DBPrpLnodutyLoss(dbManager).findByConditions(nodutyConditionP);
				PrpLnodutyLossDto prpLnodutyLossDto = null;
				if(prpLnodutyLossList.size()>0){
					for(int i = 0;i < prpLnodutyLossList.size();i++){
						prpLnodutyLossDto = prpLnodutyLossList.get(i);
						sunRealPaid += prpLnodutyLossDto.getRealPaid();
					}
					claimCover = new ClaimCover();
					claimCover.setRecoveryOrPayFlag("3");
					claimCover.setCoverageCode(("0507".equals(prpLcompensateDto1.getRiskCode())||"0597".equals(prpLcompensateDto1.getRiskCode()))?"100":prpLcompensateDto1.getRiskCode());
					claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
					claimCover.setLossFeeType("7");
					claimCover.setClaimAmount(Double.parseDouble(new DecimalFormat("0.00").format(sunRealPaid)));
					claimCoverList.add(claimCover);
				}
				//费用
				/*sunRealPaid = 0.0;
				nodutyConditionP = " compensateNo = '"+compensateNo+"' ";
				ArrayList<PrpLchargeDto> PrpLchargeDtoList = (ArrayList)new DBPrpLcharge(dbManager).findByConditions(nodutyConditionP);
				PrpLchargeDto prpLchargeDto = null;
				if(PrpLchargeDtoList.size()>0){
					for(int i = 0;i < PrpLchargeDtoList.size();i++){
						prpLchargeDto = PrpLchargeDtoList.get(i);
						sunRealPaid += prpLchargeDto.getChargeAmount();
					}
					claimCover = new ClaimCover();
					claimCover.setRecoveryOrPayFlag("3");
					claimCover.setCoverageCode(("0507".equals(prpLcompensateDto1.getRiskCode())||"0597".equals(prpLcompensateDto1.getRiskCode()))?"100":prpLcompensateDto1.getRiskCode());
					claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
					claimCover.setLossFeeType("3");
					claimCover.setClaimAmount(sunRealPaid);
					claimCoverList.add(claimCover);
				}*/
				if(claimCoverList == null || claimCoverList.size() == 0){
					claimCover = new ClaimCover();
					claimCover.setRecoveryOrPayFlag("3");
					claimCover.setCoverageCode(("0507".equals(prpLcompensateDto1.getRiskCode())||"0597".equals(prpLcompensateDto1.getRiskCode()))?"100":prpLcompensateDto1.getRiskCode());
					claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
					claimCover.setLossFeeType("3");
					claimCover.setClaimAmount(0.00);
					claimCoverList.add(claimCover);
				}
				compensateVeric.setClaimCoverList(claimCoverList);	
				compensateVeric.setRecoveryOrPayList(recoveryOrPayList);
				compensateVericList.add(compensateVeric);
			}
			compensateVeric1.setCompensateVericList(compensateVericList);
		}
		return compensateVeric1;
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
		
		BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
		EndCaseAppend endCaseAppend = new EndCaseAppend();
		
		//1.取立案信息
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(
				dbManager, claimNo);
		DateTime appendDate = prpLclaimDto.getEndCaseDate();
		String policyNo = prpLclaimDto.getPolicyNo();
		
		//2.取重开赔案对应的计算书号
		//取计算书规则：重开赔案且已结案的次数与上传日志中成功上传结案追加的次数相比较
		//如前者大于后者，则需要上传结案追加，且追加的计算书序号是上传次数加2,追加时间为该计算书核赔通过后的结案时间。
		//如两者相等，则无须上传，如前者小于后者，则说明数据有异常。
		String strRecaseCondition = "closecasedate Is Not Null " +
									"And claimno='" + claimNo + "' ";
		
		String strUploadCondition = "businessno='" + claimNo + "' " +
									"And uploadtype='" + RequestType.ENDCASE_APPEND + "' And flag='1'";

		BLPrpLrecaseAction blPrpLrecaseAction = new BLPrpLrecaseAction();
		int recaseCount = blPrpLrecaseAction.getCount(dbManager, strRecaseCondition);
		BLCIClaimUploadLogAction blCIClaimUploadLogAction = new BLCIClaimUploadLogAction();
		int uploadCount = blCIClaimUploadLogAction.getCount(dbManager, strUploadCondition);
		String compensateNo = "";
		if(recaseCount > uploadCount){
			//计算书序列号＝上传次数＋2;
			String compensateSerialNo = ("00"+(uploadCount + 2));
			compensateSerialNo = compensateSerialNo.substring(compensateSerialNo.length()-3);
			//拼计算书号
			compensateNo = "6" + claimNo.substring(1) + "-" + compensateSerialNo;
		}else if(recaseCount == uploadCount){
			throw new ClaimCiPlatFormException("该案件已追加完毕,立案号："+ claimNo );
		}else{
			throw new ClaimCiPlatFormException("结案追加次数大于重开赔案次数,立案号："+ claimNo );
		}
		//取结案时间
		strRecaseCondition = "serialno= " + (uploadCount + 1) + " ";
		Collection recaseCollection = new BLPrpLrecaseAction()
				.findByConditions(dbManager, strRecaseCondition);
		if (recaseCollection.size() > 0) {
			appendDate = ((PrpLrecaseDto) recaseCollection.iterator().next())
					.getCloseCaseDate();
		}
		String accidentDeath = "0";//是否发生有责死亡交通事故
		String compensateCondition = " claimno = '" + claimNo + "' " +
									 " and compensateNo= '" + compensateNo + "' " +
									 " and underwriteflag In ('1','3')";
		Collection prpLcompensateCollection  = blPrpLcompensateFacade.findByConditions(compensateCondition);
		if(prpLcompensateCollection.size() == 0){
			throw new ClaimCiPlatFormException("追加的计算书不存在,计算书号："+compensateNo+"，立案号："+ claimNo ); 
		}
		String indemnityduty = "";
		for(Iterator iter = prpLcompensateCollection.iterator();iter.hasNext();){
			prpLcompensateDto = (PrpLcompensateDto)iter.next();
			indemnityduty = prpLcompensateDto.getIndemnityDuty();
			if("1".equals(prpLcompensateDto.getWoundGrade()) && !"4".equals(indemnityduty)){
				accidentDeath = "1";
			}
		}
		
		//3.取计算书数据
		List prpLpersonLossList = new ArrayList();
		List prpLnodutyLossList = new ArrayList();
		List prpLchargeList = new ArrayList();
		EndCaseAppSituation lossSituationD = new EndCaseAppSituation(); // 死亡伤残赔偿损失情况
		double sumPayD = 0d; // 死亡伤残赔款金额
		EndCaseAppSituation lossSituationM = new EndCaseAppSituation(); // 医疗费用赔偿损失情况
		double sumPayM = 0d; // 医疗费用赔款金额
		EndCaseAppSituation lossSituationP = new EndCaseAppSituation(); // 财产损失赔偿损失情况
		double sumPayP = 0d; // 财产损失赔款金额
		compensateNo = "'" + compensateNo + "'";
		//3.1获取死亡伤残赔偿
		String conditionsD = "feecategory='D'"
						   + " and compensateno in (" + compensateNo + ")";
		prpLpersonLossList = (ArrayList) new BLPrpLpersonLossAction()
				.findByConditions(dbManager, conditionsD);
		for (Iterator iter = prpLpersonLossList.iterator(); iter.hasNext();) {
			PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto) iter
					.next();			
			sumPayD += prpLpersonLossDto.getSumRealPay();
		}
		//无保险死亡伤残代赔
		String nodutyConditionD = " paidType='noInsD' and compensateno in (" + compensateNo + ")";
		prpLnodutyLossList = (ArrayList)new DBPrpLnodutyLoss(dbManager).findByConditions(nodutyConditionD);
		for(Iterator iter = prpLnodutyLossList.iterator(); iter.hasNext();){
			PrpLnodutyLossDto prpLnodutyLossDto = (PrpLnodutyLossDto)iter.next();
			sumPayD += prpLnodutyLossDto.getRealPaid();
		}
		if(prpLpersonLossList.size() > 0 || prpLnodutyLossList.size() > 0){
			lossSituationD.setLossType("4".equals(indemnityduty)?Iconstants.LossType.NODUTY_DEATH_CRIPPLE:Iconstants.LossType.DEATH_CRIPPLE);
			lossSituationD.setAppPaySum(sumPayD);
			endCaseAppend.addEndCaseAppSituation(lossSituationD);
		}
		
		//3.2获取医疗费用赔偿
		String conditionsM = "feecategory='M' "
				           + " and compensateno in (" + compensateNo + ")";
		prpLpersonLossList = (ArrayList) new BLPrpLpersonLossAction()
				.findByConditions(dbManager, conditionsM);
		for (Iterator iter = prpLpersonLossList.iterator(); iter.hasNext();) {
			PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto) iter
					.next();
			sumPayM += prpLpersonLossDto.getSumRealPay();
		}
		//获取无保险医疗代赔
		String nodutyConditionM = " paidType='noInsM' and compensateno in (" + compensateNo + ")";
		prpLnodutyLossList = (ArrayList)new DBPrpLnodutyLoss(dbManager).findByConditions(nodutyConditionM);
		for(Iterator iter = prpLnodutyLossList.iterator(); iter.hasNext();){
			PrpLnodutyLossDto prpLnodutyLossDto = (PrpLnodutyLossDto)iter.next();
			
			sumPayM += prpLnodutyLossDto.getRealPaid();
		}
		if(prpLpersonLossList.size() > 0 || prpLnodutyLossList.size() > 0){
			lossSituationM.setLossType("4".equals(indemnityduty)?Iconstants.LossType.NODUTYMEDICAL:Iconstants.LossType.MEDICAL);
			lossSituationM.setAppPaySum(sumPayM);
			endCaseAppend.addEndCaseAppSituation(lossSituationM);
		}
		
		//3.3获取财产损失赔偿
		String conditionsP = " compensateno in (" + compensateNo + ")";
		List prpLlossList = (ArrayList) new BLPrpLlossAction()
				.findByConditions(dbManager, conditionsP);
		for (Iterator iter = prpLlossList.iterator(); iter.hasNext();) {
			PrpLlossDto prpLlossDto = (PrpLlossDto) iter.next();
			sumPayP += prpLlossDto.getSumRealPay();
		}
		
		String conditionCharge = " sumrealpay<>0"
				+ " and compensateno in (" + compensateNo + ")";
		prpLchargeList = (ArrayList) new BLPrpLchargeAction().findByConditions(
				dbManager, conditionCharge);
		for (Iterator iter = prpLchargeList.iterator(); iter.hasNext();) {
			PrpLchargeDto prpLcharge = (PrpLchargeDto) iter.next();

			sumPayP += prpLcharge.getSumRealPay();
		}
		
		//3.3获取无保险财产代赔
		String nodutyConditionP = " paidType in('noInsP','noDuty') and compensateno in (" + compensateNo + ")";
		prpLnodutyLossList = (ArrayList)new DBPrpLnodutyLoss(dbManager).findByConditions(nodutyConditionP);
		for(Iterator iter = prpLnodutyLossList.iterator(); iter.hasNext();){
			PrpLnodutyLossDto prpLnodutyLossDto = (PrpLnodutyLossDto)iter.next();
		
			sumPayP += prpLnodutyLossDto.getRealPaid();
		}
		
		if(prpLlossList.size() > 0 || prpLchargeList.size() > 0 || prpLnodutyLossList.size() > 0){
			lossSituationP.setLossType("4".equals(indemnityduty)?Iconstants.LossType.NODUTY_PROPERTY:Iconstants.LossType.PROPERTY);
			lossSituationP.setAppPaySum(sumPayP);
			endCaseAppend.addEndCaseAppSituation(lossSituationP);
		}
		
		//4.取追加序号
		/*BLCIClaimUploadLogFacade blCIClaimUploadLogFacade = new BLCIClaimUploadLogFacade();
		String uploadLogCondition = " uploadType = '" + RequestType.ENDCASE_APPEND + "'" +
									" and businessNo = '" + claimNo + "'" ;
		int uploadCount  = blCIClaimUploadLogFacade.getCount(uploadLogCondition);*/
		int serialNo = uploadCount + 1;
		
		//5.设置值
		endCaseAppend.setClaimNo(claimNo);
		endCaseAppend.setPolicyNO(policyNo);
		endCaseAppend.setSerialNo(serialNo + "");
		endCaseAppend.setAppendDate(formatDate(appendDate));
		endCaseAppend.setAccidentDeath(accidentDeath);
		return endCaseAppend;
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
						+ "' and Insurecarflag<>'1'");
		for (Iterator iter = thirdCarCollection.iterator(); iter.hasNext();) {
			PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto) iter
					.next();
			CIClaimThirdCarDto ciClaimThirdCarDto = new CIClaimThirdCarDto();
			ciClaimThirdCarDto.setCarMark(prpLthirdPartyDto.getLicenseNo());
			ciClaimThirdCarDto.setPolicyNo(prpLthirdPartyDto.getCarPolicyNo());
			ciClaimThirdCarDto.setClaimCompany(prpLthirdPartyDto.getInsureComCode());
			thirdCarList.add(ciClaimThirdCarDto);
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
	 * @return String 格式化后的日期
	 */
	public String formatDate(DateTime iDate,String iHour,String iMinutes) throws Exception{
		String strDate  = "";
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmm");
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyyMMdd HH:mm");
		
		Date date = new Date();
		date.setTime(iDate.getTime());
		
		strDate = dateFormat2.format(dateFormat3.parse(dateFormat1.format(date) + " " + iHour + ":" + iMinutes));
		
		return strDate;
	}
	/**
	 * 将DateTime类型的日期转换成yyyyMMddHHmm格式的字符串
	 * @author sinosoft_guoyuan
	 * @param Date
	 * @return String 格式化后的日期
	 */
	public String formatDate(DateTime iDate) throws Exception{
		String strDate  = "";
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmm");
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyyMMdd HH:mm");
		
		Date date = new Date();
		date.setTime(iDate.getTime());
		
		strDate = dateFormat2.format(date);
		
		return strDate;
	}
	public static void main(String[] args){
		DateTime test = new DateTime();
		test.setTime(System.currentTimeMillis());
		Date date = new Date();
		date.setTime(test.getTime());
		BLCIClaimPlatFormInterfaceActionImplGuoYuan bl = new BLCIClaimPlatFormInterfaceActionImplGuoYuan();
			try {
				System.err.println(bl.formatDate(test));
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public ArrayList checkRecoveryCode(String claimCode,String registNo) throws Exception{
		Accounts accountsBusiness = new Accounts();
		  ReturnAccountsInfo InfoBusiness= new ReturnAccountsInfo();
		  ArrayList accountsBusinessList = new ArrayList();
		  ArrayList accountsBusinessList1 = new ArrayList();
		  Accounts accountsInfoBusiness = null;
		  accountsBusiness.setClaimCode(claimCode);
		  accountsBusiness.setRecoveryRegistNo(registNo);
		  BLCIClaimPlatFormInterfaceFacade blCIClaimPlatFormInterfaceFacade = BLCIClaimPlatFormInterfaceFacade.getInstance();
			InfoBusiness=blCIClaimPlatFormInterfaceFacade.accountNoQuery(accountsBusiness);
			if(InfoBusiness != null){
		  		accountsBusinessList = (ArrayList)InfoBusiness.getAccountsList();
		  		if(accountsBusinessList.size() > 0){
		      		for(int i = 0;i < accountsBusinessList.size();i++){
		      			accountsInfoBusiness = (Accounts)accountsBusinessList.get(i);
		  				if(!"9".equals(accountsInfoBusiness.getAccountsNoStatus())){
		  					accountsBusinessList1.add(accountsInfoBusiness);
		        		}
		      		}
		  		}
			}
		  return accountsBusinessList1;
	}
}
