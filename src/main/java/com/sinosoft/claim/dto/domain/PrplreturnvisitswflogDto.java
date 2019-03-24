package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是PRPLRETURNVISITSWFLOG的数据传输对象类<br>
 */
public class PrplreturnvisitswflogDto extends PrplreturnvisitswflogDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private TurnPageDto turnPageDto = null;
    
    /** 属性BYCOMPLAINTCODE 被投诉人*/
    private String bycomplaintcode = "";
    
    /** 属性BYCOMPLAINTCOMCODE 被投诉机构*/
    private String bycomplaintcomcode = "";
    
    /** 属性BYCOMPLAINTCOMCODE 被投诉机构名称*/
    private String bycomplaintcomcodeName = "";
    
    /** 属性COMPLAINTDATE 投诉时间*/
    private String complaintdate = "";
    
    /** 属性 接报案人*/
    private String receivername = "";
    
    /** 属性 回访人*/
    private String enteringname = "";
    
    /** 属性 回访时间*/
    private String enteringtime = "";
    
    /** 属性 已回访次数*/
    private String serialno = "";
    /** 属性 结案号*/
    private String endcaseno = "";
    /** 属性 赔付金额*/
    private Double sumpaid = 0d;
    /** 属性 已赔付金额*/
    private Double sumprepaid = 0d;
    /** 属性 联系电话*/
    private String tel = "";
    /** 属性 报案电话*/
    private String reportorPhoneNumber = "";
    /** 属性 被保险人代码*/
    private String insuredcode = "";
    /** 属性 回访标志*/
    private String nodeMark = "";
    /** 属性 结案时间*/
    private String endCaseDate = "";
    /** 属性 支付时间*/
    private String payRefDate = "";
    /** 属性 报案时间(天)*/
    private String stReportDate = "";
    /** 属性 报案时间（时分秒）*/
    private String stReportHour = "";
    
    
    /** 属性 被回访人*/
    private String visitName="";
    /** 属性 是否回访成功*/
    private String isReturnSucess="";
    /** 属性 回访满意度*/
    private String  serviceSelect="";
    /** 属性 回访满意度*/
    private String  serviceName="";
    /** 属性 存在问题*/
    private String existIssue="";
    /** 属性 导出Excel电话号码*/
    private String exltel="";
    /** 属性 录音流水号*/
    private String recorderNo = "";
    /** 属性 回访意见*/
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
     *  默认构造方法,构造一个默认的PrplreturnvisitswflogDto对象
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
