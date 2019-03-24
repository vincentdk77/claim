package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdtype�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDtypeDtoBase implements Serializable{
    /** ����codetype */
    private String codeType = "";
    /** ����codetypedesc */
    private String codeTypeDesc = "";
    /** ����newcodetype */
    private String newCodeType = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDtypeDtoBase����
     */
    public PrpDtypeDtoBase(){
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
     * ��������codetypedesc
     * @param codeTypeDesc �����õ�����codetypedesc��ֵ
     */
    public void setCodeTypeDesc(String codeTypeDesc){
        this.codeTypeDesc = StringUtils.rightTrim(codeTypeDesc);
    }

    /**
     * ��ȡ����codetypedesc
     * @return ����codetypedesc��ֵ
     */
    public String getCodeTypeDesc(){
        return codeTypeDesc;
    }

    /**
     * ��������newcodetype
     * @param newCodeType �����õ�����newcodetype��ֵ
     */
    public void setNewCodeType(String newCodeType){
        this.newCodeType = StringUtils.rightTrim(newCodeType);
    }

    /**
     * ��ȡ����newcodetype
     * @return ����newcodetype��ֵ
     */
    public String getNewCodeType(){
        return newCodeType;
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
