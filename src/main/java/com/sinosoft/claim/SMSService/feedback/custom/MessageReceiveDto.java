package com.sinosoft.claim.SMSService.feedback.custom;

public class MessageReceiveDto {
	/**规则编码*/
	private String ruleCode = "";
	/**发送手机号码*/
	private String mobilePhones = "";
	/**回执内容*/
	private String content = "";
	/**回执时间*/
	private String receiveTime = "";
	/**业务号*/
	private String businessNo1 = "";
	/**业务号*/
	private String businessNo2 = "";
	/**业务号*/
	private String businessNo3 = "";
	/**业务号*/
	private String businessNo4 = "";
	/**业务号*/
	private String businessNo5 = "";
	
	public String getRuleCode() {
		return ruleCode;
	}
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}
	public String getMobilePhones() {
		return mobilePhones;
	}
	public void setMobilePhones(String mobilePhones) {
		this.mobilePhones = mobilePhones;
	}
	public String getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getBusinessNo1() {
		return businessNo1;
	}
	public void setBusinessNo1(String businessNo1) {
		this.businessNo1 = businessNo1;
	}
	public String getBusinessNo2() {
		return businessNo2;
	}
	public void setBusinessNo2(String businessNo2) {
		this.businessNo2 = businessNo2;
	}
	public String getBusinessNo3() {
		return businessNo3;
	}
	public void setBusinessNo3(String businessNo3) {
		this.businessNo3 = businessNo3;
	}
	public String getBusinessNo4() {
		return businessNo4;
	}
	public void setBusinessNo4(String businessNo4) {
		this.businessNo4 = businessNo4;
	}
	public String getBusinessNo5() {
		return businessNo5;
	}
	public void setBusinessNo5(String businessNo5) {
		this.businessNo5 = businessNo5;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
