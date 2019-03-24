package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是SwfPathLog工作流路径日志表（新增）的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.859<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfPathLogDtoBase implements Serializable{
    /** 属性流程编号 */
    private String flowID = "";
    /** 属性流程边号 */
    private int pathNo = 0;
    /** 属性模板号 */
    private int modelNo = 0;
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
    /** 属性流入时间 */
    private DateTime flowInTime = new DateTime();
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的SwfPathLogDtoBase对象
     */
    public SwfPathLogDtoBase(){
    }

    /**
     * 设置属性流程编号
     * @param flowID 待设置的属性流程编号的值
     */
    public void setFlowID(String flowID){
        this.flowID = StringUtils.rightTrim(flowID);
    }

    /**
     * 获取属性流程编号
     * @return 属性流程编号的值
     */
    public String getFlowID(){
        return flowID;
    }

    /**
     * 设置属性流程边号
     * @param pathNo 待设置的属性流程边号的值
     */
    public void setPathNo(int pathNo){
        this.pathNo = pathNo;
    }

    /**
     * 获取属性流程边号
     * @return 属性流程边号的值
     */
    public int getPathNo(){
        return pathNo;
    }

    /**
     * 设置属性模板号
     * @param modelNo 待设置的属性模板号的值
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * 获取属性模板号
     * @return 属性模板号的值
     */
    public int getModelNo(){
        return modelNo;
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
     * 设置属性流入时间
     * @param flowInTime 待设置的属性流入时间的值
     */
    public void setFlowInTime(DateTime flowInTime){
        this.flowInTime = flowInTime;
    }

    /**
     * 获取属性流入时间
     * @return 属性流入时间的值
     */
    public DateTime getFlowInTime(){
        return flowInTime;
    }

    /**
     * 设置属性标志位
     * @param flag 待设置的属性标志位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志位
     * @return 属性标志位的值
     */
    public String getFlag(){
        return flag;
    }
}
