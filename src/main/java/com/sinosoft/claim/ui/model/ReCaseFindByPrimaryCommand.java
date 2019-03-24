package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


public class ReCaseFindByPrimaryCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLpersonWoundFindByPrimaryKeyCommand对象
     * @param registNo 参数registNo
     * @param serialNo 参数serialNo
     * @param personNo 参数personNo
     * @throws Exception
     */
    public ReCaseFindByPrimaryCommand(String claimNo ,int serialNo ) throws Exception {
    		this.params = new Object[]{claimNo  ,new Integer(serialNo) };
    		this.paramTypes = new Class[]{String.class  ,int.class  };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLReCaseFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}