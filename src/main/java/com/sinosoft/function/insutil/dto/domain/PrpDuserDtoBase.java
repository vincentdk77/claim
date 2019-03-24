package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpduser�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDuserDtoBase implements Serializable{
    /** ����usercode */
    private String userCode = "";
    /** ����username */
    private String userName = "";
    /** ����UserEName */
    private String userEName = "";
    /** ����password */
    private String password = "";
    /** ����seal */
    private String seal = "";
    /** ����passwordsetdate */
    private DateTime passwordSetDate = new DateTime();
    /** ����passwordexpiredate */
    private DateTime passwordExpireDate = new DateTime();
    /** ����comcode */
    private String comCode = "";
    /** ����makecom */
    private String makeCom = "";
    /** ���Ժ��㵥λ���� */
    private String accountCode = "";
    /** ����phone */
    private String phone = "";
    /** ����mobile */
    private String mobile = "";
    /** ����address */
    private String address = "";
    /** ����postcode */
    private String postCode = "";
    /** ����email */
    private String email = "";
    /** ����userflag */
    private String userFlag = "";
    /** ����loginsystem */
    private String loginSystem = "";
    /** ����newusercode */
    private String newUserCode = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����articlecode */
    private String articleCode = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDuserDtoBase����
     */
    public PrpDuserDtoBase(){
    }

    /**
     * ��������usercode
     * @param userCode �����õ�����usercode��ֵ
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * ��ȡ����usercode
     * @return ����usercode��ֵ
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * ��������username
     * @param userName �����õ�����username��ֵ
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * ��ȡ����username
     * @return ����username��ֵ
     */
    public String getUserName(){
        return userName;
    }

    /**
     * ��������UserEName
     * @param userEName �����õ�����UserEName��ֵ
     */
    public void setUserEName(String userEName){
        this.userEName = StringUtils.rightTrim(userEName);
    }

    /**
     * ��ȡ����UserEName
     * @return ����UserEName��ֵ
     */
    public String getUserEName(){
        return userEName;
    }

    /**
     * ��������password
     * @param password �����õ�����password��ֵ
     */
    public void setPassword(String password){
        this.password = StringUtils.rightTrim(password);
    }

    /**
     * ��ȡ����password
     * @return ����password��ֵ
     */
    public String getPassword(){
        return password;
    }

    /**
     * ��������seal
     * @param seal �����õ�����seal��ֵ
     */
    public void setSeal(String seal){
        this.seal = StringUtils.rightTrim(seal);
    }

    /**
     * ��ȡ����seal
     * @return ����seal��ֵ
     */
    public String getSeal(){
        return seal;
    }

    /**
     * ��������passwordsetdate
     * @param passwordSetDate �����õ�����passwordsetdate��ֵ
     */
    public void setPasswordSetDate(DateTime passwordSetDate){
        this.passwordSetDate = passwordSetDate;
    }

    /**
     * ��ȡ����passwordsetdate
     * @return ����passwordsetdate��ֵ
     */
    public DateTime getPasswordSetDate(){
        return passwordSetDate;
    }

    /**
     * ��������passwordexpiredate
     * @param passwordExpireDate �����õ�����passwordexpiredate��ֵ
     */
    public void setPasswordExpireDate(DateTime passwordExpireDate){
        this.passwordExpireDate = passwordExpireDate;
    }

    /**
     * ��ȡ����passwordexpiredate
     * @return ����passwordexpiredate��ֵ
     */
    public DateTime getPasswordExpireDate(){
        return passwordExpireDate;
    }

    /**
     * ��������comcode
     * @param comCode �����õ�����comcode��ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����comcode
     * @return ����comcode��ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������makecom
     * @param makeCom �����õ�����makecom��ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ����makecom
     * @return ����makecom��ֵ
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * �������Ժ��㵥λ����
     * @param accountCode �����õ����Ժ��㵥λ�����ֵ
     */
    public void setAccountCode(String accountCode){
        this.accountCode = StringUtils.rightTrim(accountCode);
    }

    /**
     * ��ȡ���Ժ��㵥λ����
     * @return ���Ժ��㵥λ�����ֵ
     */
    public String getAccountCode(){
        return accountCode;
    }

    /**
     * ��������phone
     * @param phone �����õ�����phone��ֵ
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * ��ȡ����phone
     * @return ����phone��ֵ
     */
    public String getPhone(){
        return phone;
    }

    /**
     * ��������mobile
     * @param mobile �����õ�����mobile��ֵ
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * ��ȡ����mobile
     * @return ����mobile��ֵ
     */
    public String getMobile(){
        return mobile;
    }

    /**
     * ��������address
     * @param address �����õ�����address��ֵ
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * ��ȡ����address
     * @return ����address��ֵ
     */
    public String getAddress(){
        return address;
    }

    /**
     * ��������postcode
     * @param postCode �����õ�����postcode��ֵ
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * ��ȡ����postcode
     * @return ����postcode��ֵ
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * ��������email
     * @param email �����õ�����email��ֵ
     */
    public void setEmail(String email){
        this.email = StringUtils.rightTrim(email);
    }

    /**
     * ��ȡ����email
     * @return ����email��ֵ
     */
    public String getEmail(){
        return email;
    }

    /**
     * ��������userflag
     * @param userFlag �����õ�����userflag��ֵ
     */
    public void setUserFlag(String userFlag){
        this.userFlag = StringUtils.rightTrim(userFlag);
    }

    /**
     * ��ȡ����userflag
     * @return ����userflag��ֵ
     */
    public String getUserFlag(){
        return userFlag;
    }

    /**
     * ��������loginsystem
     * @param loginSystem �����õ�����loginsystem��ֵ
     */
    public void setLoginSystem(String loginSystem){
        this.loginSystem = StringUtils.rightTrim(loginSystem);
    }

    /**
     * ��ȡ����loginsystem
     * @return ����loginsystem��ֵ
     */
    public String getLoginSystem(){
        return loginSystem;
    }

    /**
     * ��������newusercode
     * @param newUserCode �����õ�����newusercode��ֵ
     */
    public void setNewUserCode(String newUserCode){
        this.newUserCode = StringUtils.rightTrim(newUserCode);
    }

    /**
     * ��ȡ����newusercode
     * @return ����newusercode��ֵ
     */
    public String getNewUserCode(){
        return newUserCode;
    }

    /**
     * ��������validstatus
     * @param validStatus �����õ�����validstatus��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����validstatus
     * @return ����validstatus��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������articlecode
     * @param articleCode �����õ�����articlecode��ֵ
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * ��ȡ����articlecode
     * @return ����articlecode��ֵ
     */
    public String getArticleCode(){
        return articleCode;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
