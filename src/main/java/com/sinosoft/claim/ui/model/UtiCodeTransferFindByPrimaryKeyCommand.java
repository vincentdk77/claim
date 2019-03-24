package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLUtiCodeTransferFacade的UI Command类<br>
 * 创建于 2005-05-09 09:01:33.109<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class UtiCodeTransferFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个UtiCodeTransferFindByPrimaryKeyCommand对象
     * @param configCode 参数configCode
     * @throws Exception
     */
    public UtiCodeTransferFindByPrimaryKeyCommand(String configCode) throws Exception {
    		this.params = new Object[]{configCode };
    		this.paramTypes = new Class[]{String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLUtiCodeTransferFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
