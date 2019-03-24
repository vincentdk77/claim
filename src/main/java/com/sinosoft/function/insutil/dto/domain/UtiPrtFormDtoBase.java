package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utiprtform�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPrtFormDtoBase implements Serializable{
    /** ����headcode */
    private String headCode = "";
    /** ����headname */
    private String headName = "";
    /** ����headlength */
    private int headLength = 0;
    /** ����headtype */
    private String headType = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiPrtFormDtoBase����
     */
    public UtiPrtFormDtoBase(){
    }

    /**
     * ��������headcode
     * @param headCode �����õ�����headcode��ֵ
     */
    public void setHeadCode(String headCode){
        this.headCode = StringUtils.rightTrim(headCode);
    }

    /**
     * ��ȡ����headcode
     * @return ����headcode��ֵ
     */
    public String getHeadCode(){
        return headCode;
    }

    /**
     * ��������headname
     * @param headName �����õ�����headname��ֵ
     */
    public void setHeadName(String headName){
        this.headName = StringUtils.rightTrim(headName);
    }

    /**
     * ��ȡ����headname
     * @return ����headname��ֵ
     */
    public String getHeadName(){
        return headName;
    }

    /**
     * ��������headlength
     * @param headLength �����õ�����headlength��ֵ
     */
    public void setHeadLength(int headLength){
        this.headLength = headLength;
    }

    /**
     * ��ȡ����headlength
     * @return ����headlength��ֵ
     */
    public int getHeadLength(){
        return headLength;
    }

    /**
     * ��������headtype
     * @param headType �����õ�����headtype��ֵ
     */
    public void setHeadType(String headType){
        this.headType = StringUtils.rightTrim(headType);
    }

    /**
     * ��ȡ����headtype
     * @return ����headtype��ֵ
     */
    public String getHeadType(){
        return headType;
    }
}
