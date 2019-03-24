package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.ui.model.ClaimFittingsSaveCommand;

/**
 * 实赔对象Compensate
 * <p>Title: 车险理赔样本实赔action  </p>
 * <p>Description: 车险理赔样本实赔action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UILClaimFittingsAction
{
  /**
   * 保存实赔
   * @param ClaimFittinsDto：实赔对象DTO
   * @throws Exception
   */
  public void save(Collection fittingsList) throws SQLException,Exception
  {
  	ClaimFittingsSaveCommand claimfittingsSaveCommand = new ClaimFittingsSaveCommand(fittingsList);
  	claimfittingsSaveCommand.execute();
  }
  
} 
