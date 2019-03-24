package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.ui.model.PrpLpersonTraceFindByConditionsCommand;

/**
 * UIPrpLpersonTraceAction����
 * <p>Title: ���˸���personTrace  </p>
 * <p>Description: ���˸���personTrace</p>
 * <p>Copyright: Copyright (c) 20045</p>
 * <p>Company: Sinosoft</p>
 * @author wangli
 * @version 1.0
 */

public class UIPrpLpersonTraceAction {

	  /**
	 * ���PrpLpersonTrace��Ϣ
	 * @param  conditions����ѯ����
	 * @return PrpLpersonTrace����
	 * @throws Exception
	 */

	 public Collection findByConditions(String conditions) throws SQLException,Exception
	 {
	  PrpLpersonTraceFindByConditionsCommand prpLpersonTraceFindByConditionsCommand = new PrpLpersonTraceFindByConditionsCommand(conditions);
	  
      return (Collection)prpLpersonTraceFindByConditionsCommand.execute();
    
	 }
}
