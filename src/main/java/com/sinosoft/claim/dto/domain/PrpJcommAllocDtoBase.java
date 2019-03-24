package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpjcommalloc手续费分摊表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJcommAllocDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性分摊号 */
    private String allocNo = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性分摊序号 */
    private int serialNo = 0;
    /** 属性收付费原因代码 */
    private String payReason = "";
    /** 属性币种 */
    private String currency = "";
    /** 属性总手续费 */
    private double commission = 0d;
    /** 属性未摊手续费 */
    private double owCommission = 0d;
    /** 属性本次分摊保费金额 */
    private double allocFee = 0d;
    /** 属性分摊日期 */
    private DateTime allocDate = new DateTime();
    /** 属性transflag */
    private String transFlag = "";
    /** 属性归属机构代码 */
    private String comCode = "";
    /** 属性出单机构代码 */
    private String makeCom = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性登记日期 */
    private DateTime inputDate = new DateTime();
    /** 属性预留 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpJcommAllocDtoBase对象
     */
    public PrpJcommAllocDtoBase(){
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
     * 设置属性分摊号
     * @param allocNo 待设置的属性分摊号的值
     */
    public void setAllocNo(String allocNo){
        this.allocNo = StringUtils.rightTrim(allocNo);
    }

    /**
     * 获取属性分摊号
     * @return 属性分摊号的值
     */
    public String getAllocNo(){
        return allocNo;
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
     * 设置属性分摊序号
     * @param serialNo 待设置的属性分摊序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性分摊序号
     * @return 属性分摊序号的值
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
     * 设置属性总手续费
     * @param commission 待设置的属性总手续费的值
     */
    public void setCommission(double commission){
        this.commission = commission;
    }

    /**
     * 获取属性总手续费
     * @return 属性总手续费的值
     */
    public double getCommission(){
        return commission;
    }

    /**
     * 设置属性未摊手续费
     * @param owCommission 待设置的属性未摊手续费的值
     */
    public void setOwCommission(double owCommission){
        this.owCommission = owCommission;
    }

    /**
     * 获取属性未摊手续费
     * @return 属性未摊手续费的值
     */
    public double getOwCommission(){
        return owCommission;
    }

    /**
     * 设置属性本次分摊保费金额
     * @param allocFee 待设置的属性本次分摊保费金额的值
     */
    public void setAllocFee(double allocFee){
        this.allocFee = allocFee;
    }

    /**
     * 获取属性本次分摊保费金额
     * @return 属性本次分摊保费金额的值
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
     * 设置属性transflag
     * @param transFlag 待设置的属性transflag的值
     */
    public void setTransFlag(String transFlag){
        this.transFlag = StringUtils.rightTrim(transFlag);
    }

    /**
     * 获取属性transflag
     * @return 属性transflag的值
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
     * 设置属性预留
     * @param flag 待设置的属性预留的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性预留
     * @return 属性预留的值
     */
    public String getFlag(){
        return flag;
    }
}
