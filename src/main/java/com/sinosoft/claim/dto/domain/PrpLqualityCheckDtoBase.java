package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLqualityCheck-�����������ݱ�����ݴ���������<br>
 * ������ 2005-04-14 15:56:44.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLqualityCheckDtoBase implements Serializable{
    /** ���Ա������� */
    private String registNo = "";
    /** ����ҵ������ */
    private String qualityCheckType = "";
    /** ������� */
    private int serialNo = 0;
    /** ����������Ŀ���� */
    private String typeCode = "";
    /** ����������Ŀ���� */
    private String typeName = "";
    /** ���Իطý�� */
    private String checkResult = "";
    /** �������ⱸע */
    private String checkRemark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLqualityCheckDtoBase����
     */
    public PrpLqualityCheckDtoBase(){
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
     * ��������ҵ������
     * @param qualityCheckType �����õ�����ҵ�����͵�ֵ
     */
    public void setQualityCheckType(String qualityCheckType){
        this.qualityCheckType = StringUtils.rightTrim(qualityCheckType);
    }

    /**
     * ��ȡ����ҵ������
     * @return ����ҵ�����͵�ֵ
     */
    public String getQualityCheckType(){
        return qualityCheckType;
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
     * ��������������Ŀ����
     * @param typeCode �����õ�����������Ŀ�����ֵ
     */
    public void setTypeCode(String typeCode){
        this.typeCode = StringUtils.rightTrim(typeCode);
    }

    /**
     * ��ȡ����������Ŀ����
     * @return ����������Ŀ�����ֵ
     */
    public String getTypeCode(){
        return typeCode;
    }

    /**
     * ��������������Ŀ����
     * @param typeName �����õ�����������Ŀ���Ƶ�ֵ
     */
    public void setTypeName(String typeName){
        this.typeName = StringUtils.rightTrim(typeName);
    }

    /**
     * ��ȡ����������Ŀ����
     * @return ����������Ŀ���Ƶ�ֵ
     */
    public String getTypeName(){
        return typeName;
    }

    /**
     * �������Իطý��
     * @param checkResult �����õ����Իطý����ֵ
     */
    public void setCheckResult(String checkResult){
        this.checkResult = StringUtils.rightTrim(checkResult);
    }

    /**
     * ��ȡ���Իطý��
     * @return ���Իطý����ֵ
     */
    public String getCheckResult(){
        return checkResult;
    }

    /**
     * �����������ⱸע
     * @param checkRemark �����õ��������ⱸע��ֵ
     */
    public void setCheckRemark(String checkRemark){
        this.checkRemark = StringUtils.rightTrim(checkRemark);
    }

    /**
     * ��ȡ�������ⱸע
     * @return �������ⱸע��ֵ
     */
    public String getCheckRemark(){
        return checkRemark;
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
