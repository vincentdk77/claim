package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLACCIDANGERSD�����ݴ���������<br>
 */
public class PrplaccidangersdDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ���Գ��������� */
    private String insuredName = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Գ������Ա� */
    private String gender = "";
    /** ���Գ����˳������ڣ�YYYYMMDD */
    private String birthday = "";
    /** ���Գ�����֤������ */
    private String credentialType = "";
    /** ���Գ�����֤������ */
    private String credentialNo = "";
    /** �����Ƿ���Ϸ������� */
    private String isRisk = "";
    /** ���Գ��մ��� */
    private int lossTimes = 0;
    /** �����ۼ��⸶��� */
    private Double sumClaimAmount = 0.00;
    /** ���Ծ������ */
    private int refuseClaimTimes = 0;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplaccidangersdDtoBase����
     */
    public PrplaccidangersdDtoBase(){
    }

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCredentialType() {
		return credentialType;
	}

	public void setCredentialType(String credentialType) {
		this.credentialType = credentialType;
	}

	public String getCredentialNo() {
		return credentialNo;
	}

	public void setCredentialNo(String credentialNo) {
		this.credentialNo = credentialNo;
	}

	public String getIsRisk() {
		return isRisk;
	}

	public void setIsRisk(String isRisk) {
		this.isRisk = isRisk;
	}

	public int getLossTimes() {
		return lossTimes;
	}

	public void setLossTimes(int lossTimes) {
		this.lossTimes = lossTimes;
	}

	public Double getSumClaimAmount() {
		return sumClaimAmount;
	}

	public void setSumClaimAmount(Double sumClaimAmount) {
		this.sumClaimAmount = sumClaimAmount;
	}

	public int getRefuseClaimTimes() {
		return refuseClaimTimes;
	}

	public void setRefuseClaimTimes(int refuseClaimTimes) {
		this.refuseClaimTimes = refuseClaimTimes;
	}
}
