package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLED_AGENT_INFOFacade的UI Command类<br>
 * 创建于 2005-07-19 09:59:09.675<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class ED_AGENT_INFOFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个ED_AGENT_INFOFindByPrimaryKeyCommand对象
     * @param aGENTID 参数aGENTID
     * @throws Exception
     */
    public ED_AGENT_INFOFindByPrimaryKeyCommand(String aGENTID) throws Exception {
    		this.params = new Object[]{aGENTID };
    		this.paramTypes = new Class[]{String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLED_AGENT_INFOFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
