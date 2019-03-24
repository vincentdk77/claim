package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpddriver��������˾�����������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDdriverDtoBase implements Serializable{
    /** ���Լ�ʻԱ��ʻ֤���� */
    private String drivingLicenseNo = "";
    /** ���Լ�ʻԱ���� */
    private String driverName = "";
    /** ���Լ�ʻԱ�Ա� */
    private String driverSex = "";
    /** ���Գ������� */
    private DateTime birthday = new DateTime();
    /** ���Ե�λ��סַ */
    private String driverAddress = "";
    /** �������֤�� */
    private String identifyNumber = "";
    /** ���Գ�����֤���� */
    private DateTime receiveLicenseDate = new DateTime();
    /** ������֤���� */
    private String awardLicenseOrgan = "";
    /** ����׼�ݳ��� */
    private String drivingCarType = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDdriverDtoBase����
     */
    public PrpDdriverDtoBase(){
    }

    /**
     * �������Լ�ʻԱ��ʻ֤����
     * @param drivingLicenseNo �����õ����Լ�ʻԱ��ʻ֤�����ֵ
     */
    public void setDrivingLicenseNo(String drivingLicenseNo){
        this.drivingLicenseNo = StringUtils.rightTrim(drivingLicenseNo);
    }

    /**
     * ��ȡ���Լ�ʻԱ��ʻ֤����
     * @return ���Լ�ʻԱ��ʻ֤�����ֵ
     */
    public String getDrivingLicenseNo(){
        return drivingLicenseNo;
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
     * �������Լ�ʻԱ�Ա�
     * @param driverSex �����õ����Լ�ʻԱ�Ա��ֵ
     */
    public void setDriverSex(String driverSex){
        this.driverSex = StringUtils.rightTrim(driverSex);
    }

    /**
     * ��ȡ���Լ�ʻԱ�Ա�
     * @return ���Լ�ʻԱ�Ա��ֵ
     */
    public String getDriverSex(){
        return driverSex;
    }

    /**
     * �������Գ�������
     * @param birthday �����õ����Գ������ڵ�ֵ
     */
    public void setBirthday(DateTime birthday){
        this.birthday = birthday;
    }

    /**
     * ��ȡ���Գ�������
     * @return ���Գ������ڵ�ֵ
     */
    public DateTime getBirthday(){
        return birthday;
    }

    /**
     * �������Ե�λ��סַ
     * @param driverAddress �����õ����Ե�λ��סַ��ֵ
     */
    public void setDriverAddress(String driverAddress){
        this.driverAddress = StringUtils.rightTrim(driverAddress);
    }

    /**
     * ��ȡ���Ե�λ��סַ
     * @return ���Ե�λ��סַ��ֵ
     */
    public String getDriverAddress(){
        return driverAddress;
    }

    /**
     * �����������֤��
     * @param identifyNumber �����õ��������֤�ŵ�ֵ
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * ��ȡ�������֤��
     * @return �������֤�ŵ�ֵ
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * �������Գ�����֤����
     * @param receiveLicenseDate �����õ����Գ�����֤���ڵ�ֵ
     */
    public void setReceiveLicenseDate(DateTime receiveLicenseDate){
        this.receiveLicenseDate = receiveLicenseDate;
    }

    /**
     * ��ȡ���Գ�����֤����
     * @return ���Գ�����֤���ڵ�ֵ
     */
    public DateTime getReceiveLicenseDate(){
        return receiveLicenseDate;
    }

    /**
     * ����������֤����
     * @param awardLicenseOrgan �����õ�������֤���ص�ֵ
     */
    public void setAwardLicenseOrgan(String awardLicenseOrgan){
        this.awardLicenseOrgan = StringUtils.rightTrim(awardLicenseOrgan);
    }

    /**
     * ��ȡ������֤����
     * @return ������֤���ص�ֵ
     */
    public String getAwardLicenseOrgan(){
        return awardLicenseOrgan;
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
