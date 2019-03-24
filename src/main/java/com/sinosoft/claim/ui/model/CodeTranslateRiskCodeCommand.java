package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CodeTranslateRiskCodeCommand extends BaseCommand
{
  private String riskCode = "";
  private boolean isChinese = true;

  public CodeTranslateRiskCodeCommand(String riskCode,boolean isChinese)  throws Exception
  {
      this.riskCode = riskCode;

      this.isChinese = isChinese;
  }
  public Object executeCommand() throws Exception
  {
      String comName = "";
      BLCodeFacade blCodeFacade = new BLCodeFacade();
      comName = blCodeFacade.translateRiskCode(riskCode,isChinese)  ;
      return comName;
  }
}
