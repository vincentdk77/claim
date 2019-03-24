package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utiprtpar�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPrtParDtoBase implements Serializable{
    /** ����filename */
    private String fileName = "";
    /** ����labelno */
    private String labelNo = "";
    /** ����xpos */
    private int xpos = 0;
    /** ����ypos */
    private int ypos = 0;
    /** ����len */
    private int len = 0;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiPrtParDtoBase����
     */
    public UtiPrtParDtoBase(){
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
     * ��������labelno
     * @param labelNo �����õ�����labelno��ֵ
     */
    public void setLabelNo(String labelNo){
        this.labelNo = StringUtils.rightTrim(labelNo);
    }

    /**
     * ��ȡ����labelno
     * @return ����labelno��ֵ
     */
    public String getLabelNo(){
        return labelNo;
    }

    /**
     * ��������xpos
     * @param xpos �����õ�����xpos��ֵ
     */
    public void setXpos(int xpos){
        this.xpos = xpos;
    }

    /**
     * ��ȡ����xpos
     * @return ����xpos��ֵ
     */
    public int getXpos(){
        return xpos;
    }

    /**
     * ��������ypos
     * @param ypos �����õ�����ypos��ֵ
     */
    public void setYpos(int ypos){
        this.ypos = ypos;
    }

    /**
     * ��ȡ����ypos
     * @return ����ypos��ֵ
     */
    public int getYpos(){
        return ypos;
    }

    /**
     * ��������len
     * @param len �����õ�����len��ֵ
     */
    public void setLen(int len){
        this.len = len;
    }

    /**
     * ��ȡ����len
     * @return ����len��ֵ
     */
    public int getLen(){
        return len;
    }
}
