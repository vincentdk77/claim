package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfModelMainFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.378<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfModelMainDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个SwfModelMainDeleteCommand对象
     * @param modelNo 参数modelNo
     * @throws Exception
     */
    public SwfModelMainDeleteCommand(int modelNo) throws Exception {
    		this.params = new Object[]{new Integer(modelNo) };
    		this.paramTypes = new Class[]{int.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfModelMainFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
