package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpjpremalloc������ҵ�񱣷ѷ�̯������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJpremAllocDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Է�̯���� */
    private String allocNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** �����ո���ԭ����� */
    private String payReason = "";
    /** ���Ա��� */
    private String currency = "";
    /** �����ܱ��� */
    private double sumPremium = 0d;
    /** ����ʣ��δ��̯���� */
    private double prePremium = 0d;
    /** ���Ա��η�̯���� */
    private double allocPremium = 0d;
    /** ���Է�̯��� */
    private double allocFee = 0d;
    /** ���Է�̯���� */
    private DateTime allocDate = new DateTime();
    /** ���Գɹ�ת���ո�ϵͳ��־ */
    private String transFlag = "";
    /** ���Թ����������� */
    private String comCode = "";
    /** ���Գ����������� */
    private String makeCom = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ���ԵǼ����� */
    private DateTime inputDate = new DateTime();
    /** ����Ԥ����־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpJpremAllocDtoBase����
     */
    public PrpJpremAllocDtoBase(){
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
     * �������Է�̯����
     * @param allocNo �����õ����Է�̯�����ֵ
     */
    public void setAllocNo(String allocNo){
        this.allocNo = StringUtils.rightTrim(allocNo);
    }

    /**
     * ��ȡ���Է�̯����
     * @return ���Է�̯�����ֵ
     */
    public String getAllocNo(){
        return allocNo;
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
     * ���������ո���ԭ�����
     * @param payReason �����õ������ո���ԭ������ֵ
     */
    public void setPayReason(String payReason){
        this.payReason = StringUtils.rightTrim(payReason);
    }

    /**
     * ��ȡ�����ո���ԭ�����
     * @return �����ո���ԭ������ֵ
     */
    public String getPayReason(){
        return payReason;
    }

    /**
     * �������Ա���
     * @param currency �����õ����Ա��ֵ�ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա��ֵ�ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ���������ܱ���
     * @param sumPremium �����õ������ܱ��ѵ�ֵ
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * ��ȡ�����ܱ���
     * @return �����ܱ��ѵ�ֵ
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * ��������ʣ��δ��̯����
     * @param prePremium �����õ�����ʣ��δ��̯���ѵ�ֵ
     */
    public void setPrePremium(double prePremium){
        this.prePremium = prePremium;
    }

    /**
     * ��ȡ����ʣ��δ��̯����
     * @return ����ʣ��δ��̯���ѵ�ֵ
     */
    public double getPrePremium(){
        return prePremium;
    }

    /**
     * �������Ա��η�̯����
     * @param allocPremium �����õ����Ա��η�̯���ѵ�ֵ
     */
    public void setAllocPremium(double allocPremium){
        this.allocPremium = allocPremium;
    }

    /**
     * ��ȡ���Ա��η�̯����
     * @return ���Ա��η�̯���ѵ�ֵ
     */
    public double getAllocPremium(){
        return allocPremium;
    }

    /**
     * �������Է�̯���
     * @param allocFee �����õ����Է�̯����ֵ
     */
    public void setAllocFee(double allocFee){
        this.allocFee = allocFee;
    }

    /**
     * ��ȡ���Է�̯���
     * @return ���Է�̯����ֵ
     */
    public double getAllocFee(){
        return allocFee;
    }

    /**
     * �������Է�̯����
     * @param allocDate �����õ����Է�̯���ڵ�ֵ
     */
    public void setAllocDate(DateTime allocDate){
        this.allocDate = allocDate;
    }

    /**
     * ��ȡ���Է�̯����
     * @return ���Է�̯���ڵ�ֵ
     */
    public DateTime getAllocDate(){
        return allocDate;
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
     * �������Թ�����������
     * @param comCode �����õ����Թ������������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Թ�����������
     * @return ���Թ������������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Գ�����������
     * @param makeCom �����õ����Գ������������ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ���Գ�����������
     * @return ���Գ������������ֵ
     */
    public String getMakeCom(){
        return makeCom;
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
