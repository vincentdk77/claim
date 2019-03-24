package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpjpaypatchrec批量收费登记表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJpayPatchRecDtoBase implements Serializable{
    /** 属性批量收费登记号 */
    private String payGroupNo = "";
    /** 属性保单号码/批单号码/赔款计算书号码 */
    private String certiNo = "";
    /** 属性本次收费序号 */
    private int serialNo = 0;

    /**
     *  默认构造方法,构造一个默认的PrpJpayPatchRecDtoBase对象
     */
    public PrpJpayPatchRecDtoBase(){
    }

    /**
     * 设置属性批量收费登记号
     * @param payGroupNo 待设置的属性批量收费登记号的值
     */
    public void setPayGroupNo(String payGroupNo){
        this.payGroupNo = StringUtils.rightTrim(payGroupNo);
    }

    /**
     * 获取属性批量收费登记号
     * @return 属性批量收费登记号的值
     */
    public String getPayGroupNo(){
        return payGroupNo;
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
     * 设置属性本次收费序号
     * @param serialNo 待设置的属性本次收费序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性本次收费序号
     * @return 属性本次收费序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }
}
