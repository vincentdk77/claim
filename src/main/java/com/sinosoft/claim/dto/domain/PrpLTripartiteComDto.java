package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
/**
 * 这是第三方数据管理维护中修理厂表的数据传输对象类<br>
 * 创建于 2012/11/9
 */
public class PrpLTripartiteComDto extends
	PrpLTripartiteComDtoBase implements Serializable {
	/**
     *  默认构造方法,构造一个默认的PrpDTripartiteComDto对象
     */
	public PrpLTripartiteComDto(){
		
	}
	
	/** 专修品牌名称 */
	private String brandname;
	/** 专修品牌编码 */
	private String brandcode;
	/** 配件折扣率 */
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
