package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdpersonpay交通事故损害赔偿计算标准表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDpersonPayDtoBase implements Serializable{
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性赔偿项目代码 */
    private String payItemCode = "";
    /** 属性出险地区代码 */
    private String damageAreaCode = "";
    /** 属性行业代码 */
    private String businessSource = "";
    /** 属性标准金额 */
    private double standardFee = 0d;
    /** 属性发布日期 */
    private DateTime issueDate = new DateTime();
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDpersonPayDtoBase对象
     */
    public PrpDpersonPayDtoBase(){
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
     * 设置属性赔偿项目代码
     * @param payItemCode 待设置的属性赔偿项目代码的值
     */
    public void setPayItemCode(String payItemCode){
        this.payItemCode = StringUtils.rightTrim(payItemCode);
    }

    /**
     * 获取属性赔偿项目代码
     * @return 属性赔偿项目代码的值
     */
    public String getPayItemCode(){
        return payItemCode;
    }

    /**
     * 设置属性出险地区代码
     * @param damageAreaCode 待设置的属性出险地区代码的值
     */
    public void setDamageAreaCode(String damageAreaCode){
        this.damageAreaCode = StringUtils.rightTrim(damageAreaCode);
    }

    /**
     * 获取属性出险地区代码
     * @return 属性出险地区代码的值
     */
    public String getDamageAreaCode(){
        return damageAreaCode;
    }

    /**
     * 设置属性行业代码
     * @param businessSource 待设置的属性行业代码的值
     */
    public void setBusinessSource(String businessSource){
        this.businessSource = StringUtils.rightTrim(businessSource);
    }

    /**
     * 获取属性行业代码
     * @return 属性行业代码的值
     */
    public String getBusinessSource(){
        return businessSource;
    }

    /**
     * 设置属性标准金额
     * @param standardFee 待设置的属性标准金额的值
     */
    public void setStandardFee(double standardFee){
        this.standardFee = standardFee;
    }

    /**
     * 获取属性标准金额
     * @return 属性标准金额的值
     */
    public double getStandardFee(){
        return standardFee;
    }

    /**
     * 设置属性发布日期
     * @param issueDate 待设置的属性发布日期的值
     */
    public void setIssueDate(DateTime issueDate){
        this.issueDate = issueDate;
    }

    /**
     * 获取属性发布日期
     * @return 属性发布日期的值
     */
    public DateTime getIssueDate(){
        return issueDate;
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
