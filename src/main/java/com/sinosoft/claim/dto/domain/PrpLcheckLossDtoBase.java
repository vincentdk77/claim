package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLcheckLoss-�鿱�¹ʹ����������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.531<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcheckLossDtoBase implements Serializable{
    /** ���Գ��յǼǺ� */
    private String registNo = "";
    /** �����ⰸ���� */
    private String claimNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Թ������⳵�����  (���߽��Ϊ���ܻ������ÿ����) */
    private int referSerialNo = 0;
    /** �����ձ����--** ������
--** ������
--** ���������� */
    private String kindCode = "";
    /** ���Խ������
--** ���𲿷֣�
--** 1. �����ʧ
--** 2. ʩ�ȷ�
--** 3. ����
--** 4. �ϳ�
--** 5. ����
--** ���߲���
--** 1. ����
--** 2. ��Ա
--** 3. �Ʋ� */
    private String lossFeeType = "";
    /** ������ʧ��� */
    private double lossFee = 0d;
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcheckLossDtoBase����
     */
    public PrpLcheckLossDtoBase(){
    }

    /**
     * �������Գ��յǼǺ�
     * @param registNo �����õ����Գ��յǼǺŵ�ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Գ��յǼǺ�
     * @return ���Գ��յǼǺŵ�ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ���������ⰸ����
     * @param claimNo �����õ������ⰸ�����ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ����
     * @return �����ⰸ�����ֵ
     */
    public String getClaimNo(){
        return claimNo;
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
     * �������Թ������⳵�����  (���߽��Ϊ���ܻ������ÿ����)
     * @param referSerialNo �����õ����Թ������⳵�����  (���߽��Ϊ���ܻ������ÿ����)��ֵ
     */
    public void setReferSerialNo(int referSerialNo){
        this.referSerialNo = referSerialNo;
    }

    /**
     * ��ȡ���Թ������⳵�����  (���߽��Ϊ���ܻ������ÿ����)
     * @return ���Թ������⳵�����  (���߽��Ϊ���ܻ������ÿ����)��ֵ
     */
    public int getReferSerialNo(){
        return referSerialNo;
    }

    /**
     * ���������ձ����--** ������
--** ������
--** ����������
     * @param kindCode �����õ������ձ����--** ������
--** ������
--** ���������յ�ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ�����ձ����--** ������
--** ������
--** ����������
     * @return �����ձ����--** ������
--** ������
--** ���������յ�ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * �������Խ������
--** ���𲿷֣�
--** 1. �����ʧ
--** 2. ʩ�ȷ�
--** 3. ����
--** 4. �ϳ�
--** 5. ����
--** ���߲���
--** 1. ����
--** 2. ��Ա
--** 3. �Ʋ�
     * @param lossFeeType �����õ����Խ������
--** ���𲿷֣�
--** 1. �����ʧ
--** 2. ʩ�ȷ�
--** 3. ����
--** 4. �ϳ�
--** 5. ����
--** ���߲���
--** 1. ����
--** 2. ��Ա
--** 3. �Ʋ���ֵ
     */
    public void setLossFeeType(String lossFeeType){
        this.lossFeeType = StringUtils.rightTrim(lossFeeType);
    }

    /**
     * ��ȡ���Խ������
--** ���𲿷֣�
--** 1. �����ʧ
--** 2. ʩ�ȷ�
--** 3. ����
--** 4. �ϳ�
--** 5. ����
--** ���߲���
--** 1. ����
--** 2. ��Ա
--** 3. �Ʋ�
     * @return ���Խ������
--** ���𲿷֣�
--** 1. �����ʧ
--** 2. ʩ�ȷ�
--** 3. ����
--** 4. �ϳ�
--** 5. ����
--** ���߲���
--** 1. ����
--** 2. ��Ա
--** 3. �Ʋ���ֵ
     */
    public String getLossFeeType(){
        return lossFeeType;
    }

    /**
     * ����������ʧ���
     * @param lossFee �����õ�������ʧ����ֵ
     */
    public void setLossFee(double lossFee){
        this.lossFee = lossFee;
    }

    /**
     * ��ȡ������ʧ���
     * @return ������ʧ����ֵ
     */
    public double getLossFee(){
        return lossFee;
    }

    /**
     * �������Ա�־λ
     * @param flag �����õ����Ա�־λ��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־λ
     * @return ���Ա�־λ��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
