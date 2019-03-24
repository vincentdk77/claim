package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpccardriver������ʻԱ��ϵ������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCcarDriverDtoBase implements Serializable{
    /** ���Ա������� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա����� */
    private int itemNo = 0;
    /** ����˳��� */
    private int serialNo = 0;
    /** ���Լ�ʻ֤���� */
    private String drivingLicenseNo = "";
    /** �����Ƿ�̶���ʻԱ��־ */
    private String changelessFlag = "";
    /** ���Լ�ʻԱ���� */
    private String driverName = "";
    /** �������֤���� */
    private String identifynumber = "";
    /** �����Ա� */
    private String sex = "";
    /** �������� */
    private int age = 0;
    /** ���Ի���״�� */
    private String marriage = "";
    /** ���Ե�λ���ַ */
    private String driverAddress = "";
    /** ���Թ�����λ���ʴ��� */
    private String possessnature = "";
    /** ���Դ�ҵ������ */
    private String businessSource = "";
    /** �����Ƿ���Υ�¿۷� */
    private int peccancy = 0;
    /** ���Գ�����֤���� */
    private DateTime acceptLicenseDate = new DateTime();
    /** �������ʻ֤���� */
    private int receivelicenseyear = 0;
    /** ���Լ��� */
    private int drivingYears = 0;
    /** ���Խ��������´��� */
    private int causetroubletimes = 0;
    /** ���԰�֤���� */
    private String awardLicenseOrgan = "";
    /** ����׼�ݳ��� */
    private String drivingCarType = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCcarDriverDtoBase����
     */
    public PrpCcarDriverDtoBase(){
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
     * ��������˳���
     * @param serialNo �����õ�����˳��ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����˳���
     * @return ����˳��ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Լ�ʻ֤����
     * @param drivingLicenseNo �����õ����Լ�ʻ֤�����ֵ
     */
    public void setDrivingLicenseNo(String drivingLicenseNo){
        this.drivingLicenseNo = StringUtils.rightTrim(drivingLicenseNo);
    }

    /**
     * ��ȡ���Լ�ʻ֤����
     * @return ���Լ�ʻ֤�����ֵ
     */
    public String getDrivingLicenseNo(){
        return drivingLicenseNo;
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
     * �����������֤����
     * @param identifynumber �����õ��������֤�����ֵ
     */
    public void setIdentifynumber(String identifynumber){
        this.identifynumber = StringUtils.rightTrim(identifynumber);
    }

    /**
     * ��ȡ�������֤����
     * @return �������֤�����ֵ
     */
    public String getIdentifynumber(){
        return identifynumber;
    }

    /**
     * ���������Ա�
     * @param sex �����õ������Ա��ֵ
     */
    public void setSex(String sex){
        this.sex = StringUtils.rightTrim(sex);
    }

    /**
     * ��ȡ�����Ա�
     * @return �����Ա��ֵ
     */
    public String getSex(){
        return sex;
    }

    /**
     * ������������
     * @param age �����õ����������ֵ
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * ��ȡ��������
     * @return ���������ֵ
     */
    public int getAge(){
        return age;
    }

    /**
     * �������Ի���״��
     * @param marriage �����õ����Ի���״����ֵ
     */
    public void setMarriage(String marriage){
        this.marriage = StringUtils.rightTrim(marriage);
    }

    /**
     * ��ȡ���Ի���״��
     * @return ���Ի���״����ֵ
     */
    public String getMarriage(){
        return marriage;
    }

    /**
     * �������Ե�λ���ַ
     * @param driverAddress �����õ����Ե�λ���ַ��ֵ
     */
    public void setDriverAddress(String driverAddress){
        this.driverAddress = StringUtils.rightTrim(driverAddress);
    }

    /**
     * ��ȡ���Ե�λ���ַ
     * @return ���Ե�λ���ַ��ֵ
     */
    public String getDriverAddress(){
        return driverAddress;
    }

    /**
     * �������Թ�����λ���ʴ���
     * @param possessnature �����õ����Թ�����λ���ʴ����ֵ
     */
    public void setPossessnature(String possessnature){
        this.possessnature = StringUtils.rightTrim(possessnature);
    }

    /**
     * ��ȡ���Թ�����λ���ʴ���
     * @return ���Թ�����λ���ʴ����ֵ
     */
    public String getPossessnature(){
        return possessnature;
    }

    /**
     * �������Դ�ҵ������
     * @param businessSource �����õ����Դ�ҵ�������ֵ
     */
    public void setBusinessSource(String businessSource){
        this.businessSource = StringUtils.rightTrim(businessSource);
    }

    /**
     * ��ȡ���Դ�ҵ������
     * @return ���Դ�ҵ�������ֵ
     */
    public String getBusinessSource(){
        return businessSource;
    }

    /**
     * ���������Ƿ���Υ�¿۷�
     * @param peccancy �����õ������Ƿ���Υ�¿۷ֵ�ֵ
     */
    public void setPeccancy(int peccancy){
        this.peccancy = peccancy;
    }

    /**
     * ��ȡ�����Ƿ���Υ�¿۷�
     * @return �����Ƿ���Υ�¿۷ֵ�ֵ
     */
    public int getPeccancy(){
        return peccancy;
    }

    /**
     * �������Գ�����֤����
     * @param acceptLicenseDate �����õ����Գ�����֤���ڵ�ֵ
     */
    public void setAcceptLicenseDate(DateTime acceptLicenseDate){
        this.acceptLicenseDate = acceptLicenseDate;
    }

    /**
     * ��ȡ���Գ�����֤����
     * @return ���Գ�����֤���ڵ�ֵ
     */
    public DateTime getAcceptLicenseDate(){
        return acceptLicenseDate;
    }

    /**
     * �����������ʻ֤����
     * @param receivelicenseyear �����õ��������ʻ֤������ֵ
     */
    public void setReceivelicenseyear(int receivelicenseyear){
        this.receivelicenseyear = receivelicenseyear;
    }

    /**
     * ��ȡ�������ʻ֤����
     * @return �������ʻ֤������ֵ
     */
    public int getReceivelicenseyear(){
        return receivelicenseyear;
    }

    /**
     * �������Լ���
     * @param drivingYears �����õ����Լ����ֵ
     */
    public void setDrivingYears(int drivingYears){
        this.drivingYears = drivingYears;
    }

    /**
     * ��ȡ���Լ���
     * @return ���Լ����ֵ
     */
    public int getDrivingYears(){
        return drivingYears;
    }

    /**
     * �������Խ��������´���
     * @param causetroubletimes �����õ����Խ��������´�����ֵ
     */
    public void setCausetroubletimes(int causetroubletimes){
        this.causetroubletimes = causetroubletimes;
    }

    /**
     * ��ȡ���Խ��������´���
     * @return ���Խ��������´�����ֵ
     */
    public int getCausetroubletimes(){
        return causetroubletimes;
    }

    /**
     * �������԰�֤����
     * @param awardLicenseOrgan �����õ����԰�֤���ص�ֵ
     */
    public void setAwardLicenseOrgan(String awardLicenseOrgan){
        this.awardLicenseOrgan = StringUtils.rightTrim(awardLicenseOrgan);
    }

    /**
     * ��ȡ���԰�֤����
     * @return ���԰�֤���ص�ֵ
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
