package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLassure-担保函（船舶）的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.656<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLassureDtoBase implements Serializable{
    /** 属性担保号 */
    private String assureNo = "";
    /** 属性关联担保号 */
    private String relativeAssureNo = "";
    /** 属性担保函类型 */
    private String assureTypeCode = "";
    /** 属性担保性质 */
    private String assureNatureCode = "";
    /** 属性担保原因 */
    private String assureReason = "";
    /** 属性赔案号 */
    private String claimNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性船舶险：船名 */
    private String shipName = "";
    /** 属性船舶险：船名（英文） */
    private String shipEName = "";
    /** 属性船东 */
    private String shipOwner = "";
    /** 属性航次 */
    private String voyage = "";
    /** 属性起始地 */
    private String startSiteName = "";
    /** 属性中转地 */
    private String viaSiteName = "";
    /** 属性目的地 */
    private String endSiteName = "";
    /** 属性扣押船法院 */
    private String countName = "";
    /** 属性法人代表 */
    private String artificialPerson = "";
    /** 属性保协名称 */
    private String piservice = "";
    /** 属性被侵权人 */
    private String bytortiousUnit = "";
    /** 属性被侵权标的 */
    private String bytortiousObject = "";
    /** 属性担保币种 */
    private String currency = "";
    /** 属性担保金额/反担保金额 */
    private double reverseAmount = 0d;
    /** 属性手续费金额 */
    private double commissionCharge = 0d;
    /** 属性损失金额 */
    private double sumLoss = 0d;
    /** 属性诉讼费用 */
    private double legalCost = 0d;
    /** 属性利息 */
    private double accrual = 0d;
    /** 属性其它费用 */
    private double otherFee = 0d;
    /** 属性是否不可撤销担保 */
    private String quashAssure = "";
    /** 属性担保人 */
    private String assurer = "";
    /** 属性收到日期 */
    private DateTime receiveDate = new DateTime();
    /** 属性复核人代码 */
    private String approverCode = "";
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性案情简要描述 */
    private String claimDescribe = "";
    /** 属性退还日期 */
    private DateTime returnDate = new DateTime();
    /** 属性退还经办人代码 */
    private String returnHandlerCode = "";
    /** 属性反担保人 */
    private String reverseCautioner = "";
    /** 属性承办人 */
    private String purveyor = "";
    /** 属性处（科）长意见 */
    private String chiefText = "";
    /** 属性申请担保人意见 */
    private String applicationText = "";
    /** 属性上级意见 */
    private String superText = "";
    /** 属性担保日期 */
    private DateTime assureDate = new DateTime();
    /** 属性输入日期 */
    private DateTime inputDate = new DateTime();
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLassureDtoBase对象
     */
    public PrpLassureDtoBase(){
    }

    /**
     * 设置属性担保号
     * @param assureNo 待设置的属性担保号的值
     */
    public void setAssureNo(String assureNo){
        this.assureNo = StringUtils.rightTrim(assureNo);
    }

    /**
     * 获取属性担保号
     * @return 属性担保号的值
     */
    public String getAssureNo(){
        return assureNo;
    }

    /**
     * 设置属性关联担保号
     * @param relativeAssureNo 待设置的属性关联担保号的值
     */
    public void setRelativeAssureNo(String relativeAssureNo){
        this.relativeAssureNo = StringUtils.rightTrim(relativeAssureNo);
    }

    /**
     * 获取属性关联担保号
     * @return 属性关联担保号的值
     */
    public String getRelativeAssureNo(){
        return relativeAssureNo;
    }

    /**
     * 设置属性担保函类型
     * @param assureTypeCode 待设置的属性担保函类型的值
     */
    public void setAssureTypeCode(String assureTypeCode){
        this.assureTypeCode = StringUtils.rightTrim(assureTypeCode);
    }

    /**
     * 获取属性担保函类型
     * @return 属性担保函类型的值
     */
    public String getAssureTypeCode(){
        return assureTypeCode;
    }

    /**
     * 设置属性担保性质
     * @param assureNatureCode 待设置的属性担保性质的值
     */
    public void setAssureNatureCode(String assureNatureCode){
        this.assureNatureCode = StringUtils.rightTrim(assureNatureCode);
    }

    /**
     * 获取属性担保性质
     * @return 属性担保性质的值
     */
    public String getAssureNatureCode(){
        return assureNatureCode;
    }

    /**
     * 设置属性担保原因
     * @param assureReason 待设置的属性担保原因的值
     */
    public void setAssureReason(String assureReason){
        this.assureReason = StringUtils.rightTrim(assureReason);
    }

    /**
     * 获取属性担保原因
     * @return 属性担保原因的值
     */
    public String getAssureReason(){
        return assureReason;
    }

    /**
     * 设置属性赔案号
     * @param claimNo 待设置的属性赔案号的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号
     * @return 属性赔案号的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性保单号码
     * @param policyNo 待设置的属性保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性船舶险：船名
     * @param shipName 待设置的属性船舶险：船名的值
     */
    public void setShipName(String shipName){
        this.shipName = StringUtils.rightTrim(shipName);
    }

    /**
     * 获取属性船舶险：船名
     * @return 属性船舶险：船名的值
     */
    public String getShipName(){
        return shipName;
    }

    /**
     * 设置属性船舶险：船名（英文）
     * @param shipEName 待设置的属性船舶险：船名（英文）的值
     */
    public void setShipEName(String shipEName){
        this.shipEName = StringUtils.rightTrim(shipEName);
    }

    /**
     * 获取属性船舶险：船名（英文）
     * @return 属性船舶险：船名（英文）的值
     */
    public String getShipEName(){
        return shipEName;
    }

    /**
     * 设置属性船东
     * @param shipOwner 待设置的属性船东的值
     */
    public void setShipOwner(String shipOwner){
        this.shipOwner = StringUtils.rightTrim(shipOwner);
    }

    /**
     * 获取属性船东
     * @return 属性船东的值
     */
    public String getShipOwner(){
        return shipOwner;
    }

    /**
     * 设置属性航次
     * @param voyage 待设置的属性航次的值
     */
    public void setVoyage(String voyage){
        this.voyage = StringUtils.rightTrim(voyage);
    }

    /**
     * 获取属性航次
     * @return 属性航次的值
     */
    public String getVoyage(){
        return voyage;
    }

    /**
     * 设置属性起始地
     * @param startSiteName 待设置的属性起始地的值
     */
    public void setStartSiteName(String startSiteName){
        this.startSiteName = StringUtils.rightTrim(startSiteName);
    }

    /**
     * 获取属性起始地
     * @return 属性起始地的值
     */
    public String getStartSiteName(){
        return startSiteName;
    }

    /**
     * 设置属性中转地
     * @param viaSiteName 待设置的属性中转地的值
     */
    public void setViaSiteName(String viaSiteName){
        this.viaSiteName = StringUtils.rightTrim(viaSiteName);
    }

    /**
     * 获取属性中转地
     * @return 属性中转地的值
     */
    public String getViaSiteName(){
        return viaSiteName;
    }

    /**
     * 设置属性目的地
     * @param endSiteName 待设置的属性目的地的值
     */
    public void setEndSiteName(String endSiteName){
        this.endSiteName = StringUtils.rightTrim(endSiteName);
    }

    /**
     * 获取属性目的地
     * @return 属性目的地的值
     */
    public String getEndSiteName(){
        return endSiteName;
    }

    /**
     * 设置属性扣押船法院
     * @param countName 待设置的属性扣押船法院的值
     */
    public void setCountName(String countName){
        this.countName = StringUtils.rightTrim(countName);
    }

    /**
     * 获取属性扣押船法院
     * @return 属性扣押船法院的值
     */
    public String getCountName(){
        return countName;
    }

    /**
     * 设置属性法人代表
     * @param artificialPerson 待设置的属性法人代表的值
     */
    public void setArtificialPerson(String artificialPerson){
        this.artificialPerson = StringUtils.rightTrim(artificialPerson);
    }

    /**
     * 获取属性法人代表
     * @return 属性法人代表的值
     */
    public String getArtificialPerson(){
        return artificialPerson;
    }

    /**
     * 设置属性保协名称
     * @param piservice 待设置的属性保协名称的值
     */
    public void setPiservice(String piservice){
        this.piservice = StringUtils.rightTrim(piservice);
    }

    /**
     * 获取属性保协名称
     * @return 属性保协名称的值
     */
    public String getPiservice(){
        return piservice;
    }

    /**
     * 设置属性被侵权人
     * @param bytortiousUnit 待设置的属性被侵权人的值
     */
    public void setBytortiousUnit(String bytortiousUnit){
        this.bytortiousUnit = StringUtils.rightTrim(bytortiousUnit);
    }

    /**
     * 获取属性被侵权人
     * @return 属性被侵权人的值
     */
    public String getBytortiousUnit(){
        return bytortiousUnit;
    }

    /**
     * 设置属性被侵权标的
     * @param bytortiousObject 待设置的属性被侵权标的的值
     */
    public void setBytortiousObject(String bytortiousObject){
        this.bytortiousObject = StringUtils.rightTrim(bytortiousObject);
    }

    /**
     * 获取属性被侵权标的
     * @return 属性被侵权标的的值
     */
    public String getBytortiousObject(){
        return bytortiousObject;
    }

    /**
     * 设置属性担保币种
     * @param currency 待设置的属性担保币种的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性担保币种
     * @return 属性担保币种的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性担保金额/反担保金额
     * @param reverseAmount 待设置的属性担保金额/反担保金额的值
     */
    public void setReverseAmount(double reverseAmount){
        this.reverseAmount = reverseAmount;
    }

    /**
     * 获取属性担保金额/反担保金额
     * @return 属性担保金额/反担保金额的值
     */
    public double getReverseAmount(){
        return reverseAmount;
    }

    /**
     * 设置属性手续费金额
     * @param commissionCharge 待设置的属性手续费金额的值
     */
    public void setCommissionCharge(double commissionCharge){
        this.commissionCharge = commissionCharge;
    }

    /**
     * 获取属性手续费金额
     * @return 属性手续费金额的值
     */
    public double getCommissionCharge(){
        return commissionCharge;
    }

    /**
     * 设置属性损失金额
     * @param sumLoss 待设置的属性损失金额的值
     */
    public void setSumLoss(double sumLoss){
        this.sumLoss = sumLoss;
    }

    /**
     * 获取属性损失金额
     * @return 属性损失金额的值
     */
    public double getSumLoss(){
        return sumLoss;
    }

    /**
     * 设置属性诉讼费用
     * @param legalCost 待设置的属性诉讼费用的值
     */
    public void setLegalCost(double legalCost){
        this.legalCost = legalCost;
    }

    /**
     * 获取属性诉讼费用
     * @return 属性诉讼费用的值
     */
    public double getLegalCost(){
        return legalCost;
    }

    /**
     * 设置属性利息
     * @param accrual 待设置的属性利息的值
     */
    public void setAccrual(double accrual){
        this.accrual = accrual;
    }

    /**
     * 获取属性利息
     * @return 属性利息的值
     */
    public double getAccrual(){
        return accrual;
    }

    /**
     * 设置属性其它费用
     * @param otherFee 待设置的属性其它费用的值
     */
    public void setOtherFee(double otherFee){
        this.otherFee = otherFee;
    }

    /**
     * 获取属性其它费用
     * @return 属性其它费用的值
     */
    public double getOtherFee(){
        return otherFee;
    }

    /**
     * 设置属性是否不可撤销担保
     * @param quashAssure 待设置的属性是否不可撤销担保的值
     */
    public void setQuashAssure(String quashAssure){
        this.quashAssure = StringUtils.rightTrim(quashAssure);
    }

    /**
     * 获取属性是否不可撤销担保
     * @return 属性是否不可撤销担保的值
     */
    public String getQuashAssure(){
        return quashAssure;
    }

    /**
     * 设置属性担保人
     * @param assurer 待设置的属性担保人的值
     */
    public void setAssurer(String assurer){
        this.assurer = StringUtils.rightTrim(assurer);
    }

    /**
     * 获取属性担保人
     * @return 属性担保人的值
     */
    public String getAssurer(){
        return assurer;
    }

    /**
     * 设置属性收到日期
     * @param receiveDate 待设置的属性收到日期的值
     */
    public void setReceiveDate(DateTime receiveDate){
        this.receiveDate = receiveDate;
    }

    /**
     * 获取属性收到日期
     * @return 属性收到日期的值
     */
    public DateTime getReceiveDate(){
        return receiveDate;
    }

    /**
     * 设置属性复核人代码
     * @param approverCode 待设置的属性复核人代码的值
     */
    public void setApproverCode(String approverCode){
        this.approverCode = StringUtils.rightTrim(approverCode);
    }

    /**
     * 获取属性复核人代码
     * @return 属性复核人代码的值
     */
    public String getApproverCode(){
        return approverCode;
    }

    /**
     * 设置属性经办人代码
     * @param handlerCode 待设置的属性经办人代码的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性经办人代码
     * @return 属性经办人代码的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性案情简要描述
     * @param claimDescribe 待设置的属性案情简要描述的值
     */
    public void setClaimDescribe(String claimDescribe){
        this.claimDescribe = StringUtils.rightTrim(claimDescribe);
    }

    /**
     * 获取属性案情简要描述
     * @return 属性案情简要描述的值
     */
    public String getClaimDescribe(){
        return claimDescribe;
    }

    /**
     * 设置属性退还日期
     * @param returnDate 待设置的属性退还日期的值
     */
    public void setReturnDate(DateTime returnDate){
        this.returnDate = returnDate;
    }

    /**
     * 获取属性退还日期
     * @return 属性退还日期的值
     */
    public DateTime getReturnDate(){
        return returnDate;
    }

    /**
     * 设置属性退还经办人代码
     * @param returnHandlerCode 待设置的属性退还经办人代码的值
     */
    public void setReturnHandlerCode(String returnHandlerCode){
        this.returnHandlerCode = StringUtils.rightTrim(returnHandlerCode);
    }

    /**
     * 获取属性退还经办人代码
     * @return 属性退还经办人代码的值
     */
    public String getReturnHandlerCode(){
        return returnHandlerCode;
    }

    /**
     * 设置属性反担保人
     * @param reverseCautioner 待设置的属性反担保人的值
     */
    public void setReverseCautioner(String reverseCautioner){
        this.reverseCautioner = StringUtils.rightTrim(reverseCautioner);
    }

    /**
     * 获取属性反担保人
     * @return 属性反担保人的值
     */
    public String getReverseCautioner(){
        return reverseCautioner;
    }

    /**
     * 设置属性承办人
     * @param purveyor 待设置的属性承办人的值
     */
    public void setPurveyor(String purveyor){
        this.purveyor = StringUtils.rightTrim(purveyor);
    }

    /**
     * 获取属性承办人
     * @return 属性承办人的值
     */
    public String getPurveyor(){
        return purveyor;
    }

    /**
     * 设置属性处（科）长意见
     * @param chiefText 待设置的属性处（科）长意见的值
     */
    public void setChiefText(String chiefText){
        this.chiefText = StringUtils.rightTrim(chiefText);
    }

    /**
     * 获取属性处（科）长意见
     * @return 属性处（科）长意见的值
     */
    public String getChiefText(){
        return chiefText;
    }

    /**
     * 设置属性申请担保人意见
     * @param applicationText 待设置的属性申请担保人意见的值
     */
    public void setApplicationText(String applicationText){
        this.applicationText = StringUtils.rightTrim(applicationText);
    }

    /**
     * 获取属性申请担保人意见
     * @return 属性申请担保人意见的值
     */
    public String getApplicationText(){
        return applicationText;
    }

    /**
     * 设置属性上级意见
     * @param superText 待设置的属性上级意见的值
     */
    public void setSuperText(String superText){
        this.superText = StringUtils.rightTrim(superText);
    }

    /**
     * 获取属性上级意见
     * @return 属性上级意见的值
     */
    public String getSuperText(){
        return superText;
    }

    /**
     * 设置属性担保日期
     * @param assureDate 待设置的属性担保日期的值
     */
    public void setAssureDate(DateTime assureDate){
        this.assureDate = assureDate;
    }

    /**
     * 获取属性担保日期
     * @return 属性担保日期的值
     */
    public DateTime getAssureDate(){
        return assureDate;
    }

    /**
     * 设置属性输入日期
     * @param inputDate 待设置的属性输入日期的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性输入日期
     * @return 属性输入日期的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性标志字段
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
     * @return 属性标志字段的值
     */
    public String getFlag(){
        return flag;
    }
}
