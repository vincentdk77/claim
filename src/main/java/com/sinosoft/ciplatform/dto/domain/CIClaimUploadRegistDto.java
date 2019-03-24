package com.sinosoft.ciplatform.dto.domain;

import java.io.Serializable;

/**
 * 这是理赔信息平台上传注册表的数据传输对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CIClaimUploadRegistDto extends CIClaimUploadRegistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    //属性 上传方式(1：手动上传，0：系统上传)
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
     *  默认构造方法,构造一个默认的CIClaimUploadRegistDto对象
     */
    public CIClaimUploadRegistDto(){
    }
	/**
	 * 获取属性 uplaodWay
	 * @return the uplaodWay
	 */
	public String getUplaodWay() {
		return uplaodWay;
	}
	/**
	 * 设置属性 uplaodWay
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
