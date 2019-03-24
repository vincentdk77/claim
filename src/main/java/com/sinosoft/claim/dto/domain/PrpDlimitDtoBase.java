package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdlimit�޶�������������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDlimitDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** �����޶�/���������� */
    private String limitCode = "";
    /** �����޶�/������������ */
    private String limitCName = "";
    /** �����޶�/����Ӣ������ */
    private String limitEName = "";
    /** �����޶�/�������ȼ���[0,9] */
    private String limitPriority = "";
    /** ���Ա�Ĵ��� */
    private String itemCode = "";
    /** ����Ͷ����ʽ/���η��� */
    private String modeCode = "";
    /** �����⳥�޶� */
    private double limitFee = 0d;
    /** �����ձ� */
    private String kindCode = "";
    /** �����޶�֮���ϵ */
    private String limitRelation = "";
    /** �����޶�֮���ϵ˵�� */
    private String limitRelationDesc = "";
    /** �����µ��޶������� */
    private String newLimitCode = "";
    /** ����Ч��״̬(0ʧЧ/1��Ч) */
    private String validStatus = "";
    /** �����޶���� */
    private String limitFlag = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDlimitDtoBase����
     */
    public PrpDlimitDtoBase(){
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
     * ���������޶�/����������
     * @param limitCode �����õ������޶�/�����������ֵ
     */
    public void setLimitCode(String limitCode){
        this.limitCode = StringUtils.rightTrim(limitCode);
    }

    /**
     * ��ȡ�����޶�/����������
     * @return �����޶�/�����������ֵ
     */
    public String getLimitCode(){
        return limitCode;
    }

    /**
     * ���������޶�/������������
     * @param limitCName �����õ������޶�/�����������Ƶ�ֵ
     */
    public void setLimitCName(String limitCName){
        this.limitCName = StringUtils.rightTrim(limitCName);
    }

    /**
     * ��ȡ�����޶�/������������
     * @return �����޶�/�����������Ƶ�ֵ
     */
    public String getLimitCName(){
        return limitCName;
    }

    /**
     * ���������޶�/����Ӣ������
     * @param limitEName �����õ������޶�/����Ӣ�����Ƶ�ֵ
     */
    public void setLimitEName(String limitEName){
        this.limitEName = StringUtils.rightTrim(limitEName);
    }

    /**
     * ��ȡ�����޶�/����Ӣ������
     * @return �����޶�/����Ӣ�����Ƶ�ֵ
     */
    public String getLimitEName(){
        return limitEName;
    }

    /**
     * ���������޶�/�������ȼ���[0,9]
     * @param limitPriority �����õ������޶�/�������ȼ���[0,9]��ֵ
     */
    public void setLimitPriority(String limitPriority){
        this.limitPriority = StringUtils.rightTrim(limitPriority);
    }

    /**
     * ��ȡ�����޶�/�������ȼ���[0,9]
     * @return �����޶�/�������ȼ���[0,9]��ֵ
     */
    public String getLimitPriority(){
        return limitPriority;
    }

    /**
     * �������Ա�Ĵ���
     * @param itemCode �����õ����Ա�Ĵ����ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ���Ա�Ĵ���
     * @return ���Ա�Ĵ����ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * ��������Ͷ����ʽ/���η���
     * @param modeCode �����õ�����Ͷ����ʽ/���η����ֵ
     */
    public void setModeCode(String modeCode){
        this.modeCode = StringUtils.rightTrim(modeCode);
    }

    /**
     * ��ȡ����Ͷ����ʽ/���η���
     * @return ����Ͷ����ʽ/���η����ֵ
     */
    public String getModeCode(){
        return modeCode;
    }

    /**
     * ���������⳥�޶�
     * @param limitFee �����õ������⳥�޶��ֵ
     */
    public void setLimitFee(double limitFee){
        this.limitFee = limitFee;
    }

    /**
     * ��ȡ�����⳥�޶�
     * @return �����⳥�޶��ֵ
     */
    public double getLimitFee(){
        return limitFee;
    }

    /**
     * ���������ձ�
     * @param kindCode �����õ������ձ��ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ�����ձ�
     * @return �����ձ��ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * ���������޶�֮���ϵ
     * @param limitRelation �����õ������޶�֮���ϵ��ֵ
     */
    public void setLimitRelation(String limitRelation){
        this.limitRelation = StringUtils.rightTrim(limitRelation);
    }

    /**
     * ��ȡ�����޶�֮���ϵ
     * @return �����޶�֮���ϵ��ֵ
     */
    public String getLimitRelation(){
        return limitRelation;
    }

    /**
     * ���������޶�֮���ϵ˵��
     * @param limitRelationDesc �����õ������޶�֮���ϵ˵����ֵ
     */
    public void setLimitRelationDesc(String limitRelationDesc){
        this.limitRelationDesc = StringUtils.rightTrim(limitRelationDesc);
    }

    /**
     * ��ȡ�����޶�֮���ϵ˵��
     * @return �����޶�֮���ϵ˵����ֵ
     */
    public String getLimitRelationDesc(){
        return limitRelationDesc;
    }

    /**
     * ���������µ��޶�������
     * @param newLimitCode �����õ������µ��޶��������ֵ
     */
    public void setNewLimitCode(String newLimitCode){
        this.newLimitCode = StringUtils.rightTrim(newLimitCode);
    }

    /**
     * ��ȡ�����µ��޶�������
     * @return �����µ��޶��������ֵ
     */
    public String getNewLimitCode(){
        return newLimitCode;
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
     * ���������޶����
     * @param limitFlag �����õ������޶�����ֵ
     */
    public void setLimitFlag(String limitFlag){
        this.limitFlag = StringUtils.rightTrim(limitFlag);
    }

    /**
     * ��ȡ�����޶����
     * @return �����޶�����ֵ
     */
    public String getLimitFlag(){
        return limitFlag;
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
