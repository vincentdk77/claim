package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdport�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDportDtoBase implements Serializable{
    /** ����portcode */
    private String portCode = "";
    /** ����portcname */
    private String portCName = "";
    /** ����portename */
    private String portEName = "";
    /** ����countrycode */
    private String countryCode = "";
    /** ����countrycname */
    private String countryCName = "";
    /** ����countryename */
    private String countryEName = "";
    /** ����newportcode */
    private String newPortCode = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDportDtoBase����
     */
    public PrpDportDtoBase(){
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
     * ��������portcname
     * @param portCName �����õ�����portcname��ֵ
     */
    public void setPortCName(String portCName){
        this.portCName = StringUtils.rightTrim(portCName);
    }

    /**
     * ��ȡ����portcname
     * @return ����portcname��ֵ
     */
    public String getPortCName(){
        return portCName;
    }

    /**
     * ��������portename
     * @param portEName �����õ�����portename��ֵ
     */
    public void setPortEName(String portEName){
        this.portEName = StringUtils.rightTrim(portEName);
    }

    /**
     * ��ȡ����portename
     * @return ����portename��ֵ
     */
    public String getPortEName(){
        return portEName;
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
     * ��������newportcode
     * @param newPortCode �����õ�����newportcode��ֵ
     */
    public void setNewPortCode(String newPortCode){
        this.newPortCode = StringUtils.rightTrim(newPortCode);
    }

    /**
     * ��ȡ����newportcode
     * @return ����newportcode��ֵ
     */
    public String getNewPortCode(){
        return newPortCode;
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
