package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLVerifyLossAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLverifyLossAction;
import com.sinosoft.claim.dto.custom.VerifyLossDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;


/**
 *  �����߼��ַ�
 * <p>Title: �����������</p>
 * <p>Description: �����������facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLVerifyLossFacade
{
  /**
   * �������
   * @param verifyLossDto���Զ���������
   * @throws SQLException
   * @throws Exception
   */
  public void save(VerifyLossDto verifyLossDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLVerifyLossAction().save(dbManager,verifyLossDto);
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
   * ��������������
   * @param verifyLossDto���Զ���������
   * @throws SQLException
   * @throws Exception
   */
  public void save(VerifyLossDto verifyLossDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLVerifyLossAction().save(dbManager,verifyLossDto);
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

  /**
   * ɾ������
   * @param  registNo
   * @param  nodeType
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String registNo,String nodeType) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLVerifyLossAction().delete(dbManager,registNo,nodeType);
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
   * ��ú���
   * @param  registNo
   * @param dbManager  ��������
   * @return �Զ���������
   * @throws SQLException
   * @throws Exception
   */
  public VerifyLossDto findByPrimaryKey(String registNo,String lossItemCode,String nodeType) throws SQLException,Exception
  {
    VerifyLossDto verifyLossDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      verifyLossDto = new BLVerifyLossAction().findByPrimaryKey(dbManager,registNo,lossItemCode,nodeType);
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
    return verifyLossDto;
  }

  /**
   * �жϺ���֪ͨ���Ƿ����
   * @param registNo
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String registNo,String lossItemCode,String nodeType) throws SQLException,Exception
  {

    boolean exist = false ;
    //�������ݿ�������
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLVerifyLossAction().isExist(dbManager,registNo,lossItemCode,nodeType);
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

  /**
   * ����������ѯ����������Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findByConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection verifyLossList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLverifyLossAction blPrpLverifyLossAction = new BLPrpLverifyLossAction();
       verifyLossList = (Collection)blPrpLverifyLossAction.findByConditions(dbManager,conditions);
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
     return verifyLossList;
  }

  /**
   * ����������ѯ����������Ϣ
   * @param conditions String
   * @param nodeType String
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
   */
  public Collection findByQueryConditions(String conditions,String nodeType) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection verifyLossList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLVerifyLossAction blVerifyLossAction = new BLVerifyLossAction();
       verifyLossList = (Collection)blVerifyLossAction.findByQueryConditions(dbManager,conditions,nodeType,0,0);
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
     return verifyLossList;
  }

  /**
   * ��ú���
   * @param  registNo
   * @param dbManager  ��������
   * @return �Զ���������
   * @throws SQLException
   * @throws Exception
   */
  /*
  public VerifyLossDto findByPrimaryKey(String registNo,String serialNo) throws SQLException,Exception
  {
    VerifyLossDto verifyLossDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      verifyLossDto = new BLVerifyLossAction().findByPrimaryKey(dbManager,registNo,serialNo);
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
    return verifyLossDto;
  }
  */
  
  //add by zhaolu 20060803 start
  public PageRecord findByCondition(String conditions,String nodeType,int pageNo,int recordPerPage) throws Exception
  {
	   DBManager dbManager = new DBManager();
		//PrpLpolicyDto prpLpolicyDto = null;
		PageRecord pageRecord = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLVerifyLossAction blVerifyLossAction = new BLVerifyLossAction();
			pageRecord = (PageRecord) blVerifyLossAction.findByCondition(
					dbManager, conditions,nodeType,pageNo,recordPerPage);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return pageRecord;
  }
  //add by zhaolu 20060803 end 
  
  
}
