package com.sinosoft.ciplatform.bl.action.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.sinosoft.ciplatform.dto.custom.AccidentInfor;
import com.sinosoft.ciplatform.dto.custom.Accounts;
import com.sinosoft.ciplatform.dto.custom.CancelCase;
import com.sinosoft.ciplatform.dto.custom.CarLoss;
import com.sinosoft.ciplatform.dto.custom.Claim;
import com.sinosoft.ciplatform.dto.custom.ClaimCover;
import com.sinosoft.ciplatform.dto.custom.CompensateVeric;
import com.sinosoft.ciplatform.dto.custom.EndCase;
import com.sinosoft.ciplatform.dto.custom.EndCaseAppSituation;
import com.sinosoft.ciplatform.dto.custom.EndCaseAppend;
import com.sinosoft.ciplatform.dto.custom.Iconstants;
import com.sinosoft.ciplatform.dto.custom.Paydata;
import com.sinosoft.ciplatform.dto.custom.Payinfor;
import com.sinosoft.ciplatform.dto.custom.PersonLoss;
import com.sinosoft.ciplatform.dto.custom.PropLoss;
import com.sinosoft.ciplatform.dto.custom.ReCase;
import com.sinosoft.ciplatform.dto.custom.RecoveryOrPay;
import com.sinosoft.ciplatform.dto.custom.Regist;
import com.sinosoft.ciplatform.dto.custom.ReturnAccountsInfo;
import com.sinosoft.ciplatform.dto.custom.ThirdCar;
import com.sinosoft.ciplatform.util.CodeTransfer;
import com.sinosoft.claim.bl.action.domain.BLPrpLFirstVeriOpinionAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLRegistRPolicyAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLchargeAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcompensateAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLltextAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLprepayAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLregistAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLregistTextAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLthirdPartyAction;
import com.sinosoft.claim.bl.facade.BLPrpLRecoveryOrPayFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLdriverFacade;
import com.sinosoft.claim.bl.facade.BLPrpLlossFacade;
import com.sinosoft.claim.bl.facade.BLPrpLlossFacadeFG;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpersonLossFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpersonLossFacadeFG;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.dto.custom.ReCaseDto;
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
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLchargeFG;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLnodutyLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLnodutyLossFG;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAEndcaseViewHelper;
import com.sinosoft.prpall.blsvr.lp.BLPrpLloss;
import com.sinosoft.prpall.blsvr.lp.BLPrpLpersonLoss;
import com.sinosoft.prpall.blsvr.lp.BLPrpLrepairFee;
import com.sinosoft.prpall.blsvr.lp.BLPrpLthirdParty;
import com.sinosoft.prpall.pubfun.ComCodeTools;
import com.sinosoft.prpall.pubfun.PubTools;
import com.sinosoft.prpall.schema.PrpLlossSchema;
import com.sinosoft.prpall.schema.PrpLpersonLossSchema;
import com.sinosoft.sff.blsvr.BLPrpJpayRefRec;
import com.sinosoft.sff.schema.PrpJpayRefRecSchema;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.string.Str;


public class BLCIClaimPlatFormInterfaceActionImplGuoyuan extends
		BLCIClaimPlatFormInterfaceAction {
	/**
	 * 
	 * 报案2011
	 */
	protected Regist getRegist(DBManager dbManager, String registNo, String registType)
			throws SQLException, Exception {
		PrpLregistDto prpLregistDto = new BLPrpLregistAction()
				.findByPrimaryKey(dbManager, registNo);
		String policyNo = getPolicyNo(dbManager, registNo,registType);
		String driverName="";
		String certiType = "";
		String certiCode = "";
		Date damageStartDate = new Date();
		String damageStartHour = "";
		if (prpLregistDto != null) {
			damageStartDate = prpLregistDto.getDamageStartDate();
			damageStartHour = prpLregistDto.getDamageStartHour();
		}
		Date damageDate = new Date((damageStartDate.getYear() - 1900),
				(damageStartDate.getMonth() - 1), damageStartDate.getDate(),
				Integer.parseInt(damageStartHour.split(":")[0]), Integer
						.parseInt(damageStartHour.split(":")[1]));
		Date reportDate = new Date((prpLregistDto.getReportDate().getYear() - 1900),
				(prpLregistDto.getReportDate().getMonth() - 1), prpLregistDto.getReportDate().getDate(),
				Integer.parseInt(prpLregistDto.getReportHour().split(":")[0]), Integer
						.parseInt(prpLregistDto.getReportHour().split(":")[1]));
		
		PrpLdriverDto prpLdriverDto=new BLPrpLdriverFacade().findByPrimaryKey(prpLregistDto.getRegistNo(), 0);
		if(prpLdriverDto!=null){
			driverName=prpLdriverDto.getDriverName();
			certiType = prpLdriverDto.getIdentifyType();
			certiCode = prpLdriverDto.getIdentifyNumber();
		}
		Regist regist = new Regist();
		regist.setRegistNo(registNo);
		regist.setPolicyNO(policyNo);
		regist.setReportDate(reportDate);
		regist.setReportorName(prpLregistDto.getReportorName());
		regist.setDriverName(driverName);
		regist.setCertiType(certiType);
		regist.setCertiCode(certiCode);
		regist.setDamageAddress(prpLregistDto.getDamageAddress());         //出险地点名称
		regist.setDamageDate(damageDate);
		regist.setDamageContext(getDamageContext(dbManager, registNo));
		System.out.println("报案日期：reportDate="+reportDate);
		return regist;
	}
	/***
	 * 
	 * 立案2011
	 */
	protected Claim getClaim(DBManager dbManager, String claimNo,String registType)
			throws SQLException, Exception {

		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(dbManager, claimNo);
		PrpLregistDto prpLregistDto = new BLPrpLregistAction().findByPrimaryKey(dbManager, prpLclaimDto.getRegistNo());		
		DateTime reportDate = prpLregistDto.getReportDate();
		DateTime claimDate 	= prpLclaimDto.getClaimDate();
		Date	 dateTime	= null;
		if(claimDate.compareTo(reportDate) == 0){
			dateTime = new Date((prpLregistDto.getReportDate().getYear() - 1900),
					(prpLregistDto.getReportDate().getMonth() - 1), prpLregistDto.getReportDate().getDate(),
					Integer.parseInt(prpLregistDto.getReportHour().split(":")[0])+5,
					Integer.parseInt(prpLregistDto.getReportHour().split(":")[1]));
			System.out.println((prpLregistDto.getReportDate().getYear() - 1900));
			System.out.println(prpLregistDto.getReportDate().getMonth() - 1);
			System.out.println(prpLregistDto.getReportDate().getDate());
			System.out.println(Integer.parseInt(prpLregistDto.getReportHour().split(":")[0])+5);
			System.out.println(Integer.parseInt(prpLregistDto.getReportHour().split(":")[1]));
			System.out.println(new SimpleDateFormat("yyyyMMddHHmm").format(dateTime));
		}else{//2011-05-23 15:33:55
			dateTime = claimDate;
		}
		Claim claim = new Claim();
		claim.setPolicyNO(getPolicyNo(dbManager, prpLclaimDto.getRegistNo(),registType));
		claim.setRegistNo(prpLclaimDto.getRegistNo());
		claim.setClaimNo(claimNo);
		claim.setCaseType(prpLclaimDto.getIndemnityDuty());
		claim.setIndemnityDuty(prpLclaimDto.getIndemnityDuty());
		claim.setClaimDate(dateTime);
		claim.setUnClaimAmount(prpLclaimDto.getSumClaim());
		return claim;
	}

	//损失类型合并 
	protected ArrayList losstypeBing(ArrayList endCaseAppSituationList)
	throws SQLException, Exception {	
		ArrayList endCaseAppSituationListBing=new ArrayList();		
		for(int m=0;m<endCaseAppSituationList.size();m++)
		{
			EndCaseAppSituation endCaseAppSituation=(EndCaseAppSituation)endCaseAppSituationList.get(m);
			if(endCaseAppSituationListBing.size()==0){
				endCaseAppSituationListBing.add(endCaseAppSituation);
			}else{
				int k=0;
				for(int j=0;j<endCaseAppSituationListBing.size();j++){
					EndCaseAppSituation endCaseAppSituationB=(EndCaseAppSituation)endCaseAppSituationListBing.get(j);
					if(endCaseAppSituation.getLossType().equals(endCaseAppSituationB.getLossType())){						
						endCaseAppSituationB.setAppPaySum(endCaseAppSituationB.getAppPaySum()+endCaseAppSituation.getAppPaySum());
					}else{
						k++;
					}
				}
				if(k==endCaseAppSituationListBing.size()){					
					endCaseAppSituationListBing.add(endCaseAppSituation);
				}
			}
		 }		
		return endCaseAppSituationListBing;	
	}
	
	/***
	 *  
	 *  结案2011
	 */
	protected EndCase getEndCase(DBManager dbManager, String claimNo)
			throws SQLException, Exception {
		EndCase endCase = new EndCase();
		String policyNo = "";
		String registNo = "";
		String caseNo = "";
		String compensateNo = "";
		DateTime claimDate = new DateTime();
		DateTime endCaseDate = new DateTime();
		double sumDutyPaid=0d;     //赔款金额(不包括费用)
		String claimType = "1";
		// 获取驾驶员信息
		String driverName = "";
		String certiType = "";
		String certiCode = "";
		BLPrpLloss blPrpLloss = new BLPrpLloss();
		BLPrpLpersonLoss blPrpLpersonLoss = new BLPrpLpersonLoss();
		ArrayList carLossList = new ArrayList();
		ArrayList propLossList = new ArrayList();
		ArrayList personLossList = new ArrayList();
		ArrayList prplchargeList=new ArrayList();
		ArrayList prplchargeShiJiuList=new ArrayList();
		List prepayList =new ArrayList();
		double carSumLoss=0;     //总车辆损失金额
		double carSumPaid=0;     //总车辆赔款金额
		double propSumLoss=0;    //总财产损失金额
		double propSumPaid=0;    //总财产赔款金额
		double personSumLoss=0;  //总人员损失金额
		double personSumPaid=0;  //总人员赔款金额
		double chargeSumLoss=0;  //总费用损失金额
		double chargeSumPaid=0;  //总费用赔款金额
		String conditions="";
		AccidentInfor accidentInfor = new AccidentInfor(); // 出险信息
		boolean isInsuredDuty = true; // 是否事故责任
		
		PrpLcompensateDto prpLcompensateDto= null;
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(dbManager, claimNo);
		BLPrpLcompensateFacade bLPrpLcompensateFacade=new BLPrpLcompensateFacade();
		
		if (prpLclaimDto != null) {
			registNo = prpLclaimDto.getRegistNo();
			policyNo = prpLclaimDto.getPolicyNo();
			claimDate = prpLclaimDto.getClaimDate();
			caseNo = prpLclaimDto.getCaseNo();
			endCaseDate = prpLclaimDto.getEndCaseDate();
		}		
		String condition = " claimno = '"+claimNo+"'";
		ArrayList compensatelist=(ArrayList)bLPrpLcompensateFacade.findByConditions(condition);
		if(compensatelist!=null && compensatelist.size()>0){
	        for (int i = 0; i < compensatelist.size(); i++) {
	    	    prpLcompensateDto = (PrpLcompensateDto) compensatelist.get(i);
	    	    sumDutyPaid+=prpLcompensateDto.getSumDutyPaid();
	    	    compensateNo += "'" + prpLcompensateDto.getCompensateNo() + "',";
	        }
			}
		compensateNo = compensateNo.substring(0,compensateNo.length() - 1);
		conditions= " compensateno in (" + compensateNo + ")";
		if(compensatelist!=null && compensatelist.size()>0){
			//车损、物损取值 
			blPrpLloss.query(conditions);
			for (int i = 0; i < blPrpLloss.getSize(); i++) {
				PrpLlossSchema prpLlossSchema = blPrpLloss.getArr(i);						
				if(!("").equals(prpLlossSchema.getLicenseNo())){
					CarLoss carLoss = new CarLoss();  //商业险车辆损失情况
					carLoss.setIndemnityCode(prpLlossSchema.getFeeTypeCode());
					carLoss.setSumLoss(Double.parseDouble(prpLlossSchema.getSumLoss()));
					carLoss.setSumDuty(Double.parseDouble(prpLlossSchema.getSumRealPay()));
					carLossList.add(carLoss);
					carSumLoss+=Double.parseDouble(prpLlossSchema.getSumLoss());
					carSumPaid+=Double.parseDouble(prpLlossSchema.getSumRealPay());
				}else{
					PropLoss propLoss = new PropLoss();  //商业险财产损失情况
					propLoss.setSumDuty(Double.parseDouble(prpLlossSchema.getSumRealPay()));
					propLoss.setSumLoss(Double.parseDouble(prpLlossSchema.getSumLoss()));
					propLossList.add(propLoss);
					propSumLoss+=Double.parseDouble(prpLlossSchema.getSumLoss());
					propSumPaid+=Double.parseDouble(prpLlossSchema.getSumRealPay());
				}
			}		
			//人伤取值
			blPrpLpersonLoss.query(conditions);
			for (int j = 0; j < blPrpLpersonLoss.getSize(); j++){
				PrpLpersonLossSchema prpLpersonLossSchema = blPrpLpersonLoss.getArr(j);
				PersonLoss personLoss = new PersonLoss();
				personLoss.setSumLoss(Double.parseDouble(prpLpersonLossSchema.getSumLoss()));
				personLoss.setSumDuty(Double.parseDouble(prpLpersonLossSchema.getSumRealPay()));
				personLoss.setIndemnityCode(prpLpersonLossSchema.getLiabDetailCode());
				personLossList.add(personLoss);
				personSumLoss+=Double.parseDouble(prpLpersonLossSchema.getSumLoss());
				personSumPaid+=Double.parseDouble(prpLpersonLossSchema.getSumRealPay());
			}
			//施救费取值
			String conditionsShiJiu = "compensateno in (" + compensateNo
				+ ") and compensateno in (select compensateno from prplcompensate where underwriteflag='1' or underwriteflag='3') and sumrealpay!=0 ";
			prplchargeShiJiuList=(ArrayList)new BLPrpLchargeAction().findByConditions(dbManager, conditionsShiJiu);
			for( int m=0;m<prplchargeShiJiuList.size();m++)
			{
				PrpLchargeDto prpLchargeDto=(PrpLchargeDto)prplchargeShiJiuList.get(m);
				prplchargeList.add(prpLchargeDto);
				chargeSumPaid+=prpLchargeDto.getSumRealPay();
				chargeSumLoss+=prpLchargeDto.getChargeAmount();
			}			
		}else{
			String conditions_pre = " claimNo ='" + claimNo +"'";
			prepayList = (ArrayList) new BLPrpLprepayAction().findByConditions(dbManager, conditions_pre);
			if(prepayList != null && prepayList.size() > 0){
				for(int i = 0; i < prepayList.size(); i++){					
					PrpLprepayDto  prpLprepayDto = (PrpLprepayDto)prepayList.get(i);
					//预赔时损失默认为人伤损失
					PersonLoss personLoss = new PersonLoss();
					personLoss.setSumLoss(prpLprepayDto.getSumPrePaid());
					personLoss.setSumDuty(prpLprepayDto.getSumPrePaid());
					personLoss.setIndemnityCode("103");//费用默认为住院费
					personLossList.add(personLoss);
					personSumLoss+=prpLprepayDto.getSumPrePaid();
					personSumPaid+=prpLprepayDto.getSumPrePaid();
					sumDutyPaid += prpLprepayDto.getSumPrePaid();
				}
			}
			claimType = "3";
		}
		DateTime damageStartDate = new DateTime();
		String damageStartHour = "";
		String accidentPlace = "";  //出险地点
		String handleUnit ="";
		
		PrpLregistDto prpLregistDto = new BLPrpLregistAction().findByPrimaryKey(dbManager, registNo);
		if (prpLregistDto != null) {
			damageStartDate = prpLregistDto.getDamageStartDate();
			damageStartHour = prpLregistDto.getDamageStartHour();
			// 获取出险地点
			accidentPlace = prpLregistDto.getDamageAddress();
			handleUnit = prpLregistDto.getHandleUnit();
			if("".equals(handleUnit))handleUnit="99";
		}
		// 获取出险经过
		String accidentDesc = getPrpLltext(dbManager,claimNo,"09");
		// 获取拒赔原因
		String refusereason = getPrpLltext(dbManager,claimNo,"10");
		// 获取出险日期，出险时间
		Date damageDate = new Date((damageStartDate.getYear() - 1900),
				(damageStartDate.getMonth() - 1), damageStartDate.getDate(),
				Integer.parseInt(damageStartHour.split(":")[0]), Integer
						.parseInt(damageStartHour.split(":")[1]));
		accidentInfor.setAccidentTime(damageDate);
		accidentInfor.setAccidentPlace(accidentPlace);
		accidentInfor.setAccidentDesc(accidentDesc);
		accidentInfor.setHandleUnit(handleUnit);
		accidentInfor.setIndemnityDuty(prpLclaimDto.getIndemnityDuty());
		
		//驾驶员信息
		PrpLdriverDto prpLdriverDto = new BLPrpLdriverFacade()
		.findByPrimaryKey(registNo, 1);
		if (prpLdriverDto != null) {
			driverName = prpLdriverDto.getDriverName();
			certiType = prpLdriverDto.getIdentifyType();
			certiCode = prpLdriverDto.getIdentifyNumber();
			if(certiCode.length()>18){
				certiCode=certiCode.substring(0, 18);
			}
		}else {
			driverName = "无";
			certiType = "99";
			certiCode = "0";
		}
		if(driverName==null
				||"".equals(driverName))
		{
			driverName = "无";
		}
		//三者车信息
		List thirdCarList = new ArrayList();
		//thirdCarList = getThirdCarList(dbManager, registNo);
		
		endCase.setPolicyNo(policyNo);
		endCase.setRegistNo(registNo);
		endCase.setClaimNo(claimNo);
		endCase.setEndCaseNo(caseNo);
		endCase.setSumDutyPaid(sumDutyPaid);
		Date dateTime = null;
		if(claimDate.compareTo(endCaseDate)==0){
			dateTime = new DateTime(DateTime.current().addHour(5),DateTime.YEAR_TO_SECOND);
		}else{
			dateTime = endCaseDate;
		}
		System.out.println("结案时间"+new SimpleDateFormat("yyyyMMddHHmm").format(dateTime));
		endCase.setEndCaseTime(dateTime);
		endCase.setInsuredDuty(isInsuredDuty);
		endCase.setClaimType(claimType);
		endCase.setRefusereason(refusereason);
		endCase.setDriverName(driverName);
		endCase.setCertiType(certiType);
		endCase.setCertiCode(certiCode);
		endCase.setAccidentInfor(accidentInfor);
		endCase.setOptionType(handleUnit);
		endCase.setDamageCode(prpLclaimDto.getDamageCode());		
		endCase.setThirdCarList(thirdCarList);
		endCase.setCarSumLoss(carSumLoss);
		endCase.setCarSumPaid(carSumPaid);
		endCase.setPersonSumLoss(personSumLoss);
		endCase.setPersonSumPaid(personSumPaid);
		endCase.setPropSumLoss(propSumLoss);
		endCase.setPropSumPaid(propSumPaid);
		endCase.setChargeSumPaid(chargeSumPaid);//总费用赔款金额
		endCase.setChargeSumLoss(chargeSumLoss);//总费用损失金额
		endCase.setCarLossList(carLossList);
		endCase.setPropLossList(propLossList);
		endCase.setPersonLossList(personLossList);		
		endCase.setPrplchargeList(prplchargeList);
		//add by lianjingwei 20081028 车辆损失情况、物损损失情况、人员损失情况须至少填写一条赔偿情况信息不能为空 start
		if(carLossList.size()==0&&propLossList.size()==0&&personLossList.size()==0){
			PropLoss propLoss = new PropLoss();
			propLoss.setPropDesc("无损失");
			propLoss.setSumLoss(0.00);
			propLossList.add(propLoss);
			endCase.setPropLossList(propLossList);
		}
		//add by lianjingwei 20081028 车辆损失情况、物损损失情况、人员损失情况须至少填写一条赔偿情况信息不能为空 end
		return endCase;
	}
	
	/**
	 * 
	 * 结案追加 2011
	 */
	protected EndCaseAppend getEndCaseAppend(DBManager dbManager, String claimNo)
	throws SQLException, Exception {
		Date dateTime = null;
		EndCaseAppend endCaseAppend = new EndCaseAppend();
		BLPrpLcompensateFacade bLPrpLcompensateFacade=new BLPrpLcompensateFacade();
		ArrayList endCaseAppSituationList = new ArrayList();
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(dbManager, claimNo);
		DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
		ArrayList prpLrecaseDtoList = dAAEndcaseViewHelper.getRecaseList(claimNo);
		String compensateNo="";
		String conditions = "";
		String serialNo = "1";
		String  recaseReason = "";
		DateTime recaseDate = new DateTime();
		BLPrpLloss blPrpLloss = new BLPrpLloss();
		BLPrpLpersonLoss blPrpLpersonLoss = new BLPrpLpersonLoss();	
		for(int i=0;i<prpLrecaseDtoList.size();i++)
		{
			PrpLrecaseDto prpLrecaseDto=(PrpLrecaseDto)prpLrecaseDtoList.get(i);
			PrpLcompensateDto prpLcompensateDto= null;
			int times = prpLrecaseDto.getSerialNo()+1;
			String condition=" claimno='"+claimNo+"' and times='"+times+"'";			
			Collection compensatelist=bLPrpLcompensateFacade.findByConditions(condition);
			if(compensatelist!=null && compensatelist.size()>0){
				prpLcompensateDto=(PrpLcompensateDto)compensatelist.iterator().next();
				compensateNo=prpLcompensateDto.getCompensateNo();
			}
			serialNo = String.valueOf(prpLrecaseDto.getSerialNo());
			recaseDate = prpLrecaseDto.getCloseCaseDate();
			recaseReason = prpLrecaseDto.getReCaseReason();
			
			conditions = " compensateNo='"+compensateNo+"'";
			//车损、物损取值 
			blPrpLloss.query(conditions);
			for (int j = 0; j < blPrpLloss.getSize(); j++) {
				PrpLlossSchema prpLlossSchema = blPrpLloss.getArr(j);	
				EndCaseAppSituation endCaseAppSituation = new EndCaseAppSituation();					
				if(!("").equals(prpLlossSchema.getLicenseNo())){
					endCaseAppSituation.setLossType("1");
				}else{
					endCaseAppSituation.setLossType("2");
				}
				endCaseAppSituation.setAppPaySum(Double.parseDouble(prpLlossSchema.getSumRealPay()));
				endCaseAppSituationList.add(endCaseAppSituation);	
			}		
			//人伤取值
			blPrpLpersonLoss.query(conditions);
			for (int j = 0; j < blPrpLpersonLoss.getSize(); j++){
				PrpLpersonLossSchema prpLpersonLossSchema = blPrpLpersonLoss.getArr(j);
				EndCaseAppSituation endCaseAppSituation = new EndCaseAppSituation();					
				endCaseAppSituation.setLossType("3");
				endCaseAppSituation.setAppPaySum(Double.parseDouble(prpLpersonLossSchema.getSumRealPay()));
				endCaseAppSituationList.add(endCaseAppSituation);
			}
			//施救费取值
			String conditionsShiJiu = "compensateno='" + compensateNo
				+ "' and compensateno in (select compensateno from prplcompensate where underwriteflag='1' or underwriteflag='3') and sumrealpay!=0 ";
			ArrayList prplchargeShiJiuList=(ArrayList)new BLPrpLchargeAction().findByConditions(dbManager, conditionsShiJiu);
			for( int m=0;m<prplchargeShiJiuList.size();m++)
			{
				PrpLchargeDto prpLchargeDto=(PrpLchargeDto)prplchargeShiJiuList.get(m);
				EndCaseAppSituation endCaseAppSituation = new EndCaseAppSituation();
				endCaseAppSituation.setLossType("4");
				endCaseAppSituation.setAppPaySum(prpLchargeDto.getSumRealPay());
				endCaseAppSituationList.add(endCaseAppSituation);
			}     
			DateTime endcaseDate = prpLclaimDto.getEndCaseDate();
			boolean boo=(endcaseDate.getYear()==recaseDate.getYear())&&(endcaseDate.getMonth()==recaseDate.getMonth())&&(endcaseDate.getDate()==recaseDate.getDate());
			if(boo){
				dateTime = new Date((prpLrecaseDto.getCloseCaseDate().getYear() - 1900),
						(prpLrecaseDto.getCloseCaseDate().getMonth() - 1), prpLrecaseDto.getCloseCaseDate().getDate(),
						23, 59);
			}else{
				dateTime =recaseDate;
			}
		}
		//赔偿信息按损失类型合并
	    endCaseAppend.setEndCaseAppSituationList(losstypeBing(endCaseAppSituationList));		
		
		//车辆损失情况、物损损失情况、人员损失情况须至少填写一条赔偿情况信息不能为空 start
		if(endCaseAppend.getEndCaseAppSituationList().size()==0){
			EndCaseAppSituation endCaseAppSituation = new EndCaseAppSituation();
			endCaseAppSituation.setLossType("9");			
			endCaseAppSituation.setAppPaySum(0.00);
			endCaseAppSituationList.add(endCaseAppSituation);
			endCaseAppend.setEndCaseAppSituationList(endCaseAppSituationList);
		}
		//车辆损失情况、物损损失情况、人员损失情况须至少填写一条赔偿情况信息不能为空 end		
		
		endCaseAppend.setClaimNo(claimNo);
		endCaseAppend.setSerialNo(serialNo);
		endCaseAppend.setRegistNo(prpLclaimDto.getRegistNo());
		endCaseAppend.setPolicyNO(prpLclaimDto.getPolicyNo());
		endCaseAppend.setCaseNo(prpLclaimDto.getCaseNo());
		endCaseAppend.setComCode(prpLclaimDto.getComCode());
		endCaseAppend.setRecaseDate(dateTime);
		endCaseAppend.setRecaseReason(recaseReason);
		return endCaseAppend;
	}

	/**
	 * 获得商业险赔付对象2011
	 */
	protected Payinfor getPayinfor(DBManager dbManager, String claimNo,String registType,String payRefNo)
	throws SQLException, Exception {
		Payinfor payinfor = new Payinfor();	
		
		ResultSet rs = null;
		String serialNo = null;//取上传序号
		String strSql = " Select Max(uploadSerialNo) From (							  "+
			" select uploadSerialNo from prplcompensate where claimno = '" + claimNo + "'  "+
			" Union All                                                     "+
			" select uploadSerialNo from prplprepay where claimno = '" + claimNo + "'      "+
			" )                                                             ";
		rs = dbManager.executeQuery(strSql);
		if(rs.next()){
			serialNo = (rs.getInt(1) + 1) + "";
		}
		//取实付金额、实付时间
		DateTime payRefdate = new DateTime();
		Paydata payData = null;
		List<Paydata> payDataList = new ArrayList<Paydata>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm");
		double payAmount = 0D;
		String compensateNos = "";
		String preCompensateNos = "";
		strSql = "Select rec.certino,rec.payrefreason,cl.endcasedate as endcasedate,     "+
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
			payAmount += rs.getDouble(4);
			if(payRefdate.isEmpty()){
				//预赔从prplprepay表取实付时间
				if("P50".equals(rs.getString(2))){
					BLPrpLprepayAction blPrpLprepayAction = new BLPrpLprepayAction();
					PrpLprepayDto prpLprepayDto = blPrpLprepayAction.findByPrimaryKey(dbManager, rs.getString(1));
					payRefdate = prpLprepayDto.getPayRefDate();
					System.err.println("成功取得预配日期！！");
				}else{
				//实赔从prplcompensate表取实付时间
					BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
					PrpLcompensateDto prpLcompensateDTO = blPrpLcompensateAction.findByPrimaryKey(dbManager, rs.getString(1));
					payRefdate = prpLcompensateDTO.getPayrefDate();
					System.err.println("成功取得实赔日期！！");
				}
			}
			if("P60".equals(rs.getString(2))){
				compensateNos += "'" + rs.getString(1) + "',";
			}else{
				preCompensateNos += "'" + rs.getString(1) + "',";
			}
			/**收款账户明细列表*/
			payData = new Paydata();
			payData.setClaimAmount(rs.getDouble(4));
			payData.setRecoveryCode(rs.getString(5)==null?"":rs.getString(5));
			payDataList.add(payData);
			
		}
		/**
		 * 赔付登记待修改
		 * 此处存在精度问题所以保留两位
		 */
		payAmount = Str.round(payAmount,2);
		//将赔偿支付时间写入所有payData对象中
		if(!payRefdate.isEmpty()){
			for(Iterator itr = payDataList.iterator();itr.hasNext();){
				((Paydata)itr.next()).setPayDate(payRefdate);
			}
		}
		//格式化计算书号和预赔计算书号；由605063418002010000006-005,605063418002010000006-003,格式为605063418002010000006-005,605063418002010000006-003。
		if(compensateNos.length() > 1){
			compensateNos = compensateNos.substring(0, compensateNos.length() - 1);
		}
		if(preCompensateNos.length() > 1){
			preCompensateNos = preCompensateNos.substring(0, preCompensateNos.length() - 1);
		}
		//赔款支付 开户行，账户名
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
			//accountName = rs.getString(2);
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
				"  prplpay.claimno = '"+claimNo+"'" +
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
		String strRefRec = " claimno='"+claimNo+"' AND payreffee<0  and payrefreason in ( 'P60', 'P97', 'Z03','P63') and substr(payrefstate,1,1)='1' and payrefdate is not null "
		+" and exists (select 1 from prplcompensate  where prplcompensate.compensateno=prpjpayrefrec.certino and prplcompensate.claimno=prpjpayrefrec.claimno and prplcompensate.sumpaid<0) ";
		blPrpJpayRefRec.query(strRefRec);
		//遍历负数信息
		for(int i =0;i<blPrpJpayRefRec.getSize();i++){
			PrpJpayRefRecSchema prpJpayRefRecSchema = blPrpJpayRefRec.getArr(i);
			//通过理算书和立案号查询正负合并信息
			BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
			String strPaymain=" paymentno in ( select serialno from prplpay where claimno='"+prpJpayRefRecSchema.getClaimNo()+"' and compensateno='"+prpJpayRefRecSchema.getCertiNo()+"'  and paymenttype='"+prpJpayRefRecSchema.getPayRefReason()+"' ) and payamount=0 ";
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
				/**
				 * 因为PayRefDatetime存在空、精确到时分秒、只到天三种情况，
				 * 为了简化在这里当PayRefDatetime为空或者只到天的我们取payrefdate
				 */
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
		
		String policyNo = "";
		String registNo = "";
 		PrpLclaimDto prpLclaimDto = new BLPrpLclaimFacade().findByPrimaryKey(claimNo);
 		registNo = prpLclaimDto.getRegistNo();
		policyNo = prpLclaimDto.getPolicyNo();
		
		payinfor.setClaimNo(claimNo);
		payinfor.setRegistNo(registNo);
		payinfor.setPolicyNo(policyNo);
		payinfor.setSumPaid(payAmount);
		payinfor.setBankName(bankName);
		payinfor.setAccountName(accountName);
		payinfor.setSerialNo(serialNo);
		payinfor.setPreCompensateNos(preCompensateNos);
		payinfor.setCompensateNos(compensateNos);
		payinfor.setPayDataList(payDataList1);

		return payinfor;
	}

	
	@Override
	/**
	 * 
	 * 获得理算核赔信息
	 */
	protected CompensateVeric getCompensateVeric(DBManager dbManager,String registType,
			String compensateNo) throws SQLException, Exception {
		
		ResultSet rs = null;
		ResultSet rs1 = null;
		CompensateVeric compensateVeric = null;
		CompensateVeric compensateVeric1 = new CompensateVeric();
		ArrayList compensateVericList = new ArrayList();
		PrpLcompensateDto prpLcompensateDto1 = null;
		BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
		BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
		PrpLcompensateDto prpLcompensateDto = blPrpLcompensateAction.findByPrimaryKey(dbManager,compensateNo);
		PrpLclaimDto prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(prpLcompensateDto.getClaimNo());
		PrpLregistDto prpLregistDto=new BLPrpLregistFacade().findByPrimaryKey( prpLclaimDto.getRegistNo());
		String FGDate = AppConfig.get("sysconst.FG_DATE");
		PubTools pubTools  = new PubTools();
		String riskCode=prpLclaimDto.getRiskCode();
		boolean isFG=false;
		isFG=CodeTransfer.isFG(riskCode);
		String conditions = " claimNo = '"+ prpLclaimDto.getClaimNo() +"' ";
		ArrayList prpLcompensateDtoList = (ArrayList)blPrpLcompensateAction.findByConditions(dbManager, conditions);
		compensateVeric1.setRegistNo(prpLclaimDto.getRegistNo());
		compensateVeric1.setPolicyNo(prpLcompensateDto.getPolicyNo());
		compensateVeric1.setClaimNo(prpLcompensateDto.getClaimNo());
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
				for(int index1 = 0 ;index1 < prpLcompensateDtoList.size();index1++){
					compensateVeric = new CompensateVeric();
					prpLcompensateDto1 = (PrpLcompensateDto)prpLcompensateDtoList.get(index1);
					compensateVeric.setCompensateNo(prpLcompensateDto1.getCompensateNo());
					compensateVeric.setPolicyNo(prpLcompensateDto1.getPolicyNo());
					compensateVeric.setRegistNo(prpLclaimDto.getRegistNo());
					compensateVeric.setClaimNo(prpLcompensateDto1.getClaimNo());
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
					//全面型车损险，是否新增设备
					String isDeviceItem = "";
					String strSQL = " SELECT COUNT(1) from prpCcarDevice WHERE policyno = '"+prpLcompensateDto1.getPolicyNo()+"' ";
					rs1 = dbManager.executeQuery(strSQL);
					while(rs1.next()){
						isDeviceItem = rs1.getString(1);
					}
					rs1.close();
					if(Integer.parseInt(isDeviceItem) > 0){
						isDeviceItem = "1";//是
					}else{
						isDeviceItem = "0";//否
					}
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
					//代为案件
					boolean isFalse = false;
					boolean isFalse1 = false;
					
					if(prpLRecoveryOrPayList.size()>0){
						//追偿
						for(int i = 0;i < prpLRecoveryOrPayList.size();i++){
							prpLRecoveryOrPayDto = prpLRecoveryOrPayList.get(i);
							if("1".equals(prpLRecoveryOrPayDto.getRecoveryOrPayFlag())){
								claimCoverAmountProp += prpLRecoveryOrPayDto.getRecoveryOrPayAmount();
								recoveryOrPay= new RecoveryOrPay();
								recoveryOrPay.setSerialNo(prpLRecoveryOrPayDto.getSerialNo());
								recoveryOrPay.setRecoveryOrPayFlag(prpLRecoveryOrPayDto.getRecoveryOrPayFlag());
								recoveryOrPay.setRecoveryOrPayType(prpLRecoveryOrPayDto.getRecoveryOrPayType());
								recoveryOrPay.setRecoveryOrPayMan(prpLRecoveryOrPayDto.getRecoveryOrPayMan());
								recoveryOrPay.setRecoveryCode(prpLRecoveryOrPayDto.getRecoveryCode());
								recoveryOrPay.setRecoveryOrPayAmount(prpLRecoveryOrPayDto.getRecoveryOrPayAmount().toString());
								recoveryOrPay.setRecoveryRemark(prpLRecoveryOrPayDto.getRecoveryRemark());
								recoveryOrPayList.add(recoveryOrPay);
								isFalse = true; 
							}
							
						}
						if(isFalse){
							claimCover = new ClaimCover();
							claimCover.setRecoveryOrPayFlag("1");
							if(isFG){
								if(riskCode.equals("0546")){
									claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode("A"));
								}else{
									claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode("A"));
								}
								claimCover.setClaimFeeType("5");
							}else{
							    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode("A"));
							    if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
							    	claimCover.setClaimFeeType("5");
							    }else{
							    	claimCover.setClaimFeeType("3");
							    }  
							}
							claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
							claimCover.setSalvageFee(Double.toString(0.00));
							claimCover.setClaimAmount(Double.toString(claimCoverAmountProp));
							claimCover.setLossAmount(Double.toString(claimCoverAmountProp));
							claimCoverList.add(claimCover);
						}
						compensateVeric.setSumPaid(prpLcompensateDto1.getSumThisPaid()+claimCoverAmountProp);
						//清付信息
						claimCoverAmountProp = 0.0;
						for(int i = 0;i < prpLRecoveryOrPayList.size();i++){
							prpLRecoveryOrPayDto = prpLRecoveryOrPayList.get(i);
							if("2".equals(prpLRecoveryOrPayDto.getRecoveryOrPayFlag())){
								claimCoverAmountProp += prpLRecoveryOrPayDto.getRecoveryOrPayAmount();
								recoveryOrPay= new RecoveryOrPay();
								recoveryOrPay.setSerialNo(prpLRecoveryOrPayDto.getSerialNo());
								recoveryOrPay.setRecoveryOrPayFlag(prpLRecoveryOrPayDto.getRecoveryOrPayFlag());
								recoveryOrPay.setRecoveryOrPayType(prpLRecoveryOrPayDto.getRecoveryOrPayType());
								recoveryOrPay.setRecoveryOrPayMan(prpLRecoveryOrPayDto.getRecoveryOrPayMan());
								recoveryOrPay.setRecoveryCode(prpLRecoveryOrPayDto.getRecoveryCode());
								recoveryOrPay.setRecoveryOrPayAmount(prpLRecoveryOrPayDto.getRecoveryOrPayAmount().toString());
								recoveryOrPay.setRecoveryRemark(prpLRecoveryOrPayDto.getRecoveryRemark());
								recoveryOrPayList.add(recoveryOrPay);
								isFalse1 = true;
							}
						}
						if(isFalse1){
							claimCover = new ClaimCover();
							claimCover.setRecoveryOrPayFlag("2");
							if(isFG){
								if(riskCode.equals("0546")){
									claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode("A"));
								}else{
									claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode("A"));
								}
								claimCover.setClaimFeeType("5");
							}else{
							    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode("A"));
							    if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
							    	claimCover.setClaimFeeType("5");
							    }else{
							    	claimCover.setClaimFeeType("3");
							    }  
							}
							claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
							claimCover.setSalvageFee(Double.toString(0.00));
							claimCover.setLossAmount(Double.toString(claimCoverAmountProp));
							claimCover.setClaimAmount(Double.toString(claimCoverAmountProp));
							claimCoverList.add(claimCover);
						}
						
					}
					
					//自付信息
					//财产损失
					BLPrpLlossFacade blPrpLlossFacade = new BLPrpLlossFacade();
					BLPrpLlossFacadeFG blPrpLlossFacadeFG = new BLPrpLlossFacadeFG();
					PrpLlossDto prpLlossDto = null;
					double sunRealPaid = 0.0;
					boolean isExists = true;
					String[] kindCode = new String[50];
					Double[] kindCodeAmount = new Double[50] ;
					Double[] salvageFee=new Double[50] ;
					Double[] lossAmount=new Double[50] ;
					int j = 0;
					int l = 0;
					int g = 0;
					int h = 0;
					conditions = " compensateNo = '"+compensateNo+"' ";
					ArrayList<PrpLlossDto> prpLlossDtoList=null;
					if(isFG){
						prpLlossDtoList = (ArrayList)blPrpLlossFacadeFG.findByConditions(conditions);
					}else{
						prpLlossDtoList = (ArrayList)blPrpLlossFacade.findByConditions(conditions);
					}
					
					if(prpLlossDtoList.size()>0){
						for(int i = 0;i < prpLlossDtoList.size();i++){
							isExists = true;
							prpLlossDto = prpLlossDtoList.get(i);
							if(i == 0){
								kindCode[j++] = prpLlossDto.getKindCode();
								kindCodeAmount[l++] = prpLlossDto.getSumRealPay();
								isExists = false;
								if(prpLlossDto.getFeeTypeCode().equals("05")){
									salvageFee[g++] = prpLlossDto.getSumRealPay();
								}else{
									salvageFee[g++] = 0.0;
								}
								if(prpLlossDto.getFeeTypeCode().equals("04")){
									lossAmount[h++] = -prpLlossDto.getSumLoss();
								}else{
									lossAmount[h++] = prpLlossDto.getSumLoss();
								}
							}else{
								for(int k = 0;k < kindCode.length;k++){
									
									if(kindCode[k] != null && !"".equals(kindCode[k]) && (kindCode[k]).equals(prpLlossDto.getKindCode())){
										isExists = false;
										kindCodeAmount[k] += prpLlossDto.getSumRealPay();
										if(prpLlossDto.getFeeTypeCode().equals("05")){
											salvageFee[k] += prpLlossDto.getSumRealPay();
										}else{
											salvageFee[k] +=0.0;
										}
										if(prpLlossDto.getFeeTypeCode().equals("04")){
											lossAmount[k] -= prpLlossDto.getSumLoss();
										}else{
											lossAmount[k] += prpLlossDto.getSumLoss();
										}
										k++;
									}
								}
							}
							if(isExists){
								kindCode[j++] = prpLlossDto.getKindCode();
								kindCodeAmount[l++] = prpLlossDto.getSumRealPay();
								if(prpLlossDto.getFeeTypeCode().equals("05")){
									salvageFee[g++] = prpLlossDto.getSumRealPay();
								}else{
									salvageFee[g++] = 0.0;
								}
								if(prpLlossDto.getFeeTypeCode().equals("04")){
									lossAmount[h++] = -prpLlossDto.getSumLoss();
								}else{
									lossAmount[h++] = prpLlossDto.getSumLoss();
								}
							}
						}
						for(int index = 0 ; index < kindCode.length;index++){
							if(kindCode[index] != null && !"".equals(kindCode[index])){
								claimCover = new ClaimCover();
								claimCover.setRecoveryOrPayFlag("3");
								if(isFG){
									if(riskCode.equals("0546")){
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode(kindCode[index]));
									}else{
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode(kindCode[index]));
									}
									claimCover.setClaimFeeType("2");
								}else{
								    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode(kindCode[index]));
								    if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
								    	claimCover.setClaimFeeType("2");
								    }else{
								    	claimCover.setClaimFeeType("3");
								    }  
								}
								claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
								
								if(salvageFee[index]==null||salvageFee[index].equals("")){
									//系统科学计数法精度缺失的调整251.21999999999997
									//claimCover.setSalvageFee(Double.toString(0.00));
									claimCover.setSalvageFee(new DecimalFormat("0.00").format(salvageFee[index]));
								}else{
								    //claimCover.setSalvageFee(Double.toString(salvageFee[index]));
									claimCover.setSalvageFee(new DecimalFormat("0.00").format(salvageFee[index]));
								}
								//claimCover.setLossAmount(Double.toString(lossAmount[index]));
								claimCover.setLossAmount(new DecimalFormat("0.00").format(lossAmount[index]));
								if("B".equals(kindCode[index])){
									//claimCover.setClaimAmount(Double.toString(kindCodeAmount[index]-claimCoverAmountProp));
									claimCover.setClaimAmount(new DecimalFormat("0.00").format(kindCodeAmount[index]-claimCoverAmountProp));
								}else{
									//claimCover.setClaimAmount(Double.toString(kindCodeAmount[index]));
									claimCover.setClaimAmount(new DecimalFormat("0.00").format(kindCodeAmount[index]));
								}
								if("004".equals(kindCode[index])){//是否新增设备赋值
									claimCover.setIsDeviceItem(isDeviceItem);
								}
								claimCoverList.add(claimCover);
							}
						}
					}
					
					//死亡伤残
					BLPrpLpersonLossFacade blPersonLossFacade = new BLPrpLpersonLossFacade();
					BLPrpLpersonLossFacadeFG blPersonLossFacadeFG = new BLPrpLpersonLossFacadeFG();
					PrpLpersonLossDto prpLpersonLossDto = null;
					kindCode = new String[50];
					kindCodeAmount = new Double[50] ;
					salvageFee=new Double[50] ;
					lossAmount=new Double[50] ;
					j = 0;
					l = 0;
					sunRealPaid = 0.0; 
					conditions = " compensateNo = '"+compensateNo+"' and feecategory = 'D' ";
					ArrayList<PrpLpersonLossDto> prpLpersonLossDtoList =null;
					if(isFG){
						prpLpersonLossDtoList = (ArrayList)blPersonLossFacadeFG.findByConditions(conditions);
					}else{
						prpLpersonLossDtoList = (ArrayList)blPersonLossFacade.findByConditions(conditions);
					}
					
					if(prpLpersonLossDtoList.size()>0){
						for(int i = 0; i < prpLpersonLossDtoList.size();i++){
							isExists = true;
							prpLpersonLossDto = prpLpersonLossDtoList.get(i);
							if(i == 0){
								kindCode[j++] = prpLpersonLossDto.getKindCode();
								kindCodeAmount[l] = prpLpersonLossDto.getSumRealPay();
								salvageFee[l] = 0.00;
								lossAmount[l] = prpLpersonLossDto.getSumLoss();
								l++;
								isExists = false;
							}else{
								for(int k = 0;k < kindCode.length;k++){
									if(kindCode[k] != null && !"".equals(kindCode[k]) && (kindCode[k]).equals(prpLpersonLossDto.getKindCode())){
										isExists = false;
										kindCodeAmount[k] += prpLpersonLossDto.getSumRealPay();
										salvageFee[k] += 0.00;
										lossAmount[k] += prpLpersonLossDto.getSumLoss();
										k++;
									}
								}
							}
							if(isExists){
								kindCode[j++] = prpLpersonLossDto.getKindCode();
								kindCodeAmount[l] = prpLpersonLossDto.getSumRealPay();
								salvageFee[l] = 0.00;
								lossAmount[l] = prpLpersonLossDto.getSumLoss();
								l++;
							}
						}
						for(int index = 0;index < kindCode.length;index++){
							if(kindCode[index] != null && !"".equals(kindCode[index])){
								claimCover = new ClaimCover();
								claimCover.setRecoveryOrPayFlag("3");
								if(isFG){
									if(riskCode.equals("0546")){
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode(kindCode[index]));
									}else{
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode(kindCode[index]));
									}
									claimCover.setClaimFeeType("5");
								}else{
								    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode(kindCode[index]));
								    claimCover.setClaimFeeType("1");
								}
								claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
								
								//claimCover.setClaimAmount(Double.toString(kindCodeAmount[index]));
								claimCover.setClaimAmount(new DecimalFormat("0.00").format(kindCodeAmount[index]));
								if(salvageFee[index]==null||salvageFee[index].equals("")){
									claimCover.setSalvageFee(Double.toString(0.00));
								}else{
								    //claimCover.setSalvageFee(Double.toString(salvageFee[index]));
								    claimCover.setSalvageFee(new DecimalFormat("0.00").format(salvageFee[index]));
								}
								//claimCover.setLossAmount(Double.toString(lossAmount[index]));
								claimCover.setLossAmount(new DecimalFormat("0.00").format(lossAmount[index]));
								claimCoverList.add(claimCover);
							}
						}
					}
					//医疗费用
					sunRealPaid = 0.0; 
					conditions = " compensateNo = '"+compensateNo+"' and feecategory = 'M' ";
					if(isFG){
						prpLpersonLossDtoList = (ArrayList)blPersonLossFacadeFG.findByConditions(conditions);
					}else{
						prpLpersonLossDtoList = (ArrayList)blPersonLossFacade.findByConditions(conditions);
					}
					
					kindCode = new String[50];
					kindCodeAmount = new Double[50] ;
					salvageFee=new Double[50] ;
					lossAmount=new Double[50] ;
					j = 0;
					l = 0;
					if(prpLpersonLossDtoList.size()>0){
						for(int i = 0; i < prpLpersonLossDtoList.size();i++){
							isExists = true;
							prpLpersonLossDto = prpLpersonLossDtoList.get(i);
							if(i == 0){
								kindCode[j++] = prpLpersonLossDto.getKindCode();
								kindCodeAmount[l] = prpLpersonLossDto.getSumRealPay();
								salvageFee[l] = 0.00;
								lossAmount[l] = prpLpersonLossDto.getSumLoss();
								l++;
								isExists = false;
							}else{
								for(int k = 0;k < kindCode.length;k++){
									if(kindCode[k] != null && !"".equals(kindCode[k]) && (kindCode[k]).equals(prpLpersonLossDto.getKindCode())){
										isExists = false;
										kindCodeAmount[k] += prpLpersonLossDto.getSumRealPay();
										salvageFee[k] = 0.00;
										lossAmount[k] += prpLpersonLossDto.getSumLoss();
										k++;
									}
								}
							}
							if(isExists){
								kindCode[j++] = prpLpersonLossDto.getKindCode();
								kindCodeAmount[l] = prpLpersonLossDto.getSumRealPay();
								salvageFee[l] = 0.00;
								lossAmount[l] = prpLpersonLossDto.getSumLoss();
								l++;
							}
						}
						for(int index = 0;index < kindCode.length;index++){
							if(kindCode[index] != null && !"".equals(kindCode[index])){
								claimCover = new ClaimCover();
								claimCover.setRecoveryOrPayFlag("3");
								if(isFG){
									if(riskCode.equals("0546")){
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode(kindCode[index]));
									}else{
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode(kindCode[index]));
									}
									claimCover.setClaimFeeType("6");
								}else{
								    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode(kindCode[index]));
								    if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
								    	claimCover.setClaimFeeType("6");
								    }else{
								    	claimCover.setClaimFeeType("2");
								    }  
								}
								claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
								
								//claimCover.setClaimAmount(Double.toString(kindCodeAmount[index]));
								claimCover.setClaimAmount(new DecimalFormat("0.00").format(kindCodeAmount[index]));
								if(salvageFee[index]==null||salvageFee[index].equals("")){
									claimCover.setSalvageFee(Double.toString(0.00));
								}else{
								    //claimCover.setSalvageFee(Double.toString(salvageFee[index]));
								    claimCover.setSalvageFee(new DecimalFormat("0.00").format(salvageFee[index]));
								}
								//claimCover.setLossAmount(Double.toString(lossAmount[index]));
								claimCover.setLossAmount(new DecimalFormat("0.00").format(lossAmount[index]));
								claimCoverList.add(claimCover);
							}
						}
					}
					//无责代赔
					sunRealPaid = 0.0;
					kindCode = new String[50];
					kindCodeAmount = new Double[50] ;
					salvageFee=new Double[50] ;
					lossAmount=new Double[50] ;
					j = 0;
					l = 0;
					String nodutyConditionP = " compensateNo = '"+compensateNo+"' ";
					ArrayList<PrpLnodutyLossDto> prpLnodutyLossList =null;
					if(isFG){
						prpLnodutyLossList = (ArrayList)new DBPrpLnodutyLossFG(dbManager).findByConditions(nodutyConditionP);
					}else{
						prpLnodutyLossList = (ArrayList)new DBPrpLnodutyLoss(dbManager).findByConditions(nodutyConditionP);
					}
					
					PrpLnodutyLossDto prpLnodutyLossDto = null;
					if(prpLnodutyLossList.size()>0){
						for(int i = 0;i < prpLnodutyLossList.size();i++){
							prpLnodutyLossDto = prpLnodutyLossList.get(i);
							if(i == 0){
								kindCode[j++] = prpLnodutyLossDto.getKindCode();
								kindCodeAmount[l] = prpLnodutyLossDto.getRealPaid();
								salvageFee[l] = 0.00;
								lossAmount[l] = prpLnodutyLossDto.getRealPaid();
								l++;
								isExists = false;
							}else{
								for(int k = 0;k < kindCode.length;k++){
									if(kindCode[k] != null && !"".equals(kindCode[k]) && (kindCode[k]).equals(prpLnodutyLossDto.getKindCode())){
										isExists = false;
										kindCodeAmount[k] += prpLnodutyLossDto.getRealPaid();
										salvageFee[k] += 0.00;
										lossAmount[k] += prpLnodutyLossDto.getRealPaid();
										k++;
									}
								}
							}
							if(isExists){
								kindCode[j++] = prpLnodutyLossDto.getKindCode();
								kindCodeAmount[l] = prpLnodutyLossDto.getRealPaid();
								salvageFee[l] = 0.00;
								lossAmount[l] = prpLnodutyLossDto.getRealPaid();
								l++;
							}
						}
						for(int index = 0;index < kindCode.length;index++){
							if(kindCode[index] != null && !"".equals(kindCode[index])){
								claimCover = new ClaimCover();
								claimCover.setRecoveryOrPayFlag("3");
								if(isFG){
									if(riskCode.equals("0546")){
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode(kindCode[index]));
									}else{
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode(kindCode[index]));
									}
									claimCover.setClaimFeeType("7");
								}else{
								    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode(kindCode[index]));
								    claimCover.setClaimFeeType("7");
								}
								claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
								
								//claimCover.setClaimAmount(Double.toString(kindCodeAmount[index]));
								claimCover.setClaimAmount(new DecimalFormat("0.00").format(kindCodeAmount[index]));
								if(salvageFee[index]==null||salvageFee[index].equals("")){
									claimCover.setSalvageFee(Double.toString(0.00));
								}else{
								    //claimCover.setSalvageFee(Double.toString(salvageFee[index]));
								    claimCover.setSalvageFee(new DecimalFormat("0.00").format(salvageFee[index]));
								}
								//claimCover.setLossAmount(Double.toString(lossAmount[index]));
								claimCover.setLossAmount(new DecimalFormat("0.00").format(lossAmount[index]));
								claimCoverList.add(claimCover);
							}
						}
					}
					
					//费用
					/*sunRealPaid = 0.0;
					kindCode = new String[50];
					kindCodeAmount = new Double[50] ;
					salvageFee=new Double[50] ;
					lossAmount=new Double[50] ;
					j = 0;
					l = 0;
					nodutyConditionP = " compensateNo = '"+compensateNo+"' ";
					ArrayList<PrpLchargeDto> PrpLchargeDtoList =null;
					if(isFG){
						PrpLchargeDtoList = (ArrayList)new DBPrpLchargeFG(dbManager).findByConditions(nodutyConditionP);
					}else{
						PrpLchargeDtoList = (ArrayList)new DBPrpLcharge(dbManager).findByConditions(nodutyConditionP);
					}
					PrpLchargeDto prpLchargeDto = null;
					if(PrpLchargeDtoList.size()>0 && false){
						for(int i = 0;i < PrpLchargeDtoList.size();i++){
							prpLchargeDto = PrpLchargeDtoList.get(i);
							if(i == 0){
								kindCode[j++] = prpLchargeDto.getKindCode();
								kindCodeAmount[l] = prpLchargeDto.getChargeAmount();
								if(prpLchargeDto.getChargeCode().equals("03")){
									salvageFee[l] =prpLchargeDto.getChargeAmount();
								}else{
									salvageFee[l] =0.0;
								}
								lossAmount[l] = prpLchargeDto.getChargeAmount();
								l++;
								isExists = false;
							}else{
								for(int k = 0;k < kindCode.length;k++){
									if(kindCode[k] != null && !"".equals(kindCode[k]) && (kindCode[k]).equals(prpLchargeDto.getKindCode())){
										isExists = false;
										kindCodeAmount[k] += prpLchargeDto.getChargeAmount();
										if(prpLchargeDto.getChargeCode().equals("03")){
											salvageFee[k] +=prpLchargeDto.getChargeAmount();
										}else{
											salvageFee[k] +=0.0;
										}
										lossAmount[k] += prpLchargeDto.getChargeAmount();
										k++;
									}
								}
							}
							if(isExists){
								kindCode[j++] = prpLchargeDto.getKindCode();
								kindCodeAmount[l] = prpLchargeDto.getChargeAmount();
								if(prpLchargeDto.getChargeCode().equals("03")){
									salvageFee[l] =prpLchargeDto.getChargeAmount();
								}else{
									salvageFee[l] =0.0;
								}
								lossAmount[l++] = prpLchargeDto.getChargeAmount();
								l++;
							}
						}
						for(int index = 0;index < kindCode.length;index++){
							if(kindCode[index] != null && !"".equals(kindCode[index])){
								claimCover = new ClaimCover();
								claimCover.setRecoveryOrPayFlag("3");
								if(isFG){
									if(riskCode.equals("0546")){
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode(kindCode[index]));
									}else{
										claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode(kindCode[index]));
									}
									claimCover.setClaimFeeType("6");
								}else{
								    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode(kindCode[index]));
								    if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
								    	claimCover.setClaimFeeType("6");
								    }else{
								    	claimCover.setClaimFeeType("3");
								    }
								}
								claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
								
								//claimCover.setClaimAmount(Double.toString(kindCodeAmount[index]));
								claimCover.setClaimAmount(new DecimalFormat("0.00").format(kindCodeAmount[index]));
								if(salvageFee[index]==null||salvageFee[index].equals("")){
									claimCover.setSalvageFee(Double.toString(0.00));
								}else{
								    //claimCover.setSalvageFee(Double.toString(salvageFee[index]));
									claimCover.setSalvageFee(new DecimalFormat("0.00").format(salvageFee[index]));
								}
								//claimCover.setLossAmount(Double.toString(lossAmount[index]));
								claimCover.setLossAmount(new DecimalFormat("0.00").format(lossAmount[index]));
								claimCoverList.add(claimCover);
							}
						}
					}*/
					if(claimCoverList == null || claimCoverList.size() == 0){
						claimCover = new ClaimCover();
						claimCover.setRecoveryOrPayFlag("3");
						if(isFG){
							if(riskCode.equals("0546")){
								claimCover.setCoverageCode(CodeTransfer.CoverageCodeFG.covrentPlatFormCode("A"));
							}else{
								claimCover.setCoverageCode(CodeTransfer.CoverageCodeFGT.covrentPlatFormCode("A"));
							}
							claimCover.setClaimFeeType("5");
						}else{
						    claimCover.setCoverageCode(CodeTransfer.CoverageCode.covrentPlatFormCode("A"));
						    if(pubTools.compareDate(prpLregistDto.getDamageStartDate().toString(),FGDate)>-1){
						    	claimCover.setClaimFeeType("5");
						    }else{
						    	claimCover.setClaimFeeType("3");
						    }
						}
						claimCover.setLiabilityRate(Double.toString(prpLcompensateDto1.getIndemnityDutyRate()/100));
						claimCover.setSalvageFee("0.00");
						claimCover.setClaimAmount("0.00");
						claimCover.setLossAmount("0.00"); //损失金额
						claimCoverList.add(claimCover);
					}
					compensateVeric.setRecoveryOrPayList(recoveryOrPayList);
					compensateVeric.setClaimCoverList(claimCoverList);
					compensateVericList.add(compensateVeric);
			}
			compensateVeric1.setCompensateVericList(compensateVericList);
		}
		return compensateVeric1;
	}   
	
	/**
	 * 案件注销2011
	 */
	protected CancelCase getCancelCaseZJ(DBManager dbManager, String businessNo)
	throws SQLException, Exception {
		CancelCase cancelCase = new CancelCase();
		PrpLRegistRPolicyDto prpLRegistRPolicyDto = null;
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimAction().findByPrimaryKey(
				dbManager, businessNo);
		if(prpLclaimDto==null)//没有立案数据，为报案注销
		{
			PrpLregistDto prpLregistDto=new BLPrpLregistAction().findByPrimaryKey(
					dbManager, businessNo);
			if(prpLregistDto.getRiskCode().equals("0506")){
				prpLRegistRPolicyDto=new BLPrpLRegistRPolicyAction().findByPrimaryKey(
						dbManager, prpLregistDto.getRegistNo(), prpLregistDto.getPolicyNo());
			}else{
				String condtion=" registno='"+prpLregistDto.getRegistNo()+"' and riskcode='0506' ";
				Collection coll=new BLPrpLRegistRPolicyAction().findByConditions(dbManager, condtion);
				if(coll!=null && coll.size()>0){
					prpLRegistRPolicyDto=(PrpLRegistRPolicyDto)coll.iterator().next();
				}
				
			}
			
			cancelCase.setClaimNo("");
			cancelCase.setRegistNo(prpLregistDto.getRegistNo());
			cancelCase.setPolicyNO(prpLRegistRPolicyDto.getPolicyNo());
			cancelCase.setComCode(prpLregistDto.getComCode());
			//2011
			if("".equals(prpLRegistRPolicyDto.getCancelReason())){
				prpLRegistRPolicyDto.setCancelReason("99");
			}
			cancelCase.setCancelCause(prpLRegistRPolicyDto.getCancelReason());
			cancelCase.setCancelType("1");
		}else//立案注销
		{
			cancelCase.setClaimNo(prpLclaimDto.getClaimNo());
			cancelCase.setRegistNo(prpLclaimDto.getRegistNo());
			cancelCase.setPolicyNO(prpLclaimDto.getPolicyNo());
			cancelCase.setComCode(prpLclaimDto.getComCode());
			
			//2011
			String conditions=" claimno='"+prpLclaimDto.getClaimNo()+"' ";
			Collection coll=new BLPrpLRegistRPolicyAction().findByConditions(dbManager, conditions);
			prpLRegistRPolicyDto=(PrpLRegistRPolicyDto)coll.iterator().next();
			cancelCase.setCancelCause(prpLRegistRPolicyDto.getCancelReason());
			cancelCase.setCancelType("2");
		}
		return cancelCase;
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


	/**
	 * 根据报案号获得保单号
	 */
	private String getPolicyNo(DBManager dbManager, String registNo, String registType)
			throws SQLException, Exception {
		String policyNo = "";
		String policyTye = "";
		if(Iconstants.RequstType.REGIST.equals(registType)
				||Iconstants.RequstType.CLAIM.equals(registType)
				||Iconstants.RequstType.COMPENSATE.equals(registType)
				||Iconstants.RequstType.ENDCASE.equals(registType)
				||Iconstants.RequstType.CANCEL_REGIST_CASE.equals(registType)){
			policyTye = "3";
		}else if(Iconstants.RequstType.REGIST_SYX.equals(registType)
				||Iconstants.RequstType.CLAIM_SYX.equals(registType)
				||Iconstants.RequstType.COMPENSATE_SYX.equals(registType)
				||Iconstants.RequstType.ENDCASE_SYX.equals(registType)
				||Iconstants.RequstType.CANCEL_REGISTSYX_CASE.equals(registType)
				||Iconstants.ZJRequstType.REGIST_SYX.equals(registType)
				||Iconstants.ZJRequstType.CLAIM_SYX.equals(registType)
				||Iconstants.ZJRequstType.COMPENSATE_SYX.equals(registType)
				||Iconstants.ZJRequstType.ENDCASE_SYX.equals(registType)
				||Iconstants.ZJRequstType.CANCEL_CASE.equals(registType)){
			policyTye = "1";
		}
		List prpLregistRPolicyList = new ArrayList();
		BLPrpLRegistRPolicyAction blPrpLRegistRPolicyAction = new BLPrpLRegistRPolicyAction();
		
		prpLregistRPolicyList = (ArrayList) blPrpLRegistRPolicyAction
				.findByConditions(dbManager, " registno='" + registNo
						+ "' and policytype='"+policyTye+"'");
		if (prpLregistRPolicyList != null && prpLregistRPolicyList.size() > 0) {
			policyNo = ((PrpLRegistRPolicyDto) prpLregistRPolicyList.get(0))
					.getPolicyNo();
		}
		return policyNo;
	}

	private String getPrpLltext(DBManager dbManager,String claimNo,String textType) throws Exception
	{
		String desc = "";
		String conditions = " claimno='" + claimNo + "' and texttype='"+textType+"' order by lineno";
		List prpLltextList = (ArrayList) new BLPrpLltextAction().findByConditions(dbManager, conditions);
		for (Iterator iter = prpLltextList.iterator(); iter.hasNext();) {
			PrpLltextDto prpLltextDto = (PrpLltextDto) iter.next();
			desc += prpLltextDto.getContext();
		}
		if(desc.length()>500){
			desc = desc.substring(0,499);
	    }
		return  desc ;
	}
  private String getDamageContext(DBManager dbManager,String registNo) throws Exception
  {
	  StringBuffer str   = new StringBuffer();
      String DamageContextTemp = "";
      String DamageContext = "";
	  BLPrpLregistTextAction blPrpLregistTextAction  = new BLPrpLregistTextAction();
      String conditions = "  registno='"+registNo+"'   Order By texttype,lineno " ;
      Collection col = new ArrayList();
      col = blPrpLregistTextAction.findByConditions(dbManager,conditions);
      Iterator it  = col.iterator();
      PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
      while(it.hasNext())
      {
    	  prpLregistTextDto = (PrpLregistTextDto)it.next();
    	  str.append(prpLregistTextDto.getContext());
      }
      DamageContextTemp = str.toString();
      if(DamageContextTemp.length()==0)
      {
    	  DamageContext = "无描述";
    	  
      }
      else if(DamageContextTemp.length()>500)
      {
    	  DamageContext = DamageContextTemp.substring(0,499);
      }
      else
      {
    	  DamageContext = DamageContextTemp;
      }
      System.out.println("【出险经过】----------"+DamageContext);
      return  DamageContext;
  }
/*  public String StringToDate(String strDate) {
	  String  date = "";
	  if(!("").equals(strDate)){
		  String[] arrDate =  strDate.split(" ");
		  String[] arrDate1 =  arrDate[0].trim().split("-");
	      for(int i=0;i<arrDate1.length;i++){
	    	  date = date + arrDate1[i];
	      }
	      String[] arrDate2 =  arrDate[1].trim().split(":");
	      for(int i=0;i<arrDate2.length;i++){
	    	  date = date + arrDate2[i];
	      }
	  }   
      
      return date; 
  }*/

  private ArrayList checkRecoveryCode(String claimCode,String registNo) throws Exception{
	  Accounts accountsBusiness = new Accounts();
	  ReturnAccountsInfo InfoBusiness= new ReturnAccountsInfo();
	  ArrayList accountsBusinessList = new ArrayList();
	  ArrayList accountsBusinessList1 = new ArrayList();
	  Accounts accountsInfoBusiness = null;
	  accountsBusiness.setClaimCode(claimCode);
		accountsBusiness.setRecoveryRegistNo(registNo);
		InfoBusiness=BLCIClaimPlatFormInvok.getInstance().accountNoQuery(accountsBusiness);
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
