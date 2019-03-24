package com.sinosoft.function.power.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLUtiGroupFacade��UI Command��<br>
 * ������ 2004-11-09 10:41:01.428<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiGroupDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��UtiGroupDeleteCommand����
     * @param groupCode ����groupCode
     * @throws Exception
     */
    public UtiGroupDeleteCommand(String groupCode) throws Exception {
    		this.params = new Object[]{groupCode };
    		this.paramTypes = new Class[]{String.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.function.power.bl.facade.BLUtiGroupFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}