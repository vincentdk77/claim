package com.sinosoft.function.power.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpGrantFacade的UI Command类<br>
 * 创建于 2004-11-09 10:40:57.933<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGrantDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpGrantDeleteCommand对象
     * @param userCode 参数userCode
     * @param groupCode 参数groupCode
     * @param taskCode 参数taskCode
     * @param checkCode 参数checkCode
     * @param grantStartDate 参数grantStartDate
     * @param grantEndDate 参数grantEndDate
     * @throws Exception
     */
    public PrpGrantDeleteCommand(String userCode ,String groupCode ,String taskCode ,String checkCode ,DateTime grantStartDate ,DateTime grantEndDate) throws Exception {
    		this.params = new Object[]{userCode  ,groupCode  ,taskCode  ,checkCode  ,grantStartDate  ,grantEndDate };
    		this.paramTypes = new Class[]{String.class  ,String.class  ,String.class  ,String.class  ,DateTime.class  ,DateTime.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.function.power.bl.facade.BLPrpGrantFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
