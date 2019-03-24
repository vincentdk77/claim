package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.AcciCheckDto;
import com.sinosoft.claim.dto.custom.CaseRelateNodeDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBAcciCheck;
import com.sinosoft.claim.resource.dtofactory.custom.DBRegist;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
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
public class BLAcciCheckAction
{
  public BLAcciCheckAction()
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
  public AcciCheckDto findByPrimaryKey(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
  	AcciCheckDto acciCheckDto = null;
  	acciCheckDto = new DBAcciCheck().findByPrimaryKey(dbManager,registNo);
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

}
