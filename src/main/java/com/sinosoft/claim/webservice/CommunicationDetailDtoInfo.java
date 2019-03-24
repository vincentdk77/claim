package com.sinosoft.claim.webservice;

import java.io.Serializable;
/**
 * 理赔系统理赔沟通列表查询(CommunicationDetailReqInfo)返回对象
 * @author Administrator
 *
 */
public class CommunicationDetailDtoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String registNo;
	private String nodeType;
	private String nodeName;
	private String inputDate;
	private String userCode;
	private String userName;
	private String context;
	public CommunicationDetailDtoInfo() {
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
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
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	
}
