package com.sinosoft.communication.dto.custom;

import java.io.Serializable;
import java.sql.Date;
/**
 * 沟通人员（子表）
 * @author chubin 2013-02-18
 *
 */
public class PrplCommunicatPerson implements Serializable {
	
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
	private Date createTime;
	/** 有效标志 */
	private String validata;
	
	public PrplCommunicatPerson(){}
	
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
	public Date getCreateTime() {
		return createTime;
	}
	/** 添加日期 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/** 有效标志 */
	public String getValidata() {
		return validata;
	}
	/** 有效标志 */
	public void setValidata(String validata) {
		this.validata = validata;
	}
}
