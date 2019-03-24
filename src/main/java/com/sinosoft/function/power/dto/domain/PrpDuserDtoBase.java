package com.sinosoft.function.power.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpDuser 员工代码表的数据传输对象基类<br>
 * 创建于 2004-11-09 18:30:39.076<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDuserDtoBase implements Serializable{
    /** 属性员工代码 */
    private String userCode = "";
    /** 属性员工名称 */
    private String userName = "";
    /** 属性员工名称E */
    private String userEName = "";
    /** 属性密码 */
    private String password = "";
    /** 属性印鉴 */
    private String seal = "";
    /** 属性密码设置日期 */
    private DateTime passwordSetDate = new DateTime();
    /** 属性密码过期日期 */
    private DateTime passwordExpireDate = new DateTime();
    /** 属性归属机构代码 */
    private String comCode = "";
    /** 属性出单机构代码 */
    private String makeCom = "";
    /** 属性账号代码 */
    private String accountCode = "";
    /** 属性电话号码 */
    private String phone = "";
    /** 属性手机号码 */
    private String mobile = "";
    /** 属性通信地址 */
    private String address = "";
    /** 属性邮政编码 */
    private String postCode = "";
    /** 属性邮箱 */
    private String email = "";
    /** 属性员工标志 */
    private String userFlag = "";
    /** 属性允许登录的应用系统 */
    private String loginSystem = "";
    /** 属性最新员工代码 */
    private String newUserCode = "";
    /** 属性效力状态 */
    private String validStatus = "";
    /** 属性专项代码 */
    private String articleCode = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDuserDtoBase对象
     */
    public PrpDuserDtoBase(){
    }

    /**
     * 设置属性员工代码
     * @param userCode 待设置的属性员工代码的值
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * 获取属性员工代码
     * @return 属性员工代码的值
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * 设置属性员工名称
     * @param userName 待设置的属性员工名称的值
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * 获取属性员工名称
     * @return 属性员工名称的值
     */
    public String getUserName(){
        return userName;
    }

    /**
     * 设置属性员工名称E
     * @param userEName 待设置的属性员工名称E的值
     */
    public void setUserEName(String userEName){
        this.userEName = StringUtils.rightTrim(userEName);
    }

    /**
     * 获取属性员工名称E
     * @return 属性员工名称E的值
     */
    public String getUserEName(){
        return userEName;
    }

    /**
     * 设置属性密码
     * @param password 待设置的属性密码的值
     */
    public void setPassword(String password){
        this.password = StringUtils.rightTrim(password);
    }

    /**
     * 获取属性密码
     * @return 属性密码的值
     */
    public String getPassword(){
        return password;
    }

    /**
     * 设置属性印鉴
     * @param seal 待设置的属性印鉴的值
     */
    public void setSeal(String seal){
        this.seal = StringUtils.rightTrim(seal);
    }

    /**
     * 获取属性印鉴
     * @return 属性印鉴的值
     */
    public String getSeal(){
        return seal;
    }

    /**
     * 设置属性密码设置日期
     * @param passwordSetDate 待设置的属性密码设置日期的值
     */
    public void setPasswordSetDate(DateTime passwordSetDate){
        this.passwordSetDate = passwordSetDate;
    }

    /**
     * 获取属性密码设置日期
     * @return 属性密码设置日期的值
     */
    public DateTime getPasswordSetDate(){
        return passwordSetDate;
    }

    /**
     * 设置属性密码过期日期
     * @param passwordExpireDate 待设置的属性密码过期日期的值
     */
    public void setPasswordExpireDate(DateTime passwordExpireDate){
        this.passwordExpireDate = passwordExpireDate;
    }

    /**
     * 获取属性密码过期日期
     * @return 属性密码过期日期的值
     */
    public DateTime getPasswordExpireDate(){
        return passwordExpireDate;
    }

    /**
     * 设置属性归属机构代码
     * @param comCode 待设置的属性归属机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性归属机构代码
     * @return 属性归属机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性出单机构代码
     * @param makeCom 待设置的属性出单机构代码的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性出单机构代码
     * @return 属性出单机构代码的值
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * 设置属性账号代码
     * @param accountCode 待设置的属性账号代码的值
     */
    public void setAccountCode(String accountCode){
        this.accountCode = StringUtils.rightTrim(accountCode);
    }

    /**
     * 获取属性账号代码
     * @return 属性账号代码的值
     */
    public String getAccountCode(){
        return accountCode;
    }

    /**
     * 设置属性电话号码
     * @param phone 待设置的属性电话号码的值
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * 获取属性电话号码
     * @return 属性电话号码的值
     */
    public String getPhone(){
        return phone;
    }

    /**
     * 设置属性手机号码
     * @param mobile 待设置的属性手机号码的值
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * 获取属性手机号码
     * @return 属性手机号码的值
     */
    public String getMobile(){
        return mobile;
    }

    /**
     * 设置属性通信地址
     * @param address 待设置的属性通信地址的值
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * 获取属性通信地址
     * @return 属性通信地址的值
     */
    public String getAddress(){
        return address;
    }

    /**
     * 设置属性邮政编码
     * @param postCode 待设置的属性邮政编码的值
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * 获取属性邮政编码
     * @return 属性邮政编码的值
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * 设置属性邮箱
     * @param email 待设置的属性邮箱的值
     */
    public void setEmail(String email){
        this.email = StringUtils.rightTrim(email);
    }

    /**
     * 获取属性邮箱
     * @return 属性邮箱的值
     */
    public String getEmail(){
        return email;
    }

    /**
     * 设置属性员工标志
     * @param userFlag 待设置的属性员工标志的值
     */
    public void setUserFlag(String userFlag){
        this.userFlag = StringUtils.rightTrim(userFlag);
    }

    /**
     * 获取属性员工标志
     * @return 属性员工标志的值
     */
    public String getUserFlag(){
        return userFlag;
    }

    /**
     * 设置属性允许登录的应用系统
     * @param loginSystem 待设置的属性允许登录的应用系统的值
     */
    public void setLoginSystem(String loginSystem){
        this.loginSystem = StringUtils.rightTrim(loginSystem);
    }

    /**
     * 获取属性允许登录的应用系统
     * @return 属性允许登录的应用系统的值
     */
    public String getLoginSystem(){
        return loginSystem;
    }

    /**
     * 设置属性最新员工代码
     * @param newUserCode 待设置的属性最新员工代码的值
     */
    public void setNewUserCode(String newUserCode){
        this.newUserCode = StringUtils.rightTrim(newUserCode);
    }

    /**
     * 获取属性最新员工代码
     * @return 属性最新员工代码的值
     */
    public String getNewUserCode(){
        return newUserCode;
    }

    /**
     * 设置属性效力状态
     * @param validStatus 待设置的属性效力状态的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性效力状态
     * @return 属性效力状态的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性专项代码
     * @param articleCode 待设置的属性专项代码的值
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * 获取属性专项代码
     * @return 属性专项代码的值
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
