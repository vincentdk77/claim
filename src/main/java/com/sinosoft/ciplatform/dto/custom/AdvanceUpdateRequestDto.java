package com.sinosoft.ciplatform.dto.custom;

/**
 * �Զ���"�渶��Ϣ��д����"���ݴ������
 * <p>Title: ��ǿ�ջ�������渶DTO</p>
 * <p>Description: ��ǿ�ջ�������渶����</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sinosoft&&Dbic</p>
 * @author zhangwei
 * @version 1.0
 */

public class AdvanceUpdateRequestDto {
    /** ���󹫹���Ϣ*/
	private PlatFormCrashParam platFormCrashParam = null;
	/** ȫ�𷽱��չ�˾��������*/
	private String fullDutyRegistNo = "";
	// add by lishengjun start
	private String ciPlatFormCode="";
	
	// add end
	/**
	 * ������󹫹���Ϣ
	 * @return ���󹫹���Ϣ*/
	public PlatFormCrashParam getPlatFormCrashParam() {
	  	return this.platFormCrashParam;
	}
	  
	/**
	 * �������󹫹���Ϣ
	 * @param ���󹫹���Ϣ*/
	public void setPlatFormCrashParam(PlatFormCrashParam platFormCrashParam) {
	  	this.platFormCrashParam = platFormCrashParam;
	}
	
	/**
	 * ���ȫ�𷽱��չ�˾��������
	 * @return ȫ�𷽱��չ�˾��������*/
	public String getFullDutyRegistNo() {
	  	return this.fullDutyRegistNo;
	}
	  
	/**
	 * ����ȫ�𷽱��չ�˾��������
	 * @param ȫ�𷽱��չ�˾��������*/
	public void setFullDutyRegistNo(String fullDutyRegistNo) {
	  	this.fullDutyRegistNo = fullDutyRegistNo;
	}

	public String getCiPlatFormCode() {
		return ciPlatFormCode;
	}

	public void setCiPlatFormCode(String ciPlatFormCode) {
		this.ciPlatFormCode = ciPlatFormCode;
	}
	
	
}
