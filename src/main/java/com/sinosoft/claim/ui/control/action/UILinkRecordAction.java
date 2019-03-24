package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLdocDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.ui.model.PrpLcheckFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.PrpLclaimFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.PrpLdocFindByConditionsCommand;
import com.sinosoft.claim.ui.model.PrpLdocFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.PrpLregistExtFindByConditionsCommand;
import com.sinosoft.claim.ui.model.PrpLregistFindByPrimaryKeyCommand;

/**
 * ��������Regist
 * <p>Title: ����������������action  </p>
 * <p>Description: ����������������action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UILinkRecordAction
{
  /**
   * ��ѯ��ϵ��¼
   * @param conditions������
   * @throws Exception
   */
  public Collection PrpLregistExtFindByConditionsCommand(String conditions) throws SQLException,Exception
  {
	  PrpLregistExtFindByConditionsCommand prpLregistExtFindByConditionsCommand = new PrpLregistExtFindByConditionsCommand( conditions);
	  return (Collection)prpLregistExtFindByConditionsCommand.execute();
  }
  
  /**
   * ��ѯ����
   * @param PrpLclaimDto���ⰸ����DTO
   * @throws Exception
   */
  public PrpLclaimDto PrpLclaimFindByPrimaryKeyCommand(String claimNo) throws SQLException,Exception
  {
	  PrpLclaimFindByPrimaryKeyCommand prpLclaimFindByPrimaryKeyCommand = new PrpLclaimFindByPrimaryKeyCommand( claimNo );
	  return (PrpLclaimDto)prpLclaimFindByPrimaryKeyCommand.execute();
  }
  
  
  /**
   * ��ѯ����
   * @param PrpLregistDto����������DTO
   * @throws Exception
   */
  public PrpLregistDto PrpLregistFindByPrimaryKeyCommand(String registNo) throws SQLException,Exception
  {
	  PrpLregistFindByPrimaryKeyCommand prpLregistFindByPrimaryKeyCommand = new PrpLregistFindByPrimaryKeyCommand( registNo );
	  return (PrpLregistDto)prpLregistFindByPrimaryKeyCommand.execute();
  }  
  /**
   * ��ѯ�鿱
   * @param PrpLregistDto����������DTO
   * @throws Exception
   */
  public PrpLcheckDto PrpLcheckFindByPrimaryKeyCommand(String registNo) throws SQLException,Exception
  {
	  PrpLcheckFindByPrimaryKeyCommand prpLregistFindByPrimaryKeyCommand = new PrpLcheckFindByPrimaryKeyCommand( registNo,1 );
	  return (PrpLcheckDto)prpLregistFindByPrimaryKeyCommand.execute();
  }
  
  /**
   * ��ѯ���ⵥ֤
   * @param PrpLdocDto�����ⵥ֤����DTO
   * @throws Exception
   */
  public PrpLdocDto PrpLdocFindByPrimaryKeyCommand(String claimNo,String docCode) throws SQLException,Exception
  {
	  PrpLdocFindByPrimaryKeyCommand prpLdocFindByPrimaryKeyCommand = new PrpLdocFindByPrimaryKeyCommand( claimNo,docCode);
	  return (PrpLdocDto)prpLdocFindByPrimaryKeyCommand.execute();
  }
  
  /**
   * ��ѯ���ⵥ֤
   * @param Collection�����ⵥ֤����DTO
   * @throws Exception
   */
  public Collection PrpLdocFindByConditionsCommand(String conditions) throws SQLException,Exception
  {
	  PrpLdocFindByConditionsCommand prpLdocFindByConditionsCommand = new PrpLdocFindByConditionsCommand( conditions);
	  return (Collection)prpLdocFindByConditionsCommand.execute();
  }



}
