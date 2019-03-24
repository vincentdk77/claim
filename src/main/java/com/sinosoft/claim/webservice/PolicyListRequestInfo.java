package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class PolicyListRequestInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 保单号 */
	private String policyNo;
	/**保单号查询条件标志*/
	private String policyNoFlag;
	/** 被保险人名称 */
	private String insuredName;
	/** 身份证号 */
	private String identifyNumber;
	/** 身份证号查询条件标志 */
	private String identifyNumberFlag;
	/** 保险起期 */
	private String startDate;
	/** 保险止期 */
	private String endDate;
	/** 险种大类 */
	private String riskType;
	/** 原保单号 */
	private String oldPolicyNo;
	/** 保单流水号 */
	private String policyNoPrintNo;
	/** 耳标号：(中央政策性养殖险专用) */
	private String earLabel;
	/** 耳标号查询条件标志：(中央政策性养殖险专用) “=”为精确查询，“*”为模糊查询 默认为模糊查询 **/
	private String earLabelFlag;
	/** 农户姓名：(中央政策性养殖险专用) */
	private String fname;
	/** 身份证号：(种植险专用) */
	private String fCardID;
	/** 身份证号查询条件标志：(种植险专用)*/
	private String  fCardIDFlag;
	/** 农户姓名：(种植险专用) */
	private String fname1;
	/** 户编号：(农家福组合保险专用) */
	private String familyNo;
	/** 户编号查询条件标志：(农家福组合保险专用) */
	private String familyNoFlag;
	/** 户主身份证号：(农家福组合保险专用) */
	private String familyFIDCard;
	/** 户主身份证号查询条件标志 ：(农家福组合保险专用)*/
	private String familyFIDCardFlag;
	/** 姓名：（旅行意外伤害险专用） */
	private String insuredName_2743;
	/** 身份证号：（旅行意外伤害险专用） */
	private String identifyNumber_2743;
	/** 身份证号查询条件标志：（旅行意外伤害险专用） */
	private String identifyNumber_2743Flag;
	/** 针对农房险的个性化处理 */
	private String identifyNumberSign_0310;
	/**农房查询条件标志*/
	private String identifyNumberSign_0310Flag;
	/** 行政区域代码 */
	private String areasCode;
	/** 操作人员 */
	private String userCode;
	/** 操作机构 */
	private String comCode;
	/** 当前页数 */
	private int pageNo;
	/** 每页条数 默认显示20条 */
	private int recordPerPage;
	/** 身份证号：（团体人身意外伤害保险专用） */
	private String identifyNumber_2714;
	/** 归属区域标记 */
	private String areaFlag;//0，代表老归属区域 1，代表新归属区域
    /** 归属区域层级 */
	private String areaLevel;
	

	public String getIdentifyNumber_2714() {
		return identifyNumber_2714;
	}

	public void setIdentifyNumber_2714(String identifyNumber_2714) {
		this.identifyNumber_2714 = identifyNumber_2714;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getIdentifyNumber() {
		return identifyNumber;
	}

	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public String getOldPolicyNo() {
		return oldPolicyNo;
	}

	public void setOldPolicyNo(String oldPolicyNo) {
		this.oldPolicyNo = oldPolicyNo;
	}

	public String getPolicyNoPrintNo() {
		return policyNoPrintNo;
	}

	public void setPolicyNoPrintNo(String policyNoPrintNo) {
		this.policyNoPrintNo = policyNoPrintNo;
	}

	public String getEarLabel() {
		return earLabel;
	}

	public void setEarLabel(String earLabel) {
		this.earLabel = earLabel;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFCardID() {
		return fCardID;
	}

	public void setFCardID(String cardID) {
		fCardID = cardID;
	}

	public String getFname1() {
		return fname1;
	}

	public void setFname1(String fname1) {
		this.fname1 = fname1;
	}

	public String getFamilyNo() {
		return familyNo;
	}

	public void setFamilyNo(String familyNo) {
		this.familyNo = familyNo;
	}

	public String getFamilyFIDCard() {
		return familyFIDCard;
	}

	public void setFamilyFIDCard(String familyFIDCard) {
		this.familyFIDCard = familyFIDCard;
	}

	public String getInsuredName_2743() {
		return insuredName_2743;
	}

	public void setInsuredName_2743(String insuredName_2743) {
		this.insuredName_2743 = insuredName_2743;
	}

	public String getIdentifyNumber_2743() {
		return identifyNumber_2743;
	}

	public void setIdentifyNumber_2743(String identifyNumber_2743) {
		this.identifyNumber_2743 = identifyNumber_2743;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	public String getIdentifyNumberSign_0310() {
		return identifyNumberSign_0310;
	}

	public void setIdentifyNumberSign_0310(String identifyNumberSign_0310) {
		this.identifyNumberSign_0310 = identifyNumberSign_0310;
	}

	public String getAreasCode() {
		return areasCode;
	}

	public void setAreasCode(String areasCode) {
		this.areasCode = areasCode;
	}

	public String getPolicyNoFlag() {
		return policyNoFlag;
	}

	public void setPolicyNoFlag(String policyNoFlag) {
		this.policyNoFlag = policyNoFlag;
	}

	public String getIdentifyNumberFlag() {
		return identifyNumberFlag;
	}

	public void setIdentifyNumberFlag(String identifyNumberFlag) {
		this.identifyNumberFlag = identifyNumberFlag;
	}

	public String getFCardIDFlag() {
		return fCardIDFlag;
	}

	public void setFCardIDFlag(String cardIDFlag) {
		fCardIDFlag = cardIDFlag;
	}

	public String getFamilyNoFlag() {
		return familyNoFlag;
	}

	public void setFamilyNoFlag(String familyNoFlag) {
		this.familyNoFlag = familyNoFlag;
	}

	public String getFamilyFIDCardFlag() {
		return familyFIDCardFlag;
	}

	public void setFamilyFIDCardFlag(String familyFIDCardFlag) {
		this.familyFIDCardFlag = familyFIDCardFlag;
	}

	public String getIdentifyNumber_2743Flag() {
		return identifyNumber_2743Flag;
	}

	public void setIdentifyNumber_2743Flag(String identifyNumber_2743Flag) {
		this.identifyNumber_2743Flag = identifyNumber_2743Flag;
	}

	public String getIdentifyNumberSign_0310Flag() {
		return identifyNumberSign_0310Flag;
	}

	public void setIdentifyNumberSign_0310Flag(String identifyNumberSign_0310Flag) {
		this.identifyNumberSign_0310Flag = identifyNumberSign_0310Flag;
	}

	public String getEarLabelFlag() {
		return earLabelFlag;
	}

	public void setEarLabelFlag(String earLabelFlag) {
		this.earLabelFlag = earLabelFlag;
	}

	public String getAreaFlag() {
		return areaFlag;
	}

	public void setAreaFlag(String areaFlag) {
		this.areaFlag = areaFlag;
	}

	public String getAreaLevel() {
		return areaLevel;
	}

	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
	}
	
	
}
