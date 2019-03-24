package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpcname雇员清单表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCnameDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性雇员编码 */
    private String employeeCode = "";
    /** 属性雇员姓名 */
    private String employeeName = "";
    /** 属性性别代码 */
    private String sex = "";
    /** 属性年龄 */
    private int age = 0;
    /** 属性身体状况 */
    private String health = "";
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性险别名称 */
    private String kindName = "";
    /** 属性责任分类代码 */
    private String itemCode = "";
    /** 属性责任分类名称 */
    private String itemDetailName = "";
    /** 属性雇员工种代码 */
    private String jobCode = "";
    /** 属性雇员工种名称 */
    private String jobName = "";
    /** 属性身份证号码 */
    private String identifyNumber = "";
    /** 属性工作单位 */
    private String jobUnit = "";
    /** 属性工资币别 */
    private String currency = "";
    /** 属性月工资 */
    private double monthWage = 0d;
    /** 属性限额币别 */
    private String currency1 = "";
    /** 属性限额 */
    private double sumLimit = 0d;
    /** 属性起保日期 */
    private DateTime startDate = new DateTime();
    /** 属性起保小时 */
    private int startHour = 0;
    /** 属性终保日期 */
    private DateTime endDate = new DateTime();
    /** 属性终保小时 */
    private int endHour = 0;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCnameDtoBase对象
     */
    public PrpCnameDtoBase(){
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
     * 设置属性雇员编码
     * @param employeeCode 待设置的属性雇员编码的值
     */
    public void setEmployeeCode(String employeeCode){
        this.employeeCode = StringUtils.rightTrim(employeeCode);
    }

    /**
     * 获取属性雇员编码
     * @return 属性雇员编码的值
     */
    public String getEmployeeCode(){
        return employeeCode;
    }

    /**
     * 设置属性雇员姓名
     * @param employeeName 待设置的属性雇员姓名的值
     */
    public void setEmployeeName(String employeeName){
        this.employeeName = StringUtils.rightTrim(employeeName);
    }

    /**
     * 获取属性雇员姓名
     * @return 属性雇员姓名的值
     */
    public String getEmployeeName(){
        return employeeName;
    }

    /**
     * 设置属性性别代码
     * @param sex 待设置的属性性别代码的值
     */
    public void setSex(String sex){
        this.sex = StringUtils.rightTrim(sex);
    }

    /**
     * 获取属性性别代码
     * @return 属性性别代码的值
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
     * 设置属性身体状况
     * @param health 待设置的属性身体状况的值
     */
    public void setHealth(String health){
        this.health = StringUtils.rightTrim(health);
    }

    /**
     * 获取属性身体状况
     * @return 属性身体状况的值
     */
    public String getHealth(){
        return health;
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
     * 设置属性险别名称
     * @param kindName 待设置的属性险别名称的值
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * 获取属性险别名称
     * @return 属性险别名称的值
     */
    public String getKindName(){
        return kindName;
    }

    /**
     * 设置属性责任分类代码
     * @param itemCode 待设置的属性责任分类代码的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性责任分类代码
     * @return 属性责任分类代码的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性责任分类名称
     * @param itemDetailName 待设置的属性责任分类名称的值
     */
    public void setItemDetailName(String itemDetailName){
        this.itemDetailName = StringUtils.rightTrim(itemDetailName);
    }

    /**
     * 获取属性责任分类名称
     * @return 属性责任分类名称的值
     */
    public String getItemDetailName(){
        return itemDetailName;
    }

    /**
     * 设置属性雇员工种代码
     * @param jobCode 待设置的属性雇员工种代码的值
     */
    public void setJobCode(String jobCode){
        this.jobCode = StringUtils.rightTrim(jobCode);
    }

    /**
     * 获取属性雇员工种代码
     * @return 属性雇员工种代码的值
     */
    public String getJobCode(){
        return jobCode;
    }

    /**
     * 设置属性雇员工种名称
     * @param jobName 待设置的属性雇员工种名称的值
     */
    public void setJobName(String jobName){
        this.jobName = StringUtils.rightTrim(jobName);
    }

    /**
     * 获取属性雇员工种名称
     * @return 属性雇员工种名称的值
     */
    public String getJobName(){
        return jobName;
    }

    /**
     * 设置属性身份证号码
     * @param identifyNumber 待设置的属性身份证号码的值
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * 获取属性身份证号码
     * @return 属性身份证号码的值
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * 设置属性工作单位
     * @param jobUnit 待设置的属性工作单位的值
     */
    public void setJobUnit(String jobUnit){
        this.jobUnit = StringUtils.rightTrim(jobUnit);
    }

    /**
     * 获取属性工作单位
     * @return 属性工作单位的值
     */
    public String getJobUnit(){
        return jobUnit;
    }

    /**
     * 设置属性工资币别
     * @param currency 待设置的属性工资币别的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性工资币别
     * @return 属性工资币别的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性月工资
     * @param monthWage 待设置的属性月工资的值
     */
    public void setMonthWage(double monthWage){
        this.monthWage = monthWage;
    }

    /**
     * 获取属性月工资
     * @return 属性月工资的值
     */
    public double getMonthWage(){
        return monthWage;
    }

    /**
     * 设置属性限额币别
     * @param currency1 待设置的属性限额币别的值
     */
    public void setCurrency1(String currency1){
        this.currency1 = StringUtils.rightTrim(currency1);
    }

    /**
     * 获取属性限额币别
     * @return 属性限额币别的值
     */
    public String getCurrency1(){
        return currency1;
    }

    /**
     * 设置属性限额
     * @param sumLimit 待设置的属性限额的值
     */
    public void setSumLimit(double sumLimit){
        this.sumLimit = sumLimit;
    }

    /**
     * 获取属性限额
     * @return 属性限额的值
     */
    public double getSumLimit(){
        return sumLimit;
    }

    /**
     * 设置属性起保日期
     * @param startDate 待设置的属性起保日期的值
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * 获取属性起保日期
     * @return 属性起保日期的值
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * 设置属性起保小时
     * @param startHour 待设置的属性起保小时的值
     */
    public void setStartHour(int startHour){
        this.startHour = startHour;
    }

    /**
     * 获取属性起保小时
     * @return 属性起保小时的值
     */
    public int getStartHour(){
        return startHour;
    }

    /**
     * 设置属性终保日期
     * @param endDate 待设置的属性终保日期的值
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * 获取属性终保日期
     * @return 属性终保日期的值
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * 设置属性终保小时
     * @param endHour 待设置的属性终保小时的值
     */
    public void setEndHour(int endHour){
        this.endHour = endHour;
    }

    /**
     * 获取属性终保小时
     * @return 属性终保小时的值
     */
    public int getEndHour(){
        return endHour;
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
