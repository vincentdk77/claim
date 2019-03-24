package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpgrade岗位定义表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGradeDtoBase implements Serializable{
    /** 属性岗位代码 */
    private String gradeCode = "";
    /** 属性岗位名称 */
    private String gradeName = "";
    /** 属性权限设置 */
    private String power = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpGradeDtoBase对象
     */
    public PrpGradeDtoBase(){
    }

    /**
     * 设置属性岗位代码
     * @param gradeCode 待设置的属性岗位代码的值
     */
    public void setGradeCode(String gradeCode){
        this.gradeCode = StringUtils.rightTrim(gradeCode);
    }

    /**
     * 获取属性岗位代码
     * @return 属性岗位代码的值
     */
    public String getGradeCode(){
        return gradeCode;
    }

    /**
     * 设置属性岗位名称
     * @param gradeName 待设置的属性岗位名称的值
     */
    public void setGradeName(String gradeName){
        this.gradeName = StringUtils.rightTrim(gradeName);
    }

    /**
     * 获取属性岗位名称
     * @return 属性岗位名称的值
     */
    public String getGradeName(){
        return gradeName;
    }

    /**
     * 设置属性权限设置
     * @param power 待设置的属性权限设置的值
     */
    public void setPower(String power){
        this.power = StringUtils.rightTrim(power);
    }

    /**
     * 获取属性权限设置
     * @return 属性权限设置的值
     */
    public String getPower(){
        return power;
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
