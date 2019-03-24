package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是SwfNode工作流节点定义表（新增）的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.843<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfNodeDtoBase implements Serializable{
    /** 属性模板编号 */
    private int modelNo = 0;
    /** 属性模板名称 */
    private String modelName = "";
    /** 属性节点编号 */
    private int nodeNo = 0;
    /** 属性节点名称 */
    private String nodeName = "";
    /** 属性处理时限 */
    private int timeLimit = 0;
    /** 属性结束标志 */
    private String endFlag = "";
    /** 属性处理要求 */
    private String criterion = "";
    /** 属性备用标志 */
    private String flag = "";
    /** 属性任务编号 */
    private int taskNo = 0;
    /** 属性任务类型 */
    private String taskType = "";
    /** 属性节点类型 */
    private String nodeType = "";
    /** 属性办理部门 */
    private String unitCode = "";
    /** 属性部门名称 */
    private String unitName = "";
    /** 属性办理人员编码 */
    private String handlerCode = "";
    /** 属性办理人员名称 */
    private String handlerName = "";
    /** 属性节点X坐标 */
    private int posX = 0;
    /** 属性节点Y坐标 */
    private int posY = 0;

    /**
     *  默认构造方法,构造一个默认的SwfNodeDtoBase对象
     */
    public SwfNodeDtoBase(){
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
     * 设置属性节点编号
     * @param nodeNo 待设置的属性节点编号的值
     */
    public void setNodeNo(int nodeNo){
        this.nodeNo = nodeNo;
    }

    /**
     * 获取属性节点编号
     * @return 属性节点编号的值
     */
    public int getNodeNo(){
        return nodeNo;
    }

    /**
     * 设置属性节点名称
     * @param nodeName 待设置的属性节点名称的值
     */
    public void setNodeName(String nodeName){
        this.nodeName = StringUtils.rightTrim(nodeName);
    }

    /**
     * 获取属性节点名称
     * @return 属性节点名称的值
     */
    public String getNodeName(){
        return nodeName;
    }

    /**
     * 设置属性处理时限
     * @param timeLimit 待设置的属性处理时限的值
     */
    public void setTimeLimit(int timeLimit){
        this.timeLimit = timeLimit;
    }

    /**
     * 获取属性处理时限
     * @return 属性处理时限的值
     */
    public int getTimeLimit(){
        return timeLimit;
    }

    /**
     * 设置属性结束标志
     * @param endFlag 待设置的属性结束标志的值
     */
    public void setEndFlag(String endFlag){
        this.endFlag = StringUtils.rightTrim(endFlag);
    }

    /**
     * 获取属性结束标志
     * @return 属性结束标志的值
     */
    public String getEndFlag(){
        return endFlag;
    }

    /**
     * 设置属性处理要求
     * @param criterion 待设置的属性处理要求的值
     */
    public void setCriterion(String criterion){
        this.criterion = StringUtils.rightTrim(criterion);
    }

    /**
     * 获取属性处理要求
     * @return 属性处理要求的值
     */
    public String getCriterion(){
        return criterion;
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
     * 设置属性任务编号
     * @param taskNo 待设置的属性任务编号的值
     */
    public void setTaskNo(int taskNo){
        this.taskNo = taskNo;
    }

    /**
     * 获取属性任务编号
     * @return 属性任务编号的值
     */
    public int getTaskNo(){
        return taskNo;
    }

    /**
     * 设置属性任务类型
     * @param taskType 待设置的属性任务类型的值
     */
    public void setTaskType(String taskType){
        this.taskType = StringUtils.rightTrim(taskType);
    }

    /**
     * 获取属性任务类型
     * @return 属性任务类型的值
     */
    public String getTaskType(){
        return taskType;
    }

    /**
     * 设置属性节点类型
     * @param nodeType 待设置的属性节点类型的值
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * 获取属性节点类型
     * @return 属性节点类型的值
     */
    public String getNodeType(){
        return nodeType;
    }

    /**
     * 设置属性办理部门
     * @param unitCode 待设置的属性办理部门的值
     */
    public void setUnitCode(String unitCode){
        this.unitCode = StringUtils.rightTrim(unitCode);
    }

    /**
     * 获取属性办理部门
     * @return 属性办理部门的值
     */
    public String getUnitCode(){
        return unitCode;
    }

    /**
     * 设置属性部门名称
     * @param unitName 待设置的属性部门名称的值
     */
    public void setUnitName(String unitName){
        this.unitName = StringUtils.rightTrim(unitName);
    }

    /**
     * 获取属性部门名称
     * @return 属性部门名称的值
     */
    public String getUnitName(){
        return unitName;
    }

    /**
     * 设置属性办理人员编码
     * @param handlerCode 待设置的属性办理人员编码的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性办理人员编码
     * @return 属性办理人员编码的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性办理人员名称
     * @param handlerName 待设置的属性办理人员名称的值
     */
    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * 获取属性办理人员名称
     * @return 属性办理人员名称的值
     */
    public String getHandlerName(){
        return handlerName;
    }

    /**
     * 设置属性节点X坐标
     * @param posX 待设置的属性节点X坐标的值
     */
    public void setPosX(int posX){
        this.posX = posX;
    }

    /**
     * 获取属性节点X坐标
     * @return 属性节点X坐标的值
     */
    public int getPosX(){
        return posX;
    }

    /**
     * 设置属性节点Y坐标
     * @param posY 待设置的属性节点Y坐标的值
     */
    public void setPosY(int posY){
        this.posY = posY;
    }

    /**
     * 获取属性节点Y坐标
     * @return 属性节点Y坐标的值
     */
    public int getPosY(){
        return posY;
    }
}
