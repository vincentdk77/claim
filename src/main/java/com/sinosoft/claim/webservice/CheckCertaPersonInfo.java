package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class CheckCertaPersonInfo implements Serializable {

	/**
	 * ���Ȳ鿱������Ա
	 */
	/** ����Ա������ */
    private String userCode = "";
    /** ����Ա������ */
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
    
    /**Ĭ��CheckCertaPersonInfo���췽��*/
    public CheckCertaPersonInfo(){}
    
    public CheckCertaPersonInfo(String userCode,String userName){
    	
    	this.userCode = userCode;
    	this.userName = userName;
    }
    
    /**
     * ��������Ա������
     * @param comCode �����õ�����Ա�������ֵ
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
     * ��ȡ����Ա������
     * @return ����Ա�������ֵ
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * ��ȡ����Ա������
     * @return ����Ա�����Ƶ�ֵ
     */
	public String getUserName() {
		return userName;
	}
	
	/**
     * ��������Ա������
     * @param comCode �����õ�����Ա�����Ƶ�ֵ
     */
	public void setUserName(String userName) {
		this.userName = userName;
	}
    
    
}
