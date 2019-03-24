package com.sinosoft.servlet.accisd.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLACCIBASEINFOSD的数据传输对象基类<br>
 */
public class PrpLAcciBaseInfoSDDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性NAME */
    private String name = "";
    /** 属性GENDER */
    private String gender = "";
    /** 属性BIRTHDAY */
    private String birthday = "";
    /** 属性CREDENTIALTYPE */
    private String credentialType = "";
    /** 属性CREDENTIALNO */
    private String credentialNo = "";

    /**
     *  默认构造方法,构造一个默认的PrplaccibaseinfosdDtoBase对象
     */
    public PrpLAcciBaseInfoSDDtoBase(){
    }

    /**
     * 设置属性NAME
     * @param name 待设置的属性NAME的值
     */
    public void setName(String name){
        this.name = StringUtils.rightTrim(name);
    }

    /**
     * 获取属性NAME
     * @return 属性NAME的值
     */
    public String getName(){
        return name;
    }

    /**
     * 设置属性GENDER
     * @param gender 待设置的属性GENDER的值
     */
    public void setGender(String gender){
        this.gender = StringUtils.rightTrim(gender);
    }

    /**
     * 获取属性GENDER
     * @return 属性GENDER的值
     */
    public String getGender(){
        return gender;
    }

    /**
     * 设置属性BIRTHDAY
     * @param birthday 待设置的属性BIRTHDAY的值
     */
    public void setBirthday(String birthday){
        this.birthday = StringUtils.rightTrim(birthday);
    }

    /**
     * 获取属性BIRTHDAY
     * @return 属性BIRTHDAY的值
     */
    public String getBirthday(){
        return birthday;
    }

    /**
     * 设置属性CREDENTIALTYPE
     * @param credentialtype 待设置的属性CREDENTIALTYPE的值
     */
    public void setCredentialType(String credentialtype){
        this.credentialType = StringUtils.rightTrim(credentialtype);
    }

    /**
     * 获取属性CREDENTIALTYPE
     * @return 属性CREDENTIALTYPE的值
     */
    public String getCredentialType(){
        return credentialType;
    }

    /**
     * 设置属性CREDENTIALNO
     * @param credentialno 待设置的属性CREDENTIALNO的值
     */
    public void setCredentialNo(String credentialno){
        this.credentialNo = StringUtils.rightTrim(credentialno);
    }

    /**
     * 获取属性CREDENTIALNO
     * @return 属性CREDENTIALNO的值
     */
    public String getCredentialNo(){
        return credentialNo;
    }
}
