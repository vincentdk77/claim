package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是WorkFlow工作流条件描述表的业务对象Facade类<br>
 * 创建于 2004-08-09 19:54:55.307<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLWorkFlowFacade extends BLWorkFlowFacadeBase {
    private static Log logger = LogFactory.getLog(BLWorkFlowFacade.class);

    /**
     * 构造函数
     */
    public BLWorkFlowFacade() {
        super();
    }

    /**
     * 创建工作流程的操作
     * @return scheduleID
     * @throws SQLException
     * @throws Exception
     */
    public String createFlow(WorkFlowDto workFlowDto) throws SQLException,
            Exception {

        String flowID = "";
        // 创建数据库管理对象
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        try {
            flowID = new BLWorkFlowAction().createFlow(dbManager, workFlowDto);
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            // 关闭数据库连接
            dbManager.close();
        }
        return flowID;
    }

    /**
     * 提交流程下一个节点的操作
     * @return scheduleID
     * @throws SQLException
     * @throws Exception
     */
    public String submitNode(WorkFlowDto workFlowDto) throws SQLException,
            Exception {

        String flowID = "";
        // 创建数据库管理对象
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        try {
            flowID = new BLWorkFlowAction().submitNode(dbManager, workFlowDto);
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            // 关闭数据库连接
            dbManager.close();
        }
        return flowID;
    }

    /**
     * 关闭工作流程的操作
     * @return scheduleID
     * @throws SQLException
     * @throws Exception
     */
    public String closeFlow(String flowID) throws SQLException, Exception {
        // 创建数据库管理对象
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        try {
            new BLWorkFlowAction().closeFlow(dbManager, flowID);
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            // 关闭数据库连接
            dbManager.close();
        }
        return flowID;
    }

    /**
     * 对工作流程的全部操作
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public void deal(WorkFlowDto workFlowDto) throws SQLException, Exception {

        // 创建数据库管理对象
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        boolean inOneTransaction = false;
        if (workFlowDto.getRecycle()) {
            inOneTransaction = true;
        }
        try {
            if (inOneTransaction) {
                dbManager.beginTransaction();
            }
            new BLWorkFlowAction().deal(dbManager, workFlowDto);
            if (inOneTransaction) {
                dbManager.commitTransaction();
            }
        } catch (Exception ex) {
            if (inOneTransaction) {
                dbManager.rollbackTransaction();
            }
            throw ex;
        } finally {
            // 关闭数据库连接
            dbManager.close();
        }
        return;
    }

    /**
     * 获取当前使用的工作流程的模板号码
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public int getModelNo(String riskCode, String comCode) throws SQLException,
            Exception {
        int modelNo = -1;
        // 创建数据库管理对象
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        try {
            modelNo = new BLWorkFlowAction().getModelNo(dbManager, riskCode,
                    comCode);
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            // 关闭数据库连接
            dbManager.close();
        }
        return modelNo;
    }

    /**
     * 根据条件查询理赔节点状态统计信息
     * @param conditions String
     * @throws Exception
     * @return Collection
     */
    public Collection getStatStatus(String conditions) throws Exception {
        DBManager dbManager = new DBManager();
        Collection claimStatusList = new ArrayList();
        try {
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            BLWorkFlowAction blWorkFlowAction = new BLWorkFlowAction();
            claimStatusList = (Collection) blWorkFlowAction.getStatStatus(
                    dbManager, conditions);
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            dbManager.close();
        }
        return claimStatusList;
    }
 /**
   * 删除注销/拒赔任务（即为退回注销/拒赔任务）add 2005-11-24
   * @param flowID 流程号
   * @param logNo  序号
   * @throws Exception
   * */
  public void cancelBack(String flowID, int logNo) throws Exception {
      DBManager dbManager = new DBManager();
      BLWorkFlowAction blWorkFlowAction = new BLWorkFlowAction();
      try {
          dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
          dbManager.beginTransaction();
          blWorkFlowAction.cancelBack(dbManager, flowID, logNo);
          dbManager.commitTransaction();
      } catch (SQLException sql) {
          dbManager.rollbackTransaction();
          throw sql;
      } catch (Exception ex) {
          dbManager.rollbackTransaction();
          throw ex;
      } finally {
          dbManager.close();
      }
  }
}
