package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Planting31PolicyList�����ݴ���������<br>
 */
public class Planting31PolicyListDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����InusreListCode */
    private String inusreListCode = "";
    /** ����FCode */
    private String fcode = "";
    /** ����KindCode */
    private String kindCode = "";
    /** ����ItemCode */
    private String itemCode = "";
    /** ����IndexCode */
    private String indexCode = "";
    /** ����Phone */
    private String phone = "";
    /** ����Bank */
    private String bank = "";
    /** ����ZhiBuKa */
    private String zhiBuKa = "";
    /** ����FName */
    private String fname = "";
    /** ����FIDCard */
    private String fidCard = "";
    /** ����ClassCode */
    private String classCode = "";
    /** ����RiskCode */
    private String riskCode = "";
    /** ����FAreaCode */
    private String fareaCode = "";
    /** ����TaxArea */
    private double taxArea = 0D;
    /** ����InsureArea */
    private double insureArea = 0D;
    /** ����Amount */
    private double amount = 0D;
    /** ����Rate */
    private double rate = 0D;
    /** ����ShortRateFlag */
    private String shortRateFlag = "";
    /** ����ShortRate */
    private double shortRate = 0D;
    /** ����SumAmount */
    private double sumAmount = 0D;
    /** ����SumPremium */
    private double sumPremium = 0D;
    /** ����StartDate */
    private DateTime startDate = new DateTime();
    /** ����EndDate */
    private DateTime endDate = new DateTime();
    /** ����CalculateFlag */
    private String calculateFlag = "";
    /** ����OpCode */
    private String opCode = "";
    /** ����OpTime */
    private DateTime opTime = new DateTime();
    /** ����Validity */
    private String validity = "";
    /** ����Remark */
    private String remark = "";
    /** ����FPremium */
    private double fpremium = 0D;
    /** ����TeamName */
    private String teamName = "";
    /** ����CentralPremium */
    private double centralPremium = 0D;
    /** ����ProvincePremium */
    private double provincePremium = 0D;
    /** ����CityPremium */
    private double cityPremium = 0D;
    /** ����TownPremium */
    private double townPremium = 0D;
    /** ����OtherPremium */
    private double otherPremium = 0D;
    /** ����FieldSource */
    private String fieldSource = "";
    /** ����MulChDate */
    private String mulChDate = "";
    /** ����MulChType */
    private String mulChType = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�Planting31PolicyListDtoBase����
     */
    public Planting31PolicyListDtoBase(){
    }

    /**
     * ��������InusreListCode
     * @param inusreListCode �����õ�����InusreListCode��ֵ
     */
    public void setInusreListCode(String inusreListCode){
        this.inusreListCode = StringUtils.rightTrim(inusreListCode);
    }

    /**
     * ��ȡ����InusreListCode
     * @return ����InusreListCode��ֵ
     */
    public String getInusreListCode(){
        return inusreListCode;
    }

    /**
     * ��������FCode
     * @param fcode �����õ�����FCode��ֵ
     */
    public void setFcode(String fcode){
        this.fcode = StringUtils.rightTrim(fcode);
    }

    /**
     * ��ȡ����FCode
     * @return ����FCode��ֵ
     */
    public String getFcode(){
        return fcode;
    }

    /**
     * ��������KindCode
     * @param kindCode �����õ�����KindCode��ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ����KindCode
     * @return ����KindCode��ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * ��������ItemCode
     * @param itemCode �����õ�����ItemCode��ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ����ItemCode
     * @return ����ItemCode��ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * ��������IndexCode
     * @param indexCode �����õ�����IndexCode��ֵ
     */
    public void setIndexCode(String indexCode){
        this.indexCode = StringUtils.rightTrim(indexCode);
    }

    /**
     * ��ȡ����IndexCode
     * @return ����IndexCode��ֵ
     */
    public String getIndexCode(){
        return indexCode;
    }

    /**
     * ��������Phone
     * @param phone �����õ�����Phone��ֵ
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * ��ȡ����Phone
     * @return ����Phone��ֵ
     */
    public String getPhone(){
        return phone;
    }

    /**
     * ��������Bank
     * @param bank �����õ�����Bank��ֵ
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * ��ȡ����Bank
     * @return ����Bank��ֵ
     */
    public String getBank(){
        return bank;
    }

    /**
     * ��������ZhiBuKa
     * @param zhiBuKa �����õ�����ZhiBuKa��ֵ
     */
    public void setZhiBuKa(String zhiBuKa){
        this.zhiBuKa = StringUtils.rightTrim(zhiBuKa);
    }

    /**
     * ��ȡ����ZhiBuKa
     * @return ����ZhiBuKa��ֵ
     */
    public String getZhiBuKa(){
        return zhiBuKa;
    }

    /**
     * ��������FName
     * @param fname �����õ�����FName��ֵ
     */
    public void setFname(String fname){
        this.fname = StringUtils.rightTrim(fname);
    }

    /**
     * ��ȡ����FName
     * @return ����FName��ֵ
     */
    public String getFname(){
        return fname;
    }

    /**
     * ��������FIDCard
     * @param fidCard �����õ�����FIDCard��ֵ
     */
    public void setFidCard(String fidCard){
        this.fidCard = StringUtils.rightTrim(fidCard);
    }

    /**
     * ��ȡ����FIDCard
     * @return ����FIDCard��ֵ
     */
    public String getFidCard(){
        return fidCard;
    }

    /**
     * ��������ClassCode
     * @param classCode �����õ�����ClassCode��ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ����ClassCode
     * @return ����ClassCode��ֵ
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * ��������RiskCode
     * @param riskCode �����õ�����RiskCode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����RiskCode
     * @return ����RiskCode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������FAreaCode
     * @param fareaCode �����õ�����FAreaCode��ֵ
     */
    public void setFareaCode(String fareaCode){
        this.fareaCode = StringUtils.rightTrim(fareaCode);
    }

    /**
     * ��ȡ����FAreaCode
     * @return ����FAreaCode��ֵ
     */
    public String getFareaCode(){
        return fareaCode;
    }

    /**
     * ��������TaxArea
     * @param taxArea �����õ�����TaxArea��ֵ
     */
    public void setTaxArea(double taxArea){
        this.taxArea = taxArea;
    }

    /**
     * ��ȡ����TaxArea
     * @return ����TaxArea��ֵ
     */
    public double getTaxArea(){
        return taxArea;
    }

    /**
     * ��������InsureArea
     * @param insureArea �����õ�����InsureArea��ֵ
     */
    public void setInsureArea(double insureArea){
        this.insureArea = insureArea;
    }

    /**
     * ��ȡ����InsureArea
     * @return ����InsureArea��ֵ
     */
    public double getInsureArea(){
        return insureArea;
    }

    /**
     * ��������Amount
     * @param amount �����õ�����Amount��ֵ
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * ��ȡ����Amount
     * @return ����Amount��ֵ
     */
    public double getAmount(){
        return amount;
    }

    /**
     * ��������Rate
     * @param rate �����õ�����Rate��ֵ
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * ��ȡ����Rate
     * @return ����Rate��ֵ
     */
    public double getRate(){
        return rate;
    }

    /**
     * ��������ShortRateFlag
     * @param shortRateFlag �����õ�����ShortRateFlag��ֵ
     */
    public void setShortRateFlag(String shortRateFlag){
        this.shortRateFlag = StringUtils.rightTrim(shortRateFlag);
    }

    /**
     * ��ȡ����ShortRateFlag
     * @return ����ShortRateFlag��ֵ
     */
    public String getShortRateFlag(){
        return shortRateFlag;
    }

    /**
     * ��������ShortRate
     * @param shortRate �����õ�����ShortRate��ֵ
     */
    public void setShortRate(double shortRate){
        this.shortRate = shortRate;
    }

    /**
     * ��ȡ����ShortRate
     * @return ����ShortRate��ֵ
     */
    public double getShortRate(){
        return shortRate;
    }

    /**
     * ��������SumAmount
     * @param sumAmount �����õ�����SumAmount��ֵ
     */
    public void setSumAmount(double sumAmount){
        this.sumAmount = sumAmount;
    }

    /**
     * ��ȡ����SumAmount
     * @return ����SumAmount��ֵ
     */
    public double getSumAmount(){
        return sumAmount;
    }

    /**
     * ��������SumPremium
     * @param sumPremium �����õ�����SumPremium��ֵ
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * ��ȡ����SumPremium
     * @return ����SumPremium��ֵ
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * ��������StartDate
     * @param startDate �����õ�����StartDate��ֵ
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * ��ȡ����StartDate
     * @return ����StartDate��ֵ
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * ��������EndDate
     * @param endDate �����õ�����EndDate��ֵ
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * ��ȡ����EndDate
     * @return ����EndDate��ֵ
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * ��������CalculateFlag
     * @param calculateFlag �����õ�����CalculateFlag��ֵ
     */
    public void setCalculateFlag(String calculateFlag){
        this.calculateFlag = StringUtils.rightTrim(calculateFlag);
    }

    /**
     * ��ȡ����CalculateFlag
     * @return ����CalculateFlag��ֵ
     */
    public String getCalculateFlag(){
        return calculateFlag;
    }

    /**
     * ��������OpCode
     * @param opCode �����õ�����OpCode��ֵ
     */
    public void setOpCode(String opCode){
        this.opCode = StringUtils.rightTrim(opCode);
    }

    /**
     * ��ȡ����OpCode
     * @return ����OpCode��ֵ
     */
    public String getOpCode(){
        return opCode;
    }

    /**
     * ��������OpTime
     * @param opTime �����õ�����OpTime��ֵ
     */
    public void setOpTime(DateTime opTime){
        this.opTime = opTime;
    }

    /**
     * ��ȡ����OpTime
     * @return ����OpTime��ֵ
     */
    public DateTime getOpTime(){
        return opTime;
    }

    /**
     * ��������Validity
     * @param validity �����õ�����Validity��ֵ
     */
    public void setValidity(String validity){
        this.validity = StringUtils.rightTrim(validity);
    }

    /**
     * ��ȡ����Validity
     * @return ����Validity��ֵ
     */
    public String getValidity(){
        return validity;
    }

    /**
     * ��������Remark
     * @param remark �����õ�����Remark��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����Remark
     * @return ����Remark��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ��������FPremium
     * @param fpremium �����õ�����FPremium��ֵ
     */
    public void setFpremium(double fpremium){
        this.fpremium = fpremium;
    }

    /**
     * ��ȡ����FPremium
     * @return ����FPremium��ֵ
     */
    public double getFpremium(){
        return fpremium;
    }

    /**
     * ��������TeamName
     * @param teamName �����õ�����TeamName��ֵ
     */
    public void setTeamName(String teamName){
        this.teamName = StringUtils.rightTrim(teamName);
    }

    /**
     * ��ȡ����TeamName
     * @return ����TeamName��ֵ
     */
    public String getTeamName(){
        return teamName;
    }

    /**
     * ��������CentralPremium
     * @param centralPremium �����õ�����CentralPremium��ֵ
     */
    public void setCentralPremium(double centralPremium){
        this.centralPremium = centralPremium;
    }

    /**
     * ��ȡ����CentralPremium
     * @return ����CentralPremium��ֵ
     */
    public double getCentralPremium(){
        return centralPremium;
    }

    /**
     * ��������ProvincePremium
     * @param provincePremium �����õ�����ProvincePremium��ֵ
     */
    public void setProvincePremium(double provincePremium){
        this.provincePremium = provincePremium;
    }

    /**
     * ��ȡ����ProvincePremium
     * @return ����ProvincePremium��ֵ
     */
    public double getProvincePremium(){
        return provincePremium;
    }

    /**
     * ��������CityPremium
     * @param cityPremium �����õ�����CityPremium��ֵ
     */
    public void setCityPremium(double cityPremium){
        this.cityPremium = cityPremium;
    }

    /**
     * ��ȡ����CityPremium
     * @return ����CityPremium��ֵ
     */
    public double getCityPremium(){
        return cityPremium;
    }

    /**
     * ��������TownPremium
     * @param townPremium �����õ�����TownPremium��ֵ
     */
    public void setTownPremium(double townPremium){
        this.townPremium = townPremium;
    }

    /**
     * ��ȡ����TownPremium
     * @return ����TownPremium��ֵ
     */
    public double getTownPremium(){
        return townPremium;
    }

    /**
     * ��������OtherPremium
     * @param otherPremium �����õ�����OtherPremium��ֵ
     */
    public void setOtherPremium(double otherPremium){
        this.otherPremium = otherPremium;
    }

    /**
     * ��ȡ����OtherPremium
     * @return ����OtherPremium��ֵ
     */
    public double getOtherPremium(){
        return otherPremium;
    }

    /**
     * ��������FieldSource
     * @param fieldSource �����õ�����FieldSource��ֵ
     */
    public void setFieldSource(String fieldSource){
        this.fieldSource = StringUtils.rightTrim(fieldSource);
    }

    /**
     * ��ȡ����FieldSource
     * @return ����FieldSource��ֵ
     */
    public String getFieldSource(){
        return fieldSource;
    }

    /**
     * ��������MulChDate
     * @param mulChDate �����õ�����MulChDate��ֵ
     */
    public void setMulChDate(String mulChDate){
        this.mulChDate = StringUtils.rightTrim(mulChDate);
    }

    /**
     * ��ȡ����MulChDate
     * @return ����MulChDate��ֵ
     */
    public String getMulChDate(){
        return mulChDate;
    }

    /**
     * ��������MulChType
     * @param mulChType �����õ�����MulChType��ֵ
     */
    public void setMulChType(String mulChType){
        this.mulChType = StringUtils.rightTrim(mulChType);
    }

    /**
     * ��ȡ����MulChType
     * @return ����MulChType��ֵ
     */
    public String getMulChType(){
        return mulChType;
    }
}
