package com.sinosoft.ciplatform.dto.domain;

import com.sinosoft.sysframework.common.datatype.DateTime;
/**
 * 这是理赔平台三者车信息表的数据传输对象基类<br>
 * 创建于2010-03-29
 */
public class CIClaimThirdCarDtoBase {
	private String claimCode      = "";//理赔编码（标的车）
	private int serialNo       = 0;//序号
	private String policyNo       = "";//保单号
	private String thirdClaimCode = "";//理赔编码（三者车）
	private String carMark        = "";//号牌号码
	private String vehicleType    = "";//号牌种类
	private String claimCompany   = "";//受理公司代码
	private String claimStatus    = "";//案件状态
	private String paySelfFlag    = "";//互碰自赔标志
	private String registNo       = "";//报案号
	private String claimNo        = "";//立案号
	private DateTime accidentDate   = new DateTime();//出险时间
	private String accidentPlace  = "";//出险地点
	private double sumPaid        = 0;//赔款金额
	
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getThirdClaimCode() {
		return thirdClaimCode;
	}
	public void setThirdClaimCode(String thirdClaimCode) {
		this.thirdClaimCode = thirdClaimCode;
	}
	public String getCarMark() {
		return carMark;
	}
	public void setCarMark(String carMark) {
		this.carMark = carMark;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getClaimCompany() {
		return claimCompany;
	}
	public void setClaimCompany(String claimCompany) {
		this.claimCompany = claimCompany;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	public String getPaySelfFlag() {
		return paySelfFlag;
	}
	public void setPaySelfFlag(String paySelfFlag) {
		this.paySelfFlag = paySelfFlag;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public DateTime getAccidentDate() {
		return accidentDate;
	}
	public void setAccidentDate(DateTime accidentDate) {
		this.accidentDate = accidentDate;
	}
	public String getAccidentPlace() {
		return accidentPlace;
	}
	public void setAccidentPlace(String accidentPlace) {
		this.accidentPlace = accidentPlace;
	}
	public double getSumPaid() {
		return sumPaid;
	}
	public void setSumPaid(double sumPaid) {
		this.sumPaid = sumPaid;
	}

	
}
