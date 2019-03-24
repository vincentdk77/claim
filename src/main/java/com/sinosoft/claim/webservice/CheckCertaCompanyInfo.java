package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class CheckCertaCompanyInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/** ���Ի������� */
    private String comCode = "";
    /** ���Ի������� */
    private String comCName = "";
    /** �����ϼ��������� */
    private String upperComcode = "";
    /** ���Ի������� */
    private String comlevel = "";
    
    
    /**Ĭ��CheckCertaCompanyInfo���췽��*/
    public CheckCertaCompanyInfo(){}
    
    public CheckCertaCompanyInfo(String comCode,String comCName,String upperComcode,String comlevel){
    	
    	this.comCode = comCode;
    	this.comCName = comCName;
    	this.upperComcode = upperComcode;
    	this.comlevel = comlevel;
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
	public String getComCName() {
		return comCName;
	}
	
	/**
     * �������Ի�������
     * @param comCode �����õ����Ի������Ƶ�ֵ
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
