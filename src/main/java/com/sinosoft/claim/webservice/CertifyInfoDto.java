package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class CertifyInfoDto implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性是否需要上传标识 */
    private String certifyDirectCheck = "";
    /** 属性单证类型 */
    private String typeCode = "";
    /** 属性单证清单名称 */
    private String typeName = "";
    /** 属性是否上传(1是) */
    private String uploadFlag = "";

    /**
     *  默认构造方法,构造一个默认的CertifyInfoDto对象
     */
    public CertifyInfoDto(){
    }

    /**
     * 设置属性是否需要上传标识
     * @param certifyDirectCheck 待设置的属性是否需要上传标识的值
     */
    public void setCertifyDirectCheck(String certifyDirectCheck){
        this.certifyDirectCheck = StringUtils.rightTrim(certifyDirectCheck);
    }

    /**
     * 获取属性是否需要上传标识
     * @return 属性是否需要上传标识的值
     */
    public String getCertifyDirectCheck(){
        return certifyDirectCheck;
    }

    /**
     * 设置属性单证类型
     * @param typeCode 待设置的属性单证类型的值
     */
    public void setTypeCode(String typeCode){
        this.typeCode = StringUtils.rightTrim(typeCode);
    }

    /**
     * 获取属性单证类型
     * @return 属性单证类型的值
     */
    public String getTypeCode(){
        return typeCode;
    }

    /**
     * 设置属性单证清单名称
     * @param typeName 待设置的属性单证清单名称的值
     */
    public void setTypeName(String typeName){
        this.typeName = StringUtils.rightTrim(typeName);
    }

    /**
     * 获取属性单证清单名称
     * @return 属性单证清单名称的值
     */
    public String getTypeName(){
        return typeName;
    }

    /**
     * 设置属性是否上传(1是)
     * @param uploadFlag 待设置的属性是否上传(1是)的值
     */
    public void setUploadFlag(String uploadFlag){
        this.uploadFlag = StringUtils.rightTrim(uploadFlag);
    }

    /**
     * 获取属性是否上传(1是)
     * @return 属性是否上传(1是)的值
     */
    public String getUploadFlag(){
        return uploadFlag;
    }
}
