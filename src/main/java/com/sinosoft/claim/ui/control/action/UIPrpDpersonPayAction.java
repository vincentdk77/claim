package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.ui.model.PrpDpersonPayFindByConditionsCommand;

/**
 * PrpDperson对象
 * <p>Title: 车险理赔PrpDperson  </p>
 * <p>Description: 车险理赔PrpDperson</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UIPrpDpersonPayAction
{
  

  /**
 * 获得PrpDperson信息
 * @param  conditions：查询条件
 * @return PrpDperson对象
 * @throws Exception
 */

 public Collection findByConditions(String conditions) throws SQLException,Exception
 {
    PrpDpersonPayFindByConditionsCommand prpDpersonPayFindByConditionsCommand = new PrpDpersonPayFindByConditionsCommand(conditions);

    return (Collection)prpDpersonPayFindByConditionsCommand.execute();
 }

}
