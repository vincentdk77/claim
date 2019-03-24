package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prplprop财产核定损明细清单表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpropDto extends PrpLpropDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLpropDto对象
     */
    public PrpLpropDto(){
    }

    /** 集合 **/
    Collection propList;
    /** 属性险别名称 */
    private String kindName = "";
    /** 币别名称 */
    private String currencyName = "";
    /** 移动设备序列号 add by wangxinyang 2018/6/15 */
    private String imei = "";

    public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
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

    /**得到财产核定损明细清单集合
    * @return 财产核定损明细清单集合信息
    */
    public Collection getPropList() {
      return  propList;
    }

  public String getCurrencyName() {
    return currencyName;
  }

  /**设置财产核定损明细清单集合
    * @param propList 财产核定损明细清单集合
    */
    public void setPropList(Collection propList) {
      this.propList = propList;
    }

  public void setCurrencyName(String currencyName) {
    this.currencyName = currencyName;
  }

}
