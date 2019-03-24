package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * 这是立案注销传入参数主表的数据传输对象类<br>
 */
public class PrpLinterCancelClaimRequestDto extends PrpLinterCancelClaimRequestDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
	/** 属性流程轨迹表信息 */
	private PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto;
    
    /**
     *  默认构造方法,构造一个默认的PrpLinterCancelClaimRequestDto对象
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
