package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CallCenterSendStatus�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CallCenterSendStatusDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����serial */
    private double serial = 0D;
    /** ����registNo */
    private String registNo = "";
    /** ����caseStatus */
    private String caseStatus = "";
    /** ����communicationNo */
    private String communicationNo = "";
    /** ����userCode */
    private String userCode = "";
    /** ����sendSystem */
    private String sendSystem = "";
    /** ����sendStatus */
    private String sendStatus = "";
    /** ����sendTime */
    private DateTime sendTime = new DateTime();
    /** ����againSendTime */
    private DateTime againSendTime = new DateTime();
    /** ����sendType */
    private String sendType = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CallCenterSendStatusDtoBase����
     */
    public CallCenterSendStatusDtoBase(){
    }

    /**
     * ��������serial
     * @param serial �����õ�����serial��ֵ
     */
    public void setSerial(double serial){
        this.serial = serial;
    }

    /**
     * ��ȡ����serial
     * @return ����serial��ֵ
     */
    public double getSerial(){
        return serial;
    }

    /**
     * ��������registNo
     * @param registNo �����õ�����registNo��ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ����registNo
     * @return ����registNo��ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ��������caseStatus
     * @param caseStatus �����õ�����caseStatus��ֵ
     */
    public void setCaseStatus(String caseStatus){
        this.caseStatus = StringUtils.rightTrim(caseStatus);
    }

    /**
     * ��ȡ����caseStatus
     * @return ����caseStatus��ֵ
     */
    public String getCaseStatus(){
        return caseStatus;
    }

    /**
     * ��������communicationNo
     * @param communicationNo �����õ�����communicationNo��ֵ
     */
    public void setCommunicationNo(String communicationNo){
        this.communicationNo = StringUtils.rightTrim(communicationNo);
    }

    /**
     * ��ȡ����communicationNo
     * @return ����communicationNo��ֵ
     */
    public String getCommunicationNo(){
        return communicationNo;
    }

    /**
     * ��������userCode
     * @param userCode �����õ�����userCode��ֵ
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * ��ȡ����userCode
     * @return ����userCode��ֵ
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * ��������sendSystem
     * @param sendSystem �����õ�����sendSystem��ֵ
     */
    public void setSendSystem(String sendSystem){
        this.sendSystem = StringUtils.rightTrim(sendSystem);
    }

    /**
     * ��ȡ����sendSystem
     * @return ����sendSystem��ֵ
     */
    public String getSendSystem(){
        return sendSystem;
    }

    /**
     * ��������sendStatus
     * @param sendStatus �����õ�����sendStatus��ֵ
     */
    public void setSendStatus(String sendStatus){
        this.sendStatus = StringUtils.rightTrim(sendStatus);
    }

    /**
     * ��ȡ����sendStatus
     * @return ����sendStatus��ֵ
     */
    public String getSendStatus(){
        return sendStatus;
    }

    /**
     * ��������sendTime
     * @param sendTime �����õ�����sendTime��ֵ
     */
    public void setSendTime(DateTime sendTime){
        this.sendTime = sendTime;
    }

    /**
     * ��ȡ����sendTime
     * @return ����sendTime��ֵ
     */
    public DateTime getSendTime(){
        return sendTime;
    }

    /**
     * ��������againSendTime
     * @param againSendTime �����õ�����againSendTime��ֵ
     */
    public void setAgainSendTime(DateTime againSendTime){
        this.againSendTime = againSendTime;
    }

    /**
     * ��ȡ����againSendTime
     * @return ����againSendTime��ֵ
     */
    public DateTime getAgainSendTime(){
        return againSendTime;
    }

    /**
     * ��������sendType
     * @param sendType �����õ�����sendType��ֵ
     */
    public void setSendType(String sendType){
        this.sendType = StringUtils.rightTrim(sendType);
    }

    /**
     * ��ȡ����sendType
     * @return ����sendType��ֵ
     */
    public String getSendType(){
        return sendType;
    }
    /**
     * @param message 1�����ճɹ���0������ʧ�ܣ�"":���ͳ���
     * @param sendType 0��ʵʱ���ͣ�1����ʱ�����ͣ�2���ֹ�����
     */
    public void setSendStatus(String message,String sendType){
    	if("0".equals(sendType)){//ʵʱ����
			if("1".equals(message)){
				this.setSendStatus("02");
			}else if("0".equals(message)){
				this.setSendStatus("01");
			}else{
				this.setSendStatus("00");
			}
		}else if("1".equals(sendType)){//��ʱ����
			if("1".equals(message)){
				this.setSendStatus("22");
			}else if("0".equals(message)){
				this.setSendStatus("21");
			}else{
				this.setSendStatus("20");
			}
		}else if("2".equals(sendType)){//�ֹ�����
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
