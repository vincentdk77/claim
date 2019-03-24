package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 保存用户信息
 * @author fei
 *
 */
public class UserInfo implements Serializable {

	/**
	 * 字段：员工代码、员工姓名
	 */
	private static final long serialVersionUID = 1L;
	/** 属性员工代码 */
    private String userCode = "";
    /** 属性员工名称 */
    private String userName = "";
    
    
    public UserInfo(){}
    
    public UserInfo(String userCode,String userName) {
    	this.userCode = userCode;
    	this.userName = userName;
    }
    /**
     * 设置属性员工代码
     * @param userCode 待设置的属性员工代码的值
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * 获取属性员工代码
     * @return 属性员工代码的值
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * 设置属性员工名称
     * @param userName 待设置的属性员工名称的值
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * 获取属性员工名称
     * @return 属性员工名称的值
     */
    public String getUserName(){
        return userName;
    }
	
	
}
