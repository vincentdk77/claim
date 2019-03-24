package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpcprofitdetail�Ż��ۿ���ϸ������ݴ���������<br>
 * ������ 2004-4-5 15:32:06<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCprofitDetailDtoBase implements Serializable{
    /** ���Ա����� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** �����Ż��ۿ����� */
    private String profitType = "";
    /** �����ڴ� */
    private int profitPeriod = 0;
    /** ���Ա��������� */
    private int itemKindNo = 0;
    /** �����ձ���� */
    private String kindCode = "";
    /** �����ձ����� */
    private String kindName = "";
    /** �����Ż��ۿ۴��� */
    private String profitCode = "";
    /** �����Ż��ۿ����� */
    private String profitName = "";
    /** ������� */
    private int serialNo = 0;
    /** ������������ */
    private String condition = "";
    /** ������������ֵ */
    private double fieldValue = 0d;
    /** �����Ż��ۿ۱���(%) */
    private double profitRate = 0d;
    /** ���Ը������Ƿ�ѡ�б�־ */
    private String chooseFlag = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCprofitDetailDtoBase����
     */
    public PrpCprofitDetailDtoBase(){
    }

    /**
     * �������Ա�����
     * @param policyNo �����õ����Ա����ŵ�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getPolicyNo(){
        return policyNo;
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
     * ���������Ż��ۿ�����
     * @param profitType �����õ������Ż��ۿ����͵�ֵ
     */
    public void setProfitType(String profitType){
        this.profitType = StringUtils.rightTrim(profitType);
    }

    /**
     * ��ȡ�����Ż��ۿ�����
     * @return �����Ż��ۿ����͵�ֵ
     */
    public String getProfitType(){
        return profitType;
    }

    /**
     * ���������ڴ�
     * @param profitPeriod �����õ������ڴε�ֵ
     */
    public void setProfitPeriod(int profitPeriod){
        this.profitPeriod = profitPeriod;
    }

    /**
     * ��ȡ�����ڴ�
     * @return �����ڴε�ֵ
     */
    public int getProfitPeriod(){
        return profitPeriod;
    }

    /**
     * �������Ա���������
     * @param itemKindNo �����õ����Ա��������ŵ�ֵ
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * ��ȡ���Ա���������
     * @return ���Ա��������ŵ�ֵ
     */
    public int getItemKindNo(){
        return itemKindNo;
    }

    /**
     * ���������ձ����
     * @param kindCode �����õ������ձ�����ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ�����ձ����
     * @return �����ձ�����ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * ���������ձ�����
     * @param kindName �����õ������ձ����Ƶ�ֵ
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����Ƶ�ֵ
     */
    public String getKindName(){
        return kindName;
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
     * ����������������ֵ
     * @param fieldValue �����õ�������������ֵ��ֵ
     */
    public void setFieldValue(double fieldValue){
        this.fieldValue = fieldValue;
    }

    /**
     * ��ȡ������������ֵ
     * @return ������������ֵ��ֵ
     */
    public double getFieldValue(){
        return fieldValue;
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
     * �������Ը������Ƿ�ѡ�б�־
     * @param chooseFlag �����õ����Ը������Ƿ�ѡ�б�־��ֵ
     */
    public void setChooseFlag(String chooseFlag){
        this.chooseFlag = StringUtils.rightTrim(chooseFlag);
    }

    /**
     * ��ȡ���Ը������Ƿ�ѡ�б�־
     * @return ���Ը������Ƿ�ѡ�б�־��ֵ
     */
    public String getChooseFlag(){
        return chooseFlag;
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
