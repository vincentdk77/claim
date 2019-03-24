package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLclaimLossFacade的UI Command类<br>
 * 创建于 2004-06-24 14:46:42.909<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLclaimLossFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLclaimLossFindByPrimaryKeyCommand对象
     * @param claimNo 参数claimNo
     * @param serialNo 参数serialNo
     * @throws Exception
     */
    public PrpLclaimLossFindByPrimaryKeyCommand(String claimNo ,int serialNo) throws Exception {
    		this.params = new Object[]{claimNo  ,new Integer(serialNo) };
    		this.paramTypes = new Class[]{String.class  ,int.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLclaimLossFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
