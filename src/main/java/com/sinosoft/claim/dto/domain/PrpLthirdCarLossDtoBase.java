package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLthirdCarLoss-��ʧ��λ(����)�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.718<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLthirdCarLossDtoBase implements Serializable{
    /** ���Ա������� */
    private String registNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ������� */
    private int serialNo = 0;
    /** ������ʧ��Ŀ��� */
    private int itemNo = 0;
    /** ���Գ��ƺ� */
    private String licenseNo = "";
    /** �������(��Ŀ)���� */
    private String compCode = "";
    /** �������(��Ŀ)���� */
    private String compName = "";
    /** ������ʧ�̶ȼ��� */
    private String lossGrade = "";
    /** ������ʧ�̶����� */
    private String lossDesc = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

     /** ������ʧ�������� */
    private String partCode = "";
    /** ������ʧ�������� */
    private String partName = "";

    /** �����ձ���� */
    private String kindCode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLthirdCarLossDtoBase����
     */
    public PrpLthirdCarLossDtoBase(){
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
     * ����������ʧ��Ŀ���
     * @param itemNo �����õ�������ʧ��Ŀ��ŵ�ֵ
     */
    public void setItemNo(int itemNo){
        this.itemNo = itemNo;
    }

    /**
     * ��ȡ������ʧ��Ŀ���
     * @return ������ʧ��Ŀ��ŵ�ֵ
     */
    public int getItemNo(){
        return itemNo;
    }

    /**
     * �������Գ��ƺ�
     * @param licenseNo �����õ����Գ��ƺŵ�ֵ
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ���Գ��ƺ�
     * @return ���Գ��ƺŵ�ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
    }

     /**
     * �����������(��Ŀ)����
     * @param compCode �����õ��������(��Ŀ)�����ֵ
     */
    public void setCompCode(String compCode){
        this.compCode = StringUtils.rightTrim(compCode);
    }

    /**
     * ��ȡ�������(��Ŀ)����
     * @return �������(��Ŀ)�����ֵ
     */
    public String getCompCode(){
        return compCode;
    }

    /**
     * �����������(��Ŀ)����
     * @param compName �����õ��������(��Ŀ)���Ƶ�ֵ
     */
    public void setCompName(String compName){
        this.compName = StringUtils.rightTrim(compName);
    }

    /**
     * ��ȡ�������(��Ŀ)����
     * @return �������(��Ŀ)���Ƶ�ֵ
     */
    public String getCompName(){
        return compName;
    }

    /**
     * ����������ʧ�̶ȼ���
     * @param lossGrade �����õ�������ʧ�̶ȼ����ֵ
     */
    public void setLossGrade(String lossGrade){
        this.lossGrade = StringUtils.rightTrim(lossGrade);
    }

    /**
     * ��ȡ������ʧ�̶ȼ���
     * @return ������ʧ�̶ȼ����ֵ
     */
    public String getLossGrade(){
        return lossGrade;
    }

    /**
     * ����������ʧ�̶�����
     * @param lossDesc �����õ�������ʧ�̶�������ֵ
     */
    public void setLossDesc(String lossDesc){
        this.lossDesc = StringUtils.rightTrim(lossDesc);
    }

    /**
     * ��ȡ������ʧ�̶�����
     * @return ������ʧ�̶�������ֵ
     */
    public String getLossDesc(){
        return lossDesc;
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

     /**
     * ����������ʧ��������
     * @param partCode �����õ�������ʧ���������ֵ
     */
    public void setPartCode(String partCode){
        this.partCode = StringUtils.rightTrim(partCode);
    }

    /**
     * ��ȡ������ʧ��������
     * @return ������ʧ���������ֵ
     */
    public String getPartCode(){
        return partCode;
    }

    /**
     * ����������ʧ��������
     * @param partName �����õ�������ʧ�������Ƶ�ֵ
     */
    public void setPartName(String partName){
        this.partName = StringUtils.rightTrim(partName);
    }

    /**
     * ��ȡ������ʧ��������
     * @return ������ʧ�������Ƶ�ֵ
     */
    public String getPartName(){
        return partName;
    }

    /**
    * ���������ձ����
    * @param partCode �����õ������ձ�����ֵ
    */
   public void setKindCode(String kindCode){
       this.kindCode = StringUtils.rightTrim(kindCode);
   }

   /**
    * ��ȡ�����ձ����
    * @return �����ձ�����ֵ
    */
   public String getKindCode(){
       return kindCode;
   }

}
