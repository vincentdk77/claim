package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;

public class PropLoss {
	private String propDesc = "";
	private double sumLoss;
	private double sumDuty;
	private double lossQuantity;
	
	private String esimateName = "";
	private String assesorName = "";
	
	private String esimateStartTime = "" ;		     //定损开始时间
	private String esimateEndTime = "";			 //定损结束时间
	private String assesorStartTime = "" ;		     //核损开始时间
	private String assesorEndTime = "";			 //核损结束时间
	
	public String getPropDesc() {
		return propDesc;
	}
	public void setPropDesc(String propDesc) {
		this.propDesc = propDesc;
	}
	public double getSumLoss() {
		return sumLoss;
	}
	public void setSumLoss(double sumLoss) {
		this.sumLoss = sumLoss;
	}
	public double getSumDuty() {
		return sumDuty;
	}
	public void setSumDuty(double sumDuty) {
		this.sumDuty = sumDuty;
	}
	public double getLossQuantity() {
		return lossQuantity;
	}
	public void setLossQuantity(double lossQuantity) {
		this.lossQuantity = lossQuantity;
	}
	public String getEsimateName() {
		return esimateName;
	}
	public void setEsimateName(String esimateName) {
		this.esimateName = esimateName;
	}
	public String getAssesorName() {
		return assesorName;
	}
	public void setAssesorName(String assesorName) {
		this.assesorName = assesorName;
	}
	public String getEsimateStartTime() {
		return esimateStartTime;
	}
	public void setEsimateStartTime(String esimateStartTime) {
		this.esimateStartTime = esimateStartTime;
	}
	public String getEsimateEndTime() {
		return esimateEndTime;
	}
	public void setEsimateEndTime(String esimateEndTime) {
		this.esimateEndTime = esimateEndTime;
	}
	public String getAssesorStartTime() {
		return assesorStartTime;
	}
	public void setAssesorStartTime(String assesorStartTime) {
		this.assesorStartTime = assesorStartTime;
	}
	public String getAssesorEndTime() {
		return assesorEndTime;
	}
	public void setAssesorEndTime(String assesorEndTime) {
		this.assesorEndTime = assesorEndTime;
	}	
	
	
}
