package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLdeductCond-计算书免赔条件表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLdeductCondDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性计算书号 */
    private String compensateNo = "";
    /** 属性免赔条件代码 */
    private String deductCondCode = "";
    /** 属性免赔条件名称 */
    private String deductCondName = "";
    /** 属性用户输入的出险次数或单证个数 */
    private int times = 0;

    /**
     *  默认构造方法,构造一个默认的PrpLdeductCondDtoBase对象
     */
    public PrpLdeductCondDtoBase(){
    }

    /**
     * 设置属性计算书号
     * @param compensateNo 待设置的属性计算书号的值
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * 获取属性计算书号
     * @return 属性计算书号的值
     */
    public String getCompensateNo(){
        return compensateNo;
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
     * 设置属性用户输入的出险次数或单证个数
     * @param times 待设置的属性用户输入的出险次数或单证个数的值
     */
    public void setTimes(int times){
        this.times = times;
    }

    /**
     * 获取属性用户输入的出险次数或单证个数
     * @return 属性用户输入的出险次数或单证个数的值
     */
    public int getTimes(){
        return times;
    }
}
