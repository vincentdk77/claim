package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimFittingstgAction;
import com.sinosoft.claim.dto.domain.PrpLclaimFittingsDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimFee-估损金额表的业务对象tgFacade类<br>
 * 创建于 2005-03-18 17:08:11.937<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimFittingstgFacade extends BLPrpLclaimFittingstgFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimFittingstgFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimFittingstgFacade(){
        super();
    }

    /**
     * 保存
     * @param Collection fittingsList
     * @throws SQLException
     * @throws Exception
     */
    public void save(Collection fittingsList) throws SQLException,Exception
    {
      //创建数据库管理对象
      DBManager dbManager = new DBManager();
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      //开始事务
      dbManager.beginTransaction();
      try
      {
        new BLPrpLclaimFittingstgAction().save(dbManager,fittingsList);
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
     * 根据条件查询主表信息
     * @param conditions String
     * @throws Exception
     * @return Collection
     */
    public Collection findByConditions(String conditions) throws Exception
    {
       DBManager dbManager = new DBManager();
       PrpLclaimFittingsDto prpLclaimFittingsDto = null;
       Collection claimFittingsList = null;
       try
       {
         dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
         dbManager.beginTransaction();
         BLPrpLclaimFittingstgAction blPrpLclaimFittingstgAction = new BLPrpLclaimFittingstgAction();
         
         claimFittingsList = blPrpLclaimFittingstgAction.findByConditions(dbManager,conditions,0,0);
         
         dbManager.commitTransaction();
       }
       catch(SQLException sqle)
       {
    	   dbManager.rollbackTransaction();
            throw sqle;
       }
       catch (Exception ex) {
    	   dbManager.rollbackTransaction();
            throw ex;  
       }
       finally
       {
          dbManager.close();
       }
       return claimFittingsList;
    }

}
