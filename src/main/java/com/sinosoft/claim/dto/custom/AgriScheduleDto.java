package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

public class AgriScheduleDto implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 报案号 */
	private String registNo;
	/** 险种 */
	private String riskCode;
	/** 查勘处理单位代码 */
	private String scheduleObjectID;
	/** 查勘处理单位 */
	private String scheduleObjectName;
	/** 查勘地址 */
	private String checkSite;
	/** 查勘要点提示 */
	private String checkInfo;
	/** 查勘人员代码 */
	private String nextHandlerCode1;
	/** 查勘人员 */
	private String nextHandlerName1;
	/** 定损处理单位代码 */
	private String ItemScheduleObjectID;
	/** 定损处理单位 */
	private String ItemScheduleObjectName;
	/** 定损地址 */
	private String ItemCheckSit;
	/** 联系人名称 */
	private String repairFactoryName;
	/** 报损金额 */
	private String factoryEstimateLoss;
	/** 联系人电话 */
	private String factoryPhone;
	/** 案件状态 */
	private String exigenceGree;
	/** 定损要点提示 */
	private String resultInfo;
	/** 定损人员代码 */
	private String nextHandlerCode;
	/** 定损人员 */
	private String nextHandlerName;
	/** 操作人员代码 */
	private String operatorCode;
	/** 操作人员 */
	private String operatorName;
	/** 操作机构代码 */
	private String makeComCode;
	/** 操作机构 */
	private String makeComName;
	
	private RegistExtDto[] registExtDto;

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getScheduleObjectID() {
		return scheduleObjectID;
	}

	public void setScheduleObjectID(String scheduleObjectID) {
		this.scheduleObjectID = scheduleObjectID;
	}

	public String getScheduleObjectName() {
		return scheduleObjectName;
	}

	public void setScheduleObjectName(String scheduleObjectName) {
		this.scheduleObjectName = scheduleObjectName;
	}

	public String getCheckSite() {
		return checkSite;
	}

	public void setCheckSite(String checkSite) {
		this.checkSite = checkSite;
	}

	public String getCheckInfo() {
		return checkInfo;
	}

	public void setCheckInfo(String checkInfo) {
		this.checkInfo = checkInfo;
	}

	public String getNextHandlerCode1() {
		return nextHandlerCode1;
	}

	public void setNextHandlerCode1(String nextHandlerCode1) {
		this.nextHandlerCode1 = nextHandlerCode1;
	}

	public String getNextHandlerName1() {
		return nextHandlerName1;
	}

	public void setNextHandlerName1(String nextHandlerName1) {
		this.nextHandlerName1 = nextHandlerName1;
	}

	public String getItemScheduleObjectID() {
		return ItemScheduleObjectID;
	}

	public void setItemScheduleObjectID(String itemScheduleObjectID) {
		ItemScheduleObjectID = itemScheduleObjectID;
	}

	public String getItemScheduleObjectName() {
		return ItemScheduleObjectName;
	}

	public void setItemScheduleObjectName(String itemScheduleObjectName) {
		ItemScheduleObjectName = itemScheduleObjectName;
	}

	public String getItemCheckSit() {
		return ItemCheckSit;
	}

	public void setItemCheckSit(String itemCheckSit) {
		ItemCheckSit = itemCheckSit;
	}

	public String getRepairFactoryName() {
		return repairFactoryName;
	}

	public void setRepairFactoryName(String repairFactoryName) {
		this.repairFactoryName = repairFactoryName;
	}

	public String getFactoryEstimateLoss() {
		return factoryEstimateLoss;
	}

	public void setFactoryEstimateLoss(String factoryEstimateLoss) {
		this.factoryEstimateLoss = factoryEstimateLoss;
	}

	public String getFactoryPhone() {
		return factoryPhone;
	}

	public void setFactoryPhone(String factoryPhone) {
		this.factoryPhone = factoryPhone;
	}

	public String getExigenceGree() {
		return exigenceGree;
	}

	public void setExigenceGree(String exigenceGree) {
		this.exigenceGree = exigenceGree;
	}

	public String getResultInfo() {
		return resultInfo;
	}

	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}

	public String getNextHandlerCode() {
		return nextHandlerCode;
	}

	public void setNextHandlerCode(String nextHandlerCode) {
		this.nextHandlerCode = nextHandlerCode;
	}

	public String getNextHandlerName() {
		return nextHandlerName;
	}

	public void setNextHandlerName(String nextHandlerName) {
		this.nextHandlerName = nextHandlerName;
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

	public String getMakeComCode() {
		return makeComCode;
	}

	public void setMakeComCode(String makeComCode) {
		this.makeComCode = makeComCode;
	}

	public String getMakeComName() {
		return makeComName;
	}

	public void setMakeComName(String makeComName) {
		this.makeComName = makeComName;
	}

	public RegistExtDto[] getRegistExtDto() {
		return registExtDto;
	}

	public void setRegistExtDto(RegistExtDto[] registExtDto) {
		this.registExtDto = registExtDto;
	}

}
