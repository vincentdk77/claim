package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是prpclimit限额/免赔表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpClimitDto extends PrpClimitDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpClimitDto对象
     */
    public PrpClimitDto(){
  }

    /** 列表 */
    Collection prpClimitList = null;
    /** 币别名称 */
    String currencyName = null;
    /** 限制名称 */
    String limitTypeName = null;

    public void setPrpClimitList(Collection prpClimitList) {
      this.prpClimitList = prpClimitList;
    }

  public void setCurrencyName(String currencyName) {
    this.currencyName = currencyName;
  }

  public void setLimitTypeName(String limitTypeName) {
    this.limitTypeName = limitTypeName;
  }

  public Collection getPrpClimitList() {
      return prpClimitList;
    }

  public String getCurrencyName() {
    return currencyName;
  }

  public String getLimitTypeName() {
    return limitTypeName;
  }
}
