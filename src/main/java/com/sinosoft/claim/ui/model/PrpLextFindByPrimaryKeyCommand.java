package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;

/**
 * �����������Ҳ�������������Ϣ
 * <p>Title:����ո�����Ϣ�����ݿ������</p>
 * <p>Copyright: Chinasoft (c) 2005 </p>
 * <p>Company: Sinosoft; </p>
 * @author qinyongli
 * @version 1.0
 */
public class PrpLextFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLextFindByPrimaryKeyCommand����
     * @param certiNo,certiType
     * @throws Exception
     */
    public PrpLextFindByPrimaryKeyCommand(String certiNo,String certiType) throws Exception {
    		this.params = new Object[]{certiNo };
    		this.params = new Object[]{certiType };
    		this.paramTypes = new Class[]{String.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Thread.currentThread().setContextClassLoader(myClassLoader);
        Class loaderClass = myClassLoader.loadClass("com.sinosoft.claim.bl.facade.BLPrpLextFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
