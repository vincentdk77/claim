package com.sinosoft.ciplatform.dto.custom;

import java.util.Date;

/**
 * @author  Jiangzp
 * @version 1.0
 * <p>存放支付详细信息，用于产生上传平台的XML文件
 */
public class Paydata { 
	/**赔款收款账户号accountNumber*/
	private String rBankAcount     = "";
	/**赔款收款开户行bankName*/
	private String rBankName       ="";
	/**赔款收款账户名accountName*/
	private String rBankAcountName = "";
	/**赔款收款身份证centiCode*/
	private String rBankCenticode  = "";
	/**赔款收款证件类型centiType*/
	private String rBankCentiType  = "";
	/**理赔编码*/
	private String claimCode       = "";
	/**结案追加码*/
	private String claimAddCode    = "";
	/**赔偿金额payAmount*/
	private double claimAmount     = 0;
	/**支付类型*/
	private String claimType       = "";
	/**清算码*/
	private String recoveryCode    = "" ;
	/**赔偿支付时间；精确到分*/
	private Date payDate           = new Date();
	
	public String getRBankAcount() {
		return rBankAcount;
	}
	public void setRBankAcount(String bankAcount) {
		rBankAcount = bankAcount;
	}
	public String getRBankName() {
		return rBankName;
	}
	public void setRBankName(String bankName) {
		rBankName = bankName;
	}
	public String getRBankAcountName() {
		return rBankAcountName;
	}
	public void setRBankAcountName(String bankAcountName) {
		rBankAcountName = bankAcountName;
	}
	public String getRBankCenticode() {
		return rBankCenticode;
	}
	public void setRBankCenticode(String bankCenticode) {
		rBankCenticode = bankCenticode;
	}
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	public String getClaimAddCode() {
		return claimAddCode;
	}
	public void setClaimAddCode(String claimAddCode) {
		this.claimAddCode = claimAddCode;
	}
	public double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	public String getClaimType() {
		return claimType;
	}
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
	public String getRecoveryCode() {
		return recoveryCode;
	}
	public void setRecoveryCode(String recoveryCode) {
		this.recoveryCode = recoveryCode;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getRBankCentiType() {
		return rBankCentiType;
	}
	public void setRBankCentiType(String bankCentiType) {
		rBankCentiType = bankCentiType;
	}
}
