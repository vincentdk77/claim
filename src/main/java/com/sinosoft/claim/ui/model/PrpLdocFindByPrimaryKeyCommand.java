package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLdocFacade��UI Command��<br>
 * ������ 2005-06-24 11:04:11.281<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLdocFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLdocFindByPrimaryKeyCommand����
     * @param claimNo ����claimNo
     * @param docCode ����docCode
     * @throws Exception
     */
    public PrpLdocFindByPrimaryKeyCommand(String claimNo ,String docCode) throws Exception {
    		this.params = new Object[]{claimNo  ,docCode };
    		this.paramTypes = new Class[]{String.class  ,String.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Thread.currentThread().setContextClassLoader(myClassLoader);
        Class loaderClass = myClassLoader.loadClass("com.sinosoft.claim.bl.facade.BLPrpLdocFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
