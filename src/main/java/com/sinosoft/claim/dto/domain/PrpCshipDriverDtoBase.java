package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpcshipdriver�����մ�Ա��Ϣ������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCshipDriverDtoBase implements Serializable{
    /** ����Ͷ�������� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա����� */
    private int itemNo = 0;
    /** ������� */
    private int serialNo = 0;
    /** ���Լ�ʻԱ���� */
    private String driverName = "";
    /** ���Լ�ʻԱ�Ա� */
    private String driverSex = "";
    /** ���Լ�ʻԱ���� */
    private String driverTypeCode = "";
    /** ���Գ������� */
    private DateTime birthday = new DateTime();
    /** ���Լ�ʻԱ�ȼ� */
    private String driverGrade = "";
    /** ���Լ�ʻԱ���� */
    private String driverSeaRoute = "";
    /** ���Լ�ʻԱ��ʻ֤���� */
    private String drivingLicenseNo = "";
    /** ������֤ʱ�� */
    private DateTime receiveLicenseDate = new DateTime();
    /** ����׼�ݴ��� */
    private String drivingShipType = "";
    /** ���Լ�ʻ���� */
    private int drivingYear = 0;
    /** �����Ƿ�̶���ʻԱ��־ */
    private String changelessFlag = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCshipDriverDtoBase����
     */
    public PrpCshipDriverDtoBase(){
    }

    /**
     * ��������Ͷ��������
     * @param policyNo �����õ�����Ͷ���������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����Ͷ��������
     * @return ����Ͷ���������ֵ
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
    public void setItemNo(int itemNo){
        this.itemNo = itemNo;
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public int getItemNo(){
        return itemNo;
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
     * �������Լ�ʻԱ����
     * @param driverTypeCode �����õ����Լ�ʻԱ���͵�ֵ
     */
    public void setDriverTypeCode(String driverTypeCode){
        this.driverTypeCode = StringUtils.rightTrim(driverTypeCode);
    }

    /**
     * ��ȡ���Լ�ʻԱ����
     * @return ���Լ�ʻԱ���͵�ֵ
     */
    public String getDriverTypeCode(){
        return driverTypeCode;
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
     * �������Լ�ʻԱ�ȼ�
     * @param driverGrade �����õ����Լ�ʻԱ�ȼ���ֵ
     */
    public void setDriverGrade(String driverGrade){
        this.driverGrade = StringUtils.rightTrim(driverGrade);
    }

    /**
     * ��ȡ���Լ�ʻԱ�ȼ�
     * @return ���Լ�ʻԱ�ȼ���ֵ
     */
    public String getDriverGrade(){
        return driverGrade;
    }

    /**
     * �������Լ�ʻԱ����
     * @param driverSeaRoute �����õ����Լ�ʻԱ���ߵ�ֵ
     */
    public void setDriverSeaRoute(String driverSeaRoute){
        this.driverSeaRoute = StringUtils.rightTrim(driverSeaRoute);
    }

    /**
     * ��ȡ���Լ�ʻԱ����
     * @return ���Լ�ʻԱ���ߵ�ֵ
     */
    public String getDriverSeaRoute(){
        return driverSeaRoute;
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
     * ����������֤ʱ��
     * @param receiveLicenseDate �����õ�������֤ʱ���ֵ
     */
    public void setReceiveLicenseDate(DateTime receiveLicenseDate){
        this.receiveLicenseDate = receiveLicenseDate;
    }

    /**
     * ��ȡ������֤ʱ��
     * @return ������֤ʱ���ֵ
     */
    public DateTime getReceiveLicenseDate(){
        return receiveLicenseDate;
    }

    /**
     * ��������׼�ݴ���
     * @param drivingShipType �����õ�����׼�ݴ��͵�ֵ
     */
    public void setDrivingShipType(String drivingShipType){
        this.drivingShipType = StringUtils.rightTrim(drivingShipType);
    }

    /**
     * ��ȡ����׼�ݴ���
     * @return ����׼�ݴ��͵�ֵ
     */
    public String getDrivingShipType(){
        return drivingShipType;
    }

    /**
     * �������Լ�ʻ����
     * @param drivingYear �����õ����Լ�ʻ���޵�ֵ
     */
    public void setDrivingYear(int drivingYear){
        this.drivingYear = drivingYear;
    }

    /**
     * ��ȡ���Լ�ʻ����
     * @return ���Լ�ʻ���޵�ֵ
     */
    public int getDrivingYear(){
        return drivingYear;
    }

    /**
     * ���������Ƿ�̶���ʻԱ��־
     * @param changelessFlag �����õ������Ƿ�̶���ʻԱ��־��ֵ
     */
    public void setChangelessFlag(String changelessFlag){
        this.changelessFlag = StringUtils.rightTrim(changelessFlag);
    }

    /**
     * ��ȡ�����Ƿ�̶���ʻԱ��־
     * @return �����Ƿ�̶���ʻԱ��־��ֵ
     */
    public String getChangelessFlag(){
        return changelessFlag;
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
