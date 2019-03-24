package com.gyic.claim.dto.domain;


import java.io.Serializable;

/**
 * ����PRPLCOMBINE�����ݴ��������<br>
 */
public class PrplcombineSwfLogDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    private String combineno = "";
    /** �������̱�� */
    private String flowID = "";
    /** ������� */
    private int logNo = 0;
    /** ����ģ��� */
    private int modelNo = 0;
    /** ���Ե�ǰ�ڵ�� */
    private int nodeNo = 0;
    /** ���Ե�ǰ�ڵ����� */
    private String nodeName = "";
    /** ����ҵ��� */
    private String businessNo = "";
    /** ���Դ����� */
    private String handleDept = "";
    /** ���Դ�����Ա���� */
    private String handlerCode = "";
    /** ���Դ�����Ա���� */
    private String handlerName = "";
    /** ��������ʱ�� */
    private String flowInTime = "";
    /** ���Դ���ʱ�� */
    private int timeLimit = 0;
    /** ���Դ���ʱ�� */
    private String handleTime = "";
    /** �����ύʱ�� */
    private String submitTime = "";
    /** ���Խڵ�״̬ */
    private String nodeStatus = "";
    /** ������״̬ */
    private String flowStatus = "";
    /** ������ϸ��Ϣ��ID */
    private String packageID = "";
    /** ���Ա��ñ�־ */
    private String flag = "";
    /** ���������� */
    private int taskNo = 0;
    /** ������������ */
    private String taskType = "";
    /** ���Խڵ����� */
    private String nodeType = "";
    /** ��������ע */
    private String titleStr = "";
    /** ����ҵ������ */
    private String businessType = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ����������������ֵ */
    private String keyIn = "";
    /** ���������������ֵ */
    private String keyOut = "";
    /** ���Բ������� */
    private String deptName = "";
    /** ���������̱�� */
    private String mainFlowID = "";
    /** ���������̱�� */
    private String subFlowID = "";
    /** ���Խڵ�X���� */
    private int posX = 0;
    /** ���Խڵ�Y���� */
    private int posY = 0;
    /** ���Խ�����־ */
    private String endFlag = "";
    /** �����ϸ�������Ա�� */
    private String beforeHandlerCode = "";
    /** �����ϸ�������Ա���� */
    private String beforeHandlerName = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** �������ͱ�־ */
    private String typeFlag = "";
    /** ���Թ������� */
    private String comCode = "";
    /** ���Ե��Ⱥ��� */
    private int scheduleID = 0;
    /** ���Ա����� */
    private String lossItemCode = "";
    /** ���Գ��ƺ��� */
    private String lossItemName = "";
    /** �����Ƿ�Ϊ���������� */
    private String insureCarFlag = "";
    /** ���Կɲ���/����ļ��� */
    private String handlerRange = "";
    /** ���Խ����̶� */
    private String exigenceGree = "";
    
     /** ���Ա����������� */
    private String insuredName = "";
    /** ���Ա������� */
    private String registNo = "";
    private String claimNo="";
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplcombineDto����
     */
    public PrplcombineSwfLogDtoBase(){
    }
	/**
	 * @return the combineno
	 */
	public String getCombineno() {
		return combineno;
	}
	/**
	 * @param combineno the combineno to set
	 */
	public void setCombineno(String combineno) {
		this.combineno = combineno;
	}
	/**
	 * @return the flowID
	 */
	public String getFlowID() {
		return flowID;
	}
	/**
	 * @return the claimNo
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * @param claimNo the claimNo to set
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	/**
	 * @param flowID the flowID to set
	 */
	public void setFlowID(String flowID) {
		this.flowID = flowID;
	}
	/**
	 * @return the logNo
	 */
	public int getLogNo() {
		return logNo;
	}
	/**
	 * @param logNo the logNo to set
	 */
	public void setLogNo(int logNo) {
		this.logNo = logNo;
	}
	/**
	 * @return the modelNo
	 */
	public int getModelNo() {
		return modelNo;
	}
	/**
	 * @param modelNo the modelNo to set
	 */
	public void setModelNo(int modelNo) {
		this.modelNo = modelNo;
	}
	/**
	 * @return the nodeNo
	 */
	public int getNodeNo() {
		return nodeNo;
	}
	/**
	 * @param nodeNo the nodeNo to set
	 */
	public void setNodeNo(int nodeNo) {
		this.nodeNo = nodeNo;
	}
	/**
	 * @return the nodeName
	 */
	public String getNodeName() {
		return nodeName;
	}
	/**
	 * @param nodeName the nodeName to set
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	/**
	 * @return the businessNo
	 */
	public String getBusinessNo() {
		return businessNo;
	}
	/**
	 * @param businessNo the businessNo to set
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	/**
	 * @return the handleDept
	 */
	public String getHandleDept() {
		return handleDept;
	}
	/**
	 * @param handleDept the handleDept to set
	 */
	public void setHandleDept(String handleDept) {
		this.handleDept = handleDept;
	}
	/**
	 * @return the handlerCode
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * @param handlerCode the handlerCode to set
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}
	/**
	 * @return the handlerName
	 */
	public String getHandlerName() {
		return handlerName;
	}
	/**
	 * @param handlerName the handlerName to set
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	/**
	 * @return the flowInTime
	 */
	public String getFlowInTime() {
		return flowInTime;
	}
	/**
	 * @param flowInTime the flowInTime to set
	 */
	public void setFlowInTime(String flowInTime) {
		this.flowInTime = flowInTime;
	}
	/**
	 * @return the timeLimit
	 */
	public int getTimeLimit() {
		return timeLimit;
	}
	/**
	 * @param timeLimit the timeLimit to set
	 */
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	/**
	 * @return the handleTime
	 */
	public String getHandleTime() {
		return handleTime;
	}
	/**
	 * @param handleTime the handleTime to set
	 */
	public void setHandleTime(String handleTime) {
		this.handleTime = handleTime;
	}
	/**
	 * @return the submitTime
	 */
	public String getSubmitTime() {
		return submitTime;
	}
	/**
	 * @param submitTime the submitTime to set
	 */
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	/**
	 * @return the nodeStatus
	 */
	public String getNodeStatus() {
		return nodeStatus;
	}
	/**
	 * @param nodeStatus the nodeStatus to set
	 */
	public void setNodeStatus(String nodeStatus) {
		this.nodeStatus = nodeStatus;
	}
	/**
	 * @return the flowStatus
	 */
	public String getFlowStatus() {
		return flowStatus;
	}
	/**
	 * @param flowStatus the flowStatus to set
	 */
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}
	/**
	 * @return the packageID
	 */
	public String getPackageID() {
		return packageID;
	}
	/**
	 * @param packageID the packageID to set
	 */
	public void setPackageID(String packageID) {
		this.packageID = packageID;
	}
	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * @return the taskNo
	 */
	public int getTaskNo() {
		return taskNo;
	}
	/**
	 * @param taskNo the taskNo to set
	 */
	public void setTaskNo(int taskNo) {
		this.taskNo = taskNo;
	}
	/**
	 * @return the taskType
	 */
	public String getTaskType() {
		return taskType;
	}
	/**
	 * @param taskType the taskType to set
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	/**
	 * @return the nodeType
	 */
	public String getNodeType() {
		return nodeType;
	}
	/**
	 * @param nodeType the nodeType to set
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	/**
	 * @return the titleStr
	 */
	public String getTitleStr() {
		return titleStr;
	}
	/**
	 * @param titleStr the titleStr to set
	 */
	public void setTitleStr(String titleStr) {
		this.titleStr = titleStr;
	}
	/**
	 * @return the businessType
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * @param businessType the businessType to set
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	/**
	 * @return the riskCode
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * @param riskCode the riskCode to set
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	/**
	 * @return the keyIn
	 */
	public String getKeyIn() {
		return keyIn;
	}
	/**
	 * @param keyIn the keyIn to set
	 */
	public void setKeyIn(String keyIn) {
		this.keyIn = keyIn;
	}
	/**
	 * @return the keyOut
	 */
	public String getKeyOut() {
		return keyOut;
	}
	/**
	 * @param keyOut the keyOut to set
	 */
	public void setKeyOut(String keyOut) {
		this.keyOut = keyOut;
	}
	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * @return the mainFlowID
	 */
	public String getMainFlowID() {
		return mainFlowID;
	}
	/**
	 * @param mainFlowID the mainFlowID to set
	 */
	public void setMainFlowID(String mainFlowID) {
		this.mainFlowID = mainFlowID;
	}
	/**
	 * @return the subFlowID
	 */
	public String getSubFlowID() {
		return subFlowID;
	}
	/**
	 * @param subFlowID the subFlowID to set
	 */
	public void setSubFlowID(String subFlowID) {
		this.subFlowID = subFlowID;
	}
	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}
	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}
	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}
	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
	/**
	 * @return the endFlag
	 */
	public String getEndFlag() {
		return endFlag;
	}
	/**
	 * @param endFlag the endFlag to set
	 */
	public void setEndFlag(String endFlag) {
		this.endFlag = endFlag;
	}
	/**
	 * @return the beforeHandlerCode
	 */
	public String getBeforeHandlerCode() {
		return beforeHandlerCode;
	}
	/**
	 * @param beforeHandlerCode the beforeHandlerCode to set
	 */
	public void setBeforeHandlerCode(String beforeHandlerCode) {
		this.beforeHandlerCode = beforeHandlerCode;
	}
	/**
	 * @return the beforeHandlerName
	 */
	public String getBeforeHandlerName() {
		return beforeHandlerName;
	}
	/**
	 * @param beforeHandlerName the beforeHandlerName to set
	 */
	public void setBeforeHandlerName(String beforeHandlerName) {
		this.beforeHandlerName = beforeHandlerName;
	}
	/**
	 * @return the policyNo
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * @param policyNo the policyNo to set
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	/**
	 * @return the typeFlag
	 */
	public String getTypeFlag() {
		return typeFlag;
	}
	/**
	 * @param typeFlag the typeFlag to set
	 */
	public void setTypeFlag(String typeFlag) {
		this.typeFlag = typeFlag;
	}
	/**
	 * @return the comCode
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * @param comCode the comCode to set
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	/**
	 * @return the scheduleID
	 */
	public int getScheduleID() {
		return scheduleID;
	}
	/**
	 * @param scheduleID the scheduleID to set
	 */
	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}
	/**
	 * @return the lossItemCode
	 */
	public String getLossItemCode() {
		return lossItemCode;
	}
	/**
	 * @param lossItemCode the lossItemCode to set
	 */
	public void setLossItemCode(String lossItemCode) {
		this.lossItemCode = lossItemCode;
	}
	/**
	 * @return the lossItemName
	 */
	public String getLossItemName() {
		return lossItemName;
	}
	/**
	 * @param lossItemName the lossItemName to set
	 */
	public void setLossItemName(String lossItemName) {
		this.lossItemName = lossItemName;
	}
	/**
	 * @return the insureCarFlag
	 */
	public String getInsureCarFlag() {
		return insureCarFlag;
	}
	/**
	 * @param insureCarFlag the insureCarFlag to set
	 */
	public void setInsureCarFlag(String insureCarFlag) {
		this.insureCarFlag = insureCarFlag;
	}
	/**
	 * @return the handlerRange
	 */
	public String getHandlerRange() {
		return handlerRange;
	}
	/**
	 * @param handlerRange the handlerRange to set
	 */
	public void setHandlerRange(String handlerRange) {
		this.handlerRange = handlerRange;
	}
	/**
	 * @return the exigenceGree
	 */
	public String getExigenceGree() {
		return exigenceGree;
	}
	/**
	 * @param exigenceGree the exigenceGree to set
	 */
	public void setExigenceGree(String exigenceGree) {
		this.exigenceGree = exigenceGree;
	}
	/**
	 * @return the insuredName
	 */
	public String getInsuredName() {
		return insuredName;
	}
	/**
	 * @param insuredName the insuredName to set
	 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	/**
	 * @return the registNo
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * @param registNo the registNo to set
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}
