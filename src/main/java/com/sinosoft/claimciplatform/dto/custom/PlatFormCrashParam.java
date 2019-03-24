package com.sinosoft.claimciplatform.dto.custom;

public class PlatFormCrashParam {

	public final String REQUEST_UPLOAD = "K1";

	public final String REQUEST_BACKWRITE = "K2";

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
