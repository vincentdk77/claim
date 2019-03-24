package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sinosoft.prpall.pubfun.ComCodeTools;

public class EndCase {
	private String confirmSequenceNo=""; 	//投保确认码
	private String claimCode="";	      	//理赔编码
	private double sumPaid=0;        //赔款总金额(包括费用)
	private double sumLoss=0;        //损失总金额
	private double sumDutyPaid=0;        //赔款总金额(不包括费用)
	private double sumNoDutyPaid=0;		//无责代赔金额
	private int personNum=0;      //伤亡人数
	private double otherAmount=0;    //其他费用
	private String registNo="";			//报案号
	private String claimNo="";   //立案编号
	private String endCaseNo="";   //结案号
	private Date registTime; //报案时间
	private Date claimTime; //立案时间
	private Date endCaseTime;  //结案时间
	private boolean isInsuredDuty = true;			//是否属于保险责任
	private String caseType=""; //理赔类型
	private String prepayreason="";				  //垫付原因
	private String refusereason="";	//拒赔原因
	private String  licenseNo="";					//出现车辆车牌号码
	private String licenseType="";   //出险车辆号牌种类
	private String driverName="";		//出险驾驶员
	private String driverSex="";		//出险驾驶员性别
	private String driverArea="";		//出险驾驶员属地
	private String archivesNo="";		//出险驾驶员档案编号
	private String certiType="";  //出险驾驶员证件类型
	private String certiCode=""; //出险驾驶员证件号码
	private String reportorName = "";       //报案人
	private String policyNo=""; //保单号码
	private Date damageDate;			//出险时间 
	private Date startDate;
	private Date endDate;
	private AccidentInfor accidentInfor; //事故信息
	private List thirdCarList=new ArrayList();   //第三方车牌号
	private List lossSituationList=new ArrayList(); //损失赔偿情况
	private List lossSituationDetailList = new ArrayList();  
	private String handleUnit = ""; //事故处理部门
	private String manageType = ""; //事故处理类型
	private String damageTypeCode = ""; //事故原因
	private String damageAddress ="";//出险地点
	private String dirverSex = "";//出险驾驶员的性别
	private String dirverAddress = "";//出险驾驶员的归属地
	private String comCode = "";//单子的归属机构
	private List carLossList = new ArrayList();  //商业险车辆损失情况
	private List personLossList = new ArrayList();  //商业险人伤损失情况
	private List propLossList = new ArrayList();  //商业险财产损失情况
	private String personDeath = "";//人员死亡
	//sunmingtao 浙江商业险
	private double carSumLoss=0;    //车辆损失金额
	private double carSumPaid=0;    //车辆赔款金额
	private double propSumLoss=0;    //财产损失金额
	private double propSumPaid=0;    //财产赔款金额
	private double personSumLoss=0;    //人员损失金额
	private double personSumPaid=0;    //人员赔款金额
	private double chargePaid=0;    //人员赔款金额
	private List prplchargeList = new ArrayList();  //商业险财产损失情况
	private String damageCode="";// 出险原因
	private String optionType="";// 浙江商业事故处理类型
//	sunmingtao 浙江商业险
	private String rackNo = "";//车险车辆车架号
	private String agentNo = "";//定损员代码
	private String agentName = "";//定损员名称
	private Date setLossTime ;//定损时间
	private String claimType = "";//理赔类型
	private	double chargeSumLoss=0;  //总费用损失金额
	private double chargeSumPaid=0;  //总费用赔款金额
	
	 /** 属性是否有人伤标记 */
    private String injuryFlag = "";
    
    /** 属性是否有盗抢标记 */
    private String brigandageFlag = "";
    
    /** 属性是否道路交通事故标记 */
    private String roadFlag = "";
    
    /** 属性是否有交管事故书标记 */
    private String acciLetterFlag = "";
    
    /** 属性事故书编号 */
    private String acciLetterNo = "";
    
    /** 是否互碰自赔 */
    private String paySelfFlag = "";
	
    /** 是否无责垫付 */
    private String irresponsibilityPayment = "";
    
    //add by liuxin 20080516 start for 北京交强险信息库接口调整
    /**  第三方是否为机动车属性 */
	private String thirdVehicleFlag = ""; //0否 1是
	private List thirdPersonList = new ArrayList();//第三方人员信息
	//add by liuxin 20080516 end for 北京交强险信息库接口调整
	
	public AccidentInfor getAccidentInfor() {
		return accidentInfor;
	}
	public void setAccidentInfor(AccidentInfor accidentInfor) {
		this.accidentInfor = accidentInfor;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getCertiCode() {
		return certiCode;
	}
	public void setCertiCode(String certiCode) {
		this.certiCode = certiCode;
	}
	public String getCertiType() {
		return certiType;
	}
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getEndCaseNo() {
		return endCaseNo;
	}
	public void setEndCaseNo(String endCaseNo) {
		this.endCaseNo = endCaseNo;
	}
	public Date getClaimTime() {
		return claimTime;
	}
	public void setClaimTime(Date claimTime) {
		this.claimTime = claimTime;
	}
	public String getConfirmSequenceNo() {
		return confirmSequenceNo;
	}
	public void setConfirmSequenceNo(String confirmSequenceNo) {
		this.confirmSequenceNo = confirmSequenceNo;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getArchivesNo() {
		return archivesNo;
	}
	public void setArchivesNo(String archivesNo) {
		this.archivesNo = archivesNo;
	}
	public Date getEndCaseTime() {
		return endCaseTime;
	}
	public void setEndCaseTime(Date endCaseTime) {
		this.endCaseTime = endCaseTime;
	}
	public boolean isInsuredDuty() {
		return isInsuredDuty;
	}
	public void setInsuredDuty(boolean isInsuredDuty) {
		this.isInsuredDuty = isInsuredDuty;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getLicenseType() {
		return licenseType;
	}
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getPrepayreason() {
		return prepayreason;
	}
	public void setPrepayreason(String prepayreason) {
		this.prepayreason = prepayreason;
	}
	public String getRefusereason() {
		return refusereason;
	}
	public void setRefusereason(String refusereason) {
		this.refusereason = refusereason;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	public double getSumPaid() {
		return sumPaid;
	}
	public void setSumPaid(double sumPaid) {
		this.sumPaid = sumPaid;
	}
	public List getThirdCarList() {
		return thirdCarList;
	}
	public void addThirdCar(ThirdCar thirdCar) {
		thirdCarList.add(thirdCar);
	}
	public Date getDamageDate() {
		return damageDate;
	}
	public void setDamageDate(Date damageDate) {
		this.damageDate = damageDate;
	}
	public void setThirdCarList(List thirdCarList) {
		this.thirdCarList = thirdCarList;
	}
	public List getLossSituationList() {
		return lossSituationList;
	}
	public void setLossSituationList(List lossSituationList) {
		this.lossSituationList = lossSituationList;
	}
	public void addLossSituation(LossSituation lossSituation) {
		lossSituationList.add(lossSituation);
	}
	public String getDamageAddress() {
		return damageAddress;
	}
	public void setDamageAddress(String damageAddress) {
		this.damageAddress = damageAddress;
	}
	public String getDamageTypeCode() {
		return damageTypeCode;
	}
	public void setDamageTypeCode(String damageTypeCode) {
		this.damageTypeCode = damageTypeCode;
	}
	public String getDirverAddress() {
		return dirverAddress;
	}
	public void setDirverAddress(String dirverAddress) {
		this.dirverAddress = dirverAddress;
	}
	public String getDirverSex() {
		return dirverSex;
	}
	public void setDirverSex(String dirverSex) {
		this.dirverSex = dirverSex;
	}
	public String getHandleUnit() {
		return handleUnit;
	}
	public void setHandleUnit(String handleUnit) {
		this.handleUnit = handleUnit;
	}
	public String getManageType() {
		return manageType;
	}
	public void setManageType(String manageType) {
		this.manageType = manageType;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getpersonDeath() {
		return personDeath;
	}
	public void setPersonDeath(String personDeath) {
		this.personDeath = personDeath;
	}
	  
	public List getCarLossList() {
		return carLossList;
	}
	public void setCarLossList(List carLossList) {
		this.carLossList = carLossList;
	}
	public String getDriverArea() {
		return driverArea;
	}
	public void setDriverArea(String driverArea) {
		this.driverArea = driverArea;
	}
	public String getDriverSex() {
		return driverSex;
	}
	public void setDriverSex(String driverSex) {
		this.driverSex = driverSex;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List getLossSituationDetailList() {
		return lossSituationDetailList;
	}
	public void setLossSituationDetailList(List lossSituationDetailList) {
		this.lossSituationDetailList = lossSituationDetailList;
	}
	public List getPersonLossList() {
		return personLossList;
	}
	public void setPersonLossList(List personLossList) {
		this.personLossList = personLossList;
	}
	public List getPropLossList() {
		return propLossList;
	}
	public void setPropLossList(List propLossList) {
		this.propLossList = propLossList;
	}
	public String getReportorName() {
		return reportorName;
	}
	public void setReportorName(String reportorName) {
		this.reportorName = reportorName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public double getSumLoss() {
		return sumLoss;
	}
	public void setSumLoss(double sumLoss) {
		this.sumLoss = sumLoss;
	}
	public double getSumDutyPaid() {
		return sumDutyPaid;
	}
	public void setSumDutyPaid(double sumDutyPaid) {
		this.sumDutyPaid = sumDutyPaid;
	}
	public int getPersonNum() {
		return personNum;
	}
	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}
	public double getOtherAmount() {
		return otherAmount;
	}
	public void setOtherAmount(double otherAmount) {
		this.otherAmount = otherAmount;
	}
	/**
     * 设置委托赔案标记
     * @param entrustFlag 待设置的委托赔案标记
     */
    public void setInjuryFlag(String injuryFlag){
    	this.injuryFlag = injuryFlag;
    }
    
    /**
     * 获取委托赔案标记
     * @return 委托赔案标记
     */
    public String getInjuryFlag(){
    	return this.injuryFlag;
    }
    
    /**
     * 设置委托赔案标记
     * @param entrustFlag 待设置的委托赔案标记
     */
    public void setBrigandageFlag(String brigandageFlag){
    	this.brigandageFlag = brigandageFlag;
    }
    
    /**
     * 获取委托赔案标记
     * @return 委托赔案标记
     */
    public String getBrigandageFlag(){
    	return this.brigandageFlag;
    }
    
    /**
     * 设置委托赔案标记
     * @param entrustFlag 待设置的委托赔案标记
     */
    public void setRoadFlag(String roadFlag){
    	this.roadFlag = roadFlag;
    }
    
    /**
     * 获取委托赔案标记
     * @return 委托赔案标记
     */
    public String getRoadFlag(){
    	return this.roadFlag;
    }
    
    /**
     * 设置委托赔案标记
     * @param entrustFlag 待设置的委托赔案标记
     */
    public void setAcciLetterFlag(String acciLetterFlag){
    	this.acciLetterFlag = acciLetterFlag;
    }
    
    /**
     * 获取委托赔案标记
     * @return 委托赔案标记
     */
    public String getAcciLetterFlag(){
    	return this.acciLetterFlag;
    }
    
    /**
     * 设置委托赔案标记
     * @param acciLetterNo 待设置的委托赔案标记
     */
    public void setAcciLetterNo(String acciLetterNo){
    	this.acciLetterNo = acciLetterNo;
    }
    
    /**
     * 获取委托赔案标记
     * @return 委托赔案标记
     */
    public String getAcciLetterNo(){
    	return this.acciLetterNo;
    }
    
    /**
     * 设置互碰自赔标志
     * @param paySelfFlag 待设置的互碰自赔标志
     */
    public void setPaySelfFlag(String paySelfFlag){
    	this.paySelfFlag = paySelfFlag;
    }
    
    /**
     * 获取互碰自赔标志
     * @return 互碰自赔标志
     */
    public String getPaySelfFlag(){
    	return this.paySelfFlag;
    }
    /**
     * 设置委托赔案标记
     * @param entrustFlag 待设置的委托赔案标记
     */
    public void setIrresponsibilityPayment(String irresponsibilityPayment){
    	this.irresponsibilityPayment = irresponsibilityPayment;
    }
    
    /**
     * 获取委托赔案标记
     * @return 委托赔案标记
     */
    public String getIrresponsibilityPayment(){
    	return this.irresponsibilityPayment;
    }
    
    //add by liuxin 20080516 start for 北京交强险信息库接口调整
	public String getThirdVehicleFlag() {
		return thirdVehicleFlag;
	}
	public void setThirdVehicleFlag(String thirdVehicleFlag) {
		this.thirdVehicleFlag = thirdVehicleFlag;
	}
	
	public List getThirdPersonList() {
		return thirdPersonList;
	}
	public void setThirdPersonList(List thirdPersonList) {
		this.thirdPersonList = thirdPersonList;
	}
	//add by liuxin 20080516 end for 北京交强险信息库接口调整
	public double getCarSumLoss() {
		return carSumLoss;
	}
	public void setCarSumLoss(double carSumLoss) {
		this.carSumLoss = carSumLoss;
	}	
	public double getCarSumPaid() {
		return carSumPaid;
	}
	public void setCarSumPaid(double carSumPaid) {
		this.carSumPaid = carSumPaid;
	}	
	public double getPropSumLoss() {
		return propSumLoss;
	}
	public void setPropSumLoss(double propSumLoss) {
		this.propSumLoss = propSumLoss;
	}	
	public double getPropSumPaid() {
		return propSumPaid;
	}
	public void setPropSumPaid(double propSumPaid) {
		this.propSumPaid = propSumPaid;
	}	
	public double getPersonSumLoss() {
		return personSumLoss;
	}
	public void setPersonSumLoss(double personSumLoss) {
		this.personSumLoss = personSumLoss;
	}	
	public double getPersonSumPaid() {
		return personSumPaid;
	}
	public void setPersonSumPaid(double personSumPaid) {
		this.personSumPaid = personSumPaid;
	}
	public List getPrplchargeList() {
		return prplchargeList;
	}
	public void setPrplchargeList(List prplchargeList) {
		this.prplchargeList = prplchargeList;
	}
	public double getChargePaid() {
		return chargePaid;
	}
	public void setChargePaid(double chargePaid) {
		this.chargePaid = chargePaid;
	}
	public String getDamageCode() {
		return damageCode;
	}
	public void setDamageCode(String damageCode) {
		this.damageCode = damageCode;
	}
	public String getOptionType() {
		return optionType;
	}
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
	public String getRackNo() {
		return rackNo;
	}
	public void setRackNo(String rackNo) {
		this.rackNo = rackNo;
	}
	public String getAgentNo() {
		return agentNo;
	}
	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public Date getSetLossTime() {
		return setLossTime;
	}
	public void setSetLossTime(Date setLossTime) {
		this.setLossTime = setLossTime;
	}

	public double getSumNoDutyPaid() {
		return sumNoDutyPaid;
	}
	public void setSumNoDutyPaid(double sumNoDutyPaid) {
		this.sumNoDutyPaid = sumNoDutyPaid;
	}
	public String getClaimType() {
		return claimType;
	}
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
	/**
	 * @return the chargeSumLoss
	 */
	public double getChargeSumLoss() {
		return chargeSumLoss;
	}
	/**
	 * @param chargeSumLoss the chargeSumLoss to set
	 */
	public void setChargeSumLoss(double chargeSumLoss) {
		this.chargeSumLoss = chargeSumLoss;
	}
	/**
	 * @return the chargeSumPaid
	 */
	public double getChargeSumPaid() {
		return chargeSumPaid;
	}
	/**
	 * @param chargeSumPaid the chargeSumPaid to set
	 */
	public void setChargeSumPaid(double chargeSumPaid) {
		this.chargeSumPaid = chargeSumPaid;
	}
}
