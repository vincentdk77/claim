package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是WfNode工作流节点定义表的数据传输对象类<br>
 * 创建于 2004-08-09 19:54:50.610<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfNodeDto extends SwfNodeDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的WfNodeDto对象
     */
    public SwfNodeDto(){
    }

    /** 属性显示列表*/
    private Collection nodeList ;
      /** 属性调度号码 */
    private int scheduleID = 0;
    /** 属性标的序号 */
    private String lossItemCode = "";
    /** 属性车牌号码 */
    private String lossItemName = "";
    /** 属性是否为本保单车辆 */
    private String insureCarFlag = "";
    
    /** 属性类型标志 */
    private String typeFlag = "";
    
    
    /** 属性可操作/处理的级别划分 */
    private String handlerRange = "";
    /** 属性紧急程度 */
    private String exigenceGree = "";
    
    
      /** 属性处理部门 */
    private String handleDept = "";
    
    /** 属性处理部门名称 */
    private String deptName = "";
    
     /** 属性保单号码 */
    private String policyNo = "";
    
    /** 属性险种代码 */
    private String riskCode = "";

 /** 属性业务号 */
    private String businessNo = "";
    
     /** 属性任务接收载体键值 */
    private String keyIn = "";
    
    
    /**
      * 获取列表
      * @return 属性列表
      */
     public Collection getNodeList(){
       return nodeList;
     }
     /**
      * 设置列表
      * @param nodeList 待设置的列表
      */
     public void setNodeList(Collection nodeList) {
       this.nodeList = nodeList;
     }
     
         /**
     * 设置属性调度号码
     * @param scheduleID 待设置的属性调度号码的值
     */
    public void setScheduleID(int scheduleID){
        this.scheduleID = scheduleID;
    }

    /**
     * 获取属性调度号码
     * @return 属性调度号码的值
     */
    public int getScheduleID(){
        return scheduleID;
    }

    /**
     * 设置属性标的序号
     * @param lossItemCode 待设置的属性标的序号的值
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * 获取属性标的序号
     * @return 属性标的序号的值
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * 设置属性车牌号码
     * @param lossItemName 待设置的属性车牌号码的值
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * 获取属性车牌号码
     * @return 属性车牌号码的值
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * 设置属性是否为本保单车辆
     * @param insureCarFlag 待设置的属性是否为本保单车辆的值
     */
    public void setInsureCarFlag(String insureCarFlag){
        this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
    }

    /**
     * 获取属性是否为本保单车辆
     * @return 属性是否为本保单车辆的值
     */
    public String getInsureCarFlag(){
        return insureCarFlag;
    }
     /**
     * 设置属性类型标志
     * @param typeFlag 待设置的属性类型标志的值
     */
    public void setTypeFlag(String typeFlag){
        this.typeFlag = StringUtils.rightTrim(typeFlag);
    }

    /**
     * 获取属性类型标志
     * @return 属性类型标志的值
     */
    public String getTypeFlag(){
        return typeFlag;
    }
   /**
     * 设置属性可操作/处理的级别
     * @param handlerRange 待设置的属性可操作/处理的级别的值
     */
    public void setHandlerRange(String handlerRange){
        this.handlerRange = StringUtils.rightTrim(handlerRange);
    }

    /**
     * 获取属性可操作/处理的级别
     * @return 属性可操作/处理的级别的值
     */
    public String getHandlerRange(){
        return handlerRange;
    }

    /**
     * 设置属性紧急程度
     * @param exigenceGree 待设置的属性紧急程度的值
     */
    public void setExigenceGree(String exigenceGree){
        this.exigenceGree = StringUtils.rightTrim(exigenceGree);
    }

    /**
     * 获取属性紧急程度
     * @return 属性紧急程度的值
     */
    public String getExigenceGree(){
        return exigenceGree;
    }
    
      /**
     * 设置属性处理部门
     * @param handleDept 待设置的属性处理部门的值
     */
    public void setHandleDept(String handleDept){
        this.handleDept = StringUtils.rightTrim(handleDept);
    }

    /**
     * 获取属性处理部门
     * @return 属性处理部门的值
     */
    public String getHandleDept(){
        return handleDept;
    }
    
    /**
     * 设置属性处理部门名称
     * @param DeptName 待设置的属性处理部门名称的值
     */
    public void setDeptName(String deptName){
        this.deptName = StringUtils.rightTrim(deptName);
    }

    /**
     * 获取属性处理部门名称
     * @return 属性处理部门名称的值
     */
    public String getDeptName(){
        return deptName;
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
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
    }
    
    
      /**
     * 设置属性任务接收载体键值
     * @param keyIn 待设置的属性任务接收载体键值的值
     */
    public void setKeyIn(String keyIn){
        this.keyIn = StringUtils.rightTrim(keyIn);
    }

    /**
     * 获取属性任务接收载体键值
     * @return 属性任务接收载体键值的值
     */
    public String getKeyIn(){
        return keyIn;
    }
    
    
      /**
     * 设置属性业务号
     * @param businessNo 待设置的属性业务号的值
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * 获取属性业务号
     * @return 属性业务号的值
     */
    public String getBusinessNo(){
        return businessNo;
    }


}
