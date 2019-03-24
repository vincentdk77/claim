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
 *  实赔逻辑分发
 * <p>Title: 车险理赔实赔</p>
 * <p>Description: 车险理赔实赔facade</p>
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
    //创建数据库管理对象
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
      //关闭数据库连接
      dbManager.close();
    }
    return personls;
  }

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
	  Collection personls = null;
    //创建数据库管理对象
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
      //关闭数据库连接
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
   * 山东意外险理赔风险查询方法
   * @param conditions
   * @return
   * @throws SQLException
   * @throws Exception
   */
  public Collection findByConditionsOfSDacci(String registNo,String credentialType) throws SQLException,Exception
  {
	  Collection personls = null;
    //创建数据库管理对象
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
      //关闭数据库连接
      dbManager.close();
    }
    return personls;
  }
  
}
