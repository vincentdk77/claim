package com.sinosoft.claimciplatform.dto.domain;

import java.io.Serializable;

/**
 * ����������Ϣƽ̨�ϴ�ע�������ݴ��������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CIClaimUploadRegistDto extends CIClaimUploadRegistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    //���� �ϴ���ʽ(1���ֶ��ϴ���0��ϵͳ�ϴ�)
    private String uplaodWay = "";
    //���� ֧������
    private String payRefNo = "";
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
	public String getPayRefNo() {
		return payRefNo;
	}
	public void setPayRefNo(String payRefNo) {
		this.payRefNo = payRefNo;
	}
    
    
}
