package com.sinosoft.claim.webservice;

import java.text.DecimalFormat;
import java.util.ArrayList;

import com.sinosoft.claim.util.CallCenterInterfaceLogger;
import com.sinosoft.prpall.blsvr.cb.BLPolicy;
import com.sinosoft.prpall.blsvr.cb.BLPrpCaddress;
import com.sinosoft.prpall.blsvr.cb.BLPrpCengage;
import com.sinosoft.prpall.blsvr.cb.BLPrpCfee;
import com.sinosoft.prpall.blsvr.cb.BLPrpCinsured;
import com.sinosoft.prpall.blsvr.cb.BLPrpCinsuredArtif;
import com.sinosoft.prpall.blsvr.cb.BLPrpCitemKind;
import com.sinosoft.prpall.blsvr.cb.BLPrpClimit;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmainCargo;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmainCasualty;
import com.sinosoft.prpall.blsvr.cb.BLPrpCplan;
import com.sinosoft.prpall.blsvr.pg.BLEndorse;
import com.sinosoft.prpall.schema.PrpCengageSchema;
import com.sinosoft.prpall.schema.PrpCplanSchema;
import com.sinosoft.prpall.schema.PrpTaddressSchema;
import com.sinosoft.prpall.schema.PrpTengageSchema;
import com.sinosoft.prpall.schema.PrpTfeeSchema;
import com.sinosoft.prpall.schema.PrpTinsuredArtifSchema;
import com.sinosoft.prpall.schema.PrpTinsuredSchema;
import com.sinosoft.prpall.schema.PrpTitemDeviceSchema;
import com.sinosoft.prpall.schema.PrpTitemKindSchema;
import com.sinosoft.prpall.schema.PrpTlimitSchema;
import com.sinosoft.prpall.schema.PrpTmainCargoSchema;
import com.sinosoft.prpall.schema.PrpTmainCasualtySchema;
import com.sinosoft.prpall.schema.PrpTmainLiabSchema;
import com.sinosoft.prpall.schema.PrpTmainPropSchema;
import com.sinosoft.prpall.schema.PrpTmainSchema;
import com.sinosoft.prpall.schema.PrpTplanSchema;
import com.sinosoft.prpall.schema.PrpTrenewalSchema;
import com.sinosoft.prpall.ui.UIEngageSeparator;
import com.sinosoft.prpall.ui.UIItemKindSeparator;
import com.sinosoft.utiall.blsvr.BLPrpDagent;
import com.sinosoft.utiall.blsvr.BLPrpDcode;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;
import com.sinosoft.utiall.blsvr.BLPrpDcurrency;
import com.sinosoft.utiall.blsvr.BLPrpDitem;
import com.sinosoft.utiall.blsvr.BLPrpDrisk;
import com.sinosoft.utiall.blsvr.BLPrpDuser;
import com.sinosoft.utiall.dbsvr.DBPrpDcustomLevelTrace;
import com.sinosoft.utility.string.Str;
import com.sinosoft.utility.string.ChgData;

public class ClaimPolicyDetailInfoService {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	/**
	 * 非车险保单详细信息查询
	 * @param policyNo
	 * @param damageDate
	 * @return
	 */
	public ClaimPolicyDetailInfo getClaimPolicyDetailInfo(String policyNo, String damageDate) {
		long serial = System.currentTimeMillis();
		logger.log("非车险保单详细信息查询", 1,serial, "[policyNo:"+policyNo+"][damageDate:"+damageDate+"]");
		ClaimPolicyDetailInfo claimPolicyDetailInfo = new ClaimPolicyDetailInfo();
		try {
			//获取保单信息
			BLPolicy blPolicy = new BLPolicy(); 
			BLPrpCmain blPrpCmain = new BLPrpCmain();
			blPrpCmain.getData(policyNo);
			if (blPrpCmain.getSize() == 0) {
				throw new Exception("保单"+policyNo+"不存在！");
			}
			String messType = blPrpCmain.getArr(0).getFlag();
			if (messType != null && messType.length() > 1) {
				messType = messType.substring(1, 2);
			} else {
				messType = "";
			}
			
			if (damageDate != null && !damageDate.equals("")) {
				if (damageDate.length() > 10) {
					damageDate = damageDate.substring(0, 10);
				}
				BLEndorse blEndorse = new BLEndorse();
				blPolicy = blEndorse.getBackWardPolicy(policyNo, damageDate);
			}
			
			BLPrpDrisk blPrpDrisk = new BLPrpDrisk();
			BLPrpDagent blPrpDagent = new BLPrpDagent();
			BLPrpDcode blPrpDcode = new BLPrpDcode();
			BLPrpDcompany blPrpDcompany = new BLPrpDcompany();
		    BLPrpDuser blPrpDuser = new BLPrpDuser();
		    
		    boolean isChinese = true; //中英文保单标志
			PrpTmainSchema prpMainSchema = null; //保单/投保单的MainSchema对象
			PrpTrenewalSchema prpRenewalSchema = null; //保单/投保单的RenewalSchema对象
			prpMainSchema = blPolicy.getBLPrpCmain().getArr(0);
			if(blPolicy.getBLPrpCrenewal().getSize()>0){
				 prpRenewalSchema = blPolicy.getBLPrpCrenewal().getArr(0);
			}
			
			claimPolicyDetailInfo.setProposalNo(prpMainSchema.getProposalNo());////投保单号
			claimPolicyDetailInfo.setPolicyNo(blPolicy.getBLPrpCmain().getArr(0).getPolicyNo());//保单号
			String strRiskCode = prpMainSchema.getRiskCode(); //险种代码
			String strRiskName = blPrpDrisk.translateCode(strRiskCode,true);//险种名称
			claimPolicyDetailInfo.setRiskName(strRiskName);
			claimPolicyDetailInfo.setGroupNo(prpMainSchema.getGroupNo());//协议号
			claimPolicyDetailInfo.setLanguage(prpMainSchema.getLanguage());//语种
			claimPolicyDetailInfo.setPolicySort(prpMainSchema.getPolicySort());//保单种类
			claimPolicyDetailInfo.setBusinessType(prpMainSchema.getBusinessType());//业务类型
			claimPolicyDetailInfo.setBusinessType1(prpMainSchema.getBusinessType1());//政策/商业标志
		    String strRenewalFlag = "0"; //续保标识：0 非续保 1 续保
		    String strOldPolicyNoRenewal = "";//续保保单号
		    if(null != prpRenewalSchema){
		    	strRenewalFlag = "1";
		    	strOldPolicyNoRenewal = prpRenewalSchema.getOldPolicyNo();
		    }
		    claimPolicyDetailInfo.setRenewalFlag(strRenewalFlag);
		    claimPolicyDetailInfo.setOldPolicyNoRenewal(strOldPolicyNoRenewal);
		    //归属机构
		    String comCode = prpMainSchema.getComCode();
		    String comName = blPrpDcompany.translateCode(comCode,isChinese);
		    claimPolicyDetailInfo.setComCode(comCode);
		    claimPolicyDetailInfo.setComName(comName);
		    //归属业务员
		    String handler1Code = prpMainSchema.getHandler1Code();
		    String handler1Name = blPrpDuser.translateCode(handler1Code,isChinese);
		    claimPolicyDetailInfo.setHandler1Code(handler1Code);
		    claimPolicyDetailInfo.setHandler1Name(handler1Name);
		    //实际业务员
		    String handlerCode = prpMainSchema.getHandlerCode();
		    String handlerName = blPrpDuser.translateCode(handlerCode,isChinese);
		    claimPolicyDetailInfo.setHandlerCode(handlerCode);
		    claimPolicyDetailInfo.setHandlerName(handlerName);
		    
		    claimPolicyDetailInfo.setBusinessNature(prpMainSchema.getBusinessNature());//业务来源
		    String agentCode = prpMainSchema.getAgentCode();//代理人/经纪人 
		    String agentName = blPrpDagent.translateCode(agentCode,isChinese);
		    claimPolicyDetailInfo.setAgentCode(prpMainSchema.getAgentCode());
		    claimPolicyDetailInfo.setAgentName(Str.encode(agentName));
		    claimPolicyDetailInfo.setAgreementNo(prpMainSchema.getAgreementNo());
		    String strGroupFlag = prpMainSchema.getGroupFlag(); //业务大类
		    ArrayList<String> strGroupFlagList = new ArrayList<String>();
		    if(null != strGroupFlag && !"".equals(strGroupFlag)){
		    	blPrpDcode.query(" codetype='BusinessCategory'");
		    	 for(int i = 0;i<blPrpDcode.getSize();i++){
		    		 if("1".equals(strGroupFlag.substring(i,i+1))){
		    			 strGroupFlagList.add(blPrpDcode.getArr(i).getCodeCName());
		    		 }
		    	 }
		    }
		    if(null != strGroupFlagList && strGroupFlagList.size()>0){
		    	String[] groupFlag = new String[strGroupFlagList.size()];
		    	for(int i=0;i<strGroupFlagList.size();i++){
		    		groupFlag[i] = strGroupFlagList.get(i);
		    	}
		    	claimPolicyDetailInfo.setGroupFlag(groupFlag);
		    }
		    
		    String strLimitAmount=new DecimalFormat("0.00").format(Double.parseDouble(ChgData.chgStrZero(prpMainSchema.getLimitAmount())));//每次事故责任限额
		    String strSumAmount = new DecimalFormat("0.00").format(Double.parseDouble(ChgData.chgStrZero(prpMainSchema.getSumAmount())));//累计赔偿限额,总保险金额
		    String strSumPremium = new DecimalFormat("0.00").format(Double.parseDouble(ChgData.chgStrZero(prpMainSchema.getSumPremium())));//总保险费
		    claimPolicyDetailInfo.setLimitAmount(strLimitAmount);
		    claimPolicyDetailInfo.setSumAmount(strSumAmount);
		    claimPolicyDetailInfo.setSumPremium(strSumPremium);
		    
		    //ZH信息
		    claimPolicyDetailInfo.setSumQuantity(prpMainSchema.getSumQuantity());//投保份数
		    claimPolicyDetailInfo.setDiscount(prpMainSchema.getDiscount());//优惠系数
		    claimPolicyDetailInfo.setThirdKnow(prpMainSchema.getThirdKnow());//是否通过第三方识别
		    claimPolicyDetailInfo.setAllinsFlag(prpMainSchema.getAllinsFlag());
		    BLPrpCmainCasualty blPrpCmainCasualty = blPolicy.getBLPrpCmainCasualty();
		    if(blPrpCmainCasualty.getSize()>0){
		    	PrpTmainCasualtySchema mainCasualtySchema = blPrpCmainCasualty.getArr(0);
		    	claimPolicyDetailInfo.setZH03SumQuantity(mainCasualtySchema.getMainInsuredCount());//总被保险人数
		    	if("ZH01".equals(strRiskCode)){
		    		String ZHSundoor = mainCasualtySchema.getMainInsuredCount()+"户 ,其中村干部"+mainCasualtySchema.getSubInsuredCount()+"人，家属"+mainCasualtySchema.getRemark()+"人";
		    		claimPolicyDetailInfo.setZHSumDoor(ZHSundoor);//被保险人户数信息
		    	}else{
		    		claimPolicyDetailInfo.setZHSumDoor(mainCasualtySchema.getUnitCount());//被保险人户数信息
		    	}
		    	claimPolicyDetailInfo.setInsuranceCode(mainCasualtySchema.getRemark());//清单号
		    	claimPolicyDetailInfo.setUnitCount(mainCasualtySchema.getUnitCount());//单位总人数
		    }
		    
		    String policyType = new BLPrpDcode().getOptionCode("PolicyType",strRiskCode);
		    claimPolicyDetailInfo.setPolicyType(policyType);
		    String autoTransRenewFlag = prpMainSchema.getAutoTransRenewFlag();//付款方式
		    String autoTransRenewFlagName = "";
		    if("1".equals(autoTransRenewFlag)){
		    	autoTransRenewFlagName = "现金";
		    }else if("2".equals(autoTransRenewFlag)){
		    	autoTransRenewFlagName = "银行转账";
		    }else if("3".equals(autoTransRenewFlag)){
		    	autoTransRenewFlagName = "支票";
		    }else if("4".equals(autoTransRenewFlag)){
		    	autoTransRenewFlagName = "实时代收";
		    }else if("5".equals(autoTransRenewFlag)){
		    	autoTransRenewFlagName = "批次扣款";
		    }else if("9".equals(autoTransRenewFlag)){
		    	autoTransRenewFlagName = "其他";
		    }
		    claimPolicyDetailInfo.setAutoTransRenewFlag(autoTransRenewFlagName);
		    
		    //0908车辆信息
		    BLPrpCmainCargo bLPrpCmainCargo = blPolicy.getBLPrpCmainCargo();
		    if(bLPrpCmainCargo.getSize()>0){
		    	PrpTmainCargoSchema prpmainCargoSchema = bLPrpCmainCargo.getArr(0);
		    	ClaimPolicyMainCargoInfo claimPolicyMainCargoInfo = new ClaimPolicyMainCargoInfo();
		    	claimPolicyMainCargoInfo.setDeviceNoID(prpmainCargoSchema.getCreditNo());
		    	claimPolicyMainCargoInfo.setMakeFactoryID(prpmainCargoSchema.getBargainNo());
		    	claimPolicyMainCargoInfo.setModelID(prpmainCargoSchema.getConveyance());
		    	claimPolicyMainCargoInfo.setCapaCityID(prpmainCargoSchema.getTransferConveyance());
		    	claimPolicyDetailInfo.setClaimPolicyMainCargoInfo(claimPolicyMainCargoInfo);
		    }
		    
		    //投保人，被保险人信息
		    PrpTinsuredSchema prpInsuredSchema = null;
		    PrpTinsuredSchema prpInsuredSchemaAppliInsured = null;
		    PrpTinsuredArtifSchema prpInsuredArtifSchema = null;
		    DBPrpDcustomLevelTrace dbPrpDcustomLevelTrace = new DBPrpDcustomLevelTrace();
		    
		    BLPrpCinsured blPrpCinsured = blPolicy.getBLPrpCinsured();
		    int intInsuredCount = blPrpCinsured.getSize();
		    for(int index=0;index<intInsuredCount;index++){
		    	 prpInsuredSchema = blPrpCinsured.getArr(index);
		    	//如果是投保人，给变量prpInsuredSchemaAppliInsured赋值，然后继续
		    	 if(prpInsuredSchema.getInsuredFlag().equals("2"))
		    	 {
		    	     prpInsuredSchemaAppliInsured = prpInsuredSchema;
		    	     continue;
		    	 }else if (prpInsuredSchema.getInsuredNature().equals("4")){//法人
		    		 BLPrpCinsuredArtif blPrpCinsuredArtif = blPolicy.getBLPrpCinsuredArtif();
		    		 for (int i=0;i<blPrpCinsuredArtif.getSize();i++)
		             {
		               if (prpInsuredSchema.getSerialNo().equals(blPrpCinsuredArtif.getArr(i).getSerialNo()))
		               {
		                 prpInsuredArtifSchema = blPrpCinsuredArtif.getArr(i);
		                 break;
		               }
		             }
		    	 }
		    }
		    //投保人信息
		    ClaimPolicyAppliInsuredInfo claimPolicyAppliInsuredInfo = new ClaimPolicyAppliInsuredInfo();
		    claimPolicyAppliInsuredInfo.setAppliInsuredCode(prpInsuredSchemaAppliInsured.getInsuredCode());//客户代码
		    claimPolicyAppliInsuredInfo.setAppliInsuredName(Str.encode(prpInsuredSchemaAppliInsured.getInsuredName()));//客户名称
		    String strInsuredType = prpInsuredSchemaAppliInsured.getInsuredType();
		    String appliInsuredInsuredType = blPrpDcode.translateCode("InsuredType",strInsuredType,isChinese);//客户类型
		    claimPolicyAppliInsuredInfo.setAppliInsuredType(appliInsuredInsuredType);
		    //01身份证,02户口簿,03护照,04军官证,05驾驶执照,06返乡证,59其它,61组织机构代码证,62税务登记证,99其它
		    claimPolicyAppliInsuredInfo.setAppliIdentifyType(prpInsuredSchemaAppliInsured.getIdentifyType());//证件类型
		    claimPolicyAppliInsuredInfo.setAppliInsuredNature(prpInsuredSchema.getInsuredNature());//客户性质
		    claimPolicyAppliInsuredInfo.setAppliIdentifyNumber(prpInsuredSchemaAppliInsured.getIdentifyNumber());//证件号码
		    String appliInsuredLanguage = blPrpDcode.translateCode("Language",prpInsuredSchemaAppliInsured.getLanguage(),isChinese);;//客户语种
		    claimPolicyAppliInsuredInfo.setAppliInsuredLanguage(appliInsuredLanguage);
		    claimPolicyAppliInsuredInfo.setAppliInsuredAddress(Str.encode(prpInsuredSchemaAppliInsured.getInsuredAddress()));//客户地址
		    claimPolicyAppliInsuredInfo.setAppliInsuredBank(prpInsuredSchemaAppliInsured.getBank());//开户银行
		    claimPolicyAppliInsuredInfo.setAppliInsuredAccount(prpInsuredSchemaAppliInsured.getAccount());//账号
		    claimPolicyAppliInsuredInfo.setAppliInsuredLinkerName(Str.encode(prpInsuredSchemaAppliInsured.getLinkerName()));//联系人姓名
		    claimPolicyAppliInsuredInfo.setAppliInsuredPostAddress(Str.encode(prpInsuredSchemaAppliInsured.getPostAddress()));//联系人地址
		    claimPolicyAppliInsuredInfo.setAppliInsuredPostCode(prpInsuredSchemaAppliInsured.getPostCode());//联系人邮编
		    claimPolicyAppliInsuredInfo.setAppliInsuredPhoneNumber(prpInsuredSchemaAppliInsured.getPhoneNumber());//联系人电话
		    claimPolicyAppliInsuredInfo.setAppliInsuredMobile(prpInsuredSchemaAppliInsured.getMobile());//联系人手机
		    String strRiskLevelCode = dbPrpDcustomLevelTrace.findRiskLevelByCode(prpInsuredSchemaAppliInsured.getInsuredCode());//投保人风险等级
		    String appliInsuredRiskLevel =  blPrpDcode.translateCode("RiskLevel",strRiskLevelCode,isChinese);
		    claimPolicyAppliInsuredInfo.setAppliInsuredRiskLevel(appliInsuredRiskLevel);
		    
		    claimPolicyAppliInsuredInfo.setAppliBusinessSource(prpInsuredSchema.getBusinessSource());
		    claimPolicyAppliInsuredInfo.setAppliBusinessSourceName(blPrpDcode.translateCode("BusinessType",prpInsuredSchema.getBusinessSource(),true));
		   
		    if(null != prpInsuredArtifSchema){
		    	claimPolicyAppliInsuredInfo.setAppliCarType(prpInsuredArtifSchema.getCarType());
			    claimPolicyAppliInsuredInfo.setAppliALeaderName(prpInsuredArtifSchema.getLeaderName());
			    claimPolicyAppliInsuredInfo.setAppliAPhoneNumber(prpInsuredArtifSchema.getPhoneNumber());
			    claimPolicyAppliInsuredInfo.setAppliAPostCode(prpInsuredArtifSchema.getPostCode());
		    }
		    
		    claimPolicyDetailInfo.setClaimPolicyAppliInsuredInfo(claimPolicyAppliInsuredInfo);
		    
		    //被保险人信息
		    ClaimPolicyInsuredInfo claimPolicyInsuredInfo = new ClaimPolicyInsuredInfo();
		    claimPolicyInsuredInfo.setInsuredCode(prpInsuredSchema.getInsuredCode());
		    claimPolicyInsuredInfo.setInsuredName(Str.encode(prpInsuredSchema.getInsuredName()));
		    String insuredType =blPrpDcode.translateCode("InsuredType",prpInsuredSchema.getInsuredType(),isChinese);
		    claimPolicyInsuredInfo.setInsuredType(insuredType);
		    String insuredFlag = blPrpDcode.translateCode("InsuredFlag",prpInsuredSchema.getInsuredFlag(),isChinese);
		    claimPolicyInsuredInfo.setInsuredFlag(insuredFlag);
		    String insuredLanguage = blPrpDcode.translateCode("Language",prpInsuredSchema.getLanguage(),isChinese);
		    claimPolicyInsuredInfo.setInsuredLanguage(insuredLanguage);
		    claimPolicyInsuredInfo.setIdentifyNumber(prpInsuredSchema.getIdentifyNumber());
		    claimPolicyInsuredInfo.setInsuredAddress(Str.encode(prpInsuredSchema.getInsuredAddress()));
		    claimPolicyInsuredInfo.setInsuredBank(Str.encode(prpInsuredSchema.getBank()));
		    claimPolicyInsuredInfo.setInsuredAccount(prpInsuredSchema.getAccount());
		    claimPolicyInsuredInfo.setInsuredLinkerName(Str.encode(prpInsuredSchema.getLinkerName()));
		    claimPolicyInsuredInfo.setInsuredPostAddress(Str.encode(prpInsuredSchema.getPostAddress()));
		    claimPolicyInsuredInfo.setInsuredPostCode(prpInsuredSchema.getPostCode());
		    claimPolicyInsuredInfo.setInsuredPhoneNumber(prpInsuredSchema.getPhoneNumber());
		    claimPolicyInsuredInfo.setInsuredMobile(prpInsuredSchema.getMobile());
		    String riskLevel = dbPrpDcustomLevelTrace.findRiskLevelByCode(prpInsuredSchema.getInsuredCode());//被保险人风险等级
		    String insuredRiskLevel =blPrpDcode.translateCode("RiskLevel",riskLevel,isChinese);
		    claimPolicyInsuredInfo.setInsuredRiskLevel(insuredRiskLevel);
		    claimPolicyInsuredInfo.setIdentifyType(prpInsuredSchema.getIdentifyType());
		    claimPolicyInsuredInfo.setInsuredNature(prpInsuredSchema.getInsuredNature());
		    claimPolicyInsuredInfo.setInsuredIdentity(blPrpDcode.translateCode("InsuredIdentity",prpInsuredSchema.getInsuredIdentity(),true));
		    if(null != prpInsuredArtifSchema){
		    	claimPolicyInsuredInfo.setALeaderName(prpInsuredArtifSchema.getLeaderName());
		    	claimPolicyInsuredInfo.setALeaderID(prpInsuredArtifSchema.getLeaderID());
		    }
		    claimPolicyDetailInfo.setClaimPolicyInsuredInfo(claimPolicyInsuredInfo);
		    
		    
		    //被保险财产坐落地址
		    BLPrpCaddress blPrpCaddress = blPolicy.getBLPrpCaddress();
		    int intSize = blPrpCaddress.getSize();
		    
		    ClaimPolicyInsuredAddressInfo[] claimPolicyInsuredAddressInfoList = null;
		    if(intSize>0){
		    	claimPolicyInsuredAddressInfoList = new ClaimPolicyInsuredAddressInfo[intSize];
			    for(int index=0;index<intSize;index++){
			    	PrpTaddressSchema prpAddressSchema = blPrpCaddress.getArr(index);
			    	ClaimPolicyInsuredAddressInfo claimPolicyInsuredAddressInfo = new ClaimPolicyInsuredAddressInfo();
			    	claimPolicyInsuredAddressInfo.setAddressCode(prpAddressSchema.getAddressCode());//邮政编码
			    	claimPolicyInsuredAddressInfo.setAddressName(Str.encode(prpAddressSchema.getAddressName()));//地址
			    	claimPolicyInsuredAddressInfoList[index] = claimPolicyInsuredAddressInfo;
			    }
			    claimPolicyDetailInfo.setClaimPolicyInsuredAddressInfoList(claimPolicyInsuredAddressInfoList);
		    }
		    
		    String startDate = prpMainSchema.getStartDate() +"日"+prpMainSchema.getStartHour()+"时"+prpMainSchema.getStartMinute()+"分";
		    String endDate = prpMainSchema.getEndDate() +"日"+prpMainSchema.getEndHour()+"时"+prpMainSchema.getEndMinute()+"分";
		    claimPolicyDetailInfo.setStartDate(startDate);
		    claimPolicyDetailInfo.setEndDate(endDate);
		    claimPolicyDetailInfo.setOperateDate(prpMainSchema.getOperateDate());//投保日期
		    claimPolicyDetailInfo.setSignDate(prpMainSchema.getSignDate());//制单日期
		    
		    if(blPolicy.getBLPrpCmainProp().getSize()>0){
		    	PrpTmainPropSchema prpMainPropSchema = blPolicy.getBLPrpCmainProp().getArr(0);
		    	 String businessSource = prpMainPropSchema.getBusinessSource();
		    	 String businessSourceName = blPrpDcode.translateCode("BusinessSource",businessSource,isChinese);
		    	 claimPolicyDetailInfo.setBusinessSource(businessSource);
		    	 claimPolicyDetailInfo.setBusinessSourceName(businessSourceName);//企业类别
		    	 String businessSort = prpMainPropSchema.getBusinessSort();
		    	 String businessSortName = blPrpDcode.translateCode("BusinessSort",businessSort,isChinese);
		    	 claimPolicyDetailInfo.setBusinessSort(businessSort);
		    	 claimPolicyDetailInfo.setBusinessSortName(businessSortName);//01营业性质 被保险人企业性质
		    	 String possessNature = prpMainPropSchema.getPossessNature();
		    	 String possessNatureName = blPrpDcode.translateCode("PossessNature",possessNature,isChinese);
		    	 claimPolicyDetailInfo.setPossessNature(possessNature);
		    	 claimPolicyDetailInfo.setPossessNatureName(possessNatureName);//财产占用性质
		    	 claimPolicyDetailInfo.setBusinessDetail(prpMainPropSchema.getBusinessDetail());//营业性质
		    }
		    
		    //专用-责任附加险信息
		    if(blPolicy.getBLPrpCmainLiab().getSize()>0){
		    	PrpTmainLiabSchema prpMainLiabSchema = blPolicy.getBLPrpCmainLiab().getArr(0);
		    	ClaimPolicyMainLiabInfo claimPolicyMainLiabInfo = new ClaimPolicyMainLiabInfo();
		    	claimPolicyMainLiabInfo.setBusinessDetail(prpMainLiabSchema.getBusinessDetail());
		    	claimPolicyMainLiabInfo.setInsureArea(prpMainLiabSchema.getInsureArea());
		    	claimPolicyMainLiabInfo.setElectricPower(new DecimalFormat("0").format(Double.parseDouble(Str.chgStrZero(prpMainLiabSchema.getElectricPower()))));
		    	claimPolicyMainLiabInfo.setStaffCount(new DecimalFormat("0").format(Double.parseDouble(Str.chgStrZero(prpMainLiabSchema.getStaffCount()))));
		    	
		    	claimPolicyDetailInfo.setClaimPolicyMainLiabInfo(claimPolicyMainLiabInfo);
		    }
		    
		    //保险标的信息 /1526-运输工具信息
		    if(blPolicy.getBLPrpCitemDevice().getSize() > 0){
		    	ClaimPolicyItemDeviceInfo[] claimPolicyItemDeviceInfoList = null;
		    	if("1526".equals(strRiskCode) || "0908".equals(strRiskCode) || "1536".equals(strRiskCode)){
		    		claimPolicyItemDeviceInfoList = new ClaimPolicyItemDeviceInfo[blPolicy.getBLPrpCitemDevice().getSize()];
			    	for(int i=0;i<blPolicy.getBLPrpCitemDevice().getSize();i++){
			    		PrpTitemDeviceSchema prpItemdeviceSchema1 = blPolicy.getBLPrpCitemDevice().getArr(i);
				    	ClaimPolicyItemDeviceInfo claimPolicyItemDeviceInfo1 = new ClaimPolicyItemDeviceInfo();
				    	
				    	claimPolicyItemDeviceInfo1.setItemNo(prpItemdeviceSchema1.getItemNo());
				    	claimPolicyItemDeviceInfo1.setPreUseTemperature(new DecimalFormat("0").format(Double.parseDouble(prpItemdeviceSchema1.getPreUseTemperature())));
				    	claimPolicyItemDeviceInfo1.setFuelName(prpItemdeviceSchema1.getFuelName());
				    	claimPolicyItemDeviceInfo1.setProductWorkshop(prpItemdeviceSchema1.getMakeFactory());
				    	claimPolicyItemDeviceInfo1.setProductName(prpItemdeviceSchema1.getDeviceName());
				    	claimPolicyItemDeviceInfo1.setProductModel(prpItemdeviceSchema1.getModel());
				    	claimPolicyItemDeviceInfo1.setFactoryNo(prpItemdeviceSchema1.getDeviceNo());
				    	claimPolicyItemDeviceInfo1.setUseAddress(prpItemdeviceSchema1.getUsage());
				    	
				    	claimPolicyItemDeviceInfoList[i] = claimPolicyItemDeviceInfo1;
			    	}
		    	}else{
		    		claimPolicyItemDeviceInfoList = new ClaimPolicyItemDeviceInfo[1];
		    		PrpTitemDeviceSchema prpItemdeviceSchema = blPolicy.getBLPrpCitemDevice().getArr(0);
			    	ClaimPolicyItemDeviceInfo claimPolicyItemDeviceInfo = new ClaimPolicyItemDeviceInfo();
			    	claimPolicyItemDeviceInfo.setHolder(prpItemdeviceSchema.getHolder());
			    	claimPolicyItemDeviceInfo.setPawner(prpItemdeviceSchema.getPawner());
			    	claimPolicyItemDeviceInfo.setProductWorkshop(prpItemdeviceSchema.getMakeFactory());
			    	claimPolicyItemDeviceInfo.setProductName(prpItemdeviceSchema.getDeviceName());
			    	claimPolicyItemDeviceInfo.setFactoryDate(prpItemdeviceSchema.getMakeDate());
			    	claimPolicyItemDeviceInfo.setProductModel(prpItemdeviceSchema.getModel());
			    	claimPolicyItemDeviceInfo.setFactoryNo(prpItemdeviceSchema.getDeviceNo());
			    	claimPolicyItemDeviceInfo.setEngineNo(prpItemdeviceSchema.getEngineNo());
			    	claimPolicyItemDeviceInfo.setUnderpanNo(prpItemdeviceSchema.getUnderpanNo());
			    	claimPolicyItemDeviceInfo.setFrameNo(prpItemdeviceSchema.getFrameNo());
			    	claimPolicyItemDeviceInfo.setUseAddress(prpItemdeviceSchema.getUsage());
			    	claimPolicyItemDeviceInfo.setYearOldRate(prpItemdeviceSchema.getYearoldRate());
			    	claimPolicyItemDeviceInfo.setUseArea(prpItemdeviceSchema.getRemark());
			    	claimPolicyItemDeviceInfo.setGPS(prpItemdeviceSchema.getGPS());
			    	claimPolicyItemDeviceInfo.setLimitYear(prpItemdeviceSchema.getMakeYear());
			    	claimPolicyItemDeviceInfoList[0] = claimPolicyItemDeviceInfo;
		    	}
		    	claimPolicyDetailInfo.setClaimPolicyItemDeviceInfoList(claimPolicyItemDeviceInfoList);
		    }
		    
		    //主险
		    BLPrpDitem blPrpDitem = new BLPrpDitem();
		    BLPrpCitemKind blPrpCitemKind = blPolicy.getBLPrpCitemKind();
		    UIItemKindSeparator uiItemKindSeparator = new UIItemKindSeparator(blPrpCitemKind);
		    if("ZH01".equals(strRiskCode) || "ZH02".equals(strRiskCode)){
		    	ArrayList<ClaimPolicyItemKindZHMainInfo> zhlist = new ArrayList<ClaimPolicyItemKindZHMainInfo>();
		    	
		    	if("ZH02".equals(strRiskCode)){
		    		BLPrpCitemKind blPrpCitemKindMain2603= uiItemKindSeparator.getBlPrpCitemKindMain2603();
			    	if(blPrpCitemKindMain2603.getSize()>0){
			    		for(int i=0;i<blPrpCitemKindMain2603.getSize();i++){
			    			ClaimPolicyItemKindZHMainInfo claimPolicyItemKindZHMainInfo = new ClaimPolicyItemKindZHMainInfo();
			    			PrpTitemKindSchema prpItemKindSchema603 = blPrpCitemKindMain2603.getArr(i);
			    			claimPolicyItemKindZHMainInfo.setFlag("1");
			    			claimPolicyItemKindZHMainInfo.setItemKindNoMain(prpItemKindSchema603.getItemKindNo());
			    			claimPolicyItemKindZHMainInfo.setKindCodeMain(prpItemKindSchema603.getKindCode());
			    			claimPolicyItemKindZHMainInfo.setKindNameMain(Str.encode(prpItemKindSchema603.getKindName()));
			    			claimPolicyItemKindZHMainInfo.setRationTypeMain(prpItemKindSchema603.getRationType());
			    			claimPolicyItemKindZHMainInfo.setCurrency(prpItemKindSchema603.getCurrency());
			    			claimPolicyItemKindZHMainInfo.setShortRateFlagMain(prpItemKindSchema603.getShortRateFlag());
			    			claimPolicyItemKindZHMainInfo.setShortRateMain(new DecimalFormat("0.0000").format(Double.parseDouble(prpItemKindSchema603.getShortRate())));
			    			claimPolicyItemKindZHMainInfo.setUnitAmountMain(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema603.getUnitAmount())));
			    			claimPolicyItemKindZHMainInfo.setQuantityMain(new DecimalFormat("0").format(Double.parseDouble(prpItemKindSchema603.getQuantity())));
			    			claimPolicyItemKindZHMainInfo.setAmountMain(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema603.getAmount())));
			    			claimPolicyItemKindZHMainInfo.setRateMain(new DecimalFormat("0.0000").format(Double.parseDouble(prpItemKindSchema603.getRate())));
			    			claimPolicyItemKindZHMainInfo.setPremiumMain(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema603.getPremium())));
			    			claimPolicyItemKindZHMainInfo.setDiscountMain(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema603.getDiscount())));
			    			
			    			zhlist.add(claimPolicyItemKindZHMainInfo);
			    		}
			    	}
		    	}
		    	
		    	BLPrpCitemKind blPrpCitemKindMain2714 = uiItemKindSeparator.getBlPrpCitemKindMain2714();
		    	if(blPrpCitemKindMain2714.getSize()>0){
		    		for(int i=0;i<blPrpCitemKindMain2714.getSize();i++){
		    			ClaimPolicyItemKindZHMainInfo claimPolicyItemKindZHMainInfo = new ClaimPolicyItemKindZHMainInfo();
		    			PrpTitemKindSchema prpItemKindSchema2714 = blPrpCitemKindMain2714.getArr(i);
		    			if("ZH01".equals(strRiskCode)){
		    				claimPolicyItemKindZHMainInfo.setFlag("1");
		    			}else{
		    				claimPolicyItemKindZHMainInfo.setFlag("2");
		    			}
		    			claimPolicyItemKindZHMainInfo.setItemKindNoMain(prpItemKindSchema2714.getItemKindNo());
		    			claimPolicyItemKindZHMainInfo.setKindCodeMain(prpItemKindSchema2714.getKindCode());
		    			claimPolicyItemKindZHMainInfo.setKindNameMain(Str.encode(prpItemKindSchema2714.getKindName()));
		    			claimPolicyItemKindZHMainInfo.setRationTypeMain(prpItemKindSchema2714.getRationType());
		    			claimPolicyItemKindZHMainInfo.setCurrency(prpItemKindSchema2714.getCurrency());
		    			claimPolicyItemKindZHMainInfo.setShortRateFlagMain(prpItemKindSchema2714.getShortRateFlag());
		    			claimPolicyItemKindZHMainInfo.setShortRateMain(new DecimalFormat("0.0000").format(Double.parseDouble(prpItemKindSchema2714.getShortRate())));
		    			claimPolicyItemKindZHMainInfo.setUnitAmountMain(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema2714.getUnitAmount())));
		    			claimPolicyItemKindZHMainInfo.setQuantityMain(new DecimalFormat("0").format(Double.parseDouble(prpItemKindSchema2714.getQuantity())));
		    			claimPolicyItemKindZHMainInfo.setAmountMain(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema2714.getAmount())));
		    			claimPolicyItemKindZHMainInfo.setRateMain(new DecimalFormat("0.0000").format(Double.parseDouble(prpItemKindSchema2714.getRate())));
		    			claimPolicyItemKindZHMainInfo.setPremiumMain(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema2714.getPremium())));
		    			claimPolicyItemKindZHMainInfo.setDiscountMain(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema2714.getDiscount())));
		    			
		    			zhlist.add(claimPolicyItemKindZHMainInfo);
		    		}
		    	}
		    	
		    	BLPrpCitemKind blPrpCitemKindMain0305 = uiItemKindSeparator.getBlPrpCitemKindMain0305();
		    	if(blPrpCitemKindMain0305.getSize()>0){
		    		for(int i=0;i<blPrpCitemKindMain0305.getSize();i++){
		    			ClaimPolicyItemKindZHMainInfo claimPolicyItemKindZHMainInfo = new ClaimPolicyItemKindZHMainInfo();
		    			PrpTitemKindSchema prpItemKindSchema0305 = blPrpCitemKindMain0305.getArr(i);
		    			if("ZH01".equals(strRiskCode)){
		    				claimPolicyItemKindZHMainInfo.setFlag("2");
		    			}else{
		    				claimPolicyItemKindZHMainInfo.setFlag("3");
		    			}
		    			claimPolicyItemKindZHMainInfo.setItemKindNoMain(prpItemKindSchema0305.getItemKindNo());
		    			String itemCode = prpItemKindSchema0305.getItemCode();
		    	        String itemName = blPrpDitem.translateCode(strRiskCode,itemCode,isChinese);
		    			claimPolicyItemKindZHMainInfo.setItemCode(itemCode);
		    			claimPolicyItemKindZHMainInfo.setItemName(itemName);
		    			claimPolicyItemKindZHMainInfo.setAddressNoMain(prpItemKindSchema0305.getAddressNo());
		    			claimPolicyItemKindZHMainInfo.setCurrency(prpItemKindSchema0305.getCurrency());
		    			claimPolicyItemKindZHMainInfo.setBaseAmountMain(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema0305.getUnitAmount())));
		    			claimPolicyItemKindZHMainInfo.setSumDoorMain(new DecimalFormat("0").format(Double.parseDouble(prpItemKindSchema0305.getQuantity())));
		    			claimPolicyItemKindZHMainInfo.setAmountMain(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema0305.getAmount())));
		    			claimPolicyItemKindZHMainInfo.setRateMain(new DecimalFormat("0.0000").format(Double.parseDouble(prpItemKindSchema0305.getRate())));
		    			claimPolicyItemKindZHMainInfo.setPremiumMain(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema0305.getPremium())));
		    			
		    			zhlist.add(claimPolicyItemKindZHMainInfo);
		    		}
		    	}
		    	
		    	if(null != zhlist && zhlist.size()>0){
		    		ClaimPolicyItemKindZHMainInfo[] claimPolicyItemKindZHMainInfoList = new ClaimPolicyItemKindZHMainInfo[zhlist.size()];
		    		for(int i=0;i<zhlist.size();i++){
		    			claimPolicyItemKindZHMainInfoList[i] = zhlist.get(i);
		    		}
		    		claimPolicyDetailInfo.setClaimPolicyItemKindZHMainInfoList(claimPolicyItemKindZHMainInfoList);
		    	}
		    	
		    }else{
		    	BLPrpCitemKind blPrpCitemKindMain = uiItemKindSeparator.getCMain();
				   
			    ClaimPolicyItemKindMainInfo[] claimPolicyItemKindMainInfoList = null;
			    if(blPrpCitemKindMain.getSize()>0){
			    	claimPolicyItemKindMainInfoList = new ClaimPolicyItemKindMainInfo[blPrpCitemKindMain.getSize()];
			    	for(int i=0;i<blPrpCitemKindMain.getSize();i++){
			    		ClaimPolicyItemKindMainInfo claimPolicyItemKindMainInfo = new ClaimPolicyItemKindMainInfo();
			    		PrpTitemKindSchema prpItemKindSchema = blPrpCitemKindMain.getArr(i);
				    	
			    		claimPolicyItemKindMainInfo.setItemKindNoMain(prpItemKindSchema.getItemKindNo());//标的序号
				    	String itemCode = blPrpDitem.translateCode(strRiskCode,prpItemKindSchema.getItemCode(),isChinese);//标的类别
				    	claimPolicyItemKindMainInfo.setItemCode(itemCode);
				    	String itemName = blPrpDitem.translateCode(strRiskCode,itemCode,isChinese);
				    	String itemNameMain = Str.encode(prpItemKindSchema.getItemDetailName())==null?Str.encode(itemName):Str.encode(prpItemKindSchema.getItemDetailName());
				    	claimPolicyItemKindMainInfo.setItemDetailName(itemNameMain);//标的名称
				    	claimPolicyItemKindMainInfo.setAddressNo(prpItemKindSchema.getAddressNo());//地址序号
				    	claimPolicyItemKindMainInfo.setCurrency(prpItemKindSchema.getCurrency());//币别
				    	claimPolicyItemKindMainInfo.setAmount(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema.getAmount())));//保额
				    	claimPolicyItemKindMainInfo.setPremium(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema.getPremium())));//保费
				    	claimPolicyItemKindMainInfo.setRate(new DecimalFormat("0.0000").format(Double.parseDouble(prpItemKindSchema.getRate())));//年费率
				    	claimPolicyItemKindMainInfo.setModeCodeMain(prpItemKindSchema.getModeCode());
				    	claimPolicyItemKindMainInfo.setModeNameMain(Str.encode(prpItemKindSchema.getModeName()));
				    	
				    	claimPolicyItemKindMainInfo.setQuantityMain(new DecimalFormat("0").format(Str.round(Double.parseDouble(prpItemKindSchema.getQuantity()),0)));
				    	claimPolicyItemKindMainInfo.setKindCodeMain(prpItemKindSchema.getKindCode());
				    	claimPolicyItemKindMainInfo.setKindNameMain(Str.encode(prpItemKindSchema.getKindName()));
				    	//1,短期费率表 2,日比例 3,不计,4,月比例
				    	claimPolicyItemKindMainInfo.setShortRateFlagMain(prpItemKindSchema.getShortRateFlag());
				    	claimPolicyItemKindMainInfo.setShortRateMain(new DecimalFormat("0.0000").format(Double.parseDouble(prpItemKindSchema.getShortRate())));
				    	
				    	BLPrpClimit blPrpClimit = blPolicy.getBLPrpClimit();
				    	if(blPrpClimit.getSize()>0){
				    		for(int j=0;j<blPrpClimit.getSize();j++){
				    			PrpTlimitSchema prpLimitSchema = blPrpClimit.getArr(j);
				    			if(Integer.parseInt(prpLimitSchema.getLimitNo())!=Integer.parseInt(prpItemKindSchema.getItemKindNo())){
				    				 continue;
				    			}
				    			String limitFee = new DecimalFormat("0.00").format(Double.parseDouble(prpLimitSchema.getLimitFee()));
				    			if(prpLimitSchema.getLimitType().equals("04")){ //累计赔偿限额
				    				claimPolicyItemKindMainInfo.setLimitType04Main(limitFee);
				    			}else if(prpLimitSchema.getLimitType().equals("01")){ //每次事故赔偿限额
				    				claimPolicyItemKindMainInfo.setLimitType01Main(limitFee);
				    			}else if(prpLimitSchema.getLimitType().equals("03")){ //每次事故财产损失赔偿限额
				    				claimPolicyItemKindMainInfo.setLimitType03Main(limitFee);
				    			}else if(prpLimitSchema.getLimitType().equals("07")){ //每次事故人身伤亡赔偿限额
				    				claimPolicyItemKindMainInfo.setLimitType07Main(limitFee);
				    			}else if(prpLimitSchema.getLimitType().equals("02")){ //每次事故每人人身伤亡赔偿限额
				    				claimPolicyItemKindMainInfo.setLimitType02Main(limitFee);
				    			}else if(prpLimitSchema.getLimitType().equals("05")){ //每次事故财产损失免赔额
				    				
				    			}else if(prpLimitSchema.getLimitType().equals("12")){ //每次事故财产损失免赔率
				    				
				    			}else if(prpLimitSchema.getLimitType().equals("26")){ //1526-每人责任限额
				    				claimPolicyItemKindMainInfo.setLimitType26Main(limitFee);
				    			}  
				    		}
				    	}
				    	
				    	claimPolicyItemKindMainInfo.setBaseAmountMain(new DecimalFormat("0").format(Double.parseDouble(prpItemKindSchema.getValue())));
				    	claimPolicyItemKindMainInfo.setPayAdjustrateMain(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema.getUnitPersonAmount())));
				    	claimPolicyItemKindMainInfo.setRiskAdjustrateMain(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema.getUnitPersonLimitAmount())));
				    	claimPolicyItemKindMainInfo.setSigleBasePremiumMain(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema.getBenchMarkPremium())));
				    	claimPolicyItemKindMainInfo.setBasePremiumMain(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema.getBasePremium())));
				    	claimPolicyItemKindMainInfo.setDiscountMain(prpItemKindSchema.getDiscount());
				    	claimPolicyItemKindMainInfo.setFamilyNameMain(Str.encode(prpItemKindSchema.getFamilyName()));
				    	claimPolicyItemKindMainInfo.setUnitAmountMain(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema.getUnitAmount())));
				    	claimPolicyItemKindMainInfo.setRationTypeMain(prpItemKindSchema.getRationType());
				    	
				    	claimPolicyItemKindMainInfoList[i] = claimPolicyItemKindMainInfo;
				    }
			    	claimPolicyDetailInfo.setClaimPolicyItemKindMainInfoList(claimPolicyItemKindMainInfoList);
			    }
		    }
		    
		    //免赔额说明
		    BLPrpCengage blPrpCengage = blPolicy.getBLPrpCengage();
	    	UIEngageSeparator engageSeparator = new UIEngageSeparator(blPrpCengage);
	    	BLPrpCengage blPrpCengageT = engageSeparator.getCengageT();
	    	if(blPrpCengageT.getSize()>0){
	    		StringBuffer strBuffer = new StringBuffer();
	    		for(int i=0;i<blPrpCengageT.getSize();i++){
	    			PrpTengageSchema prpEngageSchema = (PrpCengageSchema)blPrpCengageT.getArr(i);
	    			String clauseCode = prpEngageSchema.getClauseCode();
	    			if("0305".equals(strRiskCode)){
	    				if(clauseCode.equals("TX004")){
	    					strBuffer.append(prpEngageSchema.getClauses());   
	    				}
	    			}else{
	    				if(clauseCode.equals("TX001")||clauseCode.equals("TX002")||clauseCode.equals("TX003")||clauseCode.equals("TX004")){
	    					strBuffer.append(prpEngageSchema.getClauses());   
		    			}
	    			}
	    		}
	    		claimPolicyDetailInfo.setTextDeductibleText(strBuffer.toString());
	    	}
	    	
		    //附加险
	    	if("ZH01".equals(strRiskCode) || "ZH02".equals(strRiskCode)){
	    		ArrayList<ClaimPolicyItemKindZHSubInfo> zhlist = new ArrayList<ClaimPolicyItemKindZHSubInfo>();
	    		BLPrpCitemKind blPrpCitemKindSub2714 = uiItemKindSeparator.getBlPrpCitemKindSub2714();
	    		if(blPrpCitemKindSub2714.getSize()>0){
	    			for(int i=0;i<blPrpCitemKindSub2714.getSize();i++){
	    				ClaimPolicyItemKindZHSubInfo claimPolicyItemKindZHSubInfo = new ClaimPolicyItemKindZHSubInfo();
	    				PrpTitemKindSchema prpItemKindSchema2714 = blPrpCitemKindSub2714.getArr(i);
	    				if("ZH01".equals(strRiskCode)){
	    					claimPolicyItemKindZHSubInfo.setFlag("1");
		    			}else{
		    				claimPolicyItemKindZHSubInfo.setFlag("2");
		    			}
	    				claimPolicyItemKindZHSubInfo.setItemKindNoSub(prpItemKindSchema2714.getItemKindNo());
	    				claimPolicyItemKindZHSubInfo.setKindCodeSub(prpItemKindSchema2714.getKindCode());
	    				claimPolicyItemKindZHSubInfo.setKindNameSub(Str.encode(prpItemKindSchema2714.getKindName()));
	    				claimPolicyItemKindZHSubInfo.setRationTypeSub(prpItemKindSchema2714.getRationType());
	    				claimPolicyItemKindZHSubInfo.setCurrencySub(prpItemKindSchema2714.getCurrency());
	    				claimPolicyItemKindZHSubInfo.setShortRateFlagSub(prpItemKindSchema2714.getShortRateFlag());
	    				claimPolicyItemKindZHSubInfo.setShortRateSub(new DecimalFormat("0.0000").format(Double.parseDouble(prpItemKindSchema2714.getShortRate())));
	    				claimPolicyItemKindZHSubInfo.setUnitAmountSub(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema2714.getUnitAmount())));
	    				claimPolicyItemKindZHSubInfo.setQuantitySub(new DecimalFormat("0").format(Double.parseDouble(prpItemKindSchema2714.getQuantity())));
	    				claimPolicyItemKindZHSubInfo.setAmountSub(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema2714.getAmount())));
	    				claimPolicyItemKindZHSubInfo.setRateSub(new DecimalFormat("0.0000").format(Double.parseDouble(prpItemKindSchema2714.getRate())));
	    				claimPolicyItemKindZHSubInfo.setPremiumSub(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema2714.getPremium())));
	    				claimPolicyItemKindZHSubInfo.setDiscountSub(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema2714.getDiscount())));
	    				
	    				zhlist.add(claimPolicyItemKindZHSubInfo);
	    			}
	    		}
	    		BLPrpCitemKind blPrpCitemKindSub0305 = uiItemKindSeparator.getBlPrpCitemKindSub0305();
	    		if(blPrpCitemKindSub0305.getSize()>0){
	    			for(int i=0;i<blPrpCitemKindSub0305.getSize();i++){
	    				ClaimPolicyItemKindZHSubInfo claimPolicyItemKindZHSubInfo = new ClaimPolicyItemKindZHSubInfo();
	    				PrpTitemKindSchema prpItemKindSchema0305 = blPrpCitemKindSub0305.getArr(i);
	    				if("ZH01".equals(strRiskCode)){
	    					claimPolicyItemKindZHSubInfo.setFlag("2");
		    			}else{
		    				claimPolicyItemKindZHSubInfo.setFlag("3");
		    			}
	    				claimPolicyItemKindZHSubInfo.setItemKindNoSub(prpItemKindSchema0305.getItemKindNo());
	    				claimPolicyItemKindZHSubInfo.setKindCodeSub(prpItemKindSchema0305.getKindCode());
	    				claimPolicyItemKindZHSubInfo.setKindNameSub(Str.encode(prpItemKindSchema0305.getKindName()));
	    				claimPolicyItemKindZHSubInfo.setCurrencySub(prpItemKindSchema0305.getCurrency());
	    				claimPolicyItemKindZHSubInfo.setBaseAmountSub(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema0305.getUnitAmount())));
	    				claimPolicyItemKindZHSubInfo.setSumDoorSub(new DecimalFormat("0").format(Double.parseDouble(prpItemKindSchema0305.getQuantity())));
	    				claimPolicyItemKindZHSubInfo.setRateSub(new DecimalFormat("0.0000").format(Double.parseDouble(prpItemKindSchema0305.getRate())));
	    				claimPolicyItemKindZHSubInfo.setPremiumSub(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema0305.getPremium())));
	    				claimPolicyItemKindZHSubInfo.setDiscountSub(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema0305.getDiscount())));
	    				
	    				 String strClauseCode = "F" + prpItemKindSchema0305.getKindCode();
	    				 StringBuffer strBuffer = new StringBuffer();
	    				 strBuffer.setLength(0);
	    				 BLPrpCengage blPrpCengageF = engageSeparator.getCengageF();
	    				 for(int j=0;j<blPrpCengageF.getSize();j++)
	    			     {
	    				     PrpTengageSchema prpEngageSchema  = blPrpCengageF.getArr(j);
	    			         if(!prpEngageSchema.getClauseCode().equals(strClauseCode)){
	    			        	 continue;
	    			         }
	    			         if(prpEngageSchema.getTitleFlag().length()<1){
	    			        	 continue;
	    			         }
	    			         if(!prpEngageSchema.getTitleFlag().substring(0,1).equals("1"))
	    			         {
	    			            continue;
	    			         }
	    			         strBuffer.append(prpEngageSchema.getClauses());
	    			    }
	    				claimPolicyItemKindZHSubInfo.setItemKindSub_Context(strBuffer.toString());
	    				
	    				zhlist.add(claimPolicyItemKindZHSubInfo);
	    			}
	    		}
	    		
	    		if(null != zhlist && zhlist.size()>0){
		    		ClaimPolicyItemKindZHSubInfo[] caimPolicyItemKindZHSubInfo = new ClaimPolicyItemKindZHSubInfo[zhlist.size()];
		    		for(int i=0;i<zhlist.size();i++){
		    			caimPolicyItemKindZHSubInfo[i] = zhlist.get(i);
		    		}
		    		claimPolicyDetailInfo.setClaimPolicyItemKindZHSubInfoList(caimPolicyItemKindZHSubInfo);
		    	}
	    		
	    	}else{
	    		BLPrpCitemKind blPrpCitemKindSub = uiItemKindSeparator.getCSub();
			    ClaimPolicyItemKindSubInfo[] claimPolicyItemKindSubInfoList = null;
			    if(blPrpCitemKindSub.getSize()>0){
			    	BLPrpCengage blPrpCengageF = engageSeparator.getCengageF();
			    	
			    	claimPolicyItemKindSubInfoList = new ClaimPolicyItemKindSubInfo[blPrpCitemKindSub.getSize()];
			    	for(int i=0;i<blPrpCitemKindSub.getSize();i++){
			    		ClaimPolicyItemKindSubInfo claimPolicyItemKindSubInfo = new ClaimPolicyItemKindSubInfo();
			    		PrpTitemKindSchema prpItemKindSchema = blPrpCitemKindSub.getArr(i);
			    		claimPolicyItemKindSubInfo.setItemKindNoSub(prpItemKindSchema.getItemKindNo());
			    		claimPolicyItemKindSubInfo.setKindCodeSub(prpItemKindSchema.getKindCode());
			    		claimPolicyItemKindSubInfo.setKindNameSub(Str.encode(prpItemKindSchema.getKindName()));
			    		claimPolicyItemKindSubInfo.setCurrencySub(prpItemKindSchema.getCurrency());
			    		claimPolicyItemKindSubInfo.setAmountSub(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema.getAmount())));
			    		claimPolicyItemKindSubInfo.setPremiumSub(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema.getPremium())));
			    		claimPolicyItemKindSubInfo.setRateSub(new DecimalFormat("0.0000").format(Double.parseDouble(prpItemKindSchema.getRate())));
			    		
			    		//1,短期费率表 2,日比例 3,不计,4,月比例
			    		claimPolicyItemKindSubInfo.setShortRateFlagSub(prpItemKindSchema.getShortRateFlag());
			    		claimPolicyItemKindSubInfo.setShortRateSub(new DecimalFormat("0.0000").format(Double.parseDouble(prpItemKindSchema.getShortRate())));
			    		
			    		BLPrpClimit blPrpClimit = blPolicy.getBLPrpClimit();
				    	if(blPrpClimit.getSize()>0){
				    		for(int j=0;j<blPrpClimit.getSize();j++){
				    			PrpTlimitSchema prpLimitSchema = blPrpClimit.getArr(j);
				    			if(Integer.parseInt(prpLimitSchema.getLimitNo())!=Integer.parseInt(prpItemKindSchema.getItemKindNo())){
				    				 continue;
				    			}
				    			String limitFee = new DecimalFormat("0.00").format(Double.parseDouble(prpLimitSchema.getLimitFee()));
				    			if(prpLimitSchema.getLimitType().equals("04")){ //累计赔偿限额
				    				claimPolicyItemKindSubInfo.setLimitType04Sub(limitFee);
				    			}else if(prpLimitSchema.getLimitType().equals("01")){ //每次事故赔偿限额
				    				claimPolicyItemKindSubInfo.setLimitType01Sub(limitFee);
				    			}else if(prpLimitSchema.getLimitType().equals("26")){ //每次事故赔偿限额
				    				claimPolicyItemKindSubInfo.setLimitType26Sub(limitFee);
				    			}else if(prpLimitSchema.getLimitType().equals("02")){ //累计责任限额
				    				claimPolicyItemKindSubInfo.setLimitType02Sub(limitFee);
				    			}   
				    		}
				    	}
				    	StringBuffer strBuffer = new StringBuffer();
				    	String strClauseCode = "F"+prpItemKindSchema.getKindCode();
				    	if(blPrpCengageF.getSize()>0){
				    		for(int j=0;j<blPrpCengageF.getSize();j++)
		    			     {
		    				     PrpTengageSchema prpEngageSchema  = blPrpCengageF.getArr(j);
		    			         if(!prpEngageSchema.getClauseCode().equals(strClauseCode)){
		    			        	 continue;
		    			         }
		    			         if(prpEngageSchema.getTitleFlag().length()<1){
		    			        	 continue;
		    			         }
		    			         if(!prpEngageSchema.getTitleFlag().substring(0,1).equals("1"))
		    			         {
		    			            continue;
		    			         }
		    			         strBuffer.append(prpEngageSchema.getClauses());
		    			    }
				    	}
				    	
				    	claimPolicyItemKindSubInfo.setItemKindSub_Context(strBuffer.toString());
				    	claimPolicyItemKindSubInfo.setQuantitySub(new DecimalFormat("0").format(Str.round(Double.parseDouble(prpItemKindSchema.getQuantity()),0)));
				    	claimPolicyItemKindSubInfo.setTransRiskAdjustRateSub(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema.getUnitDayAmountSub())));
				    	claimPolicyItemKindSubInfo.setScaleAdjustRateSub(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema.getUnitAmount())));
				    	claimPolicyItemKindSubInfo.setPayAdjustRateSub(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema.getUnitPersonAmount())));
				    	claimPolicyItemKindSubInfo.setRiskAdjustRateSub(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema.getUnitPersonLimitAmount())));
				    	claimPolicyItemKindSubInfo.setDiscountSub(prpItemKindSchema.getDiscount());
				    	claimPolicyItemKindSubInfo.setFamilyNameSub(prpItemKindSchema.getFamilyName());
				    	claimPolicyItemKindSubInfo.setUnitAmountSub(new DecimalFormat("0.00").format(Double.parseDouble(prpItemKindSchema.getUnitAmount())));
				    	claimPolicyItemKindSubInfo.setRationTypeSub(prpItemKindSchema.getRationType());
				    	
				    	claimPolicyItemKindSubInfoList[i] = claimPolicyItemKindSubInfo;
			    	}
			    	claimPolicyDetailInfo.setClaimPolicyItemKindSubInfoList(claimPolicyItemKindSubInfoList);
			    }
	    	}
		    
		    //币别信息
		    BLPrpDcurrency blPrpDcurrency = new BLPrpDcurrency();
		    BLPrpCfee blPrpCfee = blPolicy.getBLPrpCfee();
		    ClaimPolicyDcurrencyInfo[] claimPolicyDcurrencyInfoList = null;
		    double sumPremium = 0;
		    if(blPrpCfee.getSize()>0){
		    	String sumCurrency = "";
		    	String payCurrency = "";
		    	claimPolicyDcurrencyInfoList = new ClaimPolicyDcurrencyInfo[blPrpCfee.getSize()];
		    	for(int i=0;i<blPrpCfee.getSize();i++){
		    		ClaimPolicyDcurrencyInfo claimPolicyDcurrencyInfo = new ClaimPolicyDcurrencyInfo();
		    		PrpTfeeSchema prpFeeSchema = blPrpCfee.getArr(i);
		    		
		    		if(sumCurrency.length()==0){
		    			sumCurrency = prpFeeSchema.getCurrency2();
		    		}
		    		if(payCurrency.length()==0){
		    			payCurrency = prpFeeSchema.getCurrency1(); 	
		    		}
		    		
		    		claimPolicyDcurrencyInfo.setCurrency(prpFeeSchema.getCurrency());//币别
		    		claimPolicyDcurrencyInfo.setCurrencyName(blPrpDcurrency.translateCode(prpFeeSchema.getCurrency(),isChinese));//币别名称
		    		claimPolicyDcurrencyInfo.setAmout(ChgData.chgStrZero(prpFeeSchema.getAmount()));//保额
		    		claimPolicyDcurrencyInfo.setPremium(ChgData.chgStrZero(prpFeeSchema.getPremium()));//保费
			    	//汇总币别
		    		claimPolicyDcurrencyInfo.setSumExchangeRate(ChgData.chgStrZero(prpFeeSchema.getExchangeRate2()));
		    		claimPolicyDcurrencyInfo.setSumAmout(ChgData.chgStrZero(prpFeeSchema.getAmount2()));
		    		claimPolicyDcurrencyInfo.setSumPremium(ChgData.chgStrZero(prpFeeSchema.getPremium2()));
			        //支付保费币别
		    		claimPolicyDcurrencyInfo.setPayExchangeRate(ChgData.chgStrZero(prpFeeSchema.getExchangeRate1()));
		    		claimPolicyDcurrencyInfo.setPayAmout(ChgData.chgStrZero(prpFeeSchema.getAmount1()));
		    		claimPolicyDcurrencyInfo.setPayPremium(ChgData.chgStrZero(prpFeeSchema.getPremium1()));
		    		if(null != prpFeeSchema.getPremium1() && !"".equals(prpFeeSchema.getPremium1())){
		    			double perim = Double.parseDouble(prpFeeSchema.getPremium1());
		    			sumPremium += perim;
		    		}
		    		
		    		claimPolicyDcurrencyInfoList[i] = claimPolicyDcurrencyInfo;
			    }
		    	claimPolicyDetailInfo.setClaimPolicyDcurrencyInfoList(claimPolicyDcurrencyInfoList);
		    	claimPolicyDetailInfo.setSumCurrency(sumCurrency);
		    	claimPolicyDetailInfo.setSumCurrencyName(blPrpDcurrency.translateCode(sumCurrency,isChinese));
		    	claimPolicyDetailInfo.setPayCurrency(payCurrency);
		    	claimPolicyDetailInfo.setPayCurrencyName(blPrpDcurrency.translateCode(payCurrency,isChinese));
		    }
		    
		    //缴费计划
		    BLPrpCplan blPrpCplan = blPolicy.getBLPrpCplan(); //保单的Plan对象
		    ClaimPolicyPlanFeeInfo[] claimPolicyPlanFeeInfoList = null;
		    if(blPrpCplan.getSize()>0){
		    	claimPolicyPlanFeeInfoList = new ClaimPolicyPlanFeeInfo[blPrpCplan.getSize()];
		    	for(int i=0;i<blPrpCplan.getSize();i++){
		    		ClaimPolicyPlanFeeInfo claimPolicyPlanFeeInfo = new ClaimPolicyPlanFeeInfo();
		    		PrpTplanSchema prpPlanSchema = (PrpCplanSchema)blPrpCplan.getArr(i);
		    		claimPolicyPlanFeeInfo.setPayNo(prpPlanSchema.getPayNo());
		    		claimPolicyPlanFeeInfo.setPlanStartDate(prpPlanSchema.getPlanStartDate());
			    	claimPolicyPlanFeeInfo.setPlanEndDate(prpPlanSchema.getPlanDate());
			    	String currencyName = blPrpDcurrency.translateCode(prpPlanSchema.getCurrency(),isChinese);
			    	claimPolicyPlanFeeInfo.setCurrencyName(currencyName);
			    	double dbPlanFee = Double.parseDouble(prpPlanSchema.getPlanFee());
			    	claimPolicyPlanFeeInfo.setDbPlanFee(dbPlanFee);
			    	double dbDelinquentFee = Double.parseDouble(prpPlanSchema.getDelinquentFee());
			    	double dbPayRefFee = dbPlanFee-dbDelinquentFee;
			    	claimPolicyPlanFeeInfo.setDbPayRefFee(dbPayRefFee);
			    	
			    	claimPolicyPlanFeeInfoList[i] = claimPolicyPlanFeeInfo;
			    }
		    	claimPolicyDetailInfo.setClaimPolicyPlanFeeInfoList(claimPolicyPlanFeeInfoList);
		    }
		    
		    //特约及附加信息
		    ClaimPolicyEngageInfo[] claimPolicyEngageInfoList = null;
		    if(blPrpCengage.getSize()>0){
		    	ArrayList<ClaimPolicyEngageInfo> list = new ArrayList<ClaimPolicyEngageInfo>();
		    	StringBuffer strBuffer = new StringBuffer();
		    	for(int i=0;i<blPrpCengage.getSize();i++){
			    	ClaimPolicyEngageInfo claimPolicyEngageInfo = new ClaimPolicyEngageInfo();
			    	
			    	String clausesContext = "";//内容
			    	PrpTengageSchema prpEngageSchemaNext = null;
			    	PrpTengageSchema prpEngageSchema = blPrpCengage.getArr(i);
			        if(i<blPrpCengage.getSize()-1){
			        	prpEngageSchemaNext = blPrpCengage.getArr(i+1);
			        }
			        else{
			        	prpEngageSchemaNext = null;
			        }
			    	
			    	String strClauseCode = prpEngageSchema.getClauseCode();//代码
			    	String strClauseName = Str.encode(prpEngageSchema.getClauses());//名称
			    	if(!strClauseCode.startsWith("T")&&
			    		       !strClauseCode.startsWith("L")&&
			    		       !strClauseCode.startsWith("S")&&
			    		       !strClauseCode.startsWith("G")){
			    		continue;
			    	}
			    	
			    	String strTitleFlag = prpEngageSchema.getTitleFlag();
			        if(strTitleFlag.trim().equals("")){
			        	strTitleFlag = "0";
			        }
			        if(strTitleFlag.equals("0")){
			        	strBuffer.setLength(0);
			        }else{
			        	strBuffer.append(prpEngageSchema.getClauses());
			        }
			        
			        //特约内容赋值
			        if(prpEngageSchemaNext==null||prpEngageSchemaNext!=null&&!prpEngageSchemaNext.getSerialNo().equals(prpEngageSchema.getSerialNo())){
			        	clausesContext = strBuffer.toString();
			        }
			        
			        claimPolicyEngageInfo.setClauseCode(strClauseCode);
			    	claimPolicyEngageInfo.setClauseName(strClauseName);
			    	claimPolicyEngageInfo.setClausesContext(clausesContext);
			    	
			        if(strClauseCode.equals("TX001")||
		        	         strClauseCode.equals("TX002")||
		        	         strClauseCode.equals("TX003")||
		        	         strClauseCode.equals("TX004")||
		        	         strClauseCode.length()>5&&
		        	         strClauseCode.substring(0,5).equals("LF001")) //船舶险的航行范围特别约定
		        	{
		        		
		        	}else{
		        		list.add(claimPolicyEngageInfo);
		        	}
			        
			    }
		    	ArrayList<ClaimPolicyEngageInfo> newlist = new ArrayList<ClaimPolicyEngageInfo>();
		    	if(null != list && list.size()>0){
		    		newlist.add(list.get(0));
		    		for(int m=1;m<list.size();m++){
		    			ClaimPolicyEngageInfo claimPolicyEngageInfo1 = list.get(m);
		    			boolean hasFlag = false;
		    			for(int n=0;n<newlist.size();n++){
		    				ClaimPolicyEngageInfo claimPolicyEngageInfo2 = newlist.get(n);
		    				if(claimPolicyEngageInfo1.getClauseCode().equals(claimPolicyEngageInfo2.getClauseCode())){
		    					String clausesContext = claimPolicyEngageInfo2.getClausesContext()+claimPolicyEngageInfo1.getClausesContext();
		    					claimPolicyEngageInfo2.setClausesContext(clausesContext);
		    					hasFlag = true;
		    				}
		    			}
		    			if(!hasFlag){
    						newlist.add(claimPolicyEngageInfo1);
    					}
		    		}
		    	}
		    	
			    if(null != newlist && newlist.size()>0){
			    	claimPolicyEngageInfoList = new ClaimPolicyEngageInfo[newlist.size()];
			    	for(int j=0;j<newlist.size();j++){
			    		claimPolicyEngageInfoList[j] = newlist.get(j);
			    	}
			    }
			    claimPolicyDetailInfo.setClaimPolicyEngageInfoList(claimPolicyEngageInfoList);
		    }
		    
		    
		    //费用信息
		    //手续/经纪费比例
		    String strDisRate = "";
		   
		    if(Double.parseDouble(ChgData.chgStrZero(prpMainSchema.getDisRate()))>0){
		    	strDisRate = new DecimalFormat("0.0000").format(Double.parseDouble(ChgData.chgStrZero(prpMainSchema.getDisRate())));
		    }
		    claimPolicyDetailInfo.setDisRate(strDisRate);
		      
		     //基础绩效比例
		    String strBasePerformanceRate = "";
		    if(Double.parseDouble(ChgData.chgStrZero(prpMainSchema.getBasePerformanceRate()))>0){
		    	strBasePerformanceRate = new DecimalFormat("0.0000").format(Double.parseDouble(ChgData.chgStrZero(prpMainSchema.getBasePerformanceRate())));
		    }
		    claimPolicyDetailInfo.setBasePerformanceRate(strBasePerformanceRate);
		    
		    double disrate = Double.parseDouble(ChgData.chgStrZero(prpMainSchema.getDisRate()));
	    	String disRateFee = new DecimalFormat("0.0000").format(disrate*sumPremium/100);
	    	claimPolicyDetailInfo.setDisRateFee(disRateFee);
		    
	    	double basePerFormanceRate = Double.parseDouble(ChgData.chgStrZero(prpMainSchema.getBasePerformanceRate()));
	    	String basePerFormanceRateFee = new DecimalFormat("0.0000").format(basePerFormanceRate*sumPremium/100);
	    	claimPolicyDetailInfo.setBasePerformanceRateFee(basePerFormanceRateFee);
		     
		     String judicalScopeCode = prpMainSchema.getJudicalScope();
		     String judicalScopeName = "";
		     if(judicalScopeCode.equals("1")){
		    	 judicalScopeName = "中华人民共和国管辖(港澳台除外)"; 
		     }
		     else if(judicalScopeCode.equals("2")){
		    	 judicalScopeName = "港澳台"; 
		     }
		     else{
		    	 judicalScopeName = "其他";
		     }
		     claimPolicyDetailInfo.setJudicalScopeName(judicalScopeName);
		     
		     String argueSolution = "";
		     String argueSolutionCode = prpMainSchema.getArgueSolution();
		     if(argueSolutionCode.equals("1")){
		    	 argueSolution = "诉讼";
		     }
		     else if(argueSolutionCode.equals("2")){
		    	 argueSolution = "仲裁";
		     }
		     else{
		    	 argueSolution = "";
		     }
		     claimPolicyDetailInfo.setArgueSolution(argueSolution);
		     
		     //操作员
		     String operatorCode = prpMainSchema.getOperatorCode();
		     claimPolicyDetailInfo.setOperatorCode(operatorCode);
		     String operatorName = blPrpDuser.translateCode(operatorCode,isChinese);
		     claimPolicyDetailInfo.setOperatorName(operatorName);
		     //录单日期
		     claimPolicyDetailInfo.setInputDate(prpMainSchema.getInputDate());
		     //最近修改人，时间
		     String updaterCode = prpMainSchema.getUpdaterCode();
		     String updaterName = blPrpDuser.translateCode(updaterCode,isChinese);
		     claimPolicyDetailInfo.setUpdaterCode(updaterCode);
		     claimPolicyDetailInfo.setUpdaterName(updaterName);
		     claimPolicyDetailInfo.setUpdateDate(prpMainSchema.getUpdateDate());
		     //核保人,时间
		     String underWriteCode = prpMainSchema.getUnderWriteCode();
		     String underWriteName = blPrpDuser.translateCode(underWriteCode,isChinese);
		     claimPolicyDetailInfo.setUnderWriteCode(underWriteCode);
		     claimPolicyDetailInfo.setUnderWriteName(underWriteName);
		     claimPolicyDetailInfo.setUnderWriteEndDate(prpMainSchema.getUnderWriteEndDate());
		     claimPolicyDetailInfo.setRemark(prpMainSchema.getRemark());
		     
		     String coinsFlag = prpMainSchema.getCoinsFlag();
		     String coinsFlagName = "";
		     if(coinsFlag.equals("0")){
		    	 coinsFlagName = "非联/共保";
		     }
		     else if(coinsFlag.equals("1")){
		    	 coinsFlagName = "主共保";
		     }
		     else if(coinsFlag.equals("2")){
		    	 coinsFlagName = "从共保";
		     }
		     else if(coinsFlag.equals("3")){
		    	 coinsFlagName = "主联保";
		     }
		     else if(coinsFlag.equals("4")){
		    	 coinsFlagName = "从联保";
		     }
		     else{
		    	 coinsFlagName = "";
		     }
		     claimPolicyDetailInfo.setCoinsFlagName(coinsFlagName);
		     claimPolicyDetailInfo.setAgriInsuranceFlag(prpMainSchema.getAgriFlag());//调查问卷
		     
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("非车险保单详细信息查询",serial,e);
		}
		logger.log("非车险保单详细信息查询", 0,serial, claimPolicyDetailInfo);
		return claimPolicyDetailInfo;
	}

}
