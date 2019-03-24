package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLCItemCar-���Ᵽ��������������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.640<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLCItemCarDtoBase implements Serializable{
    /** �����ⰸ�� */
    private String claimNo = "";
    /** ���Ա����� */
    private String registNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա��������복����ϵ */
    private String carInsuredRelation = "";
    /** ���Գ��� */
    private String carOwner = "";
    /** ����������� */
    private String clauseType = "";
    /** �����Ƿ�Լ����ʻԱ��־1��/0�� */
    private String agreeDriverFlag = "";
    /** �����Ƿ�Ͷ�������豸��־1��/0�� */
    private String newDeviceFlag = "";
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** ���Գ��Ƶ�ɫ���� */
    private String licenseColorCode = "";
    /** ���Գ���������� ��
--** �ͳ�/����/�ͻ�����/
--** Ħ�г�/������/���ֳ�/�� */
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
    private double runMiles = 0d;
    /** ���Գ������� */
    private DateTime enrollDate = new DateTime();
    /** ����ʹ������ */
    private int useYears = 0;
    /** ���Գ����ͺ� */
    private String brandName = "";
    /** ����ʹ�����ʴ���--** ������ҵ��/��ͥ����/�� */
    private String useNatureCode = "";
    /** ������λ�� */
    private int seatCount = 0;
    /** ���Զ�λ�� */
    private double tonCount = 0d;
    /** �������� */
    private double exhaustScale = 0d;
    /** ���Գ�����ɫ���� */
    private String colorCode = "";
    /** ���԰�ȫ����--** ����ѡ�������룬�ö��ŷָ���
--** ��ȫ����/ABS/�� */
    private String safeDevice = "";
    /** ������������ [1]���Ƿ��������������ά������ ��¼��1/0����/�ޣ�
--** [2]�������Ƿ��ڱ���˾Ͷ����1/0�� ��/�ޣ�
--** [3]��Ͷ�����Ƿ��ṩ����ʵ�꾡�ı�����Ϣ, 1/0�� ��/�ޣ�
--** [4]���Żݸ�����ʽ1������ 2������ */
    private String otherNature = "";
    /** ���Է��ʺŴ� */
    private String rateCode = "";
    /** ���Թ̶�ͣ�ŵص� */
    private String parkSite = "";
    /** �����³����ü� */
    private double purchasePrice = 0d;
    /** �����Ƿ����ҹ�˾Ͷ�����û�֤����
--** 1��/0�� */
    private String carLoanFlag = "";
    /** ���Աұ���� */
    private String currency = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLCItemCarDtoBase����
     */
    public PrpLCItemCarDtoBase(){
    }

    /**
     * ���������ⰸ��
     * @param claimNo �����õ������ⰸ�ŵ�ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ��
     * @return �����ⰸ�ŵ�ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * �������Ա�����
     * @param registNo �����õ����Ա����ŵ�ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getRegistNo(){
        return registNo;
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
     * ���������Ƿ�Լ����ʻԱ��־1��/0��
     * @param agreeDriverFlag �����õ������Ƿ�Լ����ʻԱ��־1��/0���ֵ
     */
    public void setAgreeDriverFlag(String agreeDriverFlag){
        this.agreeDriverFlag = StringUtils.rightTrim(agreeDriverFlag);
    }

    /**
     * ��ȡ�����Ƿ�Լ����ʻԱ��־1��/0��
     * @return �����Ƿ�Լ����ʻԱ��־1��/0���ֵ
     */
    public String getAgreeDriverFlag(){
        return agreeDriverFlag;
    }

    /**
     * ���������Ƿ�Ͷ�������豸��־1��/0��
     * @param newDeviceFlag �����õ������Ƿ�Ͷ�������豸��־1��/0���ֵ
     */
    public void setNewDeviceFlag(String newDeviceFlag){
        this.newDeviceFlag = StringUtils.rightTrim(newDeviceFlag);
    }

    /**
     * ��ȡ�����Ƿ�Ͷ�������豸��־1��/0��
     * @return �����Ƿ�Ͷ�������豸��־1��/0���ֵ
     */
    public String getNewDeviceFlag(){
        return newDeviceFlag;
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
     * �������Գ���������� ��
--** �ͳ�/����/�ͻ�����/
--** Ħ�г�/������/���ֳ�/��
     * @param carKindCode �����õ����Գ���������� ��
--** �ͳ�/����/�ͻ�����/
--** Ħ�г�/������/���ֳ�/����ֵ
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * ��ȡ���Գ���������� ��
--** �ͳ�/����/�ͻ�����/
--** Ħ�г�/������/���ֳ�/��
     * @return ���Գ���������� ��
--** �ͳ�/����/�ͻ�����/
--** Ħ�г�/������/���ֳ�/����ֵ
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
     * ��������ʹ�����ʴ���--** ������ҵ��/��ͥ����/��
     * @param useNatureCode �����õ�����ʹ�����ʴ���--** ������ҵ��/��ͥ����/����ֵ
     */
    public void setUseNatureCode(String useNatureCode){
        this.useNatureCode = StringUtils.rightTrim(useNatureCode);
    }

    /**
     * ��ȡ����ʹ�����ʴ���--** ������ҵ��/��ͥ����/��
     * @return ����ʹ�����ʴ���--** ������ҵ��/��ͥ����/����ֵ
     */
    public String getUseNatureCode(){
        return useNatureCode;
    }

    /**
     * ����������λ��
     * @param seatCount �����õ�������λ����ֵ
     */
    public void setSeatCount(int seatCount){
        this.seatCount = seatCount;
    }

    /**
     * ��ȡ������λ��
     * @return ������λ����ֵ
     */
    public int getSeatCount(){
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
     * �������԰�ȫ����--** ����ѡ�������룬�ö��ŷָ���
--** ��ȫ����/ABS/��
     * @param safeDevice �����õ����԰�ȫ����--** ����ѡ�������룬�ö��ŷָ���
--** ��ȫ����/ABS/����ֵ
     */
    public void setSafeDevice(String safeDevice){
        this.safeDevice = StringUtils.rightTrim(safeDevice);
    }

    /**
     * ��ȡ���԰�ȫ����--** ����ѡ�������룬�ö��ŷָ���
--** ��ȫ����/ABS/��
     * @return ���԰�ȫ����--** ����ѡ�������룬�ö��ŷָ���
--** ��ȫ����/ABS/����ֵ
     */
    public String getSafeDevice(){
        return safeDevice;
    }

    /**
     * ���������������� [1]���Ƿ��������������ά������ ��¼��1/0����/�ޣ�
--** [2]�������Ƿ��ڱ���˾Ͷ����1/0�� ��/�ޣ�
--** [3]��Ͷ�����Ƿ��ṩ����ʵ�꾡�ı�����Ϣ, 1/0�� ��/�ޣ�
--** [4]���Żݸ�����ʽ1������ 2������
     * @param otherNature �����õ������������� [1]���Ƿ��������������ά������ ��¼��1/0����/�ޣ�
--** [2]�������Ƿ��ڱ���˾Ͷ����1/0�� ��/�ޣ�
--** [3]��Ͷ�����Ƿ��ṩ����ʵ�꾡�ı�����Ϣ, 1/0�� ��/�ޣ�
--** [4]���Żݸ�����ʽ1������ 2�����ӵ�ֵ
     */
    public void setOtherNature(String otherNature){
        this.otherNature = StringUtils.rightTrim(otherNature);
    }

    /**
     * ��ȡ������������ [1]���Ƿ��������������ά������ ��¼��1/0����/�ޣ�
--** [2]�������Ƿ��ڱ���˾Ͷ����1/0�� ��/�ޣ�
--** [3]��Ͷ�����Ƿ��ṩ����ʵ�꾡�ı�����Ϣ, 1/0�� ��/�ޣ�
--** [4]���Żݸ�����ʽ1������ 2������
     * @return ������������ [1]���Ƿ��������������ά������ ��¼��1/0����/�ޣ�
--** [2]�������Ƿ��ڱ���˾Ͷ����1/0�� ��/�ޣ�
--** [3]��Ͷ�����Ƿ��ṩ����ʵ�꾡�ı�����Ϣ, 1/0�� ��/�ޣ�
--** [4]���Żݸ�����ʽ1������ 2�����ӵ�ֵ
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
     * ���������³����ü�
     * @param purchasePrice �����õ������³����ü۵�ֵ
     */
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }

    /**
     * ��ȡ�����³����ü�
     * @return �����³����ü۵�ֵ
     */
    public double getPurchasePrice(){
        return purchasePrice;
    }

    /**
     * ���������Ƿ����ҹ�˾Ͷ�����û�֤����
--** 1��/0��
     * @param carLoanFlag �����õ������Ƿ����ҹ�˾Ͷ�����û�֤����
--** 1��/0���ֵ
     */
    public void setCarLoanFlag(String carLoanFlag){
        this.carLoanFlag = StringUtils.rightTrim(carLoanFlag);
    }

    /**
     * ��ȡ�����Ƿ����ҹ�˾Ͷ�����û�֤����
--** 1��/0��
     * @return �����Ƿ����ҹ�˾Ͷ�����û�֤����
--** 1��/0���ֵ
     */
    public String getCarLoanFlag(){
        return carLoanFlag;
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
}
