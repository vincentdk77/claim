package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.custom.BLMessageAction;
import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;



/**
 * 这是PrpLmessage理赔流转讨论留言表的业务对象Facade类<br>
 * 创建于 2004-07-27 16:11:43.797<br>
 * JToolpad(1.2.12-RC9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLmessageFacade extends BLPrpLmessageFacadeBase{
  private static Log logger = LogFactory.getLog(BLPrpLmessageFacade.class);

  /**
   * 构造函数
   */
  public BLPrpLmessageFacade() {
    super();
  }

  /**
   * 保存留言内容
   * @param prplmessageDto PrpLmessageDto
   * @throws SQLException
   * @throws Exception
   */
  public void save(PrpLmessageDto prpLmessageDto) throws SQLException,
      Exception {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI"));
    //开始事务
    dbManager.beginTransaction();
    try {
      new BLMessageAction().save(dbManager, prpLmessageDto);
      //提交事务
      dbManager.commitTransaction();
    }
    catch (SQLException sqle) {
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch (Exception ex) {
      //回滚事务
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally {
      //关闭数据库连接
      dbManager.close();
    }
  }

  /**
     * 取得序号
     * @param registNo
     * @param dbManager  数据连接
     * @return messageID
     * @throws SQLException
     * @throws Exception
     */
      public int getNo(String registNo) throws SQLException,Exception
      {

        int messageID =0 ;
        //创建数据库管理对象
         DBManager dbManager = new DBManager();
         dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
        try
        {
          messageID = new BLMessageAction().getNo(dbManager,registNo);
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
        return messageID;
      }


}






