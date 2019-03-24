package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utimenu�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiMenuDtoBase implements Serializable{
    /** ����menuname */
    private String menuName = "";
    /** ����hotkey */
    private String hotKey = "";
    /** ����riskcode */
    private String riskCode = "";
    /** ����menuitem */
    private String menuItem = "";
    /** ����message */
    private String message = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiMenuDtoBase����
     */
    public UtiMenuDtoBase(){
    }

    /**
     * ��������menuname
     * @param menuName �����õ�����menuname��ֵ
     */
    public void setMenuName(String menuName){
        this.menuName = StringUtils.rightTrim(menuName);
    }

    /**
     * ��ȡ����menuname
     * @return ����menuname��ֵ
     */
    public String getMenuName(){
        return menuName;
    }

    /**
     * ��������hotkey
     * @param hotKey �����õ�����hotkey��ֵ
     */
    public void setHotKey(String hotKey){
        this.hotKey = StringUtils.rightTrim(hotKey);
    }

    /**
     * ��ȡ����hotkey
     * @return ����hotkey��ֵ
     */
    public String getHotKey(){
        return hotKey;
    }

    /**
     * ��������riskcode
     * @param riskCode �����õ�����riskcode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����riskcode
     * @return ����riskcode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������menuitem
     * @param menuItem �����õ�����menuitem��ֵ
     */
    public void setMenuItem(String menuItem){
        this.menuItem = StringUtils.rightTrim(menuItem);
    }

    /**
     * ��ȡ����menuitem
     * @return ����menuitem��ֵ
     */
    public String getMenuItem(){
        return menuItem;
    }

    /**
     * ��������message
     * @param message �����õ�����message��ֵ
     */
    public void setMessage(String message){
        this.message = StringUtils.rightTrim(message);
    }

    /**
     * ��ȡ����message
     * @return ����message��ֵ
     */
    public String getMessage(){
        return message;
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
