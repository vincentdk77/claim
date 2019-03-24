package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLassureDetail-��������ϸ�������������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.500<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLassureDetailDtoBase implements Serializable{
    /** ���Ե����� */
    private String assureNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Ա������� */
    private String policyNo = "";
    /** �����ᵥ�� */
    private String ladingNo = "";
    /** ���Ի������� */
    private String goodsDetailName = "";
    /** ���Ա�� */
    private String marks = "";
    /** �������� */
    private String count = "";
    /** ���Աұ� */
    private String currency = "";
    /** ����Amount */
    private double amount = 0d;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLassureDetailDtoBase����
     */
    public PrpLassureDetailDtoBase(){
    }

    /**
     * �������Ե�����
     * @param assureNo �����õ����Ե����ŵ�ֵ
     */
    public void setAssureNo(String assureNo){
        this.assureNo = StringUtils.rightTrim(assureNo);
    }

    /**
     * ��ȡ���Ե�����
     * @return ���Ե����ŵ�ֵ
     */
    public String getAssureNo(){
        return assureNo;
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
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ���������ᵥ��
     * @param ladingNo �����õ������ᵥ�ŵ�ֵ
     */
    public void setLadingNo(String ladingNo){
        this.ladingNo = StringUtils.rightTrim(ladingNo);
    }

    /**
     * ��ȡ�����ᵥ��
     * @return �����ᵥ�ŵ�ֵ
     */
    public String getLadingNo(){
        return ladingNo;
    }

    /**
     * �������Ի�������
     * @param goodsDetailName �����õ����Ի������Ƶ�ֵ
     */
    public void setGoodsDetailName(String goodsDetailName){
        this.goodsDetailName = StringUtils.rightTrim(goodsDetailName);
    }

    /**
     * ��ȡ���Ի�������
     * @return ���Ի������Ƶ�ֵ
     */
    public String getGoodsDetailName(){
        return goodsDetailName;
    }

    /**
     * �������Ա��
     * @param marks �����õ����Ա�ǵ�ֵ
     */
    public void setMarks(String marks){
        this.marks = StringUtils.rightTrim(marks);
    }

    /**
     * ��ȡ���Ա��
     * @return ���Ա�ǵ�ֵ
     */
    public String getMarks(){
        return marks;
    }

    /**
     * ������������
     * @param count �����õ�����������ֵ
     */
    public void setCount(String count){
        this.count = StringUtils.rightTrim(count);
    }

    /**
     * ��ȡ��������
     * @return ����������ֵ
     */
    public String getCount(){
        return count;
    }

    /**
     * �������Աұ�
     * @param currency �����õ����Աұ��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ�
     * @return ���Աұ��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ��������Amount
     * @param amount �����õ�����Amount��ֵ
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * ��ȡ����Amount
     * @return ����Amount��ֵ
     */
    public double getAmount(){
        return amount;
    }
}
