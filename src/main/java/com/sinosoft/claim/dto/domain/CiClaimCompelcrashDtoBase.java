package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CIClaimCompelcrash 理赔车车互碰数据表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CiClaimCompelcrashDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性报案号 */
    private String registNo = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性保险公司代码 */
    private String comCode = "";
    /** 属性车主姓名 */
    private String driverName = "";
    /** 属性身份证号码 */
    private String idNo = "";
    /** 属性电话号码 */
    private String telNo = "";
    /** 属性车牌号 */
    private String carNo = "";
    /** 属性车型 */
    private String carKind = "";
    /** 属性碰撞损坏部位 */
    private String damagePart = "";
    /** 属性过错方 */
    private String faultParty = "";
    /** 属性一方当事人过错行为 */
    private String faultBehavior = "";
    /** 属性出险时间 */
    private DateTime damageDate = new DateTime();
    /** 属性出险地点 */
    private String damageAddress = "";
    /** 属性报案时间 */
    private DateTime reportDate = new DateTime();
    /** 属性申请定损时间 */
    private DateTime applyCertainTime = new DateTime();
    /** 属性定损起始时间 */
    private DateTime certainStartTime =new DateTime();
    /** 属性甲乙双方标示 */
    private String actorFlag = "";
    /** 属性事故号 */
    private String accidentNo = "";
    /** 属性上传ID号 */
    private String upLoadNo = "";
    /** 属性关联报案号 */
    private String relatedRegistNo = "";

    /**
     *  默认构造方法,构造一个默认的CiClaimCompelcrashDtoBase对象
     */
    public CiClaimCompelcrashDtoBase(){
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
     * 设置属性保险公司代码
     * @param comCode 待设置的属性保险公司代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性保险公司代码
     * @return 属性保险公司代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性车主姓名
     * @param driverName 待设置的属性车主姓名的值
     */
    public void setDriverName(String driverName){
        this.driverName = StringUtils.rightTrim(driverName);
    }

    /**
     * 获取属性车主姓名
     * @return 属性车主姓名的值
     */
    public String getDriverName(){
        return driverName;
    }

    /**
     * 设置属性身份证号码
     * @param idNo 待设置的属性身份证号码的值
     */
    public void setIdNo(String idNo){
        this.idNo = StringUtils.rightTrim(idNo);
    }

    /**
     * 获取属性身份证号码
     * @return 属性身份证号码的值
     */
    public String getIdNo(){
        return idNo;
    }

    /**
     * 设置属性电话号码
     * @param telNo 待设置的属性电话号码的值
     */
    public void setTelNo(String telNo){
        this.telNo = StringUtils.rightTrim(telNo);
    }

    /**
     * 获取属性电话号码
     * @return 属性电话号码的值
     */
    public String getTelNo(){
        return telNo;
    }

    /**
     * 设置属性车牌号
     * @param carNo 待设置的属性车牌号的值
     */
    public void setCarNo(String carNo){
        this.carNo = StringUtils.rightTrim(carNo);
    }

    /**
     * 获取属性车牌号
     * @return 属性车牌号的值
     */
    public String getCarNo(){
        return carNo;
    }

    /**
     * 设置属性车型
     * @param carKind 待设置的属性车型的值
     */
    public void setCarKind(String carKind){
        this.carKind = StringUtils.rightTrim(carKind);
    }

    /**
     * 获取属性车型
     * @return 属性车型的值
     */
    public String getCarKind(){
        return carKind;
    }

    /**
     * 设置属性碰撞损坏部位
     * @param damagePart 待设置的属性碰撞损坏部位的值
     */
    public void setDamagePart(String damagePart){
        this.damagePart = StringUtils.rightTrim(damagePart);
    }

    /**
     * 获取属性碰撞损坏部位
     * @return 属性碰撞损坏部位的值
     */
    public String getDamagePart(){
        return damagePart;
    }

    /**
     * 设置属性过错方
     * @param faultParty 待设置的属性过错方的值
     */
    public void setFaultParty(String faultParty){
        this.faultParty = StringUtils.rightTrim(faultParty);
    }

    /**
     * 获取属性过错方
     * @return 属性过错方的值
     */
    public String getFaultParty(){
        return faultParty;
    }

    /**
     * 设置属性一方当事人过错行为
     * @param faultBehavior 待设置的属性一方当事人过错行为的值
     */
    public void setFaultBehavior(String faultBehavior){
        this.faultBehavior = StringUtils.rightTrim(faultBehavior);
    }

    /**
     * 获取属性一方当事人过错行为
     * @return 属性一方当事人过错行为的值
     */
    public String getFaultBehavior(){
        return faultBehavior;
    }

    /**
     * 设置属性出险时间
     * @param damageDate 待设置的属性出险时间的值
     */
    public void setDamageDate(DateTime damageDate){
        this.damageDate = damageDate;
    }

    /**
     * 获取属性出险时间
     * @return 属性出险时间的值
     */
    public DateTime getDamageDate(){
        return damageDate;
    }

    /**
     * 设置属性出险地点
     * @param damageAddress 待设置的属性出险地点的值
     */
    public void setDamageAddress(String damageAddress){
        this.damageAddress = StringUtils.rightTrim(damageAddress);
    }

    /**
     * 获取属性出险地点
     * @return 属性出险地点的值
     */
    public String getDamageAddress(){
        return damageAddress;
    }

    /**
     * 设置属性报案时间
     * @param reportDate 待设置的属性报案时间的值
     */
    public void setReportDate(DateTime reportDate){
        this.reportDate =  reportDate;
    }

    /**
     * 获取属性报案时间
     * @return 属性报案时间的值
     */
    public DateTime getReportDate(){
        return reportDate;
    }

    /**
     * 设置属性申请定损时间
     * @param applyCertainTime 待设置的属性申请定损时间的值
     */
    public void setApplyCertainTime(DateTime applyCertainTime){
        this.applyCertainTime =  applyCertainTime;
    }

    /**
     * 获取属性申请定损时间
     * @return 属性申请定损时间的值
     */
    public DateTime getApplyCertainTime(){
        return applyCertainTime;
    }

    /**
     * 设置属性定损起始时间
     * @param certainStartTime 待设置的属性定损起始时间的值
     */
    public void setCertainStartTime(DateTime certainStartTime){
        this.certainStartTime =  certainStartTime;
    }

    /**
     * 获取属性定损起始时间
     * @return 属性定损起始时间的值
     */
    public DateTime getCertainStartTime(){
        return certainStartTime;
    }

    /**
     * 设置属性甲乙双方标示
     * @param actorFlag 待设置的属性甲乙双方标示的值
     */
    public void setActorFlag(String actorFlag){
        this.actorFlag = StringUtils.rightTrim(actorFlag);
    }

    /**
     * 获取属性甲乙双方标示
     * @return 属性甲乙双方标示的值
     */
    public String getActorFlag(){
        return actorFlag;
    }

    /**
     * 设置属性事故号
     * @param accidentNo 待设置的属性事故号的值
     */
    public void setAccidentNo(String accidentNo){
        this.accidentNo = StringUtils.rightTrim(accidentNo);
    }

    /**
     * 获取属性事故号
     * @return 属性事故号的值
     */
    public String getAccidentNo(){
        return accidentNo;
    }

    /**
     * 设置属性上传ID号
     * @param upLoadNo 待设置的属性上传ID号的值
     */
    public void setUpLoadNo(String upLoadNo){
        this.upLoadNo = StringUtils.rightTrim(upLoadNo);
    }

    /**
     * 获取属性上传ID号
     * @return 属性上传ID号的值
     */
    public String getUpLoadNo(){
        return upLoadNo;
    }

    /**
     * 设置属性关联报案号
     * @param relatedRegistNo 待设置的属性关联报案号的值
     */
    public void setRelatedRegistNo(String relatedRegistNo){
        this.relatedRegistNo = StringUtils.rightTrim(relatedRegistNo);
    }

    /**
     * 获取属性关联报案号
     * @return 属性关联报案号的值
     */
    public String getRelatedRegistNo(){
        return relatedRegistNo;
    }
}
