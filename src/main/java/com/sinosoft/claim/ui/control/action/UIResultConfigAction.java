package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.ui.model.MidResultConfigFindByConditionsCommand;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**表现层的action类
* <p>Title: UIResultConfigAction</p>
* <p>Description:新产品统计分析系统程序 </p>
* <p>Copyright: Copyright (c) 2004</p>
* <p>Company: Sinosoft</p>
* <p>@createdate 2004/07/30</p>
* @author zhangshengli
* @version 1.0
*/

public class UIResultConfigAction
{
  /**
   *按条件查询多条记录
   *parameter strCondition,intPageNo,intRowsPerPage
   *return PageRecored
   */
  public PageRecord findByConditions(String strCondition,int intPageNo,int intRowsPerPage) throws SQLException,UserException,Exception
  {
    MidResultConfigFindByConditionsCommand midResultConfigFindByConditionsCommand = new MidResultConfigFindByConditionsCommand(strCondition,intPageNo,intRowsPerPage);

    PageRecord pageRecord = (PageRecord)midResultConfigFindByConditionsCommand.executeCommand();

    if(pageRecord==null)
    {
      throw new UserException(-98,200,this.getClass().getName()+".findByConditions("+strCondition+","+intPageNo+","+intRowsPerPage+")");
    }

    return pageRecord;
  }

  /**
   *按条件查询多条记录
   *parameter strCondition
   *return PageRecored
   */
  public Collection findByConditions(String strCondition) throws Exception
  {
    MidResultConfigFindByConditionsCommand midResultConfigFindByConditionsCommand = new MidResultConfigFindByConditionsCommand(strCondition);

    return (Collection)midResultConfigFindByConditionsCommand.executeCommand();
  }

  /**
   *取纪录数
   *parameter strCondition
   *return int

  public int getRowsCount(String strCondition) throws Exception
  {
    MidResultConfigGetCountCommand midResultConfigGetCountCommand = new MidResultConfigGetCountCommand(strCondition);

    Integer intObject = (Integer)midResultConfigGetCountCommand.executeCommand();

    return intObject.intValue();
  }
   */  
}
