package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrplPayeeInfo�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrplPayeeInfoDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����receiverFullName */
    private String receiverFullName = "";
    /** ����receiverTypeOther */
    private String receiverTypeOther = "";
    /** ����receiverTypeOtherName */
    private String receiverTypeOtherName = "";
    /** ����certifNo */
    private String certifNo = "";
    /** ����certifType */
    private String certifType = "";
    /** ����bank */
    private String bank = "";
    /** ����bankAccount */
    private String bankAccount = "";
    /** ����bankType */
    private String bankType = "";
    /** ����accountFlag */
    private String accountFlag = "";
    /** ����accountType */
    private String accountType = "";
    /** ����routeNum */
    private String routeNum = "";
    /** ����city */
    private String city = "";
    /** ����province */
    private String province = "";
    /** ����mobilePhone */
    private String mobilePhone = "";
    /** ����inputDate */
    private String inputDate = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplPayeeInfoDtoBase����
     */
    public PrplPayeeInfoDtoBase(){
    }

    /**
     * ��������receiverFullName
     * @param receiverFullName �����õ�����receiverFullName��ֵ
     */
    public void setReceiverFullName(String receiverFullName){
        this.receiverFullName = StringUtils.rightTrim(receiverFullName);
    }

    /**
     * ��ȡ����receiverFullName
     * @return ����receiverFullName��ֵ
     */
    public String getReceiverFullName(){
        return receiverFullName;
    }

    /**
     * ��������receiverTypeOther
     * @param receiverTypeOther �����õ�����receiverTypeOther��ֵ
     */
    public void setReceiverTypeOther(String receiverTypeOther){
        this.receiverTypeOther = StringUtils.rightTrim(receiverTypeOther);
    }

    /**
     * ��ȡ����receiverTypeOther
     * @return ����receiverTypeOther��ֵ
     */
    public String getReceiverTypeOther(){
        return receiverTypeOther;
    }

    /**
     * ��������receiverTypeOtherName
     * @param receiverTypeOtherName �����õ�����receiverTypeOtherName��ֵ
     */
    public void setReceiverTypeOtherName(String receiverTypeOtherName){
        this.receiverTypeOtherName = StringUtils.rightTrim(receiverTypeOtherName);
    }

    /**
     * ��ȡ����receiverTypeOtherName
     * @return ����receiverTypeOtherName��ֵ
     */
    public String getReceiverTypeOtherName(){
        return receiverTypeOtherName;
    }

    /**
     * ��������certifNo
     * @param certifNo �����õ�����certifNo��ֵ
     */
    public void setCertifNo(String certifNo){
        this.certifNo = StringUtils.rightTrim(certifNo);
    }

    /**
     * ��ȡ����certifNo
     * @return ����certifNo��ֵ
     */
    public String getCertifNo(){
        return certifNo;
    }

    /**
     * ��������certifType
     * @param certifType �����õ�����certifType��ֵ
     */
    public void setCertifType(String certifType){
        this.certifType = StringUtils.rightTrim(certifType);
    }

    /**
     * ��ȡ����certifType
     * @return ����certifType��ֵ
     */
    public String getCertifType(){
        return certifType;
    }

    /**
     * ��������bank
     * @param bank �����õ�����bank��ֵ
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * ��ȡ����bank
     * @return ����bank��ֵ
     */
    public String getBank(){
        return bank;
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
     * ��������bankType
     * @param bankType �����õ�����bankType��ֵ
     */
    public void setBankType(String bankType){
        this.bankType = StringUtils.rightTrim(bankType);
    }

    /**
     * ��ȡ����bankType
     * @return ����bankType��ֵ
     */
    public String getBankType(){
        return bankType;
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

    /**
     * ��������city
     * @param city �����õ�����city��ֵ
     */
    public void setCity(String city){
        this.city = StringUtils.rightTrim(city);
    }

    /**
     * ��ȡ����city
     * @return ����city��ֵ
     */
    public String getCity(){
        return city;
    }

    /**
     * ��������province
     * @param province �����õ�����province��ֵ
     */
    public void setProvince(String province){
        this.province = StringUtils.rightTrim(province);
    }

    /**
     * ��ȡ����province
     * @return ����province��ֵ
     */
    public String getProvince(){
        return province;
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

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
}
