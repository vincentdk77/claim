package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����û���Ϣ
 * @author fei
 *
 */
public class UserInfo implements Serializable {

	/**
	 * �ֶΣ�Ա�����롢Ա������
	 */
	private static final long serialVersionUID = 1L;
	/** ����Ա������ */
    private String userCode = "";
    /** ����Ա������ */
    private String userName = "";
    
    
    public UserInfo(){}
    
    public UserInfo(String userCode,String userName) {
    	this.userCode = userCode;
    	this.userName = userName;
    }
    /**
     * ��������Ա������
     * @param userCode �����õ�����Ա�������ֵ
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * ��ȡ����Ա������
     * @return ����Ա�������ֵ
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * ��������Ա������
     * @param userName �����õ�����Ա�����Ƶ�ֵ
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * ��ȡ����Ա������
     * @return ����Ա�����Ƶ�ֵ
     */
    public String getUserName(){
        return userName;
    }
	
	
}
