package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * ����PrpDuser Ա�����������ݴ��������<br>
 * ������ 2004-11-09 18:30:39.076<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDuserDto extends PrpDuserDtoBase implements Serializable{
	/** Ա�� ������ɫ */
	private String gradecode = "";
	 /** ���Թ����������� */
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
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDuserDto����
     */
    public PrpDuserDto(){
    }
}
