package com.sinosoft.function.power.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpDriskFacade的UI Command类<br>
 * 创建于 2004-11-09 10:40:57.883<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDriskFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpDriskFindByPrimaryKeyCommand对象
     * @param riskCode 参数riskCode
     * @throws Exception
     */
    public PrpDriskFindByPrimaryKeyCommand(String riskCode) throws Exception {
    		this.params = new Object[]{riskCode };
    		this.paramTypes = new Class[]{String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.function.power.bl.facade.BLPrpDriskFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
