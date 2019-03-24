package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 翻页对象
 * <p>Title: 车险理赔翻页DTO</p>
 * <p>Description: 车险理赔翻页样本程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class TurnPageDto implements Serializable
{
    /** 跳转的页码 */
    private int pageNo = 0;
    /** 总页数 */
    private int totalPage = 0;
    /** 总记录数 */
    private int totalCount = 0;
    /** 总每页显示记录数 */
    private int recordPerPage = 0;
    /** 返回一页的数据 */
    private List resultList = new ArrayList();
    /** 条件 */
    private String condition = null;
    /** 条件 */
    private String condition2 = null;
    /** 条件 */
    private String condition3 = null;

    public int getPageNo() {
      return pageNo;
    }

    public int getRecordPerPage() {
      return recordPerPage;
    }

    public int getTotalCount() {
      return totalCount;
    }

    public void setTotalPage(int totalPage) {
      this.totalPage = totalPage;
    }

    public void setPageNo(int pageNo) {
      this.pageNo = pageNo;
    }

    public void setRecordPerPage(int recordPerPage) {
      this.recordPerPage = recordPerPage;
    }

    public void setTotalCount(int totalCount) {
      this.totalCount = totalCount;
    }

    public void setResultList(List resultList) {
      this.resultList = resultList;
    }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public int getTotalPage() {
      return totalPage;
    }

    public List getResultList() {
      return resultList;
    }

  public String getCondition() {
    return condition;
  }

public String getCondition2() {
	return condition2;
}

public void setCondition2(String condition2) {
	this.condition2 = condition2;
}

public String getCondition3() {
	return condition3;
}

public void setCondition3(String condition3) {
	this.condition3 = condition3;
}

}
