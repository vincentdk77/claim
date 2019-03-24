package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpidtype的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpIDtypeDtoBase implements Serializable{
    /** 属性codetype */
    private String codeType = "";
    /** 属性codetypedesc */
    private String codeTypeDesc = "";

    /**
     *  默认构造方法,构造一个默认的PrpIDtypeDtoBase对象
     */
    public PrpIDtypeDtoBase(){
    }

    /**
     * 设置属性codetype
     * @param codeType 待设置的属性codetype的值
     */
    public void setCodeType(String codeType){
        this.codeType = StringUtils.rightTrim(codeType);
    }

    /**
     * 获取属性codetype
     * @return 属性codetype的值
     */
    public String getCodeType(){
        return codeType;
    }

    /**
     * 设置属性codetypedesc
     * @param codeTypeDesc 待设置的属性codetypedesc的值
     */
    public void setCodeTypeDesc(String codeTypeDesc){
        this.codeTypeDesc = StringUtils.rightTrim(codeTypeDesc);
    }

    /**
     * 获取属性codetypedesc
     * @return 属性codetypedesc的值
     */
    public String getCodeTypeDesc(){
        return codeTypeDesc;
    }
}
