package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ���������Ϣ �ֶΣ������š������š��ѳ��մ���������ʱ�䡢���յص㡢���ƺ��롢��ϵ�ˡ���ϵ�˵�ַ����ϵ�绰����ϵ���ʱ��
 * �鿱�����������Ϣ��������Դ
 * @author fei
 * 
 */
public class SurveyViewInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** ���Ա������� */
    private String policyNo = "";
	/** ���Ա������� */
    private String registNo = "";
    /** ���Գ��մ��� */
    private int perilCount = 0;
    /** ���Գ���ʱ�� */
    private String damageTime = "";
    /** ���Գ��յص� */
    private String damageAddress = "";
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** ������ϵ�� */
    private String linkerName = "";
    /** ������ϵ�˵绰 */
    private String linkerPhone = "";//�޴��ֶΡ�
    /** ������ϵ���ʱ� */
    private String linkerPostCode = "";
    /** ������ϵ��ͨѶ��ַ */
    private String linkerAddress = "";
    /** �����Ƿ��һ�ֳ� */
    private String firstSiteFlag = "";
    /** ���Գ���ԭ�� */
    private String damageCode = "";
    /** �����¹����� */
    private String indemnityDuty = "";
    /** ���Գ������� */
    private String damageAreaCode = "";
    /** �����ⰸ��� */
    private String claimType = "";
    /** ���Բ鿱������ */
    private String checkUserName = "";
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

	public String getFirstSiteFlag() {
		return firstSiteFlag;
	}

	public void setFirstSiteFlag(String firstSiteFlag) {
		this.firstSiteFlag = firstSiteFlag;
	}

	public String getDamageCode() {
		return damageCode;
	}

	public void setDamageCode(String damageCode) {
		this.damageCode = damageCode;
	}

	public String getIndemnityDuty() {
		return indemnityDuty;
	}

	public void setIndemnityDuty(String indemnityDuty) {
		this.indemnityDuty = indemnityDuty;
	}

	public String getDamageAreaCode() {
		return damageAreaCode;
	}

	public void setDamageAreaCode(String damageAreaCode) {
		this.damageAreaCode = damageAreaCode;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
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
     * ��ȡ���Գ��մ��� 
     * @return ���Գ��մ��� ��ֵ
     */
	public int getPerilCount() {
		return perilCount;
	}

	/**
     * �������Գ��մ��� 
     * @param perilCount �����õ����Գ��մ��� ��ֵ
     */
	public void setPerilCount(int perilCount) {
		this.perilCount = perilCount;
	}
	
	/**
     * ��ȡ���Գ���ʱ��
     * @return ���Գ���ʱ���ֵ
     */
    public String getDamageTime() {
		return damageTime;
	}

    /**
     * �������Գ���ʱ��
     * @param damageTime �����õ����Գ���ʱ���ֵ
     */
	public void setDamageTime(String damageTime) {
		this.damageTime = damageTime;
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
     * �������Գ��ƺ���
     * @param licenseNo �����õ����Գ��ƺ����ֵ
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ���Գ��ƺ���
     * @return ���Գ��ƺ����ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
    }
    
    /**
     * ����������ϵ��
     * @param linkerName �����õ�������ϵ�˵�ֵ
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * ��ȡ������ϵ��
     * @return ������ϵ�˵�ֵ
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * ����������ϵ���ʱ�
     * @param linkerPostCode �����õ�������ϵ���ʱ��ֵ
     */
    public void setLinkerPostCode(String linkerPostCode){
        this.linkerPostCode = StringUtils.rightTrim(linkerPostCode);
    }

    /**
     * ��ȡ������ϵ���ʱ�
     * @return ������ϵ���ʱ��ֵ
     */
    public String getLinkerPostCode(){
        return linkerPostCode;
    }

    /**
     * ����������ϵ��ͨѶ��ַ
     * @param linkerAddress �����õ�������ϵ��ͨѶ��ַ��ֵ
     */
    public void setLinkerAddress(String linkerAddress){
        this.linkerAddress = StringUtils.rightTrim(linkerAddress);
    }

    /**
     * ��ȡ������ϵ��ͨѶ��ַ
     * @return ������ϵ��ͨѶ��ַ��ֵ
     */
    public String getLinkerAddress(){
        return linkerAddress;
    }

    /**
     * ��ȡ������ϵ�˵绰
     * @return ������ϵ�˵绰��ֵ
     */
	public String getLinkerPhone() {
		return linkerPhone;
	}

	/**
     * ����������ϵ�˵绰
     * @param linkerPhone �����õ�������ϵ�˵绰��ֵ
     */
	public void setLinkerPhone(String linkerPhone) {
		this.linkerPhone = linkerPhone;
	}

	public String getCheckUserName() {
		return checkUserName;
	}

	public void setCheckUserName(String checkUserName) {
		this.checkUserName = checkUserName;
	}
    
    
}
