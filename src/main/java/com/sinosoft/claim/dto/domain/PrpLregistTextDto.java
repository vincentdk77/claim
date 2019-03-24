package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是prplregisttext赔案文字表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLregistTextDto extends PrpLregistTextDtoBase implements Serializable{
    /** 属性显示列表*/
    private Collection registTextList ;
    /**
     *  默认构造方法,构造一个默认的PrpLregistTextDto对象
     */
    public PrpLregistTextDto(){
    }

    /**
     * 获取列表
     * @return 属性列表
     */
    public Collection getRegistTextList(){
      return registTextList;
    }
    /**
     * 设置列表
     * @param registTextList 待设置的列表
     */
    public void setRegistTextList(Collection registTextList) {
      this.registTextList = registTextList;
    }

}
