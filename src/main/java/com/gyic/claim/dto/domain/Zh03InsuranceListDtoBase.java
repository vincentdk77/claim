package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是ZH03InsuranceList的数据传输对象基类<br>
 */
public class Zh03InsuranceListDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性InusreListCode */
    private String inusreListCode = "";
    /** 属性IndexNo */
    private String indexNo = "";
    /** 属性RiskCode */
    private String riskCode = "";
    /** 属性KindCode */
    private String kindCode = "";
    /** 属性FamilyNo */
    private String familyNo = "";
    /** 属性FamilyName */
    private String familyName = "";
    /** 属性FamilySex */
    private String familySex = "";
    /** 属性FamilyFIdCard */
    private String familyFIdCard = "";
    /** 属性Name */
    private String name = "";
    /** 属性Address */
    private String address = "";
    /** 属性Count */
    private String count = "";
    /** 属性UnitAmount */
    private double unitAmount = 0D;
    /** 属性SumAmount */
    private double sumAmount = 0D;
    /** 属性SumPremium */
    private double sumPremium = 0D;
    /** 属性HandlerCode */
    private String handlerCode = "";
    /** 属性InputDate */
    private DateTime inputDate = new DateTime();
    /** 属性StartDate */
    private DateTime startDate = new DateTime();
    /** 属性EndDate */
    private DateTime endDate = new DateTime();
    /** 属性Flag */
    private String flag = "";
    /** 属性Remark */
    private String remark = "";
    /** 属性ItemCode */
    private String itemCode = "";
    /** 属性Rate */
    private String rate = "";
    /** 属性FamilyFlag */
    private String familyFlag = "";
    /** 属性ExportIndex */
    private String exportIndex = "";
    /** 属性PersonNo */
    private String personNo = "";

    /**
     *  默认构造方法,构造一个默认的Zh03InsuranceListDtoBase对象
     */
    public Zh03InsuranceListDtoBase(){
    }

    /**
     * 设置属性InusreListCode
     * @param inusreListCode 待设置的属性InusreListCode的值
     */
    public void setInusreListCode(String inusreListCode){
        this.inusreListCode = StringUtils.rightTrim(inusreListCode);
    }

    /**
     * 获取属性InusreListCode
     * @return 属性InusreListCode的值
     */
    public String getInusreListCode(){
        return inusreListCode;
    }

    /**
     * 设置属性IndexNo
     * @param indexNo 待设置的属性IndexNo的值
     */
    public void setIndexNo(String indexNo){
        this.indexNo = StringUtils.rightTrim(indexNo);
    }

    /**
     * 获取属性IndexNo
     * @return 属性IndexNo的值
     */
    public String getIndexNo(){
        return indexNo;
    }

    /**
     * 设置属性RiskCode
     * @param riskCode 待设置的属性RiskCode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性RiskCode
     * @return 属性RiskCode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性KindCode
     * @param kindCode 待设置的属性KindCode的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性KindCode
     * @return 属性KindCode的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性FamilyNo
     * @param familyNo 待设置的属性FamilyNo的值
     */
    public void setFamilyNo(String familyNo){
        this.familyNo = StringUtils.rightTrim(familyNo);
    }

    /**
     * 获取属性FamilyNo
     * @return 属性FamilyNo的值
     */
    public String getFamilyNo(){
        return familyNo;
    }

    /**
     * 设置属性FamilyName
     * @param familyName 待设置的属性FamilyName的值
     */
    public void setFamilyName(String familyName){
        this.familyName = StringUtils.rightTrim(familyName);
    }

    /**
     * 获取属性FamilyName
     * @return 属性FamilyName的值
     */
    public String getFamilyName(){
        return familyName;
    }

    /**
     * 设置属性FamilySex
     * @param familySex 待设置的属性FamilySex的值
     */
    public void setFamilySex(String familySex){
        this.familySex = StringUtils.rightTrim(familySex);
    }

    /**
     * 获取属性FamilySex
     * @return 属性FamilySex的值
     */
    public String getFamilySex(){
        return familySex;
    }

    /**
     * 设置属性FamilyFIdCard
     * @param familyFIdCard 待设置的属性FamilyFIdCard的值
     */
    public void setFamilyFIdCard(String familyFIdCard){
        this.familyFIdCard = StringUtils.rightTrim(familyFIdCard);
    }

    /**
     * 获取属性FamilyFIdCard
     * @return 属性FamilyFIdCard的值
     */
    public String getFamilyFIdCard(){
        return familyFIdCard;
    }

    /**
     * 设置属性Name
     * @param name 待设置的属性Name的值
     */
    public void setName(String name){
        this.name = StringUtils.rightTrim(name);
    }

    /**
     * 获取属性Name
     * @return 属性Name的值
     */
    public String getName(){
        return name;
    }

    /**
     * 设置属性Address
     * @param address 待设置的属性Address的值
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * 获取属性Address
     * @return 属性Address的值
     */
    public String getAddress(){
        return address;
    }

    /**
     * 设置属性Count
     * @param count 待设置的属性Count的值
     */
    public void setCount(String count){
        this.count = StringUtils.rightTrim(count);
    }

    /**
     * 获取属性Count
     * @return 属性Count的值
     */
    public String getCount(){
        return count;
    }

    /**
     * 设置属性UnitAmount
     * @param unitAmount 待设置的属性UnitAmount的值
     */
    public void setUnitAmount(double unitAmount){
        this.unitAmount = unitAmount;
    }

    /**
     * 获取属性UnitAmount
     * @return 属性UnitAmount的值
     */
    public double getUnitAmount(){
        return unitAmount;
    }

    /**
     * 设置属性SumAmount
     * @param sumAmount 待设置的属性SumAmount的值
     */
    public void setSumAmount(double sumAmount){
        this.sumAmount = sumAmount;
    }

    /**
     * 获取属性SumAmount
     * @return 属性SumAmount的值
     */
    public double getSumAmount(){
        return sumAmount;
    }

    /**
     * 设置属性SumPremium
     * @param sumPremium 待设置的属性SumPremium的值
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * 获取属性SumPremium
     * @return 属性SumPremium的值
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * 设置属性HandlerCode
     * @param handlerCode 待设置的属性HandlerCode的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性HandlerCode
     * @return 属性HandlerCode的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性InputDate
     * @param inputDate 待设置的属性InputDate的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性InputDate
     * @return 属性InputDate的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性StartDate
     * @param startDate 待设置的属性StartDate的值
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * 获取属性StartDate
     * @return 属性StartDate的值
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * 设置属性EndDate
     * @param endDate 待设置的属性EndDate的值
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * 获取属性EndDate
     * @return 属性EndDate的值
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * 设置属性Flag
     * @param flag 待设置的属性Flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性Flag
     * @return 属性Flag的值
     */
    public String getFlag(){
        return flag;
    }

    /**
     * 设置属性Remark
     * @param remark 待设置的属性Remark的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性Remark
     * @return 属性Remark的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性ItemCode
     * @param itemCode 待设置的属性ItemCode的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性ItemCode
     * @return 属性ItemCode的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性Rate
     * @param rate 待设置的属性Rate的值
     */
    public void setRate(String rate){
        this.rate = StringUtils.rightTrim(rate);
    }

    /**
     * 获取属性Rate
     * @return 属性Rate的值
     */
    public String getRate(){
        return rate;
    }

    /**
     * 设置属性FamilyFlag
     * @param familyFlag 待设置的属性FamilyFlag的值
     */
    public void setFamilyFlag(String familyFlag){
        this.familyFlag = StringUtils.rightTrim(familyFlag);
    }

    /**
     * 获取属性FamilyFlag
     * @return 属性FamilyFlag的值
     */
    public String getFamilyFlag(){
        return familyFlag;
    }

    /**
     * 设置属性ExportIndex
     * @param exportIndex 待设置的属性ExportIndex的值
     */
    public void setExportIndex(String exportIndex){
        this.exportIndex = StringUtils.rightTrim(exportIndex);
    }

    /**
     * 获取属性ExportIndex
     * @return 属性ExportIndex的值
     */
    public String getExportIndex(){
        return exportIndex;
    }

    /**
     * 设置属性PersonNo
     * @param personNo 待设置的属性PersonNo的值
     */
    public void setPersonNo(String personNo){
        this.personNo = StringUtils.rightTrim(personNo);
    }

    /**
     * 获取属性PersonNo
     * @return 属性PersonNo的值
     */
    public String getPersonNo(){
        return personNo;
    }
}
