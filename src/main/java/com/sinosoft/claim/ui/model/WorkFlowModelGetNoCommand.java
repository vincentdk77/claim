package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLWorkFlowModelFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class WorkFlowModelGetNoCommand extends BaseCommand {
  private String modelNo = "";
  public WorkFlowModelGetNoCommand()  throws Exception
  {

  }


  public Object executeCommand() throws Exception
  {
      Integer modelNo = new Integer(0);
      BLWorkFlowModelFacade blWorkFlowModelFacade = new BLWorkFlowModelFacade();
      modelNo = new Integer(blWorkFlowModelFacade.getModelNo());
      return modelNo;
  }

}
