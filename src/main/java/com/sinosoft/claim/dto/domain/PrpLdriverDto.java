package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;
/**
 * 这是prpldriver车险驾驶员信息表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLdriverDto extends PrpLdriverDtoBase implements Serializable{
   /** 属性显示列表*/
    private Collection driverList ;

   /**
     *  默认构造方法,构造一个默认的PrpLdriverDto对象
     */
    public PrpLdriverDto(){
    }

    /**
     * 获取列表
     * @return 属性列表
     */
    public Collection getDriverList(){
      return driverList;
    }
    /**
     * 设置列表
     * @param driverList 待设置的列表
     */
    public void setDriverList(Collection driverList) {
      this.driverList = driverList;
    }

}
