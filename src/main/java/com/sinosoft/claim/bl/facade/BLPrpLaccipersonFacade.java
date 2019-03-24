package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.*;
import com.sinosoft.sysframework.reference.*;
import com.sinosoft.claim.bl.action.custom.BLCompensateAction;
import com.sinosoft.claim.bl.action.custom.BLPolicyAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcompensateAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLlossAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpersonLossAction;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.CompensateFeeDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciPerson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
/**
 *  ʵ���߼��ַ�
 * <p>Title: ��������ʵ��</p>
 * <p>Description: ��������ʵ��facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLPrpLaccipersonFacade
{


  


  public Collection findByCompensateNo(String compensateNo) throws SQLException,Exception
  {
	  Collection personls = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {      String conditions = "certino='"+compensateNo+"' and CertiType = '04'";
    	   personls= new DBPrpLacciPerson(dbManager).findByConditions(conditions);
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
    return personls;
  }

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
	  Collection personls = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {      
    	   personls= new DBPrpLacciPerson(dbManager).findByConditions(conditions);
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
    return personls;
  }
 
  
  public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
	  Collection personls = null;
	  
      DBPrpLacciPerson dbPrpLacciPerson = new DBPrpLacciPerson(dbManager);
      personls = dbPrpLacciPerson.findByConditions(conditions);
      
      return personls;
  }
  
  /**
   * ɽ��������������ղ�ѯ����
   * @param conditions
   * @return
   * @throws SQLException
   * @throws Exception
   */
  public Collection findByConditionsOfSDacci(String registNo,String credentialType) throws SQLException,Exception
  {
	  Collection personls = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {      
    	   personls= new DBPrpLacciPerson(dbManager).findByConditionsOfSDacci(registNo, credentialType);
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
    return personls;
  }
  
}
