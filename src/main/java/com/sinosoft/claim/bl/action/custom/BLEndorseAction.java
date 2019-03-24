package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.EndorseDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBEndorse;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPhead;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����߼�
 * <p>Title: ����������������</p>
 * <p>Description: ��������������������action</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author ����������Ŀ��
 * @version 1.0
 */
public class BLEndorseAction
{
  public BLEndorseAction()
  {
  }
  /**
   * �������
   * @param EndorseNoticeNo
   * @return �Զ�����������
   * @throws SQLException
   * @throws Exception
   */
  public EndorseDto findByPrimaryKey(DBManager dbManager,String endorseNo)
    throws SQLException,Exception
  {
    EndorseDto endorseDto = null;

      endorseDto = new DBEndorse().findByPrimaryKey(dbManager,endorseNo);
      return endorseDto;
  }
  /**
   * �������
   * @param EndorseNoticeNo
   * @return �Զ�����������
   * @throws SQLException
   * @throws Exception
   */
  public EndorseDto findByConditions(DBManager dbManager,String policyNo)
    throws SQLException,Exception
  {
    EndorseDto endorseDto = null;

      endorseDto = new DBEndorse().findByConditions(dbManager,policyNo);
      return endorseDto;
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
  public Collection findByPrpPheadConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
    DBPrpPhead dbPrpPhead = new DBPrpPhead(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }
    collection = dbPrpPhead.findByConditions(conditions,pageNo,rowsPerPage);
    return collection;
  }

}
