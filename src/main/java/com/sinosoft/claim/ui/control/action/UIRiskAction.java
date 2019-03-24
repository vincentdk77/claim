package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.ui.model.PrpDriskFindByConditionsCommand;

/**
 * 险种查询
 * <p>Title: 险种action  </p>
 * <p>Description: 险种action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UIRiskAction
{

  /**
  * 获得险种信息
  * @param  conditions：查询条件
  * @return 险种对象
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     PrpDriskFindByConditionsCommand prpDriskFindByConditionsCommand = new PrpDriskFindByConditionsCommand(conditions);

     return (Collection)prpDriskFindByConditionsCommand.execute();
  }
}
