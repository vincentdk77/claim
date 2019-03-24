package com.sinosoft.claim.ui.model;
import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CodeTranslateCodeCodeCommand extends BaseCommand {
  private String codeType = "";
  private String codeCode = "";
  private boolean isChinese = true;

  public CodeTranslateCodeCodeCommand(String codeType,String codeCode,boolean isChinese)  throws Exception
  {
      this.codeType = codeType;
      this.codeCode = codeCode;
      this.isChinese = isChinese;
  }
  public Object executeCommand() throws Exception
  {
      String comName = "";
      BLCodeFacade blCodeFacade = new BLCodeFacade();
      comName = blCodeFacade.translateCodeCode(codeType,codeCode,isChinese) ;
      return comName;
  }
}
