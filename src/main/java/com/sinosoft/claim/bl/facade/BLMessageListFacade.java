package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLmessageAction;
import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLMessageListFacade {
  public BLMessageListFacade() {//默认构造函数
  }

   /**
     * 查看留言页面查询Facade
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
   * 查看留言页面查询Facade(呼叫中心接口使用，输入日期类型为(yyyy-mm-dd hh24:mi:ss))
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
