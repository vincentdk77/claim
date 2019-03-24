package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLJobLinker的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLJobLinkerDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性StaffId */
    private String staffId = "";
    /** 属性StaffPosition */
    private String staffPosition = "";
    /** 属性StaffUserCode */
    private String staffUserCode = "";
    /** 属性StaffName */
    private String staffName = "";
    /** 属性StaffPhone */
    private String staffPhone = "";
    /** 属性StaffType */
    private String staffType = "";
    /** 属性Handledept */
    private String handledept = "";
    /** 属性Month */
    private String month = "";
    /** 属性FlowinTime */
    private String flowinTime = "";
    /** 属性ModifyTime */
    private String modifyTime = "";
    /** 属性ClassCode */
    private String classCode = "";

    /**
     *  默认构造方法,构造一个默认的PrpLJobLinkerDtoBase对象
     */
    public PrpLJobLinkerDtoBase(){
    }

    /**
     * 设置属性StaffId
     * @param staffId 待设置的属性StaffId的值
     */
    public void setStaffId(String staffId){
        this.staffId = StringUtils.rightTrim(staffId);
    }

    /**
     * 获取属性StaffId
     * @return 属性StaffId的值
     */
    public String getStaffId(){
        return staffId;
    }

    /**
     * 设置属性StaffPosition
     * @param staffPosition 待设置的属性StaffPosition的值
     */
    public void setStaffPosition(String staffPosition){
        this.staffPosition = StringUtils.rightTrim(staffPosition);
    }

    /**
     * 获取属性StaffPosition
     * @return 属性StaffPosition的值
     */
    public String getStaffPosition(){
        return staffPosition;
    }

    /**
     * 设置属性StaffUserCode
     * @param staffUserCode 待设置的属性StaffUserCode的值
     */
    public void setStaffUserCode(String staffUserCode){
        this.staffUserCode = StringUtils.rightTrim(staffUserCode);
    }

    /**
     * 获取属性StaffUserCode
     * @return 属性StaffUserCode的值
     */
    public String getStaffUserCode(){
        return staffUserCode;
    }

    /**
     * 设置属性StaffName
     * @param staffName 待设置的属性StaffName的值
     */
    public void setStaffName(String staffName){
        this.staffName = StringUtils.rightTrim(staffName);
    }

    /**
     * 获取属性StaffName
     * @return 属性StaffName的值
     */
    public String getStaffName(){
        return staffName;
    }

    /**
     * 设置属性StaffPhone
     * @param staffPhone 待设置的属性StaffPhone的值
     */
    public void setStaffPhone(String staffPhone){
        this.staffPhone = StringUtils.rightTrim(staffPhone);
    }

    /**
     * 获取属性StaffPhone
     * @return 属性StaffPhone的值
     */
    public String getStaffPhone(){
        return staffPhone;
    }

    /**
     * 设置属性StaffType
     * @param staffType 待设置的属性StaffType的值
     */
    public void setStaffType(String staffType){
        this.staffType = StringUtils.rightTrim(staffType);
    }

    /**
     * 获取属性StaffType
     * @return 属性StaffType的值
     */
    public String getStaffType(){
        return staffType;
    }

    /**
     * 设置属性Handledept
     * @param handledept 待设置的属性Handledept的值
     */
    public void setHandledept(String handledept){
        this.handledept = StringUtils.rightTrim(handledept);
    }

    /**
     * 获取属性Handledept
     * @return 属性Handledept的值
     */
    public String getHandledept(){
        return handledept;
    }

    /**
     * 设置属性Month
     * @param month 待设置的属性Month的值
     */
    public void setMonth(String month){
        this.month = StringUtils.rightTrim(month);
    }

    /**
     * 获取属性Month
     * @return 属性Month的值
     */
    public String getMonth(){
        return month;
    }

    /**
     * 设置属性FlowinTime
     * @param flowinTime 待设置的属性FlowinTime的值
     */
    public void setFlowinTime(String flowinTime){
        this.flowinTime = StringUtils.rightTrim(flowinTime);
    }

    /**
     * 获取属性FlowinTime
     * @return 属性FlowinTime的值
     */
    public String getFlowinTime(){
        return flowinTime;
    }

    /**
     * 设置属性ModifyTime
     * @param modifyTime 待设置的属性ModifyTime的值
     */
    public void setModifyTime(String modifyTime){
        this.modifyTime = StringUtils.rightTrim(modifyTime);
    }

    /**
     * 获取属性ModifyTime
     * @return 属性ModifyTime的值
     */
    public String getModifyTime(){
        return modifyTime;
    }

    /**
     * 设置属性ClassCode
     * @param classCode 待设置的属性ClassCode的值
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * 获取属性ClassCode
     * @return 属性ClassCode的值
     */
    public String getClassCode(){
        return classCode;
    }
}
