package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdidentifier�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDidentifierDtoBase implements Serializable{
    /** ����identifiercode */
    private String identifierCode = "";
    /** ����countrycode */
    private String countryCode = "";
    /** ����countrycname */
    private String countryCName = "";
    /** ����countryename */
    private String countryEName = "";
    /** ����portcode */
    private String portCode = "";
    /** ����portname */
    private String portName = "";
    /** ����identifierorder */
    private int identifierOrder = 0;
    /** ����identifiername */
    private String identifierName = "";
    /** ����identifieraddress */
    private String identifierAddress = "";
    /** ����identifiertype */
    private String identifierType = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDidentifierDtoBase����
     */
    public PrpDidentifierDtoBase(){
    }

    /**
     * ��������identifiercode
     * @param identifierCode �����õ�����identifiercode��ֵ
     */
    public void setIdentifierCode(String identifierCode){
        this.identifierCode = StringUtils.rightTrim(identifierCode);
    }

    /**
     * ��ȡ����identifiercode
     * @return ����identifiercode��ֵ
     */
    public String getIdentifierCode(){
        return identifierCode;
    }

    /**
     * ��������countrycode
     * @param countryCode �����õ�����countrycode��ֵ
     */
    public void setCountryCode(String countryCode){
        this.countryCode = StringUtils.rightTrim(countryCode);
    }

    /**
     * ��ȡ����countrycode
     * @return ����countrycode��ֵ
     */
    public String getCountryCode(){
        return countryCode;
    }

    /**
     * ��������countrycname
     * @param countryCName �����õ�����countrycname��ֵ
     */
    public void setCountryCName(String countryCName){
        this.countryCName = StringUtils.rightTrim(countryCName);
    }

    /**
     * ��ȡ����countrycname
     * @return ����countrycname��ֵ
     */
    public String getCountryCName(){
        return countryCName;
    }

    /**
     * ��������countryename
     * @param countryEName �����õ�����countryename��ֵ
     */
    public void setCountryEName(String countryEName){
        this.countryEName = StringUtils.rightTrim(countryEName);
    }

    /**
     * ��ȡ����countryename
     * @return ����countryename��ֵ
     */
    public String getCountryEName(){
        return countryEName;
    }

    /**
     * ��������portcode
     * @param portCode �����õ�����portcode��ֵ
     */
    public void setPortCode(String portCode){
        this.portCode = StringUtils.rightTrim(portCode);
    }

    /**
     * ��ȡ����portcode
     * @return ����portcode��ֵ
     */
    public String getPortCode(){
        return portCode;
    }

    /**
     * ��������portname
     * @param portName �����õ�����portname��ֵ
     */
    public void setPortName(String portName){
        this.portName = StringUtils.rightTrim(portName);
    }

    /**
     * ��ȡ����portname
     * @return ����portname��ֵ
     */
    public String getPortName(){
        return portName;
    }

    /**
     * ��������identifierorder
     * @param identifierOrder �����õ�����identifierorder��ֵ
     */
    public void setIdentifierOrder(int identifierOrder){
        this.identifierOrder = identifierOrder;
    }

    /**
     * ��ȡ����identifierorder
     * @return ����identifierorder��ֵ
     */
    public int getIdentifierOrder(){
        return identifierOrder;
    }

    /**
     * ��������identifiername
     * @param identifierName �����õ�����identifiername��ֵ
     */
    public void setIdentifierName(String identifierName){
        this.identifierName = StringUtils.rightTrim(identifierName);
    }

    /**
     * ��ȡ����identifiername
     * @return ����identifiername��ֵ
     */
    public String getIdentifierName(){
        return identifierName;
    }

    /**
     * ��������identifieraddress
     * @param identifierAddress �����õ�����identifieraddress��ֵ
     */
    public void setIdentifierAddress(String identifierAddress){
        this.identifierAddress = StringUtils.rightTrim(identifierAddress);
    }

    /**
     * ��ȡ����identifieraddress
     * @return ����identifieraddress��ֵ
     */
    public String getIdentifierAddress(){
        return identifierAddress;
    }

    /**
     * ��������identifiertype
     * @param identifierType �����õ�����identifiertype��ֵ
     */
    public void setIdentifierType(String identifierType){
        this.identifierType = StringUtils.rightTrim(identifierType);
    }

    /**
     * ��ȡ����identifiertype
     * @return ����identifiertype��ֵ
     */
    public String getIdentifierType(){
        return identifierType;
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
