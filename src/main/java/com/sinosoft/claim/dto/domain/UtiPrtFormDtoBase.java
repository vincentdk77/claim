package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utiprtform���Ӻ��ݱ�ͷ�����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPrtFormDtoBase implements Serializable{
    /** ���Ա�ͷ���� */
    private String headCode = "";
    /** ���Ա�ͷ���� */
    private String headName = "";
    /** ���Ա�ͷ���� */
    private int headLength = 0;
    /** ���Ժ�(h)��(v)��־ */
    private String headType = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiPrtFormDtoBase����
     */
    public UtiPrtFormDtoBase(){
    }

    /**
     * �������Ա�ͷ����
     * @param headCode �����õ����Ա�ͷ�����ֵ
     */
    public void setHeadCode(String headCode){
        this.headCode = StringUtils.rightTrim(headCode);
    }

    /**
     * ��ȡ���Ա�ͷ����
     * @return ���Ա�ͷ�����ֵ
     */
    public String getHeadCode(){
        return headCode;
    }

    /**
     * �������Ա�ͷ����
     * @param headName �����õ����Ա�ͷ���Ƶ�ֵ
     */
    public void setHeadName(String headName){
        this.headName = StringUtils.rightTrim(headName);
    }

    /**
     * ��ȡ���Ա�ͷ����
     * @return ���Ա�ͷ���Ƶ�ֵ
     */
    public String getHeadName(){
        return headName;
    }

    /**
     * �������Ա�ͷ����
     * @param headLength �����õ����Ա�ͷ���ȵ�ֵ
     */
    public void setHeadLength(int headLength){
        this.headLength = headLength;
    }

    /**
     * ��ȡ���Ա�ͷ����
     * @return ���Ա�ͷ���ȵ�ֵ
     */
    public int getHeadLength(){
        return headLength;
    }

    /**
     * �������Ժ�(h)��(v)��־
     * @param headType �����õ����Ժ�(h)��(v)��־��ֵ
     */
    public void setHeadType(String headType){
        this.headType = StringUtils.rightTrim(headType);
    }

    /**
     * ��ȡ���Ժ�(h)��(v)��־
     * @return ���Ժ�(h)��(v)��־��ֵ
     */
    public String getHeadType(){
        return headType;
    }
}
