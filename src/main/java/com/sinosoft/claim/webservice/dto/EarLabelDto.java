package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

import com.gyic.claim.dto.domain.PrplcompensateearDto;
/**
 * 耳标号清单信息
 * @author Administrator
 *
 */
public class EarLabelDto implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 耳标号       */  
	private String earNo;
	/** 投保清单编号 */  
	private String earInusreListCode;
	/** 险别序号     */  
	private String earKindCode;
	/** 农户代码     */  
	private String fcode;
	/** 证件号码     */  
	private String idCard;
	/** 姓名         */  
	private String name;
	/** 开户行名称   */  
	private String bank;
	/** 银行账号     */  
	private String account;
	/** 定损金额     */  
	private String estimateloss;
	/** 养殖地点代码 */  
	private String areaCode;
	/** 养殖地点名称 */  
	private String areaName;
	/** 单位保险金额 */  
	private String earUnitAmount;
	public EarLabelDto() {
		super();
	}
	public String getEarNo() {
		return earNo;
	}
	public void setEarNo(String earNo) {
		this.earNo = earNo;
	}
	public String getEarInusreListCode() {
		return earInusreListCode;
	}
	public void setEarInusreListCode(String earInusreListCode) {
		this.earInusreListCode = earInusreListCode;
	}
	public String getEarKindCode() {
		return earKindCode;
	}
	public void setEarKindCode(String earKindCode) {
		this.earKindCode = earKindCode;
	}
	public String getFcode() {
		return fcode;
	}
	public void setFcode(String fcode) {
		this.fcode = fcode;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getEstimateloss() {
		return estimateloss;
	}
	public void setEstimateloss(String estimateloss) {
		this.estimateloss = estimateloss;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getEarUnitAmount() {
		return earUnitAmount;
	}
	public void setEarUnitAmount(String earUnitAmount) {
		this.earUnitAmount = earUnitAmount;
	}
}
