package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prplloss赔付标的信息表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLlossDto extends PrpLlossDtoBase implements Serializable{

    /**
     *  默认构造方法,构造一个默认的PrpLlossDto对象
     */
    public PrpLlossDto(){
    }
    /** 属性显示列表*/
    private Collection prpLlossList ;

    /** 属性险别名称 */
    private String kindName = "";
	  /** 属性货币名称 */
    private String currencyName = "";
	  /** 属性货币名称 */
    private String currency1Name = "";
	  /** 属性货币名称 */
    private String currency2Name = "";
	  /** 属性货币名称 */
    private String currency3Name = "";
	  /** 属性货币名称 */
    private String currency4Name = "";
    /** 移动设备序列号 add by wangxinyang 2018/6/15 */
    private String imei = "";

    public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

    /** 属性主险的绝对免赔率 */
    private double mainKindDeductibleRate = 0d;

    /** 属性交强险赔款金额*/
    private double CISumRealPay = 0d;
    
    /** 属性组合保险户编号*/
    private String familyNoZH = "";
    /**属性 */
    private double sumAllRealpay =0d;
    
    public double getCISumRealPay() {
		return CISumRealPay;
	}

	public void setCISumRealPay(double sumRealPay) {
		CISumRealPay = sumRealPay;
	}

	/**
     * 设置属货币别名称
     * @param currency2Name 待设置的属货币别名称的值
     */
    public void setCurrency2Name(String currency2Name){
        this.currency2Name = StringUtils.rightTrim(currency2Name);
    }

    /**
     * 获取属性货币名称
     * @return 属性货币名称的值
     */
    public String getCurrency2Name(){
        return currency2Name;
    }

    /**
     * 设置属性险别名称
     * @param kindName 待设置的属性险别名称的值
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * 获取属性险别名称
     * @return 属性险别名称的值
     */
    public String getKindName(){
        return kindName;
    }

   /**设置属性显示列表
    * @param prpLctextList 属性显示列表
    */
   public void setPrpLlossList(Collection prpLlossList) {
     this.prpLlossList = prpLlossList;
   }

  public void setCurrency4Name(String currency4Name) {
    this.currency4Name = currency4Name;
  }

  public void setCurrencyName(String currencyName) {
    this.currencyName = currencyName;
  }

  public void setCurrency3Name(String currency3Name) {
    this.currency3Name = currency3Name;
  }

  public void setCurrency1Name(String currency1Name) {
    this.currency1Name = currency1Name;
  }

  /**得到属性显示列表
   * @return 属性显示列表
   */
   public Collection getPrpLlossList() {
     return prpLlossList;
   }

  public String getCurrency4Name() {
    return currency4Name;
  }

  public String getCurrencyName() {
    return currencyName;
  }

  public String getCurrency3Name() {
    return currency3Name;
  }

  public String getCurrency1Name() {
    return currency1Name;
  }


  public void setMainKindDeductibleRate(double mainKindDeductibleRate) {
     this.mainKindDeductibleRate = mainKindDeductibleRate;
  }

  public double getMainKindDeductibleRate() {
      return mainKindDeductibleRate;
  }
  
  public void setFamilyNoZH(String familyNoZH){
	  this.familyNoZH = familyNoZH;
  }
  
  public String getFamilyNoZH(){
	  return familyNoZH;
	  
  }

	public double getSumAllRealpay() {
		return sumAllRealpay;
	}
	
	public void setSumAllRealpay(double sumAllRealpay) {
		this.sumAllRealpay = sumAllRealpay;
	}

}
