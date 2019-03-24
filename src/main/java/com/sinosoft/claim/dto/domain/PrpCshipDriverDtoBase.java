package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpcshipdriver船舶险船员信息表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCshipDriverDtoBase implements Serializable{
    /** 属性投保单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性标的序号 */
    private int itemNo = 0;
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性驾驶员姓名 */
    private String driverName = "";
    /** 属性驾驶员性别 */
    private String driverSex = "";
    /** 属性驾驶员类型 */
    private String driverTypeCode = "";
    /** 属性出生日期 */
    private DateTime birthday = new DateTime();
    /** 属性驾驶员等级 */
    private String driverGrade = "";
    /** 属性驾驶员航线 */
    private String driverSeaRoute = "";
    /** 属性驾驶员驾驶证号码 */
    private String drivingLicenseNo = "";
    /** 属性领证时间 */
    private DateTime receiveLicenseDate = new DateTime();
    /** 属性准驾船型 */
    private String drivingShipType = "";
    /** 属性驾驶年限 */
    private int drivingYear = 0;
    /** 属性是否固定驾驶员标志 */
    private String changelessFlag = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCshipDriverDtoBase对象
     */
    public PrpCshipDriverDtoBase(){
    }

    /**
     * 设置属性投保单号码
     * @param policyNo 待设置的属性投保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性投保单号码
     * @return 属性投保单号码的值
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
     * 设置属性驾驶员类型
     * @param driverTypeCode 待设置的属性驾驶员类型的值
     */
    public void setDriverTypeCode(String driverTypeCode){
        this.driverTypeCode = StringUtils.rightTrim(driverTypeCode);
    }

    /**
     * 获取属性驾驶员类型
     * @return 属性驾驶员类型的值
     */
    public String getDriverTypeCode(){
        return driverTypeCode;
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
     * 设置属性驾驶员等级
     * @param driverGrade 待设置的属性驾驶员等级的值
     */
    public void setDriverGrade(String driverGrade){
        this.driverGrade = StringUtils.rightTrim(driverGrade);
    }

    /**
     * 获取属性驾驶员等级
     * @return 属性驾驶员等级的值
     */
    public String getDriverGrade(){
        return driverGrade;
    }

    /**
     * 设置属性驾驶员航线
     * @param driverSeaRoute 待设置的属性驾驶员航线的值
     */
    public void setDriverSeaRoute(String driverSeaRoute){
        this.driverSeaRoute = StringUtils.rightTrim(driverSeaRoute);
    }

    /**
     * 获取属性驾驶员航线
     * @return 属性驾驶员航线的值
     */
    public String getDriverSeaRoute(){
        return driverSeaRoute;
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
     * 设置属性领证时间
     * @param receiveLicenseDate 待设置的属性领证时间的值
     */
    public void setReceiveLicenseDate(DateTime receiveLicenseDate){
        this.receiveLicenseDate = receiveLicenseDate;
    }

    /**
     * 获取属性领证时间
     * @return 属性领证时间的值
     */
    public DateTime getReceiveLicenseDate(){
        return receiveLicenseDate;
    }

    /**
     * 设置属性准驾船型
     * @param drivingShipType 待设置的属性准驾船型的值
     */
    public void setDrivingShipType(String drivingShipType){
        this.drivingShipType = StringUtils.rightTrim(drivingShipType);
    }

    /**
     * 获取属性准驾船型
     * @return 属性准驾船型的值
     */
    public String getDrivingShipType(){
        return drivingShipType;
    }

    /**
     * 设置属性驾驶年限
     * @param drivingYear 待设置的属性驾驶年限的值
     */
    public void setDrivingYear(int drivingYear){
        this.drivingYear = drivingYear;
    }

    /**
     * 获取属性驾驶年限
     * @return 属性驾驶年限的值
     */
    public int getDrivingYear(){
        return drivingYear;
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
