package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLdriver-���ռ�ʻԱ��Ϣ������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.328<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLdriverDtoBase implements Serializable{
    /** ���Ա������� */
    private String registNo = "";
    /** �����ⰸ���� */
    private String claimNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա��յ��Ŵ� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Գ��ƺ� */
    private String licenseNo = "";
    /** ���Գ��Ƶ�ɫ���� */
    private String licenseColorCode = "";
    /** ����(����) ��ʻԱ��ʻ֤���� */
    private String drivingLicenseNo = "";
    /** ����(����)��ʻԱ���� */
    private String driverName = "";
    /** ����(����)��ʻԱ�Ա� */
    private String driverSex = "";
    /** ����(����)��ʻԱ���� */
    private int driverAge = 0;
    /** ����(����) ��ʻԱְҵ */
    private String driverOccupation = "";
    /** �����Ļ��̶� */
    private String education = "";
    /** ���Ե�λ��ַ */
    private String unitAddress = "";
    /** �������֤���� */
    private String identifyNumber = "";
    /** ����(����) ��ʻԱ�ȼ� */
    private int driverGrade = 0;
    /** ����(����) ��ʻԱ���� */
    private String driverSeaRoute = "";
    /** ����(����) ��ʻԱ��֤ʱ�� */
    private DateTime receiveLicenseDate = new DateTime();
    /** ����׼�ݳ��� */
    private String drivingCarType = "";
    /** ����(����) ��ʻԱ��ʻ���� */
    private int drivingYear = 0;
    /** ���԰�֤���� */
    private String awardLicenseOrgan = "";
    /** �������޸��ٴ�����ʻ��ѵ�ϸ�֤��(0/1) */
    private String specialCertificate = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";
    
    private String identifyType="";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLdriverDtoBase����
     */
    public PrpLdriverDtoBase(){
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
     * ���������ⰸ����
     * @param claimNo �����õ������ⰸ�����ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ����
     * @return �����ⰸ�����ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * �����������ִ���
     * @param riskCode �����õ��������ִ����ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ�������ִ���
     * @return �������ִ����ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * �������Ա��յ��Ŵ�
     * @param policyNo �����õ����Ա��յ��Ŵε�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա��յ��Ŵ�
     * @return ���Ա��յ��Ŵε�ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * �����������
     * @param serialNo �����õ�������ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Գ��ƺ�
     * @param licenseNo �����õ����Գ��ƺŵ�ֵ
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ���Գ��ƺ�
     * @return ���Գ��ƺŵ�ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * �������Գ��Ƶ�ɫ����
     * @param licenseColorCode �����õ����Գ��Ƶ�ɫ�����ֵ
     */
    public void setLicenseColorCode(String licenseColorCode){
        this.licenseColorCode = StringUtils.rightTrim(licenseColorCode);
    }

    /**
     * ��ȡ���Գ��Ƶ�ɫ����
     * @return ���Գ��Ƶ�ɫ�����ֵ
     */
    public String getLicenseColorCode(){
        return licenseColorCode;
    }

    /**
     * ��������(����) ��ʻԱ��ʻ֤����
     * @param drivingLicenseNo �����õ�����(����) ��ʻԱ��ʻ֤�����ֵ
     */
    public void setDrivingLicenseNo(String drivingLicenseNo){
        this.drivingLicenseNo = StringUtils.rightTrim(drivingLicenseNo);
    }

    /**
     * ��ȡ����(����) ��ʻԱ��ʻ֤����
     * @return ����(����) ��ʻԱ��ʻ֤�����ֵ
     */
    public String getDrivingLicenseNo(){
        return drivingLicenseNo;
    }

    /**
     * ��������(����)��ʻԱ����
     * @param driverName �����õ�����(����)��ʻԱ������ֵ
     */
    public void setDriverName(String driverName){
        this.driverName = StringUtils.rightTrim(driverName);
    }

    /**
     * ��ȡ����(����)��ʻԱ����
     * @return ����(����)��ʻԱ������ֵ
     */
    public String getDriverName(){
        return driverName;
    }

    /**
     * ��������(����)��ʻԱ�Ա�
     * @param driverSex �����õ�����(����)��ʻԱ�Ա��ֵ
     */
    public void setDriverSex(String driverSex){
        this.driverSex = StringUtils.rightTrim(driverSex);
    }

    /**
     * ��ȡ����(����)��ʻԱ�Ա�
     * @return ����(����)��ʻԱ�Ա��ֵ
     */
    public String getDriverSex(){
        return driverSex;
    }

    /**
     * ��������(����)��ʻԱ����
     * @param driverAge �����õ�����(����)��ʻԱ�����ֵ
     */
    public void setDriverAge(int driverAge){
        this.driverAge = driverAge;
    }

    /**
     * ��ȡ����(����)��ʻԱ����
     * @return ����(����)��ʻԱ�����ֵ
     */
    public int getDriverAge(){
        return driverAge;
    }

    /**
     * ��������(����) ��ʻԱְҵ
     * @param driverOccupation �����õ�����(����) ��ʻԱְҵ��ֵ
     */
    public void setDriverOccupation(String driverOccupation){
        this.driverOccupation = StringUtils.rightTrim(driverOccupation);
    }

    /**
     * ��ȡ����(����) ��ʻԱְҵ
     * @return ����(����) ��ʻԱְҵ��ֵ
     */
    public String getDriverOccupation(){
        return driverOccupation;
    }

    /**
     * ���������Ļ��̶�
     * @param education �����õ������Ļ��̶ȵ�ֵ
     */
    public void setEducation(String education){
        this.education = StringUtils.rightTrim(education);
    }

    /**
     * ��ȡ�����Ļ��̶�
     * @return �����Ļ��̶ȵ�ֵ
     */
    public String getEducation(){
        return education;
    }

    /**
     * �������Ե�λ��ַ
     * @param unitAddress �����õ����Ե�λ��ַ��ֵ
     */
    public void setUnitAddress(String unitAddress){
        this.unitAddress = StringUtils.rightTrim(unitAddress);
    }

    /**
     * ��ȡ���Ե�λ��ַ
     * @return ���Ե�λ��ַ��ֵ
     */
    public String getUnitAddress(){
        return unitAddress;
    }

    /**
     * �����������֤����
     * @param identifyNumber �����õ��������֤�����ֵ
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * ��ȡ�������֤����
     * @return �������֤�����ֵ
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * ��������(����) ��ʻԱ�ȼ�
     * @param driverGrade �����õ�����(����) ��ʻԱ�ȼ���ֵ
     */
    public void setDriverGrade(int driverGrade){
        this.driverGrade = driverGrade;
    }

    /**
     * ��ȡ����(����) ��ʻԱ�ȼ�
     * @return ����(����) ��ʻԱ�ȼ���ֵ
     */
    public int getDriverGrade(){
        return driverGrade;
    }

    /**
     * ��������(����) ��ʻԱ����
     * @param driverSeaRoute �����õ�����(����) ��ʻԱ���ߵ�ֵ
     */
    public void setDriverSeaRoute(String driverSeaRoute){
        this.driverSeaRoute = StringUtils.rightTrim(driverSeaRoute);
    }

    /**
     * ��ȡ����(����) ��ʻԱ����
     * @return ����(����) ��ʻԱ���ߵ�ֵ
     */
    public String getDriverSeaRoute(){
        return driverSeaRoute;
    }

    /**
     * ��������(����) ��ʻԱ��֤ʱ��
     * @param receiveLicenseDate �����õ�����(����) ��ʻԱ��֤ʱ���ֵ
     */
    public void setReceiveLicenseDate(DateTime receiveLicenseDate){
        this.receiveLicenseDate = receiveLicenseDate;
    }

    /**
     * ��ȡ����(����) ��ʻԱ��֤ʱ��
     * @return ����(����) ��ʻԱ��֤ʱ���ֵ
     */
    public DateTime getReceiveLicenseDate(){
        return receiveLicenseDate;
    }

    /**
     * ��������׼�ݳ���
     * @param drivingCarType �����õ�����׼�ݳ��͵�ֵ
     */
    public void setDrivingCarType(String drivingCarType){
        this.drivingCarType = StringUtils.rightTrim(drivingCarType);
    }

    /**
     * ��ȡ����׼�ݳ���
     * @return ����׼�ݳ��͵�ֵ
     */
    public String getDrivingCarType(){
        return drivingCarType;
    }

    /**
     * ��������(����) ��ʻԱ��ʻ����
     * @param drivingYear �����õ�����(����) ��ʻԱ��ʻ���޵�ֵ
     */
    public void setDrivingYear(int drivingYear){
        this.drivingYear = drivingYear;
    }

    /**
     * ��ȡ����(����) ��ʻԱ��ʻ����
     * @return ����(����) ��ʻԱ��ʻ���޵�ֵ
     */
    public int getDrivingYear(){
        return drivingYear;
    }

    /**
     * �������԰�֤����
     * @param awardLicenseOrgan �����õ����԰�֤���ص�ֵ
     */
    public void setAwardLicenseOrgan(String awardLicenseOrgan){
        this.awardLicenseOrgan = StringUtils.rightTrim(awardLicenseOrgan);
    }

    /**
     * ��ȡ���԰�֤����
     * @return ���԰�֤���ص�ֵ
     */
    public String getAwardLicenseOrgan(){
        return awardLicenseOrgan;
    }

    /**
     * �����������޸��ٴ�����ʻ��ѵ�ϸ�֤��(0/1)
     * @param specialCertificate �����õ��������޸��ٴ�����ʻ��ѵ�ϸ�֤��(0/1)��ֵ
     */
    public void setSpecialCertificate(String specialCertificate){
        this.specialCertificate = StringUtils.rightTrim(specialCertificate);
    }

    /**
     * ��ȡ�������޸��ٴ�����ʻ��ѵ�ϸ�֤��(0/1)
     * @return �������޸��ٴ�����ʻ��ѵ�ϸ�֤��(0/1)��ֵ
     */
    public String getSpecialCertificate(){
        return specialCertificate;
    }

    /**
     * �������Ա�־�ֶ�
     * @param flag �����õ����Ա�־�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
     * @return ���Ա�־�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }

	public String getIdentifyType() {
		return identifyType;
	}

	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}
}
