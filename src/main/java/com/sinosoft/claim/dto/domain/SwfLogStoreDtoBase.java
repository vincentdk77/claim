package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是SwfLogStore的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class SwfLogStoreDtoBase extends SwfLogDto implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性flowID */
    private String flowID = "";
    /** 属性logNo */
    private int logNo = 0;
    /** 属性modelNo */
    private int modelNo = 0;
    /** 属性nodeNo */
    private int nodeNo = 0;
    /** 属性nodeName */
    private String nodeName = "";
    /** 属性businessNo */
    private String businessNo = "";
    /** 属性handleDept */
    private String handleDept = "";
    /** 属性handlerCode */
    private String handlerCode = "";
    /** 属性handlerName */
    private String handlerName = "";
    /** 属性flowInTime */
    private String flowInTime = "";
    /** 属性timeLimit */
    private int timeLimit = 0;
    /** 属性handleTime */
    private String handleTime = "";
    /** 属性submitTime */
    private String submitTime = "";
    /** 属性nodeStatus */
    private String nodeStatus = "";
    /** 属性flowStatus */
    private String flowStatus = "";
    /** 属性packageID */
    private String packageID = "";
    /** 属性flag */
    private String flag = "";
    /** 属性taskNo */
    private int taskNo = 0;
    /** 属性taskType */
    private String taskType = "";
    /** 属性nodeType */
    private String nodeType = "";
    /** 属性titleStr */
    private String titleStr = "";
    /** 属性businessType */
    private String businessType = "";
    /** 属性riskCode */
    private String riskCode = "";
    /** 属性keyIn */
    private String keyIn = "";
    /** 属性keyOut */
    private String keyOut = "";
    /** 属性deptName */
    private String deptName = "";
    /** 属性mainFlowID */
    private String mainFlowID = "";
    /** 属性subFlowID */
    private String subFlowID = "";
    /** 属性posX */
    private int posX = 0;
    /** 属性posY */
    private int posY = 0;
    /** 属性endFlag */
    private String endFlag = "";
    /** 属性beforeHandlerCode */
    private String beforeHandlerCode = "";
    /** 属性beforeHandlerName */
    private String beforeHandlerName = "";
    /** 属性policyNo */
    private String policyNo = "";
    /** 属性typeFlag */
    private String typeFlag = "";
    /** 属性comCode */
    private String comCode = "";
    /** 属性scheduleID */
    private int scheduleID = 0;
    /** 属性lossItemCode */
    private String lossItemCode = "";
    /** 属性lossItemName */
    private String lossItemName = "";
    /** 属性insureCarFlag */
    private String insureCarFlag = "";
    /** 属性handlerRange */
    private String handlerRange = "";
    /** 属性exigenceGree */
    private String exigenceGree = "";
    /** 属性insuredName */
    private String insuredName = "";
    /** 属性registNo */
    private String registNo = "";

    /**
     *  默认构造方法,构造一个默认的SwfLogStoreDtoBase对象
     */
    public SwfLogStoreDtoBase(){
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
     * 设置属性logNo
     * @param logNo 待设置的属性logNo的值
     */
    public void setLogNo(int logNo){
        this.logNo = logNo;
    }

    /**
     * 获取属性logNo
     * @return 属性logNo的值
     */
    public int getLogNo(){
        return logNo;
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
     * 设置属性nodeNo
     * @param nodeNo 待设置的属性nodeNo的值
     */
    public void setNodeNo(int nodeNo){
        this.nodeNo = nodeNo;
    }

    /**
     * 获取属性nodeNo
     * @return 属性nodeNo的值
     */
    public int getNodeNo(){
        return nodeNo;
    }

    /**
     * 设置属性nodeName
     * @param nodeName 待设置的属性nodeName的值
     */
    public void setNodeName(String nodeName){
        this.nodeName = StringUtils.rightTrim(nodeName);
    }

    /**
     * 获取属性nodeName
     * @return 属性nodeName的值
     */
    public String getNodeName(){
        return nodeName;
    }

    /**
     * 设置属性businessNo
     * @param businessNo 待设置的属性businessNo的值
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * 获取属性businessNo
     * @return 属性businessNo的值
     */
    public String getBusinessNo(){
        return businessNo;
    }

    /**
     * 设置属性handleDept
     * @param handleDept 待设置的属性handleDept的值
     */
    public void setHandleDept(String handleDept){
        this.handleDept = StringUtils.rightTrim(handleDept);
    }

    /**
     * 获取属性handleDept
     * @return 属性handleDept的值
     */
    public String getHandleDept(){
        return handleDept;
    }

    /**
     * 设置属性handlerCode
     * @param handlerCode 待设置的属性handlerCode的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性handlerCode
     * @return 属性handlerCode的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性handlerName
     * @param handlerName 待设置的属性handlerName的值
     */
    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * 获取属性handlerName
     * @return 属性handlerName的值
     */
    public String getHandlerName(){
        return handlerName;
    }

    /**
     * 设置属性flowInTime
     * @param flowInTime 待设置的属性flowInTime的值
     */
    public void setFlowInTime(String flowInTime){
        this.flowInTime = StringUtils.rightTrim(flowInTime);
    }

    /**
     * 获取属性flowInTime
     * @return 属性flowInTime的值
     */
    public String getFlowInTime(){
        return flowInTime;
    }

    /**
     * 设置属性timeLimit
     * @param timeLimit 待设置的属性timeLimit的值
     */
    public void setTimeLimit(int timeLimit){
        this.timeLimit = timeLimit;
    }

    /**
     * 获取属性timeLimit
     * @return 属性timeLimit的值
     */
    public int getTimeLimit(){
        return timeLimit;
    }

    /**
     * 设置属性handleTime
     * @param handleTime 待设置的属性handleTime的值
     */
    public void setHandleTime(String handleTime){
        this.handleTime = StringUtils.rightTrim(handleTime);
    }

    /**
     * 获取属性handleTime
     * @return 属性handleTime的值
     */
    public String getHandleTime(){
        return handleTime;
    }

    /**
     * 设置属性submitTime
     * @param submitTime 待设置的属性submitTime的值
     */
    public void setSubmitTime(String submitTime){
        this.submitTime = StringUtils.rightTrim(submitTime);
    }

    /**
     * 获取属性submitTime
     * @return 属性submitTime的值
     */
    public String getSubmitTime(){
        return submitTime;
    }

    /**
     * 设置属性nodeStatus
     * @param nodeStatus 待设置的属性nodeStatus的值
     */
    public void setNodeStatus(String nodeStatus){
        this.nodeStatus = StringUtils.rightTrim(nodeStatus);
    }

    /**
     * 获取属性nodeStatus
     * @return 属性nodeStatus的值
     */
    public String getNodeStatus(){
        return nodeStatus;
    }

    /**
     * 设置属性flowStatus
     * @param flowStatus 待设置的属性flowStatus的值
     */
    public void setFlowStatus(String flowStatus){
        this.flowStatus = StringUtils.rightTrim(flowStatus);
    }

    /**
     * 获取属性flowStatus
     * @return 属性flowStatus的值
     */
    public String getFlowStatus(){
        return flowStatus;
    }

    /**
     * 设置属性packageID
     * @param packageID 待设置的属性packageID的值
     */
    public void setPackageID(String packageID){
        this.packageID = StringUtils.rightTrim(packageID);
    }

    /**
     * 获取属性packageID
     * @return 属性packageID的值
     */
    public String getPackageID(){
        return packageID;
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

    /**
     * 设置属性taskNo
     * @param taskNo 待设置的属性taskNo的值
     */
    public void setTaskNo(int taskNo){
        this.taskNo = taskNo;
    }

    /**
     * 获取属性taskNo
     * @return 属性taskNo的值
     */
    public int getTaskNo(){
        return taskNo;
    }

    /**
     * 设置属性taskType
     * @param taskType 待设置的属性taskType的值
     */
    public void setTaskType(String taskType){
        this.taskType = StringUtils.rightTrim(taskType);
    }

    /**
     * 获取属性taskType
     * @return 属性taskType的值
     */
    public String getTaskType(){
        return taskType;
    }

    /**
     * 设置属性nodeType
     * @param nodeType 待设置的属性nodeType的值
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * 获取属性nodeType
     * @return 属性nodeType的值
     */
    public String getNodeType(){
        return nodeType;
    }

    /**
     * 设置属性titleStr
     * @param titleStr 待设置的属性titleStr的值
     */
    public void setTitleStr(String titleStr){
        this.titleStr = StringUtils.rightTrim(titleStr);
    }

    /**
     * 获取属性titleStr
     * @return 属性titleStr的值
     */
    public String getTitleStr(){
        return titleStr;
    }

    /**
     * 设置属性businessType
     * @param businessType 待设置的属性businessType的值
     */
    public void setBusinessType(String businessType){
        this.businessType = StringUtils.rightTrim(businessType);
    }

    /**
     * 获取属性businessType
     * @return 属性businessType的值
     */
    public String getBusinessType(){
        return businessType;
    }

    /**
     * 设置属性riskCode
     * @param riskCode 待设置的属性riskCode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性riskCode
     * @return 属性riskCode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性keyIn
     * @param keyIn 待设置的属性keyIn的值
     */
    public void setKeyIn(String keyIn){
        this.keyIn = StringUtils.rightTrim(keyIn);
    }

    /**
     * 获取属性keyIn
     * @return 属性keyIn的值
     */
    public String getKeyIn(){
        return keyIn;
    }

    /**
     * 设置属性keyOut
     * @param keyOut 待设置的属性keyOut的值
     */
    public void setKeyOut(String keyOut){
        this.keyOut = StringUtils.rightTrim(keyOut);
    }

    /**
     * 获取属性keyOut
     * @return 属性keyOut的值
     */
    public String getKeyOut(){
        return keyOut;
    }

    /**
     * 设置属性deptName
     * @param deptName 待设置的属性deptName的值
     */
    public void setDeptName(String deptName){
        this.deptName = StringUtils.rightTrim(deptName);
    }

    /**
     * 获取属性deptName
     * @return 属性deptName的值
     */
    public String getDeptName(){
        return deptName;
    }

    /**
     * 设置属性mainFlowID
     * @param mainFlowID 待设置的属性mainFlowID的值
     */
    public void setMainFlowID(String mainFlowID){
        this.mainFlowID = StringUtils.rightTrim(mainFlowID);
    }

    /**
     * 获取属性mainFlowID
     * @return 属性mainFlowID的值
     */
    public String getMainFlowID(){
        return mainFlowID;
    }

    /**
     * 设置属性subFlowID
     * @param subFlowID 待设置的属性subFlowID的值
     */
    public void setSubFlowID(String subFlowID){
        this.subFlowID = StringUtils.rightTrim(subFlowID);
    }

    /**
     * 获取属性subFlowID
     * @return 属性subFlowID的值
     */
    public String getSubFlowID(){
        return subFlowID;
    }

    /**
     * 设置属性posX
     * @param posX 待设置的属性posX的值
     */
    public void setPosX(int posX){
        this.posX = posX;
    }

    /**
     * 获取属性posX
     * @return 属性posX的值
     */
    public int getPosX(){
        return posX;
    }

    /**
     * 设置属性posY
     * @param posY 待设置的属性posY的值
     */
    public void setPosY(int posY){
        this.posY = posY;
    }

    /**
     * 获取属性posY
     * @return 属性posY的值
     */
    public int getPosY(){
        return posY;
    }

    /**
     * 设置属性endFlag
     * @param endFlag 待设置的属性endFlag的值
     */
    public void setEndFlag(String endFlag){
        this.endFlag = StringUtils.rightTrim(endFlag);
    }

    /**
     * 获取属性endFlag
     * @return 属性endFlag的值
     */
    public String getEndFlag(){
        return endFlag;
    }

    /**
     * 设置属性beforeHandlerCode
     * @param beforeHandlerCode 待设置的属性beforeHandlerCode的值
     */
    public void setBeforeHandlerCode(String beforeHandlerCode){
        this.beforeHandlerCode = StringUtils.rightTrim(beforeHandlerCode);
    }

    /**
     * 获取属性beforeHandlerCode
     * @return 属性beforeHandlerCode的值
     */
    public String getBeforeHandlerCode(){
        return beforeHandlerCode;
    }

    /**
     * 设置属性beforeHandlerName
     * @param beforeHandlerName 待设置的属性beforeHandlerName的值
     */
    public void setBeforeHandlerName(String beforeHandlerName){
        this.beforeHandlerName = StringUtils.rightTrim(beforeHandlerName);
    }

    /**
     * 获取属性beforeHandlerName
     * @return 属性beforeHandlerName的值
     */
    public String getBeforeHandlerName(){
        return beforeHandlerName;
    }

    /**
     * 设置属性policyNo
     * @param policyNo 待设置的属性policyNo的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性policyNo
     * @return 属性policyNo的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性typeFlag
     * @param typeFlag 待设置的属性typeFlag的值
     */
    public void setTypeFlag(String typeFlag){
        this.typeFlag = StringUtils.rightTrim(typeFlag);
    }

    /**
     * 获取属性typeFlag
     * @return 属性typeFlag的值
     */
    public String getTypeFlag(){
        return typeFlag;
    }

    /**
     * 设置属性comCode
     * @param comCode 待设置的属性comCode的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性comCode
     * @return 属性comCode的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性scheduleID
     * @param scheduleID 待设置的属性scheduleID的值
     */
    public void setScheduleID(int scheduleID){
        this.scheduleID = scheduleID;
    }

    /**
     * 获取属性scheduleID
     * @return 属性scheduleID的值
     */
    public int getScheduleID(){
        return scheduleID;
    }

    /**
     * 设置属性lossItemCode
     * @param lossItemCode 待设置的属性lossItemCode的值
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * 获取属性lossItemCode
     * @return 属性lossItemCode的值
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * 设置属性lossItemName
     * @param lossItemName 待设置的属性lossItemName的值
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * 获取属性lossItemName
     * @return 属性lossItemName的值
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * 设置属性insureCarFlag
     * @param insureCarFlag 待设置的属性insureCarFlag的值
     */
    public void setInsureCarFlag(String insureCarFlag){
        this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
    }

    /**
     * 获取属性insureCarFlag
     * @return 属性insureCarFlag的值
     */
    public String getInsureCarFlag(){
        return insureCarFlag;
    }

    /**
     * 设置属性handlerRange
     * @param handlerRange 待设置的属性handlerRange的值
     */
    public void setHandlerRange(String handlerRange){
        this.handlerRange = StringUtils.rightTrim(handlerRange);
    }

    /**
     * 获取属性handlerRange
     * @return 属性handlerRange的值
     */
    public String getHandlerRange(){
        return handlerRange;
    }

    /**
     * 设置属性exigenceGree
     * @param exigenceGree 待设置的属性exigenceGree的值
     */
    public void setExigenceGree(String exigenceGree){
        this.exigenceGree = StringUtils.rightTrim(exigenceGree);
    }

    /**
     * 获取属性exigenceGree
     * @return 属性exigenceGree的值
     */
    public String getExigenceGree(){
        return exigenceGree;
    }

    /**
     * 设置属性insuredName
     * @param insuredName 待设置的属性insuredName的值
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * 获取属性insuredName
     * @return 属性insuredName的值
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * 设置属性registNo
     * @param registNo 待设置的属性registNo的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性registNo
     * @return 属性registNo的值
     */
    public String getRegistNo(){
        return registNo;
    }
}
