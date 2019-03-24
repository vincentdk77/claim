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
public class InderectFeeDto implements Serializable {
	
	/** �������*/
	private String compensateNo = "";
	/**�ձ�*/
	private String kindCode = "";
		
    /** ���������� */
    private double chargeAmount = 0d;

	/**
	 * @return Returns the chargeAmount.
	 */
	public double getChargeAmount() {
		return chargeAmount;
	}

	/**
	 * @param chargeAmount The chargeAmount to set.
	 */
	public void setChargeAmount(double chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	/**
	 * @return Returns the compensateNo.
	 */
	public String getCompensateNo() {
		return compensateNo;
	}

	/**
	 * @param compensateNo The compensateNo to set.
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}

	/**
	 * @return Returns the kindCode.
	 */
	public String getKindCode() {
		return kindCode;
	}

	/**
	 * @param kindCode The kindCode to set.
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
    
   
	
	
	
}
