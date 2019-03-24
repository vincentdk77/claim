package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是prpcitemkind标的子险信息的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCitemKindDto extends PrpCitemKindDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpCitemKindDto对象
     */
    public PrpCitemKindDto(){
    }

    /** 属性赔付比例 */
    private double claimRate = 0d;
    /** 属性责任比例 */
    private double indemnityDutyRate = 0d;
    /** 属性事故责任免赔率 */
    private double dutyDeductibleRate = 0d;
    
    /** 属性驾驶员免赔率 */
    private double driverDeductibleRate = 0d;
    
    /** 历史赔付额 */
    private double hisPaid = 0d;
    
    /** 属性交强险赔款金额*/
    private double CISumRealPay = 0d;
    
    /** 移动设备IMEI码 add by wangxinyang 20180614 */
    private String remark = "";
    
    public double getCISumRealPay() {
		return CISumRealPay;
	}

	public void setCISumRealPay(double sumRealPay) {
		CISumRealPay = sumRealPay;
	}

    
    //modify by lixiang add 20050315 start
//reason:加入保险标的信息的内容，界面上可以直接显示承保险别
 /** 保险标的信息*/
  private Collection prpCitemKindDtoList;
     /**得到itemkind信息
   * @return  itemkind信息
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

  /**设置itemkind信息
   * @param prpCitemKindDtoList itemkind表信息
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

   	//移动设备IMEI码 add by wangxinyang 20180614
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
  
}
