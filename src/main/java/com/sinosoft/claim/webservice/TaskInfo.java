package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 任务列表
字段：报案号、车牌号、受理时间、任务状态、派工类型等
 * @author fei
 *
 */
public class TaskInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 属性报案号码 */
    private String registNo = "";
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 属性受理时间 */
    private String  acceptTime = "";
    /** 属性任务状态*/
    private String taskStatus = "";
    /** 属性派工类型*/
    private String dispatchType = "";
    /** 属性被保险人名称 */
    private String insuredName = "";
    
    /**
     * 设置属性报案号码
     * @param registNo 待设置的属性报案号码的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号码
     * @return 属性报案号码的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 获取属性受理时间
     * @return 属性受理时间值
     */
	public String getAcceptTime() {
		return acceptTime;
	}
	
	/**
     * 设置属性受理时间
     * @param acceptTime 待设置的属性受理时间的值
     */
	public void setAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
	}

	/**
     * 获取属性任务状态
     * @return 属性任务状态值
     */
	public String getTaskStatus() {
		return taskStatus;
	}

	/**
     * 设置属性任务状态
     * @param taskStatus 待设置的属性任务状态的值
     */
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	
    /**
     * 获取属性车牌号码
     * @return 属性车牌号码值
     */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
     * 设置属性车牌号码
     * @param policyNo 待设置的属性车牌号码的值
     */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	/**
     * 获取属性派工类型
     * @return 属性派工类型值
     */
	public String getDispatchType() {
		return dispatchType;
	}

	/**
     * 设置属性派工类型
     * @param dispatchType 待设置的属性派工类型的值
     */
	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	
	
	
}
