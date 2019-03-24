package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

/**
 * 报案任务查询接口  查询报案列表的入参
 *
 */
public class RegistCaseQuery implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 报案号 */
	private String registNo;
	/** 保单号 */
	private String policyNo;
	/** 车牌号 */
	private String licenseNo;
	/** 机构 */
	private String comcode;
	/** 被保险人名称 */
	private String insuredName;
	/** 是否注销(1:是、2:否) */
	private String cancelFlag;
	/** 注销开始时间（如果cancelFlag=2不传） */
	private String registStartCancelDate;
	/** 注销结束时间（如果cancelFlag=2不传） */
	private String registEndCancelDate;
	/** 案件状态（2:正在处理、4:已处理） */
	private String[] caseFlag;
	/** 耳标号（中央政策性养殖险） */
	private String earLabel;
	/** 农户姓名（中央政策性养殖险专用） */
	private String fName;
	/** 身份证号（种植险专用） */
	private String fCardID;
	/** 农户姓名（种植险专用） */
	private String fName1;
	/** 操作时间起始 */
	private String operateDate;
	/** 操作时间截止 */
	private String operateDateEnd;
	/** 险种大类 */
	private String riskCategory;
	/** 险种 */
	private String queryRiskCode;
	/** 来电号码 */
	private String callInPhoneNumber;
	/** 发动机号 */
	private String engineNo;
	/** 车架号 */
	private String frameNo;
	
	
	/** 页数（默认1） */
	private int pageNo;
	/** 每页条数（默认显示20条） */
	private int recordPerPage;
	public RegistCaseQuery() {
		super();
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
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getComcode() {
		return comcode;
	}
	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getCancelFlag() {
		return cancelFlag;
	}
	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}
	
	public String[] getCaseFlag() {
		return caseFlag;
	}
	public void setCaseFlag(String[] caseFlag) {
		this.caseFlag = caseFlag;
	}
	public String getEarLabel() {
		return earLabel;
	}
	public void setEarLabel(String earLabel) {
		this.earLabel = earLabel;
	}
	public String getFName() {
		return fName;
	}
	public void setFName(String name) {
		fName = name;
	}
	public String getFCardID() {
		return fCardID;
	}
	public void setFCardID(String cardID) {
		fCardID = cardID;
	}
	public String getFName1() {
		return fName1;
	}
	public void setFName1(String name1) {
		fName1 = name1;
	}
	public String getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}
	public String getOperateDateEnd() {
		return operateDateEnd;
	}
	public void setOperateDateEnd(String operateDateEnd) {
		this.operateDateEnd = operateDateEnd;
	}
	public String getRiskCategory() {
		return riskCategory;
	}
	public void setRiskCategory(String riskCategory) {
		this.riskCategory = riskCategory;
	}
	public String getQueryRiskCode() {
		return queryRiskCode;
	}
	public void setQueryRiskCode(String queryRiskCode) {
		this.queryRiskCode = queryRiskCode;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getRecordPerPage() {
		return recordPerPage;
	}
	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getRegistStartCancelDate() {
		return registStartCancelDate;
	}
	public void setRegistStartCancelDate(String registStartCancelDate) {
		this.registStartCancelDate = registStartCancelDate;
	}
	public String getRegistEndCancelDate() {
		return registEndCancelDate;
	}
	public void setRegistEndCancelDate(String registEndCancelDate) {
		this.registEndCancelDate = registEndCancelDate;
	}
	public String getCallInPhoneNumber() {
		return callInPhoneNumber;
	}
	public void setCallInPhoneNumber(String callInPhoneNumber) {
		this.callInPhoneNumber = callInPhoneNumber;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getFrameNo() {
		return frameNo;
	}
	public void setFrameNo(String frameNo) {
		this.frameNo = frameNo;
	}
	

}
