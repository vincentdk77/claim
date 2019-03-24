package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
/**
 * 这是第三方数据管理维护中修理厂方的基类
 * 创建于2012/11/9
 */
public class PrpLTripartiteComDtoBase implements Serializable {

	// Fields    
	/** 企业代码 */
	private String enterpriseCode;
	/** 归属结构 */
	private String comCode;
	/**机构名称*/
	private String comCname;
	/** 数据类型 */
	private String enterpriseDateType;
	/** 机构电话	 */
	private String phoneNumber;
	/** 企业中文名称 */
	private String enterpriseCname;
	/** 企业简称 */
	private String enterpriseAbbreviation;
	/** 企业类型 */
	private String enterpriseType;
	/** 企业类型名称 */
	private String enterpriseTypeName;
	/** 企业组织机构代码 */
	private String organizationCode;
	/** 企业法人 */
	private String legalPerson;
	/** 法人电话 */
	private String legalPersonMobileNo;
	/** 省代码 */
	private String provinceCode;
	/** 市代码 */
	private String cityCode;
	/** 详细地址 */
	private String addressDetail;
	/** 企业热线 */
	private String hotLine;
	/** 企业联系人 */
	private String linkerName;
	/** 联系人电话 */
	private String linkerMobileNo;
	/** 联系人邮箱 */
	private String email;
	/** 联系人QQ号码 */
	private String qqNo;
	/** 合作状态 */
	private String agentClaimFlag;
	/** 账户名称*/
	private String accountName;
	/** 省份*/
	private String openProvinceCode;
	/** 城市*/
	private String openCityCode;
	/** 账号属性*/
	private String accountType;
	/** 银行大类 */
	private String bankType;
	/** 银行代码 */
	private String bankCode;
	/** 银行明细 */
	private String bankDetail;
	/** 银行账号 */
	private String bankAccount;
	/** 创建时间 */
	private DateTime createDate = new DateTime();
	/** 创建人代码 */
    private String handlerCode;
    /** 创建人名称 */
    private String handlerCname;
    /** 更新时间 */
    private DateTime updateDate = new DateTime();
    /** 审批时间 */
    private DateTime operateDate = new DateTime();
    /** 审批人代码 */
    private String operateCode;
    /** 审批人名称 */
    private String operateCname;
    /** 处理意见 */
    private String suggestion;
	/** 是否有效 */
	private String validstatus;
	/** 说明（录入说明） */
	private String illustrations;
	/** 审批状态 */
	private String approveFlag;
	/**录入类型标识*/
	private String flag;
	/**营业执照编号*/
	private String buslicenseCode;
	/**税务登记证号*/
	private String taxregistCode;
	/**合作类型*/
	private String cooperationType;
	/**机构联系人*/
	private String comLinkName;
	/**机构联系人手机号码*/
	private String comLinkTel;
	/**区代码*/
	private String townCode;
	/**合作期限起期*/
	private DateTime timeStart = new DateTime();
	/**合作期限止期*/
	private DateTime timeEnd = new DateTime();
	/**执业证号*/
	private String licenseNo;
	/**律师的等级*/
	private String lawyerLevel;
	/**公估机构定损权限*/
	private double amountPower = 0d;
	
	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getLawyerLevel() {
		return lawyerLevel;
	}

	public void setLawyerLevel(String lawyerLevel) {
		this.lawyerLevel = lawyerLevel;
	}

	private TurnPageDto turnPageDto = null;
	private ArrayList<PrpLTripartiteComDto> prpDTripartiteComDtoList;

	//private Set prpdapprovedrules = new HashSet(0);

	// Constructors

	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}

	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}

	public ArrayList<PrpLTripartiteComDto> getPrpDTripartiteComDtoList() {
		return prpDTripartiteComDtoList;
	}

	public void setPrpDTripartiteComDtoList(
			ArrayList<PrpLTripartiteComDto> prpDTripartiteComDtoList) {
		this.prpDTripartiteComDtoList = prpDTripartiteComDtoList;
	}

	public String getApproveFlag() {
		return approveFlag;
	}

	public void setApproveFlag(String approveFlag) {
		this.approveFlag = approveFlag;
	}

	/** default constructor */
	public PrpLTripartiteComDtoBase() {
	}

	// Property accessors
	/** 企业代码 */
	public String getEnterpriseCode() {
		return this.enterpriseCode;
	}
	/** 企业代码 */
	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}
	/** 归属结构 */
	public String getComCode() {
		return this.comCode;
	}
	/** 归属结构 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	/** 数据类型 */
	public String getEnterpriseDateType() {
		return this.enterpriseDateType;
	}
	/** 数据类型 */
	public void setEnterpriseDateType(String enterpriseDateType) {
		this.enterpriseDateType = enterpriseDateType;
	}
	/** 机构电话	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	/** 机构电话	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/** 企业中文名称 */
	public String getEnterpriseCname() {
		return this.enterpriseCname;
	}
	/** 企业中文名称 */
	public void setEnterpriseCname(String enterpriseCname) {
		this.enterpriseCname = enterpriseCname;
	}
	/** 企业简称 */
	public String getEnterpriseAbbreviation() {
		return this.enterpriseAbbreviation;
	}
	/** 企业简称 */
	public void setEnterpriseAbbreviation(String enterpriseAbbreviation) {
		this.enterpriseAbbreviation = enterpriseAbbreviation;
	}
	/** 企业类型 */
	public String getEnterpriseType() {
		return this.enterpriseType;
	}
	/** 企业类型 */
	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	/** 企业类型名称 */
	public String getEnterpriseTypeName() {
		return enterpriseTypeName;
	}
	/** 企业类型名称 */
	public void setEnterpriseTypeName(String enterpriseTypeName) {
		this.enterpriseTypeName = enterpriseTypeName;
	}

	/** 企业组织机构代码 */
	public String getOrganizationCode() {
		return this.organizationCode;
	}
	/** 企业组织机构代码 */
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	/** 企业法人 */
	public String getLegalPerson() {
		return legalPerson;
	}
	/** 企业法人 */
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	/** 法人电话 */
	public String getLegalPersonMobileNo() {
		return legalPersonMobileNo;
	}
	/** 法人电话 */
	public void setLegalPersonMobileNo(String legalPersonMobileNo) {
		this.legalPersonMobileNo = legalPersonMobileNo;
	}
	/** 省代码 */
	public String getProvinceCode() {
		return provinceCode;
	}
	/** 省代码 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	/** 市代码 */
	public String getCityCode() {
		return cityCode;
	}
	/** 市代码 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	/** 详细地址 */
	public String getAddressDetail() {
		return addressDetail;
	}
	/** 详细地址 */
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	/** 企业热线 */
	public String getHotLine() {
		return hotLine;
	}
	/** 企业热线 */
	public void setHotLine(String hotLine) {
		this.hotLine = hotLine;
	}
	/** 企业联系人 */
	public String getLinkerName() {
		return linkerName;
	}
	/** 企业联系人 */
	public void setLinkerName(String linkerName) {
		this.linkerName = linkerName;
	}
	/** 联系人电话 */
	public String getLinkerMobileNo() {
		return linkerMobileNo;
	}
	/** 联系人电话 */
	public void setLinkerMobileNo(String linkerMobileNo) {
		this.linkerMobileNo = linkerMobileNo;
	}
	/** 联系人邮箱 */
	public String getEmail() {
		return email;
	}
	/** 联系人邮箱 */
	public void setEmail(String email) {
		this.email = email;
	}
	/** 联系人QQ号码 */
	public String getQqNo() {
		return qqNo;
	}
	/** 联系人QQ号码 */
	public void setQqNo(String qqNo) {
		this.qqNo = qqNo;
	}
	/** 合作状态 */
	public String getAgentClaimFlag() {
		return agentClaimFlag;
	}
	/** 合作状态 */
	public void setAgentClaimFlag(String agentClaimFlag) {
		this.agentClaimFlag = agentClaimFlag;
	}
	/** 银行大类 */
	public String getBankType() {
		return bankType;
	}
	/** 银行大类 */
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	/** 银行代码 */
	public String getBankCode() {
		return bankCode;
	}
	/** 银行代码 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	/** 银行明细 */
	public String getBankDetail() {
		return bankDetail;
	}
	/** 银行明细 */
	public void setBankDetail(String bankDetail) {
		this.bankDetail = bankDetail;
	}
	/** 银行账号 */
	public String getBankAccount() {
		return bankAccount;
	}
	/** 银行账号 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	/** 创建时间 */
	public DateTime getCreateDate() {
		return createDate;
	}
	/** 创建时间 */
	public void setCreateDate(DateTime teDacreateDatete) {
		this.createDate = teDacreateDatete;
	}
	/** 创建人代码 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/** 创建人代码 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}
	/** 更新时间 */
	public DateTime getUpdateDate() {
		return updateDate;
	}
	/** 更新时间 */
	public void setUpdateDate(DateTime updateDate) {
		this.updateDate = updateDate;
	}
	/** 审批时间 */
	public DateTime getOperateDate() {
		return operateDate;
	}
	/** 审批时间 */
	public void setOperateDate(DateTime eDate) {
		this.operateDate = operateDate;
	}
	/** 审批人 */
	public String getOperateCode() {
		return operateCode;
	}
	/** 审批人 */
	public void setOperateCode(String operateCode) {
		this.operateCode = operateCode;
	}
	/** 处理意见 */
	public String getSuggestion() {
		return suggestion;
	}
	/** 处理意见 */
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	/** 是否有效 */
	public String getValidstatus() {
		return validstatus;
	}
	/** 是否有效 */
	public void setValidstatus(String validstatus) {
		this.validstatus = validstatus;
	}
	/** 说明（录入说明） */
	public String getIllustrations() {
		return illustrations;
	}
	/** 说明（录入说明） */
	public void setIllustrations(String illustrations) {
		this.illustrations = illustrations;
	}

	/**toString */
	@Override
	public String toString(){
		return "企业代码:"+enterpriseCode+" 归属结构:"+comCode+" 数据类型 :"+enterpriseDateType+
		" 机构电话:"+phoneNumber+" 企业中文名称:"+enterpriseCname+" 企业简称:"+enterpriseAbbreviation+
		" 企业类型:"+enterpriseType+" 企业组织机构代码:"+organizationCode+" 企业法人:"+legalPerson+
		" 法人电话:"+legalPersonMobileNo+" 省代码:"+provinceCode+" 市代码:"+cityCode+
		" 详细地址:"+addressDetail+" 企业热线:"+hotLine+" 企业联系人:"+linkerName+
		" 联系人电话:"+linkerMobileNo+" 联系人邮箱:"+email+" 联系人QQ号码:"+qqNo+" 合作状态:"+agentClaimFlag+
		" 银行大类:"+bankType+" 银行代码:"+bankCode+" 银行明细:"+bankDetail+" 银行账号:"+bankAccount+
		" 创建时间:"+createDate+" 创建人代码:"+handlerCode+" 更新时间:"+updateDate+" 审批时间:"+operateDate+
		" 审批人:"+operateCode+" 处理意见:"+suggestion+" 是否有效:"+validstatus;
	}

	public String getComCname() {
		return comCname;
	}

	public void setComCname(String comCname) {
		this.comCname = comCname;
	}

	public String getHandlerCname() {
		return handlerCname;
	}

	public void setHandlerCname(String handlerCname) {
		this.handlerCname = handlerCname;
	}

	public String getOperateCname() {
		return operateCname;
	}

	public void setOperateCname(String operateCname) {
		this.operateCname = operateCname;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getBuslicenseCode() {
		return buslicenseCode;
	}

	public void setBuslicenseCode(String buslicenseCode) {
		this.buslicenseCode = buslicenseCode;
	}

	public String getTaxregistCode() {
		return taxregistCode;
	}

	public void setTaxregistCode(String taxregistCode) {
		this.taxregistCode = taxregistCode;
	}

	public String getCooperationType() {
		return cooperationType;
	}

	public void setCooperationType(String cooperationType) {
		this.cooperationType = cooperationType;
	}

	public String getComLinkName() {
		return comLinkName;
	}

	public void setComLinkName(String comLinkName) {
		this.comLinkName = comLinkName;
	}

	public String getComLinkTel() {
		return comLinkTel;
	}

	public void setComLinkTel(String comLinkTel) {
		this.comLinkTel = comLinkTel;
	}

	public String getTownCode() {
		return townCode;
	}

	public void setTownCode(String townCode) {
		this.townCode = townCode;
	}

	public DateTime getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(DateTime timeStart) {
		this.timeStart = timeStart;
	}

	public DateTime getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(DateTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getOpenProvinceCode() {
		return openProvinceCode;
	}

	public void setOpenProvinceCode(String openProvinceCode) {
		this.openProvinceCode = openProvinceCode;
	}

	public String getOpenCityCode() {
		return openCityCode;
	}

	public void setOpenCityCode(String openCityCode) {
		this.openCityCode = openCityCode;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAmountPower() {
		return amountPower;
	}

	public void setAmountPower(double amountPower) {
		this.amountPower = amountPower;
	}
	
}
