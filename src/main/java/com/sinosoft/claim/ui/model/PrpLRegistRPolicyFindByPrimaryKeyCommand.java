package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLclaimGradeFacade��UI Command��<br>
 * ������ 2005-04-19 09:24:27.546<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLRegistRPolicyFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLclaimGradeFindByPrimaryKeyCommand����
     * @param userCode ����userCode
     * @param taskCode ����taskCode
     * @throws Exception
     */
    public PrpLRegistRPolicyFindByPrimaryKeyCommand(String registNo ,String policyNo) throws Exception {
    		this.params = new Object[]{registNo  ,policyNo};
    		this.paramTypes = new Class[]{String.class,String.class};
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
