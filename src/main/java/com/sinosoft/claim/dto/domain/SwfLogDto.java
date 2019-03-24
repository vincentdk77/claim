package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����SwfLog��������־������ݴ��������<br>
 * ������ 2004-08-09 19:54:50.630<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfLogDto extends SwfLogDtoBase implements Serializable {
	/** ���� * */
	Collection swfLogList;

	/** ��Ҫ������Ϣ������ */
	String alertMessage = "";
	String dfFlag = "";

	/** ��Ҫ�Ƕ�������ģ�������������������ڵ�����ã�1�ǣ���1 ���� */
	int newMTask = -1;
	/** �ڵ������ڵĲ� */
	int treeLayer = 0;

	/** ͬһ��ڵ�������λ�� */
	int nodePosLayer = 0;
	/** ��ʼ�ڵ� */
	int startNodeNo = 0;

	/** ��ֹ�ڵ� */
	int endNodeNo = 0;
	/** ÿ��Ľڵ���� */
	int countNode = 0;
	/** �Ƿ���ͬ�����ͬ�ڵ� */
	boolean sameLayerSameNode = false;

	/** ��Ҫ�������̣�1�ǣ���1 ���� */
	boolean createFlow = false;
	/** �Ƿ������ڶ���ռ�øýڵ� */
	boolean holdNode = false;

	/** ͳ�ƿ�ʼ���� */
	private String startDate;
	/** ͳ�ƽ������� */
	private String endDate;

	/** ���Խڵ��������� */
	private String nodeTypeName = "";

	/** ���Բ���״̬���� */
	private String nodeStatusName = "";
	/** ������������ */
	private String riskCodeName = "";

	/** �������͵����� */
	private String typeFlagName = "";
	/** ���õõ���һ���ڵ����Դ���ͣ�����Ϊ1����ʾͬʱָ���ڵ㣬�����ģ��Ѱ�� */
	private String nextNodeListType = "";
	/** һҳ���� */
	private TurnPageDto turnPageDto = null;
	// modify by weishixin add 20050225 start
	// reason:�������������ʱ���
	/** ʱ��� */
	private long stopTime = 0;
	/** �༭���� */
	private String editType = "";
	/** ƴ������ */
	private String whereString = "";
	/** ʱ������� */
	private String stopTimeDesc = "";

	/** �����´����� */
	private String newNewHandleDept = "";

	/** �����´��������� */
	private String newNewDeptName = "";

	/** �ڵ�İ�����Ϣ */
	private ArrayList swfNotionDtoList;

	/** δ����ͨ���ļ�������Ŀ */
	private int compeCount;

	/** ��������״̬ 0��ʾδ�������飬1��ʾ���ڴ����У�2��ʾ�Ѻ���ͨ�� */
	private String compeFlag;
	/** �����Ƿ��ѱ�ע�� */
	private String otherFlag;
	/** һ�����̵ı����϶�Ӧ�ı�������Ϣ��Ϣ */
	private Collection relatePolicyList;
	private String dataFlag;
	/**
	 * ��ҽ��ϵͳ�Ĳ�ѯ������־
	 */
	private String medicalTransitFlag;
	// add by kangzhen 070420 start
	/** �жϰ����Ƿ��Ѿ�ע�� */
	private String canceFlag;

	public String getCanceFlag() {
		return canceFlag;
	}

	public void setCanceFlag(String canceFlag) {
		this.canceFlag = canceFlag;
	}

	// add by kangzhen 070420 end

	/**
	 * ���δ����ͨ���ļ�������Ŀ
	 * 
	 * @return δ����ͨ���ļ�������Ŀ
	 */
	public int getCompeCount() {
		return this.compeCount;
	}

	/**
	 * ����δ����ͨ���ļ�������Ŀ
	 * 
	 * @param compeCount
	 *            δ����ͨ���ļ�������Ŀ
	 */
	public void setCompCount(int compeCount) {
		this.compeCount = compeCount;
	}

	// modify by weishixin add 20050225 end
	/**
	 * Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SwfLogDto����
	 */
	public SwfLogDto() {
	}

	/**
	 * �õ�wfLogList��Ϣ����
	 * 
	 * @return wfLogList��Ϣ������Ϣ
	 */
	public Collection getSwfLogList() {
		return swfLogList;
	}

	/**
	 * ����wfLogList��Ϣ����
	 * 
	 * @param wfLogList��Ϣ����
	 */
	public void setSwfLogList(Collection swfLogList) {
		this.swfLogList = swfLogList;
	}

	/**
	 * �õ�alertMessage��Ϣ
	 * 
	 * @return alertMessage��Ϣ
	 */
	public String getAlertMessage() {
		return alertMessage;
	}

	/**
	 * ����alertMessage��Ϣ
	 * 
	 * @param alertMessage��Ϣ
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
	/** ��һ���ڵ������ҵ��� */
	private String nextBusinessNo = "";

	/** ����������wfcondition�е�ҵ����������� */
	private String conditionBusinessNo = "";

	/**
	 * ������һ���ڵ�����ҵ���
	 * 
	 * @param nextNextBusinessNo
	 *            �����õ���һ���ڵ�����ҵ��ŵ�ֵ
	 */
	public void setNextBusinessNo(String nextBusinessNo) {
		this.nextBusinessNo = StringUtils.rightTrim(nextBusinessNo);
	}

	/**
	 * ��ȡ��һ���ڵ�����ҵ���
	 * 
	 * @return ��һ���ڵ�����ҵ��ŵ�ֵ
	 */
	public String getNextBusinessNo() {
		return nextBusinessNo;
	}

	/**
	 * �õ���Ҫ�Ƕ����������Ϣ
	 * 
	 * @return ��Ҫ�Ƕ����������Ϣ
	 */
	public int getNewMTask() {
		return newMTask;
	}

	/**
	 * ������Ҫ�Ƕ����������Ϣ
	 * 
	 * @param ������
	 */
	public void setNewMTask(int newMTask) {
		this.newMTask = newMTask;
	}

	/**
	 * �õ��ڵ������ڵĲ�
	 * 
	 * @return ����
	 */
	public int getTreeLayer() {
		return this.treeLayer;
	}

	/**
	 * ���ýڵ������ڵĲ�
	 * 
	 * @param ����
	 */
	public void setTreeLayer(int treeLayer) {
		this.treeLayer = treeLayer;
	}

	/**
	 * �õ�����������wfcondition�е�ҵ�����������
	 * 
	 * @return ҵ���
	 */
	public String getConditionBusinessNo() {
		return this.conditionBusinessNo;
	}

	/**
	 * ��������������wfcondition�е�ҵ�����������
	 * 
	 * @param ҵ���
	 */
	public void setConditionBusinessNo(String conditionBusinessNo) {
		this.conditionBusinessNo = conditionBusinessNo;
	}

	/**
	 * �õ���ʼ�ڵ�
	 * 
	 * @return ��ʼ�ڵ�
	 */
	public int getStartNodeNo() {
		return this.startNodeNo;
	}

	/**
	 * ������ʼ�ڵ�
	 * 
	 * @param
	 */
	public void setStartNodeNo(int startNodeNo) {
		this.startNodeNo = startNodeNo;
	}

	/**
	 * �õ���ֹ�ڵ�
	 * 
	 * @return ��ֹ�ڵ�
	 */
	public int getEndNodeNo() {
		return this.endNodeNo;
	}

	/**
	 * ������ʼ�ڵ�
	 * 
	 * @param
	 */
	public void setEndNodeNo(int endNodeNo) {
		this.endNodeNo = endNodeNo;
	}

	/**
	 * �õ�ͬ��ڵ����
	 * 
	 * @return ͬ��ڵ����
	 */
	public int getCountNode() {
		return this.countNode;
	}

	/**
	 * ����ͬ��ڵ����
	 * 
	 * @param ͬ��ڵ����
	 */
	public void setCountNode(int countNode) {
		this.countNode = countNode;
	}

	/**
	 * �õ�ͬ��ڵ��λ��
	 * 
	 * @return ͬ��ڵ��λ��
	 */
	public int getNodePosLayer() {
		return this.nodePosLayer;
	}

	/**
	 * ����ͬ��ڵ��λ��
	 * 
	 * @param ͬ��ڵ��λ��
	 */
	public void setNodePosLayer(int nodePosLayer) {
		this.nodePosLayer = nodePosLayer;
	}

	/**
	 * �Ƿ���ͬ����ظ��ڵ�
	 * 
	 * @return ͬ����ظ��ڵ�
	 */
	public boolean getsameLayerSameNode() {
		return this.sameLayerSameNode;
	}

	/**
	 * ����ͬ����ظ��ڵ�
	 * 
	 * @param ͬ����ظ��ڵ�
	 */
	public void setsameLayerSameNode(boolean sameLayerSameNode) {
		this.sameLayerSameNode = sameLayerSameNode;
	}

	/**
	 * �Ƿ񴴽�������
	 * 
	 * @return
	 */
	public boolean getCreateFlow() {
		return this.createFlow;
	}

	/**
	 * �����Ƿ񴴽�������
	 * 
	 * @param
	 */
	public void setCreateFlow(boolean createFlow) {
		this.createFlow = createFlow;
	}

	/**
	 * �Ƿ������ڶ���ռ�øýڵ�
	 * 
	 * @return ���ڶ���ռ�øýڵ�
	 */
	public boolean getHoldNode() {
		return this.holdNode;
	}

	/**
	 * �������ڶ���ռ�øýڵ�
	 * 
	 * @param ���ڶ���ռ�øýڵ�
	 */
	public void setHoldNode(boolean holdNode) {
		this.holdNode = holdNode;
	}

	/**
	 * �õ�����ͳ�ƽ�������
	 * 
	 * @return ����ͳ�ƽ�������
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * ��������ͳ�ƽ�������
	 * 
	 * @param endDate
	 *            ����ͳ�ƽ�������
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * �������Բ���״̬����
	 * 
	 * @param statusName
	 *            ���Բ���״̬����
	 */
	public void setNodeStatusName(String nodeStatusName) {
		this.nodeStatusName = nodeStatusName;
	}

	/**
	 * �õ����Բ���״̬����
	 * 
	 * @return ���Բ���״̬����
	 */
	public String getNodeStatusName() {
		return nodeStatusName;
	}

	/**
	 * �õ����Խڵ���������
	 * 
	 * @return ���Խڵ���������
	 */
	public String getNodeTypeName() {
		return nodeTypeName;
	}

	/**
	 * �������Խڵ���������
	 * 
	 * @param nodeTypeName
	 *            ���Խڵ���������
	 */
	public void setNodeTypeName(String nodeTypeName) {
		this.nodeTypeName = nodeTypeName;
	}

	/**
	 * ����������������
	 * 
	 * @param riskCodeName
	 *            �����õ������������Ƶ�ֵ
	 */
	public void setRiskCodeName(String riskCodeName) {
		this.riskCodeName = StringUtils.rightTrim(riskCodeName);
	}

	/**
	 * ��ȡ������������
	 * 
	 * @return �����������Ƶ�ֵ
	 */
	public String getRiskCodeName() {
		return riskCodeName;
	}

	/**
	 * �õ�����ͳ�ƿ�ʼ����
	 * 
	 * @return ����ͳ�ƿ�ʼ����
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * ��������ͳ�ƿ�ʼ����
	 * 
	 * @param startDate
	 *            ����ͳ�ƿ�ʼ����
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * ���ö������͵�����
	 * 
	 * @param typeFlagName
	 *            �����õĶ������͵����Ƶ�ֵ
	 */
	public void setTypeFlagName(String typeFlagName) {
		this.typeFlagName = StringUtils.rightTrim(typeFlagName);
	}

	/**
	 * ��ȡ�������͵�����
	 * 
	 * @return �������͵����Ƶ�ֵ
	 */
	public String getTypeFlagName() {
		return typeFlagName;
	}

	/**
	 * �õ���һ���ڵ����Դ���ͣ�����Ϊ1����ʾͬʱָ���ڵ㣬�����ģ��Ѱ��
	 * 
	 * @return nextNodeListType��Ϣ
	 */
	public String getNextNodeListType() {
		return nextNodeListType;
	}

	/**
	 * ���õõ���һ���ڵ����Դ���ͣ�����Ϊ1����ʾͬʱָ���ڵ㣬�����ģ��Ѱ��
	 * 
	 * @param nextNodeListType��Ϣ
	 */
	public void setNextNodeListType(String nextNodeListType) {
		this.nextNodeListType = nextNodeListType;
	}

	/**
	 * ����һҳ����
	 * 
	 * @param turnPageDto
	 *            һҳ����
	 */
	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}

	/**
	 * ��ȡһҳ����
	 * 
	 * @return ����һҳ����
	 */
	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}

	// modify by weishixin add 20050225 start
	// reason:�������������ʱ���
	/**
	 * ͣ��ʱ�����Ϣ
	 * 
	 * @return ��Ҫ��ͣ��ʱ�����Ϣ
	 */
	public long getStopTime() {
		return stopTime;
	}

	/**
	 * ����ͣ��ʱ�����Ϣ
	 * 
	 * @param ������
	 */
	public void setStopTime(long stopTime) {
		this.stopTime = stopTime;
	}

	/**
	 * ͣ��ʱ������
	 * 
	 * @return ͣ��ʱ������
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
	 * ͣ��ʱ������
	 * 
	 * @param ͣ��ʱ������
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
	 * �õ��ڵ�������Ϣ�ڵ���Ϣ
	 * 
	 * @return ���������̽ڵ���Ϣ
	 */
	public ArrayList getSwfNotionDtoList() {
		return swfNotionDtoList;
	}

	/**
	 * ���ýڵ�������Ϣ�ڵ���Ϣ
	 * 
	 * @param PrpLscheduleItemDto���������̽ڵ���Ϣ
	 */
	public void setSwfNotionDtoList(ArrayList swfNotionDtoList) {
		this.swfNotionDtoList = swfNotionDtoList;
	}

	/**
	 * ���ñ����Ƿ�ע����־
	 * 
	 * @param otherFlag
	 *            �����Ƿ�ע����־
	 */
	public void setOtherFlag(String otherFlag) {
		this.otherFlag = otherFlag;
	}

	/**
	 * ��ñ����Ƿ�ע����־
	 * 
	 * @return �����Ƿ�ע����־
	 */
	public String getOtherFlag() {
		return this.otherFlag;
	}

	/**
	 * ���������´�����
	 * 
	 * @param newNewHandleDept
	 *            �����õ����Դ����ŵ�ֵ
	 */
	public void setNewHandleDept(String newNewHandleDept) {
		this.newNewHandleDept = StringUtils.rightTrim(newNewHandleDept);
	}

	/**
	 * ��ȡ�����´�����
	 * 
	 * @return ���Դ����ŵ�ֵ
	 */
	public String getNewHandleDept() {
		return newNewHandleDept;
	}

	/**
	 * ���������´���������
	 * 
	 * @param newNewDeptName
	 *            �����õ����Դ��������Ƶ�ֵ
	 */
	public void setNewDeptName(String newNewDeptName) {
		this.newNewDeptName = StringUtils.rightTrim(newNewDeptName);
	}

	/**
	 * ��ȡ�����´���������
	 * 
	 * @return ���Դ��������Ƶ�ֵ
	 */
	public String getNewDeptName() {
		return newNewDeptName;
	}

	// add by lixiang start at 2006-6-5
	// reason :����
	/**
	 * �õ�һ�����̵ı����϶�Ӧ�ı�������Ϣ��Ϣ
	 * 
	 * @return һ�����̵ı����϶�Ӧ�ı�������Ϣ��Ϣ
	 */
	public Collection getRelatePolicyList() {
		return relatePolicyList;
	}

	/**
	 * ����һ�����̵ı����϶�Ӧ�ı�������Ϣ��Ϣ
	 * 
	 * @param PrpLscheduleItemDtoһ�����̵ı����϶�Ӧ�ı�������Ϣ��Ϣ
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
