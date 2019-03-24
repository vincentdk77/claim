package com.sinosoft.claimciplatform.dto.domain;

import java.io.Serializable;

/**
 * 这是理赔信息平台上传注册表的数据传输对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CIClaimUploadRegistDto extends CIClaimUploadRegistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    //属性 上传方式(1：手动上传，0：系统上传)
    private String uplaodWay = "";
    //属性 支付单号
    private String payRefNo = "";
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
	public String getPayRefNo() {
		return payRefNo;
	}
	public void setPayRefNo(String payRefNo) {
		this.payRefNo = payRefNo;
	}
    
    
}
