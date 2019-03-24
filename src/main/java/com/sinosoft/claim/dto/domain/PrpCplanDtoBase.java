package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpcplan收费计划表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCplanDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性批单号码 */
    private String endorseNo = "";
    /** 属性交费次数序号 */
    private int serialNo = 0;
    /** 属性交费期次 */
    private int payNo = 0;
    /** 属性交费原因 */
    private String payReason = "";
    /** 属性计划交费截止日期 */
    private DateTime planDate = new DateTime();
    /** 属性币别 */
    private String currency = "";
    /** 属性应交费金额 */
    private double planFee = 0d;
    /** 属性拖欠金额 */
    private double delinquentFee = 0d;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCplanDtoBase对象
     */
    public PrpCplanDtoBase(){
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
     * 设置属性交费次数序号
     * @param serialNo 待设置的属性交费次数序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性交费次数序号
     * @return 属性交费次数序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性交费期次
     * @param payNo 待设置的属性交费期次的值
     */
    public void setPayNo(int payNo){
        this.payNo = payNo;
    }

    /**
     * 获取属性交费期次
     * @return 属性交费期次的值
     */
    public int getPayNo(){
        return payNo;
    }

    /**
     * 设置属性交费原因
     * @param payReason 待设置的属性交费原因的值
     */
    public void setPayReason(String payReason){
        this.payReason = StringUtils.rightTrim(payReason);
    }

    /**
     * 获取属性交费原因
     * @return 属性交费原因的值
     */
    public String getPayReason(){
        return payReason;
    }

    /**
     * 设置属性计划交费截止日期
     * @param planDate 待设置的属性计划交费截止日期的值
     */
    public void setPlanDate(DateTime planDate){
        this.planDate = planDate;
    }

    /**
     * 获取属性计划交费截止日期
     * @return 属性计划交费截止日期的值
     */
    public DateTime getPlanDate(){
        return planDate;
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
     * 设置属性应交费金额
     * @param planFee 待设置的属性应交费金额的值
     */
    public void setPlanFee(double planFee){
        this.planFee = planFee;
    }

    /**
     * 获取属性应交费金额
     * @return 属性应交费金额的值
     */
    public double getPlanFee(){
        return planFee;
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
