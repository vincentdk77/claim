package com.sinosoft.ciplatform.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是商业险平台配置表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class UtiConfigMapDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性系统名 */
    private String systemName = "";
    /** 属性类名 */
    private String className = "";
    /** 属性HashMap名 */
    private String mapName = "";
    /** 属性键 */
    private String keyValue = "";
    /** 属性值 */
    private String value = "";
    /** 属性有效状态 */
    private String validStatus = "";
    /** 属性预留标志 */
    private String flag = "";
    /** 属性录入时间 */
    private DateTime inputDate = new DateTime();

    /**
     *  默认构造方法,构造一个默认的UtiConfigMapDtoBase对象
     */
    public UtiConfigMapDtoBase(){
    }

    /**
     * 设置属性系统名
     * @param systemName 待设置的属性系统名的值
     */
    public void setSystemName(String systemName){
        this.systemName = StringUtils.rightTrim(systemName);
    }

    /**
     * 获取属性系统名
     * @return 属性系统名的值
     */
    public String getSystemName(){
        return systemName;
    }

    /**
     * 设置属性类名
     * @param className 待设置的属性类名的值
     */
    public void setClassName(String className){
        this.className = StringUtils.rightTrim(className);
    }

    /**
     * 获取属性类名
     * @return 属性类名的值
     */
    public String getClassName(){
        return className;
    }

    /**
     * 设置属性HashMap名
     * @param mapName 待设置的属性HashMap名的值
     */
    public void setMapName(String mapName){
        this.mapName = StringUtils.rightTrim(mapName);
    }

    /**
     * 获取属性HashMap名
     * @return 属性HashMap名的值
     */
    public String getMapName(){
        return mapName;
    }

    /**
     * 设置属性键
     * @param keyValue 待设置的属性键的值
     */
    public void setKeyValue(String keyValue){
        this.keyValue = StringUtils.rightTrim(keyValue);
    }

    /**
     * 获取属性键
     * @return 属性键的值
     */
    public String getKeyValue(){
        return keyValue;
    }

    /**
     * 设置属性值
     * @param value 待设置的属性值的值
     */
    public void setValue(String value){
        this.value = StringUtils.rightTrim(value);
    }

    /**
     * 获取属性值
     * @return 属性值的值
     */
    public String getValue(){
        return value;
    }

    /**
     * 设置属性有效状态
     * @param validStatus 待设置的属性有效状态的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性有效状态
     * @return 属性有效状态的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性预留标志
     * @param flag 待设置的属性预留标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性预留标志
     * @return 属性预留标志的值
     */
    public String getFlag(){
        return flag;
    }

    /**
     * 设置属性录入时间
     * @param inputDate 待设置的属性录入时间的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性录入时间
     * @return 属性录入时间的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }
}
