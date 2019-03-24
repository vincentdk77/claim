package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpPheadFacade的UI Command类<br>
 * 创建于 2004-11-22 15:24:44.750<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPheadFindByConditionsCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpPheadFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @param pageNo 参数pageNo
     * @param rowsPerPage 参数rowsPerPage
     * @throws Exception
     */
    public PrpPheadFindByConditionsCommand(String conditions ,int pageNo ,int rowsPerPage) throws Exception {
    		this.params = new Object[]{conditions  ,new Integer(pageNo)  ,new Integer(rowsPerPage) };
    		this.paramTypes = new Class[]{String.class  ,int.class  ,int.class };
    }
    /**
     *  构造方法,构造一个PrpPheadFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public PrpPheadFindByConditionsCommand(String conditions) throws Exception {
    		this.params = new Object[]{conditions };
    		this.paramTypes = new Class[]{String.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claimTemp.bl.facade.BLPrpPheadFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByConditions",paramTypes);
        return method.invoke(object,params);
    }
}
