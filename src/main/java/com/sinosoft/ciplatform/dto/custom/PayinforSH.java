package com.sinosoft.ciplatform.dto.custom;

import java.util.Date;
import java.util.List;

/**
 * @author  Jiangzp
 * @version 1.0
 * <p>存放支付信息，用于产生上传平台的XML文件
 */
public class PayinforSH {
	private double claimAmount;	//赔偿总金额
	private String payMethod;	//支付类型
	private String bankName;	//赔款支付开户行
	private String bankAcount;	//赔款支付账户号
	private String bankAcountName;	//赔款支付账户名
	private Date payTime;	//款项划付时间
	List payList;	//收款账号明细
	private String policyNo;	//保单号
	private String claimNo;		//立案号
	private String registNo;	//报案号
	private String comCode;		//机构代码
	//private String claimCode;	//理赔编码
	
	public double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAcount() {
		return bankAcount;
	}
	public void setBankAcount(String bankAcount) {
		this.bankAcount = bankAcount;
	}
	public String getBankAcountName() {
		return bankAcountName;
	}
	public void setBankAcountName(String bankAcountName) {
		this.bankAcountName = bankAcountName;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public List getpayList() {
		return payList;
	}
	public void setpayList(List payList) {
		this.payList = payList;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	/*public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}	*/
	
}
