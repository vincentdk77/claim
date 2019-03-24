package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLscheduleCompanyMobile--调度中心电话表的数据传输对象基类<br>
 * 创建于 2005-09-22 17:24:48.058<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleCompanyMobileDtoBase implements Serializable{
    /** 属性调度中心机构代码 */
    private String comCode = "";
    /** 属性序列号码 */
    private int serialNo = 0;
    /** 属性手机号码 */
    private String mobileNo = "";
    /** 属性负责人 */
    private String linkerName = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性标志 */
    private String flag = "";
    /** 属性值班星期 */
    private String onDutyDay = "";

    /**
     *  默认构造方法,构造一个默认的PrpLscheduleCompanyMobileDtoBase对象
     */
    public PrpLscheduleCompanyMobileDtoBase(){
    }

    /**
     * 设置属性调度中心机构代码
     * @param comCode 待设置的属性调度中心机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性调度中心机构代码
     * @return 属性调度中心机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性序列号码
     * @param serialNo 待设置的属性序列号码的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序列号码
     * @return 属性序列号码的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性手机号码
     * @param mobileNo 待设置的属性手机号码的值
     */
    public void setMobileNo(String mobileNo){
        this.mobileNo = StringUtils.rightTrim(mobileNo);
    }

    /**
     * 获取属性手机号码
     * @return 属性手机号码的值
     */
    public String getMobileNo(){
        return mobileNo;
    }

    /**
     * 设置属性负责人
     * @param linkerName 待设置的属性负责人的值
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * 获取属性负责人
     * @return 属性负责人的值
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * 设置属性备注
     * @param remark 待设置的属性备注的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性标志
     * @param flag 待设置的属性标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志
     * @return 属性标志的值
     */
    public String getFlag(){
        return flag;
    }

    /**
     * 设置属性值班星期
     * @param onDutyDay 待设置的属性值班星期的值
     */
    public void setOnDutyDay(String onDutyDay){
        this.onDutyDay = StringUtils.rightTrim(onDutyDay);
    }

    /**
     * 获取属性值班星期
     * @return 属性值班星期的值
     */
    public String getOnDutyDay(){
        return onDutyDay;
    }
}
