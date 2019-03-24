package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

public class ReturnVisitInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 业务号 */
	private String businessNo;
	/** 节点类型（sched: 派工回访, endca: 结案回访） */
	private String nodeType;
	/** 被回访人 */
	private String visitName;
	/** 是否回访成功(1:成功,0:失败) */
	private String visitSuccess;
	/** 回访人ID */
	private String enteringCode;
	/** 回访人员 */
	private String enteringName;
	/** 回访人机构 */
	private String enteringComcode;
	/** 录入时间 */
	private String enteringTime;
	/** 险类 */
	private String classcode;
	/** 联系电话    */ 
	private String contact;
	/** 录音流水号    */ 
	private String recorderno;
	/** 服务满意度（1：满意，2：一般，3：不满意）  */ 
	private String service;
	/** 存在问题（1：时效问题，2：服务态度，3：沟通技巧，4：定损争议，5：人伤争议，6：赔付争议7：其它问题） */ 
	private String existissue;
	/** 不成功原因（1：关机，2：通讯方式变更，3：电话无人接听，4：拒绝透露案件进展，5：其他）    */ 
	private String visitnocause;
	/** 回访意见    */ 
	private String visitopinion;
	/** 报案号       */ 
	private String registno;
	/** 保单号     */ 
	private String policyno;
	/** 承保机构    */ 
	private String comcode;
	/** 承保机构名称  */ 
	private String comcodename;
	/** 被保险人    */ 
	private String insuredname;
	/** 报案日期   */ 
	private String reportdate;
	/** 结案时间 */ 
	private String ceasedate;
	/** 车牌号   */ 
	private String licenseno;
	/** 流入时间    */ 
	private String flowInTime;
	/** 结束时间  */ 
	private String ceasetime;
	/** 回访状态（0：未回访，                                        20：已回访未成功无需跟进，21：已回访未成功需跟进，4：已回访已成功）*/ 
	private String state;

	
	
	
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getVisitName() {
		return visitName;
	}
	public void setVisitName(String visitName) {
		this.visitName = visitName;
	}
	public String getVisitSuccess() {
		return visitSuccess;
	}
	public void setVisitSuccess(String visitSuccess) {
		this.visitSuccess = visitSuccess;
	}
	public String getEnteringCode() {
		return enteringCode;
	}
	public void setEnteringCode(String enteringCode) {
		this.enteringCode = enteringCode;
	}
	public String getEnteringName() {
		return enteringName;
	}
	public void setEnteringName(String enteringName) {
		this.enteringName = enteringName;
	}
	public String getEnteringComcode() {
		return enteringComcode;
	}
	public void setEnteringComcode(String enteringComcode) {
		this.enteringComcode = enteringComcode;
	}
	public String getEnteringTime() {
		return enteringTime;
	}
	public void setEnteringTime(String enteringTime) {
		this.enteringTime = enteringTime;
	}
	public String getClasscode() {
		return classcode;
	}
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getRecorderno() {
		return recorderno;
	}
	public void setRecorderno(String recorderno) {
		this.recorderno = recorderno;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getExistissue() {
		return existissue;
	}
	public void setExistissue(String existissue) {
		this.existissue = existissue;
	}
	public String getVisitnocause() {
		return visitnocause;
	}
	public void setVisitnocause(String visitnocause) {
		this.visitnocause = visitnocause;
	}
	public String getVisitopinion() {
		return visitopinion;
	}
	public void setVisitopinion(String visitopinion) {
		this.visitopinion = visitopinion;
	}
	public String getRegistno() {
		return registno;
	}
	public void setRegistno(String registno) {
		this.registno = registno;
	}
	public String getPolicyno() {
		return policyno;
	}
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}
	public String getComcode() {
		return comcode;
	}
	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
	public String getComcodename() {
		return comcodename;
	}
	public void setComcodename(String comcodename) {
		this.comcodename = comcodename;
	}
	public String getInsuredname() {
		return insuredname;
	}
	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}
	public String getReportdate() {
		return reportdate;
	}
	public void setReportdate(String reportdate) {
		this.reportdate = reportdate;
	}
	public String getCeasedate() {
		return ceasedate;
	}
	public void setCeasedate(String ceasedate) {
		this.ceasedate = ceasedate;
	}
	public String getLicenseno() {
		return licenseno;
	}
	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}
	public String getFlowInTime() {
		return flowInTime;
	}
	public void setFlowInTime(String flowInTime) {
		this.flowInTime = flowInTime;
	}
	public String getCeasetime() {
		return ceasetime;
	}
	public void setCeasetime(String ceasetime) {
		this.ceasetime = ceasetime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
