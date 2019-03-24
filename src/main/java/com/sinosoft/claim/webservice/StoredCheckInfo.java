package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;


/**
 * �ݴ����ݴ������Bean
 * �����š������š��������ڡ�����ʱ�䡢���յص㡢�鿱���ڡ��鿱ʱ�䡢�鿱�ص㡢�Ƿ��һ�ֳ����鿱���͡��鿱��1���鿱��2������ԭ��š��¹�ԭ��š��¹�����(buqueding )��
 * ���������ⰸ��𡢱�ע��
 * 
 * @author fei
 * 
 */
public class StoredCheckInfo implements Serializable {

	/**
	 * ������Դ�ڲ鿱����
	 * �鿱ʱ��(�����޴��ֶ�)
	 */
	private static final long serialVersionUID = 1L;
	/** ���Ա������� */
    private String policyNo = "";
	/** ���Ա������� */
    private String registNo = "";
    /** ���Գ������� */
    private String damageStartDate = "";
    /** ���Գ���ʱ��*/
    private String damageStartHour = "";
	/** ���Գ��յص� */
    private String damageAddress = "";
    /** �鿱���� */
    private String checkDate = "";
    /** �鿱ʱ�� */
    private String checkStartHour = "";
    /** ���Բ鿱/���鿱�ص� */
    private String checkSite = "";
    /** �����Ƿ��һ�ֳ� */
    private String firstSiteFlag = "";
    /** ���Բ鿱���� */
    private String checkType = "";
    /** ���Բ鿱/���鿱��1 */
    private String checker1 = "";
    /** ���Բ鿱/���鿱��2 */
    private String checker2 = "";
    /** ���Գ���ԭ����� */
    private String damageCode = "";
    /** �����¹����ʹ��� */
    private String damageTypeCode = "";
    /** �����⳥���δ��� */
    private String indemnityDuty = "";
    /** ���Գ���������� */
    private String damageAreaCode = "";
    /** ���԰������� */
    private String claimType = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** ��ϵ������ */
    private String linkerName = "";
    /** ��ϵ�˵绰 */
    private String linkerPhone = "";
    /** ��ϵ�˵�ַ */
    private String linkerAddress = "";
    /** ��ϵ���ʱ� */
    private String linkerPostCode = "";
    /** ���Լ�ʻԱ���� */
    private String driverName = "";
    /** ���Լ�ʻԱ�绰 */
    private String driverPhone = "";
    /** ���Լ�ʻԱ֤������ */
    private String certTypeCode = "";
    /** ���Լ�ʻԱ֤������ */
    private String certNo = "";
    /** ���Բ鿱���� */
    private String surveyReport = "";
    
    
    public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public String getCertTypeCode() {
		return certTypeCode;
	}

	public void setCertTypeCode(String certTypeCode) {
		this.certTypeCode = certTypeCode;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getSurveyReport() {
		return surveyReport;
	}

	public void setSurveyReport(String surveyReport) {
		this.surveyReport = surveyReport;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getLinkerName() {
		return linkerName;
	}

	public void setLinkerName(String linkerName) {
		this.linkerName = linkerName;
	}

	public String getLinkerPhone() {
		return linkerPhone;
	}

	public void setLinkerPhone(String linkerPhone) {
		this.linkerPhone = linkerPhone;
	}

	public String getLinkerAddress() {
		return linkerAddress;
	}

	public void setLinkerAddress(String linkerAddress) {
		this.linkerAddress = linkerAddress;
	}

	public String getLinkerPostCode() {
		return linkerPostCode;
	}

	public void setLinkerPostCode(String linkerPostCode) {
		this.linkerPostCode = linkerPostCode;
	}

	/**
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }
    
    /**
     * �������Ա�������
     * @param registNo �����õ����Ա��������ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getRegistNo(){
        return registNo;
    }
    
    /**
     * �������Գ�������
     * @param damageStartDate �����õ����Գ������ڵ�ֵ
     */
    public void setDamageStartDate(String damageStartDate){
        this.damageStartDate = damageStartDate;
    }

    /**
     * ��ȡ���Գ�������
     * @return ���Գ������ڵ�ֵ
     */
    public String getDamageStartDate(){
        return damageStartDate;
    }

    /**
     * �������Գ���ʱ��
     * @param damageStartHour �����õ����Գ���ʱ���ֵ
     */
    public void setDamageStartHour(String damageStartHour){
        this.damageStartHour = StringUtils.rightTrim(damageStartHour);
    }

    /**
     * ��ȡ���Գ���ʱ��
     * @return ���Գ���ʱ���ֵ
     */
    public String getDamageStartHour(){
        return damageStartHour;
    }
    /**
     * �������Գ��յص�
     * @param damageAddress �����õ����Գ��յص��ֵ
     */
    public void setDamageAddress(String damageAddress){
        this.damageAddress = StringUtils.rightTrim(damageAddress);
    }

    /**
     * ��ȡ���Գ��յص�
     * @return ���Գ��յص��ֵ
     */
    public String getDamageAddress(){
        return damageAddress;
    }   
    
    /**
     * �������Բ鿱/���鿱����
     * @param checkDate �����õ����Բ鿱/���鿱���ڵ�ֵ
     */
    public void setCheckDate(String checkDate){
        this.checkDate = checkDate;
    }

    /**
     * ��ȡ���Բ鿱/���鿱����
     * @return ���Բ鿱/���鿱���ڵ�ֵ
     */
    public String getCheckDate(){
        return checkDate;
        
    }
    
    
    /**
     * ��ȡ���Բ鿱/���鿱ʱ��
     * @return ���Բ鿱/���鿱ʱ���ֵ
     */
    public String getCheckStartHour() {
		return checkStartHour;
	}

    /**
     * �������Բ鿱/���鿱ʱ��
     * @param checkDate �����õ����Բ鿱/���鿱ʱ���ֵ
     */
	public void setCheckStartHour(String checkStartHour) {
		this.checkStartHour = checkStartHour;
	}

	/**
     * �������Բ鿱/���鿱�ص�
     * @param checkSite �����õ����Բ鿱/���鿱�ص��ֵ
     */
    public void setCheckSite(String checkSite){
        this.checkSite = StringUtils.rightTrim(checkSite);
    }

    /**
     * ��ȡ���Բ鿱/���鿱�ص�
     * @return ���Բ鿱/���鿱�ص��ֵ
     */
    public String getCheckSite(){
        return checkSite;
    }
    
    /**
     * ���������Ƿ��һ�ֳ�
     * @param firstSiteFlag �����õ������Ƿ��һ�ֳ���ֵ
     */
    public void setFirstSiteFlag(String firstSiteFlag){
        this.firstSiteFlag = StringUtils.rightTrim(firstSiteFlag);
    }

    /**
     * ��ȡ�����Ƿ��һ�ֳ�
     * @return �����Ƿ��һ�ֳ���ֵ
     */
    public String getFirstSiteFlag(){
        return firstSiteFlag;
    }
    
    /**
     * �������Բ鿱����
     * @param checkType �����õ����Բ鿱���͵�ֵ
     */
    public void setCheckType(String checkType){
        this.checkType = StringUtils.rightTrim(checkType);
    }

    /**
     * ��ȡ���Բ鿱����
     * @return ���Բ鿱���͵�ֵ
     */
    public String getCheckType(){
        return checkType;
    }
    
    /**
     * �������Բ鿱/���鿱��1
     * @param checker1 �����õ����Բ鿱/���鿱��1��ֵ
     */
    public void setChecker1(String checker1){
        this.checker1 = StringUtils.rightTrim(checker1);
    }

    /**
     * ��ȡ���Բ鿱/���鿱��1
     * @return ���Բ鿱/���鿱��1��ֵ
     */
    public String getChecker1(){
        return checker1;
    }

    /**
     * �������Բ鿱/���鿱��2
     * @param checker2 �����õ����Բ鿱/���鿱��2��ֵ
     */
    public void setChecker2(String checker2){
        this.checker2 = StringUtils.rightTrim(checker2);
    }

    /**
     * ��ȡ���Բ鿱/���鿱��2
     * @return ���Բ鿱/���鿱��2��ֵ
     */
    public String getChecker2(){
        return checker2;
    }
    
    /**
     * �������԰�������
     * @param claimType �����õ����԰������͵�ֵ
     */
    public void setClaimType(String claimType){
        this.claimType = StringUtils.rightTrim(claimType);
    }

    /**
     * �������Ա�ע
     * @param remark �����õ����Ա�ע��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Ա�ע
     * @return ���Ա�ע��ֵ
     */
    public String getRemark(){
        return remark;
    }
    
    /**
     * ��ȡ���԰�������
     * @return ���԰������͵�ֵ
     */
    public String getClaimType(){
        return claimType;
    }

    /**
     * �������Գ���ԭ�����
     * @param damageCode �����õ����Գ���ԭ������ֵ
     */
    public void setDamageCode(String damageCode){
        this.damageCode = StringUtils.rightTrim(damageCode);
    }

    /**
     * ��ȡ���Գ���ԭ�����
     * @return ���Գ���ԭ������ֵ
     */
    public String getDamageCode(){
        return damageCode;
    }

    
    /**
     * ���������¹����ʹ���
     * @param damageTypeCode �����õ������¹����ʹ����ֵ
     */
    public void setDamageTypeCode(String damageTypeCode){
        this.damageTypeCode = StringUtils.rightTrim(damageTypeCode);
    }

    /**
     * ��ȡ�����¹����ʹ���
     * @return �����¹����ʹ����ֵ
     */
    public String getDamageTypeCode(){
        return damageTypeCode;
    }

    /**
     * �������Գ����������
     * @param damageAreaCode �����õ����Գ�����������ֵ
     */
    public void setDamageAreaCode(String damageAreaCode){
        this.damageAreaCode = StringUtils.rightTrim(damageAreaCode);
    }

    /**
     * ��ȡ���Գ����������
     * @return ���Գ�����������ֵ
     */
    public String getDamageAreaCode(){
        return damageAreaCode;
    }
    
    /**
     * ���������⳥���δ���
     * @param indemnityDuty �����õ������⳥���δ����ֵ
     */
    public void setIndemnityDuty(String indemnityDuty){
        this.indemnityDuty = StringUtils.rightTrim(indemnityDuty);
    }

    /**
     * ��ȡ�����⳥���δ���
     * @return �����⳥���δ����ֵ
     */
    public String getIndemnityDuty(){
        return indemnityDuty;
    }
    
    
}
