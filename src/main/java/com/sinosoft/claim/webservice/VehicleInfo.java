package com.sinosoft.claim.webservice;

import java.io.Serializable;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �洢������Ϣ
 * @author Administrator
 *
 */
public class VehicleInfo implements Serializable {

	/**
	 * 
	 ,��ʧ���
	 */
	private static final long serialVersionUID = -3292919583910696944L;

    /** ���Ա������� */
    private String registNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Գ��ƺ� */
    private String licenseNo = "";
    /** ���Գ��Ƶ�ɫ���� */
    private String licenseColorCode = "";
    /** ���Գ���������� */
    private String carKindCode = "";
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
    /** ���Գб���˾���� */
    private String insureComCode = "";
    /** ���Գб���˾���� */
    private String insureComName = "";
    /** ����VIN���� */
    private String vINNo = "";
    /** ������ʧ��� */
    private double lossFee = 0d;
    /** ���������־ */
    private String lossFlag = "";
    /** ���������߳���ʻԱ���� */
    private String prpLthirdPartyDriveName = "";
    /** ���������߳���ʻԱ�����*/
    private String prpLthirdPartyDriveLicensNo = "";
    /** ���Գ����������� */
    private String carPolicyNo = "";
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�VehicleInfo����
     */
    public VehicleInfo(){
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
     * ����������ʧ���
     * @param lossFee �����õ�������ʧ����ֵ
     */
    public void setLossFee(double lossFee){
        this.lossFee = lossFee;
    }

    /**
     * ��ȡ������ʧ���
     * @return ������ʧ����ֵ
     */
    public double getLossFee(){
        return lossFee;
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
     * ��ȡ����prpLthirdPartyDriveName���߳���ʻԱ����
     * @return ����prpLthirdPartyDriveName���߳���ʻԱ������ֵ
     */
    public String getPrpLthirdPartyDriveName() {
		return prpLthirdPartyDriveName;
	}

    /**
     * ��������prpLthirdPartyDriveName���߳���ʻԱ����
     * @param prpLthirdPartyDriveName �����õ��������߳���ʻԱ������ֵ
     */
	public void setPrpLthirdPartyDriveName(String prpLthirdPartyDriveName) {
		this.prpLthirdPartyDriveName = prpLthirdPartyDriveName;
	}

    /**
     * ��ȡ����prpLthirdPartyDriveLicensNo���߳���ʻԱ�����
     * @return ����prpLthirdPartyDriveLicensNo���߳���ʻԱ�������ֵ
     */
	public String getPrpLthirdPartyDriveLicensNo() {
		return prpLthirdPartyDriveLicensNo;
	}

	/**
     * ��������prpLthirdPartyDriveLicensNo���߳���ʻԱ�����
     * @param prpLthirdPartyDriveLicensNo �����õ��������߳���ʻԱ�������ֵ
     */
      
	public void setPrpLthirdPartyDriveLicensNo(
			String prpLthirdPartyDriveLicensNo) {
		this.prpLthirdPartyDriveLicensNo = prpLthirdPartyDriveLicensNo;
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
