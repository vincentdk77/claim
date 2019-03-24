package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class CompanyInfo implements Serializable {

	/**
	 * ��¼�������롢����
	 */
	/** ���Ե�¼�������� */
    private String comCode = "";
    /** ���Ե�¼�������� */
    private String comName = "";
    
    /**Ĭ��CompanyInfo���췽��*/
    public CompanyInfo(){}
    
    public CompanyInfo(String comCode,String comName){
    	
    	this.comCode = comCode;
    	this.comName = comName;
    }
    
    /**
     * �������Ի�������
     * @param comCode �����õ����Ի��������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Ի�������
     * @return ���Ի��������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��ȡ���Ի�������
     * @return ���Ի������Ƶ�ֵ
     */
	public String getComName() {
		return comName;
	}
	
	/**
     * �������Ի�������
     * @param comCode �����õ����Ի������Ƶ�ֵ
     */
	public void setComName(String comName) {
		this.comName = comName;
	}
    
    
}
