package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpduser的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDuserDtoBase implements Serializable{
    /** 属性usercode */
    private String userCode = "";
    /** 属性username */
    private String userName = "";
    /** 属性UserEName */
    private String userEName = "";
    /** 属性password */
    private String password = "";
    /** 属性seal */
    private String seal = "";
    /** 属性passwordsetdate */
    private DateTime passwordSetDate = new DateTime();
    /** 属性passwordexpiredate */
    private DateTime passwordExpireDate = new DateTime();
    /** 属性comcode */
    private String comCode = "";
    /** 属性makecom */
    private String makeCom = "";
    /** 属性核算单位代码 */
    private String accountCode = "";
    /** 属性phone */
    private String phone = "";
    /** 属性mobile */
    private String mobile = "";
    /** 属性address */
    private String address = "";
    /** 属性postcode */
    private String postCode = "";
    /** 属性email */
    private String email = "";
    /** 属性userflag */
    private String userFlag = "";
    /** 属性loginsystem */
    private String loginSystem = "";
    /** 属性newusercode */
    private String newUserCode = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性articlecode */
    private String articleCode = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDuserDtoBase对象
     */
    public PrpDuserDtoBase(){
    }

    /**
     * 设置属性usercode
     * @param userCode 待设置的属性usercode的值
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * 获取属性usercode
     * @return 属性usercode的值
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * 设置属性username
     * @param userName 待设置的属性username的值
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * 获取属性username
     * @return 属性username的值
     */
    public String getUserName(){
        return userName;
    }

    /**
     * 设置属性UserEName
     * @param userEName 待设置的属性UserEName的值
     */
    public void setUserEName(String userEName){
        this.userEName = StringUtils.rightTrim(userEName);
    }

    /**
     * 获取属性UserEName
     * @return 属性UserEName的值
     */
    public String getUserEName(){
        return userEName;
    }

    /**
     * 设置属性password
     * @param password 待设置的属性password的值
     */
    public void setPassword(String password){
        this.password = StringUtils.rightTrim(password);
    }

    /**
     * 获取属性password
     * @return 属性password的值
     */
    public String getPassword(){
        return password;
    }

    /**
     * 设置属性seal
     * @param seal 待设置的属性seal的值
     */
    public void setSeal(String seal){
        this.seal = StringUtils.rightTrim(seal);
    }

    /**
     * 获取属性seal
     * @return 属性seal的值
     */
    public String getSeal(){
        return seal;
    }

    /**
     * 设置属性passwordsetdate
     * @param passwordSetDate 待设置的属性passwordsetdate的值
     */
    public void setPasswordSetDate(DateTime passwordSetDate){
        this.passwordSetDate = passwordSetDate;
    }

    /**
     * 获取属性passwordsetdate
     * @return 属性passwordsetdate的值
     */
    public DateTime getPasswordSetDate(){
        return passwordSetDate;
    }

    /**
     * 设置属性passwordexpiredate
     * @param passwordExpireDate 待设置的属性passwordexpiredate的值
     */
    public void setPasswordExpireDate(DateTime passwordExpireDate){
        this.passwordExpireDate = passwordExpireDate;
    }

    /**
     * 获取属性passwordexpiredate
     * @return 属性passwordexpiredate的值
     */
    public DateTime getPasswordExpireDate(){
        return passwordExpireDate;
    }

    /**
     * 设置属性comcode
     * @param comCode 待设置的属性comcode的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性comcode
     * @return 属性comcode的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性makecom
     * @param makeCom 待设置的属性makecom的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性makecom
     * @return 属性makecom的值
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * 设置属性核算单位代码
     * @param accountCode 待设置的属性核算单位代码的值
     */
    public void setAccountCode(String accountCode){
        this.accountCode = StringUtils.rightTrim(accountCode);
    }

    /**
     * 获取属性核算单位代码
     * @return 属性核算单位代码的值
     */
    public String getAccountCode(){
        return accountCode;
    }

    /**
     * 设置属性phone
     * @param phone 待设置的属性phone的值
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * 获取属性phone
     * @return 属性phone的值
     */
    public String getPhone(){
        return phone;
    }

    /**
     * 设置属性mobile
     * @param mobile 待设置的属性mobile的值
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * 获取属性mobile
     * @return 属性mobile的值
     */
    public String getMobile(){
        return mobile;
    }

    /**
     * 设置属性address
     * @param address 待设置的属性address的值
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * 获取属性address
     * @return 属性address的值
     */
    public String getAddress(){
        return address;
    }

    /**
     * 设置属性postcode
     * @param postCode 待设置的属性postcode的值
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * 获取属性postcode
     * @return 属性postcode的值
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * 设置属性email
     * @param email 待设置的属性email的值
     */
    public void setEmail(String email){
        this.email = StringUtils.rightTrim(email);
    }

    /**
     * 获取属性email
     * @return 属性email的值
     */
    public String getEmail(){
        return email;
    }

    /**
     * 设置属性userflag
     * @param userFlag 待设置的属性userflag的值
     */
    public void setUserFlag(String userFlag){
        this.userFlag = StringUtils.rightTrim(userFlag);
    }

    /**
     * 获取属性userflag
     * @return 属性userflag的值
     */
    public String getUserFlag(){
        return userFlag;
    }

    /**
     * 设置属性loginsystem
     * @param loginSystem 待设置的属性loginsystem的值
     */
    public void setLoginSystem(String loginSystem){
        this.loginSystem = StringUtils.rightTrim(loginSystem);
    }

    /**
     * 获取属性loginsystem
     * @return 属性loginsystem的值
     */
    public String getLoginSystem(){
        return loginSystem;
    }

    /**
     * 设置属性newusercode
     * @param newUserCode 待设置的属性newusercode的值
     */
    public void setNewUserCode(String newUserCode){
        this.newUserCode = StringUtils.rightTrim(newUserCode);
    }

    /**
     * 获取属性newusercode
     * @return 属性newusercode的值
     */
    public String getNewUserCode(){
        return newUserCode;
    }

    /**
     * 设置属性validstatus
     * @param validStatus 待设置的属性validstatus的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性validstatus
     * @return 属性validstatus的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性articlecode
     * @param articleCode 待设置的属性articlecode的值
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * 获取属性articlecode
     * @return 属性articlecode的值
     */
    public String getArticleCode(){
        return articleCode;
    }

    /**
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public String getFlag(){
        return flag;
    }
}
