package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLcharge－赔款费用信息表的数据传输对象基类<br>
 * 创建于 2006-08-04 09:20:18.043<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLchargeDtoBase implements Serializable{
    /** 属性赔款计算书号 */
    private String compensateNo = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性费用类别代码 */
    private String chargeCode = "";
    /** 属性费用名称 */
    private String chargeName = "";
    /** 属性币别代码 */
    private String currency = "";
    /** 属性费用金额 */
    private double chargeAmount = 0d;
    /** 属性计入赔款金额 */
    private double sumRealPay = 0d;
    /** 属性上报费用字段 */
    private double chargeReport = 0d;
    /** 属性标志字段 */
    private String flag = "";
    /** 属性录入时间 */
    private DateTime inputDate = new DateTime();
    /** 属性费用信息标志 */
    private String changeFlag = "";
    /** 属性支付对象类型 */
    private String payObjectType = "";
    /** 属性支付对象代码 */
    private String payObjectCode = "";
    /** 属性支付对象名称 */
    private String payObjectName = "";
    /** 属性保单标的序号' */
    private int itemkindno = 0;
    /** 属性处理机构代码 */
    private String checkDeptCode = "";
    /** 属性处理机构名称 */
    private String checkDeptName = "";
    /** 属性预付费用金额 */
    private double preChargeAmount = 0d;
    /**
     *  默认构造方法,构造一个默认的PrpLchargeDtoBase对象
     */
    public PrpLchargeDtoBase(){
    }

    /**
     * 设置属性赔款计算书号
     * @param compensateNo 待设置的属性赔款计算书号的值
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * 获取属性赔款计算书号
     * @return 属性赔款计算书号的值
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * 设置属性险种
     * @param riskCode 待设置的属性险种的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种
     * @return 属性险种的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性保单号
     * @param policyNo 待设置的属性保单号的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号
     * @return 属性保单号的值
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
     * 设置属性费用类别代码
     * @param chargeCode 待设置的属性费用类别代码的值
     */
    public void setChargeCode(String chargeCode){
        this.chargeCode = StringUtils.rightTrim(chargeCode);
    }

    /**
     * 获取属性费用类别代码
     * @return 属性费用类别代码的值
     */
    public String getChargeCode(){
        return chargeCode;
    }

    /**
     * 设置属性费用名称
     * @param chargeName 待设置的属性费用名称的值
     */
    public void setChargeName(String chargeName){
        this.chargeName = StringUtils.rightTrim(chargeName);
    }

    /**
     * 获取属性费用名称
     * @return 属性费用名称的值
     */
    public String getChargeName(){
        return chargeName;
    }

    /**
     * 设置属性币别代码
     * @param currency 待设置的属性币别代码的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别代码
     * @return 属性币别代码的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性费用金额
     * @param chargeAmount 待设置的属性费用金额的值
     */
    public void setChargeAmount(double chargeAmount){
        this.chargeAmount = chargeAmount;
    }

    /**
     * 获取属性费用金额
     * @return 属性费用金额的值
     */
    public double getChargeAmount(){
        return chargeAmount;
    }

    /**
     * 设置属性计入赔款金额
     * @param sumRealPay 待设置的属性计入赔款金额的值
     */
    public void setSumRealPay(double sumRealPay){
        this.sumRealPay = sumRealPay;
    }

    /**
     * 获取属性计入赔款金额
     * @return 属性计入赔款金额的值
     */
    public double getSumRealPay(){
        return sumRealPay;
    }

    /**
     * 设置属性上报费用字段
     * @param chargeReport 待设置的属性上报费用字段的值
     */
    public void setChargeReport(double chargeReport){
        this.chargeReport = chargeReport;
    }

    /**
     * 获取属性上报费用字段
     * @return 属性上报费用字段的值
     */
    public double getChargeReport(){
        return chargeReport;
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
     * 设置属性录入时间
     * @param inputDate 待设置的属性录入时间的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性录入时间
     * @return 属性录入时间的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性费用信息标志
     * @param changeFlag 待设置的属性费用信息标志的值
     */
    public void setChangeFlag(String changeFlag){
        this.changeFlag = StringUtils.rightTrim(changeFlag);
    }

    /**
     * 获取属性费用信息标志
     * @return 属性费用信息标志的值
     */
    public String getChangeFlag(){
        return changeFlag;
    }

    /**
     * 设置属性支付对象类型
     * @param payObjectType 待设置的属性支付对象类型的值
     */
    public void setPayObjectType(String payObjectType){
        this.payObjectType = StringUtils.rightTrim(payObjectType);
    }

    /**
     * 获取属性支付对象类型
     * @return 属性支付对象类型的值
     */
    public String getPayObjectType(){
        return payObjectType;
    }

    /**
     * 设置属性支付对象代码
     * @param payObjectCode 待设置的属性支付对象代码的值
     */
    public void setPayObjectCode(String payObjectCode){
        this.payObjectCode = StringUtils.rightTrim(payObjectCode);
    }

    /**
     * 获取属性支付对象代码
     * @return 属性支付对象代码的值
     */
    public String getPayObjectCode(){
        return payObjectCode;
    }

    /**
     * 设置属性支付对象名称
     * @param payObjectName 待设置的属性支付对象名称的值
     */
    public void setPayObjectName(String payObjectName){
        this.payObjectName = StringUtils.rightTrim(payObjectName);
    }

    /**
     * 获取属性支付对象名称
     * @return 属性支付对象名称的值
     */
    public String getPayObjectName(){
        return payObjectName;
    }

	public int getItemkindno() {
		return itemkindno;
	}

	public void setItemkindno(int itemkindno) {
		this.itemkindno = itemkindno;
	}

	public String getCheckDeptCode() {
		return checkDeptCode;
	}

	public void setCheckDeptCode(String checkDeptCode) {
		this.checkDeptCode = checkDeptCode;
	}

	public String getCheckDeptName() {
		return checkDeptName;
	}

	public void setCheckDeptName(String checkDeptName) {
		this.checkDeptName = checkDeptName;
	}
    
    public double getPreChargeAmount() {
		return preChargeAmount;
	}

	public void setPreChargeAmount(double preChargeAmount) {
		this.preChargeAmount = preChargeAmount;
	}
}
