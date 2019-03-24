package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.Collection;


public class NewDangerUnitDto  implements Serializable{
    /**
     *  默认构造方法,构造一个默认的NewDangerUnitDto对象
     */
    public NewDangerUnitDto(){
    }

    private String kindcode = "";
    private String kindname = "";
    private String policyno = "";
    private String riskcode = "";
    private String dangerno = "";
    private String dangerdesc = "";
    private String addressname="";
    private String dangerkindshare="";
    private String dangerkindAmount="";
    private String dangerkindFee="";
    private String currency="";
    private String itemcode="";
    private String itemname="";
    private String itemkindno="";
    //业务来源
    private  String     businessNature        ="";
    //保单业务类型
    private  String     policyBizType         ="";
    //投保方式
    private  String     policyType            ="";
    //政策性标识
    private  String     businessType1         ="";
    //涉农标识
    private  String     businessType          ="";
    //标志字段
    private  String     othFlag               ="";
    //归属区域省
    private  String     businessProvince      ="";
    //归属区域市
    private  String     businessTown          ="";
    //归属区域县
    private  String     businessCounty        ="";
    //归属区域乡镇
    private  String     businessAreaName      ="";
    	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getKindcode() {
		return kindcode;
	}

	public void setKindcode(String kindcode) {
		this.kindcode = kindcode;
	}

	public String getKindname() {
		return kindname;
	}

	public void setKindname(String kindname) {
		this.kindname = kindname;
	}

	public String getPolicyno() {
		return policyno;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}

	public String getRiskcode() {
		return riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}

	public String getDangerno() {
		return dangerno;
	}

	public void setDangerno(String dangerno) {
		this.dangerno = dangerno;
	}

	public String getDangerdesc() {
		return dangerdesc;
	}

	public void setDangerdesc(String dangerdesc) {
		this.dangerdesc = dangerdesc;
	}

	public String getAddressname() {
		return addressname;
	}

	public void setAddressname(String addressname) {
		this.addressname = addressname;
	}

	public String getDangerkindshare() {
		return dangerkindshare;
	}

	public void setDangerkindshare(String dangerkindshare) {
		this.dangerkindshare = dangerkindshare;
	}

	public String getDangerkindAmount() {
		return dangerkindAmount;
	}

	public void setDangerkindAmount(String dangerkindAmount) {
		this.dangerkindAmount = dangerkindAmount;
	}

	public String getItemcode() {
		return itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemkindno() {
		return itemkindno;
	}

	public void setItemkindno(String itemkindno) {
		this.itemkindno = itemkindno;
	}

	public String getBusinessNature() {
		return businessNature;
	}

	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}

	public String getPolicyBizType() {
		return policyBizType;
	}

	public void setPolicyBizType(String policyBizType) {
		this.policyBizType = policyBizType;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getBusinessType1() {
		return businessType1;
	}

	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getOthFlag() {
		return othFlag;
	}

	public void setOthFlag(String othFlag) {
		this.othFlag = othFlag;
	}

	public String getBusinessProvince() {
		return businessProvince;
	}

	public void setBusinessProvince(String businessProvince) {
		this.businessProvince = businessProvince;
	}

	public String getBusinessTown() {
		return businessTown;
	}

	public void setBusinessTown(String businessTown) {
		this.businessTown = businessTown;
	}

	public String getBusinessCounty() {
		return businessCounty;
	}

	public void setBusinessCounty(String businessCounty) {
		this.businessCounty = businessCounty;
	}

	public String getBusinessAreaName() {
		return businessAreaName;
	}

	public void setBusinessAreaName(String businessAreaName) {
		this.businessAreaName = businessAreaName;
	}

	public String getDangerkindFee() {
		return dangerkindFee;
	}

	public void setDangerkindFee(String dangerkindFee) {
		this.dangerkindFee = dangerkindFee;
	}

   
}
