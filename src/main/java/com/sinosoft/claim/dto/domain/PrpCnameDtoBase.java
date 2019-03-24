package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpcname��Ա�嵥������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCnameDtoBase implements Serializable{
    /** ���Ա������� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Թ�Ա���� */
    private String employeeCode = "";
    /** ���Թ�Ա���� */
    private String employeeName = "";
    /** �����Ա���� */
    private String sex = "";
    /** �������� */
    private int age = 0;
    /** ��������״�� */
    private String health = "";
    /** �����ձ���� */
    private String kindCode = "";
    /** �����ձ����� */
    private String kindName = "";
    /** �������η������ */
    private String itemCode = "";
    /** �������η������� */
    private String itemDetailName = "";
    /** ���Թ�Ա���ִ��� */
    private String jobCode = "";
    /** ���Թ�Ա�������� */
    private String jobName = "";
    /** �������֤���� */
    private String identifyNumber = "";
    /** ���Թ�����λ */
    private String jobUnit = "";
    /** ���Թ��ʱұ� */
    private String currency = "";
    /** �����¹��� */
    private double monthWage = 0d;
    /** �����޶�ұ� */
    private String currency1 = "";
    /** �����޶� */
    private double sumLimit = 0d;
    /** ���������� */
    private DateTime startDate = new DateTime();
    /** ������Сʱ */
    private int startHour = 0;
    /** �����ձ����� */
    private DateTime endDate = new DateTime();
    /** �����ձ�Сʱ */
    private int endHour = 0;
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCnameDtoBase����
     */
    public PrpCnameDtoBase(){
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
     * �������Թ�Ա����
     * @param employeeCode �����õ����Թ�Ա�����ֵ
     */
    public void setEmployeeCode(String employeeCode){
        this.employeeCode = StringUtils.rightTrim(employeeCode);
    }

    /**
     * ��ȡ���Թ�Ա����
     * @return ���Թ�Ա�����ֵ
     */
    public String getEmployeeCode(){
        return employeeCode;
    }

    /**
     * �������Թ�Ա����
     * @param employeeName �����õ����Թ�Ա������ֵ
     */
    public void setEmployeeName(String employeeName){
        this.employeeName = StringUtils.rightTrim(employeeName);
    }

    /**
     * ��ȡ���Թ�Ա����
     * @return ���Թ�Ա������ֵ
     */
    public String getEmployeeName(){
        return employeeName;
    }

    /**
     * ���������Ա����
     * @param sex �����õ������Ա�����ֵ
     */
    public void setSex(String sex){
        this.sex = StringUtils.rightTrim(sex);
    }

    /**
     * ��ȡ�����Ա����
     * @return �����Ա�����ֵ
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
     * ������������״��
     * @param health �����õ���������״����ֵ
     */
    public void setHealth(String health){
        this.health = StringUtils.rightTrim(health);
    }

    /**
     * ��ȡ��������״��
     * @return ��������״����ֵ
     */
    public String getHealth(){
        return health;
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
     * �����������η������
     * @param itemCode �����õ��������η�������ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ�������η������
     * @return �������η�������ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * �����������η�������
     * @param itemDetailName �����õ��������η������Ƶ�ֵ
     */
    public void setItemDetailName(String itemDetailName){
        this.itemDetailName = StringUtils.rightTrim(itemDetailName);
    }

    /**
     * ��ȡ�������η�������
     * @return �������η������Ƶ�ֵ
     */
    public String getItemDetailName(){
        return itemDetailName;
    }

    /**
     * �������Թ�Ա���ִ���
     * @param jobCode �����õ����Թ�Ա���ִ����ֵ
     */
    public void setJobCode(String jobCode){
        this.jobCode = StringUtils.rightTrim(jobCode);
    }

    /**
     * ��ȡ���Թ�Ա���ִ���
     * @return ���Թ�Ա���ִ����ֵ
     */
    public String getJobCode(){
        return jobCode;
    }

    /**
     * �������Թ�Ա��������
     * @param jobName �����õ����Թ�Ա�������Ƶ�ֵ
     */
    public void setJobName(String jobName){
        this.jobName = StringUtils.rightTrim(jobName);
    }

    /**
     * ��ȡ���Թ�Ա��������
     * @return ���Թ�Ա�������Ƶ�ֵ
     */
    public String getJobName(){
        return jobName;
    }

    /**
     * �����������֤����
     * @param identifyNumber �����õ��������֤�����ֵ
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * ��ȡ�������֤����
     * @return �������֤�����ֵ
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * �������Թ�����λ
     * @param jobUnit �����õ����Թ�����λ��ֵ
     */
    public void setJobUnit(String jobUnit){
        this.jobUnit = StringUtils.rightTrim(jobUnit);
    }

    /**
     * ��ȡ���Թ�����λ
     * @return ���Թ�����λ��ֵ
     */
    public String getJobUnit(){
        return jobUnit;
    }

    /**
     * �������Թ��ʱұ�
     * @param currency �����õ����Թ��ʱұ��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Թ��ʱұ�
     * @return ���Թ��ʱұ��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ���������¹���
     * @param monthWage �����õ������¹��ʵ�ֵ
     */
    public void setMonthWage(double monthWage){
        this.monthWage = monthWage;
    }

    /**
     * ��ȡ�����¹���
     * @return �����¹��ʵ�ֵ
     */
    public double getMonthWage(){
        return monthWage;
    }

    /**
     * ���������޶�ұ�
     * @param currency1 �����õ������޶�ұ��ֵ
     */
    public void setCurrency1(String currency1){
        this.currency1 = StringUtils.rightTrim(currency1);
    }

    /**
     * ��ȡ�����޶�ұ�
     * @return �����޶�ұ��ֵ
     */
    public String getCurrency1(){
        return currency1;
    }

    /**
     * ���������޶�
     * @param sumLimit �����õ������޶��ֵ
     */
    public void setSumLimit(double sumLimit){
        this.sumLimit = sumLimit;
    }

    /**
     * ��ȡ�����޶�
     * @return �����޶��ֵ
     */
    public double getSumLimit(){
        return sumLimit;
    }

    /**
     * ��������������
     * @param startDate �����õ����������ڵ�ֵ
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * ��ȡ����������
     * @return ���������ڵ�ֵ
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * ����������Сʱ
     * @param startHour �����õ�������Сʱ��ֵ
     */
    public void setStartHour(int startHour){
        this.startHour = startHour;
    }

    /**
     * ��ȡ������Сʱ
     * @return ������Сʱ��ֵ
     */
    public int getStartHour(){
        return startHour;
    }

    /**
     * ���������ձ�����
     * @param endDate �����õ������ձ����ڵ�ֵ
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����ڵ�ֵ
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * ���������ձ�Сʱ
     * @param endHour �����õ������ձ�Сʱ��ֵ
     */
    public void setEndHour(int endHour){
        this.endHour = endHour;
    }

    /**
     * ��ȡ�����ձ�Сʱ
     * @return �����ձ�Сʱ��ֵ
     */
    public int getEndHour(){
        return endHour;
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
