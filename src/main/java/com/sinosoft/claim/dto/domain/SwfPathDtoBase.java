package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是SwfPath工作流路径定义表（新增）的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.859<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfPathDtoBase implements Serializable{
    /** 属性模板编号 */
    private int modelNo = 0;
    /** 属性模板名称 */
    private String modelName = "";
    /** 属性程边号 */
    private int pathNo = 0;
    /** 属性路径名称 */
    private String pathName = "";
    /** 属性起始节点 */
    private int startNodeNo = 0;
    /** 属性起始节点名称 */
    private String startNodeName = "";
    /** 属性终止节点 */
    private int endNodeNo = 0;
    /** 属性终止节点名称 */
    private String endNodeName = "";
    /** 属性优先级别 */
    private int priority = 0;
    /** 属性是否缺省值 */
    private String defaultFlag = "";
    /** 属性备用标志 */
    private String flag = "";
    /** 属性是否存在流转条件 */
    private String conditionStatus = "";
    /** 属性正向流转所调用服务名 */
    private String forwardServices = "";
    /** 属性逆向流转所调用服务名 */
    private String backwardServices = "";

    /**
     *  默认构造方法,构造一个默认的SwfPathDtoBase对象
     */
    public SwfPathDtoBase(){
    }

    /**
     * 设置属性模板编号
     * @param modelNo 待设置的属性模板编号的值
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * 获取属性模板编号
     * @return 属性模板编号的值
     */
    public int getModelNo(){
        return modelNo;
    }

    /**
     * 设置属性模板名称
     * @param modelName 待设置的属性模板名称的值
     */
    public void setModelName(String modelName){
        this.modelName = StringUtils.rightTrim(modelName);
    }

    /**
     * 获取属性模板名称
     * @return 属性模板名称的值
     */
    public String getModelName(){
        return modelName;
    }

    /**
     * 设置属性程边号
     * @param pathNo 待设置的属性程边号的值
     */
    public void setPathNo(int pathNo){
        this.pathNo = pathNo;
    }

    /**
     * 获取属性程边号
     * @return 属性程边号的值
     */
    public int getPathNo(){
        return pathNo;
    }

    /**
     * 设置属性路径名称
     * @param pathName 待设置的属性路径名称的值
     */
    public void setPathName(String pathName){
        this.pathName = StringUtils.rightTrim(pathName);
    }

    /**
     * 获取属性路径名称
     * @return 属性路径名称的值
     */
    public String getPathName(){
        return pathName;
    }

    /**
     * 设置属性起始节点
     * @param startNodeNo 待设置的属性起始节点的值
     */
    public void setStartNodeNo(int startNodeNo){
        this.startNodeNo = startNodeNo;
    }

    /**
     * 获取属性起始节点
     * @return 属性起始节点的值
     */
    public int getStartNodeNo(){
        return startNodeNo;
    }

    /**
     * 设置属性起始节点名称
     * @param startNodeName 待设置的属性起始节点名称的值
     */
    public void setStartNodeName(String startNodeName){
        this.startNodeName = StringUtils.rightTrim(startNodeName);
    }

    /**
     * 获取属性起始节点名称
     * @return 属性起始节点名称的值
     */
    public String getStartNodeName(){
        return startNodeName;
    }

    /**
     * 设置属性终止节点
     * @param endNodeNo 待设置的属性终止节点的值
     */
    public void setEndNodeNo(int endNodeNo){
        this.endNodeNo = endNodeNo;
    }

    /**
     * 获取属性终止节点
     * @return 属性终止节点的值
     */
    public int getEndNodeNo(){
        return endNodeNo;
    }

    /**
     * 设置属性终止节点名称
     * @param endNodeName 待设置的属性终止节点名称的值
     */
    public void setEndNodeName(String endNodeName){
        this.endNodeName = StringUtils.rightTrim(endNodeName);
    }

    /**
     * 获取属性终止节点名称
     * @return 属性终止节点名称的值
     */
    public String getEndNodeName(){
        return endNodeName;
    }

    /**
     * 设置属性优先级别
     * @param priority 待设置的属性优先级别的值
     */
    public void setPriority(int priority){
        this.priority = priority;
    }

    /**
     * 获取属性优先级别
     * @return 属性优先级别的值
     */
    public int getPriority(){
        return priority;
    }

    /**
     * 设置属性是否缺省值
     * @param defaultFlag 待设置的属性是否缺省值的值
     */
    public void setDefaultFlag(String defaultFlag){
        this.defaultFlag = StringUtils.rightTrim(defaultFlag);
    }

    /**
     * 获取属性是否缺省值
     * @return 属性是否缺省值的值
     */
    public String getDefaultFlag(){
        return defaultFlag;
    }

    /**
     * 设置属性备用标志
     * @param flag 待设置的属性备用标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性备用标志
     * @return 属性备用标志的值
     */
    public String getFlag(){
        return flag;
    }

    /**
     * 设置属性是否存在流转条件
     * @param conditionStatus 待设置的属性是否存在流转条件的值
     */
    public void setConditionStatus(String conditionStatus){
        this.conditionStatus = StringUtils.rightTrim(conditionStatus);
    }

    /**
     * 获取属性是否存在流转条件
     * @return 属性是否存在流转条件的值
     */
    public String getConditionStatus(){
        return conditionStatus;
    }

    /**
     * 设置属性正向流转所调用服务名
     * @param forwardServices 待设置的属性正向流转所调用服务名的值
     */
    public void setForwardServices(String forwardServices){
        this.forwardServices = StringUtils.rightTrim(forwardServices);
    }

    /**
     * 获取属性正向流转所调用服务名
     * @return 属性正向流转所调用服务名的值
     */
    public String getForwardServices(){
        return forwardServices;
    }

    /**
     * 设置属性逆向流转所调用服务名
     * @param backwardServices 待设置的属性逆向流转所调用服务名的值
     */
    public void setBackwardServices(String backwardServices){
        this.backwardServices = StringUtils.rightTrim(backwardServices);
    }

    /**
     * 获取属性逆向流转所调用服务名
     * @return 属性逆向流转所调用服务名的值
     */
    public String getBackwardServices(){
        return backwardServices;
    }
}
