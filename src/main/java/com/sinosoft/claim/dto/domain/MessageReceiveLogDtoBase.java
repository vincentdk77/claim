package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����MessageReceiveLog�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class MessageReceiveLogDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����RuleCode */
    private String ruleCode = "";
    /** ����ModuleCode */
    private String moduleCode = "";
    /** ����BusinessNo1 */
    private String businessNo1 = "";
    /** ����BusinessNo2 */
    private String businessNo2 = "";
    /** ����BusinessNo3 */
    private String businessNo3 = "";
    /** ����BusinessNo4 */
    private String businessNo4 = "";
    /** ����BusinessNo5 */
    private String businessNo5 = "";
    /** ����SendTime */
    private DateTime sendTime = new DateTime();
    /** ����SendText */
    private String sendText = "";
    /** ����SendPhone */
    private String sendPhone = "";
    /** ����ReceiveTime */
    private DateTime receiveTime = new DateTime();
    /** ����ReceiveText */
    private String receiveText = "";
    /** ����ReceivePhone */
    private String receivePhone = "";
    /** ����Month */
    private String month = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�MessageReceiveLogDtoBase����
     */
    public MessageReceiveLogDtoBase(){
    }

    /**
     * ��������RuleCode
     * @param ruleCode �����õ�����RuleCode��ֵ
     */
    public void setRuleCode(String ruleCode){
        this.ruleCode = StringUtils.rightTrim(ruleCode);
    }

    /**
     * ��ȡ����RuleCode
     * @return ����RuleCode��ֵ
     */
    public String getRuleCode(){
        return ruleCode;
    }

    /**
     * ��������ModuleCode
     * @param moduleCode �����õ�����ModuleCode��ֵ
     */
    public void setModuleCode(String moduleCode){
        this.moduleCode = StringUtils.rightTrim(moduleCode);
    }

    /**
     * ��ȡ����ModuleCode
     * @return ����ModuleCode��ֵ
     */
    public String getModuleCode(){
        return moduleCode;
    }

    /**
     * ��������BusinessNo1
     * @param businessNo1 �����õ�����BusinessNo1��ֵ
     */
    public void setBusinessNo1(String businessNo1){
        this.businessNo1 = StringUtils.rightTrim(businessNo1);
    }

    /**
     * ��ȡ����BusinessNo1
     * @return ����BusinessNo1��ֵ
     */
    public String getBusinessNo1(){
        return businessNo1;
    }

    /**
     * ��������BusinessNo2
     * @param businessNo2 �����õ�����BusinessNo2��ֵ
     */
    public void setBusinessNo2(String businessNo2){
        this.businessNo2 = StringUtils.rightTrim(businessNo2);
    }

    /**
     * ��ȡ����BusinessNo2
     * @return ����BusinessNo2��ֵ
     */
    public String getBusinessNo2(){
        return businessNo2;
    }

    /**
     * ��������BusinessNo3
     * @param businessNo3 �����õ�����BusinessNo3��ֵ
     */
    public void setBusinessNo3(String businessNo3){
        this.businessNo3 = StringUtils.rightTrim(businessNo3);
    }

    /**
     * ��ȡ����BusinessNo3
     * @return ����BusinessNo3��ֵ
     */
    public String getBusinessNo3(){
        return businessNo3;
    }

    /**
     * ��������BusinessNo4
     * @param businessNo4 �����õ�����BusinessNo4��ֵ
     */
    public void setBusinessNo4(String businessNo4){
        this.businessNo4 = StringUtils.rightTrim(businessNo4);
    }

    /**
     * ��ȡ����BusinessNo4
     * @return ����BusinessNo4��ֵ
     */
    public String getBusinessNo4(){
        return businessNo4;
    }

    /**
     * ��������BusinessNo5
     * @param businessNo5 �����õ�����BusinessNo5��ֵ
     */
    public void setBusinessNo5(String businessNo5){
        this.businessNo5 = StringUtils.rightTrim(businessNo5);
    }

    /**
     * ��ȡ����BusinessNo5
     * @return ����BusinessNo5��ֵ
     */
    public String getBusinessNo5(){
        return businessNo5;
    }

    /**
     * ��������SendTime
     * @param sendTime �����õ�����SendTime��ֵ
     */
    public void setSendTime(DateTime sendTime){
        this.sendTime = sendTime;
    }

    /**
     * ��ȡ����SendTime
     * @return ����SendTime��ֵ
     */
    public DateTime getSendTime(){
        return sendTime;
    }

    /**
     * ��������SendText
     * @param sendText �����õ�����SendText��ֵ
     */
    public void setSendText(String sendText){
        this.sendText = StringUtils.rightTrim(sendText);
    }

    /**
     * ��ȡ����SendText
     * @return ����SendText��ֵ
     */
    public String getSendText(){
        return sendText;
    }

    /**
     * ��������SendPhone
     * @param sendPhone �����õ�����SendPhone��ֵ
     */
    public void setSendPhone(String sendPhone){
        this.sendPhone = StringUtils.rightTrim(sendPhone);
    }

    /**
     * ��ȡ����SendPhone
     * @return ����SendPhone��ֵ
     */
    public String getSendPhone(){
        return sendPhone;
    }

    /**
     * ��������ReceiveTime
     * @param receiveTime �����õ�����ReceiveTime��ֵ
     */
    public void setReceiveTime(DateTime receiveTime){
        this.receiveTime = receiveTime;
    }

    /**
     * ��ȡ����ReceiveTime
     * @return ����ReceiveTime��ֵ
     */
    public DateTime getReceiveTime(){
        return receiveTime;
    }

    /**
     * ��������ReceiveText
     * @param receiveText �����õ�����ReceiveText��ֵ
     */
    public void setReceiveText(String receiveText){
        this.receiveText = StringUtils.rightTrim(receiveText);
    }

    /**
     * ��ȡ����ReceiveText
     * @return ����ReceiveText��ֵ
     */
    public String getReceiveText(){
        return receiveText;
    }

    /**
     * ��������ReceivePhone
     * @param receivePhone �����õ�����ReceivePhone��ֵ
     */
    public void setReceivePhone(String receivePhone){
        this.receivePhone = StringUtils.rightTrim(receivePhone);
    }

    /**
     * ��ȡ����ReceivePhone
     * @return ����ReceivePhone��ֵ
     */
    public String getReceivePhone(){
        return receivePhone;
    }

    /**
     * ��������Month
     * @param month �����õ�����Month��ֵ
     */
    public void setMonth(String month){
        this.month = StringUtils.rightTrim(month);
    }

    /**
     * ��ȡ����Month
     * @return ����Month��ֵ
     */
    public String getMonth(){
        return month;
    }
}
