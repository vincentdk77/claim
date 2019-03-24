package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class CertifyInfoDto implements Serializable{

    private static final long serialVersionUID = 1L;
    /** �����Ƿ���Ҫ�ϴ���ʶ */
    private String certifyDirectCheck = "";
    /** ���Ե�֤���� */
    private String typeCode = "";
    /** ���Ե�֤�嵥���� */
    private String typeName = "";
    /** �����Ƿ��ϴ�(1��) */
    private String uploadFlag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CertifyInfoDto����
     */
    public CertifyInfoDto(){
    }

    /**
     * ���������Ƿ���Ҫ�ϴ���ʶ
     * @param certifyDirectCheck �����õ������Ƿ���Ҫ�ϴ���ʶ��ֵ
     */
    public void setCertifyDirectCheck(String certifyDirectCheck){
        this.certifyDirectCheck = StringUtils.rightTrim(certifyDirectCheck);
    }

    /**
     * ��ȡ�����Ƿ���Ҫ�ϴ���ʶ
     * @return �����Ƿ���Ҫ�ϴ���ʶ��ֵ
     */
    public String getCertifyDirectCheck(){
        return certifyDirectCheck;
    }

    /**
     * �������Ե�֤����
     * @param typeCode �����õ����Ե�֤���͵�ֵ
     */
    public void setTypeCode(String typeCode){
        this.typeCode = StringUtils.rightTrim(typeCode);
    }

    /**
     * ��ȡ���Ե�֤����
     * @return ���Ե�֤���͵�ֵ
     */
    public String getTypeCode(){
        return typeCode;
    }

    /**
     * �������Ե�֤�嵥����
     * @param typeName �����õ����Ե�֤�嵥���Ƶ�ֵ
     */
    public void setTypeName(String typeName){
        this.typeName = StringUtils.rightTrim(typeName);
    }

    /**
     * ��ȡ���Ե�֤�嵥����
     * @return ���Ե�֤�嵥���Ƶ�ֵ
     */
    public String getTypeName(){
        return typeName;
    }

    /**
     * ���������Ƿ��ϴ�(1��)
     * @param uploadFlag �����õ������Ƿ��ϴ�(1��)��ֵ
     */
    public void setUploadFlag(String uploadFlag){
        this.uploadFlag = StringUtils.rightTrim(uploadFlag);
    }

    /**
     * ��ȡ�����Ƿ��ϴ�(1��)
     * @return �����Ƿ��ϴ�(1��)��ֵ
     */
    public String getUploadFlag(){
        return uploadFlag;
    }
}
