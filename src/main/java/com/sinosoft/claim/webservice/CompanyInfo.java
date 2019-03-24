package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class CompanyInfo implements Serializable {

	/**
	 * 登录机构代码、名称
	 */
	/** 属性登录机构代码 */
    private String comCode = "";
    /** 属性登录机构名称 */
    private String comName = "";
    
    /**默认CompanyInfo构造方法*/
    public CompanyInfo(){}
    
    public CompanyInfo(String comCode,String comName){
    	
    	this.comCode = comCode;
    	this.comName = comName;
    }
    
    /**
     * 设置属性机构代码
     * @param comCode 待设置的属性机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性机构代码
     * @return 属性机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 获取属性机构名称
     * @return 属性机构名称的值
     */
	public String getComName() {
		return comName;
	}
	
	/**
     * 设置属性机构名称
     * @param comCode 待设置的属性机构名称的值
     */
	public void setComName(String comName) {
		this.comName = comName;
	}
    
    
}
