package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.ui.model.ClaimFittingsSaveCommand;

/**
 * ʵ�����Compensate
 * <p>Title: ������������ʵ��action  </p>
 * <p>Description: ������������ʵ��action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UILClaimFittingsAction
{
  /**
   * ����ʵ��
   * @param ClaimFittinsDto��ʵ�����DTO
   * @throws Exception
   */
  public void save(Collection fittingsList) throws SQLException,Exception
  {
  	ClaimFittingsSaveCommand claimfittingsSaveCommand = new ClaimFittingsSaveCommand(fittingsList);
  	claimfittingsSaveCommand.execute();
  }
  
} 
