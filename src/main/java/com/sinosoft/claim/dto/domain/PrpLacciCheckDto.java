package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * ����PrpLacciCheck�����ݴ��������<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLacciCheckDto extends PrpLacciCheckDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLacciCheckDto.class.getName().hashCode();
    
    /** ���Գ��������� */
    private DateTime damageStartDate = new DateTime();
    /** ���Գ��տ�ʼСʱ */
    private String damageStartHour = "";
    /** ���Գ��տ�ʼ���� */
    private String damageStartMinute = "";
    /** ���Ե��鿪ʼ���� */
    private String damageStartMinute2 = "";
    /** ���Ե���������� */
    private String damageStartMinute3 = "";
    /**�¹ʵص�*/
    private String damageAddress = "";
    
    //add by liuyanmei 20051209 start
    private String registNo = "";
    private String claimNo = "";
    private String compensateNo = "";
    private String claimStatus = "";
    private double checkFee = 0;
    private String currency = "";
    private String currencyName = "";
    //add by liuyanmei 20051209 end
    /**��ע��Ϣ*/
    private String remark;
    
    
//  add by liuyanmei 20051209 start
    public void setCurrency(String currency) {
    	this.currency = currency;
    }
    public String getCurrency() {
    	return this.currency;
    }
    
    public void setCurrencyName(String currencyName) {
    	this.currencyName = currencyName;
    }
    public String getCurrencyName() {
    	return this.currencyName;
    }
    
    public void setCheckFee(double checkFee) {
    	this.checkFee = checkFee;
    }
    public double getCheckFee() {
    	return this.checkFee;
    }
    
    
    public void setRegistNo(String registNo) {
    	this.registNo = registNo;
    }
    
    public String getRegistNo() {
    	return this.registNo;
    }
    
    public void setClaimNo(String claimNo) {
    	this.claimNo = claimNo;
    }
   
    public String getClaimNo() {
    	return this.claimNo;
    }
    public void setCompensateNo(String compensateNo) {
    	this.compensateNo = compensateNo;
    }
    
    public String getCompensateNo() {
    	return this.compensateNo;
    }
    public void setClaimStatus(String claimStatus) {
    	this.claimStatus = claimStatus;
    }
    
    public String getClaimStatus() {
    	return this.claimStatus;
    }
//  add by liuyanmei 20051209 end
    
    /**
     * ���ñ�ע��Ϣ
     * @param remark ��ע��Ϣ
     * */
    public void setRemark(String remark) {
    	this.remark = remark;
    }
    /**
     * ��ñ�ע��Ϣ
     * @return ��ñ�ע��Ϣ
     * */
    public String getRemark() {
    	return this.remark;
    }
    
    /**
     * �����¹ʵص�
     * @param damageAddress�¹ʵص�
     * */
    public void setDamageAddress(String damageAddress) {
    	this.damageAddress = damageAddress;
    }
    /**
     * ����¹ʵص�
     * @return ����¹ʵص�*/
    public String getDamageAddress() {
    	return this.damageAddress;
    }
    
    /**
     * ���ó���������
     * @param damageStartDate ����������
     */
    public void setDamageStartDate(DateTime damageStartDate) {
      this.damageStartDate = damageStartDate;
    }
    /**
     * �õ�����������
     * @return ����������
     */
    public DateTime getDamageStartDate() {
      return damageStartDate;
    }
    
    
    /**
     * ���ó��տ�ʼСʱ
     * @param damageStartHour ���տ�ʼСʱ
     */
    public void setDamageStartHour(String damageStartHour) {
      this.damageStartHour = damageStartHour;
    }
    /**
     * �õ����տ�ʼСʱ
     * @return ���տ�ʼСʱ
     */
    public String getDamageStartHour() {
      return damageStartHour;
    }
    
    public void setDamageStartMinute(String damageStartMinute) {
        this.damageStartMinute = damageStartMinute;
      }
    
    public String getDamageStartMinute() {
        return damageStartMinute;
      }
    
    public void setDamageStartMinute2(String damageStartMinute2) {
        this.damageStartMinute2 = damageStartMinute2;
      }
    
    public String getDamageStartMinute2() {
        return damageStartMinute2;
      }
    
    public void setDamageStartMinute3(String damageStartMinute3) {
        this.damageStartMinute3 = damageStartMinute3;
      }
    
    public String getDamageStartMinute3() {
        return damageStartMinute3;
      }
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLacciCheckDto����
     */
    public PrpLacciCheckDto(){
    }
}
