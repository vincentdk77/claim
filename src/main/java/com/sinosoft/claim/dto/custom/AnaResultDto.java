package com.sinosoft.claim.dto.custom;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ���ǽ�����ݴ��������<br>
 * <p>Title: AnaResultDto</p>
 * ������ 2005-03-11 11:20:45.203<br>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author zhangshengli
 * @version 1.0
 */

public class AnaResultDto
{
  /**��¼��*/
  private int rowsCount = 0;
  /**�����¼��*/
  private Collection collection = new ArrayList();

  /**
   * Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�AnaResultDto����
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

