package com.sinosoft.claim.dto.domain;

/**
 * ����PrpLcomRepairBillDto����ά�޷�Ʊ������ݴ��������
 * <br> ������ 2004-4-5 15:31:56
 * <br> JToolpad(1.2.3) Vendor:dingmingliang@sinosoft.com.cn
 */
public class PrpLcomRepairBillDto {

	/** ������� */
	private String compenSateNo="";
	/** ���*/
	private long itemno = 0;
	/** ��������*/
	private String carkind = "";
	/** ��Ʊ����*/
	private String billType = "";
	/** ��Ʊ����*/
	private String billNo = "";
	/** ���ƺ���*/
	private String licenseno = "";
	/** ���ܺ���*/
	private String frameno  = "";
	public String getCompenSateNo() {
		return compenSateNo;
	}
	public void setCompenSateNo(String compenSateNo) {
		this.compenSateNo = compenSateNo;
	}
	public long getItemno() {
		return itemno;
	}
	public void setItemno(long itemno) {
		this.itemno = itemno;
	}
	public String getCarkind() {
		return carkind;
	}
	public void setCarkind(String carkind) {
		this.carkind = carkind;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getLicenseno() {
		return licenseno;
	}
	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}
	public String getFrameno() {
		return frameno;
	}
	public void setFrameno(String frameno) {
		this.frameno = frameno;
	}
}
