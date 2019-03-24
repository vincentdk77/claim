package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.ui.model.PrpLpersonFindByConditionsCommand;

/**
 * PrpLperson����
 * <p>Title: ��������PrpLperson  </p>
 * <p>Description: ��������PrpLperson</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UIPrpLpersonAction
{

  /**
 * ���PrpLperson��Ϣ
 * @param  conditions����ѯ����
 * @return PrpLperson����
 * @throws Exception
 */

 public Collection findByConditions(String conditions) throws SQLException,Exception
 {
    PrpLpersonFindByConditionsCommand prpLpersonFindByConditionsCommand = new PrpLpersonFindByConditionsCommand(conditions);

    return (Collection)prpLpersonFindByConditionsCommand.execute();
 }

}
