package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLthirdPropFacade的UI Command类<br>
 * 创建于 2005-04-12 11:37:57.140<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLthirdPropDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLthirdPropDeleteCommand对象
     * @param registNo 参数registNo
     * @param serialNo 参数serialNo
     * @throws Exception
     */
    public PrpLthirdPropDeleteCommand(String registNo ,int serialNo) throws Exception {
    		this.params = new Object[]{registNo  ,new Integer(serialNo) };
    		this.paramTypes = new Class[]{String.class  ,int.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLthirdPropFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
