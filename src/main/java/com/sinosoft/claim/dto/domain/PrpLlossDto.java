package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prplloss�⸶�����Ϣ������ݴ��������<br>
 * ������ 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLlossDto extends PrpLlossDtoBase implements Serializable{

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLlossDto����
     */
    public PrpLlossDto(){
    }
    /** ������ʾ�б�*/
    private Collection prpLlossList ;

    /** �����ձ����� */
    private String kindName = "";
	  /** ���Ի������� */
    private String currencyName = "";
	  /** ���Ի������� */
    private String currency1Name = "";
	  /** ���Ի������� */
    private String currency2Name = "";
	  /** ���Ի������� */
    private String currency3Name = "";
	  /** ���Ի������� */
    private String currency4Name = "";
    /** �ƶ��豸���к� add by wangxinyang 2018/6/15 */
    private String imei = "";

    public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

    /** �������յľ��������� */
    private double mainKindDeductibleRate = 0d;

    /** ���Խ�ǿ�������*/
    private double CISumRealPay = 0d;
    
    /** ������ϱ��ջ����*/
    private String familyNoZH = "";
    /**���� */
    private double sumAllRealpay =0d;
    
    public double getCISumRealPay() {
		return CISumRealPay;
	}

	public void setCISumRealPay(double sumRealPay) {
		CISumRealPay = sumRealPay;
	}

	/**
     * ���������ұ�����
     * @param currency2Name �����õ������ұ����Ƶ�ֵ
     */
    public void setCurrency2Name(String currency2Name){
        this.currency2Name = StringUtils.rightTrim(currency2Name);
    }

    /**
     * ��ȡ���Ի�������
     * @return ���Ի������Ƶ�ֵ
     */
    public String getCurrency2Name(){
        return currency2Name;
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

   /**����������ʾ�б�
    * @param prpLctextList ������ʾ�б�
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

  /**�õ�������ʾ�б�
   * @return ������ʾ�б�
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
