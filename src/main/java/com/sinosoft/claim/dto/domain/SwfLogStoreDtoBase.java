package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����SwfLogStore�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class SwfLogStoreDtoBase extends SwfLogDto implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����flowID */
    private String flowID = "";
    /** ����logNo */
    private int logNo = 0;
    /** ����modelNo */
    private int modelNo = 0;
    /** ����nodeNo */
    private int nodeNo = 0;
    /** ����nodeName */
    private String nodeName = "";
    /** ����businessNo */
    private String businessNo = "";
    /** ����handleDept */
    private String handleDept = "";
    /** ����handlerCode */
    private String handlerCode = "";
    /** ����handlerName */
    private String handlerName = "";
    /** ����flowInTime */
    private String flowInTime = "";
    /** ����timeLimit */
    private int timeLimit = 0;
    /** ����handleTime */
    private String handleTime = "";
    /** ����submitTime */
    private String submitTime = "";
    /** ����nodeStatus */
    private String nodeStatus = "";
    /** ����flowStatus */
    private String flowStatus = "";
    /** ����packageID */
    private String packageID = "";
    /** ����flag */
    private String flag = "";
    /** ����taskNo */
    private int taskNo = 0;
    /** ����taskType */
    private String taskType = "";
    /** ����nodeType */
    private String nodeType = "";
    /** ����titleStr */
    private String titleStr = "";
    /** ����businessType */
    private String businessType = "";
    /** ����riskCode */
    private String riskCode = "";
    /** ����keyIn */
    private String keyIn = "";
    /** ����keyOut */
    private String keyOut = "";
    /** ����deptName */
    private String deptName = "";
    /** ����mainFlowID */
    private String mainFlowID = "";
    /** ����subFlowID */
    private String subFlowID = "";
    /** ����posX */
    private int posX = 0;
    /** ����posY */
    private int posY = 0;
    /** ����endFlag */
    private String endFlag = "";
    /** ����beforeHandlerCode */
    private String beforeHandlerCode = "";
    /** ����beforeHandlerName */
    private String beforeHandlerName = "";
    /** ����policyNo */
    private String policyNo = "";
    /** ����typeFlag */
    private String typeFlag = "";
    /** ����comCode */
    private String comCode = "";
    /** ����scheduleID */
    private int scheduleID = 0;
    /** ����lossItemCode */
    private String lossItemCode = "";
    /** ����lossItemName */
    private String lossItemName = "";
    /** ����insureCarFlag */
    private String insureCarFlag = "";
    /** ����handlerRange */
    private String handlerRange = "";
    /** ����exigenceGree */
    private String exigenceGree = "";
    /** ����insuredName */
    private String insuredName = "";
    /** ����registNo */
    private String registNo = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SwfLogStoreDtoBase����
     */
    public SwfLogStoreDtoBase(){
    }

    /**
     * ��������flowID
     * @param flowID �����õ�����flowID��ֵ
     */
    public void setFlowID(String flowID){
        this.flowID = StringUtils.rightTrim(flowID);
    }

    /**
     * ��ȡ����flowID
     * @return ����flowID��ֵ
     */
    public String getFlowID(){
        return flowID;
    }

    /**
     * ��������logNo
     * @param logNo �����õ�����logNo��ֵ
     */
    public void setLogNo(int logNo){
        this.logNo = logNo;
    }

    /**
     * ��ȡ����logNo
     * @return ����logNo��ֵ
     */
    public int getLogNo(){
        return logNo;
    }

    /**
     * ��������modelNo
     * @param modelNo �����õ�����modelNo��ֵ
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * ��ȡ����modelNo
     * @return ����modelNo��ֵ
     */
    public int getModelNo(){
        return modelNo;
    }

    /**
     * ��������nodeNo
     * @param nodeNo �����õ�����nodeNo��ֵ
     */
    public void setNodeNo(int nodeNo){
        this.nodeNo = nodeNo;
    }

    /**
     * ��ȡ����nodeNo
     * @return ����nodeNo��ֵ
     */
    public int getNodeNo(){
        return nodeNo;
    }

    /**
     * ��������nodeName
     * @param nodeName �����õ�����nodeName��ֵ
     */
    public void setNodeName(String nodeName){
        this.nodeName = StringUtils.rightTrim(nodeName);
    }

    /**
     * ��ȡ����nodeName
     * @return ����nodeName��ֵ
     */
    public String getNodeName(){
        return nodeName;
    }

    /**
     * ��������businessNo
     * @param businessNo �����õ�����businessNo��ֵ
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * ��ȡ����businessNo
     * @return ����businessNo��ֵ
     */
    public String getBusinessNo(){
        return businessNo;
    }

    /**
     * ��������handleDept
     * @param handleDept �����õ�����handleDept��ֵ
     */
    public void setHandleDept(String handleDept){
        this.handleDept = StringUtils.rightTrim(handleDept);
    }

    /**
     * ��ȡ����handleDept
     * @return ����handleDept��ֵ
     */
    public String getHandleDept(){
        return handleDept;
    }

    /**
     * ��������handlerCode
     * @param handlerCode �����õ�����handlerCode��ֵ
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * ��ȡ����handlerCode
     * @return ����handlerCode��ֵ
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * ��������handlerName
     * @param handlerName �����õ�����handlerName��ֵ
     */
    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * ��ȡ����handlerName
     * @return ����handlerName��ֵ
     */
    public String getHandlerName(){
        return handlerName;
    }

    /**
     * ��������flowInTime
     * @param flowInTime �����õ�����flowInTime��ֵ
     */
    public void setFlowInTime(String flowInTime){
        this.flowInTime = StringUtils.rightTrim(flowInTime);
    }

    /**
     * ��ȡ����flowInTime
     * @return ����flowInTime��ֵ
     */
    public String getFlowInTime(){
        return flowInTime;
    }

    /**
     * ��������timeLimit
     * @param timeLimit �����õ�����timeLimit��ֵ
     */
    public void setTimeLimit(int timeLimit){
        this.timeLimit = timeLimit;
    }

    /**
     * ��ȡ����timeLimit
     * @return ����timeLimit��ֵ
     */
    public int getTimeLimit(){
        return timeLimit;
    }

    /**
     * ��������handleTime
     * @param handleTime �����õ�����handleTime��ֵ
     */
    public void setHandleTime(String handleTime){
        this.handleTime = StringUtils.rightTrim(handleTime);
    }

    /**
     * ��ȡ����handleTime
     * @return ����handleTime��ֵ
     */
    public String getHandleTime(){
        return handleTime;
    }

    /**
     * ��������submitTime
     * @param submitTime �����õ�����submitTime��ֵ
     */
    public void setSubmitTime(String submitTime){
        this.submitTime = StringUtils.rightTrim(submitTime);
    }

    /**
     * ��ȡ����submitTime
     * @return ����submitTime��ֵ
     */
    public String getSubmitTime(){
        return submitTime;
    }

    /**
     * ��������nodeStatus
     * @param nodeStatus �����õ�����nodeStatus��ֵ
     */
    public void setNodeStatus(String nodeStatus){
        this.nodeStatus = StringUtils.rightTrim(nodeStatus);
    }

    /**
     * ��ȡ����nodeStatus
     * @return ����nodeStatus��ֵ
     */
    public String getNodeStatus(){
        return nodeStatus;
    }

    /**
     * ��������flowStatus
     * @param flowStatus �����õ�����flowStatus��ֵ
     */
    public void setFlowStatus(String flowStatus){
        this.flowStatus = StringUtils.rightTrim(flowStatus);
    }

    /**
     * ��ȡ����flowStatus
     * @return ����flowStatus��ֵ
     */
    public String getFlowStatus(){
        return flowStatus;
    }

    /**
     * ��������packageID
     * @param packageID �����õ�����packageID��ֵ
     */
    public void setPackageID(String packageID){
        this.packageID = StringUtils.rightTrim(packageID);
    }

    /**
     * ��ȡ����packageID
     * @return ����packageID��ֵ
     */
    public String getPackageID(){
        return packageID;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * ��������taskNo
     * @param taskNo �����õ�����taskNo��ֵ
     */
    public void setTaskNo(int taskNo){
        this.taskNo = taskNo;
    }

    /**
     * ��ȡ����taskNo
     * @return ����taskNo��ֵ
     */
    public int getTaskNo(){
        return taskNo;
    }

    /**
     * ��������taskType
     * @param taskType �����õ�����taskType��ֵ
     */
    public void setTaskType(String taskType){
        this.taskType = StringUtils.rightTrim(taskType);
    }

    /**
     * ��ȡ����taskType
     * @return ����taskType��ֵ
     */
    public String getTaskType(){
        return taskType;
    }

    /**
     * ��������nodeType
     * @param nodeType �����õ�����nodeType��ֵ
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * ��ȡ����nodeType
     * @return ����nodeType��ֵ
     */
    public String getNodeType(){
        return nodeType;
    }

    /**
     * ��������titleStr
     * @param titleStr �����õ�����titleStr��ֵ
     */
    public void setTitleStr(String titleStr){
        this.titleStr = StringUtils.rightTrim(titleStr);
    }

    /**
     * ��ȡ����titleStr
     * @return ����titleStr��ֵ
     */
    public String getTitleStr(){
        return titleStr;
    }

    /**
     * ��������businessType
     * @param businessType �����õ�����businessType��ֵ
     */
    public void setBusinessType(String businessType){
        this.businessType = StringUtils.rightTrim(businessType);
    }

    /**
     * ��ȡ����businessType
     * @return ����businessType��ֵ
     */
    public String getBusinessType(){
        return businessType;
    }

    /**
     * ��������riskCode
     * @param riskCode �����õ�����riskCode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����riskCode
     * @return ����riskCode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������keyIn
     * @param keyIn �����õ�����keyIn��ֵ
     */
    public void setKeyIn(String keyIn){
        this.keyIn = StringUtils.rightTrim(keyIn);
    }

    /**
     * ��ȡ����keyIn
     * @return ����keyIn��ֵ
     */
    public String getKeyIn(){
        return keyIn;
    }

    /**
     * ��������keyOut
     * @param keyOut �����õ�����keyOut��ֵ
     */
    public void setKeyOut(String keyOut){
        this.keyOut = StringUtils.rightTrim(keyOut);
    }

    /**
     * ��ȡ����keyOut
     * @return ����keyOut��ֵ
     */
    public String getKeyOut(){
        return keyOut;
    }

    /**
     * ��������deptName
     * @param deptName �����õ�����deptName��ֵ
     */
    public void setDeptName(String deptName){
        this.deptName = StringUtils.rightTrim(deptName);
    }

    /**
     * ��ȡ����deptName
     * @return ����deptName��ֵ
     */
    public String getDeptName(){
        return deptName;
    }

    /**
     * ��������mainFlowID
     * @param mainFlowID �����õ�����mainFlowID��ֵ
     */
    public void setMainFlowID(String mainFlowID){
        this.mainFlowID = StringUtils.rightTrim(mainFlowID);
    }

    /**
     * ��ȡ����mainFlowID
     * @return ����mainFlowID��ֵ
     */
    public String getMainFlowID(){
        return mainFlowID;
    }

    /**
     * ��������subFlowID
     * @param subFlowID �����õ�����subFlowID��ֵ
     */
    public void setSubFlowID(String subFlowID){
        this.subFlowID = StringUtils.rightTrim(subFlowID);
    }

    /**
     * ��ȡ����subFlowID
     * @return ����subFlowID��ֵ
     */
    public String getSubFlowID(){
        return subFlowID;
    }

    /**
     * ��������posX
     * @param posX �����õ�����posX��ֵ
     */
    public void setPosX(int posX){
        this.posX = posX;
    }

    /**
     * ��ȡ����posX
     * @return ����posX��ֵ
     */
    public int getPosX(){
        return posX;
    }

    /**
     * ��������posY
     * @param posY �����õ�����posY��ֵ
     */
    public void setPosY(int posY){
        this.posY = posY;
    }

    /**
     * ��ȡ����posY
     * @return ����posY��ֵ
     */
    public int getPosY(){
        return posY;
    }

    /**
     * ��������endFlag
     * @param endFlag �����õ�����endFlag��ֵ
     */
    public void setEndFlag(String endFlag){
        this.endFlag = StringUtils.rightTrim(endFlag);
    }

    /**
     * ��ȡ����endFlag
     * @return ����endFlag��ֵ
     */
    public String getEndFlag(){
        return endFlag;
    }

    /**
     * ��������beforeHandlerCode
     * @param beforeHandlerCode �����õ�����beforeHandlerCode��ֵ
     */
    public void setBeforeHandlerCode(String beforeHandlerCode){
        this.beforeHandlerCode = StringUtils.rightTrim(beforeHandlerCode);
    }

    /**
     * ��ȡ����beforeHandlerCode
     * @return ����beforeHandlerCode��ֵ
     */
    public String getBeforeHandlerCode(){
        return beforeHandlerCode;
    }

    /**
     * ��������beforeHandlerName
     * @param beforeHandlerName �����õ�����beforeHandlerName��ֵ
     */
    public void setBeforeHandlerName(String beforeHandlerName){
        this.beforeHandlerName = StringUtils.rightTrim(beforeHandlerName);
    }

    /**
     * ��ȡ����beforeHandlerName
     * @return ����beforeHandlerName��ֵ
     */
    public String getBeforeHandlerName(){
        return beforeHandlerName;
    }

    /**
     * ��������policyNo
     * @param policyNo �����õ�����policyNo��ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����policyNo
     * @return ����policyNo��ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ��������typeFlag
     * @param typeFlag �����õ�����typeFlag��ֵ
     */
    public void setTypeFlag(String typeFlag){
        this.typeFlag = StringUtils.rightTrim(typeFlag);
    }

    /**
     * ��ȡ����typeFlag
     * @return ����typeFlag��ֵ
     */
    public String getTypeFlag(){
        return typeFlag;
    }

    /**
     * ��������comCode
     * @param comCode �����õ�����comCode��ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����comCode
     * @return ����comCode��ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������scheduleID
     * @param scheduleID �����õ�����scheduleID��ֵ
     */
    public void setScheduleID(int scheduleID){
        this.scheduleID = scheduleID;
    }

    /**
     * ��ȡ����scheduleID
     * @return ����scheduleID��ֵ
     */
    public int getScheduleID(){
        return scheduleID;
    }

    /**
     * ��������lossItemCode
     * @param lossItemCode �����õ�����lossItemCode��ֵ
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * ��ȡ����lossItemCode
     * @return ����lossItemCode��ֵ
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * ��������lossItemName
     * @param lossItemName �����õ�����lossItemName��ֵ
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * ��ȡ����lossItemName
     * @return ����lossItemName��ֵ
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * ��������insureCarFlag
     * @param insureCarFlag �����õ�����insureCarFlag��ֵ
     */
    public void setInsureCarFlag(String insureCarFlag){
        this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
    }

    /**
     * ��ȡ����insureCarFlag
     * @return ����insureCarFlag��ֵ
     */
    public String getInsureCarFlag(){
        return insureCarFlag;
    }

    /**
     * ��������handlerRange
     * @param handlerRange �����õ�����handlerRange��ֵ
     */
    public void setHandlerRange(String handlerRange){
        this.handlerRange = StringUtils.rightTrim(handlerRange);
    }

    /**
     * ��ȡ����handlerRange
     * @return ����handlerRange��ֵ
     */
    public String getHandlerRange(){
        return handlerRange;
    }

    /**
     * ��������exigenceGree
     * @param exigenceGree �����õ�����exigenceGree��ֵ
     */
    public void setExigenceGree(String exigenceGree){
        this.exigenceGree = StringUtils.rightTrim(exigenceGree);
    }

    /**
     * ��ȡ����exigenceGree
     * @return ����exigenceGree��ֵ
     */
    public String getExigenceGree(){
        return exigenceGree;
    }

    /**
     * ��������insuredName
     * @param insuredName �����õ�����insuredName��ֵ
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * ��ȡ����insuredName
     * @return ����insuredName��ֵ
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * ��������registNo
     * @param registNo �����õ�����registNo��ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ����registNo
     * @return ����registNo��ֵ
     */
    public String getRegistNo(){
        return registNo;
    }
}
