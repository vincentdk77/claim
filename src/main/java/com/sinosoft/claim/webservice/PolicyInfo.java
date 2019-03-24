package com.sinosoft.claim.webservice;

import java.io.Serializable;
import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * ������Ϣ���ӦjavaBean
 * �б��������������롢�������ˡ�
 * ��ʻ֤���������ƺ��롢���ͺ��롢
 * ���ܺ��롢���������롢Ͷ�����ڡ�Ͷ�����ޡ�
 * ʹ�����ʡ���ʻ�����³����üۡ�Լ����ʻԱ
 * ����������Ͷ���ձ�
 *���ڸ�ʽ��Ϊyyyy-MM-dd
 * 
 */

public class PolicyInfo implements Serializable{
	/** ���Ա������� */
    private String policyNo = "";
    /** ���Գб�����*/
    private String comCode = "";
    /** ���Գб�����*/
    private String comName = "";
    /** ���Ա������˴��� */
    private String insuredCode = "";
    /** ���Ա����������� */
    private String insuredName = "";
    /** ���Գ��� */
    private String carOwner = "";
    /** ����ǩ������/Ͷ������ */
    private String operateDate = "";
    /** �����ձ����� */
    private String endDate = "";
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** ���Գ����ͺ� */
    private String brandName = "";
    /** ���Է������� */
    private String engineNo = "";
    /** ���Գ��ܺ� */
    private String frameNo = "";
    /** ������ʻ������� */
    private String runAreaCode = "";
    /** ������ʻ�������� */
    private String runAreaName = "";
    /** ����ʹ�����ʴ��� */
    private String useNatureCode = "";
    /** ����ʹ���������� */
    private String useNatureName = "";
    /** �����³����ü۸� */
    private double purchasePrice = 0D;
    /** ����Լ����ʻԱ������Զ��Ÿ���*/
    private String driverName = "";
    /** �����ձ���롢����Զ��Ÿ��� */
    private String kindCode = "";
    /** �����ձ����ơ�����Զ��Ÿ��� */
    private String kindName = "";
    /** ������������Զ��Ÿ��� */
    private double deductible = 0d;
    /** ���Գ��Ƶ�ɫ���� */                        
    private String licenseColorCode = "";      
    /** ���Գ���������� */                    
    private String carKindCode = "";           


    
	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PolicyInfo����
     */
    public PolicyInfo(){
    }

    /**
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = policyNo;
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ��������ǩ������/Ͷ������
     * @param operateDate �����õ�����ǩ������/Ͷ�����ڵ�ֵ
     */
    public void setOperateDate(String operateDate){
        this.operateDate = operateDate;
    }

    /**
     * ��ȡ����ǩ������/Ͷ������
     * @return ����ǩ������/Ͷ�����ڵ�ֵ
     */
    public String getOperateDate(){
        return operateDate;
    }
    
    /**
     * ���������ձ�����
     * @param endDate �����õ������ձ����ڵ�ֵ
     */
    public void setEndDate(String endDate){
        this.endDate = endDate;
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����ڵ�ֵ
     */
    public String getEndDate(){
        return endDate;
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
     * �������Գб�����
     * @param comName �����õ����Գб�������ֵ
     */
	public void setComName(String comName) {
		this.comName = comName;
	}

	/**
     * ��ȡ���Գб���������
     * @return  �б���������
     */
	public String getComName() {
		return comName;
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
     * ��ȡ���Ա�����������
     * @return ���Ա����������Ƶ�ֵ
     */
	public String getInsuredName() {
		return insuredName;
	}

	/**
     * �������Ա�����������
     * @param policyNo �����õ����Ա����������Ƶ�ֵ
     */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	
	/**
     * ��ȡ���Գ��ƺ���
     * @return ���Գ��ƺ���ֵ
     */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
     * �������Գ��ƺ���
     * @param policyNo �����õ����Գ��ƺ����ֵ
     */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
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
     * ��������ʹ����������
     * @param useNatureName �����õ�����ʹ���������Ƶ�ֵ
     */
    public void setUseNatureName(String useNatureName){
        this.useNatureName = StringUtils.rightTrim(useNatureName);
    }

    /**
     * ��ȡ����ʹ����������
     * @return ����ʹ���������Ƶ�ֵ
     */
    public String getUseNatureName(){
        return useNatureName;
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
     * �������Լ�ʻԱ����
     * @param driverName �����õ����Լ�ʻԱ������ֵ
     */
    public void setDriverName(String driverName){
        this.driverName = StringUtils.rightTrim(driverName);
    }

    /**
     * ��ȡ���Լ�ʻԱ����
     * @return ���Լ�ʻԱ������ֵ
     */
    public String getDriverName(){
        return driverName;
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
     * ���������ձ�����
     * @param kindName �����õ������ձ����Ƶ�ֵ
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����Ƶ�ֵ
     */
    public String getKindName(){
        return kindName;
    }
    
    /**
     * �������������
     * @param deductible �����õ�����������ֵ
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * ��ȡ���������
     * @return ����������ֵ
     */
    public double getDeductible(){
        return deductible;
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
}
