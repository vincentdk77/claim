package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLRegistRPolicy�ⰸ��������������ݴ���������<br>
 * ������ 2006-06-09 11:05:56.144<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLRegistRPolicyDtoBase implements Serializable{
	private static final long serialVersionUID = 1L;
	/** ���Ա����� */
    private String registNo = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���������� */
    private String claimNo = "";
    /** ���Ա������� */
    private String policyType = "";
    /** ���Թ��������� */
    private String flowId = "";
    /** ���Ա�ע */
    private String remark = "";
    /** �����Ƿ���Ч�ı�� */
    private String validStatus = "";
    /** ���Ա�־ */
    private String flag = "";
    /** �������� */
    private String riskCode = "";
    /** ���Ա������ */
    private String registFlag = "";
    /** ����ע��ԭ����� */
    private String cancelReason = "";
    /** ����ע��ԭ������ **/
    private String cancelReasonName = "";
    /** ����ע��ʱ�� **/
    private String cancelDate = "";
    /** ����ע������Ա���� **/
    private String cancelOperaterCode = "";
    /** ����ע������ **/
    private String cancelComCode = "";
    /** ���Ա�������������Ч��־ */
    private String registValidStatus = "";
    /** ���Ա�������������¼������ */
    private DateTime inputDate = new DateTime();
    /** ����¼���˴��� */
    private String operatorCode = "";
    /** ����¼���˹������� */
    private String registComCode = ""; 
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLRegistRPolicyDtoBase����
     */
    public PrpLRegistRPolicyDtoBase(){
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
    public String getPolicyNo(){
        return policyNo;
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
     * �������Ա�������
     * @param policyType �����õ����Ա������͵�ֵ
     */
    public void setPolicyType(String policyType){
        this.policyType = StringUtils.rightTrim(policyType);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա������͵�ֵ
     */
    public String getPolicyType(){
        return policyType;
    }

    /**
     * �������Թ���������
     * @param flowId �����õ����Թ����������ֵ
     */
    public void setFlowId(String flowId){
        this.flowId = StringUtils.rightTrim(flowId);
    }

    /**
     * ��ȡ���Թ���������
     * @return ���Թ����������ֵ
     */
    public String getFlowId(){
        return flowId;
    }

    /**
     * �������Ա�ע
     * @param remark �����õ����Ա�ע��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Ա�ע
     * @return ���Ա�ע��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ���������Ƿ���Ч�ı��
     * @param validStatus �����õ������Ƿ���Ч�ı�ǵ�ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ�����Ƿ���Ч�ı��
     * @return �����Ƿ���Ч�ı�ǵ�ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * �������Ա�־
     * @param flag �����õ����Ա�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־
     * @return ���Ա�־��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * ������������
     * @param riskCode �����õ��������ֵ�ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ��������
     * @return �������ֵ�ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * �������Ա������
     * @param registFlag �����õ����Ա�����ǵ�ֵ
     */
    public void setRegistFlag(String registFlag){
        this.registFlag = StringUtils.rightTrim(registFlag);
    }

    /**
     * ��ȡ���Ա������
     * @return ���Ա�����ǵ�ֵ
     */
    public String getRegistFlag(){
        return registFlag;
    }

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getCancelReasonName() {
		return cancelReasonName;
	}

	public void setCancelReasonName(String cancelReasonName) {
		this.cancelReasonName = cancelReasonName;
	}

	/**
	 * @return the cancelDate
	 */
	public String getCancelDate() {
		return cancelDate;
	}

	/**
	 * @param cancelDate the cancelDate to set
	 */
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}

	/**
	 * @return the cancelOperaterCode
	 */
	public String getCancelOperaterCode() {
		return cancelOperaterCode;
	}

	/**
	 * @param cancelOperaterCode the cancelOperaterCode to set
	 */
	public void setCancelOperaterCode(String cancelOperaterCode) {
		this.cancelOperaterCode = cancelOperaterCode;
	}

	/**
	 * @return the cancelComCode
	 */
	public String getCancelComCode() {
		return cancelComCode;
	}

	/**
	 * @param cancelComCode the cancelComCode to set
	 */
	public void setCancelComCode(String cancelComCode) {
		this.cancelComCode = cancelComCode;
	}
	/**
     * ��������registValidStatus
     * @param registValidStatus �����õ�����registValidStatus��ֵ
     */
    public void setRegistValidStatus(String registValidStatus){
        this.registValidStatus = StringUtils.rightTrim(registValidStatus);
    }

    /**
     * ��ȡ����registValidStatus
     * @return ����registValidStatus��ֵ
     */
    public String getRegistValidStatus(){
        return registValidStatus;
    }

    /**
     * ��������inputDate
     * @param inputDate �����õ�����inputDate��ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ����inputDate
     * @return ����inputDate��ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * ��������operatorCode
     * @param operatorCode �����õ�����operatorCode��ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ����operatorCode
     * @return ����operatorCode��ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * ��������registComCode
     * @param registComCode �����õ�����registComCode��ֵ
     */
    public void setRegistComCode(String registComCode){
        this.registComCode = StringUtils.rightTrim(registComCode);
    }

    /**
     * ��ȡ����registComCode
     * @return ����registComCode��ֵ
     */
    public String getRegistComCode(){
        return registComCode;
    }
}
