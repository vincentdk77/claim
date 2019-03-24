package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.ui.model.MidResultConfigFindByConditionsCommand;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**���ֲ��action��
* <p>Title: UIResultConfigAction</p>
* <p>Description:�²�Ʒͳ�Ʒ���ϵͳ���� </p>
* <p>Copyright: Copyright (c) 2004</p>
* <p>Company: Sinosoft</p>
* <p>@createdate 2004/07/30</p>
* @author zhangshengli
* @version 1.0
*/

public class UIResultConfigAction
{
  /**
   *��������ѯ������¼
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
   *��������ѯ������¼
   *parameter strCondition
   *return PageRecored
   */
  public Collection findByConditions(String strCondition) throws Exception
  {
    MidResultConfigFindByConditionsCommand midResultConfigFindByConditionsCommand = new MidResultConfigFindByConditionsCommand(strCondition);

    return (Collection)midResultConfigFindByConditionsCommand.executeCommand();
  }

  /**
   *ȡ��¼��
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
