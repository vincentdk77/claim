package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.BackVisitDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBBackVisit;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �ط�action
 * <p>Title: �������� �ط�acton</p>
 * <p>Description: �������� �ط�acton</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author ������Ŀ��
 * @version 1.0
 */
public class BLBackVisitAction
{
  public BLBackVisitAction()
  {
  }

  /**
   * ����ط�
   * @param backVisitDto���Զ���طö���
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,BackVisitDto backVisitDto)
    throws SQLException,Exception
  {
      DBBackVisit dbBackVisit = new DBBackVisit();
      dbBackVisit.insert(dbManager,backVisitDto);
  }

  /**
   * ɾ���طö���
   * @param  backVisitNo
   * @param  registNo
   * @param  backVisitType
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,int backVisitNo,String registNo,String backVisitType)
    throws SQLException,Exception
  {
      new DBBackVisit().delete(dbManager,backVisitNo,registNo,backVisitType);
  }

  /**
   * ��ûطö���
   * @param  backVisitNo
   * @param  registNo
   * @param  backVisitType
   * @param  dbManager  ��������
   * @return �Զ���طö���
   * @throws SQLException
   * @throws Exception
   */
  public BackVisitDto findByPrimaryKey(DBManager dbManager,int backVisitNo,String registNo,String backVisitType)
    throws SQLException,Exception
  {
    BackVisitDto backVisitDto = null;
    backVisitDto = new DBBackVisit().findByPrimaryKey(dbManager,backVisitNo,registNo,backVisitType);
    return backVisitDto;
  }

}
