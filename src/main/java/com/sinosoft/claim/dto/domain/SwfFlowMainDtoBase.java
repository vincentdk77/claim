package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是SwfFlowMain-流程主表（新增）的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.796<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfFlowMainDtoBase implements Serializable{
    /** 属性流程编号 */
    private String flowID = "";
    /** 属性流程名称 */
    private String flowName = "";
    /** 属性该流程的状态 */
    private String flowStatus = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性创建该流程的时间 */
    private DateTime creatDate = new DateTime();
    /** 属性关闭工作流程的时间 */
    private DateTime closeDate = new DateTime();
    /** 属性模板号 */
    private int modelNo = 0;
    /** 属性标志位 */
    private String flag = "";
    /** 属性移出标志 0未移出 1需要移出 2已移出 */
    private String storeFlag = "";

    /**
     *  默认构造方法,构造一个默认的SwfFlowMainDtoBase对象
     */
    public SwfFlowMainDtoBase(){
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
     * 设置属性流程名称
     * @param flowName 待设置的属性流程名称的值
     */
    public void setFlowName(String flowName){
        this.flowName = StringUtils.rightTrim(flowName);
    }

    /**
     * 获取属性流程名称
     * @return 属性流程名称的值
     */
    public String getFlowName(){
        return flowName;
    }

    /**
     * 设置属性该流程的状态
     * @param flowStatus 待设置的属性该流程的状态的值
     */
    public void setFlowStatus(String flowStatus){
        this.flowStatus = StringUtils.rightTrim(flowStatus);
    }

    /**
     * 获取属性该流程的状态
     * @return 属性该流程的状态的值
     */
    public String getFlowStatus(){
        return flowStatus;
    }

    /**
     * 设置属性保单号码
     * @param policyNo 待设置的属性保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性创建该流程的时间
     * @param creatDate 待设置的属性创建该流程的时间的值
     */
    public void setCreatDate(DateTime creatDate){
        this.creatDate = creatDate;
    }

    /**
     * 获取属性创建该流程的时间
     * @return 属性创建该流程的时间的值
     */
    public DateTime getCreatDate(){
        return creatDate;
    }

    /**
     * 设置属性关闭工作流程的时间
     * @param closeDate 待设置的属性关闭工作流程的时间的值
     */
    public void setCloseDate(DateTime closeDate){
        this.closeDate = closeDate;
    }

    /**
     * 获取属性关闭工作流程的时间
     * @return 属性关闭工作流程的时间的值
     */
    public DateTime getCloseDate(){
        return closeDate;
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
    
    /**
     * 设置属性移出标志
     * @param storeFlag 待设置的属性storeFlag的值
     */
    public void setStoreFlag(String storeFlag){
        this.storeFlag = StringUtils.rightTrim(storeFlag);
    }

    /**
     * 获取属性移出标志
     * @return 属性storeFlag的值
     */
    public String getStoreFlag(){
        return storeFlag;
    }
}
