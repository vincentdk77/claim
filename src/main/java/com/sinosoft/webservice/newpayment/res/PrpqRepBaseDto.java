package com.sinosoft.webservice.newpayment.res;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class PrpqRepBaseDto implements Serializable{
	private static final long serialVersionUID = 1L;
	@XStreamAlias("Head")
	public Head head;
	@XStreamAlias("Body")
	public Body body;
	public Head getHead() {
		return head;
	}
	public void setHead(Head head) {
		this.head = head;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	
}
