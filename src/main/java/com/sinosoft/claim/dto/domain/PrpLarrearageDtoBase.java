package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLarrearage-���Ƿ���嵥������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLarrearageDtoBase implements Serializable{
    /** �������� */
    private String riskCode = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** �������������� */
    private String automobileDealer = "";
    /** ���Դ����� */
    private double sumLoan = 0d;
    /** ���Խ��ʱ�� */
    private DateTime loanStartDate = new DateTime();
    /** ���Խ������ */
    private String loanTerm = "";
    /** �����ѻ������� */
    private int sumRepaidTimes = 0;
    /** �����ѻ����� */
    private double sumRePaid = 0d;
    /** ���Դ������ */
    private double sumNoRePaid = 0d;
    /** ����Ƿ��� */
    private double arrearageCorpus = 0d;
    /** ��������ʱ�� */
    private DateTime arrearageDate = new DateTime();
    /** �������һ�λ������� */
    private DateTime lastRepaidDate = new DateTime();
    /** ���Ա���Ӧ�����ֹ���� */
    private DateTime arrearageEndDate = new DateTime();
    /** ��������Ƿ������ */
    private int arrearageTimes = 0;
    /** ��������Ƿ���� */
    private double sumArrearage = 0d;
    /** ��������Ƿ��ԭ�� */
    private String arrearageReason = "";
    /** ���Ե�Ѻ��/��Ѻ�� */
    private String guaranteeName = "";
    /** ���Ա�֤�� */
    private String cautioner = "";
    /** ���Ա�֤�� */
    private double cautionMoney = 0d;
    /** ���Դ��մ�ʩ */
    private String dunStep = "";
    /** ���Ա��浥λ��� */
    private String reportUnitProposal = "";
    /** ���Ծ����� */
    private String handlerCode = "";
    /** ���Ծ��� */
    private String manager = "";
    /** ���Ե�¼ʱ�� */
    private DateTime inputDate = new DateTime();
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLarrearageDtoBase����
     */
    public PrpLarrearageDtoBase(){
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
     * ������������������
     * @param automobileDealer �����õ��������������̵�ֵ
     */
    public void setAutomobileDealer(String automobileDealer){
        this.automobileDealer = StringUtils.rightTrim(automobileDealer);
    }

    /**
     * ��ȡ��������������
     * @return �������������̵�ֵ
     */
    public String getAutomobileDealer(){
        return automobileDealer;
    }

    /**
     * �������Դ�����
     * @param sumLoan �����õ����Դ������ֵ
     */
    public void setSumLoan(double sumLoan){
        this.sumLoan = sumLoan;
    }

    /**
     * ��ȡ���Դ�����
     * @return ���Դ������ֵ
     */
    public double getSumLoan(){
        return sumLoan;
    }

    /**
     * �������Խ��ʱ��
     * @param loanStartDate �����õ����Խ��ʱ���ֵ
     */
    public void setLoanStartDate(DateTime loanStartDate){
        this.loanStartDate = loanStartDate;
    }

    /**
     * ��ȡ���Խ��ʱ��
     * @return ���Խ��ʱ���ֵ
     */
    public DateTime getLoanStartDate(){
        return loanStartDate;
    }

    /**
     * �������Խ������
     * @param loanTerm �����õ����Խ�����޵�ֵ
     */
    public void setLoanTerm(String loanTerm){
        this.loanTerm = StringUtils.rightTrim(loanTerm);
    }

    /**
     * ��ȡ���Խ������
     * @return ���Խ�����޵�ֵ
     */
    public String getLoanTerm(){
        return loanTerm;
    }

    /**
     * ���������ѻ�������
     * @param sumRepaidTimes �����õ������ѻ���������ֵ
     */
    public void setSumRepaidTimes(int sumRepaidTimes){
        this.sumRepaidTimes = sumRepaidTimes;
    }

    /**
     * ��ȡ�����ѻ�������
     * @return �����ѻ���������ֵ
     */
    public int getSumRepaidTimes(){
        return sumRepaidTimes;
    }

    /**
     * ���������ѻ�����
     * @param sumRePaid �����õ������ѻ������ֵ
     */
    public void setSumRePaid(double sumRePaid){
        this.sumRePaid = sumRePaid;
    }

    /**
     * ��ȡ�����ѻ�����
     * @return �����ѻ������ֵ
     */
    public double getSumRePaid(){
        return sumRePaid;
    }

    /**
     * �������Դ������
     * @param sumNoRePaid �����õ����Դ�������ֵ
     */
    public void setSumNoRePaid(double sumNoRePaid){
        this.sumNoRePaid = sumNoRePaid;
    }

    /**
     * ��ȡ���Դ������
     * @return ���Դ�������ֵ
     */
    public double getSumNoRePaid(){
        return sumNoRePaid;
    }

    /**
     * ��������Ƿ���
     * @param arrearageCorpus �����õ�����Ƿ����ֵ
     */
    public void setArrearageCorpus(double arrearageCorpus){
        this.arrearageCorpus = arrearageCorpus;
    }

    /**
     * ��ȡ����Ƿ���
     * @return ����Ƿ����ֵ
     */
    public double getArrearageCorpus(){
        return arrearageCorpus;
    }

    /**
     * ������������ʱ��
     * @param arrearageDate �����õ���������ʱ���ֵ
     */
    public void setArrearageDate(DateTime arrearageDate){
        this.arrearageDate = arrearageDate;
    }

    /**
     * ��ȡ��������ʱ��
     * @return ��������ʱ���ֵ
     */
    public DateTime getArrearageDate(){
        return arrearageDate;
    }

    /**
     * �����������һ�λ�������
     * @param lastRepaidDate �����õ��������һ�λ������ڵ�ֵ
     */
    public void setLastRepaidDate(DateTime lastRepaidDate){
        this.lastRepaidDate = lastRepaidDate;
    }

    /**
     * ��ȡ�������һ�λ�������
     * @return �������һ�λ������ڵ�ֵ
     */
    public DateTime getLastRepaidDate(){
        return lastRepaidDate;
    }

    /**
     * �������Ա���Ӧ�����ֹ����
     * @param arrearageEndDate �����õ����Ա���Ӧ�����ֹ���ڵ�ֵ
     */
    public void setArrearageEndDate(DateTime arrearageEndDate){
        this.arrearageEndDate = arrearageEndDate;
    }

    /**
     * ��ȡ���Ա���Ӧ�����ֹ����
     * @return ���Ա���Ӧ�����ֹ���ڵ�ֵ
     */
    public DateTime getArrearageEndDate(){
        return arrearageEndDate;
    }

    /**
     * ������������Ƿ������
     * @param arrearageTimes �����õ���������Ƿ��������ֵ
     */
    public void setArrearageTimes(int arrearageTimes){
        this.arrearageTimes = arrearageTimes;
    }

    /**
     * ��ȡ��������Ƿ������
     * @return ��������Ƿ��������ֵ
     */
    public int getArrearageTimes(){
        return arrearageTimes;
    }

    /**
     * ������������Ƿ����
     * @param sumArrearage �����õ���������Ƿ�����ֵ
     */
    public void setSumArrearage(double sumArrearage){
        this.sumArrearage = sumArrearage;
    }

    /**
     * ��ȡ��������Ƿ����
     * @return ��������Ƿ�����ֵ
     */
    public double getSumArrearage(){
        return sumArrearage;
    }

    /**
     * ������������Ƿ��ԭ��
     * @param arrearageReason �����õ���������Ƿ��ԭ���ֵ
     */
    public void setArrearageReason(String arrearageReason){
        this.arrearageReason = StringUtils.rightTrim(arrearageReason);
    }

    /**
     * ��ȡ��������Ƿ��ԭ��
     * @return ��������Ƿ��ԭ���ֵ
     */
    public String getArrearageReason(){
        return arrearageReason;
    }

    /**
     * �������Ե�Ѻ��/��Ѻ��
     * @param guaranteeName �����õ����Ե�Ѻ��/��Ѻ���ֵ
     */
    public void setGuaranteeName(String guaranteeName){
        this.guaranteeName = StringUtils.rightTrim(guaranteeName);
    }

    /**
     * ��ȡ���Ե�Ѻ��/��Ѻ��
     * @return ���Ե�Ѻ��/��Ѻ���ֵ
     */
    public String getGuaranteeName(){
        return guaranteeName;
    }

    /**
     * �������Ա�֤��
     * @param cautioner �����õ����Ա�֤�˵�ֵ
     */
    public void setCautioner(String cautioner){
        this.cautioner = StringUtils.rightTrim(cautioner);
    }

    /**
     * ��ȡ���Ա�֤��
     * @return ���Ա�֤�˵�ֵ
     */
    public String getCautioner(){
        return cautioner;
    }

    /**
     * �������Ա�֤��
     * @param cautionMoney �����õ����Ա�֤���ֵ
     */
    public void setCautionMoney(double cautionMoney){
        this.cautionMoney = cautionMoney;
    }

    /**
     * ��ȡ���Ա�֤��
     * @return ���Ա�֤���ֵ
     */
    public double getCautionMoney(){
        return cautionMoney;
    }

    /**
     * �������Դ��մ�ʩ
     * @param dunStep �����õ����Դ��մ�ʩ��ֵ
     */
    public void setDunStep(String dunStep){
        this.dunStep = StringUtils.rightTrim(dunStep);
    }

    /**
     * ��ȡ���Դ��մ�ʩ
     * @return ���Դ��մ�ʩ��ֵ
     */
    public String getDunStep(){
        return dunStep;
    }

    /**
     * �������Ա��浥λ���
     * @param reportUnitProposal �����õ����Ա��浥λ�����ֵ
     */
    public void setReportUnitProposal(String reportUnitProposal){
        this.reportUnitProposal = StringUtils.rightTrim(reportUnitProposal);
    }

    /**
     * ��ȡ���Ա��浥λ���
     * @return ���Ա��浥λ�����ֵ
     */
    public String getReportUnitProposal(){
        return reportUnitProposal;
    }

    /**
     * �������Ծ�����
     * @param handlerCode �����õ����Ծ����˵�ֵ
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * ��ȡ���Ծ�����
     * @return ���Ծ����˵�ֵ
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * �������Ծ���
     * @param manager �����õ����Ծ����ֵ
     */
    public void setManager(String manager){
        this.manager = StringUtils.rightTrim(manager);
    }

    /**
     * ��ȡ���Ծ���
     * @return ���Ծ����ֵ
     */
    public String getManager(){
        return manager;
    }

    /**
     * �������Ե�¼ʱ��
     * @param inputDate �����õ����Ե�¼ʱ���ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ���Ե�¼ʱ��
     * @return ���Ե�¼ʱ���ֵ
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
