package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����BLPrpLacciCheckFacade��UI Command��<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PubRateGetExchOfMaxDateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLacciCheckFindByConditionsCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public PubRateGetExchOfMaxDateCommand(String currDate) throws Exception {
    		this.params = new Object[]{currDate };
    		this.paramTypes = new Class[]{String.class };
    }
     /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Thread.currentThread().setContextClassLoader(myClassLoader);
        Class loaderClass = myClassLoader.loadClass("com.sinosoft.function.insutil.bl.facade.BLPubRateFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("getExchOfMaxDate",paramTypes);
        return method.invoke(object,params);
    }
}
