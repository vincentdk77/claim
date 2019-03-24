package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prppprofit�Ż���Ϣ������ݴ���������<br>
 * ������ 2004-11-22 15:24:14.218<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPprofitDtoBase implements Serializable{
    /** ���������� */
    private String endorseNo = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** �����Ż��ۿ����� */
    private String profitType = "";
    /** ���Ա���ձ���� */
    private int itemkindNo = 0;
    /** �����ձ���� */
    private String kindCode = "";
    /** ���Աұ� */
    private String currency = "";
    /** �������Ż�(�ۿ�)��(%) */
    private double discount = 0d;
    /** �����Żݣ��ۿۣ���� */
    private double totalProfit = 0d;
    /** �����Ƿ������� */
    private String minusFlag = "";
    /** ���Ծ����˴��� */
    private String handlerCode = "";
    /** ���Ը����˴��� */
    private String approverCode = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ������������ */
    private DateTime inputDate = new DateTime();
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpPprofitDtoBase����
     */
    public PrpPprofitDtoBase(){
    }

    /**
     * ��������������
     * @param endorseNo �����õ����������ŵ�ֵ
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * ��ȡ����������
     * @return ���������ŵ�ֵ
     */
    public String getEndorseNo(){
        return endorseNo;
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
     * ���������Ż��ۿ�����
     * @param profitType �����õ������Ż��ۿ����͵�ֵ
     */
    public void setProfitType(String profitType){
        this.profitType = StringUtils.rightTrim(profitType);
    }

    /**
     * ��ȡ�����Ż��ۿ�����
     * @return �����Ż��ۿ����͵�ֵ
     */
    public String getProfitType(){
        return profitType;
    }

    /**
     * �������Ա���ձ����
     * @param itemkindNo �����õ����Ա���ձ���ŵ�ֵ
     */
    public void setItemkindNo(int itemkindNo){
        this.itemkindNo = itemkindNo;
    }

    /**
     * ��ȡ���Ա���ձ����
     * @return ���Ա���ձ���ŵ�ֵ
     */
    public int getItemkindNo(){
        return itemkindNo;
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
     * �����������Ż�(�ۿ�)��(%)
     * @param discount �����õ��������Ż�(�ۿ�)��(%)��ֵ
     */
    public void setDiscount(double discount){
        this.discount = discount;
    }

    /**
     * ��ȡ�������Ż�(�ۿ�)��(%)
     * @return �������Ż�(�ۿ�)��(%)��ֵ
     */
    public double getDiscount(){
        return discount;
    }

    /**
     * ���������Żݣ��ۿۣ����
     * @param totalProfit �����õ������Żݣ��ۿۣ�����ֵ
     */
    public void setTotalProfit(double totalProfit){
        this.totalProfit = totalProfit;
    }

    /**
     * ��ȡ�����Żݣ��ۿۣ����
     * @return �����Żݣ��ۿۣ�����ֵ
     */
    public double getTotalProfit(){
        return totalProfit;
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
     * ����������������
     * @param inputDate �����õ������������ڵ�ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * �������Ա�־
     * @param flag �����õ����Ա�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־
     * @return ���Ա�־��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
