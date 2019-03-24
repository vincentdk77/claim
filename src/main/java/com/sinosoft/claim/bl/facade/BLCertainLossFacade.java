package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLCertainLossAction;
import com.sinosoft.claim.bl.action.custom.BLCheckAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLverifyLossAction;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  定损逻辑分发
 * <p>Title: 车险理赔定损</p>
 * <p>Description: 车险理赔定损facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLCertainLossFacade
{
  /**
   * 保存定损
   * @param certainLossDto：自定义定损对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(CertainLossDto certainLossDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLCertainLossAction().save(dbManager,certainLossDto);
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
   * 保存并案定损
   * @param certainLossDto：自定义定损对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(ArrayList certainLossDtoList) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
    	for(int i = 0;i < certainLossDtoList.size();i++){
    		new BLCertainLossAction().save(dbManager,(CertainLossDto)certainLossDtoList.get(i));
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
   * 保存定损带工作流
   * @param certainLossDto：自定义定损对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(CertainLossDto certainLossDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLCertainLossAction().save(dbManager,certainLossDto);
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
   * 保存定损带工作流
   * @param certainLossDto：自定义定损对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(ArrayList certainLossDtoList,ArrayList workFlowDtoList) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
    	for(int i = 0;i < certainLossDtoList.size();i++){
    		new BLCertainLossAction().save(dbManager,(CertainLossDto)certainLossDtoList.get(i));
    	}
    	for(int i = 0;i < workFlowDtoList.size();i++){
		new BLWorkFlowAction().deal(dbManager,(WorkFlowDto)workFlowDtoList.get(i));
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
   * 删除定损
   * @param  registNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String registNo) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLCertainLossAction().delete(dbManager,registNo);
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
   * 获得定损
   * @param  registNo
   * @param dbManager  数据连接
   * @return 自定义定损对象
   * @throws SQLException
   * @throws Exception
   */
  public CertainLossDto findByPrimaryKey(String registNo,String lossItemCode) throws SQLException,Exception
  {
    CertainLossDto certainLossDto = null;
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      certainLossDto = new BLCertainLossAction().findByPrimaryKey(dbManager,registNo,lossItemCode);
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
    return certainLossDto;
  }

  /**
   * 获得定损
   * @param  registNo
   * @param dbManager  数据连接
   * @return 自定义定损对象
   * @throws SQLException
   * @throws Exception 
   */
  public CertainLossDto findByPrimaryKey(String registNo) throws SQLException,Exception
  {
    CertainLossDto certainLossDto = null;
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      certainLossDto = new BLCertainLossAction().findByPrimaryKey(dbManager,registNo);
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
    return certainLossDto;
  }
  /**
   * 判断定损通知号是否存在
   * @param registNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String registNo,String lossItemCode) throws SQLException,Exception
  {

    boolean exist = false ;
    //创建数据库管理对象
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLCertainLossAction().isExist(dbManager, registNo,lossItemCode);
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
   * 根据条件查询定损主表信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findByConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection certainLossList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLverifyLossAction blPrpLcertainLossAction = new BLPrpLverifyLossAction();
       certainLossList = (Collection)blPrpLcertainLossAction.findByConditions(dbManager,conditions);
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
     return certainLossList;
  }

  /**
   * 根据条件查询报案主表信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:增加新的查询方法
   */
  public Collection findByQueryConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection certainLossList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLCertainLossAction blCertainLossAction = new BLCertainLossAction();
       certainLossList = (Collection)blCertainLossAction.findByQueryConditions(dbManager,conditions,0,0);
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
     return certainLossList;
  }

  /**
   * 保存定损带工作流
   * @param certainLossDto：自定义定损对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(CertainLossDto certainLossDto,CheckDto checkDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLCertainLossAction().save(dbManager,certainLossDto);

      new BLCheckAction().save(dbManager,checkDto);

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
   * 保存定损带工作流
   * @param certainLossDto：自定义定损对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(CertainLossDto certainLossDto,CheckDto checkDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLCertainLossAction().save(dbManager,certainLossDto);
        new BLWorkFlowAction().deal(dbManager,workFlowDto);
        new BLCheckAction().save(dbManager,checkDto);
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
  
  //add by zhaolu 20060803 start
  public PageRecord findByCondition(String conditions,int pageNo,int recordPerPage) throws Exception
  {
	  DBManager dbManager = new DBManager();
		//PrpLpolicyDto prpLpolicyDto = null;
		PageRecord pageRecord = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLCertainLossAction blCertainLossAction = new BLCertainLossAction();
			pageRecord = (PageRecord) blCertainLossAction.findByCondition(
					dbManager, conditions,pageNo,recordPerPage);
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
