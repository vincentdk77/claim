package com.sinosoft.claim.ui.model;
import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CodeTranslateCurrencyCodeCommand extends BaseCommand {
  private String currencyCode = "";
  private boolean isChinese = true;

  public CodeTranslateCurrencyCodeCommand(String currencyCode,boolean isChinese)  throws Exception
  {
      this.currencyCode = currencyCode;
      this.isChinese = isChinese;
  }
  public Object executeCommand() throws Exception
  {
      String comName = "";
      BLCodeFacade blCodeFacade = new BLCodeFacade();
      comName = blCodeFacade.translateCurrencyCode(currencyCode,isChinese)  ;
      return comName;
  }
}
