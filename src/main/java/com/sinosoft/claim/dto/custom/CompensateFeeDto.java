package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

/**
 * �Զ����Ѿ�δ��������ݴ������
 * <p>Title: ���������Ѿ�δ�����DTO</p>
 * <p>Description: ���������Ѿ�δ�������������</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author wangli
 * @version 1.0
 */
public class CompensateFeeDto implements Serializable {
	
	/** ������*/
	private String registNo = "";
		
    /** ���Ա�����ʧ��� */
    private double sumClaim = 0d;
    
    /** �����Ѿ���� */
	private double sumPaid = 0d;
	
    /** ����δ����� */
	private double sumNoPaid = 0d;
	
	
	
	/**
	 * @return Returns the registNo.
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * @param registNo The registNo to set.
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	/**
	 * @return Returns the sumClaim.
	 */
	public double getSumClaim() {
		return sumClaim;
	}
	/**
	 * @param sumClaim The sumClaim to set.
	 */
	public void setSumClaim(double sumClaim) {
		this.sumClaim = sumClaim;
	}
	/**
	 * @return Returns the sumNoPaid.
	 */
	public double getSumNoPaid() {
		return sumNoPaid;
	}
	/**
	 * @param sumNoPaid The sumNoPaid to set.
	 */
	public void setSumNoPaid(double sumNoPaid) {
		this.sumNoPaid = sumNoPaid;
	}
	/**
	 * @return Returns the sumPaid.
	 */
	public double getSumPaid() {
		return sumPaid;
	}
	/**
	 * @param sumPaid The sumPaid to set.
	 */
	public void setSumPaid(double sumPaid) {
		this.sumPaid = sumPaid;
	}
}
