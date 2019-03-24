package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdcustomer�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcustomerDtoBase implements Serializable{
    /** ����customertype */
    private String customerType = "";
    /** ����customercode */
    private String customerCode = "";
    /** ����shorthandcode */
    private String shortHandCode = "";
    /** ����customercname */
    private String customerCName = "";
    /** ����customerename */
    private String customerEName = "";
    /** ����addresscname */
    private String addressCName = "";
    /** ����addressename */
    private String addressEName = "";
    /** ����organizecode */
    private String organizeCode = "";
    /** ����fathercode */
    private String fatherCode = "";
    /** ����blackstate */
    private String blackState = "";
    /** ����customerkind */
    private String customerKind = "";
    /** ����customerflag */
    private String customerFlag = "";
    /** ����articlecode */
    private String articleCode = "";
    /** ����validstatus */
    private String validStatus = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcustomerDtoBase����
     */
    public PrpDcustomerDtoBase(){
    }

    /**
     * ��������customertype
     * @param customerType �����õ�����customertype��ֵ
     */
    public void setCustomerType(String customerType){
        this.customerType = StringUtils.rightTrim(customerType);
    }

    /**
     * ��ȡ����customertype
     * @return ����customertype��ֵ
     */
    public String getCustomerType(){
        return customerType;
    }

    /**
     * ��������customercode
     * @param customerCode �����õ�����customercode��ֵ
     */
    public void setCustomerCode(String customerCode){
        this.customerCode = StringUtils.rightTrim(customerCode);
    }

    /**
     * ��ȡ����customercode
     * @return ����customercode��ֵ
     */
    public String getCustomerCode(){
        return customerCode;
    }

    /**
     * ��������shorthandcode
     * @param shortHandCode �����õ�����shorthandcode��ֵ
     */
    public void setShortHandCode(String shortHandCode){
        this.shortHandCode = StringUtils.rightTrim(shortHandCode);
    }

    /**
     * ��ȡ����shorthandcode
     * @return ����shorthandcode��ֵ
     */
    public String getShortHandCode(){
        return shortHandCode;
    }

    /**
     * ��������customercname
     * @param customerCName �����õ�����customercname��ֵ
     */
    public void setCustomerCName(String customerCName){
        this.customerCName = StringUtils.rightTrim(customerCName);
    }

    /**
     * ��ȡ����customercname
     * @return ����customercname��ֵ
     */
    public String getCustomerCName(){
        return customerCName;
    }

    /**
     * ��������customerename
     * @param customerEName �����õ�����customerename��ֵ
     */
    public void setCustomerEName(String customerEName){
        this.customerEName = StringUtils.rightTrim(customerEName);
    }

    /**
     * ��ȡ����customerename
     * @return ����customerename��ֵ
     */
    public String getCustomerEName(){
        return customerEName;
    }

    /**
     * ��������addresscname
     * @param addressCName �����õ�����addresscname��ֵ
     */
    public void setAddressCName(String addressCName){
        this.addressCName = StringUtils.rightTrim(addressCName);
    }

    /**
     * ��ȡ����addresscname
     * @return ����addresscname��ֵ
     */
    public String getAddressCName(){
        return addressCName;
    }

    /**
     * ��������addressename
     * @param addressEName �����õ�����addressename��ֵ
     */
    public void setAddressEName(String addressEName){
        this.addressEName = StringUtils.rightTrim(addressEName);
    }

    /**
     * ��ȡ����addressename
     * @return ����addressename��ֵ
     */
    public String getAddressEName(){
        return addressEName;
    }

    /**
     * ��������organizecode
     * @param organizeCode �����õ�����organizecode��ֵ
     */
    public void setOrganizeCode(String organizeCode){
        this.organizeCode = StringUtils.rightTrim(organizeCode);
    }

    /**
     * ��ȡ����organizecode
     * @return ����organizecode��ֵ
     */
    public String getOrganizeCode(){
        return organizeCode;
    }

    /**
     * ��������fathercode
     * @param fatherCode �����õ�����fathercode��ֵ
     */
    public void setFatherCode(String fatherCode){
        this.fatherCode = StringUtils.rightTrim(fatherCode);
    }

    /**
     * ��ȡ����fathercode
     * @return ����fathercode��ֵ
     */
    public String getFatherCode(){
        return fatherCode;
    }

    /**
     * ��������blackstate
     * @param blackState �����õ�����blackstate��ֵ
     */
    public void setBlackState(String blackState){
        this.blackState = StringUtils.rightTrim(blackState);
    }

    /**
     * ��ȡ����blackstate
     * @return ����blackstate��ֵ
     */
    public String getBlackState(){
        return blackState;
    }

    /**
     * ��������customerkind
     * @param customerKind �����õ�����customerkind��ֵ
     */
    public void setCustomerKind(String customerKind){
        this.customerKind = StringUtils.rightTrim(customerKind);
    }

    /**
     * ��ȡ����customerkind
     * @return ����customerkind��ֵ
     */
    public String getCustomerKind(){
        return customerKind;
    }

    /**
     * ��������customerflag
     * @param customerFlag �����õ�����customerflag��ֵ
     */
    public void setCustomerFlag(String customerFlag){
        this.customerFlag = StringUtils.rightTrim(customerFlag);
    }

    /**
     * ��ȡ����customerflag
     * @return ����customerflag��ֵ
     */
    public String getCustomerFlag(){
        return customerFlag;
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
}
