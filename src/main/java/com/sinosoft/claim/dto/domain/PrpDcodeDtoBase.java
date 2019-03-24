package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdcodeͨ�ô��������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcodeDtoBase implements Serializable{
    /** ���Դ������� */
    private String codeType = "";
    /** ����ҵ����� */
    private String codeCode = "";
    /** ����ҵ��������ĺ��� */
    private String codeCName = "";
    /** ����ҵ�����Ӣ�ĺ��� */
    private String codeEName = "";
    /** �����µ�ҵ����� */
    private String newCodeCode = "";
    /** ����Ч��״̬(0ʧЧ/1��Ч) */
    private String validStatus = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcodeDtoBase����
     */
    public PrpDcodeDtoBase(){
    }
    public PrpDcodeDtoBase(String codeCode,String codeCName){
    	this.codeCode = codeCode;
    	this.codeCName = codeCName;
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
     * ��������ҵ�����
     * @param codeCode �����õ�����ҵ������ֵ
     */
    public void setCodeCode(String codeCode){
        this.codeCode = StringUtils.rightTrim(codeCode);
    }

    /**
     * ��ȡ����ҵ�����
     * @return ����ҵ������ֵ
     */
    public String getCodeCode(){
        return codeCode;
    }

    /**
     * ��������ҵ��������ĺ���
     * @param codeCName �����õ�����ҵ��������ĺ����ֵ
     */
    public void setCodeCName(String codeCName){
        this.codeCName = StringUtils.rightTrim(codeCName);
    }

    /**
     * ��ȡ����ҵ��������ĺ���
     * @return ����ҵ��������ĺ����ֵ
     */
    public String getCodeCName(){
        return codeCName;
    }

    /**
     * ��������ҵ�����Ӣ�ĺ���
     * @param codeEName �����õ�����ҵ�����Ӣ�ĺ����ֵ
     */
    public void setCodeEName(String codeEName){
        this.codeEName = StringUtils.rightTrim(codeEName);
    }

    /**
     * ��ȡ����ҵ�����Ӣ�ĺ���
     * @return ����ҵ�����Ӣ�ĺ����ֵ
     */
    public String getCodeEName(){
        return codeEName;
    }

    /**
     * ���������µ�ҵ�����
     * @param newCodeCode �����õ������µ�ҵ������ֵ
     */
    public void setNewCodeCode(String newCodeCode){
        this.newCodeCode = StringUtils.rightTrim(newCodeCode);
    }

    /**
     * ��ȡ�����µ�ҵ�����
     * @return �����µ�ҵ������ֵ
     */
    public String getNewCodeCode(){
        return newCodeCode;
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
