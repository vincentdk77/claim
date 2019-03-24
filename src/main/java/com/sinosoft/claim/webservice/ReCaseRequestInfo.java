package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sysframework.common.util.StringUtils;

public class ReCaseRequestInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** ���Կͻ�������id */
    private String outId = "";
    /** ���Կͻ��˹�������id */
    private String relationOutId = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Ա������� */
    private String registNo = "";
    /** ������������ */
    private String claimNo = "";
    /** �����ؿ��ⰸԭ�� */
    private String appRecaseReason = "";
    /** �����ؿ�����Ƭ�� */
    private String reClaimNotion = "";
    /** �����ؿ����������� */
    private String reClaimHandleText = "";
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
    /** �����ؿ��ⰸ����ʱ�� */
    private Date applyRecaseTime = new Date();
    /** �����ؿ��ⰸ������Ա���� */
    private String applyRecaseUser = "";
    /** ��������ؿ��ⰸʱ�� */
    private Date auditRecaseTime = new Date();
    /** ���������Ա���� */
    private String auditUser = "";
    /** ���Ժ���ͨ��ʱ�� */
    private Date vericTime = new Date();
    /** ���Ժ�����Ա���� */
    private String vericUser = "";
    /** �����¹�����Ϣ */
	private AccidentPersonInfoDto[] accidentPersonInfoDto;
	/** ���Ե��Ȳ���˵����Ϣ */
	private SchedExtInfoDto[] schedExtInfoDto;
	/** ��������������������Ϣ */
	private ClaimAppDto[] claimAppDto;
	/** ���Ե�֤��Ϣ */
	private CertifyInfoDto[] certifyInfoDto;
	/** ���Լ����������Ϣ */
	private CompeFeeInfoDto[] compeFeeInfoDto;
	/** ���Լ�������������Ϣ */
	private CompePayFeeInfoDto[] compePayFeeInfoDto;
	/** ���Լ����������嵥��Ϣ */
	private CompeInvMainInfo[] compeInvMainInfo;
	
	private InjuryPersonInfoDto injuryPersonInfoDto;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�ReCaseRequestInfo����
     */
    public ReCaseRequestInfo(){
    }

    

    /**
     * �������Կͻ�������id
     * @param outId �����õ����Կͻ�������id��ֵ
     */
    public void setOutId(String outId){
        this.outId = StringUtils.rightTrim(outId);
    }

    /**
     * ��ȡ���Կͻ�������id
     * @return ���Կͻ�������id��ֵ
     */
    public String getOutId(){
        return outId;
    }

    

    /**
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * �������Ա�������
     * @param registNo �����õ����Ա��������ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ����������������
     * @param claimNo �����õ��������������ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * ���������ؿ��ⰸԭ��
     * @param appRecaseReason �����õ������ؿ��ⰸԭ���ֵ
     */
    public void setAppRecaseReason(String appRecaseReason){
        this.appRecaseReason = StringUtils.rightTrim(appRecaseReason);
    }

    /**
     * ��ȡ�����ؿ��ⰸԭ��
     * @return �����ؿ��ⰸԭ���ֵ
     */
    public String getAppRecaseReason(){
        return appRecaseReason;
    }

    /**
     * ���������ؿ�����Ƭ��
     * @param reClaimNotion �����õ������ؿ�����Ƭ���ֵ
     */
    public void setReClaimNotion(String reClaimNotion){
        this.reClaimNotion = StringUtils.rightTrim(reClaimNotion);
    }

    /**
     * ��ȡ�����ؿ�����Ƭ��
     * @return �����ؿ�����Ƭ���ֵ
     */
    public String getReClaimNotion(){
        return reClaimNotion;
    }

    /**
     * ���������ؿ�����������
     * @param reClaimHandleText �����õ������ؿ�������������ֵ
     */
    public void setReClaimHandleText(String reClaimHandleText){
        this.reClaimHandleText = StringUtils.rightTrim(reClaimHandleText);
    }

    /**
     * ��ȡ�����ؿ�����������
     * @return �����ؿ�������������ֵ
     */
    public String getReClaimHandleText(){
        return reClaimHandleText;
    }

    /**
     * ���������⸶�˴Σ�Ĭ��Ϊ0
     * @param lossesNumber �����õ������⸶�˴Σ�Ĭ��Ϊ0��ֵ
     */
    public void setLossesNumber(double lossesNumber){
        this.lossesNumber = lossesNumber;
    }

    /**
     * ��ȡ�����⸶�˴Σ�Ĭ��Ϊ0
     * @return �����⸶�˴Σ�Ĭ��Ϊ0��ֵ
     */
    public double getLossesNumber(){
        return lossesNumber;
    }

    /**
     * �������Բ����˴���
     * @param operatorCode �����õ����Բ����˴����ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Բ����˴���
     * @return ���Բ����˴����ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * �������Բ���������
     * @param operatorName �����õ����Բ��������Ƶ�ֵ
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * ��ȡ���Բ���������
     * @return ���Բ��������Ƶ�ֵ
     */
    public String getOperatorName(){
        return operatorName;
    }

    /**
     * �����������⴦�����
     * @param makeCom �����õ��������⴦�������ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ�������⴦�����
     * @return �������⴦�������ֵ
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * �������Դ����������
     * @param makeComName �����õ����Դ���������Ƶ�ֵ
     */
    public void setMakeComName(String makeComName){
        this.makeComName = StringUtils.rightTrim(makeComName);
    }

    /**
     * ��ȡ���Դ����������
     * @return ���Դ���������Ƶ�ֵ
     */
    public String getMakeComName(){
        return makeComName;
    }

    /**
     * �������Ա������˿�������
     * @param bank �����õ����Ա������˿������е�ֵ
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * ��ȡ���Ա������˿�������
     * @return ���Ա������˿������е�ֵ
     */
    public String getBank(){
        return bank;
    }

    /**
     * ���������տ���ȫ��
     * @param receiverName �����õ������տ���ȫ�Ƶ�ֵ
     */
    public void setReceiverName(String receiverName){
        this.receiverName = StringUtils.rightTrim(receiverName);
    }

    /**
     * ��ȡ�����տ���ȫ��
     * @return �����տ���ȫ�Ƶ�ֵ
     */
    public String getReceiverName(){
        return receiverName;
    }

    /**
     * �������Կ����˺�
     * @param account �����õ����Կ����˺ŵ�ֵ
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * ��ȡ���Կ����˺�
     * @return ���Կ����˺ŵ�ֵ
     */
    public String getAccount(){
        return account;
    }

    /**
     * ��������ȷ�Ͽ����˺�
     * @param accountOK �����õ�����ȷ�Ͽ����˺ŵ�ֵ
     */
    public void setAccountOK(String accountOK){
        this.accountOK = StringUtils.rightTrim(accountOK);
    }

    /**
     * ��ȡ����ȷ�Ͽ����˺�
     * @return ����ȷ�Ͽ����˺ŵ�ֵ
     */
    public String getAccountOK(){
        return accountOK;
    }

    /**
     * �����������⸶ԭ��
     * @param zeroLossType �����õ��������⸶ԭ���ֵ
     */
    public void setZeroLossType(String zeroLossType){
        this.zeroLossType = StringUtils.rightTrim(zeroLossType);
    }

    /**
     * ��ȡ�������⸶ԭ��
     * @return �������⸶ԭ���ֵ
     */
    public String getZeroLossType(){
        return zeroLossType;
    }

    /**
     * �������Է��úϼƣ�Ĭ��0.00
     * @param sumNoDutyFee �����õ����Է��úϼƣ�Ĭ��0.00��ֵ
     */
    public void setSumNoDutyFee(double sumNoDutyFee){
        this.sumNoDutyFee = sumNoDutyFee;
    }

    /**
     * ��ȡ���Է��úϼƣ�Ĭ��0.00
     * @return ���Է��úϼƣ�Ĭ��0.00��ֵ
     */
    public double getSumNoDutyFee(){
        return sumNoDutyFee;
    }

    /**
     * �����������ϼƣ�Ĭ��0.00
     * @param prplCompensateSumPaid �����õ��������ϼƣ�Ĭ��0.00��ֵ
     */
    public void setPrplCompensateSumPaid(double prplCompensateSumPaid){
        this.prplCompensateSumPaid = prplCompensateSumPaid;
    }

    /**
     * ��ȡ�������ϼƣ�Ĭ��0.00
     * @return �������ϼƣ�Ĭ��0.00��ֵ
     */
    public double getPrplCompensateSumPaid(){
        return prplCompensateSumPaid;
    }

    /**
     * ����������Ԥ����Ĭ��0.00
     * @param prplCompensateSumPrePaid �����õ�������Ԥ����Ĭ��0.00��ֵ
     */
    public void setPrplCompensateSumPrePaid(double prplCompensateSumPrePaid){
        this.prplCompensateSumPrePaid = prplCompensateSumPrePaid;
    }

    /**
     * ��ȡ������Ԥ����Ĭ��0.00
     * @return ������Ԥ����Ĭ��0.00��ֵ
     */
    public double getPrplCompensateSumPrePaid(){
        return prplCompensateSumPrePaid;
    }

    /**
     * ����������Ԥ�����ã�Ĭ��0.00
     * @param sumChargePaid �����õ�������Ԥ�����ã�Ĭ��0.00��ֵ
     */
    public void setSumChargePaid(double sumChargePaid){
        this.sumChargePaid = sumChargePaid;
    }

    /**
     * ��ȡ������Ԥ�����ã�Ĭ��0.00
     * @return ������Ԥ�����ã�Ĭ��0.00��ֵ
     */
    public double getSumChargePaid(){
        return sumChargePaid;
    }

    /**
     * �������Ա��θ�����Ĭ��0.00
     * @param sumThisPaid �����õ����Ա��θ�����Ĭ��0.00��ֵ
     */
    public void setSumThisPaid(double sumThisPaid){
        this.sumThisPaid = sumThisPaid;
    }

    /**
     * ��ȡ���Ա��θ�����Ĭ��0.00
     * @return ���Ա��θ�����Ĭ��0.00��ֵ
     */
    public double getSumThisPaid(){
        return sumThisPaid;
    }

    /**
     * �����������������
     * @param compeContext �����õ�������������̵�ֵ
     */
    public void setCompeContext(String compeContext){
        this.compeContext = StringUtils.rightTrim(compeContext);
    }

    /**
     * ��ȡ�������������
     * @return ������������̵�ֵ
     */
    public String getCompeContext(){
        return compeContext;
    }

    /**
     * ������������Ƭ��
     * @param notion �����õ���������Ƭ���ֵ
     */
    public void setNotion(String notion){
        this.notion = StringUtils.rightTrim(notion);
    }

    /**
     * ��ȡ��������Ƭ��
     * @return ��������Ƭ���ֵ
     */
    public String getNotion(){
        return notion;
    }

    /**
     * �������Ժ���ǩ�����
     * @param handleText �����õ����Ժ���ǩ�������ֵ
     */
    public void setHandleText(String handleText){
        this.handleText = StringUtils.rightTrim(handleText);
    }

    /**
     * ��ȡ���Ժ���ǩ�����
     * @return ���Ժ���ǩ�������ֵ
     */
    public String getHandleText(){
        return handleText;
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
	/** ���Կͻ��˹�������id */
	public String getRelationOutId() {
		return relationOutId;
	}
	/** ���Կͻ��˹�������id */
	public void setRelationOutId(String relationOutId) {
		this.relationOutId = relationOutId;
	}



	public Date getApplyRecaseTime() {
		return applyRecaseTime;
	}



	public void setApplyRecaseTime(Date applyRecaseTime) {
		this.applyRecaseTime = applyRecaseTime;
	}



	public String getApplyRecaseUser() {
		return applyRecaseUser;
	}



	public void setApplyRecaseUser(String applyRecaseUser) {
		this.applyRecaseUser = applyRecaseUser;
	}



	public Date getAuditRecaseTime() {
		return auditRecaseTime;
	}



	public void setAuditRecaseTime(Date auditRecaseTime) {
		this.auditRecaseTime = auditRecaseTime;
	}



	public String getAuditUser() {
		return auditUser;
	}



	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}



	public Date getVericTime() {
		return vericTime;
	}



	public void setVericTime(Date vericTime) {
		this.vericTime = vericTime;
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

}
