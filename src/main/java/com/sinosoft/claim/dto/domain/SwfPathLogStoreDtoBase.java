package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是SwfPathLogStore的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class SwfPathLogStoreDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性flowID */
    private String flowID = "";
    /** 属性pathNo */
    private int pathNo = 0;
    /** 属性modelNo */
    private int modelNo = 0;
    /** 属性pathName */
    private String pathName = "";
    /** 属性startNodeNo */
    private int startNodeNo = 0;
    /** 属性startNodeName */
    private String startNodeName = "";
    /** 属性endNodeNo */
    private int endNodeNo = 0;
    /** 属性endNodeName */
    private String endNodeName = "";
    /** 属性flowInTime */
    private DateTime flowInTime = new DateTime();
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的SwfPathLogStoreDtoBase对象
     */
    public SwfPathLogStoreDtoBase(){
    }

    /**
     * 设置属性flowID
     * @param flowID 待设置的属性flowID的值
     */
    public void setFlowID(String flowID){
        this.flowID = StringUtils.rightTrim(flowID);
    }

    /**
     * 获取属性flowID
     * @return 属性flowID的值
     */
    public String getFlowID(){
        return flowID;
    }

    /**
     * 设置属性pathNo
     * @param pathNo 待设置的属性pathNo的值
     */
    public void setPathNo(int pathNo){
        this.pathNo = pathNo;
    }

    /**
     * 获取属性pathNo
     * @return 属性pathNo的值
     */
    public int getPathNo(){
        return pathNo;
    }

    /**
     * 设置属性modelNo
     * @param modelNo 待设置的属性modelNo的值
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * 获取属性modelNo
     * @return 属性modelNo的值
     */
    public int getModelNo(){
        return modelNo;
    }

    /**
     * 设置属性pathName
     * @param pathName 待设置的属性pathName的值
     */
    public void setPathName(String pathName){
        this.pathName = StringUtils.rightTrim(pathName);
    }

    /**
     * 获取属性pathName
     * @return 属性pathName的值
     */
    public String getPathName(){
        return pathName;
    }

    /**
     * 设置属性startNodeNo
     * @param startNodeNo 待设置的属性startNodeNo的值
     */
    public void setStartNodeNo(int startNodeNo){
        this.startNodeNo = startNodeNo;
    }

    /**
     * 获取属性startNodeNo
     * @return 属性startNodeNo的值
     */
    public int getStartNodeNo(){
        return startNodeNo;
    }

    /**
     * 设置属性startNodeName
     * @param startNodeName 待设置的属性startNodeName的值
     */
    public void setStartNodeName(String startNodeName){
        this.startNodeName = StringUtils.rightTrim(startNodeName);
    }

    /**
     * 获取属性startNodeName
     * @return 属性startNodeName的值
     */
    public String getStartNodeName(){
        return startNodeName;
    }

    /**
     * 设置属性endNodeNo
     * @param endNodeNo 待设置的属性endNodeNo的值
     */
    public void setEndNodeNo(int endNodeNo){
        this.endNodeNo = endNodeNo;
    }

    /**
     * 获取属性endNodeNo
     * @return 属性endNodeNo的值
     */
    public int getEndNodeNo(){
        return endNodeNo;
    }

    /**
     * 设置属性endNodeName
     * @param endNodeName 待设置的属性endNodeName的值
     */
    public void setEndNodeName(String endNodeName){
        this.endNodeName = StringUtils.rightTrim(endNodeName);
    }

    /**
     * 获取属性endNodeName
     * @return 属性endNodeName的值
     */
    public String getEndNodeName(){
        return endNodeName;
    }

    /**
     * 设置属性flowInTime
     * @param flowInTime 待设置的属性flowInTime的值
     */
    public void setFlowInTime(DateTime flowInTime){
        this.flowInTime = flowInTime;
    }

    /**
     * 获取属性flowInTime
     * @return 属性flowInTime的值
     */
    public DateTime getFlowInTime(){
        return flowInTime;
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
