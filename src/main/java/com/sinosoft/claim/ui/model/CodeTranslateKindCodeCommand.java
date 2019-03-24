package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CodeTranslateKindCodeCommand extends BaseCommand
{
  private String riskCode = "";
  private String kindCode ="" ;
  private boolean isChinese = true;

  public CodeTranslateKindCodeCommand(String riskCode,String kindCode,boolean isChinese)  throws Exception
  {
      this.riskCode = riskCode;
      this.kindCode = kindCode;
      this.isChinese = isChinese;
  }
  public Object executeCommand() throws Exception
  {
      String comName = "";
      BLCodeFacade blCodeFacade = new BLCodeFacade();
      comName = blCodeFacade.translateKindCode(riskCode,kindCode,isChinese)  ;
      return comName;
  }
}
