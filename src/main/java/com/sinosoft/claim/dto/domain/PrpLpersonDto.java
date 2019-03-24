package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prplperson��Ա������ϸ��Ϣ������ݴ��������<br>
 * ������ 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpersonDto extends PrpLpersonDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpersonDto����
     */
    public PrpLpersonDto(){
    }

    /** ���� **/
    Collection personList;
    /** ������������ */
    private String areaName = "";
    /** ����currencyName */
    private String currencyName = "";
    /** �����ձ����� */
    private String kindName = "";
    /** �����ձ����� */
    private String itemName = "";
    /** ������Ա�������� */
    private String payPersonTypeName = "";
    /** ��������������� */
    private String fixedIncomeFlagName = "";
    
   

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

    /**�õ���Ա������ϸ��Ϣ����
    * @return ��Ա������ϸ��Ϣ������Ϣ
    */
    public Collection getPersonList() {
      return  personList;
    }
    /**������Ա������ϸ��Ϣ����
    * @param personList ��Ա������ϸ��Ϣ����
    */
    public void setPersonList(Collection personList) {
      this.personList = personList;
    }

    /**
     * ������ʻ��������
     * @param runAreaName �����õ���ʻ�������Ƶ�ֵ
     */
    public void setAreaName(String areaName){
        this.areaName = StringUtils.rightTrim(areaName);
    }

    /**
     * ��ȡ������������
     * @return �����������Ƶ�ֵ
     */
    public String getAreaName(){
        return areaName;
    }

    /**
     * �������Աұ�����
     * @param currencyName �����õ����Աұ����Ƶ�ֵ
     */
    public void setCurrencyName(String currencyName){
        this.currencyName = StringUtils.rightTrim(currencyName);
    }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public void setFixedIncomeFlagName(String fixedIncomeFlagName) {
    this.fixedIncomeFlagName = fixedIncomeFlagName;
  }

  public void setPayPersonTypeName(String payPersonTypeName) {
    this.payPersonTypeName = payPersonTypeName;
  }

  /**
     * ��ȡ���Աұ�����
     * @return ���Աұ����Ƶ�ֵ
     */
    public String getCurrencyName(){
        return currencyName;
    }

  public String getItemName() {
    return itemName;
  }

  public String getFixedIncomeFlagName() {
    return fixedIncomeFlagName;
  }

  public String getPayPersonTypeName() {
    return payPersonTypeName;
  }

}

