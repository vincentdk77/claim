package com.sinosoft.claim.dto.custom;

import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrplcomplaintDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;

public class ReturnVisitDto {
	/** 回访主表 */
	private PrplreturnvisitswflogDto prplreturnvisitswflogDto;
	/** 回访主表子表 */
	private PrplreturnvisitDto prplreturnvisitDto;
	/** 回访主表子表集合 */
	private ArrayList<PrplreturnvisitDto> prplreturnvisitDtoList;
	/** 投诉表 */
	private PrplcomplaintDto prplcomplaintDto;
	
	
	public PrplcomplaintDto getPrplcomplaintDto() {
		return prplcomplaintDto;
	}
	public void setPrplcomplaintDto(PrplcomplaintDto prplcomplaintDto) {
		this.prplcomplaintDto = prplcomplaintDto;
	}
	public PrplreturnvisitswflogDto getPrplreturnvisitswflogDto() {
		return prplreturnvisitswflogDto;
	}
	public PrplreturnvisitDto getPrplreturnvisitDto() {
		return prplreturnvisitDto;
	}
	public ArrayList<PrplreturnvisitDto> getPrplreturnvisitDtoList() {
		return prplreturnvisitDtoList;
	}
	public void setPrplreturnvisitswflogDto(
			PrplreturnvisitswflogDto prplreturnvisitswflogDto) {
		this.prplreturnvisitswflogDto = prplreturnvisitswflogDto;
	}
	public void setPrplreturnvisitDto(PrplreturnvisitDto prplreturnvisitDto) {
		this.prplreturnvisitDto = prplreturnvisitDto;
	}
	public void setPrplreturnvisitDtoList(
			ArrayList<PrplreturnvisitDto> prplreturnvisitDtoList) {
		this.prplreturnvisitDtoList = prplreturnvisitDtoList;
	}
}
