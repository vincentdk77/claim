package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpgrant的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGrantDtoBase implements Serializable{
    /** 属性usercode */
    private String userCode = "";
    /** 属性groupcode */
    private String groupCode = "";
    /** 属性taskcode */
    private String taskCode = "";
    /** 属性checkcode */
    private String checkCode = "";
    /** 属性value */
    private String value = "";
    /** 属性grantstartdate */
    private DateTime grantStartDate = new DateTime();
    /** 属性grantenddate */
    private DateTime grantEndDate = new DateTime();
    /** 属性condition */
    private String condition = "";
    /** 属性remark */
    private String remark = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpGrantDtoBase对象
     */
    public PrpGrantDtoBase(){
    }

    /**
     * 设置属性usercode
     * @param userCode 待设置的属性usercode的值
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * 获取属性usercode
     * @return 属性usercode的值
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * 设置属性groupcode
     * @param groupCode 待设置的属性groupcode的值
     */
    public void setGroupCode(String groupCode){
        this.groupCode = StringUtils.rightTrim(groupCode);
    }

    /**
     * 获取属性groupcode
     * @return 属性groupcode的值
     */
    public String getGroupCode(){
        return groupCode;
    }

    /**
     * 设置属性taskcode
     * @param taskCode 待设置的属性taskcode的值
     */
    public void setTaskCode(String taskCode){
        this.taskCode = StringUtils.rightTrim(taskCode);
    }

    /**
     * 获取属性taskcode
     * @return 属性taskcode的值
     */
    public String getTaskCode(){
        return taskCode;
    }

    /**
     * 设置属性checkcode
     * @param checkCode 待设置的属性checkcode的值
     */
    public void setCheckCode(String checkCode){
        this.checkCode = StringUtils.rightTrim(checkCode);
    }

    /**
     * 获取属性checkcode
     * @return 属性checkcode的值
     */
    public String getCheckCode(){
        return checkCode;
    }

    /**
     * 设置属性value
     * @param value 待设置的属性value的值
     */
    public void setValue(String value){
        this.value = StringUtils.rightTrim(value);
    }

    /**
     * 获取属性value
     * @return 属性value的值
     */
    public String getValue(){
        return value;
    }

    /**
     * 设置属性grantstartdate
     * @param grantStartDate 待设置的属性grantstartdate的值
     */
    public void setGrantStartDate(DateTime grantStartDate){
        this.grantStartDate = grantStartDate;
    }

    /**
     * 获取属性grantstartdate
     * @return 属性grantstartdate的值
     */
    public DateTime getGrantStartDate(){
        return grantStartDate;
    }

    /**
     * 设置属性grantenddate
     * @param grantEndDate 待设置的属性grantenddate的值
     */
    public void setGrantEndDate(DateTime grantEndDate){
        this.grantEndDate = grantEndDate;
    }

    /**
     * 获取属性grantenddate
     * @return 属性grantenddate的值
     */
    public DateTime getGrantEndDate(){
        return grantEndDate;
    }

    /**
     * 设置属性condition
     * @param condition 待设置的属性condition的值
     */
    public void setCondition(String condition){
        this.condition = StringUtils.rightTrim(condition);
    }

    /**
     * 获取属性condition
     * @return 属性condition的值
     */
    public String getCondition(){
        return condition;
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
