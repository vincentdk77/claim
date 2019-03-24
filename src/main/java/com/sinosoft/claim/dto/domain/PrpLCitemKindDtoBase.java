package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLCitemKind-���Ᵽ��Ͷ���ձ������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.640<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLCitemKindDtoBase implements Serializable{
    /** �����ⰸ�� */
    private String claimNo = "";
    /** ���Ա����� */
    private String registNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ������� */
    private int itemKindNo = 0;
    /** �����ձ���� */
    private String kindCode = "";
    /** �����ձ����� */
    private String kindName = "";
    /** ���Ա����Ŀ������ ��
--** ��ľ������� */
    private String itemCode = "";
    /** ���Ա����Ŀ��ϸ����
--** ��ľ�������� */
    private String itemDetailName = "";
    /** ����Ͷ����ʽ����--** ��ţ��:
--** PrpDration.RationType
--** ��ֳ��: �μ�Ͷ��
--** ���գ�������� */
    private String modeCode = "";
    /** ����Ͷ����ʽ����--** ��ţ��:
--** PrpDration.RationName
--** ��ֳ��: �μ�Ͷ�� */
    private String modeName = "";
    /** ���Աұ� */
    private String currency = "";
    /** �����Ƿ���㱣���־(Y/N) */
    private String calculateFlag = "";
    /** ���Ե�λ���ս��⳥�޶
--** Լ������(Ԫ/����)(��ֲ��)
--** ��ľʵ���ܶ�(��ľ��) */
    private double unitAmount = 0d;
    /** ��������(����/��Ʒ����/����)
--** ��������(��ֳ)
--** Ͷ�����(Ķ)(��ľ��) */
    private double quantity = 0d;
    /** ���Ա��ռ�ֵ���ս��/�⳥�޶� */
    private double value = 0d;
    /** ���Ա��ս��/�⳥�޶� */
    private double amount = 0d;
    /** ���Է��� */
    private double rate = 0d;
    /** ���Զ��ڷ��ʱ�־(1.�±���/2.�ձ���) */
    private String shortRateFlag = "";
    /** ���Ի�׼���� */
    private double basePremium = 0d;
    /** ���Ա�׼���� */
    private double benchMarkPremium = 0d;
    /** �����ۿ���(%) */
    private double discount = 0d;
    /** ���Ա��ѵ�������(%) */
    private double adjustRate = 0d;
    /** ���Ա���/���� */
    private double premium = 0d;
    /** ���������� */
    private double deductibleRate = 0d;
    /** ���������(%) */
    private double deductible = 0d;
    /** ����SHORTRATE */
    private double shortRate = 0d;
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLCitemKindDtoBase����
     */
    public PrpLCitemKindDtoBase(){
    }

    /**
     * ���������ⰸ��
     * @param claimNo �����õ������ⰸ�ŵ�ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ��
     * @return �����ⰸ�ŵ�ֵ
     */
    public String getClaimNo(){
        return claimNo;
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
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * �����������ִ���
     * @param riskCode �����õ��������ִ����ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ�������ִ���
     * @return �������ִ����ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * �����������
     * @param itemKindNo �����õ�������ŵ�ֵ
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
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
     * ���������ձ�����
     * @param kindName �����õ������ձ����Ƶ�ֵ
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����Ƶ�ֵ
     */
    public String getKindName(){
        return kindName;
    }

    /**
     * �������Ա����Ŀ������ ��
--** ��ľ�������
     * @param itemCode �����õ����Ա����Ŀ������ ��
--** ��ľ��������ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ���Ա����Ŀ������ ��
--** ��ľ�������
     * @return ���Ա����Ŀ������ ��
--** ��ľ��������ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * �������Ա����Ŀ��ϸ����
--** ��ľ��������
     * @param itemDetailName �����õ����Ա����Ŀ��ϸ����
--** ��ľ�������Ƶ�ֵ
     */
    public void setItemDetailName(String itemDetailName){
        this.itemDetailName = StringUtils.rightTrim(itemDetailName);
    }

    /**
     * ��ȡ���Ա����Ŀ��ϸ����
--** ��ľ��������
     * @return ���Ա����Ŀ��ϸ����
--** ��ľ�������Ƶ�ֵ
     */
    public String getItemDetailName(){
        return itemDetailName;
    }

    /**
     * ��������Ͷ����ʽ����--** ��ţ��:
--** PrpDration.RationType
--** ��ֳ��: �μ�Ͷ��
--** ���գ��������
     * @param modeCode �����õ�����Ͷ����ʽ����--** ��ţ��:
--** PrpDration.RationType
--** ��ֳ��: �μ�Ͷ��
--** ���գ���������ֵ
     */
    public void setModeCode(String modeCode){
        this.modeCode = StringUtils.rightTrim(modeCode);
    }

    /**
     * ��ȡ����Ͷ����ʽ����--** ��ţ��:
--** PrpDration.RationType
--** ��ֳ��: �μ�Ͷ��
--** ���գ��������
     * @return ����Ͷ����ʽ����--** ��ţ��:
--** PrpDration.RationType
--** ��ֳ��: �μ�Ͷ��
--** ���գ���������ֵ
     */
    public String getModeCode(){
        return modeCode;
    }

    /**
     * ��������Ͷ����ʽ����--** ��ţ��:
--** PrpDration.RationName
--** ��ֳ��: �μ�Ͷ��
     * @param modeName �����õ�����Ͷ����ʽ����--** ��ţ��:
--** PrpDration.RationName
--** ��ֳ��: �μ�Ͷ����ֵ
     */
    public void setModeName(String modeName){
        this.modeName = StringUtils.rightTrim(modeName);
    }

    /**
     * ��ȡ����Ͷ����ʽ����--** ��ţ��:
--** PrpDration.RationName
--** ��ֳ��: �μ�Ͷ��
     * @return ����Ͷ����ʽ����--** ��ţ��:
--** PrpDration.RationName
--** ��ֳ��: �μ�Ͷ����ֵ
     */
    public String getModeName(){
        return modeName;
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
     * ���������Ƿ���㱣���־(Y/N)
     * @param calculateFlag �����õ������Ƿ���㱣���־(Y/N)��ֵ
     */
    public void setCalculateFlag(String calculateFlag){
        this.calculateFlag = StringUtils.rightTrim(calculateFlag);
    }

    /**
     * ��ȡ�����Ƿ���㱣���־(Y/N)
     * @return �����Ƿ���㱣���־(Y/N)��ֵ
     */
    public String getCalculateFlag(){
        return calculateFlag;
    }

    /**
     * �������Ե�λ���ս��⳥�޶
--** Լ������(Ԫ/����)(��ֲ��)
--** ��ľʵ���ܶ�(��ľ��)
     * @param unitAmount �����õ����Ե�λ���ս��⳥�޶
--** Լ������(Ԫ/����)(��ֲ��)
--** ��ľʵ���ܶ�(��ľ��)��ֵ
     */
    public void setUnitAmount(double unitAmount){
        this.unitAmount = unitAmount;
    }

    /**
     * ��ȡ���Ե�λ���ս��⳥�޶
--** Լ������(Ԫ/����)(��ֲ��)
--** ��ľʵ���ܶ�(��ľ��)
     * @return ���Ե�λ���ս��⳥�޶
--** Լ������(Ԫ/����)(��ֲ��)
--** ��ľʵ���ܶ�(��ľ��)��ֵ
     */
    public double getUnitAmount(){
        return unitAmount;
    }

    /**
     * ������������(����/��Ʒ����/����)
--** ��������(��ֳ)
--** Ͷ�����(Ķ)(��ľ��)
     * @param quantity �����õ���������(����/��Ʒ����/����)
--** ��������(��ֳ)
--** Ͷ�����(Ķ)(��ľ��)��ֵ
     */
    public void setQuantity(double quantity){
        this.quantity = quantity;
    }

    /**
     * ��ȡ��������(����/��Ʒ����/����)
--** ��������(��ֳ)
--** Ͷ�����(Ķ)(��ľ��)
     * @return ��������(����/��Ʒ����/����)
--** ��������(��ֳ)
--** Ͷ�����(Ķ)(��ľ��)��ֵ
     */
    public double getQuantity(){
        return quantity;
    }

    /**
     * �������Ա��ռ�ֵ���ս��/�⳥�޶�
     * @param value �����õ����Ա��ռ�ֵ���ս��/�⳥�޶��ֵ
     */
    public void setValue(double value){
        this.value = value;
    }

    /**
     * ��ȡ���Ա��ռ�ֵ���ս��/�⳥�޶�
     * @return ���Ա��ռ�ֵ���ս��/�⳥�޶��ֵ
     */
    public double getValue(){
        return value;
    }

    /**
     * �������Ա��ս��/�⳥�޶�
     * @param amount �����õ����Ա��ս��/�⳥�޶��ֵ
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * ��ȡ���Ա��ս��/�⳥�޶�
     * @return ���Ա��ս��/�⳥�޶��ֵ
     */
    public double getAmount(){
        return amount;
    }

    /**
     * �������Է���
     * @param rate �����õ����Է��ʵ�ֵ
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * ��ȡ���Է���
     * @return ���Է��ʵ�ֵ
     */
    public double getRate(){
        return rate;
    }

    /**
     * �������Զ��ڷ��ʱ�־(1.�±���/2.�ձ���)
     * @param shortRateFlag �����õ����Զ��ڷ��ʱ�־(1.�±���/2.�ձ���)��ֵ
     */
    public void setShortRateFlag(String shortRateFlag){
        this.shortRateFlag = StringUtils.rightTrim(shortRateFlag);
    }

    /**
     * ��ȡ���Զ��ڷ��ʱ�־(1.�±���/2.�ձ���)
     * @return ���Զ��ڷ��ʱ�־(1.�±���/2.�ձ���)��ֵ
     */
    public String getShortRateFlag(){
        return shortRateFlag;
    }

    /**
     * �������Ի�׼����
     * @param basePremium �����õ����Ի�׼���ѵ�ֵ
     */
    public void setBasePremium(double basePremium){
        this.basePremium = basePremium;
    }

    /**
     * ��ȡ���Ի�׼����
     * @return ���Ի�׼���ѵ�ֵ
     */
    public double getBasePremium(){
        return basePremium;
    }

    /**
     * �������Ա�׼����
     * @param benchMarkPremium �����õ����Ա�׼���ѵ�ֵ
     */
    public void setBenchMarkPremium(double benchMarkPremium){
        this.benchMarkPremium = benchMarkPremium;
    }

    /**
     * ��ȡ���Ա�׼����
     * @return ���Ա�׼���ѵ�ֵ
     */
    public double getBenchMarkPremium(){
        return benchMarkPremium;
    }

    /**
     * ���������ۿ���(%)
     * @param discount �����õ������ۿ���(%)��ֵ
     */
    public void setDiscount(double discount){
        this.discount = discount;
    }

    /**
     * ��ȡ�����ۿ���(%)
     * @return �����ۿ���(%)��ֵ
     */
    public double getDiscount(){
        return discount;
    }

    /**
     * �������Ա��ѵ�������(%)
     * @param adjustRate �����õ����Ա��ѵ�������(%)��ֵ
     */
    public void setAdjustRate(double adjustRate){
        this.adjustRate = adjustRate;
    }

    /**
     * ��ȡ���Ա��ѵ�������(%)
     * @return ���Ա��ѵ�������(%)��ֵ
     */
    public double getAdjustRate(){
        return adjustRate;
    }

    /**
     * �������Ա���/����
     * @param premium �����õ����Ա���/�����ֵ
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * ��ȡ���Ա���/����
     * @return ���Ա���/�����ֵ
     */
    public double getPremium(){
        return premium;
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
     * �������������(%)
     * @param deductible �����õ����������(%)��ֵ
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * ��ȡ���������(%)
     * @return ���������(%)��ֵ
     */
    public double getDeductible(){
        return deductible;
    }

    /**
     * ��������SHORTRATE
     * @param shortRate �����õ�����SHORTRATE��ֵ
     */
    public void setShortRate(double shortRate){
        this.shortRate = shortRate;
    }

    /**
     * ��ȡ����SHORTRATE
     * @return ����SHORTRATE��ֵ
     */
    public double getShortRate(){
        return shortRate;
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
}
