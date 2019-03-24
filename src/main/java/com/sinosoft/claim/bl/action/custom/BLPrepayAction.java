package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.PrepayDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBPrepay;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLprepay;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * Ԥ��action
 * <p>Title: �������� Ԥ��acton</p>
 * <p>Description: �������� Ԥ��acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLPrepayAction
{
  public BLPrepayAction()
  {
  }

  /**
   * ����Ԥ��
   * @param prepayDto���Զ���Ԥ�����
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,PrepayDto prepayDto)
    throws SQLException,Exception
  {
      DBPrepay dbPrepay = null;
      //ҵ�����
      dbPrepay = new DBPrepay();
      //if (this.isExist(prepayDto.getPrpLprepayDto().getPrpLprepayPrepayNo()))
      //{
        //dbPrepay.delete(prepayDto.getPrpLprepayDto().getPrpLprepayPrepayNo());
      //}
      dbPrepay.insert(dbManager,prepayDto);

  }

  /**
   * ɾ��Ԥ��
   * @param  prepayNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String prepayNo)
    throws SQLException,Exception
  {
      //ҵ�����
      new DBPrepay().delete(dbManager,prepayNo);
  }

  /**
   * ���Ԥ��
   * @param  prepayNo
   * @param dbManager  ��������
   * @return �Զ���Ԥ�����
   * @throws SQLException
   * @throws Exception
   */
  public PrepayDto findByPrimaryKey(DBManager dbManager,String prepayNo)
    throws SQLException,Exception
  {
    PrepayDto prepayDto = null;
    prepayDto = new DBPrepay().findByPrimaryKey(dbManager,prepayNo);
    return prepayDto;
  }
  /**
   * �ж�Ԥ��֪ͨ���Ƿ����
   * @param prepayNo
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(DBManager dbManager,String prepayNo)throws SQLException,Exception
  {
     if (new DBPrepay().findByPrimaryKey(dbManager,prepayNo) == null)
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
    DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLprepay.findByQueryConditions(conditions,pageNo,rowsPerPage);
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
  public Collection findByApproveQueryConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
    DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLprepay.findByApproveQueryConditions(conditions,pageNo,rowsPerPage);
    return collection;
  }

  /**
   * ����Ԥ��
   * @param prepayDto���Զ���Ԥ�����
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void approve(DBManager dbManager,String prepayNo,String userCode,String underWriteFlag)
    throws SQLException,Exception
  {
    DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
    dbPrpLprepay.approve(prepayNo,userCode,underWriteFlag);
  }
}
