package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是prpdlimit限额免赔代码表的数据传输对象类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDlimitDto extends PrpDlimitDtoBase implements Serializable{

  /**
     *  默认构造方法,构造一个默认的PrpDlimitDto对象
     */
    public PrpDlimitDto(){
    }
    /** 列表 */
    Collection prpDlimitList = null;

    public void setPrpDlimitList(Collection prpDlimitList) {
      this.prpDlimitList = prpDlimitList;
    }

    public Collection getPrpDlimitList() {
      return prpDlimitList;
    }

}
