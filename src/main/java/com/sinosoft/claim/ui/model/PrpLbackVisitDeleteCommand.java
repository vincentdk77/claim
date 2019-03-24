package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLbackVisitFacade的UI Command类<br>
 * 创建于 2005-03-25 20:44:51.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLbackVisitDeleteCommand对象
     * @param backVisitID 参数backVisitID
     * @param registNo 参数registNo
     * @param backVisitType 参数backVisitType
     * @throws Exception
     */
    public PrpLbackVisitDeleteCommand(int backVisitID ,String registNo ,String backVisitType) throws Exception {
    		this.params = new Object[]{new Integer(backVisitID)  ,registNo  ,backVisitType };
    		this.paramTypes = new Class[]{int.class  ,String.class  ,String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLbackVisitFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
