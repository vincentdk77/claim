package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.EndorDto;
import com.sinosoft.claim.ui.model.EndorSaveCommand;

/**
 * UI��������߼�
 * <p>Title: ���������������� �������action</p>
 * <p>Description: ���������������� �������action</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author     liubvo
 * @version    1.0
 */
public class UIEndorAction
{
/**
   * ����������
   * @param endorseNo������������
   * @throws Exception
   */

  public void save(EndorDto endorDto) throws SQLException,Exception
  {
  	EndorSaveCommand endorSaveCommand = new EndorSaveCommand(endorDto);
  	endorSaveCommand.execute();
  }
}
