package com.sinosoft.claimciplatform.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CIClaimUploadLog-������Ϣ�ϴ�ƽ̨��־������ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CIClaimUploadLogDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** �����ϴ���� */
    private String uploadNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ����������� */
    private String claimCode = "";
    /** ����ҵ��� */
    private String businessNo = "";
    /** �����ϴ����� */
    private String uploadType = "";
    /** �����ϴ�ʱ�� */
    private DateTime uploadDate = new DateTime();
    /** ���Ա�־ */
    private int flag = 0;
    /** ���Դ������ */
    private String errorCode = "";
    /** ���Դ������� */
    private String errorname = "";
    /** �����ϴ���ʽ */
    private String uploadWay = "";

    
    /**
	 * ��ȡ���� uploadNo
	 * @return the uploadNo
	 */
	public String getUploadNo() {
		return uploadNo;
	}

	/**
	 * �������� uploadNo
	 * @param uploadNo the uploadNo to set
	 */
	public void setUploadNo(String uploadNo) {
		this.uploadNo = uploadNo;
	}

	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CIClaimUploadLogDtoBase����
     */
    public CIClaimUploadLogDtoBase(){
    }

    /**
     * ��������˳���
     * @param serialNo �����õ�����˳��ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����˳���
     * @return ����˳��ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
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
     * ���������ϴ�ʱ��
     * @param uploadDate �����õ������ϴ�ʱ���ֵ
     */
    public void setUploadDate(DateTime uploadDate){
        this.uploadDate = uploadDate;
    }

    /**
     * ��ȡ�����ϴ�ʱ��
     * @return �����ϴ�ʱ���ֵ
     */
    public DateTime getUploadDate(){
        return uploadDate;
    }

    /**
     * �������Ա�־
     * @param flag �����õ����Ա�־��ֵ
     */
    public void setFlag(int flag){
        this.flag = flag;
    }

    /**
     * ��ȡ���Ա�־
     * @return ���Ա�־��ֵ
     */
    public int getFlag(){
        return flag;
    }

	/**
	 * ��ȡ���� errorCode
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * �������� errorCode
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * ��ȡ���� errorname
	 * @return the errorname
	 */
	public String getErrorname() {
		return errorname;
	}

	/**
	 * �������� errorname
	 * @param errorname the errorname to set
	 */
	public void setErrorname(String errorname) {
		this.errorname = errorname;
	}

	/**
	 * ��ȡ���� uploadWay
	 * @return the uploadWay
	 */
	public String getUploadWay() {
		return uploadWay;
	}

	/**
	 * �������� uploadWay
	 * @param uploadWay the uploadWay to set
	 */
	public void setUploadWay(String uploadWay) {
		this.uploadWay = uploadWay;
	}

	/**
	 * ��ȡ���� serialVersionUID
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	
}
