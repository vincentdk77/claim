package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
/**
 * ���ǵ��������ݹ���ά�����������Ļ���
 * ������2012/11/9
 */
public class PrpLTripartiteComDtoBase implements Serializable {

	// Fields    
	/** ��ҵ���� */
	private String enterpriseCode;
	/** �����ṹ */
	private String comCode;
	/**��������*/
	private String comCname;
	/** �������� */
	private String enterpriseDateType;
	/** �����绰	 */
	private String phoneNumber;
	/** ��ҵ�������� */
	private String enterpriseCname;
	/** ��ҵ��� */
	private String enterpriseAbbreviation;
	/** ��ҵ���� */
	private String enterpriseType;
	/** ��ҵ�������� */
	private String enterpriseTypeName;
	/** ��ҵ��֯�������� */
	private String organizationCode;
	/** ��ҵ���� */
	private String legalPerson;
	/** ���˵绰 */
	private String legalPersonMobileNo;
	/** ʡ���� */
	private String provinceCode;
	/** �д��� */
	private String cityCode;
	/** ��ϸ��ַ */
	private String addressDetail;
	/** ��ҵ���� */
	private String hotLine;
	/** ��ҵ��ϵ�� */
	private String linkerName;
	/** ��ϵ�˵绰 */
	private String linkerMobileNo;
	/** ��ϵ������ */
	private String email;
	/** ��ϵ��QQ���� */
	private String qqNo;
	/** ����״̬ */
	private String agentClaimFlag;
	/** �˻�����*/
	private String accountName;
	/** ʡ��*/
	private String openProvinceCode;
	/** ����*/
	private String openCityCode;
	/** �˺�����*/
	private String accountType;
	/** ���д��� */
	private String bankType;
	/** ���д��� */
	private String bankCode;
	/** ������ϸ */
	private String bankDetail;
	/** �����˺� */
	private String bankAccount;
	/** ����ʱ�� */
	private DateTime createDate = new DateTime();
	/** �����˴��� */
    private String handlerCode;
    /** ���������� */
    private String handlerCname;
    /** ����ʱ�� */
    private DateTime updateDate = new DateTime();
    /** ����ʱ�� */
    private DateTime operateDate = new DateTime();
    /** �����˴��� */
    private String operateCode;
    /** ���������� */
    private String operateCname;
    /** ������� */
    private String suggestion;
	/** �Ƿ���Ч */
	private String validstatus;
	/** ˵����¼��˵���� */
	private String illustrations;
	/** ����״̬ */
	private String approveFlag;
	/**¼�����ͱ�ʶ*/
	private String flag;
	/**Ӫҵִ�ձ��*/
	private String buslicenseCode;
	/**˰��Ǽ�֤��*/
	private String taxregistCode;
	/**��������*/
	private String cooperationType;
	/**������ϵ��*/
	private String comLinkName;
	/**������ϵ���ֻ�����*/
	private String comLinkTel;
	/**������*/
	private String townCode;
	/**������������*/
	private DateTime timeStart = new DateTime();
	/**��������ֹ��*/
	private DateTime timeEnd = new DateTime();
	/**ִҵ֤��*/
	private String licenseNo;
	/**��ʦ�ĵȼ�*/
	private String lawyerLevel;
	/**������������Ȩ��*/
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
	/** ��ҵ���� */
	public String getEnterpriseCode() {
		return this.enterpriseCode;
	}
	/** ��ҵ���� */
	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}
	/** �����ṹ */
	public String getComCode() {
		return this.comCode;
	}
	/** �����ṹ */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	/** �������� */
	public String getEnterpriseDateType() {
		return this.enterpriseDateType;
	}
	/** �������� */
	public void setEnterpriseDateType(String enterpriseDateType) {
		this.enterpriseDateType = enterpriseDateType;
	}
	/** �����绰	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	/** �����绰	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/** ��ҵ�������� */
	public String getEnterpriseCname() {
		return this.enterpriseCname;
	}
	/** ��ҵ�������� */
	public void setEnterpriseCname(String enterpriseCname) {
		this.enterpriseCname = enterpriseCname;
	}
	/** ��ҵ��� */
	public String getEnterpriseAbbreviation() {
		return this.enterpriseAbbreviation;
	}
	/** ��ҵ��� */
	public void setEnterpriseAbbreviation(String enterpriseAbbreviation) {
		this.enterpriseAbbreviation = enterpriseAbbreviation;
	}
	/** ��ҵ���� */
	public String getEnterpriseType() {
		return this.enterpriseType;
	}
	/** ��ҵ���� */
	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	/** ��ҵ�������� */
	public String getEnterpriseTypeName() {
		return enterpriseTypeName;
	}
	/** ��ҵ�������� */
	public void setEnterpriseTypeName(String enterpriseTypeName) {
		this.enterpriseTypeName = enterpriseTypeName;
	}

	/** ��ҵ��֯�������� */
	public String getOrganizationCode() {
		return this.organizationCode;
	}
	/** ��ҵ��֯�������� */
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	/** ��ҵ���� */
	public String getLegalPerson() {
		return legalPerson;
	}
	/** ��ҵ���� */
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	/** ���˵绰 */
	public String getLegalPersonMobileNo() {
		return legalPersonMobileNo;
	}
	/** ���˵绰 */
	public void setLegalPersonMobileNo(String legalPersonMobileNo) {
		this.legalPersonMobileNo = legalPersonMobileNo;
	}
	/** ʡ���� */
	public String getProvinceCode() {
		return provinceCode;
	}
	/** ʡ���� */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	/** �д��� */
	public String getCityCode() {
		return cityCode;
	}
	/** �д��� */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	/** ��ϸ��ַ */
	public String getAddressDetail() {
		return addressDetail;
	}
	/** ��ϸ��ַ */
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	/** ��ҵ���� */
	public String getHotLine() {
		return hotLine;
	}
	/** ��ҵ���� */
	public void setHotLine(String hotLine) {
		this.hotLine = hotLine;
	}
	/** ��ҵ��ϵ�� */
	public String getLinkerName() {
		return linkerName;
	}
	/** ��ҵ��ϵ�� */
	public void setLinkerName(String linkerName) {
		this.linkerName = linkerName;
	}
	/** ��ϵ�˵绰 */
	public String getLinkerMobileNo() {
		return linkerMobileNo;
	}
	/** ��ϵ�˵绰 */
	public void setLinkerMobileNo(String linkerMobileNo) {
		this.linkerMobileNo = linkerMobileNo;
	}
	/** ��ϵ������ */
	public String getEmail() {
		return email;
	}
	/** ��ϵ������ */
	public void setEmail(String email) {
		this.email = email;
	}
	/** ��ϵ��QQ���� */
	public String getQqNo() {
		return qqNo;
	}
	/** ��ϵ��QQ���� */
	public void setQqNo(String qqNo) {
		this.qqNo = qqNo;
	}
	/** ����״̬ */
	public String getAgentClaimFlag() {
		return agentClaimFlag;
	}
	/** ����״̬ */
	public void setAgentClaimFlag(String agentClaimFlag) {
		this.agentClaimFlag = agentClaimFlag;
	}
	/** ���д��� */
	public String getBankType() {
		return bankType;
	}
	/** ���д��� */
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	/** ���д��� */
	public String getBankCode() {
		return bankCode;
	}
	/** ���д��� */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	/** ������ϸ */
	public String getBankDetail() {
		return bankDetail;
	}
	/** ������ϸ */
	public void setBankDetail(String bankDetail) {
		this.bankDetail = bankDetail;
	}
	/** �����˺� */
	public String getBankAccount() {
		return bankAccount;
	}
	/** �����˺� */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	/** ����ʱ�� */
	public DateTime getCreateDate() {
		return createDate;
	}
	/** ����ʱ�� */
	public void setCreateDate(DateTime teDacreateDatete) {
		this.createDate = teDacreateDatete;
	}
	/** �����˴��� */
	public String getHandlerCode() {
		return handlerCode;
	}
	/** �����˴��� */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}
	/** ����ʱ�� */
	public DateTime getUpdateDate() {
		return updateDate;
	}
	/** ����ʱ�� */
	public void setUpdateDate(DateTime updateDate) {
		this.updateDate = updateDate;
	}
	/** ����ʱ�� */
	public DateTime getOperateDate() {
		return operateDate;
	}
	/** ����ʱ�� */
	public void setOperateDate(DateTime eDate) {
		this.operateDate = operateDate;
	}
	/** ������ */
	public String getOperateCode() {
		return operateCode;
	}
	/** ������ */
	public void setOperateCode(String operateCode) {
		this.operateCode = operateCode;
	}
	/** ������� */
	public String getSuggestion() {
		return suggestion;
	}
	/** ������� */
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	/** �Ƿ���Ч */
	public String getValidstatus() {
		return validstatus;
	}
	/** �Ƿ���Ч */
	public void setValidstatus(String validstatus) {
		this.validstatus = validstatus;
	}
	/** ˵����¼��˵���� */
	public String getIllustrations() {
		return illustrations;
	}
	/** ˵����¼��˵���� */
	public void setIllustrations(String illustrations) {
		this.illustrations = illustrations;
	}

	/**toString */
	@Override
	public String toString(){
		return "��ҵ����:"+enterpriseCode+" �����ṹ:"+comCode+" �������� :"+enterpriseDateType+
		" �����绰:"+phoneNumber+" ��ҵ��������:"+enterpriseCname+" ��ҵ���:"+enterpriseAbbreviation+
		" ��ҵ����:"+enterpriseType+" ��ҵ��֯��������:"+organizationCode+" ��ҵ����:"+legalPerson+
		" ���˵绰:"+legalPersonMobileNo+" ʡ����:"+provinceCode+" �д���:"+cityCode+
		" ��ϸ��ַ:"+addressDetail+" ��ҵ����:"+hotLine+" ��ҵ��ϵ��:"+linkerName+
		" ��ϵ�˵绰:"+linkerMobileNo+" ��ϵ������:"+email+" ��ϵ��QQ����:"+qqNo+" ����״̬:"+agentClaimFlag+
		" ���д���:"+bankType+" ���д���:"+bankCode+" ������ϸ:"+bankDetail+" �����˺�:"+bankAccount+
		" ����ʱ��:"+createDate+" �����˴���:"+handlerCode+" ����ʱ��:"+updateDate+" ����ʱ��:"+operateDate+
		" ������:"+operateCode+" �������:"+suggestion+" �Ƿ���Ч:"+validstatus;
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
