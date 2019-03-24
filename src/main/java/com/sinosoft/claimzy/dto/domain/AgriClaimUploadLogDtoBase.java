package com.sinosoft.claimzy.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����AgriClaimUploadLogDto�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class AgriClaimUploadLogDtoBase implements Serializable{
	private static final long serialVersionUID = 1L;
    /** ����������� */
    private String claimCode = "";
    /** ���������� */
    private String claimNo = "";
    /** �����ⰸ�� */
    private String caseNo = "";
    /** ����Ԥ�ⰸ�� */
    private String preCompensateNo = "";
    /** ������Ӧ���� */
    private String responseCode = "";
    /** ���Դ������ */
    private String errorCode = "";
    /** �������κ� */
    private String batchNo = "";
    /** ���Դ������� */
    private String errorDesc = "";
    /** �����ϴ����� */
    private DateTime uploadDate = new DateTime();
    /** ���Ա�־λ */
    private int flag = 0;
    /**������Ӧ���루��ϸ��*/
    private String responseMXCode = "";
    /**���Դ�����루��ϸ��*/
    private String errorMXCode = "";
    /**���Դ���˵�����루��ϸ��*/
    private String errorMXDesc = "";
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�AgriClaimUploadLogDtoBase����
     */
    public AgriClaimUploadLogDtoBase(){
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
     * ���������ⰸ��
     * @param caseNo �����õ������ⰸ�ŵ�ֵ
     */
    public void setCaseNo(String caseNo){
        this.caseNo = StringUtils.rightTrim(caseNo);
    }

    /**
     * ��ȡ�����ⰸ��
     * @return �����ⰸ�ŵ�ֵ
     */
    public String getCaseNo(){
        return caseNo;
    }

    /**
     * ��������Ԥ�ⰸ��
     * @param preCompensateNo �����õ�����Ԥ�ⰸ�ŵ�ֵ
     */
    public void setPreCompensateNo(String preCompensateNo){
        this.preCompensateNo = StringUtils.rightTrim(preCompensateNo);
    }

    /**
     * ��ȡ����Ԥ�ⰸ��
     * @return ����Ԥ�ⰸ�ŵ�ֵ
     */
    public String getPreCompensateNo(){
        return preCompensateNo;
    }

    /**
     * ����������Ӧ����
     * @param responseCode �����õ�������Ӧ�����ֵ
     */
    public void setResponseCode(String responseCode){
        this.responseCode = StringUtils.rightTrim(responseCode);
    }

    /**
     * ��ȡ������Ӧ����
     * @return ������Ӧ�����ֵ
     */
    public String getResponseCode(){
        return responseCode;
    }

    /**
     * �������Դ������
     * @param errorCode �����õ����Դ�������ֵ
     */
    public void setErrorCode(String errorCode){
        this.errorCode = StringUtils.rightTrim(errorCode);
    }

    /**
     * ��ȡ���Դ������
     * @return ���Դ�������ֵ
     */
    public String getErrorCode(){
        return errorCode;
    }

    /**
     * �����������κ�
     * @param batchNo �����õ��������κŵ�ֵ
     */
    public void setBatchNo(String batchNo){
        this.batchNo = StringUtils.rightTrim(batchNo);
    }

    /**
     * ��ȡ�������κ�
     * @return �������κŵ�ֵ
     */
    public String getBatchNo(){
        return batchNo;
    }

    /**
     * �������Դ�������
     * @param errorDesc �����õ����Դ���������ֵ
     */
    public void setErrorDesc(String errorDesc){
        this.errorDesc = StringUtils.rightTrim(errorDesc);
    }

    /**
     * ��ȡ���Դ�������
     * @return ���Դ���������ֵ
     */
    public String getErrorDesc(){
        return errorDesc;
    }

    /**
     * ���������ϴ�����
     * @param Date �����õ������ϴ����ڵ�ֵ
     */
    public void setUploadDate(DateTime uploadDate){
        this.uploadDate = uploadDate;
        }

    /**
     * ��ȡ�����ϴ�����
     * @return �����ϴ����ڵ�ֵ
     */
    public DateTime getUploadDate(){
        return uploadDate;
    }


    /**
     * �������Ա�־λ
     * @param flag �����õ����Ա�־λ��ֵ
     */
    public void setFlag(int flag){
        this.flag = flag;
    }

    /**
     * ��ȡ���Ա�־λ
     * @return ���Ա�־λ��ֵ
     */
    public int getFlag(){
        return flag;
    }

	public String getResponseMXCode() {
		return responseMXCode;
	}

	public void setResponseMXCode(String responseMXCode) {
		this.responseMXCode = StringUtils.rightTrim(responseMXCode);
	}

	public String getErrorMXCode() {
		return errorMXCode;
	}

	public void setErrorMXCode(String errorMXCode) {
		this.errorMXCode = StringUtils.rightTrim(errorMXCode);
	}

	public String getErrorMXDesc() {
		return errorMXDesc;
	}

	public void setErrorMXDesc(String errorMXDesc) {
		this.errorMXDesc = StringUtils.rightTrim(errorMXDesc);
	}
    
}
