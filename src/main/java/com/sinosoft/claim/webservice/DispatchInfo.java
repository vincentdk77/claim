package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;
/*
 * 调度信息表
*字段：调度时间、调度人员、调度意见、紧急程度（空）、地图信息（空）等
 */
public class DispatchInfo implements Serializable { 
//	调度时间、调度人员、调度意见、紧急程度（空）、地图信息（空）等
	/** 属性调度时间*/
	private String dispatchDate = "";
	/** 属性调度的代码 */
	private String handlerCode = "";
    /** 属性调度的名称 */
    private String handlerName = "";
    /** 属性处理信息 */
    private String checkInfo = "";
    /** 属性紧急程度（空） */
    private String emergencyLevel = "";
    /** 属性地图信息（空） */
    private String mapInfo="";
    
    
    public DispatchInfo() {
    }

	
	public String getDispatchDate() {
		return dispatchDate;
	}


	public void setDispatchDate(String dispatchDate) {
		this.dispatchDate = dispatchDate;
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
    
	/**
     * 设置属性处理信息
     * @param checkInfo 待设置的属性处理信息的值
     */
    public void setCheckInfo(String checkInfo){
        this.checkInfo = StringUtils.rightTrim(checkInfo);
    }
    
    /**
     * 获取属性处理信息
     * @return 属性处理信息的值
     */
    public String getCheckInfo(){
        return checkInfo;
    }

	public String getEmergencyLevel() {
		return emergencyLevel;
	}

	public void setEmergencyLevel(String emergencyLevel) {
		this.emergencyLevel = emergencyLevel;
	}

	public String getMapInfo() {
		return mapInfo;
	}

	public void setMapInfo(String mapInfo) {
		this.mapInfo = mapInfo;
	}
    
    


}
