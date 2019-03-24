package com.sinosoft.function.power.bl.facade;
/**
 * <p>Title: 权限校验</p>
 * <p>Description: 理赔产品组权限校验类Facade</p>
 * <p>Copyright: Copyright (c) 2004.11</p>
 * <p>Company: Sinosoft</p>
 * @author 理赔产品组 魏士鑫
 * @version 1.0
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.function.power.bl.action.custom.BLPowerAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPowerFacade extends BLPowerFacadeBase
{
  public BLPowerFacade()
  {
  }

  /**
   * 根据岗位（任务）及险种，部门条件获得某岗位的人员权限
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findByTask(String conditions) throws Exception
  {
    BLPowerAction blPowerAction = new BLPowerAction();
    Collection collection = new ArrayList();
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
      collection = blPowerAction.findByTask(dbManager,conditions);
    }
    catch(Exception e)
    {
      throw e;
    }
    finally {
      dbManager.close();
    }

    return collection;
  }
  
  /**
   * 根据人员获取对应公司本机各机构代码
   * @param userCode String
   * @param tableName String
   * @throws SQLException
   * @throws Exception
   * @return String
   */
  public String getLocalCom(String userCode,String tableName) throws Exception
  {
    BLPowerAction blPowerAction = new BLPowerAction();
    String conditions = "";
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
      conditions = blPowerAction.getLocalCom(dbManager,userCode,tableName);
    }
    catch(Exception e)
    {
      throw e;
    }
    finally {
      dbManager.close();
    }

    return conditions;
  }

}
