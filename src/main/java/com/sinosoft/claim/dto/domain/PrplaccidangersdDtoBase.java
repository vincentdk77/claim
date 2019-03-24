package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLACCIDANGERSD的数据传输对象基类<br>
 */
public class PrplaccidangersdDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性出险人姓名 */
    private String insuredName = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性出险人性别 */
    private String gender = "";
    /** 属性出险人出生日期；YYYYMMDD */
    private String birthday = "";
    /** 属性出险人证件类型 */
    private String credentialType = "";
    /** 属性出险人证件号码 */
    private String credentialNo = "";
    /** 属性是否符合风险特征 */
    private String isRisk = "";
    /** 属性出险次数 */
    private int lossTimes = 0;
    /** 属性累计赔付金额 */
    private Double sumClaimAmount = 0.00;
    /** 属性拒赔次数 */
    private int refuseClaimTimes = 0;

    /**
     *  默认构造方法,构造一个默认的PrplaccidangersdDtoBase对象
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
