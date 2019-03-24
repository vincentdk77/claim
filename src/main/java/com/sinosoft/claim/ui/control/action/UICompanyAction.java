package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.ui.model.PrpDcompanyFindByConCommand;
import com.sinosoft.claim.ui.model.PrpDcompanyFindByConditionsCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 出单机构处理
 * <p>Title: 公司部门处理action  </p>
 * <p>Description: 公司部门处理action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UICompanyAction
{

  /**
  * 获得部门信息
  * @param  conditions：查询条件
  * @return prpDcompany对象集合
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     PrpDcompanyFindByConditionsCommand prpDcompanyFindByConditionsCommand = new PrpDcompanyFindByConditionsCommand(conditions);

     return (Collection)prpDcompanyFindByConditionsCommand.execute();
  }

  /**
   * 获得部门信息
   * @param  comCode
   * @return prpDcompany对象
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
