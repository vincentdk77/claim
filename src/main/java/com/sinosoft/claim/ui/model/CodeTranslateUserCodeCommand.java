package com.sinosoft.claim.ui.model;
import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CodeTranslateUserCodeCommand extends BaseCommand {
  private String userCode = "";
  private boolean isChinese = true;

  public CodeTranslateUserCodeCommand(String userCode,boolean isChinese)  throws Exception
  {
      this.userCode = userCode;
      this.isChinese = isChinese;
  }
  public Object executeCommand() throws Exception
  {
      String comName = "";
      BLCodeFacade blCodeFacade = new BLCodeFacade();
      comName = blCodeFacade.translateUserCode(userCode,isChinese) ;
      return comName;
  }
}
