package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.ui.model.PrpDriskFindByConditionsCommand;

/**
 * ���ֲ�ѯ
 * <p>Title: ����action  </p>
 * <p>Description: ����action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UIRiskAction
{

  /**
  * ���������Ϣ
  * @param  conditions����ѯ����
  * @return ���ֶ���
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     PrpDriskFindByConditionsCommand prpDriskFindByConditionsCommand = new PrpDriskFindByConditionsCommand(conditions);

     return (Collection)prpDriskFindByConditionsCommand.execute();
  }
}
