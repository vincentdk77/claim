package com.sinosoft.claim.dto.custom;

public class PersonLossDto {
	private int personNo;		//人员序号
	private int serialNo;		//费用序号
	private String feeCode;		//费用代码		
	private String feeName;		//费用代码
	
	private double realloss; 	//损失金额（剔出残值后的金额）
	
	private String compelFeeCategory;	//强制保险赔付类型
	private double compelPaid;			//强制保险赔付金额

	private String businessFeeCategory;	//商业保险赔付类型
	private double businessPaid;		//商业保险赔付金额
	
	
	/**
	 * 人伤费用类型
	 *
	 */
	public static class FeeCategory{
		public static final String MEDICAL = "M";	//医疗费用
		public static final String DEATH = "D";		//死亡伤残费用
	}


	public String getBusinessFeeCategory() {
		return businessFeeCategory;
	}


	public void setBusinessFeeCategory(String businessFeeCategory) {
		this.businessFeeCategory = businessFeeCategory;
	}


	public double getBusinessPaid() {
		return businessPaid;
	}


	public void setBusinessPaid(double businessPaid) {
		this.businessPaid = businessPaid;
	}


	public String getCompelFeeCategory() {
		return compelFeeCategory;
	}


	public void setCompelFeeCategory(String compelFeeCategory) {
		this.compelFeeCategory = compelFeeCategory;
	}


	public double getCompelPaid() {
		return compelPaid;
	}


	public void setCompelPaid(double compelPaid) {
		this.compelPaid = compelPaid;
	}


	public String getFeeCode() {
		return feeCode;
	}


	public void setFeeCode(String feeCode) {
		this.feeCode = feeCode;
	}


	public double getRealloss() {
		return realloss;
	}


	public void setRealloss(double realloss) {
		this.realloss = realloss;
	}


	public int getSerialNo() {
		return serialNo;
	}


	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}


	public int getPersonNo() {
		return personNo;
	}


	public void setPersonNo(int personNo) {
		this.personNo = personNo;
	}
}


