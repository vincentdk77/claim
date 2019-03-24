package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ClaimStatusDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBClaimStatus;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 理赔节点状态action
 * <p>Title: 车险理赔 理赔节点状态acton</p>
 * <p>Description: 车险理赔 理赔节点状态acton</p>
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
   * 保存理赔节点状态
   * @param claimStatusDto：自定义理赔节点状态对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,ClaimStatusDto claimStatusDto)
    throws SQLException,Exception
  {
      DBClaimStatus dbClaimStatus = null;
      //业务操作
      dbClaimStatus = new DBClaimStatus();
      //if (this.isExist(claimStatusDto.getPrpLclaimStatusDto().getPrpLclaimStatusClaimStatusNo()))
      //{
        //dbClaimStatus.delete(claimStatusDto.getPrpLclaimStatusDto().getPrpLclaimStatusClaimStatusNo());
      //}
      dbClaimStatus.insert(dbManager,claimStatusDto);

  }

  /**
   * 删除理赔节点状态
   * @param  claimStatusNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String claimStatusNo,String nodeType,int serialNo)
    throws SQLException,Exception
  {
      //业务操作
      new DBClaimStatus().delete(dbManager,claimStatusNo,nodeType,serialNo);
  }

  /**
   * 获得理赔节点状态
   * @param  claimStatusNo
   * @param dbManager  数据连接
   * @return 自定义理赔节点状态对象
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
   * 判断理赔节点状态号是否存在
   * @param claimStatusNo
   * @param dbManager  数据连接
   * @return 是/否
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
