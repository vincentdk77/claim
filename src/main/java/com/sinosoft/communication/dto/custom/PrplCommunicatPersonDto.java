package com.sinosoft.communication.dto.custom;

import java.io.Serializable;

public class PrplCommunicatPersonDto extends PrplCommunicatPersonDtoBase
		implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** �������� */
	private String comCName;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplCommunicatPersonDto����
     */
	public PrplCommunicatPersonDto(){
		
	}
	/** �������� */
	public String getComCName() {
		return comCName;
	}
	/** �������� */
	public void setComCName(String comCName) {
		this.comCName = comCName;
	}
	
	
}
