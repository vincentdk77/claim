package com.sinosoft.claim.bl.facade;
 
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.custom.BLScheduleCertainLossAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 这是PrpLthirdParty-理赔车辆信息(修改)的业务对象Facade类<br>
 * 创建于 2005-03-18 17:08:12.109<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLthirdPartyFacade extends BLPrpLthirdPartyFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLthirdPartyFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLthirdPartyFacade(){
        super();
    }
    
    
    //modify by wangli add 20050414 start
    /**
     * 保存到 理赔车辆信息表和调度任务标的表中
     * @param checkDto：自定义新增定损调度对象
     * @throws SQLException
     * @throws Exception
     */
    public void save(CheckDto checkDto,WorkFlowDto workFlowDto) throws SQLException,Exception
    {
      //创建数据库管理对象
      DBManager dbManager = new DBManager();
      
      try
      {
          dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
          //开始事务
          dbManager.beginTransaction();
        new BLScheduleCertainLossAction().save(dbManager,checkDto);
        
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
  //modify by wangli add 20050414 end
    
    
}
