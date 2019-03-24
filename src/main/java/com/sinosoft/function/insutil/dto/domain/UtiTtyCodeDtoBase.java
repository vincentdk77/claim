package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utittycode�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiTtyCodeDtoBase implements Serializable{
    /** ����ttycode */
    private String ttyCode = "";
    /** ����ttytype */
    private String ttyType = "";
    /** ����ttyname */
    private String ttyName = "";
    /** ����prttype */
    private String prtType = "";
    /** ����prtname */
    private String prtName = "";
    /** ����prtmode */
    private String prtMode = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiTtyCodeDtoBase����
     */
    public UtiTtyCodeDtoBase(){
    }

    /**
     * ��������ttycode
     * @param ttyCode �����õ�����ttycode��ֵ
     */
    public void setTtyCode(String ttyCode){
        this.ttyCode = StringUtils.rightTrim(ttyCode);
    }

    /**
     * ��ȡ����ttycode
     * @return ����ttycode��ֵ
     */
    public String getTtyCode(){
        return ttyCode;
    }

    /**
     * ��������ttytype
     * @param ttyType �����õ�����ttytype��ֵ
     */
    public void setTtyType(String ttyType){
        this.ttyType = StringUtils.rightTrim(ttyType);
    }

    /**
     * ��ȡ����ttytype
     * @return ����ttytype��ֵ
     */
    public String getTtyType(){
        return ttyType;
    }

    /**
     * ��������ttyname
     * @param ttyName �����õ�����ttyname��ֵ
     */
    public void setTtyName(String ttyName){
        this.ttyName = StringUtils.rightTrim(ttyName);
    }

    /**
     * ��ȡ����ttyname
     * @return ����ttyname��ֵ
     */
    public String getTtyName(){
        return ttyName;
    }

    /**
     * ��������prttype
     * @param prtType �����õ�����prttype��ֵ
     */
    public void setPrtType(String prtType){
        this.prtType = StringUtils.rightTrim(prtType);
    }

    /**
     * ��ȡ����prttype
     * @return ����prttype��ֵ
     */
    public String getPrtType(){
        return prtType;
    }

    /**
     * ��������prtname
     * @param prtName �����õ�����prtname��ֵ
     */
    public void setPrtName(String prtName){
        this.prtName = StringUtils.rightTrim(prtName);
    }

    /**
     * ��ȡ����prtname
     * @return ����prtname��ֵ
     */
    public String getPrtName(){
        return prtName;
    }

    /**
     * ��������prtmode
     * @param prtMode �����õ�����prtmode��ֵ
     */
    public void setPrtMode(String prtMode){
        this.prtMode = StringUtils.rightTrim(prtMode);
    }

    /**
     * ��ȡ����prtmode
     * @return ����prtmode��ֵ
     */
    public String getPrtMode(){
        return prtMode;
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
