package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpDcustomerUnit��λ�ͻ����������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcustomerUnitDtoBase implements Serializable{
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
    /** ����ռ�����ʴ��� */
    private String possessNature = "";
    /** ������ҵ���� */
    private String businessSource = "";
    /** ���������ƴ��루��λ���ʴ��룩 */
    private String businessSort = "";
    /** ���Կͻ����� */
    private String customerKind = "";
    /** ���Կͻ���־ */
    private String customerFlag = "";
    /** ���Է�����֯�������� (I) */
    private String organizeCode = "";
    /** �������ŵȼ� */
    private String creditLevel = "";
    /** ���Է��˴��� */
    private String leaderName = "";
    /** ���Ե绰 */
    private String phoneNumber = "";
    /** ���Դ��� */
    private String faxNumber = "";
    /** �����ֻ� */
    private String mobile = "";
    /** ������ַ */
    private String netAddress = "";
    /** ���Ե������� */
    private String emailAddress = "";
    /** ����ͨ�ŵ�ַ */
    private String postAddress = "";
    /** �����ʱ� */
    private String postCode = "";
    /** ������ϵ�� */
    private String linkerName = "";
    /** ���Կ������� */
    private String bank = "";
    /** ���Կ����ʺ� */
    private String account = "";
    /** ���Թ��̾��� */
    private String industryCode = "";
    /** ���Ծ�óί�� */
    private String economyCode = "";
    /** ���Ա�׼������ */
    private String measureCode = "";
    /** �����ϼ����� */
    private String fatherCode = "";
    /** �������������� */
    private String sponsorName = "";
    /** ���Ծ�Ӫ��Χ */
    private String businessRange = "";
    /** ����ע���ʽ� */
    private double registFund = 0d;
    /** ���������������� */
    private String regionCode = "";
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
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcustomerUnitDtoBase����
     */
    public PrpDcustomerUnitDtoBase(){
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
     * ��������ռ�����ʴ���
     * @param possessNature �����õ�����ռ�����ʴ����ֵ
     */
    public void setPossessNature(String possessNature){
        this.possessNature = StringUtils.rightTrim(possessNature);
    }

    /**
     * ��ȡ����ռ�����ʴ���
     * @return ����ռ�����ʴ����ֵ
     */
    public String getPossessNature(){
        return possessNature;
    }

    /**
     * ����������ҵ����
     * @param businessSource �����õ�������ҵ�����ֵ
     */
    public void setBusinessSource(String businessSource){
        this.businessSource = StringUtils.rightTrim(businessSource);
    }

    /**
     * ��ȡ������ҵ����
     * @return ������ҵ�����ֵ
     */
    public String getBusinessSource(){
        return businessSource;
    }

    /**
     * �������������ƴ��루��λ���ʴ��룩
     * @param businessSort �����õ����������ƴ��루��λ���ʴ��룩��ֵ
     */
    public void setBusinessSort(String businessSort){
        this.businessSort = StringUtils.rightTrim(businessSort);
    }

    /**
     * ��ȡ���������ƴ��루��λ���ʴ��룩
     * @return ���������ƴ��루��λ���ʴ��룩��ֵ
     */
    public String getBusinessSort(){
        return businessSort;
    }

    /**
     * �������Կͻ�����
     * @param customerKind �����õ����Կͻ����͵�ֵ
     */
    public void setCustomerKind(String customerKind){
        this.customerKind = StringUtils.rightTrim(customerKind);
    }

    /**
     * ��ȡ���Կͻ�����
     * @return ���Կͻ����͵�ֵ
     */
    public String getCustomerKind(){
        return customerKind;
    }

    /**
     * �������Կͻ���־
     * @param customerFlag �����õ����Կͻ���־��ֵ
     */
    public void setCustomerFlag(String customerFlag){
        this.customerFlag = StringUtils.rightTrim(customerFlag);
    }

    /**
     * ��ȡ���Կͻ���־
     * @return ���Կͻ���־��ֵ
     */
    public String getCustomerFlag(){
        return customerFlag;
    }

    /**
     * �������Է�����֯�������� (I)
     * @param organizeCode �����õ����Է�����֯�������� (I)��ֵ
     */
    public void setOrganizeCode(String organizeCode){
        this.organizeCode = StringUtils.rightTrim(organizeCode);
    }

    /**
     * ��ȡ���Է�����֯�������� (I)
     * @return ���Է�����֯�������� (I)��ֵ
     */
    public String getOrganizeCode(){
        return organizeCode;
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
     * �������Է��˴���
     * @param leaderName �����õ����Է��˴����ֵ
     */
    public void setLeaderName(String leaderName){
        this.leaderName = StringUtils.rightTrim(leaderName);
    }

    /**
     * ��ȡ���Է��˴���
     * @return ���Է��˴����ֵ
     */
    public String getLeaderName(){
        return leaderName;
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
     * ����������ַ
     * @param netAddress �����õ�������ַ��ֵ
     */
    public void setNetAddress(String netAddress){
        this.netAddress = StringUtils.rightTrim(netAddress);
    }

    /**
     * ��ȡ������ַ
     * @return ������ַ��ֵ
     */
    public String getNetAddress(){
        return netAddress;
    }

    /**
     * �������Ե�������
     * @param emailAddress �����õ����Ե��������ֵ
     */
    public void setEmailAddress(String emailAddress){
        this.emailAddress = StringUtils.rightTrim(emailAddress);
    }

    /**
     * ��ȡ���Ե�������
     * @return ���Ե��������ֵ
     */
    public String getEmailAddress(){
        return emailAddress;
    }

    /**
     * ��������ͨ�ŵ�ַ
     * @param postAddress �����õ�����ͨ�ŵ�ַ��ֵ
     */
    public void setPostAddress(String postAddress){
        this.postAddress = StringUtils.rightTrim(postAddress);
    }

    /**
     * ��ȡ����ͨ�ŵ�ַ
     * @return ����ͨ�ŵ�ַ��ֵ
     */
    public String getPostAddress(){
        return postAddress;
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
     * ����������ϵ��
     * @param linkerName �����õ�������ϵ�˵�ֵ
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * ��ȡ������ϵ��
     * @return ������ϵ�˵�ֵ
     */
    public String getLinkerName(){
        return linkerName;
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
     * �������Կ����ʺ�
     * @param account �����õ����Կ����ʺŵ�ֵ
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * ��ȡ���Կ����ʺ�
     * @return ���Կ����ʺŵ�ֵ
     */
    public String getAccount(){
        return account;
    }

    /**
     * �������Թ��̾���
     * @param industryCode �����õ����Թ��̾����ֵ
     */
    public void setIndustryCode(String industryCode){
        this.industryCode = StringUtils.rightTrim(industryCode);
    }

    /**
     * ��ȡ���Թ��̾���
     * @return ���Թ��̾����ֵ
     */
    public String getIndustryCode(){
        return industryCode;
    }

    /**
     * �������Ծ�óί��
     * @param economyCode �����õ����Ծ�óί���ֵ
     */
    public void setEconomyCode(String economyCode){
        this.economyCode = StringUtils.rightTrim(economyCode);
    }

    /**
     * ��ȡ���Ծ�óί��
     * @return ���Ծ�óί���ֵ
     */
    public String getEconomyCode(){
        return economyCode;
    }

    /**
     * �������Ա�׼������
     * @param measureCode �����õ����Ա�׼�������ֵ
     */
    public void setMeasureCode(String measureCode){
        this.measureCode = StringUtils.rightTrim(measureCode);
    }

    /**
     * ��ȡ���Ա�׼������
     * @return ���Ա�׼�������ֵ
     */
    public String getMeasureCode(){
        return measureCode;
    }

    /**
     * ���������ϼ�����
     * @param fatherCode �����õ������ϼ������ֵ
     */
    public void setFatherCode(String fatherCode){
        this.fatherCode = StringUtils.rightTrim(fatherCode);
    }

    /**
     * ��ȡ�����ϼ�����
     * @return �����ϼ������ֵ
     */
    public String getFatherCode(){
        return fatherCode;
    }

    /**
     * ������������������
     * @param sponsorName �����õ��������������Ƶ�ֵ
     */
    public void setSponsorName(String sponsorName){
        this.sponsorName = StringUtils.rightTrim(sponsorName);
    }

    /**
     * ��ȡ��������������
     * @return �������������Ƶ�ֵ
     */
    public String getSponsorName(){
        return sponsorName;
    }

    /**
     * �������Ծ�Ӫ��Χ
     * @param businessRange �����õ����Ծ�Ӫ��Χ��ֵ
     */
    public void setBusinessRange(String businessRange){
        this.businessRange = StringUtils.rightTrim(businessRange);
    }

    /**
     * ��ȡ���Ծ�Ӫ��Χ
     * @return ���Ծ�Ӫ��Χ��ֵ
     */
    public String getBusinessRange(){
        return businessRange;
    }

    /**
     * ��������ע���ʽ�
     * @param registFund �����õ�����ע���ʽ��ֵ
     */
    public void setRegistFund(double registFund){
        this.registFund = registFund;
    }

    /**
     * ��ȡ����ע���ʽ�
     * @return ����ע���ʽ��ֵ
     */
    public double getRegistFund(){
        return registFund;
    }

    /**
     * ��������������������
     * @param regionCode �����õ������������������ֵ
     */
    public void setRegionCode(String regionCode){
        this.regionCode = StringUtils.rightTrim(regionCode);
    }

    /**
     * ��ȡ����������������
     * @return �����������������ֵ
     */
    public String getRegionCode(){
        return regionCode;
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
