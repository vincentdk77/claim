package com.sinosoft.ciplatform.dto.custom;

import java.util.Date;
import java.util.List;

/**
 * @author  Jiangzp
 * @version 1.0
 * <p>���֧����Ϣ�����ڲ����ϴ�ƽ̨��XML�ļ�
 */
public class PayinforSH {
	private double claimAmount;	//�⳥�ܽ��
	private String payMethod;	//֧������
	private String bankName;	//���֧��������
	private String bankAcount;	//���֧���˻���
	private String bankAcountName;	//���֧���˻���
	private Date payTime;	//�����ʱ��
	List payList;	//�տ��˺���ϸ
	private String policyNo;	//������
	private String claimNo;		//������
	private String registNo;	//������
	private String comCode;		//��������
	//private String claimCode;	//�������
	
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
