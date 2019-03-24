package com.sinosoft.function.power.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpDrisk���ִ��������ݴ���������<br>
 * ������ 2004-11-09 10:40:47.678<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDriskDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** ���������������� */
    private String riskCName = "";
    /** ��������Ӣ������ */
    private String riskEName = "";
    /** ����������� */
    private String classCode = "";
    /** ����Ȩ����Ŵ��� */
    private String groupCode = "";
    /** ���Լ��㱣�ѷ�ʽ */
    private double calculator = 0d;
    /** ���Խ������ڱ�־ */
    private String endDateFlag = "";
    /** �������ֱ�־ */
    private String riskFlag = "";
    /** ������Сʱ */
    private double startHour = 0d;
    /** �����µ����ִ��� */
    private String newRiskCode = "";
    /** ����Ч��״̬ */
    private String validStatus = "";
    /** ����ר����� */
    private String articleCode = "";
    /** �����ո��Ѵ����־ */
    private String manageFlag = "";
    /** ������������ */
    private String settleType = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDriskDtoBase����
     */
    public PrpDriskDtoBase(){
    }

    /**
     * �����������ִ���
     * @param riskCode �����õ��������ִ����ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ�������ִ���
     * @return �������ִ����ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������������������
     * @param riskCName �����õ����������������Ƶ�ֵ
     */
    public void setRiskCName(String riskCName){
        this.riskCName = StringUtils.rightTrim(riskCName);
    }

    /**
     * ��ȡ����������������
     * @return ���������������Ƶ�ֵ
     */
    public String getRiskCName(){
        return riskCName;
    }

    /**
     * ������������Ӣ������
     * @param riskEName �����õ���������Ӣ�����Ƶ�ֵ
     */
    public void setRiskEName(String riskEName){
        this.riskEName = StringUtils.rightTrim(riskEName);
    }

    /**
     * ��ȡ��������Ӣ������
     * @return ��������Ӣ�����Ƶ�ֵ
     */
    public String getRiskEName(){
        return riskEName;
    }

    /**
     * ���������������
     * @param classCode �����õ�������������ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * ��������Ȩ����Ŵ���
     * @param groupCode �����õ�����Ȩ����Ŵ����ֵ
     */
    public void setGroupCode(String groupCode){
        this.groupCode = StringUtils.rightTrim(groupCode);
    }

    /**
     * ��ȡ����Ȩ����Ŵ���
     * @return ����Ȩ����Ŵ����ֵ
     */
    public String getGroupCode(){
        return groupCode;
    }

    /**
     * �������Լ��㱣�ѷ�ʽ
     * @param calculator �����õ����Լ��㱣�ѷ�ʽ��ֵ
     */
    public void setCalculator(double calculator){
        this.calculator = calculator;
    }

    /**
     * ��ȡ���Լ��㱣�ѷ�ʽ
     * @return ���Լ��㱣�ѷ�ʽ��ֵ
     */
    public double getCalculator(){
        return calculator;
    }

    /**
     * �������Խ������ڱ�־
     * @param endDateFlag �����õ����Խ������ڱ�־��ֵ
     */
    public void setEndDateFlag(String endDateFlag){
        this.endDateFlag = StringUtils.rightTrim(endDateFlag);
    }

    /**
     * ��ȡ���Խ������ڱ�־
     * @return ���Խ������ڱ�־��ֵ
     */
    public String getEndDateFlag(){
        return endDateFlag;
    }

    /**
     * �����������ֱ�־
     * @param riskFlag �����õ��������ֱ�־��ֵ
     */
    public void setRiskFlag(String riskFlag){
        this.riskFlag = StringUtils.rightTrim(riskFlag);
    }

    /**
     * ��ȡ�������ֱ�־
     * @return �������ֱ�־��ֵ
     */
    public String getRiskFlag(){
        return riskFlag;
    }

    /**
     * ����������Сʱ
     * @param startHour �����õ�������Сʱ��ֵ
     */
    public void setStartHour(double startHour){
        this.startHour = startHour;
    }

    /**
     * ��ȡ������Сʱ
     * @return ������Сʱ��ֵ
     */
    public double getStartHour(){
        return startHour;
    }

    /**
     * ���������µ����ִ���
     * @param newRiskCode �����õ������µ����ִ����ֵ
     */
    public void setNewRiskCode(String newRiskCode){
        this.newRiskCode = StringUtils.rightTrim(newRiskCode);
    }

    /**
     * ��ȡ�����µ����ִ���
     * @return �����µ����ִ����ֵ
     */
    public String getNewRiskCode(){
        return newRiskCode;
    }

    /**
     * ��������Ч��״̬
     * @param validStatus �����õ�����Ч��״̬��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����Ч��״̬
     * @return ����Ч��״̬��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������ר�����
     * @param articleCode �����õ�����ר������ֵ
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * ��ȡ����ר�����
     * @return ����ר������ֵ
     */
    public String getArticleCode(){
        return articleCode;
    }

    /**
     * ���������ո��Ѵ����־
     * @param manageFlag �����õ������ո��Ѵ����־��ֵ
     */
    public void setManageFlag(String manageFlag){
        this.manageFlag = StringUtils.rightTrim(manageFlag);
    }

    /**
     * ��ȡ�����ո��Ѵ����־
     * @return �����ո��Ѵ����־��ֵ
     */
    public String getManageFlag(){
        return manageFlag;
    }

    /**
     * ����������������
     * @param settleType �����õ������������͵�ֵ
     */
    public void setSettleType(String settleType){
        this.settleType = StringUtils.rightTrim(settleType);
    }

    /**
     * ��ȡ������������
     * @return �����������͵�ֵ
     */
    public String getSettleType(){
        return settleType;
    }

    /**
     * �������Ա�־�ֶ�
     * @param flag �����õ����Ա�־�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
     * @return ���Ա�־�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
