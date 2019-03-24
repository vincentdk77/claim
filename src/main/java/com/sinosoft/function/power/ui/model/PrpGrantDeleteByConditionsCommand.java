package com.sinosoft.function.power.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpGrantFacade的UI Command类<br>
 * 创建于 2004-11-09 10:40:57.923<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGrantDeleteByConditionsCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpGrantDeleteByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public PrpGrantDeleteByConditionsCommand(String conditions) throws Exception {
    		this.params = new Object[]{conditions };
    		this.paramTypes = new Class[]{String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.function.power.bl.facade.BLPrpGrantFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("deleteByConditions",paramTypes);
        return method.invoke(object,params);
    }
}
