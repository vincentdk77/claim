package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLpeds_Person��Ա������ϸ��Ϣ������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpeds_PersonDtoBase implements Serializable{
    /** ���Ա����� */
    private String registNo = "";
    /** �������� */
    private String riskCode = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Ա������������� */
    private int itemKindNo = 0;
    /** �����ձ���� */
    private String kindCode = "";
    /** ������� */
    private int serialNo = 0;
    /** �������ڵ������� */
    private String areaCode = "";
    /** ���Թ̶������־ */
    private String fixedIncomeFlag = "";
    /** ������ҵ���� */
    private String jobCode = "";
    /** ������ҵ���� */
    private String jobName = "";
    /** �����⸶��Ա���� */
    private String payPersonType = "";
    /** ���Ը��ַ��ô��� */
    private String feeTypeCode = "";
    /** ���Է������� */
    private String feeTypeName = "";
    /** ������Ա��� */
    private int personNo = 0;
    /** ������Ա���� */
    private String personName = "";
    /** �����Ա� */
    private String personSex = "";
    /** �������� */
    private int personAge = 0;
    /** ���Աұ� */
    private String currency = "";
    /** ���������� */
    private double sumLoss = 0d;
    /** �����޳���� */
    private double sumReject = 0d;
    /** �����޳�ԭ�� */
    private String rejectReason = "";
    /** �����⳥���� */
    private double lossRate = 0d;
    /** ���Ժ˶����� */
    private double sumDefLoss = 0d;
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpeds_PersonDtoBase����
     */
    public PrpLpeds_PersonDtoBase(){
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
     * ������������
     * @param riskCode �����õ��������ֵ�ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ��������
     * @return �������ֵ�ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * �������Ա�����
     * @param policyNo �����õ����Ա����ŵ�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
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
     * �����������ڵ�������
     * @param areaCode �����õ��������ڵ��������ֵ
     */
    public void setAreaCode(String areaCode){
        this.areaCode = StringUtils.rightTrim(areaCode);
    }

    /**
     * ��ȡ�������ڵ�������
     * @return �������ڵ��������ֵ
     */
    public String getAreaCode(){
        return areaCode;
    }

    /**
     * �������Թ̶������־
     * @param fixedIncomeFlag �����õ����Թ̶������־��ֵ
     */
    public void setFixedIncomeFlag(String fixedIncomeFlag){
        this.fixedIncomeFlag = StringUtils.rightTrim(fixedIncomeFlag);
    }

    /**
     * ��ȡ���Թ̶������־
     * @return ���Թ̶������־��ֵ
     */
    public String getFixedIncomeFlag(){
        return fixedIncomeFlag;
    }

    /**
     * ����������ҵ����
     * @param jobCode �����õ�������ҵ�����ֵ
     */
    public void setJobCode(String jobCode){
        this.jobCode = StringUtils.rightTrim(jobCode);
    }

    /**
     * ��ȡ������ҵ����
     * @return ������ҵ�����ֵ
     */
    public String getJobCode(){
        return jobCode;
    }

    /**
     * ����������ҵ����
     * @param jobName �����õ�������ҵ���Ƶ�ֵ
     */
    public void setJobName(String jobName){
        this.jobName = StringUtils.rightTrim(jobName);
    }

    /**
     * ��ȡ������ҵ����
     * @return ������ҵ���Ƶ�ֵ
     */
    public String getJobName(){
        return jobName;
    }

    /**
     * ���������⸶��Ա����
     * @param payPersonType �����õ������⸶��Ա���͵�ֵ
     */
    public void setPayPersonType(String payPersonType){
        this.payPersonType = StringUtils.rightTrim(payPersonType);
    }

    /**
     * ��ȡ�����⸶��Ա����
     * @return �����⸶��Ա���͵�ֵ
     */
    public String getPayPersonType(){
        return payPersonType;
    }

    /**
     * �������Ը��ַ��ô���
     * @param feeTypeCode �����õ����Ը��ַ��ô����ֵ
     */
    public void setFeeTypeCode(String feeTypeCode){
        this.feeTypeCode = StringUtils.rightTrim(feeTypeCode);
    }

    /**
     * ��ȡ���Ը��ַ��ô���
     * @return ���Ը��ַ��ô����ֵ
     */
    public String getFeeTypeCode(){
        return feeTypeCode;
    }

    /**
     * �������Է�������
     * @param feeTypeName �����õ����Է������Ƶ�ֵ
     */
    public void setFeeTypeName(String feeTypeName){
        this.feeTypeName = StringUtils.rightTrim(feeTypeName);
    }

    /**
     * ��ȡ���Է�������
     * @return ���Է������Ƶ�ֵ
     */
    public String getFeeTypeName(){
        return feeTypeName;
    }

    /**
     * ����������Ա���
     * @param personNo �����õ�������Ա��ŵ�ֵ
     */
    public void setPersonNo(int personNo){
        this.personNo = personNo;
    }

    /**
     * ��ȡ������Ա���
     * @return ������Ա��ŵ�ֵ
     */
    public int getPersonNo(){
        return personNo;
    }

    /**
     * ����������Ա����
     * @param personName �����õ�������Ա������ֵ
     */
    public void setPersonName(String personName){
        this.personName = StringUtils.rightTrim(personName);
    }

    /**
     * ��ȡ������Ա����
     * @return ������Ա������ֵ
     */
    public String getPersonName(){
        return personName;
    }

    /**
     * ���������Ա�
     * @param personSex �����õ������Ա��ֵ
     */
    public void setPersonSex(String personSex){
        this.personSex = StringUtils.rightTrim(personSex);
    }

    /**
     * ��ȡ�����Ա�
     * @return �����Ա��ֵ
     */
    public String getPersonSex(){
        return personSex;
    }

    /**
     * ������������
     * @param personAge �����õ����������ֵ
     */
    public void setPersonAge(int personAge){
        this.personAge = personAge;
    }

    /**
     * ��ȡ��������
     * @return ���������ֵ
     */
    public int getPersonAge(){
        return personAge;
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
     * ��������������
     * @param sumLoss �����õ������������ֵ
     */
    public void setSumLoss(double sumLoss){
        this.sumLoss = sumLoss;
    }

    /**
     * ��ȡ����������
     * @return �����������ֵ
     */
    public double getSumLoss(){
        return sumLoss;
    }

    /**
     * ���������޳����
     * @param sumReject �����õ������޳�����ֵ
     */
    public void setSumReject(double sumReject){
        this.sumReject = sumReject;
    }

    /**
     * ��ȡ�����޳����
     * @return �����޳�����ֵ
     */
    public double getSumReject(){
        return sumReject;
    }

    /**
     * ���������޳�ԭ��
     * @param rejectReason �����õ������޳�ԭ���ֵ
     */
    public void setRejectReason(String rejectReason){
        this.rejectReason = StringUtils.rightTrim(rejectReason);
    }

    /**
     * ��ȡ�����޳�ԭ��
     * @return �����޳�ԭ���ֵ
     */
    public String getRejectReason(){
        return rejectReason;
    }

    /**
     * ���������⳥����
     * @param lossRate �����õ������⳥������ֵ
     */
    public void setLossRate(double lossRate){
        this.lossRate = lossRate;
    }

    /**
     * ��ȡ�����⳥����
     * @return �����⳥������ֵ
     */
    public double getLossRate(){
        return lossRate;
    }

    /**
     * �������Ժ˶�����
     * @param sumDefLoss �����õ����Ժ˶������ֵ
     */
    public void setSumDefLoss(double sumDefLoss){
        this.sumDefLoss = sumDefLoss;
    }

    /**
     * ��ȡ���Ժ˶�����
     * @return ���Ժ˶������ֵ
     */
    public double getSumDefLoss(){
        return sumDefLoss;
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
