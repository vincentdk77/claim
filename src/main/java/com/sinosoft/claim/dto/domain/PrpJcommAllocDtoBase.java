package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpjcommalloc�����ѷ�̯������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJcommAllocDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Է�̯�� */
    private String allocNo = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Է�̯��� */
    private int serialNo = 0;
    /** �����ո���ԭ����� */
    private String payReason = "";
    /** ���Ա��� */
    private String currency = "";
    /** ������������ */
    private double commission = 0d;
    /** ����δ̯������ */
    private double owCommission = 0d;
    /** ���Ա��η�̯���ѽ�� */
    private double allocFee = 0d;
    /** ���Է�̯���� */
    private DateTime allocDate = new DateTime();
    /** ����transflag */
    private String transFlag = "";
    /** ���Թ����������� */
    private String comCode = "";
    /** ���Գ����������� */
    private String makeCom = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ���ԵǼ����� */
    private DateTime inputDate = new DateTime();
    /** ����Ԥ�� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpJcommAllocDtoBase����
     */
    public PrpJcommAllocDtoBase(){
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
     * �������Է�̯��
     * @param allocNo �����õ����Է�̯�ŵ�ֵ
     */
    public void setAllocNo(String allocNo){
        this.allocNo = StringUtils.rightTrim(allocNo);
    }

    /**
     * ��ȡ���Է�̯��
     * @return ���Է�̯�ŵ�ֵ
     */
    public String getAllocNo(){
        return allocNo;
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
     * �������Է�̯���
     * @param serialNo �����õ����Է�̯��ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ���Է�̯���
     * @return ���Է�̯��ŵ�ֵ
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
     * ����������������
     * @param commission �����õ������������ѵ�ֵ
     */
    public void setCommission(double commission){
        this.commission = commission;
    }

    /**
     * ��ȡ������������
     * @return �����������ѵ�ֵ
     */
    public double getCommission(){
        return commission;
    }

    /**
     * ��������δ̯������
     * @param owCommission �����õ�����δ̯�����ѵ�ֵ
     */
    public void setOwCommission(double owCommission){
        this.owCommission = owCommission;
    }

    /**
     * ��ȡ����δ̯������
     * @return ����δ̯�����ѵ�ֵ
     */
    public double getOwCommission(){
        return owCommission;
    }

    /**
     * �������Ա��η�̯���ѽ��
     * @param allocFee �����õ����Ա��η�̯���ѽ���ֵ
     */
    public void setAllocFee(double allocFee){
        this.allocFee = allocFee;
    }

    /**
     * ��ȡ���Ա��η�̯���ѽ��
     * @return ���Ա��η�̯���ѽ���ֵ
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
     * ��������transflag
     * @param transFlag �����õ�����transflag��ֵ
     */
    public void setTransFlag(String transFlag){
        this.transFlag = StringUtils.rightTrim(transFlag);
    }

    /**
     * ��ȡ����transflag
     * @return ����transflag��ֵ
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
     * ��������Ԥ��
     * @param flag �����õ�����Ԥ����ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����Ԥ��
     * @return ����Ԥ����ֵ
     */
    public String getFlag(){
        return flag;
    }
}
