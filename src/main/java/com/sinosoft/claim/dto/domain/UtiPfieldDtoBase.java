package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utipfield��֤��ӡ�����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPfieldDtoBase implements Serializable{
    /** �����ļ����� */
    private String fileName = "";
    /** ���Ա��(��ʽ���) */
    private String labelNo = "";
    /** �����ֶ����� */
    private String fieldName = "";
    /** ����ȡ����־ */
    private String selFlag = "";
    /** ���Ա��� */
    private String tabName = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiPfieldDtoBase����
     */
    public UtiPfieldDtoBase(){
    }

    /**
     * ���������ļ�����
     * @param fileName �����õ������ļ����Ƶ�ֵ
     */
    public void setFileName(String fileName){
        this.fileName = StringUtils.rightTrim(fileName);
    }

    /**
     * ��ȡ�����ļ�����
     * @return �����ļ����Ƶ�ֵ
     */
    public String getFileName(){
        return fileName;
    }

    /**
     * �������Ա��(��ʽ���)
     * @param labelNo �����õ����Ա��(��ʽ���)��ֵ
     */
    public void setLabelNo(String labelNo){
        this.labelNo = StringUtils.rightTrim(labelNo);
    }

    /**
     * ��ȡ���Ա��(��ʽ���)
     * @return ���Ա��(��ʽ���)��ֵ
     */
    public String getLabelNo(){
        return labelNo;
    }

    /**
     * ���������ֶ�����
     * @param fieldName �����õ������ֶ����Ƶ�ֵ
     */
    public void setFieldName(String fieldName){
        this.fieldName = StringUtils.rightTrim(fieldName);
    }

    /**
     * ��ȡ�����ֶ�����
     * @return �����ֶ����Ƶ�ֵ
     */
    public String getFieldName(){
        return fieldName;
    }

    /**
     * ��������ȡ����־
     * @param selFlag �����õ�����ȡ����־��ֵ
     */
    public void setSelFlag(String selFlag){
        this.selFlag = StringUtils.rightTrim(selFlag);
    }

    /**
     * ��ȡ����ȡ����־
     * @return ����ȡ����־��ֵ
     */
    public String getSelFlag(){
        return selFlag;
    }

    /**
     * �������Ա���
     * @param tabName �����õ����Ա�����ֵ
     */
    public void setTabName(String tabName){
        this.tabName = StringUtils.rightTrim(tabName);
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա�����ֵ
     */
    public String getTabName(){
        return tabName;
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
