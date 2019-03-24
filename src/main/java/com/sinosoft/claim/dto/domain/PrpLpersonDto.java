package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prplperson人员伤亡明细信息表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpersonDto extends PrpLpersonDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLpersonDto对象
     */
    public PrpLpersonDto(){
    }

    /** 集合 **/
    Collection personList;
    /** 属性区域名称 */
    private String areaName = "";
    /** 属性currencyName */
    private String currencyName = "";
    /** 属性险别名称 */
    private String kindName = "";
    /** 属性险别名称 */
    private String itemName = "";
    /** 属性人员类型名称 */
    private String payPersonTypeName = "";
    /** 属性收入情况名称 */
    private String fixedIncomeFlagName = "";
    
   

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

    /**得到人员伤亡明细信息集合
    * @return 人员伤亡明细信息集合信息
    */
    public Collection getPersonList() {
      return  personList;
    }
    /**设置人员伤亡明细信息集合
    * @param personList 人员伤亡明细信息集合
    */
    public void setPersonList(Collection personList) {
      this.personList = personList;
    }

    /**
     * 设置属驶区域名称
     * @param runAreaName 待设置的属驶区域名称的值
     */
    public void setAreaName(String areaName){
        this.areaName = StringUtils.rightTrim(areaName);
    }

    /**
     * 获取属性区域名称
     * @return 属性区域名称的值
     */
    public String getAreaName(){
        return areaName;
    }

    /**
     * 设置属性币别名称
     * @param currencyName 待设置的属性币别名称的值
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
     * 获取属性币别名称
     * @return 属性币别名称的值
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

