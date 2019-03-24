package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLloss－赔付标的信息表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLlossDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性赔款计算书号 */
    private String compensateNo = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性赔付标的序号 */
    private int serialNo = 0;
    /** 属性保单标的子险序号 */
    private int itemKindNo = 0;
    /** 属性分户序号(仅用于集体家财险) */
    private int familyNo = 0;
    /** 属性分户名称(仅用于集体家财险) */
    private String familyName = "";
    /** 属性承保险别代码 */
    private String kindCode = "";
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 属性标的项目类别代码 */
    private String itemCode = "";
    /** 属性受损标的名称 */
    private String lossName = "";
    /** 属性受损标的地址 */
    private String itemAddress = "";
    /** 属性费用明细类别代码 */
    private String feeTypeCode = "";
    /** 属性费用明细类别 */
    private String feeTypeName = "";
    /** 属性受损标的数量 */
    private double lossQuantity = 0D;
    /** 属性数量单位 */
    private String unit = "";
    /** 属性单价 */
    private double unitPrice = 0D;
    /** 属性购买日期 */
    private DateTime buyDate = new DateTime();
    /** 属性总折旧率 */
    private double depreRate = 0D;
    /** 属性币别 */
    private String currency = "";
    /** 属性保险金额 */
    private double amount = 0D;
    /** 属性标的价值币别 */
    private String currency1 = "";
    /** 属性标的价值 */
    private double itemValue = 0D;
    /** 属性受损金额币别 */
    private String currency2 = "";
    /** 属性受损金额 */
    private double sumLoss = 0D;
    /** 属性剔除金额/残值/损余 */
    private double sumRest = 0D;
    /** 属性责任比例 */
    private double indemnityDutyRate = 0D;
    /** 属性赔付比例 */
    private double claimRate = 0D;
    /** 属性免赔额币别 */
    private String currency3 = "";
    /** 属性免赔率 */
    private double deductibleRate = 0D;
    /** 属性免赔额 */
    private double deductible = 0D;
    /** 属性实赔币别 */
    private String currency4 = "";
    /** 属性实赔金额 */
    private double sumRealPay = 0D;
    /** 属性标志字段 */
    private String flag = "";
    /** 属性剔除原因 */
    private String rejectReason = "";
    /** 属性事故责任免赔率 */
    private double dutyDeductibleRate = 0D;
    /** 属性驾驶员免赔率 */
    private double driverDeductibleRate = 0D;
    /** 属性备注 */
    private String remark = "";
    /** 属性协商比例 */
    private double arrangeRate = 0D;
    /** 属性核定赔偿 */
    private double sumDefPay = 0D;
    /** 赔付面积 */
    private double settleArea = 0D;
    /** 损失率 */
    private double lossrate = 0D;
    /** 车辆厂牌型号 */
    private String BrandCode ="";
    /** 共保业务总赔付金额（含我方与其他共保方） */
    private double coinsSumRealPaid = 0d ; 
    
    
    /**
     *  默认构造方法,构造一个默认的PrpLlossDtoBase对象
     */
    public PrpLlossDtoBase(){
    }

    /**
     * 设置属性赔款计算书号
     * @param compensateNo 待设置的属性赔款计算书号的值
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * 获取属性赔款计算书号
     * @return 属性赔款计算书号的值
     */
    public String getCompensateNo(){
        return compensateNo;
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
     * 设置属性赔付标的序号
     * @param serialNo 待设置的属性赔付标的序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性赔付标的序号
     * @return 属性赔付标的序号的值
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
     * 设置属性承保险别代码
     * @param kindCode 待设置的属性承保险别代码的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性承保险别代码
     * @return 属性承保险别代码的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性车牌号码
     * @param licenseNo 待设置的属性车牌号码的值
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * 获取属性车牌号码
     * @return 属性车牌号码的值
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * 设置属性标的项目类别代码
     * @param itemCode 待设置的属性标的项目类别代码的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性标的项目类别代码
     * @return 属性标的项目类别代码的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性受损标的名称
     * @param lossName 待设置的属性受损标的名称的值
     */
    public void setLossName(String lossName){
        this.lossName = StringUtils.rightTrim(lossName);
    }

    /**
     * 获取属性受损标的名称
     * @return 属性受损标的名称的值
     */
    public String getLossName(){
        return lossName;
    }

    /**
     * 设置属性受损标的地址
     * @param itemAddress 待设置的属性受损标的地址的值
     */
    public void setItemAddress(String itemAddress){
        this.itemAddress = StringUtils.rightTrim(itemAddress);
    }

    /**
     * 获取属性受损标的地址
     * @return 属性受损标的地址的值
     */
    public String getItemAddress(){
        return itemAddress;
    }

    /**
     * 设置属性费用明细类别代码
     * @param feeTypeCode 待设置的属性费用明细类别代码的值
     */
    public void setFeeTypeCode(String feeTypeCode){
        this.feeTypeCode = StringUtils.rightTrim(feeTypeCode);
    }

    /**
     * 获取属性费用明细类别代码
     * @return 属性费用明细类别代码的值
     */
    public String getFeeTypeCode(){
        return feeTypeCode;
    }

    /**
     * 设置属性费用明细类别
     * @param feeTypeName 待设置的属性费用明细类别的值
     */
    public void setFeeTypeName(String feeTypeName){
        this.feeTypeName = StringUtils.rightTrim(feeTypeName);
    }

    /**
     * 获取属性费用明细类别
     * @return 属性费用明细类别的值
     */
    public String getFeeTypeName(){
        return feeTypeName;
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
     * 设置属性保险金额
     * @param amount 待设置的属性保险金额的值
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * 获取属性保险金额
     * @return 属性保险金额的值
     */
    public double getAmount(){
        return amount;
    }

    /**
     * 设置属性标的价值币别
     * @param currency1 待设置的属性标的价值币别的值
     */
    public void setCurrency1(String currency1){
        this.currency1 = StringUtils.rightTrim(currency1);
    }

    /**
     * 获取属性标的价值币别
     * @return 属性标的价值币别的值
     */
    public String getCurrency1(){
        return currency1;
    }

    /**
     * 设置属性标的价值
     * @param itemValue 待设置的属性标的价值的值
     */
    public void setItemValue(double itemValue){
        this.itemValue = itemValue;
    }

    /**
     * 获取属性标的价值
     * @return 属性标的价值的值
     */
    public double getItemValue(){
        return itemValue;
    }

    /**
     * 设置属性受损金额币别
     * @param currency2 待设置的属性受损金额币别的值
     */
    public void setCurrency2(String currency2){
        this.currency2 = StringUtils.rightTrim(currency2);
    }

    /**
     * 获取属性受损金额币别
     * @return 属性受损金额币别的值
     */
    public String getCurrency2(){
        return currency2;
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
     * 设置属性剔除金额/残值/损余
     * @param sumRest 待设置的属性剔除金额/残值/损余的值
     */
    public void setSumRest(double sumRest){
        this.sumRest = sumRest;
    }

    /**
     * 获取属性剔除金额/残值/损余
     * @return 属性剔除金额/残值/损余的值
     */
    public double getSumRest(){
        return sumRest;
    }

    /**
     * 设置属性责任比例
     * @param indemnityDutyRate 待设置的属性责任比例的值
     */
    public void setIndemnityDutyRate(double indemnityDutyRate){
        this.indemnityDutyRate = indemnityDutyRate;
    }

    /**
     * 获取属性责任比例
     * @return 属性责任比例的值
     */
    public double getIndemnityDutyRate(){
        return indemnityDutyRate;
    }

    /**
     * 设置属性赔付比例
     * @param claimRate 待设置的属性赔付比例的值
     */
    public void setClaimRate(double claimRate){
        this.claimRate = claimRate;
    }

    /**
     * 获取属性赔付比例
     * @return 属性赔付比例的值
     */
    public double getClaimRate(){
        return claimRate;
    }

    /**
     * 设置属性免赔额币别
     * @param currency3 待设置的属性免赔额币别的值
     */
    public void setCurrency3(String currency3){
        this.currency3 = StringUtils.rightTrim(currency3);
    }

    /**
     * 获取属性免赔额币别
     * @return 属性免赔额币别的值
     */
    public String getCurrency3(){
        return currency3;
    }

    /**
     * 设置属性免赔率
     * @param deductibleRate 待设置的属性免赔率的值
     */
    public void setDeductibleRate(double deductibleRate){
        this.deductibleRate = deductibleRate;
    }

    /**
     * 获取属性免赔率
     * @return 属性免赔率的值
     */
    public double getDeductibleRate(){
        return deductibleRate;
    }

    /**
     * 设置属性免赔额
     * @param deductible 待设置的属性免赔额的值
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * 获取属性免赔额
     * @return 属性免赔额的值
     */
    public double getDeductible(){
        return deductible;
    }

    /**
     * 设置属性实赔币别
     * @param currency4 待设置的属性实赔币别的值
     */
    public void setCurrency4(String currency4){
        this.currency4 = StringUtils.rightTrim(currency4);
    }

    /**
     * 获取属性实赔币别
     * @return 属性实赔币别的值
     */
    public String getCurrency4(){
        return currency4;
    }

    /**
     * 设置属性实赔金额
     * @param sumRealPay 待设置的属性实赔金额的值
     */
    public void setSumRealPay(double sumRealPay){
        this.sumRealPay = sumRealPay;
    }

    /**
     * 获取属性实赔金额
     * @return 属性实赔金额的值
     */
    public double getSumRealPay(){
        return sumRealPay;
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
     * 设置属性事故责任免赔率
     * @param dutyDeductibleRate 待设置的属性事故责任免赔率的值
     */
    public void setDutyDeductibleRate(double dutyDeductibleRate){
        this.dutyDeductibleRate = dutyDeductibleRate;
    }

    /**
     * 获取属性事故责任免赔率
     * @return 属性事故责任免赔率的值
     */
    public double getDutyDeductibleRate(){
        return dutyDeductibleRate;
    }

    /**
     * 设置属性驾驶员免赔率
     * @param driverDeductibleRate 待设置的属性驾驶员免赔率的值
     */
    public void setDriverDeductibleRate(double driverDeductibleRate){
        this.driverDeductibleRate = driverDeductibleRate;
    }

    /**
     * 获取属性驾驶员免赔率
     * @return 属性驾驶员免赔率的值
     */
    public double getDriverDeductibleRate(){
        return driverDeductibleRate;
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
     * 设置属性协商比例
     * @param arrangeRate 待设置的属性协商比例的值
     */
    public void setArrangeRate(double arrangeRate){
        this.arrangeRate = arrangeRate;
    }

    /**
     * 获取属性协商比例
     * @return 属性协商比例的值
     */
    public double getArrangeRate(){
        return arrangeRate;
    }

    /**
     * 设置属性核定赔偿
     * @param sumDefPay 待设置的属性核定赔偿的值
     */
    public void setSumDefPay(double sumDefPay){
        this.sumDefPay = sumDefPay;
    }

    /**
     * 获取属性核定赔偿
     * @return 属性核定赔偿的值
     */
    public double getSumDefPay(){
        return sumDefPay;
    }

	/**
	 * @return the settleArea
	 */
	public double getSettleArea() {
		return settleArea;
	}

	/**
	 * @param settleArea the settleArea to set
	 */
	public void setSettleArea(double settleArea) {
		this.settleArea = settleArea;
	}

	/**
	 * @return the lossrate
	 */
	public double getLossrate() {
		return lossrate;
	}

	/**
	 * @param lossrate the lossrate to set
	 */
	public void setLossrate(double lossrate) {
		this.lossrate = lossrate;
	}

	public String getBrandCode() {
		return StringUtils.rightTrim(BrandCode);
	}

	public void setBrandCode(String brandCode) {
		BrandCode = StringUtils.rightTrim(brandCode);
	}

	public double getCoinsSumRealPaid() {
		return coinsSumRealPaid;
	}

	public void setCoinsSumRealPaid(double coinsSumRealPaid) {
		this.coinsSumRealPaid = coinsSumRealPaid;
	}
	
	
}
