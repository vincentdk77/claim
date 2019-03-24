package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdcurrency�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcurrencyDtoBase implements Serializable{
    /** ����currencycode */
    private String currencyCode = "";
    /** ����currencycname */
    private String currencyCName = "";
    /** ����currencyename */
    private String currencyEName = "";
    /** ����newcurrencycode */
    private String newCurrencyCode = "";
    /** ����AccBookCode */
    private String accBookCode = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcurrencyDtoBase����
     */
    public PrpDcurrencyDtoBase(){
    }

    /**
     * ��������currencycode
     * @param currencyCode �����õ�����currencycode��ֵ
     */
    public void setCurrencyCode(String currencyCode){
        this.currencyCode = StringUtils.rightTrim(currencyCode);
    }

    /**
     * ��ȡ����currencycode
     * @return ����currencycode��ֵ
     */
    public String getCurrencyCode(){
        return currencyCode;
    }

    /**
     * ��������currencycname
     * @param currencyCName �����õ�����currencycname��ֵ
     */
    public void setCurrencyCName(String currencyCName){
        this.currencyCName = StringUtils.rightTrim(currencyCName);
    }

    /**
     * ��ȡ����currencycname
     * @return ����currencycname��ֵ
     */
    public String getCurrencyCName(){
        return currencyCName;
    }

    /**
     * ��������currencyename
     * @param currencyEName �����õ�����currencyename��ֵ
     */
    public void setCurrencyEName(String currencyEName){
        this.currencyEName = StringUtils.rightTrim(currencyEName);
    }

    /**
     * ��ȡ����currencyename
     * @return ����currencyename��ֵ
     */
    public String getCurrencyEName(){
        return currencyEName;
    }

    /**
     * ��������newcurrencycode
     * @param newCurrencyCode �����õ�����newcurrencycode��ֵ
     */
    public void setNewCurrencyCode(String newCurrencyCode){
        this.newCurrencyCode = StringUtils.rightTrim(newCurrencyCode);
    }

    /**
     * ��ȡ����newcurrencycode
     * @return ����newcurrencycode��ֵ
     */
    public String getNewCurrencyCode(){
        return newCurrencyCode;
    }

    /**
     * ��������AccBookCode
     * @param accBookCode �����õ�����AccBookCode��ֵ
     */
    public void setAccBookCode(String accBookCode){
        this.accBookCode = StringUtils.rightTrim(accBookCode);
    }

    /**
     * ��ȡ����AccBookCode
     * @return ����AccBookCode��ֵ
     */
    public String getAccBookCode(){
        return accBookCode;
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
