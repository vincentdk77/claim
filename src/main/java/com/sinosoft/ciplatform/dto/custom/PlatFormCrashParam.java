package com.sinosoft.ciplatform.dto.custom;

public class PlatFormCrashParam {

	public final String REQUEST_UPLOAD = "K1";

	public final String REQUEST_BACKWRITE = "K2";

	/**北京无责赔付垫付信息回写*/
	public final String NODUTYPAYREQUEST_UPLOAD = "D1";
	
	
	private String user;

	private String psd;

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
