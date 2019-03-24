package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是prplcheckext查勘/代查勘扩展表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcheckExtDto extends PrpLcheckExtDtoBase implements Serializable{

  /**
     *  默认构造方法,构造一个默认的PrpLcheckExtDto对象
     */
    public PrpLcheckExtDto(){
    }
    /** 属性显示列表*/
    private Collection prpLcheckExtList ;

   /**设置属性显示列表
    * @param prpLctextList 属性显示列表
    */        
    public void setPrpLcheckExtList(Collection prpLcheckExtList) {
      this.prpLcheckExtList = prpLcheckExtList;
    }
      
   /**得到属性显示列表
   * @return 属性显示列表
   */
    public Collection getPrpLcheckExtList() {
      return prpLcheckExtList;
    }
}
