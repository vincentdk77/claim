package com.sinosoft.ciplatform.dto.custom;

/**
 * 自定义"垫付信息回写请求"数据传输对象
 * <p>Title: 交强险互碰理赔垫付DTO</p>
 * <p>Description: 交强险互碰理赔垫付程序</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sinosoft&&Dbic</p>
 * @author zhangwei
 * @version 1.0
 */

public class AdvanceUpdateRequestDto {
    /** 请求公共信息*/
	private PlatFormCrashParam platFormCrashParam = null;
	/** 全责方保险公司报案号码*/
	private String fullDutyRegistNo = "";
	// add by lishengjun start
	private String ciPlatFormCode="";
	
	// add end
	/**
	 * 获得请求公共信息
	 * @return 请求公共信息*/
	public PlatFormCrashParam getPlatFormCrashParam() {
	  	return this.platFormCrashParam;
	}
	  
	/**
	 * 设置请求公共信息
	 * @param 请求公共信息*/
	public void setPlatFormCrashParam(PlatFormCrashParam platFormCrashParam) {
	  	this.platFormCrashParam = platFormCrashParam;
	}
	
	/**
	 * 获得全责方保险公司报案号码
	 * @return 全责方保险公司报案号码*/
	public String getFullDutyRegistNo() {
	  	return this.fullDutyRegistNo;
	}
	  
	/**
	 * 设置全责方保险公司报案号码
	 * @param 全责方保险公司报案号码*/
	public void setFullDutyRegistNo(String fullDutyRegistNo) {
	  	this.fullDutyRegistNo = fullDutyRegistNo;
	}

	public String getCiPlatFormCode() {
		return ciPlatFormCode;
	}

	public void setCiPlatFormCode(String ciPlatFormCode) {
		this.ciPlatFormCode = ciPlatFormCode;
	}
	
	
}
