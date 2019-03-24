package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfPathLogFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.368<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfPathLogGetMaxPathNoCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个SwfPathLogGetMaxPathNoCommand对象
     * @param flowID 参数flowID
     * @throws Exception
     */
    public SwfPathLogGetMaxPathNoCommand(String flowID) throws Exception {
    		this.params = new Object[]{flowID };
    		this.paramTypes = new Class[]{String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfPathLogFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("getMaxPathNo",paramTypes);
        return method.invoke(object,params);
    }
}
