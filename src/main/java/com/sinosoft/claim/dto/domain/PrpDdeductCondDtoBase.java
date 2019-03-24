package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpDdeductCond-免赔条件表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpDdeductCondDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性险种 */
    private String riskCode = "";
    /** 属性条款类别 */
    private String clauseType = "";
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性免赔条件代码 */
    private String deductCondCode = "";
    /** 属性免赔条件名称 */
    private String deductCondName = "";
    /** 属性免赔率 */
    private double deductRate = 0D;
    /** 属性免赔额 */
    private double deductible = 0D;
    /** 属性启用日期 */
    private DateTime validDate = new DateTime();
    /** 属性标志位 */
    private String flag = "";
    /** 属性期数 */
    private String dEDUCTPERIOD = "";
    /** 属性开始计算绝对免赔率的出险次数 */
    private int baseTimes = 0;
    /** 属性封顶免赔率 */
    private double maxDeductRate = 0D;

    /**
     *  默认构造方法,构造一个默认的PrpDdeductCondDtoBase对象
     */
    public PrpDdeductCondDtoBase(){
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
     * 设置属性条款类别
     * @param clauseType 待设置的属性条款类别的值
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * 获取属性条款类别
     * @return 属性条款类别的值
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
     * 设置属性免赔条件代码
     * @param deductCondCode 待设置的属性免赔条件代码的值
     */
    public void setDeductCondCode(String deductCondCode){
        this.deductCondCode = StringUtils.rightTrim(deductCondCode);
    }

    /**
     * 获取属性免赔条件代码
     * @return 属性免赔条件代码的值
     */
    public String getDeductCondCode(){
        return deductCondCode;
    }

    /**
     * 设置属性免赔条件名称
     * @param deductCondName 待设置的属性免赔条件名称的值
     */
    public void setDeductCondName(String deductCondName){
        this.deductCondName = StringUtils.rightTrim(deductCondName);
    }

    /**
     * 获取属性免赔条件名称
     * @return 属性免赔条件名称的值
     */
    public String getDeductCondName(){
        return deductCondName;
    }

    /**
     * 设置属性免赔率
     * @param deductRate 待设置的属性免赔率的值
     */
    public void setDeductRate(double deductRate){
        this.deductRate = deductRate;
    }

    /**
     * 获取属性免赔率
     * @return 属性免赔率的值
     */
    public double getDeductRate(){
        return deductRate;
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
     * 设置属性启用日期
     * @param validDate 待设置的属性启用日期的值
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * 获取属性启用日期
     * @return 属性启用日期的值
     */
    public DateTime getValidDate(){
        return validDate;
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

    /**
     * 设置属性期数
     * @param dEDUCTPERIOD 待设置的属性期数的值
     */
    public void setDEDUCTPERIOD(String dEDUCTPERIOD){
        this.dEDUCTPERIOD = StringUtils.rightTrim(dEDUCTPERIOD);
    }

    /**
     * 获取属性期数
     * @return 属性期数的值
     */
    public String getDEDUCTPERIOD(){
        return dEDUCTPERIOD;
    }

    /**
     * 设置属性开始计算绝对免赔率的出险次数
     * @param baseTimes 待设置的属性开始计算绝对免赔率的出险次数的值
     */
    public void setBaseTimes(int baseTimes){
        this.baseTimes = baseTimes;
    }

    /**
     * 获取属性开始计算绝对免赔率的出险次数
     * @return 属性开始计算绝对免赔率的出险次数的值
     */
    public int getBaseTimes(){
        return baseTimes;
    }

    /**
     * 设置属性封顶免赔率
     * @param maxDeductRate 待设置的属性封顶免赔率的值
     */
    public void setMaxDeductRate(double maxDeductRate){
        this.maxDeductRate = maxDeductRate;
    }

    /**
     * 获取属性封顶免赔率
     * @return 属性封顶免赔率的值
     */
    public double getMaxDeductRate(){
        return maxDeductRate;
    }
}
