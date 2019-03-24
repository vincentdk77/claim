package com.sinosoft.claim.dto.domain;
import java.io.Serializable;

import com.sinosoft.utility.string.Str;

/**
 * ����PrpJpackDetail�����ݴ��������
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>@createdate 2005-05-27</p>
 * @author DtoGenerator
 * @version 1.0
 */
public class PrpJpaymentpackDetailDto implements Serializable{
	//����packno
	private String packNo = "";
    //����lonNo
    private String logNo = "";
    //����fee
    private String fee = "";
	//����CertiType
    private String CertiType = "";
    //����visaSerialNo
    private String visaSerialNo = "";
    //����� 
    private String receiverfullname = "";
    //�����˺�
    private String bankAccount = "";
    //���д���
    private String bankType = "";
    //������
    private String bank = "";
    //����������ʡ��
    private String bankProv = "";
    //���������ڳ���
    private String bankCity = "";
    //״̬
    private String approveFlag = "";
    //�Ƿ���Ч
    private String flag = "";
    //�������
    private String yearMonth = "";
    //���㵥λ
    private String centerCode = "";
    //ƾ֤��
    private String voucherNo = "";
    //������ˮ��
    private String merSeqId = "";
    //�˻�ԭ��
    private String backReason = "";
    //����
    private String policyNo = "";
    //����˰��
    private String taxFee = "";
    //֧������ ���ʽ���ʱת��������
    private String payDate = "";
    //����ʵ�����
    private String payRefFee = "";
    //���������
    private String reconFee = "";
    
    /**
     * ���캯��
     */       
    public PrpJpaymentpackDetailDto(){
    }

    /**
     * ��������CertiType
     * @param CertiType CertiType
     */
    public void setCertiType(String CertiType){
        this.CertiType = Str.rightTrim(CertiType);
    }

    /**
     * ��ȡ����CertiType
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
     * @param iSchema ����PrpJpackDetailSchema
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
