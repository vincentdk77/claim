package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utimenu菜单控制表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiMenuDtoBase implements Serializable{
    /** 属性菜单名 */
    private String menuName = "";
    /** 属性热键 */
    private String hotKey = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性菜单条 */
    private String menuItem = "";
    /** 属性消息 */
    private String message = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiMenuDtoBase对象
     */
    public UtiMenuDtoBase(){
    }

    /**
     * 设置属性菜单名
     * @param menuName 待设置的属性菜单名的值
     */
    public void setMenuName(String menuName){
        this.menuName = StringUtils.rightTrim(menuName);
    }

    /**
     * 获取属性菜单名
     * @return 属性菜单名的值
     */
    public String getMenuName(){
        return menuName;
    }

    /**
     * 设置属性热键
     * @param hotKey 待设置的属性热键的值
     */
    public void setHotKey(String hotKey){
        this.hotKey = StringUtils.rightTrim(hotKey);
    }

    /**
     * 获取属性热键
     * @return 属性热键的值
     */
    public String getHotKey(){
        return hotKey;
    }

    /**
     * 设置属性险种
     * @param riskCode 待设置的属性险种的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种
     * @return 属性险种的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性菜单条
     * @param menuItem 待设置的属性菜单条的值
     */
    public void setMenuItem(String menuItem){
        this.menuItem = StringUtils.rightTrim(menuItem);
    }

    /**
     * 获取属性菜单条
     * @return 属性菜单条的值
     */
    public String getMenuItem(){
        return menuItem;
    }

    /**
     * 设置属性消息
     * @param message 待设置的属性消息的值
     */
    public void setMessage(String message){
        this.message = StringUtils.rightTrim(message);
    }

    /**
     * 获取属性消息
     * @return 属性消息的值
     */
    public String getMessage(){
        return message;
    }

    /**
     * 设置属性标志
     * @param flag 待设置的属性标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志
     * @return 属性标志的值
     */
    public String getFlag(){
        return flag;
    }
}
