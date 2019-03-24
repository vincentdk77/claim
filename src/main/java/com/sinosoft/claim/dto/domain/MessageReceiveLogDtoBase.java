package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是MessageReceiveLog的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class MessageReceiveLogDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性RuleCode */
    private String ruleCode = "";
    /** 属性ModuleCode */
    private String moduleCode = "";
    /** 属性BusinessNo1 */
    private String businessNo1 = "";
    /** 属性BusinessNo2 */
    private String businessNo2 = "";
    /** 属性BusinessNo3 */
    private String businessNo3 = "";
    /** 属性BusinessNo4 */
    private String businessNo4 = "";
    /** 属性BusinessNo5 */
    private String businessNo5 = "";
    /** 属性SendTime */
    private DateTime sendTime = new DateTime();
    /** 属性SendText */
    private String sendText = "";
    /** 属性SendPhone */
    private String sendPhone = "";
    /** 属性ReceiveTime */
    private DateTime receiveTime = new DateTime();
    /** 属性ReceiveText */
    private String receiveText = "";
    /** 属性ReceivePhone */
    private String receivePhone = "";
    /** 属性Month */
    private String month = "";

    /**
     *  默认构造方法,构造一个默认的MessageReceiveLogDtoBase对象
     */
    public MessageReceiveLogDtoBase(){
    }

    /**
     * 设置属性RuleCode
     * @param ruleCode 待设置的属性RuleCode的值
     */
    public void setRuleCode(String ruleCode){
        this.ruleCode = StringUtils.rightTrim(ruleCode);
    }

    /**
     * 获取属性RuleCode
     * @return 属性RuleCode的值
     */
    public String getRuleCode(){
        return ruleCode;
    }

    /**
     * 设置属性ModuleCode
     * @param moduleCode 待设置的属性ModuleCode的值
     */
    public void setModuleCode(String moduleCode){
        this.moduleCode = StringUtils.rightTrim(moduleCode);
    }

    /**
     * 获取属性ModuleCode
     * @return 属性ModuleCode的值
     */
    public String getModuleCode(){
        return moduleCode;
    }

    /**
     * 设置属性BusinessNo1
     * @param businessNo1 待设置的属性BusinessNo1的值
     */
    public void setBusinessNo1(String businessNo1){
        this.businessNo1 = StringUtils.rightTrim(businessNo1);
    }

    /**
     * 获取属性BusinessNo1
     * @return 属性BusinessNo1的值
     */
    public String getBusinessNo1(){
        return businessNo1;
    }

    /**
     * 设置属性BusinessNo2
     * @param businessNo2 待设置的属性BusinessNo2的值
     */
    public void setBusinessNo2(String businessNo2){
        this.businessNo2 = StringUtils.rightTrim(businessNo2);
    }

    /**
     * 获取属性BusinessNo2
     * @return 属性BusinessNo2的值
     */
    public String getBusinessNo2(){
        return businessNo2;
    }

    /**
     * 设置属性BusinessNo3
     * @param businessNo3 待设置的属性BusinessNo3的值
     */
    public void setBusinessNo3(String businessNo3){
        this.businessNo3 = StringUtils.rightTrim(businessNo3);
    }

    /**
     * 获取属性BusinessNo3
     * @return 属性BusinessNo3的值
     */
    public String getBusinessNo3(){
        return businessNo3;
    }

    /**
     * 设置属性BusinessNo4
     * @param businessNo4 待设置的属性BusinessNo4的值
     */
    public void setBusinessNo4(String businessNo4){
        this.businessNo4 = StringUtils.rightTrim(businessNo4);
    }

    /**
     * 获取属性BusinessNo4
     * @return 属性BusinessNo4的值
     */
    public String getBusinessNo4(){
        return businessNo4;
    }

    /**
     * 设置属性BusinessNo5
     * @param businessNo5 待设置的属性BusinessNo5的值
     */
    public void setBusinessNo5(String businessNo5){
        this.businessNo5 = StringUtils.rightTrim(businessNo5);
    }

    /**
     * 获取属性BusinessNo5
     * @return 属性BusinessNo5的值
     */
    public String getBusinessNo5(){
        return businessNo5;
    }

    /**
     * 设置属性SendTime
     * @param sendTime 待设置的属性SendTime的值
     */
    public void setSendTime(DateTime sendTime){
        this.sendTime = sendTime;
    }

    /**
     * 获取属性SendTime
     * @return 属性SendTime的值
     */
    public DateTime getSendTime(){
        return sendTime;
    }

    /**
     * 设置属性SendText
     * @param sendText 待设置的属性SendText的值
     */
    public void setSendText(String sendText){
        this.sendText = StringUtils.rightTrim(sendText);
    }

    /**
     * 获取属性SendText
     * @return 属性SendText的值
     */
    public String getSendText(){
        return sendText;
    }

    /**
     * 设置属性SendPhone
     * @param sendPhone 待设置的属性SendPhone的值
     */
    public void setSendPhone(String sendPhone){
        this.sendPhone = StringUtils.rightTrim(sendPhone);
    }

    /**
     * 获取属性SendPhone
     * @return 属性SendPhone的值
     */
    public String getSendPhone(){
        return sendPhone;
    }

    /**
     * 设置属性ReceiveTime
     * @param receiveTime 待设置的属性ReceiveTime的值
     */
    public void setReceiveTime(DateTime receiveTime){
        this.receiveTime = receiveTime;
    }

    /**
     * 获取属性ReceiveTime
     * @return 属性ReceiveTime的值
     */
    public DateTime getReceiveTime(){
        return receiveTime;
    }

    /**
     * 设置属性ReceiveText
     * @param receiveText 待设置的属性ReceiveText的值
     */
    public void setReceiveText(String receiveText){
        this.receiveText = StringUtils.rightTrim(receiveText);
    }

    /**
     * 获取属性ReceiveText
     * @return 属性ReceiveText的值
     */
    public String getReceiveText(){
        return receiveText;
    }

    /**
     * 设置属性ReceivePhone
     * @param receivePhone 待设置的属性ReceivePhone的值
     */
    public void setReceivePhone(String receivePhone){
        this.receivePhone = StringUtils.rightTrim(receivePhone);
    }

    /**
     * 获取属性ReceivePhone
     * @return 属性ReceivePhone的值
     */
    public String getReceivePhone(){
        return receivePhone;
    }

    /**
     * 设置属性Month
     * @param month 待设置的属性Month的值
     */
    public void setMonth(String month){
        this.month = StringUtils.rightTrim(month);
    }

    /**
     * 获取属性Month
     * @return 属性Month的值
     */
    public String getMonth(){
        return month;
    }
}
