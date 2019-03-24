package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;
import java.util.Date;

import com.sinosoft.sysframework.web.model.BaseCommand;

public class ClaimUpdateEndCaseDateCommand extends BaseCommand
{
	 private Class[] paramTypes;
   private Object[] params;

	public ClaimUpdateEndCaseDateCommand(String claimNo,Date endCaseDate)  throws Exception
	{
		 this.params = new Object[]{new String(claimNo),endCaseDate};
		 this.paramTypes = new Class[]{String.class,Date.class};
  }

 public Object executeCommand() throws Exception
	{
    Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLClaimFacade");
    Object object = loaderClass.newInstance();
    Method method = loaderClass.getMethod("updateEndCaseDate",paramTypes);
    return method.invoke(object,params);

	}
}