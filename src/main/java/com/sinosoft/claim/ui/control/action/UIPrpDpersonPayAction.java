package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.ui.model.PrpDpersonPayFindByConditionsCommand;

/**
 * PrpDperson����
 * <p>Title: ��������PrpDperson  </p>
 * <p>Description: ��������PrpDperson</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UIPrpDpersonPayAction
{
  

  /**
 * ���PrpDperson��Ϣ
 * @param  conditions����ѯ����
 * @return PrpDperson����
 * @throws Exception
 */

 public Collection findByConditions(String conditions) throws SQLException,Exception
 {
    PrpDpersonPayFindByConditionsCommand prpDpersonPayFindByConditionsCommand = new PrpDpersonPayFindByConditionsCommand(conditions);

    return (Collection)prpDpersonPayFindByConditionsCommand.execute();
 }

}
