package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����prpcitemkind���������Ϣ�����ݴ��������<br>
 * ������ 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCitemKindDto extends PrpCitemKindDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCitemKindDto����
     */
    public PrpCitemKindDto(){
    }

    /** �����⸶���� */
    private double claimRate = 0d;
    /** �������α��� */
    private double indemnityDutyRate = 0d;
    /** �����¹����������� */
    private double dutyDeductibleRate = 0d;
    
    /** ���Լ�ʻԱ������ */
    private double driverDeductibleRate = 0d;
    
    /** ��ʷ�⸶�� */
    private double hisPaid = 0d;
    
    /** ���Խ�ǿ�������*/
    private double CISumRealPay = 0d;
    
    /** �ƶ��豸IMEI�� add by wangxinyang 20180614 */
    private String remark = "";
    
    public double getCISumRealPay() {
		return CISumRealPay;
	}

	public void setCISumRealPay(double sumRealPay) {
		CISumRealPay = sumRealPay;
	}

    
    //modify by lixiang add 20050315 start
//reason:���뱣�ձ����Ϣ�����ݣ������Ͽ���ֱ����ʾ�б��ձ�
 /** ���ձ����Ϣ*/
  private Collection prpCitemKindDtoList;
     /**�õ�itemkind��Ϣ
   * @return  itemkind��Ϣ
   */
  public Collection getPrpCitemKindDtoList()
  {
    return prpCitemKindDtoList;
  }

  public double getClaimRate() {
    return claimRate;
  }

  public double getIndemnityDutyRate() {
    return indemnityDutyRate;
  }

  /**����itemkind��Ϣ
   * @param prpCitemKindDtoList itemkind����Ϣ
   */
  public void setPrpCitemKindDtoList(Collection prpCitemKindDtoList)
  {
    this.prpCitemKindDtoList = prpCitemKindDtoList;
  }

  public void setClaimRate(double claimRate) {
    this.claimRate = claimRate;
  }

  public void setIndemnityDutyRate(double indemnityDutyRate) {
    this.indemnityDutyRate = indemnityDutyRate;
  }

//modify by lixiang add 20050315 end
  public double getDutyDeductibleRate() {
   return dutyDeductibleRate;
  }
  public void setDutyDeductibleRate(double dutyDeductibleRate) {
     this.dutyDeductibleRate = dutyDeductibleRate;
  }
  
  public double getDriverDeductibleRate() {
   return driverDeductibleRate;
  }
  public void setDriverDeductibleRate(double driverDeductibleRate) {
     this.driverDeductibleRate = driverDeductibleRate;
  }
  
  public double getHisPaid() {
    return hisPaid;
   }
   public void setHisPaid(double hisPaid) {
      this.hisPaid = hisPaid;
   }

   	//�ƶ��豸IMEI�� add by wangxinyang 20180614
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
  
}
