package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLclaimBillManager的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLclaimBillManagerDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性registNo */
    private String registNo = "";
    /** 属性policyNo */
    private String policyNo = "";
    /** 属性compensateNo */
    private String compensateNo = "";
    /** 属性serialNo */
    private int serialNo = 0;
    /** 属性payName */
    private String payName = "";
    /** 属性identifyNumber */
    private String identifyNumber = "";
    /** 属性insuredCode */
    private String insuredCode = "";
    /** 属性provinceName */
    private String provinceName = "";
    /** 属性cityName */
    private String cityName = "";
    /** 属性accountType */
    private String accountType = "";
    /** 属性bankName */
    private String bankName = "";
    /** 属性openBank */
    private String openBank = "";
    /** 属性bankAccount */
    private String bankAccount = "";
    /** 属性sumPaid */
    private double sumPaid = 0D;
    /** 属性payAmount */
    private double payAmount = 0D;
    /** 属性payFlag */
    private String payFlag = "";
    /** 属性mobilePhone */
    private String mobilePhone = "";
    /** 属性address */
    private String address = "";
    /** 属性accountFlag */
    private String accountFlag = "";
    /** 属性flag */
    private String flag = "";
    /** 属性operatorCode */
    private String operatorCode = "";
    /** 属性routeNum */
    private String routeNum = "";
    /** 属性realPayWay */
    private String realPayWay = "";
    private String Exist = "";

    /**
     *  默认构造方法,构造一个默认的PrpLclaimBillManagerDtoBase对象
     */
    public PrpLclaimBillManagerDtoBase(){
    }

    /**
     * 设置属性registNo
     * @param registNo 待设置的属性registNo的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性registNo
     * @return 属性registNo的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性policyNo
     * @param policyNo 待设置的属性policyNo的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性policyNo
     * @return 属性policyNo的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性compensateNo
     * @param compensateNo 待设置的属性compensateNo的值
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * 获取属性compensateNo
     * @return 属性compensateNo的值
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * 设置属性serialNo
     * @param serialNo 待设置的属性serialNo的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性serialNo
     * @return 属性serialNo的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性payName
     * @param payName 待设置的属性payName的值
     */
    public void setPayName(String payName){
        this.payName = StringUtils.rightTrim(payName);
    }

    /**
     * 获取属性payName
     * @return 属性payName的值
     */
    public String getPayName(){
        return payName;
    }

    /**
     * 设置属性identifyNumber
     * @param identifyNumber 待设置的属性identifyNumber的值
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * 获取属性identifyNumber
     * @return 属性identifyNumber的值
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * 设置属性insuredCode
     * @param insuredCode 待设置的属性insuredCode的值
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * 获取属性insuredCode
     * @return 属性insuredCode的值
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * 设置属性provinceName
     * @param provinceName 待设置的属性provinceName的值
     */
    public void setProvinceName(String provinceName){
        this.provinceName = StringUtils.rightTrim(provinceName);
    }

    /**
     * 获取属性provinceName
     * @return 属性provinceName的值
     */
    public String getProvinceName(){
        return provinceName;
    }

    /**
     * 设置属性cityName
     * @param cityName 待设置的属性cityName的值
     */
    public void setCityName(String cityName){
        this.cityName = StringUtils.rightTrim(cityName);
    }

    /**
     * 获取属性cityName
     * @return 属性cityName的值
     */
    public String getCityName(){
        return cityName;
    }

    /**
     * 设置属性accountType
     * @param accountType 待设置的属性accountType的值
     */
    public void setAccountType(String accountType){
        this.accountType = StringUtils.rightTrim(accountType);
    }

    /**
     * 获取属性accountType
     * @return 属性accountType的值
     */
    public String getAccountType(){
        return accountType;
    }

    /**
     * 设置属性bankName
     * @param bankName 待设置的属性bankName的值
     */
    public void setBankName(String bankName){
        this.bankName = StringUtils.rightTrim(bankName);
    }

    /**
     * 获取属性bankName
     * @return 属性bankName的值
     */
    public String getBankName(){
        return bankName;
    }

    /**
     * 设置属性openBank
     * @param openBank 待设置的属性openBank的值
     */
    public void setOpenBank(String openBank){
        this.openBank = StringUtils.rightTrim(openBank);
    }

    /**
     * 获取属性openBank
     * @return 属性openBank的值
     */
    public String getOpenBank(){
        return openBank;
    }

    /**
     * 设置属性bankAccount
     * @param bankAccount 待设置的属性bankAccount的值
     */
    public void setBankAccount(String bankAccount){
        this.bankAccount = StringUtils.rightTrim(bankAccount);
    }

    /**
     * 获取属性bankAccount
     * @return 属性bankAccount的值
     */
    public String getBankAccount(){
        return bankAccount;
    }

    /**
     * 设置属性sumPaid
     * @param sumPaid 待设置的属性sumPaid的值
     */
    public void setSumPaid(double sumPaid){
        this.sumPaid = sumPaid;
    }

    /**
     * 获取属性sumPaid
     * @return 属性sumPaid的值
     */
    public double getSumPaid(){
        return sumPaid;
    }

    /**
     * 设置属性payAmount
     * @param payAmount 待设置的属性payAmount的值
     */
    public void setPayAmount(double payAmount){
        this.payAmount = payAmount;
    }

    /**
     * 获取属性payAmount
     * @return 属性payAmount的值
     */
    public double getPayAmount(){
        return payAmount;
    }

    /**
     * 设置属性payFlag
     * @param payFlag 待设置的属性payFlag的值
     */
    public void setPayFlag(String payFlag){
        this.payFlag = StringUtils.rightTrim(payFlag);
    }

    /**
     * 获取属性payFlag
     * @return 属性payFlag的值
     */
    public String getPayFlag(){
        return payFlag;
    }

    /**
     * 设置属性mobilePhone
     * @param mobilePhone 待设置的属性mobilePhone的值
     */
    public void setMobilePhone(String mobilePhone){
        this.mobilePhone = StringUtils.rightTrim(mobilePhone);
    }

    /**
     * 获取属性mobilePhone
     * @return 属性mobilePhone的值
     */
    public String getMobilePhone(){
        return mobilePhone;
    }

    /**
     * 设置属性address
     * @param address 待设置的属性address的值
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * 获取属性address
     * @return 属性address的值
     */
    public String getAddress(){
        return address;
    }

    /**
     * 设置属性accountFlag
     * @param accountFlag 待设置的属性accountFlag的值
     */
    public void setAccountFlag(String accountFlag){
        this.accountFlag = StringUtils.rightTrim(accountFlag);
    }

    /**
     * 获取属性accountFlag
     * @return 属性accountFlag的值
     */
    public String getAccountFlag(){
        return accountFlag;
    }

    /**
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public String getFlag(){
        return flag;
    }

    /**
     * 设置属性operatorCode
     * @param operatorCode 待设置的属性operatorCode的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性operatorCode
     * @return 属性operatorCode的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性routeNum
     * @param routeNum 待设置的属性routeNum的值
     */
    public void setRouteNum(String routeNum){
        this.routeNum = StringUtils.rightTrim(routeNum);
    }

    /**
     * 获取属性routeNum
     * @return 属性routeNum的值
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
