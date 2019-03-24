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
	    //�������ݿ�������
	    DBManager dbManager = new DBManager();
	    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	    //��ʼ����
	    dbManager.beginTransaction();
	    try
	    {
	    CompelCrashDto compelCrashDto=(CompelCrashDto)BLCIClaimPlatFormInterfaceAction.getInstance().DownLoadCompelCrashRecord(dbManager,uploadType,compelCrashArgDto);
	   //�ύ����
	    dbManager.commitTransaction();
	      return compelCrashDto;
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
	public  ClaimCiPlatFormException upLoad(String requestType,CompelCrashDto compelCrashDto) throws SQLException,Exception {
		//�������ݿ�������
	    DBManager dbManager = new DBManager();
	    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	    //��ʼ����
	    dbManager.beginTransaction();
	    try
	    {
	      //�ӿ�
	      //�ύ����

	    ClaimCiPlatFormException claimCiPlatFormException=BLCIClaimPlatFormInterfaceAction.getInstance().uploadCompelCrashRecord(dbManager,requestType,compelCrashDto);
	    dbManager.commitTransaction();
	     return claimCiPlatFormException;
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
	
	
	
}
