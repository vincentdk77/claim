package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpPheadFacade的UI Command类<br>
 * 创建于 2004-11-22 15:24:44.750<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPheadFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpPheadFindByPrimaryKeyCommand对象
     * @param endorseNo 参数endorseNo
     * @throws Exception
     */
    public PrpPheadFindByPrimaryKeyCommand(String endorseNo) throws Exception {
    		this.params = new Object[]{endorseNo };
    		this.paramTypes = new Class[]{String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claimTemp.bl.facade.BLPrpPheadFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
