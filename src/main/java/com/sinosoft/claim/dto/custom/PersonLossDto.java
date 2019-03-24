package com.sinosoft.claim.dto.custom;

public class PersonLossDto {
	private int personNo;		//��Ա���
	private int serialNo;		//�������
	private String feeCode;		//���ô���		
	private String feeName;		//���ô���
	
	private double realloss; 	//��ʧ���޳���ֵ��Ľ�
	
	private String compelFeeCategory;	//ǿ�Ʊ����⸶����
	private double compelPaid;			//ǿ�Ʊ����⸶���

	private String businessFeeCategory;	//��ҵ�����⸶����
	private double businessPaid;		//��ҵ�����⸶���
	
	
	/**
	 * ���˷�������
	 *
	 */
	public static class FeeCategory{
		public static final String MEDICAL = "M";	//ҽ�Ʒ���
		public static final String DEATH = "D";		//�����˲з���
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


