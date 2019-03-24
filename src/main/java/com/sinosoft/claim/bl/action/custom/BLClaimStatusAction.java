package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ClaimStatusDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBClaimStatus;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����ڵ�״̬action
 * <p>Title: �������� ����ڵ�״̬acton</p>
 * <p>Description: �������� ����ڵ�״̬acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLClaimStatusAction
{
  public BLClaimStatusAction()
  {
  }

  /**
   * ��������ڵ�״̬
   * @param claimStatusDto���Զ�������ڵ�״̬����
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,ClaimStatusDto claimStatusDto)
    throws SQLException,Exception
  {
      DBClaimStatus dbClaimStatus = null;
      //ҵ�����
      dbClaimStatus = new DBClaimStatus();
      //if (this.isExist(claimStatusDto.getPrpLclaimStatusDto().getPrpLclaimStatusClaimStatusNo()))
      //{
        //dbClaimStatus.delete(claimStatusDto.getPrpLclaimStatusDto().getPrpLclaimStatusClaimStatusNo());
      //}
      dbClaimStatus.insert(dbManager,claimStatusDto);

  }

  /**
   * ɾ������ڵ�״̬
   * @param  claimStatusNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String claimStatusNo,String nodeType,int serialNo)
    throws SQLException,Exception
  {
      //ҵ�����
      new DBClaimStatus().delete(dbManager,claimStatusNo,nodeType,serialNo);
  }

  /**
   * �������ڵ�״̬
   * @param  claimStatusNo
   * @param dbManager  ��������
   * @return �Զ�������ڵ�״̬����
   * @throws SQLException
   * @throws Exception
   */
  public ClaimStatusDto findByPrimaryKey(DBManager dbManager,String claimStatusNo,String nodeType,int serialNo)
    throws SQLException,Exception
  {
    ClaimStatusDto claimStatusDto = null;
    claimStatusDto = new DBClaimStatus().findByPrimaryKey(dbManager,claimStatusNo,nodeType,serialNo);
    return claimStatusDto;
  }
  /**
   * �ж�����ڵ�״̬���Ƿ����
   * @param claimStatusNo
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(DBManager dbManager,String claimStatusNo,String nodeType,int serialNo)throws SQLException,Exception
  {
     if (new DBClaimStatus().findByPrimaryKey(dbManager,claimStatusNo,nodeType,serialNo) == null)
      {
        return false;
      }else
      {
        return true;
      }
  }

}
