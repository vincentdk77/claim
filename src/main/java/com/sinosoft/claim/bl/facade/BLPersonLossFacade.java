package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.List;

import com.sinosoft.claim.bl.action.custom.BLPersonLossAction;
import com.sinosoft.claim.bl.action.custom.BLPersonLossActionImpl2;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPersonLossFacade {
	public static void initPersonLoss(String configCode,String riskCode,List personLossList,double MedicalLimit,double DeathLimit)throws SQLException,Exception{
	    DBManager dbManager = new DBManager();
	    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	    try
	    {
	    	BLPersonLossAction blPersonLossAction = BLPersonLossActionImpl2.getInstance();
	    	
	    	blPersonLossAction.initPersonLoss(dbManager,configCode,riskCode,personLossList, MedicalLimit, DeathLimit);
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
	}
	
	
	
	
	
}
