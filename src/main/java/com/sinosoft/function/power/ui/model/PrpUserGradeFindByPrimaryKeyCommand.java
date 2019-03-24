package com.sinosoft.function.power.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpUserGradeFacade的UI Command类<br>
 * 创建于 2004-11-09 10:41:01.168<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpUserGradeFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpUserGradeFindByPrimaryKeyCommand对象
     * @param userCode 参数userCode
     * @param groupCode 参数groupCode
     * @param taskCode 参数taskCode
     * @param checkCode 参数checkCode
     * @throws Exception
     */
    public PrpUserGradeFindByPrimaryKeyCommand(String userCode ,String groupCode ,String taskCode ,String checkCode) throws Exception {
    		this.params = new Object[]{userCode  ,groupCode  ,taskCode  ,checkCode };
    		this.paramTypes = new Class[]{String.class  ,String.class  ,String.class  ,String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.function.power.bl.facade.BLPrpUserGradeFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
