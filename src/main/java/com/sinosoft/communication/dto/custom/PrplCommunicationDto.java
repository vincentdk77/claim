package com.sinosoft.communication.dto.custom;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;

public class PrplCommunicationDto extends PrplCommunicationDtoBase implements
		Serializable {
	 private static final long serialVersionUID = 1L;

	 /** �б�*/ 
	 private Collection resultList ;
	 /** һҳ����*/
	 private TurnPageDto turnPageDto = null ;
	 
	 /** �����ֶ� ��ʾ����ͨ����ɫ */
	 private String color;
	 /** ����ʱ�� */
	 private String aboveTime;
	 /** �������� */
	 private String insuredName;
	 /**���ƺ��� ��ʾ��*/
	 private String licenseNo;
	 /** ��ʷ���ݼ��ݵ� ��� */
	 private String serialNo;
	 /** ��ʷ���ݼ��ݵ� �к� */
	 private String lineno;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplCommunicationDto����
     */
	 public PrplCommunicationDto(){}
	 /** �б�*/
	public Collection getResultList() {
		return resultList;
	}
	/** �б�*/
	public void setResultList(Collection resultList) {
		this.resultList = resultList;
	}
	 /** һҳ����*/
	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}
	 /** һҳ����*/
	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}
	/** �����ֶ� ��ʾ����ͨ����ɫ */
	public String getColor() {
		return color;
	}
	/** �����ֶ� ��ʾ����ͨ����ɫ */
	public void setColor(String color) {
		this.color = color;
	}
	/** ����ʱ�� */
	public String getAboveTime() {
		return aboveTime;
	}
	/** ����ʱ�� */
	public void setAboveTime(String aboveTime) {
		this.aboveTime = aboveTime;
	}
	/** �������� */
	public String getInsuredName() {
		return insuredName;
	}
	/** �������� */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	/**���ƺ��� ��ʾ��*/
	public String getLicenseNo() {
		return licenseNo;
	}
	/**���ƺ��� ��ʾ��*/
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	/** ��ʷ���ݼ��ݵ� ��� */
	public String getSerialNo() {
		return serialNo;
	}
	/** ��ʷ���ݼ��ݵ� ��� */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	/** ��ʷ���ݼ��ݵ� �к� */
	public String getLineno() {
		return lineno;
	}
	/** ��ʷ���ݼ��ݵ� �к� */
	public void setLineno(String lineno) {
		this.lineno = lineno;
	}
	
	 
}
