package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * ����֧����Ϣ��������ݴ��������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLpaymaintgDto extends PrpLpaymaintgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ���д������� */
    private String bankTypeName;
    /** ����� */
    private ArrayList resultList;
    /**����ʱ��**/
    private String totalInputDate = "";
    /**�б���������**/
    private String comName = "";
    /** ���������� */
    private String operatorName ="";
    /** ʡ������*/
    private String provinceName = "";
    /** ��������*/
    private String cityName = "";
    
    private String registNo; //��������
    
    private String policyNo; //��������
    
    private String insuredName; //������������
    
    private String licenseNo; //���ƺ���]
    
    /** ���Ե�������֧����� */
    private double payAmountSub = 0D; 
    
    private String billNo = "";
    
    private String billNoFlag = "";
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpaymaintgDto����
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
