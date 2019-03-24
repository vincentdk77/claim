package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLsalvation-特约救助表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.546<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLsalvationDtoBase implements Serializable{
    /** 属性报案号 */
    private String registNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性特约救助号 */
    private String salvationNo = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性号牌号码 */
    private String licenseNo = "";
    /** 属性牌照底色代码 */
    private String licenseColorCode = "";
    /** 属性发动机号 */
    private String engineNo = "";
    /** 属性车身颜色代码 */
    private String colorCode = "";
    /** 属性车型代码 */
    private String modelCode = "";
    /** 属性厂牌型号 */
    private String brandName = "";
    /** 属性驾驶员姓名 */
    private String driverName = "";
    /** 属性电话 */
    private String phone = "";
    /** 属性救助类型
--** 0:车险条款救助 1：其它救助 */
    private String salvaType = "";
    /** 属性发生事故时间 */
    private DateTime damageTime = new DateTime();
    /** 属性付费方式  0：免费救助 
--** 1：现场收费救助 */
    private String moneyFlag = "";
    /** 属性救助项目代码▲
--** 0: 拖车 1: 简易故障2: 送电
--** 3: 送油 4:更换轮胎
--** 5: 开锁 6: 其他 */
    private String salvaItemCode = "";
    /** 属性救助项目名称 */
    private String salvaItemName = "";
    /** 属性救助地点 */
    private String salvaSite = "";
    /** 属性车辆送至地点 */
    private String sendSite = "";
    /** 属性救助协助单位名称 */
    private String salvaAssistUnit = "";
    /** 属性救助协助单位经办人名称 */
    private String salvaUnitHandler = "";
    /** 属性拖运路线 */
    private String salvaRoute = "";
    /** 属性救助距离 */
    private double salvaMile = 0d;
    /** 属性承保公司代码 */
    private String insureUnitCode = "";
    /** 属性承保公司名称 */
    private String insureUnitName = "";
    /** 属性收费标准 */
    private String feeStandard = "";
    /** 属性救助费用 */
    private double salvaFee = 0d;
    /** 属性救助车到达时间 */
    private DateTime arriveDate = new DateTime();
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性输入日期 */
    private DateTime inputDate = new DateTime();
    /** 属性确认日期 */
    private DateTime verifyDate = new DateTime();
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLsalvationDtoBase对象
     */
    public PrpLsalvationDtoBase(){
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
     * 设置属性特约救助号
     * @param salvationNo 待设置的属性特约救助号的值
     */
    public void setSalvationNo(String salvationNo){
        this.salvationNo = StringUtils.rightTrim(salvationNo);
    }

    /**
     * 获取属性特约救助号
     * @return 属性特约救助号的值
     */
    public String getSalvationNo(){
        return salvationNo;
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
     * 设置属性牌照底色代码
     * @param licenseColorCode 待设置的属性牌照底色代码的值
     */
    public void setLicenseColorCode(String licenseColorCode){
        this.licenseColorCode = StringUtils.rightTrim(licenseColorCode);
    }

    /**
     * 获取属性牌照底色代码
     * @return 属性牌照底色代码的值
     */
    public String getLicenseColorCode(){
        return licenseColorCode;
    }

    /**
     * 设置属性发动机号
     * @param engineNo 待设置的属性发动机号的值
     */
    public void setEngineNo(String engineNo){
        this.engineNo = StringUtils.rightTrim(engineNo);
    }

    /**
     * 获取属性发动机号
     * @return 属性发动机号的值
     */
    public String getEngineNo(){
        return engineNo;
    }

    /**
     * 设置属性车身颜色代码
     * @param colorCode 待设置的属性车身颜色代码的值
     */
    public void setColorCode(String colorCode){
        this.colorCode = StringUtils.rightTrim(colorCode);
    }

    /**
     * 获取属性车身颜色代码
     * @return 属性车身颜色代码的值
     */
    public String getColorCode(){
        return colorCode;
    }

    /**
     * 设置属性车型代码
     * @param modelCode 待设置的属性车型代码的值
     */
    public void setModelCode(String modelCode){
        this.modelCode = StringUtils.rightTrim(modelCode);
    }

    /**
     * 获取属性车型代码
     * @return 属性车型代码的值
     */
    public String getModelCode(){
        return modelCode;
    }

    /**
     * 设置属性厂牌型号
     * @param brandName 待设置的属性厂牌型号的值
     */
    public void setBrandName(String brandName){
        this.brandName = StringUtils.rightTrim(brandName);
    }

    /**
     * 获取属性厂牌型号
     * @return 属性厂牌型号的值
     */
    public String getBrandName(){
        return brandName;
    }

    /**
     * 设置属性驾驶员姓名
     * @param driverName 待设置的属性驾驶员姓名的值
     */
    public void setDriverName(String driverName){
        this.driverName = StringUtils.rightTrim(driverName);
    }

    /**
     * 获取属性驾驶员姓名
     * @return 属性驾驶员姓名的值
     */
    public String getDriverName(){
        return driverName;
    }

    /**
     * 设置属性电话
     * @param phone 待设置的属性电话的值
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * 获取属性电话
     * @return 属性电话的值
     */
    public String getPhone(){
        return phone;
    }

    /**
     * 设置属性救助类型
--** 0:车险条款救助 1：其它救助
     * @param salvaType 待设置的属性救助类型
--** 0:车险条款救助 1：其它救助的值
     */
    public void setSalvaType(String salvaType){
        this.salvaType = StringUtils.rightTrim(salvaType);
    }

    /**
     * 获取属性救助类型
--** 0:车险条款救助 1：其它救助
     * @return 属性救助类型
--** 0:车险条款救助 1：其它救助的值
     */
    public String getSalvaType(){
        return salvaType;
    }

    /**
     * 设置属性发生事故时间
     * @param damageTime 待设置的属性发生事故时间的值
     */
    public void setDamageTime(DateTime damageTime){
        this.damageTime = damageTime;
    }

    /**
     * 获取属性发生事故时间
     * @return 属性发生事故时间的值
     */
    public DateTime getDamageTime(){
        return damageTime;
    }

    /**
     * 设置属性付费方式  0：免费救助 
--** 1：现场收费救助
     * @param moneyFlag 待设置的属性付费方式  0：免费救助 
--** 1：现场收费救助的值
     */
    public void setMoneyFlag(String moneyFlag){
        this.moneyFlag = StringUtils.rightTrim(moneyFlag);
    }

    /**
     * 获取属性付费方式  0：免费救助 
--** 1：现场收费救助
     * @return 属性付费方式  0：免费救助 
--** 1：现场收费救助的值
     */
    public String getMoneyFlag(){
        return moneyFlag;
    }

    /**
     * 设置属性救助项目代码▲
--** 0: 拖车 1: 简易故障2: 送电
--** 3: 送油 4:更换轮胎
--** 5: 开锁 6: 其他
     * @param salvaItemCode 待设置的属性救助项目代码▲
--** 0: 拖车 1: 简易故障2: 送电
--** 3: 送油 4:更换轮胎
--** 5: 开锁 6: 其他的值
     */
    public void setSalvaItemCode(String salvaItemCode){
        this.salvaItemCode = StringUtils.rightTrim(salvaItemCode);
    }

    /**
     * 获取属性救助项目代码▲
--** 0: 拖车 1: 简易故障2: 送电
--** 3: 送油 4:更换轮胎
--** 5: 开锁 6: 其他
     * @return 属性救助项目代码▲
--** 0: 拖车 1: 简易故障2: 送电
--** 3: 送油 4:更换轮胎
--** 5: 开锁 6: 其他的值
     */
    public String getSalvaItemCode(){
        return salvaItemCode;
    }

    /**
     * 设置属性救助项目名称
     * @param salvaItemName 待设置的属性救助项目名称的值
     */
    public void setSalvaItemName(String salvaItemName){
        this.salvaItemName = StringUtils.rightTrim(salvaItemName);
    }

    /**
     * 获取属性救助项目名称
     * @return 属性救助项目名称的值
     */
    public String getSalvaItemName(){
        return salvaItemName;
    }

    /**
     * 设置属性救助地点
     * @param salvaSite 待设置的属性救助地点的值
     */
    public void setSalvaSite(String salvaSite){
        this.salvaSite = StringUtils.rightTrim(salvaSite);
    }

    /**
     * 获取属性救助地点
     * @return 属性救助地点的值
     */
    public String getSalvaSite(){
        return salvaSite;
    }

    /**
     * 设置属性车辆送至地点
     * @param sendSite 待设置的属性车辆送至地点的值
     */
    public void setSendSite(String sendSite){
        this.sendSite = StringUtils.rightTrim(sendSite);
    }

    /**
     * 获取属性车辆送至地点
     * @return 属性车辆送至地点的值
     */
    public String getSendSite(){
        return sendSite;
    }

    /**
     * 设置属性救助协助单位名称
     * @param salvaAssistUnit 待设置的属性救助协助单位名称的值
     */
    public void setSalvaAssistUnit(String salvaAssistUnit){
        this.salvaAssistUnit = StringUtils.rightTrim(salvaAssistUnit);
    }

    /**
     * 获取属性救助协助单位名称
     * @return 属性救助协助单位名称的值
     */
    public String getSalvaAssistUnit(){
        return salvaAssistUnit;
    }

    /**
     * 设置属性救助协助单位经办人名称
     * @param salvaUnitHandler 待设置的属性救助协助单位经办人名称的值
     */
    public void setSalvaUnitHandler(String salvaUnitHandler){
        this.salvaUnitHandler = StringUtils.rightTrim(salvaUnitHandler);
    }

    /**
     * 获取属性救助协助单位经办人名称
     * @return 属性救助协助单位经办人名称的值
     */
    public String getSalvaUnitHandler(){
        return salvaUnitHandler;
    }

    /**
     * 设置属性拖运路线
     * @param salvaRoute 待设置的属性拖运路线的值
     */
    public void setSalvaRoute(String salvaRoute){
        this.salvaRoute = StringUtils.rightTrim(salvaRoute);
    }

    /**
     * 获取属性拖运路线
     * @return 属性拖运路线的值
     */
    public String getSalvaRoute(){
        return salvaRoute;
    }

    /**
     * 设置属性救助距离
     * @param salvaMile 待设置的属性救助距离的值
     */
    public void setSalvaMile(double salvaMile){
        this.salvaMile = salvaMile;
    }

    /**
     * 获取属性救助距离
     * @return 属性救助距离的值
     */
    public double getSalvaMile(){
        return salvaMile;
    }

    /**
     * 设置属性承保公司代码
     * @param insureUnitCode 待设置的属性承保公司代码的值
     */
    public void setInsureUnitCode(String insureUnitCode){
        this.insureUnitCode = StringUtils.rightTrim(insureUnitCode);
    }

    /**
     * 获取属性承保公司代码
     * @return 属性承保公司代码的值
     */
    public String getInsureUnitCode(){
        return insureUnitCode;
    }

    /**
     * 设置属性承保公司名称
     * @param insureUnitName 待设置的属性承保公司名称的值
     */
    public void setInsureUnitName(String insureUnitName){
        this.insureUnitName = StringUtils.rightTrim(insureUnitName);
    }

    /**
     * 获取属性承保公司名称
     * @return 属性承保公司名称的值
     */
    public String getInsureUnitName(){
        return insureUnitName;
    }

    /**
     * 设置属性收费标准
     * @param feeStandard 待设置的属性收费标准的值
     */
    public void setFeeStandard(String feeStandard){
        this.feeStandard = StringUtils.rightTrim(feeStandard);
    }

    /**
     * 获取属性收费标准
     * @return 属性收费标准的值
     */
    public String getFeeStandard(){
        return feeStandard;
    }

    /**
     * 设置属性救助费用
     * @param salvaFee 待设置的属性救助费用的值
     */
    public void setSalvaFee(double salvaFee){
        this.salvaFee = salvaFee;
    }

    /**
     * 获取属性救助费用
     * @return 属性救助费用的值
     */
    public double getSalvaFee(){
        return salvaFee;
    }

    /**
     * 设置属性救助车到达时间
     * @param arriveDate 待设置的属性救助车到达时间的值
     */
    public void setArriveDate(DateTime arriveDate){
        this.arriveDate = arriveDate;
    }

    /**
     * 获取属性救助车到达时间
     * @return 属性救助车到达时间的值
     */
    public DateTime getArriveDate(){
        return arriveDate;
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
     * 设置属性确认日期
     * @param verifyDate 待设置的属性确认日期的值
     */
    public void setVerifyDate(DateTime verifyDate){
        this.verifyDate = verifyDate;
    }

    /**
     * 获取属性确认日期
     * @return 属性确认日期的值
     */
    public DateTime getVerifyDate(){
        return verifyDate;
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
