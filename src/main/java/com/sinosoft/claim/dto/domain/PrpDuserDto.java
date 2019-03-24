package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * 这是PrpDuser 员工代码表的数据传输对象类<br>
 * 创建于 2004-11-09 18:30:39.076<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDuserDto extends PrpDuserDtoBase implements Serializable{
	/** 员工 工作角色 */
	private String gradecode = "";
	 /** 属性归属机构名称 */
	private String comCName = "";
	
    public String getComCName() {
		return comCName;
	}

	public void setComCName(String comCName) {
		this.comCName = comCName;
	}

	public String getGradecode() {
		return gradecode;
	}

	public void setGradecode(String gradecode) {
		this.gradecode = gradecode;
	}

	/**
     *  默认构造方法,构造一个默认的PrpDuserDto对象
     */
    public PrpDuserDto(){
    }
}
