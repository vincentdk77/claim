package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是大病医疗接口重开赔案参数中间表的数据传输对象基类<br>
 */
public class PrpLinterRecaseRequestDtoBase extends PrpLinterRequestDto implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键id PK */
    private String id = "";
    /** 属性客户端主键id */
    private String outId = "";
    /** 属性客户端关联主键id */
    private String relationOutId = "";
    /** 属性输入时间 */
    private DateTime inputDate = new DateTime();
    /** 属性保单号码 */
    private String policyno = "";
    /** 属性报案号码 */
    private String registno = "";
    /** 属性立案号码 */
    private String claimno = "";
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
    /** 属性交互成功标识(1成功0未) */
    private String mutualFlag = "";
    /** 属性重开赔案申请时间 */
    private DateTime applyRecaseTime = new DateTime();
    /** 属性重开赔案申请人员代码 */
    private String applyRecaseUser = "";
    /** 属性审核重开赔案时间 */
    private DateTime auditRecaseTime = new DateTime();
    /** 属性审核人员代码 */
    private String auditUser = "";
    /** 属性核赔通过时间 */
    private DateTime vericTime = new DateTime();
    /** 属性核赔人员代码 */
    private String vericUser = "";

    /**
     *  默认构造方法,构造一个默认的PrpLinterRecaseRequestDtoBase对象
     */
    public PrpLinterRecaseRequestDtoBase(){
    }

    /**
     * 设置属性主键id PK
     * @param id 待设置的属性主键id PK的值
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * 获取属性主键id PK
     * @return 属性主键id PK的值
     */
    public String getId(){
        return id;
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
     * 设置属性客户端关联主键id
     * @param relationOutId 待设置的属性客户端关联主键id的值
     */
    public void setRelationOutId(String relationOutId){
        this.relationOutId = StringUtils.rightTrim(relationOutId);
    }

    /**
     * 获取属性客户端关联主键id
     * @return 属性客户端关联主键id的值
     */
    public String getRelationOutId(){
        return relationOutId;
    }

    /**
     * 设置属性输入时间
     * @param inputDate 待设置的属性输入时间的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性输入时间
     * @return 属性输入时间的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性保单号码
     * @param policyno 待设置的属性保单号码的值
     */
    public void setPolicyno(String policyno){
        this.policyno = StringUtils.rightTrim(policyno);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyno(){
        return policyno;
    }

    /**
     * 设置属性报案号码
     * @param registno 待设置的属性报案号码的值
     */
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    /**
     * 获取属性报案号码
     * @return 属性报案号码的值
     */
    public String getRegistno(){
        return registno;
    }

    /**
     * 设置属性立案号码
     * @param claimno 待设置的属性立案号码的值
     */
    public void setClaimno(String claimno){
        this.claimno = StringUtils.rightTrim(claimno);
    }

    /**
     * 获取属性立案号码
     * @return 属性立案号码的值
     */
    public String getClaimno(){
        return claimno;
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
     * 设置属性交互成功标识(1成功0未)
     * @param mutualFlag 待设置的属性交互成功标识(1成功0未)的值
     */
    public void setMutualFlag(String mutualFlag){
        this.mutualFlag = StringUtils.rightTrim(mutualFlag);
    }

    /**
     * 获取属性交互成功标识(1成功0未)
     * @return 属性交互成功标识(1成功0未)的值
     */
    public String getMutualFlag(){
        return mutualFlag;
    }

	public DateTime getApplyRecaseTime() {
		return applyRecaseTime;
	}

	public void setApplyRecaseTime(DateTime applyRecaseTime) {
		this.applyRecaseTime = applyRecaseTime;
	}

	public String getApplyRecaseUser() {
		return applyRecaseUser;
	}

	public void setApplyRecaseUser(String applyRecaseUser) {
		this.applyRecaseUser = applyRecaseUser;
	}

	public DateTime getAuditRecaseTime() {
		return auditRecaseTime;
	}

	public void setAuditRecaseTime(DateTime auditRecaseTime) {
		this.auditRecaseTime = auditRecaseTime;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public DateTime getVericTime() {
		return vericTime;
	}

	public void setVericTime(DateTime vericTime) {
		this.vericTime = vericTime;
	}

	public String getVericUser() {
		return vericUser;
	}

	public void setVericUser(String vericUser) {
		this.vericUser = vericUser;
	}
}
