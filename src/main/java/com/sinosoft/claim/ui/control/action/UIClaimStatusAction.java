package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.ClaimStatusDto;
import com.sinosoft.claim.ui.model.ClaimStatusDeleteCommand;
import com.sinosoft.claim.ui.model.ClaimStatusFindByConCommand;
import com.sinosoft.claim.ui.model.ClaimStatusGetStatCommand;
import com.sinosoft.claim.ui.model.ClaimStatusIsExistCommand;
import com.sinosoft.claim.ui.model.ClaimStatusSaveCommand;
import com.sinosoft.claim.ui.model.PrpLclaimStatusFindByConCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 理赔节点状态对象Claimstatus
 * <p>Title: 车险理赔理赔节点状态  </p>
 * <p>Description: 车险理赔理赔节点状态</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UIClaimStatusAction
{
  /**
   * 保存理赔节点状态
   * @param ClaimStatusDto：理赔节点状态对象DTO
   * @throws Exception
   */
  public void save(ClaimStatusDto claimStatusDto) throws SQLException,Exception
  {
          ClaimStatusSaveCommand claimStatusSaveCommand = new ClaimStatusSaveCommand(claimStatusDto);
          claimStatusSaveCommand.execute();
  }
  /**
   * 删除理赔节点状态
   * @param claimStatusNo：理赔节点状态号
   * @throws Exception
   */
  public void delete(String claimStatusNo,String nodeType,int serialNo) throws SQLException,Exception
  {
    ClaimStatusDeleteCommand claimStatusDeleteCommand = new ClaimStatusDeleteCommand(claimStatusNo,nodeType,serialNo);
          claimStatusDeleteCommand.execute();
  }

  /**
   * 获得理赔节点状态信息
   * @param  claimStatusNo：理赔节点状态号
   * @return 理赔节点状态对象
   * @throws Exception
   */
  public ClaimStatusDto findByPrimaryKey(String claimStatusNo,String nodeType,int serialNo) throws SQLException,UserException,Exception
  {
          ClaimStatusFindByConCommand claimStatusFindByConCommand = new ClaimStatusFindByConCommand(claimStatusNo,nodeType,serialNo);
          ClaimStatusDto claimStatusDto = (ClaimStatusDto)claimStatusFindByConCommand.execute();

    if (claimStatusDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+claimStatusNo+")");
    }
    return claimStatusDto;
  }

  /**
   * 判断理赔节点状态号是否存在
   * @param claimStatusNo:理赔节点状态号
   * @return 是/否
   * @throws Exception
   */
  public boolean isExist(String claimStatusNo,String nodeType,int serialNo) throws SQLException,Exception
  {
          ClaimStatusIsExistCommand claimStatusIsExistCommand = new ClaimStatusIsExistCommand(claimStatusNo,nodeType,serialNo);
          return ((Boolean)claimStatusIsExistCommand.execute()).booleanValue();
  }

  /**
 * 获得理赔节点状信息
 * @param  conditions：查询条件
 * @return 理赔节点状对象
 * @throws Exception
 */

 public Collection findByConditions(String conditions) throws SQLException,Exception
 {
    PrpLclaimStatusFindByConCommand prpLclaimStatusFindByConCommand = new PrpLclaimStatusFindByConCommand(conditions);

    return (Collection)prpLclaimStatusFindByConCommand.execute();
 }

 /**
 * 获得理赔节点统计信息
 * @param  conditions：查询条件
 * @return Collection
 * @throws Exception
 */

 public Collection getStatStatus(String conditions) throws SQLException,Exception
 {
    ClaimStatusGetStatCommand claimStatusGetStatCommand = new ClaimStatusGetStatCommand(conditions);

    return (Collection)claimStatusGetStatCommand.execute();
 }
}
