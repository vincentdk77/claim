package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpClimitFacade的UI Command类<br>
 * 创建于 2006-06-09 15:31:34.859<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpClimitFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpClimitFindByPrimaryKeyCommand对象
     * @param policyNo 参数policyNo
     * @param limitGrade 参数limitGrade
     * @param limitNo 参数limitNo
     * @param limitType 参数limitType
     * @param currency 参数currency
     * @throws Exception
     */
    public PrpClimitFindByPrimaryKeyCommand(String policyNo ,String limitGrade ,double limitNo ,String limitType ,String currency) throws Exception {
    		this.params = new Object[]{policyNo  ,limitGrade  ,new Double(limitNo)  ,limitType  ,currency };
    		this.paramTypes = new Class[]{String.class  ,String.class  ,double.class  ,String.class  ,String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Thread.currentThread().setContextClassLoader(myClassLoader);
        Class loaderClass = myClassLoader.loadClass("com.sinosoft.claim.bl.facade.BLPrpClimitFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
