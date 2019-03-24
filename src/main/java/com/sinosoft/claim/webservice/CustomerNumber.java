package com.sinosoft.claim.webservice;

import java.io.Serializable;

/**
 * 读取客户电话号码，包括报案人电话号码、驾驶员电话号码等。
 * @author fei
 *
 */
public class CustomerNumber implements Serializable {
	
    /**
	 * OK
	 */
	private static final long serialVersionUID = 1L;
	
	/** 属性客户电话号码*/
    private String customerPhone = "";
	/** 属性报案人电话号码*/
    private String reportorPhone = "";
    /** 属性驾驶员电话号码*/
    private String driverPhone = "";
    /** 属性报案人姓名 */
    private String reportName = "";
    /**客户姓名*/
    private String customerName = "";
    /**驾驶员姓名*/
    private String driverName = "";
    
    public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	/**
     * 获取属性客户电话号码 
     * @return 属性客户电话号码 的值
     */
    public String getCustomerPhone() {
		return customerPhone;
	}

    /**
     * 设置属性客户电话号码 
     * @param customerPhone 待设置的属性客户电话号码 的值
     */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	/**
     * 获取属性报案人电话号码 
     * @return 属性报案人电话号码 的值
     */
	public String getReportorPhone() {
		return reportorPhone;
	}

	/**
     * 设置属性报案人电话号码 
     * @param reportorPhone 待设置的属性报案人电话号码 的值
     */
	public void setReportorPhone(String reportorPhone) {
		this.reportorPhone = reportorPhone;
	}

	/**
     * 获取属性驾驶员电话号码 
     * @return 属性驾驶员电话号码 的值
     */
	public String getDriverPhone() {
		return driverPhone;
	}

	/**
     * 设置属性驾驶员电话号码 
     * @param driverPhone 待设置的属性驾驶员电话号码 的值
     */
	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}
    

}
