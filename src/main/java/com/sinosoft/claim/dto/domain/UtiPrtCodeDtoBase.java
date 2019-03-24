package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utiprtcode��ӡ����ָ����������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPrtCodeDtoBase implements Serializable{
    /** ����ָ����� */
    private String instructType = "";
    /** ����ָ����� */
    private String instructCode = "";
    /** ����ָ������ */
    private String instructName = "";
    /** ���Կ����ַ� */
    private String ctrlCode = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiPrtCodeDtoBase����
     */
    public UtiPrtCodeDtoBase(){
    }

    /**
     * ��������ָ�����
     * @param instructType �����õ�����ָ������ֵ
     */
    public void setInstructType(String instructType){
        this.instructType = StringUtils.rightTrim(instructType);
    }

    /**
     * ��ȡ����ָ�����
     * @return ����ָ������ֵ
     */
    public String getInstructType(){
        return instructType;
    }

    /**
     * ��������ָ�����
     * @param instructCode �����õ�����ָ������ֵ
     */
    public void setInstructCode(String instructCode){
        this.instructCode = StringUtils.rightTrim(instructCode);
    }

    /**
     * ��ȡ����ָ�����
     * @return ����ָ������ֵ
     */
    public String getInstructCode(){
        return instructCode;
    }

    /**
     * ��������ָ������
     * @param instructName �����õ�����ָ�����Ƶ�ֵ
     */
    public void setInstructName(String instructName){
        this.instructName = StringUtils.rightTrim(instructName);
    }

    /**
     * ��ȡ����ָ������
     * @return ����ָ�����Ƶ�ֵ
     */
    public String getInstructName(){
        return instructName;
    }

    /**
     * �������Կ����ַ�
     * @param ctrlCode �����õ����Կ����ַ���ֵ
     */
    public void setCtrlCode(String ctrlCode){
        this.ctrlCode = StringUtils.rightTrim(ctrlCode);
    }

    /**
     * ��ȡ���Կ����ַ�
     * @return ���Կ����ַ���ֵ
     */
    public String getCtrlCode(){
        return ctrlCode;
    }

    /**
     * �������Ա�־
     * @param flag �����õ����Ա�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־
     * @return ���Ա�־��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
