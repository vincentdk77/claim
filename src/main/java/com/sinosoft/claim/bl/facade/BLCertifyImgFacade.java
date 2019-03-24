package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLCertifyImgAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcertifyImgAction;
import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  单证图片逻辑分发
 * <p>Title: 车险理赔单证图片</p>
 * <p>Description: 车险理赔单证图片facade</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author 理赔项目组
 * @version 1.0
 */
public class BLCertifyImgFacade
{    
  /** 
   * 保存单证图片
   * @param certifyImgDto：自定义单证图片对象
   * @throws SQLException 
   * @throws Exception
   */ 
  public void save(PrpLcertifyImgDto prpLcertifyImgDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
  	try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      //开始事务
      dbManager.beginTransaction();  
      new BLCertifyImgAction().save(dbManager,prpLcertifyImgDto);
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
    	ex.printStackTrace();
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
   * 删除单证图片
   * @param  dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(PrpLcertifyImgDto prpLcertifyImgDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    try
    {
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
      new BLCertifyImgAction().delete(dbManager,prpLcertifyImgDto);
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
   * 删除单证图片
   * @param  dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void update(PrpLcertifyImgDto prpLcertifyImgDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    try
    {
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction(); 
      new BLCertifyImgAction().update(dbManager,prpLcertifyImgDto);
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
   * 获得单证图片
   * @param dbManager  数据连接
   * @return 自定义单证图片对象
   * @throws SQLException
   * @throws Exception
   */
  public PrpLcertifyImgDto findByPrimaryKey(PrpLcertifyImgDto prpLcertifyImgDto) throws SQLException,Exception
  {
    PrpLcertifyImgDto prpLcertifyImgDtoTemp = null;
    //创建数据库管理对象 
    DBManager dbManager = new DBManager();
    try
    {  
    	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    	prpLcertifyImgDtoTemp = new BLCertifyImgAction().findByPrimaryKey(dbManager,prpLcertifyImgDto);
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
    return prpLcertifyImgDtoTemp;
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
       BLPrpLcertifyImgAction blPrpLcertifyImgAction = new BLPrpLcertifyImgAction();
       certainLossList = (Collection)blPrpLcertifyImgAction.findByConditions(dbManager,conditions);
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
   * 根据条件更新单证及影像表信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   * add by liyanjie 2005-11-04 reason:单证删除功能
   */
  public void updateByCondition(String condition) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    try
    {
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction(); 
      new BLCertifyImgAction().updateByCondition(dbManager,condition);
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
 
  //add by zhaolu 20060913 start
  //增加单证查看分页
  public PageRecord findByQueryConditions(String conditions, String pageNo, String recordPerPage)
  throws SQLException, Exception
 {
  DBManager dbManager = new DBManager();
  PageRecord pagerecord;
  try
  {
      dbManager.open(AppConfig.get("sysconst.DBJNDI"));
      BLPrpLcertifyImgAction blPrpLcertifyImgAction = new BLPrpLcertifyImgAction();
      if(pageNo == null || pageNo.trim().length() < 1)
          pageNo = "1";
      pagerecord = blPrpLcertifyImgAction.findByConditions(dbManager, conditions, Integer.parseInt(pageNo), Integer.parseInt(recordPerPage));
  }
  finally
  {
      dbManager.close();
  }
  return pagerecord;
}
  //add by zhaolu 20060913 end
  
  
  
}
