package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLCitemKind-代赔保单投保险别表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.640<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLCitemKindDtoBase implements Serializable{
    /** 属性赔案号 */
    private String claimNo = "";
    /** 属性报案号 */
    private String registNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性序号 */
    private int itemKindNo = 0;
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性险别名称 */
    private String kindName = "";
    /** 属性标的项目类别代码 ▲
--** 林木种类代码 */
    private String itemCode = "";
    /** 属性标的项目明细名称
--** 林木种类名称 */
    private String itemDetailName = "";
    /** 属性投保方式代码--** 金牛险:
--** PrpDration.RationType
--** 养殖险: 何价投保
--** 车险：玻璃类别 */
    private String modeCode = "";
    /** 属性投保方式名称--** 金牛险:
--** PrpDration.RationName
--** 养殖险: 何价投保 */
    private String modeName = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性是否计算保额标志(Y/N) */
    private String calculateFlag = "";
    /** 属性单位保险金额（赔偿限额）
--** 约定单价(元/公斤)(种植险)
--** 林木实有密度(林木险) */
    private double unitAmount = 0d;
    /** 属性数量(人数/产品数量/户数)
--** 牲畜数量(养殖)
--** 投保面积(亩)(林木险) */
    private double quantity = 0d;
    /** 属性保险价值保险金额/赔偿限额 */
    private double value = 0d;
    /** 属性保险金额/赔偿限额 */
    private double amount = 0d;
    /** 属性费率 */
    private double rate = 0d;
    /** 属性短期费率标志(1.月比例/2.日比例) */
    private String shortRateFlag = "";
    /** 属性基准保费 */
    private double basePremium = 0d;
    /** 属性标准保费 */
    private double benchMarkPremium = 0d;
    /** 属性折扣率(%) */
    private double discount = 0d;
    /** 属性保费调整比率(%) */
    private double adjustRate = 0d;
    /** 属性保费/储金 */
    private double premium = 0d;
    /** 属性免赔率 */
    private double deductibleRate = 0d;
    /** 属性免赔额(%) */
    private double deductible = 0d;
    /** 属性SHORTRATE */
    private double shortRate = 0d;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLCitemKindDtoBase对象
     */
    public PrpLCitemKindDtoBase(){
    }

    /**
     * 设置属性赔案号
     * @param claimNo 待设置的属性赔案号的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号
     * @return 属性赔案号的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性报案号
     * @param registNo 待设置的属性报案号的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号
     * @return 属性报案号的值
     */
    public String getRegistNo(){
        return registNo;
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
     * 设置属性标的项目类别代码 ▲
--** 林木种类代码
     * @param itemCode 待设置的属性标的项目类别代码 ▲
--** 林木种类代码的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性标的项目类别代码 ▲
--** 林木种类代码
     * @return 属性标的项目类别代码 ▲
--** 林木种类代码的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性标的项目明细名称
--** 林木种类名称
     * @param itemDetailName 待设置的属性标的项目明细名称
--** 林木种类名称的值
     */
    public void setItemDetailName(String itemDetailName){
        this.itemDetailName = StringUtils.rightTrim(itemDetailName);
    }

    /**
     * 获取属性标的项目明细名称
--** 林木种类名称
     * @return 属性标的项目明细名称
--** 林木种类名称的值
     */
    public String getItemDetailName(){
        return itemDetailName;
    }

    /**
     * 设置属性投保方式代码--** 金牛险:
--** PrpDration.RationType
--** 养殖险: 何价投保
--** 车险：玻璃类别
     * @param modeCode 待设置的属性投保方式代码--** 金牛险:
--** PrpDration.RationType
--** 养殖险: 何价投保
--** 车险：玻璃类别的值
     */
    public void setModeCode(String modeCode){
        this.modeCode = StringUtils.rightTrim(modeCode);
    }

    /**
     * 获取属性投保方式代码--** 金牛险:
--** PrpDration.RationType
--** 养殖险: 何价投保
--** 车险：玻璃类别
     * @return 属性投保方式代码--** 金牛险:
--** PrpDration.RationType
--** 养殖险: 何价投保
--** 车险：玻璃类别的值
     */
    public String getModeCode(){
        return modeCode;
    }

    /**
     * 设置属性投保方式名称--** 金牛险:
--** PrpDration.RationName
--** 养殖险: 何价投保
     * @param modeName 待设置的属性投保方式名称--** 金牛险:
--** PrpDration.RationName
--** 养殖险: 何价投保的值
     */
    public void setModeName(String modeName){
        this.modeName = StringUtils.rightTrim(modeName);
    }

    /**
     * 获取属性投保方式名称--** 金牛险:
--** PrpDration.RationName
--** 养殖险: 何价投保
     * @return 属性投保方式名称--** 金牛险:
--** PrpDration.RationName
--** 养殖险: 何价投保的值
     */
    public String getModeName(){
        return modeName;
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
     * 设置属性是否计算保额标志(Y/N)
     * @param calculateFlag 待设置的属性是否计算保额标志(Y/N)的值
     */
    public void setCalculateFlag(String calculateFlag){
        this.calculateFlag = StringUtils.rightTrim(calculateFlag);
    }

    /**
     * 获取属性是否计算保额标志(Y/N)
     * @return 属性是否计算保额标志(Y/N)的值
     */
    public String getCalculateFlag(){
        return calculateFlag;
    }

    /**
     * 设置属性单位保险金额（赔偿限额）
--** 约定单价(元/公斤)(种植险)
--** 林木实有密度(林木险)
     * @param unitAmount 待设置的属性单位保险金额（赔偿限额）
--** 约定单价(元/公斤)(种植险)
--** 林木实有密度(林木险)的值
     */
    public void setUnitAmount(double unitAmount){
        this.unitAmount = unitAmount;
    }

    /**
     * 获取属性单位保险金额（赔偿限额）
--** 约定单价(元/公斤)(种植险)
--** 林木实有密度(林木险)
     * @return 属性单位保险金额（赔偿限额）
--** 约定单价(元/公斤)(种植险)
--** 林木实有密度(林木险)的值
     */
    public double getUnitAmount(){
        return unitAmount;
    }

    /**
     * 设置属性数量(人数/产品数量/户数)
--** 牲畜数量(养殖)
--** 投保面积(亩)(林木险)
     * @param quantity 待设置的属性数量(人数/产品数量/户数)
--** 牲畜数量(养殖)
--** 投保面积(亩)(林木险)的值
     */
    public void setQuantity(double quantity){
        this.quantity = quantity;
    }

    /**
     * 获取属性数量(人数/产品数量/户数)
--** 牲畜数量(养殖)
--** 投保面积(亩)(林木险)
     * @return 属性数量(人数/产品数量/户数)
--** 牲畜数量(养殖)
--** 投保面积(亩)(林木险)的值
     */
    public double getQuantity(){
        return quantity;
    }

    /**
     * 设置属性保险价值保险金额/赔偿限额
     * @param value 待设置的属性保险价值保险金额/赔偿限额的值
     */
    public void setValue(double value){
        this.value = value;
    }

    /**
     * 获取属性保险价值保险金额/赔偿限额
     * @return 属性保险价值保险金额/赔偿限额的值
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
     * 设置属性短期费率标志(1.月比例/2.日比例)
     * @param shortRateFlag 待设置的属性短期费率标志(1.月比例/2.日比例)的值
     */
    public void setShortRateFlag(String shortRateFlag){
        this.shortRateFlag = StringUtils.rightTrim(shortRateFlag);
    }

    /**
     * 获取属性短期费率标志(1.月比例/2.日比例)
     * @return 属性短期费率标志(1.月比例/2.日比例)的值
     */
    public String getShortRateFlag(){
        return shortRateFlag;
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
     * 设置属性折扣率(%)
     * @param discount 待设置的属性折扣率(%)的值
     */
    public void setDiscount(double discount){
        this.discount = discount;
    }

    /**
     * 获取属性折扣率(%)
     * @return 属性折扣率(%)的值
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
     * 设置属性免赔率
     * @param deductibleRate 待设置的属性免赔率的值
     */
    public void setDeductibleRate(double deductibleRate){
        this.deductibleRate = deductibleRate;
    }

    /**
     * 获取属性免赔率
     * @return 属性免赔率的值
     */
    public double getDeductibleRate(){
        return deductibleRate;
    }

    /**
     * 设置属性免赔额(%)
     * @param deductible 待设置的属性免赔额(%)的值
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * 获取属性免赔额(%)
     * @return 属性免赔额(%)的值
     */
    public double getDeductible(){
        return deductible;
    }

    /**
     * 设置属性SHORTRATE
     * @param shortRate 待设置的属性SHORTRATE的值
     */
    public void setShortRate(double shortRate){
        this.shortRate = shortRate;
    }

    /**
     * 获取属性SHORTRATE
     * @return 属性SHORTRATE的值
     */
    public double getShortRate(){
        return shortRate;
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
}
