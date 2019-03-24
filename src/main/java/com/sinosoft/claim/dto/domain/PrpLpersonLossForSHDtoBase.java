package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLpersonLoss����Ա�⸶��Ϣ������ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLpersonLossForSHDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ������������� */
    private String compensateNo = "";
    /** �������� */
    private String riskCode = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** �����⸶������ */
    private int serialNo = 0;
    /** ������Ա��� */
    private int personNo = 0;
    /** ������Ա���� */
    private String personName = "";
    /** �������֤���� */
    private String identifyNumber = "";
    /** �����Ա� */
    private String sex = "";
    /** �������� */
    private int age = 0;
    /** ���Ա���ձ���� */
    private int itemKindNo = 0;
    /** ���Լ�ͥ��� */
    private int familyNo = 0;
    /** ���Լ�ͥ���� */
    private String familyName = "";
    /** ���Գб��ձ���� */
    private String kindCode = "";
    /** �������η������ */
    private String liabCode = "";
    /** �������η������� */
    private String liabName = "";
    /** ���Թ�Ա���ִ��� */
    private String jobCode = "";
    /** ���Թ�Ա�������� */
    private String jobName = "";
    /** ����������ϸ������� */
    private String liabDetailCode = "";
    /** ����������ϸ�������� */
    private String liabDetailName = "";
    /** ���������ĵ�ַ */
    private String itemAddress = "";
    /** �������� */
    private int lossQuantity = 0;
    /** ����������λ */
    private String unit = "";
    /** ���Ե�λ�⳥�޶� */
    private double unitAmount = 0D;
    /** ���Աұ� */
    private String currency = "";
    /** ���Ա��ս�� */
    private double amount = 0D;
    /** ���Ա�ļ�ֵ�ұ� */
    private String currency1 = "";
    /** ���Ա�ļ�ֵ */
    private double itemValue = 0D;
    /** ����������ұ� */
    private String currency2 = "";
    /** ���������� */
    private double sumLoss = 0D;
    /** �����޳����/��ֵ/���� */
    private double sumRest = 0D;
    /** �������α��� */
    private double indemnityDutyRate = 0D;
    /** �����⸶���� */
    private double claimRate = 0D;
    /** ���������ұ� */
    private String currency3 = "";
    /** ���������� */
    private double deductibleRate = 0D;
    /** ��������� */
    private double deductible = 0D;
    /** ����ʵ��ұ� */
    private String currency4 = "";
    /** ����ʵ���� */
    private double sumRealPay = 0D;
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** �����¹����������� */
    private double dutyDeductibleRate = 0D;
    /** ����INJURYGRADE */
    private String injuryGrade = "";
    /** ����INJURYSCOPEDESC */
    private String injuryScopeDesc = "";
    /** ������Ժ���� */
    private String inHospDate = "";
    /** ���Գ�Ժ���� */
    private String outHospDate = "";
    /** ���Ծ���ҽԺ */
    private String hospital = "";
    /** ����סԺ���� */
    private int hospitalDays = 0;
    /** �����޳�ԭ�� */
    private String rejectReason = "";
    /** ���Լ�ʻԱ������ */
    private double driverDeductibleRate = 0D;
    /** ��������⸶��� */
    private double maxpaid = 0D;
    /** ������ʷ�⸶��� */
    private double hispaid = 0D;
    /** ���Ա�ע */
    private String remark = "";
    /** ����Э�̱��� */
    private double arrangeRate = 0D;
    /** ���Ժ˶��⳥ */
    private double sumDefPay = 0D;
    /** ���Է��÷�Χ */
    private String feeCategory = "";
    
    private double sumAllRealPay = 0d;
    private String hospitalCode = "";
    private String diseaseCode = "";
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpersonLossDtoBase����
     */
    public PrpLpersonLossForSHDtoBase(){
    }

    /**
     * �����������������
     * @param compensateNo �����õ�������������ŵ�ֵ
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * ��ȡ�������������
     * @return ������������ŵ�ֵ
     */
    public String getCompensateNo(){
        return compensateNo;
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
     * ���������⸶������
     * @param serialNo �����õ������⸶�����ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�����⸶������
     * @return �����⸶�����ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
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
     * @param personName �����õ�������Ա���Ƶ�ֵ
     */
    public void setPersonName(String personName){
        this.personName = StringUtils.rightTrim(personName);
    }

    /**
     * ��ȡ������Ա����
     * @return ������Ա���Ƶ�ֵ
     */
    public String getPersonName(){
        return personName;
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
     * �������Ա���ձ����
     * @param itemKindNo �����õ����Ա���ձ���ŵ�ֵ
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * ��ȡ���Ա���ձ����
     * @return ���Ա���ձ���ŵ�ֵ
     */
    public int getItemKindNo(){
        return itemKindNo;
    }

    /**
     * �������Լ�ͥ���
     * @param familyNo �����õ����Լ�ͥ��ŵ�ֵ
     */
    public void setFamilyNo(int familyNo){
        this.familyNo = familyNo;
    }

    /**
     * ��ȡ���Լ�ͥ���
     * @return ���Լ�ͥ��ŵ�ֵ
     */
    public int getFamilyNo(){
        return familyNo;
    }

    /**
     * �������Լ�ͥ����
     * @param familyName �����õ����Լ�ͥ���Ƶ�ֵ
     */
    public void setFamilyName(String familyName){
        this.familyName = StringUtils.rightTrim(familyName);
    }

    /**
     * ��ȡ���Լ�ͥ����
     * @return ���Լ�ͥ���Ƶ�ֵ
     */
    public String getFamilyName(){
        return familyName;
    }

    /**
     * �������Գб��ձ����
     * @param kindCode �����õ����Գб��ձ�����ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ���Գб��ձ����
     * @return ���Գб��ձ�����ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * �����������η������
     * @param liabCode �����õ��������η�������ֵ
     */
    public void setLiabCode(String liabCode){
        this.liabCode = StringUtils.rightTrim(liabCode);
    }

    /**
     * ��ȡ�������η������
     * @return �������η�������ֵ
     */
    public String getLiabCode(){
        return liabCode;
    }

    /**
     * �����������η�������
     * @param liabName �����õ��������η������Ƶ�ֵ
     */
    public void setLiabName(String liabName){
        this.liabName = StringUtils.rightTrim(liabName);
    }

    /**
     * ��ȡ�������η�������
     * @return �������η������Ƶ�ֵ
     */
    public String getLiabName(){
        return liabName;
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
     * ��������������ϸ�������
     * @param liabDetailCode �����õ�����������ϸ��������ֵ
     */
    public void setLiabDetailCode(String liabDetailCode){
        this.liabDetailCode = StringUtils.rightTrim(liabDetailCode);
    }

    /**
     * ��ȡ����������ϸ�������
     * @return ����������ϸ��������ֵ
     */
    public String getLiabDetailCode(){
        return liabDetailCode;
    }

    /**
     * ��������������ϸ��������
     * @param liabDetailName �����õ�����������ϸ�������Ƶ�ֵ
     */
    public void setLiabDetailName(String liabDetailName){
        this.liabDetailName = StringUtils.rightTrim(liabDetailName);
    }

    /**
     * ��ȡ����������ϸ��������
     * @return ����������ϸ�������Ƶ�ֵ
     */
    public String getLiabDetailName(){
        return liabDetailName;
    }

    /**
     * �������������ĵ�ַ
     * @param itemAddress �����õ����������ĵ�ַ��ֵ
     */
    public void setItemAddress(String itemAddress){
        this.itemAddress = StringUtils.rightTrim(itemAddress);
    }

    /**
     * ��ȡ���������ĵ�ַ
     * @return ���������ĵ�ַ��ֵ
     */
    public String getItemAddress(){
        return itemAddress;
    }

    /**
     * ������������
     * @param lossQuantity �����õ�����������ֵ
     */
    public void setLossQuantity(int lossQuantity){
        this.lossQuantity = lossQuantity;
    }

    /**
     * ��ȡ��������
     * @return ����������ֵ
     */
    public int getLossQuantity(){
        return lossQuantity;
    }

    /**
     * ��������������λ
     * @param unit �����õ�����������λ��ֵ
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * ��ȡ����������λ
     * @return ����������λ��ֵ
     */
    public String getUnit(){
        return unit;
    }

    /**
     * �������Ե�λ�⳥�޶�
     * @param unitAmount �����õ����Ե�λ�⳥�޶��ֵ
     */
    public void setUnitAmount(double unitAmount){
        this.unitAmount = unitAmount;
    }

    /**
     * ��ȡ���Ե�λ�⳥�޶�
     * @return ���Ե�λ�⳥�޶��ֵ
     */
    public double getUnitAmount(){
        return unitAmount;
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
     * �������Ա��ս��
     * @param amount �����õ����Ա��ս���ֵ
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * ��ȡ���Ա��ս��
     * @return ���Ա��ս���ֵ
     */
    public double getAmount(){
        return amount;
    }

    /**
     * �������Ա�ļ�ֵ�ұ�
     * @param currency1 �����õ����Ա�ļ�ֵ�ұ��ֵ
     */
    public void setCurrency1(String currency1){
        this.currency1 = StringUtils.rightTrim(currency1);
    }

    /**
     * ��ȡ���Ա�ļ�ֵ�ұ�
     * @return ���Ա�ļ�ֵ�ұ��ֵ
     */
    public String getCurrency1(){
        return currency1;
    }

    /**
     * �������Ա�ļ�ֵ
     * @param itemValue �����õ����Ա�ļ�ֵ��ֵ
     */
    public void setItemValue(double itemValue){
        this.itemValue = itemValue;
    }

    /**
     * ��ȡ���Ա�ļ�ֵ
     * @return ���Ա�ļ�ֵ��ֵ
     */
    public double getItemValue(){
        return itemValue;
    }

    /**
     * ��������������ұ�
     * @param currency2 �����õ�����������ұ��ֵ
     */
    public void setCurrency2(String currency2){
        this.currency2 = StringUtils.rightTrim(currency2);
    }

    /**
     * ��ȡ����������ұ�
     * @return ����������ұ��ֵ
     */
    public String getCurrency2(){
        return currency2;
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
     * ���������޳����/��ֵ/����
     * @param sumRest �����õ������޳����/��ֵ/�����ֵ
     */
    public void setSumRest(double sumRest){
        this.sumRest = sumRest;
    }

    /**
     * ��ȡ�����޳����/��ֵ/����
     * @return �����޳����/��ֵ/�����ֵ
     */
    public double getSumRest(){
        return sumRest;
    }

    /**
     * �����������α���
     * @param indemnityDutyRate �����õ��������α�����ֵ
     */
    public void setIndemnityDutyRate(double indemnityDutyRate){
        this.indemnityDutyRate = indemnityDutyRate;
    }

    /**
     * ��ȡ�������α���
     * @return �������α�����ֵ
     */
    public double getIndemnityDutyRate(){
        return indemnityDutyRate;
    }

    /**
     * ���������⸶����
     * @param claimRate �����õ������⸶������ֵ
     */
    public void setClaimRate(double claimRate){
        this.claimRate = claimRate;
    }

    /**
     * ��ȡ�����⸶����
     * @return �����⸶������ֵ
     */
    public double getClaimRate(){
        return claimRate;
    }

    /**
     * �������������ұ�
     * @param currency3 �����õ����������ұ��ֵ
     */
    public void setCurrency3(String currency3){
        this.currency3 = StringUtils.rightTrim(currency3);
    }

    /**
     * ��ȡ���������ұ�
     * @return ���������ұ��ֵ
     */
    public String getCurrency3(){
        return currency3;
    }

    /**
     * ��������������
     * @param deductibleRate �����õ����������ʵ�ֵ
     */
    public void setDeductibleRate(double deductibleRate){
        this.deductibleRate = deductibleRate;
    }

    /**
     * ��ȡ����������
     * @return ���������ʵ�ֵ
     */
    public double getDeductibleRate(){
        return deductibleRate;
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
     * ��������ʵ��ұ�
     * @param currency4 �����õ�����ʵ��ұ��ֵ
     */
    public void setCurrency4(String currency4){
        this.currency4 = StringUtils.rightTrim(currency4);
    }

    /**
     * ��ȡ����ʵ��ұ�
     * @return ����ʵ��ұ��ֵ
     */
    public String getCurrency4(){
        return currency4;
    }

    /**
     * ��������ʵ����
     * @param sumRealPay �����õ�����ʵ�����ֵ
     */
    public void setSumRealPay(double sumRealPay){
        this.sumRealPay = sumRealPay;
    }

    /**
     * ��ȡ����ʵ����
     * @return ����ʵ�����ֵ
     */
    public double getSumRealPay(){
        return sumRealPay;
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
     * ���������¹�����������
     * @param dutyDeductibleRate �����õ������¹����������ʵ�ֵ
     */
    public void setDutyDeductibleRate(double dutyDeductibleRate){
        this.dutyDeductibleRate = dutyDeductibleRate;
    }

    /**
     * ��ȡ�����¹�����������
     * @return �����¹����������ʵ�ֵ
     */
    public double getDutyDeductibleRate(){
        return dutyDeductibleRate;
    }

    /**
     * ��������INJURYGRADE
     * @param injuryGrade �����õ�����INJURYGRADE��ֵ
     */
    public void setInjuryGrade(String injuryGrade){
        this.injuryGrade = StringUtils.rightTrim(injuryGrade);
    }

    /**
     * ��ȡ����INJURYGRADE
     * @return ����INJURYGRADE��ֵ
     */
    public String getInjuryGrade(){
        return injuryGrade;
    }

    /**
     * ��������INJURYSCOPEDESC
     * @param injuryScopeDesc �����õ�����INJURYSCOPEDESC��ֵ
     */
    public void setInjuryScopeDesc(String injuryScopeDesc){
        this.injuryScopeDesc = StringUtils.rightTrim(injuryScopeDesc);
    }

    /**
     * ��ȡ����INJURYSCOPEDESC
     * @return ����INJURYSCOPEDESC��ֵ
     */
    public String getInjuryScopeDesc(){
        return injuryScopeDesc;
    }

    /**
     * ����������Ժ����
     * @param inHospDate �����õ�������Ժ���ڵ�ֵ
     */
    public void setInHospDate(String inHospDate){
        this.inHospDate = inHospDate;
    }

    /**
     * ��ȡ������Ժ����
     * @return ������Ժ���ڵ�ֵ
     */
    public String getInHospDate(){
        return inHospDate;
    }

    /**
     * �������Գ�Ժ����
     * @param outHospDate �����õ����Գ�Ժ���ڵ�ֵ
     */
    public void setOutHospDate(String outHospDate){
        this.outHospDate = outHospDate;
    }

    /**
     * ��ȡ���Գ�Ժ����
     * @return ���Գ�Ժ���ڵ�ֵ
     */
    public String getOutHospDate(){
        return outHospDate;
    }

    /**
     * �������Ծ���ҽԺ
     * @param hospital �����õ����Ծ���ҽԺ��ֵ
     */
    public void setHospital(String hospital){
        this.hospital = StringUtils.rightTrim(hospital);
    }

    /**
     * ��ȡ���Ծ���ҽԺ
     * @return ���Ծ���ҽԺ��ֵ
     */
    public String getHospital(){
        return hospital;
    }

    /**
     * ��������סԺ����
     * @param hospitalDays �����õ�����סԺ������ֵ
     */
    public void setHospitalDays(int hospitalDays){
        this.hospitalDays = hospitalDays;
    }

    /**
     * ��ȡ����סԺ����
     * @return ����סԺ������ֵ
     */
    public int getHospitalDays(){
        return hospitalDays;
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
     * �������Լ�ʻԱ������
     * @param driverDeductibleRate �����õ����Լ�ʻԱ�����ʵ�ֵ
     */
    public void setDriverDeductibleRate(double driverDeductibleRate){
        this.driverDeductibleRate = driverDeductibleRate;
    }

    /**
     * ��ȡ���Լ�ʻԱ������
     * @return ���Լ�ʻԱ�����ʵ�ֵ
     */
    public double getDriverDeductibleRate(){
        return driverDeductibleRate;
    }

    /**
     * ������������⸶���
     * @param maxpaid �����õ���������⸶����ֵ
     */
    public void setMaxpaid(double maxpaid){
        this.maxpaid = maxpaid;
    }

    /**
     * ��ȡ��������⸶���
     * @return ��������⸶����ֵ
     */
    public double getMaxpaid(){
        return maxpaid;
    }

    /**
     * ����������ʷ�⸶���
     * @param hispaid �����õ�������ʷ�⸶����ֵ
     */
    public void setHispaid(double hispaid){
        this.hispaid = hispaid;
    }

    /**
     * ��ȡ������ʷ�⸶���
     * @return ������ʷ�⸶����ֵ
     */
    public double getHispaid(){
        return hispaid;
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
     * ��������Э�̱���
     * @param arrangeRate �����õ�����Э�̱�����ֵ
     */
    public void setArrangeRate(double arrangeRate){
        this.arrangeRate = arrangeRate;
    }

    /**
     * ��ȡ����Э�̱���
     * @return ����Э�̱�����ֵ
     */
    public double getArrangeRate(){
        return arrangeRate;
    }

    /**
     * �������Ժ˶��⳥
     * @param sumDefPay �����õ����Ժ˶��⳥��ֵ
     */
    public void setSumDefPay(double sumDefPay){
        this.sumDefPay = sumDefPay;
    }

    /**
     * ��ȡ���Ժ˶��⳥
     * @return ���Ժ˶��⳥��ֵ
     */
    public double getSumDefPay(){
        return sumDefPay;
    }

    /**
     * �������Է��÷�Χ
     * @param feeCategory �����õ����Է��÷�Χ��ֵ
     */
    public void setFeeCategory(String feeCategory){
        this.feeCategory = StringUtils.rightTrim(feeCategory);
    }

    /**
     * ��ȡ���Է��÷�Χ
     * @return ���Է��÷�Χ��ֵ
     */
    public String getFeeCategory(){
        return feeCategory;
    }

	public double getSumAllRealPay() {
		return sumAllRealPay;
	}

	public void setSumAllRealPay(double sumAllRealPay) {
		this.sumAllRealPay = sumAllRealPay;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	
	
}
