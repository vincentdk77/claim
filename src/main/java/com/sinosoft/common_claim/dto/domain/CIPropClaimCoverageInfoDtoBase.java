package com.sinosoft.common_claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class CIPropClaimCoverageInfoDtoBase implements Serializable{

	private static final long serialVersionUID = 1L;
	 /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CIPropClaimCoverageInfoDtoBase����
     */
    public CIPropClaimCoverageInfoDtoBase(){
    }
	private String comCoverageCode = "";//��˾���ִ���	
	private String hospitalCode = "";//����ҽԺ
	private String inpatientDepartment = "";//סԺ����	
	private String bedNumber = "";//��λ��	BED_NUMBER
	private String attendingDoctor = "";//����ҽʦ	
	private String residentPhysician = "";//סԺҽʦ	
	private String chiefPhysician = "";//����ҽʦ	
	private Date hospitalDate = new Date();//��Ժ����	
	private Date dischardeDate = new Date();//��Ժ����	
	private int hospitalDay = 0;//סԺ����	
	private Date payDate = new Date();//�����֧��ʱ��	
	private Date refusePayDate = new Date();//�������ʱ��	
	private double refusePayMoney = 0D;//�ܸ����	
	private String ifMedicalCaculate = "";//�Ƿ�ҽ������	
	private String claimAccount = "";//����ʺ�	
	private String claimBank = "";//����˻�������	
	private String claimName = "";//����ʺ�������	
	private String claimedReason = "";//�⸶����	
	private double claimAmount = 0D;//�⸶���	
	private String claimConclusionCode = "";//�������	
	private String claimConclusionDes = "";//�����������	
	
	private ArrayList<CIPropClaimDiseaseInfoDto> ciPropClaimDiseaseList ;//�����б� ������������Ϣ

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
