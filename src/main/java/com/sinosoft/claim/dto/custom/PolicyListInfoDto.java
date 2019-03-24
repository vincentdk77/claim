package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.Date;


public class PolicyListInfoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ������ */
	private String policyNo;
	/** ������������ */
	private String insuredName;
	/** �������� */
	private String startDate;
	/** ����ֹ�� */
	private String endDate;
	/** ���ִ��� */
	private String riskCode;
	/** �������� */
	private String riskName;
	/** ҵ��������� */
	private String comName;
	/** ҵ������������� */
	private String comCode;
	/** ����ҵ��Ա */
	private String handler1Name;
	/** ����ҵ��Ա���� */
	private String handler1code;
	/** ���յص� */
	private String addressName;
	/** ��������(������) */
	private String startSiteDate;
	/** ���˵�(������) */
	private String startSiteName;
	/** Ŀ�ĵ�(������) */
	private String endSiteName;
	/** ���乤�ߴ���(������) */
	private String conveyanceCode;
	/** ���乤������(������) */
	private String conveyanceName;
	/** ����(������) */
	private String voyageNo;
	/** ���մ��� */
	private String damageTimes;
	/** ���ս�� */
	private String amount;
	
	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getHandler1Name() {
		return handler1Name;
	}

	public void setHandler1Name(String handler1Name) {
		this.handler1Name = handler1Name;
	}

	public String getHandler1code() {
		return handler1code;
	}

	public void setHandler1code(String handler1code) {
		this.handler1code = handler1code;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getStartSiteDate() {
		return startSiteDate;
	}

	public void setStartSiteDate(String startSiteDate) {
		this.startSiteDate = startSiteDate;
	}

	public String getStartSiteName() {
		return startSiteName;
	}

	public void setStartSiteName(String startSiteName) {
		this.startSiteName = startSiteName;
	}

	public String getEndSiteName() {
		return endSiteName;
	}

	public void setEndSiteName(String endSiteName) {
		this.endSiteName = endSiteName;
	}

	public String getConveyanceCode() {
		return conveyanceCode;
	}

	public void setConveyanceCode(String conveyanceCode) {
		this.conveyanceCode = conveyanceCode;
	}

	public String getConveyanceName() {
		return conveyanceName;
	}

	public void setConveyanceName(String conveyanceName) {
		this.conveyanceName = conveyanceName;
	}

	public String getVoyageNo() {
		return voyageNo;
	}

	public void setVoyageNo(String voyageNo) {
		this.voyageNo = voyageNo;
	}

	public String getDamageTimes() {
		return damageTimes;
	}

	public void setDamageTimes(String damageTimes) {
		this.damageTimes = damageTimes;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
