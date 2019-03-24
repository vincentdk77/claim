package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdfieldext�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDfieldExtDtoBase implements Serializable{
    /** ����codetype */
    private String codeType = "";
    /** ����riskcode */
    private String riskCode = "";
    /** ����codecode */
    private String codeCode = "";
    /** ����codecname */
    private String codeCName = "";
    /** ����columnname */
    private String columnName = "";
    /** ����displayname */
    private String displayName = "";
    /** ����keyflag */
    private String keyFlag = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDfieldExtDtoBase����
     */
    public PrpDfieldExtDtoBase(){
    }

    /**
     * ��������codetype
     * @param codeType �����õ�����codetype��ֵ
     */
    public void setCodeType(String codeType){
        this.codeType = StringUtils.rightTrim(codeType);
    }

    /**
     * ��ȡ����codetype
     * @return ����codetype��ֵ
     */
    public String getCodeType(){
        return codeType;
    }

    /**
     * ��������riskcode
     * @param riskCode �����õ�����riskcode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����riskcode
     * @return ����riskcode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������codecode
     * @param codeCode �����õ�����codecode��ֵ
     */
    public void setCodeCode(String codeCode){
        this.codeCode = StringUtils.rightTrim(codeCode);
    }

    /**
     * ��ȡ����codecode
     * @return ����codecode��ֵ
     */
    public String getCodeCode(){
        return codeCode;
    }

    /**
     * ��������codecname
     * @param codeCName �����õ�����codecname��ֵ
     */
    public void setCodeCName(String codeCName){
        this.codeCName = StringUtils.rightTrim(codeCName);
    }

    /**
     * ��ȡ����codecname
     * @return ����codecname��ֵ
     */
    public String getCodeCName(){
        return codeCName;
    }

    /**
     * ��������columnname
     * @param columnName �����õ�����columnname��ֵ
     */
    public void setColumnName(String columnName){
        this.columnName = StringUtils.rightTrim(columnName);
    }

    /**
     * ��ȡ����columnname
     * @return ����columnname��ֵ
     */
    public String getColumnName(){
        return columnName;
    }

    /**
     * ��������displayname
     * @param displayName �����õ�����displayname��ֵ
     */
    public void setDisplayName(String displayName){
        this.displayName = StringUtils.rightTrim(displayName);
    }

    /**
     * ��ȡ����displayname
     * @return ����displayname��ֵ
     */
    public String getDisplayName(){
        return displayName;
    }

    /**
     * ��������keyflag
     * @param keyFlag �����õ�����keyflag��ֵ
     */
    public void setKeyFlag(String keyFlag){
        this.keyFlag = StringUtils.rightTrim(keyFlag);
    }

    /**
     * ��ȡ����keyflag
     * @return ����keyflag��ֵ
     */
    public String getKeyFlag(){
        return keyFlag;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
