package com.sinosoft.claimprop.common.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CiClaimPropDemand�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CiClaimPropDemandDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����claimCode */
    private String claimCode = "";
    /** ����cancellationNo */
    private String cancellationNo = "";
    /** ����policyNo */
    private String policyNo = "";
    /** ����registNo */
    private String registNo = "";
    /** ����claimNo */
    private String claimNo = "";
    /** ����registUploadFlag */
    private String registUploadFlag = "";
    /** ����claimUploadFlag */
    private String claimUploadFlag = "";
    /** ����endCaseUploadFlag */
    private String endCaseUploadFlag = "";
    /** ����cancelUploadFlag */
    private String cancelUploadFlag = "";
    /** ����endAddcode */
    private String endAddcode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CiClaimPropDemandDtoBase����
     */
    public CiClaimPropDemandDtoBase(){
    }

    /**
     * ��������claimCode
     * @param claimCode �����õ�����claimCode��ֵ
     */
    public void setClaimCode(String claimCode){
        this.claimCode = StringUtils.rightTrim(claimCode);
    }

    /**
     * ��ȡ����claimCode
     * @return ����claimCode��ֵ
     */
    public String getClaimCode(){
        return claimCode;
    }

    /**
     * ��������cancellationNo
     * @param cancellationNo �����õ�����cancellationNo��ֵ
     */
    public void setCancellationNo(String cancellationNo){
        this.cancellationNo = StringUtils.rightTrim(cancellationNo);
    }

    /**
     * ��ȡ����cancellationNo
     * @return ����cancellationNo��ֵ
     */
    public String getCancellationNo(){
        return cancellationNo;
    }

    /**
     * ��������policyNo
     * @param policyNo �����õ�����policyNo��ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����policyNo
     * @return ����policyNo��ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ��������registNo
     * @param registNo �����õ�����registNo��ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ����registNo
     * @return ����registNo��ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ��������claimNo
     * @param claimNo �����õ�����claimNo��ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ����claimNo
     * @return ����claimNo��ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * ��������registUploadFlag
     * @param registUploadFlag �����õ�����registUploadFlag��ֵ
     */
    public void setRegistUploadFlag(String registUploadFlag){
        this.registUploadFlag = StringUtils.rightTrim(registUploadFlag);
    }

    /**
     * ��ȡ����registUploadFlag
     * @return ����registUploadFlag��ֵ
     */
    public String getRegistUploadFlag(){
        return registUploadFlag;
    }

    /**
     * ��������claimUploadFlag
     * @param claimUploadFlag �����õ�����claimUploadFlag��ֵ
     */
    public void setClaimUploadFlag(String claimUploadFlag){
        this.claimUploadFlag = StringUtils.rightTrim(claimUploadFlag);
    }

    /**
     * ��ȡ����claimUploadFlag
     * @return ����claimUploadFlag��ֵ
     */
    public String getClaimUploadFlag(){
        return claimUploadFlag;
    }

    /**
     * ��������endCaseUploadFlag
     * @param endCaseUploadFlag �����õ�����endCaseUploadFlag��ֵ
     */
    public void setEndCaseUploadFlag(String endCaseUploadFlag){
        this.endCaseUploadFlag = StringUtils.rightTrim(endCaseUploadFlag);
    }

    /**
     * ��ȡ����endCaseUploadFlag
     * @return ����endCaseUploadFlag��ֵ
     */
    public String getEndCaseUploadFlag(){
        return endCaseUploadFlag;
    }

    /**
     * ��������cancelUploadFlag
     * @param cancelUploadFlag �����õ�����cancelUploadFlag��ֵ
     */
    public void setCancelUploadFlag(String cancelUploadFlag){
        this.cancelUploadFlag = StringUtils.rightTrim(cancelUploadFlag);
    }

    /**
     * ��ȡ����cancelUploadFlag
     * @return ����cancelUploadFlag��ֵ
     */
    public String getCancelUploadFlag(){
        return cancelUploadFlag;
    }

    /**
     * ��������endAddcode
     * @param endAddcode �����õ�����endAddcode��ֵ
     */
    public void setEndAddcode(String endAddcode){
        this.endAddcode = StringUtils.rightTrim(endAddcode);
    }

    /**
     * ��ȡ����endAddcode
     * @return ����endAddcode��ֵ
     */
    public String getEndAddcode(){
        return endAddcode;
    }
}
