package com.sinosoft.claim.webservice;

import java.io.Serializable;
/**
 * 理赔系统改派列表查询:改派列表信息(ScheduleGetBackQueryDetailDtoInfo)
 * @author Administrator
 *
 */
public class ScheduleGetBackQueryDetailDtoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**报案登记号*/
	private String registNo;
	/**调度时间*/
	private String flowInTime;
	/**调度操作员代码*/
	private String handlerCode;
	/**调度操作员名称*/
	private String handlerName;
	/**查勘/定损人员代码*/
	private String beforeHandlerCode;
	/**查勘/定损人员名称*/
	private String beforeHandlerName;
	/**调度对象代码*/
	private String lossItemCode;
	/**调度对象名称*/
	private String lossItemName;
	/**节点ID*/
	private String flowId;
	/**节点序号*/
	private String logNo;
	public ScheduleGetBackQueryDetailDtoInfo() {
		super();
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getFlowInTime() {
		return flowInTime;
	}
	public void setFlowInTime(String flowInTime) {
		this.flowInTime = flowInTime;
	}
	public String getHandlerCode() {
		return handlerCode;
	}
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}
	public String getHandlerName() {
		return handlerName;
	}
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	public String getBeforeHandlerCode() {
		return beforeHandlerCode;
	}
	public void setBeforeHandlerCode(String beforeHandlerCode) {
		this.beforeHandlerCode = beforeHandlerCode;
	}
	public String getBeforeHandlerName() {
		return beforeHandlerName;
	}
	public void setBeforeHandlerName(String beforeHandlerName) {
		this.beforeHandlerName = beforeHandlerName;
	}
	public String getLossItemCode() {
		return lossItemCode;
	}
	public void setLossItemCode(String lossItemCode) {
		this.lossItemCode = lossItemCode;
	}
	public String getLossItemName() {
		return lossItemName;
	}
	public void setLossItemName(String lossItemName) {
		this.lossItemName = lossItemName;
	}
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getLogNo() {
		return logNo;
	}
	public void setLogNo(String logNo) {
		this.logNo = logNo;
	}
	

}
