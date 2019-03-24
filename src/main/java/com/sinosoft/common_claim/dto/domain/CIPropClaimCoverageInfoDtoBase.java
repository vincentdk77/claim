package com.sinosoft.common_claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class CIPropClaimCoverageInfoDtoBase implements Serializable{

	private static final long serialVersionUID = 1L;
	 /**
     *  默认构造方法,构造一个默认的CIPropClaimCoverageInfoDtoBase对象
     */
    public CIPropClaimCoverageInfoDtoBase(){
    }
	private String comCoverageCode = "";//公司险种代码	
	private String hospitalCode = "";//就诊医院
	private String inpatientDepartment = "";//住院科室	
	private String bedNumber = "";//床位号	BED_NUMBER
	private String attendingDoctor = "";//主治医师	
	private String residentPhysician = "";//住院医师	
	private String chiefPhysician = "";//主任医师	
	private Date hospitalDate = new Date();//入院日期	
	private Date dischardeDate = new Date();//出院日期	
	private int hospitalDay = 0;//住院天数	
	private Date payDate = new Date();//理赔款支付时间	
	private Date refusePayDate = new Date();//拒赔决定时间	
	private double refusePayMoney = 0D;//拒付金额	
	private String ifMedicalCaculate = "";//是否医保结算	
	private String claimAccount = "";//赔款帐号	
	private String claimBank = "";//赔款账户开户行	
	private String claimName = "";//赔款帐号所有人	
	private String claimedReason = "";//赔付事由	
	private double claimAmount = 0D;//赔付金额	
	private String claimConclusionCode = "";//理赔结论	
	private String claimConclusionDes = "";//理赔结论描述	
	
	private ArrayList<CIPropClaimDiseaseInfoDto> ciPropClaimDiseaseList ;//疾病列表 隶属于险种信息

	public String getComCoverageCode() {
		return comCoverageCode;
	}
	public void setComCoverageCode(String comCoverageCode) {
		this.comCoverageCode = comCoverageCode;
	}
	public String getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public String getInpatientDepartment() {
		return inpatientDepartment;
	}
	public void setInpatientDepartment(String inpatientDepartment) {
		this.inpatientDepartment = inpatientDepartment;
	}
	public String getBedNumber() {
		return bedNumber;
	}
	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}
	public String getAttendingDoctor() {
		return attendingDoctor;
	}
	public void setAttendingDoctor(String attendingDoctor) {
		this.attendingDoctor = attendingDoctor;
	}
	public String getResidentPhysician() {
		return residentPhysician;
	}
	public void setResidentPhysician(String residentPhysician) {
		this.residentPhysician = residentPhysician;
	}
	public String getChiefPhysician() {
		return chiefPhysician;
	}
	public void setChiefPhysician(String chiefPhysician) {
		this.chiefPhysician = chiefPhysician;
	}
	public Date getHospitalDate() {
		return hospitalDate;
	}
	public void setHospitalDate(Date hospitalDate) {
		this.hospitalDate = hospitalDate;
	}
	public Date getDischardeDate() {
		return dischardeDate;
	}
	public void setDischardeDate(Date dischardeDate) {
		this.dischardeDate = dischardeDate;
	}
	public int getHospitalDay() {
		return hospitalDay;
	}
	public void setHospitalDay(int hospitalDay) {
		this.hospitalDay = hospitalDay;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Date getRefusePayDate() {
		return refusePayDate;
	}
	public void setRefusePayDate(Date refusePayDate) {
		this.refusePayDate = refusePayDate;
	}
	public double getRefusePayMoney() {
		return refusePayMoney;
	}
	public void setRefusePayMoney(double refusePayMoney) {
		this.refusePayMoney = refusePayMoney;
	}
	public String getIfMedicalCaculate() {
		return ifMedicalCaculate;
	}
	public void setIfMedicalCaculate(String ifMedicalCaculate) {
		this.ifMedicalCaculate = ifMedicalCaculate;
	}
	public String getClaimAccount() {
		return claimAccount;
	}
	public void setClaimAccount(String claimAccount) {
		this.claimAccount = claimAccount;
	}
	public String getClaimBank() {
		return claimBank;
	}
	public void setClaimBank(String claimBank) {
		this.claimBank = claimBank;
	}
	public String getClaimName() {
		return claimName;
	}
	public void setClaimName(String claimName) {
		this.claimName = claimName;
	}
	public String getClaimedReason() {
		return claimedReason;
	}
	public void setClaimedReason(String claimedReason) {
		this.claimedReason = claimedReason;
	}
	public double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	public String getClaimConclusionCode() {
		return claimConclusionCode;
	}
	public void setClaimConclusionCode(String claimConclusionCode) {
		this.claimConclusionCode = claimConclusionCode;
	}
	public String getClaimConclusionDes() {
		return claimConclusionDes;
	}
	public void setClaimConclusionDes(String claimConclusionDes) {
		this.claimConclusionDes = claimConclusionDes;
	}
	public ArrayList<CIPropClaimDiseaseInfoDto> getCiPropClaimDiseaseList() {
		return ciPropClaimDiseaseList;
	}
	public void setCiPropClaimDiseaseList(
			ArrayList<CIPropClaimDiseaseInfoDto> ciPropClaimDiseaseList) {
		this.ciPropClaimDiseaseList = ciPropClaimDiseaseList;
	}
	
	
}
