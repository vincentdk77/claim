package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpddriver机动车险司机代码表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDdriverDtoBase implements Serializable{
    /** 属性驾驶员驾驶证号码 */
    private String drivingLicenseNo = "";
    /** 属性驾驶员姓名 */
    private String driverName = "";
    /** 属性驾驶员性别 */
    private String driverSex = "";
    /** 属性出生日期 */
    private DateTime birthday = new DateTime();
    /** 属性单位或住址 */
    private String driverAddress = "";
    /** 属性身份证号 */
    private String identifyNumber = "";
    /** 属性初次领证日期 */
    private DateTime receiveLicenseDate = new DateTime();
    /** 属性领证机关 */
    private String awardLicenseOrgan = "";
    /** 属性准驾车型 */
    private String drivingCarType = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDdriverDtoBase对象
     */
    public PrpDdriverDtoBase(){
    }

    /**
     * 设置属性驾驶员驾驶证号码
     * @param drivingLicenseNo 待设置的属性驾驶员驾驶证号码的值
     */
    public void setDrivingLicenseNo(String drivingLicenseNo){
        this.drivingLicenseNo = StringUtils.rightTrim(drivingLicenseNo);
    }

    /**
     * 获取属性驾驶员驾驶证号码
     * @return 属性驾驶员驾驶证号码的值
     */
    public String getDrivingLicenseNo(){
        return drivingLicenseNo;
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
     * 设置属性驾驶员性别
     * @param driverSex 待设置的属性驾驶员性别的值
     */
    public void setDriverSex(String driverSex){
        this.driverSex = StringUtils.rightTrim(driverSex);
    }

    /**
     * 获取属性驾驶员性别
     * @return 属性驾驶员性别的值
     */
    public String getDriverSex(){
        return driverSex;
    }

    /**
     * 设置属性出生日期
     * @param birthday 待设置的属性出生日期的值
     */
    public void setBirthday(DateTime birthday){
        this.birthday = birthday;
    }

    /**
     * 获取属性出生日期
     * @return 属性出生日期的值
     */
    public DateTime getBirthday(){
        return birthday;
    }

    /**
     * 设置属性单位或住址
     * @param driverAddress 待设置的属性单位或住址的值
     */
    public void setDriverAddress(String driverAddress){
        this.driverAddress = StringUtils.rightTrim(driverAddress);
    }

    /**
     * 获取属性单位或住址
     * @return 属性单位或住址的值
     */
    public String getDriverAddress(){
        return driverAddress;
    }

    /**
     * 设置属性身份证号
     * @param identifyNumber 待设置的属性身份证号的值
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * 获取属性身份证号
     * @return 属性身份证号的值
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * 设置属性初次领证日期
     * @param receiveLicenseDate 待设置的属性初次领证日期的值
     */
    public void setReceiveLicenseDate(DateTime receiveLicenseDate){
        this.receiveLicenseDate = receiveLicenseDate;
    }

    /**
     * 获取属性初次领证日期
     * @return 属性初次领证日期的值
     */
    public DateTime getReceiveLicenseDate(){
        return receiveLicenseDate;
    }

    /**
     * 设置属性领证机关
     * @param awardLicenseOrgan 待设置的属性领证机关的值
     */
    public void setAwardLicenseOrgan(String awardLicenseOrgan){
        this.awardLicenseOrgan = StringUtils.rightTrim(awardLicenseOrgan);
    }

    /**
     * 获取属性领证机关
     * @return 属性领证机关的值
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
