package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是prplltext立案文字表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLltextDto extends PrpLltextDtoBase implements Serializable{
    private Collection ltextList ;
    /**
     *  默认构造方法,构造一个默认的PrpLltextDto对象
     */
    public PrpLltextDto(){
    }

    public Collection getLtextList(){
      return ltextList;
    }
    /**
     * 设置列表
     * @param driverList 待设置的列表
     */
    public void setLtextList(Collection ltextList) {
      this.ltextList = ltextList;
    	}
	
}
