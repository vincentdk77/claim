package com.sinosoft.claim.ui.model;
import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CodeFindByLicenseNoCommand extends BaseCommand {
  private String registNo = "";

  public CodeFindByLicenseNoCommand(String registNo)  throws Exception
  {
      this.registNo = registNo;
  }
  public Object executeCommand() throws Exception
  {
	    BLCodeFacade bLCodeFacade = new BLCodeFacade();
	    return bLCodeFacade.getLicenseNoList(registNo);
  }
}
