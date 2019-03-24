package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;

import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormInterfaceAction;
import com.sinosoft.claimciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.claimciplatform.dto.custom.CompelCrashArgDto;
import com.sinosoft.claimciplatform.dto.custom.CompelCrashDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLImpelCrashFacade {
	
	public CompelCrashDto downLoad(String uploadType,CompelCrashArgDto compelCrashArgDto) throws SQLException,Exception
	  {
	    //创建数据库管理对象
	    DBManager dbManager = new DBManager();
	    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	    //开始事务
	    dbManager.beginTransaction();
	    try
	    {
	    CompelCrashDto compelCrashDto=(CompelCrashDto)BLCIClaimPlatFormInterfaceAction.getInstance().DownLoadCompelCrashRecord(dbManager,uploadType,compelCrashArgDto);
	   //提交事务
	    dbManager.commitTransaction();
	      return compelCrashDto;
	    }
	    catch(SQLException sqle)
	    {
	      //回滚事务
	      dbManager.rollbackTransaction();
	      throw sqle;
	    }
	    catch(Exception ex)
	    {
	      //回滚事务
	      dbManager.rollbackTransaction();
	      throw ex;
	    }
	    finally
	    {
	      //关闭数据库连接
	      dbManager.close();
	    }
	  }
	public  ClaimCiPlatFormException upLoad(String requestType,CompelCrashDto compelCrashDto) throws SQLException,Exception {
		//创建数据库管理对象
	    DBManager dbManager = new DBManager();
	    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	    //开始事务
	    dbManager.beginTransaction();
	    try
	    {
	      //接口
	      //提交事务

	    ClaimCiPlatFormException claimCiPlatFormException=BLCIClaimPlatFormInterfaceAction.getInstance().uploadCompelCrashRecord(dbManager,requestType,compelCrashDto);
	    dbManager.commitTransaction();
	     return claimCiPlatFormException;
	    }
	    catch(SQLException sqle)
	    {
	      //回滚事务
	      dbManager.rollbackTransaction();
	      throw sqle;
	    }
	    catch(Exception ex)
	    {
	      //回滚事务
	      dbManager.rollbackTransaction();
	      throw ex;
	    }
	    finally
	    {
	      //关闭数据库连接
	      dbManager.close();
	    }
	}
	
	
	
}
