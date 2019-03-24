package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpjprofitcond�Ż�����������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJprofitCondDtoBase implements Serializable{
    /** ���Ա��յ��Ŵ� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** �����Ż�ԭ�� */
    private String profitReason = "";
    /** ��������Ͷ�� */
    private String internetApply = "";
    /** ����ʹ������ */
    private String useNatureCode = "";
    /** ���Գ��� */
    private String carKindCode = "";
    /** ����������� */
    private String renewalFlag = "";
    /** �����Ż������ֶ�Ӣ������ */
    private String fieldEName = "";
    /** �����Ż������ֶ�ֵ */
    private int fieldValue = 0;
    /** �����Ż������ֶ�Ӣ������1 */
    private String fieldEName1 = "";
    /** �����Ż������ֶ�ֵ1 */
    private int fieldValue1 = 0;
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpJprofitCondDtoBase����
     */
    public PrpJprofitCondDtoBase(){
    }

    /**
     * �������Ա��յ��Ŵ�
     * @param policyNo �����õ����Ա��յ��Ŵε�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա��յ��Ŵ�
     * @return ���Ա��յ��Ŵε�ֵ
     */
    public String getPolicyNo(){
        return policyNo;
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
     * ���������Ż�ԭ��
     * @param profitReason �����õ������Ż�ԭ���ֵ
     */
    public void setProfitReason(String profitReason){
        this.profitReason = StringUtils.rightTrim(profitReason);
    }

    /**
     * ��ȡ�����Ż�ԭ��
     * @return �����Ż�ԭ���ֵ
     */
    public String getProfitReason(){
        return profitReason;
    }

    /**
     * ������������Ͷ��
     * @param internetApply �����õ���������Ͷ����ֵ
     */
    public void setInternetApply(String internetApply){
        this.internetApply = StringUtils.rightTrim(internetApply);
    }

    /**
     * ��ȡ��������Ͷ��
     * @return ��������Ͷ����ֵ
     */
    public String getInternetApply(){
        return internetApply;
    }

    /**
     * ��������ʹ������
     * @param useNatureCode �����õ�����ʹ�����ʵ�ֵ
     */
    public void setUseNatureCode(String useNatureCode){
        this.useNatureCode = StringUtils.rightTrim(useNatureCode);
    }

    /**
     * ��ȡ����ʹ������
     * @return ����ʹ�����ʵ�ֵ
     */
    public String getUseNatureCode(){
        return useNatureCode;
    }

    /**
     * �������Գ���
     * @param carKindCode �����õ����Գ��ֵ�ֵ
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * ��ȡ���Գ���
     * @return ���Գ��ֵ�ֵ
     */
    public String getCarKindCode(){
        return carKindCode;
    }

    /**
     * ���������������
     * @param renewalFlag �����õ��������������ֵ
     */
    public void setRenewalFlag(String renewalFlag){
        this.renewalFlag = StringUtils.rightTrim(renewalFlag);
    }

    /**
     * ��ȡ�����������
     * @return �������������ֵ
     */
    public String getRenewalFlag(){
        return renewalFlag;
    }

    /**
     * ���������Ż������ֶ�Ӣ������
     * @param fieldEName �����õ������Ż������ֶ�Ӣ�����Ƶ�ֵ
     */
    public void setFieldEName(String fieldEName){
        this.fieldEName = StringUtils.rightTrim(fieldEName);
    }

    /**
     * ��ȡ�����Ż������ֶ�Ӣ������
     * @return �����Ż������ֶ�Ӣ�����Ƶ�ֵ
     */
    public String getFieldEName(){
        return fieldEName;
    }

    /**
     * ���������Ż������ֶ�ֵ
     * @param fieldValue �����õ������Ż������ֶ�ֵ��ֵ
     */
    public void setFieldValue(int fieldValue){
        this.fieldValue = fieldValue;
    }

    /**
     * ��ȡ�����Ż������ֶ�ֵ
     * @return �����Ż������ֶ�ֵ��ֵ
     */
    public int getFieldValue(){
        return fieldValue;
    }

    /**
     * ���������Ż������ֶ�Ӣ������1
     * @param fieldEName1 �����õ������Ż������ֶ�Ӣ������1��ֵ
     */
    public void setFieldEName1(String fieldEName1){
        this.fieldEName1 = StringUtils.rightTrim(fieldEName1);
    }

    /**
     * ��ȡ�����Ż������ֶ�Ӣ������1
     * @return �����Ż������ֶ�Ӣ������1��ֵ
     */
    public String getFieldEName1(){
        return fieldEName1;
    }

    /**
     * ���������Ż������ֶ�ֵ1
     * @param fieldValue1 �����õ������Ż������ֶ�ֵ1��ֵ
     */
    public void setFieldValue1(int fieldValue1){
        this.fieldValue1 = fieldValue1;
    }

    /**
     * ��ȡ�����Ż������ֶ�ֵ1
     * @return �����Ż������ֶ�ֵ1��ֵ
     */
    public int getFieldValue1(){
        return fieldValue1;
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
