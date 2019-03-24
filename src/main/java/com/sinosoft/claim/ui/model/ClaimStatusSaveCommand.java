package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLClaimStatusFacade;
import com.sinosoft.claim.dto.custom.ClaimStatusDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ClaimStatusSaveCommand extends BaseCommand
{
  private ClaimStatusDto claimStatusDto;

  public ClaimStatusSaveCommand(ClaimStatusDto claimStatusDto)  throws Exception
  {
    this.claimStatusDto = claimStatusDto;
  }
  public Object executeCommand() throws Exception
  {
    BLClaimStatusFacade bLClaimStatusFacade = new BLClaimStatusFacade();
    bLClaimStatusFacade.save(claimStatusDto);
    return null;
  }

}
