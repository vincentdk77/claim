package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpjpayrefkind收付费险别分摊表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:06<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJpayRefKindDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性单证号 */
    private String certiNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性条款类别代码 */
    private String clauseType = "";
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性收付费原因代码（同收付费系统） */
    private String payReason = "";
    /** 属性应收付币别 */
    private String currency1 = "";
    /** 属性应收付金额 */
    private double payRefFee = 0d;
    /** 属性拖欠金额 */
    private double delinquentFee = 0d;
    /** 属性登记日期 */
    private DateTime inputDate = new DateTime();
    /** 属性实收付币别 */
    private String currency2 = "";
    /** 属性实收付金额 */
    private double realPayRefFee = 0d;
    /** 属性实收付日期 */
    private DateTime realPayRefDate = new DateTime();
    /** 属性归属机构 */
    private String comCode = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpJpayRefKindDtoBase对象
     */
    public PrpJpayRefKindDtoBase(){
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
     * 设置属性单证号
     * @param certiNo 待设置的属性单证号的值
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * 获取属性单证号
     * @return 属性单证号的值
     */
    public String getCertiNo(){
        return certiNo;
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
     * 设置属性条款类别代码
     * @param clauseType 待设置的属性条款类别代码的值
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * 获取属性条款类别代码
     * @return 属性条款类别代码的值
     */
    public String getClauseType(){
        return clauseType;
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
     * 设置属性收付费原因代码（同收付费系统）
     * @param payReason 待设置的属性收付费原因代码（同收付费系统）的值
     */
    public void setPayReason(String payReason){
        this.payReason = StringUtils.rightTrim(payReason);
    }

    /**
     * 获取属性收付费原因代码（同收付费系统）
     * @return 属性收付费原因代码（同收付费系统）的值
     */
    public String getPayReason(){
        return payReason;
    }

    /**
     * 设置属性应收付币别
     * @param currency1 待设置的属性应收付币别的值
     */
    public void setCurrency1(String currency1){
        this.currency1 = StringUtils.rightTrim(currency1);
    }

    /**
     * 获取属性应收付币别
     * @return 属性应收付币别的值
     */
    public String getCurrency1(){
        return currency1;
    }

    /**
     * 设置属性应收付金额
     * @param payRefFee 待设置的属性应收付金额的值
     */
    public void setPayRefFee(double payRefFee){
        this.payRefFee = payRefFee;
    }

    /**
     * 获取属性应收付金额
     * @return 属性应收付金额的值
     */
    public double getPayRefFee(){
        return payRefFee;
    }

    /**
     * 设置属性拖欠金额
     * @param delinquentFee 待设置的属性拖欠金额的值
     */
    public void setDelinquentFee(double delinquentFee){
        this.delinquentFee = delinquentFee;
    }

    /**
     * 获取属性拖欠金额
     * @return 属性拖欠金额的值
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
     * 设置属性实收付币别
     * @param currency2 待设置的属性实收付币别的值
     */
    public void setCurrency2(String currency2){
        this.currency2 = StringUtils.rightTrim(currency2);
    }

    /**
     * 获取属性实收付币别
     * @return 属性实收付币别的值
     */
    public String getCurrency2(){
        return currency2;
    }

    /**
     * 设置属性实收付金额
     * @param realPayRefFee 待设置的属性实收付金额的值
     */
    public void setRealPayRefFee(double realPayRefFee){
        this.realPayRefFee = realPayRefFee;
    }

    /**
     * 获取属性实收付金额
     * @return 属性实收付金额的值
     */
    public double getRealPayRefFee(){
        return realPayRefFee;
    }

    /**
     * 设置属性实收付日期
     * @param realPayRefDate 待设置的属性实收付日期的值
     */
    public void setRealPayRefDate(DateTime realPayRefDate){
        this.realPayRefDate = realPayRefDate;
    }

    /**
     * 获取属性实收付日期
     * @return 属性实收付日期的值
     */
    public DateTime getRealPayRefDate(){
        return realPayRefDate;
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
     * 设置属性标志位
     * @param flag 待设置的属性标志位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志位
     * @return 属性标志位的值
     */
    public String getFlag(){
        return flag;
    }
}
