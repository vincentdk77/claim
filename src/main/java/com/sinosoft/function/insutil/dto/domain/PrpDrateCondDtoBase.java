package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdratecond�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrateCondDtoBase implements Serializable{
    /** ����riskcode */
    private String riskCode = "";
    /** ����validdate */
    private DateTime validDate = new DateTime();
    /** ����rateperiod */
    private int ratePeriod = 0;
    /** ����condcode */
    private String condCode = "";
    /** ����condname */
    private String condName = "";
    /** ����lowervalue */
    private double lowerValue = 0d;
    /** ����uppervalue */
    private double upperValue = 0d;
    /** ����valuecode */
    private String valueCode = "";
    /** ����valuename */
    private String valueName = "";
    /** ����startpos */
    private int startPos = 0;
    /** ����endpos */
    private int endPos = 0;
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDrateCondDtoBase����
     */
    public PrpDrateCondDtoBase(){
    }

    /**
     * ��������riskcode
     * @param riskCode �����õ�����riskcode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����riskcode
     * @return ����riskcode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
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
     * ��������rateperiod
     * @param ratePeriod �����õ�����rateperiod��ֵ
     */
    public void setRatePeriod(int ratePeriod){
        this.ratePeriod = ratePeriod;
    }

    /**
     * ��ȡ����rateperiod
     * @return ����rateperiod��ֵ
     */
    public int getRatePeriod(){
        return ratePeriod;
    }

    /**
     * ��������condcode
     * @param condCode �����õ�����condcode��ֵ
     */
    public void setCondCode(String condCode){
        this.condCode = StringUtils.rightTrim(condCode);
    }

    /**
     * ��ȡ����condcode
     * @return ����condcode��ֵ
     */
    public String getCondCode(){
        return condCode;
    }

    /**
     * ��������condname
     * @param condName �����õ�����condname��ֵ
     */
    public void setCondName(String condName){
        this.condName = StringUtils.rightTrim(condName);
    }

    /**
     * ��ȡ����condname
     * @return ����condname��ֵ
     */
    public String getCondName(){
        return condName;
    }

    /**
     * ��������lowervalue
     * @param lowerValue �����õ�����lowervalue��ֵ
     */
    public void setLowerValue(double lowerValue){
        this.lowerValue = lowerValue;
    }

    /**
     * ��ȡ����lowervalue
     * @return ����lowervalue��ֵ
     */
    public double getLowerValue(){
        return lowerValue;
    }

    /**
     * ��������uppervalue
     * @param upperValue �����õ�����uppervalue��ֵ
     */
    public void setUpperValue(double upperValue){
        this.upperValue = upperValue;
    }

    /**
     * ��ȡ����uppervalue
     * @return ����uppervalue��ֵ
     */
    public double getUpperValue(){
        return upperValue;
    }

    /**
     * ��������valuecode
     * @param valueCode �����õ�����valuecode��ֵ
     */
    public void setValueCode(String valueCode){
        this.valueCode = StringUtils.rightTrim(valueCode);
    }

    /**
     * ��ȡ����valuecode
     * @return ����valuecode��ֵ
     */
    public String getValueCode(){
        return valueCode;
    }

    /**
     * ��������valuename
     * @param valueName �����õ�����valuename��ֵ
     */
    public void setValueName(String valueName){
        this.valueName = StringUtils.rightTrim(valueName);
    }

    /**
     * ��ȡ����valuename
     * @return ����valuename��ֵ
     */
    public String getValueName(){
        return valueName;
    }

    /**
     * ��������startpos
     * @param startPos �����õ�����startpos��ֵ
     */
    public void setStartPos(int startPos){
        this.startPos = startPos;
    }

    /**
     * ��ȡ����startpos
     * @return ����startpos��ֵ
     */
    public int getStartPos(){
        return startPos;
    }

    /**
     * ��������endpos
     * @param endPos �����õ�����endpos��ֵ
     */
    public void setEndPos(int endPos){
        this.endPos = endPos;
    }

    /**
     * ��ȡ����endpos
     * @return ����endpos��ֵ
     */
    public int getEndPos(){
        return endPos;
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
