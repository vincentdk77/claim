package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utiprtpar��֤��ӡ�ļ����������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPrtParDtoBase implements Serializable{
    /** �����ļ����� */
    private String fileName = "";
    /** ���Ա�� */
    private String labelNo = "";
    /** ���������� */
    private int xpos = 0;
    /** ���������� */
    private int ypos = 0;
    /** ���Գ��� */
    private int len = 0;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiPrtParDtoBase����
     */
    public UtiPrtParDtoBase(){
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
     * �������Ա��
     * @param labelNo �����õ����Ա�ŵ�ֵ
     */
    public void setLabelNo(String labelNo){
        this.labelNo = StringUtils.rightTrim(labelNo);
    }

    /**
     * ��ȡ���Ա��
     * @return ���Ա�ŵ�ֵ
     */
    public String getLabelNo(){
        return labelNo;
    }

    /**
     * ��������������
     * @param xpos �����õ������������ֵ
     */
    public void setXpos(int xpos){
        this.xpos = xpos;
    }

    /**
     * ��ȡ����������
     * @return �����������ֵ
     */
    public int getXpos(){
        return xpos;
    }

    /**
     * ��������������
     * @param ypos �����õ������������ֵ
     */
    public void setYpos(int ypos){
        this.ypos = ypos;
    }

    /**
     * ��ȡ����������
     * @return �����������ֵ
     */
    public int getYpos(){
        return ypos;
    }

    /**
     * �������Գ���
     * @param len �����õ����Գ��ȵ�ֵ
     */
    public void setLen(int len){
        this.len = len;
    }

    /**
     * ��ȡ���Գ���
     * @return ���Գ��ȵ�ֵ
     */
    public int getLen(){
        return len;
    }
}
