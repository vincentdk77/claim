package com.gyic.claim.dto.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;

/**
 * ����PRPLCOMBINE�����ݴ��������<br>
 */
public class PrplcombineSwfLogDto extends PrplcombineSwfLogDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ���� **/
    Collection swfLogList;

    /**��Ҫ������Ϣ������*/
    String alertMessage="";
    String  dfFlag="";

    /**��Ҫ�Ƕ�������ģ�������������������ڵ�����ã�1�ǣ���1 ����*/
    int newMTask = -1;
    /**�ڵ������ڵĲ�*/
    int treeLayer = 0 ;

    /**ͬһ��ڵ�������λ��*/
    int nodePosLayer = 0;
    /**��ʼ�ڵ�*/
    int startNodeNo = 0 ;

    /**��ֹ�ڵ�*/
    int endNodeNo   = 0 ;
    /**ÿ��Ľڵ����*/
    int countNode  = 0 ;
    /** �Ƿ���ͬ�����ͬ�ڵ�*/
    boolean sameLayerSameNode = false;

    /**��Ҫ�������̣�1�ǣ���1 ����*/
    boolean createFlow =false;
  /** �Ƿ������ڶ���ռ�øýڵ�*/
    boolean holdNode = false;

       /** ͳ�ƿ�ʼ����*/
      private String startDate;
      /** ͳ�ƽ�������*/
      private String endDate;

  /** ���Խڵ��������� */
      private String nodeTypeName = "";

      /** ���Բ���״̬���� */
      private String nodeStatusName = "";
      /** ������������ */
     private String riskCodeName="";


      /** �������͵����� */
      private String typeFlagName="";
      /**���õõ���һ���ڵ����Դ���ͣ�����Ϊ1����ʾͬʱָ���ڵ㣬�����ģ��Ѱ��*/
      private String nextNodeListType="";
      /** һҳ����*/
      private TurnPageDto turnPageDto = null ;
      //modify by weishixin add 20050225 start
      //reason:�������������ʱ���
      /** ʱ���*/
      private long stopTime = 0 ;
      /** �༭���� */
      private String editType = "" ;
      /** ƴ������ */
      private String whereString = "" ;
      /** ʱ�������*/
      private String stopTimeDesc = "" ;
      
        
      /** �����´����� */
      private String newNewHandleDept = "";
      
      /** �����´��������� */
      private String newNewDeptName = "";
      
     /**�ڵ�İ�����Ϣ*/
    private ArrayList swfNotionDtoList;
    
    /**δ����ͨ���ļ�������Ŀ*/
    private int compeCount;
    
    /**��������״̬ 0��ʾδ�������飬1��ʾ���ڴ����У�2��ʾ�Ѻ���ͨ��*/
    private String compeFlag;
    /**�����Ƿ��ѱ�ע��*/
    private String otherFlag;
    /**һ�����̵ı����϶�Ӧ�ı�������Ϣ��Ϣ*/
    private Collection relatePolicyList;
    
    
    //add by kangzhen 070420 start
    /**�жϰ����Ƿ��Ѿ�ע�� */
    private String canceFlag;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplcombineDto����
     */
    public PrplcombineSwfLogDto(){
    }
	/**
	 * @return the swfLogList
	 */
	public Collection getSwfLogList() {
		return swfLogList;
	}
	/**
	 * @param swfLogList the swfLogList to set
	 */
	public void setSwfLogList(Collection swfLogList) {
		this.swfLogList = swfLogList;
	}
	/**
	 * @return the alertMessage
	 */
	public String getAlertMessage() {
		return alertMessage;
	}
	/**
	 * @param alertMessage the alertMessage to set
	 */
	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}
	/**
	 * @return the dfFlag
	 */
	public String getDfFlag() {
		return dfFlag;
	}
	/**
	 * @param dfFlag the dfFlag to set
	 */
	public void setDfFlag(String dfFlag) {
		this.dfFlag = dfFlag;
	}
	/**
	 * @return the newMTask
	 */
	public int getNewMTask() {
		return newMTask;
	}
	/**
	 * @param newMTask the newMTask to set
	 */
	public void setNewMTask(int newMTask) {
		this.newMTask = newMTask;
	}
	/**
	 * @return the treeLayer
	 */
	public int getTreeLayer() {
		return treeLayer;
	}
	/**
	 * @param treeLayer the treeLayer to set
	 */
	public void setTreeLayer(int treeLayer) {
		this.treeLayer = treeLayer;
	}
	/**
	 * @return the nodePosLayer
	 */
	public int getNodePosLayer() {
		return nodePosLayer;
	}
	/**
	 * @param nodePosLayer the nodePosLayer to set
	 */
	public void setNodePosLayer(int nodePosLayer) {
		this.nodePosLayer = nodePosLayer;
	}
	/**
	 * @return the startNodeNo
	 */
	public int getStartNodeNo() {
		return startNodeNo;
	}
	/**
	 * @param startNodeNo the startNodeNo to set
	 */
	public void setStartNodeNo(int startNodeNo) {
		this.startNodeNo = startNodeNo;
	}
	/**
	 * @return the endNodeNo
	 */
	public int getEndNodeNo() {
		return endNodeNo;
	}
	/**
	 * @param endNodeNo the endNodeNo to set
	 */
	public void setEndNodeNo(int endNodeNo) {
		this.endNodeNo = endNodeNo;
	}
	/**
	 * @return the countNode
	 */
	public int getCountNode() {
		return countNode;
	}
	/**
	 * @param countNode the countNode to set
	 */
	public void setCountNode(int countNode) {
		this.countNode = countNode;
	}
	/**
	 * @return the sameLayerSameNode
	 */
	public boolean isSameLayerSameNode() {
		return sameLayerSameNode;
	}
	/**
	 * @param sameLayerSameNode the sameLayerSameNode to set
	 */
	public void setSameLayerSameNode(boolean sameLayerSameNode) {
		this.sameLayerSameNode = sameLayerSameNode;
	}
	/**
	 * @return the createFlow
	 */
	public boolean isCreateFlow() {
		return createFlow;
	}
	/**
	 * @param createFlow the createFlow to set
	 */
	public void setCreateFlow(boolean createFlow) {
		this.createFlow = createFlow;
	}
	/**
	 * @return the holdNode
	 */
	public boolean isHoldNode() {
		return holdNode;
	}
	/**
	 * @param holdNode the holdNode to set
	 */
	public void setHoldNode(boolean holdNode) {
		this.holdNode = holdNode;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the nodeTypeName
	 */
	public String getNodeTypeName() {
		return nodeTypeName;
	}
	/**
	 * @param nodeTypeName the nodeTypeName to set
	 */
	public void setNodeTypeName(String nodeTypeName) {
		this.nodeTypeName = nodeTypeName;
	}
	/**
	 * @return the nodeStatusName
	 */
	public String getNodeStatusName() {
		return nodeStatusName;
	}
	/**
	 * @param nodeStatusName the nodeStatusName to set
	 */
	public void setNodeStatusName(String nodeStatusName) {
		this.nodeStatusName = nodeStatusName;
	}
	/**
	 * @return the riskCodeName
	 */
	public String getRiskCodeName() {
		return riskCodeName;
	}
	/**
	 * @param riskCodeName the riskCodeName to set
	 */
	public void setRiskCodeName(String riskCodeName) {
		this.riskCodeName = riskCodeName;
	}
	/**
	 * @return the typeFlagName
	 */
	public String getTypeFlagName() {
		return typeFlagName;
	}
	/**
	 * @param typeFlagName the typeFlagName to set
	 */
	public void setTypeFlagName(String typeFlagName) {
		this.typeFlagName = typeFlagName;
	}
	/**
	 * @return the nextNodeListType
	 */
	public String getNextNodeListType() {
		return nextNodeListType;
	}
	/**
	 * @param nextNodeListType the nextNodeListType to set
	 */
	public void setNextNodeListType(String nextNodeListType) {
		this.nextNodeListType = nextNodeListType;
	}
	/**
	 * @return the turnPageDto
	 */
	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}
	/**
	 * @param turnPageDto the turnPageDto to set
	 */
	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}
	/**
	 * @return the stopTime
	 */
	public long getStopTime() {
		return stopTime;
	}
	/**
	 * @param stopTime the stopTime to set
	 */
	public void setStopTime(long stopTime) {
		this.stopTime = stopTime;
	}
	/**
	 * @return the editType
	 */
	public String getEditType() {
		return editType;
	}
	/**
	 * @param editType the editType to set
	 */
	public void setEditType(String editType) {
		this.editType = editType;
	}
	/**
	 * @return the whereString
	 */
	public String getWhereString() {
		return whereString;
	}
	/**
	 * @param whereString the whereString to set
	 */
	public void setWhereString(String whereString) {
		this.whereString = whereString;
	}
	/**
	 * @return the stopTimeDesc
	 */
	public String getStopTimeDesc() {
		return stopTimeDesc;
	}
	/**
	 * @param stopTimeDesc the stopTimeDesc to set
	 */
	public void setStopTimeDesc(String stopTimeDesc) {
		this.stopTimeDesc = stopTimeDesc;
	}
	/**
	 * @return the newNewHandleDept
	 */
	public String getNewNewHandleDept() {
		return newNewHandleDept;
	}
	/**
	 * @param newNewHandleDept the newNewHandleDept to set
	 */
	public void setNewNewHandleDept(String newNewHandleDept) {
		this.newNewHandleDept = newNewHandleDept;
	}
	/**
	 * @return the newNewDeptName
	 */
	public String getNewNewDeptName() {
		return newNewDeptName;
	}
	/**
	 * @param newNewDeptName the newNewDeptName to set
	 */
	public void setNewNewDeptName(String newNewDeptName) {
		this.newNewDeptName = newNewDeptName;
	}
	/**
	 * @return the swfNotionDtoList
	 */
	public ArrayList getSwfNotionDtoList() {
		return swfNotionDtoList;
	}
	/**
	 * @param swfNotionDtoList the swfNotionDtoList to set
	 */
	public void setSwfNotionDtoList(ArrayList swfNotionDtoList) {
		this.swfNotionDtoList = swfNotionDtoList;
	}
	/**
	 * @return the compeCount
	 */
	public int getCompeCount() {
		return compeCount;
	}
	/**
	 * @param compeCount the compeCount to set
	 */
	public void setCompeCount(int compeCount) {
		this.compeCount = compeCount;
	}
	/**
	 * @return the compeFlag
	 */
	public String getCompeFlag() {
		return compeFlag;
	}
	/**
	 * @param compeFlag the compeFlag to set
	 */
	public void setCompeFlag(String compeFlag) {
		this.compeFlag = compeFlag;
	}
	/**
	 * @return the otherFlag
	 */
	public String getOtherFlag() {
		return otherFlag;
	}
	/**
	 * @param otherFlag the otherFlag to set
	 */
	public void setOtherFlag(String otherFlag) {
		this.otherFlag = otherFlag;
	}
	/**
	 * @return the relatePolicyList
	 */
	public Collection getRelatePolicyList() {
		return relatePolicyList;
	}
	/**
	 * @param relatePolicyList the relatePolicyList to set
	 */
	public void setRelatePolicyList(Collection relatePolicyList) {
		this.relatePolicyList = relatePolicyList;
	}
	/**
	 * @return the canceFlag
	 */
	public String getCanceFlag() {
		return canceFlag;
	}
	/**
	 * @param canceFlag the canceFlag to set
	 */
	public void setCanceFlag(String canceFlag) {
		this.canceFlag = canceFlag;
	}
	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}
