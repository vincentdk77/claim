package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdcode�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcodeDtoBase implements Serializable{
    /** ����codetype */
    private String codeType = "";
    /** ����codecode */
    private String codeCode = "";
    /** ����codecname */
    private String codeCName = "";
    /** ����codeename */
    private String codeEName = "";
    /** ����newcodecode */
    private String newCodeCode = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcodeDtoBase����
     */
    public PrpDcodeDtoBase(){
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
     * ��������codeename
     * @param codeEName �����õ�����codeename��ֵ
     */
    public void setCodeEName(String codeEName){
        this.codeEName = StringUtils.rightTrim(codeEName);
    }

    /**
     * ��ȡ����codeename
     * @return ����codeename��ֵ
     */
    public String getCodeEName(){
        return codeEName;
    }

    /**
     * ��������newcodecode
     * @param newCodeCode �����õ�����newcodecode��ֵ
     */
    public void setNewCodeCode(String newCodeCode){
        this.newCodeCode = StringUtils.rightTrim(newCodeCode);
    }

    /**
     * ��ȡ����newcodecode
     * @return ����newcodecode��ֵ
     */
    public String getNewCodeCode(){
        return newCodeCode;
    }

    /**
     * ��������validstatus
     * @param validStatus �����õ�����validstatus��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����validstatus
     * @return ����validstatus��ֵ
     */
    public String getValidStatus(){
        return validStatus;
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
