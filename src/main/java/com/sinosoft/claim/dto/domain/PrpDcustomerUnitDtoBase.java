package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpDcustomerUnit单位客户代码表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcustomerUnitDtoBase implements Serializable{
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
    /** 属性占用性质代码 */
    private String possessNature = "";
    /** 属性行业代码 */
    private String businessSource = "";
    /** 属性所有制代码（单位性质代码） */
    private String businessSort = "";
    /** 属性客户类型 */
    private String customerKind = "";
    /** 属性客户标志 */
    private String customerFlag = "";
    /** 属性法人组织机构代码 (I) */
    private String organizeCode = "";
    /** 属性资信等级 */
    private String creditLevel = "";
    /** 属性法人代表 */
    private String leaderName = "";
    /** 属性电话 */
    private String phoneNumber = "";
    /** 属性传真 */
    private String faxNumber = "";
    /** 属性手机 */
    private String mobile = "";
    /** 属性网址 */
    private String netAddress = "";
    /** 属性电子信箱 */
    private String emailAddress = "";
    /** 属性通信地址 */
    private String postAddress = "";
    /** 属性邮编 */
    private String postCode = "";
    /** 属性联系人 */
    private String linkerName = "";
    /** 属性开户银行 */
    private String bank = "";
    /** 属性开户帐号 */
    private String account = "";
    /** 属性工商局码 */
    private String industryCode = "";
    /** 属性经贸委码 */
    private String economyCode = "";
    /** 属性标准计量码 */
    private String measureCode = "";
    /** 属性上级代码 */
    private String fatherCode = "";
    /** 属性主管人名称 */
    private String sponsorName = "";
    /** 属性经营范围 */
    private String businessRange = "";
    /** 属性注册资金 */
    private double registFund = 0d;
    /** 属性行政区划分码 */
    private String regionCode = "";
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
     *  默认构造方法,构造一个默认的PrpDcustomerUnitDtoBase对象
     */
    public PrpDcustomerUnitDtoBase(){
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
     * 设置属性占用性质代码
     * @param possessNature 待设置的属性占用性质代码的值
     */
    public void setPossessNature(String possessNature){
        this.possessNature = StringUtils.rightTrim(possessNature);
    }

    /**
     * 获取属性占用性质代码
     * @return 属性占用性质代码的值
     */
    public String getPossessNature(){
        return possessNature;
    }

    /**
     * 设置属性行业代码
     * @param businessSource 待设置的属性行业代码的值
     */
    public void setBusinessSource(String businessSource){
        this.businessSource = StringUtils.rightTrim(businessSource);
    }

    /**
     * 获取属性行业代码
     * @return 属性行业代码的值
     */
    public String getBusinessSource(){
        return businessSource;
    }

    /**
     * 设置属性所有制代码（单位性质代码）
     * @param businessSort 待设置的属性所有制代码（单位性质代码）的值
     */
    public void setBusinessSort(String businessSort){
        this.businessSort = StringUtils.rightTrim(businessSort);
    }

    /**
     * 获取属性所有制代码（单位性质代码）
     * @return 属性所有制代码（单位性质代码）的值
     */
    public String getBusinessSort(){
        return businessSort;
    }

    /**
     * 设置属性客户类型
     * @param customerKind 待设置的属性客户类型的值
     */
    public void setCustomerKind(String customerKind){
        this.customerKind = StringUtils.rightTrim(customerKind);
    }

    /**
     * 获取属性客户类型
     * @return 属性客户类型的值
     */
    public String getCustomerKind(){
        return customerKind;
    }

    /**
     * 设置属性客户标志
     * @param customerFlag 待设置的属性客户标志的值
     */
    public void setCustomerFlag(String customerFlag){
        this.customerFlag = StringUtils.rightTrim(customerFlag);
    }

    /**
     * 获取属性客户标志
     * @return 属性客户标志的值
     */
    public String getCustomerFlag(){
        return customerFlag;
    }

    /**
     * 设置属性法人组织机构代码 (I)
     * @param organizeCode 待设置的属性法人组织机构代码 (I)的值
     */
    public void setOrganizeCode(String organizeCode){
        this.organizeCode = StringUtils.rightTrim(organizeCode);
    }

    /**
     * 获取属性法人组织机构代码 (I)
     * @return 属性法人组织机构代码 (I)的值
     */
    public String getOrganizeCode(){
        return organizeCode;
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
     * 设置属性法人代表
     * @param leaderName 待设置的属性法人代表的值
     */
    public void setLeaderName(String leaderName){
        this.leaderName = StringUtils.rightTrim(leaderName);
    }

    /**
     * 获取属性法人代表
     * @return 属性法人代表的值
     */
    public String getLeaderName(){
        return leaderName;
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
     * 设置属性网址
     * @param netAddress 待设置的属性网址的值
     */
    public void setNetAddress(String netAddress){
        this.netAddress = StringUtils.rightTrim(netAddress);
    }

    /**
     * 获取属性网址
     * @return 属性网址的值
     */
    public String getNetAddress(){
        return netAddress;
    }

    /**
     * 设置属性电子信箱
     * @param emailAddress 待设置的属性电子信箱的值
     */
    public void setEmailAddress(String emailAddress){
        this.emailAddress = StringUtils.rightTrim(emailAddress);
    }

    /**
     * 获取属性电子信箱
     * @return 属性电子信箱的值
     */
    public String getEmailAddress(){
        return emailAddress;
    }

    /**
     * 设置属性通信地址
     * @param postAddress 待设置的属性通信地址的值
     */
    public void setPostAddress(String postAddress){
        this.postAddress = StringUtils.rightTrim(postAddress);
    }

    /**
     * 获取属性通信地址
     * @return 属性通信地址的值
     */
    public String getPostAddress(){
        return postAddress;
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
     * 设置属性联系人
     * @param linkerName 待设置的属性联系人的值
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * 获取属性联系人
     * @return 属性联系人的值
     */
    public String getLinkerName(){
        return linkerName;
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
     * 设置属性开户帐号
     * @param account 待设置的属性开户帐号的值
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * 获取属性开户帐号
     * @return 属性开户帐号的值
     */
    public String getAccount(){
        return account;
    }

    /**
     * 设置属性工商局码
     * @param industryCode 待设置的属性工商局码的值
     */
    public void setIndustryCode(String industryCode){
        this.industryCode = StringUtils.rightTrim(industryCode);
    }

    /**
     * 获取属性工商局码
     * @return 属性工商局码的值
     */
    public String getIndustryCode(){
        return industryCode;
    }

    /**
     * 设置属性经贸委码
     * @param economyCode 待设置的属性经贸委码的值
     */
    public void setEconomyCode(String economyCode){
        this.economyCode = StringUtils.rightTrim(economyCode);
    }

    /**
     * 获取属性经贸委码
     * @return 属性经贸委码的值
     */
    public String getEconomyCode(){
        return economyCode;
    }

    /**
     * 设置属性标准计量码
     * @param measureCode 待设置的属性标准计量码的值
     */
    public void setMeasureCode(String measureCode){
        this.measureCode = StringUtils.rightTrim(measureCode);
    }

    /**
     * 获取属性标准计量码
     * @return 属性标准计量码的值
     */
    public String getMeasureCode(){
        return measureCode;
    }

    /**
     * 设置属性上级代码
     * @param fatherCode 待设置的属性上级代码的值
     */
    public void setFatherCode(String fatherCode){
        this.fatherCode = StringUtils.rightTrim(fatherCode);
    }

    /**
     * 获取属性上级代码
     * @return 属性上级代码的值
     */
    public String getFatherCode(){
        return fatherCode;
    }

    /**
     * 设置属性主管人名称
     * @param sponsorName 待设置的属性主管人名称的值
     */
    public void setSponsorName(String sponsorName){
        this.sponsorName = StringUtils.rightTrim(sponsorName);
    }

    /**
     * 获取属性主管人名称
     * @return 属性主管人名称的值
     */
    public String getSponsorName(){
        return sponsorName;
    }

    /**
     * 设置属性经营范围
     * @param businessRange 待设置的属性经营范围的值
     */
    public void setBusinessRange(String businessRange){
        this.businessRange = StringUtils.rightTrim(businessRange);
    }

    /**
     * 获取属性经营范围
     * @return 属性经营范围的值
     */
    public String getBusinessRange(){
        return businessRange;
    }

    /**
     * 设置属性注册资金
     * @param registFund 待设置的属性注册资金的值
     */
    public void setRegistFund(double registFund){
        this.registFund = registFund;
    }

    /**
     * 获取属性注册资金
     * @return 属性注册资金的值
     */
    public double getRegistFund(){
        return registFund;
    }

    /**
     * 设置属性行政区划分码
     * @param regionCode 待设置的属性行政区划分码的值
     */
    public void setRegionCode(String regionCode){
        this.regionCode = StringUtils.rightTrim(regionCode);
    }

    /**
     * 获取属性行政区划分码
     * @return 属性行政区划分码的值
     */
    public String getRegionCode(){
        return regionCode;
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
