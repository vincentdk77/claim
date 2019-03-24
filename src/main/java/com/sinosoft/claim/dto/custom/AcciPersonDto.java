package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

public class AcciPersonDto implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 序号 */
	private String serialNo;
	/** 事故者序号 */
	private String familyNo;
	/** 事故者编码 */
	private String acciCode;
	/** 事故者姓名 */
	private String acciName;
	/** 事故者性别 1：男 2：女 */
	private String sex;
	/** 事故者年龄 */
	private String age;
	/** 身份证号 */
	private String identifyNumber;

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getFamilyNo() {
		return familyNo;
	}

	public void setFamilyNo(String familyNo) {
		this.familyNo = familyNo;
	}

	public String getAcciCode() {
		return acciCode;
	}

	public void setAcciCode(String acciCode) {
		this.acciCode = acciCode;
	}

	public String getAcciName() {
		return acciName;
	}

	public void setAcciName(String acciName) {
		this.acciName = acciName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getIdentifyNumber() {
		return identifyNumber;
	}

	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}

}
