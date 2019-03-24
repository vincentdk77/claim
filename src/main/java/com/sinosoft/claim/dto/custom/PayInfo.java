package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

public class PayInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ���Կͻ����������� */
	private String outid = "";
	/** ����֧��״̬���� */
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
