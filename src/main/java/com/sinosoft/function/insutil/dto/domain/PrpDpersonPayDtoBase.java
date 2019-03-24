package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdpersonpay的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDpersonPayDtoBase implements Serializable{
    /** 属性serialno */
    private int serialNo = 0;
    /** 属性payitemcode */
    private String payItemCode = "";
    /** 属性damageareacode */
    private String damageAreaCode = "";
    /** 属性businesssource */
    private String businessSource = "";
    /** 属性standardfee */
    private double standardFee = 0d;
    /** 属性issuedate */
    private DateTime issueDate = new DateTime();
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDpersonPayDtoBase对象
     */
    public PrpDpersonPayDtoBase(){
    }

    /**
     * 设置属性serialno
     * @param serialNo 待设置的属性serialno的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性serialno
     * @return 属性serialno的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性payitemcode
     * @param payItemCode 待设置的属性payitemcode的值
     */
    public void setPayItemCode(String payItemCode){
        this.payItemCode = StringUtils.rightTrim(payItemCode);
    }

    /**
     * 获取属性payitemcode
     * @return 属性payitemcode的值
     */
    public String getPayItemCode(){
        return payItemCode;
    }

    /**
     * 设置属性damageareacode
     * @param damageAreaCode 待设置的属性damageareacode的值
     */
    public void setDamageAreaCode(String damageAreaCode){
        this.damageAreaCode = StringUtils.rightTrim(damageAreaCode);
    }

    /**
     * 获取属性damageareacode
     * @return 属性damageareacode的值
     */
    public String getDamageAreaCode(){
        return damageAreaCode;
    }

    /**
     * 设置属性businesssource
     * @param businessSource 待设置的属性businesssource的值
     */
    public void setBusinessSource(String businessSource){
        this.businessSource = StringUtils.rightTrim(businessSource);
    }

    /**
     * 获取属性businesssource
     * @return 属性businesssource的值
     */
    public String getBusinessSource(){
        return businessSource;
    }

    /**
     * 设置属性standardfee
     * @param standardFee 待设置的属性standardfee的值
     */
    public void setStandardFee(double standardFee){
        this.standardFee = standardFee;
    }

    /**
     * 获取属性standardfee
     * @return 属性standardfee的值
     */
    public double getStandardFee(){
        return standardFee;
    }

    /**
     * 设置属性issuedate
     * @param issueDate 待设置的属性issuedate的值
     */
    public void setIssueDate(DateTime issueDate){
        this.issueDate = issueDate;
    }

    /**
     * 获取属性issuedate
     * @return 属性issuedate的值
     */
    public DateTime getIssueDate(){
        return issueDate;
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
