package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是单证信息表的数据传输对象基类<br>
 */
public class PrpLinterCertifyDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键 PK */
    private String id = "";
    /** 属性序号 PK */
    private int serialNo = 0;
    /** 属性是否需要上传标识 */
    private String certifyDirectCheck = "";
    /** 属性单证类型 */
    private String typeCode = "";
    /** 属性单证清单名称 */
    private String typeName = "";
    /** 属性是否上传(1是) */
    private String uploadFlag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLinterCertifyDtoBase对象
     */
    public PrpLinterCertifyDtoBase(){
    }

    /**
     * 设置属性主键 PK
     * @param id 待设置的属性主键 PK的值
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * 获取属性主键 PK
     * @return 属性主键 PK的值
     */
    public String getId(){
        return id;
    }

    /**
     * 设置属性序号 PK
     * @param serialNo 待设置的属性序号 PK的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号 PK
     * @return 属性序号 PK的值
     */
    public int getSerialNo(){
        return serialNo;
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
