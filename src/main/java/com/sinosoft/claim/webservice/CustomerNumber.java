package com.sinosoft.claim.webservice;

import java.io.Serializable;

/**
 * ��ȡ�ͻ��绰���룬���������˵绰���롢��ʻԱ�绰����ȡ�
 * @author fei
 *
 */
public class CustomerNumber implements Serializable {
	
    /**
	 * OK
	 */
	private static final long serialVersionUID = 1L;
	
	/** ���Կͻ��绰����*/
    private String customerPhone = "";
	/** ���Ա����˵绰����*/
    private String reportorPhone = "";
    /** ���Լ�ʻԱ�绰����*/
    private String driverPhone = "";
    /** ���Ա��������� */
    private String reportName = "";
    /**�ͻ�����*/
    private String customerName = "";
    /**��ʻԱ����*/
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
     * ��ȡ���Կͻ��绰���� 
     * @return ���Կͻ��绰���� ��ֵ
     */
    public String getCustomerPhone() {
		return customerPhone;
	}

    /**
     * �������Կͻ��绰���� 
     * @param customerPhone �����õ����Կͻ��绰���� ��ֵ
     */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	/**
     * ��ȡ���Ա����˵绰���� 
     * @return ���Ա����˵绰���� ��ֵ
     */
	public String getReportorPhone() {
		return reportorPhone;
	}

	/**
     * �������Ա����˵绰���� 
     * @param reportorPhone �����õ����Ա����˵绰���� ��ֵ
     */
	public void setReportorPhone(String reportorPhone) {
		this.reportorPhone = reportorPhone;
	}

	/**
     * ��ȡ���Լ�ʻԱ�绰���� 
     * @return ���Լ�ʻԱ�绰���� ��ֵ
     */
	public String getDriverPhone() {
		return driverPhone;
	}

	/**
     * �������Լ�ʻԱ�绰���� 
     * @param driverPhone �����õ����Լ�ʻԱ�绰���� ��ֵ
     */
	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}
    

}
