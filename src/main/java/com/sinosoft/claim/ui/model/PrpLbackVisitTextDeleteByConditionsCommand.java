package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLbackVisitTextFacade的UI Command类<br>
 * 创建于 2005-03-23 09:00:42.640<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitTextDeleteByConditionsCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLbackVisitTextDeleteByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public PrpLbackVisitTextDeleteByConditionsCommand(String conditions) throws Exception {
    		this.params = new Object[]{conditions };
    		this.paramTypes = new Class[]{String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLbackVisitTextFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("deleteByConditions",paramTypes);
        return method.invoke(object,params);
    }
}
