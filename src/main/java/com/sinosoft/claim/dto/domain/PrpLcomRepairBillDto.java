package com.sinosoft.claim.dto.domain;

/**
 * 这是PrpLcomRepairBillDto车险维修发票表的数据传输对象类
 * <br> 创建于 2004-4-5 15:31:56
 * <br> JToolpad(1.2.3) Vendor:dingmingliang@sinosoft.com.cn
 */
public class PrpLcomRepairBillDto {

	/** 理算书号 */
	private String compenSateNo="";
	/** 序号*/
	private long itemno = 0;
	/** 车辆种类*/
	private String carkind = "";
	/** 发票类型*/
	private String billType = "";
	/** 发票号码*/
	private String billNo = "";
	/** 车牌号码*/
	private String licenseno = "";
	/** 车架号码*/
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
