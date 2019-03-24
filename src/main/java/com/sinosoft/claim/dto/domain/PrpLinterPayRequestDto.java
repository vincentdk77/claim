package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * ���Ǵ��������������ݴ��������<br>
 */
public class PrpLinterPayRequestDto extends PrpLinterPayRequestDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /** �⸶��Ϣ(����һ��) */
	private PrpLinterPaymentInfoDto[] prpLinterPaymentInfoDto;
	/** �������(���������) */
	private PrpLinterPayExtDto[] prpLinterPayExtDto;
	/** �������̹켣����Ϣ */
	private PrpLinterPayDetailDto prpLinterPayDetailDto;
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterPayRequestDto����
     */
    public PrpLinterPayRequestDto(){
    }

	public PrpLinterPaymentInfoDto[] getPrpLinterPaymentInfoDto() {
		return prpLinterPaymentInfoDto;
	}

	public void setPrpLinterPaymentInfoDto(
			PrpLinterPaymentInfoDto[] prpLinterPaymentInfoDto) {
		this.prpLinterPaymentInfoDto = prpLinterPaymentInfoDto;
	}

	public PrpLinterPayExtDto[] getPrpLinterPayExtDto() {
		return prpLinterPayExtDto;
	}

	public void setPrpLinterPayExtDto(PrpLinterPayExtDto[] prpLinterPayExtDto) {
		this.prpLinterPayExtDto = prpLinterPayExtDto;
	}

	public PrpLinterPayDetailDto getPrpLinterPayDetailDto() {
		return prpLinterPayDetailDto;
	}

	public void setPrpLinterPayDetailDto(PrpLinterPayDetailDto prpLinterPayDetailDto) {
		this.prpLinterPayDetailDto = prpLinterPayDetailDto;
	}
    
}
