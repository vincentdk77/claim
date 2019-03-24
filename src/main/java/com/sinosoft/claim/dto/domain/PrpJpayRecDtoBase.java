package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpjpayrec收费登记表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJpayRecDtoBase implements Serializable{
    /** 属性险种 */
    private String riskCode = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性保单号码/批单号码 */
    private String certiNo = "";
    /** 属性收费序号 */
    private int order02No = 0;
    /** 属性收费计划对应的序号 */
    private int serialNo = 0;
    /** 属性优惠退费序号 */
    private int profitNo = 0;
    /** 属性收费原因代码 */
    private String payReason = "";
    /** 属性应收币种 */
    private String currency1 = "";
    /** 属性应收金额 */
    private double payFee = 0d;
    /** 属性未付金额 */
    private double delinquentFee = 0d;
    /** 属性登记日期 */
    private DateTime inputDate = new DateTime();
    /** 属性成功转入收付系统标志 */
    private String transFlag = "";
    /** 属性实收币种 */
    private String currency2 = "";
    /** 属性实收金额 */
    private double realPayFee = 0d;
    /** 属性实收日期 */
    private DateTime realPayDate = new DateTime();
    /** 属性归属机构 */
    private String comCode = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性预留标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpJpayRecDtoBase对象
     */
    public PrpJpayRecDtoBase(){
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
     * 设置属性保单号码/批单号码
     * @param certiNo 待设置的属性保单号码/批单号码的值
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * 获取属性保单号码/批单号码
     * @return 属性保单号码/批单号码的值
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * 设置属性收费序号
     * @param order02No 待设置的属性收费序号的值
     */
    public void setOrder02No(int order02No){
        this.order02No = order02No;
    }

    /**
     * 获取属性收费序号
     * @return 属性收费序号的值
     */
    public int getOrder02No(){
        return order02No;
    }

    /**
     * 设置属性收费计划对应的序号
     * @param serialNo 待设置的属性收费计划对应的序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性收费计划对应的序号
     * @return 属性收费计划对应的序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性优惠退费序号
     * @param profitNo 待设置的属性优惠退费序号的值
     */
    public void setProfitNo(int profitNo){
        this.profitNo = profitNo;
    }

    /**
     * 获取属性优惠退费序号
     * @return 属性优惠退费序号的值
     */
    public int getProfitNo(){
        return profitNo;
    }

    /**
     * 设置属性收费原因代码
     * @param payReason 待设置的属性收费原因代码的值
     */
    public void setPayReason(String payReason){
        this.payReason = StringUtils.rightTrim(payReason);
    }

    /**
     * 获取属性收费原因代码
     * @return 属性收费原因代码的值
     */
    public String getPayReason(){
        return payReason;
    }

    /**
     * 设置属性应收币种
     * @param currency1 待设置的属性应收币种的值
     */
    public void setCurrency1(String currency1){
        this.currency1 = StringUtils.rightTrim(currency1);
    }

    /**
     * 获取属性应收币种
     * @return 属性应收币种的值
     */
    public String getCurrency1(){
        return currency1;
    }

    /**
     * 设置属性应收金额
     * @param payFee 待设置的属性应收金额的值
     */
    public void setPayFee(double payFee){
        this.payFee = payFee;
    }

    /**
     * 获取属性应收金额
     * @return 属性应收金额的值
     */
    public double getPayFee(){
        return payFee;
    }

    /**
     * 设置属性未付金额
     * @param delinquentFee 待设置的属性未付金额的值
     */
    public void setDelinquentFee(double delinquentFee){
        this.delinquentFee = delinquentFee;
    }

    /**
     * 获取属性未付金额
     * @return 属性未付金额的值
     */
    public double getDelinquentFee(){
        return delinquentFee;
    }

    /**
     * 设置属性登记日期
     * @param inputDate 待设置的属性登记日期的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性登记日期
     * @return 属性登记日期的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性成功转入收付系统标志
     * @param transFlag 待设置的属性成功转入收付系统标志的值
     */
    public void setTransFlag(String transFlag){
        this.transFlag = StringUtils.rightTrim(transFlag);
    }

    /**
     * 获取属性成功转入收付系统标志
     * @return 属性成功转入收付系统标志的值
     */
    public String getTransFlag(){
        return transFlag;
    }

    /**
     * 设置属性实收币种
     * @param currency2 待设置的属性实收币种的值
     */
    public void setCurrency2(String currency2){
        this.currency2 = StringUtils.rightTrim(currency2);
    }

    /**
     * 获取属性实收币种
     * @return 属性实收币种的值
     */
    public String getCurrency2(){
        return currency2;
    }

    /**
     * 设置属性实收金额
     * @param realPayFee 待设置的属性实收金额的值
     */
    public void setRealPayFee(double realPayFee){
        this.realPayFee = realPayFee;
    }

    /**
     * 获取属性实收金额
     * @return 属性实收金额的值
     */
    public double getRealPayFee(){
        return realPayFee;
    }

    /**
     * 设置属性实收日期
     * @param realPayDate 待设置的属性实收日期的值
     */
    public void setRealPayDate(DateTime realPayDate){
        this.realPayDate = realPayDate;
    }

    /**
     * 获取属性实收日期
     * @return 属性实收日期的值
     */
    public DateTime getRealPayDate(){
        return realPayDate;
    }

    /**
     * 设置属性归属机构
     * @param comCode 待设置的属性归属机构的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性归属机构
     * @return 属性归属机构的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性操作员代码
     * @param operatorCode 待设置的属性操作员代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性操作员代码
     * @return 属性操作员代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性预留标志
     * @param flag 待设置的属性预留标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性预留标志
     * @return 属性预留标志的值
     */
    public String getFlag(){
        return flag;
    }
}
