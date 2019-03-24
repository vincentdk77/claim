package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpjprofit�Żݼ�¼������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJprofitDtoBase implements Serializable{
    /** ���Ա��յ��Ŵ� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���������Ŵ� */
    private String endorseNo = "";
    /** �����Ż���� */
    private int profitNo = 0;
    /** ���Ա���ձ���� */
    private int itemKindNo = 0;
    /** �����ձ���� */
    private String kindCode = "";
    /** ���Ա�������� */
    private String itemCode = "";
    /** ���Ա����ϸ���� */
    private String itemDetailName = "";
    /** �����Ż�ԭ�� */
    private String profitReasonCode = "";
    /** ���Ա������� */
    private double sumPremium = 0d;
    /** �����Ż��� */
    private double profitRate = 0d;
    /** ���Աұ� */
    private String currency = "";
    /** �����Żݽ�� */
    private double totalProfit = 0d;
    /** ���԰�ȫ��������ʽ */
    private String safeBountyFlag = "";
    /** �����Ƿ������� */
    private String minusFlag = "";
    /** ���Ծ����˴��� */
    private String handlerCode = "";
    /** ���Ը����˴��� */
    private String approverCode = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ���Լ�����䵥���� */
    private DateTime inputDate = new DateTime();
    /** ���Ը��ѱ�־ */
    private String refundFlag = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpJprofitDtoBase����
     */
    public PrpJprofitDtoBase(){
    }

    /**
     * �������Ա��յ��Ŵ�
     * @param policyNo �����õ����Ա��յ��Ŵε�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա��յ��Ŵ�
     * @return ���Ա��յ��Ŵε�ֵ
     */
    public String getPolicyNo(){
        return policyNo;
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
     * �������������Ŵ�
     * @param endorseNo �����õ����������Ŵε�ֵ
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * ��ȡ���������Ŵ�
     * @return ���������Ŵε�ֵ
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * ���������Ż����
     * @param profitNo �����õ������Ż���ŵ�ֵ
     */
    public void setProfitNo(int profitNo){
        this.profitNo = profitNo;
    }

    /**
     * ��ȡ�����Ż����
     * @return �����Ż���ŵ�ֵ
     */
    public int getProfitNo(){
        return profitNo;
    }

    /**
     * �������Ա���ձ����
     * @param itemKindNo �����õ����Ա���ձ���ŵ�ֵ
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * ��ȡ���Ա���ձ����
     * @return ���Ա���ձ���ŵ�ֵ
     */
    public int getItemKindNo(){
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
     * �������Ա��������
     * @param itemCode �����õ����Ա���������ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ���Ա��������
     * @return ���Ա���������ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * �������Ա����ϸ����
     * @param itemDetailName �����õ����Ա����ϸ���Ƶ�ֵ
     */
    public void setItemDetailName(String itemDetailName){
        this.itemDetailName = StringUtils.rightTrim(itemDetailName);
    }

    /**
     * ��ȡ���Ա����ϸ����
     * @return ���Ա����ϸ���Ƶ�ֵ
     */
    public String getItemDetailName(){
        return itemDetailName;
    }

    /**
     * ���������Ż�ԭ��
     * @param profitReasonCode �����õ������Ż�ԭ���ֵ
     */
    public void setProfitReasonCode(String profitReasonCode){
        this.profitReasonCode = StringUtils.rightTrim(profitReasonCode);
    }

    /**
     * ��ȡ�����Ż�ԭ��
     * @return �����Ż�ԭ���ֵ
     */
    public String getProfitReasonCode(){
        return profitReasonCode;
    }

    /**
     * �������Ա�������
     * @param sumPremium �����õ����Ա������ѵ�ֵ
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա������ѵ�ֵ
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * ���������Ż���
     * @param profitRate �����õ������Ż��ʵ�ֵ
     */
    public void setProfitRate(double profitRate){
        this.profitRate = profitRate;
    }

    /**
     * ��ȡ�����Ż���
     * @return �����Ż��ʵ�ֵ
     */
    public double getProfitRate(){
        return profitRate;
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
     * ���������Żݽ��
     * @param totalProfit �����õ������Żݽ���ֵ
     */
    public void setTotalProfit(double totalProfit){
        this.totalProfit = totalProfit;
    }

    /**
     * ��ȡ�����Żݽ��
     * @return �����Żݽ���ֵ
     */
    public double getTotalProfit(){
        return totalProfit;
    }

    /**
     * �������԰�ȫ��������ʽ
     * @param safeBountyFlag �����õ����԰�ȫ��������ʽ��ֵ
     */
    public void setSafeBountyFlag(String safeBountyFlag){
        this.safeBountyFlag = StringUtils.rightTrim(safeBountyFlag);
    }

    /**
     * ��ȡ���԰�ȫ��������ʽ
     * @return ���԰�ȫ��������ʽ��ֵ
     */
    public String getSafeBountyFlag(){
        return safeBountyFlag;
    }

    /**
     * ���������Ƿ�������
     * @param minusFlag �����õ������Ƿ������ѵ�ֵ
     */
    public void setMinusFlag(String minusFlag){
        this.minusFlag = StringUtils.rightTrim(minusFlag);
    }

    /**
     * ��ȡ�����Ƿ�������
     * @return �����Ƿ������ѵ�ֵ
     */
    public String getMinusFlag(){
        return minusFlag;
    }

    /**
     * �������Ծ����˴���
     * @param handlerCode �����õ����Ծ����˴����ֵ
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * ��ȡ���Ծ����˴���
     * @return ���Ծ����˴����ֵ
     */
    public String getHandlerCode(){
        return handlerCode;
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
     * �������Լ�����䵥����
     * @param inputDate �����õ����Լ�����䵥���ڵ�ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ���Լ�����䵥����
     * @return ���Լ�����䵥���ڵ�ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * �������Ը��ѱ�־
     * @param refundFlag �����õ����Ը��ѱ�־��ֵ
     */
    public void setRefundFlag(String refundFlag){
        this.refundFlag = StringUtils.rightTrim(refundFlag);
    }

    /**
     * ��ȡ���Ը��ѱ�־
     * @return ���Ը��ѱ�־��ֵ
     */
    public String getRefundFlag(){
        return refundFlag;
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
