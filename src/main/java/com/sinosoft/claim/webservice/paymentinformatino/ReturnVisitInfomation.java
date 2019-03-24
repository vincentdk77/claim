package com.sinosoft.claim.webservice.paymentinformatino;

import java.io.Serializable;

public class ReturnVisitInfomation implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 是否回访成功(1:成功,0:失败,01:失败需跟进，00: 失败无需跟进) */
	private String visitSuccess;
	/** 回访人ID */
	private String enteringCode;
	/** 回访人员 */
	private String enteringName;
	/** 回访人机构 */
	private String enteringComcode;
	/** 录入时间 */
	private String enteringTime;
	/** 联系电话    */ 
	private String contact;
	/** 录音流水号    */ 
	private String recorderno;
	/** 服务满意度（1：满意，2：一般，3：不满意）  */ 
	private String service;
	/** 存在问题（1：时效问题，2：服务态度，3：沟通技巧，4：定损争议，5：人伤争议，6：赔付争议7：其它问题）多选用”;”隔开 */ 
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
	
	
	
}
