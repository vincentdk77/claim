package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpcinsured���չ�ϵ�˱�����ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCinsuredDtoBase implements Serializable{
    /** ���Ա������� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ������� */
    private int serialNo = 0;
    /** �������� */
    private String language = "";
    /** ���Թ�ϵ������ */
    private String insuredType = "";
    /** ���Թ�ϵ�˴��� */
    private String insuredCode = "";
    /** ���Թ�ϵ������ */
    private String insuredName = "";
    /** ���Թ�ϵ�˵�ַ */
    private String insuredAddress = "";
    /** ���Թ�ϵ������ */
    private String insuredNature = "";
    /** ���Թ�ϵ�˱�־ */
    private String insuredFlag = "";
    /** �����Ǳ������˵� */
    private String insuredidentity = "";
    /** ���Թ�������� */
    private int relateserialno = 0;
    /** ����֤������ */
    private String identifytype = "";
    /** �������֤��/���˴��� */
    private String identifyNumber = "";
    /** �������ŵȼ� */
    private String creditLevel = "";
    /** ����ռ�����ʴ��� */
    private String possessNature = "";
    /** ������ҵ���� */
    private String businessSource = "";
    /** ���������ƴ��루��λ���ʴ��룩 */
    private String businessSort = "";
    /** ���Ը���ְҵ���� */
    private String occupationCode = "";
    /** ���Ը���ѧ������ */
    private String educationCode = "";
    /** ���Կ������� */
    private String bank = "";
    /** �����ʻ�����Ͷ��-�ɷ�/����-��ȡ�� */
    private String accountname = "";
    /** ���Կ����˺� */
    private String account = "";
    /** ������ϵ������ */
    private String linkerName = "";
    /** ����ͨѶ��ַ */
    private String postAddress = "";
    /** ������������ */
    private String postCode = "";
    /** ���Ե绰 */
    private String phoneNumber = "";
    /** �����ƶ��绰 */
    private String mobile = "";
    /** ���Ե����ʼ� */
    private String email = "";
    /** ���������˱�־ */
    private String benefitFlag = "";
    /** ��������ݶ� */
    private double benefitRate = 0d;
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCinsuredDtoBase����
     */
    public PrpCinsuredDtoBase(){
    }

    /**
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * �����������ִ���
     * @param riskCode �����õ��������ִ����ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ�������ִ���
     * @return �������ִ����ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * �����������
     * @param serialNo �����õ�������ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ������������
     * @param language �����õ��������ֵ�ֵ
     */
    public void setLanguage(String language){
        this.language = StringUtils.rightTrim(language);
    }

    /**
     * ��ȡ��������
     * @return �������ֵ�ֵ
     */
    public String getLanguage(){
        return language;
    }

    /**
     * �������Թ�ϵ������
     * @param insuredType �����õ����Թ�ϵ�����͵�ֵ
     */
    public void setInsuredType(String insuredType){
        this.insuredType = StringUtils.rightTrim(insuredType);
    }

    /**
     * ��ȡ���Թ�ϵ������
     * @return ���Թ�ϵ�����͵�ֵ
     */
    public String getInsuredType(){
        return insuredType;
    }

    /**
     * �������Թ�ϵ�˴���
     * @param insuredCode �����õ����Թ�ϵ�˴����ֵ
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * ��ȡ���Թ�ϵ�˴���
     * @return ���Թ�ϵ�˴����ֵ
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * �������Թ�ϵ������
     * @param insuredName �����õ����Թ�ϵ�����Ƶ�ֵ
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * ��ȡ���Թ�ϵ������
     * @return ���Թ�ϵ�����Ƶ�ֵ
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * �������Թ�ϵ�˵�ַ
     * @param insuredAddress �����õ����Թ�ϵ�˵�ַ��ֵ
     */
    public void setInsuredAddress(String insuredAddress){
        this.insuredAddress = StringUtils.rightTrim(insuredAddress);
    }

    /**
     * ��ȡ���Թ�ϵ�˵�ַ
     * @return ���Թ�ϵ�˵�ַ��ֵ
     */
    public String getInsuredAddress(){
        return insuredAddress;
    }

    /**
     * �������Թ�ϵ������
     * @param insuredNature �����õ����Թ�ϵ�����ʵ�ֵ
     */
    public void setInsuredNature(String insuredNature){
        this.insuredNature = StringUtils.rightTrim(insuredNature);
    }

    /**
     * ��ȡ���Թ�ϵ������
     * @return ���Թ�ϵ�����ʵ�ֵ
     */
    public String getInsuredNature(){
        return insuredNature;
    }

    /**
     * �������Թ�ϵ�˱�־
     * @param insuredFlag �����õ����Թ�ϵ�˱�־��ֵ
     */
    public void setInsuredFlag(String insuredFlag){
        this.insuredFlag = StringUtils.rightTrim(insuredFlag);
    }

    /**
     * ��ȡ���Թ�ϵ�˱�־
     * @return ���Թ�ϵ�˱�־��ֵ
     */
    public String getInsuredFlag(){
        return insuredFlag;
    }

    /**
     * ���������Ǳ������˵�
     * @param insuredidentity �����õ������Ǳ������˵ĵ�ֵ
     */
    public void setInsuredidentity(String insuredidentity){
        this.insuredidentity = StringUtils.rightTrim(insuredidentity);
    }

    /**
     * ��ȡ�����Ǳ������˵�
     * @return �����Ǳ������˵ĵ�ֵ
     */
    public String getInsuredidentity(){
        return insuredidentity;
    }

    /**
     * �������Թ��������
     * @param relateserialno �����õ����Թ�������ŵ�ֵ
     */
    public void setRelateserialno(int relateserialno){
        this.relateserialno = relateserialno;
    }

    /**
     * ��ȡ���Թ��������
     * @return ���Թ�������ŵ�ֵ
     */
    public int getRelateserialno(){
        return relateserialno;
    }

    /**
     * ��������֤������
     * @param identifytype �����õ�����֤�����͵�ֵ
     */
    public void setIdentifytype(String identifytype){
        this.identifytype = StringUtils.rightTrim(identifytype);
    }

    /**
     * ��ȡ����֤������
     * @return ����֤�����͵�ֵ
     */
    public String getIdentifytype(){
        return identifytype;
    }

    /**
     * �����������֤��/���˴���
     * @param identifyNumber �����õ��������֤��/���˴����ֵ
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * ��ȡ�������֤��/���˴���
     * @return �������֤��/���˴����ֵ
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
     * �������Ը���ְҵ����
     * @param occupationCode �����õ����Ը���ְҵ�����ֵ
     */
    public void setOccupationCode(String occupationCode){
        this.occupationCode = StringUtils.rightTrim(occupationCode);
    }

    /**
     * ��ȡ���Ը���ְҵ����
     * @return ���Ը���ְҵ�����ֵ
     */
    public String getOccupationCode(){
        return occupationCode;
    }

    /**
     * �������Ը���ѧ������
     * @param educationCode �����õ����Ը���ѧ�������ֵ
     */
    public void setEducationCode(String educationCode){
        this.educationCode = StringUtils.rightTrim(educationCode);
    }

    /**
     * ��ȡ���Ը���ѧ������
     * @return ���Ը���ѧ�������ֵ
     */
    public String getEducationCode(){
        return educationCode;
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
     * ���������ʻ�����Ͷ��-�ɷ�/����-��ȡ��
     * @param accountname �����õ������ʻ�����Ͷ��-�ɷ�/����-��ȡ����ֵ
     */
    public void setAccountname(String accountname){
        this.accountname = StringUtils.rightTrim(accountname);
    }

    /**
     * ��ȡ�����ʻ�����Ͷ��-�ɷ�/����-��ȡ��
     * @return �����ʻ�����Ͷ��-�ɷ�/����-��ȡ����ֵ
     */
    public String getAccountname(){
        return accountname;
    }

    /**
     * �������Կ����˺�
     * @param account �����õ����Կ����˺ŵ�ֵ
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * ��ȡ���Կ����˺�
     * @return ���Կ����˺ŵ�ֵ
     */
    public String getAccount(){
        return account;
    }

    /**
     * ����������ϵ������
     * @param linkerName �����õ�������ϵ�����Ƶ�ֵ
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * ��ȡ������ϵ������
     * @return ������ϵ�����Ƶ�ֵ
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * ��������ͨѶ��ַ
     * @param postAddress �����õ�����ͨѶ��ַ��ֵ
     */
    public void setPostAddress(String postAddress){
        this.postAddress = StringUtils.rightTrim(postAddress);
    }

    /**
     * ��ȡ����ͨѶ��ַ
     * @return ����ͨѶ��ַ��ֵ
     */
    public String getPostAddress(){
        return postAddress;
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
     * ���������ƶ��绰
     * @param mobile �����õ������ƶ��绰��ֵ
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * ��ȡ�����ƶ��绰
     * @return �����ƶ��绰��ֵ
     */
    public String getMobile(){
        return mobile;
    }

    /**
     * �������Ե����ʼ�
     * @param email �����õ����Ե����ʼ���ֵ
     */
    public void setEmail(String email){
        this.email = StringUtils.rightTrim(email);
    }

    /**
     * ��ȡ���Ե����ʼ�
     * @return ���Ե����ʼ���ֵ
     */
    public String getEmail(){
        return email;
    }

    /**
     * �������������˱�־
     * @param benefitFlag �����õ����������˱�־��ֵ
     */
    public void setBenefitFlag(String benefitFlag){
        this.benefitFlag = StringUtils.rightTrim(benefitFlag);
    }

    /**
     * ��ȡ���������˱�־
     * @return ���������˱�־��ֵ
     */
    public String getBenefitFlag(){
        return benefitFlag;
    }

    /**
     * ������������ݶ�
     * @param benefitRate �����õ���������ݶ��ֵ
     */
    public void setBenefitRate(double benefitRate){
        this.benefitRate = benefitRate;
    }

    /**
     * ��ȡ��������ݶ�
     * @return ��������ݶ��ֵ
     */
    public double getBenefitRate(){
        return benefitRate;
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
