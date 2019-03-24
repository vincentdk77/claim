package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdcustomer_idv个人客户代码表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcustomerIdvDtoBase implements Serializable{
    /** 属性客户代码 */
    private String customerCode = "";
    /** 属性速查索引码 */
    private String shortHandCode = "";
    /** 属性客户中文名称 */
    private String customerCName = "";
    /** 属性客户英文名称 */
    private String customerEName = "";
    /** 属性地址中文名称 */
    private String addressCName = "";
    /** 属性地址英文名称 */
    private String addressEName = "";
    /** 属性身份证号码 */
    private String identifyNumber = "";
    /** 属性资信等级 */
    private String creditLevel = "";
    /** 属性性别 */
    private String sex = "";
    /** 属性年龄 */
    private int age = 0;
    /** 属性健康状况 */
    private String health = "";
    /** 属性职业代码 */
    private String occupationCode = "";
    /** 属性学历代码 */
    private String educationCode = "";
    /** 属性工作单位 */
    private String unit = "";
    /** 属性单位地址 */
    private String unitAddress = "";
    /** 属性客户标志(0:临时/1:正式) */
    private String customerFlag = "";
    /** 属性电话 */
    private String phoneNumber = "";
    /** 属性传真 */
    private String faxNumber = "";
    /** 属性手机 */
    private String mobile = "";
    /** 属性通信地址 */
    private String linkAddress = "";
    /** 属性邮编 */
    private String postCode = "";
    /** 属性呼机 */
    private String pager = "";
    /** 属性E_mail信箱 */
    private String email = "";
    /** 属性开户银行 */
    private String bank = "";
    /** 属性帐号 */
    private String account = "";
    /** 属性死亡时间 */
    private DateTime deathDate = new DateTime();
    /** 属性黑名单标志 */
    private String blackState = "";
    /** 属性新的客户代码 */
    private String newCustomerCode = "";
    /** 属性效力状态(0失效/1有效) */
    private String validStatus = "";
    /** 属性专项代码(对应会计科目) */
    private String articleCode = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDcustomer_idvDtoBase对象
     */
    public PrpDcustomerIdvDtoBase(){
    }

    /**
     * 设置属性客户代码
     * @param customerCode 待设置的属性客户代码的值
     */
    public void setCustomerCode(String customerCode){
        this.customerCode = StringUtils.rightTrim(customerCode);
    }

    /**
     * 获取属性客户代码
     * @return 属性客户代码的值
     */
    public String getCustomerCode(){
        return customerCode;
    }

    /**
     * 设置属性速查索引码
     * @param shortHandCode 待设置的属性速查索引码的值
     */
    public void setShortHandCode(String shortHandCode){
        this.shortHandCode = StringUtils.rightTrim(shortHandCode);
    }

    /**
     * 获取属性速查索引码
     * @return 属性速查索引码的值
     */
    public String getShortHandCode(){
        return shortHandCode;
    }

    /**
     * 设置属性客户中文名称
     * @param customerCName 待设置的属性客户中文名称的值
     */
    public void setCustomerCName(String customerCName){
        this.customerCName = StringUtils.rightTrim(customerCName);
    }

    /**
     * 获取属性客户中文名称
     * @return 属性客户中文名称的值
     */
    public String getCustomerCName(){
        return customerCName;
    }

    /**
     * 设置属性客户英文名称
     * @param customerEName 待设置的属性客户英文名称的值
     */
    public void setCustomerEName(String customerEName){
        this.customerEName = StringUtils.rightTrim(customerEName);
    }

    /**
     * 获取属性客户英文名称
     * @return 属性客户英文名称的值
     */
    public String getCustomerEName(){
        return customerEName;
    }

    /**
     * 设置属性地址中文名称
     * @param addressCName 待设置的属性地址中文名称的值
     */
    public void setAddressCName(String addressCName){
        this.addressCName = StringUtils.rightTrim(addressCName);
    }

    /**
     * 获取属性地址中文名称
     * @return 属性地址中文名称的值
     */
    public String getAddressCName(){
        return addressCName;
    }

    /**
     * 设置属性地址英文名称
     * @param addressEName 待设置的属性地址英文名称的值
     */
    public void setAddressEName(String addressEName){
        this.addressEName = StringUtils.rightTrim(addressEName);
    }

    /**
     * 获取属性地址英文名称
     * @return 属性地址英文名称的值
     */
    public String getAddressEName(){
        return addressEName;
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
     * 设置属性资信等级
     * @param creditLevel 待设置的属性资信等级的值
     */
    public void setCreditLevel(String creditLevel){
        this.creditLevel = StringUtils.rightTrim(creditLevel);
    }

    /**
     * 获取属性资信等级
     * @return 属性资信等级的值
     */
    public String getCreditLevel(){
        return creditLevel;
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
     * 设置属性健康状况
     * @param health 待设置的属性健康状况的值
     */
    public void setHealth(String health){
        this.health = StringUtils.rightTrim(health);
    }

    /**
     * 获取属性健康状况
     * @return 属性健康状况的值
     */
    public String getHealth(){
        return health;
    }

    /**
     * 设置属性职业代码
     * @param occupationCode 待设置的属性职业代码的值
     */
    public void setOccupationCode(String occupationCode){
        this.occupationCode = StringUtils.rightTrim(occupationCode);
    }

    /**
     * 获取属性职业代码
     * @return 属性职业代码的值
     */
    public String getOccupationCode(){
        return occupationCode;
    }

    /**
     * 设置属性学历代码
     * @param educationCode 待设置的属性学历代码的值
     */
    public void setEducationCode(String educationCode){
        this.educationCode = StringUtils.rightTrim(educationCode);
    }

    /**
     * 获取属性学历代码
     * @return 属性学历代码的值
     */
    public String getEducationCode(){
        return educationCode;
    }

    /**
     * 设置属性工作单位
     * @param unit 待设置的属性工作单位的值
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * 获取属性工作单位
     * @return 属性工作单位的值
     */
    public String getUnit(){
        return unit;
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
     * 设置属性客户标志(0:临时/1:正式)
     * @param customerFlag 待设置的属性客户标志(0:临时/1:正式)的值
     */
    public void setCustomerFlag(String customerFlag){
        this.customerFlag = StringUtils.rightTrim(customerFlag);
    }

    /**
     * 获取属性客户标志(0:临时/1:正式)
     * @return 属性客户标志(0:临时/1:正式)的值
     */
    public String getCustomerFlag(){
        return customerFlag;
    }

    /**
     * 设置属性电话
     * @param phoneNumber 待设置的属性电话的值
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * 获取属性电话
     * @return 属性电话的值
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * 设置属性传真
     * @param faxNumber 待设置的属性传真的值
     */
    public void setFaxNumber(String faxNumber){
        this.faxNumber = StringUtils.rightTrim(faxNumber);
    }

    /**
     * 获取属性传真
     * @return 属性传真的值
     */
    public String getFaxNumber(){
        return faxNumber;
    }

    /**
     * 设置属性手机
     * @param mobile 待设置的属性手机的值
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * 获取属性手机
     * @return 属性手机的值
     */
    public String getMobile(){
        return mobile;
    }

    /**
     * 设置属性通信地址
     * @param linkAddress 待设置的属性通信地址的值
     */
    public void setLinkAddress(String linkAddress){
        this.linkAddress = StringUtils.rightTrim(linkAddress);
    }

    /**
     * 获取属性通信地址
     * @return 属性通信地址的值
     */
    public String getLinkAddress(){
        return linkAddress;
    }

    /**
     * 设置属性邮编
     * @param postCode 待设置的属性邮编的值
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * 获取属性邮编
     * @return 属性邮编的值
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * 设置属性呼机
     * @param pager 待设置的属性呼机的值
     */
    public void setPager(String pager){
        this.pager = StringUtils.rightTrim(pager);
    }

    /**
     * 获取属性呼机
     * @return 属性呼机的值
     */
    public String getPager(){
        return pager;
    }

    /**
     * 设置属性E_mail信箱
     * @param email 待设置的属性E_mail信箱的值
     */
    public void setEmail(String email){
        this.email = StringUtils.rightTrim(email);
    }

    /**
     * 获取属性E_mail信箱
     * @return 属性E_mail信箱的值
     */
    public String getEmail(){
        return email;
    }

    /**
     * 设置属性开户银行
     * @param bank 待设置的属性开户银行的值
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * 获取属性开户银行
     * @return 属性开户银行的值
     */
    public String getBank(){
        return bank;
    }

    /**
     * 设置属性帐号
     * @param account 待设置的属性帐号的值
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * 获取属性帐号
     * @return 属性帐号的值
     */
    public String getAccount(){
        return account;
    }

    /**
     * 设置属性死亡时间
     * @param deathDate 待设置的属性死亡时间的值
     */
    public void setDeathDate(DateTime deathDate){
        this.deathDate = deathDate;
    }

    /**
     * 获取属性死亡时间
     * @return 属性死亡时间的值
     */
    public DateTime getDeathDate(){
        return deathDate;
    }

    /**
     * 设置属性黑名单标志
     * @param blackState 待设置的属性黑名单标志的值
     */
    public void setBlackState(String blackState){
        this.blackState = StringUtils.rightTrim(blackState);
    }

    /**
     * 获取属性黑名单标志
     * @return 属性黑名单标志的值
     */
    public String getBlackState(){
        return blackState;
    }

    /**
     * 设置属性新的客户代码
     * @param newCustomerCode 待设置的属性新的客户代码的值
     */
    public void setNewCustomerCode(String newCustomerCode){
        this.newCustomerCode = StringUtils.rightTrim(newCustomerCode);
    }

    /**
     * 获取属性新的客户代码
     * @return 属性新的客户代码的值
     */
    public String getNewCustomerCode(){
        return newCustomerCode;
    }

    /**
     * 设置属性效力状态(0失效/1有效)
     * @param validStatus 待设置的属性效力状态(0失效/1有效)的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性效力状态(0失效/1有效)
     * @return 属性效力状态(0失效/1有效)的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性专项代码(对应会计科目)
     * @param articleCode 待设置的属性专项代码(对应会计科目)的值
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * 获取属性专项代码(对应会计科目)
     * @return 属性专项代码(对应会计科目)的值
     */
    public String getArticleCode(){
        return articleCode;
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
