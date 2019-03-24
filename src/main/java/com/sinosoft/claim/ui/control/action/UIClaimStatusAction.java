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
 * ����ڵ�״̬����Claimstatus
 * <p>Title: ������������ڵ�״̬  </p>
 * <p>Description: ������������ڵ�״̬</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UIClaimStatusAction
{
  /**
   * ��������ڵ�״̬
   * @param ClaimStatusDto������ڵ�״̬����DTO
   * @throws Exception
   */
  public void save(ClaimStatusDto claimStatusDto) throws SQLException,Exception
  {
          ClaimStatusSaveCommand claimStatusSaveCommand = new ClaimStatusSaveCommand(claimStatusDto);
          claimStatusSaveCommand.execute();
  }
  /**
   * ɾ������ڵ�״̬
   * @param claimStatusNo������ڵ�״̬��
   * @throws Exception
   */
  public void delete(String claimStatusNo,String nodeType,int serialNo) throws SQLException,Exception
  {
    ClaimStatusDeleteCommand claimStatusDeleteCommand = new ClaimStatusDeleteCommand(claimStatusNo,nodeType,serialNo);
          claimStatusDeleteCommand.execute();
  }

  /**
   * �������ڵ�״̬��Ϣ
   * @param  claimStatusNo������ڵ�״̬��
   * @return ����ڵ�״̬����
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
   * �ж�����ڵ�״̬���Ƿ����
   * @param claimStatusNo:����ڵ�״̬��
   * @return ��/��
   * @throws Exception
   */
  public boolean isExist(String claimStatusNo,String nodeType,int serialNo) throws SQLException,Exception
  {
          ClaimStatusIsExistCommand claimStatusIsExistCommand = new ClaimStatusIsExistCommand(claimStatusNo,nodeType,serialNo);
          return ((Boolean)claimStatusIsExistCommand.execute()).booleanValue();
  }

  /**
 * �������ڵ�״��Ϣ
 * @param  conditions����ѯ����
 * @return ����ڵ�״����
 * @throws Exception
 */

 public Collection findByConditions(String conditions) throws SQLException,Exception
 {
    PrpLclaimStatusFindByConCommand prpLclaimStatusFindByConCommand = new PrpLclaimStatusFindByConCommand(conditions);

    return (Collection)prpLclaimStatusFindByConCommand.execute();
 }

 /**
 * �������ڵ�ͳ����Ϣ
 * @param  conditions����ѯ����
 * @return Collection
 * @throws Exception
 */

 public Collection getStatStatus(String conditions) throws SQLException,Exception
 {
    ClaimStatusGetStatCommand claimStatusGetStatCommand = new ClaimStatusGetStatCommand(conditions);

    return (Collection)claimStatusGetStatCommand.execute();
 }
}
