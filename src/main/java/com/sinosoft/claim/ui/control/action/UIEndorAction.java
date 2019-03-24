package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.EndorDto;
import com.sinosoft.claim.ui.model.EndorSaveCommand;

/**
 * UI冲减保额逻辑
 * <p>Title: 车险理赔样本程序 冲减保额action</p>
 * <p>Description: 车险理赔样本程序 冲减保额action</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author     liubvo
 * @version    1.0
 */
public class UIEndorAction
{
/**
   * 保存冲减保额
   * @param endorseNo：冲减保额对象
   * @throws Exception
   */

  public void save(EndorDto endorDto) throws SQLException,Exception
  {
  	EndorSaveCommand endorSaveCommand = new EndorSaveCommand(endorDto);
  	endorSaveCommand.execute();
  }
}
