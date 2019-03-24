package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdrate�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrateDtoBase implements Serializable{
    /** ����serialno */
    private int serialNo = 0;
    /** ����classcode */
    private String classCode = "";
    /** ����riskcode */
    private String riskCode = "";
    /** ����kindcode */
    private String kindCode = "";
    /** ����kindname */
    private String kindName = "";
    /** ����comcode */
    private String comCode = "";
    /** ����possessnature */
    private String possessNature = "";
    /** ����businesssource */
    private String businessSource = "";
    /** ����businessdetail */
    private String businessDetail = "";
    /** ����itemcode */
    private String itemCode = "";
    /** ����itemname */
    private String itemName = "";
    /** ����years */
    private int years = 0;
    /** ����preturnover */
    private double preturnOver = 0d;
    /** ����limittype */
    private String limitType = "";
    /** ����currency */
    private String currency = "";
    /** ����limitfeelower */
    private double limitFeeLower = 0d;
    /** ����limitfeeupper */
    private double limitFeeUpper = 0d;
    /** ����baseratelower */
    private double baseRateLower = 0d;
    /** ����baserateupper */
    private double baseRateUpper = 0d;
    /** ����rateratio */
    private double rateRatio = 0d;
    /** ����premium */
    private double premium = 0d;
    /** ����ratecode */
    private String rateCode = "";
    /** ����validdate */
    private DateTime validDate = new DateTime();
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDrateDtoBase����
     */
    public PrpDrateDtoBase(){
    }

    /**
     * ��������serialno
     * @param serialNo �����õ�����serialno��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����serialno
     * @return ����serialno��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ��������classcode
     * @param classCode �����õ�����classcode��ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ����classcode
     * @return ����classcode��ֵ
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * ��������riskcode
     * @param riskCode �����õ�����riskcode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����riskcode
     * @return ����riskcode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������kindcode
     * @param kindCode �����õ�����kindcode��ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ����kindcode
     * @return ����kindcode��ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * ��������kindname
     * @param kindName �����õ�����kindname��ֵ
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * ��ȡ����kindname
     * @return ����kindname��ֵ
     */
    public String getKindName(){
        return kindName;
    }

    /**
     * ��������comcode
     * @param comCode �����õ�����comcode��ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����comcode
     * @return ����comcode��ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������possessnature
     * @param possessNature �����õ�����possessnature��ֵ
     */
    public void setPossessNature(String possessNature){
        this.possessNature = StringUtils.rightTrim(possessNature);
    }

    /**
     * ��ȡ����possessnature
     * @return ����possessnature��ֵ
     */
    public String getPossessNature(){
        return possessNature;
    }

    /**
     * ��������businesssource
     * @param businessSource �����õ�����businesssource��ֵ
     */
    public void setBusinessSource(String businessSource){
        this.businessSource = StringUtils.rightTrim(businessSource);
    }

    /**
     * ��ȡ����businesssource
     * @return ����businesssource��ֵ
     */
    public String getBusinessSource(){
        return businessSource;
    }

    /**
     * ��������businessdetail
     * @param businessDetail �����õ�����businessdetail��ֵ
     */
    public void setBusinessDetail(String businessDetail){
        this.businessDetail = StringUtils.rightTrim(businessDetail);
    }

    /**
     * ��ȡ����businessdetail
     * @return ����businessdetail��ֵ
     */
    public String getBusinessDetail(){
        return businessDetail;
    }

    /**
     * ��������itemcode
     * @param itemCode �����õ�����itemcode��ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ����itemcode
     * @return ����itemcode��ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * ��������itemname
     * @param itemName �����õ�����itemname��ֵ
     */
    public void setItemName(String itemName){
        this.itemName = StringUtils.rightTrim(itemName);
    }

    /**
     * ��ȡ����itemname
     * @return ����itemname��ֵ
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * ��������years
     * @param years �����õ�����years��ֵ
     */
    public void setYears(int years){
        this.years = years;
    }

    /**
     * ��ȡ����years
     * @return ����years��ֵ
     */
    public int getYears(){
        return years;
    }

    /**
     * ��������preturnover
     * @param preturnOver �����õ�����preturnover��ֵ
     */
    public void setPreturnOver(double preturnOver){
        this.preturnOver = preturnOver;
    }

    /**
     * ��ȡ����preturnover
     * @return ����preturnover��ֵ
     */
    public double getPreturnOver(){
        return preturnOver;
    }

    /**
     * ��������limittype
     * @param limitType �����õ�����limittype��ֵ
     */
    public void setLimitType(String limitType){
        this.limitType = StringUtils.rightTrim(limitType);
    }

    /**
     * ��ȡ����limittype
     * @return ����limittype��ֵ
     */
    public String getLimitType(){
        return limitType;
    }

    /**
     * ��������currency
     * @param currency �����õ�����currency��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ����currency
     * @return ����currency��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ��������limitfeelower
     * @param limitFeeLower �����õ�����limitfeelower��ֵ
     */
    public void setLimitFeeLower(double limitFeeLower){
        this.limitFeeLower = limitFeeLower;
    }

    /**
     * ��ȡ����limitfeelower
     * @return ����limitfeelower��ֵ
     */
    public double getLimitFeeLower(){
        return limitFeeLower;
    }

    /**
     * ��������limitfeeupper
     * @param limitFeeUpper �����õ�����limitfeeupper��ֵ
     */
    public void setLimitFeeUpper(double limitFeeUpper){
        this.limitFeeUpper = limitFeeUpper;
    }

    /**
     * ��ȡ����limitfeeupper
     * @return ����limitfeeupper��ֵ
     */
    public double getLimitFeeUpper(){
        return limitFeeUpper;
    }

    /**
     * ��������baseratelower
     * @param baseRateLower �����õ�����baseratelower��ֵ
     */
    public void setBaseRateLower(double baseRateLower){
        this.baseRateLower = baseRateLower;
    }

    /**
     * ��ȡ����baseratelower
     * @return ����baseratelower��ֵ
     */
    public double getBaseRateLower(){
        return baseRateLower;
    }

    /**
     * ��������baserateupper
     * @param baseRateUpper �����õ�����baserateupper��ֵ
     */
    public void setBaseRateUpper(double baseRateUpper){
        this.baseRateUpper = baseRateUpper;
    }

    /**
     * ��ȡ����baserateupper
     * @return ����baserateupper��ֵ
     */
    public double getBaseRateUpper(){
        return baseRateUpper;
    }

    /**
     * ��������rateratio
     * @param rateRatio �����õ�����rateratio��ֵ
     */
    public void setRateRatio(double rateRatio){
        this.rateRatio = rateRatio;
    }

    /**
     * ��ȡ����rateratio
     * @return ����rateratio��ֵ
     */
    public double getRateRatio(){
        return rateRatio;
    }

    /**
     * ��������premium
     * @param premium �����õ�����premium��ֵ
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * ��ȡ����premium
     * @return ����premium��ֵ
     */
    public double getPremium(){
        return premium;
    }

    /**
     * ��������ratecode
     * @param rateCode �����õ�����ratecode��ֵ
     */
    public void setRateCode(String rateCode){
        this.rateCode = StringUtils.rightTrim(rateCode);
    }

    /**
     * ��ȡ����ratecode
     * @return ����ratecode��ֵ
     */
    public String getRateCode(){
        return rateCode;
    }

    /**
     * ��������validdate
     * @param validDate �����õ�����validdate��ֵ
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * ��ȡ����validdate
     * @return ����validdate��ֵ
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * ��������validstatus
     * @param validStatus �����õ�����validstatus��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����validstatus
     * @return ����validstatus��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
