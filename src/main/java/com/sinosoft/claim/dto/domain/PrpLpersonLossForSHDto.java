package com.sinosoft.claim.dto.domain;
import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prplpersonloss��Ա�⸶��Ϣ������ݴ��������<br>
 * ������ 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpersonLossForSHDto extends PrpLpersonLossForSHDtoBase implements Serializable{


  /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpersonLossDto����
     */
    public PrpLpersonLossForSHDto(){
    }
    /** ������ʾ�б�*/
    private Collection<PrpLpersonLossForSHDto> prpLpersonLossList ;
    /** ������ʾ�б�*/
    private Collection<PrpLpersonLossForSHDto> personLossList ;

    /** �����ձ����� */
    private String kindName = "";
    /** ���Ի������� */
    private String currency3Name = "";
    /** ���Ի������� */
    private String currencyName = "";
    /** ���Ի������� */
    private String currency2Name = "";
    /** ����ʵ���� */
    private double sumRealPay1 = 0d;

    /** �Ƿ񳬹������е��޶��־�� */
    private String overAmount = "";
    /** ����ʵ���� */
    private double mainKindDeductibleRate = 0d;

    /** ���Խ�ǿ�������*/
    private double CISumRealPay = 0d;
    
    public double getCISumRealPay() {
		return CISumRealPay;
	}

	public void setCISumRealPay(double sumRealPay) {
		CISumRealPay = sumRealPay;
	}

    /** ���Ի������� */
    private String injuryGradeName = "";
    
    /**�ձ�����⸶��Ϣ*/
    private double dblMaxPaid;

    /**
     * ���������ұ�����
     * @param currency3Name �����õ������ұ����Ƶ�ֵ
     */
    public void setCurrency3Name(String currency3Name){
        this.currency3Name = StringUtils.rightTrim(currency3Name);
    }

    /**
     * ��ȡ���Ի�������
     * @return ���Ի������Ƶ�ֵ
     */
    public String getCurrency3Name(){
        return currency3Name;
    }

    /**
     * ���������ձ�����
     * @param kindName �����õ������ձ����Ƶ�ֵ
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����Ƶ�ֵ
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
     * ���������ձ�����
     * @param kindName �����õ������ձ����Ƶ�ֵ
     */
    public void setInjuryGradeName(String injuryGradeName){
        this.injuryGradeName = StringUtils.rightTrim(injuryGradeName);
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����Ƶ�ֵ
     */
    public String getInjuryGradeName(){
        return injuryGradeName;
    }

  /**
   * �����ձ�����⸶��Ϣ
   * @param dblMaxPaid �⸶ֵ
   * */
    public void setdblMaxPaid(double dblMaxPaid) {
    	this.dblMaxPaid = dblMaxPaid;
    }
    
    /**
     * ����ձ�����⸶��Ϣ
     * @return ����⸶��Ϣ
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
