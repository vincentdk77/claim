package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;

public class SwfLogupdateFlowStatusCommand extends BaseCommand
{
	 private  Class[] paramTypes;
     private  Object[] params;

	public SwfLogupdateFlowStatusCommand(String flowId)  throws Exception
	{
		 this.params = new Object[]{new String(flowId) };
         this.paramTypes = new Class[]{String.class};
    }

 public Object executeCommand() throws Exception
	{
    Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfLogFacade");
    Object object = loaderClass.newInstance();
    Method method = loaderClass.getMethod("updateFlowStatus",paramTypes);
    return method.invoke(object,params);

	}
}