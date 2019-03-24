package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是Planting31PolicyList的数据传输对象基类<br>
 */
public class Planting31PolicyListDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性InusreListCode */
    private String inusreListCode = "";
    /** 属性FCode */
    private String fcode = "";
    /** 属性KindCode */
    private String kindCode = "";
    /** 属性ItemCode */
    private String itemCode = "";
    /** 属性IndexCode */
    private String indexCode = "";
    /** 属性Phone */
    private String phone = "";
    /** 属性Bank */
    private String bank = "";
    /** 属性ZhiBuKa */
    private String zhiBuKa = "";
    /** 属性FName */
    private String fname = "";
    /** 属性FIDCard */
    private String fidCard = "";
    /** 属性ClassCode */
    private String classCode = "";
    /** 属性RiskCode */
    private String riskCode = "";
    /** 属性FAreaCode */
    private String fareaCode = "";
    /** 属性TaxArea */
    private double taxArea = 0D;
    /** 属性InsureArea */
    private double insureArea = 0D;
    /** 属性Amount */
    private double amount = 0D;
    /** 属性Rate */
    private double rate = 0D;
    /** 属性ShortRateFlag */
    private String shortRateFlag = "";
    /** 属性ShortRate */
    private double shortRate = 0D;
    /** 属性SumAmount */
    private double sumAmount = 0D;
    /** 属性SumPremium */
    private double sumPremium = 0D;
    /** 属性StartDate */
    private DateTime startDate = new DateTime();
    /** 属性EndDate */
    private DateTime endDate = new DateTime();
    /** 属性CalculateFlag */
    private String calculateFlag = "";
    /** 属性OpCode */
    private String opCode = "";
    /** 属性OpTime */
    private DateTime opTime = new DateTime();
    /** 属性Validity */
    private String validity = "";
    /** 属性Remark */
    private String remark = "";
    /** 属性FPremium */
    private double fpremium = 0D;
    /** 属性TeamName */
    private String teamName = "";
    /** 属性CentralPremium */
    private double centralPremium = 0D;
    /** 属性ProvincePremium */
    private double provincePremium = 0D;
    /** 属性CityPremium */
    private double cityPremium = 0D;
    /** 属性TownPremium */
    private double townPremium = 0D;
    /** 属性OtherPremium */
    private double otherPremium = 0D;
    /** 属性FieldSource */
    private String fieldSource = "";
    /** 属性MulChDate */
    private String mulChDate = "";
    /** 属性MulChType */
    private String mulChType = "";

    /**
     *  默认构造方法,构造一个默认的Planting31PolicyListDtoBase对象
     */
    public Planting31PolicyListDtoBase(){
    }

    /**
     * 设置属性InusreListCode
     * @param inusreListCode 待设置的属性InusreListCode的值
     */
    public void setInusreListCode(String inusreListCode){
        this.inusreListCode = StringUtils.rightTrim(inusreListCode);
    }

    /**
     * 获取属性InusreListCode
     * @return 属性InusreListCode的值
     */
    public String getInusreListCode(){
        return inusreListCode;
    }

    /**
     * 设置属性FCode
     * @param fcode 待设置的属性FCode的值
     */
    public void setFcode(String fcode){
        this.fcode = StringUtils.rightTrim(fcode);
    }

    /**
     * 获取属性FCode
     * @return 属性FCode的值
     */
    public String getFcode(){
        return fcode;
    }

    /**
     * 设置属性KindCode
     * @param kindCode 待设置的属性KindCode的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性KindCode
     * @return 属性KindCode的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性ItemCode
     * @param itemCode 待设置的属性ItemCode的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性ItemCode
     * @return 属性ItemCode的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性IndexCode
     * @param indexCode 待设置的属性IndexCode的值
     */
    public void setIndexCode(String indexCode){
        this.indexCode = StringUtils.rightTrim(indexCode);
    }

    /**
     * 获取属性IndexCode
     * @return 属性IndexCode的值
     */
    public String getIndexCode(){
        return indexCode;
    }

    /**
     * 设置属性Phone
     * @param phone 待设置的属性Phone的值
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * 获取属性Phone
     * @return 属性Phone的值
     */
    public String getPhone(){
        return phone;
    }

    /**
     * 设置属性Bank
     * @param bank 待设置的属性Bank的值
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * 获取属性Bank
     * @return 属性Bank的值
     */
    public String getBank(){
        return bank;
    }

    /**
     * 设置属性ZhiBuKa
     * @param zhiBuKa 待设置的属性ZhiBuKa的值
     */
    public void setZhiBuKa(String zhiBuKa){
        this.zhiBuKa = StringUtils.rightTrim(zhiBuKa);
    }

    /**
     * 获取属性ZhiBuKa
     * @return 属性ZhiBuKa的值
     */
    public String getZhiBuKa(){
        return zhiBuKa;
    }

    /**
     * 设置属性FName
     * @param fname 待设置的属性FName的值
     */
    public void setFname(String fname){
        this.fname = StringUtils.rightTrim(fname);
    }

    /**
     * 获取属性FName
     * @return 属性FName的值
     */
    public String getFname(){
        return fname;
    }

    /**
     * 设置属性FIDCard
     * @param fidCard 待设置的属性FIDCard的值
     */
    public void setFidCard(String fidCard){
        this.fidCard = StringUtils.rightTrim(fidCard);
    }

    /**
     * 获取属性FIDCard
     * @return 属性FIDCard的值
     */
    public String getFidCard(){
        return fidCard;
    }

    /**
     * 设置属性ClassCode
     * @param classCode 待设置的属性ClassCode的值
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * 获取属性ClassCode
     * @return 属性ClassCode的值
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * 设置属性RiskCode
     * @param riskCode 待设置的属性RiskCode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性RiskCode
     * @return 属性RiskCode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性FAreaCode
     * @param fareaCode 待设置的属性FAreaCode的值
     */
    public void setFareaCode(String fareaCode){
        this.fareaCode = StringUtils.rightTrim(fareaCode);
    }

    /**
     * 获取属性FAreaCode
     * @return 属性FAreaCode的值
     */
    public String getFareaCode(){
        return fareaCode;
    }

    /**
     * 设置属性TaxArea
     * @param taxArea 待设置的属性TaxArea的值
     */
    public void setTaxArea(double taxArea){
        this.taxArea = taxArea;
    }

    /**
     * 获取属性TaxArea
     * @return 属性TaxArea的值
     */
    public double getTaxArea(){
        return taxArea;
    }

    /**
     * 设置属性InsureArea
     * @param insureArea 待设置的属性InsureArea的值
     */
    public void setInsureArea(double insureArea){
        this.insureArea = insureArea;
    }

    /**
     * 获取属性InsureArea
     * @return 属性InsureArea的值
     */
    public double getInsureArea(){
        return insureArea;
    }

    /**
     * 设置属性Amount
     * @param amount 待设置的属性Amount的值
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * 获取属性Amount
     * @return 属性Amount的值
     */
    public double getAmount(){
        return amount;
    }

    /**
     * 设置属性Rate
     * @param rate 待设置的属性Rate的值
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * 获取属性Rate
     * @return 属性Rate的值
     */
    public double getRate(){
        return rate;
    }

    /**
     * 设置属性ShortRateFlag
     * @param shortRateFlag 待设置的属性ShortRateFlag的值
     */
    public void setShortRateFlag(String shortRateFlag){
        this.shortRateFlag = StringUtils.rightTrim(shortRateFlag);
    }

    /**
     * 获取属性ShortRateFlag
     * @return 属性ShortRateFlag的值
     */
    public String getShortRateFlag(){
        return shortRateFlag;
    }

    /**
     * 设置属性ShortRate
     * @param shortRate 待设置的属性ShortRate的值
     */
    public void setShortRate(double shortRate){
        this.shortRate = shortRate;
    }

    /**
     * 获取属性ShortRate
     * @return 属性ShortRate的值
     */
    public double getShortRate(){
        return shortRate;
    }

    /**
     * 设置属性SumAmount
     * @param sumAmount 待设置的属性SumAmount的值
     */
    public void setSumAmount(double sumAmount){
        this.sumAmount = sumAmount;
    }

    /**
     * 获取属性SumAmount
     * @return 属性SumAmount的值
     */
    public double getSumAmount(){
        return sumAmount;
    }

    /**
     * 设置属性SumPremium
     * @param sumPremium 待设置的属性SumPremium的值
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * 获取属性SumPremium
     * @return 属性SumPremium的值
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * 设置属性StartDate
     * @param startDate 待设置的属性StartDate的值
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * 获取属性StartDate
     * @return 属性StartDate的值
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * 设置属性EndDate
     * @param endDate 待设置的属性EndDate的值
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * 获取属性EndDate
     * @return 属性EndDate的值
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * 设置属性CalculateFlag
     * @param calculateFlag 待设置的属性CalculateFlag的值
     */
    public void setCalculateFlag(String calculateFlag){
        this.calculateFlag = StringUtils.rightTrim(calculateFlag);
    }

    /**
     * 获取属性CalculateFlag
     * @return 属性CalculateFlag的值
     */
    public String getCalculateFlag(){
        return calculateFlag;
    }

    /**
     * 设置属性OpCode
     * @param opCode 待设置的属性OpCode的值
     */
    public void setOpCode(String opCode){
        this.opCode = StringUtils.rightTrim(opCode);
    }

    /**
     * 获取属性OpCode
     * @return 属性OpCode的值
     */
    public String getOpCode(){
        return opCode;
    }

    /**
     * 设置属性OpTime
     * @param opTime 待设置的属性OpTime的值
     */
    public void setOpTime(DateTime opTime){
        this.opTime = opTime;
    }

    /**
     * 获取属性OpTime
     * @return 属性OpTime的值
     */
    public DateTime getOpTime(){
        return opTime;
    }

    /**
     * 设置属性Validity
     * @param validity 待设置的属性Validity的值
     */
    public void setValidity(String validity){
        this.validity = StringUtils.rightTrim(validity);
    }

    /**
     * 获取属性Validity
     * @return 属性Validity的值
     */
    public String getValidity(){
        return validity;
    }

    /**
     * 设置属性Remark
     * @param remark 待设置的属性Remark的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性Remark
     * @return 属性Remark的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性FPremium
     * @param fpremium 待设置的属性FPremium的值
     */
    public void setFpremium(double fpremium){
        this.fpremium = fpremium;
    }

    /**
     * 获取属性FPremium
     * @return 属性FPremium的值
     */
    public double getFpremium(){
        return fpremium;
    }

    /**
     * 设置属性TeamName
     * @param teamName 待设置的属性TeamName的值
     */
    public void setTeamName(String teamName){
        this.teamName = StringUtils.rightTrim(teamName);
    }

    /**
     * 获取属性TeamName
     * @return 属性TeamName的值
     */
    public String getTeamName(){
        return teamName;
    }

    /**
     * 设置属性CentralPremium
     * @param centralPremium 待设置的属性CentralPremium的值
     */
    public void setCentralPremium(double centralPremium){
        this.centralPremium = centralPremium;
    }

    /**
     * 获取属性CentralPremium
     * @return 属性CentralPremium的值
     */
    public double getCentralPremium(){
        return centralPremium;
    }

    /**
     * 设置属性ProvincePremium
     * @param provincePremium 待设置的属性ProvincePremium的值
     */
    public void setProvincePremium(double provincePremium){
        this.provincePremium = provincePremium;
    }

    /**
     * 获取属性ProvincePremium
     * @return 属性ProvincePremium的值
     */
    public double getProvincePremium(){
        return provincePremium;
    }

    /**
     * 设置属性CityPremium
     * @param cityPremium 待设置的属性CityPremium的值
     */
    public void setCityPremium(double cityPremium){
        this.cityPremium = cityPremium;
    }

    /**
     * 获取属性CityPremium
     * @return 属性CityPremium的值
     */
    public double getCityPremium(){
        return cityPremium;
    }

    /**
     * 设置属性TownPremium
     * @param townPremium 待设置的属性TownPremium的值
     */
    public void setTownPremium(double townPremium){
        this.townPremium = townPremium;
    }

    /**
     * 获取属性TownPremium
     * @return 属性TownPremium的值
     */
    public double getTownPremium(){
        return townPremium;
    }

    /**
     * 设置属性OtherPremium
     * @param otherPremium 待设置的属性OtherPremium的值
     */
    public void setOtherPremium(double otherPremium){
        this.otherPremium = otherPremium;
    }

    /**
     * 获取属性OtherPremium
     * @return 属性OtherPremium的值
     */
    public double getOtherPremium(){
        return otherPremium;
    }

    /**
     * 设置属性FieldSource
     * @param fieldSource 待设置的属性FieldSource的值
     */
    public void setFieldSource(String fieldSource){
        this.fieldSource = StringUtils.rightTrim(fieldSource);
    }

    /**
     * 获取属性FieldSource
     * @return 属性FieldSource的值
     */
    public String getFieldSource(){
        return fieldSource;
    }

    /**
     * 设置属性MulChDate
     * @param mulChDate 待设置的属性MulChDate的值
     */
    public void setMulChDate(String mulChDate){
        this.mulChDate = StringUtils.rightTrim(mulChDate);
    }

    /**
     * 获取属性MulChDate
     * @return 属性MulChDate的值
     */
    public String getMulChDate(){
        return mulChDate;
    }

    /**
     * 设置属性MulChType
     * @param mulChType 待设置的属性MulChType的值
     */
    public void setMulChType(String mulChType){
        this.mulChType = StringUtils.rightTrim(mulChType);
    }

    /**
     * 获取属性MulChType
     * @return 属性MulChType的值
     */
    public String getMulChType(){
        return mulChType;
    }
}
