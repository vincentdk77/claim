package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.ui.model.PrpLpersonFindByConditionsCommand;

/**
 * PrpLperson对象
 * <p>Title: 车险理赔PrpLperson  </p>
 * <p>Description: 车险理赔PrpLperson</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UIPrpLpersonAction
{

  /**
 * 获得PrpLperson信息
 * @param  conditions：查询条件
 * @return PrpLperson对象
 * @throws Exception
 */

 public Collection findByConditions(String conditions) throws SQLException,Exception
 {
    PrpLpersonFindByConditionsCommand prpLpersonFindByConditionsCommand = new PrpLpersonFindByConditionsCommand(conditions);

    return (Collection)prpLpersonFindByConditionsCommand.execute();
 }

}
