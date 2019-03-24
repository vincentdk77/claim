package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

/**
 * 报案任务查询接口  查询报案列表的 返回信息：案件信息
 * @author Administrator
 *
 */

public class RegistCaseDto implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 案件状态 */
	private String caseFlag;
	/** 报案号 */
	private String registNo;
	/** 保单号 */
	private String policyNo;
	/** 被保险人名称 */
	private String insuredName;
	/** 接报案人员名称 */
	private String operateName;
	/** 操作时间 */
	private String operateDate;
	public RegistCaseDto() {
		super();
	}
	public String getCaseFlag() {
		return caseFlag;
	}
	public void setCaseFlag(String caseFlag) {
		this.caseFlag = caseFlag;
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
	public String getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}
	public String getOperateName() {
		return operateName;
	}
	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}
	
}
