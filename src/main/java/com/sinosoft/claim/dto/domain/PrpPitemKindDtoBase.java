package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prppitemkind标的子险信息的数据传输对象基类<br>
 * 创建于 2004-11-22 15:24:13.062<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPitemKindDtoBase implements Serializable{
    /** 属性批单号码 */
    private String endorseNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性序号 */
    private int itemKindNo = 0;
    /** 属性分户序号 */
    private int familyNo = 0;
    /** 属性分户名称 */
    private String familyName = "";
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性险别名称 */
    private String kindName = "";
    /** 属性标的序号 */
    private int itemNo = 0;
    /** 属性标的项目类别代码 */
    private String itemCode = "";
    /** 属性标的项目明细名称 */
    private String itemDetailName = "";
    /** 属性投保方式代码 */
    private String modeCode = "";
    /** 属性投保方式名称 */
    private String modeName = "";
    /** 属性起保日期 */
    private DateTime startDate = new DateTime();
    /** 属性起保小时 */
    private int startHour = 0;
    /** 属性终保日期 */
    private DateTime endDate = new DateTime();
    /** 属性终保小时 */
    private int endHour = 0;
    /** 属性规格型号 */
    private String model = "";
    /** 属性购买日期 */
    private DateTime buyDate = new DateTime();
    /** 属性地址序号 */
    private int addressNo = 0;
    /** 属性是否计算保额标志 */
    private String calculateFlag = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性单位保险金额 */
    private double unitAmount = 0d;
    /** 属性数量 */
    private double quantity = 0d;
    /** 属性数量单位 */
    private String unit = "";
    /** 属性保险价值 */
    private double value = 0d;
    /** 属性保险金额/赔偿限额 */
    private double amount = 0d;
    /** 属性适应费率期数 */
    private int ratePeriod = 0;
    /** 属性费率 */
    private double rate = 0d;
    /** 属性短期费率标志 */
    private String shortRateFlag = "";
    /** 属性短期费率 */
    private double shortRate = 0d;
    /** 属性基准保费 */
    private double basePremium = 0d;
    /** 属性标准保费 */
    private double benchMarkPremium = 0d;
    /** 属性折扣率 */
    private double discount = 0d;
    /** 属性保费调整比率(%) */
    private double adjustRate = 0d;
    /** 属性保费/储金 */
    private double premium = 0d;
    /** 属性免赔率(%) */
    private double deductibleRate = 0d;
    /** 属性免赔额 */
    private double deductible = 0d;
    /** 属性标志字段 */
    private String flag = "";
    /** 属性数量变化量 */
    private double chgQuantity = 0d;
    /** 属性保额变化量 */
    private double chgAmount = 0d;
    /** 属性保费变化量 */
    private double chgPremium = 0d;

    /**
     *  默认构造方法,构造一个默认的PrpPitemKindDtoBase对象
     */
    public PrpPitemKindDtoBase(){
    }

    /**
     * 设置属性批单号码
     * @param endorseNo 待设置的属性批单号码的值
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * 获取属性批单号码
     * @return 属性批单号码的值
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * 设置属性保单号码
     * @param policyNo 待设置的属性保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性序号
     * @param itemKindNo 待设置的属性序号的值
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public int getItemKindNo(){
        return itemKindNo;
    }

    /**
     * 设置属性分户序号
     * @param familyNo 待设置的属性分户序号的值
     */
    public void setFamilyNo(int familyNo){
        this.familyNo = familyNo;
    }

    /**
     * 获取属性分户序号
     * @return 属性分户序号的值
     */
    public int getFamilyNo(){
        return familyNo;
    }

    /**
     * 设置属性分户名称
     * @param familyName 待设置的属性分户名称的值
     */
    public void setFamilyName(String familyName){
        this.familyName = StringUtils.rightTrim(familyName);
    }

    /**
     * 获取属性分户名称
     * @return 属性分户名称的值
     */
    public String getFamilyName(){
        return familyName;
    }

    /**
     * 设置属性险别代码
     * @param kindCode 待设置的属性险别代码的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性险别代码
     * @return 属性险别代码的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性险别名称
     * @param kindName 待设置的属性险别名称的值
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * 获取属性险别名称
     * @return 属性险别名称的值
     */
    public String getKindName(){
        return kindName;
    }

    /**
     * 设置属性标的序号
     * @param itemNo 待设置的属性标的序号的值
     */
    public void setItemNo(int itemNo){
        this.itemNo = itemNo;
    }

    /**
     * 获取属性标的序号
     * @return 属性标的序号的值
     */
    public int getItemNo(){
        return itemNo;
    }

    /**
     * 设置属性标的项目类别代码
     * @param itemCode 待设置的属性标的项目类别代码的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性标的项目类别代码
     * @return 属性标的项目类别代码的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性标的项目明细名称
     * @param itemDetailName 待设置的属性标的项目明细名称的值
     */
    public void setItemDetailName(String itemDetailName){
        this.itemDetailName = StringUtils.rightTrim(itemDetailName);
    }

    /**
     * 获取属性标的项目明细名称
     * @return 属性标的项目明细名称的值
     */
    public String getItemDetailName(){
        return itemDetailName;
    }

    /**
     * 设置属性投保方式代码
     * @param modeCode 待设置的属性投保方式代码的值
     */
    public void setModeCode(String modeCode){
        this.modeCode = StringUtils.rightTrim(modeCode);
    }

    /**
     * 获取属性投保方式代码
     * @return 属性投保方式代码的值
     */
    public String getModeCode(){
        return modeCode;
    }

    /**
     * 设置属性投保方式名称
     * @param modeName 待设置的属性投保方式名称的值
     */
    public void setModeName(String modeName){
        this.modeName = StringUtils.rightTrim(modeName);
    }

    /**
     * 获取属性投保方式名称
     * @return 属性投保方式名称的值
     */
    public String getModeName(){
        return modeName;
    }

    /**
     * 设置属性起保日期
     * @param startDate 待设置的属性起保日期的值
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * 获取属性起保日期
     * @return 属性起保日期的值
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * 设置属性起保小时
     * @param startHour 待设置的属性起保小时的值
     */
    public void setStartHour(int startHour){
        this.startHour = startHour;
    }

    /**
     * 获取属性起保小时
     * @return 属性起保小时的值
     */
    public int getStartHour(){
        return startHour;
    }

    /**
     * 设置属性终保日期
     * @param endDate 待设置的属性终保日期的值
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * 获取属性终保日期
     * @return 属性终保日期的值
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * 设置属性终保小时
     * @param endHour 待设置的属性终保小时的值
     */
    public void setEndHour(int endHour){
        this.endHour = endHour;
    }

    /**
     * 获取属性终保小时
     * @return 属性终保小时的值
     */
    public int getEndHour(){
        return endHour;
    }

    /**
     * 设置属性规格型号
     * @param model 待设置的属性规格型号的值
     */
    public void setModel(String model){
        this.model = StringUtils.rightTrim(model);
    }

    /**
     * 获取属性规格型号
     * @return 属性规格型号的值
     */
    public String getModel(){
        return model;
    }

    /**
     * 设置属性购买日期
     * @param buyDate 待设置的属性购买日期的值
     */
    public void setBuyDate(DateTime buyDate){
        this.buyDate = buyDate;
    }

    /**
     * 获取属性购买日期
     * @return 属性购买日期的值
     */
    public DateTime getBuyDate(){
        return buyDate;
    }

    /**
     * 设置属性地址序号
     * @param addressNo 待设置的属性地址序号的值
     */
    public void setAddressNo(int addressNo){
        this.addressNo = addressNo;
    }

    /**
     * 获取属性地址序号
     * @return 属性地址序号的值
     */
    public int getAddressNo(){
        return addressNo;
    }

    /**
     * 设置属性是否计算保额标志
     * @param calculateFlag 待设置的属性是否计算保额标志的值
     */
    public void setCalculateFlag(String calculateFlag){
        this.calculateFlag = StringUtils.rightTrim(calculateFlag);
    }

    /**
     * 获取属性是否计算保额标志
     * @return 属性是否计算保额标志的值
     */
    public String getCalculateFlag(){
        return calculateFlag;
    }

    /**
     * 设置属性币别
     * @param currency 待设置的属性币别的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别
     * @return 属性币别的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性单位保险金额
     * @param unitAmount 待设置的属性单位保险金额的值
     */
    public void setUnitAmount(double unitAmount){
        this.unitAmount = unitAmount;
    }

    /**
     * 获取属性单位保险金额
     * @return 属性单位保险金额的值
     */
    public double getUnitAmount(){
        return unitAmount;
    }

    /**
     * 设置属性数量
     * @param quantity 待设置的属性数量的值
     */
    public void setQuantity(double quantity){
        this.quantity = quantity;
    }

    /**
     * 获取属性数量
     * @return 属性数量的值
     */
    public double getQuantity(){
        return quantity;
    }

    /**
     * 设置属性数量单位
     * @param unit 待设置的属性数量单位的值
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * 获取属性数量单位
     * @return 属性数量单位的值
     */
    public String getUnit(){
        return unit;
    }

    /**
     * 设置属性保险价值
     * @param value 待设置的属性保险价值的值
     */
    public void setValue(double value){
        this.value = value;
    }

    /**
     * 获取属性保险价值
     * @return 属性保险价值的值
     */
    public double getValue(){
        return value;
    }

    /**
     * 设置属性保险金额/赔偿限额
     * @param amount 待设置的属性保险金额/赔偿限额的值
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * 获取属性保险金额/赔偿限额
     * @return 属性保险金额/赔偿限额的值
     */
    public double getAmount(){
        return amount;
    }

    /**
     * 设置属性适应费率期数
     * @param ratePeriod 待设置的属性适应费率期数的值
     */
    public void setRatePeriod(int ratePeriod){
        this.ratePeriod = ratePeriod;
    }

    /**
     * 获取属性适应费率期数
     * @return 属性适应费率期数的值
     */
    public int getRatePeriod(){
        return ratePeriod;
    }

    /**
     * 设置属性费率
     * @param rate 待设置的属性费率的值
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * 获取属性费率
     * @return 属性费率的值
     */
    public double getRate(){
        return rate;
    }

    /**
     * 设置属性短期费率标志
     * @param shortRateFlag 待设置的属性短期费率标志的值
     */
    public void setShortRateFlag(String shortRateFlag){
        this.shortRateFlag = StringUtils.rightTrim(shortRateFlag);
    }

    /**
     * 获取属性短期费率标志
     * @return 属性短期费率标志的值
     */
    public String getShortRateFlag(){
        return shortRateFlag;
    }

    /**
     * 设置属性短期费率
     * @param shortRate 待设置的属性短期费率的值
     */
    public void setShortRate(double shortRate){
        this.shortRate = shortRate;
    }

    /**
     * 获取属性短期费率
     * @return 属性短期费率的值
     */
    public double getShortRate(){
        return shortRate;
    }

    /**
     * 设置属性基准保费
     * @param basePremium 待设置的属性基准保费的值
     */
    public void setBasePremium(double basePremium){
        this.basePremium = basePremium;
    }

    /**
     * 获取属性基准保费
     * @return 属性基准保费的值
     */
    public double getBasePremium(){
        return basePremium;
    }

    /**
     * 设置属性标准保费
     * @param benchMarkPremium 待设置的属性标准保费的值
     */
    public void setBenchMarkPremium(double benchMarkPremium){
        this.benchMarkPremium = benchMarkPremium;
    }

    /**
     * 获取属性标准保费
     * @return 属性标准保费的值
     */
    public double getBenchMarkPremium(){
        return benchMarkPremium;
    }

    /**
     * 设置属性折扣率
     * @param discount 待设置的属性折扣率的值
     */
    public void setDiscount(double discount){
        this.discount = discount;
    }

    /**
     * 获取属性折扣率
     * @return 属性折扣率的值
     */
    public double getDiscount(){
        return discount;
    }

    /**
     * 设置属性保费调整比率(%)
     * @param adjustRate 待设置的属性保费调整比率(%)的值
     */
    public void setAdjustRate(double adjustRate){
        this.adjustRate = adjustRate;
    }

    /**
     * 获取属性保费调整比率(%)
     * @return 属性保费调整比率(%)的值
     */
    public double getAdjustRate(){
        return adjustRate;
    }

    /**
     * 设置属性保费/储金
     * @param premium 待设置的属性保费/储金的值
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * 获取属性保费/储金
     * @return 属性保费/储金的值
     */
    public double getPremium(){
        return premium;
    }

    /**
     * 设置属性免赔率(%)
     * @param deductibleRate 待设置的属性免赔率(%)的值
     */
    public void setDeductibleRate(double deductibleRate){
        this.deductibleRate = deductibleRate;
    }

    /**
     * 获取属性免赔率(%)
     * @return 属性免赔率(%)的值
     */
    public double getDeductibleRate(){
        return deductibleRate;
    }

    /**
     * 设置属性免赔额
     * @param deductible 待设置的属性免赔额的值
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * 获取属性免赔额
     * @return 属性免赔额的值
     */
    public double getDeductible(){
        return deductible;
    }

    /**
     * 设置属性标志字段
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
     * @return 属性标志字段的值
     */
    public String getFlag(){
        return flag;
    }

    /**
     * 设置属性数量变化量
     * @param chgQuantity 待设置的属性数量变化量的值
     */
    public void setChgQuantity(double chgQuantity){
        this.chgQuantity = chgQuantity;
    }

    /**
     * 获取属性数量变化量
     * @return 属性数量变化量的值
     */
    public double getChgQuantity(){
        return chgQuantity;
    }

    /**
     * 设置属性保额变化量
     * @param chgAmount 待设置的属性保额变化量的值
     */
    public void setChgAmount(double chgAmount){
        this.chgAmount = chgAmount;
    }

    /**
     * 获取属性保额变化量
     * @return 属性保额变化量的值
     */
    public double getChgAmount(){
        return chgAmount;
    }

    /**
     * 设置属性保费变化量
     * @param chgPremium 待设置的属性保费变化量的值
     */
    public void setChgPremium(double chgPremium){
        this.chgPremium = chgPremium;
    }

    /**
     * 获取属性保费变化量
     * @return 属性保费变化量的值
     */
    public double getChgPremium(){
        return chgPremium;
    }
}
