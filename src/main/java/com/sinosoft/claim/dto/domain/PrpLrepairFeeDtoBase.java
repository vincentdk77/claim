package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLrepairFee－修理费用清单修理费用清单的数据传输对象基类<br>
 * 创建于 2006-04-24 10:56:38.753<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLrepairFeeDtoBase implements Serializable{
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
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 属性车牌底色代码 */
    private String licenseColorCode = "";
    /** 属性车辆种类代码 */
    private String carKindCode = "";
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
    /** 属性工时 */
    private double manHour = 0d;
    /** 属性工时单价 */
    private double manHourUnitPrice = 0d;
    /** 属性工时费 */
    private double manHourFee = 0d;
    /** 属性材料费 */
    private double materialFee = 0d;
    /** 属性赔偿比例 */
    private double lossRate = 0d;
    /** 属性币别 */
    private String currency = "";
    /** 属性核定损金额 */
    private double sumDefLoss = 0d;
    /** 属性备注 */
    private String remark = "";
    /** 属性标志字段 */
    private String flag = "";
    /** 属性工时(核损) */
    private double veriManHour = 0d;
    /** 属性工时单价(核损) */
    private double veriManUnitPrice = 0d;
    /** 属性工时费(核损) */
    private double veriManHourFee = 0d;
    /** 属性材料数量(核损) */
    private double veriMaterQuantity = 0d;
    /** 属性材料单价费(核损) */
    private double veriMaterUnitPrice = 0d;
    /** 属性材料费(核损) */
    private double veriMaterialFee = 0d;
    /** 属性赔偿比例 (核损) */
    private double veriLossRate = 0d;
    /** 属性核定损金额(核损) */
    private double veriSumLoss = 0d;
    /** 属性备注(核损意见) */
    private String veriRemark = "";
    /** 属性材料数量 */
    private double materialQuantity = 0d;
    /** 属性材料单价 */
    private double materialUnitPrice = 0d;
    /** 属性SUMCHECKLOSS */
    private double sumCheckLoss = 0d;
    /** 属性回勘分项目意见 */
    private String backCheckRemark = "";
    /** 属性标的代码 */
    private String lossItemCode = "";
    /** 属性损失部件代码 */
    private String partCode = "";
    /** 属性损失部件名称 */
    private String partName = "";
    /** 属性修理方式 */
    private String repairType = "";
    /** 属性初次定损金额 */
    private double firstSumDefLoss = 0d;
    /** 属性原有换件标记 */
    private String compensateBackFlag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLrepairFeeDtoBase对象
     */
    public PrpLrepairFeeDtoBase(){
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
     * 设置属性材料费
     * @param materialFee 待设置的属性材料费的值
     */
    public void setMaterialFee(double materialFee){
        this.materialFee = materialFee;
    }

    /**
     * 获取属性材料费
     * @return 属性材料费的值
     */
    public double getMaterialFee(){
        return materialFee;
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
     * 设置属性工时(核损)
     * @param veriManHour 待设置的属性工时(核损)的值
     */
    public void setVeriManHour(double veriManHour){
        this.veriManHour = veriManHour;
    }

    /**
     * 获取属性工时(核损)
     * @return 属性工时(核损)的值
     */
    public double getVeriManHour(){
        return veriManHour;
    }

    /**
     * 设置属性工时单价(核损)
     * @param veriManUnitPrice 待设置的属性工时单价(核损)的值
     */
    public void setVeriManUnitPrice(double veriManUnitPrice){
        this.veriManUnitPrice = veriManUnitPrice;
    }

    /**
     * 获取属性工时单价(核损)
     * @return 属性工时单价(核损)的值
     */
    public double getVeriManUnitPrice(){
        return veriManUnitPrice;
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
     * 设置属性材料数量(核损)
     * @param veriMaterQuantity 待设置的属性材料数量(核损)的值
     */
    public void setVeriMaterQuantity(double veriMaterQuantity){
        this.veriMaterQuantity = veriMaterQuantity;
    }

    /**
     * 获取属性材料数量(核损)
     * @return 属性材料数量(核损)的值
     */
    public double getVeriMaterQuantity(){
        return veriMaterQuantity;
    }

    /**
     * 设置属性材料单价费(核损)
     * @param veriMaterUnitPrice 待设置的属性材料单价费(核损)的值
     */
    public void setVeriMaterUnitPrice(double veriMaterUnitPrice){
        this.veriMaterUnitPrice = veriMaterUnitPrice;
    }

    /**
     * 获取属性材料单价费(核损)
     * @return 属性材料单价费(核损)的值
     */
    public double getVeriMaterUnitPrice(){
        return veriMaterUnitPrice;
    }

    /**
     * 设置属性材料费(核损)
     * @param veriMaterialFee 待设置的属性材料费(核损)的值
     */
    public void setVeriMaterialFee(double veriMaterialFee){
        this.veriMaterialFee = veriMaterialFee;
    }

    /**
     * 获取属性材料费(核损)
     * @return 属性材料费(核损)的值
     */
    public double getVeriMaterialFee(){
        return veriMaterialFee;
    }

    /**
     * 设置属性赔偿比例 (核损)
     * @param veriLossRate 待设置的属性赔偿比例 (核损)的值
     */
    public void setVeriLossRate(double veriLossRate){
        this.veriLossRate = veriLossRate;
    }

    /**
     * 获取属性赔偿比例 (核损)
     * @return 属性赔偿比例 (核损)的值
     */
    public double getVeriLossRate(){
        return veriLossRate;
    }

    /**
     * 设置属性核定损金额(核损)
     * @param veriSumLoss 待设置的属性核定损金额(核损)的值
     */
    public void setVeriSumLoss(double veriSumLoss){
        this.veriSumLoss = veriSumLoss;
    }

    /**
     * 获取属性核定损金额(核损)
     * @return 属性核定损金额(核损)的值
     */
    public double getVeriSumLoss(){
        return veriSumLoss;
    }

    /**
     * 设置属性备注(核损意见)
     * @param veriRemark 待设置的属性备注(核损意见)的值
     */
    public void setVeriRemark(String veriRemark){
        this.veriRemark = StringUtils.rightTrim(veriRemark);
    }

    /**
     * 获取属性备注(核损意见)
     * @return 属性备注(核损意见)的值
     */
    public String getVeriRemark(){
        return veriRemark;
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
     * 设置属性材料单价
     * @param materialUnitPrice 待设置的属性材料单价的值
     */
    public void setMaterialUnitPrice(double materialUnitPrice){
        this.materialUnitPrice = materialUnitPrice;
    }

    /**
     * 获取属性材料单价
     * @return 属性材料单价的值
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
     * 设置属性修理方式
     * @param repairType 待设置的属性修理方式的值
     */
    public void setRepairType(String repairType){
        this.repairType = StringUtils.rightTrim(repairType);
    }

    /**
     * 获取属性修理方式
     * @return 属性修理方式的值
     */
    public String getRepairType(){
        return repairType;
    }

    /**
     * 设置属性初次定损金额
     * @param firstSumDefLoss 待设置的属性初次定损金额的值
     */
    public void setFirstSumDefLoss(double firstSumDefLoss){
        this.firstSumDefLoss = firstSumDefLoss;
    }

    /**
     * 获取属性初次定损金额
     * @return 属性初次定损金额的值
     */
    public double getFirstSumDefLoss(){
        return firstSumDefLoss;
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
