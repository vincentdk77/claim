package com.sinosoft.communication.dto.custom;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;
/**
 * 沟通意见（子表）
 * @author chubin 2013-02-18
 *
 */
public class PrplCommunicatOpinionDtoBase implements Serializable {
	/** 沟通号码  */
	private String communicationNo;
	/** 沟通意见序号 */
	private String opinionNo;
	/** 沟通人员序号 */
	private String personNo;
	/** 处理机构代码 */
	private String comCode;
	/** 处理机构名称 */
	private String comCName;
	/** 沟通人员人代码 */
	private String userCode;
	/** 沟通人员名称 */
	private String userName;
	/** 处理角色 */
	private String handleRole;
	/** 处理时间 */
	private DateTime handleTime = new DateTime();
	/** 沟通意见 */
	private String direction;
	/** 占用时间 */
	private String aboveTime;
	/** 处理意见 */
	private String handleOpinion;
	
	
	public PrplCommunicatOpinionDtoBase(){}
	
	/** 沟通号码  */
	public String getCommunicationNo() {
		return communicationNo;
	}
	/** 沟通号码   */
	public void setCommunicationNo(String communicationNo) {
		this.communicationNo = communicationNo;
	}
	
	/** 沟通意见序号  */
	public String getOpinionNo() {
		return opinionNo;
	}
	
	/** 沟通意见序号  */
	public void setOpinionNo(String opinionNo) {
		this.opinionNo = opinionNo;
	}

	/** 沟通人员序号  */
	public String getPersonNo() {
		return personNo;
	}
	
	/** 沟通人员序号  */
	public void setPersonNo(String personNo) {
		this.personNo = personNo;
	}
	/** 处理机构代码 */
	public String getComCode() {
		return comCode;
	}
	/** 处理机构代码 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	/** 处理机构名称 */
	public String getComCName() {
		return comCName;
	}
	/** 处理机构名称 */
	public void setComCName(String comCName) {
		this.comCName = comCName;
	}

	/** 沟通人员代码 */
	public String getUserCode() {
		return userCode;
	}
	/** 沟通人员代码 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/** 沟通人员名称 */
	public String getUserName() {
		return userName;
	}
	/** 沟通人员名称 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/** 处理角色 */
	public String getHandleRole() {
		return handleRole;
	}
	/** 处理角色 */
	public void setHandleRole(String handleRole) {
		this.handleRole = handleRole;
	}
	/** 处理时间 */
	public DateTime getHandleTime() {
		return handleTime;
	}

	/** 处理时间 */
	public void setHandleTime(DateTime handleTime) {
		this.handleTime = handleTime;
	}
	/** 沟通说明 */
	public String getDirection() {
		return direction;
	}
	/** 沟通说明 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	/** 占用时间 */
	public String getAboveTime() {
		return aboveTime;
	}
	/** 占用时间 */
	public void setAboveTime(String aboveTime) {
		this.aboveTime = aboveTime;
	}
	/** 处理意见 */
	public String getHandleOpinion() {
		return handleOpinion;
	}
	/** 处理意见 */
	public void setHandleOpinion(String handleOpinion) {
		this.handleOpinion = handleOpinion;
	}
}
