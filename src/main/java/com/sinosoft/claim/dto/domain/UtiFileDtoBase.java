package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utifile��ӡ�ļ�������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiFileDtoBase implements Serializable{
    /** �����ļ����� */
    private String fileName = "";
    /** �����к� */
    private int lineNo = 0;
    /** �������� */
    private String text = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiFileDtoBase����
     */
    public UtiFileDtoBase(){
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
     * ���������к�
     * @param lineNo �����õ������кŵ�ֵ
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * ��ȡ�����к�
     * @return �����кŵ�ֵ
     */
    public int getLineNo(){
        return lineNo;
    }

    /**
     * ������������
     * @param text �����õ��������ݵ�ֵ
     */
    public void setText(String text){
        this.text = StringUtils.rightTrim(text);
    }

    /**
     * ��ȡ��������
     * @return �������ݵ�ֵ
     */
    public String getText(){
        return text;
    }
}
