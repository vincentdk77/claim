package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLCertifyAction;
import com.sinosoft.claim.bl.action.custom.BLCertifyCombineAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowCombineAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcertifyCollectAction;
import com.sinosoft.claim.dto.custom.CertifyDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;


/**
 *  单证逻辑分发
 * <p>Title: 车险理赔单证</p>
 * <p>Description: 车险理赔单证facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLCertifyCombineFacade
{
  /**
   * 保存单证
   * @param certifyDto：自定义单证对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(CertifyDto certifyDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLCertifyCombineAction().save(dbManager,certifyDto);
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
   * 保存单证带工作流
   * @param certifyDto：自定义单证对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(CertifyDto certifyDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLCertifyCombineAction().save(dbManager,certifyDto);
      if(workFlowDto!=null){
        new BLWorkFlowCombineAction().deal(dbManager,workFlowDto);
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
   * 删除单证
   * @param  certifyNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String certifyNo) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLCertifyCombineAction().delete(dbManager,certifyNo);
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
   * 获得单证
   * @param  certifyNo
   * @param dbManager  数据连接
   * @return 自定义单证对象
   * @throws SQLException
   * @throws Exception
   */
  public CertifyDto findByPrimaryKey(String registNo) throws SQLException,Exception
  {
    CertifyDto certifyDto = null;
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      certifyDto = new BLCertifyCombineAction().findByPrimaryKey(dbManager,registNo);
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
    return certifyDto;
  }

  /**
   * 判断单证通知号是否存在
   * @param certifyNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String certifyNo) throws SQLException,Exception
  {

    boolean exist = false ;
    //创建数据库管理对象
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLCertifyCombineAction().isExist(dbManager,certifyNo);
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
   * 根据条件查询单证主表信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findByConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLcertifyCollectDto prpLcertifyCollectDto = null;
     Collection certifyList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
       certifyList = (Collection)blPrpLcertifyCollectAction.findByConditions(dbManager,conditions);
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
     return certifyList;
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
     Collection certifyList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLCertifyAction blCertifyAction = new BLCertifyAction();
       certifyList = (Collection)blCertifyAction.findByQueryConditions(dbManager,conditions,0,0);
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
     return certifyList;
  }
  
  //add by zhaolu 20060803 start
  public PageRecord findByQueryConditions(String conditions,int pageNo,int recordPerPage) throws Exception
  {
	  DBManager dbManager = new DBManager();
		//PrpLpolicyDto prpLpolicyDto = null;
		PageRecord pageRecord = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			 BLCertifyAction  blCertifyAction = new  BLCertifyAction();
			pageRecord = (PageRecord)blCertifyAction.findByConditions(
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
