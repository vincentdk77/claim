package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLVerifyLossAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLverifyLossAction;
import com.sinosoft.claim.dto.custom.VerifyLossDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;


/**
 *  核损逻辑分发
 * <p>Title: 车险理赔核损</p>
 * <p>Description: 车险理赔核损facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLVerifyLossFacade
{
  /**
   * 保存核损
   * @param verifyLossDto：自定义核损对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(VerifyLossDto verifyLossDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLVerifyLossAction().save(dbManager,verifyLossDto);
      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }
  }

   /**
   * 保存核损带工作流
   * @param verifyLossDto：自定义核损对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(VerifyLossDto verifyLossDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLVerifyLossAction().save(dbManager,verifyLossDto);
      if(workFlowDto!=null){
        new BLWorkFlowAction().deal(dbManager,workFlowDto);
      }
      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }
  }

  /**
   * 删除核损
   * @param  registNo
   * @param  nodeType
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String registNo,String nodeType) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLVerifyLossAction().delete(dbManager,registNo,nodeType);
      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }

  }
  /**
   * 获得核损
   * @param  registNo
   * @param dbManager  数据连接
   * @return 自定义核损对象
   * @throws SQLException
   * @throws Exception
   */
  public VerifyLossDto findByPrimaryKey(String registNo,String lossItemCode,String nodeType) throws SQLException,Exception
  {
    VerifyLossDto verifyLossDto = null;
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      verifyLossDto = new BLVerifyLossAction().findByPrimaryKey(dbManager,registNo,lossItemCode,nodeType);
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
    return verifyLossDto;
  }

  /**
   * 判断核损通知号是否存在
   * @param registNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String registNo,String lossItemCode,String nodeType) throws SQLException,Exception
  {

    boolean exist = false ;
    //创建数据库管理对象
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLVerifyLossAction().isExist(dbManager,registNo,lossItemCode,nodeType);
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
    return exist;
  }

  /**
   * 根据条件查询核损主表信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findByConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection verifyLossList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLverifyLossAction blPrpLverifyLossAction = new BLPrpLverifyLossAction();
       verifyLossList = (Collection)blPrpLverifyLossAction.findByConditions(dbManager,conditions);
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
     return verifyLossList;
  }

  /**
   * 根据条件查询报案主表信息
   * @param conditions String
   * @param nodeType String
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:增加新的查询方法
   */
  public Collection findByQueryConditions(String conditions,String nodeType) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection verifyLossList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLVerifyLossAction blVerifyLossAction = new BLVerifyLossAction();
       verifyLossList = (Collection)blVerifyLossAction.findByQueryConditions(dbManager,conditions,nodeType,0,0);
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
     return verifyLossList;
  }

  /**
   * 获得核损
   * @param  registNo
   * @param dbManager  数据连接
   * @return 自定义核损对象
   * @throws SQLException
   * @throws Exception
   */
  /*
  public VerifyLossDto findByPrimaryKey(String registNo,String serialNo) throws SQLException,Exception
  {
    VerifyLossDto verifyLossDto = null;
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      verifyLossDto = new BLVerifyLossAction().findByPrimaryKey(dbManager,registNo,serialNo);
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
    return verifyLossDto;
  }
  */
  
  //add by zhaolu 20060803 start
  public PageRecord findByCondition(String conditions,String nodeType,int pageNo,int recordPerPage) throws Exception
  {
	   DBManager dbManager = new DBManager();
		//PrpLpolicyDto prpLpolicyDto = null;
		PageRecord pageRecord = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLVerifyLossAction blVerifyLossAction = new BLVerifyLossAction();
			pageRecord = (PageRecord) blVerifyLossAction.findByCondition(
					dbManager, conditions,nodeType,pageNo,recordPerPage);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return pageRecord;
  }
  //add by zhaolu 20060803 end 
  
  
}
