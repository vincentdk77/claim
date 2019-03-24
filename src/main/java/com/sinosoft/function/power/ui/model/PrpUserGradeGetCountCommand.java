package com.sinosoft.function.power.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpUserGradeFacade的UI Command类<br>
 * 创建于 2004-11-09 10:41:01.128<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpUserGradeGetCountCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpUserGradeGetCountCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public PrpUserGradeGetCountCommand(String conditions) throws Exception {
    		this.params = new Object[]{conditions };
    		this.paramTypes = new Class[]{String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.function.power.bl.facade.BLPrpUserGradeFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("getCount",paramTypes);
        return method.invoke(object,params);
    }
}
