package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class CheckCertaPersonInfo implements Serializable {

	/**
	 * 调度查勘定损人员
	 */
	/** 属性员工代码 */
    private String userCode = "";
    /** 属性员工名称 */
    private String userName = "";
    
    private String UserEName = "";
    private String Password = "";
    private String Seal = "";
    private String PasswordSetDate = "";
    private String PasswordExpireDate = "";
    private String ComCode = "";
    private String MakeCom = "";
    private String AccountCode = "";
    private String Phone = "";
    private String Mobile = "";
    private String Address = "";
    private String PostCode = "";
    private String Email = "";
    private String UserFlag = "";
    private String LoginSystem = "";
    private String NewUserCode = "";
    private String ValidStatus = "";
    private String ArticleCode = "";
    
    private String phoneNumber = "";
    
    /**默认CheckCertaPersonInfo构造方法*/
    public CheckCertaPersonInfo(){}
    
    public CheckCertaPersonInfo(String userCode,String userName){
    	
    	this.userCode = userCode;
    	this.userName = userName;
    }
    
    /**
     * 设置属性员工代码
     * @param comCode 待设置的属性员工代码的值
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }
    
    public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
     * 获取属性员工代码
     * @return 属性员工代码的值
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * 获取属性员工名称
     * @return 属性员工名称的值
     */
	public String getUserName() {
		return userName;
	}
	
	/**
     * 设置属性员工名称
     * @param comCode 待设置的属性员工名称的值
     */
	public void setUserName(String userName) {
		this.userName = userName;
	}
    
    
}
