package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Regist {
	private String confirmSequenceNo=""; 	//Ͷ��ȷ����
	private String claimCode="";	      	//�������
	private String policyNO="";			    //������
	private String registNo="";			    //������
	private String claimNo="";			    //������
	private Date damageDate;			    //����ʱ��
	private Date reportDate;			    //����ʱ��
	private String reportorName = "";       //������
	private Date startDate;                 //��������
	private Date endDate;                   //����ֹ��
	private String licenseNo="";			//���ƺ���
	private String licenseType="";			//��������
	private String owner="";			    //����
	private List thirdCarList = new ArrayList(); //���߳���Ϣ
	private List carLossList = new ArrayList();  //������Ϣ
	private List propLossList = new ArrayList(); //������Ϣ
	private List personLossList = new ArrayList();//������Ϣ
	/**
	 *  2007-06-06 ����ƽ̨��������ƽ̨��Ҫ�¼��ֶ�  
	 *  sunzhaoyun@sinosoft.com.cn  begin
	 */
	private String handleUnit = "";         //�¹ʴ�������
	private String damageTypeCode = "";     //�¹�ԭ��
	private String damageAddreddCode = "";  //���յص����
	private String damageAddress ="";       //���յص�
	private String weatherCode = "";        //��������
	private String damageAreacode = "";     //�¹ʹܽ�
	private String damageManCount = "";     //��������
	private String damageContext= "";       //���־���
	private String indemnityDuty = "";      //�¹����λ���
	private String phoneNumber = "";        //��ϵ�绰
	private String comCode = "";            //���ӵĹ�������
	private String manageTypeCode = "";     //�¹ʴ�������
	private String paySelfFlag = "";        //�Ƿ�������
	private String rackNo = "";             //���ճ������ܺ�
	/**
	 *  2007-06-06 ����ƽ̨��������ƽ̨��Ҫ�¼��ֶ�  
	 *  sunzhaoyun@sinosoft.com.cn  end
	 */
	//add by lianjingwei dubang ������ҵ��ƽ̨�ϴ� start
	//add by sunmingtao �㽭��ҵ��ƽ̨�ϴ� start
	private String driverName="";     //���ռ�ʻԱ����
	private String certiType="";      //���ռ�ʻԱ����
	private String certiCode="";      //���ռ�ʻԱ֤����
	private String archivesNo="";      //���ռ�ʻԱ�������
//	add by sunmingtao �㽭��ҵ��ƽ̨�ϴ� end
	private String licenseKindCode = "";//���ճб�������������
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
	 * �������߳���Ϣ
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
