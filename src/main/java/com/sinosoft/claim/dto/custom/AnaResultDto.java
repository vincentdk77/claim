package com.sinosoft.claim.dto.custom;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 这是结果数据传输对象类<br>
 * <p>Title: AnaResultDto</p>
 * 创建于 2005-03-11 11:20:45.203<br>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author zhangshengli
 * @version 1.0
 */

public class AnaResultDto
{
  /**记录数*/
  private int rowsCount = 0;
  /**结果记录集*/
  private Collection collection = new ArrayList();

  /**
   * 默认构造方法,构造一个默认的AnaResultDto对象
   */
  public AnaResultDto()
  {
  }

  public void setRowsCount(int rowsCount)
  {
    this.rowsCount = rowsCount;
  }

  public int getRowsCount()
  {
    return rowsCount;
  }

  public void setCollection(Collection collection)
  {
    this.collection = collection;
  }

  public Collection getCollection()
  {
    return collection;
  }
}

