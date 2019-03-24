package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLafterward-案后费用处理表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.187<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLafterwardDtoBase implements Serializable{
    /** 属性赔案号 */
    private String claimNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性费用类别代码 */
    private String chargeCode = "";
    /** 属性费用名称 */
    private String chargeName = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性费用金额 */
    private double chargeAmount = 0d;
    /** 属性计入赔款金额 */
    private double sumRealPay = 0d;
    /** 属性处理日期 */
    private DateTime dealDate = new DateTime();
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLafterwardDtoBase对象
     */
    public PrpLafterwardDtoBase(){
    }

    /**
     * 设置属性赔案号
     * @param claimNo 待设置的属性赔案号的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号
     * @return 属性赔案号的值
     */
    public String getClaimNo(){
        return claimNo;
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
     * 设置属性费用类别代码
     * @param chargeCode 待设置的属性费用类别代码的值
     */
    public void setChargeCode(String chargeCode){
        this.chargeCode = StringUtils.rightTrim(chargeCode);
    }

    /**
     * 获取属性费用类别代码
     * @return 属性费用类别代码的值
     */
    public String getChargeCode(){
        return chargeCode;
    }

    /**
     * 设置属性费用名称
     * @param chargeName 待设置的属性费用名称的值
     */
    public void setChargeName(String chargeName){
        this.chargeName = StringUtils.rightTrim(chargeName);
    }

    /**
     * 获取属性费用名称
     * @return 属性费用名称的值
     */
    public String getChargeName(){
        return chargeName;
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
     * 设置属性费用金额
     * @param chargeAmount 待设置的属性费用金额的值
     */
    public void setChargeAmount(double chargeAmount){
        this.chargeAmount = chargeAmount;
    }

    /**
     * 获取属性费用金额
     * @return 属性费用金额的值
     */
    public double getChargeAmount(){
        return chargeAmount;
    }

    /**
     * 设置属性计入赔款金额
     * @param sumRealPay 待设置的属性计入赔款金额的值
     */
    public void setSumRealPay(double sumRealPay){
        this.sumRealPay = sumRealPay;
    }

    /**
     * 获取属性计入赔款金额
     * @return 属性计入赔款金额的值
     */
    public double getSumRealPay(){
        return sumRealPay;
    }

    /**
     * 设置属性处理日期
     * @param dealDate 待设置的属性处理日期的值
     */
    public void setDealDate(DateTime dealDate){
        this.dealDate = dealDate;
    }

    /**
     * 获取属性处理日期
     * @return 属性处理日期的值
     */
    public DateTime getDealDate(){
        return dealDate;
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
