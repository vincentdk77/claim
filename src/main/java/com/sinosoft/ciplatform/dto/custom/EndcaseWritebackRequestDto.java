package com.sinosoft.ciplatform.dto.custom;

/**
 * �Զ���"�᰸��Ϣ��д����"���ݴ������
 * <p>Title: ��ǿ�ջ�������渶DTO</p>
 * <p>Description: ��ǿ�ջ�������渶����</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sinosoft&&Dbic</p>
 * @author zhangwei
 * @version 1.0
 */

public class EndcaseWritebackRequestDto {
	/** ���󹫹���Ϣ*/
	private PlatFormCrashParam platFormCrashParam = null;
	/** ���𷽱��չ�˾��������*/
	private String noDutyRegistNo = "";
		
    //add by lishengjun start
	private String ciPlatFormCode="";
	// add end
	
	public String getCiPlatFormCode() {
		return ciPlatFormCode;
	}

	public void setCiPlatFormCode(String ciPlatFormCode) {
		this.ciPlatFormCode = ciPlatFormCode;
	}

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
	 * ������𷽱��չ�˾��������
	 * @return ȫ�𷽱��չ�˾��������*/
	public String getNoDutyRegistNo() {
	  	return this.noDutyRegistNo;
	}
	  
	/**
	 * �������𷽱��չ�˾��������
	 * @param ȫ�𷽱��չ�˾��������*/
	public void setNoDutyRegistNo(String noDutyRegistNo) {
	  	this.noDutyRegistNo = noDutyRegistNo;
	}

}
