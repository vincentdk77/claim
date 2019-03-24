package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpLclaimFindByConCommand extends BaseCommand {
  private String conditions;
  
  //add by zhaolu 20060803 start
  private int pageNo;
  
  private int recordPerPage;
  
  public PrpLclaimFindByConCommand(String conditions,int pageNo,int recordPerPage)  throws Exception
  {
	  this.conditions = conditions;
	  this.pageNo = pageNo;
	  this.recordPerPage = recordPerPage;
  }
  
  //add by zhaolu 20060803 end

  public PrpLclaimFindByConCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
	  if(pageNo != 0 && recordPerPage != 0)
	  {
		  return new BLClaimFacade().findByConditions(conditions,pageNo,recordPerPage);
	  }
      BLClaimFacade bLClaimFacade = new BLClaimFacade();
      return bLClaimFacade.findByConditions(conditions);
  }

}
