package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrpLmessageFacade;

public class MessageGetNoCommand {
  String registNo = "";
  
  public MessageGetNoCommand(String registNo) {
  this.registNo = registNo;
  }
  public Object executeCommand() throws Exception
  { 
    int messageID = 0;
    BLPrpLmessageFacade bLPrpLmessageFacade = new BLPrpLmessageFacade();
    messageID = bLPrpLmessageFacade.getNo(registNo);
    Integer inte = new Integer(messageID);
    return inte;
  }
}
