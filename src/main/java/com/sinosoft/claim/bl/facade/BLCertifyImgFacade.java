package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLCertifyImgAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcertifyImgAction;
import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  ��֤ͼƬ�߼��ַ�
 * <p>Title: �������ⵥ֤ͼƬ</p>
 * <p>Description: �������ⵥ֤ͼƬfacade</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author ������Ŀ��
 * @version 1.0
 */
public class BLCertifyImgFacade
{    
  /** 
   * ���浥֤ͼƬ
   * @param certifyImgDto���Զ��嵥֤ͼƬ����
   * @throws SQLException 
   * @throws Exception
   */ 
  public void save(PrpLcertifyImgDto prpLcertifyImgDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
  	try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      //��ʼ����
      dbManager.beginTransaction();  
      new BLCertifyImgAction().save(dbManager,prpLcertifyImgDto);
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
    	ex.printStackTrace();
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
   * ɾ����֤ͼƬ
   * @param  dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(PrpLcertifyImgDto prpLcertifyImgDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    try
    {
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
      new BLCertifyImgAction().delete(dbManager,prpLcertifyImgDto);
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
   * ɾ����֤ͼƬ
   * @param  dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void update(PrpLcertifyImgDto prpLcertifyImgDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    try
    {
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction(); 
      new BLCertifyImgAction().update(dbManager,prpLcertifyImgDto);
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
   * ��õ�֤ͼƬ
   * @param dbManager  ��������
   * @return �Զ��嵥֤ͼƬ����
   * @throws SQLException
   * @throws Exception
   */
  public PrpLcertifyImgDto findByPrimaryKey(PrpLcertifyImgDto prpLcertifyImgDto) throws SQLException,Exception
  {
    PrpLcertifyImgDto prpLcertifyImgDtoTemp = null;
    //�������ݿ������� 
    DBManager dbManager = new DBManager();
    try
    {  
    	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    	prpLcertifyImgDtoTemp = new BLCertifyImgAction().findByPrimaryKey(dbManager,prpLcertifyImgDto);
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
    return prpLcertifyImgDtoTemp;
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
       BLPrpLcertifyImgAction blPrpLcertifyImgAction = new BLPrpLcertifyImgAction();
       certainLossList = (Collection)blPrpLcertifyImgAction.findByConditions(dbManager,conditions);
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
   * �����������µ�֤��Ӱ�����Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   * add by liyanjie 2005-11-04 reason:��֤ɾ������
   */
  public void updateByCondition(String condition) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    try
    {
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction(); 
      new BLCertifyImgAction().updateByCondition(dbManager,condition);
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
 
  //add by zhaolu 20060913 start
  //���ӵ�֤�鿴��ҳ
  public PageRecord findByQueryConditions(String conditions, String pageNo, String recordPerPage)
  throws SQLException, Exception
 {
  DBManager dbManager = new DBManager();
  PageRecord pagerecord;
  try
  {
      dbManager.open(AppConfig.get("sysconst.DBJNDI"));
      BLPrpLcertifyImgAction blPrpLcertifyImgAction = new BLPrpLcertifyImgAction();
      if(pageNo == null || pageNo.trim().length() < 1)
          pageNo = "1";
      pagerecord = blPrpLcertifyImgAction.findByConditions(dbManager, conditions, Integer.parseInt(pageNo), Integer.parseInt(recordPerPage));
  }
  finally
  {
      dbManager.close();
  }
  return pagerecord;
}
  //add by zhaolu 20060913 end
  
  
  
}
