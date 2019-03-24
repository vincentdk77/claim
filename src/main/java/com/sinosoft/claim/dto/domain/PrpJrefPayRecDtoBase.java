package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpjrefpayrec付费和收费联系记录表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJrefPayRecDtoBase implements Serializable{
    /** 属性保单号码/批单号码/赔款计算书号码 */
    private String certiNo = "";
    /** 属性本次付费序号 */
    private int serialNo = 0;
    /** 属性冲减交费标志 */
    private String payFlag = "";
    /** 属性收费序号 */
    private int order02No = 0;
    /** 属性交费计划期数 */
    private int payTimes = 0;

    /**
     *  默认构造方法,构造一个默认的PrpJrefPayRecDtoBase对象
     */
    public PrpJrefPayRecDtoBase(){
    }

    /**
     * 设置属性保单号码/批单号码/赔款计算书号码
     * @param certiNo 待设置的属性保单号码/批单号码/赔款计算书号码的值
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * 获取属性保单号码/批单号码/赔款计算书号码
     * @return 属性保单号码/批单号码/赔款计算书号码的值
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * 设置属性本次付费序号
     * @param serialNo 待设置的属性本次付费序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性本次付费序号
     * @return 属性本次付费序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性冲减交费标志
     * @param payFlag 待设置的属性冲减交费标志的值
     */
    public void setPayFlag(String payFlag){
        this.payFlag = StringUtils.rightTrim(payFlag);
    }

    /**
     * 获取属性冲减交费标志
     * @return 属性冲减交费标志的值
     */
    public String getPayFlag(){
        return payFlag;
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
     * 设置属性交费计划期数
     * @param payTimes 待设置的属性交费计划期数的值
     */
    public void setPayTimes(int payTimes){
        this.payTimes = payTimes;
    }

    /**
     * 获取属性交费计划期数
     * @return 属性交费计划期数的值
     */
    public int getPayTimes(){
        return payTimes;
    }
}
