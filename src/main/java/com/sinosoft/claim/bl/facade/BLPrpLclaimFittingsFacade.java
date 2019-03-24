package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimFittingsAction;
import com.sinosoft.claim.dto.domain.PrpLclaimFittingsDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimFee-��������ҵ�����Facade��<br>
 * ������ 2005-03-18 17:08:11.937<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimFittingsFacade extends BLPrpLclaimFittingsFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimFittingsFacade.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimFittingsFacade(){
        super();
    }

    /**
     * ����
     * @param Collection fittingsList
     * @throws SQLException
     * @throws Exception
     */
    public void save(Collection fittingsList) throws SQLException,Exception
    {
      //�������ݿ�������
      DBManager dbManager = new DBManager();
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      //��ʼ����
      dbManager.beginTransaction();
      try
      {
        new BLPrpLclaimFittingsAction().save(dbManager,fittingsList);
        //�ύ����
        dbManager.commitTransaction();
      }
      catch(SQLException sqle)
      {
        //�ع�����
        dbManager.rollbackTransaction();
        throw sqle;
      }
      catch(Exception ex)
      {
        //�ع�����
        dbManager.rollbackTransaction();
        throw ex;
      }
      finally
      {
        //�ر����ݿ�����
        dbManager.close();
      }
    }

    /**
     * ����������ѯ������Ϣ
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
         BLPrpLclaimFittingsAction blPrpLclaimFittingsAction = new BLPrpLclaimFittingsAction();
         
         claimFittingsList = blPrpLclaimFittingsAction.findByConditions(dbManager,conditions,0,0);
         
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
