package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLprop－财产核定损明细清单表的数据传输对象基类<br>
 * 创建于 2006-04-24 17:46:12.358<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpropDtoBase implements Serializable{
    /** 属性立案号 */
    private String claimNo = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性报案号 */
    private String registNo = "";
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
    /** 属性损失项目类别 */
    private String lossItemCode = "";
    /** 属性损失项目名称 */
    private String lossItemName = "";
    /** 属性各种费用代码 */
    private String feeTypeCode = "";
    /** 属性费用名称 */
    private String feeTypeName = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性单价 */
    private double unitPrice = 0d;
    /** 属性受损标的数量 */
    private double lossQuantity = 0d;
    /** 属性数量单位 */
    private String unit = "";
    /** 属性购买日期 */
    private DateTime buyDate = new DateTime();
    /** 属性总折旧率 */
    private double depreRate = 0d;
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
    /** 属性备注 */
    private String remark = "";
    /** 属性标志字段 */
    private String flag = "";
    /** 属性单价(核损） */
    private double veriUnitPrice = 0d;
    /** 属性受损标的数量(核损） */
    private double veriLossQuantity = 0d;
    /** 属性数量单位(核损） */
    private String veriUnit = "";
    /** 属性总折旧率(核损） */
    private double veriDepreRate = 0d;
    /** 属性受损金额(核损） */
    private double veriSumLoss = 0d;
    /** 属性剔除金额(核损） */
    private double veriSumReject = 0d;
    /** 属性剔除原因(核损） */
    private String veriRejectReason = "";
    /** 属性赔偿比例(核损） */
    private double veriLossRate = 0d;
    /** 属性核定损金额(核损） */
    private double veriSumDefLoss = 0d;
    /** 属性备注(核损） */
    private String veriRemark = "";
    /** 属性原有换件标记 */
    private String compensateBackFlag = "";
    /** 属性车辆编号 自行车第三者责任使用 */
    private String licenseNo = "";
    /** 属性车辆厂牌型号 自行车第三者责任使用 */
    private String modelNo = "";

    
    
    /**
     *  默认构造方法,构造一个默认的PrpLpropDtoBase对象
     */
    public PrpLpropDtoBase(){
    }

    /**
     * 设置属性立案号
     * @param claimNo 待设置的属性立案号的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性立案号
     * @return 属性立案号的值
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
     * 设置属性报案号
     * @param registNo 待设置的属性报案号的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号
     * @return 属性报案号的值
     */
    public String getRegistNo(){
        return registNo;
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
     * 设置属性损失项目类别
     * @param lossItemCode 待设置的属性损失项目类别的值
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * 获取属性损失项目类别
     * @return 属性损失项目类别的值
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * 设置属性损失项目名称
     * @param lossItemName 待设置的属性损失项目名称的值
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * 获取属性损失项目名称
     * @return 属性损失项目名称的值
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * 设置属性各种费用代码
     * @param feeTypeCode 待设置的属性各种费用代码的值
     */
    public void setFeeTypeCode(String feeTypeCode){
        this.feeTypeCode = StringUtils.rightTrim(feeTypeCode);
    }

    /**
     * 获取属性各种费用代码
     * @return 属性各种费用代码的值
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
     * 设置属性单价
     * @param unitPrice 待设置的属性单价的值
     */
    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }

    /**
     * 获取属性单价
     * @return 属性单价的值
     */
    public double getUnitPrice(){
        return unitPrice;
    }

    /**
     * 设置属性受损标的数量
     * @param lossQuantity 待设置的属性受损标的数量的值
     */
    public void setLossQuantity(double lossQuantity){
        this.lossQuantity = lossQuantity;
    }

    /**
     * 获取属性受损标的数量
     * @return 属性受损标的数量的值
     */
    public double getLossQuantity(){
        return lossQuantity;
    }

    /**
     * 设置属性数量单位
     * @param unit 待设置的属性数量单位的值
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * 获取属性数量单位
     * @return 属性数量单位的值
     */
    public String getUnit(){
        return unit;
    }

    /**
     * 设置属性购买日期
     * @param buyDate 待设置的属性购买日期的值
     */
    public void setBuyDate(DateTime buyDate){
        this.buyDate = buyDate;
    }

    /**
     * 获取属性购买日期
     * @return 属性购买日期的值
     */
    public DateTime getBuyDate(){
        return buyDate;
    }

    /**
     * 设置属性总折旧率
     * @param depreRate 待设置的属性总折旧率的值
     */
    public void setDepreRate(double depreRate){
        this.depreRate = depreRate;
    }

    /**
     * 获取属性总折旧率
     * @return 属性总折旧率的值
     */
    public double getDepreRate(){
        return depreRate;
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
     * 设置属性单价(核损）
     * @param veriUnitPrice 待设置的属性单价(核损）的值
     */
    public void setVeriUnitPrice(double veriUnitPrice){
        this.veriUnitPrice = veriUnitPrice;
    }

    /**
     * 获取属性单价(核损）
     * @return 属性单价(核损）的值
     */
    public double getVeriUnitPrice(){
        return veriUnitPrice;
    }

    /**
     * 设置属性受损标的数量(核损）
     * @param veriLossQuantity 待设置的属性受损标的数量(核损）的值
     */
    public void setVeriLossQuantity(double veriLossQuantity){
        this.veriLossQuantity = veriLossQuantity;
    }

    /**
     * 获取属性受损标的数量(核损）
     * @return 属性受损标的数量(核损）的值
     */
    public double getVeriLossQuantity(){
        return veriLossQuantity;
    }

    /**
     * 设置属性数量单位(核损）
     * @param veriUnit 待设置的属性数量单位(核损）的值
     */
    public void setVeriUnit(String veriUnit){
        this.veriUnit = StringUtils.rightTrim(veriUnit);
    }

    /**
     * 获取属性数量单位(核损）
     * @return 属性数量单位(核损）的值
     */
    public String getVeriUnit(){
        return veriUnit;
    }

    /**
     * 设置属性总折旧率(核损）
     * @param veriDepreRate 待设置的属性总折旧率(核损）的值
     */
    public void setVeriDepreRate(double veriDepreRate){
        this.veriDepreRate = veriDepreRate;
    }

    /**
     * 获取属性总折旧率(核损）
     * @return 属性总折旧率(核损）的值
     */
    public double getVeriDepreRate(){
        return veriDepreRate;
    }

    /**
     * 设置属性受损金额(核损）
     * @param veriSumLoss 待设置的属性受损金额(核损）的值
     */
    public void setVeriSumLoss(double veriSumLoss){
        this.veriSumLoss = veriSumLoss;
    }

    /**
     * 获取属性受损金额(核损）
     * @return 属性受损金额(核损）的值
     */
    public double getVeriSumLoss(){
        return veriSumLoss;
    }

    /**
     * 设置属性剔除金额(核损）
     * @param veriSumReject 待设置的属性剔除金额(核损）的值
     */
    public void setVeriSumReject(double veriSumReject){
        this.veriSumReject = veriSumReject;
    }

    /**
     * 获取属性剔除金额(核损）
     * @return 属性剔除金额(核损）的值
     */
    public double getVeriSumReject(){
        return veriSumReject;
    }

    /**
     * 设置属性剔除原因(核损）
     * @param veriRejectReason 待设置的属性剔除原因(核损）的值
     */
    public void setVeriRejectReason(String veriRejectReason){
        this.veriRejectReason = StringUtils.rightTrim(veriRejectReason);
    }

    /**
     * 获取属性剔除原因(核损）
     * @return 属性剔除原因(核损）的值
     */
    public String getVeriRejectReason(){
        return veriRejectReason;
    }

    /**
     * 设置属性赔偿比例(核损）
     * @param veriLossRate 待设置的属性赔偿比例(核损）的值
     */
    public void setVeriLossRate(double veriLossRate){
        this.veriLossRate = veriLossRate;
    }

    /**
     * 获取属性赔偿比例(核损）
     * @return 属性赔偿比例(核损）的值
     */
    public double getVeriLossRate(){
        return veriLossRate;
    }

    /**
     * 设置属性核定损金额(核损）
     * @param veriSumDefLoss 待设置的属性核定损金额(核损）的值
     */
    public void setVeriSumDefLoss(double veriSumDefLoss){
        this.veriSumDefLoss = veriSumDefLoss;
    }

    /**
     * 获取属性核定损金额(核损）
     * @return 属性核定损金额(核损）的值
     */
    public double getVeriSumDefLoss(){
        return veriSumDefLoss;
    }

    /**
     * 设置属性备注(核损）
     * @param veriRemark 待设置的属性备注(核损）的值
     */
    public void setVeriRemark(String veriRemark){
        this.veriRemark = StringUtils.rightTrim(veriRemark);
    }

    /**
     * 获取属性备注(核损）
     * @return 属性备注(核损）的值
     */
    public String getVeriRemark(){
        return veriRemark;
    }

    /**
     * 设置属性原有换件标记
     * @param compensateBackFlag 待设置的属性原有换件标记的值
     */
    public void setCompensateBackFlag(String compensateBackFlag){
        this.compensateBackFlag = StringUtils.rightTrim(compensateBackFlag);
    }

    /**
     * 获取属性原有换件标记
     * @return 属性原有换件标记的值
     */
    public String getCompensateBackFlag(){
        return compensateBackFlag;
    }

	public String getLicenseNo() {
		return StringUtils.rightTrim(licenseNo);
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = StringUtils.rightTrim(licenseNo);
	}

	public String getModelNo() {
		return StringUtils.rightTrim(modelNo);
	}

	public void setModelNo(String modelNo) {
		this.modelNo = StringUtils.rightTrim(modelNo);
	}
    
    
    
}
