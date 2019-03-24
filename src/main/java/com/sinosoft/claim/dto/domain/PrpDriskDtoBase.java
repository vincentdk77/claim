package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdrisk���ִ��������ݴ���������<br>
 * ������ 2004-08-25 16:51:28.621<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDriskDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** ���������������� */
    private String riskCName = "";
    /** ��������Ӣ������ */
    private String riskEName = "";
    /** ������������ */
    private String classCode = "";
    /** �����������(2λΪ����) */
    private String riskType = "";
    /** ���Լ��㱣�ѷ�ʽ */
    private int calculator = 0;
    /** ���Ա��Ѽ������� */
    private String calculateFlag = "";
    /** ����Y/N �����ձ����ڱ�־ */
    private String endDateFlag = "";
    /** �������ֱ�־λ */
    private String riskFlag = "";
    /** ������Сʱ */
    private int startHour = 0;
    /** �����µ����ִ��� */
    private String newRiskCode = "";
    /** ����Ч��״̬(0ʧЧ/1��Ч) */
    private String validStatus = "";
    /** ����ר�����(��Ӧ��ƿ�Ŀ) */
    private String articleCode = "";
    /** �����ո��Ѵ����־ */
    private String manageFlag = "";
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
     * ����������������
     * @param classCode �����õ��������������ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * ���������������(2λΪ����)
     * @param riskType �����õ������������(2λΪ����)��ֵ
     */
    public void setRiskType(String riskType){
        this.riskType = StringUtils.rightTrim(riskType);
    }

    /**
     * ��ȡ�����������(2λΪ����)
     * @return �����������(2λΪ����)��ֵ
     */
    public String getRiskType(){
        return riskType;
    }

    /**
     * �������Լ��㱣�ѷ�ʽ
     * @param calculator �����õ����Լ��㱣�ѷ�ʽ��ֵ
     */
    public void setCalculator(int calculator){
        this.calculator = calculator;
    }

    /**
     * ��ȡ���Լ��㱣�ѷ�ʽ
     * @return ���Լ��㱣�ѷ�ʽ��ֵ
     */
    public int getCalculator(){
        return calculator;
    }

    /**
     * �������Ա��Ѽ�������
     * @param calculateFlag �����õ����Ա��Ѽ������͵�ֵ
     */
    public void setCalculateFlag(String calculateFlag){
        this.calculateFlag = StringUtils.rightTrim(calculateFlag);
    }

    /**
     * ��ȡ���Ա��Ѽ�������
     * @return ���Ա��Ѽ������͵�ֵ
     */
    public String getCalculateFlag(){
        return calculateFlag;
    }

    /**
     * ��������Y/N �����ձ����ڱ�־
     * @param endDateFlag �����õ�����Y/N �����ձ����ڱ�־��ֵ
     */
    public void setEndDateFlag(String endDateFlag){
        this.endDateFlag = StringUtils.rightTrim(endDateFlag);
    }

    /**
     * ��ȡ����Y/N �����ձ����ڱ�־
     * @return ����Y/N �����ձ����ڱ�־��ֵ
     */
    public String getEndDateFlag(){
        return endDateFlag;
    }

    /**
     * �����������ֱ�־λ
     * @param riskFlag �����õ��������ֱ�־λ��ֵ
     */
    public void setRiskFlag(String riskFlag){
        this.riskFlag = StringUtils.rightTrim(riskFlag);
    }

    /**
     * ��ȡ�������ֱ�־λ
     * @return �������ֱ�־λ��ֵ
     */
    public String getRiskFlag(){
        return riskFlag;
    }

    /**
     * ����������Сʱ
     * @param startHour �����õ�������Сʱ��ֵ
     */
    public void setStartHour(int startHour){
        this.startHour = startHour;
    }

    /**
     * ��ȡ������Сʱ
     * @return ������Сʱ��ֵ
     */
    public int getStartHour(){
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
     * ��������Ч��״̬(0ʧЧ/1��Ч)
     * @param validStatus �����õ�����Ч��״̬(0ʧЧ/1��Ч)��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����Ч��״̬(0ʧЧ/1��Ч)
     * @return ����Ч��״̬(0ʧЧ/1��Ч)��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������ר�����(��Ӧ��ƿ�Ŀ)
     * @param articleCode �����õ�����ר�����(��Ӧ��ƿ�Ŀ)��ֵ
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * ��ȡ����ר�����(��Ӧ��ƿ�Ŀ)
     * @return ����ר�����(��Ӧ��ƿ�Ŀ)��ֵ
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
