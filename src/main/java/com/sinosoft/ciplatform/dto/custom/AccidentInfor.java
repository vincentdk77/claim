package com.sinosoft.ciplatform.dto.custom;

import java.util.Date;

public class AccidentInfor {
	private Date accidentTime;//����ʱ��
	private String accidentPlace="";//���յص�
	private String accidentDesc="";//���վ���
	private String accidentdep=""; //�¹ʴ�����
	private String indemnityDuty=""; //�¹�����
	private String handleUnit="";  //�¹ʴ�����
	private String damageTypeCode=""; //�¹�ԭ��
	private String addressCode=""; //�¹ʵص����
	private String manageTypeCode = "";//�¹ʴ�������
	private String accidentPlaceCode="";//���յص�Ψһ��ʶ
	
	//add by liuxin 20080516 start for ������ǿ����Ϣ��ӿڵ���
	private String damageAreaCode = "";   //�¹ʹܽ����
	//add by liuxin 20080516 end for ������ǿ����Ϣ��ӿڵ���
	
	public String getAddressCode() {
		return addressCode;
	}
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	public String getDamageTypeCode() {
		return damageTypeCode;
	}
	public void setDamageTypeCode(String damageTypeCode) {
		this.damageTypeCode = damageTypeCode;
	}
	public String getHandleUnit() {
		return handleUnit;
	}
	public void setHandleUnit(String handleUnit) {
		this.handleUnit = handleUnit;
	}
	public String getManageTypeCode() {
		return manageTypeCode;
	}
	public void setManageTypeCode(String manageTypeCode) {
		this.manageTypeCode = manageTypeCode;
	}
	/**
	 * �¹ʴ�����
	 * @return
	 */
	public String getAccidentdep() {
		return accidentdep;
	}
	public void setAccidentdep(String accidentdep) {
		this.accidentdep = accidentdep;
	}
	public String getAccidentDesc() {
		return accidentDesc;
	}
	public void setAccidentDesc(String accidentDesc) {
		this.accidentDesc = accidentDesc;
	}
	public String getAccidentPlace() {
		return accidentPlace;
	}
	public void setAccidentPlace(String accidentPlace) {
		this.accidentPlace = accidentPlace;
	}
	public Date getAccidentTime() {
		return accidentTime;
	}
	public void setAccidentTime(Date accidentTime) {
		this.accidentTime = accidentTime;
	}
	public String getIndemnityDuty() {
		return indemnityDuty;
	}
	public void setIndemnityDuty(String indemnityDuty) {
		this.indemnityDuty = indemnityDuty;
	}
	
    //add by liuxin 20080516 start for ������ǿ����Ϣ��ӿڵ���
	public String getDamageAreaCode() {
		return damageAreaCode;
	}
	public void setDamageAreaCode(String damageAreaCode) {
		this.damageAreaCode = damageAreaCode;
	}
	//add by liuxin 20080516 end for ������ǿ����Ϣ��ӿڵ���
	
	public String getAccidentPlaceCode() {
		return accidentPlaceCode;
	}
	public void setAccidentPlaceCode(String accidentPlaceCode) {
		this.accidentPlaceCode = accidentPlaceCode;
	}

	
}
