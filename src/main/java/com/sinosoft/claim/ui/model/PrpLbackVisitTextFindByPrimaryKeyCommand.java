package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLbackVisitTextFacade的UI Command类<br>
 * 创建于 2005-03-23 09:00:42.640<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitTextFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLbackVisitTextFindByPrimaryKeyCommand对象
     * @param backVisitID 参数backVisitID
     * @param registNo 参数registNo
     * @param backVisitType 参数backVisitType
     * @param lineNo 参数lineNo
     * @throws Exception
     */
    public PrpLbackVisitTextFindByPrimaryKeyCommand(int backVisitID ,String registNo ,String backVisitType ,int lineNo) throws Exception {
    		this.params = new Object[]{new Integer(backVisitID)  ,registNo  ,backVisitType  ,new Integer(lineNo) };
    		this.paramTypes = new Class[]{int.class  ,String.class  ,String.class  ,int.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLbackVisitTextFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
