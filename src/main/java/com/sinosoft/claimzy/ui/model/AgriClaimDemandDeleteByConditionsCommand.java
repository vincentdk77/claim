package com.sinosoft.claimzy.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;

public class AgriClaimDemandDeleteByConditionsCommand extends BaseCommand {
	 private Class[] paramTypes;
	    private Object[] params;
	    /**
	     *  构造方法,构造一个AGRICLAIMUPLOADLOGDeleteByConditionsCommand对象
	     * @param conditions 参数conditions
	     * @throws Exception
	     */
	    public AgriClaimDemandDeleteByConditionsCommand(String conditions)
	            throws Exception{
	    		this.params = new Object[]{conditions };
	    		this.paramTypes = new Class[]{String.class };
	    }
	    /**
	     *  执行方法
	     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
	     */
	    public Object executeCommand() throws Exception{
	        Thread.currentThread().setContextClassLoader(myClassLoader);
	        Class loaderClass = myClassLoader.loadClass("com.sinosoft.claimzy.bl.facade.BLAgriClaimDemandFacade");
	        Object object = loaderClass.newInstance();
	        Method method = loaderClass.getMethod("deleteByConditions",paramTypes);
	        return method.invoke(object,params);
	    }
}
