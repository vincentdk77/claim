package com.sinosoft.claim.ui.model;

import java.util.Collection;

import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.claim.bl.facade.BLJobManagerFacade;


/**
 * Reason:增加立案查询Command类
 */
public class JobManagerQueryCommand {
	
	private String conditions;
	
	private int pageNo;
	
	private int recordPerPage;
	
	public JobManagerQueryCommand(String conditions,int pageNo,int recordPerPage)  throws Exception
	  {
		  this.conditions = conditions;
		  this.pageNo = pageNo;
		  this.recordPerPage = recordPerPage;
	  }
	
	public Object executeCommand() throws Exception
	  {
		  //add by zhaolu 20060802 start
		  if( pageNo != 0 && recordPerPage != 0)
		  {
			  return new BLJobManagerFacade().findByQueryConditions(conditions,pageNo,recordPerPage);
		  }
		  //add by zhaolu 20060802 end
	      BLJobManagerFacade bLJobManagerFacade = new BLJobManagerFacade();
	      return bLJobManagerFacade.findByQueryConditions(conditions);
	  }
	/**
	 * 查询险类命令
	 * */
	/*public Collection executeClassCodeCommand() throws Exception {
		BLJobManagerFacade bLJobManagerFacade = new BLJobManagerFacade();
		return bLJobManagerFacade.findClassCodeByConditions(conditions);
	}*/

}
