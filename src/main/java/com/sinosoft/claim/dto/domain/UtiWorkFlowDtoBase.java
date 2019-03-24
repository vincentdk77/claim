package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utiworkflow工作流表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiWorkFlowDtoBase implements Serializable{
    /** 属性工作流名称 */
    private String workflowName = "";
    /** 属性工序 */
    private String orderNo = "";
    /** 属性消息 */
    private String message = "";
    /** 属性提示 */
    private String note = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiWorkFlowDtoBase对象
     */
    public UtiWorkFlowDtoBase(){
    }

    /**
     * 设置属性工作流名称
     * @param workflowName 待设置的属性工作流名称的值
     */
    public void setWorkflowName(String workflowName){
        this.workflowName = StringUtils.rightTrim(workflowName);
    }

    /**
     * 获取属性工作流名称
     * @return 属性工作流名称的值
     */
    public String getWorkflowName(){
        return workflowName;
    }

    /**
     * 设置属性工序
     * @param orderNo 待设置的属性工序的值
     */
    public void setOrderNo(String orderNo){
        this.orderNo = StringUtils.rightTrim(orderNo);
    }

    /**
     * 获取属性工序
     * @return 属性工序的值
     */
    public String getOrderNo(){
        return orderNo;
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
     * 设置属性提示
     * @param note 待设置的属性提示的值
     */
    public void setNote(String note){
        this.note = StringUtils.rightTrim(note);
    }

    /**
     * 获取属性提示
     * @return 属性提示的值
     */
    public String getNote(){
        return note;
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
