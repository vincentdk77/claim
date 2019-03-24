package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CodeTranslateItemCodeCommand extends BaseCommand
{
  private String riskCode = "";
  private String itemCode ="" ;
  private boolean isChinese = true;

  public CodeTranslateItemCodeCommand(String riskCode,String itemCode,boolean isChinese)  throws Exception
  {
      this.riskCode = riskCode;
      this.itemCode = itemCode;
      this.isChinese = isChinese;
  }
  public Object executeCommand() throws Exception
  {
      String comName = "";
      BLCodeFacade blCodeFacade = new BLCodeFacade();
      comName = blCodeFacade.translateItemCode(riskCode,itemCode,isChinese)  ;
      return comName;
  }
}
