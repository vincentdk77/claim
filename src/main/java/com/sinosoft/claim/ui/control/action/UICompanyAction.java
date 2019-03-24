package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.ui.model.PrpDcompanyFindByConCommand;
import com.sinosoft.claim.ui.model.PrpDcompanyFindByConditionsCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * ������������
 * <p>Title: ��˾���Ŵ���action  </p>
 * <p>Description: ��˾���Ŵ���action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UICompanyAction
{

  /**
  * ��ò�����Ϣ
  * @param  conditions����ѯ����
  * @return prpDcompany���󼯺�
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     PrpDcompanyFindByConditionsCommand prpDcompanyFindByConditionsCommand = new PrpDcompanyFindByConditionsCommand(conditions);

     return (Collection)prpDcompanyFindByConditionsCommand.execute();
  }

  /**
   * ��ò�����Ϣ
   * @param  comCode
   * @return prpDcompany����
   * @throws Exception
   */
  public PrpDcompanyDto findByPrimaryKey(String comCode) throws SQLException,UserException,Exception
  {
          PrpDcompanyFindByConCommand prpDcompanyFindByConCommand = new PrpDcompanyFindByConCommand(comCode);
          PrpDcompanyDto prpDcompanyDto = (PrpDcompanyDto)prpDcompanyFindByConCommand.execute();

    if (comCode == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+comCode+")");
    }
    return prpDcompanyDto;
  }
}
