package com.gyic.claim.dto.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;

/**
 * 这是PRPLCOMBINE的数据传输对象类<br>
 */
public class PrplcombineSwfLogDto extends PrplcombineSwfLogDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 集合 **/
    Collection swfLogList;

    /**需要弹出消息的内容*/
    String alertMessage="";
    String  dfFlag="";

    /**需要是多任务处理的，并且是新生成子任务节点的配置，1是，非1 不是*/
    int newMTask = -1;
    /**节点树所在的层*/
    int treeLayer = 0 ;

    /**同一层节点所处的位置*/
    int nodePosLayer = 0;
    /**起始节点*/
    int startNodeNo = 0 ;

    /**终止节点*/
    int endNodeNo   = 0 ;
    /**每层的节点个数*/
    int countNode  = 0 ;
    /** 是否是同层的相同节点*/
    boolean sameLayerSameNode = false;

    /**需要创建流程，1是，非1 不是*/
    boolean createFlow =false;
  /** 是否是正在独自占用该节点*/
    boolean holdNode = false;

       /** 统计开始日期*/
      private String startDate;
      /** 统计结束日期*/
      private String endDate;

  /** 属性节点种类名称 */
      private String nodeTypeName = "";

      /** 属性操作状态名称 */
      private String nodeStatusName = "";
      /** 属性险种名称 */
     private String riskCodeName="";


      /** 定损类型的名称 */
      private String typeFlagName="";
      /**设置得到下一个节点的来源类型，设置为1，表示同时指定节点，否则从模板寻找*/
      private String nextNodeListType="";
      /** 一页数据*/
      private TurnPageDto turnPageDto = null ;
      //modify by weishixin add 20050225 start
      //reason:计算流入和流出时间差
      /** 时间差*/
      private long stopTime = 0 ;
      /** 编辑类型 */
      private String editType = "" ;
      /** 拼的条件 */
      private String whereString = "" ;
      /** 时间差描述*/
      private String stopTimeDesc = "" ;
      
        
      /** 属性新处理部门 */
      private String newNewHandleDept = "";
      
      /** 属性新处理部门名称 */
      private String newNewDeptName = "";
      
     /**节点的办理信息*/
    private ArrayList swfNotionDtoList;
    
    /**未核赔通过的计算书数目*/
    private int compeCount;
    
    /**理算任务状态 0表示未出计算书，1表示正在处理中，2表示已核赔通过*/
    private String compeFlag;
    /**保单是否已被注销*/
    private String otherFlag;
    /**一个流程的报案上对应的保单号信息信息*/
    private Collection relatePolicyList;
    
    
    //add by kangzhen 070420 start
    /**判断案件是否已经注销 */
    private String canceFlag;
    /**
     *  默认构造方法,构造一个默认的PrplcombineDto对象
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
