package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdrationlimit�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrationLimitDtoBase implements Serializable{
    /** ����riskcode */
    private String riskCode = "";
    /** ����limitgrade */
    private String limitGrade = "";
    /** ����limitcode */
    private String limitCode = "";
    /** ����rationtype */
    private String rationType = "";
    /** ����kindcode */
    private String kindCode = "";
    /** ����itemcode */
    private String itemCode = "";
    /** ����modecode */
    private String modeCode = "";
    /** ����currency */
    private String currency = "";
    /** ����limitfee */
    private double limitFee = 0d;
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDrationLimitDtoBase����
     */
    public PrpDrationLimitDtoBase(){
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
     * ��������limitgrade
     * @param limitGrade �����õ�����limitgrade��ֵ
     */
    public void setLimitGrade(String limitGrade){
        this.limitGrade = StringUtils.rightTrim(limitGrade);
    }

    /**
     * ��ȡ����limitgrade
     * @return ����limitgrade��ֵ
     */
    public String getLimitGrade(){
        return limitGrade;
    }

    /**
     * ��������limitcode
     * @param limitCode �����õ�����limitcode��ֵ
     */
    public void setLimitCode(String limitCode){
        this.limitCode = StringUtils.rightTrim(limitCode);
    }

    /**
     * ��ȡ����limitcode
     * @return ����limitcode��ֵ
     */
    public String getLimitCode(){
        return limitCode;
    }

    /**
     * ��������rationtype
     * @param rationType �����õ�����rationtype��ֵ
     */
    public void setRationType(String rationType){
        this.rationType = StringUtils.rightTrim(rationType);
    }

    /**
     * ��ȡ����rationtype
     * @return ����rationtype��ֵ
     */
    public String getRationType(){
        return rationType;
    }

    /**
     * ��������kindcode
     * @param kindCode �����õ�����kindcode��ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ����kindcode
     * @return ����kindcode��ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * ��������itemcode
     * @param itemCode �����õ�����itemcode��ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ����itemcode
     * @return ����itemcode��ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * ��������modecode
     * @param modeCode �����õ�����modecode��ֵ
     */
    public void setModeCode(String modeCode){
        this.modeCode = StringUtils.rightTrim(modeCode);
    }

    /**
     * ��ȡ����modecode
     * @return ����modecode��ֵ
     */
    public String getModeCode(){
        return modeCode;
    }

    /**
     * ��������currency
     * @param currency �����õ�����currency��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ����currency
     * @return ����currency��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ��������limitfee
     * @param limitFee �����õ�����limitfee��ֵ
     */
    public void setLimitFee(double limitFee){
        this.limitFee = limitFee;
    }

    /**
     * ��ȡ����limitfee
     * @return ����limitfee��ֵ
     */
    public double getLimitFee(){
        return limitFee;
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
