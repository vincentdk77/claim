package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdagent�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDagentDtoBase implements Serializable{
    /** ����agentcode */
    private String agentCode = "";
    /** ����agentname */
    private String agentName = "";
    /** ����addressname */
    private String addressName = "";
    /** ����postcode */
    private String postCode = "";
    /** ����agenttype */
    private String agentType = "";
    /** ����permitno */
    private String permitNo = "";
    /** ����linkername */
    private String linkerName = "";
    /** ����bargaindate */
    private DateTime bargainDate = new DateTime();
    /** ����phonenumber */
    private String phoneNumber = "";
    /** ����faxnumber */
    private String faxNumber = "";
    /** ����comcode */
    private String comCode = "";
    /** ����handlercode */
    private String handlerCode = "";
    /** ����upperagentcode */
    private String upperAgentCode = "";
    /** ����newagentcode */
    private String newAgentCode = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����articlecode */
    private String articleCode = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDagentDtoBase����
     */
    public PrpDagentDtoBase(){
    }

    /**
     * ��������agentcode
     * @param agentCode �����õ�����agentcode��ֵ
     */
    public void setAgentCode(String agentCode){
        this.agentCode = StringUtils.rightTrim(agentCode);
    }

    /**
     * ��ȡ����agentcode
     * @return ����agentcode��ֵ
     */
    public String getAgentCode(){
        return agentCode;
    }

    /**
     * ��������agentname
     * @param agentName �����õ�����agentname��ֵ
     */
    public void setAgentName(String agentName){
        this.agentName = StringUtils.rightTrim(agentName);
    }

    /**
     * ��ȡ����agentname
     * @return ����agentname��ֵ
     */
    public String getAgentName(){
        return agentName;
    }

    /**
     * ��������addressname
     * @param addressName �����õ�����addressname��ֵ
     */
    public void setAddressName(String addressName){
        this.addressName = StringUtils.rightTrim(addressName);
    }

    /**
     * ��ȡ����addressname
     * @return ����addressname��ֵ
     */
    public String getAddressName(){
        return addressName;
    }

    /**
     * ��������postcode
     * @param postCode �����õ�����postcode��ֵ
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * ��ȡ����postcode
     * @return ����postcode��ֵ
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * ��������agenttype
     * @param agentType �����õ�����agenttype��ֵ
     */
    public void setAgentType(String agentType){
        this.agentType = StringUtils.rightTrim(agentType);
    }

    /**
     * ��ȡ����agenttype
     * @return ����agenttype��ֵ
     */
    public String getAgentType(){
        return agentType;
    }

    /**
     * ��������permitno
     * @param permitNo �����õ�����permitno��ֵ
     */
    public void setPermitNo(String permitNo){
        this.permitNo = StringUtils.rightTrim(permitNo);
    }

    /**
     * ��ȡ����permitno
     * @return ����permitno��ֵ
     */
    public String getPermitNo(){
        return permitNo;
    }

    /**
     * ��������linkername
     * @param linkerName �����õ�����linkername��ֵ
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * ��ȡ����linkername
     * @return ����linkername��ֵ
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * ��������bargaindate
     * @param bargainDate �����õ�����bargaindate��ֵ
     */
    public void setBargainDate(DateTime bargainDate){
        this.bargainDate = bargainDate;
    }

    /**
     * ��ȡ����bargaindate
     * @return ����bargaindate��ֵ
     */
    public DateTime getBargainDate(){
        return bargainDate;
    }

    /**
     * ��������phonenumber
     * @param phoneNumber �����õ�����phonenumber��ֵ
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * ��ȡ����phonenumber
     * @return ����phonenumber��ֵ
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * ��������faxnumber
     * @param faxNumber �����õ�����faxnumber��ֵ
     */
    public void setFaxNumber(String faxNumber){
        this.faxNumber = StringUtils.rightTrim(faxNumber);
    }

    /**
     * ��ȡ����faxnumber
     * @return ����faxnumber��ֵ
     */
    public String getFaxNumber(){
        return faxNumber;
    }

    /**
     * ��������comcode
     * @param comCode �����õ�����comcode��ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����comcode
     * @return ����comcode��ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������handlercode
     * @param handlerCode �����õ�����handlercode��ֵ
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * ��ȡ����handlercode
     * @return ����handlercode��ֵ
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * ��������upperagentcode
     * @param upperAgentCode �����õ�����upperagentcode��ֵ
     */
    public void setUpperAgentCode(String upperAgentCode){
        this.upperAgentCode = StringUtils.rightTrim(upperAgentCode);
    }

    /**
     * ��ȡ����upperagentcode
     * @return ����upperagentcode��ֵ
     */
    public String getUpperAgentCode(){
        return upperAgentCode;
    }

    /**
     * ��������newagentcode
     * @param newAgentCode �����õ�����newagentcode��ֵ
     */
    public void setNewAgentCode(String newAgentCode){
        this.newAgentCode = StringUtils.rightTrim(newAgentCode);
    }

    /**
     * ��ȡ����newagentcode
     * @return ����newagentcode��ֵ
     */
    public String getNewAgentCode(){
        return newAgentCode;
    }

    /**
     * ��������validstatus
     * @param validStatus �����õ�����validstatus��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����validstatus
     * @return ����validstatus��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������articlecode
     * @param articleCode �����õ�����articlecode��ֵ
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * ��ȡ����articlecode
     * @return ����articlecode��ֵ
     */
    public String getArticleCode(){
        return articleCode;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
