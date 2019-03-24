package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLthirdProp-�Ʋ���ʧ��λ������ݴ���������<br>
 * ������ 2005-04-12 16:23:32.046<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLthirdPropDtoBase implements Serializable{
    /** ���Ա������� */
    private String registNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ������ʧ��Ŀ��� */
    private int serialNo = 0;
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** ���ԲƲ���ʧ��λ���� */
    private String lossItemCode = "";
    /** ���ԲƲ���ʧ��λ���� */
    private String lossItemName = "";
    /** ������ʧ�������� */
    private String lossItemDesc = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLthirdPropDtoBase����
     */
    public PrpLthirdPropDtoBase(){
    }

    /**
     * �������Ա�������
     * @param registNo �����õ����Ա��������ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getRegistNo(){
        return registNo;
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
     * ����������ʧ��Ŀ���
     * @param serialNo �����õ�������ʧ��Ŀ��ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ������ʧ��Ŀ���
     * @return ������ʧ��Ŀ��ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Գ��ƺ���
     * @param licenseNo �����õ����Գ��ƺ����ֵ
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ���Գ��ƺ���
     * @return ���Գ��ƺ����ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * �������ԲƲ���ʧ��λ����
     * @param lossItemCode �����õ����ԲƲ���ʧ��λ�����ֵ
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * ��ȡ���ԲƲ���ʧ��λ����
     * @return ���ԲƲ���ʧ��λ�����ֵ
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * �������ԲƲ���ʧ��λ����
     * @param lossItemName �����õ����ԲƲ���ʧ��λ���Ƶ�ֵ
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * ��ȡ���ԲƲ���ʧ��λ����
     * @return ���ԲƲ���ʧ��λ���Ƶ�ֵ
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * ����������ʧ��������
     * @param lossItemDesc �����õ�������ʧ����������ֵ
     */
    public void setLossItemDesc(String lossItemDesc){
        this.lossItemDesc = StringUtils.rightTrim(lossItemDesc);
    }

    /**
     * ��ȡ������ʧ��������
     * @return ������ʧ����������ֵ
     */
    public String getLossItemDesc(){
        return lossItemDesc;
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
