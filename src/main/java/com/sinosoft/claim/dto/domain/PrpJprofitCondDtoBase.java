package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpjprofitcond优惠条件表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJprofitCondDtoBase implements Serializable{
    /** 属性保险单号次 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性优惠原因 */
    private String profitReason = "";
    /** 属性网上投保 */
    private String internetApply = "";
    /** 属性使用性质 */
    private String useNatureCode = "";
    /** 属性车种 */
    private String carKindCode = "";
    /** 属性续保情况 */
    private String renewalFlag = "";
    /** 属性优惠条件字段英文名称 */
    private String fieldEName = "";
    /** 属性优惠条件字段值 */
    private int fieldValue = 0;
    /** 属性优惠条件字段英文名称1 */
    private String fieldEName1 = "";
    /** 属性优惠条件字段值1 */
    private int fieldValue1 = 0;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpJprofitCondDtoBase对象
     */
    public PrpJprofitCondDtoBase(){
    }

    /**
     * 设置属性保险单号次
     * @param policyNo 待设置的属性保险单号次的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保险单号次
     * @return 属性保险单号次的值
     */
    public String getPolicyNo(){
        return policyNo;
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
     * 设置属性优惠原因
     * @param profitReason 待设置的属性优惠原因的值
     */
    public void setProfitReason(String profitReason){
        this.profitReason = StringUtils.rightTrim(profitReason);
    }

    /**
     * 获取属性优惠原因
     * @return 属性优惠原因的值
     */
    public String getProfitReason(){
        return profitReason;
    }

    /**
     * 设置属性网上投保
     * @param internetApply 待设置的属性网上投保的值
     */
    public void setInternetApply(String internetApply){
        this.internetApply = StringUtils.rightTrim(internetApply);
    }

    /**
     * 获取属性网上投保
     * @return 属性网上投保的值
     */
    public String getInternetApply(){
        return internetApply;
    }

    /**
     * 设置属性使用性质
     * @param useNatureCode 待设置的属性使用性质的值
     */
    public void setUseNatureCode(String useNatureCode){
        this.useNatureCode = StringUtils.rightTrim(useNatureCode);
    }

    /**
     * 获取属性使用性质
     * @return 属性使用性质的值
     */
    public String getUseNatureCode(){
        return useNatureCode;
    }

    /**
     * 设置属性车种
     * @param carKindCode 待设置的属性车种的值
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * 获取属性车种
     * @return 属性车种的值
     */
    public String getCarKindCode(){
        return carKindCode;
    }

    /**
     * 设置属性续保情况
     * @param renewalFlag 待设置的属性续保情况的值
     */
    public void setRenewalFlag(String renewalFlag){
        this.renewalFlag = StringUtils.rightTrim(renewalFlag);
    }

    /**
     * 获取属性续保情况
     * @return 属性续保情况的值
     */
    public String getRenewalFlag(){
        return renewalFlag;
    }

    /**
     * 设置属性优惠条件字段英文名称
     * @param fieldEName 待设置的属性优惠条件字段英文名称的值
     */
    public void setFieldEName(String fieldEName){
        this.fieldEName = StringUtils.rightTrim(fieldEName);
    }

    /**
     * 获取属性优惠条件字段英文名称
     * @return 属性优惠条件字段英文名称的值
     */
    public String getFieldEName(){
        return fieldEName;
    }

    /**
     * 设置属性优惠条件字段值
     * @param fieldValue 待设置的属性优惠条件字段值的值
     */
    public void setFieldValue(int fieldValue){
        this.fieldValue = fieldValue;
    }

    /**
     * 获取属性优惠条件字段值
     * @return 属性优惠条件字段值的值
     */
    public int getFieldValue(){
        return fieldValue;
    }

    /**
     * 设置属性优惠条件字段英文名称1
     * @param fieldEName1 待设置的属性优惠条件字段英文名称1的值
     */
    public void setFieldEName1(String fieldEName1){
        this.fieldEName1 = StringUtils.rightTrim(fieldEName1);
    }

    /**
     * 获取属性优惠条件字段英文名称1
     * @return 属性优惠条件字段英文名称1的值
     */
    public String getFieldEName1(){
        return fieldEName1;
    }

    /**
     * 设置属性优惠条件字段值1
     * @param fieldValue1 待设置的属性优惠条件字段值1的值
     */
    public void setFieldValue1(int fieldValue1){
        this.fieldValue1 = fieldValue1;
    }

    /**
     * 获取属性优惠条件字段值1
     * @return 属性优惠条件字段值1的值
     */
    public int getFieldValue1(){
        return fieldValue1;
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
