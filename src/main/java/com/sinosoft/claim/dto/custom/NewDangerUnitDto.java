package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.Collection;


public class NewDangerUnitDto  implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�NewDangerUnitDto����
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
    //ҵ����Դ
    private  String     businessNature        ="";
    //����ҵ������
    private  String     policyBizType         ="";
    //Ͷ����ʽ
    private  String     policyType            ="";
    //�����Ա�ʶ
    private  String     businessType1         ="";
    //��ũ��ʶ
    private  String     businessType          ="";
    //��־�ֶ�
    private  String     othFlag               ="";
    //��������ʡ
    private  String     businessProvince      ="";
    //����������
    private  String     businessTown          ="";
    //����������
    private  String     businessCounty        ="";
    //������������
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
