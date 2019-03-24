package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLscheduleMainWFFacade的UI Command类<br>
 * 创建于 2005-10-17 15:12:18.046<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleMainWFGetCountCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLscheduleMainWFGetCountCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public PrpLscheduleMainWFGetCountCommand(String conditions) throws Exception {
    		this.params = new Object[]{conditions };
    		this.paramTypes = new Class[]{String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName ("com.sinosoft.claim.bl.facade.BLPrpLscheduleMainWFFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("getCount",paramTypes);
        return method.invoke(object,params);
    }
}
