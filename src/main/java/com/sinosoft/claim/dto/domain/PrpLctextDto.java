package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是prplctext赔款计算文字表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLctextDto extends PrpLctextDtoBase implements Serializable{


  /**
     *  默认构造方法,构造一个默认的PrpLctextDto对象
     */
    public PrpLctextDto(){
    }
    /** 属性显示列表*/
    private Collection prpLctextList ;

    /**设置属性显示列表
     * @param prpLctextList 属性显示列表
     */
    public void setPrpLctextList(Collection prpLctextList) {
      this.prpLctextList = prpLctextList;
    }
    
    /**得到属性显示列表
    * @return 属性显示列表
    */
    public Collection getPrpLctextList() {
      return prpLctextList;
    }

}
