package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;

/**
 * 自定义危险单位分摊比例数据传输对象
 * <p>
 * Title: 危险单位分摊比例DTO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author lijiyuan
 * @version 1.0
 */

public class PrpDangerShareDto
{
	private int  dangerNo = 0;
	private double  dangerShare = 0;
    //业务来源
    private  String     businessNature        ="";
    //保单业务类型
    private  String     policyBizType         ="";
    //投保方式
    private  String     policyType            ="";
    //政策性标识
    private  String     businessType1         ="";
    //涉农标识
    private  String     businessType          ="";
    //标志字段
    private  String     othFlag               ="";
    //归属区域省
    private  String     businessProvince      ="";
    //归属区域市
    private  String     businessTown          ="";
    //归属区域县
    private  String     businessCounty        ="";
    //归属区域乡镇
    private  String     businessAreaName      ="";
	public int getDangerNo() {
		return dangerNo;
	}
	public void setDangerNo(int dangerNo) {
		this.dangerNo = dangerNo;
	}
	public double getDangerShare() {
		return dangerShare;
	}
	public void setDangerShare(double dangerShare) {
		this.dangerShare = dangerShare;
	}
	public String getBusinessNature() {
		return businessNature;
	}
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}
	public String getPolicyBizType() {
		return policyBizType;
	}
	public void setPolicyBizType(String policyBizType) {
		this.policyBizType = policyBizType;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public String getBusinessType1() {
		return businessType1;
	}
	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getOthFlag() {
		return othFlag;
	}
	public void setOthFlag(String othFlag) {
		this.othFlag = othFlag;
	}
	public String getBusinessProvince() {
		return businessProvince;
	}
	public void setBusinessProvince(String businessProvince) {
		this.businessProvince = businessProvince;
	}
	public String getBusinessTown() {
		return businessTown;
	}
	public void setBusinessTown(String businessTown) {
		this.businessTown = businessTown;
	}
	public String getBusinessCounty() {
		return businessCounty;
	}
	public void setBusinessCounty(String businessCounty) {
		this.businessCounty = businessCounty;
	}
	public String getBusinessAreaName() {
		return businessAreaName;
	}
	public void setBusinessAreaName(String businessAreaName) {
		this.businessAreaName = businessAreaName;
	}


}
