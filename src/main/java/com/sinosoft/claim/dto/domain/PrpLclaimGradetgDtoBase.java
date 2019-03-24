package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLclaimGrade--理赔业务权限表(新增)的数据传输对象基类<br>
 * 创建于 2005-04-19 09:24:18.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLclaimGradetgDtoBase implements Serializable{
    /** 属性员工代码 */
    private String userCode = "";
    /** 属性员工名称 */
    private String userName = "";
    /** 属性任务代码 */
    private String taskCode = "";
    /** 属性业务归属机构代码 */
    private String comCode = "";
    /** 属性权限级别 */
    private String claimLevel = "";
    /** 属性金额下限 */
    private double valueLower = 0d;
    /** 属性金额上限 */
    private double valueUpper = 0d;
    /** 属性比例 */
    private double rate = 0d;
    /** 属性效力状态(0失效/1有效) */
    private String validStatus = "";
    /** 属性标志字段 */
    private String flag = "";

    /** 属性CONFIGPARA */
    private String configPara = "";
    /** 属性CONFIGDESC */
    private String configDesc = "";
    
    /**
     *  默认构造方法,构造一个默认的PrpLclaimGradetgDtoBase对象
     */
    public PrpLclaimGradetgDtoBase(){
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
     * 设置属性员工名称
     * @param userName 待设置的属性员工名称的值
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * 获取属性员工名称
     * @return 属性员工名称的值
     */
    public String getUserName(){
        return userName;
    }

    /**
     * 设置属性任务代码
     * @param taskCode 待设置的属性任务代码的值
     */
    public void setTaskCode(String taskCode){
        this.taskCode = StringUtils.rightTrim(taskCode);
    }

    /**
     * 获取属性任务代码
     * @return 属性任务代码的值
     */
    public String getTaskCode(){
        return taskCode;
    }

    /**
     * 设置属性业务归属机构代码
     * @param comCode 待设置的属性业务归属机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性业务归属机构代码
     * @return 属性业务归属机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性权限级别
     * @param claimLevel 待设置的属性权限级别的值
     */
    public void setClaimLevel(String claimLevel){
        this.claimLevel = StringUtils.rightTrim(claimLevel);
    }

    /**
     * 获取属性权限级别
     * @return 属性权限级别的值
     */
    public String getClaimLevel(){
        return claimLevel;
    }

    /**
     * 设置属性金额下限
     * @param valueLower 待设置的属性金额下限的值
     */
    public void setValueLower(double valueLower){
        this.valueLower = valueLower;
    }

    /**
     * 获取属性金额下限
     * @return 属性金额下限的值
     */
    public double getValueLower(){
        return valueLower;
    }

    /**
     * 设置属性金额上限
     * @param valueUpper 待设置的属性金额上限的值
     */
    public void setValueUpper(double valueUpper){
        this.valueUpper = valueUpper;
    }

    /**
     * 获取属性金额上限
     * @return 属性金额上限的值
     */
    public double getValueUpper(){
        return valueUpper;
    }

    /**
     * 设置属性比例
     * @param rate 待设置的属性比例的值
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * 获取属性比例
     * @return 属性比例的值
     */
    public double getRate(){
        return rate;
    }

    /**
     * 设置属性效力状态(0失效/1有效)
     * @param validStatus 待设置的属性效力状态(0失效/1有效)的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性效力状态(0失效/1有效)
     * @return 属性效力状态(0失效/1有效)的值
     */
    public String getValidStatus(){
        return validStatus;
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

    /**
     * 设置属性CONFIGPARA
     * @param configPara 待设置的属性CONFIGPARA的值
     */
    public void setConfigPara(String configPara){
        this.configPara = StringUtils.rightTrim(configPara);
    }

    /**
     * 获取属性CONFIGPARA
     * @return 属性CONFIGPARA的值
     */
    public String getConfigPara(){
        return configPara;
    }

    /**
     * 设置属性CONFIGDESC
     * @param configDesc 待设置的属性CONFIGDESC的值
     */
    public void setConfigDesc(String configDesc){
        this.configDesc = StringUtils.rightTrim(configDesc);
    }

    /**
     * 获取属性CONFIGDESC
     * @return 属性CONFIGDESC的值
     */
    public String getConfigDesc(){
        return configDesc;
    }

}
