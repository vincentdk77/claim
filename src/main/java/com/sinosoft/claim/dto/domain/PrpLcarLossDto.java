package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLcarLoss������������ݴ��������<br>
 * ������ 2004-07-19 14:23:54.158<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcarLossDto extends PrpLcarLossDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcarLossDto����
     */
    public PrpLcarLossDto(){
    }
    /** ���Գ��Ƶ�ɫ���� */
    private String licenseColorCode = "";
    /** ���Ժ���������� */
    private String carKindCode = "";
    /** ���Ժ����������� */
    private String carKindName = ""; 
    /** ���ʹ��� */
    private String modelCode = "";
    /** ���Գ����ͺ� */
    private String brandName = "";
    /** ���Է������� */
    private String engineNo = "";
    /** ���Գ��ܺ� */
    private String frameNo = "";
    /** �����Ƿ�Ϊ���������� */
    private String insureCarFlag = "";
    /** �����Ƿ�Ϊ���������� */
    private String insureCarFlagName = "";
    /** ���Գб���˾���� */
    private String insureComCode = "";
    /** ���Գб���˾���� */
    private String insureComName = "";
    /** ����VIN�� */
    private String vINNo = "";
    /**�������� **/
    private String repairFactoryCode = "";
    /**�������� **/
    private String repairFactoryName = "";
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
     * ���������Ƿ�Ϊ����������
     * @param insureCarFlag �����õ������Ƿ�Ϊ������������ֵ
     */
    public void setInsureCarFlag(String insureCarFlag){
        this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
    }

    /**
     * ��ȡ�����Ƿ�Ϊ����������
     * @return �����Ƿ�Ϊ������������ֵ
     */
    public String getInsureCarFlag(){
        return insureCarFlag;
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
     * �������Ժ����������
     * @param carKindCode �����õ����Ժ�����������ֵ
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * ��ȡ���Ժ����������
     * @return ���Ժ�����������ֵ
     */
    public String getCarKindCode(){
        return carKindCode;
    }
    
    /**
     * �������Գ��Ƶ�ɫ����
     * @param licenseColorCode �����õ����Գ��Ƶ�ɫ�����ֵ
     */
    public void setLicenseColorCode(String licenseColorCode){
        this.licenseColorCode = StringUtils.rightTrim(licenseColorCode);
    }
    
    /**
     * ���������Ƿ�Ϊ����������
     * @param insureCarFlagName �����Ƿ�Ϊ����������
     */
    public void setInsureCarFlagName(String insureCarFlagName) {
      this.insureCarFlagName = insureCarFlagName;
    }

    /**
     * �������Ժ�����������
     * @param carKindName ���Ժ�����������
     */  
    public void setCarKindName(String carKindName) {
      this.carKindName = carKindName;
    }

   /**
     * ��ȡ���Գ��Ƶ�ɫ����
     * @return ���Գ��Ƶ�ɫ�����ֵ
     */
    public String getLicenseColorCode(){
        return licenseColorCode;
    }
  
   /**
     * ��ȡ�����Ƿ�Ϊ����������
     * @return �����Ƿ�Ϊ����������
     */
    public String getInsureCarFlagName() {
      return insureCarFlagName;
    }
  
   /**
     * ��ȡ���Ժ�����������
     * @return ���Ժ�����������
     */
    public String getCarKindName() {
      return carKindName;
    }

/**
 * ��ȡ���� repairFactoryCode
 * @return the repairFactoryCode
 */
public String getRepairFactoryCode() {
	return repairFactoryCode;
}

/**
 * �������� repairFactoryCode
 * @param repairFactoryCode the repairFactoryCode to set
 */
public void setRepairFactoryCode(String repairFactoryCode) {
	this.repairFactoryCode = repairFactoryCode;
}

/**
 * ��ȡ���� repairFactoryName
 * @return the repairFactoryName
 */
public String getRepairFactoryName() {
	return repairFactoryName;
}

/**
 * �������� repairFactoryName
 * @param repairFactoryName the repairFactoryName to set
 */
public void setRepairFactoryName(String repairFactoryName) {
	this.repairFactoryName = repairFactoryName;
}

    
}
