package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�ƽӿ��ؿ��ⰸ�����м������ݴ���������<br>
 */
public class PrpLinterRecaseRequestDtoBase extends PrpLinterRequestDto implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ��������id PK */
    private String id = "";
    /** ���Կͻ�������id */
    private String outId = "";
    /** ���Կͻ��˹�������id */
    private String relationOutId = "";
    /** ��������ʱ�� */
    private DateTime inputDate = new DateTime();
    /** ���Ա������� */
    private String policyno = "";
    /** ���Ա������� */
    private String registno = "";
    /** ������������ */
    private String claimno = "";
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
    /** ���Խ����ɹ���ʶ(1�ɹ�0δ) */
    private String mutualFlag = "";
    /** �����ؿ��ⰸ����ʱ�� */
    private DateTime applyRecaseTime = new DateTime();
    /** �����ؿ��ⰸ������Ա���� */
    private String applyRecaseUser = "";
    /** ��������ؿ��ⰸʱ�� */
    private DateTime auditRecaseTime = new DateTime();
    /** ���������Ա���� */
    private String auditUser = "";
    /** ���Ժ���ͨ��ʱ�� */
    private DateTime vericTime = new DateTime();
    /** ���Ժ�����Ա���� */
    private String vericUser = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterRecaseRequestDtoBase����
     */
    public PrpLinterRecaseRequestDtoBase(){
    }

    /**
     * ������������id PK
     * @param id �����õ���������id PK��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ��������id PK
     * @return ��������id PK��ֵ
     */
    public String getId(){
        return id;
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
     * �������Կͻ��˹�������id
     * @param relationOutId �����õ����Կͻ��˹�������id��ֵ
     */
    public void setRelationOutId(String relationOutId){
        this.relationOutId = StringUtils.rightTrim(relationOutId);
    }

    /**
     * ��ȡ���Կͻ��˹�������id
     * @return ���Կͻ��˹�������id��ֵ
     */
    public String getRelationOutId(){
        return relationOutId;
    }

    /**
     * ������������ʱ��
     * @param inputDate �����õ���������ʱ���ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ��������ʱ��
     * @return ��������ʱ���ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * �������Ա�������
     * @param policyno �����õ����Ա��������ֵ
     */
    public void setPolicyno(String policyno){
        this.policyno = StringUtils.rightTrim(policyno);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyno(){
        return policyno;
    }

    /**
     * �������Ա�������
     * @param registno �����õ����Ա��������ֵ
     */
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getRegistno(){
        return registno;
    }

    /**
     * ����������������
     * @param claimno �����õ��������������ֵ
     */
    public void setClaimno(String claimno){
        this.claimno = StringUtils.rightTrim(claimno);
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public String getClaimno(){
        return claimno;
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
     * �������Խ����ɹ���ʶ(1�ɹ�0δ)
     * @param mutualFlag �����õ����Խ����ɹ���ʶ(1�ɹ�0δ)��ֵ
     */
    public void setMutualFlag(String mutualFlag){
        this.mutualFlag = StringUtils.rightTrim(mutualFlag);
    }

    /**
     * ��ȡ���Խ����ɹ���ʶ(1�ɹ�0δ)
     * @return ���Խ����ɹ���ʶ(1�ɹ�0δ)��ֵ
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
