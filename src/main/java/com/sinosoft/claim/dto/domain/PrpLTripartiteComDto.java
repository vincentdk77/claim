package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
/**
 * ���ǵ��������ݹ���ά��������������ݴ��������<br>
 * ������ 2012/11/9
 */
public class PrpLTripartiteComDto extends
	PrpLTripartiteComDtoBase implements Serializable {
	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDTripartiteComDto����
     */
	public PrpLTripartiteComDto(){
		
	}
	
	/** ר��Ʒ������ */
	private String brandname;
	/** ר��Ʒ�Ʊ��� */
	private String brandcode;
	/** ����ۿ��� */
	private double discountRate;

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getBrandcode() {
		return brandcode;
	}

	public void setBrandcode(String brandcode) {
		this.brandcode = brandcode;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

}
