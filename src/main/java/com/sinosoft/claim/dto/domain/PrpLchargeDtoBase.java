package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLcharge����������Ϣ������ݴ���������<br>
 * ������ 2006-08-04 09:20:18.043<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLchargeDtoBase implements Serializable{
    /** ������������� */
    private String compensateNo = "";
    /** �������� */
    private String riskCode = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** �����ձ���� */
    private String kindCode = "";
    /** ���Է��������� */
    private String chargeCode = "";
    /** ���Է������� */
    private String chargeName = "";
    /** ���Աұ���� */
    private String currency = "";
    /** ���Է��ý�� */
    private double chargeAmount = 0d;
    /** ���Լ�������� */
    private double sumRealPay = 0d;
    /** �����ϱ������ֶ� */
    private double chargeReport = 0d;
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** ����¼��ʱ�� */
    private DateTime inputDate = new DateTime();
    /** ���Է�����Ϣ��־ */
    private String changeFlag = "";
    /** ����֧���������� */
    private String payObjectType = "";
    /** ����֧��������� */
    private String payObjectCode = "";
    /** ����֧���������� */
    private String payObjectName = "";
    /** ���Ա���������' */
    private int itemkindno = 0;
    /** ���Դ���������� */
    private String checkDeptCode = "";
    /** ���Դ���������� */
    private String checkDeptName = "";
    /** ����Ԥ�����ý�� */
    private double preChargeAmount = 0d;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLchargeDtoBase����
     */
    public PrpLchargeDtoBase(){
    }

    /**
     * �����������������
     * @param compensateNo �����õ�������������ŵ�ֵ
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * ��ȡ�������������
     * @return ������������ŵ�ֵ
     */
    public String getCompensateNo(){
        return compensateNo;
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
     * �������Է���������
     * @param chargeCode �����õ����Է����������ֵ
     */
    public void setChargeCode(String chargeCode){
        this.chargeCode = StringUtils.rightTrim(chargeCode);
    }

    /**
     * ��ȡ���Է���������
     * @return ���Է����������ֵ
     */
    public String getChargeCode(){
        return chargeCode;
    }

    /**
     * �������Է�������
     * @param chargeName �����õ����Է������Ƶ�ֵ
     */
    public void setChargeName(String chargeName){
        this.chargeName = StringUtils.rightTrim(chargeName);
    }

    /**
     * ��ȡ���Է�������
     * @return ���Է������Ƶ�ֵ
     */
    public String getChargeName(){
        return chargeName;
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
     * �������Է��ý��
     * @param chargeAmount �����õ����Է��ý���ֵ
     */
    public void setChargeAmount(double chargeAmount){
        this.chargeAmount = chargeAmount;
    }

    /**
     * ��ȡ���Է��ý��
     * @return ���Է��ý���ֵ
     */
    public double getChargeAmount(){
        return chargeAmount;
    }

    /**
     * �������Լ��������
     * @param sumRealPay �����õ����Լ���������ֵ
     */
    public void setSumRealPay(double sumRealPay){
        this.sumRealPay = sumRealPay;
    }

    /**
     * ��ȡ���Լ��������
     * @return ���Լ���������ֵ
     */
    public double getSumRealPay(){
        return sumRealPay;
    }

    /**
     * ���������ϱ������ֶ�
     * @param chargeReport �����õ������ϱ������ֶε�ֵ
     */
    public void setChargeReport(double chargeReport){
        this.chargeReport = chargeReport;
    }

    /**
     * ��ȡ�����ϱ������ֶ�
     * @return �����ϱ������ֶε�ֵ
     */
    public double getChargeReport(){
        return chargeReport;
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
     * ��������¼��ʱ��
     * @param inputDate �����õ�����¼��ʱ���ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ����¼��ʱ��
     * @return ����¼��ʱ���ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * �������Է�����Ϣ��־
     * @param changeFlag �����õ����Է�����Ϣ��־��ֵ
     */
    public void setChangeFlag(String changeFlag){
        this.changeFlag = StringUtils.rightTrim(changeFlag);
    }

    /**
     * ��ȡ���Է�����Ϣ��־
     * @return ���Է�����Ϣ��־��ֵ
     */
    public String getChangeFlag(){
        return changeFlag;
    }

    /**
     * ��������֧����������
     * @param payObjectType �����õ�����֧���������͵�ֵ
     */
    public void setPayObjectType(String payObjectType){
        this.payObjectType = StringUtils.rightTrim(payObjectType);
    }

    /**
     * ��ȡ����֧����������
     * @return ����֧���������͵�ֵ
     */
    public String getPayObjectType(){
        return payObjectType;
    }

    /**
     * ��������֧���������
     * @param payObjectCode �����õ�����֧����������ֵ
     */
    public void setPayObjectCode(String payObjectCode){
        this.payObjectCode = StringUtils.rightTrim(payObjectCode);
    }

    /**
     * ��ȡ����֧���������
     * @return ����֧����������ֵ
     */
    public String getPayObjectCode(){
        return payObjectCode;
    }

    /**
     * ��������֧����������
     * @param payObjectName �����õ�����֧���������Ƶ�ֵ
     */
    public void setPayObjectName(String payObjectName){
        this.payObjectName = StringUtils.rightTrim(payObjectName);
    }

    /**
     * ��ȡ����֧����������
     * @return ����֧���������Ƶ�ֵ
     */
    public String getPayObjectName(){
        return payObjectName;
    }

	public int getItemkindno() {
		return itemkindno;
	}

	public void setItemkindno(int itemkindno) {
		this.itemkindno = itemkindno;
	}

	public String getCheckDeptCode() {
		return checkDeptCode;
	}

	public void setCheckDeptCode(String checkDeptCode) {
		this.checkDeptCode = checkDeptCode;
	}

	public String getCheckDeptName() {
		return checkDeptName;
	}

	public void setCheckDeptName(String checkDeptName) {
		this.checkDeptName = checkDeptName;
	}
    
    public double getPreChargeAmount() {
		return preChargeAmount;
	}

	public void setPreChargeAmount(double preChargeAmount) {
		this.preChargeAmount = preChargeAmount;
	}
}
