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
 * 报案对象Regist
 * <p>Title: 车险理赔样本报案action  </p>
 * <p>Description: 车险理赔样本报案action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UILinkRecordAction
{
  /**
   * 查询联系记录
   * @param conditions：条件
   * @throws Exception
   */
  public Collection PrpLregistExtFindByConditionsCommand(String conditions) throws SQLException,Exception
  {
	  PrpLregistExtFindByConditionsCommand prpLregistExtFindByConditionsCommand = new PrpLregistExtFindByConditionsCommand( conditions);
	  return (Collection)prpLregistExtFindByConditionsCommand.execute();
  }
  
  /**
   * 查询立案
   * @param PrpLclaimDto：赔案对象DTO
   * @throws Exception
   */
  public PrpLclaimDto PrpLclaimFindByPrimaryKeyCommand(String claimNo) throws SQLException,Exception
  {
	  PrpLclaimFindByPrimaryKeyCommand prpLclaimFindByPrimaryKeyCommand = new PrpLclaimFindByPrimaryKeyCommand( claimNo );
	  return (PrpLclaimDto)prpLclaimFindByPrimaryKeyCommand.execute();
  }
  
  
  /**
   * 查询报案
   * @param PrpLregistDto：报案对象DTO
   * @throws Exception
   */
  public PrpLregistDto PrpLregistFindByPrimaryKeyCommand(String registNo) throws SQLException,Exception
  {
	  PrpLregistFindByPrimaryKeyCommand prpLregistFindByPrimaryKeyCommand = new PrpLregistFindByPrimaryKeyCommand( registNo );
	  return (PrpLregistDto)prpLregistFindByPrimaryKeyCommand.execute();
  }  
  /**
   * 查询查勘
   * @param PrpLregistDto：报案对象DTO
   * @throws Exception
   */
  public PrpLcheckDto PrpLcheckFindByPrimaryKeyCommand(String registNo) throws SQLException,Exception
  {
	  PrpLcheckFindByPrimaryKeyCommand prpLregistFindByPrimaryKeyCommand = new PrpLcheckFindByPrimaryKeyCommand( registNo,1 );
	  return (PrpLcheckDto)prpLregistFindByPrimaryKeyCommand.execute();
  }
  
  /**
   * 查询索赔单证
   * @param PrpLdocDto：索赔单证对象DTO
   * @throws Exception
   */
  public PrpLdocDto PrpLdocFindByPrimaryKeyCommand(String claimNo,String docCode) throws SQLException,Exception
  {
	  PrpLdocFindByPrimaryKeyCommand prpLdocFindByPrimaryKeyCommand = new PrpLdocFindByPrimaryKeyCommand( claimNo,docCode);
	  return (PrpLdocDto)prpLdocFindByPrimaryKeyCommand.execute();
  }
  
  /**
   * 查询索赔单证
   * @param Collection：索赔单证对象DTO
   * @throws Exception
   */
  public Collection PrpLdocFindByConditionsCommand(String conditions) throws SQLException,Exception
  {
	  PrpLdocFindByConditionsCommand prpLdocFindByConditionsCommand = new PrpLdocFindByConditionsCommand( conditions);
	  return (Collection)prpLdocFindByConditionsCommand.execute();
  }



}
