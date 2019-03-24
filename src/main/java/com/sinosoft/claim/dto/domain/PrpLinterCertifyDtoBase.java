package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǵ�֤��Ϣ������ݴ���������<br>
 */
public class PrpLinterCertifyDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** �������� PK */
    private String id = "";
    /** ������� PK */
    private int serialNo = 0;
    /** �����Ƿ���Ҫ�ϴ���ʶ */
    private String certifyDirectCheck = "";
    /** ���Ե�֤���� */
    private String typeCode = "";
    /** ���Ե�֤�嵥���� */
    private String typeName = "";
    /** �����Ƿ��ϴ�(1��) */
    private String uploadFlag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterCertifyDtoBase����
     */
    public PrpLinterCertifyDtoBase(){
    }

    /**
     * ������������ PK
     * @param id �����õ��������� PK��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ�������� PK
     * @return �������� PK��ֵ
     */
    public String getId(){
        return id;
    }

    /**
     * ����������� PK
     * @param serialNo �����õ�������� PK��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ������� PK
     * @return ������� PK��ֵ
     */
    public int getSerialNo(){
        return serialNo;
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
