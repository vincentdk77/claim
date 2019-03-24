package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����б�
�ֶΣ������š����ƺš�����ʱ�䡢����״̬���ɹ����͵�
 * @author fei
 *
 */
public class TaskInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** ���Ա������� */
    private String registNo = "";
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** ��������ʱ�� */
    private String  acceptTime = "";
    /** ��������״̬*/
    private String taskStatus = "";
    /** �����ɹ�����*/
    private String dispatchType = "";
    /** ���Ա����������� */
    private String insuredName = "";
    
    /**
     * �������Ա�������
     * @param registNo �����õ����Ա��������ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ��ȡ��������ʱ��
     * @return ��������ʱ��ֵ
     */
	public String getAcceptTime() {
		return acceptTime;
	}
	
	/**
     * ������������ʱ��
     * @param acceptTime �����õ���������ʱ���ֵ
     */
	public void setAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
	}

	/**
     * ��ȡ��������״̬
     * @return ��������״ֵ̬
     */
	public String getTaskStatus() {
		return taskStatus;
	}

	/**
     * ������������״̬
     * @param taskStatus �����õ���������״̬��ֵ
     */
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	
    /**
     * ��ȡ���Գ��ƺ���
     * @return ���Գ��ƺ���ֵ
     */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
     * �������Գ��ƺ���
     * @param policyNo �����õ����Գ��ƺ����ֵ
     */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	/**
     * ��ȡ�����ɹ�����
     * @return �����ɹ�����ֵ
     */
	public String getDispatchType() {
		return dispatchType;
	}

	/**
     * ���������ɹ�����
     * @param dispatchType �����õ������ɹ����͵�ֵ
     */
	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	
	
	
}
