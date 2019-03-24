package com.sinosoft.workrove.dto.formbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.struts.action.ActionForm;

import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;

@SuppressWarnings("serial")
public class WorkRoveForm extends ActionForm implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6416762248672060040L;
	
	private String registNo 		="";
	private String swfLogFlowID 	="";
	private String swfLogLogNo		="";
	private String roveTypeHidden	="";
	private String riskcode 		="";
	
	private String handleCode		="";
	private String handleName		="";
	private String handlerCode		="";
	private String handlerName		="";
	private String inputDate		="";
	private String inputHour		="";
	private String operatorCode		="";
	private String operatorName		="";
	private String context			="";
	
	private String comCode			="";
	private String taskCode			="";
	private String lossitemCode		="";

	public String getSwfLogFlowID() {
		return swfLogFlowID;
	}
	public void setSwfLogFlowID(String swfLogFlowID) {
		this.swfLogFlowID = swfLogFlowID;
	}
	public String getSwfLogLogNo() {
		return swfLogLogNo;
	}
	public void setSwfLogLogNo(String swfLogLogNo) {
		this.swfLogLogNo = swfLogLogNo;
	}
	public String getRoveTypeHidden() {
		return roveTypeHidden;
	}
	public void setRoveTypeHidden(String roveTypeHidden) {
		this.roveTypeHidden = roveTypeHidden;
	}
	public String getRiskcode() {
		return riskcode;
	}
	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getHandleCode() {
		return handleCode;
	}
	public void setHandleCode(String handleCode) {
		this.handleCode = handleCode;
	}
	public String getHandleName() {
		return handleName;
	}
	public void setHandleName(String handleName) {
		this.handleName = handleName;
	}
	public String getHandlerCode() {
		return handlerCode;
	}
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}
	public String getHandlerName() {
		return handlerName;
	}
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	public String getInputHour() {
		return inputHour;
	}
	public void setInputHour(String inputHour) {
		this.inputHour = inputHour;
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
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getTaskCode() {
		return taskCode;
	}
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	public String getLossitemCode() {
		return lossitemCode;
	}
	public void setLossitemCode(String lossitemCode) {
		this.lossitemCode = lossitemCode;
	}	
	
}
