package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLmedicine-��Աҽҩ���嵥������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.375<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLmedicineDtoBase implements Serializable{
    /** �����ⰸ�� */
    private String claimNo = "";
    /** �������� */
    private String riskCode = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Ա������������� */
    private int itemKindNo = 0;
    /** ���Էֻ����(�����ڼ���Ҳ���) */
    private int familyNo = 0;
    /** ���Էֻ�����(�����ڼ���Ҳ���) */
    private String familyName = "";
    /** �����ձ���� */
    private String kindCode = "";
    /** ���Ա��������Ŀ���� */
    private String itemCode = "";
    /** ���Թ�Ա���� */
    private String employeeCode = "";
    /** ���Թ�Ա���� */
    private String employeeName = "";
    /** ���Ը��ַ��ô���--** 1-����ҽҩ�� 
--** 2-�󹤹���
--** 5-����ҽҩ�� 
--** 6-�� 0-���� */
    private String feeTypeCode = "";
    /** ���Է������� */
    private String feeTypeName = "";
    /** ���Աұ���� */
    private String currency = "";
    /** �����⳥�޶� */
    private double indemnityLimit = 0d;
    /** �����վ��� */
    private int receiptCount = 0;
    /** �����վݽ�� */
    private double receiptAmt = 0d;
    /** �����վ����� */
    private DateTime receiptDate = new DateTime();
    /** ���������� */
    private int missWorkDays = 0;
    /** ���������� */
    private double sumLoss = 0d;
    /** �����޳���� */
    private double sumReject = 0d;
    /** �����޳�ԭ�� */
    private String rejectReason = "";
    /** �����⳥���� */
    private double lossRate = 0d;
    /** ���Ժ˶����� */
    private double sumDefLoss = 0d;
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLmedicineDtoBase����
     */
    public PrpLmedicineDtoBase(){
    }

    /**
     * ���������ⰸ��
     * @param claimNo �����õ������ⰸ�ŵ�ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ��
     * @return �����ⰸ�ŵ�ֵ
     */
    public String getClaimNo(){
        return claimNo;
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
     * �������Ա�������������
     * @param itemKindNo �����õ����Ա������������ŵ�ֵ
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * ��ȡ���Ա�������������
     * @return ���Ա������������ŵ�ֵ
     */
    public int getItemKindNo(){
        return itemKindNo;
    }

    /**
     * �������Էֻ����(�����ڼ���Ҳ���)
     * @param familyNo �����õ����Էֻ����(�����ڼ���Ҳ���)��ֵ
     */
    public void setFamilyNo(int familyNo){
        this.familyNo = familyNo;
    }

    /**
     * ��ȡ���Էֻ����(�����ڼ���Ҳ���)
     * @return ���Էֻ����(�����ڼ���Ҳ���)��ֵ
     */
    public int getFamilyNo(){
        return familyNo;
    }

    /**
     * �������Էֻ�����(�����ڼ���Ҳ���)
     * @param familyName �����õ����Էֻ�����(�����ڼ���Ҳ���)��ֵ
     */
    public void setFamilyName(String familyName){
        this.familyName = StringUtils.rightTrim(familyName);
    }

    /**
     * ��ȡ���Էֻ�����(�����ڼ���Ҳ���)
     * @return ���Էֻ�����(�����ڼ���Ҳ���)��ֵ
     */
    public String getFamilyName(){
        return familyName;
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
     * �������Ա��������Ŀ����
     * @param itemCode �����õ����Ա��������Ŀ�����ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ���Ա��������Ŀ����
     * @return ���Ա��������Ŀ�����ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * �������Թ�Ա����
     * @param employeeCode �����õ����Թ�Ա�����ֵ
     */
    public void setEmployeeCode(String employeeCode){
        this.employeeCode = StringUtils.rightTrim(employeeCode);
    }

    /**
     * ��ȡ���Թ�Ա����
     * @return ���Թ�Ա�����ֵ
     */
    public String getEmployeeCode(){
        return employeeCode;
    }

    /**
     * �������Թ�Ա����
     * @param employeeName �����õ����Թ�Ա������ֵ
     */
    public void setEmployeeName(String employeeName){
        this.employeeName = StringUtils.rightTrim(employeeName);
    }

    /**
     * ��ȡ���Թ�Ա����
     * @return ���Թ�Ա������ֵ
     */
    public String getEmployeeName(){
        return employeeName;
    }

    /**
     * �������Ը��ַ��ô���--** 1-����ҽҩ�� 
--** 2-�󹤹���
--** 5-����ҽҩ�� 
--** 6-�� 0-����
     * @param feeTypeCode �����õ����Ը��ַ��ô���--** 1-����ҽҩ�� 
--** 2-�󹤹���
--** 5-����ҽҩ�� 
--** 6-�� 0-������ֵ
     */
    public void setFeeTypeCode(String feeTypeCode){
        this.feeTypeCode = StringUtils.rightTrim(feeTypeCode);
    }

    /**
     * ��ȡ���Ը��ַ��ô���--** 1-����ҽҩ�� 
--** 2-�󹤹���
--** 5-����ҽҩ�� 
--** 6-�� 0-����
     * @return ���Ը��ַ��ô���--** 1-����ҽҩ�� 
--** 2-�󹤹���
--** 5-����ҽҩ�� 
--** 6-�� 0-������ֵ
     */
    public String getFeeTypeCode(){
        return feeTypeCode;
    }

    /**
     * �������Է�������
     * @param feeTypeName �����õ����Է������Ƶ�ֵ
     */
    public void setFeeTypeName(String feeTypeName){
        this.feeTypeName = StringUtils.rightTrim(feeTypeName);
    }

    /**
     * ��ȡ���Է�������
     * @return ���Է������Ƶ�ֵ
     */
    public String getFeeTypeName(){
        return feeTypeName;
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
     * ���������⳥�޶�
     * @param indemnityLimit �����õ������⳥�޶��ֵ
     */
    public void setIndemnityLimit(double indemnityLimit){
        this.indemnityLimit = indemnityLimit;
    }

    /**
     * ��ȡ�����⳥�޶�
     * @return �����⳥�޶��ֵ
     */
    public double getIndemnityLimit(){
        return indemnityLimit;
    }

    /**
     * ���������վ���
     * @param receiptCount �����õ������վ�����ֵ
     */
    public void setReceiptCount(int receiptCount){
        this.receiptCount = receiptCount;
    }

    /**
     * ��ȡ�����վ���
     * @return �����վ�����ֵ
     */
    public int getReceiptCount(){
        return receiptCount;
    }

    /**
     * ���������վݽ��
     * @param receiptAmt �����õ������վݽ���ֵ
     */
    public void setReceiptAmt(double receiptAmt){
        this.receiptAmt = receiptAmt;
    }

    /**
     * ��ȡ�����վݽ��
     * @return �����վݽ���ֵ
     */
    public double getReceiptAmt(){
        return receiptAmt;
    }

    /**
     * ���������վ�����
     * @param receiptDate �����õ������վ����ڵ�ֵ
     */
    public void setReceiptDate(DateTime receiptDate){
        this.receiptDate = receiptDate;
    }

    /**
     * ��ȡ�����վ�����
     * @return �����վ����ڵ�ֵ
     */
    public DateTime getReceiptDate(){
        return receiptDate;
    }

    /**
     * ��������������
     * @param missWorkDays �����õ�������������ֵ
     */
    public void setMissWorkDays(int missWorkDays){
        this.missWorkDays = missWorkDays;
    }

    /**
     * ��ȡ����������
     * @return ������������ֵ
     */
    public int getMissWorkDays(){
        return missWorkDays;
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
     * ���������޳����
     * @param sumReject �����õ������޳�����ֵ
     */
    public void setSumReject(double sumReject){
        this.sumReject = sumReject;
    }

    /**
     * ��ȡ�����޳����
     * @return �����޳�����ֵ
     */
    public double getSumReject(){
        return sumReject;
    }

    /**
     * ���������޳�ԭ��
     * @param rejectReason �����õ������޳�ԭ���ֵ
     */
    public void setRejectReason(String rejectReason){
        this.rejectReason = StringUtils.rightTrim(rejectReason);
    }

    /**
     * ��ȡ�����޳�ԭ��
     * @return �����޳�ԭ���ֵ
     */
    public String getRejectReason(){
        return rejectReason;
    }

    /**
     * ���������⳥����
     * @param lossRate �����õ������⳥������ֵ
     */
    public void setLossRate(double lossRate){
        this.lossRate = lossRate;
    }

    /**
     * ��ȡ�����⳥����
     * @return �����⳥������ֵ
     */
    public double getLossRate(){
        return lossRate;
    }

    /**
     * �������Ժ˶�����
     * @param sumDefLoss �����õ����Ժ˶������ֵ
     */
    public void setSumDefLoss(double sumDefLoss){
        this.sumDefLoss = sumDefLoss;
    }

    /**
     * ��ȡ���Ժ˶�����
     * @return ���Ժ˶������ֵ
     */
    public double getSumDefLoss(){
        return sumDefLoss;
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
