package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是PrpLthirdCarLoss损失部位的数据传输对象类<br>
 * 创建于 2004-12-06 12:08:34.673<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLthirdCarLossDto extends PrpLthirdCarLossDtoBase implements Serializable{
  public void setThirdCarLossList(Collection thirdCarLossList) {
    this.thirdCarLossList = thirdCarLossList;
  }

  public Collection getThirdCarLossList() {
    return thirdCarLossList;
  }

  /**
     *  默认构造方法,构造一个默认的PrpLthirdCarLossDto对象
     */
    public PrpLthirdCarLossDto(){
  }
   /** 属性显示列表*/
    private Collection thirdCarLossList ;
}
