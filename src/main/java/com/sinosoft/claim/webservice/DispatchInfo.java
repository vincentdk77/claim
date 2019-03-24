package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;
/*
 * ������Ϣ��
*�ֶΣ�����ʱ�䡢������Ա����������������̶ȣ��գ�����ͼ��Ϣ���գ���
 */
public class DispatchInfo implements Serializable { 
//	����ʱ�䡢������Ա����������������̶ȣ��գ�����ͼ��Ϣ���գ���
	/** ���Ե���ʱ��*/
	private String dispatchDate = "";
	/** ���Ե��ȵĴ��� */
	private String handlerCode = "";
    /** ���Ե��ȵ����� */
    private String handlerName = "";
    /** ���Դ�����Ϣ */
    private String checkInfo = "";
    /** ���Խ����̶ȣ��գ� */
    private String emergencyLevel = "";
    /** ���Ե�ͼ��Ϣ���գ� */
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
     * �������Դ�����Ϣ
     * @param checkInfo �����õ����Դ�����Ϣ��ֵ
     */
    public void setCheckInfo(String checkInfo){
        this.checkInfo = StringUtils.rightTrim(checkInfo);
    }
    
    /**
     * ��ȡ���Դ�����Ϣ
     * @return ���Դ�����Ϣ��ֵ
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
