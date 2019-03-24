package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLassureDetail-担保函明细（船舶）的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.500<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLassureDetailDtoBase implements Serializable{
    /** 属性担保号 */
    private String assureNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性提单号 */
    private String ladingNo = "";
    /** 属性货物名称 */
    private String goodsDetailName = "";
    /** 属性标记 */
    private String marks = "";
    /** 属性数量 */
    private String count = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性Amount */
    private double amount = 0d;

    /**
     *  默认构造方法,构造一个默认的PrpLassureDetailDtoBase对象
     */
    public PrpLassureDetailDtoBase(){
    }

    /**
     * 设置属性担保号
     * @param assureNo 待设置的属性担保号的值
     */
    public void setAssureNo(String assureNo){
        this.assureNo = StringUtils.rightTrim(assureNo);
    }

    /**
     * 获取属性担保号
     * @return 属性担保号的值
     */
    public String getAssureNo(){
        return assureNo;
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
     * 设置属性提单号
     * @param ladingNo 待设置的属性提单号的值
     */
    public void setLadingNo(String ladingNo){
        this.ladingNo = StringUtils.rightTrim(ladingNo);
    }

    /**
     * 获取属性提单号
     * @return 属性提单号的值
     */
    public String getLadingNo(){
        return ladingNo;
    }

    /**
     * 设置属性货物名称
     * @param goodsDetailName 待设置的属性货物名称的值
     */
    public void setGoodsDetailName(String goodsDetailName){
        this.goodsDetailName = StringUtils.rightTrim(goodsDetailName);
    }

    /**
     * 获取属性货物名称
     * @return 属性货物名称的值
     */
    public String getGoodsDetailName(){
        return goodsDetailName;
    }

    /**
     * 设置属性标记
     * @param marks 待设置的属性标记的值
     */
    public void setMarks(String marks){
        this.marks = StringUtils.rightTrim(marks);
    }

    /**
     * 获取属性标记
     * @return 属性标记的值
     */
    public String getMarks(){
        return marks;
    }

    /**
     * 设置属性数量
     * @param count 待设置的属性数量的值
     */
    public void setCount(String count){
        this.count = StringUtils.rightTrim(count);
    }

    /**
     * 获取属性数量
     * @return 属性数量的值
     */
    public String getCount(){
        return count;
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
     * 设置属性Amount
     * @param amount 待设置的属性Amount的值
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * 获取属性Amount
     * @return 属性Amount的值
     */
    public double getAmount(){
        return amount;
    }
}
