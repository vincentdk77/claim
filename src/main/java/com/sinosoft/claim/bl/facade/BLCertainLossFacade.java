package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLCertainLossAction;
import com.sinosoft.claim.bl.action.custom.BLCheckAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLverifyLossAction;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  �����߼��ַ�
 * <p>Title: �������ⶨ��</p>
 * <p>Description: �������ⶨ��facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLCertainLossFacade
{
  /**
   * ���涨��
   * @param certainLossDto���Զ��嶨�����
   * @throws SQLException
   * @throws Exception
   */
  public void save(CertainLossDto certainLossDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLCertainLossAction().save(dbManager,certainLossDto);
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
   * ���沢������
   * @param certainLossDto���Զ��嶨�����
   * @throws SQLException
   * @throws Exception
   */
  public void save(ArrayList certainLossDtoList) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
    	for(int i = 0;i < certainLossDtoList.size();i++){
    		new BLCertainLossAction().save(dbManager,(CertainLossDto)certainLossDtoList.get(i));
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
   * ���涨���������
   * @param certainLossDto���Զ��嶨�����
   * @throws SQLException
   * @throws Exception
   */
  public void save(CertainLossDto certainLossDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLCertainLossAction().save(dbManager,certainLossDto);
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
   * ���涨���������
   * @param certainLossDto���Զ��嶨�����
   * @throws SQLException
   * @throws Exception
   */
  public void save(ArrayList certainLossDtoList,ArrayList workFlowDtoList) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
    	for(int i = 0;i < certainLossDtoList.size();i++){
    		new BLCertainLossAction().save(dbManager,(CertainLossDto)certainLossDtoList.get(i));
    	}
    	for(int i = 0;i < workFlowDtoList.size();i++){
		new BLWorkFlowAction().deal(dbManager,(WorkFlowDto)workFlowDtoList.get(i));
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
      new BLCertainLossAction().delete(dbManager,registNo);
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
   * ��ö���
   * @param  registNo
   * @param dbManager  ��������
   * @return �Զ��嶨�����
   * @throws SQLException
   * @throws Exception
   */
  public CertainLossDto findByPrimaryKey(String registNo,String lossItemCode) throws SQLException,Exception
  {
    CertainLossDto certainLossDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      certainLossDto = new BLCertainLossAction().findByPrimaryKey(dbManager,registNo,lossItemCode);
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
    return certainLossDto;
  }

  /**
   * ��ö���
   * @param  registNo
   * @param dbManager  ��������
   * @return �Զ��嶨�����
   * @throws SQLException
   * @throws Exception 
   */
  public CertainLossDto findByPrimaryKey(String registNo) throws SQLException,Exception
  {
    CertainLossDto certainLossDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      certainLossDto = new BLCertainLossAction().findByPrimaryKey(dbManager,registNo);
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
    return certainLossDto;
  }
  /**
   * �ж϶���֪ͨ���Ƿ����
   * @param registNo
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String registNo,String lossItemCode) throws SQLException,Exception
  {

    boolean exist = false ;
    //�������ݿ�������
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLCertainLossAction().isExist(dbManager, registNo,lossItemCode);
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
     Collection certainLossList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLverifyLossAction blPrpLcertainLossAction = new BLPrpLverifyLossAction();
       certainLossList = (Collection)blPrpLcertainLossAction.findByConditions(dbManager,conditions);
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
     return certainLossList;
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
     Collection certainLossList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLCertainLossAction blCertainLossAction = new BLCertainLossAction();
       certainLossList = (Collection)blCertainLossAction.findByQueryConditions(dbManager,conditions,0,0);
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
     return certainLossList;
  }

  /**
   * ���涨���������
   * @param certainLossDto���Զ��嶨�����
   * @throws SQLException
   * @throws Exception
   */
  public void save(CertainLossDto certainLossDto,CheckDto checkDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLCertainLossAction().save(dbManager,certainLossDto);

      new BLCheckAction().save(dbManager,checkDto);

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
   * ���涨���������
   * @param certainLossDto���Զ��嶨�����
   * @throws SQLException
   * @throws Exception
   */
  public void save(CertainLossDto certainLossDto,CheckDto checkDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLCertainLossAction().save(dbManager,certainLossDto);
        new BLWorkFlowAction().deal(dbManager,workFlowDto);
        new BLCheckAction().save(dbManager,checkDto);
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
  
  //add by zhaolu 20060803 start
  public PageRecord findByCondition(String conditions,int pageNo,int recordPerPage) throws Exception
  {
	  DBManager dbManager = new DBManager();
		//PrpLpolicyDto prpLpolicyDto = null;
		PageRecord pageRecord = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLCertainLossAction blCertainLossAction = new BLCertainLossAction();
			pageRecord = (PageRecord) blCertainLossAction.findByCondition(
					dbManager, conditions,pageNo,recordPerPage);
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
