package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLclaimLoss的数据传输对象类<br>
 * 创建于 2004-06-24 14:46:00.088<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLclaimLossDto extends PrpLclaimLossDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLclaimLossDto对象
     */
    private Collection claimLossList ;

    /** 属性currencyName */
    private String currencyName = "";
    /** 属性kindName */
    private String kindName = "";
    /** 属性责任名称 add by qinyongli 2005-9-2 */
    private String itemKindName = "";
    /**item对应保额*/
    private double itemAmount = 0.0;
    /** 移动设备序列号 add by wangxinyang 2018/6/15 */
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
     * 获取列表
     * @return 属性列表
     */
    public Collection getClaimLossList(){
      return claimLossList ;
    }
    /**
     * 设置列表
     * @param driverList 待设置的列表
     */
    public void setClaimLossList(Collection claimLossList ) {
      this.claimLossList  = claimLossList ;
    }

    /**
     * 设置属性币别名称
     * @param currencyName 待设置的属性币别名称的值
     */
    public void setCurrencyName(String currencyName){
        this.currencyName = StringUtils.rightTrim(currencyName);
    }

    /**
     * 获取属性币别名称
     * @return 属性币别名称的值
     */
    public String getCurrencyName(){
        return currencyName;
    }
    
    /**
     * 设置属险别别名称
     * @param currencyName 待设置的属险别别名称的值
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * 获取属险别别名称
     * @return 属险别别名称的值
     */
    public String getKindName(){
        return kindName;
    }
    /**
     * 设置属性责任名称
     * @param currencyName 待设置的属性责任名称
     */
    public void setItemKindName(String itemKindName){
        this.itemKindName = StringUtils.rightTrim(itemKindName);
    }

    /**
     * 获取属性责任名称
     * @return 属性责任名称
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
