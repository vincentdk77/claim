package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是SwfModelUse模板使用设置（新增）的数据传输对象基类<br>
 * 创建于 2005-04-26 15:20:13.468<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfModelUseDtoBase implements Serializable{
    /** 属性模板编号 */
    private int modelNo = 0;
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性部门编码 */
    private String comCode = "";
    /** 属性模板类型 */
    private String modelType = "";
    /** 属性模板状态 */
    private String modelStatus = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的SwfModelUseDtoBase对象
     */
    public SwfModelUseDtoBase(){
    }

    /**
     * 设置属性模板编号
     * @param modelNo 待设置的属性模板编号的值
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * 获取属性模板编号
     * @return 属性模板编号的值
     */
    public int getModelNo(){
        return modelNo;
    }

    /**
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性部门编码
     * @param comCode 待设置的属性部门编码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性部门编码
     * @return 属性部门编码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性模板类型
     * @param modelType 待设置的属性模板类型的值
     */
    public void setModelType(String modelType){
        this.modelType = StringUtils.rightTrim(modelType);
    }

    /**
     * 获取属性模板类型
     * @return 属性模板类型的值
     */
    public String getModelType(){
        return modelType;
    }

    /**
     * 设置属性模板状态
     * @param modelStatus 待设置的属性模板状态的值
     */
    public void setModelStatus(String modelStatus){
        this.modelStatus = StringUtils.rightTrim(modelStatus);
    }

    /**
     * 获取属性模板状态
     * @return 属性模板状态的值
     */
    public String getModelStatus(){
        return modelStatus;
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
}
