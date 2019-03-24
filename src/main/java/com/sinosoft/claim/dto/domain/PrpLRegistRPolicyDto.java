package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.mail.search.DateTerm;

import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * 这是PrpLRegistRPolicy赔案保单关联表的数据传输对象类<br>
 * 创建于 2006-06-04 15:22:02.769<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLRegistRPolicyDto extends PrpLRegistRPolicyDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLRegistRPolicyDto对象
     */
    public PrpLRegistRPolicyDto(){
    }
    /**		
     * 商业保单
     */
    public static final String BUSINESS_POLICY = "1";
    /**
     * 强制保单
     */
    public static final String COMPEL_POLICY = "3";
    
    /**
     * 被保险人代码
     */
    private String insuredcode="";
    /***
     * 被保险人名称
     */
    private String insuredname="";
    /**
     * 车牌号
     */
    private String licensenno="";
    /*
     * 出险次数
     */
    private int dangerTimes=0;
    /*
     * 保险期限
     */
    private String endDate="";
    /*
     * 承保机构
     */
    private String comCode="";
    /*
     * 承保机构
     */
    private String comCodeName="";
    /*
     * 车架号
     */
    private String frameno="";
    /*
     * 发动机号
     */
    private String engineNo="";
    /*
     *报案保单的标志
     */
    private String policyFlag="1";
    private String startDate = "";
    
    private ArrayList prplregistrpolicyArrayList = new ArrayList<PrpLRegistRPolicyDto>();
    
    
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getPolicyFlag() {
		return policyFlag;
	}
	public void setPolicyFlag(String policyFlag) {
		this.policyFlag = policyFlag;
	}
	public String getComCodeName() {
		return comCodeName;
	}
	public void setComCodeName(String comCodeName) {
		this.comCodeName = comCodeName;
	}
	public String getInsuredcode() {
		return insuredcode;
	}
	public void setInsuredcode(String insuredcode) {
		this.insuredcode = insuredcode;
	}
	public String getInsuredname() {
		return insuredname;
	}
	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}
	public String getLicensenno() {
		return licensenno;
	}
	public void setLicensenno(String licensenno) {
		this.licensenno = licensenno;
	}
	public int getDangerTimes() {
		return dangerTimes;
	}
	public void setDangerTimes(int dangerTimes) {
		this.dangerTimes = dangerTimes;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getFrameno() {
		return frameno;
	}
	public void setFrameno(String frameno) {
		this.frameno = frameno;
	}
	public ArrayList getPrplregistrpolicyArrayList() {
		return prplregistrpolicyArrayList;
	}
	public void setPrplregistrpolicyArrayList(ArrayList prplregistrpolicyArrayList) {
		this.prplregistrpolicyArrayList = prplregistrpolicyArrayList;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
    
}
			