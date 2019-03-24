package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǽ����������Ϣ�����ݴ���������<br>
 */
public class PrpLinterCompeFeeDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ��������pk */
    private String id = "";
    /** �����������pk */
    private int serialNo = 0;
    /** ���Ա����� */
    private long itemKindNo = 0L;
    /** �����ձ���� */
    private String kindCode = "";
    /** �����ձ����� */
    private String kindName = "";
    /** ���Աұ���� */
    private String currency = "";
    /** ���������� */
    private double sumLoss = 0D;
    /** �����Էѽ�� */
    private double sumRest = 0D;
    /** ��������� */
    private double deductible = 0D;
    /** �����⳥����% */
    private double claimRete = 0D;
    /** ���Ը������ */
    private double sumRealPay = 0D;
    /** ���Ա�ע */
    private String remark = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterCompeFeeDtoBase����
     */
    public PrpLinterCompeFeeDtoBase(){
    }

    /**
     * ������������pk
     * @param id �����õ���������pk��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ��������pk
     * @return ��������pk��ֵ
     */
    public String getId(){
        return id;
    }

    /**
     * ���������������pk
     * @param serialNo �����õ������������pk��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�����������pk
     * @return �����������pk��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Ա�����
     * @param itemKindNo �����õ����Ա����ŵ�ֵ
     */
    public void setItemKindNo(long itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public long getItemKindNo(){
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
     * �������Աұ����
     * @param currency �����õ����Աұ�����ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ����
     * @return ���Աұ�����ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ��������������
     * @param sumLoss �����õ������������ֵ
     */
    public void setSumLoss(double sumLoss){
        this.sumLoss = sumLoss;
    }

    /**
     * ��ȡ����������
     * @return �����������ֵ
     */
    public double getSumLoss(){
        return sumLoss;
    }

    /**
     * ���������Էѽ��
     * @param sumRest �����õ������Էѽ���ֵ
     */
    public void setSumRest(double sumRest){
        this.sumRest = sumRest;
    }

    /**
     * ��ȡ�����Էѽ��
     * @return �����Էѽ���ֵ
     */
    public double getSumRest(){
        return sumRest;
    }

    /**
     * �������������
     * @param deductible �����õ�����������ֵ
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * ��ȡ���������
     * @return ����������ֵ
     */
    public double getDeductible(){
        return deductible;
    }

    /**
     * ���������⳥����%
     * @param claimRete �����õ������⳥����%��ֵ
     */
    public void setClaimRete(double claimRete){
        this.claimRete = claimRete;
    }

    /**
     * ��ȡ�����⳥����%
     * @return �����⳥����%��ֵ
     */
    public double getClaimRete(){
        return claimRete;
    }

    /**
     * �������Ը������
     * @param sumRealPay �����õ����Ը�������ֵ
     */
    public void setSumRealPay(double sumRealPay){
        this.sumRealPay = sumRealPay;
    }

    /**
     * ��ȡ���Ը������
     * @return ���Ը�������ֵ
     */
    public double getSumRealPay(){
        return sumRealPay;
    }

    /**
     * �������Ա�ע
     * @param remark �����õ����Ա�ע��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Ա�ע
     * @return ���Ա�ע��ֵ
     */
    public String getRemark(){
        return remark;
    }
}
