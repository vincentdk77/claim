package com.sinosoft.communication.dto.custom;

import java.io.Serializable;
import java.sql.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * 沟通人员（子表）
 * @author chubin 2013-02-18
 *
 */
public class PrplCommunicatPersonDtoBase implements Serializable {
	/** 沟通号码 沟通主表主键Id  */
	private String communicationNo;
	/** 沟通人员序号 */
	private String personNo;
	/** 沟通人员机构代码 */
	private String comCode;
	/** 沟通人员人代码 */
	private String userCode;
	/** 沟通人员名称 */
	private String userName;
	/** 添加日期 */
	private DateTime createTime = new DateTime();
	/** 沟通人标志（1:沟通回复人，2:沟通发起人） */
	private String validata;
	/** 沟通状态 (0:待处理,1:已处理,2:需跟踪) */
	private String communicationFlag;
	
	public PrplCommunicatPersonDtoBase(){}
	
	/** 沟通号码  */
	public String getCommunicationNo() {
		return communicationNo;
	}
	/** 沟通号码   */
	public void setCommunicationNo(String communicationNo) {
		this.communicationNo = communicationNo;
	}
	
	/** 沟通人员序号  */
	public String getPersonNo() {
		return personNo;
	}
	
	/** 沟通人员序号  */
	public void setPersonNo(String personNo) {
		this.personNo = personNo;
	}

	/** 沟通人员机构代码 */
	public String getComCode() {
		return comCode;
	}
	/** 沟通人员机构代码 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
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
	
	/** 添加日期 */
	public DateTime getCreateTime() {
		return createTime;
	}
	/** 添加日期 */
	public void setCreateTime(DateTime createTime) {
		this.createTime = createTime;
	}
	
	/** 沟通人标志（1:沟通回复人，2:沟通发起人） */
	public String getValidata() {
		return validata;
	}
	/** 沟通人标志（1:沟通回复人，2:沟通发起人） */
	public void setValidata(String validata) {
		this.validata = validata;
	}
	/**沟通状态 (0:待处理,1:已处理,2:需跟踪)*/
	public String getCommunicationFlag() {
		return communicationFlag;
	}
	/**沟通状态 (0:待处理,1:已处理,2:需跟踪)*/
	public void setCommunicationFlag(String communicationFlag) {
		this.communicationFlag = communicationFlag;
	}
	
}
