package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLClaimAction;
import com.sinosoft.claim.bl.action.custom.BLReCaseAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
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
public class BLReCaseFacade
{
  /*
  public void save(CertifyDto certifyDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLReCaseAction().save(dbManager,certifyDto);
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

 */ 
  public void save( ReCaseDto recaseDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    /*dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction(); */
    try
    {
    	 dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
         //开始事务
         dbManager.beginTransaction();
         new BLReCaseAction().save(dbManager,recaseDto);
         //重开赔案
         //new BLClaimAction().updateEndCaseDate(dbManager, recaseDto.getPrpLrecaseDto().getClaimNo(),null);
         //modify by lixiang  start at 2006-6-7
         //reason:应该在同一个事物中
        if (workFlowDto!=null){
      	  new BLWorkFlowAction().deal(dbManager,workFlowDto);
        }
        //modify by lixiang end at 2006-6-7
        
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

  public void savePrpLrecase(ReCaseDto recaseDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    try
    {
     
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      //开始事务
      dbManager.beginTransaction();
      new BLReCaseAction().savePrpLrecase(dbManager,recaseDto);
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
   /*
  public void delete(String certifyNo) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLReCaseAction().delete(dbManager,certifyNo);
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

  */
  public ReCaseDto findByPrimaryKey(String claimNo,int serialNo) throws SQLException,Exception
  {
  	ReCaseDto  reCaseDto = null;
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
   // dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      reCaseDto = new BLReCaseAction().findByPrimaryKey(dbManager,claimNo,serialNo);
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
    return reCaseDto;
  }

  /*
  public boolean isExist(String certifyNo) throws SQLException,Exception
  {

    boolean exist = false ;
    //创建数据库管理对象
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLReCaseAction().isExist(dbManager,certifyNo);
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

  */
  public Collection findByConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     ReCaseDto reCaseDto = null;
     Collection reCaseDtoList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLReCaseAction blReCaseAction = new BLReCaseAction();
       reCaseDtoList = (Collection)blReCaseAction.findByConditions(dbManager,conditions,0,0);
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
     return reCaseDtoList;
  }

  /*
  public Collection findByQueryConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection certifyList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLReCaseAction blReCaseAction = new BLReCaseAction();
       certifyList = (Collection)blReCaseAction.findByQueryConditions(dbManager,conditions,0,0);
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
  */
  public int getMaxSerialNo(String  claimNo)
  throws Exception{

  int serialNo=0;

  DBManager dbManager = new DBManager();
  BLReCaseAction blReCaseAction = new BLReCaseAction();
  try{
      dbManager.open(AppConfig.get("sysconst.DBJNDI"));
      serialNo = blReCaseAction.getMaxSerialNo(dbManager,claimNo);
  }catch(Exception exception){
      throw exception;
  }finally{
      dbManager.close();
  }
  return serialNo;
}

}
