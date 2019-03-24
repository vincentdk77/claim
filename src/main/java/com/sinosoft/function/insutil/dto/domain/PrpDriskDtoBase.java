package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdrisk�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDriskDtoBase implements Serializable{
    /** ����riskcode */
    private String riskCode = "";
    /** ����riskcname */
    private String riskCName = "";
    /** ����riskename */
    private String riskEName = "";
    /** ����classcode */
    private String classCode = "";
    /** ����calculator */
    private int calculator = 0;
    /** ����EndDateFlag */
    private String endDateFlag = "";
    /** ����riskflag */
    private String riskFlag = "";
    /** ����starthour */
    private int startHour = 0;
    /** ����newriskcode */
    private String newRiskCode = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����articlecode */
    private String articleCode = "";
    /** ����manageflag */
    private String manageFlag = "";
    /** ����settletype */
    private String settleType = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDriskDtoBase����
     */
    public PrpDriskDtoBase(){
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
     * ��������riskcname
     * @param riskCName �����õ�����riskcname��ֵ
     */
    public void setRiskCName(String riskCName){
        this.riskCName = StringUtils.rightTrim(riskCName);
    }

    /**
     * ��ȡ����riskcname
     * @return ����riskcname��ֵ
     */
    public String getRiskCName(){
        return riskCName;
    }

    /**
     * ��������riskename
     * @param riskEName �����õ�����riskename��ֵ
     */
    public void setRiskEName(String riskEName){
        this.riskEName = StringUtils.rightTrim(riskEName);
    }

    /**
     * ��ȡ����riskename
     * @return ����riskename��ֵ
     */
    public String getRiskEName(){
        return riskEName;
    }

    /**
     * ��������classcode
     * @param classCode �����õ�����classcode��ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ����classcode
     * @return ����classcode��ֵ
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * ��������calculator
     * @param calculator �����õ�����calculator��ֵ
     */
    public void setCalculator(int calculator){
        this.calculator = calculator;
    }

    /**
     * ��ȡ����calculator
     * @return ����calculator��ֵ
     */
    public int getCalculator(){
        return calculator;
    }

    /**
     * ��������EndDateFlag
     * @param endDateFlag �����õ�����EndDateFlag��ֵ
     */
    public void setEndDateFlag(String endDateFlag){
        this.endDateFlag = StringUtils.rightTrim(endDateFlag);
    }

    /**
     * ��ȡ����EndDateFlag
     * @return ����EndDateFlag��ֵ
     */
    public String getEndDateFlag(){
        return endDateFlag;
    }

    /**
     * ��������riskflag
     * @param riskFlag �����õ�����riskflag��ֵ
     */
    public void setRiskFlag(String riskFlag){
        this.riskFlag = StringUtils.rightTrim(riskFlag);
    }

    /**
     * ��ȡ����riskflag
     * @return ����riskflag��ֵ
     */
    public String getRiskFlag(){
        return riskFlag;
    }

    /**
     * ��������starthour
     * @param startHour �����õ�����starthour��ֵ
     */
    public void setStartHour(int startHour){
        this.startHour = startHour;
    }

    /**
     * ��ȡ����starthour
     * @return ����starthour��ֵ
     */
    public int getStartHour(){
        return startHour;
    }

    /**
     * ��������newriskcode
     * @param newRiskCode �����õ�����newriskcode��ֵ
     */
    public void setNewRiskCode(String newRiskCode){
        this.newRiskCode = StringUtils.rightTrim(newRiskCode);
    }

    /**
     * ��ȡ����newriskcode
     * @return ����newriskcode��ֵ
     */
    public String getNewRiskCode(){
        return newRiskCode;
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
     * ��������manageflag
     * @param manageFlag �����õ�����manageflag��ֵ
     */
    public void setManageFlag(String manageFlag){
        this.manageFlag = StringUtils.rightTrim(manageFlag);
    }

    /**
     * ��ȡ����manageflag
     * @return ����manageflag��ֵ
     */
    public String getManageFlag(){
        return manageFlag;
    }

    /**
     * ��������settletype
     * @param settleType �����õ�����settletype��ֵ
     */
    public void setSettleType(String settleType){
        this.settleType = StringUtils.rightTrim(settleType);
    }

    /**
     * ��ȡ����settletype
     * @return ����settletype��ֵ
     */
    public String getSettleType(){
        return settleType;
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
