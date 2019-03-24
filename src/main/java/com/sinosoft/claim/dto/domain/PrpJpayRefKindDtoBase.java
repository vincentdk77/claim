package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpjpayrefkind�ո����ձ��̯������ݴ���������<br>
 * ������ 2004-4-5 15:32:06<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJpayRefKindDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Ե�֤�� */
    private String certiNo = "";
    /** ������� */
    private int serialNo = 0;
    /** �������������� */
    private String clauseType = "";
    /** �����ձ���� */
    private String kindCode = "";
    /** �����ո���ԭ����루ͬ�ո���ϵͳ�� */
    private String payReason = "";
    /** ����Ӧ�ո��ұ� */
    private String currency1 = "";
    /** ����Ӧ�ո���� */
    private double payRefFee = 0d;
    /** ������Ƿ��� */
    private double delinquentFee = 0d;
    /** ���ԵǼ����� */
    private DateTime inputDate = new DateTime();
    /** ����ʵ�ո��ұ� */
    private String currency2 = "";
    /** ����ʵ�ո���� */
    private double realPayRefFee = 0d;
    /** ����ʵ�ո����� */
    private DateTime realPayRefDate = new DateTime();
    /** ���Թ������� */
    private String comCode = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpJpayRefKindDtoBase����
     */
    public PrpJpayRefKindDtoBase(){
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
     * �������Ե�֤��
     * @param certiNo �����õ����Ե�֤�ŵ�ֵ
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * ��ȡ���Ե�֤��
     * @return ���Ե�֤�ŵ�ֵ
     */
    public String getCertiNo(){
        return certiNo;
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
     * ������������������
     * @param clauseType �����õ����������������ֵ
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * ��ȡ��������������
     * @return ���������������ֵ
     */
    public String getClauseType(){
        return clauseType;
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
     * ���������ո���ԭ����루ͬ�ո���ϵͳ��
     * @param payReason �����õ������ո���ԭ����루ͬ�ո���ϵͳ����ֵ
     */
    public void setPayReason(String payReason){
        this.payReason = StringUtils.rightTrim(payReason);
    }

    /**
     * ��ȡ�����ո���ԭ����루ͬ�ո���ϵͳ��
     * @return �����ո���ԭ����루ͬ�ո���ϵͳ����ֵ
     */
    public String getPayReason(){
        return payReason;
    }

    /**
     * ��������Ӧ�ո��ұ�
     * @param currency1 �����õ�����Ӧ�ո��ұ��ֵ
     */
    public void setCurrency1(String currency1){
        this.currency1 = StringUtils.rightTrim(currency1);
    }

    /**
     * ��ȡ����Ӧ�ո��ұ�
     * @return ����Ӧ�ո��ұ��ֵ
     */
    public String getCurrency1(){
        return currency1;
    }

    /**
     * ��������Ӧ�ո����
     * @param payRefFee �����õ�����Ӧ�ո�����ֵ
     */
    public void setPayRefFee(double payRefFee){
        this.payRefFee = payRefFee;
    }

    /**
     * ��ȡ����Ӧ�ո����
     * @return ����Ӧ�ո�����ֵ
     */
    public double getPayRefFee(){
        return payRefFee;
    }

    /**
     * ����������Ƿ���
     * @param delinquentFee �����õ�������Ƿ����ֵ
     */
    public void setDelinquentFee(double delinquentFee){
        this.delinquentFee = delinquentFee;
    }

    /**
     * ��ȡ������Ƿ���
     * @return ������Ƿ����ֵ
     */
    public double getDelinquentFee(){
        return delinquentFee;
    }

    /**
     * �������ԵǼ�����
     * @param inputDate �����õ����ԵǼ����ڵ�ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ���ԵǼ�����
     * @return ���ԵǼ����ڵ�ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * ��������ʵ�ո��ұ�
     * @param currency2 �����õ�����ʵ�ո��ұ��ֵ
     */
    public void setCurrency2(String currency2){
        this.currency2 = StringUtils.rightTrim(currency2);
    }

    /**
     * ��ȡ����ʵ�ո��ұ�
     * @return ����ʵ�ո��ұ��ֵ
     */
    public String getCurrency2(){
        return currency2;
    }

    /**
     * ��������ʵ�ո����
     * @param realPayRefFee �����õ�����ʵ�ո�����ֵ
     */
    public void setRealPayRefFee(double realPayRefFee){
        this.realPayRefFee = realPayRefFee;
    }

    /**
     * ��ȡ����ʵ�ո����
     * @return ����ʵ�ո�����ֵ
     */
    public double getRealPayRefFee(){
        return realPayRefFee;
    }

    /**
     * ��������ʵ�ո�����
     * @param realPayRefDate �����õ�����ʵ�ո����ڵ�ֵ
     */
    public void setRealPayRefDate(DateTime realPayRefDate){
        this.realPayRefDate = realPayRefDate;
    }

    /**
     * ��ȡ����ʵ�ո�����
     * @return ����ʵ�ո����ڵ�ֵ
     */
    public DateTime getRealPayRefDate(){
        return realPayRefDate;
    }

    /**
     * �������Թ�������
     * @param comCode �����õ����Թ���������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Թ�������
     * @return ���Թ���������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Ա�־λ
     * @param flag �����õ����Ա�־λ��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־λ
     * @return ���Ա�־λ��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
