package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����prpclimit�޶�/���������ݴ��������<br>
 * ������ 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpClimitDto extends PrpClimitDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpClimitDto����
     */
    public PrpClimitDto(){
  }

    /** �б� */
    Collection prpClimitList = null;
    /** �ұ����� */
    String currencyName = null;
    /** �������� */
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
