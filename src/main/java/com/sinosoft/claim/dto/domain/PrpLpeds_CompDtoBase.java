package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLpeds_Comp�����嵥�ӿ����ݱ�����ݴ���������<br>
 * ������ 2004-4-5 15:32:04<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpeds_CompDtoBase implements Serializable{
    /** ���Ա����� */
    private String registNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Ա������� */
    private String insuredName = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Ա������������� */
    private int itemKindNo = 0;
    /** �����ձ���� */
    private String kindCode = "";
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** �������յ�ɫ */
    private String licenseColorCode = "";
    /** ���Գ��ܺ� */
    private String frameNo = "";
    /** ���Է��������� */
    private String engineNo = "";
    /** ���Գ������� */
    private String carKindCode = "";
    /** ���Բ�λ���� */
    private String partDesc = "";
    /** ����������Ŀ���� */
    private String compCode = "";
    /** ����������Ŀ���� */
    private String compName = "";
    /** �������� */
    private int quantity = 0;
    /** ���Աұ� */
    private String currency = "";
    /** ���Թ�ʱ�� */
    private double manHourFee = 0d;
    /** ���Բ��Ϸ� */
    private double materialFee = 0d;
    /** �����Ƿ����־ */
    private String transmitFlag = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpeds_CompDtoBase����
     */
    public PrpLpeds_CompDtoBase(){
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
     * �������Ա�������
     * @param insuredName �����õ����Ա������˵�ֵ
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա������˵�ֵ
     */
    public String getInsuredName(){
        return insuredName;
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
     * �������Ա�������������
     * @param itemKindNo �����õ����Ա������������ŵ�ֵ
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * ��ȡ���Ա�������������
     * @return ���Ա������������ŵ�ֵ
     */
    public int getItemKindNo(){
        return itemKindNo;
    }

    /**
     * ���������ձ����
     * @param kindCode �����õ������ձ�����ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ�����ձ����
     * @return �����ձ�����ֵ
     */
    public String getKindCode(){
        return kindCode;
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
     * �����������յ�ɫ
     * @param licenseColorCode �����õ��������յ�ɫ��ֵ
     */
    public void setLicenseColorCode(String licenseColorCode){
        this.licenseColorCode = StringUtils.rightTrim(licenseColorCode);
    }

    /**
     * ��ȡ�������յ�ɫ
     * @return �������յ�ɫ��ֵ
     */
    public String getLicenseColorCode(){
        return licenseColorCode;
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
     * �������Է���������
     * @param engineNo �����õ����Է����������ֵ
     */
    public void setEngineNo(String engineNo){
        this.engineNo = StringUtils.rightTrim(engineNo);
    }

    /**
     * ��ȡ���Է���������
     * @return ���Է����������ֵ
     */
    public String getEngineNo(){
        return engineNo;
    }

    /**
     * �������Գ�������
     * @param carKindCode �����õ����Գ��������ֵ
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * ��ȡ���Գ�������
     * @return ���Գ��������ֵ
     */
    public String getCarKindCode(){
        return carKindCode;
    }

    /**
     * �������Բ�λ����
     * @param partDesc �����õ����Բ�λ���Ƶ�ֵ
     */
    public void setPartDesc(String partDesc){
        this.partDesc = StringUtils.rightTrim(partDesc);
    }

    /**
     * ��ȡ���Բ�λ����
     * @return ���Բ�λ���Ƶ�ֵ
     */
    public String getPartDesc(){
        return partDesc;
    }

    /**
     * ��������������Ŀ����
     * @param compCode �����õ�����������Ŀ�����ֵ
     */
    public void setCompCode(String compCode){
        this.compCode = StringUtils.rightTrim(compCode);
    }

    /**
     * ��ȡ����������Ŀ����
     * @return ����������Ŀ�����ֵ
     */
    public String getCompCode(){
        return compCode;
    }

    /**
     * ��������������Ŀ����
     * @param compName �����õ�����������Ŀ���Ƶ�ֵ
     */
    public void setCompName(String compName){
        this.compName = StringUtils.rightTrim(compName);
    }

    /**
     * ��ȡ����������Ŀ����
     * @return ����������Ŀ���Ƶ�ֵ
     */
    public String getCompName(){
        return compName;
    }

    /**
     * ������������
     * @param quantity �����õ�����������ֵ
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * ��ȡ��������
     * @return ����������ֵ
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * �������Աұ�
     * @param currency �����õ����Աұ��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ�
     * @return ���Աұ��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * �������Թ�ʱ��
     * @param manHourFee �����õ����Թ�ʱ�ѵ�ֵ
     */
    public void setManHourFee(double manHourFee){
        this.manHourFee = manHourFee;
    }

    /**
     * ��ȡ���Թ�ʱ��
     * @return ���Թ�ʱ�ѵ�ֵ
     */
    public double getManHourFee(){
        return manHourFee;
    }

    /**
     * �������Բ��Ϸ�
     * @param materialFee �����õ����Բ��Ϸѵ�ֵ
     */
    public void setMaterialFee(double materialFee){
        this.materialFee = materialFee;
    }

    /**
     * ��ȡ���Բ��Ϸ�
     * @return ���Բ��Ϸѵ�ֵ
     */
    public double getMaterialFee(){
        return materialFee;
    }

    /**
     * ���������Ƿ����־
     * @param transmitFlag �����õ������Ƿ����־��ֵ
     */
    public void setTransmitFlag(String transmitFlag){
        this.transmitFlag = StringUtils.rightTrim(transmitFlag);
    }

    /**
     * ��ȡ�����Ƿ����־
     * @return �����Ƿ����־��ֵ
     */
    public String getTransmitFlag(){
        return transmitFlag;
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
}
