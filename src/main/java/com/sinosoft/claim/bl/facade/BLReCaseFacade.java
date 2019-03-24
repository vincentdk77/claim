package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLClaimAction;
import com.sinosoft.claim.bl.action.custom.BLReCaseAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;


/**
 *  ��֤�߼��ַ�
 * <p>Title: �������ⵥ֤</p>
 * <p>Description: �������ⵥ֤facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLReCaseFacade
{
  /*
  public void save(CertifyDto certifyDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLReCaseAction().save(dbManager,certifyDto);
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

 */ 
  public void save( ReCaseDto recaseDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    /*dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction(); */
    try
    {
    	 dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
         //��ʼ����
         dbManager.beginTransaction();
         new BLReCaseAction().save(dbManager,recaseDto);
         //�ؿ��ⰸ
         //new BLClaimAction().updateEndCaseDate(dbManager, recaseDto.getPrpLrecaseDto().getClaimNo(),null);
         //modify by lixiang  start at 2006-6-7
         //reason:Ӧ����ͬһ��������
        if (workFlowDto!=null){
      	  new BLWorkFlowAction().deal(dbManager,workFlowDto);
        }
        //modify by lixiang end at 2006-6-7
        
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

  public void savePrpLrecase(ReCaseDto recaseDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    try
    {
     
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      //��ʼ����
      dbManager.beginTransaction();
      new BLReCaseAction().savePrpLrecase(dbManager,recaseDto);
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
   /*
  public void delete(String certifyNo) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLReCaseAction().delete(dbManager,certifyNo);
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

  */
  public ReCaseDto findByPrimaryKey(String claimNo,int serialNo) throws SQLException,Exception
  {
  	ReCaseDto  reCaseDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
   // dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      reCaseDto = new BLReCaseAction().findByPrimaryKey(dbManager,claimNo,serialNo);
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
    return reCaseDto;
  }

  /*
  public boolean isExist(String certifyNo) throws SQLException,Exception
  {

    boolean exist = false ;
    //�������ݿ�������
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLReCaseAction().isExist(dbManager,certifyNo);
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

  */
  public Collection findByConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     ReCaseDto reCaseDto = null;
     Collection reCaseDtoList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLReCaseAction blReCaseAction = new BLReCaseAction();
       reCaseDtoList = (Collection)blReCaseAction.findByConditions(dbManager,conditions,0,0);
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch (Exception ex) {
       throw ex;
     }
     finally
     {
       dbManager.close();
     }
     return reCaseDtoList;
  }

  /*
  public Collection findByQueryConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection certifyList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLReCaseAction blReCaseAction = new BLReCaseAction();
       certifyList = (Collection)blReCaseAction.findByQueryConditions(dbManager,conditions,0,0);
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch (Exception ex) {
       throw ex;
     }
     finally
     {
       dbManager.close();
     }
     return certifyList;
  }
  */
  public int getMaxSerialNo(String  claimNo)
  throws Exception{

  int serialNo=0;

  DBManager dbManager = new DBManager();
  BLReCaseAction blReCaseAction = new BLReCaseAction();
  try{
      dbManager.open(AppConfig.get("sysconst.DBJNDI"));
      serialNo = blReCaseAction.getMaxSerialNo(dbManager,claimNo);
  }catch(Exception exception){
      throw exception;
  }finally{
      dbManager.close();
  }
  return serialNo;
}

}
