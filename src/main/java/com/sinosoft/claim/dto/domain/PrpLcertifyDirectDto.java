package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是PrpLcertifyDirect-索赔指引(新增)的数据传输对象类<br>
 * 创建于 2005-03-22 17:21:36.031<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcertifyDirectDto extends PrpLcertifyDirectDtoBase implements Serializable{

  /**
     *  默认构造方法,构造一个默认的PrpLcertifyDirectDto对象
     */
    public PrpLcertifyDirectDto(){
    }
    /** 集合 **/
    Collection certifyDirectList;

    public void setCertifyDirectList(Collection certifyDirectList) {
      this.certifyDirectList = certifyDirectList;
    }

    public Collection getCertifyDirectList() {
      return certifyDirectList;
    }

}
