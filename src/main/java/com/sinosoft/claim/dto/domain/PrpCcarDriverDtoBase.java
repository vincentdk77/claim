package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpccardriver车辆驾驶员关系表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCcarDriverDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性标的序号 */
    private int itemNo = 0;
    /** 属性顺序号 */
    private int serialNo = 0;
    /** 属性驾驶证号码 */
    private String drivingLicenseNo = "";
    /** 属性是否固定驾驶员标志 */
    private String changelessFlag = "";
    /** 属性驾驶员姓名 */
    private String driverName = "";
    /** 属性身份证号码 */
    private String identifynumber = "";
    /** 属性性别 */
    private String sex = "";
    /** 属性年龄 */
    private int age = 0;
    /** 属性婚姻状况 */
    private String marriage = "";
    /** 属性单位或地址 */
    private String driverAddress = "";
    /** 属性工作单位性质代码 */
    private String possessnature = "";
    /** 属性从业类别代码 */
    private String businessSource = "";
    /** 属性是否有违章扣分 */
    private int peccancy = 0;
    /** 属性初次领证日期 */
    private DateTime acceptLicenseDate = new DateTime();
    /** 属性领驾驶证年数 */
    private int receivelicenseyear = 0;
    /** 属性驾龄 */
    private int drivingYears = 0;
    /** 属性近两年肇事次数 */
    private int causetroubletimes = 0;
    /** 属性颁证机关 */
    private String awardLicenseOrgan = "";
    /** 属性准驾车型 */
    private String drivingCarType = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCcarDriverDtoBase对象
     */
    public PrpCcarDriverDtoBase(){
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
     * 设置属性标的序号
     * @param itemNo 待设置的属性标的序号的值
     */
    public void setItemNo(int itemNo){
        this.itemNo = itemNo;
    }

    /**
     * 获取属性标的序号
     * @return 属性标的序号的值
     */
    public int getItemNo(){
        return itemNo;
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
     * 设置属性驾驶证号码
     * @param drivingLicenseNo 待设置的属性驾驶证号码的值
     */
    public void setDrivingLicenseNo(String drivingLicenseNo){
        this.drivingLicenseNo = StringUtils.rightTrim(drivingLicenseNo);
    }

    /**
     * 获取属性驾驶证号码
     * @return 属性驾驶证号码的值
     */
    public String getDrivingLicenseNo(){
        return drivingLicenseNo;
    }

    /**
     * 设置属性是否固定驾驶员标志
     * @param changelessFlag 待设置的属性是否固定驾驶员标志的值
     */
    public void setChangelessFlag(String changelessFlag){
        this.changelessFlag = StringUtils.rightTrim(changelessFlag);
    }

    /**
     * 获取属性是否固定驾驶员标志
     * @return 属性是否固定驾驶员标志的值
     */
    public String getChangelessFlag(){
        return changelessFlag;
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
     * 设置属性身份证号码
     * @param identifynumber 待设置的属性身份证号码的值
     */
    public void setIdentifynumber(String identifynumber){
        this.identifynumber = StringUtils.rightTrim(identifynumber);
    }

    /**
     * 获取属性身份证号码
     * @return 属性身份证号码的值
     */
    public String getIdentifynumber(){
        return identifynumber;
    }

    /**
     * 设置属性性别
     * @param sex 待设置的属性性别的值
     */
    public void setSex(String sex){
        this.sex = StringUtils.rightTrim(sex);
    }

    /**
     * 获取属性性别
     * @return 属性性别的值
     */
    public String getSex(){
        return sex;
    }

    /**
     * 设置属性年龄
     * @param age 待设置的属性年龄的值
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * 获取属性年龄
     * @return 属性年龄的值
     */
    public int getAge(){
        return age;
    }

    /**
     * 设置属性婚姻状况
     * @param marriage 待设置的属性婚姻状况的值
     */
    public void setMarriage(String marriage){
        this.marriage = StringUtils.rightTrim(marriage);
    }

    /**
     * 获取属性婚姻状况
     * @return 属性婚姻状况的值
     */
    public String getMarriage(){
        return marriage;
    }

    /**
     * 设置属性单位或地址
     * @param driverAddress 待设置的属性单位或地址的值
     */
    public void setDriverAddress(String driverAddress){
        this.driverAddress = StringUtils.rightTrim(driverAddress);
    }

    /**
     * 获取属性单位或地址
     * @return 属性单位或地址的值
     */
    public String getDriverAddress(){
        return driverAddress;
    }

    /**
     * 设置属性工作单位性质代码
     * @param possessnature 待设置的属性工作单位性质代码的值
     */
    public void setPossessnature(String possessnature){
        this.possessnature = StringUtils.rightTrim(possessnature);
    }

    /**
     * 获取属性工作单位性质代码
     * @return 属性工作单位性质代码的值
     */
    public String getPossessnature(){
        return possessnature;
    }

    /**
     * 设置属性从业类别代码
     * @param businessSource 待设置的属性从业类别代码的值
     */
    public void setBusinessSource(String businessSource){
        this.businessSource = StringUtils.rightTrim(businessSource);
    }

    /**
     * 获取属性从业类别代码
     * @return 属性从业类别代码的值
     */
    public String getBusinessSource(){
        return businessSource;
    }

    /**
     * 设置属性是否有违章扣分
     * @param peccancy 待设置的属性是否有违章扣分的值
     */
    public void setPeccancy(int peccancy){
        this.peccancy = peccancy;
    }

    /**
     * 获取属性是否有违章扣分
     * @return 属性是否有违章扣分的值
     */
    public int getPeccancy(){
        return peccancy;
    }

    /**
     * 设置属性初次领证日期
     * @param acceptLicenseDate 待设置的属性初次领证日期的值
     */
    public void setAcceptLicenseDate(DateTime acceptLicenseDate){
        this.acceptLicenseDate = acceptLicenseDate;
    }

    /**
     * 获取属性初次领证日期
     * @return 属性初次领证日期的值
     */
    public DateTime getAcceptLicenseDate(){
        return acceptLicenseDate;
    }

    /**
     * 设置属性领驾驶证年数
     * @param receivelicenseyear 待设置的属性领驾驶证年数的值
     */
    public void setReceivelicenseyear(int receivelicenseyear){
        this.receivelicenseyear = receivelicenseyear;
    }

    /**
     * 获取属性领驾驶证年数
     * @return 属性领驾驶证年数的值
     */
    public int getReceivelicenseyear(){
        return receivelicenseyear;
    }

    /**
     * 设置属性驾龄
     * @param drivingYears 待设置的属性驾龄的值
     */
    public void setDrivingYears(int drivingYears){
        this.drivingYears = drivingYears;
    }

    /**
     * 获取属性驾龄
     * @return 属性驾龄的值
     */
    public int getDrivingYears(){
        return drivingYears;
    }

    /**
     * 设置属性近两年肇事次数
     * @param causetroubletimes 待设置的属性近两年肇事次数的值
     */
    public void setCausetroubletimes(int causetroubletimes){
        this.causetroubletimes = causetroubletimes;
    }

    /**
     * 获取属性近两年肇事次数
     * @return 属性近两年肇事次数的值
     */
    public int getCausetroubletimes(){
        return causetroubletimes;
    }

    /**
     * 设置属性颁证机关
     * @param awardLicenseOrgan 待设置的属性颁证机关的值
     */
    public void setAwardLicenseOrgan(String awardLicenseOrgan){
        this.awardLicenseOrgan = StringUtils.rightTrim(awardLicenseOrgan);
    }

    /**
     * 获取属性颁证机关
     * @return 属性颁证机关的值
     */
    public String getAwardLicenseOrgan(){
        return awardLicenseOrgan;
    }

    /**
     * 设置属性准驾车型
     * @param drivingCarType 待设置的属性准驾车型的值
     */
    public void setDrivingCarType(String drivingCarType){
        this.drivingCarType = StringUtils.rightTrim(drivingCarType);
    }

    /**
     * 获取属性准驾车型
     * @return 属性准驾车型的值
     */
    public String getDrivingCarType(){
        return drivingCarType;
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
