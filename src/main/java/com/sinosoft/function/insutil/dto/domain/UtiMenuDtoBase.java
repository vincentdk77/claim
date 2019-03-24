package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utimenu的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiMenuDtoBase implements Serializable{
    /** 属性menuname */
    private String menuName = "";
    /** 属性hotkey */
    private String hotKey = "";
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性menuitem */
    private String menuItem = "";
    /** 属性message */
    private String message = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiMenuDtoBase对象
     */
    public UtiMenuDtoBase(){
    }

    /**
     * 设置属性menuname
     * @param menuName 待设置的属性menuname的值
     */
    public void setMenuName(String menuName){
        this.menuName = StringUtils.rightTrim(menuName);
    }

    /**
     * 获取属性menuname
     * @return 属性menuname的值
     */
    public String getMenuName(){
        return menuName;
    }

    /**
     * 设置属性hotkey
     * @param hotKey 待设置的属性hotkey的值
     */
    public void setHotKey(String hotKey){
        this.hotKey = StringUtils.rightTrim(hotKey);
    }

    /**
     * 获取属性hotkey
     * @return 属性hotkey的值
     */
    public String getHotKey(){
        return hotKey;
    }

    /**
     * 设置属性riskcode
     * @param riskCode 待设置的属性riskcode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性riskcode
     * @return 属性riskcode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性menuitem
     * @param menuItem 待设置的属性menuitem的值
     */
    public void setMenuItem(String menuItem){
        this.menuItem = StringUtils.rightTrim(menuItem);
    }

    /**
     * 获取属性menuitem
     * @return 属性menuitem的值
     */
    public String getMenuItem(){
        return menuItem;
    }

    /**
     * 设置属性message
     * @param message 待设置的属性message的值
     */
    public void setMessage(String message){
        this.message = StringUtils.rightTrim(message);
    }

    /**
     * 获取属性message
     * @return 属性message的值
     */
    public String getMessage(){
        return message;
    }

    /**
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public String getFlag(){
        return flag;
    }
}
