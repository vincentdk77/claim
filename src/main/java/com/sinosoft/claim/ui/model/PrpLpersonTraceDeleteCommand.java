package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLpersonTraceFacade的UI Command类<br>
 * 创建于 2005-02-18 10:47:33.843<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLpersonTraceDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLpersonTraceDeleteCommand对象
     * @param registNo 参数registNo
     * @param personNo 参数personNo
     * @throws Exception
     */
    public PrpLpersonTraceDeleteCommand(String registNo ,int personNo) throws Exception {
    		this.params = new Object[]{registNo  ,new Integer(personNo) };
    		this.paramTypes = new Class[]{String.class  ,int.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLpersonTraceFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
