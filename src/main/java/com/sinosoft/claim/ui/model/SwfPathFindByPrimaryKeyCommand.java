package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfPathFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.388<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfPathFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��SwfPathFindByPrimaryKeyCommand����
     * @param modelNo ����modelNo
     * @param patheNo ����patheNo
     * @throws Exception
     */
    public SwfPathFindByPrimaryKeyCommand(int modelNo ,int patheNo) throws Exception {
    		this.params = new Object[]{new Integer(modelNo)  ,new Integer(patheNo) };
    		this.paramTypes = new Class[]{int.class  ,int.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfPathFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
