package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sysframework.common.util.StringUtils;

public class ReCaseRequestInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** 属性客户端主键id */
    private String outId = "";
    /** 属性客户端关联主键id */
    private String relationOutId = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性立案号码 */
    private String claimNo = "";
    /** 属性重开赔案原因 */
    private String appRecaseReason = "";
    /** 属性重开审批片语 */
    private String reClaimNotion = "";
    /** 属性重开审核审批意见 */
    private String reClaimHandleText = "";
    /** 属性赔付人次，默认为0 */
    private double lossesNumber = 0D;
    /** 属性操作人代码 */
    private String operatorCode = "";
    /** 属性操作人名称 */
    private String operatorName = "";
    /** 属性理赔处理机构 */
    private String makeCom = "";
    /** 属性处理机构名称 */
    private String makeComName = "";
    /** 属性被保险人开户银行 */
    private String bank = "";
    /** 属性收款人全称 */
    private String receiverName = "";
    /** 属性开户账号 */
    private String account = "";
    /** 属性确认开户账号 */
    private String accountOK = "";
    /** 属性零赔付原因 */
    private String zeroLossType = "";
    /** 属性费用合计，默认0.00 */
    private double sumNoDutyFee = 0D;
    /** 属性赔款合计，默认0.00 */
    private double prplCompensateSumPaid = 0D;
    /** 属性已预付赔款，默认0.00 */
    private double prplCompensateSumPrePaid = 0D;
    /** 属性已预付费用，默认0.00 */
    private double sumChargePaid = 0D;
    /** 属性本次给付金额，默认0.00 */
    private double sumThisPaid = 0D;
    /** 属性赔款计算过程 */
    private String compeContext = "";
    /** 属性审批片语 */
    private String notion = "";
    /** 属性核赔签署意见 */
    private String handleText = "";
    /** 属性重开赔案申请时间 */
    private Date applyRecaseTime = new Date();
    /** 属性重开赔案申请人员代码 */
    private String applyRecaseUser = "";
    /** 属性审核重开赔案时间 */
    private Date auditRecaseTime = new Date();
    /** 属性审核人员代码 */
    private String auditUser = "";
    /** 属性核赔通过时间 */
    private Date vericTime = new Date();
    /** 属性核赔人员代码 */
    private String vericUser = "";
    /** 属性事故者信息 */
	private AccidentPersonInfoDto[] accidentPersonInfoDto;
	/** 属性调度补充说明信息 */
	private SchedExtInfoDto[] schedExtInfoDto;
	/** 属性立案索赔申请人信息 */
	private ClaimAppDto[] claimAppDto;
	/** 属性单证信息 */
	private CertifyInfoDto[] certifyInfoDto;
	/** 属性计算书费用信息 */
	private CompeFeeInfoDto[] compeFeeInfoDto;
	/** 属性计算书赔款费用信息 */
	private CompePayFeeInfoDto[] compePayFeeInfoDto;
	/** 属性计算书理算清单信息 */
	private CompeInvMainInfo[] compeInvMainInfo;
	
	private InjuryPersonInfoDto injuryPersonInfoDto;
    /**
     *  默认构造方法,构造一个默认的ReCaseRequestInfo对象
     */
    public ReCaseRequestInfo(){
    }

    

    /**
     * 设置属性客户端主键id
     * @param outId 待设置的属性客户端主键id的值
     */
    public void setOutId(String outId){
        this.outId = StringUtils.rightTrim(outId);
    }

    /**
     * 获取属性客户端主键id
     * @return 属性客户端主键id的值
     */
    public String getOutId(){
        return outId;
    }

    

    /**
     * 设置属性保单号码
     * @param policyNo 待设置的属性保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性报案号码
     * @param registNo 待设置的属性报案号码的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号码
     * @return 属性报案号码的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性立案号码
     * @param claimNo 待设置的属性立案号码的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性立案号码
     * @return 属性立案号码的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性重开赔案原因
     * @param appRecaseReason 待设置的属性重开赔案原因的值
     */
    public void setAppRecaseReason(String appRecaseReason){
        this.appRecaseReason = StringUtils.rightTrim(appRecaseReason);
    }

    /**
     * 获取属性重开赔案原因
     * @return 属性重开赔案原因的值
     */
    public String getAppRecaseReason(){
        return appRecaseReason;
    }

    /**
     * 设置属性重开审批片语
     * @param reClaimNotion 待设置的属性重开审批片语的值
     */
    public void setReClaimNotion(String reClaimNotion){
        this.reClaimNotion = StringUtils.rightTrim(reClaimNotion);
    }

    /**
     * 获取属性重开审批片语
     * @return 属性重开审批片语的值
     */
    public String getReClaimNotion(){
        return reClaimNotion;
    }

    /**
     * 设置属性重开审核审批意见
     * @param reClaimHandleText 待设置的属性重开审核审批意见的值
     */
    public void setReClaimHandleText(String reClaimHandleText){
        this.reClaimHandleText = StringUtils.rightTrim(reClaimHandleText);
    }

    /**
     * 获取属性重开审核审批意见
     * @return 属性重开审核审批意见的值
     */
    public String getReClaimHandleText(){
        return reClaimHandleText;
    }

    /**
     * 设置属性赔付人次，默认为0
     * @param lossesNumber 待设置的属性赔付人次，默认为0的值
     */
    public void setLossesNumber(double lossesNumber){
        this.lossesNumber = lossesNumber;
    }

    /**
     * 获取属性赔付人次，默认为0
     * @return 属性赔付人次，默认为0的值
     */
    public double getLossesNumber(){
        return lossesNumber;
    }

    /**
     * 设置属性操作人代码
     * @param operatorCode 待设置的属性操作人代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性操作人代码
     * @return 属性操作人代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性操作人名称
     * @param operatorName 待设置的属性操作人名称的值
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * 获取属性操作人名称
     * @return 属性操作人名称的值
     */
    public String getOperatorName(){
        return operatorName;
    }

    /**
     * 设置属性理赔处理机构
     * @param makeCom 待设置的属性理赔处理机构的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性理赔处理机构
     * @return 属性理赔处理机构的值
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * 设置属性处理机构名称
     * @param makeComName 待设置的属性处理机构名称的值
     */
    public void setMakeComName(String makeComName){
        this.makeComName = StringUtils.rightTrim(makeComName);
    }

    /**
     * 获取属性处理机构名称
     * @return 属性处理机构名称的值
     */
    public String getMakeComName(){
        return makeComName;
    }

    /**
     * 设置属性被保险人开户银行
     * @param bank 待设置的属性被保险人开户银行的值
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * 获取属性被保险人开户银行
     * @return 属性被保险人开户银行的值
     */
    public String getBank(){
        return bank;
    }

    /**
     * 设置属性收款人全称
     * @param receiverName 待设置的属性收款人全称的值
     */
    public void setReceiverName(String receiverName){
        this.receiverName = StringUtils.rightTrim(receiverName);
    }

    /**
     * 获取属性收款人全称
     * @return 属性收款人全称的值
     */
    public String getReceiverName(){
        return receiverName;
    }

    /**
     * 设置属性开户账号
     * @param account 待设置的属性开户账号的值
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * 获取属性开户账号
     * @return 属性开户账号的值
     */
    public String getAccount(){
        return account;
    }

    /**
     * 设置属性确认开户账号
     * @param accountOK 待设置的属性确认开户账号的值
     */
    public void setAccountOK(String accountOK){
        this.accountOK = StringUtils.rightTrim(accountOK);
    }

    /**
     * 获取属性确认开户账号
     * @return 属性确认开户账号的值
     */
    public String getAccountOK(){
        return accountOK;
    }

    /**
     * 设置属性零赔付原因
     * @param zeroLossType 待设置的属性零赔付原因的值
     */
    public void setZeroLossType(String zeroLossType){
        this.zeroLossType = StringUtils.rightTrim(zeroLossType);
    }

    /**
     * 获取属性零赔付原因
     * @return 属性零赔付原因的值
     */
    public String getZeroLossType(){
        return zeroLossType;
    }

    /**
     * 设置属性费用合计，默认0.00
     * @param sumNoDutyFee 待设置的属性费用合计，默认0.00的值
     */
    public void setSumNoDutyFee(double sumNoDutyFee){
        this.sumNoDutyFee = sumNoDutyFee;
    }

    /**
     * 获取属性费用合计，默认0.00
     * @return 属性费用合计，默认0.00的值
     */
    public double getSumNoDutyFee(){
        return sumNoDutyFee;
    }

    /**
     * 设置属性赔款合计，默认0.00
     * @param prplCompensateSumPaid 待设置的属性赔款合计，默认0.00的值
     */
    public void setPrplCompensateSumPaid(double prplCompensateSumPaid){
        this.prplCompensateSumPaid = prplCompensateSumPaid;
    }

    /**
     * 获取属性赔款合计，默认0.00
     * @return 属性赔款合计，默认0.00的值
     */
    public double getPrplCompensateSumPaid(){
        return prplCompensateSumPaid;
    }

    /**
     * 设置属性已预付赔款，默认0.00
     * @param prplCompensateSumPrePaid 待设置的属性已预付赔款，默认0.00的值
     */
    public void setPrplCompensateSumPrePaid(double prplCompensateSumPrePaid){
        this.prplCompensateSumPrePaid = prplCompensateSumPrePaid;
    }

    /**
     * 获取属性已预付赔款，默认0.00
     * @return 属性已预付赔款，默认0.00的值
     */
    public double getPrplCompensateSumPrePaid(){
        return prplCompensateSumPrePaid;
    }

    /**
     * 设置属性已预付费用，默认0.00
     * @param sumChargePaid 待设置的属性已预付费用，默认0.00的值
     */
    public void setSumChargePaid(double sumChargePaid){
        this.sumChargePaid = sumChargePaid;
    }

    /**
     * 获取属性已预付费用，默认0.00
     * @return 属性已预付费用，默认0.00的值
     */
    public double getSumChargePaid(){
        return sumChargePaid;
    }

    /**
     * 设置属性本次给付金额，默认0.00
     * @param sumThisPaid 待设置的属性本次给付金额，默认0.00的值
     */
    public void setSumThisPaid(double sumThisPaid){
        this.sumThisPaid = sumThisPaid;
    }

    /**
     * 获取属性本次给付金额，默认0.00
     * @return 属性本次给付金额，默认0.00的值
     */
    public double getSumThisPaid(){
        return sumThisPaid;
    }

    /**
     * 设置属性赔款计算过程
     * @param compeContext 待设置的属性赔款计算过程的值
     */
    public void setCompeContext(String compeContext){
        this.compeContext = StringUtils.rightTrim(compeContext);
    }

    /**
     * 获取属性赔款计算过程
     * @return 属性赔款计算过程的值
     */
    public String getCompeContext(){
        return compeContext;
    }

    /**
     * 设置属性审批片语
     * @param notion 待设置的属性审批片语的值
     */
    public void setNotion(String notion){
        this.notion = StringUtils.rightTrim(notion);
    }

    /**
     * 获取属性审批片语
     * @return 属性审批片语的值
     */
    public String getNotion(){
        return notion;
    }

    /**
     * 设置属性核赔签署意见
     * @param handleText 待设置的属性核赔签署意见的值
     */
    public void setHandleText(String handleText){
        this.handleText = StringUtils.rightTrim(handleText);
    }

    /**
     * 获取属性核赔签署意见
     * @return 属性核赔签署意见的值
     */
    public String getHandleText(){
        return handleText;
    }

    /**
	 * 设置属性事故者信息
	 * 
	 * @param accidentPersonInfoDto
	 *            待设置的属性事故者信息的值
	 */
	public void setAccidentPersonInfoDto(AccidentPersonInfoDto[] accidentPersonInfoDto) {
		this.accidentPersonInfoDto = accidentPersonInfoDto;
	}

	/**
	 * 获取属性事故者信息
	 * 
	 * @return 属性事故者信息的值
	 */
	public AccidentPersonInfoDto[] getAccidentPersonInfoDto() {
		return accidentPersonInfoDto;
	}

	/**
	 * 设置属性调度补充说明信息
	 * 
	 * @param schedExtInfoDto
	 *            待设置的属性调度补充说明信息的值
	 */
	public void setSchedExtInfoDto(SchedExtInfoDto[] schedExtInfoDto) {
		this.schedExtInfoDto = schedExtInfoDto;
	}

	/**
	 * 获取属性调度补充说明信息
	 * 
	 * @return 属性调度补充说明信息的值
	 */
	public SchedExtInfoDto[] getSchedExtInfoDto() {
		return schedExtInfoDto;
	}

	/**
	 * 设置属性立案索赔申请人信息
	 * 
	 * @param claimAppDto
	 *            待设置的属性立案索赔申请人信息的值
	 */
	public void setClaimAppDto(ClaimAppDto[] claimAppDto) {
		this.claimAppDto = claimAppDto;
	}

	/**
	 * 获取属性立案索赔申请人信息
	 * 
	 * @return 属性立案索赔申请人信息的值
	 */
	public ClaimAppDto[] getClaimAppDto() {
		return claimAppDto;
	}


	/**
	 * 设置属性单证信息
	 * 
	 * @param certifyInfoDto
	 *            待设置的属性单证信息的值
	 */
	public void setCertifyInfoDto(CertifyInfoDto[] certifyInfoDto) {
		this.certifyInfoDto = certifyInfoDto;
	}

	/**
	 * 获取属性单证信息
	 * 
	 * @return 属性单证信息的值
	 */
	public CertifyInfoDto[] getCertifyInfoDto() {
		return certifyInfoDto;
	}

	/**
	 * 设置属性计算书费用信息
	 * 
	 * @param compeFeeInfoDto
	 *            待设置的属性计算书费用信息的值
	 */
	public void setCompeFeeInfoDto(CompeFeeInfoDto[] compeFeeInfoDto) {
		this.compeFeeInfoDto = compeFeeInfoDto;
	}

	/**
	 * 获取属性计算书费用信息
	 * 
	 * @return 属性计算书费用信息的值
	 */
	public CompeFeeInfoDto[] getCompeFeeInfoDto() {
		return compeFeeInfoDto;
	}

	/**
	 * 设置属性计算书赔款费用信息
	 * 
	 * @param compePayFeeInfoDto
	 *            待设置的属性计算书赔款费用信息的值
	 */
	public void setCompePayFeeInfoDto(CompePayFeeInfoDto[] compePayFeeInfoDto) {
		this.compePayFeeInfoDto = compePayFeeInfoDto;
	}

	/**
	 * 获取属性计算书赔款费用信息
	 * 
	 * @return 属性计算书赔款费用信息的值
	 */
	public CompePayFeeInfoDto[] getCompePayFeeInfoDto() {
		return compePayFeeInfoDto;
	}

	/**
	 * 设置属性计算书赔款费用信息
	 * 
	 * @param compePayFeeInfoDto
	 *            待设置的属性计算书赔款费用信息的值
	 */
	public void setCompeInvMainInfo(CompeInvMainInfo[] compeInvMainInfo) {
		this.compeInvMainInfo = compeInvMainInfo;
	}

	/**
	 * 获取属性计算书赔款费用信息
	 * 
	 * @return 属性计算书赔款费用信息的值
	 */
	public CompeInvMainInfo[] getCompeInvMainInfo() {
		return compeInvMainInfo;
	}
	/** 属性客户端关联主键id */
	public String getRelationOutId() {
		return relationOutId;
	}
	/** 属性客户端关联主键id */
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
