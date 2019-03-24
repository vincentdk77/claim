package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLhospitalizationPayFee的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLhospitalizationPayFeeDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性compensateNo */
    private String compensateNo = "";
    /** 属性unitType */
    private String unitType = "";
    /** 属性serialNo */
    private long serialNo = 0L;
    /** 属性feeType */
    private String feeType = "";
    /** 属性feeRate */
    private double feeRate = 0D;
    /** 属性fee */
    private double fee = 0D;
    /** 属性inputDate */
    private DateTime inputDate = new DateTime();
    /** 属性remark */
    private String remark = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLhospitalizationPayFeeDtoBase对象
     */
    public PrpLhospitalizationPayFeeDtoBase(){
    }

    /**
     * 设置属性compensateNo
     * @param compensateNo 待设置的属性compensateNo的值
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * 获取属性compensateNo
     * @return 属性compensateNo的值
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * 设置属性unitType
     * @param unitType 待设置的属性unitType的值
     */
    public void setUnitType(String unitType){
        this.unitType = StringUtils.rightTrim(unitType);
    }

    /**
     * 获取属性unitType
     * @return 属性unitType的值
     */
    public String getUnitType(){
        return unitType;
    }

    /**
     * 设置属性serialNo
     * @param serialNo 待设置的属性serialNo的值
     */
    public void setSerialNo(long serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性serialNo
     * @return 属性serialNo的值
     */
    public long getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性feeType
     * @param feeType 待设置的属性feeType的值
     */
    public void setFeeType(String feeType){
        this.feeType = StringUtils.rightTrim(feeType);
    }

    /**
     * 获取属性feeType
     * @return 属性feeType的值
     */
    public String getFeeType(){
        return feeType;
    }

    /**
     * 设置属性feeRate
     * @param feeRate 待设置的属性feeRate的值
     */
    public void setFeeRate(double feeRate){
        this.feeRate = feeRate;
    }

    /**
     * 获取属性feeRate
     * @return 属性feeRate的值
     */
    public double getFeeRate(){
        return feeRate;
    }

    /**
     * 设置属性fee
     * @param fee 待设置的属性fee的值
     */
    public void setFee(double fee){
        this.fee = fee;
    }

    /**
     * 获取属性fee
     * @return 属性fee的值
     */
    public double getFee(){
        return fee;
    }

    /**
     * 设置属性inputDate
     * @param inputDate 待设置的属性inputDate的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性inputDate
     * @return 属性inputDate的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性remark
     * @param remark 待设置的属性remark的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性remark
     * @return 属性remark的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public String getFlag(){
        return flag;
    }
}
