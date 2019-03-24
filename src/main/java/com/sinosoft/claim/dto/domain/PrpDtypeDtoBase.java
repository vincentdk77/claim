package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdtypeͨ�ô����������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDtypeDtoBase implements Serializable{
    /** ���Դ������� */
    private String codeType = "";
    /** ���Դ����������� */
    private String codeTypeDesc = "";
    /** �����µĴ������� */
    private String newCodeType = "";
    /** ����Ч��״̬(0ʧЧ/1��Ч) */
    private String validStatus = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDtypeDtoBase����
     */
    public PrpDtypeDtoBase(){
    }

    /**
     * �������Դ�������
     * @param codeType �����õ����Դ������͵�ֵ
     */
    public void setCodeType(String codeType){
        this.codeType = StringUtils.rightTrim(codeType);
    }

    /**
     * ��ȡ���Դ�������
     * @return ���Դ������͵�ֵ
     */
    public String getCodeType(){
        return codeType;
    }

    /**
     * �������Դ�����������
     * @param codeTypeDesc �����õ����Դ�������������ֵ
     */
    public void setCodeTypeDesc(String codeTypeDesc){
        this.codeTypeDesc = StringUtils.rightTrim(codeTypeDesc);
    }

    /**
     * ��ȡ���Դ�����������
     * @return ���Դ�������������ֵ
     */
    public String getCodeTypeDesc(){
        return codeTypeDesc;
    }

    /**
     * ���������µĴ�������
     * @param newCodeType �����õ������µĴ������͵�ֵ
     */
    public void setNewCodeType(String newCodeType){
        this.newCodeType = StringUtils.rightTrim(newCodeType);
    }

    /**
     * ��ȡ�����µĴ�������
     * @return �����µĴ������͵�ֵ
     */
    public String getNewCodeType(){
        return newCodeType;
    }

    /**
     * ��������Ч��״̬(0ʧЧ/1��Ч)
     * @param validStatus �����õ�����Ч��״̬(0ʧЧ/1��Ч)��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����Ч��״̬(0ʧЧ/1��Ч)
     * @return ����Ч��״̬(0ʧЧ/1��Ч)��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * �������Ա�־�ֶ�
     * @param flag �����õ����Ա�־�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
     * @return ���Ա�־�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
