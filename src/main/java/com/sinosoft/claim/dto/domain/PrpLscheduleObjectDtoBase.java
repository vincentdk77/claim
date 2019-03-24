package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLscheduleObject-调度对象表的数据传输对象基类<br>
 * 创建于 2005-07-11 16:53:05.889<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleObjectDtoBase implements Serializable{
    /** 属性调度对象代码 */
    private String scheduleObjectID = "";
    /** 属性调度对象名称 */
    private String scheduleObjectName = "";
    /** 属性调度对象类别 */
    private String objectType = "";
    /** 属性调度对象所在表主键 */
    private String objectKey = "";
    /** 属性调度对象所在表 */
    private String objectTable = "";
    /** 属性调度对象所属地区 */
    private String objectArea = "";
    /** 属性调度对象所属分组 */
    private int objectGroup = 0;
    /** 属性标志 */
    private String flag = "";
    /** 属性机构代码 */
    private String comCode = "";

    /**
     *  默认构造方法,构造一个默认的PrpLscheduleObjectDtoBase对象
     */
    public PrpLscheduleObjectDtoBase(){
    }

    /**
     * 设置属性调度对象代码
     * @param scheduleObjectID 待设置的属性调度对象代码的值
     */
    public void setScheduleObjectID(String scheduleObjectID){
        this.scheduleObjectID = StringUtils.rightTrim(scheduleObjectID);
    }

    /**
     * 获取属性调度对象代码
     * @return 属性调度对象代码的值
     */
    public String getScheduleObjectID(){
        return scheduleObjectID;
    }

    /**
     * 设置属性调度对象名称
     * @param scheduleObjectName 待设置的属性调度对象名称的值
     */
    public void setScheduleObjectName(String scheduleObjectName){
        this.scheduleObjectName = StringUtils.rightTrim(scheduleObjectName);
    }

    /**
     * 获取属性调度对象名称
     * @return 属性调度对象名称的值
     */
    public String getScheduleObjectName(){
        return scheduleObjectName;
    }

    /**
     * 设置属性调度对象类别
     * @param objectType 待设置的属性调度对象类别的值
     */
    public void setObjectType(String objectType){
        this.objectType = StringUtils.rightTrim(objectType);
    }

    /**
     * 获取属性调度对象类别
     * @return 属性调度对象类别的值
     */
    public String getObjectType(){
        return objectType;
    }

    /**
     * 设置属性调度对象所在表主键
     * @param objectKey 待设置的属性调度对象所在表主键的值
     */
    public void setObjectKey(String objectKey){
        this.objectKey = StringUtils.rightTrim(objectKey);
    }

    /**
     * 获取属性调度对象所在表主键
     * @return 属性调度对象所在表主键的值
     */
    public String getObjectKey(){
        return objectKey;
    }

    /**
     * 设置属性调度对象所在表
     * @param objectTable 待设置的属性调度对象所在表的值
     */
    public void setObjectTable(String objectTable){
        this.objectTable = StringUtils.rightTrim(objectTable);
    }

    /**
     * 获取属性调度对象所在表
     * @return 属性调度对象所在表的值
     */
    public String getObjectTable(){
        return objectTable;
    }

    /**
     * 设置属性调度对象所属地区
     * @param objectArea 待设置的属性调度对象所属地区的值
     */
    public void setObjectArea(String objectArea){
        this.objectArea = StringUtils.rightTrim(objectArea);
    }

    /**
     * 获取属性调度对象所属地区
     * @return 属性调度对象所属地区的值
     */
    public String getObjectArea(){
        return objectArea;
    }

    /**
     * 设置属性调度对象所属分组
     * @param objectGroup 待设置的属性调度对象所属分组的值
     */
    public void setObjectGroup(int objectGroup){
        this.objectGroup = objectGroup;
    }

    /**
     * 获取属性调度对象所属分组
     * @return 属性调度对象所属分组的值
     */
    public int getObjectGroup(){
        return objectGroup;
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

    /**
     * 设置属性机构代码
     * @param comCode 待设置的属性机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性机构代码
     * @return 属性机构代码的值
     */
    public String getComCode(){
        return comCode;
    }
}
