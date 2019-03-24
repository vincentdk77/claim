package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class PrpCinsuredDtoInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 个单是序列号，团单是familyno */
	private String familyno;
	/** 分户姓名 */
	private String insuredName;
	/** 分户性别 */
	private String sex;
	/** 分户年龄 */
	private String age;
	/** 分户身份证号 */
	private String identifyNumber;
	/** 分户代码，是团单没有此值，个单有此值 */
	private String insuredCode;

	public String getFamilyno() {
		return familyno;
	}

	public void setFamilyno(String familyno) {
		this.familyno = familyno;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
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

	public String getInsuredCode() {
		return insuredCode;
	}

	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
	}

}
