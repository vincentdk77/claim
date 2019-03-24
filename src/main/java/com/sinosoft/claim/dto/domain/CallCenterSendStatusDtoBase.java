package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CallCenterSendStatus的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CallCenterSendStatusDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性serial */
    private double serial = 0D;
    /** 属性registNo */
    private String registNo = "";
    /** 属性caseStatus */
    private String caseStatus = "";
    /** 属性communicationNo */
    private String communicationNo = "";
    /** 属性userCode */
    private String userCode = "";
    /** 属性sendSystem */
    private String sendSystem = "";
    /** 属性sendStatus */
    private String sendStatus = "";
    /** 属性sendTime */
    private DateTime sendTime = new DateTime();
    /** 属性againSendTime */
    private DateTime againSendTime = new DateTime();
    /** 属性sendType */
    private String sendType = "";

    /**
     *  默认构造方法,构造一个默认的CallCenterSendStatusDtoBase对象
     */
    public CallCenterSendStatusDtoBase(){
    }

    /**
     * 设置属性serial
     * @param serial 待设置的属性serial的值
     */
    public void setSerial(double serial){
        this.serial = serial;
    }

    /**
     * 获取属性serial
     * @return 属性serial的值
     */
    public double getSerial(){
        return serial;
    }

    /**
     * 设置属性registNo
     * @param registNo 待设置的属性registNo的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性registNo
     * @return 属性registNo的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性caseStatus
     * @param caseStatus 待设置的属性caseStatus的值
     */
    public void setCaseStatus(String caseStatus){
        this.caseStatus = StringUtils.rightTrim(caseStatus);
    }

    /**
     * 获取属性caseStatus
     * @return 属性caseStatus的值
     */
    public String getCaseStatus(){
        return caseStatus;
    }

    /**
     * 设置属性communicationNo
     * @param communicationNo 待设置的属性communicationNo的值
     */
    public void setCommunicationNo(String communicationNo){
        this.communicationNo = StringUtils.rightTrim(communicationNo);
    }

    /**
     * 获取属性communicationNo
     * @return 属性communicationNo的值
     */
    public String getCommunicationNo(){
        return communicationNo;
    }

    /**
     * 设置属性userCode
     * @param userCode 待设置的属性userCode的值
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * 获取属性userCode
     * @return 属性userCode的值
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * 设置属性sendSystem
     * @param sendSystem 待设置的属性sendSystem的值
     */
    public void setSendSystem(String sendSystem){
        this.sendSystem = StringUtils.rightTrim(sendSystem);
    }

    /**
     * 获取属性sendSystem
     * @return 属性sendSystem的值
     */
    public String getSendSystem(){
        return sendSystem;
    }

    /**
     * 设置属性sendStatus
     * @param sendStatus 待设置的属性sendStatus的值
     */
    public void setSendStatus(String sendStatus){
        this.sendStatus = StringUtils.rightTrim(sendStatus);
    }

    /**
     * 获取属性sendStatus
     * @return 属性sendStatus的值
     */
    public String getSendStatus(){
        return sendStatus;
    }

    /**
     * 设置属性sendTime
     * @param sendTime 待设置的属性sendTime的值
     */
    public void setSendTime(DateTime sendTime){
        this.sendTime = sendTime;
    }

    /**
     * 获取属性sendTime
     * @return 属性sendTime的值
     */
    public DateTime getSendTime(){
        return sendTime;
    }

    /**
     * 设置属性againSendTime
     * @param againSendTime 待设置的属性againSendTime的值
     */
    public void setAgainSendTime(DateTime againSendTime){
        this.againSendTime = againSendTime;
    }

    /**
     * 获取属性againSendTime
     * @return 属性againSendTime的值
     */
    public DateTime getAgainSendTime(){
        return againSendTime;
    }

    /**
     * 设置属性sendType
     * @param sendType 待设置的属性sendType的值
     */
    public void setSendType(String sendType){
        this.sendType = StringUtils.rightTrim(sendType);
    }

    /**
     * 获取属性sendType
     * @return 属性sendType的值
     */
    public String getSendType(){
        return sendType;
    }
    /**
     * @param message 1：接收成功，0：接收失败，"":发送出错
     * @param sendType 0：实时发送，1：定时任务发送，2：手工发送
     */
    public void setSendStatus(String message,String sendType){
    	if("0".equals(sendType)){//实时发送
			if("1".equals(message)){
				this.setSendStatus("02");
			}else if("0".equals(message)){
				this.setSendStatus("01");
			}else{
				this.setSendStatus("00");
			}
		}else if("1".equals(sendType)){//定时任务
			if("1".equals(message)){
				this.setSendStatus("22");
			}else if("0".equals(message)){
				this.setSendStatus("21");
			}else{
				this.setSendStatus("20");
			}
		}else if("2".equals(sendType)){//手工发送
			if("1".equals(message)){
				this.setSendStatus("12");
			}else if("0".equals(message)){
				this.setSendStatus("11");
			}else{
				this.setSendStatus("10");
			}
		}
    }
}
