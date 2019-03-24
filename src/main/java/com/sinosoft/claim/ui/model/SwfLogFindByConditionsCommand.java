package com.sinosoft.claim.ui.model;
import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;

public class SwfLogFindByConditionsCommand extends BaseCommand
{
	private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个SwfPathFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @param pageNo 参数pageNo
     * @param rowsPerPage 参数rowsPerPage
     * @throws Exception
     */
    public SwfLogFindByConditionsCommand(String conditions ,int pageNo ,int rowsPerPage) throws Exception {
    		this.params = new Object[]{conditions  ,new Integer(pageNo)  ,new Integer(rowsPerPage) };
    		this.paramTypes = new Class[]{String.class  ,int.class  ,int.class };
    }  
    
   /**
     *  构造方法,构造一个SwfPathFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public SwfLogFindByConditionsCommand(String conditions) throws Exception {
    		this.params = new Object[]{conditions };
    		this.paramTypes = new Class[]{String.class };
    }
  
 /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfLogFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByConditions",paramTypes);
        return method.invoke(object,params);
    }
}
