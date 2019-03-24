package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLclaimGradeFacade的UI Command类<br>
 * 创建于 2005-04-19 09:24:27.562<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLclaimGradeDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLclaimGradeDeleteCommand对象
     * @param userCode 参数userCode
     * @param taskCode 参数taskCode
     * @throws Exception
     */
    public PrpLclaimGradeDeleteCommand(String userCode ,String taskCode,String configPara) throws Exception {
    		this.params = new Object[]{userCode  ,taskCode ,configPara};
    		this.paramTypes = new Class[]{String.class  ,String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLclaimGradeFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
