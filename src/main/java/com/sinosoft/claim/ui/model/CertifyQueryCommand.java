package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCertifyFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

 /** Create By sunhao 2004-08-24
  * Reason:增加单证查询Command类
  */

public class CertifyQueryCommand extends BaseCommand {
  private String conditions;
  
  //add by zhaolu 20060803 start
  private int pageNo;
  
  private int recordPerPage;
  
  public CertifyQueryCommand(String conditions,int pageNo,int recordPerPage)  throws Exception
  {
	  this.conditions = conditions;
	  this.pageNo = pageNo;
	  this.recordPerPage = recordPerPage;
  }
  //add b yzhaolu 20060803 end

  public CertifyQueryCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
	  //add by zhaolu 20060803 start
	  if( pageNo != 0 && recordPerPage != 0)
	  {
		  return new BLCertifyFacade().findByQueryConditions(conditions,pageNo,recordPerPage);
	  }
	  //add by zhaolu 20060803 end
      BLCertifyFacade bLCertifyFacade = new BLCertifyFacade();
      return bLCertifyFacade.findByQueryConditions(conditions);
  }

}