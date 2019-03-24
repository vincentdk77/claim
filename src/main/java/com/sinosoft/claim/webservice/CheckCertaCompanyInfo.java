package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class CheckCertaCompanyInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 属性机构代码 */
    private String comCode = "";
    /** 属性机构名称 */
    private String comCName = "";
    /** 属性上级机构代码 */
    private String upperComcode = "";
    /** 属性机构级别 */
    private String comlevel = "";
    
    
    /**默认CheckCertaCompanyInfo构造方法*/
    public CheckCertaCompanyInfo(){}
    
    public CheckCertaCompanyInfo(String comCode,String comCName,String upperComcode,String comlevel){
    	
    	this.comCode = comCode;
    	this.comCName = comCName;
    	this.upperComcode = upperComcode;
    	this.comlevel = comlevel;
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
	public String getComCName() {
		return comCName;
	}
	
	/**
     * 设置属性机构名称
     * @param comCode 待设置的属性机构名称的值
     */
	public void setComCName(String comCName) {
		this.comCName = comCName;
	}

	public String getUpperComcode() {
		return upperComcode;
	}

	public void setUpperComcode(String upperComcode) {
		this.upperComcode = upperComcode;
	}

	public String getComlevel() {
		return comlevel;
	}

	public void setComlevel(String comlevel) {
		this.comlevel = comlevel;
	}
    
    
}
