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
public class InderectFeeDto implements Serializable {
	
	/** 计算书号*/
	private String compensateNo = "";
	/**险别*/
	private String kindCode = "";
		
    /** 间接理赔费用 */
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
