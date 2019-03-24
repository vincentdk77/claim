package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLmessageAction;
import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLMessageListFacade {
  public BLMessageListFacade() {//Ĭ�Ϲ��캯��
  }

   /**
     * �鿴����ҳ���ѯFacade
     * @param dbManager dbManager
     * @param prpLmessageDto
     * @throws Exception
     */
  
  
  public Collection findByConditions(String conditions) throws Exception
 {
    DBManager dbManager = new DBManager();
    PrpLmessageDto prpLmessageDto = null;
    Collection messageList = new ArrayList();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      BLPrpLmessageAction blPrpLmessageAction = new BLPrpLmessageAction();
      messageList = (Collection)blPrpLmessageAction.findByConditions(dbManager,conditions);
    }
    catch(SQLException sqle)
    {
      throw sqle;
    }
    catch (Exception ex) {
      throw ex;
    }
    finally
    {
      dbManager.close();
    }
    return messageList;
 }
  
  /**
   * �鿴����ҳ���ѯFacade(�������Ľӿ�ʹ�ã�������������Ϊ(yyyy-mm-dd hh24:mi:ss))
   * @param dbManager dbManager
   * @param prpLmessageDto
   * @throws Exception
   */


public Collection findByConditions1(String conditions) throws Exception
{
  DBManager dbManager = new DBManager();
  PrpLmessageDto prpLmessageDto = null;
  Collection messageList = new ArrayList();
  try
  {
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    BLPrpLmessageAction blPrpLmessageAction = new BLPrpLmessageAction();
    messageList = (Collection)blPrpLmessageAction.findByConditions1(dbManager,conditions);
  }
  catch(SQLException sqle)
  {
    throw sqle;
  }
  catch (Exception ex) {
    throw ex;
  }
  finally
  {
    dbManager.close();
  }
  return messageList;
}

}
