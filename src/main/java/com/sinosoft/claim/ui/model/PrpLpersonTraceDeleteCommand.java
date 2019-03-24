package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLpersonTraceFacade��UI Command��<br>
 * ������ 2005-02-18 10:47:33.843<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLpersonTraceDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLpersonTraceDeleteCommand����
     * @param registNo ����registNo
     * @param personNo ����personNo
     * @throws Exception
     */
    public PrpLpersonTraceDeleteCommand(String registNo ,int personNo) throws Exception {
    		this.params = new Object[]{registNo  ,new Integer(personNo) };
    		this.paramTypes = new Class[]{String.class  ,int.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLpersonTraceFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
