package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpClimitFacade��UI Command��<br>
 * ������ 2006-06-09 15:31:34.859<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpClimitFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpClimitFindByPrimaryKeyCommand����
     * @param policyNo ����policyNo
     * @param limitGrade ����limitGrade
     * @param limitNo ����limitNo
     * @param limitType ����limitType
     * @param currency ����currency
     * @throws Exception
     */
    public PrpClimitFindByPrimaryKeyCommand(String policyNo ,String limitGrade ,double limitNo ,String limitType ,String currency) throws Exception {
    		this.params = new Object[]{policyNo  ,limitGrade  ,new Double(limitNo)  ,limitType  ,currency };
    		this.paramTypes = new Class[]{String.class  ,String.class  ,double.class  ,String.class  ,String.class };
    }
    /**
     *  ִ�з���
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
