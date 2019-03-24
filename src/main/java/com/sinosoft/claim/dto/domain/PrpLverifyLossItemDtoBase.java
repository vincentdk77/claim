package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLverifyLossItem定核损处理标的表的数据传输对象基类<br>
 * 创建于 2004-11-11 14:31:00.749<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLverifyLossItemDtoBase implements Serializable{
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性赔案号码 */
    private String claimNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性定损类型 */
    private String lossType = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性保单号码 */
    private String policyNo = "";
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
    /** 属性定损人 */
    private String handlerName = "";
    /** 属性定损结束日期 */
    private DateTime defLossDate = new DateTime();
    /** 属性核损人代码 */
    private String underWriteCode = "";
    /** 属性核损人名称 */
    private String underWriteName = "";
    /** 属性最终核损完成日期 */
    private DateTime underWriteEndDate = new DateTime();
    /** 属性核损标志 */
    private String underWriteFlag = "";
    /** 属性节点类型 */
    private String nodeType = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性备注(核损) */
    private String verifyRemark = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLverifyLossItemDtoBase对象
     */
    public PrpLverifyLossItemDtoBase(){
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
     * 设置属性赔案号码
     * @param claimNo 待设置的属性赔案号码的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号码
     * @return 属性赔案号码的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性序号
     * @param serialNo 待设置的属性序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性定损类型
     * @param lossType 待设置的属性定损类型的值
     */
    public void setLossType(String lossType){
        this.lossType = StringUtils.rightTrim(lossType);
    }

    /**
     * 获取属性定损类型
     * @return 属性定损类型的值
     */
    public String getLossType(){
        return lossType;
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
     * 设置属性定损人
     * @param handlerName 待设置的属性定损人的值
     */
    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * 获取属性定损人
     * @return 属性定损人的值
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
     * 设置属性核损标志
     * @param underWriteFlag 待设置的属性核损标志的值
     */
    public void setUnderWriteFlag(String underWriteFlag){
        this.underWriteFlag = StringUtils.rightTrim(underWriteFlag);
    }

    /**
     * 获取属性核损标志
     * @return 属性核损标志的值
     */
    public String getUnderWriteFlag(){
        return underWriteFlag;
    }

    /**
     * 设置属性节点类型
     * @param nodeType 待设置的属性节点类型的值
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * 获取属性节点类型
     * @return 属性节点类型的值
     */
    public String getNodeType(){
        return nodeType;
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
}
