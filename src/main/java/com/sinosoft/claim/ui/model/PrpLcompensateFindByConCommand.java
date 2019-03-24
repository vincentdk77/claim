package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLqualityCheckFacade的UI Command类<br>
 * 创建于 2005-04-14 15:56:49.781<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcompensateFindByConCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLqualityCheckFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public PrpLcompensateFindByConCommand(String conditions) throws Exception {
    		this.params = new Object[]{conditions };
    		this.paramTypes = new Class[]{String.class };
    }  
    /** 
     *  构造方法,构造一个PrpLqualityCheckFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @param pageNo 参数pageNo
     * @param rowsPerPage 参数rowsPerPage
     * @throws Exception 
     */
    public PrpLcompensateFindByConCommand(String conditions ,String pageNo ,String rowsPerPage) throws Exception {
    		this.params = new Object[]{conditions  ,pageNo  ,rowsPerPage };
    		this.paramTypes = new Class[]{String.class  ,String.class  ,String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLCompensateFacade");
        Object object = loaderClass.newInstance(); 
        Method method = loaderClass.getMethod("findByConditions",paramTypes);
        return method.invoke(object,params);
    }
}
