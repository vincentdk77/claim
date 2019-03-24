package com.sinosoft.claim.ui.model;
import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CodeTranslateComCodeCommand extends BaseCommand {
  private String comCode = "";
  private boolean isChinese = true;

  public CodeTranslateComCodeCommand(String comCode,boolean isChinese)  throws Exception
  {
      this.comCode = comCode;
      this.isChinese = isChinese;
  }
  public Object executeCommand() throws Exception
  {
      String comName = "";
      BLCodeFacade blCodeFacade = new BLCodeFacade();
      comName = blCodeFacade.translateComCode(comCode,isChinese) ;
      return comName;
  }
}
