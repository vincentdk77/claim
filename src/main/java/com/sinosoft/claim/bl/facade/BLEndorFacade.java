package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;

import com.sinosoft.claim.bl.action.custom.BLEndorAction;
import com.sinosoft.claim.dto.custom.EndorDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 冲减保额逻辑分发EJB
 * <p>Description: 理赔样本程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author 车险理赔组
 * @version 1.0
 */
public class BLEndorFacade
{

 /**
   * 保存冲减保额
   * @param endorDto：自定义冲减保额对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(EndorDto endorDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLEndorAction().save(dbManager,endorDto);
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
}
