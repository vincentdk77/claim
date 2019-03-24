package com.sinosoft.claim.query.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLEndorseAction;
import com.sinosoft.claim.dto.custom.EndorseDto;
import com.sinosoft.claim.query.util.Constant;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 批单逻辑分发EJB
 * <p>Description: 理赔样本程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author 车险理赔组
 * @version 1.0
 */
public class BLEndorseFacade
{

  public EndorseDto findByPrimaryKey(String endorseNo) throws SQLException,Exception
  {
    EndorseDto endorseDto = null ;
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      endorseDto = new BLEndorseAction().findByPrimaryKey(dbManager,endorseNo);
    }
    catch(SQLException sqle)
    {
      throw sqle;
    }
    catch(Exception ex)
    {
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }

    return endorseDto ;
  }
  public EndorseDto findByConditions(String policyNo) throws SQLException,Exception
  {
    EndorseDto endorseDto = null ;
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      endorseDto = new BLEndorseAction().findByConditions(dbManager,policyNo);
    }
    catch(SQLException sqle)
    {
      throw sqle;
    }
    catch(Exception ex)
    {
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }

    return endorseDto ;
  }

  /**
   * 根据条件查询批单主表信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findByPrpPheadConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection collection = new ArrayList();
     try
     {

       //dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    	 dbManager.open(Constant.QUERY_DATA_SOURCE) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLEndorseAction blEndorseAction = new BLEndorseAction();
       collection = (Collection)blEndorseAction.findByPrpPheadConditions(dbManager,conditions,0,0);
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
     return collection;
  }

}
