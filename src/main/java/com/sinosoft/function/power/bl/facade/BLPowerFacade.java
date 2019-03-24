package com.sinosoft.function.power.bl.facade;
/**
 * <p>Title: Ȩ��У��</p>
 * <p>Description: �����Ʒ��Ȩ��У����Facade</p>
 * <p>Copyright: Copyright (c) 2004.11</p>
 * <p>Company: Sinosoft</p>
 * @author �����Ʒ�� κʿ��
 * @version 1.0
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.function.power.bl.action.custom.BLPowerAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPowerFacade extends BLPowerFacadeBase
{
  public BLPowerFacade()
  {
  }

  /**
   * ���ݸ�λ�����񣩼����֣������������ĳ��λ����ԱȨ��
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findByTask(String conditions) throws Exception
  {
    BLPowerAction blPowerAction = new BLPowerAction();
    Collection collection = new ArrayList();
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
      collection = blPowerAction.findByTask(dbManager,conditions);
    }
    catch(Exception e)
    {
      throw e;
    }
    finally {
      dbManager.close();
    }

    return collection;
  }
  
  /**
   * ������Ա��ȡ��Ӧ��˾��������������
   * @param userCode String
   * @param tableName String
   * @throws SQLException
   * @throws Exception
   * @return String
   */
  public String getLocalCom(String userCode,String tableName) throws Exception
  {
    BLPowerAction blPowerAction = new BLPowerAction();
    String conditions = "";
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
      conditions = blPowerAction.getLocalCom(dbManager,userCode,tableName);
    }
    catch(Exception e)
    {
      throw e;
    }
    finally {
      dbManager.close();
    }

    return conditions;
  }

}
