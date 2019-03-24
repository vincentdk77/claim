package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBEndcase;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcaseNo;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �᰸action
 * <p>Title: �������� �᰸acton</p>
 * <p>Description: �������� �᰸acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLEndcaseAction
{
  public BLEndcaseAction()
  {
  }

  /**
   * ����᰸
   * @param endcaseDto���Զ���᰸����
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,EndcaseDto endcaseDto)
    throws SQLException,Exception
  {
      DBEndcase dbEndcase = null;
      //ҵ�����
      dbEndcase = new DBEndcase();
      dbEndcase.insert(dbManager,endcaseDto);
  }

  /**
   * ɾ���᰸
   * @param  caseNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String caseNo)
    throws SQLException,Exception
  {
      //ҵ�����
      new DBEndcase().delete(dbManager,caseNo);
  }

  /**
   * ��ý᰸
   * @param  caseNo
   * @param dbManager  ��������
   * @return �Զ���᰸����
   * @throws SQLException
   * @throws Exception
   */
  public EndcaseDto findByPrimaryKey(DBManager dbManager,String caseNo,String claimNo,String certiNo,String certiType)
    throws SQLException,Exception
  {
    EndcaseDto endcaseDto = null;
    endcaseDto = new DBEndcase().findByPrimaryKey(dbManager,caseNo,claimNo,certiNo,certiType);
    return endcaseDto;
  }
  /**
   * ��ý᰸
   * @param dbManager  ��������
   * @return �Զ���᰸����
   * @throws SQLException
   * @throws Exception
   */
  public EndcaseDto findByPrimaryKey(DBManager dbManager,String claimNo)
    throws SQLException,Exception
  {
    EndcaseDto endcaseDto = null;
    endcaseDto = new DBEndcase().findByPrimaryKey(dbManager,claimNo);
    return endcaseDto;
  }
  /**
   * �жϽ᰸���Ƿ����
   * @param caseNo
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(DBManager dbManager,String caseNo,String claimNo,String certiNo,String certiType) throws SQLException,Exception
  {
    if (new DBEndcase().findByPrimaryKey(dbManager,caseNo,claimNo,certiNo,certiType) == null)
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
    DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLcaseNo.findByQueryConditions(conditions,pageNo,rowsPerPage);
    return collection;
}

}
