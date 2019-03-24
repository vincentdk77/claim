package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpidtype接口代码类型表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpIDTypeDtoBase implements Serializable{
    /** 属性接口代码类型 */
    private String codeType = "";
    /** 属性代码类型描述 */
    private String codeTypeDesc = "";

    /**
     *  默认构造方法,构造一个默认的PrpIDTypeDtoBase对象
     */
    public PrpIDTypeDtoBase(){
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
     * 设置属性代码类型描述
     * @param codeTypeDesc 待设置的属性代码类型描述的值
     */
    public void setCodeTypeDesc(String codeTypeDesc){
        this.codeTypeDesc = StringUtils.rightTrim(codeTypeDesc);
    }

    /**
     * 获取属性代码类型描述
     * @return 属性代码类型描述的值
     */
    public String getCodeTypeDesc(){
        return codeTypeDesc;
    }
}
