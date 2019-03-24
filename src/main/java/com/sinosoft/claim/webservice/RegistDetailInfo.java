package com.sinosoft.claim.webservice;

import java.io.Serializable;
import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * �����������롢����ʱ�䡢�����ˡ������˵绰����ʻԱ����ʻԱ�绰�����ƺ��롢�¹����͡�����ԭ�򡢳������򡢳��յص㡢�����š��¹����Ρ���ʧ���ͣ��գ����������������վ�����PrpLregistText�������մ�������Ϣ��
 * @author fei
 *
 */
public class RegistDetailInfo implements Serializable {

	/**�¹�������0-ȫ��1-����2-ͬ��3-����4-����9-����
	 * ��ʧ���ͣ�1-����      ��2-����     3-����  �� 4-������    5-������ 
	 */
	private static final long serialVersionUID = 1L;
	/** ���Ա������� */
    private String registNo = "";
    /** ���Գ���ʱ�� */
    private String damageTime = "";
    /** ���Լ�ʻԱ���� */
    private String driverName = "";//prpLdriver����
    /** ���Լ�ʻԱ��ϵ�绰 */
    private String driverPhone = "";
	/** ���Ա����� */
    private String reportorName = "";
    /** ���Ա�������ϵ�绰 */
    private String phoneNumber = "";
    /** �����¹����ʹ���(����) */
    private String damageTypeCode = "";
    /** �����¹�����˵�� */
    private String damageTypeName = "";
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** ���Գ���ԭ����� */
    private String damageCode = "";
    /** ���Գ���ԭ��˵�� */
    private String damageName = "";
    /** ���Գ���������� */
    private String damageAreaCode = "";
    /** ���Գ����������� */
    private String damageAreaName = "";
    /** ���Գ��յص� */
    private String damageAddress = "";
    /** �����¹ʴ����� */
    private String handleUnit = "";
    /** �����¹��������� */
    private String indemnityDuty = "";
    /** ������������ */
    private String woundRemark = "";//PrpLpersonTrace��
    /** ������ʧ���� */
    private String lossType = "";
    /** ���Գ��־���*/
    private String damageAbstract = "";//���վ�����PrpLregistText��
    /** ���Գ��մ��� */
    private int perilCount = 0;

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
     * ��ȡ���Լ�ʻԱ��ϵ�绰
     * @return ���Լ�ʻԱ��ϵ�绰��ֵ
     */
    public String getDriverPhone() {
		return driverPhone;
	}
    
    /**
     * �������Լ�ʻԱ��ϵ�绰
     * @param driverPhone �����õ����Լ�ʻԱ��ϵ�绰��ֵ
     */
	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
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

	/**
     * ����������������
     * @param woundRemark �����õ���������������ֵ
     */
    public void setWoundRemark(String woundRemark){
        this.woundRemark = StringUtils.rightTrim(woundRemark);
    }

    /**
     * ��ȡ������������
     * @return ��������������ֵ
     */
    public String getWoundRemark(){
        return woundRemark;
    }

    /**
     * ��ȡ������ʧ���� 
     * @return ������ʧ���� ��ֵ
     */
	public String getLossType() {
		return lossType;
	}

	/**
     * ����������ʧ���� 
     * @param lossType �����õ�������ʧ���� ��ֵ
     */
	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	/**
     * ��ȡ���Գ��־��� 
     * @return ���Գ��־��� ��ֵ
     */
	public String getDamageAbstract() {
		return damageAbstract;
	}
	
	/**
     * �������Գ��־��� 
     * @param damageAbstract �����õ����Գ��־��� ��ֵ
     */
	public void setDamageAbstract(String damageAbstract) {
		this.damageAbstract = damageAbstract;
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
    
    

}
