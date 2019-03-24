package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Claim {
	private String confirmSequenceNo=""; 	//投保确认码
	private String claimCode="";	      	//理赔编码
	private double unClaimAmount=0;//估损金额
	private String claimNo="";		//立案号
	private String registNo="";		//报案号
	private String policyNO="";		//保单号
	private String caseType="";		//理赔赔案类型
	private String licenseNo="";	//出险车牌号码
	private String licenseType="";	//出险车辆类型
	private Date damageDate;		//出险时间 
	private List thirdCarList = new ArrayList();//三者车信息
	private List carLossList = new ArrayList();  //车损信息
	private List propLossList = new ArrayList(); //物孙信息
	private List personLossList = new ArrayList();//人伤信息
	private String handleUnit = ""; //事故处理类型
	private String damageTypeCode = ""; //事故原因
	private String comCode = "";//单子的归属机构
	private Date claimDate;       //立案时间
	private Date startDate;              //保险起期
	private Date endDate;                 //保险止期
	private String damageText = "";     //出险经过
	private String reportorName = "";   //报案人
	private String indemnityDuty="";   //事故责任
	private String rackNo="";   //出险车辆车架号
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
    
    /** 属性事故书编号 */
    private String firstInvestigateTime = "";
    /** 互碰自赔标志 */
    private String paySelfFlag = "";
    /** 互碰自赔标志 */
    private String damageAddress = "";
    //add by liuxin 20080516 start for 北京交强险信息库接口调整
    /**属性第三方是否为机动车*/
    private String  thirdVehicleFlag = "";  //1是  0否
    
    private List thirdPersonList = new ArrayList();//第三方人员信息
    //add by liuxin 20080516 end for 北京交强险信息库接口调整
    
    private String manageTypeCode = "";//事故处理类型

	public Date getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}
	public String getDamageText() {
		return damageText;
	}
	public void setDamageText(String damageText) {
		this.damageText = damageText;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
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
	public String getConfirmSequenceNo() {
		return confirmSequenceNo;
	}
	public void setConfirmSequenceNo(String confirmSequenceNo) {
		this.confirmSequenceNo = confirmSequenceNo;
	}
	public Date getDamageDate() {
		return damageDate;
	}
	public void setDamageDate(Date damageDate) {
		this.damageDate = damageDate;
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
	public double getUnClaimAmount() {
		return unClaimAmount;
	}
	public void setUnClaimAmount(double unClaimAmount) {
		this.unClaimAmount = unClaimAmount;
	}

	public List getThirdCarList() {
		return thirdCarList;
	}
	public void setThirdCarList(List thirdCarList) {
		this.thirdCarList = thirdCarList;
	}
	public List getCarLossList() {
		return carLossList;
	}
	public void setCarLossList(List carLossList) {
		this.carLossList = carLossList;
	}
	public List getPropLossList() {
		return propLossList;
	}
	public void setPropLossList(List propLossList) {
		this.propLossList = propLossList;
	}
	public List getPersonLossList() {
		return personLossList;
	}
	public void setPersonLossList(List personLossList) {
		this.personLossList = personLossList;
	}
	public String getManageTypeCode() {
		return manageTypeCode;
	}
	public void setManageTypeCode(String manageTypeCode) {
		this.manageTypeCode = manageTypeCode;
	}
	/**
	 * 增加三者车信息
	 * @param thirdCar
	 */
	public void addThirdCar(ThirdCar thirdCar){
		this.thirdCarList.add(thirdCar);
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getPolicyNO() {
		return policyNO;
	}
	public void setPolicyNO(String policyNO) {
		this.policyNO = policyNO;
	}
	public String getDamageTypeCode() {
		return damageTypeCode;
	}
	public void setDamageTypeCode(String damageTypeCode) {
		this.damageTypeCode = damageTypeCode;
	}
	public String getHandleUnit() {
		return handleUnit;
	}
	public void setHandleUnit(String handleUnit) {
		this.handleUnit = handleUnit;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
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
     * @param entrustFlag 待设置的委托赔案标记
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
     * 设置委托赔案标记
     * @param entrustFlag 待设置的委托赔案标记
     */
    public void setFirstInvestigateTime(String firstInvestigateTime){
    	this.firstInvestigateTime = firstInvestigateTime;
    }
    
    /**
     * 获取委托赔案标记
     * @return 委托赔案标记
     */
    public String getFirstInvestigateTime(){
    	return this.firstInvestigateTime;
    }
    
    /**
     * 设置互碰自赔标志
     * @param entrustFlag 待设置的互碰自赔标志
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
     * 设置事故地点
     * @param damageAddress 待设置的事故地点
     */
    public void setDamageAddress(String damageAddress){
    	this.damageAddress = damageAddress;
    }
    
    /**
     * 获取事故地点
     * @return 事故地点
     */
    public String getDamageAddress(){
    	return this.damageAddress;
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
    /**
     * 设置案件责任
     * @param indemnityDuty 待设置的案件责任标志
     */
    public void setIndemnityDuty(String indemnityDuty){
    	this.indemnityDuty = indemnityDuty;
    }
    
    /**
     * 获取案件责任标志
     * @return 案件责任标志
     */
    public String getIndemnityDuty(){
    	return this.indemnityDuty;
    }
	public String getRackNo() {
		return rackNo;
	}
	public void setRackNo(String rackNo) {
		this.rackNo = rackNo;
	}
}
