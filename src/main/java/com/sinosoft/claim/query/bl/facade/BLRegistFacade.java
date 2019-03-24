package com.sinosoft.claim.query.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLPolicyAction;
import com.sinosoft.claim.bl.action.custom.BLRegistAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLregistAction;
import com.sinosoft.claim.bl.action.domain.BLSwfLogAction;
import com.sinosoft.claim.dto.custom.CaseRelateNodeDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.query.util.Constant;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
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
public class BLRegistFacade
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
      new BLRegistAction().save(dbManager,registDto);
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
  public RegistDto findByPrimaryKey(String registNo) throws SQLException,Exception
  {
    RegistDto registDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    //dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    dbManager.open(Constant.QUERY_DATA_SOURCE) ;
    try
    {
      registDto = new BLRegistAction().findByPrimaryKey(dbManager,registNo);
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
    return registDto;
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
   * ���ݱ����Ų�ѯ����������Ϣ
   * @param policyno ������
   * @throws Exception
   * @return Collection
   */
  public Collection findByPolicyno(String policyno) throws Exception
  {
	  DBManager dbManager = new DBManager();
	  Collection registList = new ArrayList();
	  try
	  {
		  dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;	     
		  String conditions = "policyno = '"+policyno+"' order by reportDate,reportHour";
		  registList = (Collection)(new BLRegistAction().findByQueryConditions(dbManager,conditions,0,0));
	  }
	  catch(SQLException sqle){
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
   * ����������ѯ����������Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
   */
  public PageRecord findByQueryConditions(String conditions,String pageNo,String recordPerPage) throws Exception
  {
     DBManager dbManager = new DBManager();
     PageRecord pageRecord = null;
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLRegistAction blRegistAction = new BLRegistAction();
       //modify by zhaolu 20060801 start
       pageRecord = (PageRecord)blRegistAction.findForRegistConditions(dbManager,conditions,Integer.parseInt(DataUtils.nullToZero(pageNo)) ,Integer.parseInt(DataUtils.nullToZero(recordPerPage)));
       //modify by zhaolu 20060801 end
     } 
     catch(SQLException sqle)
     {
     	sqle.printStackTrace();
       throw sqle;
     }
     catch (Exception ex) {
     	ex.printStackTrace();
       throw ex;
     }
     finally
     {
       dbManager.close();
     }
     return pageRecord; 
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

  
  /**
   * ���汨��ע����Ϣ������������Ĺ���
   * @param registDto���Զ��屨������
   * @param workFlowDto������������
   * @throws SQLException
   * @throws Exception
   */
  public void saveRegistCancel(RegistDto registDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLRegistAction().saveRegistCancel(dbManager,registDto);

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
	 * ���ݱ����Ż����Ӧ������Ϣ
	 * @param registNO
	 * @return GYIC ��ֲ������
	 * @throws SQLException
	 * @throws Exception
	 */
	public Collection findForPrpLclaimConditions(String strPolicyNo
			) throws SQLException, Exception {
		Collection collection=null;
		// �������ݿ�������

		DBManager dbManager = new DBManager();
		
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			collection = new BLRegistAction().findForPrpLclaimConditions(dbManager,strPolicyNo);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			// �ر����ݿ�����
			dbManager.close();
		}
		return collection;
	}

}


  

