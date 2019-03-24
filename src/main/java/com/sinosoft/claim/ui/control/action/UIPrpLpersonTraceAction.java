package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.ui.model.PrpLpersonTraceFindByConditionsCommand;

/**
 * UIPrpLpersonTraceAction对象
 * <p>Title: 人伤跟踪personTrace  </p>
 * <p>Description: 人伤跟踪personTrace</p>
 * <p>Copyright: Copyright (c) 20045</p>
 * <p>Company: Sinosoft</p>
 * @author wangli
 * @version 1.0
 */

public class UIPrpLpersonTraceAction {

	  /**
	 * 获得PrpLpersonTrace信息
	 * @param  conditions：查询条件
	 * @return PrpLpersonTrace对象
	 * @throws Exception
	 */

	 public Collection findByConditions(String conditions) throws SQLException,Exception
	 {
	  PrpLpersonTraceFindByConditionsCommand prpLpersonTraceFindByConditionsCommand = new PrpLpersonTraceFindByConditionsCommand(conditions);
	  
      return (Collection)prpLpersonTraceFindByConditionsCommand.execute();
    
	 }
}
