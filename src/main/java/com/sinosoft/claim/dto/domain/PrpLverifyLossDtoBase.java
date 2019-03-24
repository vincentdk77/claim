package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLverifyLoss－定核损主表的数据传输对象基类<br>
 * 创建于 2006-04-17 15:58:39.519<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLverifyLossDtoBase implements Serializable{
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性立案号码 */
    private String claimNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性标的序号 */
    private String lossItemCode = "";
    /** 属性车牌号码 */
    private String lossItemName = "";
    /** 属性是否为本保单车辆 */
    private String insureCarFlag = "";
    /** 属性被保险人 */
    private String insuredName = "";
    /** 属性号牌号码 */
    private String licenseNo = "";
    /** 属性号牌底色代码 */
    private String licenseColorcode = "";
    /** 属性号牌种类代码 */
    private String carKindCode = "";
    /** 属性币别代码 */
    private String currency = "";
    /** 属性定损总金额 */
    private double sumPreDefLoss = 0d;
    /** 属性核损总金额 */
    private double sumDefLoss = 0d;
    /** 属性出单机构 */
    private String makeCom = "";
    /** 属性业务归属机构代码 */
    private String comCode = "";
    /** 属性定损人代码 */
    private String handlerCode = "";
    /** 属性定损人（名称） */
    private String handlerName = "";
    /** 属性定损结束日期 */
    private DateTime defLossDate = new DateTime();
    /** 属性核损人代码 */
    private String underWriteCode = "";
    /** 属性核损人名称 */
    private String underWriteName = "";
    /** 属性最终核损完成日期 */
    private DateTime underWriteEndDate = new DateTime();
    /** 属性是否经过核损标志 */
    private String underWriteFlag = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性备注(核损) */
    private String verifyRemark = "";
    /** 属性标志字段 */
    private String flag = "";
    /** 属性回勘意见 */
    private String backCheckRemark = "";
    /** 属性人伤核损回退的原因 */
    private String veriwReturnReason = "";
    /** 属性核损意见 */
    private String verifyOpinion = "";
    /** 属性初次定损金额 */
    private double firstDefLoss = 0d;
    /** 属性偏差定损金额 */
    private double warpDefLoss = 0d;
    /** 属性核价人代码 */
    private String verpApproverCode = "";
    /** 属性核价时间 */
    private DateTime verpDate = new DateTime();
    /** 属性核价意见 */
    private String verpOpinion = "";
    /** 属性备注(核价) */
    private String verpRemark = "";
    /** 属性理算退回标记 */
    private String compensateFlag = "";
    /** 属性理算退回原因 */
    private String compensateOpinion = "";
    /** 属性理算退回时间 */
    private DateTime compensateBackDate = new DateTime();
    /** 属性理算退回的操作人 */
    private String compensateApproverCode = "";

    /**
     *  默认构造方法,构造一个默认的PrpLverifyLossDtoBase对象
     */
    public PrpLverifyLossDtoBase(){
    }

    /**
     * 设置属性报案号码
     * @param registNo 待设置的属性报案号码的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号码
     * @return 属性报案号码的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性立案号码
     * @param claimNo 待设置的属性立案号码的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性立案号码
     * @return 属性立案号码的值
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
     * 设置属性标的序号
     * @param lossItemCode 待设置的属性标的序号的值
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * 获取属性标的序号
     * @return 属性标的序号的值
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * 设置属性车牌号码
     * @param lossItemName 待设置的属性车牌号码的值
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * 获取属性车牌号码
     * @return 属性车牌号码的值
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * 设置属性是否为本保单车辆
     * @param insureCarFlag 待设置的属性是否为本保单车辆的值
     */
    public void setInsureCarFlag(String insureCarFlag){
        this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
    }

    /**
     * 获取属性是否为本保单车辆
     * @return 属性是否为本保单车辆的值
     */
    public String getInsureCarFlag(){
        return insureCarFlag;
    }

    /**
     * 设置属性被保险人
     * @param insuredName 待设置的属性被保险人的值
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * 获取属性被保险人
     * @return 属性被保险人的值
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * 设置属性号牌号码
     * @param licenseNo 待设置的属性号牌号码的值
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * 获取属性号牌号码
     * @return 属性号牌号码的值
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * 设置属性号牌底色代码
     * @param licenseColorcode 待设置的属性号牌底色代码的值
     */
    public void setLicenseColorcode(String licenseColorcode){
        this.licenseColorcode = StringUtils.rightTrim(licenseColorcode);
    }

    /**
     * 获取属性号牌底色代码
     * @return 属性号牌底色代码的值
     */
    public String getLicenseColorcode(){
        return licenseColorcode;
    }

    /**
     * 设置属性号牌种类代码
     * @param carKindCode 待设置的属性号牌种类代码的值
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * 获取属性号牌种类代码
     * @return 属性号牌种类代码的值
     */
    public String getCarKindCode(){
        return carKindCode;
    }

    /**
     * 设置属性币别代码
     * @param currency 待设置的属性币别代码的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别代码
     * @return 属性币别代码的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性定损总金额
     * @param sumPreDefLoss 待设置的属性定损总金额的值
     */
    public void setSumPreDefLoss(double sumPreDefLoss){
        this.sumPreDefLoss = sumPreDefLoss;
    }

    /**
     * 获取属性定损总金额
     * @return 属性定损总金额的值
     */
    public double getSumPreDefLoss(){
        return sumPreDefLoss;
    }

    /**
     * 设置属性核损总金额
     * @param sumDefLoss 待设置的属性核损总金额的值
     */
    public void setSumDefLoss(double sumDefLoss){
        this.sumDefLoss = sumDefLoss;
    }

    /**
     * 获取属性核损总金额
     * @return 属性核损总金额的值
     */
    public double getSumDefLoss(){
        return sumDefLoss;
    }

    /**
     * 设置属性出单机构
     * @param makeCom 待设置的属性出单机构的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性出单机构
     * @return 属性出单机构的值
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * 设置属性业务归属机构代码
     * @param comCode 待设置的属性业务归属机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性业务归属机构代码
     * @return 属性业务归属机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性定损人代码
     * @param handlerCode 待设置的属性定损人代码的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性定损人代码
     * @return 属性定损人代码的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性定损人（名称）
     * @param handlerName 待设置的属性定损人（名称）的值
     */
    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * 获取属性定损人（名称）
     * @return 属性定损人（名称）的值
     */
    public String getHandlerName(){
        return handlerName;
    }

    /**
     * 设置属性定损结束日期
     * @param defLossDate 待设置的属性定损结束日期的值
     */
    public void setDefLossDate(DateTime defLossDate){
        this.defLossDate = defLossDate;
    }

    /**
     * 获取属性定损结束日期
     * @return 属性定损结束日期的值
     */
    public DateTime getDefLossDate(){
        return defLossDate;
    }

    /**
     * 设置属性核损人代码
     * @param underWriteCode 待设置的属性核损人代码的值
     */
    public void setUnderWriteCode(String underWriteCode){
        this.underWriteCode = StringUtils.rightTrim(underWriteCode);
    }

    /**
     * 获取属性核损人代码
     * @return 属性核损人代码的值
     */
    public String getUnderWriteCode(){
        return underWriteCode;
    }

    /**
     * 设置属性核损人名称
     * @param underWriteName 待设置的属性核损人名称的值
     */
    public void setUnderWriteName(String underWriteName){
        this.underWriteName = StringUtils.rightTrim(underWriteName);
    }

    /**
     * 获取属性核损人名称
     * @return 属性核损人名称的值
     */
    public String getUnderWriteName(){
        return underWriteName;
    }

    /**
     * 设置属性最终核损完成日期
     * @param underWriteEndDate 待设置的属性最终核损完成日期的值
     */
    public void setUnderWriteEndDate(DateTime underWriteEndDate){
        this.underWriteEndDate = underWriteEndDate;
    }

    /**
     * 获取属性最终核损完成日期
     * @return 属性最终核损完成日期的值
     */
    public DateTime getUnderWriteEndDate(){
        return underWriteEndDate;
    }

    /**
     * 设置属性是否经过核损标志
     * @param underWriteFlag 待设置的属性是否经过核损标志的值
     */
    public void setUnderWriteFlag(String underWriteFlag){
        this.underWriteFlag = StringUtils.rightTrim(underWriteFlag);
    }

    /**
     * 获取属性是否经过核损标志
     * @return 属性是否经过核损标志的值
     */
    public String getUnderWriteFlag(){
        return underWriteFlag;
    }

    /**
     * 设置属性备注
     * @param remark 待设置的属性备注的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性备注(核损)
     * @param verifyRemark 待设置的属性备注(核损)的值
     */
    public void setVerifyRemark(String verifyRemark){
        this.verifyRemark = StringUtils.rightTrim(verifyRemark);
    }

    /**
     * 获取属性备注(核损)
     * @return 属性备注(核损)的值
     */
    public String getVerifyRemark(){
        return verifyRemark;
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

    /**
     * 设置属性回勘意见
     * @param backCheckRemark 待设置的属性回勘意见的值
     */
    public void setBackCheckRemark(String backCheckRemark){
        this.backCheckRemark = StringUtils.rightTrim(backCheckRemark);
    }

    /**
     * 获取属性回勘意见
     * @return 属性回勘意见的值
     */
    public String getBackCheckRemark(){
        return backCheckRemark;
    }

    /**
     * 设置属性人伤核损回退的原因
     * @param veriwReturnReason 待设置的属性人伤核损回退的原因的值
     */
    public void setVeriwReturnReason(String veriwReturnReason){
        this.veriwReturnReason = StringUtils.rightTrim(veriwReturnReason);
    }

    /**
     * 获取属性人伤核损回退的原因
     * @return 属性人伤核损回退的原因的值
     */
    public String getVeriwReturnReason(){
        return veriwReturnReason;
    }

    /**
     * 设置属性核损意见
     * @param verifyOpinion 待设置的属性核损意见的值
     */
    public void setVerifyOpinion(String verifyOpinion){
        this.verifyOpinion = StringUtils.rightTrim(verifyOpinion);
    }

    /**
     * 获取属性核损意见
     * @return 属性核损意见的值
     */
    public String getVerifyOpinion(){
        return verifyOpinion;
    }

    /**
     * 设置属性初次定损金额
     * @param firstDefLoss 待设置的属性初次定损金额的值
     */
    public void setFirstDefLoss(double firstDefLoss){
        this.firstDefLoss = firstDefLoss;
    }

    /**
     * 获取属性初次定损金额
     * @return 属性初次定损金额的值
     */
    public double getFirstDefLoss(){
        return firstDefLoss;
    }

    /**
     * 设置属性偏差定损金额
     * @param warpDefLoss 待设置的属性偏差定损金额的值
     */
    public void setWarpDefLoss(double warpDefLoss){
        this.warpDefLoss = warpDefLoss;
    }

    /**
     * 获取属性偏差定损金额
     * @return 属性偏差定损金额的值
     */
    public double getWarpDefLoss(){
        return warpDefLoss;
    }

    /**
     * 设置属性核价人代码
     * @param verpApproverCode 待设置的属性核价人代码的值
     */
    public void setVerpApproverCode(String verpApproverCode){
        this.verpApproverCode = StringUtils.rightTrim(verpApproverCode);
    }

    /**
     * 获取属性核价人代码
     * @return 属性核价人代码的值
     */
    public String getVerpApproverCode(){
        return verpApproverCode;
    }

    /**
     * 设置属性核价时间
     * @param verpDate 待设置的属性核价时间的值
     */
    public void setVerpDate(DateTime verpDate){
        this.verpDate = verpDate;
    }

    /**
     * 获取属性核价时间
     * @return 属性核价时间的值
     */
    public DateTime getVerpDate(){
        return verpDate;
    }

    /**
     * 设置属性核价意见
     * @param verpOpinion 待设置的属性核价意见的值
     */
    public void setVerpOpinion(String verpOpinion){
        this.verpOpinion = StringUtils.rightTrim(verpOpinion);
    }

    /**
     * 获取属性核价意见
     * @return 属性核价意见的值
     */
    public String getVerpOpinion(){
        return verpOpinion;
    }

    /**
     * 设置属性备注(核价)
     * @param verpRemark 待设置的属性备注(核价)的值
     */
    public void setVerpRemark(String verpRemark){
        this.verpRemark = StringUtils.rightTrim(verpRemark);
    }

    /**
     * 获取属性备注(核价)
     * @return 属性备注(核价)的值
     */
    public String getVerpRemark(){
        return verpRemark;
    }

    /**
     * 设置属性理算退回标记
     * @param compensateFlag 待设置的属性理算退回标记的值
     */
    public void setCompensateFlag(String compensateFlag){
        this.compensateFlag = StringUtils.rightTrim(compensateFlag);
    }

    /**
     * 获取属性理算退回标记
     * @return 属性理算退回标记的值
     */
    public String getCompensateFlag(){
        return compensateFlag;
    }

    /**
     * 设置属性理算退回原因
     * @param compensateOpinion 待设置的属性理算退回原因的值
     */
    public void setCompensateOpinion(String compensateOpinion){
        this.compensateOpinion = StringUtils.rightTrim(compensateOpinion);
    }

    /**
     * 获取属性理算退回原因
     * @return 属性理算退回原因的值
     */
    public String getCompensateOpinion(){
        return compensateOpinion;
    }

    /**
     * 设置属性理算退回时间
     * @param compensateBackDate 待设置的属性理算退回时间的值
     */
    public void setCompensateBackDate(DateTime compensateBackDate){
        this.compensateBackDate = compensateBackDate;
    }

    /**
     * 获取属性理算退回时间
     * @return 属性理算退回时间的值
     */
    public DateTime getCompensateBackDate(){
        return compensateBackDate;
    }

    /**
     * 设置属性理算退回的操作人
     * @param compensateApproverCode 待设置的属性理算退回的操作人的值
     */
    public void setCompensateApproverCode(String compensateApproverCode){
        this.compensateApproverCode = StringUtils.rightTrim(compensateApproverCode);
    }

    /**
     * 获取属性理算退回的操作人
     * @return 属性理算退回的操作人的值
     */
    public String getCompensateApproverCode(){
        return compensateApproverCode;
    }
}
