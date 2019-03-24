package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLFISCALPAYDETAIL�����ݴ���������<br>
 */
public class PrplfiscalpaydetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ���Բ������ļ��嵥�� */
    private String fiscalno = "";
    /** ������� */
    private String serialno = "";
    /** ���Ա����� */
    private String registno = "";
    /** �������� */
    private String classcode = "";
    /** �������� */
    private String riskcode = "";
    /** ���Ա����� */
    private String policyno = "";
    /** ���������� */
    private String claimno = "";
    /** ���Լ������ */
    private String compensateno = "";
    /** �����ո�ԭ�� */
    private String paymenttype = "";
    /** ����֧������ */
    private String paytype = "";
    /** ������������� */
    private String receiverfullname = "";
    /** �������֤�� */
    private String identifynumber = "";
    /** ����ũ������ */
    private String insuredcode = "";
    /** ���Լ������ܽ�� */
    private double sumamount = 0D;
    /** ���Ա���֧����� */
    private double payamount = 0D;
    /** �������д��� */
    private String banktype = "";
    /** ���Կ���֧�� */
    private String bank = "";
    /** �����˺����� */
    private String accounttype = "";
    /** �����ֻ����� */
    private String mobilephone = "";
    /** ����֧��˵�� */
    private String payremark = "";
    /** ���������˺� */
    private String bankaccount = "";
    /** ����VFLAG */
    private String vflag = "";
    /** ����ʡ */
    private String provincename = "";
    /** ������ */
    private String cityname = "";
    /** �����˺����� */
    private String accountflag = "";
    /** ����֧���к� */
    private String routenum = "";
    /** ����*/
    private String comcode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplfiscalpaydetailDtoBase����
     */
    public PrplfiscalpaydetailDtoBase(){
    }

    /**
     * �������Բ������ļ��嵥��
     * @param fiscalno �����õ����Բ������ļ��嵥�ŵ�ֵ
     */
    public void setFiscalno(String fiscalno){
        this.fiscalno = StringUtils.rightTrim(fiscalno);
    }

    /**
     * ��ȡ���Բ������ļ��嵥��
     * @return ���Բ������ļ��嵥�ŵ�ֵ
     */
    public String getFiscalno(){
        return fiscalno;
    }

    /**
     * �����������
     * @param serialno �����õ�������ŵ�ֵ
     */
    public void setSerialno(String serialno){
        this.serialno = StringUtils.rightTrim(serialno);
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public String getSerialno(){
        return serialno;
    }

    /**
     * �������Ա�����
     * @param registno �����õ����Ա����ŵ�ֵ
     */
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getRegistno(){
        return registno;
    }

    /**
     * ������������
     * @param classcode �����õ����������ֵ
     */
    public void setClasscode(String classcode){
        this.classcode = StringUtils.rightTrim(classcode);
    }

    /**
     * ��ȡ��������
     * @return ���������ֵ
     */
    public String getClasscode(){
        return classcode;
    }

    /**
     * ������������
     * @param riskcode �����õ��������ֵ�ֵ
     */
    public void setRiskcode(String riskcode){
        this.riskcode = StringUtils.rightTrim(riskcode);
    }

    /**
     * ��ȡ��������
     * @return �������ֵ�ֵ
     */
    public String getRiskcode(){
        return riskcode;
    }

    /**
     * �������Ա�����
     * @param policyno �����õ����Ա����ŵ�ֵ
     */
    public void setPolicyno(String policyno){
        this.policyno = StringUtils.rightTrim(policyno);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getPolicyno(){
        return policyno;
    }

    /**
     * ��������������
     * @param claimno �����õ����������ŵ�ֵ
     */
    public void setClaimno(String claimno){
        this.claimno = StringUtils.rightTrim(claimno);
    }

    /**
     * ��ȡ����������
     * @return ���������ŵ�ֵ
     */
    public String getClaimno(){
        return claimno;
    }

    /**
     * �������Լ������
     * @param compensateno �����õ����Լ�����ŵ�ֵ
     */
    public void setCompensateno(String compensateno){
        this.compensateno = StringUtils.rightTrim(compensateno);
    }

    /**
     * ��ȡ���Լ������
     * @return ���Լ�����ŵ�ֵ
     */
    public String getCompensateno(){
        return compensateno;
    }

    /**
     * ���������ո�ԭ��
     * @param paymenttype �����õ������ո�ԭ���ֵ
     */
    public void setPaymenttype(String paymenttype){
        this.paymenttype = StringUtils.rightTrim(paymenttype);
    }

    /**
     * ��ȡ�����ո�ԭ��
     * @return �����ո�ԭ���ֵ
     */
    public String getPaymenttype(){
        return paymenttype;
    }

    /**
     * ��������֧������
     * @param paytype �����õ�����֧�����͵�ֵ
     */
    public void setPaytype(String paytype){
        this.paytype = StringUtils.rightTrim(paytype);
    }

    /**
     * ��ȡ����֧������
     * @return ����֧�����͵�ֵ
     */
    public String getPaytype(){
        return paytype;
    }

    /**
     * �����������������
     * @param receiverfullname �����õ�������������Ƶ�ֵ
     */
    public void setReceiverfullname(String receiverfullname){
        this.receiverfullname = StringUtils.rightTrim(receiverfullname);
    }

    /**
     * ��ȡ�������������
     * @return ������������Ƶ�ֵ
     */
    public String getReceiverfullname(){
        return receiverfullname;
    }

    /**
     * �����������֤��
     * @param identifynumber �����õ��������֤�ŵ�ֵ
     */
    public void setIdentifynumber(String identifynumber){
        this.identifynumber = StringUtils.rightTrim(identifynumber);
    }

    /**
     * ��ȡ�������֤��
     * @return �������֤�ŵ�ֵ
     */
    public String getIdentifynumber(){
        return identifynumber;
    }

    /**
     * ��������ũ������
     * @param insuredcode �����õ�����ũ�������ֵ
     */
    public void setInsuredcode(String insuredcode){
        this.insuredcode = StringUtils.rightTrim(insuredcode);
    }

    /**
     * ��ȡ����ũ������
     * @return ����ũ�������ֵ
     */
    public String getInsuredcode(){
        return insuredcode;
    }

    /**
     * �������Լ������ܽ��
     * @param sumamount �����õ����Լ������ܽ���ֵ
     */
    public void setSumamount(double sumamount){
        this.sumamount = sumamount;
    }

    /**
     * ��ȡ���Լ������ܽ��
     * @return ���Լ������ܽ���ֵ
     */
    public double getSumamount(){
        return sumamount;
    }

    /**
     * �������Ա���֧�����
     * @param payamount �����õ����Ա���֧������ֵ
     */
    public void setPayamount(double payamount){
        this.payamount = payamount;
    }

    /**
     * ��ȡ���Ա���֧�����
     * @return ���Ա���֧������ֵ
     */
    public double getPayamount(){
        return payamount;
    }

    /**
     * �����������д���
     * @param banktype �����õ��������д����ֵ
     */
    public void setBanktype(String banktype){
        this.banktype = StringUtils.rightTrim(banktype);
    }

    /**
     * ��ȡ�������д���
     * @return �������д����ֵ
     */
    public String getBanktype(){
        return banktype;
    }

    /**
     * �������Կ���֧��
     * @param bank �����õ����Կ���֧�е�ֵ
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * ��ȡ���Կ���֧��
     * @return ���Կ���֧�е�ֵ
     */
    public String getBank(){
        return bank;
    }

    /**
     * ���������˺�����
     * @param accounttype �����õ������˺����Ե�ֵ
     */
    public void setAccounttype(String accounttype){
        this.accounttype = StringUtils.rightTrim(accounttype);
    }

    /**
     * ��ȡ�����˺�����
     * @return �����˺����Ե�ֵ
     */
    public String getAccounttype(){
        return accounttype;
    }

    /**
     * ���������ֻ�����
     * @param mobilephone �����õ������ֻ������ֵ
     */
    public void setMobilephone(String mobilephone){
        this.mobilephone = StringUtils.rightTrim(mobilephone);
    }

    /**
     * ��ȡ�����ֻ�����
     * @return �����ֻ������ֵ
     */
    public String getMobilephone(){
        return mobilephone;
    }

    /**
     * ��������֧��˵��
     * @param payremark �����õ�����֧��˵����ֵ
     */
    public void setPayremark(String payremark){
        this.payremark = StringUtils.rightTrim(payremark);
    }

    /**
     * ��ȡ����֧��˵��
     * @return ����֧��˵����ֵ
     */
    public String getPayremark(){
        return payremark;
    }

    /**
     * �������������˺�
     * @param bankaccount �����õ����������˺ŵ�ֵ
     */
    public void setBankaccount(String bankaccount){
        this.bankaccount = StringUtils.rightTrim(bankaccount);
    }

    /**
     * ��ȡ���������˺�
     * @return ���������˺ŵ�ֵ
     */
    public String getBankaccount(){
        return bankaccount;
    }

    /**
     * ��������VFLAG
     * @param vflag �����õ�����VFLAG��ֵ
     */
    public void setVflag(String vflag){
        this.vflag = StringUtils.rightTrim(vflag);
    }

    /**
     * ��ȡ����VFLAG
     * @return ����VFLAG��ֵ
     */
    public String getVflag(){
        return vflag;
    }

    /**
     * ��������ʡ
     * @param provincename �����õ�����ʡ��ֵ
     */
    public void setProvincename(String provincename){
        this.provincename = StringUtils.rightTrim(provincename);
    }

    /**
     * ��ȡ����ʡ
     * @return ����ʡ��ֵ
     */
    public String getProvincename(){
        return provincename;
    }

    /**
     * ����������
     * @param cityname �����õ������е�ֵ
     */
    public void setCityname(String cityname){
        this.cityname = StringUtils.rightTrim(cityname);
    }

    /**
     * ��ȡ������
     * @return �����е�ֵ
     */
    public String getCityname(){
        return cityname;
    }

    /**
     * ���������˺�����
     * @param accountflag �����õ������˺����͵�ֵ
     */
    public void setAccountflag(String accountflag){
        this.accountflag = StringUtils.rightTrim(accountflag);
    }

    /**
     * ��ȡ�����˺�����
     * @return �����˺����͵�ֵ
     */
    public String getAccountflag(){
        return accountflag;
    }

    /**
     * ��������֧���к�
     * @param routenum �����õ�����֧���кŵ�ֵ
     */
    public void setRoutenum(String routenum){
        this.routenum = StringUtils.rightTrim(routenum);
    }

    /**
     * ��ȡ����֧���к�
     * @return ����֧���кŵ�ֵ
     */
    public String getRoutenum(){
        return routenum;
    }

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
    
}
