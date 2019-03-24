package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CodeTranslateCalculateFlagCommand extends BaseCommand
{
  private String riskCode = "";
  private String kindCode ="" ;

  public CodeTranslateCalculateFlagCommand(String riskCode,String kindCode)  throws Exception
  {
    this.riskCode = riskCode;  
    this.kindCode = kindCode;
  }
  public Object executeCommand() throws Exception
  {
    String comName = "";
    BLCodeFacade blCodeFacade = new BLCodeFacade();
    comName = blCodeFacade.translateCalculateFlag(riskCode,kindCode);
    return comName; 
  } 
}  
  