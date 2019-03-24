package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

public class PrpCinsuredNatureDtoInfo implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性关系人标志 */
    private String insuredFlag = "";
    /** 属性性别 */
    private String sex = "";
    /** 属性年龄 */
    private int age = 0;
    /** 属性出生日期 */
    private Date birthday = new Date();
    /** 属性健康状态 */
    private String health = "";
    /** 属性职称 */
    private String jobTitle = "";
    /** 属性在本地工作年限 */
    private int loacalWorkYears = 0;
    /** 属性学历 */
    private String education = "";
    /** 属性总工龄 */
    private int totalWorkYears = 0;
    /** 属性单位名称 */
    private String unit = "";
    /** 属性单位电话 */
    private String unitPhoneNumber = "";
    /** 属性单位地址 */
    private String unitAddress = "";
    /** 属性单位邮编 */
    private String unitPostCode = "";
    /** 属性单位类型 */
    private String unitType = "";
    /** 属性任职级别 */
    private String dutyLevel = "";
    /** 属性任职种类 */
    private String dutyType = "";
    /** 属性兼职职业/工种代码 */
    private String occupationcode = "";
    /** 属性房产状况 */
    private String houseProperty = "";
    /** 属性户口所在地派出所名称 */
    private String localPoliceStation = "";
    /** 属性经常住房地 */
    private String roomAddress = "";
    /** 属性邮政编码 */
    private String roompostcode = "";
    /** 属性本人月收入 */
    private double selfMonthIncome = 0d;
    /** 属性家庭月收入 */
    private double familyMonthIncome = 0d;
    /** 属性收入来源 */
    private String incomeSource = "";
    /** 属性常住房电话 */
    private String roomPhone = "";
    /** 属性手提电话 */
    private String mobile = "";
    /** 属性家庭人口 */
    private int familySumQuantity = 0;
    /** 属性婚姻状况 */
    private String marriage = "";
    /** 属性配偶姓名 */
    private String spouseName = "";
    /** 属性配偶出生年月 */
    private Date spouseBornDate = new Date();
    /** 属性配偶身份证号码 */
    private String spouseID = "";
    /** 属性配偶单位 */
    private String spouseUnit = "";
    /** 属性配偶职务 */
    private String spouseJobTitle = "";
    /** 属性配偶单位电话 */
    private String spouseUnitPhone = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCinsuredNatureDtoBase对象
     */
    public PrpCinsuredNatureDtoInfo(){
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
     * 设置属性关系人标志
     * @param insuredFlag 待设置的属性关系人标志的值
     */
    public void setInsuredFlag(String insuredFlag){
        this.insuredFlag = StringUtils.rightTrim(insuredFlag);
    }

    /**
     * 获取属性关系人标志
     * @return 属性关系人标志的值
     */
    public String getInsuredFlag(){
        return insuredFlag;
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
     * 设置属性出生日期
     * @param birthday 待设置的属性出生日期的值
     */
    public void setBirthday(DateTime birthday){
        this.birthday = birthday;
    }

   

    /**
     * 设置属性健康状态
     * @param health 待设置的属性健康状态的值
     */
    public void setHealth(String health){
        this.health = StringUtils.rightTrim(health);
    }

    /**
     * 获取属性健康状态
     * @return 属性健康状态的值
     */
    public String getHealth(){
        return health;
    }

    /**
     * 设置属性职称
     * @param jobTitle 待设置的属性职称的值
     */
    public void setJobTitle(String jobTitle){
        this.jobTitle = StringUtils.rightTrim(jobTitle);
    }

    /**
     * 获取属性职称
     * @return 属性职称的值
     */
    public String getJobTitle(){
        return jobTitle;
    }

    /**
     * 设置属性在本地工作年限
     * @param loacalWorkYears 待设置的属性在本地工作年限的值
     */
    public void setLoacalWorkYears(int loacalWorkYears){
        this.loacalWorkYears = loacalWorkYears;
    }

    /**
     * 获取属性在本地工作年限
     * @return 属性在本地工作年限的值
     */
    public int getLoacalWorkYears(){
        return loacalWorkYears;
    }

    /**
     * 设置属性学历
     * @param education 待设置的属性学历的值
     */
    public void setEducation(String education){
        this.education = StringUtils.rightTrim(education);
    }

    /**
     * 获取属性学历
     * @return 属性学历的值
     */
    public String getEducation(){
        return education;
    }

    /**
     * 设置属性总工龄
     * @param totalWorkYears 待设置的属性总工龄的值
     */
    public void setTotalWorkYears(int totalWorkYears){
        this.totalWorkYears = totalWorkYears;
    }

    /**
     * 获取属性总工龄
     * @return 属性总工龄的值
     */
    public int getTotalWorkYears(){
        return totalWorkYears;
    }

    /**
     * 设置属性单位名称
     * @param unit 待设置的属性单位名称的值
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * 获取属性单位名称
     * @return 属性单位名称的值
     */
    public String getUnit(){
        return unit;
    }

    /**
     * 设置属性单位电话
     * @param unitPhoneNumber 待设置的属性单位电话的值
     */
    public void setUnitPhoneNumber(String unitPhoneNumber){
        this.unitPhoneNumber = StringUtils.rightTrim(unitPhoneNumber);
    }

    /**
     * 获取属性单位电话
     * @return 属性单位电话的值
     */
    public String getUnitPhoneNumber(){
        return unitPhoneNumber;
    }

    /**
     * 设置属性单位地址
     * @param unitAddress 待设置的属性单位地址的值
     */
    public void setUnitAddress(String unitAddress){
        this.unitAddress = StringUtils.rightTrim(unitAddress);
    }

    /**
     * 获取属性单位地址
     * @return 属性单位地址的值
     */
    public String getUnitAddress(){
        return unitAddress;
    }

    /**
     * 设置属性单位邮编
     * @param unitPostCode 待设置的属性单位邮编的值
     */
    public void setUnitPostCode(String unitPostCode){
        this.unitPostCode = StringUtils.rightTrim(unitPostCode);
    }

    /**
     * 获取属性单位邮编
     * @return 属性单位邮编的值
     */
    public String getUnitPostCode(){
        return unitPostCode;
    }

    /**
     * 设置属性单位类型
     * @param unitType 待设置的属性单位类型的值
     */
    public void setUnitType(String unitType){
        this.unitType = StringUtils.rightTrim(unitType);
    }

    /**
     * 获取属性单位类型
     * @return 属性单位类型的值
     */
    public String getUnitType(){
        return unitType;
    }

    /**
     * 设置属性任职级别
     * @param dutyLevel 待设置的属性任职级别的值
     */
    public void setDutyLevel(String dutyLevel){
        this.dutyLevel = StringUtils.rightTrim(dutyLevel);
    }

    /**
     * 获取属性任职级别
     * @return 属性任职级别的值
     */
    public String getDutyLevel(){
        return dutyLevel;
    }

    /**
     * 设置属性任职种类
     * @param dutyType 待设置的属性任职种类的值
     */
    public void setDutyType(String dutyType){
        this.dutyType = StringUtils.rightTrim(dutyType);
    }

    /**
     * 获取属性任职种类
     * @return 属性任职种类的值
     */
    public String getDutyType(){
        return dutyType;
    }

    /**
     * 设置属性兼职职业/工种代码
     * @param occupationcode 待设置的属性兼职职业/工种代码的值
     */
    public void setOccupationcode(String occupationcode){
        this.occupationcode = StringUtils.rightTrim(occupationcode);
    }

    /**
     * 获取属性兼职职业/工种代码
     * @return 属性兼职职业/工种代码的值
     */
    public String getOccupationcode(){
        return occupationcode;
    }

    /**
     * 设置属性房产状况
     * @param houseProperty 待设置的属性房产状况的值
     */
    public void setHouseProperty(String houseProperty){
        this.houseProperty = StringUtils.rightTrim(houseProperty);
    }

    /**
     * 获取属性房产状况
     * @return 属性房产状况的值
     */
    public String getHouseProperty(){
        return houseProperty;
    }

    /**
     * 设置属性户口所在地派出所名称
     * @param localPoliceStation 待设置的属性户口所在地派出所名称的值
     */
    public void setLocalPoliceStation(String localPoliceStation){
        this.localPoliceStation = StringUtils.rightTrim(localPoliceStation);
    }

    /**
     * 获取属性户口所在地派出所名称
     * @return 属性户口所在地派出所名称的值
     */
    public String getLocalPoliceStation(){
        return localPoliceStation;
    }

    /**
     * 设置属性经常住房地
     * @param roomAddress 待设置的属性经常住房地的值
     */
    public void setRoomAddress(String roomAddress){
        this.roomAddress = StringUtils.rightTrim(roomAddress);
    }

    /**
     * 获取属性经常住房地
     * @return 属性经常住房地的值
     */
    public String getRoomAddress(){
        return roomAddress;
    }

    /**
     * 设置属性邮政编码
     * @param roompostcode 待设置的属性邮政编码的值
     */
    public void setRoompostcode(String roompostcode){
        this.roompostcode = StringUtils.rightTrim(roompostcode);
    }

    /**
     * 获取属性邮政编码
     * @return 属性邮政编码的值
     */
    public String getRoompostcode(){
        return roompostcode;
    }

    /**
     * 设置属性本人月收入
     * @param selfMonthIncome 待设置的属性本人月收入的值
     */
    public void setSelfMonthIncome(double selfMonthIncome){
        this.selfMonthIncome = selfMonthIncome;
    }

    /**
     * 获取属性本人月收入
     * @return 属性本人月收入的值
     */
    public double getSelfMonthIncome(){
        return selfMonthIncome;
    }

    /**
     * 设置属性家庭月收入
     * @param familyMonthIncome 待设置的属性家庭月收入的值
     */
    public void setFamilyMonthIncome(double familyMonthIncome){
        this.familyMonthIncome = familyMonthIncome;
    }

    /**
     * 获取属性家庭月收入
     * @return 属性家庭月收入的值
     */
    public double getFamilyMonthIncome(){
        return familyMonthIncome;
    }

    /**
     * 设置属性收入来源
     * @param incomeSource 待设置的属性收入来源的值
     */
    public void setIncomeSource(String incomeSource){
        this.incomeSource = StringUtils.rightTrim(incomeSource);
    }

    /**
     * 获取属性收入来源
     * @return 属性收入来源的值
     */
    public String getIncomeSource(){
        return incomeSource;
    }

    /**
     * 设置属性常住房电话
     * @param roomPhone 待设置的属性常住房电话的值
     */
    public void setRoomPhone(String roomPhone){
        this.roomPhone = StringUtils.rightTrim(roomPhone);
    }

    /**
     * 获取属性常住房电话
     * @return 属性常住房电话的值
     */
    public String getRoomPhone(){
        return roomPhone;
    }

    /**
     * 设置属性手提电话
     * @param mobile 待设置的属性手提电话的值
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * 获取属性手提电话
     * @return 属性手提电话的值
     */
    public String getMobile(){
        return mobile;
    }

    /**
     * 设置属性家庭人口
     * @param familySumQuantity 待设置的属性家庭人口的值
     */
    public void setFamilySumQuantity(int familySumQuantity){
        this.familySumQuantity = familySumQuantity;
    }

    /**
     * 获取属性家庭人口
     * @return 属性家庭人口的值
     */
    public int getFamilySumQuantity(){
        return familySumQuantity;
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
     * 设置属性配偶姓名
     * @param spouseName 待设置的属性配偶姓名的值
     */
    public void setSpouseName(String spouseName){
        this.spouseName = StringUtils.rightTrim(spouseName);
    }

    /**
     * 获取属性配偶姓名
     * @return 属性配偶姓名的值
     */
    public String getSpouseName(){
        return spouseName;
    }

    /**
     * 设置属性配偶出生年月
     * @param spouseBornDate 待设置的属性配偶出生年月的值
     */
    public void setSpouseBornDate(DateTime spouseBornDate){
        this.spouseBornDate = spouseBornDate;
    }

   

    /**
     * 设置属性配偶身份证号码
     * @param spouseID 待设置的属性配偶身份证号码的值
     */
    public void setSpouseID(String spouseID){
        this.spouseID = StringUtils.rightTrim(spouseID);
    }

    /**
     * 获取属性配偶身份证号码
     * @return 属性配偶身份证号码的值
     */
    public String getSpouseID(){
        return spouseID;
    }

    /**
     * 设置属性配偶单位
     * @param spouseUnit 待设置的属性配偶单位的值
     */
    public void setSpouseUnit(String spouseUnit){
        this.spouseUnit = StringUtils.rightTrim(spouseUnit);
    }

    /**
     * 获取属性配偶单位
     * @return 属性配偶单位的值
     */
    public String getSpouseUnit(){
        return spouseUnit;
    }

    /**
     * 设置属性配偶职务
     * @param spouseJobTitle 待设置的属性配偶职务的值
     */
    public void setSpouseJobTitle(String spouseJobTitle){
        this.spouseJobTitle = StringUtils.rightTrim(spouseJobTitle);
    }

    /**
     * 获取属性配偶职务
     * @return 属性配偶职务的值
     */
    public String getSpouseJobTitle(){
        return spouseJobTitle;
    }

    /**
     * 设置属性配偶单位电话
     * @param spouseUnitPhone 待设置的属性配偶单位电话的值
     */
    public void setSpouseUnitPhone(String spouseUnitPhone){
        this.spouseUnitPhone = StringUtils.rightTrim(spouseUnitPhone);
    }

    /**
     * 获取属性配偶单位电话
     * @return 属性配偶单位电话的值
     */
    public String getSpouseUnitPhone(){
        return spouseUnitPhone;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getSpouseBornDate() {
		return spouseBornDate;
	}

	public void setSpouseBornDate(Date spouseBornDate) {
		this.spouseBornDate = spouseBornDate;
	}
    
}

