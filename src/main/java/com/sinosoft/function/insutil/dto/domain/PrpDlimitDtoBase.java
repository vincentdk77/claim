package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdlimit�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDlimitDtoBase implements Serializable{
    /** ����riskcode */
    private String riskCode = "";
    /** ����limitcode */
    private String limitCode = "";
    /** ����limitcname */
    private String limitCName = "";
    /** ����limitename */
    private String limitEName = "";
    /** ����limitpriority */
    private String limitPriority = "";
    /** ����kindcode */
    private String kindCode = "";
    /** ����itemcode */
    private String itemCode = "";
    /** ����modecode */
    private String modeCode = "";
    /** ����limitfee */
    private double limitFee = 0d;
    /** ����limitrelation */
    private String limitRelation = "";
    /** ����limitrelationdesc */
    private String limitRelationDesc = "";
    /** ����newlimitcode */
    private String newLimitCode = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����limitflag */
    private String limitFlag = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDlimitDtoBase����
     */
    public PrpDlimitDtoBase(){
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
     * ��������limitcname
     * @param limitCName �����õ�����limitcname��ֵ
     */
    public void setLimitCName(String limitCName){
        this.limitCName = StringUtils.rightTrim(limitCName);
    }

    /**
     * ��ȡ����limitcname
     * @return ����limitcname��ֵ
     */
    public String getLimitCName(){
        return limitCName;
    }

    /**
     * ��������limitename
     * @param limitEName �����õ�����limitename��ֵ
     */
    public void setLimitEName(String limitEName){
        this.limitEName = StringUtils.rightTrim(limitEName);
    }

    /**
     * ��ȡ����limitename
     * @return ����limitename��ֵ
     */
    public String getLimitEName(){
        return limitEName;
    }

    /**
     * ��������limitpriority
     * @param limitPriority �����õ�����limitpriority��ֵ
     */
    public void setLimitPriority(String limitPriority){
        this.limitPriority = StringUtils.rightTrim(limitPriority);
    }

    /**
     * ��ȡ����limitpriority
     * @return ����limitpriority��ֵ
     */
    public String getLimitPriority(){
        return limitPriority;
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
     * ��������limitrelation
     * @param limitRelation �����õ�����limitrelation��ֵ
     */
    public void setLimitRelation(String limitRelation){
        this.limitRelation = StringUtils.rightTrim(limitRelation);
    }

    /**
     * ��ȡ����limitrelation
     * @return ����limitrelation��ֵ
     */
    public String getLimitRelation(){
        return limitRelation;
    }

    /**
     * ��������limitrelationdesc
     * @param limitRelationDesc �����õ�����limitrelationdesc��ֵ
     */
    public void setLimitRelationDesc(String limitRelationDesc){
        this.limitRelationDesc = StringUtils.rightTrim(limitRelationDesc);
    }

    /**
     * ��ȡ����limitrelationdesc
     * @return ����limitrelationdesc��ֵ
     */
    public String getLimitRelationDesc(){
        return limitRelationDesc;
    }

    /**
     * ��������newlimitcode
     * @param newLimitCode �����õ�����newlimitcode��ֵ
     */
    public void setNewLimitCode(String newLimitCode){
        this.newLimitCode = StringUtils.rightTrim(newLimitCode);
    }

    /**
     * ��ȡ����newlimitcode
     * @return ����newlimitcode��ֵ
     */
    public String getNewLimitCode(){
        return newLimitCode;
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
     * ��������limitflag
     * @param limitFlag �����õ�����limitflag��ֵ
     */
    public void setLimitFlag(String limitFlag){
        this.limitFlag = StringUtils.rightTrim(limitFlag);
    }

    /**
     * ��ȡ����limitflag
     * @return ����limitflag��ֵ
     */
    public String getLimitFlag(){
        return limitFlag;
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
