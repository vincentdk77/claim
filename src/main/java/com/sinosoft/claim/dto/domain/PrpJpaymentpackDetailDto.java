package com.sinosoft.claim.dto.domain;
import java.io.Serializable;

import com.sinosoft.utility.string.Str;

/**
 * 定义PrpJpackDetail的数据传输对象类
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>@createdate 2005-05-27</p>
 * @author DtoGenerator
 * @version 1.0
 */
public class PrpJpaymentpackDetailDto implements Serializable{
	//属性packno
	private String packNo = "";
    //属性lonNo
    private String logNo = "";
    //属性fee
    private String fee = "";
	//属性CertiType
    private String CertiType = "";
    //属性visaSerialNo
    private String visaSerialNo = "";
    //领款人 
    private String receiverfullname = "";
    //银行账号
    private String bankAccount = "";
    //银行大类
    private String bankType = "";
    //开户行
    private String bank = "";
    //开户行所在省份
    private String bankProv = "";
    //开户行所在城市
    private String bankCity = "";
    //状态
    private String approveFlag = "";
    //是否有效
    private String flag = "";
    //会计区间
    private String yearMonth = "";
    //核算单位
    private String centerCode = "";
    //凭证号
    private String voucherNo = "";
    //交易流水号
    private String merSeqId = "";
    //退回原因
    private String backReason = "";
    //保单
    private String policyNo = "";
    //代扣税金
    private String taxFee = "";
    //支付日期 单笔交易时转载数据用
    private String payDate = "";
    //本次实付金额
    private String payRefFee = "";
    //备付金余额
    private String reconFee = "";
    
    /**
     * 构造函数
     */       
    public PrpJpaymentpackDetailDto(){
    }

    /**
     * 设置属性CertiType
     * @param CertiType CertiType
     */
    public void setCertiType(String CertiType){
        this.CertiType = Str.rightTrim(CertiType);
    }

    /**
     * 获取属性CertiType
     * @return CertiType
     */
    public String getCertiType(){
        return Str.rightTrim(CertiType);
    }

    public String getPackNo() {
		return packNo;
	}

	public void setPackNo(String packNo) {
		this.packNo = packNo;
	}

    public void setLogNo(String logNo){
        this.logNo = Str.rightTrim(logNo);
    }

    public String getLogNo(){
        return Str.rightTrim(logNo);
    }
	public String getFee() {
		return Str.rightTrim(fee);
	}

	public void setFee(String fee) {
		this.fee = Str.rightTrim(fee);
	}
	
	public String getVisaSerialNo() {
		return visaSerialNo;
	}

	public void setVisaSerialNo(String visaSerialNo) {
		this.visaSerialNo = visaSerialNo;
	}
	
	public String getReceiverfullname() {
		return receiverfullname;
	}

	public void setReceiverfullname(String receiverfullname) {
		this.receiverfullname = receiverfullname;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankProv() {
		return bankProv;
	}

	public void setBankProv(String bankProv) {
		this.bankProv = bankProv;
	}

	public String getBankCity() {
		return bankCity;
	}

	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	public String getApproveFlag() {
		return approveFlag;
	}

	public void setApproveFlag(String approveFlag) {
		this.approveFlag = approveFlag;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	public String getMerSeqId() {
		return merSeqId;
	}

	public void setMerSeqId(String merSeqId) {
		this.merSeqId = merSeqId;
	}

	public String getBackReason() {
		return backReason;
	}

	public void setBackReason(String backReason) {
		this.backReason = backReason;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getTaxFee() {
		return taxFee;
	}

	public void setTaxFee(String taxFee) {
		this.taxFee = taxFee;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getPayRefFee() {
		return payRefFee;
	}

	public void setPayRefFee(String payRefFee) {
		this.payRefFee = payRefFee;
	}

	public String getReconFee() {
		return reconFee;
	}

	public void setReconFee(String reconFee) {
		this.reconFee = reconFee;
	}

	/**
     * @param iSchema 对象PrpJpackDetailSchema
     */       
    public void setSchema(PrpJpaymentpackDetailDto iSchema)
    {
        this.packNo = iSchema.getPackNo();
        this.CertiType = iSchema.getCertiType();
        this.fee = iSchema.getFee();
        this.logNo = iSchema.getLogNo();
        this.visaSerialNo = iSchema.getVisaSerialNo();
        this.receiverfullname = iSchema.getReceiverfullname();
        this.bankAccount = iSchema.getBankAccount();
        this.bankType = iSchema.getBankType();
        this.bank = iSchema.getBank();
        this.bankProv = iSchema.getBankProv();
        this.bankCity = iSchema.getBankCity();
        this.approveFlag = iSchema.getApproveFlag();
        this.flag = iSchema.getFlag();
        this.yearMonth = iSchema.getYearMonth();
        this.centerCode = iSchema.getCenterCode();
        this.voucherNo = iSchema.getVoucherNo();
        this.merSeqId = iSchema.getMerSeqId();
        this.backReason = iSchema.getBackReason();
        this.policyNo = iSchema.getPolicyNo();
        this.taxFee = iSchema.getTaxFee();
        this.payDate = iSchema.getPayDate();
        this.payRefFee = iSchema.getPayRefFee();
        this.reconFee = iSchema.getReconFee();
    }

	
	
}
