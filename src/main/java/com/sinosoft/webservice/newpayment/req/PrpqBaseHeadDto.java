package com.sinosoft.webservice.newpayment.req;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class PrpqBaseHeadDto {
	//接口类型
	@XStreamAlias("TransType")
	private String transType;
	//交互编号
	@XStreamAlias("TransID")
	private String transID;
	//渠道类型
	@XStreamAlias("ChannelCode")
	private String channelCode;
	//用户名
	@XStreamAlias("UserCode")
	private String userCode;
	//密码
	@XStreamAlias("Password")
	private String password;
	
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getTransID() {
		return transID;
	}
	public void setTransID(String transID) {
		this.transID = transID;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	
}
