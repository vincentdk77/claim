package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utifile�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiFileDtoBase implements Serializable{
    /** ����filename */
    private String fileName = "";
    /** ����lineno */
    private int lineNo = 0;
    /** ����text */
    private String text = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiFileDtoBase����
     */
    public UtiFileDtoBase(){
    }

    /**
     * ��������filename
     * @param fileName �����õ�����filename��ֵ
     */
    public void setFileName(String fileName){
        this.fileName = StringUtils.rightTrim(fileName);
    }

    /**
     * ��ȡ����filename
     * @return ����filename��ֵ
     */
    public String getFileName(){
        return fileName;
    }

    /**
     * ��������lineno
     * @param lineNo �����õ�����lineno��ֵ
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * ��ȡ����lineno
     * @return ����lineno��ֵ
     */
    public int getLineNo(){
        return lineNo;
    }

    /**
     * ��������text
     * @param text �����õ�����text��ֵ
     */
    public void setText(String text){
        this.text = StringUtils.rightTrim(text);
    }

    /**
     * ��ȡ����text
     * @return ����text��ֵ
     */
    public String getText(){
        return text;
    }
}
