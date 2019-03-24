package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLperson����Ա������ϸ��Ϣ������ݴ���������<br>
 * ������ 2006-04-24 10:56:38.422<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpersonDtoBase implements Serializable{
    /** ���������� */
    private String claimNo = "";
    /** �������� */
    private String riskCode = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Ա����� */
    private String registNo = "";
    /** ���Ա������������� */
    private int itemKindNo = 0;
    /** ���Էֻ����(�������к�) */
    private int familyNo = 0;
    /** ���Էֻ�����(���ճ��ƺ�) */
    private String familyName = "";
    /** �����ձ���� */
    private String kindCode = "";
    /** ���Ա��������Ŀ���� */
    private String itemCode = "";
    /** �������ڵ������� */
    private String areaCode = "";
    /** ���Թ̶������־ */
    private String fixedIncomeFlag = "";
    /** ���Թ�Ա���ִ��� */
    private String jobCode = "";
    /** ���Թ�Ա�������� */
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
    /** �������֤���� */
    private String identifyNumber = "";
    /** ���Թ�����λ */
    private String jobUnit = "";
    /** ���Ա�׼���� */
    private double monthStdWage = 0d;
    /** �����½��� */
    private double monthBonus = 0d;
    /** ���Խ��� */
    private double allowance = 0d;
    /** ���������� */
    private double monthWage = 0d;
    /** ���Ծ���ҽԺ */
    private String hospital = "";
    /** ������Ҫ�������� */
    private int nursePersons = 0;
    /** ������Ҫ�������� */
    private int nurseDays = 0;
    /** ������Ͻ�� */
    private String diagnose = "";
    /** �������Ƴ̶� */
    private String woundGrade = "";
    /** ������סԺ���� */
    private int hospitalDays = 0;
    /** �������������� */
    private int cureDays = 0;
    /** �����Ƿ���ҪתԺ���� */
    private String changeHospital = "";
    /** ���Թ�����Ա��� */
    private int relatePersonNo = 0;
    /** ���Ե�λ��� */
    private double unitLoss = 0d;
    /** �������� */
    private double quantity = 0d;
    /** ����������λ */
    private String unit = "";
    /** ���Ա��� */
    private double times = 0d;
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
    /** ���Ե�λ���(����) */
    private double veriUnitLoss = 0d;
    /** ��������(����) */
    private double veriQuantity = 0d;
    /** ����������λ(����) */
    private String veriUnit = "";
    /** ���Ա���(����) */
    private double veriTimes = 0d;
    /** ����������(����) */
    private double veriSumLoss = 0d;
    /** �����޳����(����) */
    private double veriSumReject = 0d;
    /** �����޳�ԭ��(����) */
    private String veriRejectReason = "";
    /** �����⳥����(����) */
    private double veriLossRate = 0d;
    /** ���Ժ˶�����(����) */
    private double veriSumDefLoss = 0d;
    /** ���Ա�ע1 */
    private String veriRemark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** ���Լ�ҽ���˵�� */
    private String fllowHospRemark = "";
    /** ������Ժ���� */
    private DateTime inHospDate = new DateTime();
    /** ���Գ�Ժ���� */
    private DateTime outHospDate = new DateTime();
    /** ���Զ������� */
    private DateTime restDate = new DateTime();
    /** ����ԭ�л������ */
    private String compensateBackFlag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpersonDtoBase����
     */
    public PrpLpersonDtoBase(){
    }

    /**
     * ��������������
     * @param claimNo �����õ����������ŵ�ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ����������
     * @return ���������ŵ�ֵ
     */
    public String getClaimNo(){
        return claimNo;
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
     * �������Էֻ����(�������к�)
     * @param familyNo �����õ����Էֻ����(�������к�)��ֵ
     */
    public void setFamilyNo(int familyNo){
        this.familyNo = familyNo;
    }

    /**
     * ��ȡ���Էֻ����(�������к�)
     * @return ���Էֻ����(�������к�)��ֵ
     */
    public int getFamilyNo(){
        return familyNo;
    }

    /**
     * �������Էֻ�����(���ճ��ƺ�)
     * @param familyName �����õ����Էֻ�����(���ճ��ƺ�)��ֵ
     */
    public void setFamilyName(String familyName){
        this.familyName = StringUtils.rightTrim(familyName);
    }

    /**
     * ��ȡ���Էֻ�����(���ճ��ƺ�)
     * @return ���Էֻ�����(���ճ��ƺ�)��ֵ
     */
    public String getFamilyName(){
        return familyName;
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
     * �������Ա��������Ŀ����
     * @param itemCode �����õ����Ա��������Ŀ�����ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ���Ա��������Ŀ����
     * @return ���Ա��������Ŀ�����ֵ
     */
    public String getItemCode(){
        return itemCode;
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
     * �������Ա�׼����
     * @param monthStdWage �����õ����Ա�׼���ʵ�ֵ
     */
    public void setMonthStdWage(double monthStdWage){
        this.monthStdWage = monthStdWage;
    }

    /**
     * ��ȡ���Ա�׼����
     * @return ���Ա�׼���ʵ�ֵ
     */
    public double getMonthStdWage(){
        return monthStdWage;
    }

    /**
     * ���������½���
     * @param monthBonus �����õ������½����ֵ
     */
    public void setMonthBonus(double monthBonus){
        this.monthBonus = monthBonus;
    }

    /**
     * ��ȡ�����½���
     * @return �����½����ֵ
     */
    public double getMonthBonus(){
        return monthBonus;
    }

    /**
     * �������Խ���
     * @param allowance �����õ����Խ�����ֵ
     */
    public void setAllowance(double allowance){
        this.allowance = allowance;
    }

    /**
     * ��ȡ���Խ���
     * @return ���Խ�����ֵ
     */
    public double getAllowance(){
        return allowance;
    }

    /**
     * ��������������
     * @param monthWage �����õ������������ֵ
     */
    public void setMonthWage(double monthWage){
        this.monthWage = monthWage;
    }

    /**
     * ��ȡ����������
     * @return �����������ֵ
     */
    public double getMonthWage(){
        return monthWage;
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
     * ����������Ҫ��������
     * @param nursePersons �����õ�������Ҫ����������ֵ
     */
    public void setNursePersons(int nursePersons){
        this.nursePersons = nursePersons;
    }

    /**
     * ��ȡ������Ҫ��������
     * @return ������Ҫ����������ֵ
     */
    public int getNursePersons(){
        return nursePersons;
    }

    /**
     * ����������Ҫ��������
     * @param nurseDays �����õ�������Ҫ����������ֵ
     */
    public void setNurseDays(int nurseDays){
        this.nurseDays = nurseDays;
    }

    /**
     * ��ȡ������Ҫ��������
     * @return ������Ҫ����������ֵ
     */
    public int getNurseDays(){
        return nurseDays;
    }

    /**
     * ����������Ͻ��
     * @param diagnose �����õ�������Ͻ����ֵ
     */
    public void setDiagnose(String diagnose){
        this.diagnose = StringUtils.rightTrim(diagnose);
    }

    /**
     * ��ȡ������Ͻ��
     * @return ������Ͻ����ֵ
     */
    public String getDiagnose(){
        return diagnose;
    }

    /**
     * �����������Ƴ̶�
     * @param woundGrade �����õ��������Ƴ̶ȵ�ֵ
     */
    public void setWoundGrade(String woundGrade){
        this.woundGrade = StringUtils.rightTrim(woundGrade);
    }

    /**
     * ��ȡ�������Ƴ̶�
     * @return �������Ƴ̶ȵ�ֵ
     */
    public String getWoundGrade(){
        return woundGrade;
    }

    /**
     * ����������סԺ����
     * @param hospitalDays �����õ�������סԺ������ֵ
     */
    public void setHospitalDays(int hospitalDays){
        this.hospitalDays = hospitalDays;
    }

    /**
     * ��ȡ������סԺ����
     * @return ������סԺ������ֵ
     */
    public int getHospitalDays(){
        return hospitalDays;
    }

    /**
     * ������������������
     * @param cureDays �����õ�����������������ֵ
     */
    public void setCureDays(int cureDays){
        this.cureDays = cureDays;
    }

    /**
     * ��ȡ��������������
     * @return ����������������ֵ
     */
    public int getCureDays(){
        return cureDays;
    }

    /**
     * ���������Ƿ���ҪתԺ����
     * @param changeHospital �����õ������Ƿ���ҪתԺ���Ƶ�ֵ
     */
    public void setChangeHospital(String changeHospital){
        this.changeHospital = StringUtils.rightTrim(changeHospital);
    }

    /**
     * ��ȡ�����Ƿ���ҪתԺ����
     * @return �����Ƿ���ҪתԺ���Ƶ�ֵ
     */
    public String getChangeHospital(){
        return changeHospital;
    }

    /**
     * �������Թ�����Ա���
     * @param relatePersonNo �����õ����Թ�����Ա��ŵ�ֵ
     */
    public void setRelatePersonNo(int relatePersonNo){
        this.relatePersonNo = relatePersonNo;
    }

    /**
     * ��ȡ���Թ�����Ա���
     * @return ���Թ�����Ա��ŵ�ֵ
     */
    public int getRelatePersonNo(){
        return relatePersonNo;
    }

    /**
     * �������Ե�λ���
     * @param unitLoss �����õ����Ե�λ����ֵ
     */
    public void setUnitLoss(double unitLoss){
        this.unitLoss = unitLoss;
    }

    /**
     * ��ȡ���Ե�λ���
     * @return ���Ե�λ����ֵ
     */
    public double getUnitLoss(){
        return unitLoss;
    }

    /**
     * ������������
     * @param quantity �����õ�����������ֵ
     */
    public void setQuantity(double quantity){
        this.quantity = quantity;
    }

    /**
     * ��ȡ��������
     * @return ����������ֵ
     */
    public double getQuantity(){
        return quantity;
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
     * �������Ա���
     * @param times �����õ����Ա�����ֵ
     */
    public void setTimes(double times){
        this.times = times;
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա�����ֵ
     */
    public double getTimes(){
        return times;
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
     * �������Ե�λ���(����)
     * @param veriUnitLoss �����õ����Ե�λ���(����)��ֵ
     */
    public void setVeriUnitLoss(double veriUnitLoss){
        this.veriUnitLoss = veriUnitLoss;
    }

    /**
     * ��ȡ���Ե�λ���(����)
     * @return ���Ե�λ���(����)��ֵ
     */
    public double getVeriUnitLoss(){
        return veriUnitLoss;
    }

    /**
     * ������������(����)
     * @param veriQuantity �����õ���������(����)��ֵ
     */
    public void setVeriQuantity(double veriQuantity){
        this.veriQuantity = veriQuantity;
    }

    /**
     * ��ȡ��������(����)
     * @return ��������(����)��ֵ
     */
    public double getVeriQuantity(){
        return veriQuantity;
    }

    /**
     * ��������������λ(����)
     * @param veriUnit �����õ�����������λ(����)��ֵ
     */
    public void setVeriUnit(String veriUnit){
        this.veriUnit = StringUtils.rightTrim(veriUnit);
    }

    /**
     * ��ȡ����������λ(����)
     * @return ����������λ(����)��ֵ
     */
    public String getVeriUnit(){
        return veriUnit;
    }

    /**
     * �������Ա���(����)
     * @param veriTimes �����õ����Ա���(����)��ֵ
     */
    public void setVeriTimes(double veriTimes){
        this.veriTimes = veriTimes;
    }

    /**
     * ��ȡ���Ա���(����)
     * @return ���Ա���(����)��ֵ
     */
    public double getVeriTimes(){
        return veriTimes;
    }

    /**
     * ��������������(����)
     * @param veriSumLoss �����õ�����������(����)��ֵ
     */
    public void setVeriSumLoss(double veriSumLoss){
        this.veriSumLoss = veriSumLoss;
    }

    /**
     * ��ȡ����������(����)
     * @return ����������(����)��ֵ
     */
    public double getVeriSumLoss(){
        return veriSumLoss;
    }

    /**
     * ���������޳����(����)
     * @param veriSumReject �����õ������޳����(����)��ֵ
     */
    public void setVeriSumReject(double veriSumReject){
        this.veriSumReject = veriSumReject;
    }

    /**
     * ��ȡ�����޳����(����)
     * @return �����޳����(����)��ֵ
     */
    public double getVeriSumReject(){
        return veriSumReject;
    }

    /**
     * ���������޳�ԭ��(����)
     * @param veriRejectReason �����õ������޳�ԭ��(����)��ֵ
     */
    public void setVeriRejectReason(String veriRejectReason){
        this.veriRejectReason = StringUtils.rightTrim(veriRejectReason);
    }

    /**
     * ��ȡ�����޳�ԭ��(����)
     * @return �����޳�ԭ��(����)��ֵ
     */
    public String getVeriRejectReason(){
        return veriRejectReason;
    }

    /**
     * ���������⳥����(����)
     * @param veriLossRate �����õ������⳥����(����)��ֵ
     */
    public void setVeriLossRate(double veriLossRate){
        this.veriLossRate = veriLossRate;
    }

    /**
     * ��ȡ�����⳥����(����)
     * @return �����⳥����(����)��ֵ
     */
    public double getVeriLossRate(){
        return veriLossRate;
    }

    /**
     * �������Ժ˶�����(����)
     * @param veriSumDefLoss �����õ����Ժ˶�����(����)��ֵ
     */
    public void setVeriSumDefLoss(double veriSumDefLoss){
        this.veriSumDefLoss = veriSumDefLoss;
    }

    /**
     * ��ȡ���Ժ˶�����(����)
     * @return ���Ժ˶�����(����)��ֵ
     */
    public double getVeriSumDefLoss(){
        return veriSumDefLoss;
    }

    /**
     * �������Ա�ע1
     * @param veriRemark �����õ����Ա�ע1��ֵ
     */
    public void setVeriRemark(String veriRemark){
        this.veriRemark = StringUtils.rightTrim(veriRemark);
    }

    /**
     * ��ȡ���Ա�ע1
     * @return ���Ա�ע1��ֵ
     */
    public String getVeriRemark(){
        return veriRemark;
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
     * �������Լ�ҽ���˵��
     * @param fllowHospRemark �����õ����Լ�ҽ���˵����ֵ
     */
    public void setFllowHospRemark(String fllowHospRemark){
        this.fllowHospRemark = StringUtils.rightTrim(fllowHospRemark);
    }

    /**
     * ��ȡ���Լ�ҽ���˵��
     * @return ���Լ�ҽ���˵����ֵ
     */
    public String getFllowHospRemark(){
        return fllowHospRemark;
    }

    /**
     * ����������Ժ����
     * @param inHospDate �����õ�������Ժ���ڵ�ֵ
     */
    public void setInHospDate(DateTime inHospDate){
        this.inHospDate = inHospDate;
    }

    /**
     * ��ȡ������Ժ����
     * @return ������Ժ���ڵ�ֵ
     */
    public DateTime getInHospDate(){
        return inHospDate;
    }

    /**
     * �������Գ�Ժ����
     * @param outHospDate �����õ����Գ�Ժ���ڵ�ֵ
     */
    public void setOutHospDate(DateTime outHospDate){
        this.outHospDate = outHospDate;
    }

    /**
     * ��ȡ���Գ�Ժ����
     * @return ���Գ�Ժ���ڵ�ֵ
     */
    public DateTime getOutHospDate(){
        return outHospDate;
    }

    /**
     * �������Զ�������
     * @param restDate �����õ����Զ������ڵ�ֵ
     */
    public void setRestDate(DateTime restDate){
        this.restDate = restDate;
    }

    /**
     * ��ȡ���Զ�������
     * @return ���Զ������ڵ�ֵ
     */
    public DateTime getRestDate(){
        return restDate;
    }

    /**
     * ��������ԭ�л������
     * @param compensateBackFlag �����õ�����ԭ�л�����ǵ�ֵ
     */
    public void setCompensateBackFlag(String compensateBackFlag){
        this.compensateBackFlag = StringUtils.rightTrim(compensateBackFlag);
    }

    /**
     * ��ȡ����ԭ�л������
     * @return ����ԭ�л�����ǵ�ֵ
     */
    public String getCompensateBackFlag(){
        return compensateBackFlag;
    }
}
