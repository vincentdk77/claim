package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLscheduleCompany--调度中心提示信息设置表的数据传输对象基类<br>
 * 创建于 2005-11-07 11:11:19.031<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleCompanyDtoBase implements Serializable{
    /** 属性调度中心机构代码 */
    private String comCode = "";
    /** 属性上班时间 */
    private String onDutyTime = "";
    /** 属性下班时间 */
    private String offDutyTime = "";
    /** 属性提示信息 */
    private String promptContent = "";
    /** 属性固定电话 */
    private String phoneNo = "";
    /** 属性负责人 */
    private String linkerName = "";
    /** 属性手机号码 */
    private String mobileNo = "";
    /** 属性效力状态 */
    private String validStatus = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性标志 */
    private String flag = "";
    /** 属性am帐号 */
    private String amNo = "";

    /**
     *  默认构造方法,构造一个默认的PrpLscheduleCompanyDtoBase对象
     */
    public PrpLscheduleCompanyDtoBase(){
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
     * 设置属性上班时间
     * @param onDutyTime 待设置的属性上班时间的值
     */
    public void setOnDutyTime(String onDutyTime){
        this.onDutyTime = StringUtils.rightTrim(onDutyTime);
    }

    /**
     * 获取属性上班时间
     * @return 属性上班时间的值
     */
    public String getOnDutyTime(){
        return onDutyTime;
    }

    /**
     * 设置属性下班时间
     * @param offDutyTime 待设置的属性下班时间的值
     */
    public void setOffDutyTime(String offDutyTime){
        this.offDutyTime = StringUtils.rightTrim(offDutyTime);
    }

    /**
     * 获取属性下班时间
     * @return 属性下班时间的值
     */
    public String getOffDutyTime(){
        return offDutyTime;
    }

    /**
     * 设置属性提示信息
     * @param promptContent 待设置的属性提示信息的值
     */
    public void setPromptContent(String promptContent){
        this.promptContent = StringUtils.rightTrim(promptContent);
    }

    /**
     * 获取属性提示信息
     * @return 属性提示信息的值
     */
    public String getPromptContent(){
        return promptContent;
    }

    /**
     * 设置属性固定电话
     * @param phoneNo 待设置的属性固定电话的值
     */
    public void setPhoneNo(String phoneNo){
        this.phoneNo = StringUtils.rightTrim(phoneNo);
    }

    /**
     * 获取属性固定电话
     * @return 属性固定电话的值
     */
    public String getPhoneNo(){
        return phoneNo;
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
     * 设置属性效力状态
     * @param validStatus 待设置的属性效力状态的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性效力状态
     * @return 属性效力状态的值
     */
    public String getValidStatus(){
        return validStatus;
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
     * 设置属性am帐号
     * @param amNo 待设置的属性am帐号的值
     */
    public void setAmNo(String amNo){
        this.amNo = StringUtils.rightTrim(amNo);
    }

    /**
     * 获取属性am帐号
     * @return 属性am帐号的值
     */
    public String getAmNo(){
        return amNo;
    }
}
