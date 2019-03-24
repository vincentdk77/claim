package com.sinosoft.ciplatform.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ��������ƽ̨��ѯ������ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CIClaimDemandDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����������� */
    private String claimCode = "";
    /** ���Ա����� */
    private String registNo = "";
    /** ���������� */
    private String claimNo = "";
    /** ���Ա�����Ϣ�Ƿ��ϴ� */
    private String registUploadFlag = "";
    /** ����������Ϣ�Ƿ��ϴ� */
    private String claimUploadFlag = "";
    /** ���Խ᰸��Ϣ�Ƿ��ϴ� */
    private String endCaseUploadFlag = "";
    /** ����ע����Ϣ�Ƿ��ϴ� */
    private String cancelUploadFlag = "";
    /** ���Խ᰸׷����Ϣ�Ƿ��ϴ� */
    private String endCaseAppendUploadFlag = "";
    /** �����ⰸ�᰸У���� */
    private String caseCheckNo = "";
    
    //2011
    private String payinfouploadflag="";
    private String riskcode="";
    private String compensateno="";

    /**
	 * @return the payinfouploadflag
	 */
	public String getPayinfouploadflag() {
		return payinfouploadflag;
	}

	/**
	 * @param payinfouploadflag the payinfouploadflag to set
	 */
	public void setPayinfouploadflag(String payinfouploadflag) {
		this.payinfouploadflag = payinfouploadflag;
	}

	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CIClaimDemandDtoBase����
     */
    public CIClaimDemandDtoBase(){
    }

    /**
     * ���������������
     * @param claimCode �����õ�������������ֵ
     */
    public void setClaimCode(String claimCode){
        this.claimCode = StringUtils.rightTrim(claimCode);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getClaimCode(){
        return claimCode;
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
     * �������Ա�����Ϣ�Ƿ��ϴ�
     * @param registUploadFlag �����õ����Ա�����Ϣ�Ƿ��ϴ���ֵ
     */
    public void setRegistUploadFlag(String registUploadFlag){
        this.registUploadFlag = StringUtils.rightTrim(registUploadFlag);
    }

    /**
     * ��ȡ���Ա�����Ϣ�Ƿ��ϴ�
     * @return ���Ա�����Ϣ�Ƿ��ϴ���ֵ
     */
    public String getRegistUploadFlag(){
        return registUploadFlag;
    }

    /**
     * ��������������Ϣ�Ƿ��ϴ�
     * @param claimUploadFlag �����õ�����������Ϣ�Ƿ��ϴ���ֵ
     */
    public void setClaimUploadFlag(String claimUploadFlag){
        this.claimUploadFlag = StringUtils.rightTrim(claimUploadFlag);
    }

    /**
     * ��ȡ����������Ϣ�Ƿ��ϴ�
     * @return ����������Ϣ�Ƿ��ϴ���ֵ
     */
    public String getClaimUploadFlag(){
        return claimUploadFlag;
    }

    /**
     * �������Խ᰸��Ϣ�Ƿ��ϴ�
     * @param endCaseUploadFlag �����õ����Խ᰸��Ϣ�Ƿ��ϴ���ֵ
     */
    public void setEndCaseUploadFlag(String endCaseUploadFlag){
        this.endCaseUploadFlag = StringUtils.rightTrim(endCaseUploadFlag);
    }

    /**
     * ��ȡ���Խ᰸��Ϣ�Ƿ��ϴ�
     * @return ���Խ᰸��Ϣ�Ƿ��ϴ���ֵ
     */
    public String getEndCaseUploadFlag(){
        return endCaseUploadFlag;
    }

    /**
     * ��������ע����Ϣ�Ƿ��ϴ�
     * @param cancelUploadFlag �����õ�����ע����Ϣ�Ƿ��ϴ���ֵ
     */
    public void setCancelUploadFlag(String cancelUploadFlag){
        this.cancelUploadFlag = StringUtils.rightTrim(cancelUploadFlag);
    }

    /**
     * ��ȡ����ע����Ϣ�Ƿ��ϴ�
     * @return ����ע����Ϣ�Ƿ��ϴ���ֵ
     */
    public String getCancelUploadFlag(){
        return cancelUploadFlag;
    }

    /**
     * ���������ⰸ�᰸У����
     * @param caseCheckNo �����õ������ⰸ�᰸У�����ֵ
     */
    public void setCaseCheckNo(String caseCheckNo){
        this.caseCheckNo = StringUtils.rightTrim(caseCheckNo);
    }

    /**
     * ��ȡ�����ⰸ�᰸У����
     * @return �����ⰸ�᰸У�����ֵ
     */
    public String getCaseCheckNo(){
        return caseCheckNo;
    }

	/**
	 * ��ȡ���� endCaseAppendUploadFlag
	 * @return the endCaseAppendUploadFlag
	 */
	public String getEndCaseAppendUploadFlag() {
		return endCaseAppendUploadFlag;
	}

	/**
	 * �������� endCaseAppendUploadFlag
	 * @param endCaseAppendUploadFlag the endCaseAppendUploadFlag to set
	 */
	public void setEndCaseAppendUploadFlag(String endCaseAppendUploadFlag) {
		this.endCaseAppendUploadFlag = endCaseAppendUploadFlag;
	}

	/**
	 * @return the riskcode
	 */
	public String getRiskcode() {
		return riskcode;
	}

	/**
	 * @param riskcode the riskcode to set
	 */
	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}

	/**
	 * @return the compensateno
	 */
	public String getCompensateno() {
		return compensateno;
	}

	/**
	 * @param compensateno the compensateno to set
	 */
	public void setCompensateno(String compensateno) {
		this.compensateno = compensateno;
	}
    
    
}
