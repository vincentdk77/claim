package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLAcciCheckAction;
import com.sinosoft.claim.bl.action.custom.BLRegistAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLregistAction;
import com.sinosoft.claim.dto.custom.AcciCheckDto;
import com.sinosoft.claim.dto.custom.CaseRelateNodeDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 *  �����߼��ַ�
 * <p>Title: �������ⱨ��</p>
 * <p>Description: �������ⱨ��facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class BLAcciCheckFacade
{
  /**
   * ���汨��
   * @param registDto���Զ��屨������
   * @throws SQLException
   * @throws Exception
   */
  public void save(RegistDto registDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLAcciCheckAction().save(dbManager,registDto);
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
   * ���汨��������������Ĺ���
   * @param registDto���Զ��屨������
   * @throws SQLException
   * @throws Exception
   */
  public void save(RegistDto registDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLRegistAction().save(dbManager,registDto);

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
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String registNo) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLRegistAction().delete(dbManager,registNo);

      //������ɾ��
     new BLWorkFlowAction().deleteByRegistNo(dbManager,registNo);
     //�Żغ���



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
   * ��ñ���
   * @param  registNo
   * @param dbManager  ��������
   * @return �Զ��屨������
   * @throws SQLException
   * @throws Exception
   */
  public AcciCheckDto findByPrimaryKey(String registNo) throws SQLException,Exception
  {
  	AcciCheckDto acciCheckDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
    	acciCheckDto = new BLAcciCheckAction().findByPrimaryKey(dbManager,registNo);
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
    return acciCheckDto;
  }

  /**
   * �жϱ���֪ͨ���Ƿ����
   * @param registNo
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String registNo) throws SQLException,Exception
  {

    boolean exist = false ;
    //�������ݿ�������
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLRegistAction().isExist(dbManager,registNo);
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
     PrpLregistDto prpLregistDto = null;
     Collection registList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       registList = (Collection)blPrpLregistAction.findByConditions(dbManager,conditions);
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
     return registList;
  }

  /**
   * ����������ѯ����������Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
   */
  public Collection findByQueryConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLregistDto prpLregistDto = null;
     Collection registList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLRegistAction blRegistAction = new BLRegistAction();
       registList = (Collection)blRegistAction.findByQueryConditions(dbManager,conditions,0,0);
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
     return registList;
  }

  /**
   * ����������ѯ������Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findSamePolicyRegist(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLregistDto prpLregistDto = null;
     Collection registList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLRegistAction blRegistAction = new BLRegistAction();
       registList = (Collection)blRegistAction.findSamePolicyRegist(dbManager,conditions,0,0);
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
     return registList;
  }

  /**
   * ����������ѯ����������Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
   */
  public Collection getWorkFlowList(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLregistDto prpLregistDto = null;
     Collection registList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLRegistAction blRegistAction = new BLRegistAction();
       registList = (Collection)blRegistAction.getWorkFlowList(dbManager,conditions,0,0);
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
     return registList;
  }

  /**
   * �����صĽڵ���Ϣ
   * @param  registNo
   * @param dbManager  ��������
   * @return �Զ��屨������
   * @throws SQLException
   * @throws Exception
   */
  public CaseRelateNodeDto relateNode(String registNo) throws SQLException,Exception
  {
    CaseRelateNodeDto caseRelateNodeDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      caseRelateNodeDto = new BLRegistAction().relateNode(dbManager,registNo);
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
    return caseRelateNodeDto;
  }

}
