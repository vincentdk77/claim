package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

public class EarNoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ����� */
	private String earNo;
	/** Ͷ���嵥��� */
	private String earInusreListCode;
	/** ũ������ */
	private String fcode;
	/** ֤������ */
	private String idCard;
	/** ���� */
	private String name;
	/** ���������� */
	private String bank;
	/** �����˺� */
	private String account;
	/** �ձ���� */
	private String earKindCode;
	/** ��ֳ�ص���� */
	private String areaCode;
	/** ��ֳ�ص����� */
	private String areaName;
	/** ��λ���ս�� */
	private String earUnitAmount;
	/** ������ */
	private String estimateloss;

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

	public String getEarKindCode() {
		return earKindCode;
	}

	public void setEarKindCode(String earKindCode) {
		this.earKindCode = earKindCode;
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

	public String getEstimateloss() {
		return estimateloss;
	}

	public void setEstimateloss(String estimateloss) {
		this.estimateloss = estimateloss;
	}

}
