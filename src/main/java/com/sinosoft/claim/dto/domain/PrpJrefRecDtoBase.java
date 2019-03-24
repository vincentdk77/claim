package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpjrefrec���ѵǼǱ�����ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJrefRecDtoBase implements Serializable{
    /** �������� */
    private String riskCode = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Ե������� */
    private String certiType = "";
    /** ���Ա�������/��������/����������� */
    private String certiNo = "";
    /** ���Ա��θ������ */
    private int serialNo = 0;
    /** �����Ż��˷���� */
    private int profitNo = 0;
    /** ���Ը���ԭ����� */
    private String refundReason = "";
    /** ����Ӧ������ */
    private String currency1 = "";
    /** ����Ӧ����� */
    private double refundFee = 0d;
    /** ������������� */
    private String refundName = "";
    /** ���ԵǼ����� */
    private DateTime inputDate = new DateTime();
    /** ���Գɹ�ת���ո�ϵͳ��־ */
    private String transFlag = "";
    /** ����ʵ������ */
    private String currency2 = "";
    /** ����ʵ����� */
    private double realRefundFee = 0d;
    /** ����ʵ������ */
    private DateTime realRefundDate = new DateTime();
    /** ���Թ������� */
    private String comCode = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ����Ԥ����־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpJrefRecDtoBase����
     */
    public PrpJrefRecDtoBase(){
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
     * �������Ե�������
     * @param certiType �����õ����Ե������͵�ֵ
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * ��ȡ���Ե�������
     * @return ���Ե������͵�ֵ
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * �������Ա�������/��������/�����������
     * @param certiNo �����õ����Ա�������/��������/������������ֵ
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * ��ȡ���Ա�������/��������/�����������
     * @return ���Ա�������/��������/������������ֵ
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * �������Ա��θ������
     * @param serialNo �����õ����Ա��θ�����ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ���Ա��θ������
     * @return ���Ա��θ�����ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ���������Ż��˷����
     * @param profitNo �����õ������Ż��˷���ŵ�ֵ
     */
    public void setProfitNo(int profitNo){
        this.profitNo = profitNo;
    }

    /**
     * ��ȡ�����Ż��˷����
     * @return �����Ż��˷���ŵ�ֵ
     */
    public int getProfitNo(){
        return profitNo;
    }

    /**
     * �������Ը���ԭ�����
     * @param refundReason �����õ����Ը���ԭ������ֵ
     */
    public void setRefundReason(String refundReason){
        this.refundReason = StringUtils.rightTrim(refundReason);
    }

    /**
     * ��ȡ���Ը���ԭ�����
     * @return ���Ը���ԭ������ֵ
     */
    public String getRefundReason(){
        return refundReason;
    }

    /**
     * ��������Ӧ������
     * @param currency1 �����õ�����Ӧ�����ֵ�ֵ
     */
    public void setCurrency1(String currency1){
        this.currency1 = StringUtils.rightTrim(currency1);
    }

    /**
     * ��ȡ����Ӧ������
     * @return ����Ӧ�����ֵ�ֵ
     */
    public String getCurrency1(){
        return currency1;
    }

    /**
     * ��������Ӧ�����
     * @param refundFee �����õ�����Ӧ������ֵ
     */
    public void setRefundFee(double refundFee){
        this.refundFee = refundFee;
    }

    /**
     * ��ȡ����Ӧ�����
     * @return ����Ӧ������ֵ
     */
    public double getRefundFee(){
        return refundFee;
    }

    /**
     * �����������������
     * @param refundName �����õ�������������Ƶ�ֵ
     */
    public void setRefundName(String refundName){
        this.refundName = StringUtils.rightTrim(refundName);
    }

    /**
     * ��ȡ�������������
     * @return ������������Ƶ�ֵ
     */
    public String getRefundName(){
        return refundName;
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
     * �������Գɹ�ת���ո�ϵͳ��־
     * @param transFlag �����õ����Գɹ�ת���ո�ϵͳ��־��ֵ
     */
    public void setTransFlag(String transFlag){
        this.transFlag = StringUtils.rightTrim(transFlag);
    }

    /**
     * ��ȡ���Գɹ�ת���ո�ϵͳ��־
     * @return ���Գɹ�ת���ո�ϵͳ��־��ֵ
     */
    public String getTransFlag(){
        return transFlag;
    }

    /**
     * ��������ʵ������
     * @param currency2 �����õ�����ʵ�����ֵ�ֵ
     */
    public void setCurrency2(String currency2){
        this.currency2 = StringUtils.rightTrim(currency2);
    }

    /**
     * ��ȡ����ʵ������
     * @return ����ʵ�����ֵ�ֵ
     */
    public String getCurrency2(){
        return currency2;
    }

    /**
     * ��������ʵ�����
     * @param realRefundFee �����õ�����ʵ������ֵ
     */
    public void setRealRefundFee(double realRefundFee){
        this.realRefundFee = realRefundFee;
    }

    /**
     * ��ȡ����ʵ�����
     * @return ����ʵ������ֵ
     */
    public double getRealRefundFee(){
        return realRefundFee;
    }

    /**
     * ��������ʵ������
     * @param realRefundDate �����õ�����ʵ�����ڵ�ֵ
     */
    public void setRealRefundDate(DateTime realRefundDate){
        this.realRefundDate = realRefundDate;
    }

    /**
     * ��ȡ����ʵ������
     * @return ����ʵ�����ڵ�ֵ
     */
    public DateTime getRealRefundDate(){
        return realRefundDate;
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
     * �������Բ���Ա����
     * @param operatorCode �����õ����Բ���Ա�����ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Բ���Ա����
     * @return ���Բ���Ա�����ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * ��������Ԥ����־
     * @param flag �����õ�����Ԥ����־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����Ԥ����־
     * @return ����Ԥ����־��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
