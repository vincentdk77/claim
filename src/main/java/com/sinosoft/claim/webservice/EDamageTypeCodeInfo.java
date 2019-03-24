package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class EDamageTypeCodeInfo implements Serializable {

	/**
	 * 意键险事故类型代码、名称
	 */
	/** 属性事故类型代码 */
    private String codeCode = "";
    /** 属性事故类型名称 */
    private String comCName = "";
    
    
    
    /**默认EDamageTypeCodeInfo构造方法*/
    public EDamageTypeCodeInfo(){}
    
    public EDamageTypeCodeInfo(String codeCode,String comCName){
    	
    	this.codeCode = codeCode;
    	this.comCName = comCName;
    }
    
    /**
     * 设置属性类型代码
     * @param codeCode 待设置的属性类型代码的值
     */
    public void setCodeCode(String codeCode){
        this.codeCode = StringUtils.rightTrim(codeCode);
    }

    /**
     * 获取属性类型代码
     * @return 属性类型代码的值
     */
    public String getCodeCode(){
        return codeCode;
    }

    /**
     * 获取属性类型名称
     * @return 属性类型名称的值
     */
	public String getComCName() {
		return comCName;
	}
	
	/**
     * 设置属性类型名称
     * @param codeCode 待设置的属性类型名称的值
     */
	public void setcomCName(String comCName) {
		this.comCName = comCName;
	}
    
    
}
