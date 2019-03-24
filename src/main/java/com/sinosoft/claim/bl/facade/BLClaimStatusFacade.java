package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLClaimStatusAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimStatusAction;
import com.sinosoft.claim.dto.custom.ClaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  ����ڵ�״̬�߼��ַ�
 * <p>Title: ������������ڵ�״̬</p>
 * <p>Description: ������������ڵ�״̬facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLClaimStatusFacade
{
  /**
   * ��������ڵ�״̬
   * @param claimStatusDto���Զ�������ڵ�״̬����
   * @throws SQLException
   * @throws Exception
   */
  public void save(ClaimStatusDto claimStatusDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLClaimStatusAction().save(dbManager,claimStatusDto);
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
   * ɾ������ڵ�״̬
   * @param  claimStatusNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String claimStatusNo,String nodeType,int serialNo) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLClaimStatusAction().delete(dbManager,claimStatusNo,nodeType,serialNo);
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
   * �������ڵ�״̬
   * @param  claimStatusNo
   * @param dbManager  ��������
   * @return �Զ�������ڵ�״̬����
   * @throws SQLException
   * @throws Exception
   */
  public ClaimStatusDto findByPrimaryKey(String claimStatusNo,String nodeType,int serialNo) throws SQLException,Exception
  {
    ClaimStatusDto claimStatusDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      claimStatusDto = new BLClaimStatusAction().findByPrimaryKey(dbManager,claimStatusNo,nodeType,serialNo);
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
    return claimStatusDto;
  }

  /**
   * �ж�����ڵ�״̬֪ͨ���Ƿ����
   * @param claimStatusNo
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String claimStatusNo,String nodeType,int serialNo) throws SQLException,Exception
  {

    boolean exist = false ;
    //�������ݿ�������
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLClaimStatusAction().isExist(dbManager,claimStatusNo,nodeType,serialNo);
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
   * ����������ѯ����ڵ�״̬����Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findByConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLclaimStatusDto prpLclaimStatusDto = null;
     Collection claimStatusList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLclaimStatusAction blPrpLclaimStatusAction = new BLPrpLclaimStatusAction();
       claimStatusList = (Collection)blPrpLclaimStatusAction.findByConditions(dbManager,conditions,0,0);
       /*
       String driverName = "oracle.jdbc.driver.OracleDriver";

      Class.forName(driverName).newInstance();
       String url="jdbc:oracle:thin:@192.168.60.12:1521:ccicdb";
       Connection c= DriverManager.getConnection(url , "claim" , "claim");
       java.sql.DatabaseMetaData d = c.getMetaData();
java.sql.Statement s = c.createStatement();
java.sql.ResultSet rs = s.executeQuery("select count(*) from prplclaimstatus");
       while(rs.next()){
       }
       */
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
     return claimStatusList;
  }


  /**
   * ����������ѯ����ڵ�״̬ͳ����Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection getStatStatus(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLclaimStatusDto prpLclaimStatusDto = null;
     Collection claimStatusList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLclaimStatusAction blPrpLclaimStatusAction = new BLPrpLclaimStatusAction();
       claimStatusList = (Collection)blPrpLclaimStatusAction.getStatStatus(dbManager,conditions);
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
     return claimStatusList;
  }

}
