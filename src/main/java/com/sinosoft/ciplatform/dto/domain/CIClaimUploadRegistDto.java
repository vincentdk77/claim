package com.sinosoft.ciplatform.dto.domain;

import java.io.Serializable;

/**
 * ����������Ϣƽ̨�ϴ�ע�������ݴ��������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CIClaimUploadRegistDto extends CIClaimUploadRegistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    //���� �ϴ���ʽ(1���ֶ��ϴ���0��ϵͳ�ϴ�)
    private String uplaodWay = "";
    private String policyNo = "";
    //2011
    private String payRefNo="";
    /**
	 * @return the payRefNo
	 */
	public String getPayRefNo() {
		return payRefNo;
	}
	/**
	 * @param payRefNo the payRefNo to set
	 */
	public void setPayRefNo(String payRefNo) {
		this.payRefNo = payRefNo;
	}
	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CIClaimUploadRegistDto����
     */
    public CIClaimUploadRegistDto(){
    }
	/**
	 * ��ȡ���� uplaodWay
	 * @return the uplaodWay
	 */
	public String getUplaodWay() {
		return uplaodWay;
	}
	/**
	 * �������� uplaodWay
	 * @param uplaodWay the uplaodWay to set
	 */
	public void setUplaodWay(String uplaodWay) {
		this.uplaodWay = uplaodWay;
	}
	/**
	 * @return the policyNo
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * @param policyNo the policyNo to set
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
    
    
}
