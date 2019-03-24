package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLqualityCheck-质量评审内容表的数据传输对象基类<br>
 * 创建于 2005-04-14 15:56:44.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLqualityCheckDtoBase implements Serializable{
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性业务类型 */
    private String qualityCheckType = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性评审项目代码 */
    private String typeCode = "";
    /** 属性评审项目名称 */
    private String typeName = "";
    /** 属性回访结果 */
    private String checkResult = "";
    /** 属性问题备注 */
    private String checkRemark = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLqualityCheckDtoBase对象
     */
    public PrpLqualityCheckDtoBase(){
    }

    /**
     * 设置属性报案号码
     * @param registNo 待设置的属性报案号码的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号码
     * @return 属性报案号码的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性业务类型
     * @param qualityCheckType 待设置的属性业务类型的值
     */
    public void setQualityCheckType(String qualityCheckType){
        this.qualityCheckType = StringUtils.rightTrim(qualityCheckType);
    }

    /**
     * 获取属性业务类型
     * @return 属性业务类型的值
     */
    public String getQualityCheckType(){
        return qualityCheckType;
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
     * 设置属性评审项目代码
     * @param typeCode 待设置的属性评审项目代码的值
     */
    public void setTypeCode(String typeCode){
        this.typeCode = StringUtils.rightTrim(typeCode);
    }

    /**
     * 获取属性评审项目代码
     * @return 属性评审项目代码的值
     */
    public String getTypeCode(){
        return typeCode;
    }

    /**
     * 设置属性评审项目名称
     * @param typeName 待设置的属性评审项目名称的值
     */
    public void setTypeName(String typeName){
        this.typeName = StringUtils.rightTrim(typeName);
    }

    /**
     * 获取属性评审项目名称
     * @return 属性评审项目名称的值
     */
    public String getTypeName(){
        return typeName;
    }

    /**
     * 设置属性回访结果
     * @param checkResult 待设置的属性回访结果的值
     */
    public void setCheckResult(String checkResult){
        this.checkResult = StringUtils.rightTrim(checkResult);
    }

    /**
     * 获取属性回访结果
     * @return 属性回访结果的值
     */
    public String getCheckResult(){
        return checkResult;
    }

    /**
     * 设置属性问题备注
     * @param checkRemark 待设置的属性问题备注的值
     */
    public void setCheckRemark(String checkRemark){
        this.checkRemark = StringUtils.rightTrim(checkRemark);
    }

    /**
     * 获取属性问题备注
     * @return 属性问题备注的值
     */
    public String getCheckRemark(){
        return checkRemark;
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
