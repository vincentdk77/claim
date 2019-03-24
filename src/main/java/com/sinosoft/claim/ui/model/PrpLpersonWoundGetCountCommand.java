package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLpersonWoundFacade的UI Command类<br>
 * 创建于 2005-02-18 10:47:33.859<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLpersonWoundGetCountCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLpersonWoundGetCountCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public PrpLpersonWoundGetCountCommand(String conditions) throws Exception {
    		this.params = new Object[]{conditions };
    		this.paramTypes = new Class[]{String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLpersonWoundFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("getCount",paramTypes);
        return method.invoke(object,params);
    }
}
