package com.sinosoft.communication.dto.custom;

import java.io.Serializable;
import java.sql.Date;
/**
 * 沟通意见（子表）
 * @author chubin 2013-02-18
 *
 */
public class PrplCommunicatOpinion implements Serializable {
	
	/** 沟通号码  */
	private String communicationNo;
	/** 沟通意见序号 */
	private String opinionNo;
	/** 沟通人员序号 */
	private String personNo;
	/** 沟通人员人代码 */
	private String userCode;
	/** 沟通人员名称 */
	private String userName;
	/** 处理角色 */
	private String handleRole;
	/** 处理时间 */
	private String handleTime;
	/** 沟通意见 */
	private String communicatOpinion;
	
	
	public PrplCommunicatOpinion(){}
	
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
	public String getHandleTime() {
		return handleTime;
	}

	/** 处理时间 */
	public void setHandleTime(String handleTime) {
		this.handleTime = handleTime;
	}
	/** 沟通意见 */
	public String getCommunicatOpinion() {
		return communicatOpinion;
	}
	/** 沟通意见 */
	public void setCommunicatOpinion(String communicatOpinion) {
		this.communicatOpinion = communicatOpinion;
	}
	
}
