package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdexch�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDexchDtoBase implements Serializable{
    /** ����exchdate */
    private DateTime exchDate = new DateTime();
    /** ����base */
    private double base = 0d;
    /** ����basecurrency */
    private String baseCurrency = "";
    /** ����exchcurrency */
    private String exchCurrency = "";
    /** ����exchrate */
    private double exchRate = 0d;
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDexchDtoBase����
     */
    public PrpDexchDtoBase(){
    }

    /**
     * ��������exchdate
     * @param exchDate �����õ�����exchdate��ֵ
     */
    public void setExchDate(DateTime exchDate){
        this.exchDate = exchDate;
    }

    /**
     * ��ȡ����exchdate
     * @return ����exchdate��ֵ
     */
    public DateTime getExchDate(){
        return exchDate;
    }

    /**
     * ��������base
     * @param base �����õ�����base��ֵ
     */
    public void setBase(double base){
        this.base = base;
    }

    /**
     * ��ȡ����base
     * @return ����base��ֵ
     */
    public double getBase(){
        return base;
    }

    /**
     * ��������basecurrency
     * @param baseCurrency �����õ�����basecurrency��ֵ
     */
    public void setBaseCurrency(String baseCurrency){
        this.baseCurrency = StringUtils.rightTrim(baseCurrency);
    }

    /**
     * ��ȡ����basecurrency
     * @return ����basecurrency��ֵ
     */
    public String getBaseCurrency(){
        return baseCurrency;
    }

    /**
     * ��������exchcurrency
     * @param exchCurrency �����õ�����exchcurrency��ֵ
     */
    public void setExchCurrency(String exchCurrency){
        this.exchCurrency = StringUtils.rightTrim(exchCurrency);
    }

    /**
     * ��ȡ����exchcurrency
     * @return ����exchcurrency��ֵ
     */
    public String getExchCurrency(){
        return exchCurrency;
    }

    /**
     * ��������exchrate
     * @param exchRate �����õ�����exchrate��ֵ
     */
    public void setExchRate(double exchRate){
        this.exchRate = exchRate;
    }

    /**
     * ��ȡ����exchrate
     * @return ����exchrate��ֵ
     */
    public double getExchRate(){
        return exchRate;
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
