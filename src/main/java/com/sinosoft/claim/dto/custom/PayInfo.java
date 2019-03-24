package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

public class PayInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性客户端数据主键 */
	private String outid = "";
	/** 属性支付状态编码 */
	private String status = "";

	public PayInfo(String outid, String status) {
		this.outid = outid;
		this.status = status;
	}

	public String getOutid() {
		return outid;
	}

	public void setOutid(String outid) {
		this.outid = outid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
