package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * ��������ע�����������������ݴ��������<br>
 */
public class PrpLinterCancelClaimRequestDto extends PrpLinterCancelClaimRequestDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
	/** �������̹켣����Ϣ */
	private PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto;
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterCancelClaimRequestDto����
     */
    public PrpLinterCancelClaimRequestDto(){
    }

	public PrpLinterCancelClaimDetailDto getPrpLinterCancelClaimDetailDto() {
		return prpLinterCancelClaimDetailDto;
	}

	public void setPrpLinterCancelClaimDetailDto(
			PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto) {
		this.prpLinterCancelClaimDetailDto = prpLinterCancelClaimDetailDto;
	}
	
}
