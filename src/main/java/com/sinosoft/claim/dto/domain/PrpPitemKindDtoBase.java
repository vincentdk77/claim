package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prppitemkind���������Ϣ�����ݴ���������<br>
 * ������ 2004-11-22 15:24:13.062<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPitemKindDtoBase implements Serializable{
    /** ������������ */
    private String endorseNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ������� */
    private int itemKindNo = 0;
    /** ���Էֻ���� */
    private int familyNo = 0;
    /** ���Էֻ����� */
    private String familyName = "";
    /** �����ձ���� */
    private String kindCode = "";
    /** �����ձ����� */
    private String kindName = "";
    /** ���Ա����� */
    private int itemNo = 0;
    /** ���Ա����Ŀ������ */
    private String itemCode = "";
    /** ���Ա����Ŀ��ϸ���� */
    private String itemDetailName = "";
    /** ����Ͷ����ʽ���� */
    private String modeCode = "";
    /** ����Ͷ����ʽ���� */
    private String modeName = "";
    /** ���������� */
    private DateTime startDate = new DateTime();
    /** ������Сʱ */
    private int startHour = 0;
    /** �����ձ����� */
    private DateTime endDate = new DateTime();
    /** �����ձ�Сʱ */
    private int endHour = 0;
    /** ���Թ���ͺ� */
    private String model = "";
    /** ���Թ������� */
    private DateTime buyDate = new DateTime();
    /** ���Ե�ַ��� */
    private int addressNo = 0;
    /** �����Ƿ���㱣���־ */
    private String calculateFlag = "";
    /** ���Աұ� */
    private String currency = "";
    /** ���Ե�λ���ս�� */
    private double unitAmount = 0d;
    /** �������� */
    private double quantity = 0d;
    /** ����������λ */
    private String unit = "";
    /** ���Ա��ռ�ֵ */
    private double value = 0d;
    /** ���Ա��ս��/�⳥�޶� */
    private double amount = 0d;
    /** ������Ӧ�������� */
    private int ratePeriod = 0;
    /** ���Է��� */
    private double rate = 0d;
    /** ���Զ��ڷ��ʱ�־ */
    private String shortRateFlag = "";
    /** ���Զ��ڷ��� */
    private double shortRate = 0d;
    /** ���Ի�׼���� */
    private double basePremium = 0d;
    /** ���Ա�׼���� */
    private double benchMarkPremium = 0d;
    /** �����ۿ��� */
    private double discount = 0d;
    /** ���Ա��ѵ�������(%) */
    private double adjustRate = 0d;
    /** ���Ա���/���� */
    private double premium = 0d;
    /** ����������(%) */
    private double deductibleRate = 0d;
    /** ��������� */
    private double deductible = 0d;
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** ���������仯�� */
    private double chgQuantity = 0d;
    /** ���Ա���仯�� */
    private double chgAmount = 0d;
    /** ���Ա��ѱ仯�� */
    private double chgPremium = 0d;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpPitemKindDtoBase����
     */
    public PrpPitemKindDtoBase(){
    }

    /**
     * ����������������
     * @param endorseNo �����õ��������������ֵ
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public String getEndorseNo(){
        return endorseNo;
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
     * �������Էֻ����
     * @param familyNo �����õ����Էֻ���ŵ�ֵ
     */
    public void setFamilyNo(int familyNo){
        this.familyNo = familyNo;
    }

    /**
     * ��ȡ���Էֻ����
     * @return ���Էֻ���ŵ�ֵ
     */
    public int getFamilyNo(){
        return familyNo;
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
     * �������Ա�����
     * @param itemNo �����õ����Ա����ŵ�ֵ
     */
    public void setItemNo(int itemNo){
        this.itemNo = itemNo;
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public int getItemNo(){
        return itemNo;
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
     * ��������Ͷ����ʽ����
     * @param modeCode �����õ�����Ͷ����ʽ�����ֵ
     */
    public void setModeCode(String modeCode){
        this.modeCode = StringUtils.rightTrim(modeCode);
    }

    /**
     * ��ȡ����Ͷ����ʽ����
     * @return ����Ͷ����ʽ�����ֵ
     */
    public String getModeCode(){
        return modeCode;
    }

    /**
     * ��������Ͷ����ʽ����
     * @param modeName �����õ�����Ͷ����ʽ���Ƶ�ֵ
     */
    public void setModeName(String modeName){
        this.modeName = StringUtils.rightTrim(modeName);
    }

    /**
     * ��ȡ����Ͷ����ʽ����
     * @return ����Ͷ����ʽ���Ƶ�ֵ
     */
    public String getModeName(){
        return modeName;
    }

    /**
     * ��������������
     * @param startDate �����õ����������ڵ�ֵ
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * ��ȡ����������
     * @return ���������ڵ�ֵ
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * ����������Сʱ
     * @param startHour �����õ�������Сʱ��ֵ
     */
    public void setStartHour(int startHour){
        this.startHour = startHour;
    }

    /**
     * ��ȡ������Сʱ
     * @return ������Сʱ��ֵ
     */
    public int getStartHour(){
        return startHour;
    }

    /**
     * ���������ձ�����
     * @param endDate �����õ������ձ����ڵ�ֵ
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����ڵ�ֵ
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * ���������ձ�Сʱ
     * @param endHour �����õ������ձ�Сʱ��ֵ
     */
    public void setEndHour(int endHour){
        this.endHour = endHour;
    }

    /**
     * ��ȡ�����ձ�Сʱ
     * @return �����ձ�Сʱ��ֵ
     */
    public int getEndHour(){
        return endHour;
    }

    /**
     * �������Թ���ͺ�
     * @param model �����õ����Թ���ͺŵ�ֵ
     */
    public void setModel(String model){
        this.model = StringUtils.rightTrim(model);
    }

    /**
     * ��ȡ���Թ���ͺ�
     * @return ���Թ���ͺŵ�ֵ
     */
    public String getModel(){
        return model;
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
     * �������Ե�ַ���
     * @param addressNo �����õ����Ե�ַ��ŵ�ֵ
     */
    public void setAddressNo(int addressNo){
        this.addressNo = addressNo;
    }

    /**
     * ��ȡ���Ե�ַ���
     * @return ���Ե�ַ��ŵ�ֵ
     */
    public int getAddressNo(){
        return addressNo;
    }

    /**
     * ���������Ƿ���㱣���־
     * @param calculateFlag �����õ������Ƿ���㱣���־��ֵ
     */
    public void setCalculateFlag(String calculateFlag){
        this.calculateFlag = StringUtils.rightTrim(calculateFlag);
    }

    /**
     * ��ȡ�����Ƿ���㱣���־
     * @return �����Ƿ���㱣���־��ֵ
     */
    public String getCalculateFlag(){
        return calculateFlag;
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
     * �������Ե�λ���ս��
     * @param unitAmount �����õ����Ե�λ���ս���ֵ
     */
    public void setUnitAmount(double unitAmount){
        this.unitAmount = unitAmount;
    }

    /**
     * ��ȡ���Ե�λ���ս��
     * @return ���Ե�λ���ս���ֵ
     */
    public double getUnitAmount(){
        return unitAmount;
    }

    /**
     * ������������
     * @param quantity �����õ�����������ֵ
     */
    public void setQuantity(double quantity){
        this.quantity = quantity;
    }

    /**
     * ��ȡ��������
     * @return ����������ֵ
     */
    public double getQuantity(){
        return quantity;
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
     * �������Ա��ռ�ֵ
     * @param value �����õ����Ա��ռ�ֵ��ֵ
     */
    public void setValue(double value){
        this.value = value;
    }

    /**
     * ��ȡ���Ա��ռ�ֵ
     * @return ���Ա��ռ�ֵ��ֵ
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
     * ����������Ӧ��������
     * @param ratePeriod �����õ�������Ӧ����������ֵ
     */
    public void setRatePeriod(int ratePeriod){
        this.ratePeriod = ratePeriod;
    }

    /**
     * ��ȡ������Ӧ��������
     * @return ������Ӧ����������ֵ
     */
    public int getRatePeriod(){
        return ratePeriod;
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
     * �������Զ��ڷ��ʱ�־
     * @param shortRateFlag �����õ����Զ��ڷ��ʱ�־��ֵ
     */
    public void setShortRateFlag(String shortRateFlag){
        this.shortRateFlag = StringUtils.rightTrim(shortRateFlag);
    }

    /**
     * ��ȡ���Զ��ڷ��ʱ�־
     * @return ���Զ��ڷ��ʱ�־��ֵ
     */
    public String getShortRateFlag(){
        return shortRateFlag;
    }

    /**
     * �������Զ��ڷ���
     * @param shortRate �����õ����Զ��ڷ��ʵ�ֵ
     */
    public void setShortRate(double shortRate){
        this.shortRate = shortRate;
    }

    /**
     * ��ȡ���Զ��ڷ���
     * @return ���Զ��ڷ��ʵ�ֵ
     */
    public double getShortRate(){
        return shortRate;
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
     * ���������ۿ���
     * @param discount �����õ������ۿ��ʵ�ֵ
     */
    public void setDiscount(double discount){
        this.discount = discount;
    }

    /**
     * ��ȡ�����ۿ���
     * @return �����ۿ��ʵ�ֵ
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
     * ��������������(%)
     * @param deductibleRate �����õ�����������(%)��ֵ
     */
    public void setDeductibleRate(double deductibleRate){
        this.deductibleRate = deductibleRate;
    }

    /**
     * ��ȡ����������(%)
     * @return ����������(%)��ֵ
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
     * �������������仯��
     * @param chgQuantity �����õ����������仯����ֵ
     */
    public void setChgQuantity(double chgQuantity){
        this.chgQuantity = chgQuantity;
    }

    /**
     * ��ȡ���������仯��
     * @return ���������仯����ֵ
     */
    public double getChgQuantity(){
        return chgQuantity;
    }

    /**
     * �������Ա���仯��
     * @param chgAmount �����õ����Ա���仯����ֵ
     */
    public void setChgAmount(double chgAmount){
        this.chgAmount = chgAmount;
    }

    /**
     * ��ȡ���Ա���仯��
     * @return ���Ա���仯����ֵ
     */
    public double getChgAmount(){
        return chgAmount;
    }

    /**
     * �������Ա��ѱ仯��
     * @param chgPremium �����õ����Ա��ѱ仯����ֵ
     */
    public void setChgPremium(double chgPremium){
        this.chgPremium = chgPremium;
    }

    /**
     * ��ȡ���Ա��ѱ仯��
     * @return ���Ա��ѱ仯����ֵ
     */
    public double getChgPremium(){
        return chgPremium;
    }
}
