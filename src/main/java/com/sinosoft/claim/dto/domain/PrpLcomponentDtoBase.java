package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLcomponent－换件项目清单的数据传输对象基类<br>
 * 创建于 2006-04-24 19:02:04.443<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcomponentDtoBase implements Serializable{
    /** 属性险种 */
    private String riskCode = "";
    /** 属性立案号 */
    private String claimNo = "";
    /** 属性报案号 */
    private String registNo = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性保单标的子险序号 */
    private int itemKindNo = 0;
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性标的代码 */
    private String lossItemCode = "";
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 属性车牌底色代码 */
    private String licenseColorCode = "";
    /** 属性车辆种类代码 */
    private String carKindCode = "";
    /** 属性制造年份 */
    private String makeYear = "";
    /** 属性变速箱型式 */
    private String gearboxType = "";
    /** 属性报价公司等级 */
    private String quoteCompanyGrade = "";
    /** 属性管理费比例 */
    private double manageFeeRate = 0d;
    /** 属性修理厂代码 */
    private String repairFactoryCode = "";
    /** 属性修理厂名称 */
    private String repairFactoryName = "";
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性拖修日期 */
    private DateTime repairStartDate = new DateTime();
    /** 属性修回日期 */
    private DateTime repairEndDate = new DateTime();
    /** 属性部位名称 */
    private String partDesc = "";
    /** 属性核准人 */
    private String sanctioner = "";
    /** 属性复核人代码 */
    private String approverCode = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性修理项目代码 */
    private String compCode = "";
    /** 属性修理项目名称 */
    private String compName = "";
    /** 属性数量 */
    private int quantity = 0;
    /** 属性工时费 */
    private double manHourFee = 0d;
    /** 属性材料费（上报价格） */
    private double materialFee = 0d;
    /** 属性询价价格 */
    private double queryPrice = 0d;
    /** 属性报价价格 */
    private double quotedPrice = 0d;
    /** 属性赔偿比例 */
    private double lossRate = 0d;
    /** 属性币别 */
    private String currency = "";
    /** 属性核定损金额（中间计算乘以数量） */
    private double sumDefLoss = 0d;
    /** 属性备注 */
    private String remark = "";
    /** 属性标志字段 */
    private String flag = "";
    /** 属性工时 */
    private double manHour = 0d;
    /** 属性工时单价 */
    private double manHourUnitPrice = 0d;
    /** 属性材料数量 */
    private double materialQuantity = 0d;
    /** 属性材料单价费 */
    private double materialUnitPrice = 0d;
    /** 属性SUMCHECKLOSS */
    private double sumCheckLoss = 0d;
    /** 属性数量(核损) */
    private int veriQuantity = 0;
    /** 属性工时费(核损) */
    private double veriManHourFee = 0d;
    /** 属性材料费(核损) */
    private double veriMaterFee = 0d;
    /** 属性赔偿比例(核损) */
    private double veriLossRate = 0d;
    /** 属性核定损金额(核损) */
    private double sumVeriLoss = 0d;
    /** 属性备注（核损意见） */
    private String veriRemark = "";
    /** 属性残值(核损) */
    private double veriRestFee = 0d;
    /** 属性残值 */
    private double sumReject = 0d;
    /** 属性剔除原因 */
    private String rejectReason = "";
    /** 属性残值1 */
    private double restFee = 0d;
    /** 属性回勘分项目意见 */
    private String backCheckRemark = "";
    /** 属性损失部件代码 */
    private String partCode = "";
    /** 属性损失部件名称 */
    private String partName = "";
    /** 属性零配件原厂编码 */
    private String originalId = "";
    /** 属性系统专修价格 */
    private double sys4SPrice = 0d;
    /** 属性系统市场价格 */
    private double sysMarketPrice = 0d;
    /** 属性系统配套价格 */
    private double sysMatchPrice = 0d;
    /** 属性本地专修价格 */
    private double native4SPrice = 0d;
    /** 属性本地市场价格 */
    private double nativeMarketPrice = 0d;
    /** 属性本地配套价格 */
    private double nativeMatchPrice = 0d;
    /** 属性零配件价格（核价） */
    private double verpCompPrice = 0d;
    /** 属性配件序号 */
    private int indId = 0;
    /** 属性FirstMaterialFee */
    private double firstMaterialFee = 0d;
    /** 属性VerpoFlag */
    private String verpoFlag = "";
    /** 属性原有换件标记 */
    private String compensateBackFlag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLcomponentDtoBase对象
     */
    public PrpLcomponentDtoBase(){
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
     * 设置属性标的代码
     * @param lossItemCode 待设置的属性标的代码的值
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * 获取属性标的代码
     * @return 属性标的代码的值
     */
    public String getLossItemCode(){
        return lossItemCode;
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
     * 设置属性车牌底色代码
     * @param licenseColorCode 待设置的属性车牌底色代码的值
     */
    public void setLicenseColorCode(String licenseColorCode){
        this.licenseColorCode = StringUtils.rightTrim(licenseColorCode);
    }

    /**
     * 获取属性车牌底色代码
     * @return 属性车牌底色代码的值
     */
    public String getLicenseColorCode(){
        return licenseColorCode;
    }

    /**
     * 设置属性车辆种类代码
     * @param carKindCode 待设置的属性车辆种类代码的值
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * 获取属性车辆种类代码
     * @return 属性车辆种类代码的值
     */
    public String getCarKindCode(){
        return carKindCode;
    }

    /**
     * 设置属性制造年份
     * @param makeYear 待设置的属性制造年份的值
     */
    public void setMakeYear(String makeYear){
        this.makeYear = StringUtils.rightTrim(makeYear);
    }

    /**
     * 获取属性制造年份
     * @return 属性制造年份的值
     */
    public String getMakeYear(){
        return makeYear;
    }

    /**
     * 设置属性变速箱型式
     * @param gearboxType 待设置的属性变速箱型式的值
     */
    public void setGearboxType(String gearboxType){
        this.gearboxType = StringUtils.rightTrim(gearboxType);
    }

    /**
     * 获取属性变速箱型式
     * @return 属性变速箱型式的值
     */
    public String getGearboxType(){
        return gearboxType;
    }

    /**
     * 设置属性报价公司等级
     * @param quoteCompanyGrade 待设置的属性报价公司等级的值
     */
    public void setQuoteCompanyGrade(String quoteCompanyGrade){
        this.quoteCompanyGrade = StringUtils.rightTrim(quoteCompanyGrade);
    }

    /**
     * 获取属性报价公司等级
     * @return 属性报价公司等级的值
     */
    public String getQuoteCompanyGrade(){
        return quoteCompanyGrade;
    }

    /**
     * 设置属性管理费比例
     * @param manageFeeRate 待设置的属性管理费比例的值
     */
    public void setManageFeeRate(double manageFeeRate){
        this.manageFeeRate = manageFeeRate;
    }

    /**
     * 获取属性管理费比例
     * @return 属性管理费比例的值
     */
    public double getManageFeeRate(){
        return manageFeeRate;
    }

    /**
     * 设置属性修理厂代码
     * @param repairFactoryCode 待设置的属性修理厂代码的值
     */
    public void setRepairFactoryCode(String repairFactoryCode){
        this.repairFactoryCode = StringUtils.rightTrim(repairFactoryCode);
    }

    /**
     * 获取属性修理厂代码
     * @return 属性修理厂代码的值
     */
    public String getRepairFactoryCode(){
        return repairFactoryCode;
    }

    /**
     * 设置属性修理厂名称
     * @param repairFactoryName 待设置的属性修理厂名称的值
     */
    public void setRepairFactoryName(String repairFactoryName){
        this.repairFactoryName = StringUtils.rightTrim(repairFactoryName);
    }

    /**
     * 获取属性修理厂名称
     * @return 属性修理厂名称的值
     */
    public String getRepairFactoryName(){
        return repairFactoryName;
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
     * 设置属性拖修日期
     * @param repairStartDate 待设置的属性拖修日期的值
     */
    public void setRepairStartDate(DateTime repairStartDate){
        this.repairStartDate = repairStartDate;
    }

    /**
     * 获取属性拖修日期
     * @return 属性拖修日期的值
     */
    public DateTime getRepairStartDate(){
        return repairStartDate;
    }

    /**
     * 设置属性修回日期
     * @param repairEndDate 待设置的属性修回日期的值
     */
    public void setRepairEndDate(DateTime repairEndDate){
        this.repairEndDate = repairEndDate;
    }

    /**
     * 获取属性修回日期
     * @return 属性修回日期的值
     */
    public DateTime getRepairEndDate(){
        return repairEndDate;
    }

    /**
     * 设置属性部位名称
     * @param partDesc 待设置的属性部位名称的值
     */
    public void setPartDesc(String partDesc){
        this.partDesc = StringUtils.rightTrim(partDesc);
    }

    /**
     * 获取属性部位名称
     * @return 属性部位名称的值
     */
    public String getPartDesc(){
        return partDesc;
    }

    /**
     * 设置属性核准人
     * @param sanctioner 待设置的属性核准人的值
     */
    public void setSanctioner(String sanctioner){
        this.sanctioner = StringUtils.rightTrim(sanctioner);
    }

    /**
     * 获取属性核准人
     * @return 属性核准人的值
     */
    public String getSanctioner(){
        return sanctioner;
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
     * 设置属性操作员代码
     * @param operatorCode 待设置的属性操作员代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性操作员代码
     * @return 属性操作员代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性修理项目代码
     * @param compCode 待设置的属性修理项目代码的值
     */
    public void setCompCode(String compCode){
        this.compCode = StringUtils.rightTrim(compCode);
    }

    /**
     * 获取属性修理项目代码
     * @return 属性修理项目代码的值
     */
    public String getCompCode(){
        return compCode;
    }

    /**
     * 设置属性修理项目名称
     * @param compName 待设置的属性修理项目名称的值
     */
    public void setCompName(String compName){
        this.compName = StringUtils.rightTrim(compName);
    }

    /**
     * 获取属性修理项目名称
     * @return 属性修理项目名称的值
     */
    public String getCompName(){
        return compName;
    }

    /**
     * 设置属性数量
     * @param quantity 待设置的属性数量的值
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * 获取属性数量
     * @return 属性数量的值
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * 设置属性工时费
     * @param manHourFee 待设置的属性工时费的值
     */
    public void setManHourFee(double manHourFee){
        this.manHourFee = manHourFee;
    }

    /**
     * 获取属性工时费
     * @return 属性工时费的值
     */
    public double getManHourFee(){
        return manHourFee;
    }

    /**
     * 设置属性材料费（上报价格）
     * @param materialFee 待设置的属性材料费（上报价格）的值
     */
    public void setMaterialFee(double materialFee){
        this.materialFee = materialFee;
    }

    /**
     * 获取属性材料费（上报价格）
     * @return 属性材料费（上报价格）的值
     */
    public double getMaterialFee(){
        return materialFee;
    }

    /**
     * 设置属性询价价格
     * @param queryPrice 待设置的属性询价价格的值
     */
    public void setQueryPrice(double queryPrice){
        this.queryPrice = queryPrice;
    }

    /**
     * 获取属性询价价格
     * @return 属性询价价格的值
     */
    public double getQueryPrice(){
        return queryPrice;
    }

    /**
     * 设置属性报价价格
     * @param quotedPrice 待设置的属性报价价格的值
     */
    public void setQuotedPrice(double quotedPrice){
        this.quotedPrice = quotedPrice;
    }

    /**
     * 获取属性报价价格
     * @return 属性报价价格的值
     */
    public double getQuotedPrice(){
        return quotedPrice;
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
     * 设置属性核定损金额（中间计算乘以数量）
     * @param sumDefLoss 待设置的属性核定损金额（中间计算乘以数量）的值
     */
    public void setSumDefLoss(double sumDefLoss){
        this.sumDefLoss = sumDefLoss;
    }

    /**
     * 获取属性核定损金额（中间计算乘以数量）
     * @return 属性核定损金额（中间计算乘以数量）的值
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
     * 设置属性工时
     * @param manHour 待设置的属性工时的值
     */
    public void setManHour(double manHour){
        this.manHour = manHour;
    }

    /**
     * 获取属性工时
     * @return 属性工时的值
     */
    public double getManHour(){
        return manHour;
    }

    /**
     * 设置属性工时单价
     * @param manHourUnitPrice 待设置的属性工时单价的值
     */
    public void setManHourUnitPrice(double manHourUnitPrice){
        this.manHourUnitPrice = manHourUnitPrice;
    }

    /**
     * 获取属性工时单价
     * @return 属性工时单价的值
     */
    public double getManHourUnitPrice(){
        return manHourUnitPrice;
    }

    /**
     * 设置属性材料数量
     * @param materialQuantity 待设置的属性材料数量的值
     */
    public void setMaterialQuantity(double materialQuantity){
        this.materialQuantity = materialQuantity;
    }

    /**
     * 获取属性材料数量
     * @return 属性材料数量的值
     */
    public double getMaterialQuantity(){
        return materialQuantity;
    }

    /**
     * 设置属性材料单价费
     * @param materialUnitPrice 待设置的属性材料单价费的值
     */
    public void setMaterialUnitPrice(double materialUnitPrice){
        this.materialUnitPrice = materialUnitPrice;
    }

    /**
     * 获取属性材料单价费
     * @return 属性材料单价费的值
     */
    public double getMaterialUnitPrice(){
        return materialUnitPrice;
    }

    /**
     * 设置属性SUMCHECKLOSS
     * @param sumCheckLoss 待设置的属性SUMCHECKLOSS的值
     */
    public void setSumCheckLoss(double sumCheckLoss){
        this.sumCheckLoss = sumCheckLoss;
    }

    /**
     * 获取属性SUMCHECKLOSS
     * @return 属性SUMCHECKLOSS的值
     */
    public double getSumCheckLoss(){
        return sumCheckLoss;
    }

    /**
     * 设置属性数量(核损)
     * @param veriQuantity 待设置的属性数量(核损)的值
     */
    public void setVeriQuantity(int veriQuantity){
        this.veriQuantity = veriQuantity;
    }

    /**
     * 获取属性数量(核损)
     * @return 属性数量(核损)的值
     */
    public int getVeriQuantity(){
        return veriQuantity;
    }

    /**
     * 设置属性工时费(核损)
     * @param veriManHourFee 待设置的属性工时费(核损)的值
     */
    public void setVeriManHourFee(double veriManHourFee){
        this.veriManHourFee = veriManHourFee;
    }

    /**
     * 获取属性工时费(核损)
     * @return 属性工时费(核损)的值
     */
    public double getVeriManHourFee(){
        return veriManHourFee;
    }

    /**
     * 设置属性材料费(核损)
     * @param veriMaterFee 待设置的属性材料费(核损)的值
     */
    public void setVeriMaterFee(double veriMaterFee){
        this.veriMaterFee = veriMaterFee;
    }

    /**
     * 获取属性材料费(核损)
     * @return 属性材料费(核损)的值
     */
    public double getVeriMaterFee(){
        return veriMaterFee;
    }

    /**
     * 设置属性赔偿比例(核损)
     * @param veriLossRate 待设置的属性赔偿比例(核损)的值
     */
    public void setVeriLossRate(double veriLossRate){
        this.veriLossRate = veriLossRate;
    }

    /**
     * 获取属性赔偿比例(核损)
     * @return 属性赔偿比例(核损)的值
     */
    public double getVeriLossRate(){
        return veriLossRate;
    }

    /**
     * 设置属性核定损金额(核损)
     * @param sumVeriLoss 待设置的属性核定损金额(核损)的值
     */
    public void setSumVeriLoss(double sumVeriLoss){
        this.sumVeriLoss = sumVeriLoss;
    }

    /**
     * 获取属性核定损金额(核损)
     * @return 属性核定损金额(核损)的值
     */
    public double getSumVeriLoss(){
        return sumVeriLoss;
    }

    /**
     * 设置属性备注（核损意见）
     * @param veriRemark 待设置的属性备注（核损意见）的值
     */
    public void setVeriRemark(String veriRemark){
        this.veriRemark = StringUtils.rightTrim(veriRemark);
    }

    /**
     * 获取属性备注（核损意见）
     * @return 属性备注（核损意见）的值
     */
    public String getVeriRemark(){
        return veriRemark;
    }

    /**
     * 设置属性残值(核损)
     * @param veriRestFee 待设置的属性残值(核损)的值
     */
    public void setVeriRestFee(double veriRestFee){
        this.veriRestFee = veriRestFee;
    }

    /**
     * 获取属性残值(核损)
     * @return 属性残值(核损)的值
     */
    public double getVeriRestFee(){
        return veriRestFee;
    }

    /**
     * 设置属性残值
     * @param sumReject 待设置的属性残值的值
     */
    public void setSumReject(double sumReject){
        this.sumReject = sumReject;
    }

    /**
     * 获取属性残值
     * @return 属性残值的值
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
     * 设置属性残值1
     * @param restFee 待设置的属性残值1的值
     */
    public void setRestFee(double restFee){
        this.restFee = restFee;
    }

    /**
     * 获取属性残值1
     * @return 属性残值1的值
     */
    public double getRestFee(){
        return restFee;
    }

    /**
     * 设置属性回勘分项目意见
     * @param backCheckRemark 待设置的属性回勘分项目意见的值
     */
    public void setBackCheckRemark(String backCheckRemark){
        this.backCheckRemark = StringUtils.rightTrim(backCheckRemark);
    }

    /**
     * 获取属性回勘分项目意见
     * @return 属性回勘分项目意见的值
     */
    public String getBackCheckRemark(){
        return backCheckRemark;
    }

    /**
     * 设置属性损失部件代码
     * @param partCode 待设置的属性损失部件代码的值
     */
    public void setPartCode(String partCode){
        this.partCode = StringUtils.rightTrim(partCode);
    }

    /**
     * 获取属性损失部件代码
     * @return 属性损失部件代码的值
     */
    public String getPartCode(){
        return partCode;
    }

    /**
     * 设置属性损失部件名称
     * @param partName 待设置的属性损失部件名称的值
     */
    public void setPartName(String partName){
        this.partName = StringUtils.rightTrim(partName);
    }

    /**
     * 获取属性损失部件名称
     * @return 属性损失部件名称的值
     */
    public String getPartName(){
        return partName;
    }

    /**
     * 设置属性零配件原厂编码
     * @param originalId 待设置的属性零配件原厂编码的值
     */
    public void setOriginalId(String originalId){
        this.originalId = StringUtils.rightTrim(originalId);
    }

    /**
     * 获取属性零配件原厂编码
     * @return 属性零配件原厂编码的值
     */
    public String getOriginalId(){
        return originalId;
    }

    /**
     * 设置属性系统专修价格
     * @param sys4SPrice 待设置的属性系统专修价格的值
     */
    public void setSys4SPrice(double sys4SPrice){
        this.sys4SPrice = sys4SPrice;
    }

    /**
     * 获取属性系统专修价格
     * @return 属性系统专修价格的值
     */
    public double getSys4SPrice(){
        return sys4SPrice;
    }

    /**
     * 设置属性系统市场价格
     * @param sysMarketPrice 待设置的属性系统市场价格的值
     */
    public void setSysMarketPrice(double sysMarketPrice){
        this.sysMarketPrice = sysMarketPrice;
    }

    /**
     * 获取属性系统市场价格
     * @return 属性系统市场价格的值
     */
    public double getSysMarketPrice(){
        return sysMarketPrice;
    }

    /**
     * 设置属性系统配套价格
     * @param sysMatchPrice 待设置的属性系统配套价格的值
     */
    public void setSysMatchPrice(double sysMatchPrice){
        this.sysMatchPrice = sysMatchPrice;
    }

    /**
     * 获取属性系统配套价格
     * @return 属性系统配套价格的值
     */
    public double getSysMatchPrice(){
        return sysMatchPrice;
    }

    /**
     * 设置属性本地专修价格
     * @param native4SPrice 待设置的属性本地专修价格的值
     */
    public void setNative4SPrice(double native4SPrice){
        this.native4SPrice = native4SPrice;
    }

    /**
     * 获取属性本地专修价格
     * @return 属性本地专修价格的值
     */
    public double getNative4SPrice(){
        return native4SPrice;
    }

    /**
     * 设置属性本地市场价格
     * @param nativeMarketPrice 待设置的属性本地市场价格的值
     */
    public void setNativeMarketPrice(double nativeMarketPrice){
        this.nativeMarketPrice = nativeMarketPrice;
    }

    /**
     * 获取属性本地市场价格
     * @return 属性本地市场价格的值
     */
    public double getNativeMarketPrice(){
        return nativeMarketPrice;
    }

    /**
     * 设置属性本地配套价格
     * @param nativeMatchPrice 待设置的属性本地配套价格的值
     */
    public void setNativeMatchPrice(double nativeMatchPrice){
        this.nativeMatchPrice = nativeMatchPrice;
    }

    /**
     * 获取属性本地配套价格
     * @return 属性本地配套价格的值
     */
    public double getNativeMatchPrice(){
        return nativeMatchPrice;
    }

    /**
     * 设置属性零配件价格（核价）
     * @param verpCompPrice 待设置的属性零配件价格（核价）的值
     */
    public void setVerpCompPrice(double verpCompPrice){
        this.verpCompPrice = verpCompPrice;
    }

    /**
     * 获取属性零配件价格（核价）
     * @return 属性零配件价格（核价）的值
     */
    public double getVerpCompPrice(){
        return verpCompPrice;
    }

    /**
     * 设置属性配件序号
     * @param indId 待设置的属性配件序号的值
     */
    public void setIndId(int indId){
        this.indId = indId;
    }

    /**
     * 获取属性配件序号
     * @return 属性配件序号的值
     */
    public int getIndId(){
        return indId;
    }

    /**
     * 设置属性FirstMaterialFee
     * @param firstMaterialFee 待设置的属性FirstMaterialFee的值
     */
    public void setFirstMaterialFee(double firstMaterialFee){
        this.firstMaterialFee = firstMaterialFee;
    }

    /**
     * 获取属性FirstMaterialFee
     * @return 属性FirstMaterialFee的值
     */
    public double getFirstMaterialFee(){
        return firstMaterialFee;
    }

    /**
     * 设置属性VerpoFlag
     * @param verpoFlag 待设置的属性VerpoFlag的值
     */
    public void setVerpoFlag(String verpoFlag){
        this.verpoFlag = StringUtils.rightTrim(verpoFlag);
    }

    /**
     * 获取属性VerpoFlag
     * @return 属性VerpoFlag的值
     */
    public String getVerpoFlag(){
        return verpoFlag;
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
}
