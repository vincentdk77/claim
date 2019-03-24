package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compensate {
	private String confirmSequenceNo=""; 	//投保确认码
	private String claimCode="";	      	//理赔编码
	private String compensateNo="";		    //计算书号
	private String claimNo="";		        //立案号
	private String registNo="";		        //报案号
	private String policyNo="";		        //保单号
	private String caseType="";				//理赔赔案类型	
	private String licenseNo="";			//出险车牌号码
	private String licenseType="";			//出险车辆类型
	private Date damageDate;				//出险时间 
	private Date compensateDate;		    //出险时间 
	private Date startDate;                 //保险起期
	private Date endDate;                   //保险止期
	private double sumPaid=0;			    //理算金额
	private double claimCost=0;				//费用
	private String comCode = "";			//单子的归属机构
	private String times = "";				//理算书编号
	private Date payDate;					//支付日期
	private String agentNo="";				//定损员代码
	private String agentName="";			//定损员代码
	private Date setLossTime; 				//定损时间
	
	private String numerationStartTime ="";	//厘算开始时间
	private String numerationEndTime ="";	//厘算结束时间
	private String assesorStartTime ="";	//核赔开始时间
	private String assesorEndTime ="";		//核赔结束时间
	private String assesorDes ="";			//核赔意见
	private double otherAmount =0; 		    //总核赔费用
	private double assesorAmount=0; 		//总核赔金额
	private String driverName ="";			//出险驾驶员名称
	private String certiType ="";			//出险驾驶员证件类型
	private String certiCode="";			//出险驾驶员证件号
	private String archivesNo="";			//出险驾驶员档案编号
	private String accidentPlace ="";		//出险地点
	private String proportionaClaim ="";	//是否比例赔付
	private String accidentPlaceMark ="";	//出险地点唯一标识
	private List lossSituationList=new ArrayList(); //损失赔偿情况
	
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
	public String getCompensateNo() {
		return compensateNo;
	}
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
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
	public Date getCompensateDate() {
		return compensateDate;
	}
	public void setCompensateDate(Date compensateDate) {
		this.compensateDate = compensateDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
	
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public double getSumPaid() {
		return sumPaid;
	}
	public void setSumPaid(double sumPaid) {
		this.sumPaid = sumPaid;
	}
	public double getClaimCost() {
		return claimCost;
	}
	public void setClaimCost(double claimCost) {
		this.claimCost = claimCost;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
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
	public String getNumerationStartTime() {
		return numerationStartTime;
	}
	public void setNumerationStartTime(String numerationStartTime) {
		this.numerationStartTime = numerationStartTime;
	}
	public String getNumerationEndTime() {
		return numerationEndTime;
	}
	public void setNumerationEndTime(String numerationEndTime) {
		this.numerationEndTime = numerationEndTime;
	}
	public String getAssesorStartTime() {
		return assesorStartTime;
	}
	public void setAssesorStartTime(String assesorStartTime) {
		this.assesorStartTime = assesorStartTime;
	}
	public String getAssesorEndTime() {
		return assesorEndTime;
	}
	public void setAssesorEndTime(String assesorEndTime) {
		this.assesorEndTime = assesorEndTime;
	}
	public String getAssesorDes() {
		return assesorDes;
	}
	public void setAssesorDes(String assesorDes) {
		this.assesorDes = assesorDes;
	}
	public double getOtherAmount() {
		return otherAmount;
	}
	public void setOtherAmount(double otherAmount) {
		this.otherAmount = otherAmount;
	}
	public double getAssesorAmount() {
		return assesorAmount;
	}
	public void setAssesorAmount(double assesorAmount) {
		this.assesorAmount = assesorAmount;
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
	public String getAccidentPlace() {
		return accidentPlace;
	}
	public void setAccidentPlace(String accidentPlace) {
		this.accidentPlace = accidentPlace;
	}
	public String getProportionaClaim() {
		return proportionaClaim;
	}
	public void setProportionaClaim(String proportionaClaim) {
		this.proportionaClaim = proportionaClaim;
	}
	public String getAccidentPlaceMark() {
		return accidentPlaceMark;
	}
	public void setAccidentPlaceMark(String accidentPlaceMark) {
		this.accidentPlaceMark = accidentPlaceMark;
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
}
