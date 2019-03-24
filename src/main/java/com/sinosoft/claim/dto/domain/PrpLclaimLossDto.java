package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLclaimLoss�����ݴ��������<br>
 * ������ 2004-06-24 14:46:00.088<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLclaimLossDto extends PrpLclaimLossDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLclaimLossDto����
     */
    private Collection claimLossList ;

    /** ����currencyName */
    private String currencyName = "";
    /** ����kindName */
    private String kindName = "";
    /** ������������ add by qinyongli 2005-9-2 */
    private String itemKindName = "";
    /**item��Ӧ����*/
    private double itemAmount = 0.0;
    /** �ƶ��豸���к� add by wangxinyang 2018/6/15 */
    private String imei = "";

    public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}
    
    public PrpLclaimLossDto(){
    }

    /**
     * ��ȡ�б�
     * @return �����б�
     */
    public Collection getClaimLossList(){
      return claimLossList ;
    }
    /**
     * �����б�
     * @param driverList �����õ��б�
     */
    public void setClaimLossList(Collection claimLossList ) {
      this.claimLossList  = claimLossList ;
    }

    /**
     * �������Աұ�����
     * @param currencyName �����õ����Աұ����Ƶ�ֵ
     */
    public void setCurrencyName(String currencyName){
        this.currencyName = StringUtils.rightTrim(currencyName);
    }

    /**
     * ��ȡ���Աұ�����
     * @return ���Աұ����Ƶ�ֵ
     */
    public String getCurrencyName(){
        return currencyName;
    }
    
    /**
     * �������ձ������
     * @param currencyName �����õ����ձ�����Ƶ�ֵ
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * ��ȡ���ձ������
     * @return ���ձ�����Ƶ�ֵ
     */
    public String getKindName(){
        return kindName;
    }
    /**
     * ����������������
     * @param currencyName �����õ�������������
     */
    public void setItemKindName(String itemKindName){
        this.itemKindName = StringUtils.rightTrim(itemKindName);
    }

    /**
     * ��ȡ������������
     * @return ������������
     */
    public String getItemKindName(){
        return itemKindName;
    }

	public double getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(double itemAmount) {
		this.itemAmount = itemAmount;
	}

}
