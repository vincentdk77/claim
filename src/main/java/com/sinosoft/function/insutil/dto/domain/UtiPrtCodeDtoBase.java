package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utiprtcode�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPrtCodeDtoBase implements Serializable{
    /** ����instructtype */
    private String instructType = "";
    /** ����instructcode */
    private String instructCode = "";
    /** ����instructname */
    private String instructName = "";
    /** ����ctrlcode */
    private String ctrlCode = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiPrtCodeDtoBase����
     */
    public UtiPrtCodeDtoBase(){
    }

    /**
     * ��������instructtype
     * @param instructType �����õ�����instructtype��ֵ
     */
    public void setInstructType(String instructType){
        this.instructType = StringUtils.rightTrim(instructType);
    }

    /**
     * ��ȡ����instructtype
     * @return ����instructtype��ֵ
     */
    public String getInstructType(){
        return instructType;
    }

    /**
     * ��������instructcode
     * @param instructCode �����õ�����instructcode��ֵ
     */
    public void setInstructCode(String instructCode){
        this.instructCode = StringUtils.rightTrim(instructCode);
    }

    /**
     * ��ȡ����instructcode
     * @return ����instructcode��ֵ
     */
    public String getInstructCode(){
        return instructCode;
    }

    /**
     * ��������instructname
     * @param instructName �����õ�����instructname��ֵ
     */
    public void setInstructName(String instructName){
        this.instructName = StringUtils.rightTrim(instructName);
    }

    /**
     * ��ȡ����instructname
     * @return ����instructname��ֵ
     */
    public String getInstructName(){
        return instructName;
    }

    /**
     * ��������ctrlcode
     * @param ctrlCode �����õ�����ctrlcode��ֵ
     */
    public void setCtrlCode(String ctrlCode){
        this.ctrlCode = StringUtils.rightTrim(ctrlCode);
    }

    /**
     * ��ȡ����ctrlcode
     * @return ����ctrlcode��ֵ
     */
    public String getCtrlCode(){
        return ctrlCode;
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
