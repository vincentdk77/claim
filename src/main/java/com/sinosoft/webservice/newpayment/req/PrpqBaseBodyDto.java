package com.sinosoft.webservice.newpayment.req;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class PrpqBaseBodyDto {
	
	//֧����ϢBasePart����
	@XStreamAlias("BasePart")
	private PrpqPayMainDto basePart;
	//֧����ϢDetailInfoList����
	@XStreamAlias("DetailInfoList")
	private List<PrpqPayDto> detailInfoList;
	
	public PrpqPayMainDto getBasePart() {
		return basePart;
	}
	public void setBasePart(PrpqPayMainDto basePart) {
		this.basePart = basePart;
	}
	public List<PrpqPayDto> getDetailInfoList() {
		return detailInfoList;
	}
	public void setDetailInfoList(List<PrpqPayDto> detailInfoList) {
		this.detailInfoList = detailInfoList;
	}
	
	
}
