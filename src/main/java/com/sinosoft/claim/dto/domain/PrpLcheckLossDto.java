package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是prplcheckloss查勘事故估损金额表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcheckLossDto extends PrpLcheckLossDtoBase implements Serializable{

  /**
     *  默认构造方法,构造一个默认的PrpLcheckLossDto对象
     */
    public PrpLcheckLossDto(){
    }
    /** 属性显示列表*/
    private Collection prpLcheckLossList ;
    /** 属性险别名称 */
    private String kindName = "";

   /**设置属性显示列表
    * @param prpLctextList 属性显示列表
    */
    public void setPrpLcheckLossList(Collection prpLcheckLossList) {
      this.prpLcheckLossList = prpLcheckLossList;
    }

    /**设置属性险别名称
     * @param kindName 险别名称
     */

    public void setKindName(String kindName) {
      this.kindName = kindName;
    }

  /**得到属性显示列表
   * @return 属性显示列表
   */
    public Collection getPrpLcheckLossList() {
      return prpLcheckLossList;
    }
    /**得到险别名称
     * @return 险别名称
     */
    public String getKindName() {
      return kindName;
    }

}
