package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdagent的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDagentDtoBase implements Serializable{
    /** 属性agentcode */
    private String agentCode = "";
    /** 属性agentname */
    private String agentName = "";
    /** 属性addressname */
    private String addressName = "";
    /** 属性postcode */
    private String postCode = "";
    /** 属性agenttype */
    private String agentType = "";
    /** 属性permitno */
    private String permitNo = "";
    /** 属性linkername */
    private String linkerName = "";
    /** 属性bargaindate */
    private DateTime bargainDate = new DateTime();
    /** 属性phonenumber */
    private String phoneNumber = "";
    /** 属性faxnumber */
    private String faxNumber = "";
    /** 属性comcode */
    private String comCode = "";
    /** 属性handlercode */
    private String handlerCode = "";
    /** 属性upperagentcode */
    private String upperAgentCode = "";
    /** 属性newagentcode */
    private String newAgentCode = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性articlecode */
    private String articleCode = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDagentDtoBase对象
     */
    public PrpDagentDtoBase(){
    }

    /**
     * 设置属性agentcode
     * @param agentCode 待设置的属性agentcode的值
     */
    public void setAgentCode(String agentCode){
        this.agentCode = StringUtils.rightTrim(agentCode);
    }

    /**
     * 获取属性agentcode
     * @return 属性agentcode的值
     */
    public String getAgentCode(){
        return agentCode;
    }

    /**
     * 设置属性agentname
     * @param agentName 待设置的属性agentname的值
     */
    public void setAgentName(String agentName){
        this.agentName = StringUtils.rightTrim(agentName);
    }

    /**
     * 获取属性agentname
     * @return 属性agentname的值
     */
    public String getAgentName(){
        return agentName;
    }

    /**
     * 设置属性addressname
     * @param addressName 待设置的属性addressname的值
     */
    public void setAddressName(String addressName){
        this.addressName = StringUtils.rightTrim(addressName);
    }

    /**
     * 获取属性addressname
     * @return 属性addressname的值
     */
    public String getAddressName(){
        return addressName;
    }

    /**
     * 设置属性postcode
     * @param postCode 待设置的属性postcode的值
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * 获取属性postcode
     * @return 属性postcode的值
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * 设置属性agenttype
     * @param agentType 待设置的属性agenttype的值
     */
    public void setAgentType(String agentType){
        this.agentType = StringUtils.rightTrim(agentType);
    }

    /**
     * 获取属性agenttype
     * @return 属性agenttype的值
     */
    public String getAgentType(){
        return agentType;
    }

    /**
     * 设置属性permitno
     * @param permitNo 待设置的属性permitno的值
     */
    public void setPermitNo(String permitNo){
        this.permitNo = StringUtils.rightTrim(permitNo);
    }

    /**
     * 获取属性permitno
     * @return 属性permitno的值
     */
    public String getPermitNo(){
        return permitNo;
    }

    /**
     * 设置属性linkername
     * @param linkerName 待设置的属性linkername的值
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * 获取属性linkername
     * @return 属性linkername的值
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * 设置属性bargaindate
     * @param bargainDate 待设置的属性bargaindate的值
     */
    public void setBargainDate(DateTime bargainDate){
        this.bargainDate = bargainDate;
    }

    /**
     * 获取属性bargaindate
     * @return 属性bargaindate的值
     */
    public DateTime getBargainDate(){
        return bargainDate;
    }

    /**
     * 设置属性phonenumber
     * @param phoneNumber 待设置的属性phonenumber的值
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * 获取属性phonenumber
     * @return 属性phonenumber的值
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * 设置属性faxnumber
     * @param faxNumber 待设置的属性faxnumber的值
     */
    public void setFaxNumber(String faxNumber){
        this.faxNumber = StringUtils.rightTrim(faxNumber);
    }

    /**
     * 获取属性faxnumber
     * @return 属性faxnumber的值
     */
    public String getFaxNumber(){
        return faxNumber;
    }

    /**
     * 设置属性comcode
     * @param comCode 待设置的属性comcode的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性comcode
     * @return 属性comcode的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性handlercode
     * @param handlerCode 待设置的属性handlercode的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性handlercode
     * @return 属性handlercode的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性upperagentcode
     * @param upperAgentCode 待设置的属性upperagentcode的值
     */
    public void setUpperAgentCode(String upperAgentCode){
        this.upperAgentCode = StringUtils.rightTrim(upperAgentCode);
    }

    /**
     * 获取属性upperagentcode
     * @return 属性upperagentcode的值
     */
    public String getUpperAgentCode(){
        return upperAgentCode;
    }

    /**
     * 设置属性newagentcode
     * @param newAgentCode 待设置的属性newagentcode的值
     */
    public void setNewAgentCode(String newAgentCode){
        this.newAgentCode = StringUtils.rightTrim(newAgentCode);
    }

    /**
     * 获取属性newagentcode
     * @return 属性newagentcode的值
     */
    public String getNewAgentCode(){
        return newAgentCode;
    }

    /**
     * 设置属性validstatus
     * @param validStatus 待设置的属性validstatus的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性validstatus
     * @return 属性validstatus的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性articlecode
     * @param articleCode 待设置的属性articlecode的值
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * 获取属性articlecode
     * @return 属性articlecode的值
     */
    public String getArticleCode(){
        return articleCode;
    }

    /**
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public String getFlag(){
        return flag;
    }
}
