package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLclaimLoss�������ձ�����������ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLclaimLossDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ���������� */
    private String claimNo = "";
    /** �������� */
    private String riskCode = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Ա��������� */
    private int itemKindNo = 0;
    /** �����ձ���� */
    private String kindCode = "";
    /** ���Ա��������Ŀ���� */
    private String itemCode = "";
    /** ���Աұ� */
    private String currency = "";
    /** ���Թ����� */
    private double sumClaim = 0D;
    /** ������������ */
    private DateTime inputDate = new DateTime();
    /** ���Ա�ע */
    private String remarkFlag = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** ����Ҫ�ֱܷ������ֱ��������� */
    private String lossFeeType = "";
    /** ���Ա����Ŀ��ϸ���� */
    private String itemDetailName = "";
    /** ���Է��÷�Χ */
    private String feeCategory = "";
    /** �����ձ���ʧ */
    private double kindLoss = 0D;
    /** �����ձ��ֵ */
    private double kindRest = 0D;
    /** ���Ծ��������� */
    private double deductibleRate = 0D;
    /** ���Ծ�������� */
    private double deductible = 0D;
    /** �����¹����������� */
    private double acciDeductibleRate = 0D;
    /** ���Էֻ��� */
    private int familyNo = 0;
    /** ������ϱ��շֻ��� */
    private String familyNoZH = "";
    /** ���Էֻ����� */
    private String familyName = "";
    /** ���Գ������ ���г�����������ʹ�� */
    private String licenseNo = "";
    /** �����⸶���� */
    private String claimNumber = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLclaimLossDtoBase����
     */
    public PrpLclaimLossDtoBase(){
    }

    /**
     * ��������������
     * @param claimNo �����õ����������ŵ�ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ����������
     * @return ���������ŵ�ֵ
     */
    public String getClaimNo(){
        return claimNo;
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
     * �����������
     * @param serialNo �����õ�������ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Ա���������
     * @param itemKindNo �����õ����Ա��������ŵ�ֵ
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * ��ȡ���Ա���������
     * @return ���Ա��������ŵ�ֵ
     */
    public int getItemKindNo(){
        return itemKindNo;
    }

    /**
     * ���������ձ����
     * @param kindCode �����õ������ձ�����ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ�����ձ����
     * @return �����ձ�����ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * �������Ա��������Ŀ����
     * @param itemCode �����õ����Ա��������Ŀ�����ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ���Ա��������Ŀ����
     * @return ���Ա��������Ŀ�����ֵ
     */
    public String getItemCode(){
        return itemCode;
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
     * �������Թ�����
     * @param sumClaim �����õ����Թ������ֵ
     */
    public void setSumClaim(double sumClaim){
        this.sumClaim = sumClaim;
    }

    /**
     * ��ȡ���Թ�����
     * @return ���Թ������ֵ
     */
    public double getSumClaim(){
        return sumClaim;
    }

    /**
     * ����������������
     * @param inputDate �����õ������������ڵ�ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * �������Ա�ע
     * @param remarkFlag �����õ����Ա�ע��ֵ
     */
    public void setRemarkFlag(String remarkFlag){
        this.remarkFlag = StringUtils.rightTrim(remarkFlag);
    }

    /**
     * ��ȡ���Ա�ע
     * @return ���Ա�ע��ֵ
     */
    public String getRemarkFlag(){
        return remarkFlag;
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
     * ��������Ҫ�ֱܷ������ֱ���������
     * @param lossFeeType �����õ�����Ҫ�ֱܷ������ֱ��������õ�ֵ
     */
    public void setLossFeeType(String lossFeeType){
        this.lossFeeType = StringUtils.rightTrim(lossFeeType);
    }

    /**
     * ��ȡ����Ҫ�ֱܷ������ֱ���������
     * @return ����Ҫ�ֱܷ������ֱ��������õ�ֵ
     */
    public String getLossFeeType(){
        return lossFeeType;
    }

    /**
     * �������Ա����Ŀ��ϸ����
     * @param itemDetailName �����õ����Ա����Ŀ��ϸ���Ƶ�ֵ
     */
    public void setItemDetailName(String itemDetailName){
        this.itemDetailName = StringUtils.rightTrim(itemDetailName);
    }

    /**
     * ��ȡ���Ա����Ŀ��ϸ����
     * @return ���Ա����Ŀ��ϸ���Ƶ�ֵ
     */
    public String getItemDetailName(){
        return itemDetailName;
    }

    /**
     * �������Է��÷�Χ
     * @param feeCategory �����õ����Է��÷�Χ��ֵ
     */
    public void setFeeCategory(String feeCategory){
        this.feeCategory = StringUtils.rightTrim(feeCategory);
    }

    /**
     * ��ȡ���Է��÷�Χ
     * @return ���Է��÷�Χ��ֵ
     */
    public String getFeeCategory(){
        return feeCategory;
    }

    /**
     * ���������ձ���ʧ
     * @param kindLoss �����õ������ձ���ʧ��ֵ
     */
    public void setKindLoss(double kindLoss){
        this.kindLoss = kindLoss;
    }

    /**
     * ��ȡ�����ձ���ʧ
     * @return �����ձ���ʧ��ֵ
     */
    public double getKindLoss(){
        return kindLoss;
    }

    /**
     * ���������ձ��ֵ
     * @param kindRest �����õ������ձ��ֵ��ֵ
     */
    public void setKindRest(double kindRest){
        this.kindRest = kindRest;
    }

    /**
     * ��ȡ�����ձ��ֵ
     * @return �����ձ��ֵ��ֵ
     */
    public double getKindRest(){
        return kindRest;
    }

    /**
     * �������Ծ���������
     * @param deductibleRate �����õ����Ծ��������ʵ�ֵ
     */
    public void setDeductibleRate(double deductibleRate){
        this.deductibleRate = deductibleRate;
    }

    /**
     * ��ȡ���Ծ���������
     * @return ���Ծ��������ʵ�ֵ
     */
    public double getDeductibleRate(){
        return deductibleRate;
    }

    /**
     * �������Ծ��������
     * @param deductible �����õ����Ծ���������ֵ
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * ��ȡ���Ծ��������
     * @return ���Ծ���������ֵ
     */
    public double getDeductible(){
        return deductible;
    }

    /**
     * ���������¹�����������
     * @param acciDeductibleRate �����õ������¹����������ʵ�ֵ
     */
    public void setAcciDeductibleRate(double acciDeductibleRate){
        this.acciDeductibleRate = acciDeductibleRate;
    }

    /**
     * ��ȡ�����¹�����������
     * @return �����¹����������ʵ�ֵ
     */
    public double getAcciDeductibleRate(){
        return acciDeductibleRate;
    }
    
    
    /**
     * �������Էֻ���
     * @param familyNO �����õ����Էֻ��ŵ�ֵ
     */
    public void setFamilyNo(int familyNo){
        this.familyNo = familyNo;
    }
    /**
     * ��ȡ���Էֻ���
     * @return ���Էֻ��ŵ�ֵ
     */
    public int getFamilyNo(){
        return familyNo;
    }
    
    /**
     * �������Էֻ���
     * @param familyNO �����õ����Էֻ��ŵ�ֵ
     */
    public void setFamilyNoZH(String familyNoZH){
        this.familyNoZH = familyNoZH;
    }
    /**
     * ��ȡ���Էֻ���
     * @return ���Էֻ��ŵ�ֵ
     */
    public String getFamilyNoZH(){
        return familyNoZH;
    }
    
    /**
     * �������Էֻ�����
     * @param familyName �����õ����Էֻ����Ƶ�ֵ
     */
    public void setFamilyName(String familyName){
        this.familyName = StringUtils.rightTrim(familyName);
    }

    /**
     * ��ȡ���Էֻ�����
     * @return ���Էֻ����Ƶ�ֵ
     */
    public String getFamilyName(){
        return familyName;
    }

	public String getLicenseNo() {
		return StringUtils.rightTrim(licenseNo);
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = StringUtils.rightTrim(licenseNo);
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
    
    
}
