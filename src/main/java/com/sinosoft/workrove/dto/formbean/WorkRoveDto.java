package com.sinosoft.workrove.dto.formbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;

@SuppressWarnings("serial")
public class WorkRoveDto extends ActionForm implements Serializable {
	

	private String registNo = "";
	private Collection prpLregistExtDtoList = new ArrayList();
	private PrpLscheduleItemDto  prpLscheduleItemDto  ;
	private PrpLscheduleMainWFDto prpLscheduleMainWFDto;
	private PrpLthirdPartyDto prpLthirdPartyDto;
	private PrpLthirdPropDto prpLthirdPropDto;

	public Collection getPrpLregistExtDtoList() {
		return prpLregistExtDtoList;
	}

	public void setPrpLregistExtDtoList(Collection prpLregistExtDtoList) {
		this.prpLregistExtDtoList = prpLregistExtDtoList;
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public PrpLscheduleItemDto getPrpLscheduleItemDto() {
		return prpLscheduleItemDto;
	}

	public void setPrpLscheduleItemDto(PrpLscheduleItemDto prpLscheduleItemDto) {
		this.prpLscheduleItemDto = prpLscheduleItemDto;
	}

	public PrpLscheduleMainWFDto getPrpLscheduleMainWFDto() {
		return prpLscheduleMainWFDto;
	}

	public void setPrpLscheduleMainWFDto(PrpLscheduleMainWFDto prpLscheduleMainWFDto) {
		this.prpLscheduleMainWFDto = prpLscheduleMainWFDto;
	}

	public PrpLthirdPartyDto getPrpLthirdPartyDto() {
		return prpLthirdPartyDto;
	}

	public void setPrpLthirdPartyDto(PrpLthirdPartyDto prpLthirdPartyDto) {
		this.prpLthirdPartyDto = prpLthirdPartyDto;
	}

	public PrpLthirdPropDto getPrpLthirdPropDto() {
		return prpLthirdPropDto;
	}

	public void setPrpLthirdPropDto(PrpLthirdPropDto prpLthirdPropDto) {
		this.prpLthirdPropDto = prpLthirdPropDto;
	}

	
	
}
