package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是prplcharge赔款费用信息表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLchargeDto extends PrpLchargeDtoBase implements Serializable{

  /**
     *  默认构造方法,构造一个默认的PrpLchargeDto对象
     */
    public PrpLchargeDto(){
    }
    /** 属性显示列表*/
    private Collection prpLchargeList ;
    /** 属性险别名称*/
    private String kindName;
    /** 货币名称*/
    private String currencyName;


    /**设置属性显示列表
     * @param prpLctextList 属性显示列表
     */
    public void setPrpLchargeList(Collection prpLchargeList) {
      this.prpLchargeList = prpLchargeList;
    }

    /**设置属性险别名称
     * @param kindName 属性险别名称
     */
    public void setKindName(String kindName) {
      this.kindName = kindName;
    }

  public void setCurrencyName(String currencyName) {
    this.currencyName = currencyName;
  }

  /**得到属性显示列表
     * @return 属性显示列表
     */
    public Collection getPrpLchargeList() {
      return prpLchargeList;
    }

    /**得到属性险别名称
     * @return 属性险别名称
     */
    public String getKindName() {
      return kindName;
    }

  public String getCurrencyName() {
    return currencyName;
  }

}
