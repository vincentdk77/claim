package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Regist {
	private String confirmSequenceNo=""; 	//投保确认码
	private String claimCode="";	      	//理赔编码
	private String policyNO="";			    //保单号
	private String registNo="";			    //报案号
	private String claimNo="";			    //立案号
	private Date damageDate;			    //出险时间
	private Date reportDate;			    //报案时间
	private String reportorName = "";       //报案人
	private Date startDate;                 //保险起期
	private Date endDate;                   //保险止期
	private String licenseNo="";			//号牌号码
	private String licenseType="";			//号牌类型
	private String owner="";			    //车主
	private List thirdCarList = new ArrayList(); //三者车信息
	private List carLossList = new ArrayList();  //车损信息
	private List propLossList = new ArrayList(); //物孙信息
	private List personLossList = new ArrayList();//人伤信息
	/**
	 *  2007-06-06 北分平台调整，传平台需要新加字段  
	 *  sunzhaoyun@sinosoft.com.cn  begin
	 */
	private String handleUnit = "";         //事故处理类型
	private String damageTypeCode = "";     //事故原因
	private String damageAddreddCode = "";  //出险地点代码
	private String damageAddress ="";       //出险地点
	private String weatherCode = "";        //出险天气
	private String damageAreacode = "";     //事故管界
	private String damageManCount = "";     //受伤人数
	private String damageContext= "";       //出现经过
	private String indemnityDuty = "";      //事故责任划分
	private String phoneNumber = "";        //联系电话
	private String comCode = "";            //单子的归属机构
	private String manageTypeCode = "";     //事故处理类型
	private String paySelfFlag = "";        //是否互碰自赔
	private String rackNo = "";             //出险车辆车架号
	/**
	 *  2007-06-06 北分平台调整，传平台需要新加字段  
	 *  sunzhaoyun@sinosoft.com.cn  end
	 */
	//add by lianjingwei dubang 北京商业险平台上传 start
	//add by sunmingtao 浙江商业险平台上传 start
	private String driverName="";     //出险驾驶员姓名
	private String certiType="";      //出险驾驶员姓名
	private String certiCode="";      //出险驾驶员证件号
	private String archivesNo="";      //出险驾驶员档案编号
//	add by sunmingtao 浙江商业险平台上传 end
	private String licenseKindCode = "";//出险承保车辆号牌种类
	//add by lianjingwei end
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
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
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getPolicyNO() {
		return policyNO;
	}
	public void setPolicyNO(String policyNO) {
		this.policyNO = policyNO;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
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
	/**
	 * 增加三者车信息
	 * @param thirdCar
	 */
	public void addThirdCar(ThirdCar thirdCar){
		this.thirdCarList.add(thirdCar);
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getDamageAddress() {
		return damageAddress;
	}
	public void setDamageAddress(String damageAddress) {
		this.damageAddress = damageAddress;
	}
	public String getDamageAreacode() {
		return damageAreacode;
	}
	public void setDamageAreacode(String damageAreacode) {
		this.damageAreacode = damageAreacode;
	}
	public String getDamageTypeCode() {
		return damageTypeCode;
	}
	public void setDamageTypeCode(String damageTypeCode) {
		this.damageTypeCode = damageTypeCode;
	}
	public String getDamageContext() {
		return damageContext;
	}
	public void setDamageContext(String damageContext) {
		this.damageContext = damageContext;
	}
	public String getDamageManCount() {
		return damageManCount;
	}
	public void setDamageManCount(String damageManCount) {
		this.damageManCount = damageManCount;
	}
	public String getHandleUnit() {
		return handleUnit;
	}
	public void setHandleUnit(String handleUnit) {
		this.handleUnit = handleUnit;
	}
	public String getIndemnityDuty() {
		return indemnityDuty;
	}
	public void setIndemnityDuty(String indemnityDuty) {
		this.indemnityDuty = indemnityDuty;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getWeatherCode() {
		return weatherCode;
	}
	public void setWeatherCode(String weatherCode) {
		this.weatherCode = weatherCode;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getManageTypeCode() {
		return manageTypeCode;
	}
	public void setManageTypeCode(String manageTypeCode) {
		this.manageTypeCode = manageTypeCode;
	}
	public String getLicenseKindCode() {
		return licenseKindCode;
	}
	public void setLicenseKindCode(String licenseKindCode) {
		this.licenseKindCode = licenseKindCode;
	}
	public String getPaySelfFlag() {
		return paySelfFlag;
	}
	public void setPaySelfFlag(String paySelfFlag) {
		this.paySelfFlag = paySelfFlag;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
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
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getCertiType() {
		return certiType;
	}
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}
	public String getCertiCode() {
		return certiCode;
	}
	public void setCertiCode(String certiCode) {
		this.certiCode = certiCode;
	}
	public String getArchivesNo() {
		return archivesNo;
	}
	public void setArchivesNo(String archivesNo) {
		this.archivesNo = archivesNo;
	}
	public String getRackNo() {
		return rackNo;
	}
	public void setRackNo(String rackNo) {
		this.rackNo = rackNo;
	}
	public String getDamageAddreddCode() {
		return damageAddreddCode;
	}
	public void setDamageAddreddCode(String damageAddreddCode) {
		this.damageAddreddCode = damageAddreddCode;
	}
	
}
