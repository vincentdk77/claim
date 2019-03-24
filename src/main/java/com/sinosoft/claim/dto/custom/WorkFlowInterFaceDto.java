package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * ���������̽ӿ����ݴ������
 * <p>Title: ���������̽ӿ�DTO</p>
 * <p>Description: ������������ڵ� ����������</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class WorkFlowInterFaceDto implements Serializable
{
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


    /** ���Խڵ��������� */
    private String nodeTypeName = "";

    /** ���Բ���״̬���� */
    private String nodeStatusName = "";
    /** ������������ */
   private String riskCodeName="";

    /** ���͵����� */
    private String typeFlagName="";
    /** ҳ���ݶ���*/
    private TurnPageDto turnPageDto = null ;


    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SwfLogDtoBase����
     */
    public WorkFlowInterFaceDto(){
    }

    /**
     * �����������̱��
     * @param flowID �����õ��������̱�ŵ�ֵ
     */
    public void setFlowID(String flowID){
        this.flowID = StringUtils.rightTrim(flowID);
    }

    /**
     * ��ȡ�������̱��
     * @return �������̱�ŵ�ֵ
     */
    public String getFlowID(){
        return flowID;
    }

    /**
     * �����������
     * @param logNo �����õ�������ŵ�ֵ
     */
    public void setLogNo(int logNo){
        this.logNo = logNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getLogNo(){
        return logNo;
    }

    /**
     * ��������ģ���
     * @param modelNo �����õ�����ģ��ŵ�ֵ
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * ��ȡ����ģ���
     * @return ����ģ��ŵ�ֵ
     */
    public int getModelNo(){
        return modelNo;
    }

    /**
     * �������Ե�ǰ�ڵ��
     * @param nodeNo �����õ����Ե�ǰ�ڵ�ŵ�ֵ
     */
    public void setNodeNo(int nodeNo){
        this.nodeNo = nodeNo;
    }

    /**
     * ��ȡ���Ե�ǰ�ڵ��
     * @return ���Ե�ǰ�ڵ�ŵ�ֵ
     */
    public int getNodeNo(){
        return nodeNo;
    }

    /**
     * �������Ե�ǰ�ڵ�����
     * @param nodeName �����õ����Ե�ǰ�ڵ����Ƶ�ֵ
     */
    public void setNodeName(String nodeName){
        this.nodeName = StringUtils.rightTrim(nodeName);
    }

    /**
     * ��ȡ���Ե�ǰ�ڵ�����
     * @return ���Ե�ǰ�ڵ����Ƶ�ֵ
     */
    public String getNodeName(){
        return nodeName;
    }

    /**
     * ��������ҵ���
     * @param businessNo �����õ�����ҵ��ŵ�ֵ
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * ��ȡ����ҵ���
     * @return ����ҵ��ŵ�ֵ
     */
    public String getBusinessNo(){
        return businessNo;
    }

    /**
     * �������Դ�����
     * @param handleDept �����õ����Դ����ŵ�ֵ
     */
    public void setHandleDept(String handleDept){
        this.handleDept = StringUtils.rightTrim(handleDept);
    }

    /**
     * ��ȡ���Դ�����
     * @return ���Դ����ŵ�ֵ
     */
    public String getHandleDept(){
        return handleDept;
    }

    /**
     * �������Դ�����Ա����
     * @param handlerCode �����õ����Դ�����Ա�����ֵ
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * ��ȡ���Դ�����Ա����
     * @return ���Դ�����Ա�����ֵ
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * �������Դ�����Ա����
     * @param handlerName �����õ����Դ�����Ա���Ƶ�ֵ
     */
    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * ��ȡ���Դ�����Ա����
     * @return ���Դ�����Ա���Ƶ�ֵ
     */
    public String getHandlerName(){
        return handlerName;
    }

    /**
     * ������������ʱ��
     * @param flowInTime �����õ���������ʱ���ֵ
     */
    public void setFlowInTime(String flowInTime){
        this.flowInTime = StringUtils.rightTrim(flowInTime);
    }

    /**
     * ��ȡ��������ʱ��
     * @return ��������ʱ���ֵ
     */
    public String getFlowInTime(){
        return flowInTime;
    }

    /**
     * �������Դ���ʱ��
     * @param timeLimit �����õ����Դ���ʱ�޵�ֵ
     */
    public void setTimeLimit(int timeLimit){
        this.timeLimit = timeLimit;
    }

    /**
     * ��ȡ���Դ���ʱ��
     * @return ���Դ���ʱ�޵�ֵ
     */
    public int getTimeLimit(){
        return timeLimit;
    }

    /**
     * �������Դ���ʱ��
     * @param handleTime �����õ����Դ���ʱ���ֵ
     */
    public void setHandleTime(String handleTime){
        this.handleTime = StringUtils.rightTrim(handleTime);
    }

    /**
     * ��ȡ���Դ���ʱ��
     * @return ���Դ���ʱ���ֵ
     */
    public String getHandleTime(){
        return handleTime;
    }

    /**
     * ���������ύʱ��
     * @param submitTime �����õ������ύʱ���ֵ
     */
    public void setSubmitTime(String submitTime){
        this.submitTime = StringUtils.rightTrim(submitTime);
    }

    /**
     * ��ȡ�����ύʱ��
     * @return �����ύʱ���ֵ
     */
    public String getSubmitTime(){
        return submitTime;
    }

    /**
     * �������Խڵ�״̬
     * @param nodeStatus �����õ����Խڵ�״̬��ֵ
     */
    public void setNodeStatus(String nodeStatus){
        this.nodeStatus = StringUtils.rightTrim(nodeStatus);
    }

    /**
     * ��ȡ���Խڵ�״̬
     * @return ���Խڵ�״̬��ֵ
     */
    public String getNodeStatus(){
        return nodeStatus;
    }

    /**
     * ����������״̬
     * @param flowStatus �����õ�������״̬��ֵ
     */
    public void setFlowStatus(String flowStatus){
        this.flowStatus = StringUtils.rightTrim(flowStatus);
    }

    /**
     * ��ȡ������״̬
     * @return ������״̬��ֵ
     */
    public String getFlowStatus(){
        return flowStatus;
    }

    /**
     * ����������ϸ��Ϣ��ID
     * @param packageID �����õ�������ϸ��Ϣ��ID��ֵ
     */
    public void setPackageID(String packageID){
        this.packageID = StringUtils.rightTrim(packageID);
    }

    /**
     * ��ȡ������ϸ��Ϣ��ID
     * @return ������ϸ��Ϣ��ID��ֵ
     */
    public String getPackageID(){
        return packageID;
    }

    /**
     * �������Ա��ñ�־
     * @param flag �����õ����Ա��ñ�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա��ñ�־
     * @return ���Ա��ñ�־��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * ��������������
     * @param taskNo �����õ����������ŵ�ֵ
     */
    public void setTaskNo(int taskNo){
        this.taskNo = taskNo;
    }

    /**
     * ��ȡ����������
     * @return ���������ŵ�ֵ
     */
    public int getTaskNo(){
        return taskNo;
    }

    /**
     * ����������������
     * @param taskType �����õ������������͵�ֵ
     */
    public void setTaskType(String taskType){
        this.taskType = StringUtils.rightTrim(taskType);
    }

    /**
     * ��ȡ������������
     * @return �����������͵�ֵ
     */
    public String getTaskType(){
        return taskType;
    }

    /**
     * �������Խڵ�����
     * @param nodeType �����õ����Խڵ����͵�ֵ
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * ��ȡ���Խڵ�����
     * @return ���Խڵ����͵�ֵ
     */
    public String getNodeType(){
        return nodeType;
    }

    /**
     * ������������ע
     * @param titleStr �����õ���������ע��ֵ
     */
    public void setTitleStr(String titleStr){
        this.titleStr = StringUtils.rightTrim(titleStr);
    }

    /**
     * ��ȡ��������ע
     * @return ��������ע��ֵ
     */
    public String getTitleStr(){
        return titleStr;
    }

    /**
     * ��������ҵ������
     * @param businessType �����õ�����ҵ�����͵�ֵ
     */
    public void setBusinessType(String businessType){
        this.businessType = StringUtils.rightTrim(businessType);
    }

    /**
     * ��ȡ����ҵ������
     * @return ����ҵ�����͵�ֵ
     */
    public String getBusinessType(){
        return businessType;
    }

    /**
     * �����������ִ���
     * @param riskCode �����õ��������ִ����ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ�������ִ���
     * @return �������ִ����ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������������������ֵ
     * @param keyIn �����õ�����������������ֵ��ֵ
     */
    public void setKeyIn(String keyIn){
        this.keyIn = StringUtils.rightTrim(keyIn);
    }

    /**
     * ��ȡ����������������ֵ
     * @return ����������������ֵ��ֵ
     */
    public String getKeyIn(){
        return keyIn;
    }

    /**
     * �������������������ֵ
     * @param keyOut �����õ����������������ֵ��ֵ
     */
    public void setKeyOut(String keyOut){
        this.keyOut = StringUtils.rightTrim(keyOut);
    }

    /**
     * ��ȡ���������������ֵ
     * @return ���������������ֵ��ֵ
     */
    public String getKeyOut(){
        return keyOut;
    }

    /**
     * �������Բ�������
     * @param deptName �����õ����Բ������Ƶ�ֵ
     */
    public void setDeptName(String deptName){
        this.deptName = StringUtils.rightTrim(deptName);
    }

    /**
     * ��ȡ���Բ�������
     * @return ���Բ������Ƶ�ֵ
     */
    public String getDeptName(){
        return deptName;
    }

    /**
     * �������������̱��
     * @param mainFlowID �����õ����������̱�ŵ�ֵ
     */
    public void setMainFlowID(String mainFlowID){
        this.mainFlowID = StringUtils.rightTrim(mainFlowID);
    }

    /**
     * ��ȡ���������̱��
     * @return ���������̱�ŵ�ֵ
     */
    public String getMainFlowID(){
        return mainFlowID;
    }

    /**
     * �������������̱��
     * @param subFlowID �����õ����������̱�ŵ�ֵ
     */
    public void setSubFlowID(String subFlowID){
        this.subFlowID = StringUtils.rightTrim(subFlowID);
    }

    /**
     * ��ȡ���������̱��
     * @return ���������̱�ŵ�ֵ
     */
    public String getSubFlowID(){
        return subFlowID;
    }

    /**
     * �������Խڵ�X����
     * @param posX �����õ����Խڵ�X�����ֵ
     */
    public void setPosX(int posX){
        this.posX = posX;
    }

    /**
     * ��ȡ���Խڵ�X����
     * @return ���Խڵ�X�����ֵ
     */
    public int getPosX(){
        return posX;
    }

    /**
     * �������Խڵ�Y����
     * @param posY �����õ����Խڵ�Y�����ֵ
     */
    public void setPosY(int posY){
        this.posY = posY;
    }

    /**
     * ��ȡ���Խڵ�Y����
     * @return ���Խڵ�Y�����ֵ
     */
    public int getPosY(){
        return posY;
    }

    /**
     * �������Խ�����־
     * @param endFlag �����õ����Խ�����־��ֵ
     */
    public void setEndFlag(String endFlag){
        this.endFlag = StringUtils.rightTrim(endFlag);
    }

    /**
     * ��ȡ���Խ�����־
     * @return ���Խ�����־��ֵ
     */
    public String getEndFlag(){
        return endFlag;
    }

    /**
     * ���������ϸ�������Ա��
     * @param beforeHandlerCode �����õ������ϸ�������Ա���ֵ
     */
    public void setBeforeHandlerCode(String beforeHandlerCode){
        this.beforeHandlerCode = StringUtils.rightTrim(beforeHandlerCode);
    }

    /**
     * ��ȡ�����ϸ�������Ա��
     * @return �����ϸ�������Ա���ֵ
     */
    public String getBeforeHandlerCode(){
        return beforeHandlerCode;
    }

    /**
     * ���������ϸ�������Ա����
     * @param beforeHandlerName �����õ������ϸ�������Ա���Ƶ�ֵ
     */
    public void setBeforeHandlerName(String beforeHandlerName){
        this.beforeHandlerName = StringUtils.rightTrim(beforeHandlerName);
    }

    /**
     * ��ȡ�����ϸ�������Ա����
     * @return �����ϸ�������Ա���Ƶ�ֵ
     */
    public String getBeforeHandlerName(){
        return beforeHandlerName;
    }

    /**
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * �����������ͱ�־
     * @param typeFlag �����õ��������ͱ�־��ֵ
     */
    public void setTypeFlag(String typeFlag){
        this.typeFlag = StringUtils.rightTrim(typeFlag);
    }

    /**
     * ��ȡ�������ͱ�־
     * @return �������ͱ�־��ֵ
     */
    public String getTypeFlag(){
        return typeFlag;
    }

    /**
     * �������Թ�������
     * @param comCode �����õ����Թ���������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Թ�������
     * @return ���Թ���������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Ե��Ⱥ���
     * @param scheduleID �����õ����Ե��Ⱥ����ֵ
     */
    public void setScheduleID(int scheduleID){
        this.scheduleID = scheduleID;
    }

    /**
     * ��ȡ���Ե��Ⱥ���
     * @return ���Ե��Ⱥ����ֵ
     */
    public int getScheduleID(){
        return scheduleID;
    }

    /**
     * �������Ա�����
     * @param lossItemCode �����õ����Ա����ŵ�ֵ
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * �������Գ��ƺ���
     * @param lossItemName �����õ����Գ��ƺ����ֵ
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * ��ȡ���Գ��ƺ���
     * @return ���Գ��ƺ����ֵ
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * ���������Ƿ�Ϊ����������
     * @param insureCarFlag �����õ������Ƿ�Ϊ������������ֵ
     */
    public void setInsureCarFlag(String insureCarFlag){
        this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
    }

    /**
     * ��ȡ�����Ƿ�Ϊ����������
     * @return �����Ƿ�Ϊ������������ֵ
     */
    public String getInsureCarFlag(){
        return insureCarFlag;
    }


     /**�������Բ���״̬����
    * @param statusName ���Բ���״̬����
    */
    public void setNodeStatusName(String nodeStatusName) {
      this.nodeStatusName = nodeStatusName;
    }
    /**
     * ���ö������͵�����
     * @param typeFlagName �����õĶ������͵����Ƶ�ֵ
     */
    public void setTypeFlagName(String typeFlagName){
        this.typeFlagName = StringUtils.rightTrim(typeFlagName);
    }

    /**
     * ��ȡ�������͵�����
     * @return �������͵����Ƶ�ֵ
     */
    public String getTypeFlagName(){
        return typeFlagName;
    }
    /**
     * ����һҳ����
     * @param turnPageDto һҳ����
     */
    public void setTurnPageDto(TurnPageDto turnPageDto) {
    this.turnPageDto = turnPageDto;
    }
   /**
     * ��ȡһҳ����
     * @return ����һҳ����
     */
    public TurnPageDto getTurnPageDto() {
      return turnPageDto;
    }
     /**�õ����Բ���״̬����
     * @return ���Բ���״̬����
     */
    public String getNodeStatusName() {
      return nodeStatusName;
    }


   /**�õ����Խڵ���������
    * @return ���Խڵ���������
    */
    public String getNodeTypeName() {
      return nodeTypeName;
    }
  /**�������Խڵ���������
    * @param nodeTypeName ���Խڵ���������
    */
    public void setNodeTypeName(String nodeTypeName) {
      this.nodeTypeName = nodeTypeName;
    }

    /**
       * ����������������
       * @param riskCodeName �����õ������������Ƶ�ֵ
       */
      public void setRiskCodeName(String riskCodeName){
          this.riskCodeName = StringUtils.rightTrim(riskCodeName);
      }

      /**
       * ��ȡ������������
       * @return �����������Ƶ�ֵ
       */
      public String getRiskCodeName(){
          return riskCodeName;
      }
}
