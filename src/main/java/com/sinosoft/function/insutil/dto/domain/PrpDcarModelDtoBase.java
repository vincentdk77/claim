package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdcarmodel�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcarModelDtoBase implements Serializable{
    /** ����modelcode */
    private String modelCode = "";
    /** ����shorthandcode */
    private String shortHandCode = "";
    /** ����modelname */
    private String modelName = "";
    /** ����carseriesname */
    private String carSeriesName = "";
    /** ����seatcount */
    private int seatCount = 0;
    /** ����toncount */
    private double tonCount = 0d;
    /** ����factory */
    private String factory = "";
    /** ����countrycode */
    private String countryCode = "";
    /** ����purchaseprice */
    private double purchasePrice = 0d;
    /** ����riskscope */
    private String riskScope = "";
    /** ����validdate */
    private DateTime validDate = new DateTime();
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcarModelDtoBase����
     */
    public PrpDcarModelDtoBase(){
    }

    /**
     * ��������modelcode
     * @param modelCode �����õ�����modelcode��ֵ
     */
    public void setModelCode(String modelCode){
        this.modelCode = StringUtils.rightTrim(modelCode);
    }

    /**
     * ��ȡ����modelcode
     * @return ����modelcode��ֵ
     */
    public String getModelCode(){
        return modelCode;
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
     * ��������modelname
     * @param modelName �����õ�����modelname��ֵ
     */
    public void setModelName(String modelName){
        this.modelName = StringUtils.rightTrim(modelName);
    }

    /**
     * ��ȡ����modelname
     * @return ����modelname��ֵ
     */
    public String getModelName(){
        return modelName;
    }

    /**
     * ��������carseriesname
     * @param carSeriesName �����õ�����carseriesname��ֵ
     */
    public void setCarSeriesName(String carSeriesName){
        this.carSeriesName = StringUtils.rightTrim(carSeriesName);
    }

    /**
     * ��ȡ����carseriesname
     * @return ����carseriesname��ֵ
     */
    public String getCarSeriesName(){
        return carSeriesName;
    }

    /**
     * ��������seatcount
     * @param seatCount �����õ�����seatcount��ֵ
     */
    public void setSeatCount(int seatCount){
        this.seatCount = seatCount;
    }

    /**
     * ��ȡ����seatcount
     * @return ����seatcount��ֵ
     */
    public int getSeatCount(){
        return seatCount;
    }

    /**
     * ��������toncount
     * @param tonCount �����õ�����toncount��ֵ
     */
    public void setTonCount(double tonCount){
        this.tonCount = tonCount;
    }

    /**
     * ��ȡ����toncount
     * @return ����toncount��ֵ
     */
    public double getTonCount(){
        return tonCount;
    }

    /**
     * ��������factory
     * @param factory �����õ�����factory��ֵ
     */
    public void setFactory(String factory){
        this.factory = StringUtils.rightTrim(factory);
    }

    /**
     * ��ȡ����factory
     * @return ����factory��ֵ
     */
    public String getFactory(){
        return factory;
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
     * ��������purchaseprice
     * @param purchasePrice �����õ�����purchaseprice��ֵ
     */
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }

    /**
     * ��ȡ����purchaseprice
     * @return ����purchaseprice��ֵ
     */
    public double getPurchasePrice(){
        return purchasePrice;
    }

    /**
     * ��������riskscope
     * @param riskScope �����õ�����riskscope��ֵ
     */
    public void setRiskScope(String riskScope){
        this.riskScope = StringUtils.rightTrim(riskScope);
    }

    /**
     * ��ȡ����riskscope
     * @return ����riskscope��ֵ
     */
    public String getRiskScope(){
        return riskScope;
    }

    /**
     * ��������validdate
     * @param validDate �����õ�����validdate��ֵ
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * ��ȡ����validdate
     * @return ����validdate��ֵ
     */
    public DateTime getValidDate(){
        return validDate;
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
