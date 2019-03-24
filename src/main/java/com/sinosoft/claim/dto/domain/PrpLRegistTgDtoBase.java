package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLregist��������Ϣ������ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLRegistTgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /**�����ύ������*/
    private DateTime submitDate = new DateTime();
    /**�����ύ��ʱ����*/
    private String SubmitHour="";
	/**���������ʱ����*/
	private String inputHour="";
	/**�Ƿ����ֳ�*/
	private String siteFlag="";
	/**���־���*/
	private String damageDescribe="";
	/**��������*/
	private String woundDescribe="";
	/**��ʧ����*/
	private String lossType="";
	/**��ʧ�̶�*/
	private String lossLevel="";
	/**���������ֻ���*/
	private String InsuredMobilePhone="";
	/**�������˹̶��绰*/
	private String insuredPhone="";
	/**��ʻԱ��ϵ�绰*/
	private String driverPhone="";
	/**�������Ƿ񱻱�����*/
	private String isinsureFlag="";
	/**��ʻԱ����*/
	private String driverName="";
	/**�������Ƿ��ʻԱ*/
	private String driverFlag="";
    
    
    /** ���Ա������� */
    private String registNo = "";
    /** ������������ */
    private String lFlag = "";
    /** ����������� */
    private String classCode = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** �������� */
    private String language = "";
    /** ���Ա������˴��� */
    private String insuredCode = "";
    /** ���Ա����������� */
    private String insuredName = "";
    /** ���Ա�������ͨѶ��ַ */
    private String insuredAddress = "";
    /** ����������� */
    private String clauseType = "";
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** ���Գ��Ƶ�ɫ���� */
    private String licenseColorCode = "";
    /** ���Գ���������� */
    private String carKindCode = "";
    /** ���Գ��ʹ���(��ϵ+����) */
    private String modelCode = "";
    /** ���Գ����ͺ� */
    private String brandName = "";
    /** ���Է������� */
    private String engineNo = "";
    /** ���Գ��ܺ� */
    private String frameNo = "";
    /** ���Գ�������ʻ������ */
    private double runDistance = 0D;
    /** ���Գ���ʵ��ʹ������ */
    private int useYears = 0;
    /** ���Ա������� */
    private DateTime reportDate = new DateTime();
    /** ���Ա���Сʱ */
    private String reportHour = "";
    /** ���Ա����ص� */
    private String reportAddress = "";
    /** ���Ա����� */
    private String reportorName = "";
    /** ���Ա�����ʽ */
    private String reportType = "";
    /** ���Ա�������ϵ�绰 */
    private String phoneNumber = "";
    /** ������ϵ�� */
    private String linkerName = "";
    /** ���Գ��������� */
    private DateTime damageStartDate = new DateTime();
    /** ���Գ��տ�ʼСʱ */
    private String damageStartHour = "";
    /** ���Գ�������ֹ */
    private DateTime damageEndDate = new DateTime();
    /** ���Գ�����ֹСʱ */
    private String damageEndHour = "";
    /** ���Գ���ԭ����� */
    private String damageCode = "";
    /** ���Գ���ԭ��˵�� */
    private String damageName = "";
    /** �����¹����ʹ���(����) */
    private String damageTypeCode = "";
    /** �����¹�����˵�� */
    private String damageTypeName = "";
    /** �����Ƿ��һ�ֳ� */
    private String firstSiteFlag = "";
    /** ���Գ���������� */
    private String damageAreaCode = "";
    /** ���Գ����������� */
    private String damageAreaName = "";
    /** ���Գ��յص���� */
    private String damageAddressType = "";
    /** ���Գ��յش��� */
    private String addressCode = "";
    /** ���Գ��յص� */
    private String damageAddress = "";
    /** ���Գ��յص��������� */
    private String damageAreaPostCode = "";
    /** �����¹ʴ����� */
    private String handleUnit = "";
    /** ���������� */
    private String lossName = "";
    /** �������������� */
    private double lossQuantity = 0D;
    /** ����������λ */
    private String unit = "";
    /** ���Թ���ұ� */
    private String estiCurrency = "";
    /** ���Թ����� */
    private double estimateLoss = 0D;
    /** ���ԽӰ�Ա���� */
    private String receiverName = "";
    /** ���Ծ����˴��� */
    private String handlerCode = "";
    /** ���Թ���ҵ��Ա���� */
    private String handler1Code = "";
    /** ����ҵ������������� */
    private String comCode = "";
    /** ���Լ�����䵥���� */
    private DateTime inputDate = new DateTime();
    /** ���������־(Y/N) */
    private String acceptFlag = "";
    /** �����Ƿ����ı��չ�˾Ͷ��(Y/N) */
    private String repeatInsureFlag = "";
    /** �����ⰸ��� */
    private String claimType = "";
    /** ����ע��/�������� */
    private DateTime cancelDate = new DateTime();
    /** ����ע��/�����˴��� */
    private String dealerCode = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ��������Ǽǻ��� */
    private String makeCom = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** ���Ա����˵绰 */
    private String reportorPhoneNumber = "";
    /** ������ϵ���ʱ� */
    private String linkerPostCode = "";
    /** ������ϵ��ͨѶ��ַ */
    private String linkerAddress = "";
    /** ����δ�����׼���� */
    private double estimateFee = 0D;
    /** ���Ծ���һ������ */
    private String catastropheCode1 = "";
    /** ���Ծ���һ������ */
    private String catastropheName1 = "";
    /** ���Ծ��ֶ������� */
    private String catastropheCode2 = "";
    /** ���Ծ��ֶ������� */
    private String catastropheName2 = "";
    /** ���Ա�����־ */
    private String reportFlag = "";
    /** �����¹��������� */
    private String indemnityDuty = "";
    private String damageArea = "";
    /** ���Գٱ�����־ */
    private String lateRegistFlag = "";
    /** ���Գٱ���ԭ�� */
    private String lateRegistReason = "";

	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLregistDtoBase����
     */
    public PrpLRegistTgDtoBase(){
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
     * ����������������
     * @param lFlag �����õ������������͵�ֵ
     */
    public void setLFlag(String lFlag){
        this.lFlag = StringUtils.rightTrim(lFlag);
    }

    /**
     * ��ȡ������������
     * @return �����������͵�ֵ
     */
    public String getLFlag(){
        return lFlag;
    }

    /**
     * ���������������
     * @param classCode �����õ�������������ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * �����������ִ���
     * @param riskCode �����õ��������ִ����ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }
    
    public String getDriverFlag() {
		return driverFlag;
	}

	public void setDriverFlag(String driverFlag) {
		this.driverFlag = driverFlag;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getIsinsureFlag() {
		return isinsureFlag;
	}

	public void setIsinsureFlag(String isinsureFlag) {
		this.isinsureFlag = isinsureFlag;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public String getInsuredPhone() {
		return insuredPhone;
	}

	public void setInsuredPhone(String insuredPhone) {
		this.insuredPhone = insuredPhone;
	}

	public String getInsuredMobilePhone() {
		return InsuredMobilePhone;
	}

	public void setInsuredMobilePhone(String insuredMobilePhone) {
		this.InsuredMobilePhone = insuredMobilePhone;
	}

	public String getLossLevel() {
		return lossLevel;
	}

	public void setLossLevel(String lossLevel) {
		this.lossLevel = lossLevel;
	}

	public String getLossType() {
		return lossType;
	}

	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	public String getWoundDescribe() {
		return woundDescribe;
	}

	public void setWoundDescribe(String woundDescribe) {
		this.woundDescribe = woundDescribe;
	}

	public String getDamageDescribe() {
		return damageDescribe;
	}

	public void setDamageDescribe(String damageDescribe) {
		this.damageDescribe = damageDescribe;
	}

	public String getSiteFlag() {
		return siteFlag;
	}

	public void setSiteFlag(String siteFlag) {
		this.siteFlag = siteFlag;
	}

	public String getInputHour() {
		return inputHour;
	}

	public void setInputHour(String inputHour) {
		this.inputHour = inputHour;
	}

    /**
     * ��ȡ�������ִ���
     * @return �������ִ����ֵ
     */
    public String getRiskCode(){
        return riskCode;
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
     * ������������
     * @param language �����õ��������ֵ�ֵ
     */
    public void setLanguage(String language){
        this.language = StringUtils.rightTrim(language);
    }

    /**
     * ��ȡ��������
     * @return �������ֵ�ֵ
     */
    public String getLanguage(){
        return language;
    }

    /**
     * �������Ա������˴���
     * @param insuredCode �����õ����Ա������˴����ֵ
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * ��ȡ���Ա������˴���
     * @return ���Ա������˴����ֵ
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * �������Ա�����������
     * @param insuredName �����õ����Ա����������Ƶ�ֵ
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * ��ȡ���Ա�����������
     * @return ���Ա����������Ƶ�ֵ
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * �������Ա�������ͨѶ��ַ
     * @param insuredAddress �����õ����Ա�������ͨѶ��ַ��ֵ
     */
    public void setInsuredAddress(String insuredAddress){
        this.insuredAddress = StringUtils.rightTrim(insuredAddress);
    }

    /**
     * ��ȡ���Ա�������ͨѶ��ַ
     * @return ���Ա�������ͨѶ��ַ��ֵ
     */
    public String getInsuredAddress(){
        return insuredAddress;
    }

    /**
     * ���������������
     * @param clauseType �����õ�������������ֵ
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getClauseType(){
        return clauseType;
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
     * �������Գ����������
     * @param carKindCode �����õ����Գ�����������ֵ
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * ��ȡ���Գ����������
     * @return ���Գ�����������ֵ
     */
    public String getCarKindCode(){
        return carKindCode;
    }

    /**
     * �������Գ��ʹ���(��ϵ+����)
     * @param modelCode �����õ����Գ��ʹ���(��ϵ+����)��ֵ
     */
    public void setModelCode(String modelCode){
        this.modelCode = StringUtils.rightTrim(modelCode);
    }

    /**
     * ��ȡ���Գ��ʹ���(��ϵ+����)
     * @return ���Գ��ʹ���(��ϵ+����)��ֵ
     */
    public String getModelCode(){
        return modelCode;
    }

    /**
     * �������Գ����ͺ�
     * @param brandName �����õ����Գ����ͺŵ�ֵ
     */
    public void setBrandName(String brandName){
        this.brandName = StringUtils.rightTrim(brandName);
    }

    /**
     * ��ȡ���Գ����ͺ�
     * @return ���Գ����ͺŵ�ֵ
     */
    public String getBrandName(){
        return brandName;
    }

    /**
     * �������Է�������
     * @param engineNo �����õ����Է������ŵ�ֵ
     */
    public void setEngineNo(String engineNo){
        this.engineNo = StringUtils.rightTrim(engineNo);
    }

    /**
     * ��ȡ���Է�������
     * @return ���Է������ŵ�ֵ
     */
    public String getEngineNo(){
        return engineNo;
    }

    /**
     * �������Գ��ܺ�
     * @param frameNo �����õ����Գ��ܺŵ�ֵ
     */
    public void setFrameNo(String frameNo){
        this.frameNo = StringUtils.rightTrim(frameNo);
    }

    /**
     * ��ȡ���Գ��ܺ�
     * @return ���Գ��ܺŵ�ֵ
     */
    public String getFrameNo(){
        return frameNo;
    }

    /**
     * �������Գ�������ʻ������
     * @param runDistance �����õ����Գ�������ʻ��������ֵ
     */
    public void setRunDistance(double runDistance){
        this.runDistance = runDistance;
    }

    /**
     * ��ȡ���Գ�������ʻ������
     * @return ���Գ�������ʻ��������ֵ
     */
    public double getRunDistance(){
        return runDistance;
    }

    /**
     * �������Գ���ʵ��ʹ������
     * @param useYears �����õ����Գ���ʵ��ʹ�����޵�ֵ
     */
    public void setUseYears(int useYears){
        this.useYears = useYears;
    }

    /**
     * ��ȡ���Գ���ʵ��ʹ������
     * @return ���Գ���ʵ��ʹ�����޵�ֵ
     */
    public int getUseYears(){
        return useYears;
    }

    /**
     * �������Ա�������
     * @param reportDate �����õ����Ա������ڵ�ֵ
     */
    public void setReportDate(DateTime reportDate){
        this.reportDate = reportDate;
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա������ڵ�ֵ
     */
    public DateTime getReportDate(){
        return reportDate;
    }

    /**
     * �������Ա���Сʱ
     * @param reportHour �����õ����Ա���Сʱ��ֵ
     */
    public void setReportHour(String reportHour){
        this.reportHour = StringUtils.rightTrim(reportHour);
    }

    /**
     * ��ȡ���Ա���Сʱ
     * @return ���Ա���Сʱ��ֵ
     */
    public String getReportHour(){
        return reportHour;
    }

    /**
     * �������Ա����ص�
     * @param reportAddress �����õ����Ա����ص��ֵ
     */
    public void setReportAddress(String reportAddress){
        this.reportAddress = StringUtils.rightTrim(reportAddress);
    }

    /**
     * ��ȡ���Ա����ص�
     * @return ���Ա����ص��ֵ
     */
    public String getReportAddress(){
        return reportAddress;
    }

    /**
     * �������Ա�����
     * @param reportorName �����õ����Ա����˵�ֵ
     */
    public void setReportorName(String reportorName){
        this.reportorName = StringUtils.rightTrim(reportorName);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����˵�ֵ
     */
    public String getReportorName(){
        return reportorName;
    }

    /**
     * �������Ա�����ʽ
     * @param reportType �����õ����Ա�����ʽ��ֵ
     */
    public void setReportType(String reportType){
        this.reportType = StringUtils.rightTrim(reportType);
    }

    /**
     * ��ȡ���Ա�����ʽ
     * @return ���Ա�����ʽ��ֵ
     */
    public String getReportType(){
        return reportType;
    }

    /**
     * �������Ա�������ϵ�绰
     * @param phoneNumber �����õ����Ա�������ϵ�绰��ֵ
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * ��ȡ���Ա�������ϵ�绰
     * @return ���Ա�������ϵ�绰��ֵ
     */
    public String getPhoneNumber(){
        return phoneNumber;
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
     * �������Գ���������
     * @param damageStartDate �����õ����Գ����������ֵ
     */
    public void setDamageStartDate(DateTime damageStartDate){
        this.damageStartDate = damageStartDate;
    }

    /**
     * ��ȡ���Գ���������
     * @return ���Գ����������ֵ
     */
    public DateTime getDamageStartDate(){
        return damageStartDate;
    }

    /**
     * �������Գ��տ�ʼСʱ
     * @param damageStartHour �����õ����Գ��տ�ʼСʱ��ֵ
     */
    public void setDamageStartHour(String damageStartHour){
        this.damageStartHour = StringUtils.rightTrim(damageStartHour);
    }

    /**
     * ��ȡ���Գ��տ�ʼСʱ
     * @return ���Գ��տ�ʼСʱ��ֵ
     */
    public String getDamageStartHour(){
        return damageStartHour;
    }

    /**
     * �������Գ�������ֹ
     * @param damageEndDate �����õ����Գ�������ֹ��ֵ
     */
    public void setDamageEndDate(DateTime damageEndDate){
        this.damageEndDate = damageEndDate;
    }

    /**
     * ��ȡ���Գ�������ֹ
     * @return ���Գ�������ֹ��ֵ
     */
    public DateTime getDamageEndDate(){
        return damageEndDate;
    }

    /**
     * �������Գ�����ֹСʱ
     * @param damageEndHour �����õ����Գ�����ֹСʱ��ֵ
     */
    public void setDamageEndHour(String damageEndHour){
        this.damageEndHour = StringUtils.rightTrim(damageEndHour);
    }

    /**
     * ��ȡ���Գ�����ֹСʱ
     * @return ���Գ�����ֹСʱ��ֵ
     */
    public String getDamageEndHour(){
        return damageEndHour;
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
     * �������Գ���ԭ��˵��
     * @param damageName �����õ����Գ���ԭ��˵����ֵ
     */
    public void setDamageName(String damageName){
        this.damageName = StringUtils.rightTrim(damageName);
    }

    /**
     * ��ȡ���Գ���ԭ��˵��
     * @return ���Գ���ԭ��˵����ֵ
     */
    public String getDamageName(){
        return damageName;
    }

    /**
     * ���������¹����ʹ���(����)
     * @param damageTypeCode �����õ������¹����ʹ���(����)��ֵ
     */
    public void setDamageTypeCode(String damageTypeCode){
        this.damageTypeCode = StringUtils.rightTrim(damageTypeCode);
    }

    /**
     * ��ȡ�����¹����ʹ���(����)
     * @return �����¹����ʹ���(����)��ֵ
     */
    public String getDamageTypeCode(){
        return damageTypeCode;
    }

    /**
     * ���������¹�����˵��
     * @param damageTypeName �����õ������¹�����˵����ֵ
     */
    public void setDamageTypeName(String damageTypeName){
        this.damageTypeName = StringUtils.rightTrim(damageTypeName);
    }

    /**
     * ��ȡ�����¹�����˵��
     * @return �����¹�����˵����ֵ
     */
    public String getDamageTypeName(){
        return damageTypeName;
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
     * �������Գ�����������
     * @param damageAreaName �����õ����Գ����������Ƶ�ֵ
     */
    public void setDamageAreaName(String damageAreaName){
        this.damageAreaName = StringUtils.rightTrim(damageAreaName);
    }

    /**
     * ��ȡ���Գ�����������
     * @return ���Գ����������Ƶ�ֵ
     */
    public String getDamageAreaName(){
        return damageAreaName;
    }

    /**
     * �������Գ��յص����
     * @param damageAddressType �����õ����Գ��յص�����ֵ
     */
    public void setDamageAddressType(String damageAddressType){
        this.damageAddressType = StringUtils.rightTrim(damageAddressType);
    }

    /**
     * ��ȡ���Գ��յص����
     * @return ���Գ��յص�����ֵ
     */
    public String getDamageAddressType(){
        return damageAddressType;
    }

    /**
     * �������Գ��յش���
     * @param addressCode �����õ����Գ��յش����ֵ
     */
    public void setAddressCode(String addressCode){
        this.addressCode = StringUtils.rightTrim(addressCode);
    }

    /**
     * ��ȡ���Գ��յش���
     * @return ���Գ��յش����ֵ
     */
    public String getAddressCode(){
        return addressCode;
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
     * �������Գ��յص���������
     * @param damageAreaPostCode �����õ����Գ��յص����������ֵ
     */
    public void setDamageAreaPostCode(String damageAreaPostCode){
        this.damageAreaPostCode = StringUtils.rightTrim(damageAreaPostCode);
    }

    /**
     * ��ȡ���Գ��յص���������
     * @return ���Գ��յص����������ֵ
     */
    public String getDamageAreaPostCode(){
        return damageAreaPostCode;
    }

    /**
     * ���������¹ʴ�����
     * @param handleUnit �����õ������¹ʴ����ŵ�ֵ
     */
    public void setHandleUnit(String handleUnit){
        this.handleUnit = StringUtils.rightTrim(handleUnit);
    }

    /**
     * ��ȡ�����¹ʴ�����
     * @return �����¹ʴ����ŵ�ֵ
     */
    public String getHandleUnit(){
        return handleUnit;
    }

    /**
     * ��������������
     * @param lossName �����õ����������ĵ�ֵ
     */
    public void setLossName(String lossName){
        this.lossName = StringUtils.rightTrim(lossName);
    }

    /**
     * ��ȡ����������
     * @return ���������ĵ�ֵ
     */
    public String getLossName(){
        return lossName;
    }

    /**
     * ������������������
     * @param lossQuantity �����õ�����������������ֵ
     */
    public void setLossQuantity(double lossQuantity){
        this.lossQuantity = lossQuantity;
    }

    /**
     * ��ȡ��������������
     * @return ����������������ֵ
     */
    public double getLossQuantity(){
        return lossQuantity;
    }

    /**
     * ��������������λ
     * @param unit �����õ�����������λ��ֵ
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * ��ȡ����������λ
     * @return ����������λ��ֵ
     */
    public String getUnit(){
        return unit;
    }

    /**
     * �������Թ���ұ�
     * @param estiCurrency �����õ����Թ���ұ��ֵ
     */
    public void setEstiCurrency(String estiCurrency){
        this.estiCurrency = StringUtils.rightTrim(estiCurrency);
    }

    /**
     * ��ȡ���Թ���ұ�
     * @return ���Թ���ұ��ֵ
     */
    public String getEstiCurrency(){
        return estiCurrency;
    }

    /**
     * �������Թ�����
     * @param estimateLoss �����õ����Թ������ֵ
     */
    public void setEstimateLoss(double estimateLoss){
        this.estimateLoss = estimateLoss;
    }

    /**
     * ��ȡ���Թ�����
     * @return ���Թ������ֵ
     */
    public double getEstimateLoss(){
        return estimateLoss;
    }

    /**
     * �������ԽӰ�Ա����
     * @param receiverName �����õ����ԽӰ�Ա������ֵ
     */
    public void setReceiverName(String receiverName){
        this.receiverName = StringUtils.rightTrim(receiverName);
    }

    /**
     * ��ȡ���ԽӰ�Ա����
     * @return ���ԽӰ�Ա������ֵ
     */
    public String getReceiverName(){
        return receiverName;
    }

    /**
     * �������Ծ����˴���
     * @param handlerCode �����õ����Ծ����˴����ֵ
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * ��ȡ���Ծ����˴���
     * @return ���Ծ����˴����ֵ
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * �������Թ���ҵ��Ա����
     * @param handler1Code �����õ����Թ���ҵ��Ա�����ֵ
     */
    public void setHandler1Code(String handler1Code){
        this.handler1Code = StringUtils.rightTrim(handler1Code);
    }

    /**
     * ��ȡ���Թ���ҵ��Ա����
     * @return ���Թ���ҵ��Ա�����ֵ
     */
    public String getHandler1Code(){
        return handler1Code;
    }

    /**
     * ��������ҵ�������������
     * @param comCode �����õ�����ҵ��������������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����ҵ�������������
     * @return ����ҵ��������������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Լ�����䵥����
     * @param inputDate �����õ����Լ�����䵥���ڵ�ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ���Լ�����䵥����
     * @return ���Լ�����䵥���ڵ�ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * �������������־(Y/N)
     * @param acceptFlag �����õ����������־(Y/N)��ֵ
     */
    public void setAcceptFlag(String acceptFlag){
        this.acceptFlag = StringUtils.rightTrim(acceptFlag);
    }

    /**
     * ��ȡ���������־(Y/N)
     * @return ���������־(Y/N)��ֵ
     */
    public String getAcceptFlag(){
        return acceptFlag;
    }

    /**
     * ���������Ƿ����ı��չ�˾Ͷ��(Y/N)
     * @param repeatInsureFlag �����õ������Ƿ����ı��չ�˾Ͷ��(Y/N)��ֵ
     */
    public void setRepeatInsureFlag(String repeatInsureFlag){
        this.repeatInsureFlag = StringUtils.rightTrim(repeatInsureFlag);
    }

    /**
     * ��ȡ�����Ƿ����ı��չ�˾Ͷ��(Y/N)
     * @return �����Ƿ����ı��չ�˾Ͷ��(Y/N)��ֵ
     */
    public String getRepeatInsureFlag(){
        return repeatInsureFlag;
    }

    /**
     * ���������ⰸ���
     * @param claimType �����õ������ⰸ����ֵ
     */
    public void setClaimType(String claimType){
        this.claimType = StringUtils.rightTrim(claimType);
    }

    /**
     * ��ȡ�����ⰸ���
     * @return �����ⰸ����ֵ
     */
    public String getClaimType(){
        return claimType;
    }

    /**
     * ��������ע��/��������
     * @param cancelDate �����õ�����ע��/�������ڵ�ֵ
     */
    public void setCancelDate(DateTime cancelDate){
        this.cancelDate = cancelDate;
    }

    /**
     * ��ȡ����ע��/��������
     * @return ����ע��/�������ڵ�ֵ
     */
    public DateTime getCancelDate(){
        return cancelDate;
    }

    /**
     * ��������ע��/�����˴���
     * @param dealerCode �����õ�����ע��/�����˴����ֵ
     */
    public void setDealerCode(String dealerCode){
        this.dealerCode = StringUtils.rightTrim(dealerCode);
    }

    /**
     * ��ȡ����ע��/�����˴���
     * @return ����ע��/�����˴����ֵ
     */
    public String getDealerCode(){
        return dealerCode;
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
     * �������Բ���Ա����
     * @param operatorCode �����õ����Բ���Ա�����ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Բ���Ա����
     * @return ���Բ���Ա�����ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * ������������Ǽǻ���
     * @param makeCom �����õ���������Ǽǻ�����ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ��������Ǽǻ���
     * @return ��������Ǽǻ�����ֵ
     */
    public String getMakeCom(){
        return makeCom;
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

    /**
     * �������Ա����˵绰
     * @param reportorPhoneNumber �����õ����Ա����˵绰��ֵ
     */
    public void setReportorPhoneNumber(String reportorPhoneNumber){
        this.reportorPhoneNumber = StringUtils.rightTrim(reportorPhoneNumber);
    }

    /**
     * ��ȡ���Ա����˵绰
     * @return ���Ա����˵绰��ֵ
     */
    public String getReportorPhoneNumber(){
        return reportorPhoneNumber;
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
     * ��������δ�����׼����
     * @param estimateFee �����õ�����δ�����׼�����ֵ
     */
    public void setEstimateFee(double estimateFee){
        this.estimateFee = estimateFee;
    }

    /**
     * ��ȡ����δ�����׼����
     * @return ����δ�����׼�����ֵ
     */
    public double getEstimateFee(){
        return estimateFee;
    }

    /**
     * �������Ծ���һ������
     * @param catastropheCode1 �����õ����Ծ���һ�������ֵ
     */
    public void setCatastropheCode1(String catastropheCode1){
        this.catastropheCode1 = StringUtils.rightTrim(catastropheCode1);
    }

    /**
     * ��ȡ���Ծ���һ������
     * @return ���Ծ���һ�������ֵ
     */
    public String getCatastropheCode1(){
        return catastropheCode1;
    }

    /**
     * �������Ծ���һ������
     * @param catastropheName1 �����õ����Ծ���һ�����Ƶ�ֵ
     */
    public void setCatastropheName1(String catastropheName1){
        this.catastropheName1 = StringUtils.rightTrim(catastropheName1);
    }

    /**
     * ��ȡ���Ծ���һ������
     * @return ���Ծ���һ�����Ƶ�ֵ
     */
    public String getCatastropheName1(){
        return catastropheName1;
    }

    /**
     * �������Ծ��ֶ�������
     * @param catastropheCode2 �����õ����Ծ��ֶ��������ֵ
     */
    public void setCatastropheCode2(String catastropheCode2){
        this.catastropheCode2 = StringUtils.rightTrim(catastropheCode2);
    }

    /**
     * ��ȡ���Ծ��ֶ�������
     * @return ���Ծ��ֶ��������ֵ
     */
    public String getCatastropheCode2(){
        return catastropheCode2;
    }

    /**
     * �������Ծ��ֶ�������
     * @param catastropheName2 �����õ����Ծ��ֶ������Ƶ�ֵ
     */
    public void setCatastropheName2(String catastropheName2){
        this.catastropheName2 = StringUtils.rightTrim(catastropheName2);
    }

    /**
     * ��ȡ���Ծ��ֶ�������
     * @return ���Ծ��ֶ������Ƶ�ֵ
     */
    public String getCatastropheName2(){
        return catastropheName2;
    }

    /**
     * �������Ա�����־
     * @param reportFlag �����õ����Ա�����־��ֵ
     */
    public void setReportFlag(String reportFlag){
        this.reportFlag = StringUtils.rightTrim(reportFlag);
    }

    /**
     * ��ȡ���Ա�����־
     * @return ���Ա�����־��ֵ
     */
    public String getReportFlag(){
        return reportFlag;
    }

    /**
     * ���������¹���������
     * @param indemnityDuty �����õ������¹��������͵�ֵ
     */
    public void setIndemnityDuty(String indemnityDuty){
        this.indemnityDuty = StringUtils.rightTrim(indemnityDuty);
    }

    /**
     * ��ȡ�����¹���������
     * @return �����¹��������͵�ֵ
     */
    public String getIndemnityDuty(){
        return indemnityDuty;
    }

	public DateTime getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(DateTime submitDate) {
		this.submitDate = submitDate;
	}

	public String getSubmitHour() {
		return SubmitHour;
	}

	public void setSubmitHour(String submitHour) {
		this.SubmitHour = submitHour;
	}

	public String getDamageArea() {
		return damageArea;
	}

	public void setDamageArea(String damageArea) {
		this.damageArea = damageArea;
	}

	public String getLateRegistFlag() {
		return lateRegistFlag;
	}

	public void setLateRegistFlag(String lateRegistFlag) {
		this.lateRegistFlag = lateRegistFlag;
	}

	public String getLateRegistReason() {
		return lateRegistReason;
	}

	public void setLateRegistReason(String lateRegistReason) {
		this.lateRegistReason = lateRegistReason;
	}
	
}
