package com.sinosoft.ciplatform.dto.custom;

import java.util.Date;

/**
 * @author  Jiangzp
 * @version 1.0
 * <p>���֧����ϸ��Ϣ�����ڲ����ϴ�ƽ̨��XML�ļ�
 */
public class Paydata { 
	/**����տ��˻���accountNumber*/
	private String rBankAcount     = "";
	/**����տ����bankName*/
	private String rBankName       ="";
	/**����տ��˻���accountName*/
	private String rBankAcountName = "";
	/**����տ����֤centiCode*/
	private String rBankCenticode  = "";
	/**����տ�֤������centiType*/
	private String rBankCentiType  = "";
	/**�������*/
	private String claimCode       = "";
	/**�᰸׷����*/
	private String claimAddCode    = "";
	/**�⳥���payAmount*/
	private double claimAmount     = 0;
	/**֧������*/
	private String claimType       = "";
	/**������*/
	private String recoveryCode    = "" ;
	/**�⳥֧��ʱ�䣻��ȷ����*/
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
