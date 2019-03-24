package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ��������վݵ����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLIndemnityReceiptDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����ҵ��� */
    private String businessNo = "";
    /** ���Ե�֤���� */
    private String certiType = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Ա������˴��� */
    private String insuredCode = "";
    /** ���Ա����������� */
    private String insuredName = "";
    /** �����տλ���� */
    private String unitBank = "";
    /** �����տλ�ʺ� */
    private String unitAccount = "";
    /** �����տ��������ʺ� */
    private String account = "";
    /** �����տ������֤�� */
    private String identifyNumber = "";
    /** ���Դ�ӡ��֤���� */
    private String visaCode = "";
    /** ���Դ�ӡ��֤���� */
    private String visaName = "";
    /** ���Դ�ӡ��֤��ˮ�� */
    private String printNo = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLIndemnityReceiptDtoBase����
     */
    public PrpLIndemnityReceiptDtoBase(){
    }

    /**
     * ��������ҵ���
     * @param businessNo �����õ�����ҵ��ŵ�ֵ
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * ��ȡ����ҵ���
     * @return ����ҵ��ŵ�ֵ
     */
    public String getBusinessNo(){
        return businessNo;
    }

    /**
     * �������Ե�֤����
     * @param certiType �����õ����Ե�֤���͵�ֵ
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * ��ȡ���Ե�֤����
     * @return ���Ե�֤���͵�ֵ
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * �������Ա�����
     * @param policyNo �����õ����Ա����ŵ�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * �������Ա������˴���
     * @param insuredCode �����õ����Ա������˴����ֵ
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * ��ȡ���Ա������˴���
     * @return ���Ա������˴����ֵ
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * �������Ա�����������
     * @param insuredName �����õ����Ա����������Ƶ�ֵ
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * ��ȡ���Ա�����������
     * @return ���Ա����������Ƶ�ֵ
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * ���������տλ����
     * @param unitBank �����õ������տλ���е�ֵ
     */
    public void setUnitBank(String unitBank){
        this.unitBank = StringUtils.rightTrim(unitBank);
    }

    /**
     * ��ȡ�����տλ����
     * @return �����տλ���е�ֵ
     */
    public String getUnitBank(){
        return unitBank;
    }

    /**
     * ���������տλ�ʺ�
     * @param unitAccount �����õ������տλ�ʺŵ�ֵ
     */
    public void setUnitAccount(String unitAccount){
        this.unitAccount = StringUtils.rightTrim(unitAccount);
    }

    /**
     * ��ȡ�����տλ�ʺ�
     * @return �����տλ�ʺŵ�ֵ
     */
    public String getUnitAccount(){
        return unitAccount;
    }

    /**
     * ���������տ��������ʺ�
     * @param account �����õ������տ��������ʺŵ�ֵ
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * ��ȡ�����տ��������ʺ�
     * @return �����տ��������ʺŵ�ֵ
     */
    public String getAccount(){
        return account;
    }

    /**
     * ���������տ������֤��
     * @param identifyNumber �����õ������տ������֤�ŵ�ֵ
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * ��ȡ�����տ������֤��
     * @return �����տ������֤�ŵ�ֵ
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * �������Դ�ӡ��֤����
     * @param visaCode �����õ����Դ�ӡ��֤�����ֵ
     */
    public void setVisaCode(String visaCode){
        this.visaCode = StringUtils.rightTrim(visaCode);
    }

    /**
     * ��ȡ���Դ�ӡ��֤����
     * @return ���Դ�ӡ��֤�����ֵ
     */
    public String getVisaCode(){
        return visaCode;
    }

    /**
     * �������Դ�ӡ��֤����
     * @param visaName �����õ����Դ�ӡ��֤���Ƶ�ֵ
     */
    public void setVisaName(String visaName){
        this.visaName = StringUtils.rightTrim(visaName);
    }

    /**
     * ��ȡ���Դ�ӡ��֤����
     * @return ���Դ�ӡ��֤���Ƶ�ֵ
     */
    public String getVisaName(){
        return visaName;
    }

    /**
     * �������Դ�ӡ��֤��ˮ��
     * @param printNo �����õ����Դ�ӡ��֤��ˮ�ŵ�ֵ
     */
    public void setPrintNo(String printNo){
        this.printNo = StringUtils.rightTrim(printNo);
    }

    /**
     * ��ȡ���Դ�ӡ��֤��ˮ��
     * @return ���Դ�ӡ��֤��ˮ�ŵ�ֵ
     */
    public String getPrintNo(){
        return printNo;
    }
}
