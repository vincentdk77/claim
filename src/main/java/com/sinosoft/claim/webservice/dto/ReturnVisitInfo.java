package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

public class ReturnVisitInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ҵ��� */
	private String businessNo;
	/** �ڵ����ͣ�sched: �ɹ��ط�, endca: �᰸�طã� */
	private String nodeType;
	/** ���ط��� */
	private String visitName;
	/** �Ƿ�طóɹ�(1:�ɹ�,0:ʧ��) */
	private String visitSuccess;
	/** �ط���ID */
	private String enteringCode;
	/** �ط���Ա */
	private String enteringName;
	/** �ط��˻��� */
	private String enteringComcode;
	/** ¼��ʱ�� */
	private String enteringTime;
	/** ���� */
	private String classcode;
	/** ��ϵ�绰    */ 
	private String contact;
	/** ¼����ˮ��    */ 
	private String recorderno;
	/** ��������ȣ�1�����⣬2��һ�㣬3�������⣩  */ 
	private String service;
	/** �������⣨1��ʱЧ���⣬2������̬�ȣ�3����ͨ���ɣ�4���������飬5���������飬6���⸶����7���������⣩ */ 
	private String existissue;
	/** ���ɹ�ԭ��1���ػ���2��ͨѶ��ʽ�����3���绰���˽�����4���ܾ�͸¶������չ��5��������    */ 
	private String visitnocause;
	/** �ط����    */ 
	private String visitopinion;
	/** ������       */ 
	private String registno;
	/** ������     */ 
	private String policyno;
	/** �б�����    */ 
	private String comcode;
	/** �б���������  */ 
	private String comcodename;
	/** ��������    */ 
	private String insuredname;
	/** ��������   */ 
	private String reportdate;
	/** �᰸ʱ�� */ 
	private String ceasedate;
	/** ���ƺ�   */ 
	private String licenseno;
	/** ����ʱ��    */ 
	private String flowInTime;
	/** ����ʱ��  */ 
	private String ceasetime;
	/** �ط�״̬��0��δ�طã�                                        20���ѻط�δ�ɹ����������21���ѻط�δ�ɹ��������4���ѻط��ѳɹ���*/ 
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
