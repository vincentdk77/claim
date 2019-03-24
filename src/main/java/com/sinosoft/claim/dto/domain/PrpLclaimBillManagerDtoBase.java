package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLclaimBillManager�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLclaimBillManagerDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����registNo */
    private String registNo = "";
    /** ����policyNo */
    private String policyNo = "";
    /** ����compensateNo */
    private String compensateNo = "";
    /** ����serialNo */
    private int serialNo = 0;
    /** ����payName */
    private String payName = "";
    /** ����identifyNumber */
    private String identifyNumber = "";
    /** ����insuredCode */
    private String insuredCode = "";
    /** ����provinceName */
    private String provinceName = "";
    /** ����cityName */
    private String cityName = "";
    /** ����accountType */
    private String accountType = "";
    /** ����bankName */
    private String bankName = "";
    /** ����openBank */
    private String openBank = "";
    /** ����bankAccount */
    private String bankAccount = "";
    /** ����sumPaid */
    private double sumPaid = 0D;
    /** ����payAmount */
    private double payAmount = 0D;
    /** ����payFlag */
    private String payFlag = "";
    /** ����mobilePhone */
    private String mobilePhone = "";
    /** ����address */
    private String address = "";
    /** ����accountFlag */
    private String accountFlag = "";
    /** ����flag */
    private String flag = "";
    /** ����operatorCode */
    private String operatorCode = "";
    /** ����routeNum */
    private String routeNum = "";
    /** ����realPayWay */
    private String realPayWay = "";
    private String Exist = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLclaimBillManagerDtoBase����
     */
    public PrpLclaimBillManagerDtoBase(){
    }

    /**
     * ��������registNo
     * @param registNo �����õ�����registNo��ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ����registNo
     * @return ����registNo��ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ��������policyNo
     * @param policyNo �����õ�����policyNo��ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����policyNo
     * @return ����policyNo��ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ��������compensateNo
     * @param compensateNo �����õ�����compensateNo��ֵ
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * ��ȡ����compensateNo
     * @return ����compensateNo��ֵ
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * ��������serialNo
     * @param serialNo �����õ�����serialNo��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����serialNo
     * @return ����serialNo��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ��������payName
     * @param payName �����õ�����payName��ֵ
     */
    public void setPayName(String payName){
        this.payName = StringUtils.rightTrim(payName);
    }

    /**
     * ��ȡ����payName
     * @return ����payName��ֵ
     */
    public String getPayName(){
        return payName;
    }

    /**
     * ��������identifyNumber
     * @param identifyNumber �����õ�����identifyNumber��ֵ
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * ��ȡ����identifyNumber
     * @return ����identifyNumber��ֵ
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * ��������insuredCode
     * @param insuredCode �����õ�����insuredCode��ֵ
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * ��ȡ����insuredCode
     * @return ����insuredCode��ֵ
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * ��������provinceName
     * @param provinceName �����õ�����provinceName��ֵ
     */
    public void setProvinceName(String provinceName){
        this.provinceName = StringUtils.rightTrim(provinceName);
    }

    /**
     * ��ȡ����provinceName
     * @return ����provinceName��ֵ
     */
    public String getProvinceName(){
        return provinceName;
    }

    /**
     * ��������cityName
     * @param cityName �����õ�����cityName��ֵ
     */
    public void setCityName(String cityName){
        this.cityName = StringUtils.rightTrim(cityName);
    }

    /**
     * ��ȡ����cityName
     * @return ����cityName��ֵ
     */
    public String getCityName(){
        return cityName;
    }

    /**
     * ��������accountType
     * @param accountType �����õ�����accountType��ֵ
     */
    public void setAccountType(String accountType){
        this.accountType = StringUtils.rightTrim(accountType);
    }

    /**
     * ��ȡ����accountType
     * @return ����accountType��ֵ
     */
    public String getAccountType(){
        return accountType;
    }

    /**
     * ��������bankName
     * @param bankName �����õ�����bankName��ֵ
     */
    public void setBankName(String bankName){
        this.bankName = StringUtils.rightTrim(bankName);
    }

    /**
     * ��ȡ����bankName
     * @return ����bankName��ֵ
     */
    public String getBankName(){
        return bankName;
    }

    /**
     * ��������openBank
     * @param openBank �����õ�����openBank��ֵ
     */
    public void setOpenBank(String openBank){
        this.openBank = StringUtils.rightTrim(openBank);
    }

    /**
     * ��ȡ����openBank
     * @return ����openBank��ֵ
     */
    public String getOpenBank(){
        return openBank;
    }

    /**
     * ��������bankAccount
     * @param bankAccount �����õ�����bankAccount��ֵ
     */
    public void setBankAccount(String bankAccount){
        this.bankAccount = StringUtils.rightTrim(bankAccount);
    }

    /**
     * ��ȡ����bankAccount
     * @return ����bankAccount��ֵ
     */
    public String getBankAccount(){
        return bankAccount;
    }

    /**
     * ��������sumPaid
     * @param sumPaid �����õ�����sumPaid��ֵ
     */
    public void setSumPaid(double sumPaid){
        this.sumPaid = sumPaid;
    }

    /**
     * ��ȡ����sumPaid
     * @return ����sumPaid��ֵ
     */
    public double getSumPaid(){
        return sumPaid;
    }

    /**
     * ��������payAmount
     * @param payAmount �����õ�����payAmount��ֵ
     */
    public void setPayAmount(double payAmount){
        this.payAmount = payAmount;
    }

    /**
     * ��ȡ����payAmount
     * @return ����payAmount��ֵ
     */
    public double getPayAmount(){
        return payAmount;
    }

    /**
     * ��������payFlag
     * @param payFlag �����õ�����payFlag��ֵ
     */
    public void setPayFlag(String payFlag){
        this.payFlag = StringUtils.rightTrim(payFlag);
    }

    /**
     * ��ȡ����payFlag
     * @return ����payFlag��ֵ
     */
    public String getPayFlag(){
        return payFlag;
    }

    /**
     * ��������mobilePhone
     * @param mobilePhone �����õ�����mobilePhone��ֵ
     */
    public void setMobilePhone(String mobilePhone){
        this.mobilePhone = StringUtils.rightTrim(mobilePhone);
    }

    /**
     * ��ȡ����mobilePhone
     * @return ����mobilePhone��ֵ
     */
    public String getMobilePhone(){
        return mobilePhone;
    }

    /**
     * ��������address
     * @param address �����õ�����address��ֵ
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * ��ȡ����address
     * @return ����address��ֵ
     */
    public String getAddress(){
        return address;
    }

    /**
     * ��������accountFlag
     * @param accountFlag �����õ�����accountFlag��ֵ
     */
    public void setAccountFlag(String accountFlag){
        this.accountFlag = StringUtils.rightTrim(accountFlag);
    }

    /**
     * ��ȡ����accountFlag
     * @return ����accountFlag��ֵ
     */
    public String getAccountFlag(){
        return accountFlag;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * ��������operatorCode
     * @param operatorCode �����õ�����operatorCode��ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ����operatorCode
     * @return ����operatorCode��ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * ��������routeNum
     * @param routeNum �����õ�����routeNum��ֵ
     */
    public void setRouteNum(String routeNum){
        this.routeNum = StringUtils.rightTrim(routeNum);
    }

    /**
     * ��ȡ����routeNum
     * @return ����routeNum��ֵ
     */
    public String getRouteNum(){
        return routeNum;
    }
    
    public String getExist() {
		return Exist;
	}

	public void setExist(String exist) {
		Exist = exist;
	}

	public String getRealPayWay() {
		return realPayWay;
	}

	public void setRealPayWay(String realPayWay) {
		this.realPayWay = realPayWay;
	}
	
}
