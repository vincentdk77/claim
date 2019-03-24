package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是SwfLog工作流日志表的数据传输对象类<br>
 * 创建于 2004-08-09 19:54:50.630<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfLogDto extends SwfLogDtoBase implements Serializable {
	/** 集合 * */
	Collection swfLogList;

	/** 需要弹出消息的内容 */
	String alertMessage = "";
	String dfFlag = "";

	/** 需要是多任务处理的，并且是新生成子任务节点的配置，1是，非1 不是 */
	int newMTask = -1;
	/** 节点树所在的层 */
	int treeLayer = 0;

	/** 同一层节点所处的位置 */
	int nodePosLayer = 0;
	/** 起始节点 */
	int startNodeNo = 0;

	/** 终止节点 */
	int endNodeNo = 0;
	/** 每层的节点个数 */
	int countNode = 0;
	/** 是否是同层的相同节点 */
	boolean sameLayerSameNode = false;

	/** 需要创建流程，1是，非1 不是 */
	boolean createFlow = false;
	/** 是否是正在独自占用该节点 */
	boolean holdNode = false;

	/** 统计开始日期 */
	private String startDate;
	/** 统计结束日期 */
	private String endDate;

	/** 属性节点种类名称 */
	private String nodeTypeName = "";

	/** 属性操作状态名称 */
	private String nodeStatusName = "";
	/** 属性险种名称 */
	private String riskCodeName = "";

	/** 定损类型的名称 */
	private String typeFlagName = "";
	/** 设置得到下一个节点的来源类型，设置为1，表示同时指定节点，否则从模板寻找 */
	private String nextNodeListType = "";
	/** 一页数据 */
	private TurnPageDto turnPageDto = null;
	// modify by weishixin add 20050225 start
	// reason:计算流入和流出时间差
	/** 时间差 */
	private long stopTime = 0;
	/** 编辑类型 */
	private String editType = "";
	/** 拼的条件 */
	private String whereString = "";
	/** 时间差描述 */
	private String stopTimeDesc = "";

	/** 属性新处理部门 */
	private String newNewHandleDept = "";

	/** 属性新处理部门名称 */
	private String newNewDeptName = "";

	/** 节点的办理信息 */
	private ArrayList swfNotionDtoList;

	/** 未核赔通过的计算书数目 */
	private int compeCount;

	/** 理算任务状态 0表示未出计算书，1表示正在处理中，2表示已核赔通过 */
	private String compeFlag;
	/** 保单是否已被注销 */
	private String otherFlag;
	/** 一个流程的报案上对应的保单号信息信息 */
	private Collection relatePolicyList;
	private String dataFlag;
	/**
	 * 大病医疗系统的查询交换标志
	 */
	private String medicalTransitFlag;
	// add by kangzhen 070420 start
	/** 判断案件是否已经注销 */
	private String canceFlag;

	public String getCanceFlag() {
		return canceFlag;
	}

	public void setCanceFlag(String canceFlag) {
		this.canceFlag = canceFlag;
	}

	// add by kangzhen 070420 end

	/**
	 * 获得未核赔通过的计算书数目
	 * 
	 * @return 未核赔通过的计算书数目
	 */
	public int getCompeCount() {
		return this.compeCount;
	}

	/**
	 * 设置未核赔通过的计算书数目
	 * 
	 * @param compeCount
	 *            未核赔通过的计算书数目
	 */
	public void setCompCount(int compeCount) {
		this.compeCount = compeCount;
	}

	// modify by weishixin add 20050225 end
	/**
	 * 默认构造方法,构造一个默认的SwfLogDto对象
	 */
	public SwfLogDto() {
	}

	/**
	 * 得到wfLogList信息集合
	 * 
	 * @return wfLogList信息集合信息
	 */
	public Collection getSwfLogList() {
		return swfLogList;
	}

	/**
	 * 设置wfLogList信息集合
	 * 
	 * @param wfLogList信息集合
	 */
	public void setSwfLogList(Collection swfLogList) {
		this.swfLogList = swfLogList;
	}

	/**
	 * 得到alertMessage信息
	 * 
	 * @return alertMessage信息
	 */
	public String getAlertMessage() {
		return alertMessage;
	}

	/**
	 * 设置alertMessage信息
	 * 
	 * @param alertMessage信息
	 */
	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}

	// add 20060809 start
	public String getDfFlag() {
		return dfFlag;
	}

	public void setDfFlag(String dfFlag) {
		this.dfFlag = dfFlag;
	}

	// add 20060809 end
	/** 下一个节点的属性业务号 */
	private String nextBusinessNo = "";

	/** 用来做条件wfcondition中的业务号限制条件 */
	private String conditionBusinessNo = "";

	/**
	 * 设置下一个节点属性业务号
	 * 
	 * @param nextNextBusinessNo
	 *            待设置的下一个节点属性业务号的值
	 */
	public void setNextBusinessNo(String nextBusinessNo) {
		this.nextBusinessNo = StringUtils.rightTrim(nextBusinessNo);
	}

	/**
	 * 获取下一个节点属性业务号
	 * 
	 * @return 下一个节点属性业务号的值
	 */
	public String getNextBusinessNo() {
		return nextBusinessNo;
	}

	/**
	 * 得到需要是多任务处理的信息
	 * 
	 * @return 需要是多任务处理的信息
	 */
	public int getNewMTask() {
		return newMTask;
	}

	/**
	 * 设置需要是多任务处理的信息
	 * 
	 * @param 任务数
	 */
	public void setNewMTask(int newMTask) {
		this.newMTask = newMTask;
	}

	/**
	 * 得到节点树所在的层
	 * 
	 * @return 层数
	 */
	public int getTreeLayer() {
		return this.treeLayer;
	}

	/**
	 * 设置节点树所在的层
	 * 
	 * @param 层数
	 */
	public void setTreeLayer(int treeLayer) {
		this.treeLayer = treeLayer;
	}

	/**
	 * 得到用来做条件wfcondition中的业务号限制条件
	 * 
	 * @return 业务号
	 */
	public String getConditionBusinessNo() {
		return this.conditionBusinessNo;
	}

	/**
	 * 设置用来做条件wfcondition中的业务号限制条件
	 * 
	 * @param 业务号
	 */
	public void setConditionBusinessNo(String conditionBusinessNo) {
		this.conditionBusinessNo = conditionBusinessNo;
	}

	/**
	 * 得到起始节点
	 * 
	 * @return 起始节点
	 */
	public int getStartNodeNo() {
		return this.startNodeNo;
	}

	/**
	 * 设置起始节点
	 * 
	 * @param
	 */
	public void setStartNodeNo(int startNodeNo) {
		this.startNodeNo = startNodeNo;
	}

	/**
	 * 得到终止节点
	 * 
	 * @return 终止节点
	 */
	public int getEndNodeNo() {
		return this.endNodeNo;
	}

	/**
	 * 设置起始节点
	 * 
	 * @param
	 */
	public void setEndNodeNo(int endNodeNo) {
		this.endNodeNo = endNodeNo;
	}

	/**
	 * 得到同层节点个数
	 * 
	 * @return 同层节点个数
	 */
	public int getCountNode() {
		return this.countNode;
	}

	/**
	 * 设置同层节点个数
	 * 
	 * @param 同层节点个数
	 */
	public void setCountNode(int countNode) {
		this.countNode = countNode;
	}

	/**
	 * 得到同层节点层位置
	 * 
	 * @return 同层节点层位置
	 */
	public int getNodePosLayer() {
		return this.nodePosLayer;
	}

	/**
	 * 设置同层节点层位置
	 * 
	 * @param 同层节点层位置
	 */
	public void setNodePosLayer(int nodePosLayer) {
		this.nodePosLayer = nodePosLayer;
	}

	/**
	 * 是否是同层的重复节点
	 * 
	 * @return 同层的重复节点
	 */
	public boolean getsameLayerSameNode() {
		return this.sameLayerSameNode;
	}

	/**
	 * 设置同层的重复节点
	 * 
	 * @param 同层的重复节点
	 */
	public void setsameLayerSameNode(boolean sameLayerSameNode) {
		this.sameLayerSameNode = sameLayerSameNode;
	}

	/**
	 * 是否创建新流程
	 * 
	 * @return
	 */
	public boolean getCreateFlow() {
		return this.createFlow;
	}

	/**
	 * 设置是否创建新流程
	 * 
	 * @param
	 */
	public void setCreateFlow(boolean createFlow) {
		this.createFlow = createFlow;
	}

	/**
	 * 是否是正在独自占用该节点
	 * 
	 * @return 正在独自占用该节点
	 */
	public boolean getHoldNode() {
		return this.holdNode;
	}

	/**
	 * 设置正在独自占用该节点
	 * 
	 * @param 正在独自占用该节点
	 */
	public void setHoldNode(boolean holdNode) {
		this.holdNode = holdNode;
	}

	/**
	 * 得到属性统计结束日期
	 * 
	 * @return 属性统计结束日期
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * 设置属性统计结束日期
	 * 
	 * @param endDate
	 *            属性统计结束日期
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * 设置属性操作状态名称
	 * 
	 * @param statusName
	 *            属性操作状态名称
	 */
	public void setNodeStatusName(String nodeStatusName) {
		this.nodeStatusName = nodeStatusName;
	}

	/**
	 * 得到属性操作状态名称
	 * 
	 * @return 属性操作状态名称
	 */
	public String getNodeStatusName() {
		return nodeStatusName;
	}

	/**
	 * 得到属性节点种类名称
	 * 
	 * @return 属性节点种类名称
	 */
	public String getNodeTypeName() {
		return nodeTypeName;
	}

	/**
	 * 设置属性节点种类名称
	 * 
	 * @param nodeTypeName
	 *            属性节点种类名称
	 */
	public void setNodeTypeName(String nodeTypeName) {
		this.nodeTypeName = nodeTypeName;
	}

	/**
	 * 设置属性险种名称
	 * 
	 * @param riskCodeName
	 *            待设置的属性险种名称的值
	 */
	public void setRiskCodeName(String riskCodeName) {
		this.riskCodeName = StringUtils.rightTrim(riskCodeName);
	}

	/**
	 * 获取属性险种名称
	 * 
	 * @return 属性险种名称的值
	 */
	public String getRiskCodeName() {
		return riskCodeName;
	}

	/**
	 * 得到属性统计开始日期
	 * 
	 * @return 属性统计开始日期
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * 设置属性统计开始日期
	 * 
	 * @param startDate
	 *            属性统计开始日期
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * 设置定损类型的名称
	 * 
	 * @param typeFlagName
	 *            待设置的定损类型的名称的值
	 */
	public void setTypeFlagName(String typeFlagName) {
		this.typeFlagName = StringUtils.rightTrim(typeFlagName);
	}

	/**
	 * 获取定损类型的名称
	 * 
	 * @return 定损类型的名称的值
	 */
	public String getTypeFlagName() {
		return typeFlagName;
	}

	/**
	 * 得到下一个节点的来源类型，设置为1，表示同时指定节点，否则从模板寻找
	 * 
	 * @return nextNodeListType信息
	 */
	public String getNextNodeListType() {
		return nextNodeListType;
	}

	/**
	 * 设置得到下一个节点的来源类型，设置为1，表示同时指定节点，否则从模板寻找
	 * 
	 * @param nextNodeListType信息
	 */
	public void setNextNodeListType(String nextNodeListType) {
		this.nextNodeListType = nextNodeListType;
	}

	/**
	 * 设置一页数据
	 * 
	 * @param turnPageDto
	 *            一页数据
	 */
	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}

	/**
	 * 获取一页数据
	 * 
	 * @return 属性一页数据
	 */
	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}

	// modify by weishixin add 20050225 start
	// reason:计算流入和流出时间差
	/**
	 * 停留时间的信息
	 * 
	 * @return 需要是停留时间的信息
	 */
	public long getStopTime() {
		return stopTime;
	}

	/**
	 * 设置停留时间的信息
	 * 
	 * @param 任务数
	 */
	public void setStopTime(long stopTime) {
		this.stopTime = stopTime;
	}

	/**
	 * 停留时间描述
	 * 
	 * @return 停留时间描述
	 */
	public String getStopTimeDesc() {
		return this.stopTimeDesc;
	}

	public boolean isSameLayerSameNode() {
		return sameLayerSameNode;
	}

	public String getEditType() {
		return editType;
	}

	public String getWhereString() {
		return whereString;
	}

	/**
	 * 停留时间描述
	 * 
	 * @param 停留时间描述
	 */
	public void setStopTimeDesc(String stopTimeDesc) {
		this.stopTimeDesc = stopTimeDesc;
	}

	public void setSameLayerSameNode(boolean sameLayerSameNode) {
		this.sameLayerSameNode = sameLayerSameNode;
	}

	public void setEditType(String editType) {
		this.editType = editType;
	}

	public void setWhereString(String whereString) {
		this.whereString = whereString;
	}

	// modify by weishixin add 20050225 end
	/**
	 * 得到节点批办信息节点信息
	 * 
	 * @return 工作流流程节点信息
	 */
	public ArrayList getSwfNotionDtoList() {
		return swfNotionDtoList;
	}

	/**
	 * 设置节点批办信息节点信息
	 * 
	 * @param PrpLscheduleItemDto工作流流程节点信息
	 */
	public void setSwfNotionDtoList(ArrayList swfNotionDtoList) {
		this.swfNotionDtoList = swfNotionDtoList;
	}

	/**
	 * 设置保单是否被注销标志
	 * 
	 * @param otherFlag
	 *            保单是否被注销标志
	 */
	public void setOtherFlag(String otherFlag) {
		this.otherFlag = otherFlag;
	}

	/**
	 * 获得保单是否被注销标志
	 * 
	 * @return 保单是否被注销标志
	 */
	public String getOtherFlag() {
		return this.otherFlag;
	}

	/**
	 * 设置属性新处理部门
	 * 
	 * @param newNewHandleDept
	 *            待设置的属性处理部门的值
	 */
	public void setNewHandleDept(String newNewHandleDept) {
		this.newNewHandleDept = StringUtils.rightTrim(newNewHandleDept);
	}

	/**
	 * 获取属性新处理部门
	 * 
	 * @return 属性处理部门的值
	 */
	public String getNewHandleDept() {
		return newNewHandleDept;
	}

	/**
	 * 设置属性新处理部门名称
	 * 
	 * @param newNewDeptName
	 *            待设置的属性处理部门名称的值
	 */
	public void setNewDeptName(String newNewDeptName) {
		this.newNewDeptName = StringUtils.rightTrim(newNewDeptName);
	}

	/**
	 * 获取属性新处理部门名称
	 * 
	 * @return 属性处理部门名称的值
	 */
	public String getNewDeptName() {
		return newNewDeptName;
	}

	// add by lixiang start at 2006-6-5
	// reason :增加
	/**
	 * 得到一个流程的报案上对应的保单号信息信息
	 * 
	 * @return 一个流程的报案上对应的保单号信息信息
	 */
	public Collection getRelatePolicyList() {
		return relatePolicyList;
	}

	/**
	 * 设置一个流程的报案上对应的保单号信息信息
	 * 
	 * @param PrpLscheduleItemDto一个流程的报案上对应的保单号信息信息
	 */
	public void setRelatePolicyList(Collection relatePolicyList) {
		this.relatePolicyList = relatePolicyList;
	}

	// add by lixiang end at 2006-6-5
	public String getCompeFlag() {
		return compeFlag;
	}

	public void setCompeFlag(String compeFlag) {
		this.compeFlag = compeFlag;
	}

	public String getDataFlag() {
		return dataFlag;
	}

	public void setDataFlag(String dataFlag) {
		this.dataFlag = dataFlag;
	}

	public String getMedicalTransitFlag() {
		return medicalTransitFlag;
	}

	public void setMedicalTransitFlag(String medicalTransitFlag) {
		this.medicalTransitFlag = medicalTransitFlag;
	}
}
