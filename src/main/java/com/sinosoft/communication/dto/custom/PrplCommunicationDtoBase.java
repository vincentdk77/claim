package com.sinosoft.communication.dto.custom;

import java.io.Serializable;
import java.sql.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;
/**
 * 沟通主表 数据库底层映射类
 * @author chubin 2013-02-18
 *
 */
public class PrplCommunicationDtoBase implements Serializable {
	/** 沟通号码 主键Id（仿照报案号码）  */
	private String communicationNo;
	/** 沟通主题 */
	private String communicationTopic;
	/** 报案号码 */
	private String registNo;
	/** 创建机构代码 */
	private String comCode;
	/** 创建机构名称 */
	private String comName;
	/** 创建人代码 */
	private String userCode;
	/** 创建人名称 */
	private String userName;
	/** 节点代码 */
	private String nodeCode;
	/** 节点名称 */
	private String nodeName;
	/** 任务类型 */
	private String taskType;
	/** 任务名称 */
	private String taskName;
	/** 创建时间 */
	private DateTime createTime = new DateTime();
	/** 关闭日期 */
	private DateTime closeTime  = new DateTime();
	/** 关闭方式 (1:手动关闭,0:结案自动关闭) */
	private String closeMode;
	/** 有效标志 (1:未关闭,0:已关闭)*/
	private String validata;
	
	public PrplCommunicationDtoBase(){}
	
	/** 沟通号码 主键Id（仿照报案号码）  */
	public String getCommunicationNo() {
		return communicationNo;
	}
	/** 沟通号码 主键Id（仿照报案号码）  */
	public void setCommunicationNo(String communicationNo) {
		this.communicationNo = communicationNo;
	}
	/** 沟通主题 */
	public String getCommunicationTopic() {
		return communicationTopic;
	}
	/** 沟通主题 */
	public void setCommunicationTopic(String communicationTopic) {
		this.communicationTopic = communicationTopic;
	}
	/** 报案号码 */
	public String getRegistNo() {
		return registNo;
	}
	/** 报案号码 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	/** 创建机构代码 */
	public String getComCode() {
		return comCode;
	}
	/** 创建机构代码 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	/** 创建人代码 */
	public String getUserCode() {
		return userCode;
	}
	/** 创建人代码 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/** 创建人名称 */
	public String getUserName() {
		return userName;
	}
	/** 创建人名称 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/** 节点代码 */
	public String getNodeCode() {
		return nodeCode;
	}
	/** 节点代码 */
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}
	/** 节点名称 */
	public String getNodeName() {
		return nodeName;
	}
	/** 节点名称 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	/** 创建时间 */
	public DateTime getCreateTime() {
		return createTime;
	}
	/** 创建时间 */
	public void setCreateTime(DateTime createTime) {
		this.createTime = createTime;
	}
	/** 关闭日期 */
	public DateTime getCloseTime() {
		return closeTime;
	}
	/** 关闭日期 */
	public void setCloseTime(DateTime closeTime) {
		this.closeTime = closeTime;
	}
	/** 关闭方式 (1:手动关闭,0:结案自动关闭) */
	public String getCloseMode() {
		return closeMode;
	}
	/** 关闭方式 (1:手动关闭,0:结案自动关闭) */
	public void setCloseMode(String closeMode) {
		this.closeMode = closeMode;
	}
	/** 有效标志 */
	public String getValidata() {
		return validata;
	}
	/** 有效标志 */
	public void setValidata(String validata) {
		this.validata = validata;
	}
	/** 创建机构名称 */
	public String getComName() {
		return comName;
	}
	/** 创建机构名称 */
	public void setComName(String comName) {
		this.comName = comName;
	}
	/** 任务类型 */
	public String getTaskType() {
		return taskType;
	}
	/** 任务类型 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	/** 任务名称 */
	public String getTaskName() {
		return taskName;
	}
	/** 任务名称 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
}
