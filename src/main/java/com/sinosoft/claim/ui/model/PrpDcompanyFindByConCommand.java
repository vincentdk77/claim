package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpDcompanyFindByConCommand extends BaseCommand
{
  private String comCode;

  public PrpDcompanyFindByConCommand(String comCode)  throws Exception
  {
    this.comCode = comCode; 
  }
  public Object executeCommand() throws Exception
  {
    BLPrpDcompanyFacade blPrpDcompanyFacade = new BLPrpDcompanyFacade(); 
    return blPrpDcompanyFacade.findByPrimaryKey(comCode); 
  } 
} 
