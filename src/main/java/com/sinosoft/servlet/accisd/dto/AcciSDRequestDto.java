package com.sinosoft.servlet.accisd.dto;

import java.util.List;

import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciBaseInfoSDDto;
import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciClaimInfoSDDto;

public class AcciSDRequestDto extends RequestBaseDto{
	private PrpLAcciBaseInfoSDDto prpLAcciBaseInfoSDDto;
	
	private List<PrpLAcciClaimInfoSDDto> prpLAcciClaimInfoSDDtoList;

	public PrpLAcciBaseInfoSDDto getPrpLAcciBaseInfoSDDto() {
		return prpLAcciBaseInfoSDDto;
	}

	public void setPrpLAcciBaseInfoSDDto(PrpLAcciBaseInfoSDDto prpLAcciBaseInfoSDDto) {
		this.prpLAcciBaseInfoSDDto = prpLAcciBaseInfoSDDto;
	}

	public List<PrpLAcciClaimInfoSDDto> getPrpLAcciClaimInfoSDDtoList() {
		return prpLAcciClaimInfoSDDtoList;
	}

	public void setPrpLAcciClaimInfoSDDtoList(
			List<PrpLAcciClaimInfoSDDto> prpLAcciClaimInfoSDDtoList) {
		this.prpLAcciClaimInfoSDDtoList = prpLAcciClaimInfoSDDtoList;
	}
	
	
}
