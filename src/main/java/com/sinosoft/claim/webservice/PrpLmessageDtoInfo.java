package com.sinosoft.claim.webservice;

import java.io.Serializable;
/**
 * 理赔系统理赔沟通:主信息(PrpLmessageDtoInfo)
 * @author Administrator
 *
 */
public class PrpLmessageDtoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String registNo;
	private String inputDate;
	private String nodeType;
	private String nodeName;
	private String operatorCode;
	private String operatorName;
	private String context;
	public PrpLmessageDtoInfo() {
		super();
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	

}
