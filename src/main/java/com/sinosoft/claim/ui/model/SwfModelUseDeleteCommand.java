package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfModelUseFacade��UI Command��<br>
 * ������ 2004-08-10 10:49:39.377<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfModelUseDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��SwfModelUseDeleteCommand����
     * @param modelNo ����modelNo
     * @param riskCode ����riskCode
     * @param comCode ����comCode
     * @throws Exception
     */
    public SwfModelUseDeleteCommand(int modelNo ,String riskCode ,String comCode) throws Exception {
    		this.params = new Object[]{new Integer(modelNo)  ,riskCode  ,comCode };
    		this.paramTypes = new Class[]{int.class  ,String.class  ,String.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfModelUseFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
