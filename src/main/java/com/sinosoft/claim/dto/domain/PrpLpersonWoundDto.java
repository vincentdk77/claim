package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是PrpLpersonWound 伤情信息表的数据传输对象类<br>
 * 创建于 2005-02-18 10:21:16.171<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpersonWoundDto extends PrpLpersonWoundDtoBase implements Serializable{

  /**
     *  默认构造方法,构造一个默认的PrpLpersonWoundDto对象
     */
    public PrpLpersonWoundDto() {
    }

    Collection woundList;
    public void setWoundList(Collection woundList) {
      this.woundList = woundList;
    }

    public Collection getWoundList() {
      return woundList;
    }

}
