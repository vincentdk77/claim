package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class CatastropheCodeInfo implements Serializable {

	/**
	 * ���ֵȼ����롢����
	 */
	/** ���Ծ��ֵȼ����� */
    private String codeCode = "";
    /** ���Ծ��ֵȼ����� */
    private String comCName = "";
    
    
    
    /**Ĭ��CatastropheCodeInfo���췽��*/
    public CatastropheCodeInfo(){}
    
    public CatastropheCodeInfo(String codeCode,String comCName){
    	
    	this.codeCode = codeCode;
    	this.comCName = comCName;
    }
    
    /**
     * �����������ʹ���
     * @param codeCode �����õ��������ʹ����ֵ
     */
    public void setCodeCode(String codeCode){
        this.codeCode = StringUtils.rightTrim(codeCode);
    }

    /**
     * ��ȡ�������ʹ���
     * @return �������ʹ����ֵ
     */
    public String getCodeCode(){
        return codeCode;
    }

    /**
     * ��ȡ������������
     * @return �����������Ƶ�ֵ
     */
	public String getComCName() {
		return comCName;
	}
	
	/**
     * ����������������
     * @param codeCode �����õ������������Ƶ�ֵ
     */
	public void setcomCName(String comCName) {
		this.comCName = comCName;
	}
    
    
}
