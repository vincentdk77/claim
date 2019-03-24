package com.sinosoft.claimzy.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;

public class AgriClaimDemandDeleteCommand extends BaseCommand{
	 private Class[] paramTypes;
	    private Object[] params;
	    /**
	     *  ���췽��,����һ��AGRICLAIMUPLOADLOGDeleteCommand����
	     * @param claimCode ����claimCode
	     * @throws Exception
	     */
	    public AgriClaimDemandDeleteCommand(String claimCode)
	            throws Exception{
	    		this.params = new Object[]{claimCode };
	    		this.paramTypes = new Class[]{String.class };
	    }
	    /**
	     *  ִ�з���
	     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
	     */
	    public Object executeCommand() throws Exception{
	        Thread.currentThread().setContextClassLoader(myClassLoader);
	        Class loaderClass = myClassLoader.loadClass("com.sinosoft.claimzy.bl.facade.BLAgriClaimDemandFacade");
	        Object object = loaderClass.newInstance();
	        Method method = loaderClass.getMethod("delete",paramTypes);
	        return method.invoke(object,params);
	    }

}
