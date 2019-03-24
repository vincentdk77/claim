package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLcetainLoss�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.890<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcetainLossDtoBase implements Serializable{
    /** �����ⰸ�� */
    private String claimNo = "";
    /** �������� */
    private String riskCode = "";
    /** ���Ա����� */
    private String registNo = "";
    /** ���Ա����� */
    private int itemNo = 0;
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Կ�ʼʱ�� */
    private DateTime startDate = new DateTime();
    /** ���Կ�ʼСʱ */
    private String startHour = "";
    /** ���Խ���ʱ�� */
    private DateTime endDate = new DateTime();
    /** ���Խ���Сʱ */
    private String endHour = "";
    /** ���Աұ� */
    private String currency = "";
    /** �����޳����/��ֵ/���� */
    private double sumRest = 0d;
    /** ���Թ���� */
    private double sumManager = 0d;
    /** �����ܶ����� */
    private double sumCertainLoss = 0d;
    /** �����ܺ����� */
    private double sumVerifyLoss = 0d;
    /** ������ʧ��λ���̶ȸ��� */
    private String lossDesc = "";
    /** �����⳥���δ����
--**��׼������ */
    private String indemnityDuty = "";
    /** �������α��� */
    private double indemnityDutyRate = 0d;
    /** ���Ա�ע */
    private String remark = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ���Ը����˴��� */
    private String approverCode = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcetainLossDtoBase����
     */
    public PrpLcetainLossDtoBase(){
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
     * @param itemNo �����õ����Ա����ŵ�ֵ
     */
    public void setItemNo(int itemNo){
        this.itemNo = itemNo;
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public int getItemNo(){
        return itemNo;
    }

    /**
     * �������Գ��ƺ���
     * @param licenseNo �����õ����Գ��ƺ����ֵ
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ���Գ��ƺ���
     * @return ���Գ��ƺ����ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
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
     * �������Կ�ʼʱ��
     * @param startDate �����õ����Կ�ʼʱ���ֵ
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * ��ȡ���Կ�ʼʱ��
     * @return ���Կ�ʼʱ���ֵ
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * �������Կ�ʼСʱ
     * @param startHour �����õ����Կ�ʼСʱ��ֵ
     */
    public void setStartHour(String startHour){
        this.startHour = StringUtils.rightTrim(startHour);
    }

    /**
     * ��ȡ���Կ�ʼСʱ
     * @return ���Կ�ʼСʱ��ֵ
     */
    public String getStartHour(){
        return startHour;
    }

    /**
     * �������Խ���ʱ��
     * @param endDate �����õ����Խ���ʱ���ֵ
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * ��ȡ���Խ���ʱ��
     * @return ���Խ���ʱ���ֵ
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * �������Խ���Сʱ
     * @param endHour �����õ����Խ���Сʱ��ֵ
     */
    public void setEndHour(String endHour){
        this.endHour = StringUtils.rightTrim(endHour);
    }

    /**
     * ��ȡ���Խ���Сʱ
     * @return ���Խ���Сʱ��ֵ
     */
    public String getEndHour(){
        return endHour;
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
     * ���������⳥���δ����
--**��׼������
     * @param indemnityDuty �����õ������⳥���δ����
--**��׼�������ֵ
     */
    public void setIndemnityDuty(String indemnityDuty){
        this.indemnityDuty = StringUtils.rightTrim(indemnityDuty);
    }

    /**
     * ��ȡ�����⳥���δ����
--**��׼������
     * @return �����⳥���δ����
--**��׼�������ֵ
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
