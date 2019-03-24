package com.sinosoft.claim.webservice.paymentinformatino;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * ֧���ط���Ϣ�ӿ���ϸ��Ϣ
 * @author Administrator
 *
 */
public class PaymentInfoBackList implements Serializable {
	private static final long serialVersionUID = 1L;
	/**֧�����*/
	private String payNo;
	/**���������*/
	private String payRefName;
	/**ʵ�����*/
	private Double payRefAmount;
	/**֧��״̬*/
	private String payStatus;
	/**֧��ʱ��*/
	private DateTime payrefDate;
	/**�ʺ�*/
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
