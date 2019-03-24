package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLqualityCheckFacade的UI Command类<br>
 * 创建于 2005-04-14 15:56:49.796<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLqualityCheckDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLqualityCheckDeleteCommand对象
     * @param registNo 参数registNo
     * @param qualityCheckType 参数qualityCheckType
     * @param serialNo 参数serialNo
     * @throws Exception
     */
    public PrpLqualityCheckDeleteCommand(String registNo ,String qualityCheckType ,int serialNo) throws Exception {
    		this.params = new Object[]{registNo  ,qualityCheckType  ,new Integer(serialNo) };
    		this.paramTypes = new Class[]{String.class  ,String.class  ,int.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLqualityCheckFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
