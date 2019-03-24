package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLED_AGENT_INFOAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ������ϯԱ����Ϣ���ҵ�����Facade��<br>
 * ������ 2005-07-19 09:59:06.511<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLED_AGENT_INFOFacade extends BLED_AGENT_INFOFacadeBase{
    private static Log logger = LogFactory.getLog(BLED_AGENT_INFOFacade.class);

    /**
     * ���캯��
     */
    public BLED_AGENT_INFOFacade(){
        super();
    }
    
  /**
   * �ж�Ա�������Ƿ����
   * @param agentid
   * @param password
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String agentid,String password) throws SQLException,Exception
  {

    boolean exist = false;
    
    //�������ݿ�������
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
      //�ر����ݿ�����
      dbManager.close();
    }
    return exist;
  }
  
}
