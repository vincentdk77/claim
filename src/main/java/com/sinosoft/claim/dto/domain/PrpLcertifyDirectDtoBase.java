package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLcertifyDirect������ָ�������ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLcertifyDirectDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ���Ա������� */
    private String registNo = "";
    /** ������� */
    private int serialNo = 0;
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Ա�Ĵ��� */
    private String lossItemCode = "";
    /** ���Ե�֤���ʹ��� */
    private String typeCode = "";
    /** ���Ե�֤�������� */
    private String typeName = "";
    /** ���������ֶ����� */
    private String columnValue = "";
    /** ���Ա�־ */
    private String flag = "";
    /** ����ǿ�Ʊ����ռ���־ */
    private String compelFlag = "";
    /** ������ҵ�����ռ���־ */
    private String businessFlag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcertifyDirectDtoBase����
     */
    public PrpLcertifyDirectDtoBase(){
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
     * �������Ա�Ĵ���
     * @param lossItemCode �����õ����Ա�Ĵ����ֵ
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * ��ȡ���Ա�Ĵ���
     * @return ���Ա�Ĵ����ֵ
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * �������Ե�֤���ʹ���
     * @param typeCode �����õ����Ե�֤���ʹ����ֵ
     */
    public void setTypeCode(String typeCode){
        this.typeCode = StringUtils.rightTrim(typeCode);
    }

    /**
     * ��ȡ���Ե�֤���ʹ���
     * @return ���Ե�֤���ʹ����ֵ
     */
    public String getTypeCode(){
        return typeCode;
    }

    /**
     * �������Ե�֤��������
     * @param typeName �����õ����Ե�֤�������Ƶ�ֵ
     */
    public void setTypeName(String typeName){
        this.typeName = StringUtils.rightTrim(typeName);
    }

    /**
     * ��ȡ���Ե�֤��������
     * @return ���Ե�֤�������Ƶ�ֵ
     */
    public String getTypeName(){
        return typeName;
    }

    /**
     * �������������ֶ�����
     * @param columnValue �����õ����������ֶ����ݵ�ֵ
     */
    public void setColumnValue(String columnValue){
        this.columnValue = StringUtils.rightTrim(columnValue);
    }

    /**
     * ��ȡ���������ֶ�����
     * @return ���������ֶ����ݵ�ֵ
     */
    public String getColumnValue(){
        return columnValue;
    }

    /**
     * �������Ա�־
     * @param flag �����õ����Ա�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־
     * @return ���Ա�־��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * ��������ǿ�Ʊ����ռ���־
     * @param compelFlag �����õ�����ǿ�Ʊ����ռ���־��ֵ
     */
    public void setCompelFlag(String compelFlag){
        this.compelFlag = StringUtils.rightTrim(compelFlag);
    }

    /**
     * ��ȡ����ǿ�Ʊ����ռ���־
     * @return ����ǿ�Ʊ����ռ���־��ֵ
     */
    public String getCompelFlag(){
        return compelFlag;
    }

    /**
     * ����������ҵ�����ռ���־
     * @param businessFlag �����õ�������ҵ�����ռ���־��ֵ
     */
    public void setBusinessFlag(String businessFlag){
        this.businessFlag = StringUtils.rightTrim(businessFlag);
    }

    /**
     * ��ȡ������ҵ�����ռ���־
     * @return ������ҵ�����ռ���־��ֵ
     */
    public String getBusinessFlag(){
        return businessFlag;
    }
}
