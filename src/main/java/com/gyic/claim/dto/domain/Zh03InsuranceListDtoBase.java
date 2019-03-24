package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����ZH03InsuranceList�����ݴ���������<br>
 */
public class Zh03InsuranceListDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����InusreListCode */
    private String inusreListCode = "";
    /** ����IndexNo */
    private String indexNo = "";
    /** ����RiskCode */
    private String riskCode = "";
    /** ����KindCode */
    private String kindCode = "";
    /** ����FamilyNo */
    private String familyNo = "";
    /** ����FamilyName */
    private String familyName = "";
    /** ����FamilySex */
    private String familySex = "";
    /** ����FamilyFIdCard */
    private String familyFIdCard = "";
    /** ����Name */
    private String name = "";
    /** ����Address */
    private String address = "";
    /** ����Count */
    private String count = "";
    /** ����UnitAmount */
    private double unitAmount = 0D;
    /** ����SumAmount */
    private double sumAmount = 0D;
    /** ����SumPremium */
    private double sumPremium = 0D;
    /** ����HandlerCode */
    private String handlerCode = "";
    /** ����InputDate */
    private DateTime inputDate = new DateTime();
    /** ����StartDate */
    private DateTime startDate = new DateTime();
    /** ����EndDate */
    private DateTime endDate = new DateTime();
    /** ����Flag */
    private String flag = "";
    /** ����Remark */
    private String remark = "";
    /** ����ItemCode */
    private String itemCode = "";
    /** ����Rate */
    private String rate = "";
    /** ����FamilyFlag */
    private String familyFlag = "";
    /** ����ExportIndex */
    private String exportIndex = "";
    /** ����PersonNo */
    private String personNo = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�Zh03InsuranceListDtoBase����
     */
    public Zh03InsuranceListDtoBase(){
    }

    /**
     * ��������InusreListCode
     * @param inusreListCode �����õ�����InusreListCode��ֵ
     */
    public void setInusreListCode(String inusreListCode){
        this.inusreListCode = StringUtils.rightTrim(inusreListCode);
    }

    /**
     * ��ȡ����InusreListCode
     * @return ����InusreListCode��ֵ
     */
    public String getInusreListCode(){
        return inusreListCode;
    }

    /**
     * ��������IndexNo
     * @param indexNo �����õ�����IndexNo��ֵ
     */
    public void setIndexNo(String indexNo){
        this.indexNo = StringUtils.rightTrim(indexNo);
    }

    /**
     * ��ȡ����IndexNo
     * @return ����IndexNo��ֵ
     */
    public String getIndexNo(){
        return indexNo;
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

    /**
     * ��������FamilyNo
     * @param familyNo �����õ�����FamilyNo��ֵ
     */
    public void setFamilyNo(String familyNo){
        this.familyNo = StringUtils.rightTrim(familyNo);
    }

    /**
     * ��ȡ����FamilyNo
     * @return ����FamilyNo��ֵ
     */
    public String getFamilyNo(){
        return familyNo;
    }

    /**
     * ��������FamilyName
     * @param familyName �����õ�����FamilyName��ֵ
     */
    public void setFamilyName(String familyName){
        this.familyName = StringUtils.rightTrim(familyName);
    }

    /**
     * ��ȡ����FamilyName
     * @return ����FamilyName��ֵ
     */
    public String getFamilyName(){
        return familyName;
    }

    /**
     * ��������FamilySex
     * @param familySex �����õ�����FamilySex��ֵ
     */
    public void setFamilySex(String familySex){
        this.familySex = StringUtils.rightTrim(familySex);
    }

    /**
     * ��ȡ����FamilySex
     * @return ����FamilySex��ֵ
     */
    public String getFamilySex(){
        return familySex;
    }

    /**
     * ��������FamilyFIdCard
     * @param familyFIdCard �����õ�����FamilyFIdCard��ֵ
     */
    public void setFamilyFIdCard(String familyFIdCard){
        this.familyFIdCard = StringUtils.rightTrim(familyFIdCard);
    }

    /**
     * ��ȡ����FamilyFIdCard
     * @return ����FamilyFIdCard��ֵ
     */
    public String getFamilyFIdCard(){
        return familyFIdCard;
    }

    /**
     * ��������Name
     * @param name �����õ�����Name��ֵ
     */
    public void setName(String name){
        this.name = StringUtils.rightTrim(name);
    }

    /**
     * ��ȡ����Name
     * @return ����Name��ֵ
     */
    public String getName(){
        return name;
    }

    /**
     * ��������Address
     * @param address �����õ�����Address��ֵ
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * ��ȡ����Address
     * @return ����Address��ֵ
     */
    public String getAddress(){
        return address;
    }

    /**
     * ��������Count
     * @param count �����õ�����Count��ֵ
     */
    public void setCount(String count){
        this.count = StringUtils.rightTrim(count);
    }

    /**
     * ��ȡ����Count
     * @return ����Count��ֵ
     */
    public String getCount(){
        return count;
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
     * ��������SumAmount
     * @param sumAmount �����õ�����SumAmount��ֵ
     */
    public void setSumAmount(double sumAmount){
        this.sumAmount = sumAmount;
    }

    /**
     * ��ȡ����SumAmount
     * @return ����SumAmount��ֵ
     */
    public double getSumAmount(){
        return sumAmount;
    }

    /**
     * ��������SumPremium
     * @param sumPremium �����õ�����SumPremium��ֵ
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * ��ȡ����SumPremium
     * @return ����SumPremium��ֵ
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * ��������HandlerCode
     * @param handlerCode �����õ�����HandlerCode��ֵ
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * ��ȡ����HandlerCode
     * @return ����HandlerCode��ֵ
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * ��������InputDate
     * @param inputDate �����õ�����InputDate��ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ����InputDate
     * @return ����InputDate��ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * ��������StartDate
     * @param startDate �����õ�����StartDate��ֵ
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * ��ȡ����StartDate
     * @return ����StartDate��ֵ
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * ��������EndDate
     * @param endDate �����õ�����EndDate��ֵ
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * ��ȡ����EndDate
     * @return ����EndDate��ֵ
     */
    public DateTime getEndDate(){
        return endDate;
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
     * ��������ItemCode
     * @param itemCode �����õ�����ItemCode��ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ����ItemCode
     * @return ����ItemCode��ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * ��������Rate
     * @param rate �����õ�����Rate��ֵ
     */
    public void setRate(String rate){
        this.rate = StringUtils.rightTrim(rate);
    }

    /**
     * ��ȡ����Rate
     * @return ����Rate��ֵ
     */
    public String getRate(){
        return rate;
    }

    /**
     * ��������FamilyFlag
     * @param familyFlag �����õ�����FamilyFlag��ֵ
     */
    public void setFamilyFlag(String familyFlag){
        this.familyFlag = StringUtils.rightTrim(familyFlag);
    }

    /**
     * ��ȡ����FamilyFlag
     * @return ����FamilyFlag��ֵ
     */
    public String getFamilyFlag(){
        return familyFlag;
    }

    /**
     * ��������ExportIndex
     * @param exportIndex �����õ�����ExportIndex��ֵ
     */
    public void setExportIndex(String exportIndex){
        this.exportIndex = StringUtils.rightTrim(exportIndex);
    }

    /**
     * ��ȡ����ExportIndex
     * @return ����ExportIndex��ֵ
     */
    public String getExportIndex(){
        return exportIndex;
    }

    /**
     * ��������PersonNo
     * @param personNo �����õ�����PersonNo��ֵ
     */
    public void setPersonNo(String personNo){
        this.personNo = StringUtils.rightTrim(personNo);
    }

    /**
     * ��ȡ����PersonNo
     * @return ����PersonNo��ֵ
     */
    public String getPersonNo(){
        return personNo;
    }
}
