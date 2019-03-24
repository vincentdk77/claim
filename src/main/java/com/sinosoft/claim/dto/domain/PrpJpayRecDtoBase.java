package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpjpayrec�շѵǼǱ�����ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJpayRecDtoBase implements Serializable{
    /** �������� */
    private String riskCode = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Ա�������/�������� */
    private String certiNo = "";
    /** �����շ���� */
    private int order02No = 0;
    /** �����շѼƻ���Ӧ����� */
    private int serialNo = 0;
    /** �����Ż��˷���� */
    private int profitNo = 0;
    /** �����շ�ԭ����� */
    private String payReason = "";
    /** ����Ӧ�ձ��� */
    private String currency1 = "";
    /** ����Ӧ�ս�� */
    private double payFee = 0d;
    /** ����δ����� */
    private double delinquentFee = 0d;
    /** ���ԵǼ����� */
    private DateTime inputDate = new DateTime();
    /** ���Գɹ�ת���ո�ϵͳ��־ */
    private String transFlag = "";
    /** ����ʵ�ձ��� */
    private String currency2 = "";
    /** ����ʵ�ս�� */
    private double realPayFee = 0d;
    /** ����ʵ������ */
    private DateTime realPayDate = new DateTime();
    /** ���Թ������� */
    private String comCode = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ����Ԥ����־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpJpayRecDtoBase����
     */
    public PrpJpayRecDtoBase(){
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
     * �������Ա�������/��������
     * @param certiNo �����õ����Ա�������/���������ֵ
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * ��ȡ���Ա�������/��������
     * @return ���Ա�������/���������ֵ
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * ���������շ����
     * @param order02No �����õ������շ���ŵ�ֵ
     */
    public void setOrder02No(int order02No){
        this.order02No = order02No;
    }

    /**
     * ��ȡ�����շ����
     * @return �����շ���ŵ�ֵ
     */
    public int getOrder02No(){
        return order02No;
    }

    /**
     * ���������շѼƻ���Ӧ�����
     * @param serialNo �����õ������շѼƻ���Ӧ����ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�����շѼƻ���Ӧ�����
     * @return �����շѼƻ���Ӧ����ŵ�ֵ
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
     * ���������շ�ԭ�����
     * @param payReason �����õ������շ�ԭ������ֵ
     */
    public void setPayReason(String payReason){
        this.payReason = StringUtils.rightTrim(payReason);
    }

    /**
     * ��ȡ�����շ�ԭ�����
     * @return �����շ�ԭ������ֵ
     */
    public String getPayReason(){
        return payReason;
    }

    /**
     * ��������Ӧ�ձ���
     * @param currency1 �����õ�����Ӧ�ձ��ֵ�ֵ
     */
    public void setCurrency1(String currency1){
        this.currency1 = StringUtils.rightTrim(currency1);
    }

    /**
     * ��ȡ����Ӧ�ձ���
     * @return ����Ӧ�ձ��ֵ�ֵ
     */
    public String getCurrency1(){
        return currency1;
    }

    /**
     * ��������Ӧ�ս��
     * @param payFee �����õ�����Ӧ�ս���ֵ
     */
    public void setPayFee(double payFee){
        this.payFee = payFee;
    }

    /**
     * ��ȡ����Ӧ�ս��
     * @return ����Ӧ�ս���ֵ
     */
    public double getPayFee(){
        return payFee;
    }

    /**
     * ��������δ�����
     * @param delinquentFee �����õ�����δ������ֵ
     */
    public void setDelinquentFee(double delinquentFee){
        this.delinquentFee = delinquentFee;
    }

    /**
     * ��ȡ����δ�����
     * @return ����δ������ֵ
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
     * ��������ʵ�ձ���
     * @param currency2 �����õ�����ʵ�ձ��ֵ�ֵ
     */
    public void setCurrency2(String currency2){
        this.currency2 = StringUtils.rightTrim(currency2);
    }

    /**
     * ��ȡ����ʵ�ձ���
     * @return ����ʵ�ձ��ֵ�ֵ
     */
    public String getCurrency2(){
        return currency2;
    }

    /**
     * ��������ʵ�ս��
     * @param realPayFee �����õ�����ʵ�ս���ֵ
     */
    public void setRealPayFee(double realPayFee){
        this.realPayFee = realPayFee;
    }

    /**
     * ��ȡ����ʵ�ս��
     * @return ����ʵ�ս���ֵ
     */
    public double getRealPayFee(){
        return realPayFee;
    }

    /**
     * ��������ʵ������
     * @param realPayDate �����õ�����ʵ�����ڵ�ֵ
     */
    public void setRealPayDate(DateTime realPayDate){
        this.realPayDate = realPayDate;
    }

    /**
     * ��ȡ����ʵ������
     * @return ����ʵ�����ڵ�ֵ
     */
    public DateTime getRealPayDate(){
        return realPayDate;
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
