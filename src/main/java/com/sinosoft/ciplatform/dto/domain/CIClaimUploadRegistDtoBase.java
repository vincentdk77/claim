package com.sinosoft.ciplatform.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����������Ϣƽ̨�ϴ�ע�������ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CIClaimUploadRegistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** �����ϴ���� */
    private String uploadNo = "";
    /** ����ҵ��� */
    private String businessNo = "";
    /** �����ϴ����� */
    private String uploadType = "";
    /** ����ע��ʱ�� */
    private DateTime registDate = new DateTime();
    /** �����ϴ�ʧ�ܴ��� */
    private int failTimes = 0;
    /** ������־ */
    private String uploadFlag = "";
    /** ���Դ�����ʽ */
    private String triggerMode = "";
    /** �ؿ���� */
    private int serlalNo =0;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CIClaimUploadRegistDtoBase����
     */
    public CIClaimUploadRegistDtoBase(){
    }

    /**
     * ���������ϴ����
     * @param uploadNo �����õ������ϴ���ŵ�ֵ
     */
    public void setUploadNo(String uploadNo){
        this.uploadNo = StringUtils.rightTrim(uploadNo);
    }

    /**
     * ��ȡ�����ϴ����
     * @return �����ϴ���ŵ�ֵ
     */
    public String getUploadNo(){
        return uploadNo;
    }

    /**
     * ��������ҵ���
     * @param businessNo �����õ�����ҵ��ŵ�ֵ
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * ��ȡ����ҵ���
     * @return ����ҵ��ŵ�ֵ
     */
    public String getBusinessNo(){
        return businessNo;
    }

    /**
     * ���������ϴ�����
     * @param uploadType �����õ������ϴ����͵�ֵ
     */
    public void setUploadType(String uploadType){
        this.uploadType = StringUtils.rightTrim(uploadType);
    }

    /**
     * ��ȡ�����ϴ�����
     * @return �����ϴ����͵�ֵ
     */
    public String getUploadType(){
        return uploadType;
    }

    /**
     * ��������ע��ʱ��
     * @param registDate �����õ�����ע��ʱ���ֵ
     */
    public void setRegistDate(DateTime registDate){
        this.registDate = registDate;
    }

    /**
     * ��ȡ����ע��ʱ��
     * @return ����ע��ʱ���ֵ
     */
    public DateTime getRegistDate(){
        return registDate;
    }

    /**
     * ���������ϴ�ʧ�ܴ���
     * @param failTimes �����õ������ϴ�ʧ�ܴ�����ֵ
     */
    public void setFailTimes(int failTimes){
        this.failTimes = failTimes;
    }

    /**
     * ��ȡ�����ϴ�ʧ�ܴ���
     * @return �����ϴ�ʧ�ܴ�����ֵ
     */
    public int getFailTimes(){
        return failTimes;
    }

    /**
     * �������Դ�����ʽ
     * @param triggerMode �����õ����Դ�����ʽ��ֵ
     */
    public void setTriggerMode(String triggerMode){
        this.triggerMode = StringUtils.rightTrim(triggerMode);
    }

    /**
     * ��ȡ���Դ�����ʽ
     * @return ���Դ�����ʽ��ֵ
     */
    public String getTriggerMode(){
        return triggerMode;
    }

	/**
	 * @return the uploadFlag
	 */
	public String getUploadFlag() {
		return uploadFlag;
	}

	/**
	 * @param uploadFlag the uploadFlag to set
	 */
	public void setUploadFlag(String uploadFlag) {
		this.uploadFlag = uploadFlag;
	}

	/**
	 * @return the serlalNo
	 */
	public int getSerlalNo() {
		return serlalNo;
	}

	/**
	 * @param serlalNo the serlalNo to set
	 */
	public void setSerlalNo(int serlalNo) {
		this.serlalNo = serlalNo;
	}
}
