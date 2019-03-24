package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpditem�����Ŀ���������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDitemDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա����Ŀ���� */
    private String itemCode = "";
    /** ���Ա����Ŀ�������� */
    private String itemCName = "";
    /** ���Ա����ĿӢ������ */
    private String itemEName = "";
    /** ���Ա����Ŀ����־ */
    private String itemFlag = "";
    /** �����µı����Ŀ������ */
    private String newItemCode = "";
    /** ����Ч��״̬(0ʧЧ/1��Ч) */
    private String validStatus = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDitemDtoBase����
     */
    public PrpDitemDtoBase(){
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
     * �������Ա����Ŀ����
     * @param itemCode �����õ����Ա����Ŀ�����ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ���Ա����Ŀ����
     * @return ���Ա����Ŀ�����ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * �������Ա����Ŀ��������
     * @param itemCName �����õ����Ա����Ŀ�������Ƶ�ֵ
     */
    public void setItemCName(String itemCName){
        this.itemCName = StringUtils.rightTrim(itemCName);
    }

    /**
     * ��ȡ���Ա����Ŀ��������
     * @return ���Ա����Ŀ�������Ƶ�ֵ
     */
    public String getItemCName(){
        return itemCName;
    }

    /**
     * �������Ա����ĿӢ������
     * @param itemEName �����õ����Ա����ĿӢ�����Ƶ�ֵ
     */
    public void setItemEName(String itemEName){
        this.itemEName = StringUtils.rightTrim(itemEName);
    }

    /**
     * ��ȡ���Ա����ĿӢ������
     * @return ���Ա����ĿӢ�����Ƶ�ֵ
     */
    public String getItemEName(){
        return itemEName;
    }

    /**
     * �������Ա����Ŀ����־
     * @param itemFlag �����õ����Ա����Ŀ����־��ֵ
     */
    public void setItemFlag(String itemFlag){
        this.itemFlag = StringUtils.rightTrim(itemFlag);
    }

    /**
     * ��ȡ���Ա����Ŀ����־
     * @return ���Ա����Ŀ����־��ֵ
     */
    public String getItemFlag(){
        return itemFlag;
    }

    /**
     * ���������µı����Ŀ������
     * @param newItemCode �����õ������µı����Ŀ�������ֵ
     */
    public void setNewItemCode(String newItemCode){
        this.newItemCode = StringUtils.rightTrim(newItemCode);
    }

    /**
     * ��ȡ�����µı����Ŀ������
     * @return �����µı����Ŀ�������ֵ
     */
    public String getNewItemCode(){
        return newItemCode;
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
