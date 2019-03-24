package com.sinosoft.function.power.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpDuser Ա�����������ݴ���������<br>
 * ������ 2004-11-09 18:30:39.076<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDuserDtoBase implements Serializable{
    /** ����Ա������ */
    private String userCode = "";
    /** ����Ա������ */
    private String userName = "";
    /** ����Ա������E */
    private String userEName = "";
    /** �������� */
    private String password = "";
    /** ����ӡ�� */
    private String seal = "";
    /** ���������������� */
    private DateTime passwordSetDate = new DateTime();
    /** ��������������� */
    private DateTime passwordExpireDate = new DateTime();
    /** ���Թ����������� */
    private String comCode = "";
    /** ���Գ����������� */
    private String makeCom = "";
    /** �����˺Ŵ��� */
    private String accountCode = "";
    /** ���Ե绰���� */
    private String phone = "";
    /** �����ֻ����� */
    private String mobile = "";
    /** ����ͨ�ŵ�ַ */
    private String address = "";
    /** ������������ */
    private String postCode = "";
    /** �������� */
    private String email = "";
    /** ����Ա����־ */
    private String userFlag = "";
    /** ���������¼��Ӧ��ϵͳ */
    private String loginSystem = "";
    /** ��������Ա������ */
    private String newUserCode = "";
    /** ����Ч��״̬ */
    private String validStatus = "";
    /** ����ר����� */
    private String articleCode = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDuserDtoBase����
     */
    public PrpDuserDtoBase(){
    }

    /**
     * ��������Ա������
     * @param userCode �����õ�����Ա�������ֵ
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * ��ȡ����Ա������
     * @return ����Ա�������ֵ
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * ��������Ա������
     * @param userName �����õ�����Ա�����Ƶ�ֵ
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * ��ȡ����Ա������
     * @return ����Ա�����Ƶ�ֵ
     */
    public String getUserName(){
        return userName;
    }

    /**
     * ��������Ա������E
     * @param userEName �����õ�����Ա������E��ֵ
     */
    public void setUserEName(String userEName){
        this.userEName = StringUtils.rightTrim(userEName);
    }

    /**
     * ��ȡ����Ա������E
     * @return ����Ա������E��ֵ
     */
    public String getUserEName(){
        return userEName;
    }

    /**
     * ������������
     * @param password �����õ����������ֵ
     */
    public void setPassword(String password){
        this.password = StringUtils.rightTrim(password);
    }

    /**
     * ��ȡ��������
     * @return ���������ֵ
     */
    public String getPassword(){
        return password;
    }

    /**
     * ��������ӡ��
     * @param seal �����õ�����ӡ����ֵ
     */
    public void setSeal(String seal){
        this.seal = StringUtils.rightTrim(seal);
    }

    /**
     * ��ȡ����ӡ��
     * @return ����ӡ����ֵ
     */
    public String getSeal(){
        return seal;
    }

    /**
     * ��������������������
     * @param passwordSetDate �����õ����������������ڵ�ֵ
     */
    public void setPasswordSetDate(DateTime passwordSetDate){
        this.passwordSetDate = passwordSetDate;
    }

    /**
     * ��ȡ����������������
     * @return ���������������ڵ�ֵ
     */
    public DateTime getPasswordSetDate(){
        return passwordSetDate;
    }

    /**
     * �������������������
     * @param passwordExpireDate �����õ���������������ڵ�ֵ
     */
    public void setPasswordExpireDate(DateTime passwordExpireDate){
        this.passwordExpireDate = passwordExpireDate;
    }

    /**
     * ��ȡ���������������
     * @return ��������������ڵ�ֵ
     */
    public DateTime getPasswordExpireDate(){
        return passwordExpireDate;
    }

    /**
     * �������Թ�����������
     * @param comCode �����õ����Թ������������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Թ�����������
     * @return ���Թ������������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Գ�����������
     * @param makeCom �����õ����Գ������������ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ���Գ�����������
     * @return ���Գ������������ֵ
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * ���������˺Ŵ���
     * @param accountCode �����õ������˺Ŵ����ֵ
     */
    public void setAccountCode(String accountCode){
        this.accountCode = StringUtils.rightTrim(accountCode);
    }

    /**
     * ��ȡ�����˺Ŵ���
     * @return �����˺Ŵ����ֵ
     */
    public String getAccountCode(){
        return accountCode;
    }

    /**
     * �������Ե绰����
     * @param phone �����õ����Ե绰�����ֵ
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * ��ȡ���Ե绰����
     * @return ���Ե绰�����ֵ
     */
    public String getPhone(){
        return phone;
    }

    /**
     * ���������ֻ�����
     * @param mobile �����õ������ֻ������ֵ
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * ��ȡ�����ֻ�����
     * @return �����ֻ������ֵ
     */
    public String getMobile(){
        return mobile;
    }

    /**
     * ��������ͨ�ŵ�ַ
     * @param address �����õ�����ͨ�ŵ�ַ��ֵ
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * ��ȡ����ͨ�ŵ�ַ
     * @return ����ͨ�ŵ�ַ��ֵ
     */
    public String getAddress(){
        return address;
    }

    /**
     * ����������������
     * @param postCode �����õ��������������ֵ
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * ������������
     * @param email �����õ����������ֵ
     */
    public void setEmail(String email){
        this.email = StringUtils.rightTrim(email);
    }

    /**
     * ��ȡ��������
     * @return ���������ֵ
     */
    public String getEmail(){
        return email;
    }

    /**
     * ��������Ա����־
     * @param userFlag �����õ�����Ա����־��ֵ
     */
    public void setUserFlag(String userFlag){
        this.userFlag = StringUtils.rightTrim(userFlag);
    }

    /**
     * ��ȡ����Ա����־
     * @return ����Ա����־��ֵ
     */
    public String getUserFlag(){
        return userFlag;
    }

    /**
     * �������������¼��Ӧ��ϵͳ
     * @param loginSystem �����õ����������¼��Ӧ��ϵͳ��ֵ
     */
    public void setLoginSystem(String loginSystem){
        this.loginSystem = StringUtils.rightTrim(loginSystem);
    }

    /**
     * ��ȡ���������¼��Ӧ��ϵͳ
     * @return ���������¼��Ӧ��ϵͳ��ֵ
     */
    public String getLoginSystem(){
        return loginSystem;
    }

    /**
     * ������������Ա������
     * @param newUserCode �����õ���������Ա�������ֵ
     */
    public void setNewUserCode(String newUserCode){
        this.newUserCode = StringUtils.rightTrim(newUserCode);
    }

    /**
     * ��ȡ��������Ա������
     * @return ��������Ա�������ֵ
     */
    public String getNewUserCode(){
        return newUserCode;
    }

    /**
     * ��������Ч��״̬
     * @param validStatus �����õ�����Ч��״̬��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����Ч��״̬
     * @return ����Ч��״̬��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������ר�����
     * @param articleCode �����õ�����ר������ֵ
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * ��ȡ����ר�����
     * @return ����ר������ֵ
     */
    public String getArticleCode(){
        return articleCode;
    }

    /**
     * �������Ա�־�ֶ�
     * @param flag �����õ����Ա�־�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
     * @return ���Ա�־�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
