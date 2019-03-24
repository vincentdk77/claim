package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpCitemKindAgri�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpCitemKindAgriDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����PolicyNo */
    private String policyNo = "";
    /** ����RiskCode */
    private String riskCode = "";
    /** ����ItemKindNo */
    private long itemKindNo = 0L;
    /** ����UnitOutput */
    private double unitOutput = 0D;
    /** ����UnitCost */
    private double unitCost = 0D;
    /** ����PropoRation */
    private double propoRtion = 0D;
    /** ����DepreciAtionRate */
    private double depreciAtionRate = 0D;
    /** ����UnitAmount */
    private double unitAmount = 0D;
    /** ����GrossQuantity */
    private double grossQuantity = 0D;
    /** ����DiscountType */
    private String discountType = "";
    /** ����Flag */
    private String flag = "";
    /** ����Remark */
    private String remark = "";
    /** ����KindCode */
    private String kindCode = "";
    /** ��α���*/
    private double timesAmount ;
    /** ��α���*/
    private double distributingRate;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCitemKindAgriDtoBase����
     */
    public PrpCitemKindAgriDtoBase(){
    }

    /**
     * ��������PolicyNo
     * @param policyNo �����õ�����PolicyNo��ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����PolicyNo
     * @return ����PolicyNo��ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ��������RiskCode
     * @param riskCode �����õ�����RiskCode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����RiskCode
     * @return ����RiskCode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������ItemKindNo
     * @param itemKindNo �����õ�����ItemKindNo��ֵ
     */
    public void setItemKindNo(long itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * ��ȡ����ItemKindNo
     * @return ����ItemKindNo��ֵ
     */
    public long getItemKindNo(){
        return itemKindNo;
    }

    /**
     * ��������UnitOutput
     * @param unitOutput �����õ�����UnitOutput��ֵ
     */
    public void setUnitOutput(double unitOutput){
        this.unitOutput = unitOutput;
    }

    /**
     * ��ȡ����UnitOutput
     * @return ����UnitOutput��ֵ
     */
    public double getUnitOutput(){
        return unitOutput;
    }

    /**
     * ��������UnitCost
     * @param unitCost �����õ�����UnitCost��ֵ
     */
    public void setUnitCost(double unitCost){
        this.unitCost = unitCost;
    }

    /**
     * ��ȡ����UnitCost
     * @return ����UnitCost��ֵ
     */
    public double getUnitCost(){
        return unitCost;
    }

    /**
     * ��������PropoRation
     * @param propoRation �����õ�����PropoRation��ֵ
     */
    public void setPropoRtion(double propoRtion){
        this.propoRtion = propoRtion;
    }

    /**
     * ��ȡ����PropoRation
     * @return ����PropoRation��ֵ
     */
    public double getPropoRtion(){
        return propoRtion;
    }

    /**
     * ��������DepreciAtionRate
     * @param depreciAtionRate �����õ�����DepreciAtionRate��ֵ
     */
    public void setDepreciAtionRate(double depreciAtionRate){
        this.depreciAtionRate = depreciAtionRate;
    }

    /**
     * ��ȡ����DepreciAtionRate
     * @return ����DepreciAtionRate��ֵ
     */
    public double getDepreciAtionRate(){
        return depreciAtionRate;
    }

    /**
     * ��������UnitAmount
     * @param unitAmount �����õ�����UnitAmount��ֵ
     */
    public void setUnitAmount(double unitAmount){
        this.unitAmount = unitAmount;
    }

    /**
     * ��ȡ����UnitAmount
     * @return ����UnitAmount��ֵ
     */
    public double getUnitAmount(){
        return unitAmount;
    }

    /**
     * ��������GrossQuantity
     * @param grossQuantity �����õ�����GrossQuantity��ֵ
     */
    public void setGrossQuantity(double grossQuantity){
        this.grossQuantity = grossQuantity;
    }

    /**
     * ��ȡ����GrossQuantity
     * @return ����GrossQuantity��ֵ
     */
    public double getGrossQuantity(){
        return grossQuantity;
    }

    /**
     * ��������DiscountType
     * @param discountType �����õ�����DiscountType��ֵ
     */
    public void setDiscountType(String discountType){
        this.discountType = StringUtils.rightTrim(discountType);
    }

    /**
     * ��ȡ����DiscountType
     * @return ����DiscountType��ֵ
     */
    public String getDiscountType(){
        return discountType;
    }

    /**
     * ��������Flag
     * @param flag �����õ�����Flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����Flag
     * @return ����Flag��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * ��������Remark
     * @param remark �����õ�����Remark��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����Remark
     * @return ����Remark��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ��������KindCode
     * @param kindCode �����õ�����KindCode��ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ����KindCode
     * @return ����KindCode��ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

	public double getTimesAmount() {
		return timesAmount;
	}

	public void setTimesAmount(double timesAmount) {
		this.timesAmount = timesAmount;
	}

	public double getDistributingRate() {
		return distributingRate;
	}

	public void setDistributingRate(double distributingRate) {
		this.distributingRate = distributingRate;
	}

}
