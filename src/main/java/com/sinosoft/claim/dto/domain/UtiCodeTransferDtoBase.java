package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是UtiCodeTransfer-险种险类代码对照表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class UtiCodeTransferDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性程序中代码 */
    private String configCode = "";
    /** 属性外部代码 */
    private String outerCode = "";
    /** 属性内部代码 */
    private String innerCode = "";
    /** 属性接口代码类型 */
    private String codeType = "";
    /** 属性效力状态 */
    private String validStatus = "";
    /** 属性险别大类 */
    private String riskType = "";

    /**
     *  默认构造方法,构造一个默认的UtiCodeTransferDtoBase对象
     */
    public UtiCodeTransferDtoBase(){
    }

    /**
     * 设置属性程序中代码
     * @param configCode 待设置的属性程序中代码的值
     */
    public void setConfigCode(String configCode){
        this.configCode = StringUtils.rightTrim(configCode);
    }

    /**
     * 获取属性程序中代码
     * @return 属性程序中代码的值
     */
    public String getConfigCode(){
        return configCode;
    }

    /**
     * 设置属性外部代码
     * @param outerCode 待设置的属性外部代码的值
     */
    public void setOuterCode(String outerCode){
        this.outerCode = StringUtils.rightTrim(outerCode);
    }

    /**
     * 获取属性外部代码
     * @return 属性外部代码的值
     */
    public String getOuterCode(){
        return outerCode;
    }

    /**
     * 设置属性内部代码
     * @param innerCode 待设置的属性内部代码的值
     */
    public void setInnerCode(String innerCode){
        this.innerCode = StringUtils.rightTrim(innerCode);
    }

    /**
     * 获取属性内部代码
     * @return 属性内部代码的值
     */
    public String getInnerCode(){
        return innerCode;
    }

    /**
     * 设置属性接口代码类型
     * @param codeType 待设置的属性接口代码类型的值
     */
    public void setCodeType(String codeType){
        this.codeType = StringUtils.rightTrim(codeType);
    }

    /**
     * 获取属性接口代码类型
     * @return 属性接口代码类型的值
     */
    public String getCodeType(){
        return codeType;
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
     * 设置属性险别大类
     * @param riskType 待设置的属性险别大类的值
     */
    public void setRiskType(String riskType){
        this.riskType = StringUtils.rightTrim(riskType);
    }

    /**
     * 获取属性险别大类
     * @return 属性险别大类的值
     */
    public String getRiskType(){
        return riskType;
    }
}
