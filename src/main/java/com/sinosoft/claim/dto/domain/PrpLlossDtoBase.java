package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLloss���⸶�����Ϣ������ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLlossDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ������������� */
    private String compensateNo = "";
    /** �������� */
    private String riskCode = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** �����⸶������ */
    private int serialNo = 0;
    /** ���Ա������������� */
    private int itemKindNo = 0;
    /** ���Էֻ����(�����ڼ���Ҳ���) */
    private int familyNo = 0;
    /** ���Էֻ�����(�����ڼ���Ҳ���) */
    private String familyName = "";
    /** ���Գб��ձ���� */
    private String kindCode = "";
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** ���Ա����Ŀ������ */
    private String itemCode = "";
    /** �������������� */
    private String lossName = "";
    /** ���������ĵ�ַ */
    private String itemAddress = "";
    /** ���Է�����ϸ������ */
    private String feeTypeCode = "";
    /** ���Է�����ϸ��� */
    private String feeTypeName = "";
    /** �������������� */
    private double lossQuantity = 0D;
    /** ����������λ */
    private String unit = "";
    /** ���Ե��� */
    private double unitPrice = 0D;
    /** ���Թ������� */
    private DateTime buyDate = new DateTime();
    /** �������۾��� */
    private double depreRate = 0D;
    /** ���Աұ� */
    private String currency = "";
    /** ���Ա��ս�� */
    private double amount = 0D;
    /** ���Ա�ļ�ֵ�ұ� */
    private String currency1 = "";
    /** ���Ա�ļ�ֵ */
    private double itemValue = 0D;
    /** ����������ұ� */
    private String currency2 = "";
    /** ���������� */
    private double sumLoss = 0D;
    /** �����޳����/��ֵ/���� */
    private double sumRest = 0D;
    /** �������α��� */
    private double indemnityDutyRate = 0D;
    /** �����⸶���� */
    private double claimRate = 0D;
    /** ���������ұ� */
    private String currency3 = "";
    /** ���������� */
    private double deductibleRate = 0D;
    /** ��������� */
    private double deductible = 0D;
    /** ����ʵ��ұ� */
    private String currency4 = "";
    /** ����ʵ���� */
    private double sumRealPay = 0D;
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** �����޳�ԭ�� */
    private String rejectReason = "";
    /** �����¹����������� */
    private double dutyDeductibleRate = 0D;
    /** ���Լ�ʻԱ������ */
    private double driverDeductibleRate = 0D;
    /** ���Ա�ע */
    private String remark = "";
    /** ����Э�̱��� */
    private double arrangeRate = 0D;
    /** ���Ժ˶��⳥ */
    private double sumDefPay = 0D;
    /** �⸶��� */
    private double settleArea = 0D;
    /** ��ʧ�� */
    private double lossrate = 0D;
    /** ���������ͺ� */
    private String BrandCode ="";
    /** ����ҵ�����⸶�����ҷ��������������� */
    private double coinsSumRealPaid = 0d ; 
    
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLlossDtoBase����
     */
    public PrpLlossDtoBase(){
    }

    /**
     * �����������������
     * @param compensateNo �����õ�������������ŵ�ֵ
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * ��ȡ�������������
     * @return ������������ŵ�ֵ
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * ������������
     * @param riskCode �����õ��������ֵ�ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ��������
     * @return �������ֵ�ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * �������Ա�����
     * @param policyNo �����õ����Ա����ŵ�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ���������⸶������
     * @param serialNo �����õ������⸶�����ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�����⸶������
     * @return �����⸶�����ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Ա�������������
     * @param itemKindNo �����õ����Ա������������ŵ�ֵ
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * ��ȡ���Ա�������������
     * @return ���Ա������������ŵ�ֵ
     */
    public int getItemKindNo(){
        return itemKindNo;
    }

    /**
     * �������Էֻ����(�����ڼ���Ҳ���)
     * @param familyNo �����õ����Էֻ����(�����ڼ���Ҳ���)��ֵ
     */
    public void setFamilyNo(int familyNo){
        this.familyNo = familyNo;
    }

    /**
     * ��ȡ���Էֻ����(�����ڼ���Ҳ���)
     * @return ���Էֻ����(�����ڼ���Ҳ���)��ֵ
     */
    public int getFamilyNo(){
        return familyNo;
    }

    /**
     * �������Էֻ�����(�����ڼ���Ҳ���)
     * @param familyName �����õ����Էֻ�����(�����ڼ���Ҳ���)��ֵ
     */
    public void setFamilyName(String familyName){
        this.familyName = StringUtils.rightTrim(familyName);
    }

    /**
     * ��ȡ���Էֻ�����(�����ڼ���Ҳ���)
     * @return ���Էֻ�����(�����ڼ���Ҳ���)��ֵ
     */
    public String getFamilyName(){
        return familyName;
    }

    /**
     * �������Գб��ձ����
     * @param kindCode �����õ����Գб��ձ�����ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ���Գб��ձ����
     * @return ���Գб��ձ�����ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * �������Գ��ƺ���
     * @param licenseNo �����õ����Գ��ƺ����ֵ
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ���Գ��ƺ���
     * @return ���Գ��ƺ����ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * �������Ա����Ŀ������
     * @param itemCode �����õ����Ա����Ŀ�������ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ���Ա����Ŀ������
     * @return ���Ա����Ŀ�������ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * ������������������
     * @param lossName �����õ��������������Ƶ�ֵ
     */
    public void setLossName(String lossName){
        this.lossName = StringUtils.rightTrim(lossName);
    }

    /**
     * ��ȡ��������������
     * @return �������������Ƶ�ֵ
     */
    public String getLossName(){
        return lossName;
    }

    /**
     * �������������ĵ�ַ
     * @param itemAddress �����õ����������ĵ�ַ��ֵ
     */
    public void setItemAddress(String itemAddress){
        this.itemAddress = StringUtils.rightTrim(itemAddress);
    }

    /**
     * ��ȡ���������ĵ�ַ
     * @return ���������ĵ�ַ��ֵ
     */
    public String getItemAddress(){
        return itemAddress;
    }

    /**
     * �������Է�����ϸ������
     * @param feeTypeCode �����õ����Է�����ϸ�������ֵ
     */
    public void setFeeTypeCode(String feeTypeCode){
        this.feeTypeCode = StringUtils.rightTrim(feeTypeCode);
    }

    /**
     * ��ȡ���Է�����ϸ������
     * @return ���Է�����ϸ�������ֵ
     */
    public String getFeeTypeCode(){
        return feeTypeCode;
    }

    /**
     * �������Է�����ϸ���
     * @param feeTypeName �����õ����Է�����ϸ����ֵ
     */
    public void setFeeTypeName(String feeTypeName){
        this.feeTypeName = StringUtils.rightTrim(feeTypeName);
    }

    /**
     * ��ȡ���Է�����ϸ���
     * @return ���Է�����ϸ����ֵ
     */
    public String getFeeTypeName(){
        return feeTypeName;
    }

    /**
     * ������������������
     * @param lossQuantity �����õ�����������������ֵ
     */
    public void setLossQuantity(double lossQuantity){
        this.lossQuantity = lossQuantity;
    }

    /**
     * ��ȡ��������������
     * @return ����������������ֵ
     */
    public double getLossQuantity(){
        return lossQuantity;
    }

    /**
     * ��������������λ
     * @param unit �����õ�����������λ��ֵ
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * ��ȡ����������λ
     * @return ����������λ��ֵ
     */
    public String getUnit(){
        return unit;
    }

    /**
     * �������Ե���
     * @param unitPrice �����õ����Ե��۵�ֵ
     */
    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }

    /**
     * ��ȡ���Ե���
     * @return ���Ե��۵�ֵ
     */
    public double getUnitPrice(){
        return unitPrice;
    }

    /**
     * �������Թ�������
     * @param buyDate �����õ����Թ������ڵ�ֵ
     */
    public void setBuyDate(DateTime buyDate){
        this.buyDate = buyDate;
    }

    /**
     * ��ȡ���Թ�������
     * @return ���Թ������ڵ�ֵ
     */
    public DateTime getBuyDate(){
        return buyDate;
    }

    /**
     * �����������۾���
     * @param depreRate �����õ��������۾��ʵ�ֵ
     */
    public void setDepreRate(double depreRate){
        this.depreRate = depreRate;
    }

    /**
     * ��ȡ�������۾���
     * @return �������۾��ʵ�ֵ
     */
    public double getDepreRate(){
        return depreRate;
    }

    /**
     * �������Աұ�
     * @param currency �����õ����Աұ��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ�
     * @return ���Աұ��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * �������Ա��ս��
     * @param amount �����õ����Ա��ս���ֵ
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * ��ȡ���Ա��ս��
     * @return ���Ա��ս���ֵ
     */
    public double getAmount(){
        return amount;
    }

    /**
     * �������Ա�ļ�ֵ�ұ�
     * @param currency1 �����õ����Ա�ļ�ֵ�ұ��ֵ
     */
    public void setCurrency1(String currency1){
        this.currency1 = StringUtils.rightTrim(currency1);
    }

    /**
     * ��ȡ���Ա�ļ�ֵ�ұ�
     * @return ���Ա�ļ�ֵ�ұ��ֵ
     */
    public String getCurrency1(){
        return currency1;
    }

    /**
     * �������Ա�ļ�ֵ
     * @param itemValue �����õ����Ա�ļ�ֵ��ֵ
     */
    public void setItemValue(double itemValue){
        this.itemValue = itemValue;
    }

    /**
     * ��ȡ���Ա�ļ�ֵ
     * @return ���Ա�ļ�ֵ��ֵ
     */
    public double getItemValue(){
        return itemValue;
    }

    /**
     * ��������������ұ�
     * @param currency2 �����õ�����������ұ��ֵ
     */
    public void setCurrency2(String currency2){
        this.currency2 = StringUtils.rightTrim(currency2);
    }

    /**
     * ��ȡ����������ұ�
     * @return ����������ұ��ֵ
     */
    public String getCurrency2(){
        return currency2;
    }

    /**
     * ��������������
     * @param sumLoss �����õ������������ֵ
     */
    public void setSumLoss(double sumLoss){
        this.sumLoss = sumLoss;
    }

    /**
     * ��ȡ����������
     * @return �����������ֵ
     */
    public double getSumLoss(){
        return sumLoss;
    }

    /**
     * ���������޳����/��ֵ/����
     * @param sumRest �����õ������޳����/��ֵ/�����ֵ
     */
    public void setSumRest(double sumRest){
        this.sumRest = sumRest;
    }

    /**
     * ��ȡ�����޳����/��ֵ/����
     * @return �����޳����/��ֵ/�����ֵ
     */
    public double getSumRest(){
        return sumRest;
    }

    /**
     * �����������α���
     * @param indemnityDutyRate �����õ��������α�����ֵ
     */
    public void setIndemnityDutyRate(double indemnityDutyRate){
        this.indemnityDutyRate = indemnityDutyRate;
    }

    /**
     * ��ȡ�������α���
     * @return �������α�����ֵ
     */
    public double getIndemnityDutyRate(){
        return indemnityDutyRate;
    }

    /**
     * ���������⸶����
     * @param claimRate �����õ������⸶������ֵ
     */
    public void setClaimRate(double claimRate){
        this.claimRate = claimRate;
    }

    /**
     * ��ȡ�����⸶����
     * @return �����⸶������ֵ
     */
    public double getClaimRate(){
        return claimRate;
    }

    /**
     * �������������ұ�
     * @param currency3 �����õ����������ұ��ֵ
     */
    public void setCurrency3(String currency3){
        this.currency3 = StringUtils.rightTrim(currency3);
    }

    /**
     * ��ȡ���������ұ�
     * @return ���������ұ��ֵ
     */
    public String getCurrency3(){
        return currency3;
    }

    /**
     * ��������������
     * @param deductibleRate �����õ����������ʵ�ֵ
     */
    public void setDeductibleRate(double deductibleRate){
        this.deductibleRate = deductibleRate;
    }

    /**
     * ��ȡ����������
     * @return ���������ʵ�ֵ
     */
    public double getDeductibleRate(){
        return deductibleRate;
    }

    /**
     * �������������
     * @param deductible �����õ�����������ֵ
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * ��ȡ���������
     * @return ����������ֵ
     */
    public double getDeductible(){
        return deductible;
    }

    /**
     * ��������ʵ��ұ�
     * @param currency4 �����õ�����ʵ��ұ��ֵ
     */
    public void setCurrency4(String currency4){
        this.currency4 = StringUtils.rightTrim(currency4);
    }

    /**
     * ��ȡ����ʵ��ұ�
     * @return ����ʵ��ұ��ֵ
     */
    public String getCurrency4(){
        return currency4;
    }

    /**
     * ��������ʵ����
     * @param sumRealPay �����õ�����ʵ�����ֵ
     */
    public void setSumRealPay(double sumRealPay){
        this.sumRealPay = sumRealPay;
    }

    /**
     * ��ȡ����ʵ����
     * @return ����ʵ�����ֵ
     */
    public double getSumRealPay(){
        return sumRealPay;
    }

    /**
     * �������Ա�־�ֶ�
     * @param flag �����õ����Ա�־�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
     * @return ���Ա�־�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * ���������޳�ԭ��
     * @param rejectReason �����õ������޳�ԭ���ֵ
     */
    public void setRejectReason(String rejectReason){
        this.rejectReason = StringUtils.rightTrim(rejectReason);
    }

    /**
     * ��ȡ�����޳�ԭ��
     * @return �����޳�ԭ���ֵ
     */
    public String getRejectReason(){
        return rejectReason;
    }

    /**
     * ���������¹�����������
     * @param dutyDeductibleRate �����õ������¹����������ʵ�ֵ
     */
    public void setDutyDeductibleRate(double dutyDeductibleRate){
        this.dutyDeductibleRate = dutyDeductibleRate;
    }

    /**
     * ��ȡ�����¹�����������
     * @return �����¹����������ʵ�ֵ
     */
    public double getDutyDeductibleRate(){
        return dutyDeductibleRate;
    }

    /**
     * �������Լ�ʻԱ������
     * @param driverDeductibleRate �����õ����Լ�ʻԱ�����ʵ�ֵ
     */
    public void setDriverDeductibleRate(double driverDeductibleRate){
        this.driverDeductibleRate = driverDeductibleRate;
    }

    /**
     * ��ȡ���Լ�ʻԱ������
     * @return ���Լ�ʻԱ�����ʵ�ֵ
     */
    public double getDriverDeductibleRate(){
        return driverDeductibleRate;
    }

    /**
     * �������Ա�ע
     * @param remark �����õ����Ա�ע��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Ա�ע
     * @return ���Ա�ע��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ��������Э�̱���
     * @param arrangeRate �����õ�����Э�̱�����ֵ
     */
    public void setArrangeRate(double arrangeRate){
        this.arrangeRate = arrangeRate;
    }

    /**
     * ��ȡ����Э�̱���
     * @return ����Э�̱�����ֵ
     */
    public double getArrangeRate(){
        return arrangeRate;
    }

    /**
     * �������Ժ˶��⳥
     * @param sumDefPay �����õ����Ժ˶��⳥��ֵ
     */
    public void setSumDefPay(double sumDefPay){
        this.sumDefPay = sumDefPay;
    }

    /**
     * ��ȡ���Ժ˶��⳥
     * @return ���Ժ˶��⳥��ֵ
     */
    public double getSumDefPay(){
        return sumDefPay;
    }

	/**
	 * @return the settleArea
	 */
	public double getSettleArea() {
		return settleArea;
	}

	/**
	 * @param settleArea the settleArea to set
	 */
	public void setSettleArea(double settleArea) {
		this.settleArea = settleArea;
	}

	/**
	 * @return the lossrate
	 */
	public double getLossrate() {
		return lossrate;
	}

	/**
	 * @param lossrate the lossrate to set
	 */
	public void setLossrate(double lossrate) {
		this.lossrate = lossrate;
	}

	public String getBrandCode() {
		return StringUtils.rightTrim(BrandCode);
	}

	public void setBrandCode(String brandCode) {
		BrandCode = StringUtils.rightTrim(brandCode);
	}

	public double getCoinsSumRealPaid() {
		return coinsSumRealPaid;
	}

	public void setCoinsSumRealPaid(double coinsSumRealPaid) {
		this.coinsSumRealPaid = coinsSumRealPaid;
	}
	
	
}
