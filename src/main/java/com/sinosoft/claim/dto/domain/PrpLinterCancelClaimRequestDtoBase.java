package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ��������ע����������������ݴ���������<br>
 */
public class PrpLinterCancelClaimRequestDtoBase extends PrpLinterRequestDto implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ��������id PK */
    private String id = "";
    /** ���Կͻ������� */
    private String outId = "";
    /** ���Կͻ��˱�����ˮ�� */
    private String outRegistNo = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Ա����� */
    private String registNo = "";
    /** ���������� */
    private String claimNo = "";
    /** �����¹�����(yyyy-mm-dd) */
    private DateTime damageStartDate = new DateTime();
    /** �����¹�ʱ��(00:00) */
    private String damageStartHour = "";
    /** �����¹�ԭ�� */
    private String damageCode = "";
    /** ���Ա����� */
    private String reportorName = "";
    /** ���Ա���ʱ��(yyyy-mm-dd) */
    private DateTime reportDate = new DateTime();
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
    /** �����⸶�˴�, Ĭ��Ϊ0 */
    private double lossesNumber = 0D;
    /** ���Բ����˴��� */
    private String operatorCode = "";
    /** ���Բ��������� */
    private String operatorName = "";
    /** �������⴦����� */
    private String makeCom = "";
    /** �������⴦��������� */
    private String makeComName = "";
    /** ��������ʱ�� */
    private DateTime inputDate = new DateTime();
    /** ���Ա�������¼ */
    private String remark = "";
    /** �����¹ʾ��������¹�����״ */
    private String context = "";
    /** ����ע��ʱ�� */
    private DateTime cancelDate = new DateTime();
    /** ����ע���˴��� */
    private String dealerCode = "";
    /** ����ע��ԭ�� */
    private String cancelContext = "";
    /** ����ע��/�����־ */
    private String caseType = "";
    /** ����ע��/����ԭ�� */
    private String cancelReson = "";
    /** ���Ժ�������Ƭ�� */
    private String notion = "";
    /** ���Ժ���ǩ��������� */
    private String handleText = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterCancelClaimRequestDtoBase����
     */
    public PrpLinterCancelClaimRequestDtoBase(){
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
     * �������Կͻ�������
     * @param outId �����õ����Կͻ���������ֵ
     */
    public void setOutId(String outId){
        this.outId = StringUtils.rightTrim(outId);
    }

    /**
     * ��ȡ���Կͻ�������
     * @return ���Կͻ���������ֵ
     */
    public String getOutId(){
        return outId;
    }

    /**
     * �������Ա�����
     * @param policyNo �����õ����Ա����ŵ�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getPolicyno(){
        return policyNo;
    }

    /**
     * �������Ա�����
     * @param registNo �����õ����Ա����ŵ�ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ��������������
     * @param claimNo �����õ����������ŵ�ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ����������
     * @return ���������ŵ�ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * ���������¹�����(yyyy-mm-dd)
     * @param damageStartDate �����õ������¹�����(yyyy-mm-dd)��ֵ
     */
    public void setDamageStartDate(DateTime damageStartDate){
        this.damageStartDate = damageStartDate;
    }

    /**
     * ��ȡ�����¹�����(yyyy-mm-dd)
     * @return �����¹�����(yyyy-mm-dd)��ֵ
     */
    public DateTime getDamageStartDate(){
        return damageStartDate;
    }

    /**
     * ���������¹�ʱ��(00:00)
     * @param damageStartHour �����õ������¹�ʱ��(00:00)��ֵ
     */
    public void setDamageStartHour(String damageStartHour){
        this.damageStartHour = StringUtils.rightTrim(damageStartHour);
    }

    /**
     * ��ȡ�����¹�ʱ��(00:00)
     * @return �����¹�ʱ��(00:00)��ֵ
     */
    public String getDamageStartHour(){
        return damageStartHour;
    }

    /**
     * ���������¹�ԭ��
     * @param damageCode �����õ������¹�ԭ���ֵ
     */
    public void setDamageCode(String damageCode){
        this.damageCode = StringUtils.rightTrim(damageCode);
    }

    /**
     * ��ȡ�����¹�ԭ��
     * @return �����¹�ԭ���ֵ
     */
    public String getDamageCode(){
        return damageCode;
    }

    /**
     * �������Ա�����
     * @param reportorName �����õ����Ա����˵�ֵ
     */
    public void setReportorName(String reportorName){
        this.reportorName = StringUtils.rightTrim(reportorName);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����˵�ֵ
     */
    public String getReportorName(){
        return reportorName;
    }

    /**
     * �������Ա���ʱ��(yyyy-mm-dd)
     * @param reportDate �����õ����Ա���ʱ��(yyyy-mm-dd)��ֵ
     */
    public void setReportDate(DateTime reportDate){
        this.reportDate = reportDate;
    }

    /**
     * ��ȡ���Ա���ʱ��(yyyy-mm-dd)
     * @return ���Ա���ʱ��(yyyy-mm-dd)��ֵ
     */
    public DateTime getReportDate(){
        return reportDate;
    }

    /**
     * �������Ա���ʱ��(00:00)
     * @param reportHour �����õ����Ա���ʱ��(00:00)��ֵ
     */
    public void setReportHour(String reportHour){
        this.reportHour = StringUtils.rightTrim(reportHour);
    }

    /**
     * ��ȡ���Ա���ʱ��(00:00)
     * @return ���Ա���ʱ��(00:00)��ֵ
     */
    public String getReportHour(){
        return reportHour;
    }

    /**
     * �������Ա�����ʽ
     * @param reportType �����õ����Ա�����ʽ��ֵ
     */
    public void setReportType(String reportType){
        this.reportType = StringUtils.rightTrim(reportType);
    }

    /**
     * ��ȡ���Ա�����ʽ
     * @return ���Ա�����ʽ��ֵ
     */
    public String getReportType(){
        return reportType;
    }

    /**
     * ����������ϵ��
     * @param linkerName �����õ�������ϵ�˵�ֵ
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * ��ȡ������ϵ��
     * @return ������ϵ�˵�ֵ
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * ����������ϵ�绰
     * @param phoneNumber �����õ�������ϵ�绰��ֵ
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * ��ȡ������ϵ�绰
     * @return ������ϵ�绰��ֵ
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * ����������ϵ��ַ
     * @param linkerAddress �����õ�������ϵ��ַ��ֵ
     */
    public void setLinkerAddress(String linkerAddress){
        this.linkerAddress = StringUtils.rightTrim(linkerAddress);
    }

    /**
     * ��ȡ������ϵ��ַ
     * @return ������ϵ��ַ��ֵ
     */
    public String getLinkerAddress(){
        return linkerAddress;
    }

    /**
     * �����������¹��߹�ϵ
     * @param clauseType �����õ��������¹��߹�ϵ��ֵ
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * ��ȡ�������¹��߹�ϵ
     * @return �������¹��߹�ϵ��ֵ
     */
    public String getClauseType(){
        return clauseType;
    }

    /**
     * ���������¹ʵص�
     * @param damageAddress �����õ������¹ʵص��ֵ
     */
    public void setDamageAddress(String damageAddress){
        this.damageAddress = StringUtils.rightTrim(damageAddress);
    }

    /**
     * ��ȡ�����¹ʵص�
     * @return �����¹ʵص��ֵ
     */
    public String getDamageAddress(){
        return damageAddress;
    }

    /**
     * ���������¹�����
     * @param damageTypeCode �����õ������¹����͵�ֵ
     */
    public void setDamageTypeCode(String damageTypeCode){
        this.damageTypeCode = StringUtils.rightTrim(damageTypeCode);
    }

    /**
     * ��ȡ�����¹�����
     * @return �����¹����͵�ֵ
     */
    public String getDamageTypeCode(){
        return damageTypeCode;
    }

    /**
     * ���������⸶�˴�, Ĭ��Ϊ0
     * @param lossesNumber �����õ������⸶�˴�, Ĭ��Ϊ0��ֵ
     */
    public void setLossesNumber(double lossesNumber){
        this.lossesNumber = lossesNumber;
    }

    /**
     * ��ȡ�����⸶�˴�, Ĭ��Ϊ0
     * @return �����⸶�˴�, Ĭ��Ϊ0��ֵ
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
     * �����������⴦���������
     * @param makeComName �����õ��������⴦��������Ƶ�ֵ
     */
    public void setMakeComName(String makeComName){
        this.makeComName = StringUtils.rightTrim(makeComName);
    }

    /**
     * ��ȡ�������⴦���������
     * @return �������⴦��������Ƶ�ֵ
     */
    public String getMakeComName(){
        return makeComName;
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
     * �������Ա�������¼
     * @param remark �����õ����Ա�������¼��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Ա�������¼
     * @return ���Ա�������¼��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ���������¹ʾ��������¹�����״
     * @param context �����õ������¹ʾ��������¹�����״��ֵ
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * ��ȡ�����¹ʾ��������¹�����״
     * @return �����¹ʾ��������¹�����״��ֵ
     */
    public String getContext(){
        return context;
    }

    /**
     * ��������ע��ʱ��
     * @param cancelDate �����õ�����ע��ʱ���ֵ
     */
    public void setCancelDate(DateTime cancelDate){
        this.cancelDate = cancelDate;
    }

    /**
     * ��ȡ����ע��ʱ��
     * @return ����ע��ʱ���ֵ
     */
    public DateTime getCancelDate(){
        return cancelDate;
    }

    /**
     * ��������ע���˴���
     * @param dealerCode �����õ�����ע���˴����ֵ
     */
    public void setDealerCode(String dealerCode){
        this.dealerCode = StringUtils.rightTrim(dealerCode);
    }

    /**
     * ��ȡ����ע���˴���
     * @return ����ע���˴����ֵ
     */
    public String getDealerCode(){
        return dealerCode;
    }

    /**
     * ��������ע��ԭ��
     * @param cancelContext �����õ�����ע��ԭ���ֵ
     */
    public void setCancelContext(String cancelContext){
        this.cancelContext = StringUtils.rightTrim(cancelContext);
    }

    /**
     * ��ȡ����ע��ԭ��
     * @return ����ע��ԭ���ֵ
     */
    public String getCancelContext(){
        return cancelContext;
    }

	public String getOutRegistNo() {
		return outRegistNo;
	}

	public void setOutRegistNo(String outRegistNo) {
		this.outRegistNo = outRegistNo;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getCancelReson() {
		return cancelReson;
	}

	public void setCancelReson(String cancelReson) {
		this.cancelReson = cancelReson;
	}

	public String getNotion() {
		return notion;
	}

	public void setNotion(String notion) {
		this.notion = notion;
	}

	public String getHandleText() {
		return handleText;
	}

	public void setHandleText(String handleText) {
		this.handleText = handleText;
	}

}
