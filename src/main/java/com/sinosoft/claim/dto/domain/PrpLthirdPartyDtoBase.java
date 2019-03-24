package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLthirdParty-���⳵����Ϣ(�޸�)�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.484<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLthirdPartyDtoBase implements Serializable{
    /** ���Ա������� */
    private String registNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ������� */
    private int serialNo = 0;
    /** �����ⰸ�� */
    private String claimNo = "";
    /** �����������ѡ����룩 */
    private String clauseType = "";
    /** ���Գ��ƺ� */
    private String licenseNo = "";
    /** ���Գ��Ƶ�ɫ���� */
    private String licenseColorCode = "";
    /** ���Գ���������� */
    private String carKindCode = "";
    /** �����Ƿ�Ϊ����������(1.��2.��) */
    private String insureCarFlag = "";
    /** ���Գ��� */
    private String carOwner = "";
    /** ���Է������� */
    private String engineNo = "";
    /** ���Գ��ܺ� */
    private String frameNo = "";
    /** ���Գ��ʹ���(��ϵ+����) */
    private String modelCode = "";
    /** ���Գ����ͺ� */
    private String brandName = "";
    /** ���Գ�������ʻ������ */
    private double runDistance = 0d;
    /** ���Գ���ʵ��ʹ������ */
    private int useYears = 0;
    /** ���Ա������α��� */
    private double dutyPercent = 0d;
    /** �����Ƿ��գ�0-��1-��2-δ֪�� */
    private String insuredFlag = "";
    /** ���Գб���˾���� */
    private String insureComCode = "";
    /** ���Գб���˾���� */
    private String insureComName = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** ����VIN���� */
    private String vINNo = "";
    /** ���������־ */
    private String lossFlag = "";
    /** ���Գ����������� */
    private String carPolicyNo = "";
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLthirdPartyDtoBase����
     */
    public PrpLthirdPartyDtoBase(){
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
     * ���������������ѡ����룩
     * @param clauseType �����õ������������ѡ����룩��ֵ
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * ��ȡ�����������ѡ����룩
     * @return �����������ѡ����룩��ֵ
     */
    public String getClauseType(){
        return clauseType;
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
     * ���������Ƿ�Ϊ����������(1.��2.��)
     * @param insureCarFlag �����õ������Ƿ�Ϊ����������(1.��2.��)��ֵ
     */
    public void setInsureCarFlag(String insureCarFlag){
        this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
    }

    /**
     * ��ȡ�����Ƿ�Ϊ����������(1.��2.��)
     * @return �����Ƿ�Ϊ����������(1.��2.��)��ֵ
     */
    public String getInsureCarFlag(){
        return insureCarFlag;
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
     * �������Ա������α���
     * @param dutyPercent �����õ����Ա������α�����ֵ
     */
    public void setDutyPercent(double dutyPercent){
        this.dutyPercent = dutyPercent;
    }

    /**
     * ��ȡ���Ա������α���
     * @return ���Ա������α�����ֵ
     */
    public double getDutyPercent(){
        return dutyPercent;
    }

    /**
     * ���������Ƿ��գ�0-��1-��2-δ֪��
     * @param insuredFlag �����õ������Ƿ��գ�0-��1-��2-δ֪����ֵ
     */
    public void setInsuredFlag(String insuredFlag){
        this.insuredFlag = StringUtils.rightTrim(insuredFlag);
    }

    /**
     * ��ȡ�����Ƿ��գ�0-��1-��2-δ֪��
     * @return �����Ƿ��գ�0-��1-��2-δ֪����ֵ
     */
    public String getInsuredFlag(){
        return insuredFlag;
    }

    /**
     * �������Գб���˾����
     * @param insureComCode �����õ����Գб���˾�����ֵ
     */
    public void setInsureComCode(String insureComCode){
        this.insureComCode = StringUtils.rightTrim(insureComCode);
    }

    /**
     * ��ȡ���Գб���˾����
     * @return ���Գб���˾�����ֵ
     */
    public String getInsureComCode(){
        return insureComCode;
    }

    /**
     * �������Գб���˾����
     * @param insureComName �����õ����Գб���˾���Ƶ�ֵ
     */
    public void setInsureComName(String insureComName){
        this.insureComName = StringUtils.rightTrim(insureComName);
    }

    /**
     * ��ȡ���Գб���˾����
     * @return ���Գб���˾���Ƶ�ֵ
     */
    public String getInsureComName(){
        return insureComName;
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
     * ��������VIN����
     * @param vINNo �����õ�����VIN�����ֵ
     */
    public void setVINNo(String vINNo){
        this.vINNo = StringUtils.rightTrim(vINNo);
    }

    /**
     * ��ȡ����VIN����
     * @return ����VIN�����ֵ
     */
    public String getVINNo(){
        return vINNo;
    }
    /**
     * ��������LossFlag�����־
     * @param lossFlag �����õ����������־��ֵ
     */
    public void setLossFlag(String lossFlag){
        this.lossFlag = StringUtils.rightTrim(lossFlag);
    }

    /**
     * ��ȡ����LossFlag�����־
     * @return ����lossFlag�����־��ֵ
     */
    public String getLossFlag(){
        return lossFlag;
    }

	/**
	 * ��ȡ���� carPolicyNo
	 * @return the carPolicyNo
	 */
	public String getCarPolicyNo() {
		return carPolicyNo;
	}

	/**
	 * �������� carPolicyNo
	 * @param carPolicyNo the carPolicyNo to set
	 */
	public void setCarPolicyNo(String carPolicyNo) {
		this.carPolicyNo = carPolicyNo;
	}
    
}
