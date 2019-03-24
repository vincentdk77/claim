package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdfieldext��չ�ֶε����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDfieldExtDtoBase implements Serializable{
    /** ���Դ������� */
    private String codeType = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ����ҵ����� */
    private String codeCode = "";
    /** ���Դ������ĺ��� */
    private String codeCName = "";
    /** ���������ֶ��� */
    private String columnName = "";
    /** ������ʾ���� */
    private String displayName = "";
    /** ���Լ���־ */
    private String keyFlag = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDfieldExtDtoBase����
     */
    public PrpDfieldExtDtoBase(){
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
     * �����������ִ���
     * @param riskCode �����õ��������ִ����ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ�������ִ���
     * @return �������ִ����ֵ
     */
    public String getRiskCode(){
        return riskCode;
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
     * �������Դ������ĺ���
     * @param codeCName �����õ����Դ������ĺ����ֵ
     */
    public void setCodeCName(String codeCName){
        this.codeCName = StringUtils.rightTrim(codeCName);
    }

    /**
     * ��ȡ���Դ������ĺ���
     * @return ���Դ������ĺ����ֵ
     */
    public String getCodeCName(){
        return codeCName;
    }

    /**
     * �������������ֶ���
     * @param columnName �����õ����������ֶ�����ֵ
     */
    public void setColumnName(String columnName){
        this.columnName = StringUtils.rightTrim(columnName);
    }

    /**
     * ��ȡ���������ֶ���
     * @return ���������ֶ�����ֵ
     */
    public String getColumnName(){
        return columnName;
    }

    /**
     * ����������ʾ����
     * @param displayName �����õ�������ʾ���Ƶ�ֵ
     */
    public void setDisplayName(String displayName){
        this.displayName = StringUtils.rightTrim(displayName);
    }

    /**
     * ��ȡ������ʾ����
     * @return ������ʾ���Ƶ�ֵ
     */
    public String getDisplayName(){
        return displayName;
    }

    /**
     * �������Լ���־
     * @param keyFlag �����õ����Լ���־��ֵ
     */
    public void setKeyFlag(String keyFlag){
        this.keyFlag = StringUtils.rightTrim(keyFlag);
    }

    /**
     * ��ȡ���Լ���־
     * @return ���Լ���־��ֵ
     */
    public String getKeyFlag(){
        return keyFlag;
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
