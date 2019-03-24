package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����uticonfig���������ݱ������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiConfigDtoBase implements Serializable{
    /** ����cfgid */
    private String cfgid = "";
    /** ����cfgoth */
    private String cfgoth = "";
    /** ����cfgothmean */
    private String cfgothmean = "";
    /** ����cfgvalue */
    private String cfgvalue = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiConfigDtoBase����
     */
    public UtiConfigDtoBase(){
    }

    /**
     * ��������cfgid
     * @param cfgid �����õ�����cfgid��ֵ
     */
    public void setCfgid(String cfgid){
        this.cfgid = StringUtils.rightTrim(cfgid);
    }

    /**
     * ��ȡ����cfgid
     * @return ����cfgid��ֵ
     */
    public String getCfgid(){
        return cfgid;
    }

    /**
     * ��������cfgoth
     * @param cfgoth �����õ�����cfgoth��ֵ
     */
    public void setCfgoth(String cfgoth){
        this.cfgoth = StringUtils.rightTrim(cfgoth);
    }

    /**
     * ��ȡ����cfgoth
     * @return ����cfgoth��ֵ
     */
    public String getCfgoth(){
        return cfgoth;
    }

    /**
     * ��������cfgothmean
     * @param cfgothmean �����õ�����cfgothmean��ֵ
     */
    public void setCfgothmean(String cfgothmean){
        this.cfgothmean = StringUtils.rightTrim(cfgothmean);
    }

    /**
     * ��ȡ����cfgothmean
     * @return ����cfgothmean��ֵ
     */
    public String getCfgothmean(){
        return cfgothmean;
    }

    /**
     * ��������cfgvalue
     * @param cfgvalue �����õ�����cfgvalue��ֵ
     */
    public void setCfgvalue(String cfgvalue){
        this.cfgvalue = StringUtils.rightTrim(cfgvalue);
    }

    /**
     * ��ȡ����cfgvalue
     * @return ����cfgvalue��ֵ
     */
    public String getCfgvalue(){
        return cfgvalue;
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
