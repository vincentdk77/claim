package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrplareasettingDto;

public class AreaSettingDto implements Serializable{
	
	/** 区域设置信息*/
	private ArrayList<PrplareasettingDto> prplareasettingDtoList;
	/** 区域设置对象 */
	private PrplareasettingDto areaSettingDto;

	public PrplareasettingDto getAreaSettingDto() {
		return areaSettingDto;
	}

	public void setAreaSettingDto(PrplareasettingDto areaSettingDto) {
		this.areaSettingDto = areaSettingDto;
	}

	public ArrayList<PrplareasettingDto> getPrplareasettingDtoList() {
		return prplareasettingDtoList;
	}

	public void setPrplareasettingDtoList(
			ArrayList<PrplareasettingDto> prplareasettingDtoList) {
		this.prplareasettingDtoList = prplareasettingDtoList;
	}

}
