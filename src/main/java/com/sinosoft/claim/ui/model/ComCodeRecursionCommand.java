package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


public class ComCodeRecursionCommand extends BaseCommand{
	String Conditions="";
	public ComCodeRecursionCommand(String Conditions)  throws Exception
	  {
	      this.Conditions = Conditions;
	
	  }
	  public Object executeCommand() throws Exception
	  {
	      String comCode = "";
	      BLPrpDcompanyFacade blprpdcompanyfacade = new BLPrpDcompanyFacade();
	      comCode = blprpdcompanyfacade.getRecursionComCode(Conditions) ;
	      return comCode;
	  }
}
