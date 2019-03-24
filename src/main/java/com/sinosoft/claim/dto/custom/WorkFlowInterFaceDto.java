package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * 工作流流程接口数据传输对象
 * <p>Title: 工作流流程接口DTO</p>
 * <p>Description: 车险理赔理赔节点 工作流部分</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class WorkFlowInterFaceDto implements Serializable
{
      /** 属性流程编号 */
    private String flowID = "";
    /** 属性序号 */
    private int logNo = 0;
    /** 属性模板号 */
    private int modelNo = 0;
    /** 属性当前节点号 */
    private int nodeNo = 0;
    /** 属性当前节点名称 */
    private String nodeName = "";
    /** 属性业务号 */
    private String businessNo = "";
    /** 属性处理部门 */
    private String handleDept = "";
    /** 属性处理人员代码 */
    private String handlerCode = "";
    /** 属性处理人员名称 */
    private String handlerName = "";
    /** 属性流入时间 */
    private String flowInTime = "";
    /** 属性处理时限 */
    private int timeLimit = 0;
    /** 属性处理时间 */
    private String handleTime = "";
    /** 属性提交时间 */
    private String submitTime = "";
    /** 属性节点状态 */
    private String nodeStatus = "";
    /** 属性流状态 */
    private String flowStatus = "";
    /** 属性明细信息包ID */
    private String packageID = "";
    /** 属性备用标志 */
    private String flag = "";
    /** 属性任务编号 */
    private int taskNo = 0;
    /** 属性任务类型 */
    private String taskType = "";
    /** 属性节点类型 */
    private String nodeType = "";
    /** 属性任务备注 */
    private String titleStr = "";
    /** 属性业务类型 */
    private String businessType = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性任务接收载体键值 */
    private String keyIn = "";
    /** 属性任务发送载体键值 */
    private String keyOut = "";
    /** 属性部门名称 */
    private String deptName = "";
    /** 属性主流程编号 */
    private String mainFlowID = "";
    /** 属性子流程编号 */
    private String subFlowID = "";
    /** 属性节点X坐标 */
    private int posX = 0;
    /** 属性节点Y坐标 */
    private int posY = 0;
    /** 属性结束标志 */
    private String endFlag = "";
    /** 属性上个处理人员码 */
    private String beforeHandlerCode = "";
    /** 属性上个处理人员名称 */
    private String beforeHandlerName = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性类型标志 */
    private String typeFlag = "";
    /** 属性归属机构 */
    private String comCode = "";
    /** 属性调度号码 */
    private int scheduleID = 0;
    /** 属性标的序号 */
    private String lossItemCode = "";
    /** 属性车牌号码 */
    private String lossItemName = "";
    /** 属性是否为本保单车辆 */
    private String insureCarFlag = "";


    /** 属性节点种类名称 */
    private String nodeTypeName = "";

    /** 属性操作状态名称 */
    private String nodeStatusName = "";
    /** 属性险种名称 */
   private String riskCodeName="";

    /** 类型的名称 */
    private String typeFlagName="";
    /** 页数据对象*/
    private TurnPageDto turnPageDto = null ;


    /**
     *  默认构造方法,构造一个默认的SwfLogDtoBase对象
     */
    public WorkFlowInterFaceDto(){
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
     * 设置属性序号
     * @param logNo 待设置的属性序号的值
     */
    public void setLogNo(int logNo){
        this.logNo = logNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public int getLogNo(){
        return logNo;
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
     * 设置属性当前节点号
     * @param nodeNo 待设置的属性当前节点号的值
     */
    public void setNodeNo(int nodeNo){
        this.nodeNo = nodeNo;
    }

    /**
     * 获取属性当前节点号
     * @return 属性当前节点号的值
     */
    public int getNodeNo(){
        return nodeNo;
    }

    /**
     * 设置属性当前节点名称
     * @param nodeName 待设置的属性当前节点名称的值
     */
    public void setNodeName(String nodeName){
        this.nodeName = StringUtils.rightTrim(nodeName);
    }

    /**
     * 获取属性当前节点名称
     * @return 属性当前节点名称的值
     */
    public String getNodeName(){
        return nodeName;
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
     * 设置属性处理人员代码
     * @param handlerCode 待设置的属性处理人员代码的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性处理人员代码
     * @return 属性处理人员代码的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性处理人员名称
     * @param handlerName 待设置的属性处理人员名称的值
     */
    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * 获取属性处理人员名称
     * @return 属性处理人员名称的值
     */
    public String getHandlerName(){
        return handlerName;
    }

    /**
     * 设置属性流入时间
     * @param flowInTime 待设置的属性流入时间的值
     */
    public void setFlowInTime(String flowInTime){
        this.flowInTime = StringUtils.rightTrim(flowInTime);
    }

    /**
     * 获取属性流入时间
     * @return 属性流入时间的值
     */
    public String getFlowInTime(){
        return flowInTime;
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
     * 设置属性处理时间
     * @param handleTime 待设置的属性处理时间的值
     */
    public void setHandleTime(String handleTime){
        this.handleTime = StringUtils.rightTrim(handleTime);
    }

    /**
     * 获取属性处理时间
     * @return 属性处理时间的值
     */
    public String getHandleTime(){
        return handleTime;
    }

    /**
     * 设置属性提交时间
     * @param submitTime 待设置的属性提交时间的值
     */
    public void setSubmitTime(String submitTime){
        this.submitTime = StringUtils.rightTrim(submitTime);
    }

    /**
     * 获取属性提交时间
     * @return 属性提交时间的值
     */
    public String getSubmitTime(){
        return submitTime;
    }

    /**
     * 设置属性节点状态
     * @param nodeStatus 待设置的属性节点状态的值
     */
    public void setNodeStatus(String nodeStatus){
        this.nodeStatus = StringUtils.rightTrim(nodeStatus);
    }

    /**
     * 获取属性节点状态
     * @return 属性节点状态的值
     */
    public String getNodeStatus(){
        return nodeStatus;
    }

    /**
     * 设置属性流状态
     * @param flowStatus 待设置的属性流状态的值
     */
    public void setFlowStatus(String flowStatus){
        this.flowStatus = StringUtils.rightTrim(flowStatus);
    }

    /**
     * 获取属性流状态
     * @return 属性流状态的值
     */
    public String getFlowStatus(){
        return flowStatus;
    }

    /**
     * 设置属性明细信息包ID
     * @param packageID 待设置的属性明细信息包ID的值
     */
    public void setPackageID(String packageID){
        this.packageID = StringUtils.rightTrim(packageID);
    }

    /**
     * 获取属性明细信息包ID
     * @return 属性明细信息包ID的值
     */
    public String getPackageID(){
        return packageID;
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
     * 设置属性任务备注
     * @param titleStr 待设置的属性任务备注的值
     */
    public void setTitleStr(String titleStr){
        this.titleStr = StringUtils.rightTrim(titleStr);
    }

    /**
     * 获取属性任务备注
     * @return 属性任务备注的值
     */
    public String getTitleStr(){
        return titleStr;
    }

    /**
     * 设置属性业务类型
     * @param businessType 待设置的属性业务类型的值
     */
    public void setBusinessType(String businessType){
        this.businessType = StringUtils.rightTrim(businessType);
    }

    /**
     * 获取属性业务类型
     * @return 属性业务类型的值
     */
    public String getBusinessType(){
        return businessType;
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
     * 设置属性任务发送载体键值
     * @param keyOut 待设置的属性任务发送载体键值的值
     */
    public void setKeyOut(String keyOut){
        this.keyOut = StringUtils.rightTrim(keyOut);
    }

    /**
     * 获取属性任务发送载体键值
     * @return 属性任务发送载体键值的值
     */
    public String getKeyOut(){
        return keyOut;
    }

    /**
     * 设置属性部门名称
     * @param deptName 待设置的属性部门名称的值
     */
    public void setDeptName(String deptName){
        this.deptName = StringUtils.rightTrim(deptName);
    }

    /**
     * 获取属性部门名称
     * @return 属性部门名称的值
     */
    public String getDeptName(){
        return deptName;
    }

    /**
     * 设置属性主流程编号
     * @param mainFlowID 待设置的属性主流程编号的值
     */
    public void setMainFlowID(String mainFlowID){
        this.mainFlowID = StringUtils.rightTrim(mainFlowID);
    }

    /**
     * 获取属性主流程编号
     * @return 属性主流程编号的值
     */
    public String getMainFlowID(){
        return mainFlowID;
    }

    /**
     * 设置属性子流程编号
     * @param subFlowID 待设置的属性子流程编号的值
     */
    public void setSubFlowID(String subFlowID){
        this.subFlowID = StringUtils.rightTrim(subFlowID);
    }

    /**
     * 获取属性子流程编号
     * @return 属性子流程编号的值
     */
    public String getSubFlowID(){
        return subFlowID;
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
     * 设置属性上个处理人员码
     * @param beforeHandlerCode 待设置的属性上个处理人员码的值
     */
    public void setBeforeHandlerCode(String beforeHandlerCode){
        this.beforeHandlerCode = StringUtils.rightTrim(beforeHandlerCode);
    }

    /**
     * 获取属性上个处理人员码
     * @return 属性上个处理人员码的值
     */
    public String getBeforeHandlerCode(){
        return beforeHandlerCode;
    }

    /**
     * 设置属性上个处理人员名称
     * @param beforeHandlerName 待设置的属性上个处理人员名称的值
     */
    public void setBeforeHandlerName(String beforeHandlerName){
        this.beforeHandlerName = StringUtils.rightTrim(beforeHandlerName);
    }

    /**
     * 获取属性上个处理人员名称
     * @return 属性上个处理人员名称的值
     */
    public String getBeforeHandlerName(){
        return beforeHandlerName;
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
     * 设置属性归属机构
     * @param comCode 待设置的属性归属机构的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性归属机构
     * @return 属性归属机构的值
     */
    public String getComCode(){
        return comCode;
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


     /**设置属性操作状态名称
    * @param statusName 属性操作状态名称
    */
    public void setNodeStatusName(String nodeStatusName) {
      this.nodeStatusName = nodeStatusName;
    }
    /**
     * 设置定损类型的名称
     * @param typeFlagName 待设置的定损类型的名称的值
     */
    public void setTypeFlagName(String typeFlagName){
        this.typeFlagName = StringUtils.rightTrim(typeFlagName);
    }

    /**
     * 获取定损类型的名称
     * @return 定损类型的名称的值
     */
    public String getTypeFlagName(){
        return typeFlagName;
    }
    /**
     * 设置一页数据
     * @param turnPageDto 一页数据
     */
    public void setTurnPageDto(TurnPageDto turnPageDto) {
    this.turnPageDto = turnPageDto;
    }
   /**
     * 获取一页数据
     * @return 属性一页数据
     */
    public TurnPageDto getTurnPageDto() {
      return turnPageDto;
    }
     /**得到属性操作状态名称
     * @return 属性操作状态名称
     */
    public String getNodeStatusName() {
      return nodeStatusName;
    }


   /**得到属性节点种类名称
    * @return 属性节点种类名称
    */
    public String getNodeTypeName() {
      return nodeTypeName;
    }
  /**设置属性节点种类名称
    * @param nodeTypeName 属性节点种类名称
    */
    public void setNodeTypeName(String nodeTypeName) {
      this.nodeTypeName = nodeTypeName;
    }

    /**
       * 设置属性险种名称
       * @param riskCodeName 待设置的属性险种名称的值
       */
      public void setRiskCodeName(String riskCodeName){
          this.riskCodeName = StringUtils.rightTrim(riskCodeName);
      }

      /**
       * 获取属性险种名称
       * @return 属性险种名称的值
       */
      public String getRiskCodeName(){
          return riskCodeName;
      }
}
