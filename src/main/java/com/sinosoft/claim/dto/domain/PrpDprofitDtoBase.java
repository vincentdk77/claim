package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdprofit�Ż��ۿ�����������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDprofitDtoBase implements Serializable{
    /** ���Ե������� */
    private String comcode = "";
    /** �������� */
    private String riskCode = "";
    /** �������� */
    private int profitPeriod = 0;
    /** ������������ */
    private DateTime validDate = new DateTime();
    /** �����Ż��ۿ۴��� */
    private String profitCode = "";
    /** �����Ż��ۿ����� */
    private String profitName = "";
    /** ������� */
    private int serialNo = 0;
    /** ������������ */
    private String condition = "";
    /** �����ֶ�ֵ���� */
    private double fieldValueLower = 0d;
    /** �����ֶ�ֵ���� */
    private double fieldValueUpper = 0d;
    /** �����ۿ������� */
    private double minprofitrate = 0d;
    /** �����Ż��ۿ۱���(%) */
    private double profitRate = 0d;
    /** ��������Ż��ۿ۱���(%) */
    private double maxProfitRate = 0d;
    /** �����ۿ�������־ */
    private String profitFlag = "";
    /** ������Ч״̬ */
    private String validStatus = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDprofitDtoBase����
     */
    public PrpDprofitDtoBase(){
    }

    /**
     * �������Ե�������
     * @param comcode �����õ����Ե��������ֵ
     */
    public void setComcode(String comcode){
        this.comcode = StringUtils.rightTrim(comcode);
    }

    /**
     * ��ȡ���Ե�������
     * @return ���Ե��������ֵ
     */
    public String getComcode(){
        return comcode;
    }

    /**
     * ������������
     * @param riskCode �����õ��������ֵ�ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ��������
     * @return �������ֵ�ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ������������
     * @param profitPeriod �����õ��������ε�ֵ
     */
    public void setProfitPeriod(int profitPeriod){
        this.profitPeriod = profitPeriod;
    }

    /**
     * ��ȡ��������
     * @return �������ε�ֵ
     */
    public int getProfitPeriod(){
        return profitPeriod;
    }

    /**
     * ����������������
     * @param validDate �����õ������������ڵ�ֵ
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * ���������Ż��ۿ۴���
     * @param profitCode �����õ������Ż��ۿ۴����ֵ
     */
    public void setProfitCode(String profitCode){
        this.profitCode = StringUtils.rightTrim(profitCode);
    }

    /**
     * ��ȡ�����Ż��ۿ۴���
     * @return �����Ż��ۿ۴����ֵ
     */
    public String getProfitCode(){
        return profitCode;
    }

    /**
     * ���������Ż��ۿ�����
     * @param profitName �����õ������Ż��ۿ����Ƶ�ֵ
     */
    public void setProfitName(String profitName){
        this.profitName = StringUtils.rightTrim(profitName);
    }

    /**
     * ��ȡ�����Ż��ۿ�����
     * @return �����Ż��ۿ����Ƶ�ֵ
     */
    public String getProfitName(){
        return profitName;
    }

    /**
     * �����������
     * @param serialNo �����õ�������ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ����������������
     * @param condition �����õ���������������ֵ
     */
    public void setCondition(String condition){
        this.condition = StringUtils.rightTrim(condition);
    }

    /**
     * ��ȡ������������
     * @return ��������������ֵ
     */
    public String getCondition(){
        return condition;
    }

    /**
     * ���������ֶ�ֵ����
     * @param fieldValueLower �����õ������ֶ�ֵ���޵�ֵ
     */
    public void setFieldValueLower(double fieldValueLower){
        this.fieldValueLower = fieldValueLower;
    }

    /**
     * ��ȡ�����ֶ�ֵ����
     * @return �����ֶ�ֵ���޵�ֵ
     */
    public double getFieldValueLower(){
        return fieldValueLower;
    }

    /**
     * ���������ֶ�ֵ����
     * @param fieldValueUpper �����õ������ֶ�ֵ���޵�ֵ
     */
    public void setFieldValueUpper(double fieldValueUpper){
        this.fieldValueUpper = fieldValueUpper;
    }

    /**
     * ��ȡ�����ֶ�ֵ����
     * @return �����ֶ�ֵ���޵�ֵ
     */
    public double getFieldValueUpper(){
        return fieldValueUpper;
    }

    /**
     * ���������ۿ�������
     * @param minprofitrate �����õ������ۿ������޵�ֵ
     */
    public void setMinprofitrate(double minprofitrate){
        this.minprofitrate = minprofitrate;
    }

    /**
     * ��ȡ�����ۿ�������
     * @return �����ۿ������޵�ֵ
     */
    public double getMinprofitrate(){
        return minprofitrate;
    }

    /**
     * ���������Ż��ۿ۱���(%)
     * @param profitRate �����õ������Ż��ۿ۱���(%)��ֵ
     */
    public void setProfitRate(double profitRate){
        this.profitRate = profitRate;
    }

    /**
     * ��ȡ�����Ż��ۿ۱���(%)
     * @return �����Ż��ۿ۱���(%)��ֵ
     */
    public double getProfitRate(){
        return profitRate;
    }

    /**
     * ������������Ż��ۿ۱���(%)
     * @param maxProfitRate �����õ���������Ż��ۿ۱���(%)��ֵ
     */
    public void setMaxProfitRate(double maxProfitRate){
        this.maxProfitRate = maxProfitRate;
    }

    /**
     * ��ȡ��������Ż��ۿ۱���(%)
     * @return ��������Ż��ۿ۱���(%)��ֵ
     */
    public double getMaxProfitRate(){
        return maxProfitRate;
    }

    /**
     * ���������ۿ�������־
     * @param profitFlag �����õ������ۿ�������־��ֵ
     */
    public void setProfitFlag(String profitFlag){
        this.profitFlag = StringUtils.rightTrim(profitFlag);
    }

    /**
     * ��ȡ�����ۿ�������־
     * @return �����ۿ�������־��ֵ
     */
    public String getProfitFlag(){
        return profitFlag;
    }

    /**
     * ����������Ч״̬
     * @param validStatus �����õ�������Ч״̬��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ������Ч״̬
     * @return ������Ч״̬��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * �������Ա�־
     * @param flag �����õ����Ա�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־
     * @return ���Ա�־��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
