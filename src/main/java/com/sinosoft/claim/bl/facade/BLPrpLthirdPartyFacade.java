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
 * ����PrpLthirdParty-���⳵����Ϣ(�޸�)��ҵ�����Facade��<br>
 * ������ 2005-03-18 17:08:12.109<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLthirdPartyFacade extends BLPrpLthirdPartyFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLthirdPartyFacade.class);

    /**
     * ���캯��
     */
    public BLPrpLthirdPartyFacade(){
        super();
    }
    
    
    //modify by wangli add 20050414 start
    /**
     * ���浽 ���⳵����Ϣ��͵��������ı���
     * @param checkDto���Զ�������������ȶ���
     * @throws SQLException
     * @throws Exception
     */
    public void save(CheckDto checkDto,WorkFlowDto workFlowDto) throws SQLException,Exception
    {
      //�������ݿ�������
      DBManager dbManager = new DBManager();
      
      try
      {
          dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
          //��ʼ����
          dbManager.beginTransaction();
        new BLScheduleCertainLossAction().save(dbManager,checkDto);
        
        if(workFlowDto!=null){
        new BLWorkFlowAction().deal(dbManager,workFlowDto);
      }
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
  //modify by wangli add 20050414 end
    
    
}
