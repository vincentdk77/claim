package com.sinosoft.claim.dto.custom;

import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrplcomplaintDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;

public class ReturnVisitDto {
	/** �ط����� */
	private PrplreturnvisitswflogDto prplreturnvisitswflogDto;
	/** �ط������ӱ� */
	private PrplreturnvisitDto prplreturnvisitDto;
	/** �ط������ӱ��� */
	private ArrayList<PrplreturnvisitDto> prplreturnvisitDtoList;
	/** Ͷ�߱� */
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
