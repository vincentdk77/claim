package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpClimitDto;
import com.sinosoft.claim.ui.model.PrpClimitFindByConditionsCommand;
import com.sinosoft.claim.ui.model.PrpClimitFindByPrimaryKeyCommand;
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
public class UIPrpClimitAction
{

  /**
  * ��ò�����Ϣ
  * @param  conditions����ѯ����
  * @return prpDcompany���󼯺�
  * @throws Exception
  */

 
  /**
   * ��ò�����Ϣ
   * @param  comCode
   * @return prpDcompany����
   * @throws Exception
   */
  public PrpClimitDto findByPrimaryKey(String policyNo ,String limitGrade ,double limitNo ,String limitType ,String currency) throws SQLException,UserException,Exception
  {
  	PrpClimitFindByPrimaryKeyCommand prpClimitFindByPrimaryKeyCommand = new PrpClimitFindByPrimaryKeyCommand(policyNo,limitGrade,limitNo,limitType,currency);
  	PrpClimitDto prpClimitDto = (PrpClimitDto)prpClimitFindByPrimaryKeyCommand.execute();
       return prpClimitDto;
  }
  
  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
  	PrpClimitFindByConditionsCommand prpClimitFindByConditionsCommand = new PrpClimitFindByConditionsCommand(conditions);

     return (Collection)prpClimitFindByConditionsCommand.execute();
  }

}
