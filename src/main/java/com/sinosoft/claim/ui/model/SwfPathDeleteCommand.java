package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfPathFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.408<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfPathDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个SwfPathDeleteCommand对象
     * @param modelNo 参数modelNo
     * @param patheNo 参数patheNo
     * @throws Exception
     */
    public SwfPathDeleteCommand(int modelNo ,int patheNo) throws Exception {
    		this.params = new Object[]{new Integer(modelNo)  ,new Integer(patheNo) };
    		this.paramTypes = new Class[]{int.class  ,int.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfPathFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
