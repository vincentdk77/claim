package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * ����PrpDpersonFeeCodeRisk-���˷������ֶ��ձ�����ݴ��������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpDpersonFeeCodeRiskDto extends PrpDpersonFeeCodeRiskDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /** ���Է��ô��� */
    private String feeName = "";
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDpersonFeeCodeRiskDto����
     */
    public PrpDpersonFeeCodeRiskDto(){
    }

	public String getFeeName() {
		return feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}
}
