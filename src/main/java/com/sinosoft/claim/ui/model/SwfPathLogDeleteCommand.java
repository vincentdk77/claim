package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLWfPathLogFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.418<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfPathLogDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个WfPathLogDeleteCommand对象
     * @param flowID 参数flowID
     * @param pathNo 参数pathNo
     * @throws Exception
     */
    public SwfPathLogDeleteCommand(String flowID ,int pathNo) throws Exception {
    		this.params = new Object[]{flowID  ,new Integer(pathNo) };
    		this.paramTypes = new Class[]{String.class  ,int.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLWfPathLogFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
