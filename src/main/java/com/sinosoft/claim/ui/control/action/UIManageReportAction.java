package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.AnaRepCommonDto;
import com.sinosoft.claim.dto.custom.AnaResultDto;
import com.sinosoft.claim.ui.model.ManageFindByDtoCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

public class UIManageReportAction
{
  public UIManageReportAction ()
  {
  }

  public AnaResultDto findByDto(AnaRepCommonDto anaRepCommonDto) throws SQLException,UserException,Exception
  {
    ManageFindByDtoCommand ManageFindByDtoCommand = new ManageFindByDtoCommand(anaRepCommonDto);
    AnaResultDto anaResultDto = (AnaResultDto)ManageFindByDtoCommand.executeCommand();

    return anaResultDto;
  }
}

