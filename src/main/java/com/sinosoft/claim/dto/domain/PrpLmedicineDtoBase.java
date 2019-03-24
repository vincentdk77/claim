package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLmedicine-雇员医药费清单表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.375<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLmedicineDtoBase implements Serializable{
    /** 属性赔案号 */
    private String claimNo = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性保单标的子险序号 */
    private int itemKindNo = 0;
    /** 属性分户序号(仅用于集体家财险) */
    private int familyNo = 0;
    /** 属性分户名称(仅用于集体家财险) */
    private String familyName = "";
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性保单标的项目代码 */
    private String itemCode = "";
    /** 属性雇员编码 */
    private String employeeCode = "";
    /** 属性雇员姓名 */
    private String employeeName = "";
    /** 属性各种费用代码--** 1-工伤医药费 
--** 2-误工工资
--** 5-计帐医药费 
--** 6-大病 0-其它 */
    private String feeTypeCode = "";
    /** 属性费用名称 */
    private String feeTypeName = "";
    /** 属性币别代码 */
    private String currency = "";
    /** 属性赔偿限额 */
    private double indemnityLimit = 0d;
    /** 属性收据数 */
    private int receiptCount = 0;
    /** 属性收据金额 */
    private double receiptAmt = 0d;
    /** 属性收据日期 */
    private DateTime receiptDate = new DateTime();
    /** 属性误工天数 */
    private int missWorkDays = 0;
    /** 属性受损金额 */
    private double sumLoss = 0d;
    /** 属性剔除金额 */
    private double sumReject = 0d;
    /** 属性剔除原因 */
    private String rejectReason = "";
    /** 属性赔偿比例 */
    private double lossRate = 0d;
    /** 属性核定损金额 */
    private double sumDefLoss = 0d;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLmedicineDtoBase对象
     */
    public PrpLmedicineDtoBase(){
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
     * 设置属性险种
     * @param riskCode 待设置的属性险种的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种
     * @return 属性险种的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性保单号
     * @param policyNo 待设置的属性保单号的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号
     * @return 属性保单号的值
     */
    public String getPolicyNo(){
        return policyNo;
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
     * 设置属性保单标的子险序号
     * @param itemKindNo 待设置的属性保单标的子险序号的值
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * 获取属性保单标的子险序号
     * @return 属性保单标的子险序号的值
     */
    public int getItemKindNo(){
        return itemKindNo;
    }

    /**
     * 设置属性分户序号(仅用于集体家财险)
     * @param familyNo 待设置的属性分户序号(仅用于集体家财险)的值
     */
    public void setFamilyNo(int familyNo){
        this.familyNo = familyNo;
    }

    /**
     * 获取属性分户序号(仅用于集体家财险)
     * @return 属性分户序号(仅用于集体家财险)的值
     */
    public int getFamilyNo(){
        return familyNo;
    }

    /**
     * 设置属性分户名称(仅用于集体家财险)
     * @param familyName 待设置的属性分户名称(仅用于集体家财险)的值
     */
    public void setFamilyName(String familyName){
        this.familyName = StringUtils.rightTrim(familyName);
    }

    /**
     * 获取属性分户名称(仅用于集体家财险)
     * @return 属性分户名称(仅用于集体家财险)的值
     */
    public String getFamilyName(){
        return familyName;
    }

    /**
     * 设置属性险别代码
     * @param kindCode 待设置的属性险别代码的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性险别代码
     * @return 属性险别代码的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性保单标的项目代码
     * @param itemCode 待设置的属性保单标的项目代码的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性保单标的项目代码
     * @return 属性保单标的项目代码的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性雇员编码
     * @param employeeCode 待设置的属性雇员编码的值
     */
    public void setEmployeeCode(String employeeCode){
        this.employeeCode = StringUtils.rightTrim(employeeCode);
    }

    /**
     * 获取属性雇员编码
     * @return 属性雇员编码的值
     */
    public String getEmployeeCode(){
        return employeeCode;
    }

    /**
     * 设置属性雇员姓名
     * @param employeeName 待设置的属性雇员姓名的值
     */
    public void setEmployeeName(String employeeName){
        this.employeeName = StringUtils.rightTrim(employeeName);
    }

    /**
     * 获取属性雇员姓名
     * @return 属性雇员姓名的值
     */
    public String getEmployeeName(){
        return employeeName;
    }

    /**
     * 设置属性各种费用代码--** 1-工伤医药费 
--** 2-误工工资
--** 5-计帐医药费 
--** 6-大病 0-其它
     * @param feeTypeCode 待设置的属性各种费用代码--** 1-工伤医药费 
--** 2-误工工资
--** 5-计帐医药费 
--** 6-大病 0-其它的值
     */
    public void setFeeTypeCode(String feeTypeCode){
        this.feeTypeCode = StringUtils.rightTrim(feeTypeCode);
    }

    /**
     * 获取属性各种费用代码--** 1-工伤医药费 
--** 2-误工工资
--** 5-计帐医药费 
--** 6-大病 0-其它
     * @return 属性各种费用代码--** 1-工伤医药费 
--** 2-误工工资
--** 5-计帐医药费 
--** 6-大病 0-其它的值
     */
    public String getFeeTypeCode(){
        return feeTypeCode;
    }

    /**
     * 设置属性费用名称
     * @param feeTypeName 待设置的属性费用名称的值
     */
    public void setFeeTypeName(String feeTypeName){
        this.feeTypeName = StringUtils.rightTrim(feeTypeName);
    }

    /**
     * 获取属性费用名称
     * @return 属性费用名称的值
     */
    public String getFeeTypeName(){
        return feeTypeName;
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
     * 设置属性赔偿限额
     * @param indemnityLimit 待设置的属性赔偿限额的值
     */
    public void setIndemnityLimit(double indemnityLimit){
        this.indemnityLimit = indemnityLimit;
    }

    /**
     * 获取属性赔偿限额
     * @return 属性赔偿限额的值
     */
    public double getIndemnityLimit(){
        return indemnityLimit;
    }

    /**
     * 设置属性收据数
     * @param receiptCount 待设置的属性收据数的值
     */
    public void setReceiptCount(int receiptCount){
        this.receiptCount = receiptCount;
    }

    /**
     * 获取属性收据数
     * @return 属性收据数的值
     */
    public int getReceiptCount(){
        return receiptCount;
    }

    /**
     * 设置属性收据金额
     * @param receiptAmt 待设置的属性收据金额的值
     */
    public void setReceiptAmt(double receiptAmt){
        this.receiptAmt = receiptAmt;
    }

    /**
     * 获取属性收据金额
     * @return 属性收据金额的值
     */
    public double getReceiptAmt(){
        return receiptAmt;
    }

    /**
     * 设置属性收据日期
     * @param receiptDate 待设置的属性收据日期的值
     */
    public void setReceiptDate(DateTime receiptDate){
        this.receiptDate = receiptDate;
    }

    /**
     * 获取属性收据日期
     * @return 属性收据日期的值
     */
    public DateTime getReceiptDate(){
        return receiptDate;
    }

    /**
     * 设置属性误工天数
     * @param missWorkDays 待设置的属性误工天数的值
     */
    public void setMissWorkDays(int missWorkDays){
        this.missWorkDays = missWorkDays;
    }

    /**
     * 获取属性误工天数
     * @return 属性误工天数的值
     */
    public int getMissWorkDays(){
        return missWorkDays;
    }

    /**
     * 设置属性受损金额
     * @param sumLoss 待设置的属性受损金额的值
     */
    public void setSumLoss(double sumLoss){
        this.sumLoss = sumLoss;
    }

    /**
     * 获取属性受损金额
     * @return 属性受损金额的值
     */
    public double getSumLoss(){
        return sumLoss;
    }

    /**
     * 设置属性剔除金额
     * @param sumReject 待设置的属性剔除金额的值
     */
    public void setSumReject(double sumReject){
        this.sumReject = sumReject;
    }

    /**
     * 获取属性剔除金额
     * @return 属性剔除金额的值
     */
    public double getSumReject(){
        return sumReject;
    }

    /**
     * 设置属性剔除原因
     * @param rejectReason 待设置的属性剔除原因的值
     */
    public void setRejectReason(String rejectReason){
        this.rejectReason = StringUtils.rightTrim(rejectReason);
    }

    /**
     * 获取属性剔除原因
     * @return 属性剔除原因的值
     */
    public String getRejectReason(){
        return rejectReason;
    }

    /**
     * 设置属性赔偿比例
     * @param lossRate 待设置的属性赔偿比例的值
     */
    public void setLossRate(double lossRate){
        this.lossRate = lossRate;
    }

    /**
     * 获取属性赔偿比例
     * @return 属性赔偿比例的值
     */
    public double getLossRate(){
        return lossRate;
    }

    /**
     * 设置属性核定损金额
     * @param sumDefLoss 待设置的属性核定损金额的值
     */
    public void setSumDefLoss(double sumDefLoss){
        this.sumDefLoss = sumDefLoss;
    }

    /**
     * 获取属性核定损金额
     * @return 属性核定损金额的值
     */
    public double getSumDefLoss(){
        return sumDefLoss;
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
