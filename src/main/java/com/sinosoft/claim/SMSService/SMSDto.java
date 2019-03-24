package com.sinosoft.claim.SMSService;

public class SMSDto {
	/** 
	 * 鉴权口令*/
	private String certSerialNumber;
	/** 
	 * 应用系统的编号*/
	private String appNumber;
    /**
     *  短信下发扩展号，由一位短信类型标识和不超过6位的短信唯一标识组成。总长度不超过7位
     **/
	private String exNumber;
    /**
     * 短信发送目标手机号码，手机号码不能超过2^32 个。
     **/
	private String phone;
    /**
     * 待发短信内容。
     **/
	private String message;
    /**
     * 提交的短信是否需要定时发送，0表示短信需要立即发送，1表示短信需要定时发送。 
     **/
	private int timeFlag;
    /**
     *  短信定时发送时间。该值是由UTC（协调世界时间）标准的1970年1月1日0点0分0秒至当前时间的毫秒数。
     **/
	private long smsTime;
    /** 
     * 备用字段，以备以后扩展使用，传null空值。
     **/
	private String msgFlag;
	/**
	 * 
	 * 短信接收人，0 报案人，1 被保险人 2查勘人
	 */
	private String acceptor;
	
	public String getCertSerialNumber() {
		return certSerialNumber;
	}
	public void setCertSerialNumber(String certSerialNumber) {
		this.certSerialNumber = certSerialNumber;
	}
	public String getAppNumber() {
		return appNumber;
	}
	public void setAppNumber(String appNumber) {
		this.appNumber = appNumber;
	}
	public String getExNumber() {
		return exNumber;
	}
	public void setExNumber(String exNumber) {
		this.exNumber = exNumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getTimeFlag() {
		return timeFlag;
	}
	public void setTimeFlag(int timeFlag) {
		this.timeFlag = timeFlag;
	}
	public long getSmsTime() {
		return smsTime;
	}
	public void setSmsTime(long smsTime) {
		this.smsTime = smsTime;
	}
	public String getMsgFlag() {
		return msgFlag;
	}
	public void setMsgFlag(String msgFlag) {
		this.msgFlag = msgFlag;
	}
	public String getAcceptor() {
		return acceptor;
	}
	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}

}
