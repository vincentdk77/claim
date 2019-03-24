package com.sinosoft.claim.webservice.paymentinformatino;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * 支付回访信息接口详细信息
 * @author Administrator
 *
 */
public class PaymentInfoBackList implements Serializable {
	private static final long serialVersionUID = 1L;
	/**支付编号*/
	private String payNo;
	/**领款人姓名*/
	private String payRefName;
	/**实付金额*/
	private Double payRefAmount;
	/**支付状态*/
	private String payStatus;
	/**支付时间*/
	private DateTime payrefDate;
	/**帐号*/
	private String payAccount;
	
	public PaymentInfoBackList(){
		
	}
	
	public String getPayNo() {
		return payNo;
	}
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}
	public String getPayRefName() {
		return payRefName;
	}
	public void setPayRefName(String payRefName) {
		this.payRefName = payRefName;
	}
	public Double getPayRefAmount() {
		return payRefAmount;
	}
	public void setPayRefAmount(Double payRefAmount) {
		this.payRefAmount = payRefAmount;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public DateTime getPayrefDate() {
		return payrefDate;
	}
	public void setPayrefDate(DateTime payrefDate) {
		this.payrefDate = payrefDate;
	}
	public String getPayAccount() {
		return payAccount;
	}
	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}
	
	
}
