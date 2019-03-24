package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpgradeext岗位扩展表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGradeExtDtoBase implements Serializable{
    /** 属性岗位代码 */
    private String gradeCode = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性保额 */
    private double sumAmount = 0d;
    /** 属性主险费率 */
    private double rate = 0d;
    /** 属性赔款 */
    private double sumPaid = 0d;

    /**
     *  默认构造方法,构造一个默认的PrpGradeExtDtoBase对象
     */
    public PrpGradeExtDtoBase(){
    }

    /**
     * 设置属性岗位代码
     * @param gradeCode 待设置的属性岗位代码的值
     */
    public void setGradeCode(String gradeCode){
        this.gradeCode = StringUtils.rightTrim(gradeCode);
    }

    /**
     * 获取属性岗位代码
     * @return 属性岗位代码的值
     */
    public String getGradeCode(){
        return gradeCode;
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
     * 设置属性保额
     * @param sumAmount 待设置的属性保额的值
     */
    public void setSumAmount(double sumAmount){
        this.sumAmount = sumAmount;
    }

    /**
     * 获取属性保额
     * @return 属性保额的值
     */
    public double getSumAmount(){
        return sumAmount;
    }

    /**
     * 设置属性主险费率
     * @param rate 待设置的属性主险费率的值
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * 获取属性主险费率
     * @return 属性主险费率的值
     */
    public double getRate(){
        return rate;
    }

    /**
     * 设置属性赔款
     * @param sumPaid 待设置的属性赔款的值
     */
    public void setSumPaid(double sumPaid){
        this.sumPaid = sumPaid;
    }

    /**
     * 获取属性赔款
     * @return 属性赔款的值
     */
    public double getSumPaid(){
        return sumPaid;
    }
}
