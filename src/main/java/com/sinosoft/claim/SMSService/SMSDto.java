package com.sinosoft.claim.SMSService;

public class SMSDto {
	/** 
	 * ��Ȩ����*/
	private String certSerialNumber;
	/** 
	 * Ӧ��ϵͳ�ı��*/
	private String appNumber;
    /**
     *  �����·���չ�ţ���һλ�������ͱ�ʶ�Ͳ�����6λ�Ķ���Ψһ��ʶ��ɡ��ܳ��Ȳ�����7λ
     **/
	private String exNumber;
    /**
     * ���ŷ���Ŀ���ֻ����룬�ֻ����벻�ܳ���2^32 ����
     **/
	private String phone;
    /**
     * �����������ݡ�
     **/
	private String message;
    /**
     * �ύ�Ķ����Ƿ���Ҫ��ʱ���ͣ�0��ʾ������Ҫ�������ͣ�1��ʾ������Ҫ��ʱ���͡� 
     **/
	private int timeFlag;
    /**
     *  ���Ŷ�ʱ����ʱ�䡣��ֵ����UTC��Э������ʱ�䣩��׼��1970��1��1��0��0��0������ǰʱ��ĺ�������
     **/
	private long smsTime;
    /** 
     * �����ֶΣ��Ա��Ժ���չʹ�ã���null��ֵ��
     **/
	private String msgFlag;
	/**
	 * 
	 * ���Ž����ˣ�0 �����ˣ�1 �������� 2�鿱��
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
