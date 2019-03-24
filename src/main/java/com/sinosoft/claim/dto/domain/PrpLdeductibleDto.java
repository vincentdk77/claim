package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
/**
 * ����PrpLdeductibleDto�����ݴ��������<br>
 * ������ 2006-01-06 <br>
 * �ֹ����� by ������ ���ڴ�����ġ��ձ��⸶���͡��������ĸ����⼶��������
 */
public class PrpLdeductibleDto implements Serializable{
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLdeductibleDto����
     */
    public PrpLdeductibleDto(){
    }
    /** ���Լ�������� */
    private String compensateNo    = "";
    /** ������� */
    private String serialNo        = "";
    /** ������������ */
    private String claimNo         = "";
    /** �����ձ� */
    private String kindCode        = "";
    /** �����ձ��⳥��� */
    private double sumKindPaid     = 0;
    /** ���� �������� */
    private String deductibleLevel = "";
    /** ��������ұ� */
    private String currency        = "";
    /** ��������� */
    private String deductible      = "";
    /** ���������� */
    private String deductibleRate  = "";
    /** ���Ա�־λ */
    private String flag            = "";
    /**�����ձ�����*/
    private String kindName = "";
    /**
     * ��ȡ���������
     * @return ���Լ��������
     */
    public String getCompensateNo(){
      return compensateNo;
    }
    /**
     * ���ü��������
     * @param compensateNo ���������
     */
    public void setCompensateNo(String compensateNo ) {
      this.compensateNo  = compensateNo;
    }
    /**
     * ��ȡ���
     * @return �������
     */
    public String getSerialNo(){
      return serialNo;
    }
    /**
     * �������
     * @param serialNo ���
     */
    public void setSerialNo(String serialNo ) {
      this.serialNo  = serialNo;
    }
    /**
     * ��ȡ��������
     * @return ������������
     */
    public String getClaimNo(){
      return claimNo;
    }
    /**
     * ������������
     * @param claimNo ��������
     */
    public void setClaimNo(String claimNo ) {
      this.claimNo  = claimNo;
    }
    /**
     * ��ȡ�ձ�
     * @return �����ձ�
     */
    public String getKindCode(){
      return kindCode;
    }
    /**
     * �����ձ�
     * @param kindCode �ձ�
     */
    public void setKindCode(String kindCode ) {
      this.kindCode  = kindCode;
    }
    /**
     * ��ȡ����ȼ�
     * @return ��������ȼ�
     */
    public String getDeductibleLevel(){
      return deductibleLevel ;
    }
    /**
     * ��������ȼ�
     * @param deductibleLevel ����ȼ�
     */
    public void setDeductibleLevel(String deductibleLevel ) {
      this.deductibleLevel  = deductibleLevel ;
    }
    /**
     * ��������ұ�
     * @return ��������ұ�
     */
    public String getCurrency(){
      return currency ;
    }
    /**
     * ��������ұ�
     * @param currency ��������ұ�
     */
    public void setCurrency(String currency ) {
      this.currency  = currency ;
    }
    /**
     * ���������
     * @return ���������
     */
    public String getDeductible(){
      return deductible ;
    }
    /**
     * ���������
     * @param deductible ���������
     */
    public void setDeductible(String deductible ) {
      this.deductible  = deductible ;
    }
    /**
     * ����������
     * @return ����������
     */
    public String getDeductibleRate(){
      return deductibleRate ;
    }
    /**
     * ����������
     * @param deductibleRate ����������
     */
    public void setDeductibleRate(String deductibleRate ) {
      this.deductibleRate  = deductibleRate ;
    }
    /**
     * ���Ա�־λ
     * @return ���Ա�־λ
     */
    public String getFlag(){
      return flag ;
    }
    /**
     * ���Ա�־λ
     * @param flag ���Ա�־λ
     */
    public void setFlag(String flag ) {
      this.flag  = flag ;
    }
    /**
     * �����ձ�����
     * @return �����ձ�����
     */
    public String getKindName(){
      return kindName ;
    }
    /**
     * ���Ա�־λ
     * @param flag ���Ա�־λ
     */
    public void setKindName(String kindName ) {
      this.kindName  = kindName ;
    }
    /**
     * �����ձ��⳥���
     * @return �����ձ��⳥���
     */
    public double getSumKindPaid(){
      return sumKindPaid ;
    }
    /**
     * �����ձ��⳥���
     * @param flag �����ձ��⳥���
     */
    public void setSumKindPaid(double sumKindPaid ) {
      this.sumKindPaid  = sumKindPaid ;
    }
}
