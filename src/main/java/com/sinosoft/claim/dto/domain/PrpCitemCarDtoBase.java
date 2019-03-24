package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpCitemCar-�������ձ����Ϣ�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpCitemCarDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ���Ա������� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա����� */
    private long itemNo = 0L;
    /** ���Ա��������� */
    private String insuredTypeCode = "";
    /** ���Ա��������복����ϵ */
    private String carInsuredRelation = "";
    /** ���Գ��� */
    private String carOwner = "";
    /** ����������� */
    private String clauseType = "";
    /** �����Ƿ�Լ����ʻԱ��־ */
    private String agreeDriverFlag = "";
    /** �����Ƿ�Ͷ�������豸��־ */
    private String newDeviceFlag = "";
    /** ���Գ��ձ����� */
    private String carPolicyno = "";
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** ���Գ��Ƶ�ɫ���� */
    private String licenseColorCode = "";
    /** ���Գ���������� */
    private String carKindCode = "";
    /** �����Ƿ�۰ĳ���־ */
    private String hKFlag = "";
    /** ���Ը۰ĳ��ƺ��� */
    private String hKLicenseNo = "";
    /** ���Է������� */
    private String engineNo = "";
    /** ����VIN�� */
    private String vINNo = "";
    /** ���Գ��ܺ� */
    private String frameNo = "";
    /** ������ʻ������� */
    private String runAreaCode = "";
    /** ������ʻ�������� */
    private String runAreaName = "";
    /** ������ʻ���(����) */
    private double runMiles = 0D;
    /** ���Գ������� */
    private DateTime enrollDate = new DateTime();
    /** ����ʹ������ */
    private int useYears = 0;
    /** ���Գ��ʹ��� */
    private String modelCode = "";
    /** ���Գ����ͺ����� */
    private String brandName = "";
    /** ���Թ������� */
    private String countryNature = "";
    /** �����������Ҵ��� */
    private String countryCode = "";
    /** ����ʹ�����ʴ��� */
    private String useNatureCode = "";
    /** ����Ӫҵ���ʷ������ */
    private String businessClassCode = "";
    /** ������λ�� */
    private long seatCount = 0L;
    /** ���Զ�λ�� */
    private double tonCount = 0D;
    /** �������� */
    private double exhaustScale = 0D;
    /** ���Գ�����ɫ���� */
    private String colorCode = "";
    /** ���԰�ȫ���� */
    private String safeDevice = "";
    /** ���Թ̶�ͣ�ŵص� */
    private String parkSite = "";
    /** ���Թ����˵�ַ */
    private String ownerAddress = "";
    /** ������������ */
    private String otherNature = "";
    /** ���Է��ʺŴ� */
    private String rateCode = "";
    /** ������������ */
    private DateTime makeDate = new DateTime();
    /** ���Թ�����; */
    private String carUsage = "";
    /** ���Աұ���� */
    private String currency = "";
    /** �����³����ü۸� */
    private double purchasePrice = 0D;
    /** ����ʵ�ʼ�ֵ */
    private double actualValue = 0D;
    /** ���Թ�����Ʊ�� */
    private String invoiceNo = "";
    /** �����Ƿ����ҹ�˾Ͷ�����û�֤���� */
    private String carLoanFlag = "";
    /** ���Գб���˾���� */
    private String insurerCode = "";
    /** �������ڳб���˾ */
    private String lastInsurer = "";
    /** �����鳵��� */
    private String carCheckStatus = "";
    /** �����鳵�� */
    private String carChecker = "";
    /** �����鳵ʱ�� */
    private String carCheckTime = "";
    /** ����������Ŵ� */
    private double specialTreat = 0D;
    /** ���Ծ������� */
    private String relievingAreaCode = "";
    /** ���Ը��������� */
    private long addonCount = 0L;
    /** ���Ծ����̴��� */
    private String carDealerCode = "";
    /** ���Ծ��������� */
    private String carDealerName = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** ����CarCheckReason */
    private String carCheckReason = "";
    /** ����SvioLatedTimes */
    private long svioLatedTimes = 0L;
    /** ����LvioLatedTimes */
    private long lvioLatedTimes = 0L;
    /** ����LicenseKindCode */
    private String licenseKindCode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCitemCarDtoBase����
     */
    public PrpCitemCarDtoBase(){
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
     * �������Ա�����
     * @param itemNo �����õ����Ա����ŵ�ֵ
     */
    public void setItemNo(long itemNo){
        this.itemNo = itemNo;
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public long getItemNo(){
        return itemNo;
    }

    /**
     * �������Ա���������
     * @param insuredTypeCode �����õ����Ա����������ֵ
     */
    public void setInsuredTypeCode(String insuredTypeCode){
        this.insuredTypeCode = StringUtils.rightTrim(insuredTypeCode);
    }

    /**
     * ��ȡ���Ա���������
     * @return ���Ա����������ֵ
     */
    public String getInsuredTypeCode(){
        return insuredTypeCode;
    }

    /**
     * �������Ա��������복����ϵ
     * @param carInsuredRelation �����õ����Ա��������복����ϵ��ֵ
     */
    public void setCarInsuredRelation(String carInsuredRelation){
        this.carInsuredRelation = StringUtils.rightTrim(carInsuredRelation);
    }

    /**
     * ��ȡ���Ա��������복����ϵ
     * @return ���Ա��������복����ϵ��ֵ
     */
    public String getCarInsuredRelation(){
        return carInsuredRelation;
    }

    /**
     * �������Գ���
     * @param carOwner �����õ����Գ�����ֵ
     */
    public void setCarOwner(String carOwner){
        this.carOwner = StringUtils.rightTrim(carOwner);
    }

    /**
     * ��ȡ���Գ���
     * @return ���Գ�����ֵ
     */
    public String getCarOwner(){
        return carOwner;
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
     * ���������Ƿ�Լ����ʻԱ��־
     * @param agreeDriverFlag �����õ������Ƿ�Լ����ʻԱ��־��ֵ
     */
    public void setAgreeDriverFlag(String agreeDriverFlag){
        this.agreeDriverFlag = StringUtils.rightTrim(agreeDriverFlag);
    }

    /**
     * ��ȡ�����Ƿ�Լ����ʻԱ��־
     * @return �����Ƿ�Լ����ʻԱ��־��ֵ
     */
    public String getAgreeDriverFlag(){
        return agreeDriverFlag;
    }

    /**
     * ���������Ƿ�Ͷ�������豸��־
     * @param newDeviceFlag �����õ������Ƿ�Ͷ�������豸��־��ֵ
     */
    public void setNewDeviceFlag(String newDeviceFlag){
        this.newDeviceFlag = StringUtils.rightTrim(newDeviceFlag);
    }

    /**
     * ��ȡ�����Ƿ�Ͷ�������豸��־
     * @return �����Ƿ�Ͷ�������豸��־��ֵ
     */
    public String getNewDeviceFlag(){
        return newDeviceFlag;
    }

    /**
     * �������Գ��ձ�����
     * @param carPolicyno �����õ����Գ��ձ����ŵ�ֵ
     */
    public void setCarPolicyno(String carPolicyno){
        this.carPolicyno = StringUtils.rightTrim(carPolicyno);
    }

    /**
     * ��ȡ���Գ��ձ�����
     * @return ���Գ��ձ����ŵ�ֵ
     */
    public String getCarPolicyno(){
        return carPolicyno;
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
     * ���������Ƿ�۰ĳ���־
     * @param hKFlag �����õ������Ƿ�۰ĳ���־��ֵ
     */
    public void setHKFlag(String hKFlag){
        this.hKFlag = StringUtils.rightTrim(hKFlag);
    }

    /**
     * ��ȡ�����Ƿ�۰ĳ���־
     * @return �����Ƿ�۰ĳ���־��ֵ
     */
    public String getHKFlag(){
        return hKFlag;
    }

    /**
     * �������Ը۰ĳ��ƺ���
     * @param hKLicenseNo �����õ����Ը۰ĳ��ƺ����ֵ
     */
    public void setHKLicenseNo(String hKLicenseNo){
        this.hKLicenseNo = StringUtils.rightTrim(hKLicenseNo);
    }

    /**
     * ��ȡ���Ը۰ĳ��ƺ���
     * @return ���Ը۰ĳ��ƺ����ֵ
     */
    public String getHKLicenseNo(){
        return hKLicenseNo;
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
     * ��������VIN��
     * @param vINNo �����õ�����VIN�ŵ�ֵ
     */
    public void setVINNo(String vINNo){
        this.vINNo = StringUtils.rightTrim(vINNo);
    }

    /**
     * ��ȡ����VIN��
     * @return ����VIN�ŵ�ֵ
     */
    public String getVINNo(){
        return vINNo;
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
     * ����������ʻ�������
     * @param runAreaCode �����õ�������ʻ��������ֵ
     */
    public void setRunAreaCode(String runAreaCode){
        this.runAreaCode = StringUtils.rightTrim(runAreaCode);
    }

    /**
     * ��ȡ������ʻ�������
     * @return ������ʻ��������ֵ
     */
    public String getRunAreaCode(){
        return runAreaCode;
    }

    /**
     * ����������ʻ��������
     * @param runAreaName �����õ�������ʻ�������Ƶ�ֵ
     */
    public void setRunAreaName(String runAreaName){
        this.runAreaName = StringUtils.rightTrim(runAreaName);
    }

    /**
     * ��ȡ������ʻ��������
     * @return ������ʻ�������Ƶ�ֵ
     */
    public String getRunAreaName(){
        return runAreaName;
    }

    /**
     * ����������ʻ���(����)
     * @param runMiles �����õ�������ʻ���(����)��ֵ
     */
    public void setRunMiles(double runMiles){
        this.runMiles = runMiles;
    }

    /**
     * ��ȡ������ʻ���(����)
     * @return ������ʻ���(����)��ֵ
     */
    public double getRunMiles(){
        return runMiles;
    }

    /**
     * �������Գ�������
     * @param enrollDate �����õ����Գ������ڵ�ֵ
     */
    public void setEnrollDate(DateTime enrollDate){
        this.enrollDate = enrollDate;
    }

    /**
     * ��ȡ���Գ�������
     * @return ���Գ������ڵ�ֵ
     */
    public DateTime getEnrollDate(){
        return enrollDate;
    }

    /**
     * ��������ʹ������
     * @param useYears �����õ�����ʹ�����޵�ֵ
     */
    public void setUseYears(int useYears){
        this.useYears = useYears;
    }

    /**
     * ��ȡ����ʹ������
     * @return ����ʹ�����޵�ֵ
     */
    public int getUseYears(){
        return useYears;
    }

    /**
     * �������Գ��ʹ���
     * @param modelCode �����õ����Գ��ʹ����ֵ
     */
    public void setModelCode(String modelCode){
        this.modelCode = StringUtils.rightTrim(modelCode);
    }

    /**
     * ��ȡ���Գ��ʹ���
     * @return ���Գ��ʹ����ֵ
     */
    public String getModelCode(){
        return modelCode;
    }

    /**
     * �������Գ����ͺ�����
     * @param brandName �����õ����Գ����ͺ����Ƶ�ֵ
     */
    public void setBrandName(String brandName){
        this.brandName = StringUtils.rightTrim(brandName);
    }

    /**
     * ��ȡ���Գ����ͺ�����
     * @return ���Գ����ͺ����Ƶ�ֵ
     */
    public String getBrandName(){
        return brandName;
    }

    /**
     * �������Թ�������
     * @param countryNature �����õ����Թ������ʵ�ֵ
     */
    public void setCountryNature(String countryNature){
        this.countryNature = StringUtils.rightTrim(countryNature);
    }

    /**
     * ��ȡ���Թ�������
     * @return ���Թ������ʵ�ֵ
     */
    public String getCountryNature(){
        return countryNature;
    }

    /**
     * ���������������Ҵ���
     * @param countryCode �����õ������������Ҵ����ֵ
     */
    public void setCountryCode(String countryCode){
        this.countryCode = StringUtils.rightTrim(countryCode);
    }

    /**
     * ��ȡ�����������Ҵ���
     * @return �����������Ҵ����ֵ
     */
    public String getCountryCode(){
        return countryCode;
    }

    /**
     * ��������ʹ�����ʴ���
     * @param useNatureCode �����õ�����ʹ�����ʴ����ֵ
     */
    public void setUseNatureCode(String useNatureCode){
        this.useNatureCode = StringUtils.rightTrim(useNatureCode);
    }

    /**
     * ��ȡ����ʹ�����ʴ���
     * @return ����ʹ�����ʴ����ֵ
     */
    public String getUseNatureCode(){
        return useNatureCode;
    }

    /**
     * ��������Ӫҵ���ʷ������
     * @param businessClassCode �����õ�����Ӫҵ���ʷ�������ֵ
     */
    public void setBusinessClassCode(String businessClassCode){
        this.businessClassCode = StringUtils.rightTrim(businessClassCode);
    }

    /**
     * ��ȡ����Ӫҵ���ʷ������
     * @return ����Ӫҵ���ʷ�������ֵ
     */
    public String getBusinessClassCode(){
        return businessClassCode;
    }

    /**
     * ����������λ��
     * @param seatCount �����õ�������λ����ֵ
     */
    public void setSeatCount(long seatCount){
        this.seatCount = seatCount;
    }

    /**
     * ��ȡ������λ��
     * @return ������λ����ֵ
     */
    public long getSeatCount(){
        return seatCount;
    }

    /**
     * �������Զ�λ��
     * @param tonCount �����õ����Զ�λ����ֵ
     */
    public void setTonCount(double tonCount){
        this.tonCount = tonCount;
    }

    /**
     * ��ȡ���Զ�λ��
     * @return ���Զ�λ����ֵ
     */
    public double getTonCount(){
        return tonCount;
    }

    /**
     * ������������
     * @param exhaustScale �����õ�����������ֵ
     */
    public void setExhaustScale(double exhaustScale){
        this.exhaustScale = exhaustScale;
    }

    /**
     * ��ȡ��������
     * @return ����������ֵ
     */
    public double getExhaustScale(){
        return exhaustScale;
    }

    /**
     * �������Գ�����ɫ����
     * @param colorCode �����õ����Գ�����ɫ�����ֵ
     */
    public void setColorCode(String colorCode){
        this.colorCode = StringUtils.rightTrim(colorCode);
    }

    /**
     * ��ȡ���Գ�����ɫ����
     * @return ���Գ�����ɫ�����ֵ
     */
    public String getColorCode(){
        return colorCode;
    }

    /**
     * �������԰�ȫ����
     * @param safeDevice �����õ����԰�ȫ���õ�ֵ
     */
    public void setSafeDevice(String safeDevice){
        this.safeDevice = StringUtils.rightTrim(safeDevice);
    }

    /**
     * ��ȡ���԰�ȫ����
     * @return ���԰�ȫ���õ�ֵ
     */
    public String getSafeDevice(){
        return safeDevice;
    }

    /**
     * �������Թ̶�ͣ�ŵص�
     * @param parkSite �����õ����Թ̶�ͣ�ŵص��ֵ
     */
    public void setParkSite(String parkSite){
        this.parkSite = StringUtils.rightTrim(parkSite);
    }

    /**
     * ��ȡ���Թ̶�ͣ�ŵص�
     * @return ���Թ̶�ͣ�ŵص��ֵ
     */
    public String getParkSite(){
        return parkSite;
    }

    /**
     * �������Թ����˵�ַ
     * @param ownerAddress �����õ����Թ����˵�ַ��ֵ
     */
    public void setOwnerAddress(String ownerAddress){
        this.ownerAddress = StringUtils.rightTrim(ownerAddress);
    }

    /**
     * ��ȡ���Թ����˵�ַ
     * @return ���Թ����˵�ַ��ֵ
     */
    public String getOwnerAddress(){
        return ownerAddress;
    }

    /**
     * ����������������
     * @param otherNature �����õ������������ʵ�ֵ
     */
    public void setOtherNature(String otherNature){
        this.otherNature = StringUtils.rightTrim(otherNature);
    }

    /**
     * ��ȡ������������
     * @return �����������ʵ�ֵ
     */
    public String getOtherNature(){
        return otherNature;
    }

    /**
     * �������Է��ʺŴ�
     * @param rateCode �����õ����Է��ʺŴε�ֵ
     */
    public void setRateCode(String rateCode){
        this.rateCode = StringUtils.rightTrim(rateCode);
    }

    /**
     * ��ȡ���Է��ʺŴ�
     * @return ���Է��ʺŴε�ֵ
     */
    public String getRateCode(){
        return rateCode;
    }

    /**
     * ����������������
     * @param makeDate �����õ������������ڵ�ֵ
     */
    public void setMakeDate(DateTime makeDate){
        this.makeDate = makeDate;
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public DateTime getMakeDate(){
        return makeDate;
    }

    /**
     * �������Թ�����;
     * @param carUsage �����õ����Թ�����;��ֵ
     */
    public void setCarUsage(String carUsage){
        this.carUsage = StringUtils.rightTrim(carUsage);
    }

    /**
     * ��ȡ���Թ�����;
     * @return ���Թ�����;��ֵ
     */
    public String getCarUsage(){
        return carUsage;
    }

    /**
     * �������Աұ����
     * @param currency �����õ����Աұ�����ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ����
     * @return ���Աұ�����ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ���������³����ü۸�
     * @param purchasePrice �����õ������³����ü۸��ֵ
     */
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }

    /**
     * ��ȡ�����³����ü۸�
     * @return �����³����ü۸��ֵ
     */
    public double getPurchasePrice(){
        return purchasePrice;
    }

    /**
     * ��������ʵ�ʼ�ֵ
     * @param actualValue �����õ�����ʵ�ʼ�ֵ��ֵ
     */
    public void setActualValue(double actualValue){
        this.actualValue = actualValue;
    }

    /**
     * ��ȡ����ʵ�ʼ�ֵ
     * @return ����ʵ�ʼ�ֵ��ֵ
     */
    public double getActualValue(){
        return actualValue;
    }

    /**
     * �������Թ�����Ʊ��
     * @param invoiceNo �����õ����Թ�����Ʊ�ŵ�ֵ
     */
    public void setInvoiceNo(String invoiceNo){
        this.invoiceNo = StringUtils.rightTrim(invoiceNo);
    }

    /**
     * ��ȡ���Թ�����Ʊ��
     * @return ���Թ�����Ʊ�ŵ�ֵ
     */
    public String getInvoiceNo(){
        return invoiceNo;
    }

    /**
     * ���������Ƿ����ҹ�˾Ͷ�����û�֤����
     * @param carLoanFlag �����õ������Ƿ����ҹ�˾Ͷ�����û�֤���յ�ֵ
     */
    public void setCarLoanFlag(String carLoanFlag){
        this.carLoanFlag = StringUtils.rightTrim(carLoanFlag);
    }

    /**
     * ��ȡ�����Ƿ����ҹ�˾Ͷ�����û�֤����
     * @return �����Ƿ����ҹ�˾Ͷ�����û�֤���յ�ֵ
     */
    public String getCarLoanFlag(){
        return carLoanFlag;
    }

    /**
     * �������Գб���˾����
     * @param insurerCode �����õ����Գб���˾�����ֵ
     */
    public void setInsurerCode(String insurerCode){
        this.insurerCode = StringUtils.rightTrim(insurerCode);
    }

    /**
     * ��ȡ���Գб���˾����
     * @return ���Գб���˾�����ֵ
     */
    public String getInsurerCode(){
        return insurerCode;
    }

    /**
     * �����������ڳб���˾
     * @param lastInsurer �����õ��������ڳб���˾��ֵ
     */
    public void setLastInsurer(String lastInsurer){
        this.lastInsurer = StringUtils.rightTrim(lastInsurer);
    }

    /**
     * ��ȡ�������ڳб���˾
     * @return �������ڳб���˾��ֵ
     */
    public String getLastInsurer(){
        return lastInsurer;
    }

    /**
     * ���������鳵���
     * @param carCheckStatus �����õ������鳵�����ֵ
     */
    public void setCarCheckStatus(String carCheckStatus){
        this.carCheckStatus = StringUtils.rightTrim(carCheckStatus);
    }

    /**
     * ��ȡ�����鳵���
     * @return �����鳵�����ֵ
     */
    public String getCarCheckStatus(){
        return carCheckStatus;
    }

    /**
     * ���������鳵��
     * @param carChecker �����õ������鳵�˵�ֵ
     */
    public void setCarChecker(String carChecker){
        this.carChecker = StringUtils.rightTrim(carChecker);
    }

    /**
     * ��ȡ�����鳵��
     * @return �����鳵�˵�ֵ
     */
    public String getCarChecker(){
        return carChecker;
    }

    /**
     * ���������鳵ʱ��
     * @param carCheckTime �����õ������鳵ʱ���ֵ
     */
    public void setCarCheckTime(String carCheckTime){
        this.carCheckTime = StringUtils.rightTrim(carCheckTime);
    }

    /**
     * ��ȡ�����鳵ʱ��
     * @return �����鳵ʱ���ֵ
     */
    public String getCarCheckTime(){
        return carCheckTime;
    }

    /**
     * ��������������Ŵ�
     * @param specialTreat �����õ�����������Ŵ���ֵ
     */
    public void setSpecialTreat(double specialTreat){
        this.specialTreat = specialTreat;
    }

    /**
     * ��ȡ����������Ŵ�
     * @return ����������Ŵ���ֵ
     */
    public double getSpecialTreat(){
        return specialTreat;
    }

    /**
     * �������Ծ�������
     * @param relievingAreaCode �����õ����Ծ��������ֵ
     */
    public void setRelievingAreaCode(String relievingAreaCode){
        this.relievingAreaCode = StringUtils.rightTrim(relievingAreaCode);
    }

    /**
     * ��ȡ���Ծ�������
     * @return ���Ծ��������ֵ
     */
    public String getRelievingAreaCode(){
        return relievingAreaCode;
    }

    /**
     * �������Ը���������
     * @param addonCount �����õ����Ը�����������ֵ
     */
    public void setAddonCount(long addonCount){
        this.addonCount = addonCount;
    }

    /**
     * ��ȡ���Ը���������
     * @return ���Ը�����������ֵ
     */
    public long getAddonCount(){
        return addonCount;
    }

    /**
     * �������Ծ����̴���
     * @param carDealerCode �����õ����Ծ����̴����ֵ
     */
    public void setCarDealerCode(String carDealerCode){
        this.carDealerCode = StringUtils.rightTrim(carDealerCode);
    }

    /**
     * ��ȡ���Ծ����̴���
     * @return ���Ծ����̴����ֵ
     */
    public String getCarDealerCode(){
        return carDealerCode;
    }

    /**
     * �������Ծ���������
     * @param carDealerName �����õ����Ծ��������Ƶ�ֵ
     */
    public void setCarDealerName(String carDealerName){
        this.carDealerName = StringUtils.rightTrim(carDealerName);
    }

    /**
     * ��ȡ���Ծ���������
     * @return ���Ծ��������Ƶ�ֵ
     */
    public String getCarDealerName(){
        return carDealerName;
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
     * ��������CarCheckReason
     * @param carCheckReason �����õ�����CarCheckReason��ֵ
     */
    public void setCarCheckReason(String carCheckReason){
        this.carCheckReason = StringUtils.rightTrim(carCheckReason);
    }

    /**
     * ��ȡ����CarCheckReason
     * @return ����CarCheckReason��ֵ
     */
    public String getCarCheckReason(){
        return carCheckReason;
    }

    /**
     * ��������SvioLatedTimes
     * @param svioLatedTimes �����õ�����SvioLatedTimes��ֵ
     */
    public void setSvioLatedTimes(long svioLatedTimes){
        this.svioLatedTimes = svioLatedTimes;
    }

    /**
     * ��ȡ����SvioLatedTimes
     * @return ����SvioLatedTimes��ֵ
     */
    public long getSvioLatedTimes(){
        return svioLatedTimes;
    }

    /**
     * ��������LvioLatedTimes
     * @param lvioLatedTimes �����õ�����LvioLatedTimes��ֵ
     */
    public void setLvioLatedTimes(long lvioLatedTimes){
        this.lvioLatedTimes = lvioLatedTimes;
    }

    /**
     * ��ȡ����LvioLatedTimes
     * @return ����LvioLatedTimes��ֵ
     */
    public long getLvioLatedTimes(){
        return lvioLatedTimes;
    }

    /**
     * ��������LicenseKindCode
     * @param licenseKindCode �����õ�����LicenseKindCode��ֵ
     */
    public void setLicenseKindCode(String licenseKindCode){
        this.licenseKindCode = StringUtils.rightTrim(licenseKindCode);
    }

    /**
     * ��ȡ����LicenseKindCode
     * @return ����LicenseKindCode��ֵ
     */
    public String getLicenseKindCode(){
        return licenseKindCode;
    }
}
