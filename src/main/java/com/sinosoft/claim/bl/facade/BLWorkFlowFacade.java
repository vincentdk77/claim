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
 * ����WorkFlow�����������������ҵ�����Facade��<br>
 * ������ 2004-08-09 19:54:55.307<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLWorkFlowFacade extends BLWorkFlowFacadeBase {
    private static Log logger = LogFactory.getLog(BLWorkFlowFacade.class);

    /**
     * ���캯��
     */
    public BLWorkFlowFacade() {
        super();
    }

    /**
     * �����������̵Ĳ���
     * @return scheduleID
     * @throws SQLException
     * @throws Exception
     */
    public String createFlow(WorkFlowDto workFlowDto) throws SQLException,
            Exception {

        String flowID = "";
        // �������ݿ�������
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        try {
            flowID = new BLWorkFlowAction().createFlow(dbManager, workFlowDto);
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            // �ر����ݿ�����
            dbManager.close();
        }
        return flowID;
    }

    /**
     * �ύ������һ���ڵ�Ĳ���
     * @return scheduleID
     * @throws SQLException
     * @throws Exception
     */
    public String submitNode(WorkFlowDto workFlowDto) throws SQLException,
            Exception {

        String flowID = "";
        // �������ݿ�������
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        try {
            flowID = new BLWorkFlowAction().submitNode(dbManager, workFlowDto);
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            // �ر����ݿ�����
            dbManager.close();
        }
        return flowID;
    }

    /**
     * �رչ������̵Ĳ���
     * @return scheduleID
     * @throws SQLException
     * @throws Exception
     */
    public String closeFlow(String flowID) throws SQLException, Exception {
        // �������ݿ�������
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        try {
            new BLWorkFlowAction().closeFlow(dbManager, flowID);
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            // �ر����ݿ�����
            dbManager.close();
        }
        return flowID;
    }

    /**
     * �Թ������̵�ȫ������
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public void deal(WorkFlowDto workFlowDto) throws SQLException, Exception {

        // �������ݿ�������
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
            // �ر����ݿ�����
            dbManager.close();
        }
        return;
    }

    /**
     * ��ȡ��ǰʹ�õĹ������̵�ģ�����
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public int getModelNo(String riskCode, String comCode) throws SQLException,
            Exception {
        int modelNo = -1;
        // �������ݿ�������
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
            // �ر����ݿ�����
            dbManager.close();
        }
        return modelNo;
    }

    /**
     * ����������ѯ����ڵ�״̬ͳ����Ϣ
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
   * ɾ��ע��/�������񣨼�Ϊ�˻�ע��/��������add 2005-11-24
   * @param flowID ���̺�
   * @param logNo  ���
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
