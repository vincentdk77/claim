package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����prplcharge��������Ϣ������ݴ��������<br>
 * ������ 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLchargeDto extends PrpLchargeDtoBase implements Serializable{

  /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLchargeDto����
     */
    public PrpLchargeDto(){
    }
    /** ������ʾ�б�*/
    private Collection prpLchargeList ;
    /** �����ձ�����*/
    private String kindName;
    /** ��������*/
    private String currencyName;


    /**����������ʾ�б�
     * @param prpLctextList ������ʾ�б�
     */
    public void setPrpLchargeList(Collection prpLchargeList) {
      this.prpLchargeList = prpLchargeList;
    }

    /**���������ձ�����
     * @param kindName �����ձ�����
     */
    public void setKindName(String kindName) {
      this.kindName = kindName;
    }

  public void setCurrencyName(String currencyName) {
    this.currencyName = currencyName;
  }

  /**�õ�������ʾ�б�
     * @return ������ʾ�б�
     */
    public Collection getPrpLchargeList() {
      return prpLchargeList;
    }

    /**�õ������ձ�����
     * @return �����ձ�����
     */
    public String getKindName() {
      return kindName;
    }

  public String getCurrencyName() {
    return currencyName;
  }

}
