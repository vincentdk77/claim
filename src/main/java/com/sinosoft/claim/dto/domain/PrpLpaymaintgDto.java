package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 这是支付信息主表的数据传输对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLpaymaintgDto extends PrpLpaymaintgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 银行大类名称 */
    private String bankTypeName;
    /** 结果集 */
    private ArrayList resultList;
    /**流入时长**/
    private String totalInputDate = "";
    /**承保机构名称**/
    private String comName = "";
    /** 操作人名称 */
    private String operatorName ="";
    /** 省份名称*/
    private String provinceName = "";
    /** 城市名称*/
    private String cityName = "";
    
    private String registNo; //报案号码
    
    private String policyNo; //保单号码
    
    private String insuredName; //被保险人名称
    
    private String licenseNo; //号牌号码]
    
    /** 属性单个案件支付金额 */
    private double payAmountSub = 0D; 
    
    private String billNo = "";
    
    private String billNoFlag = "";
    
    /**
     *  默认构造方法,构造一个默认的PrpLpaymaintgDto对象
     */
    public PrpLpaymaintgDto(){
    }
	public ArrayList getResultList() {
		return resultList;
	}
	public void setResultList(ArrayList resultList) {
		this.resultList = resultList;
	}
	public String getBankTypeName() {
		return bankTypeName;
	}
	public void setBankTypeName(String bankTypeName) {
		this.bankTypeName = bankTypeName;
	}
	public String getTotalInputDate() {
		return totalInputDate;
	}
	public void setTotalInputDate(String totalInputDate) {
		this.totalInputDate = totalInputDate;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public double getPayAmountSub() {
		return payAmountSub;
	}
	public void setPayAmountSub(double payAmountSub) {
		this.payAmountSub = payAmountSub;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getBillNoFlag() {
		return billNoFlag;
	}
	public void setBillNoFlag(String billNoFlag) {
		this.billNoFlag = billNoFlag;
	}
	
}
