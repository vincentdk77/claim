package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;

/**
 * �Զ���Σ�յ�λ��̯�������ݴ������
 * <p>
 * Title: Σ�յ�λ��̯����DTO
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
    //ҵ����Դ
    private  String     businessNature        ="";
    //����ҵ������
    private  String     policyBizType         ="";
    //Ͷ����ʽ
    private  String     policyType            ="";
    //�����Ա�ʶ
    private  String     businessType1         ="";
    //��ũ��ʶ
    private  String     businessType          ="";
    //��־�ֶ�
    private  String     othFlag               ="";
    //��������ʡ
    private  String     businessProvince      ="";
    //����������
    private  String     businessTown          ="";
    //����������
    private  String     businessCounty        ="";
    //������������
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
