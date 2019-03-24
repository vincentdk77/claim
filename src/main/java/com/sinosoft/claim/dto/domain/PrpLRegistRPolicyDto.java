package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.mail.search.DateTerm;

import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * ����PrpLRegistRPolicy�ⰸ��������������ݴ��������<br>
 * ������ 2006-06-04 15:22:02.769<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLRegistRPolicyDto extends PrpLRegistRPolicyDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLRegistRPolicyDto����
     */
    public PrpLRegistRPolicyDto(){
    }
    /**		
     * ��ҵ����
     */
    public static final String BUSINESS_POLICY = "1";
    /**
     * ǿ�Ʊ���
     */
    public static final String COMPEL_POLICY = "3";
    
    /**
     * �������˴���
     */
    private String insuredcode="";
    /***
     * ������������
     */
    private String insuredname="";
    /**
     * ���ƺ�
     */
    private String licensenno="";
    /*
     * ���մ���
     */
    private int dangerTimes=0;
    /*
     * ��������
     */
    private String endDate="";
    /*
     * �б�����
     */
    private String comCode="";
    /*
     * �б�����
     */
    private String comCodeName="";
    /*
     * ���ܺ�
     */
    private String frameno="";
    /*
     * ��������
     */
    private String engineNo="";
    /*
     *���������ı�־
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
			