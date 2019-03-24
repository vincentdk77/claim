package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfNodeFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.378<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfNodeDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��SwfNodeDeleteCommand����
     * @param modelNo ����modelNo
     * @param nodeNo ����nodeNo
     * @throws Exception
     */
    public SwfNodeDeleteCommand(int modelNo ,int nodeNo) throws Exception {
    		this.params = new Object[]{new Integer(modelNo)  ,new Integer(nodeNo) };
    		this.paramTypes = new Class[]{int.class  ,int.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfNodeFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
