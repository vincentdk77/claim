package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfConditionFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.358<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfConditionExecuteResultCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��SwfConditionGetCountCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public SwfConditionExecuteResultCommand(String conditions) throws Exception {
    		this.params = new Object[]{conditions };
    		this.paramTypes = new Class[]{String.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfConditionFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("executeResult",paramTypes);
        return method.invoke(object,params);
    }
}
