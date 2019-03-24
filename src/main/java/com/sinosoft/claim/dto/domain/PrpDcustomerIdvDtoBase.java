package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdcustomer_idv���˿ͻ����������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcustomerIdvDtoBase implements Serializable{
    /** ���Կͻ����� */
    private String customerCode = "";
    /** �����ٲ������� */
    private String shortHandCode = "";
    /** ���Կͻ��������� */
    private String customerCName = "";
    /** ���Կͻ�Ӣ������ */
    private String customerEName = "";
    /** ���Ե�ַ�������� */
    private String addressCName = "";
    /** ���Ե�ַӢ������ */
    private String addressEName = "";
    /** �������֤���� */
    private String identifyNumber = "";
    /** �������ŵȼ� */
    private String creditLevel = "";
    /** �����Ա� */
    private String sex = "";
    /** �������� */
    private int age = 0;
    /** ���Խ���״�� */
    private String health = "";
    /** ����ְҵ���� */
    private String occupationCode = "";
    /** ����ѧ������ */
    private String educationCode = "";
    /** ���Թ�����λ */
    private String unit = "";
    /** ���Ե�λ��ַ */
    private String unitAddress = "";
    /** ���Կͻ���־(0:��ʱ/1:��ʽ) */
    private String customerFlag = "";
    /** ���Ե绰 */
    private String phoneNumber = "";
    /** ���Դ��� */
    private String faxNumber = "";
    /** �����ֻ� */
    private String mobile = "";
    /** ����ͨ�ŵ�ַ */
    private String linkAddress = "";
    /** �����ʱ� */
    private String postCode = "";
    /** ���Ժ��� */
    private String pager = "";
    /** ����E_mail���� */
    private String email = "";
    /** ���Կ������� */
    private String bank = "";
    /** �����ʺ� */
    private String account = "";
    /** ��������ʱ�� */
    private DateTime deathDate = new DateTime();
    /** ���Ժ�������־ */
    private String blackState = "";
    /** �����µĿͻ����� */
    private String newCustomerCode = "";
    /** ����Ч��״̬(0ʧЧ/1��Ч) */
    private String validStatus = "";
    /** ����ר�����(��Ӧ��ƿ�Ŀ) */
    private String articleCode = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcustomer_idvDtoBase����
     */
    public PrpDcustomerIdvDtoBase(){
    }

    /**
     * �������Կͻ�����
     * @param customerCode �����õ����Կͻ������ֵ
     */
    public void setCustomerCode(String customerCode){
        this.customerCode = StringUtils.rightTrim(customerCode);
    }

    /**
     * ��ȡ���Կͻ�����
     * @return ���Կͻ������ֵ
     */
    public String getCustomerCode(){
        return customerCode;
    }

    /**
     * ���������ٲ�������
     * @param shortHandCode �����õ������ٲ��������ֵ
     */
    public void setShortHandCode(String shortHandCode){
        this.shortHandCode = StringUtils.rightTrim(shortHandCode);
    }

    /**
     * ��ȡ�����ٲ�������
     * @return �����ٲ��������ֵ
     */
    public String getShortHandCode(){
        return shortHandCode;
    }

    /**
     * �������Կͻ���������
     * @param customerCName �����õ����Կͻ��������Ƶ�ֵ
     */
    public void setCustomerCName(String customerCName){
        this.customerCName = StringUtils.rightTrim(customerCName);
    }

    /**
     * ��ȡ���Կͻ���������
     * @return ���Կͻ��������Ƶ�ֵ
     */
    public String getCustomerCName(){
        return customerCName;
    }

    /**
     * �������Կͻ�Ӣ������
     * @param customerEName �����õ����Կͻ�Ӣ�����Ƶ�ֵ
     */
    public void setCustomerEName(String customerEName){
        this.customerEName = StringUtils.rightTrim(customerEName);
    }

    /**
     * ��ȡ���Կͻ�Ӣ������
     * @return ���Կͻ�Ӣ�����Ƶ�ֵ
     */
    public String getCustomerEName(){
        return customerEName;
    }

    /**
     * �������Ե�ַ��������
     * @param addressCName �����õ����Ե�ַ�������Ƶ�ֵ
     */
    public void setAddressCName(String addressCName){
        this.addressCName = StringUtils.rightTrim(addressCName);
    }

    /**
     * ��ȡ���Ե�ַ��������
     * @return ���Ե�ַ�������Ƶ�ֵ
     */
    public String getAddressCName(){
        return addressCName;
    }

    /**
     * �������Ե�ַӢ������
     * @param addressEName �����õ����Ե�ַӢ�����Ƶ�ֵ
     */
    public void setAddressEName(String addressEName){
        this.addressEName = StringUtils.rightTrim(addressEName);
    }

    /**
     * ��ȡ���Ե�ַӢ������
     * @return ���Ե�ַӢ�����Ƶ�ֵ
     */
    public String getAddressEName(){
        return addressEName;
    }

    /**
     * �����������֤����
     * @param identifyNumber �����õ��������֤�����ֵ
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * ��ȡ�������֤����
     * @return �������֤�����ֵ
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * �����������ŵȼ�
     * @param creditLevel �����õ��������ŵȼ���ֵ
     */
    public void setCreditLevel(String creditLevel){
        this.creditLevel = StringUtils.rightTrim(creditLevel);
    }

    /**
     * ��ȡ�������ŵȼ�
     * @return �������ŵȼ���ֵ
     */
    public String getCreditLevel(){
        return creditLevel;
    }

    /**
     * ���������Ա�
     * @param sex �����õ������Ա��ֵ
     */
    public void setSex(String sex){
        this.sex = StringUtils.rightTrim(sex);
    }

    /**
     * ��ȡ�����Ա�
     * @return �����Ա��ֵ
     */
    public String getSex(){
        return sex;
    }

    /**
     * ������������
     * @param age �����õ����������ֵ
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * ��ȡ��������
     * @return ���������ֵ
     */
    public int getAge(){
        return age;
    }

    /**
     * �������Խ���״��
     * @param health �����õ����Խ���״����ֵ
     */
    public void setHealth(String health){
        this.health = StringUtils.rightTrim(health);
    }

    /**
     * ��ȡ���Խ���״��
     * @return ���Խ���״����ֵ
     */
    public String getHealth(){
        return health;
    }

    /**
     * ��������ְҵ����
     * @param occupationCode �����õ�����ְҵ�����ֵ
     */
    public void setOccupationCode(String occupationCode){
        this.occupationCode = StringUtils.rightTrim(occupationCode);
    }

    /**
     * ��ȡ����ְҵ����
     * @return ����ְҵ�����ֵ
     */
    public String getOccupationCode(){
        return occupationCode;
    }

    /**
     * ��������ѧ������
     * @param educationCode �����õ�����ѧ�������ֵ
     */
    public void setEducationCode(String educationCode){
        this.educationCode = StringUtils.rightTrim(educationCode);
    }

    /**
     * ��ȡ����ѧ������
     * @return ����ѧ�������ֵ
     */
    public String getEducationCode(){
        return educationCode;
    }

    /**
     * �������Թ�����λ
     * @param unit �����õ����Թ�����λ��ֵ
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * ��ȡ���Թ�����λ
     * @return ���Թ�����λ��ֵ
     */
    public String getUnit(){
        return unit;
    }

    /**
     * �������Ե�λ��ַ
     * @param unitAddress �����õ����Ե�λ��ַ��ֵ
     */
    public void setUnitAddress(String unitAddress){
        this.unitAddress = StringUtils.rightTrim(unitAddress);
    }

    /**
     * ��ȡ���Ե�λ��ַ
     * @return ���Ե�λ��ַ��ֵ
     */
    public String getUnitAddress(){
        return unitAddress;
    }

    /**
     * �������Կͻ���־(0:��ʱ/1:��ʽ)
     * @param customerFlag �����õ����Կͻ���־(0:��ʱ/1:��ʽ)��ֵ
     */
    public void setCustomerFlag(String customerFlag){
        this.customerFlag = StringUtils.rightTrim(customerFlag);
    }

    /**
     * ��ȡ���Կͻ���־(0:��ʱ/1:��ʽ)
     * @return ���Կͻ���־(0:��ʱ/1:��ʽ)��ֵ
     */
    public String getCustomerFlag(){
        return customerFlag;
    }

    /**
     * �������Ե绰
     * @param phoneNumber �����õ����Ե绰��ֵ
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * ��ȡ���Ե绰
     * @return ���Ե绰��ֵ
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * �������Դ���
     * @param faxNumber �����õ����Դ����ֵ
     */
    public void setFaxNumber(String faxNumber){
        this.faxNumber = StringUtils.rightTrim(faxNumber);
    }

    /**
     * ��ȡ���Դ���
     * @return ���Դ����ֵ
     */
    public String getFaxNumber(){
        return faxNumber;
    }

    /**
     * ���������ֻ�
     * @param mobile �����õ������ֻ���ֵ
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * ��ȡ�����ֻ�
     * @return �����ֻ���ֵ
     */
    public String getMobile(){
        return mobile;
    }

    /**
     * ��������ͨ�ŵ�ַ
     * @param linkAddress �����õ�����ͨ�ŵ�ַ��ֵ
     */
    public void setLinkAddress(String linkAddress){
        this.linkAddress = StringUtils.rightTrim(linkAddress);
    }

    /**
     * ��ȡ����ͨ�ŵ�ַ
     * @return ����ͨ�ŵ�ַ��ֵ
     */
    public String getLinkAddress(){
        return linkAddress;
    }

    /**
     * ���������ʱ�
     * @param postCode �����õ������ʱ��ֵ
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * ��ȡ�����ʱ�
     * @return �����ʱ��ֵ
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * �������Ժ���
     * @param pager �����õ����Ժ�����ֵ
     */
    public void setPager(String pager){
        this.pager = StringUtils.rightTrim(pager);
    }

    /**
     * ��ȡ���Ժ���
     * @return ���Ժ�����ֵ
     */
    public String getPager(){
        return pager;
    }

    /**
     * ��������E_mail����
     * @param email �����õ�����E_mail�����ֵ
     */
    public void setEmail(String email){
        this.email = StringUtils.rightTrim(email);
    }

    /**
     * ��ȡ����E_mail����
     * @return ����E_mail�����ֵ
     */
    public String getEmail(){
        return email;
    }

    /**
     * �������Կ�������
     * @param bank �����õ����Կ������е�ֵ
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * ��ȡ���Կ�������
     * @return ���Կ������е�ֵ
     */
    public String getBank(){
        return bank;
    }

    /**
     * ���������ʺ�
     * @param account �����õ������ʺŵ�ֵ
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * ��ȡ�����ʺ�
     * @return �����ʺŵ�ֵ
     */
    public String getAccount(){
        return account;
    }

    /**
     * ������������ʱ��
     * @param deathDate �����õ���������ʱ���ֵ
     */
    public void setDeathDate(DateTime deathDate){
        this.deathDate = deathDate;
    }

    /**
     * ��ȡ��������ʱ��
     * @return ��������ʱ���ֵ
     */
    public DateTime getDeathDate(){
        return deathDate;
    }

    /**
     * �������Ժ�������־
     * @param blackState �����õ����Ժ�������־��ֵ
     */
    public void setBlackState(String blackState){
        this.blackState = StringUtils.rightTrim(blackState);
    }

    /**
     * ��ȡ���Ժ�������־
     * @return ���Ժ�������־��ֵ
     */
    public String getBlackState(){
        return blackState;
    }

    /**
     * ���������µĿͻ�����
     * @param newCustomerCode �����õ������µĿͻ������ֵ
     */
    public void setNewCustomerCode(String newCustomerCode){
        this.newCustomerCode = StringUtils.rightTrim(newCustomerCode);
    }

    /**
     * ��ȡ�����µĿͻ�����
     * @return �����µĿͻ������ֵ
     */
    public String getNewCustomerCode(){
        return newCustomerCode;
    }

    /**
     * ��������Ч��״̬(0ʧЧ/1��Ч)
     * @param validStatus �����õ�����Ч��״̬(0ʧЧ/1��Ч)��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����Ч��״̬(0ʧЧ/1��Ч)
     * @return ����Ч��״̬(0ʧЧ/1��Ч)��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������ר�����(��Ӧ��ƿ�Ŀ)
     * @param articleCode �����õ�����ר�����(��Ӧ��ƿ�Ŀ)��ֵ
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * ��ȡ����ר�����(��Ӧ��ƿ�Ŀ)
     * @return ����ר�����(��Ӧ��ƿ�Ŀ)��ֵ
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
