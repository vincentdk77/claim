package com.sinosoft.communication.dto.custom;

import java.io.Serializable;

public class PrplCommunicatPersonDto extends PrplCommunicatPersonDtoBase
		implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** 机构名称 */
	private String comCName;
    /**
     *  默认构造方法,构造一个默认的PrplCommunicatPersonDto对象
     */
	public PrplCommunicatPersonDto(){
		
	}
	/** 机构名称 */
	public String getComCName() {
		return comCName;
	}
	/** 机构名称 */
	public void setComCName(String comCName) {
		this.comCName = comCName;
	}
	
	
}
