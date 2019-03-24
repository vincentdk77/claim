package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

public class PropScheduleDto implements Serializable {
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
