package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLWorkFlowModelFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class WorkFlowModelDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个WorkFlowModelDeleteCommand对象
     * @param modelNo 参数modelNo
     * @param pathNo 参数pathNo
     * @param conditionNo 参数conditionNo
     * @param serialNo 参数serialNo
     * @throws Exception
     */
    public WorkFlowModelDeleteCommand(int modelNo ,int pathNo ,int conditionNo ,int serialNo) throws Exception {
    		this.params = new Object[]{new Integer(modelNo)  ,new Integer(pathNo)  ,new Integer(conditionNo)  ,new Integer(serialNo) };
    		this.paramTypes = new Class[]{int.class  ,int.class  ,int.class  ,int.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLWorkFlowModelFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
