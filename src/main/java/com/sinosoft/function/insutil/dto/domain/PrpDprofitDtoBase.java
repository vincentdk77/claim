package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdprofit�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDprofitDtoBase implements Serializable{
    /** ����comcode */
    private String comCode = "";
    /** ����riskcode */
    private String riskCode = "";
    /** ����profitperiod */
    private int profitPeriod = 0;
    /** ����validdate */
    private DateTime validDate = new DateTime();
    /** ����profitcode */
    private String profitCode = "";
    /** ����profitname */
    private String profitName = "";
    /** ����serialno */
    private int serialNo = 0;
    /** ����condition */
    private String condition = "";
    /** ����fieldvaluelower */
    private double fieldValueLower = 0d;
    /** ����fieldvalueupper */
    private double fieldValueUpper = 0d;
    /** ����minprofitrate */
    private double minprofitrate = 0d;
    /** ����profitrate */
    private double profitRate = 0d;
    /** ����maxprofitrate */
    private double maxProfitRate = 0d;
    /** ����profitflag */
    private String profitFlag = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDprofitDtoBase����
     */
    public PrpDprofitDtoBase(){
    }

    /**
     * ��������comcode
     * @param comCode �����õ�����comcode��ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����comcode
     * @return ����comcode��ֵ
     */
    public String getComCode(){
        return comCode;
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
     * ��������profitperiod
     * @param profitPeriod �����õ�����profitperiod��ֵ
     */
    public void setProfitPeriod(int profitPeriod){
        this.profitPeriod = profitPeriod;
    }

    /**
     * ��ȡ����profitperiod
     * @return ����profitperiod��ֵ
     */
    public int getProfitPeriod(){
        return profitPeriod;
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
     * ��������profitcode
     * @param profitCode �����õ�����profitcode��ֵ
     */
    public void setProfitCode(String profitCode){
        this.profitCode = StringUtils.rightTrim(profitCode);
    }

    /**
     * ��ȡ����profitcode
     * @return ����profitcode��ֵ
     */
    public String getProfitCode(){
        return profitCode;
    }

    /**
     * ��������profitname
     * @param profitName �����õ�����profitname��ֵ
     */
    public void setProfitName(String profitName){
        this.profitName = StringUtils.rightTrim(profitName);
    }

    /**
     * ��ȡ����profitname
     * @return ����profitname��ֵ
     */
    public String getProfitName(){
        return profitName;
    }

    /**
     * ��������serialno
     * @param serialNo �����õ�����serialno��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����serialno
     * @return ����serialno��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ��������condition
     * @param condition �����õ�����condition��ֵ
     */
    public void setCondition(String condition){
        this.condition = StringUtils.rightTrim(condition);
    }

    /**
     * ��ȡ����condition
     * @return ����condition��ֵ
     */
    public String getCondition(){
        return condition;
    }

    /**
     * ��������fieldvaluelower
     * @param fieldValueLower �����õ�����fieldvaluelower��ֵ
     */
    public void setFieldValueLower(double fieldValueLower){
        this.fieldValueLower = fieldValueLower;
    }

    /**
     * ��ȡ����fieldvaluelower
     * @return ����fieldvaluelower��ֵ
     */
    public double getFieldValueLower(){
        return fieldValueLower;
    }

    /**
     * ��������fieldvalueupper
     * @param fieldValueUpper �����õ�����fieldvalueupper��ֵ
     */
    public void setFieldValueUpper(double fieldValueUpper){
        this.fieldValueUpper = fieldValueUpper;
    }

    /**
     * ��ȡ����fieldvalueupper
     * @return ����fieldvalueupper��ֵ
     */
    public double getFieldValueUpper(){
        return fieldValueUpper;
    }

    /**
     * ��������minprofitrate
     * @param minprofitrate �����õ�����minprofitrate��ֵ
     */
    public void setMinprofitrate(double minprofitrate){
        this.minprofitrate = minprofitrate;
    }

    /**
     * ��ȡ����minprofitrate
     * @return ����minprofitrate��ֵ
     */
    public double getMinprofitrate(){
        return minprofitrate;
    }

    /**
     * ��������profitrate
     * @param profitRate �����õ�����profitrate��ֵ
     */
    public void setProfitRate(double profitRate){
        this.profitRate = profitRate;
    }

    /**
     * ��ȡ����profitrate
     * @return ����profitrate��ֵ
     */
    public double getProfitRate(){
        return profitRate;
    }

    /**
     * ��������maxprofitrate
     * @param maxProfitRate �����õ�����maxprofitrate��ֵ
     */
    public void setMaxProfitRate(double maxProfitRate){
        this.maxProfitRate = maxProfitRate;
    }

    /**
     * ��ȡ����maxprofitrate
     * @return ����maxprofitrate��ֵ
     */
    public double getMaxProfitRate(){
        return maxProfitRate;
    }

    /**
     * ��������profitflag
     * @param profitFlag �����õ�����profitflag��ֵ
     */
    public void setProfitFlag(String profitFlag){
        this.profitFlag = StringUtils.rightTrim(profitFlag);
    }

    /**
     * ��ȡ����profitflag
     * @return ����profitflag��ֵ
     */
    public String getProfitFlag(){
        return profitFlag;
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
