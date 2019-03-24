package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

public class ZH03CaseListInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**序号*/
	private String serial;
	/**户编号*/
	private String familyNo;
	/**主被保险人姓名*/
	private String familyName;
	/**主被保险人性别*/
	private String familySex;
	/**主被保险人身份证*/
	private String familyIdCard;
	/**连带被保险人1*/
	private String p1;
	/**连带被保险人2*/
	private String p2;
	/**连带被保险人3*/
	private String p3;
	/**连带被保险人4*/
	private String p4;
	/**连带被保险人5*/
	private String p5;
	/**投保房屋地址*/
	private String address;
	/**份数*/
	private String count;
	/**备注*/
	private String remark;
	public ZH03CaseListInfo() {
		super();
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getFamilyNo() {
		return familyNo;
	}
	public void setFamilyNo(String familyNo) {
		this.familyNo = familyNo;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFamilySex() {
		return familySex;
	}
	public void setFamilySex(String familySex) {
		this.familySex = familySex;
	}
	public String getFamilyIdCard() {
		return familyIdCard;
	}
	public void setFamilyIdCard(String familyIdCard) {
		this.familyIdCard = familyIdCard;
	}
	public String getP1() {
		return p1;
	}
	public void setP1(String p1) {
		this.p1 = p1;
	}
	public String getP2() {
		return p2;
	}
	public void setP2(String p2) {
		this.p2 = p2;
	}
	public String getP3() {
		return p3;
	}
	public void setP3(String p3) {
		this.p3 = p3;
	}
	public String getP4() {
		return p4;
	}
	public void setP4(String p4) {
		this.p4 = p4;
	}
	public String getP5() {
		return p5;
	}
	public void setP5(String p5) {
		this.p5 = p5;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}
