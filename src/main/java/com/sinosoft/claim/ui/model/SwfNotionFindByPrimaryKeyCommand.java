package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfModelUseFacade��UI Command��<br>
 * ������ 2004-08-10 10:49:39.367<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfNotionFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��SwfModelUseFindByPrimaryKeyCommand����
     * @param modelNo ����modelNo
     * @param riskCode ����riskCode
     * @param comCode ����comCode
     * @throws Exception
     */
    public SwfNotionFindByPrimaryKeyCommand(String flowId ,int logNo ,int lineNo) throws Exception {
    		this.params = new Object[]{new String(flowId)  ,new Integer(logNo)  ,new Integer(lineNo) };
    		this.paramTypes = new Class[]{String.class  ,int.class  ,int.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfNotionFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
