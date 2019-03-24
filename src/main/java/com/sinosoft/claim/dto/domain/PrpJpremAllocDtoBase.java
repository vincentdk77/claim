package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpjpremalloc长期险业务保费分摊表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJpremAllocDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性分摊号码 */
    private String allocNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性收付费原因代码 */
    private String payReason = "";
    /** 属性币种 */
    private String currency = "";
    /** 属性总保费 */
    private double sumPremium = 0d;
    /** 属性剩余未分摊保费 */
    private double prePremium = 0d;
    /** 属性本次分摊保费 */
    private double allocPremium = 0d;
    /** 属性分摊金额 */
    private double allocFee = 0d;
    /** 属性分摊日期 */
    private DateTime allocDate = new DateTime();
    /** 属性成功转入收付系统标志 */
    private String transFlag = "";
    /** 属性归属机构代码 */
    private String comCode = "";
    /** 属性出单机构代码 */
    private String makeCom = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性登记日期 */
    private DateTime inputDate = new DateTime();
    /** 属性预留标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpJpremAllocDtoBase对象
     */
    public PrpJpremAllocDtoBase(){
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
     * 设置属性分摊号码
     * @param allocNo 待设置的属性分摊号码的值
     */
    public void setAllocNo(String allocNo){
        this.allocNo = StringUtils.rightTrim(allocNo);
    }

    /**
     * 获取属性分摊号码
     * @return 属性分摊号码的值
     */
    public String getAllocNo(){
        return allocNo;
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
     * 设置属性收付费原因代码
     * @param payReason 待设置的属性收付费原因代码的值
     */
    public void setPayReason(String payReason){
        this.payReason = StringUtils.rightTrim(payReason);
    }

    /**
     * 获取属性收付费原因代码
     * @return 属性收付费原因代码的值
     */
    public String getPayReason(){
        return payReason;
    }

    /**
     * 设置属性币种
     * @param currency 待设置的属性币种的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币种
     * @return 属性币种的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性总保费
     * @param sumPremium 待设置的属性总保费的值
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * 获取属性总保费
     * @return 属性总保费的值
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * 设置属性剩余未分摊保费
     * @param prePremium 待设置的属性剩余未分摊保费的值
     */
    public void setPrePremium(double prePremium){
        this.prePremium = prePremium;
    }

    /**
     * 获取属性剩余未分摊保费
     * @return 属性剩余未分摊保费的值
     */
    public double getPrePremium(){
        return prePremium;
    }

    /**
     * 设置属性本次分摊保费
     * @param allocPremium 待设置的属性本次分摊保费的值
     */
    public void setAllocPremium(double allocPremium){
        this.allocPremium = allocPremium;
    }

    /**
     * 获取属性本次分摊保费
     * @return 属性本次分摊保费的值
     */
    public double getAllocPremium(){
        return allocPremium;
    }

    /**
     * 设置属性分摊金额
     * @param allocFee 待设置的属性分摊金额的值
     */
    public void setAllocFee(double allocFee){
        this.allocFee = allocFee;
    }

    /**
     * 获取属性分摊金额
     * @return 属性分摊金额的值
     */
    public double getAllocFee(){
        return allocFee;
    }

    /**
     * 设置属性分摊日期
     * @param allocDate 待设置的属性分摊日期的值
     */
    public void setAllocDate(DateTime allocDate){
        this.allocDate = allocDate;
    }

    /**
     * 获取属性分摊日期
     * @return 属性分摊日期的值
     */
    public DateTime getAllocDate(){
        return allocDate;
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
     * 设置属性归属机构代码
     * @param comCode 待设置的属性归属机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性归属机构代码
     * @return 属性归属机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性出单机构代码
     * @param makeCom 待设置的属性出单机构代码的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性出单机构代码
     * @return 属性出单机构代码的值
     */
    public String getMakeCom(){
        return makeCom;
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
