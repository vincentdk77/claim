package com.sinosoft.webservice.newpayment.req;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class PrpqBaseDto implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XStreamAlias("Head")
	private PrpqBaseHeadDto head;
	@XStreamAlias("Body")
	private PrpqBaseBodyDto body;
	public PrpqBaseHeadDto getHead() {
		return head;
	}
	public void setHead(PrpqBaseHeadDto head) {
		this.head = head;
	}
	public PrpqBaseBodyDto getBody() {
		return body;
	}
	public void setBody(PrpqBaseBodyDto body) {
		this.body = body;
	}
	
	

}
