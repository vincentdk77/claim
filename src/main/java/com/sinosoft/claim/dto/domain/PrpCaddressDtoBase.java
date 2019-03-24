package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpcaddress���յ�ַ������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCaddressDtoBase implements Serializable{
    /** ���Ա������� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ե�ַ��� */
    private int addressNo = 0;
    /** ���Ե�ַ���� */
    private String addressCode = "";
    /** ���Ե�ַ */
    private String addressName = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCaddressDtoBase����
     */
    public PrpCaddressDtoBase(){
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
     * �������Ե�ַ���
     * @param addressNo �����õ����Ե�ַ��ŵ�ֵ
     */
    public void setAddressNo(int addressNo){
        this.addressNo = addressNo;
    }

    /**
     * ��ȡ���Ե�ַ���
     * @return ���Ե�ַ��ŵ�ֵ
     */
    public int getAddressNo(){
        return addressNo;
    }

    /**
     * �������Ե�ַ����
     * @param addressCode �����õ����Ե�ַ�����ֵ
     */
    public void setAddressCode(String addressCode){
        this.addressCode = StringUtils.rightTrim(addressCode);
    }

    /**
     * ��ȡ���Ե�ַ����
     * @return ���Ե�ַ�����ֵ
     */
    public String getAddressCode(){
        return addressCode;
    }

    /**
     * �������Ե�ַ
     * @param addressName �����õ����Ե�ַ��ֵ
     */
    public void setAddressName(String addressName){
        this.addressName = StringUtils.rightTrim(addressName);
    }

    /**
     * ��ȡ���Ե�ַ
     * @return ���Ե�ַ��ֵ
     */
    public String getAddressName(){
        return addressName;
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
