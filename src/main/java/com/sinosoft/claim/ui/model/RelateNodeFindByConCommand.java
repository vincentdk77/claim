package com.sinosoft.claim.ui.model;
import com.sinosoft.claim.bl.facade.BLRegistFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class RelateNodeFindByConCommand extends BaseCommand{
  private String registNo;

  public RelateNodeFindByConCommand(String registNo) throws Exception {
    this.registNo = registNo;
  }

  public Object executeCommand() throws Exception {
    BLRegistFacade bLRegistFacade = new BLRegistFacade();
    return bLRegistFacade.relateNode(registNo);
  }
 
}
