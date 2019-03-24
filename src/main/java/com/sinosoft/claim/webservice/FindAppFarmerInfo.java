package com.sinosoft.claim.webservice;

/**
 * 驻点员App农户清单查询类养殖险
 * @author CDB
 *
 */
public class FindAppFarmerInfo {
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private FindAppFarmerInfoList[] findAppFarmerInfoList;
    public FindAppFarmerInfo(){
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public FindAppFarmerInfoList[] getFindAppFarmerInfoList() {
		return findAppFarmerInfoList;
	}
	public void setFindAppFarmerInfoList(
			FindAppFarmerInfoList[] findAppFarmerInfoList) {
		this.findAppFarmerInfoList = findAppFarmerInfoList;
	}
}
