package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLprop���Ʋ��˶�����ϸ�嵥������ݴ���������<br>
 * ������ 2006-04-24 17:46:12.358<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpropDtoBase implements Serializable{
    /** ���������� */
    private String claimNo = "";
    /** �������� */
    private String riskCode = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Ա����� */
    private String registNo = "";
    /** ���Ա������������� */
    private int itemKindNo = 0;
    /** ���Էֻ����(�����ڼ���Ҳ���) */
    private int familyNo = 0;
    /** ���Էֻ�����(�����ڼ���Ҳ���) */
    private String familyName = "";
    /** �����ձ���� */
    private String kindCode = "";
    /** ���Ա��������Ŀ���� */
    private String itemCode = "";
    /** ������ʧ��Ŀ��� */
    private String lossItemCode = "";
    /** ������ʧ��Ŀ���� */
    private String lossItemName = "";
    /** ���Ը��ַ��ô��� */
    private String feeTypeCode = "";
    /** ���Է������� */
    private String feeTypeName = "";
    /** ���Աұ� */
    private String currency = "";
    /** ���Ե��� */
    private double unitPrice = 0d;
    /** �������������� */
    private double lossQuantity = 0d;
    /** ����������λ */
    private String unit = "";
    /** ���Թ������� */
    private DateTime buyDate = new DateTime();
    /** �������۾��� */
    private double depreRate = 0d;
    /** ���������� */
    private double sumLoss = 0d;
    /** �����޳���� */
    private double sumReject = 0d;
    /** �����޳�ԭ�� */
    private String rejectReason = "";
    /** �����⳥���� */
    private double lossRate = 0d;
    /** ���Ժ˶����� */
    private double sumDefLoss = 0d;
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** ���Ե���(���� */
    private double veriUnitPrice = 0d;
    /** ��������������(���� */
    private double veriLossQuantity = 0d;
    /** ����������λ(���� */
    private String veriUnit = "";
    /** �������۾���(���� */
    private double veriDepreRate = 0d;
    /** ����������(���� */
    private double veriSumLoss = 0d;
    /** �����޳����(���� */
    private double veriSumReject = 0d;
    /** �����޳�ԭ��(���� */
    private String veriRejectReason = "";
    /** �����⳥����(���� */
    private double veriLossRate = 0d;
    /** ���Ժ˶�����(���� */
    private double veriSumDefLoss = 0d;
    /** ���Ա�ע(���� */
    private String veriRemark = "";
    /** ����ԭ�л������ */
    private String compensateBackFlag = "";
    /** ���Գ������ ���г�����������ʹ�� */
    private String licenseNo = "";
    /** ���Գ��������ͺ� ���г�����������ʹ�� */
    private String modelNo = "";

    
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpropDtoBase����
     */
    public PrpLpropDtoBase(){
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
     * �������Ա�����
     * @param registNo �����õ����Ա����ŵ�ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getRegistNo(){
        return registNo;
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
     * ����������ʧ��Ŀ���
     * @param lossItemCode �����õ�������ʧ��Ŀ����ֵ
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * ��ȡ������ʧ��Ŀ���
     * @return ������ʧ��Ŀ����ֵ
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * ����������ʧ��Ŀ����
     * @param lossItemName �����õ�������ʧ��Ŀ���Ƶ�ֵ
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * ��ȡ������ʧ��Ŀ����
     * @return ������ʧ��Ŀ���Ƶ�ֵ
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * �������Ը��ַ��ô���
     * @param feeTypeCode �����õ����Ը��ַ��ô����ֵ
     */
    public void setFeeTypeCode(String feeTypeCode){
        this.feeTypeCode = StringUtils.rightTrim(feeTypeCode);
    }

    /**
     * ��ȡ���Ը��ַ��ô���
     * @return ���Ը��ַ��ô����ֵ
     */
    public String getFeeTypeCode(){
        return feeTypeCode;
    }

    /**
     * �������Է�������
     * @param feeTypeName �����õ����Է������Ƶ�ֵ
     */
    public void setFeeTypeName(String feeTypeName){
        this.feeTypeName = StringUtils.rightTrim(feeTypeName);
    }

    /**
     * ��ȡ���Է�������
     * @return ���Է������Ƶ�ֵ
     */
    public String getFeeTypeName(){
        return feeTypeName;
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
     * ���������޳����
     * @param sumReject �����õ������޳�����ֵ
     */
    public void setSumReject(double sumReject){
        this.sumReject = sumReject;
    }

    /**
     * ��ȡ�����޳����
     * @return �����޳�����ֵ
     */
    public double getSumReject(){
        return sumReject;
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
     * ���������⳥����
     * @param lossRate �����õ������⳥������ֵ
     */
    public void setLossRate(double lossRate){
        this.lossRate = lossRate;
    }

    /**
     * ��ȡ�����⳥����
     * @return �����⳥������ֵ
     */
    public double getLossRate(){
        return lossRate;
    }

    /**
     * �������Ժ˶�����
     * @param sumDefLoss �����õ����Ժ˶������ֵ
     */
    public void setSumDefLoss(double sumDefLoss){
        this.sumDefLoss = sumDefLoss;
    }

    /**
     * ��ȡ���Ժ˶�����
     * @return ���Ժ˶������ֵ
     */
    public double getSumDefLoss(){
        return sumDefLoss;
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
     * �������Ե���(����
     * @param veriUnitPrice �����õ����Ե���(���𣩵�ֵ
     */
    public void setVeriUnitPrice(double veriUnitPrice){
        this.veriUnitPrice = veriUnitPrice;
    }

    /**
     * ��ȡ���Ե���(����
     * @return ���Ե���(���𣩵�ֵ
     */
    public double getVeriUnitPrice(){
        return veriUnitPrice;
    }

    /**
     * ������������������(����
     * @param veriLossQuantity �����õ���������������(���𣩵�ֵ
     */
    public void setVeriLossQuantity(double veriLossQuantity){
        this.veriLossQuantity = veriLossQuantity;
    }

    /**
     * ��ȡ��������������(����
     * @return ��������������(���𣩵�ֵ
     */
    public double getVeriLossQuantity(){
        return veriLossQuantity;
    }

    /**
     * ��������������λ(����
     * @param veriUnit �����õ�����������λ(���𣩵�ֵ
     */
    public void setVeriUnit(String veriUnit){
        this.veriUnit = StringUtils.rightTrim(veriUnit);
    }

    /**
     * ��ȡ����������λ(����
     * @return ����������λ(���𣩵�ֵ
     */
    public String getVeriUnit(){
        return veriUnit;
    }

    /**
     * �����������۾���(����
     * @param veriDepreRate �����õ��������۾���(���𣩵�ֵ
     */
    public void setVeriDepreRate(double veriDepreRate){
        this.veriDepreRate = veriDepreRate;
    }

    /**
     * ��ȡ�������۾���(����
     * @return �������۾���(���𣩵�ֵ
     */
    public double getVeriDepreRate(){
        return veriDepreRate;
    }

    /**
     * ��������������(����
     * @param veriSumLoss �����õ�����������(���𣩵�ֵ
     */
    public void setVeriSumLoss(double veriSumLoss){
        this.veriSumLoss = veriSumLoss;
    }

    /**
     * ��ȡ����������(����
     * @return ����������(���𣩵�ֵ
     */
    public double getVeriSumLoss(){
        return veriSumLoss;
    }

    /**
     * ���������޳����(����
     * @param veriSumReject �����õ������޳����(���𣩵�ֵ
     */
    public void setVeriSumReject(double veriSumReject){
        this.veriSumReject = veriSumReject;
    }

    /**
     * ��ȡ�����޳����(����
     * @return �����޳����(���𣩵�ֵ
     */
    public double getVeriSumReject(){
        return veriSumReject;
    }

    /**
     * ���������޳�ԭ��(����
     * @param veriRejectReason �����õ������޳�ԭ��(���𣩵�ֵ
     */
    public void setVeriRejectReason(String veriRejectReason){
        this.veriRejectReason = StringUtils.rightTrim(veriRejectReason);
    }

    /**
     * ��ȡ�����޳�ԭ��(����
     * @return �����޳�ԭ��(���𣩵�ֵ
     */
    public String getVeriRejectReason(){
        return veriRejectReason;
    }

    /**
     * ���������⳥����(����
     * @param veriLossRate �����õ������⳥����(���𣩵�ֵ
     */
    public void setVeriLossRate(double veriLossRate){
        this.veriLossRate = veriLossRate;
    }

    /**
     * ��ȡ�����⳥����(����
     * @return �����⳥����(���𣩵�ֵ
     */
    public double getVeriLossRate(){
        return veriLossRate;
    }

    /**
     * �������Ժ˶�����(����
     * @param veriSumDefLoss �����õ����Ժ˶�����(���𣩵�ֵ
     */
    public void setVeriSumDefLoss(double veriSumDefLoss){
        this.veriSumDefLoss = veriSumDefLoss;
    }

    /**
     * ��ȡ���Ժ˶�����(����
     * @return ���Ժ˶�����(���𣩵�ֵ
     */
    public double getVeriSumDefLoss(){
        return veriSumDefLoss;
    }

    /**
     * �������Ա�ע(����
     * @param veriRemark �����õ����Ա�ע(���𣩵�ֵ
     */
    public void setVeriRemark(String veriRemark){
        this.veriRemark = StringUtils.rightTrim(veriRemark);
    }

    /**
     * ��ȡ���Ա�ע(����
     * @return ���Ա�ע(���𣩵�ֵ
     */
    public String getVeriRemark(){
        return veriRemark;
    }

    /**
     * ��������ԭ�л������
     * @param compensateBackFlag �����õ�����ԭ�л�����ǵ�ֵ
     */
    public void setCompensateBackFlag(String compensateBackFlag){
        this.compensateBackFlag = StringUtils.rightTrim(compensateBackFlag);
    }

    /**
     * ��ȡ����ԭ�л������
     * @return ����ԭ�л�����ǵ�ֵ
     */
    public String getCompensateBackFlag(){
        return compensateBackFlag;
    }

	public String getLicenseNo() {
		return StringUtils.rightTrim(licenseNo);
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = StringUtils.rightTrim(licenseNo);
	}

	public String getModelNo() {
		return StringUtils.rightTrim(modelNo);
	}

	public void setModelNo(String modelNo) {
		this.modelNo = StringUtils.rightTrim(modelNo);
	}
    
    
    
}
