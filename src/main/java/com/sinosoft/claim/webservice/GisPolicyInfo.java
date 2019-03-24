package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

public class GisPolicyInfo implements Serializable {
	/** 属性投保单号码 */
	private String proposalNo = "";
	/** 属性保单号码 */
	private String policyNo = "";
	/** 属性险种代码 */
	private String riskCode = "";
	/** 属性险种名称 */
	private String riskName = "";
	/** 属性投保人代码 */
	private String appliCode = "";
	/** 属性投保人名称 */
	private String appliName = "";
	/** 属性投保人地址 */
	private String appliAddress = "";
	/** 属性被保险人代码 */
	private String insuredCode = "";
	/** 属性被保险人名称 */
	private String insuredName = "";
	/** 属性政策性分类名称 */
	private String businessType1Name = "";
	/** 属性签单日期 */
	private Date operateDate = new Date();
	/** 属性起保日期 */
	private Date startDate = new Date();
	/** 属性终保日期 */
	private Date endDate = new Date();
	/** 属性终保小时 */
	private int endHour = 0;
	/** 属性净费率 */
	private double pureRate = 0.0;
	/** 属性手续费比例 */
	private double disRate = 0.0;
	/** 属性总折扣率 */
	private double disCount = 0.0;
	/** 属性币别代码 */
	private String currency = "";
	/** 属性总保险价值 */
	private double sumValue = 0.0;
	/** 属性总折扣金额 */
	private double sumDiscount = 0.0;
	/** 属性总保险金额 */
	private double sumAmount = 0.0;
	/** 属性总保险费 */
	private double sumPremium = 0.0;
	/** 属性总附加险保费 */
	private double sumSubPrem = 0.0;
	/** 属性被保险户数 */
	private int sumQuantity = 0;
	/** 属性批改次数 */
	private int endorseTimes = 0;
	/** 属性理赔次数 */
	private int claimTimes = 0;
	/** 属性出单机构名称 */
	private String makeComName = "";
	/** 属性业务归属机构名称 */
	private String comName = "";
	/** 属性最终核保人代码 */
	private String underWriteCode = "";
	/** 属性最终核保人名称 */
	private String underWriteName = "";
	/** 属性操作员代码 */
	private String operatorCode = "";
	/** 属性操作员名称 */
	private String operatorName = "";
	/** 属性计算机输单日期 */
	private Date inputDate = new Date();
	/** 属性计算机输单小时 */
	private int inputHour = 0;
	/** 属性核保完成日期 */
	private Date underWriteEndDate = new Date();

	public GisPolicyInfo() {
		
	}

	public String getProposalNo() {
		return proposalNo;
	}

	public void setProposalNo(String proposalNo) {
		if (null != proposalNo) {
			this.proposalNo = proposalNo;
		}
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		if (null != policyNo) {
			this.policyNo = policyNo;
		}
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		if (null != riskCode) {
			this.riskCode = riskCode;
		}
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		if (null != riskName) {
			this.riskName = riskName;
		}
	}

	public String getAppliCode() {
		return appliCode;
	}

	public void setAppliCode(String appliCode) {
		if (null != appliCode) {
			this.appliCode = appliCode;
		}
	}

	public String getAppliName() {
		return appliName;
	}

	public void setAppliName(String appliName) {
		if (null != appliName) {
			this.appliName = appliName;
		}
	}

	public String getAppliAddress() {
		return appliAddress;
	}

	public void setAppliAddress(String appliAddress) {
		if (null != appliAddress) {
			this.appliAddress = appliAddress;
		}
	}

	public String getInsuredCode() {
		return insuredCode;
	}

	public void setInsuredCode(String insuredCode) {
		if (null != insuredCode) {
			this.insuredCode = insuredCode;
		}
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		if (null != insuredName) {
			this.insuredName = insuredName;
		}
	}

	public String getBusinessType1Name() {
		return businessType1Name;
	}

	public void setBusinessType1Name(String businessType1Name) {
		if (null != businessType1Name) {
			this.businessType1Name = businessType1Name;
		}
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		if (null != operateDate) {
			this.operateDate = operateDate;
		}
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		if (null != startDate) {
			this.startDate = startDate;
		}
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		if (null != endDate) {
			this.endDate = endDate;
		}
	}

	public int getEndHour() {
		return endHour;
	}

	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}

	public double getPureRate() {
		return pureRate;
	}

	public void setPureRate(double pureRate) {
		this.pureRate = pureRate;
	}

	public double getDisRate() {
		return disRate;
	}

	public void setDisRate(double disRate) {
		this.disRate = disRate;
	}

	public double getDisCount() {
		return disCount;
	}

	public void setDisCount(double disCount) {
		this.disCount = disCount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		if (null != currency) {
			this.currency = currency;
		}
	}

	public double getSumValue() {
		return sumValue;
	}

	public void setSumValue(double sumValue) {
		this.sumValue = sumValue;
	}

	public double getSumDiscount() {
		return sumDiscount;
	}

	public void setSumDiscount(double sumDiscount) {
		this.sumDiscount = sumDiscount;
	}

	public double getSumAmount() {
		return sumAmount;
	}

	public void setSumAmount(double sumAmount) {
		this.sumAmount = sumAmount;
	}

	public double getSumPremium() {
		return sumPremium;
	}

	public void setSumPremium(double sumPremium) {
		this.sumPremium = sumPremium;
	}

	public double getSumSubPrem() {
		return sumSubPrem;
	}

	public void setSumSubPrem(double sumSubPrem) {
		this.sumSubPrem = sumSubPrem;
	}

	public int getSumQuantity() {
		return sumQuantity;
	}

	public void setSumQuantity(int sumQuantity) {
		this.sumQuantity = sumQuantity;
	}

	public int getEndorseTimes() {
		return endorseTimes;
	}

	public void setEndorseTimes(int endorseTimes) {
		this.endorseTimes = endorseTimes;
	}

	public int getClaimTimes() {
		return claimTimes;
	}

	public void setClaimTimes(int claimTimes) {
		this.claimTimes = claimTimes;
	}

	public String getMakeComName() {
		return makeComName;
	}

	public void setMakeComName(String makeComName) {
		if (null != makeComName) {
			this.makeComName = makeComName;
		}
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		if (null != comName) {
			this.comName = comName;
		}
	}

	public String getUnderWriteCode() {
		return underWriteCode;
	}

	public void setUnderWriteCode(String underWriteCode) {
		if (null != underWriteCode) {
			this.underWriteCode = underWriteCode;
		}
	}

	public String getUnderWriteName() {
		return underWriteName;
	}

	public void setUnderWriteName(String underWriteName) {
		if (null != underWriteName) {
			this.underWriteName = underWriteName;
		}
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		if (null != operatorCode) {
			this.operatorCode = operatorCode;
		}
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		if (null != operatorName) {
			this.operatorName = operatorName;
		}
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		if (null != inputDate) {
			this.inputDate = inputDate;
		}
	}

	public int getInputHour() {
		return inputHour;
	}

	public void setInputHour(int inputHour) {
		this.inputHour = inputHour;
	}

	public Date getUnderWriteEndDate() {
		return underWriteEndDate;
	}

	public void setUnderWriteEndDate(Date underWriteEndDate) {
		if (null != underWriteEndDate) {
			this.underWriteEndDate = underWriteEndDate;
		}
	}

}
