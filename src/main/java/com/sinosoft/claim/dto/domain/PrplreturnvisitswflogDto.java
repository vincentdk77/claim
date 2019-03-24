package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * ����PRPLRETURNVISITSWFLOG�����ݴ��������<br>
 */
public class PrplreturnvisitswflogDto extends PrplreturnvisitswflogDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private TurnPageDto turnPageDto = null;
    
    /** ����BYCOMPLAINTCODE ��Ͷ����*/
    private String bycomplaintcode = "";
    
    /** ����BYCOMPLAINTCOMCODE ��Ͷ�߻���*/
    private String bycomplaintcomcode = "";
    
    /** ����BYCOMPLAINTCOMCODE ��Ͷ�߻�������*/
    private String bycomplaintcomcodeName = "";
    
    /** ����COMPLAINTDATE Ͷ��ʱ��*/
    private String complaintdate = "";
    
    /** ���� �ӱ�����*/
    private String receivername = "";
    
    /** ���� �ط���*/
    private String enteringname = "";
    
    /** ���� �ط�ʱ��*/
    private String enteringtime = "";
    
    /** ���� �ѻطô���*/
    private String serialno = "";
    /** ���� �᰸��*/
    private String endcaseno = "";
    /** ���� �⸶���*/
    private Double sumpaid = 0d;
    /** ���� ���⸶���*/
    private Double sumprepaid = 0d;
    /** ���� ��ϵ�绰*/
    private String tel = "";
    /** ���� �����绰*/
    private String reportorPhoneNumber = "";
    /** ���� �������˴���*/
    private String insuredcode = "";
    /** ���� �طñ�־*/
    private String nodeMark = "";
    /** ���� �᰸ʱ��*/
    private String endCaseDate = "";
    /** ���� ֧��ʱ��*/
    private String payRefDate = "";
    /** ���� ����ʱ��(��)*/
    private String stReportDate = "";
    /** ���� ����ʱ�䣨ʱ���룩*/
    private String stReportHour = "";
    
    
    /** ���� ���ط���*/
    private String visitName="";
    /** ���� �Ƿ�طóɹ�*/
    private String isReturnSucess="";
    /** ���� �ط������*/
    private String  serviceSelect="";
    /** ���� �ط������*/
    private String  serviceName="";
    /** ���� ��������*/
    private String existIssue="";
    /** ���� ����Excel�绰����*/
    private String exltel="";
    /** ���� ¼����ˮ��*/
    private String recorderNo = "";
    /** ���� �ط����*/
    private String visitOpinion = "";
    
    
    public String getEnteringname() {
		return enteringname;
	}

	public String getEnteringtime() {
		return enteringtime;
	}

	public void setEnteringname(String enteringname) {
		this.enteringname = enteringname;
	}

	public void setEnteringtime(String enteringtime) {
		this.enteringtime = enteringtime;
	}

	public String getReceivername() {
		return receivername;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}

	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}

	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}

	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplreturnvisitswflogDto����
     */
    public PrplreturnvisitswflogDto(){
    }

	public String getBycomplaintcode() {
		return bycomplaintcode;
	}

	public String getBycomplaintcomcode() {
		return bycomplaintcomcode;
	}

	public String getBycomplaintcomcodeName() {
		return bycomplaintcomcodeName;
	}

	public String getComplaintdate() {
		return complaintdate;
	}

	public void setBycomplaintcode(String bycomplaintcode) {
		this.bycomplaintcode = bycomplaintcode;
	}

	public void setBycomplaintcomcode(String bycomplaintcomcode) {
		this.bycomplaintcomcode = bycomplaintcomcode;
	}

	public void setBycomplaintcomcodeName(String bycomplaintcomcodeName) {
		this.bycomplaintcomcodeName = bycomplaintcomcodeName;
	}

	public void setComplaintdate(String complaintdate) {
		this.complaintdate = complaintdate;
	}

	public String getSerialno() {
		return serialno;
	}

	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	public String getEndcaseno() {
		return endcaseno;
	}

	public void setEndcaseno(String endcaseno) {
		this.endcaseno = endcaseno;
	}

	public Double getSumpaid() {
		return sumpaid;
	}

	public void setSumpaid(Double sumpaid) {
		this.sumpaid = sumpaid;
	}

	public Double getSumprepaid() {
		return sumprepaid;
	}

	public void setSumprepaid(Double sumprepaid) {
		this.sumprepaid = sumprepaid;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getReportorPhoneNumber() {
		return reportorPhoneNumber;
	}

	public void setReportorPhoneNumber(String reportorPhoneNumber) {
		this.reportorPhoneNumber = reportorPhoneNumber;
	}

	public String getInsuredcode() {
		return insuredcode;
	}

	public void setInsuredcode(String insuredcode) {
		this.insuredcode = insuredcode;
	}

	public String getNodeMark() {
		return nodeMark;
	}

	public void setNodeMark(String nodeMark) {
		this.nodeMark = nodeMark;
	}

	public String getEndCaseDate() {
		return endCaseDate;
	}

	public void setEndCaseDate(String endCaseDate) {
		this.endCaseDate = endCaseDate;
	}

	public String getPayRefDate() {
		return payRefDate;
	}

	public void setPayRefDate(String payRefDate) {
		this.payRefDate = payRefDate;
	}

	public String getStReportDate() {
		return stReportDate;
	}

	public void setStReportDate(String stReportDate) {
		this.stReportDate = stReportDate;
	}

	public String getStReportHour() {
		return stReportHour;
	}

	public void setStReportHour(String stReportHour) {
		this.stReportHour = stReportHour;
	}

	public String getVisitName() {
		return visitName;
	}

	public void setVisitName(String visitName) {
		this.visitName = visitName;
	}

	public String getIsReturnSucess() {
		return isReturnSucess;
	}

	public void setIsReturnSucess(String isReturnSucess) {
		this.isReturnSucess = isReturnSucess;
	}

	public String getServiceSelect() {
		return serviceSelect;
	}

	public void setServiceSelect(String serviceSelect) {
		this.serviceSelect = serviceSelect;
	}

	public String getExistIssue() {
		return existIssue;
	}

	public void setExistIssue(String existIssue) {
		this.existIssue = existIssue;
	}

	public String getExltel() {
		return exltel;
	}

	public void setExltel(String exltel) {
		this.exltel = exltel;
	
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	
	}
	

	public String getRecorderNo() {
		return recorderNo;
	}

	public void setRecorderNo(String recorderNo) {
		this.recorderNo = recorderNo;
	
	}
	

	public String getVisitOpinion() {
		return visitOpinion;
	}

	public void setVisitOpinion(String visitOpinion) {
		this.visitOpinion = visitOpinion;
	
	}
	
}
