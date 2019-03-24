package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLED_AGENT_INFOAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是座席员工信息表的业务对象Facade类<br>
 * 创建于 2005-07-19 09:59:06.511<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLED_AGENT_INFOFacade extends BLED_AGENT_INFOFacadeBase{
    private static Log logger = LogFactory.getLog(BLED_AGENT_INFOFacade.class);

    /**
     * 构造函数
     */
    public BLED_AGENT_INFOFacade(){
        super();
    }
    
  /**
   * 判断员工工号是否存在
   * @param agentid
   * @param password
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String agentid,String password) throws SQLException,Exception
  {

    boolean exist = false;
    
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    try
    {
        dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
      exist = new BLED_AGENT_INFOAction().isExist(dbManager,agentid,password);
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
  
}
