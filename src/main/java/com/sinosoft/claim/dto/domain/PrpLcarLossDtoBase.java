package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLcarLoss-�������������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.734<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcarLossDtoBase implements Serializable{
    /** �����ⰸ�� */
    private String claimNo = "";
    /** �������� */
    private String riskCode = "";
    /** ���Ա����� */
    private String registNo = "";
    /** ���Ա����� */
    private String lossItemCode = "";
    /** ���Գ��ƺ��� */
    private String lossItemName = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Աұ� */
    private String currency = "";
    /** �����޳����/��ֵ/���� */
    private double sumRest = 0d;
    /** ���Թ���� */
    private double sumManager = 0d;
    /** �����ܶ����� */
    private double sumCertainLoss = 0d;
    /** �����޳����/��ֵ/���ࣨ���� */
    private double sumVeriRest = 0d;
    /** ���Թ���ѣ����� */
    private double sumVeriManager = 0d;
    /** �����ܺ����� */
    private double sumVerifyLoss = 0d;
    /** ������ʧ��λ���̶ȸ��� */
    private String lossDesc = "";
    /** �����⳥���δ��� */
    private String indemnityDuty = "";
    /** �������α��� */
    private double indemnityDutyRate = 0d;
    /** �������α���(����) */
    private double veriIndeDutyRate = 0d;
    /** ���Ա�ע */
    private String remark = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ���Ը����˴��� */
    private String approverCode = "";
    /** �����¹����� */
    private String caseFlag = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** ����VIN���� */
    private String vINNo = "";
    /** ���Թ������ */
    private double sumManageFeeRate = 0d;
    /** ���Իؿ���� */
    private String backCheckRemark = "";
    /** �����Ƿ���Ҫ�ؿ� */
    private String backCheckFlag = "";
    
    /** ���Կɲ���/����ļ��� */
    private String handlerRange = "";
    
    /** ����SumTransFee */
    private double sumTransFee = 0D;
    /** ����SumTax */
    private double sumTax = 0D;
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcarLossDtoBase����
     */
    public PrpLcarLossDtoBase(){
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
     * @param registNo �����õ����Ա����ŵ�ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * �������Ա�����
     * @param lossItemCode �����õ����Ա����ŵ�ֵ
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * �������Գ��ƺ���
     * @param lossItemName �����õ����Գ��ƺ����ֵ
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * ��ȡ���Գ��ƺ���
     * @return ���Գ��ƺ����ֵ
     */
    public String getLossItemName(){
        return lossItemName;
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
     * ���������޳����/��ֵ/����
     * @param sumRest �����õ������޳����/��ֵ/�����ֵ
     */
    public void setSumRest(double sumRest){
        this.sumRest = sumRest;
    }

    /**
     * ��ȡ�����޳����/��ֵ/����
     * @return �����޳����/��ֵ/�����ֵ
     */
    public double getSumRest(){
        return sumRest;
    }

    /**
     * �������Թ����
     * @param sumManager �����õ����Թ���ѵ�ֵ
     */
    public void setSumManager(double sumManager){
        this.sumManager = sumManager;
    }

    /**
     * ��ȡ���Թ����
     * @return ���Թ���ѵ�ֵ
     */
    public double getSumManager(){
        return sumManager;
    }

    /**
     * ���������ܶ�����
     * @param sumCertainLoss �����õ������ܶ������ֵ
     */
    public void setSumCertainLoss(double sumCertainLoss){
        this.sumCertainLoss = sumCertainLoss;
    }

    /**
     * ��ȡ�����ܶ�����
     * @return �����ܶ������ֵ
     */
    public double getSumCertainLoss(){
        return sumCertainLoss;
    }

    /**
     * ���������޳����/��ֵ/���ࣨ����
     * @param sumVeriRest �����õ������޳����/��ֵ/���ࣨ���𣩵�ֵ
     */
    public void setSumVeriRest(double sumVeriRest){
        this.sumVeriRest = sumVeriRest;
    }

    /**
     * ��ȡ�����޳����/��ֵ/���ࣨ����
     * @return �����޳����/��ֵ/���ࣨ���𣩵�ֵ
     */
    public double getSumVeriRest(){
        return sumVeriRest;
    }

    /**
     * �������Թ���ѣ�����
     * @param sumVeriManager �����õ����Թ���ѣ����𣩵�ֵ
     */
    public void setSumVeriManager(double sumVeriManager){
        this.sumVeriManager = sumVeriManager;
    }

    /**
     * ��ȡ���Թ���ѣ�����
     * @return ���Թ���ѣ����𣩵�ֵ
     */
    public double getSumVeriManager(){
        return sumVeriManager;
    }

    /**
     * ���������ܺ�����
     * @param sumVerifyLoss �����õ������ܺ������ֵ
     */
    public void setSumVerifyLoss(double sumVerifyLoss){
        this.sumVerifyLoss = sumVerifyLoss;
    }

    /**
     * ��ȡ�����ܺ�����
     * @return �����ܺ������ֵ
     */
    public double getSumVerifyLoss(){
        return sumVerifyLoss;
    }

    /**
     * ����������ʧ��λ���̶ȸ���
     * @param lossDesc �����õ�������ʧ��λ���̶ȸ�����ֵ
     */
    public void setLossDesc(String lossDesc){
        this.lossDesc = StringUtils.rightTrim(lossDesc);
    }

    /**
     * ��ȡ������ʧ��λ���̶ȸ���
     * @return ������ʧ��λ���̶ȸ�����ֵ
     */
    public String getLossDesc(){
        return lossDesc;
    }

    /**
     * ���������⳥���δ���
     * @param indemnityDuty �����õ������⳥���δ����ֵ
     */
    public void setIndemnityDuty(String indemnityDuty){
        this.indemnityDuty = StringUtils.rightTrim(indemnityDuty);
    }

    /**
     * ��ȡ�����⳥���δ���
     * @return �����⳥���δ����ֵ
     */
    public String getIndemnityDuty(){
        return indemnityDuty;
    }

    /**
     * �����������α���
     * @param indemnityDutyRate �����õ��������α�����ֵ
     */
    public void setIndemnityDutyRate(double indemnityDutyRate){
        this.indemnityDutyRate = indemnityDutyRate;
    }

    /**
     * ��ȡ�������α���
     * @return �������α�����ֵ
     */
    public double getIndemnityDutyRate(){
        return indemnityDutyRate;
    }

    /**
     * �����������α���(����)
     * @param veriIndeDutyRate �����õ��������α���(����)��ֵ
     */
    public void setVeriIndeDutyRate(double veriIndeDutyRate){
        this.veriIndeDutyRate = veriIndeDutyRate;
    }

    /**
     * ��ȡ�������α���(����)
     * @return �������α���(����)��ֵ
     */
    public double getVeriIndeDutyRate(){
        return veriIndeDutyRate;
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
     * �������Ը����˴���
     * @param approverCode �����õ����Ը����˴����ֵ
     */
    public void setApproverCode(String approverCode){
        this.approverCode = StringUtils.rightTrim(approverCode);
    }

    /**
     * ��ȡ���Ը����˴���
     * @return ���Ը����˴����ֵ
     */
    public String getApproverCode(){
        return approverCode;
    }

    /**
     * ���������¹�����
     * @param caseFlag �����õ������¹����͵�ֵ
     */
    public void setCaseFlag(String caseFlag){
        this.caseFlag = StringUtils.rightTrim(caseFlag);
    }

    /**
     * ��ȡ�����¹�����
     * @return �����¹����͵�ֵ
     */
    public String getCaseFlag(){
        return caseFlag;
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

    /**
     * ��������VIN����
     * @param vINNo �����õ�����VIN�����ֵ
     */
    public void setVINNo(String vINNo){
        this.vINNo = StringUtils.rightTrim(vINNo);
    }

    /**
     * ��ȡ����VIN����
     * @return ����VIN�����ֵ
     */
    public String getVINNo(){
        return vINNo;
    }

    /**
     * �������Թ������
     * @param sumManageFeeRate �����õ����Թ�����ʵ�ֵ
     */
    public void setSumManageFeeRate(double sumManageFeeRate){
        this.sumManageFeeRate = sumManageFeeRate;
    }

    /**
     * ��ȡ���Թ������
     * @return ���Թ�����ʵ�ֵ
     */
    public double getSumManageFeeRate(){
        return sumManageFeeRate;
    }

    /**
     * �������Իؿ����
     * @param backCheckRemark �����õ����Իؿ������ֵ
     */
    public void setBackCheckRemark(String backCheckRemark){
        this.backCheckRemark = StringUtils.rightTrim(backCheckRemark);
    }

    /**
     * ��ȡ���Իؿ����
     * @return ���Իؿ������ֵ
     */
    public String getBackCheckRemark(){
        return backCheckRemark;
    }

    /**
     * ���������Ƿ���Ҫ�ؿ�
     * @param backCheckFlag �����õ������Ƿ���Ҫ�ؿ���ֵ
     */
    public void setBackCheckFlag(String backCheckFlag){
        this.backCheckFlag = StringUtils.rightTrim(backCheckFlag);
    }

    /**
     * ��ȡ�����Ƿ���Ҫ�ؿ�
     * @return �����Ƿ���Ҫ�ؿ���ֵ
     */
    public String getBackCheckFlag(){
        return backCheckFlag;
    }
    
    /**
     * �������Կɲ���/����ļ���
     * @param handlerRange �����õ����Կɲ���/����ļ����ֵ
     */
    public void setHandlerRange(String handlerRange){
        this.handlerRange = StringUtils.rightTrim(handlerRange);
    }

    /**
     * ��ȡ���Կɲ���/����ļ���
     * @return ���Կɲ���/����ļ����ֵ
     */
    public String getHandlerRange(){
        return handlerRange;
    }

    /**
     * ��������SumTransFee
     * @param sumTransFee �����õ�����SumTransFee��ֵ
     */
    public void setSumTransFee(double sumTransFee){
        this.sumTransFee = sumTransFee;
    }

    /**
     * ��ȡ����SumTransFee
     * @return ����SumTransFee��ֵ
     */
    public double getSumTransFee(){
        return sumTransFee;
    }

    /**
     * ��������SumTax
     * @param sumTax �����õ�����SumTax��ֵ
     */
    public void setSumTax(double sumTax){
        this.sumTax = sumTax;
    }

    /**
     * ��ȡ����SumTax
     * @return ����SumTax��ֵ
     */
    public double getSumTax(){
        return sumTax;
    }

}
