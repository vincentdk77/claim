package com.sinosoft.claim.ui.model;
import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CodeTranslateLimitCommand extends BaseCommand {
  private String riskCode = "";
  private String limitCode = "";
  private boolean isChinese = true;

  public CodeTranslateLimitCommand(String riskCode,String limitCode,boolean isChinese)  throws Exception
  {
      this.riskCode = riskCode ;
      this.limitCode = limitCode;
      this.isChinese = isChinese;
  }
  public Object executeCommand() throws Exception
  {
      String comName = "";
      BLCodeFacade blCodeFacade = new BLCodeFacade();
      comName = blCodeFacade.translateLimit(riskCode,limitCode,isChinese) ;
      return comName;
  }
}
