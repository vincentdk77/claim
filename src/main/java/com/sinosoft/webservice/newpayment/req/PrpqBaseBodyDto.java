package com.sinosoft.webservice.newpayment.req;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class PrpqBaseBodyDto {
	
	//支付信息BasePart部分
	@XStreamAlias("BasePart")
	private PrpqPayMainDto basePart;
	//支付信息DetailInfoList部分
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
