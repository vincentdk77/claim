package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.custom.BLWorkFlowModelAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����WorkFlowModel�����������������ҵ�����Facade��<br>
 * ������ 2004-08-09 19:54:55.307<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLWorkFlowModelFacade extends BLWorkFlowModelFacadeBase{
    private static Log logger = LogFactory.getLog(BLWorkFlowModelFacade.class);

    /**
     * ���캯��
     */
    public BLWorkFlowModelFacade(){
        super();
    }

     /**
       * ȡ��ģ���
       * @return scheduleID
       * @throws SQLException
       * @throws Exception
       */
      public int getModelNo() throws SQLException,Exception
      {

        int modelNo =0 ;
        //�������ݿ�������
         DBManager dbManager = new DBManager();
         dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
        try
        {
          modelNo = new BLWorkFlowModelAction().getModelNo(dbManager);
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
          //�ر����ݿ�����
          dbManager.close();
        }
        return modelNo;
      }

}
