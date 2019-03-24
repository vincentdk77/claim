package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class EDamageTypeCodeInfo implements Serializable {

	/**
	 * ������¹����ʹ��롢����
	 */
	/** �����¹����ʹ��� */
    private String codeCode = "";
    /** �����¹��������� */
    private String comCName = "";
    
    
    
    /**Ĭ��EDamageTypeCodeInfo���췽��*/
    public EDamageTypeCodeInfo(){}
    
    public EDamageTypeCodeInfo(String codeCode,String comCName){
    	
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
