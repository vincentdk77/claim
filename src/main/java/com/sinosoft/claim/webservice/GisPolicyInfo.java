package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

public class GisPolicyInfo implements Serializable {
	/** ����Ͷ�������� */
	private String proposalNo = "";
	/** ���Ա������� */
	private String policyNo = "";
	/** �������ִ��� */
	private String riskCode = "";
	/** ������������ */
	private String riskName = "";
	/** ����Ͷ���˴��� */
	private String appliCode = "";
	/** ����Ͷ�������� */
	private String appliName = "";
	/** ����Ͷ���˵�ַ */
	private String appliAddress = "";
	/** ���Ա������˴��� */
	private String insuredCode = "";
	/** ���Ա����������� */
	private String insuredName = "";
	/** ���������Է������� */
	private String businessType1Name = "";
	/** ����ǩ������ */
	private Date operateDate = new Date();
	/** ���������� */
	private Date startDate = new Date();
	/** �����ձ����� */
	private Date endDate = new Date();
	/** �����ձ�Сʱ */
	private int endHour = 0;
	/** ���Ծ����� */
	private double pureRate = 0.0;
	/** ���������ѱ��� */
	private double disRate = 0.0;
	/** �������ۿ��� */
	private double disCount = 0.0;
	/** ���Աұ���� */
	private String currency = "";
	/** �����ܱ��ռ�ֵ */
	private double sumValue = 0.0;
	/** �������ۿ۽�� */
	private double sumDiscount = 0.0;
	/** �����ܱ��ս�� */
	private double sumAmount = 0.0;
	/** �����ܱ��շ� */
	private double sumPremium = 0.0;
	/** �����ܸ����ձ��� */
	private double sumSubPrem = 0.0;
	/** ���Ա����ջ��� */
	private int sumQuantity = 0;
	/** �������Ĵ��� */
	private int endorseTimes = 0;
	/** ����������� */
	private int claimTimes = 0;
	/** ���Գ����������� */
	private String makeComName = "";
	/** ����ҵ������������� */
	private String comName = "";
	/** �������պ˱��˴��� */
	private String underWriteCode = "";
	/** �������պ˱������� */
	private String underWriteName = "";
	/** ���Բ���Ա���� */
	private String operatorCode = "";
	/** ���Բ���Ա���� */
	private String operatorName = "";
	/** ���Լ�����䵥���� */
	private Date inputDate = new Date();
	/** ���Լ�����䵥Сʱ */
	private int inputHour = 0;
	/** ���Ժ˱�������� */
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
