
package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


public class CompensateFeeByClaimNoCommand extends BaseCommand{


  private String claimNo;


  public CompensateFeeByClaimNoCommand(String claimNo)  throws Exception
  {
    this.claimNo = claimNo;
  }
  
  /**
   * 根据赔案号得到已决赔款
   * @param claimNo 赔案号
   * @author wangli 
   * @return 
   * @throws Exception
   */

  public Object executeCommand() throws Exception
  {
  	 BLCompensateFacade bLCompensateFacade = new BLCompensateFacade();
  	
     return bLCompensateFacade.findCompensateFeeByClaimNo(claimNo);
  }

}
