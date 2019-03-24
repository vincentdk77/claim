package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLclaimGradeFacade的UI Command类<br>
 * 创建于 2005-04-19 09:24:27.546<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLRegistRPolicyFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLclaimGradeFindByPrimaryKeyCommand对象
     * @param userCode 参数userCode
     * @param taskCode 参数taskCode
     * @throws Exception
     */
    public PrpLRegistRPolicyFindByPrimaryKeyCommand(String registNo ,String policyNo) throws Exception {
    		this.params = new Object[]{registNo  ,policyNo};
    		this.paramTypes = new Class[]{String.class,String.class};
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
