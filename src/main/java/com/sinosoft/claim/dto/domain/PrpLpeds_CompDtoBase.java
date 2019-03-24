package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLpeds_Comp换件清单接口数据表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:04<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpeds_CompDtoBase implements Serializable{
    /** 属性报案号 */
    private String registNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性被保险人 */
    private String insuredName = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性保单标的子险序号 */
    private int itemKindNo = 0;
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 属性牌照底色 */
    private String licenseColorCode = "";
    /** 属性车架号 */
    private String frameNo = "";
    /** 属性发动机号码 */
    private String engineNo = "";
    /** 属性车辆种类 */
    private String carKindCode = "";
    /** 属性部位名称 */
    private String partDesc = "";
    /** 属性修理项目代码 */
    private String compCode = "";
    /** 属性修理项目名称 */
    private String compName = "";
    /** 属性数量 */
    private int quantity = 0;
    /** 属性币别 */
    private String currency = "";
    /** 属性工时费 */
    private double manHourFee = 0d;
    /** 属性材料费 */
    private double materialFee = 0d;
    /** 属性是否处理标志 */
    private String transmitFlag = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLpeds_CompDtoBase对象
     */
    public PrpLpeds_CompDtoBase(){
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
     * 设置属性牌照底色
     * @param licenseColorCode 待设置的属性牌照底色的值
     */
    public void setLicenseColorCode(String licenseColorCode){
        this.licenseColorCode = StringUtils.rightTrim(licenseColorCode);
    }

    /**
     * 获取属性牌照底色
     * @return 属性牌照底色的值
     */
    public String getLicenseColorCode(){
        return licenseColorCode;
    }

    /**
     * 设置属性车架号
     * @param frameNo 待设置的属性车架号的值
     */
    public void setFrameNo(String frameNo){
        this.frameNo = StringUtils.rightTrim(frameNo);
    }

    /**
     * 获取属性车架号
     * @return 属性车架号的值
     */
    public String getFrameNo(){
        return frameNo;
    }

    /**
     * 设置属性发动机号码
     * @param engineNo 待设置的属性发动机号码的值
     */
    public void setEngineNo(String engineNo){
        this.engineNo = StringUtils.rightTrim(engineNo);
    }

    /**
     * 获取属性发动机号码
     * @return 属性发动机号码的值
     */
    public String getEngineNo(){
        return engineNo;
    }

    /**
     * 设置属性车辆种类
     * @param carKindCode 待设置的属性车辆种类的值
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * 获取属性车辆种类
     * @return 属性车辆种类的值
     */
    public String getCarKindCode(){
        return carKindCode;
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
     * 设置属性是否处理标志
     * @param transmitFlag 待设置的属性是否处理标志的值
     */
    public void setTransmitFlag(String transmitFlag){
        this.transmitFlag = StringUtils.rightTrim(transmitFlag);
    }

    /**
     * 获取属性是否处理标志
     * @return 属性是否处理标志的值
     */
    public String getTransmitFlag(){
        return transmitFlag;
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
}
