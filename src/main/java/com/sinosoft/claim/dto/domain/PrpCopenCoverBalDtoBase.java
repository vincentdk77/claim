package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpcopencoverbal协议结算记录表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCopenCoverBalDtoBase implements Serializable{
    /** 属性批单号 */
    private String endorseNo = "";
    /** 属性协议号 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性顺序号 */
    private int serialNo = 0;
    /** 属性本次结算发货登记保费 */
    private double sendPremium = 0d;
    /** 属性本次结算发货登记保额 */
    private double sendAmount = 0d;
    /** 属性本次结算逐单录入保费 */
    private double oneByOnePremium = 0d;
    /** 属性本次结算逐单录入保费1 */
    private double oneByOneAmount = 0d;
    /** 属性本次结算已交保费 */
    private double paidPremium = 0d;
    /** 属性本次结算已交保费1 */
    private double paidAmount = 0d;
    /** 属性本次结算送收付费系统保费 */
    private double sffPremium = 0d;
    /** 属性本次结算未送收付费系统保费 */
    private double unSffPremium = 0d;
    /** 属性催缴金额 */
    private double duePremium = 0d;
    /** 属性结算日期 */
    private DateTime balanceDate = new DateTime();
    /** 属性币别 */
    private String currency = "";
    /** 属性结算保费 */
    private double balancePremium = 0d;
    /** 属性结算保额 */
    private double balanceAmount = 0d;
    /** 属性国内结算比例 */
    private double domesticRate = 0d;
    /** 属性国内结算金额 */
    private double domesticPremium = 0d;
    /** 属性进口结算比例 */
    private double importRate = 0d;
    /** 属性进口结算金额 */
    private double importPremium = 0d;
    /** 属性出口港澳结算比例 */
    private double hkRate = 0d;
    /** 属性出口港澳结算金额 */
    private double hkPremium = 0d;
    /** 属性出口远洋结算比例 */
    private double oceanRate = 0d;
    /** 属性出口远洋结算金额 */
    private double oceanPremium = 0d;
    /** 属性操作员 */
    private String operatorCode = "";
    /** 属性机构代码 */
    private String comCode = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCopenCoverBalDtoBase对象
     */
    public PrpCopenCoverBalDtoBase(){
    }

    /**
     * 设置属性批单号
     * @param endorseNo 待设置的属性批单号的值
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * 获取属性批单号
     * @return 属性批单号的值
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * 设置属性协议号
     * @param policyNo 待设置的属性协议号的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性协议号
     * @return 属性协议号的值
     */
    public String getPolicyNo(){
        return policyNo;
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
     * 设置属性顺序号
     * @param serialNo 待设置的属性顺序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性顺序号
     * @return 属性顺序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性本次结算发货登记保费
     * @param sendPremium 待设置的属性本次结算发货登记保费的值
     */
    public void setSendPremium(double sendPremium){
        this.sendPremium = sendPremium;
    }

    /**
     * 获取属性本次结算发货登记保费
     * @return 属性本次结算发货登记保费的值
     */
    public double getSendPremium(){
        return sendPremium;
    }

    /**
     * 设置属性本次结算发货登记保额
     * @param sendAmount 待设置的属性本次结算发货登记保额的值
     */
    public void setSendAmount(double sendAmount){
        this.sendAmount = sendAmount;
    }

    /**
     * 获取属性本次结算发货登记保额
     * @return 属性本次结算发货登记保额的值
     */
    public double getSendAmount(){
        return sendAmount;
    }

    /**
     * 设置属性本次结算逐单录入保费
     * @param oneByOnePremium 待设置的属性本次结算逐单录入保费的值
     */
    public void setOneByOnePremium(double oneByOnePremium){
        this.oneByOnePremium = oneByOnePremium;
    }

    /**
     * 获取属性本次结算逐单录入保费
     * @return 属性本次结算逐单录入保费的值
     */
    public double getOneByOnePremium(){
        return oneByOnePremium;
    }

    /**
     * 设置属性本次结算逐单录入保费1
     * @param oneByOneAmount 待设置的属性本次结算逐单录入保费1的值
     */
    public void setOneByOneAmount(double oneByOneAmount){
        this.oneByOneAmount = oneByOneAmount;
    }

    /**
     * 获取属性本次结算逐单录入保费1
     * @return 属性本次结算逐单录入保费1的值
     */
    public double getOneByOneAmount(){
        return oneByOneAmount;
    }

    /**
     * 设置属性本次结算已交保费
     * @param paidPremium 待设置的属性本次结算已交保费的值
     */
    public void setPaidPremium(double paidPremium){
        this.paidPremium = paidPremium;
    }

    /**
     * 获取属性本次结算已交保费
     * @return 属性本次结算已交保费的值
     */
    public double getPaidPremium(){
        return paidPremium;
    }

    /**
     * 设置属性本次结算已交保费1
     * @param paidAmount 待设置的属性本次结算已交保费1的值
     */
    public void setPaidAmount(double paidAmount){
        this.paidAmount = paidAmount;
    }

    /**
     * 获取属性本次结算已交保费1
     * @return 属性本次结算已交保费1的值
     */
    public double getPaidAmount(){
        return paidAmount;
    }

    /**
     * 设置属性本次结算送收付费系统保费
     * @param sffPremium 待设置的属性本次结算送收付费系统保费的值
     */
    public void setSffPremium(double sffPremium){
        this.sffPremium = sffPremium;
    }

    /**
     * 获取属性本次结算送收付费系统保费
     * @return 属性本次结算送收付费系统保费的值
     */
    public double getSffPremium(){
        return sffPremium;
    }

    /**
     * 设置属性本次结算未送收付费系统保费
     * @param unSffPremium 待设置的属性本次结算未送收付费系统保费的值
     */
    public void setUnSffPremium(double unSffPremium){
        this.unSffPremium = unSffPremium;
    }

    /**
     * 获取属性本次结算未送收付费系统保费
     * @return 属性本次结算未送收付费系统保费的值
     */
    public double getUnSffPremium(){
        return unSffPremium;
    }

    /**
     * 设置属性催缴金额
     * @param duePremium 待设置的属性催缴金额的值
     */
    public void setDuePremium(double duePremium){
        this.duePremium = duePremium;
    }

    /**
     * 获取属性催缴金额
     * @return 属性催缴金额的值
     */
    public double getDuePremium(){
        return duePremium;
    }

    /**
     * 设置属性结算日期
     * @param balanceDate 待设置的属性结算日期的值
     */
    public void setBalanceDate(DateTime balanceDate){
        this.balanceDate = balanceDate;
    }

    /**
     * 获取属性结算日期
     * @return 属性结算日期的值
     */
    public DateTime getBalanceDate(){
        return balanceDate;
    }

    /**
     * 设置属性币别
     * @param currency 待设置的属性币别的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别
     * @return 属性币别的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性结算保费
     * @param balancePremium 待设置的属性结算保费的值
     */
    public void setBalancePremium(double balancePremium){
        this.balancePremium = balancePremium;
    }

    /**
     * 获取属性结算保费
     * @return 属性结算保费的值
     */
    public double getBalancePremium(){
        return balancePremium;
    }

    /**
     * 设置属性结算保额
     * @param balanceAmount 待设置的属性结算保额的值
     */
    public void setBalanceAmount(double balanceAmount){
        this.balanceAmount = balanceAmount;
    }

    /**
     * 获取属性结算保额
     * @return 属性结算保额的值
     */
    public double getBalanceAmount(){
        return balanceAmount;
    }

    /**
     * 设置属性国内结算比例
     * @param domesticRate 待设置的属性国内结算比例的值
     */
    public void setDomesticRate(double domesticRate){
        this.domesticRate = domesticRate;
    }

    /**
     * 获取属性国内结算比例
     * @return 属性国内结算比例的值
     */
    public double getDomesticRate(){
        return domesticRate;
    }

    /**
     * 设置属性国内结算金额
     * @param domesticPremium 待设置的属性国内结算金额的值
     */
    public void setDomesticPremium(double domesticPremium){
        this.domesticPremium = domesticPremium;
    }

    /**
     * 获取属性国内结算金额
     * @return 属性国内结算金额的值
     */
    public double getDomesticPremium(){
        return domesticPremium;
    }

    /**
     * 设置属性进口结算比例
     * @param importRate 待设置的属性进口结算比例的值
     */
    public void setImportRate(double importRate){
        this.importRate = importRate;
    }

    /**
     * 获取属性进口结算比例
     * @return 属性进口结算比例的值
     */
    public double getImportRate(){
        return importRate;
    }

    /**
     * 设置属性进口结算金额
     * @param importPremium 待设置的属性进口结算金额的值
     */
    public void setImportPremium(double importPremium){
        this.importPremium = importPremium;
    }

    /**
     * 获取属性进口结算金额
     * @return 属性进口结算金额的值
     */
    public double getImportPremium(){
        return importPremium;
    }

    /**
     * 设置属性出口港澳结算比例
     * @param hkRate 待设置的属性出口港澳结算比例的值
     */
    public void setHkRate(double hkRate){
        this.hkRate = hkRate;
    }

    /**
     * 获取属性出口港澳结算比例
     * @return 属性出口港澳结算比例的值
     */
    public double getHkRate(){
        return hkRate;
    }

    /**
     * 设置属性出口港澳结算金额
     * @param hkPremium 待设置的属性出口港澳结算金额的值
     */
    public void setHkPremium(double hkPremium){
        this.hkPremium = hkPremium;
    }

    /**
     * 获取属性出口港澳结算金额
     * @return 属性出口港澳结算金额的值
     */
    public double getHkPremium(){
        return hkPremium;
    }

    /**
     * 设置属性出口远洋结算比例
     * @param oceanRate 待设置的属性出口远洋结算比例的值
     */
    public void setOceanRate(double oceanRate){
        this.oceanRate = oceanRate;
    }

    /**
     * 获取属性出口远洋结算比例
     * @return 属性出口远洋结算比例的值
     */
    public double getOceanRate(){
        return oceanRate;
    }

    /**
     * 设置属性出口远洋结算金额
     * @param oceanPremium 待设置的属性出口远洋结算金额的值
     */
    public void setOceanPremium(double oceanPremium){
        this.oceanPremium = oceanPremium;
    }

    /**
     * 获取属性出口远洋结算金额
     * @return 属性出口远洋结算金额的值
     */
    public double getOceanPremium(){
        return oceanPremium;
    }

    /**
     * 设置属性操作员
     * @param operatorCode 待设置的属性操作员的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性操作员
     * @return 属性操作员的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性机构代码
     * @param comCode 待设置的属性机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性机构代码
     * @return 属性机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public String getFlag(){
        return flag;
    }
}
