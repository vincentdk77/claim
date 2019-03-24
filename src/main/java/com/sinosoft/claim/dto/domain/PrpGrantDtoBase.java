package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpgrant授权记录表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGrantDtoBase implements Serializable{
    /** 属性员工代码 */
    private String userCode = "";
    /** 属性授权险类 */
    private String riskType = "";
    /** 属性授权任务 */
    private String taskCode = "";
    /** 属性授权类型 */
    private String checkType = "";
    /** 属性授予权限 */
    private String power = "";
    /** 属性授权开始时限 */
    private DateTime grantStartDate = new DateTime();
    /** 属性授权终止时限 */
    private DateTime grantEndDate = new DateTime();
    /** 属性授权条件 */
    private String condition = "";
    /** 属性条件文字描述 */
    private String remark = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpGrantDtoBase对象
     */
    public PrpGrantDtoBase(){
    }

    /**
     * 设置属性员工代码
     * @param userCode 待设置的属性员工代码的值
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * 获取属性员工代码
     * @return 属性员工代码的值
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * 设置属性授权险类
     * @param riskType 待设置的属性授权险类的值
     */
    public void setRiskType(String riskType){
        this.riskType = StringUtils.rightTrim(riskType);
    }

    /**
     * 获取属性授权险类
     * @return 属性授权险类的值
     */
    public String getRiskType(){
        return riskType;
    }

    /**
     * 设置属性授权任务
     * @param taskCode 待设置的属性授权任务的值
     */
    public void setTaskCode(String taskCode){
        this.taskCode = StringUtils.rightTrim(taskCode);
    }

    /**
     * 获取属性授权任务
     * @return 属性授权任务的值
     */
    public String getTaskCode(){
        return taskCode;
    }

    /**
     * 设置属性授权类型
     * @param checkType 待设置的属性授权类型的值
     */
    public void setCheckType(String checkType){
        this.checkType = StringUtils.rightTrim(checkType);
    }

    /**
     * 获取属性授权类型
     * @return 属性授权类型的值
     */
    public String getCheckType(){
        return checkType;
    }

    /**
     * 设置属性授予权限
     * @param power 待设置的属性授予权限的值
     */
    public void setPower(String power){
        this.power = StringUtils.rightTrim(power);
    }

    /**
     * 获取属性授予权限
     * @return 属性授予权限的值
     */
    public String getPower(){
        return power;
    }

    /**
     * 设置属性授权开始时限
     * @param grantStartDate 待设置的属性授权开始时限的值
     */
    public void setGrantStartDate(DateTime grantStartDate){
        this.grantStartDate = grantStartDate;
    }

    /**
     * 获取属性授权开始时限
     * @return 属性授权开始时限的值
     */
    public DateTime getGrantStartDate(){
        return grantStartDate;
    }

    /**
     * 设置属性授权终止时限
     * @param grantEndDate 待设置的属性授权终止时限的值
     */
    public void setGrantEndDate(DateTime grantEndDate){
        this.grantEndDate = grantEndDate;
    }

    /**
     * 获取属性授权终止时限
     * @return 属性授权终止时限的值
     */
    public DateTime getGrantEndDate(){
        return grantEndDate;
    }

    /**
     * 设置属性授权条件
     * @param condition 待设置的属性授权条件的值
     */
    public void setCondition(String condition){
        this.condition = StringUtils.rightTrim(condition);
    }

    /**
     * 获取属性授权条件
     * @return 属性授权条件的值
     */
    public String getCondition(){
        return condition;
    }

    /**
     * 设置属性条件文字描述
     * @param remark 待设置的属性条件文字描述的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性条件文字描述
     * @return 属性条件文字描述的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性标志位
     * @param flag 待设置的属性标志位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志位
     * @return 属性标志位的值
     */
    public String getFlag(){
        return flag;
    }
}
