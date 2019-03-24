package com.sinosoft.servlet.accisd.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLACCIBASEINFOSD�����ݴ���������<br>
 */
public class PrpLAcciBaseInfoSDDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����NAME */
    private String name = "";
    /** ����GENDER */
    private String gender = "";
    /** ����BIRTHDAY */
    private String birthday = "";
    /** ����CREDENTIALTYPE */
    private String credentialType = "";
    /** ����CREDENTIALNO */
    private String credentialNo = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplaccibaseinfosdDtoBase����
     */
    public PrpLAcciBaseInfoSDDtoBase(){
    }

    /**
     * ��������NAME
     * @param name �����õ�����NAME��ֵ
     */
    public void setName(String name){
        this.name = StringUtils.rightTrim(name);
    }

    /**
     * ��ȡ����NAME
     * @return ����NAME��ֵ
     */
    public String getName(){
        return name;
    }

    /**
     * ��������GENDER
     * @param gender �����õ�����GENDER��ֵ
     */
    public void setGender(String gender){
        this.gender = StringUtils.rightTrim(gender);
    }

    /**
     * ��ȡ����GENDER
     * @return ����GENDER��ֵ
     */
    public String getGender(){
        return gender;
    }

    /**
     * ��������BIRTHDAY
     * @param birthday �����õ�����BIRTHDAY��ֵ
     */
    public void setBirthday(String birthday){
        this.birthday = StringUtils.rightTrim(birthday);
    }

    /**
     * ��ȡ����BIRTHDAY
     * @return ����BIRTHDAY��ֵ
     */
    public String getBirthday(){
        return birthday;
    }

    /**
     * ��������CREDENTIALTYPE
     * @param credentialtype �����õ�����CREDENTIALTYPE��ֵ
     */
    public void setCredentialType(String credentialtype){
        this.credentialType = StringUtils.rightTrim(credentialtype);
    }

    /**
     * ��ȡ����CREDENTIALTYPE
     * @return ����CREDENTIALTYPE��ֵ
     */
    public String getCredentialType(){
        return credentialType;
    }

    /**
     * ��������CREDENTIALNO
     * @param credentialno �����õ�����CREDENTIALNO��ֵ
     */
    public void setCredentialNo(String credentialno){
        this.credentialNo = StringUtils.rightTrim(credentialno);
    }

    /**
     * ��ȡ����CREDENTIALNO
     * @return ����CREDENTIALNO��ֵ
     */
    public String getCredentialNo(){
        return credentialNo;
    }
}
