package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyMainCargoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 车牌号码 */
	private String deviceNoID;
	/** 发动机号 */
	private String makeFactoryID;
	/** 车型 */
	private String modelID;
	/** 吨位 */
	private String capaCityID;

	public String getDeviceNoID() {
		return deviceNoID;
	}

	public void setDeviceNoID(String deviceNoID) {
		this.deviceNoID = deviceNoID;
	}

	public String getMakeFactoryID() {
		return makeFactoryID;
	}

	public void setMakeFactoryID(String makeFactoryID) {
		this.makeFactoryID = makeFactoryID;
	}

	public String getModelID() {
		return modelID;
	}

	public void setModelID(String modelID) {
		this.modelID = modelID;
	}

	public String getCapaCityID() {
		return capaCityID;
	}

	public void setCapaCityID(String capaCityID) {
		this.capaCityID = capaCityID;
	}
}
