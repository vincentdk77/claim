package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.dto.custom.CaseRelateNodeDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBRegist;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaim;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLog;
import com.sinosoft.prpall.blsvr.lp.BLPrpLclaim;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����action
 * <p>Title: �������� ����acton</p>
 * <p>Description: �������� ����acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class BLRegistAction
{
  public BLRegistAction()
  {
  }

  /**
   * ���汨��
   * @param registDto���Զ��屨������
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,RegistDto registDto)
    throws SQLException,Exception
  {
      DBRegist dbRegist = null;
      //ҵ�����
      dbRegist = new DBRegist();
      if (this.isExist(dbManager,registDto.getPrpLregistDto().getRegistNo()))
      {
        dbRegist.delete(dbManager,registDto.getPrpLregistDto().getRegistNo());
      }
      dbRegist.insert(dbManager,registDto);

  }

  /**
   * ɾ������
   * @param  registNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
      //ҵ�����
     new DBRegist().delete(dbManager,registNo);


  }

  /**
   * ��ñ���
   * @param  registNo
   * @param dbManager  ��������
   * @return �Զ��屨������
   * @throws SQLException
   * @throws Exception
   */
  public RegistDto findByPrimaryKey(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
    RegistDto registDto = null;
    registDto = new DBRegist().findByPrimaryKey(dbManager,registNo);
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
  public boolean isExist(DBManager dbManager,String registNo)throws SQLException,Exception
  {   DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
      String strSql ="registNo='"+ registNo+"'";
      if(dbPrpLregist.getCount(strSql)<1)
      //     if (new DBPrpLregist().getCount(dbManager,registNo) == null)
      {
        return false;
      }else
      {
        return true;
      }
  }


  /**
   * ��������ѯ��������
   * @param dbManager DBManager
   * @param conditions String
   * @param pageNo int
   * @param rowsPerPage int
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
   */
  public Collection findByQueryConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
    DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLregist.findByQueryConditions(conditions,pageNo,rowsPerPage);
    return collection;
  }

  /**
   * ��������ѯ��������
   * @param dbManager DBManager
   * @param conditions String
   * @param pageNo int
   * @param rowsPerPage int
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
   */
  public Collection findSamePolicyRegist(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
    DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLregist.findSamePolicyRegist(conditions,pageNo,rowsPerPage);
    return collection;
  }

  /**
   * ��������ѯ��������
   * @param dbManager DBManager
   * @param conditions String
   * @param pageNo int
   * @param rowsPerPage int
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
   */
  public Collection getWorkFlowList(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
    DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLregist.getWorkFlowList(conditions,pageNo,rowsPerPage);
    return collection;
  }

  /**
   * �����صĽڵ���Ϣ
   * @param  registNo
   * @param dbManager  ��������
   * @return �Զ��屨������
   * @throws SQLException
   * @throws Exception
   */
  public CaseRelateNodeDto relateNode(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
    CaseRelateNodeDto raseRelateNodeDto = null;
    raseRelateNodeDto = new DBRegist().relateNode(dbManager,registNo);
    return raseRelateNodeDto;
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
   * ���汨��ע����Ϣ
   * @param registDto���Զ��屨������
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void saveRegistCancel(DBManager dbManager,RegistDto registDto)
    throws SQLException,Exception
  {
      DBRegist dbRegist = null;
      //ҵ�����
      dbRegist = new DBRegist();
      dbRegist.insertRegistCancel(dbManager,registDto);
  }
  
  

	//add by zhaolu 20060801 start
   //��������ѯ��������
  public PageRecord findForRegistConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
		DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
		Collection collection = new ArrayList();
		
		if(conditions.trim().length()==0){
			conditions = "1=1";
		}
		collection = dbPrpLregist.findByQueryConditions(conditions,pageNo,rowsPerPage);
		int count = dbPrpLregist.getCount1(SqlUtils.getWherePartForGetCount(conditions));
		int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
		if(maxQueryCount!=0&&count>maxQueryCount){   
	      throw new UserException(1,3,"0000","��ѯ�����������ϵͳ����"); 
	    }
		PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
		return pageRecord;
  }
  // add by zhaolu 20060801 end
  

  /**
   * ������ع����ѯ�ñ����Ƿ��з��������ı�����
   * @param registDto���Զ��屨������
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public Collection findForPrpLclaimConditions(DBManager dbManager,String strPolicyNo)
    throws SQLException,Exception{
	  DBPrpLregist dbPrpLregist = new DBPrpLregist(dbManager);
      Collection collection = new ArrayList();
      String strSql =  strPolicyNo;
      collection = dbPrpLregist.findByQueryConditionsForPolicyno(strSql,0,0);
      return collection;
  }
}

  

