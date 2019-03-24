package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ClaimDeleteCommand extends BaseCommand
{
	 private Class[] paramTypes;
   private Object[] params;

	public ClaimDeleteCommand(String claimNo)  throws Exception
	{
		 this.params = new Object[]{new String(claimNo) };
     this.paramTypes = new Class[]{String.class};
  }

	public ClaimDeleteCommand(String claimNo,WorkFlowDto workFlowDto)  throws Exception
	{
		 this.params = new Object[]{new String(claimNo),workFlowDto };
     this.paramTypes = new Class[]{String.class,WorkFlowDto.class};
	}

	public Object executeCommand() throws Exception
	{
    Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLClaimFacade");
    Object object = loaderClass.newInstance();
    Method method = loaderClass.getMethod("delete",paramTypes);
    return method.invoke(object,params);

	}
}
