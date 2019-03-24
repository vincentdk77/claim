package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

public class ClaimRequestInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** ���Կͻ��˱�����ˮ�� */
	private String outRigstNo = "";
	/** ��������ʱ�� */
	private Date inputDate = new Date();
	/** ���Ա������� */
	private String policyno = "";
	/** ���Ա������� */
	private String registno = "";
	/** ������������ */
	private String claimno = "";
	/** �����¹�����(yyyy-MM-dd) */
	private Date damageStartDate = new Date();
	/** �����¹�ʱ��(00:00) */
	private String damageStartHour = "";
	/** �����¹�ԭ�� */
	private String damageCode = "";
	/** ���Ա����� */
	private String reportName = "";
	/** ���Ա���ʱ��(yyyy-MM-dd) */
	private Date reportDate = new Date();
	/** ���Ա���ʱ��(00:00) */
	private String reportHour = "";
	/** ���Ա�����ʽ */
	private String reportType = "";
	/** ������ϵ�� */
	private String linkerName = "";
	/** ������ϵ�绰 */
	private String phoneNumber = "";
	/** ������ϵ��ַ */
	private String linkerAddress = "";
	/** �������¹��߹�ϵ */
	private String clauseType = "";
	/** �����¹ʵص� */
	private String damageAddress = "";
	/** �����¹����� */
	private String damageTypeCode = "";
	/** �����⸶�˴Σ�Ĭ��Ϊ0 */
	private double lossesNumber = 0D;
	/** ���Բ����˴��� */
	private String operatorCode = "";
	/** ���Բ��������� */
	private String operatorName = "";
	/** �������⴦����� */
	private String makeCom = "";
	/** ���Դ���������� */
	private String makeComName = "";
	/** ���Ա�������¼ */
	private String remark = "";
	/** �����¹ʾ������¹���״ */
	private String context = "";
	/** ���Ա�����CNY */
	private double estimateLoss = 0D;
	/** ���Ե��Ȳ鿱����λ */
	private String scheduleObjectId = "";
	/** ���Բ鿱��ַ */
	private String checkSite = "";
	/** ���Բ鿱Ҫ�� */
	private String checkInfo = "";
	/** ���Բ鿱�˴��� */
	private String nextHandlerCode = "";
	/** ���Բ鿱������ */
	private String nextHandlerName = "";
	/** ���Բ鿱��2 */
	private String checker2 = "";
	/** ���Բ鿱����(�鿱L����D) */
	private String checkType = "";
	/** ���Բ鿱����(yyyy-MM-dd) */
	private Date checkDate = new Date();
	/** ���Բ鿱����(�ֳ�1����9) */
	private String checkNature = "";
	/** ���Բ鿱Ԥ�����CNY */
	private double checkEstimateLoss = 0D;
	/** ����Ԥ������ */
	private double estimateFee = 0D;
	/** ���Բ鿱����λ(��1����0) */
	private String unitType = "";
	/** ���Բ鿱��ע */
	private String checkRemark = "";
	/** ���Բ鿱���� */
	private String checkContext = "";
	/** ���Աұ�Ĭ��CNY */
	private String currency = "";
	/** �����¹��������� */
	private String damageTypeName = "";
	/** �����Ƿ����׷��(��1����0) */
	private String replevyFlag = "";
	/** �����Ƿ����������н�:��1��0 */
	private String thirdComFlag = "";
	/** �������������� */
	private double sumClaim = 0D;
	/** ���԰������ʹ��� */
	private String claimType = "";
	/** ��������Ԥ���ⰸ����ѡ�� */
	private String caseType = "";
	/** ����Ԥ������ԭ�� */
	private String payAppContext = "";
	/** ����Ԥ���Ĭ��0.00 */
	private double sumPrePaid = 0D;
	/** ����Ԥ�ⱨ�� */
	private String prepayReport = "";
	/** ���Ե�֤����������� */
	private String certifyContext = "";
	/** ���Ա������˿������� */
	private String bank = "";
	/** �����տ���ȫ�� */
	private String receiverName = "";
	/** ���Կ����˺� */
	private String account = "";
	/** ����ȷ�Ͽ����˺� */
	private String accountOK = "";
	/** �������⸶ԭ�� */
	private String zeroLossType = "";
	/** ���Է��úϼƣ�Ĭ��0.00 */
	private double sumNoDutyFee = 0D;
	/** �������ϼƣ�Ĭ��0.00 */
	private double prplCompensateSumPaid = 0D;
	/** ������Ԥ����Ĭ��0.00 */
	private double prplCompensateSumPrePaid = 0D;
	/** ������Ԥ�����ã�Ĭ��0.00 */
	private double sumChargePaid = 0D;
	/** ���Ա��θ�����Ĭ��0.00 */
	private double sumThisPaid = 0D;
	/** ������������� */
	private String compeContext = "";
	/** ��������Ƭ�� */
	private String notion = "";
	/** ���Ժ���ǩ����� */
	private String handleText = "";
	/** ���Կͻ����������� */
    private String outId = "";
    /** ���Ա���ʱ�� */
    private Date registTime = new Date();
    /** ��������ʱ�� */
    private Date compeTime = new Date();
    /** ���Ժ���ʱ�� */
    private Date vericTime = new Date();
    /** ���Ա��������˴��� */
    private String registUser = "";
    /** �������������˴��� */
    private String compeUser = "";
    /** ���Ժ�������˴��� */
    private String vericUser = "";
	/** �����¹�����Ϣ */
	private AccidentPersonInfoDto[] accidentPersonInfoDto;
	/** ���Ե��Ȳ���˵����Ϣ */
	private SchedExtInfoDto[] schedExtInfoDto;
	/** ��������������������Ϣ */
	private ClaimAppDto[] claimAppDto;
	/** ���������ձ��������Ϣ */
	private ClaimKindDto[] claimKindDto;
	/** ���Է�����Ϣ */
	private PrepayFeeInfoDto[] prepayFeeInfoDto;
	/** ���Ե�֤��Ϣ */
	private CertifyInfoDto[] certifyInfoDto;
	/** ���Լ����������Ϣ */
	private CompeFeeInfoDto[] compeFeeInfoDto;
	/** ���Լ�������������Ϣ */
	private CompePayFeeInfoDto[] compePayFeeInfoDto;
	/** ���Լ����������嵥��Ϣ */
	private CompeInvMainInfo[] compeInvMainInfo;
	/** ���Ծ����������Ϣ */
	private InjuryPersonInfoDto injuryPersonInfoDto;
	/**�����������Ϣ*/
	private InjuryPersonInfoDto[] injuryPersonInfoArrayDto;
	
	
	/**
	 * Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterRequestDtoBase����
	 */
	public ClaimRequestInfo() {
	}

	/**
	 * ������������ʱ��
	 * 
	 * @param inputDate
	 *            �����õ���������ʱ���ֵ
	 */
	public void setInputDate(Date inputDate) {
		if (null != inputDate) {
			this.inputDate = inputDate;
		}
	}

	/**
	 * ��ȡ��������ʱ��
	 * 
	 * @return ��������ʱ���ֵ
	 */
	public Date getInputDate() {
		return inputDate;
	}

	/**
	 * �������Ա�������
	 * 
	 * @param policyno
	 *            �����õ����Ա��������ֵ
	 */
	public void setPolicyno(String policyno) {
		this.policyno = StringUtils.rightTrim(policyno);
	}

	/**
	 * ��ȡ���Ա�������
	 * 
	 * @return ���Ա��������ֵ
	 */
	public String getPolicyno() {
		return policyno;
	}

	/**
	 * �������Ա�������
	 * 
	 * @param registno
	 *            �����õ����Ա��������ֵ
	 */
	public void setRegistno(String registno) {
		this.registno = StringUtils.rightTrim(registno);
	}

	/**
	 * ��ȡ���Ա�������
	 * 
	 * @return ���Ա��������ֵ
	 */
	public String getRegistno() {
		return registno;
	}

	/**
	 * ����������������
	 * 
	 * @param claimno
	 *            �����õ��������������ֵ
	 */
	public void setClaimno(String claimno) {
		this.claimno = StringUtils.rightTrim(claimno);
	}

	/**
	 * ��ȡ������������
	 * 
	 * @return �������������ֵ
	 */
	public String getClaimno() {
		return claimno;
	}

	/**
	 * ���������¹�����(yyyy-MM-dd)
	 * 
	 * @param damageStartDate
	 *            �����õ������¹�����(yyyy-MM-dd)��ֵ
	 */
	public void setDamageStartDate(Date damageStartDate) {
		if (null != damageStartDate) {
			this.damageStartDate = damageStartDate;
		}
	}

	/**
	 * ��ȡ�����¹�����(yyyy-MM-dd)
	 * 
	 * @return �����¹�����(yyyy-MM-dd)��ֵ
	 */
	public Date getDamageStartDate() {
		return damageStartDate;
	}

	/**
	 * ���������¹�ʱ��(00:00)
	 * 
	 * @param damageStartHour
	 *            �����õ������¹�ʱ��(00:00)��ֵ
	 */
	public void setDamageStartHour(String damageStartHour) {
		this.damageStartHour = StringUtils.rightTrim(damageStartHour);
	}

	/**
	 * ��ȡ�����¹�ʱ��(00:00)
	 * 
	 * @return �����¹�ʱ��(00:00)��ֵ
	 */
	public String getDamageStartHour() {
		return damageStartHour;
	}

	/**
	 * ���������¹�ԭ��
	 * 
	 * @param damageCode
	 *            �����õ������¹�ԭ���ֵ
	 */
	public void setDamageCode(String damageCode) {
		this.damageCode = StringUtils.rightTrim(damageCode);
	}

	/**
	 * ��ȡ�����¹�ԭ��
	 * 
	 * @return �����¹�ԭ���ֵ
	 */
	public String getDamageCode() {
		return damageCode;
	}

	/**
	 * �������Ա�����
	 * 
	 * @param reportName
	 *            �����õ����Ա����˵�ֵ
	 */
	public void setReportName(String reportName) {
		this.reportName = StringUtils.rightTrim(reportName);
	}

	/**
	 * ��ȡ���Ա�����
	 * 
	 * @return ���Ա����˵�ֵ
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * �������Ա���ʱ��(yyyy-MM-dd)
	 * 
	 * @param reportDate
	 *            �����õ����Ա���ʱ��(yyyy-MM-dd)��ֵ
	 */
	public void setReportDate(Date reportDate) {
		if (null != reportDate) {
			this.reportDate = reportDate;
		}
	}

	/**
	 * ��ȡ���Ա���ʱ��(yyyy-MM-dd)
	 * 
	 * @return ���Ա���ʱ��(yyyy-MM-dd)��ֵ
	 */
	public Date getReportDate() {
		return reportDate;
	}

	/**
	 * �������Ա���ʱ��(00:00)
	 * 
	 * @param reportHour
	 *            �����õ����Ա���ʱ��(00:00)��ֵ
	 */
	public void setReportHour(String reportHour) {
		this.reportHour = StringUtils.rightTrim(reportHour);
	}

	/**
	 * ��ȡ���Ա���ʱ��(00:00)
	 * 
	 * @return ���Ա���ʱ��(00:00)��ֵ
	 */
	public String getReportHour() {
		return reportHour;
	}

	/**
	 * �������Ա�����ʽ
	 * 
	 * @param reportType
	 *            �����õ����Ա�����ʽ��ֵ
	 */
	public void setReportType(String reportType) {
		this.reportType = StringUtils.rightTrim(reportType);
	}

	/**
	 * ��ȡ���Ա�����ʽ
	 * 
	 * @return ���Ա�����ʽ��ֵ
	 */
	public String getReportType() {
		return reportType;
	}

	/**
	 * ����������ϵ��
	 * 
	 * @param linkerName
	 *            �����õ�������ϵ�˵�ֵ
	 */
	public void setLinkerName(String linkerName) {
		this.linkerName = StringUtils.rightTrim(linkerName);
	}

	/**
	 * ��ȡ������ϵ��
	 * 
	 * @return ������ϵ�˵�ֵ
	 */
	public String getLinkerName() {
		return linkerName;
	}

	/**
	 * ����������ϵ�绰
	 * 
	 * @param phoneNumber
	 *            �����õ�������ϵ�绰��ֵ
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = StringUtils.rightTrim(phoneNumber);
	}

	/**
	 * ��ȡ������ϵ�绰
	 * 
	 * @return ������ϵ�绰��ֵ
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * ����������ϵ��ַ
	 * 
	 * @param linkerAddress
	 *            �����õ�������ϵ��ַ��ֵ
	 */
	public void setLinkerAddress(String linkerAddress) {
		this.linkerAddress = StringUtils.rightTrim(linkerAddress);
	}

	/**
	 * ��ȡ������ϵ��ַ
	 * 
	 * @return ������ϵ��ַ��ֵ
	 */
	public String getLinkerAddress() {
		return linkerAddress;
	}

	/**
	 * �����������¹��߹�ϵ
	 * 
	 * @param clauseType
	 *            �����õ��������¹��߹�ϵ��ֵ
	 */
	public void setClauseType(String clauseType) {
		this.clauseType = StringUtils.rightTrim(clauseType);
	}

	/**
	 * ��ȡ�������¹��߹�ϵ
	 * 
	 * @return �������¹��߹�ϵ��ֵ
	 */
	public String getClauseType() {
		return clauseType;
	}

	/**
	 * ���������¹ʵص�
	 * 
	 * @param damageAddress
	 *            �����õ������¹ʵص��ֵ
	 */
	public void setDamageAddress(String damageAddress) {
		this.damageAddress = StringUtils.rightTrim(damageAddress);
	}

	/**
	 * ��ȡ�����¹ʵص�
	 * 
	 * @return �����¹ʵص��ֵ
	 */
	public String getDamageAddress() {
		return damageAddress;
	}

	/**
	 * ���������¹�����
	 * 
	 * @param damageTypeCode
	 *            �����õ������¹����͵�ֵ
	 */
	public void setDamageTypeCode(String damageTypeCode) {
		this.damageTypeCode = StringUtils.rightTrim(damageTypeCode);
	}

	/**
	 * ��ȡ�����¹�����
	 * 
	 * @return �����¹����͵�ֵ
	 */
	public String getDamageTypeCode() {
		return damageTypeCode;
	}

	/**
	 * ���������⸶�˴Σ�Ĭ��Ϊ0
	 * 
	 * @param lossesNumber
	 *            �����õ������⸶�˴Σ�Ĭ��Ϊ0��ֵ
	 */
	public void setLossesNumber(double lossesNumber) {
		this.lossesNumber = lossesNumber;
	}

	/**
	 * ��ȡ�����⸶�˴Σ�Ĭ��Ϊ0
	 * 
	 * @return �����⸶�˴Σ�Ĭ��Ϊ0��ֵ
	 */
	public double getLossesNumber() {
		return lossesNumber;
	}

	/**
	 * �������Բ����˴���
	 * 
	 * @param operatorCode
	 *            �����õ����Բ����˴����ֵ
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = StringUtils.rightTrim(operatorCode);
	}

	/**
	 * ��ȡ���Բ����˴���
	 * 
	 * @return ���Բ����˴����ֵ
	 */
	public String getOperatorCode() {
		return operatorCode;
	}

	/**
	 * �������Բ���������
	 * 
	 * @param operatorName
	 *            �����õ����Բ��������Ƶ�ֵ
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = StringUtils.rightTrim(operatorName);
	}

	/**
	 * ��ȡ���Բ���������
	 * 
	 * @return ���Բ��������Ƶ�ֵ
	 */
	public String getOperatorName() {
		return operatorName;
	}

	/**
	 * �����������⴦�����
	 * 
	 * @param makeCom
	 *            �����õ��������⴦�������ֵ
	 */
	public void setMakeCom(String makeCom) {
		this.makeCom = StringUtils.rightTrim(makeCom);
	}

	/**
	 * ��ȡ�������⴦�����
	 * 
	 * @return �������⴦�������ֵ
	 */
	public String getMakeCom() {
		return makeCom;
	}

	/**
	 * �������Դ����������
	 * 
	 * @param makeComName
	 *            �����õ����Դ���������Ƶ�ֵ
	 */
	public void setMakeComName(String makeComName) {
		this.makeComName = StringUtils.rightTrim(makeComName);
	}

	/**
	 * ��ȡ���Դ����������
	 * 
	 * @return ���Դ���������Ƶ�ֵ
	 */
	public String getMakeComName() {
		return makeComName;
	}

	/**
	 * �������Ա�������¼
	 * 
	 * @param remark
	 *            �����õ����Ա�������¼��ֵ
	 */
	public void setRemark(String remark) {
		this.remark = StringUtils.rightTrim(remark);
	}

	/**
	 * ��ȡ���Ա�������¼
	 * 
	 * @return ���Ա�������¼��ֵ
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * ���������¹ʾ������¹���״
	 * 
	 * @param context
	 *            �����õ������¹ʾ������¹���״��ֵ
	 */
	public void setContext(String context) {
		this.context = StringUtils.rightTrim(context);
	}

	/**
	 * ��ȡ�����¹ʾ������¹���״
	 * 
	 * @return �����¹ʾ������¹���״��ֵ
	 */
	public String getContext() {
		return context;
	}

	/**
	 * �������Ա�����CNY
	 * 
	 * @param estimateLoss
	 *            �����õ����Ա�����CNY��ֵ
	 */
	public void setEstimateLoss(double estimateLoss) {
		this.estimateLoss = estimateLoss;
	}

	/**
	 * ��ȡ���Ա�����CNY
	 * 
	 * @return ���Ա�����CNY��ֵ
	 */
	public double getEstimateLoss() {
		return estimateLoss;
	}

	/**
	 * �������Ե��Ȳ鿱����λ
	 * 
	 * @param scheduleObjectId
	 *            �����õ����Ե��Ȳ鿱����λ��ֵ
	 */
	public void setScheduleObjectId(String scheduleObjectId) {
		this.scheduleObjectId = StringUtils.rightTrim(scheduleObjectId);
	}

	/**
	 * ��ȡ���Ե��Ȳ鿱����λ
	 * 
	 * @return ���Ե��Ȳ鿱����λ��ֵ
	 */
	public String getScheduleObjectId() {
		return scheduleObjectId;
	}

	/**
	 * �������Բ鿱��ַ
	 * 
	 * @param checkSite
	 *            �����õ����Բ鿱��ַ��ֵ
	 */
	public void setCheckSite(String checkSite) {
		this.checkSite = StringUtils.rightTrim(checkSite);
	}

	/**
	 * ��ȡ���Բ鿱��ַ
	 * 
	 * @return ���Բ鿱��ַ��ֵ
	 */
	public String getCheckSite() {
		return checkSite;
	}

	/**
	 * �������Բ鿱Ҫ��
	 * 
	 * @param checkInfo
	 *            �����õ����Բ鿱Ҫ���ֵ
	 */
	public void setCheckInfo(String checkInfo) {
		this.checkInfo = StringUtils.rightTrim(checkInfo);
	}

	/**
	 * ��ȡ���Բ鿱Ҫ��
	 * 
	 * @return ���Բ鿱Ҫ���ֵ
	 */
	public String getCheckInfo() {
		return checkInfo;
	}

	/**
	 * �������Բ鿱�˴���
	 * 
	 * @param nextHandlerCode
	 *            �����õ����Բ鿱�˴����ֵ
	 */
	public void setNextHandlerCode(String nextHandlerCode) {
		this.nextHandlerCode = StringUtils.rightTrim(nextHandlerCode);
	}

	/**
	 * ��ȡ���Բ鿱�˴���
	 * 
	 * @return ���Բ鿱�˴����ֵ
	 */
	public String getNextHandlerCode() {
		return nextHandlerCode;
	}

	/**
	 * �������Բ鿱������
	 * 
	 * @param nextHandlerName
	 *            �����õ����Բ鿱�����Ƶ�ֵ
	 */
	public void setNextHandlerName(String nextHandlerName) {
		this.nextHandlerName = StringUtils.rightTrim(nextHandlerName);
	}

	/**
	 * ��ȡ���Բ鿱������
	 * 
	 * @return ���Բ鿱�����Ƶ�ֵ
	 */
	public String getNextHandlerName() {
		return nextHandlerName;
	}

	/**
	 * �������Բ鿱��2
	 * 
	 * @param checker2
	 *            �����õ����Բ鿱��2��ֵ
	 */
	public void setChecker2(String checker2) {
		this.checker2 = StringUtils.rightTrim(checker2);
	}

	/**
	 * ��ȡ���Բ鿱��2
	 * 
	 * @return ���Բ鿱��2��ֵ
	 */
	public String getChecker2() {
		return checker2;
	}

	/**
	 * �������Բ鿱����(�鿱L����D)
	 * 
	 * @param checkType
	 *            �����õ����Բ鿱����(�鿱L����D)��ֵ
	 */
	public void setCheckType(String checkType) {
		this.checkType = StringUtils.rightTrim(checkType);
	}

	/**
	 * ��ȡ���Բ鿱����(�鿱L����D)
	 * 
	 * @return ���Բ鿱����(�鿱L����D)��ֵ
	 */
	public String getCheckType() {
		return checkType;
	}

	/**
	 * �������Բ鿱����(yyyy-MM-dd)
	 * 
	 * @param checkDate
	 *            �����õ����Բ鿱����(yyyy-MM-dd)��ֵ
	 */
	public void setCheckDate(Date checkDate) {
		if (null != checkDate) {
			this.checkDate = checkDate;
		}
	}

	/**
	 * ��ȡ���Բ鿱����(yyyy-MM-dd)
	 * 
	 * @return ���Բ鿱����(yyyy-MM-dd)��ֵ
	 */
	public Date getCheckDate() {
		return checkDate;
	}

	/**
	 * �������Բ鿱����(�ֳ�1����9)
	 * 
	 * @param checkNature
	 *            �����õ����Բ鿱����(�ֳ�1����9)��ֵ
	 */
	public void setCheckNature(String checkNature) {
		this.checkNature = StringUtils.rightTrim(checkNature);
	}

	/**
	 * ��ȡ���Բ鿱����(�ֳ�1����9)
	 * 
	 * @return ���Բ鿱����(�ֳ�1����9)��ֵ
	 */
	public String getCheckNature() {
		return checkNature;
	}

	/**
	 * �������Բ鿱Ԥ�����CNY
	 * 
	 * @param checkEstimateLoss
	 *            �����õ����Բ鿱Ԥ�����CNY��ֵ
	 */
	public void setCheckEstimateLoss(double checkEstimateLoss) {
		this.checkEstimateLoss = checkEstimateLoss;
	}

	/**
	 * ��ȡ���Բ鿱Ԥ�����CNY
	 * 
	 * @return ���Բ鿱Ԥ�����CNY��ֵ
	 */
	public double getCheckEstimateLoss() {
		return checkEstimateLoss;
	}

	/**
	 * ��������Ԥ������
	 * 
	 * @param estimateFee
	 *            �����õ�����Ԥ�����õ�ֵ
	 */
	public void setEstimateFee(double estimateFee) {
		this.estimateFee = estimateFee;
	}

	/**
	 * ��ȡ����Ԥ������
	 * 
	 * @return ����Ԥ�����õ�ֵ
	 */
	public double getEstimateFee() {
		return estimateFee;
	}

	/**
	 * �������Բ鿱����λ(��1����0)
	 * 
	 * @param unitType
	 *            �����õ����Բ鿱����λ(��1����0)��ֵ
	 */
	public void setUnitType(String unitType) {
		this.unitType = StringUtils.rightTrim(unitType);
	}

	/**
	 * ��ȡ���Բ鿱����λ(��1����0)
	 * 
	 * @return ���Բ鿱����λ(��1����0)��ֵ
	 */
	public String getUnitType() {
		return unitType;
	}

	/**
	 * �������Բ鿱��ע
	 * 
	 * @param checkRemark
	 *            �����õ����Բ鿱��ע��ֵ
	 */
	public void setCheckRemark(String checkRemark) {
		this.checkRemark = StringUtils.rightTrim(checkRemark);
	}

	/**
	 * ��ȡ���Բ鿱��ע
	 * 
	 * @return ���Բ鿱��ע��ֵ
	 */
	public String getCheckRemark() {
		return checkRemark;
	}

	/**
	 * �������Բ鿱����
	 * 
	 * @param checkContext
	 *            �����õ����Բ鿱�����ֵ
	 */
	public void setCheckContext(String checkContext) {
		this.checkContext = StringUtils.rightTrim(checkContext);
	}

	/**
	 * ��ȡ���Բ鿱����
	 * 
	 * @return ���Բ鿱�����ֵ
	 */
	public String getCheckContext() {
		return checkContext;
	}

	/**
	 * �������Աұ�Ĭ��CNY
	 * 
	 * @param currency
	 *            �����õ����Աұ�Ĭ��CNY��ֵ
	 */
	public void setCurrency(String currency) {
		this.currency = StringUtils.rightTrim(currency);
	}

	/**
	 * ��ȡ���Աұ�Ĭ��CNY
	 * 
	 * @return ���Աұ�Ĭ��CNY��ֵ
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * ���������¹���������
	 * 
	 * @param damageTypeName
	 *            �����õ������¹��������Ƶ�ֵ
	 */
	public void setDamageTypeName(String damageTypeName) {
		this.damageTypeName = StringUtils.rightTrim(damageTypeName);
	}

	/**
	 * ��ȡ�����¹���������
	 * 
	 * @return �����¹��������Ƶ�ֵ
	 */
	public String getDamageTypeName() {
		return damageTypeName;
	}

	/**
	 * ���������Ƿ����׷��(��1����0)
	 * 
	 * @param replevyFlag
	 *            �����õ������Ƿ����׷��(��1����0)��ֵ
	 */
	public void setReplevyFlag(String replevyFlag) {
		this.replevyFlag = StringUtils.rightTrim(replevyFlag);
	}

	/**
	 * ��ȡ�����Ƿ����׷��(��1����0)
	 * 
	 * @return �����Ƿ����׷��(��1����0)��ֵ
	 */
	public String getReplevyFlag() {
		return replevyFlag;
	}

	/**
	 * ���������Ƿ����������н�:��1��0
	 * 
	 * @param thirdComFlag
	 *            �����õ������Ƿ����������н�:��1��0��ֵ
	 */
	public void setThirdComFlag(String thirdComFlag) {
		this.thirdComFlag = StringUtils.rightTrim(thirdComFlag);
	}

	/**
	 * ��ȡ�����Ƿ����������н�:��1��0
	 * 
	 * @return �����Ƿ����������н�:��1��0��ֵ
	 */
	public String getThirdComFlag() {
		return thirdComFlag;
	}

	/**
	 * ������������������
	 * 
	 * @param sumClaim
	 *            �����õ����������������ֵ
	 */
	public void setSumClaim(double sumClaim) {
		this.sumClaim = sumClaim;
	}

	/**
	 * ��ȡ��������������
	 * 
	 * @return ���������������ֵ
	 */
	public double getSumClaim() {
		return sumClaim;
	}

	/**
	 * �������԰������ʹ���
	 * 
	 * @param claimType
	 *            �����õ����԰������ʹ����ֵ
	 */
	public void setClaimType(String claimType) {
		this.claimType = StringUtils.rightTrim(claimType);
	}

	/**
	 * ��ȡ���԰������ʹ���
	 * 
	 * @return ���԰������ʹ����ֵ
	 */
	public String getClaimType() {
		return claimType;
	}

	/**
	 * ������������Ԥ���ⰸ����ѡ��
	 * 
	 * @param caseType
	 *            �����õ���������Ԥ���ⰸ����ѡ���ֵ
	 */
	public void setCaseType(String caseType) {
		this.caseType = StringUtils.rightTrim(caseType);
	}

	/**
	 * ��ȡ��������Ԥ���ⰸ����ѡ��
	 * 
	 * @return ��������Ԥ���ⰸ����ѡ���ֵ
	 */
	public String getCaseType() {
		return caseType;
	}

	/**
	 * ��������Ԥ������ԭ��
	 * 
	 * @param payAppContext
	 *            �����õ�����Ԥ������ԭ���ֵ
	 */
	public void setPayAppContext(String payAppContext) {
		this.payAppContext = StringUtils.rightTrim(payAppContext);
	}

	/**
	 * ��ȡ����Ԥ������ԭ��
	 * 
	 * @return ����Ԥ������ԭ���ֵ
	 */
	public String getPayAppContext() {
		return payAppContext;
	}

	/**
	 * ��������Ԥ���Ĭ��0.00
	 * 
	 * @param sumPrePaid
	 *            �����õ�����Ԥ���Ĭ��0.00��ֵ
	 */
	public void setSumPrePaid(double sumPrePaid) {
		this.sumPrePaid = sumPrePaid;
	}

	/**
	 * ��ȡ����Ԥ���Ĭ��0.00
	 * 
	 * @return ����Ԥ���Ĭ��0.00��ֵ
	 */
	public double getSumPrePaid() {
		return sumPrePaid;
	}

	/**
	 * ��������Ԥ�ⱨ��
	 * 
	 * @param prepayReport
	 *            �����õ�����Ԥ�ⱨ���ֵ
	 */
	public void setPrepayReport(String prepayReport) {
		this.prepayReport = StringUtils.rightTrim(prepayReport);
	}

	/**
	 * ��ȡ����Ԥ�ⱨ��
	 * 
	 * @return ����Ԥ�ⱨ���ֵ
	 */
	public String getPrepayReport() {
		return prepayReport;
	}

	/**
	 * �������Ե�֤�����������
	 * 
	 * @param certifyContext
	 *            �����õ����Ե�֤�������������ֵ
	 */
	public void setCertifyContext(String certifyContext) {
		this.certifyContext = StringUtils.rightTrim(certifyContext);
	}

	/**
	 * ��ȡ���Ե�֤�����������
	 * 
	 * @return ���Ե�֤�������������ֵ
	 */
	public String getCertifyContext() {
		return certifyContext;
	}

	/**
	 * �������Ա������˿�������
	 * 
	 * @param bank
	 *            �����õ����Ա������˿������е�ֵ
	 */
	public void setBank(String bank) {
		this.bank = StringUtils.rightTrim(bank);
	}

	/**
	 * ��ȡ���Ա������˿�������
	 * 
	 * @return ���Ա������˿������е�ֵ
	 */
	public String getBank() {
		return bank;
	}

	/**
	 * ���������տ���ȫ��
	 * 
	 * @param receiverName
	 *            �����õ������տ���ȫ�Ƶ�ֵ
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = StringUtils.rightTrim(receiverName);
	}

	/**
	 * ��ȡ�����տ���ȫ��
	 * 
	 * @return �����տ���ȫ�Ƶ�ֵ
	 */
	public String getReceiverName() {
		return receiverName;
	}

	/**
	 * �������Կ����˺�
	 * 
	 * @param account
	 *            �����õ����Կ����˺ŵ�ֵ
	 */
	public void setAccount(String account) {
		this.account = StringUtils.rightTrim(account);
	}

	/**
	 * ��ȡ���Կ����˺�
	 * 
	 * @return ���Կ����˺ŵ�ֵ
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * ��������ȷ�Ͽ����˺�
	 * 
	 * @param accountOK
	 *            �����õ�����ȷ�Ͽ����˺ŵ�ֵ
	 */
	public void setAccountOK(String accountOK) {
		this.accountOK = StringUtils.rightTrim(accountOK);
	}

	/**
	 * ��ȡ����ȷ�Ͽ����˺�
	 * 
	 * @return ����ȷ�Ͽ����˺ŵ�ֵ
	 */
	public String getAccountOK() {
		return accountOK;
	}

	/**
	 * �����������⸶ԭ��
	 * 
	 * @param zeroLossType
	 *            �����õ��������⸶ԭ���ֵ
	 */
	public void setZeroLossType(String zeroLossType) {
		this.zeroLossType = StringUtils.rightTrim(zeroLossType);
	}

	/**
	 * ��ȡ�������⸶ԭ��
	 * 
	 * @return �������⸶ԭ���ֵ
	 */
	public String getZeroLossType() {
		return zeroLossType;
	}

	/**
	 * �������Է��úϼƣ�Ĭ��0.00
	 * 
	 * @param sumNoDutyFee
	 *            �����õ����Է��úϼƣ�Ĭ��0.00��ֵ
	 */
	public void setSumNoDutyFee(double sumNoDutyFee) {
		this.sumNoDutyFee = sumNoDutyFee;
	}

	/**
	 * ��ȡ���Է��úϼƣ�Ĭ��0.00
	 * 
	 * @return ���Է��úϼƣ�Ĭ��0.00��ֵ
	 */
	public double getSumNoDutyFee() {
		return sumNoDutyFee;
	}

	/**
	 * �����������ϼƣ�Ĭ��0.00
	 * 
	 * @param prplCompensateSumPaid
	 *            �����õ��������ϼƣ�Ĭ��0.00��ֵ
	 */
	public void setPrplCompensateSumPaid(double prplCompensateSumPaid) {
		this.prplCompensateSumPaid = prplCompensateSumPaid;
	}

	/**
	 * ��ȡ�������ϼƣ�Ĭ��0.00
	 * 
	 * @return �������ϼƣ�Ĭ��0.00��ֵ
	 */
	public double getPrplCompensateSumPaid() {
		return prplCompensateSumPaid;
	}

	/**
	 * ����������Ԥ����Ĭ��0.00
	 * 
	 * @param prplCompensateSumPrePaid
	 *            �����õ�������Ԥ����Ĭ��0.00��ֵ
	 */
	public void setPrplCompensateSumPrePaid(double prplCompensateSumPrePaid) {
		this.prplCompensateSumPrePaid = prplCompensateSumPrePaid;
	}

	/**
	 * ��ȡ������Ԥ����Ĭ��0.00
	 * 
	 * @return ������Ԥ����Ĭ��0.00��ֵ
	 */
	public double getPrplCompensateSumPrePaid() {
		return prplCompensateSumPrePaid;
	}

	/**
	 * ����������Ԥ�����ã�Ĭ��0.00
	 * 
	 * @param sumChargePaid
	 *            �����õ�������Ԥ�����ã�Ĭ��0.00��ֵ
	 */
	public void setSumChargePaid(double sumChargePaid) {
		this.sumChargePaid = sumChargePaid;
	}

	/**
	 * ��ȡ������Ԥ�����ã�Ĭ��0.00
	 * 
	 * @return ������Ԥ�����ã�Ĭ��0.00��ֵ
	 */
	public double getSumChargePaid() {
		return sumChargePaid;
	}

	/**
	 * �������Ա��θ�����Ĭ��0.00
	 * 
	 * @param sumThisPaid
	 *            �����õ����Ա��θ�����Ĭ��0.00��ֵ
	 */
	public void setSumThisPaid(double sumThisPaid) {
		this.sumThisPaid = sumThisPaid;
	}

	/**
	 * ��ȡ���Ա��θ�����Ĭ��0.00
	 * 
	 * @return ���Ա��θ�����Ĭ��0.00��ֵ
	 */
	public double getSumThisPaid() {
		return sumThisPaid;
	}

	/**
	 * �����������������
	 * 
	 * @param compeContext
	 *            �����õ�������������̵�ֵ
	 */
	public void setCompeContext(String compeContext) {
		this.compeContext = StringUtils.rightTrim(compeContext);
	}

	/**
	 * ��ȡ�������������
	 * 
	 * @return ������������̵�ֵ
	 */
	public String getCompeContext() {
		return compeContext;
	}

	/**
	 * ������������Ƭ��
	 * 
	 * @param notion
	 *            �����õ���������Ƭ���ֵ
	 */
	public void setNotion(String notion) {
		this.notion = StringUtils.rightTrim(notion);
	}

	/**
	 * ��ȡ��������Ƭ��
	 * 
	 * @return ��������Ƭ���ֵ
	 */
	public String getNotion() {
		return notion;
	}

	/**
	 * �������Ժ���ǩ�����
	 * 
	 * @param handleText
	 *            �����õ����Ժ���ǩ�������ֵ
	 */
	public void setHandleText(String handleText) {
		this.handleText = StringUtils.rightTrim(handleText);
	}

	/**
	 * ��ȡ���Ժ���ǩ�����
	 * 
	 * @return ���Ժ���ǩ�������ֵ
	 */
	public String getHandleText() {
		return handleText;
	}
	
	/**
     * �������Կͻ�����������
     * @param outId �����õ����Կͻ�������������ֵ
     */
    public void setOutId(String outId){
        this.outId = StringUtils.rightTrim(outId);
    }

    /**
     * ��ȡ���Կͻ�����������
     * @return ���Կͻ�������������ֵ
     */
    public String getOutId(){
        return outId;
    }
	
	/**
	 * ���������¹�����Ϣ
	 * 
	 * @param accidentPersonInfoDto
	 *            �����õ������¹�����Ϣ��ֵ
	 */
	public void setAccidentPersonInfoDto(AccidentPersonInfoDto[] accidentPersonInfoDto) {
		this.accidentPersonInfoDto = accidentPersonInfoDto;
	}

	/**
	 * ��ȡ�����¹�����Ϣ
	 * 
	 * @return �����¹�����Ϣ��ֵ
	 */
	public AccidentPersonInfoDto[] getAccidentPersonInfoDto() {
		return accidentPersonInfoDto;
	}

	/**
	 * �������Ե��Ȳ���˵����Ϣ
	 * 
	 * @param schedExtInfoDto
	 *            �����õ����Ե��Ȳ���˵����Ϣ��ֵ
	 */
	public void setSchedExtInfoDto(SchedExtInfoDto[] schedExtInfoDto) {
		this.schedExtInfoDto = schedExtInfoDto;
	}

	/**
	 * ��ȡ���Ե��Ȳ���˵����Ϣ
	 * 
	 * @return ���Ե��Ȳ���˵����Ϣ��ֵ
	 */
	public SchedExtInfoDto[] getSchedExtInfoDto() {
		return schedExtInfoDto;
	}

	/**
	 * ������������������������Ϣ
	 * 
	 * @param claimAppDto
	 *            �����õ���������������������Ϣ��ֵ
	 */
	public void setClaimAppDto(ClaimAppDto[] claimAppDto) {
		this.claimAppDto = claimAppDto;
	}

	/**
	 * ��ȡ��������������������Ϣ
	 * 
	 * @return ��������������������Ϣ��ֵ
	 */
	public ClaimAppDto[] getClaimAppDto() {
		return claimAppDto;
	}

	/**
	 * �������������ձ��������
	 * 
	 * @param claimKindDto
	 *            �����õ����������ձ�������ŵ�ֵ
	 */
	public void setClaimKindDto(ClaimKindDto[] claimKindDto) {
		this.claimKindDto = claimKindDto;
	}

	/**
	 * ��ȡ���������ձ��������
	 * 
	 * @return ���������ձ�������ŵ�ֵ
	 */
	public ClaimKindDto[] getClaimKindDto() {
		return claimKindDto;
	}

	/**
	 * �������Է�����Ϣ
	 * 
	 * @param prepayFeeInfoDto
	 *            �����õ����Է�����Ϣ��ֵ
	 */
	public void setPrepayFeeInfoDto(PrepayFeeInfoDto[] prepayFeeInfoDto) {
		this.prepayFeeInfoDto = prepayFeeInfoDto;
	}

	/**
	 * ��ȡ���Է�����Ϣ
	 * 
	 * @return ���Է�����Ϣ��ֵ
	 */
	public PrepayFeeInfoDto[] getPrepayFeeInfoDto() {
		return prepayFeeInfoDto;
	}

	/**
	 * �������Ե�֤��Ϣ
	 * 
	 * @param certifyInfoDto
	 *            �����õ����Ե�֤��Ϣ��ֵ
	 */
	public void setCertifyInfoDto(CertifyInfoDto[] certifyInfoDto) {
		this.certifyInfoDto = certifyInfoDto;
	}

	/**
	 * ��ȡ���Ե�֤��Ϣ
	 * 
	 * @return ���Ե�֤��Ϣ��ֵ
	 */
	public CertifyInfoDto[] getCertifyInfoDto() {
		return certifyInfoDto;
	}

	/**
	 * �������Լ����������Ϣ
	 * 
	 * @param compeFeeInfoDto
	 *            �����õ����Լ����������Ϣ��ֵ
	 */
	public void setCompeFeeInfoDto(CompeFeeInfoDto[] compeFeeInfoDto) {
		this.compeFeeInfoDto = compeFeeInfoDto;
	}

	/**
	 * ��ȡ���Լ����������Ϣ
	 * 
	 * @return ���Լ����������Ϣ��ֵ
	 */
	public CompeFeeInfoDto[] getCompeFeeInfoDto() {
		return compeFeeInfoDto;
	}

	/**
	 * �������Լ�������������Ϣ
	 * 
	 * @param compePayFeeInfoDto
	 *            �����õ����Լ�������������Ϣ��ֵ
	 */
	public void setCompePayFeeInfoDto(CompePayFeeInfoDto[] compePayFeeInfoDto) {
		this.compePayFeeInfoDto = compePayFeeInfoDto;
	}

	/**
	 * ��ȡ���Լ�������������Ϣ
	 * 
	 * @return ���Լ�������������Ϣ��ֵ
	 */
	public CompePayFeeInfoDto[] getCompePayFeeInfoDto() {
		return compePayFeeInfoDto;
	}

	/**
	 * �������Լ�������������Ϣ
	 * 
	 * @param compePayFeeInfoDto
	 *            �����õ����Լ�������������Ϣ��ֵ
	 */
	public void setCompeInvMainInfo(CompeInvMainInfo[] compeInvMainInfo) {
		this.compeInvMainInfo = compeInvMainInfo;
	}

	/**
	 * ��ȡ���Լ�������������Ϣ
	 * 
	 * @return ���Լ�������������Ϣ��ֵ
	 */
	public CompeInvMainInfo[] getCompeInvMainInfo() {
		return compeInvMainInfo;
	}

	public String getOutRigstNo() {
		return outRigstNo;
	}

	public void setOutRigstNo(String outRigstNo) {
		this.outRigstNo = outRigstNo;
	}

	public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}

	public Date getCompeTime() {
		return compeTime;
	}

	public void setCompeTime(Date compeTime) {
		this.compeTime = compeTime;
	}

	public Date getVericTime() {
		return vericTime;
	}

	public void setVericTime(Date vericTime) {
		this.vericTime = vericTime;
	}

	public String getRegistUser() {
		return registUser;
	}

	public void setRegistUser(String registUser) {
		this.registUser = registUser;
	}

	public String getCompeUser() {
		return compeUser;
	}

	public void setCompeUser(String compeUser) {
		this.compeUser = compeUser;
	}

	public String getVericUser() {
		return vericUser;
	}

	public void setVericUser(String vericUser) {
		this.vericUser = vericUser;
	}

	public InjuryPersonInfoDto getInjuryPersonInfoDto() {
		return injuryPersonInfoDto;
	}

	public void setInjuryPersonInfoDto(InjuryPersonInfoDto injuryPersonInfoDto) {
		this.injuryPersonInfoDto = injuryPersonInfoDto;
	}

	public InjuryPersonInfoDto[] getInjuryPersonInfoArrayDto() {
		return injuryPersonInfoArrayDto;
	}

	public void setInjuryPersonInfoArrayDto(
			InjuryPersonInfoDto[] injuryPersonInfoArrayDto) {
		this.injuryPersonInfoArrayDto = injuryPersonInfoArrayDto;
	}

	

}
