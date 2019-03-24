package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

/**
 * 自定义已决未决金额数据传输对象
 * <p>Title: 车险理赔已决未决金额DTO</p>
 * <p>Description: 车险理赔已决未决金额样本程序</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author wangli
 * @version 1.0
 */
public class CompensateFeeDto implements Serializable {
	
	/** 报案号*/
	private String registNo = "";
		
    /** 属性保险损失金额 */
    private double sumClaim = 0d;
    
    /** 属性已决金额 */
	private double sumPaid = 0d;
	
    /** 属性未决金额 */
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
