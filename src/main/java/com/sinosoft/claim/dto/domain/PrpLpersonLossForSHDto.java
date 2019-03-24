package com.sinosoft.claim.dto.domain;
import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prplpersonloss人员赔付信息表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpersonLossForSHDto extends PrpLpersonLossForSHDtoBase implements Serializable{


  /**
     *  默认构造方法,构造一个默认的PrpLpersonLossDto对象
     */
    public PrpLpersonLossForSHDto(){
    }
    /** 属性显示列表*/
    private Collection<PrpLpersonLossForSHDto> prpLpersonLossList ;
    /** 属性显示列表*/
    private Collection<PrpLpersonLossForSHDto> personLossList ;

    /** 属性险别名称 */
    private String kindName = "";
    /** 属性货币名称 */
    private String currency3Name = "";
    /** 属性货币名称 */
    private String currencyName = "";
    /** 属性货币名称 */
    private String currency2Name = "";
    /** 属性实赔金额 */
    private double sumRealPay1 = 0d;

    /** 是否超过保单中的限额标志域 */
    private String overAmount = "";
    /** 属性实赔金额 */
    private double mainKindDeductibleRate = 0d;

    /** 属性交强险赔款金额*/
    private double CISumRealPay = 0d;
    
    public double getCISumRealPay() {
		return CISumRealPay;
	}

	public void setCISumRealPay(double sumRealPay) {
		CISumRealPay = sumRealPay;
	}

    /** 属性货币名称 */
    private String injuryGradeName = "";
    
    /**险别最大赔付信息*/
    private double dblMaxPaid;

    /**
     * 设置属货币别名称
     * @param currency3Name 待设置的属货币别名称的值
     */
    public void setCurrency3Name(String currency3Name){
        this.currency3Name = StringUtils.rightTrim(currency3Name);
    }

    /**
     * 获取属性货币名称
     * @return 属性货币名称的值
     */
    public String getCurrency3Name(){
        return currency3Name;
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

    public void setOverAmount(String overAmount) {
      this.overAmount = overAmount;
    }

  public void setCurrency2Name(String currency2Name) {
    this.currency2Name = currency2Name;
  }

  public void setCurrencyName(String currencyName) {
    this.currencyName = currencyName;
  }

  public void setSumRealPay1(double sumRealPay1) {
    this.sumRealPay1 = sumRealPay1;
  }

    public String getOverAmount() {
      return overAmount;
    }

  public String getCurrency2Name() {
    return currency2Name;
  }

  public String getCurrencyName() {
    return currencyName;
  }

  public double getSumRealPay1() {
    return sumRealPay1;
  }


  public void setMainKindDeductibleRate(double mainKindDeductibleRate) {
   this.mainKindDeductibleRate = mainKindDeductibleRate;
  }

  public double getMainKindDeductibleRate() {
  return mainKindDeductibleRate;
  }

  /**
     * 设置属性险别名称
     * @param kindName 待设置的属性险别名称的值
     */
    public void setInjuryGradeName(String injuryGradeName){
        this.injuryGradeName = StringUtils.rightTrim(injuryGradeName);
    }

    /**
     * 获取属性险别名称
     * @return 属性险别名称的值
     */
    public String getInjuryGradeName(){
        return injuryGradeName;
    }

  /**
   * 设置险别最大赔付信息
   * @param dblMaxPaid 赔付值
   * */
    public void setdblMaxPaid(double dblMaxPaid) {
    	this.dblMaxPaid = dblMaxPaid;
    }
    
    /**
     * 获得险别最大赔付信息
     * @return 最大赔付信息
     * */
    public double getdblMaxPaid() {
    	return this.dblMaxPaid;
    }

	public Collection<PrpLpersonLossForSHDto> getPrpLpersonLossList() {
		return prpLpersonLossList;
	}

	public void setPrpLpersonLossList(
			Collection<PrpLpersonLossForSHDto> prpLpersonLossList) {
		this.prpLpersonLossList = prpLpersonLossList;
	}

	public Collection<PrpLpersonLossForSHDto> getPersonLossList() {
		return personLossList;
	}

	public void setPersonLossList(Collection<PrpLpersonLossForSHDto> personLossList) {
		this.personLossList = personLossList;
	}
}
