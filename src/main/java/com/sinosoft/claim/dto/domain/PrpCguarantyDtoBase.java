package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpcguaranty担保信息表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:06<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCguarantyDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性担保方式 */
    private String guaranteeType = "";
    /** 属性质押方式 */
    private String inpawnType = "";
    /** 属性抵(质)押合同号 */
    private String mortgageNo = "";
    /** 属性权人类别 */
    private String obligeeType = "";
    /** 属性抵押（出质）人名称 */
    private String warrantorName = "";
    /** 属性抵押（质）权人 */
    private String guarantyObligee = "";
    /** 属性担保物名称 */
    private String guarantyName = "";
    /** 属性担保物规格型号 */
    private String model = "";
    /** 属性担保物计量单位 */
    private String unit = "";
    /** 属性担保物数量 */
    private int quantity = 0;
    /** 属性担保物所有权属 */
    private String possessor = "";
    /** 属性担保物所在处所 */
    private String guarantyAddress = "";
    /** 属性担保物保管人 */
    private String guarantyKeeper = "";
    /** 属性产权证书号 */
    private String propCertifNo = "";
    /** 属性担保物评估价值 */
    private double guarantyAssessment = 0d;
    /** 属性已经为其他债权设定额度 */
    private double otherRating = 0d;
    /** 属性质押物质量状况 */
    private String inpawnQuality = "";
    /** 属性质押物帐面原值 */
    private double originalValue = 0d;
    /** 属性质押物净值 */
    private double netValue = 0d;
    /** 属性评估人 */
    private String valuator = "";
    /** 属性权利有效期 */
    private DateTime rightValidPeriod = new DateTime();
    /** 属性提货或兑现期 */
    private DateTime encashDate = new DateTime();
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCguarantyDtoBase对象
     */
    public PrpCguarantyDtoBase(){
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
     * 设置属性序号
     * @param serialNo 待设置的属性序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public int getSerialNo(){
        return serialNo;
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
     * 设置属性担保方式
     * @param guaranteeType 待设置的属性担保方式的值
     */
    public void setGuaranteeType(String guaranteeType){
        this.guaranteeType = StringUtils.rightTrim(guaranteeType);
    }

    /**
     * 获取属性担保方式
     * @return 属性担保方式的值
     */
    public String getGuaranteeType(){
        return guaranteeType;
    }

    /**
     * 设置属性质押方式
     * @param inpawnType 待设置的属性质押方式的值
     */
    public void setInpawnType(String inpawnType){
        this.inpawnType = StringUtils.rightTrim(inpawnType);
    }

    /**
     * 获取属性质押方式
     * @return 属性质押方式的值
     */
    public String getInpawnType(){
        return inpawnType;
    }

    /**
     * 设置属性抵(质)押合同号
     * @param mortgageNo 待设置的属性抵(质)押合同号的值
     */
    public void setMortgageNo(String mortgageNo){
        this.mortgageNo = StringUtils.rightTrim(mortgageNo);
    }

    /**
     * 获取属性抵(质)押合同号
     * @return 属性抵(质)押合同号的值
     */
    public String getMortgageNo(){
        return mortgageNo;
    }

    /**
     * 设置属性权人类别
     * @param obligeeType 待设置的属性权人类别的值
     */
    public void setObligeeType(String obligeeType){
        this.obligeeType = StringUtils.rightTrim(obligeeType);
    }

    /**
     * 获取属性权人类别
     * @return 属性权人类别的值
     */
    public String getObligeeType(){
        return obligeeType;
    }

    /**
     * 设置属性抵押（出质）人名称
     * @param warrantorName 待设置的属性抵押（出质）人名称的值
     */
    public void setWarrantorName(String warrantorName){
        this.warrantorName = StringUtils.rightTrim(warrantorName);
    }

    /**
     * 获取属性抵押（出质）人名称
     * @return 属性抵押（出质）人名称的值
     */
    public String getWarrantorName(){
        return warrantorName;
    }

    /**
     * 设置属性抵押（质）权人
     * @param guarantyObligee 待设置的属性抵押（质）权人的值
     */
    public void setGuarantyObligee(String guarantyObligee){
        this.guarantyObligee = StringUtils.rightTrim(guarantyObligee);
    }

    /**
     * 获取属性抵押（质）权人
     * @return 属性抵押（质）权人的值
     */
    public String getGuarantyObligee(){
        return guarantyObligee;
    }

    /**
     * 设置属性担保物名称
     * @param guarantyName 待设置的属性担保物名称的值
     */
    public void setGuarantyName(String guarantyName){
        this.guarantyName = StringUtils.rightTrim(guarantyName);
    }

    /**
     * 获取属性担保物名称
     * @return 属性担保物名称的值
     */
    public String getGuarantyName(){
        return guarantyName;
    }

    /**
     * 设置属性担保物规格型号
     * @param model 待设置的属性担保物规格型号的值
     */
    public void setModel(String model){
        this.model = StringUtils.rightTrim(model);
    }

    /**
     * 获取属性担保物规格型号
     * @return 属性担保物规格型号的值
     */
    public String getModel(){
        return model;
    }

    /**
     * 设置属性担保物计量单位
     * @param unit 待设置的属性担保物计量单位的值
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * 获取属性担保物计量单位
     * @return 属性担保物计量单位的值
     */
    public String getUnit(){
        return unit;
    }

    /**
     * 设置属性担保物数量
     * @param quantity 待设置的属性担保物数量的值
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * 获取属性担保物数量
     * @return 属性担保物数量的值
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * 设置属性担保物所有权属
     * @param possessor 待设置的属性担保物所有权属的值
     */
    public void setPossessor(String possessor){
        this.possessor = StringUtils.rightTrim(possessor);
    }

    /**
     * 获取属性担保物所有权属
     * @return 属性担保物所有权属的值
     */
    public String getPossessor(){
        return possessor;
    }

    /**
     * 设置属性担保物所在处所
     * @param guarantyAddress 待设置的属性担保物所在处所的值
     */
    public void setGuarantyAddress(String guarantyAddress){
        this.guarantyAddress = StringUtils.rightTrim(guarantyAddress);
    }

    /**
     * 获取属性担保物所在处所
     * @return 属性担保物所在处所的值
     */
    public String getGuarantyAddress(){
        return guarantyAddress;
    }

    /**
     * 设置属性担保物保管人
     * @param guarantyKeeper 待设置的属性担保物保管人的值
     */
    public void setGuarantyKeeper(String guarantyKeeper){
        this.guarantyKeeper = StringUtils.rightTrim(guarantyKeeper);
    }

    /**
     * 获取属性担保物保管人
     * @return 属性担保物保管人的值
     */
    public String getGuarantyKeeper(){
        return guarantyKeeper;
    }

    /**
     * 设置属性产权证书号
     * @param propCertifNo 待设置的属性产权证书号的值
     */
    public void setPropCertifNo(String propCertifNo){
        this.propCertifNo = StringUtils.rightTrim(propCertifNo);
    }

    /**
     * 获取属性产权证书号
     * @return 属性产权证书号的值
     */
    public String getPropCertifNo(){
        return propCertifNo;
    }

    /**
     * 设置属性担保物评估价值
     * @param guarantyAssessment 待设置的属性担保物评估价值的值
     */
    public void setGuarantyAssessment(double guarantyAssessment){
        this.guarantyAssessment = guarantyAssessment;
    }

    /**
     * 获取属性担保物评估价值
     * @return 属性担保物评估价值的值
     */
    public double getGuarantyAssessment(){
        return guarantyAssessment;
    }

    /**
     * 设置属性已经为其他债权设定额度
     * @param otherRating 待设置的属性已经为其他债权设定额度的值
     */
    public void setOtherRating(double otherRating){
        this.otherRating = otherRating;
    }

    /**
     * 获取属性已经为其他债权设定额度
     * @return 属性已经为其他债权设定额度的值
     */
    public double getOtherRating(){
        return otherRating;
    }

    /**
     * 设置属性质押物质量状况
     * @param inpawnQuality 待设置的属性质押物质量状况的值
     */
    public void setInpawnQuality(String inpawnQuality){
        this.inpawnQuality = StringUtils.rightTrim(inpawnQuality);
    }

    /**
     * 获取属性质押物质量状况
     * @return 属性质押物质量状况的值
     */
    public String getInpawnQuality(){
        return inpawnQuality;
    }

    /**
     * 设置属性质押物帐面原值
     * @param originalValue 待设置的属性质押物帐面原值的值
     */
    public void setOriginalValue(double originalValue){
        this.originalValue = originalValue;
    }

    /**
     * 获取属性质押物帐面原值
     * @return 属性质押物帐面原值的值
     */
    public double getOriginalValue(){
        return originalValue;
    }

    /**
     * 设置属性质押物净值
     * @param netValue 待设置的属性质押物净值的值
     */
    public void setNetValue(double netValue){
        this.netValue = netValue;
    }

    /**
     * 获取属性质押物净值
     * @return 属性质押物净值的值
     */
    public double getNetValue(){
        return netValue;
    }

    /**
     * 设置属性评估人
     * @param valuator 待设置的属性评估人的值
     */
    public void setValuator(String valuator){
        this.valuator = StringUtils.rightTrim(valuator);
    }

    /**
     * 获取属性评估人
     * @return 属性评估人的值
     */
    public String getValuator(){
        return valuator;
    }

    /**
     * 设置属性权利有效期
     * @param rightValidPeriod 待设置的属性权利有效期的值
     */
    public void setRightValidPeriod(DateTime rightValidPeriod){
        this.rightValidPeriod = rightValidPeriod;
    }

    /**
     * 获取属性权利有效期
     * @return 属性权利有效期的值
     */
    public DateTime getRightValidPeriod(){
        return rightValidPeriod;
    }

    /**
     * 设置属性提货或兑现期
     * @param encashDate 待设置的属性提货或兑现期的值
     */
    public void setEncashDate(DateTime encashDate){
        this.encashDate = encashDate;
    }

    /**
     * 获取属性提货或兑现期
     * @return 属性提货或兑现期的值
     */
    public DateTime getEncashDate(){
        return encashDate;
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
