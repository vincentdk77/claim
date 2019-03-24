package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLSwfPathLogStoreFacade的UI Command类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class SwfPathLogStoreFindByConditionsCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个SwfPathLogStoreFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public SwfPathLogStoreFindByConditionsCommand(String conditions)
            throws Exception{
    		this.params = new Object[]{conditions };
    		this.paramTypes = new Class[]{String.class };
    }
    /**
     *  构造方法,构造一个SwfPathLogStoreFindByConditionsCommand对象
     * @param conditions 参数conditions
     * @param pageNo 参数pageNo
     * @param rowsPerPage 参数rowsPerPage
     * @throws Exception
     */
    public SwfPathLogStoreFindByConditionsCommand(String conditions ,int pageNo ,int rowsPerPage)
            throws Exception{
    		this.params = new Object[]{conditions  ,new Integer(pageNo)  ,new Integer(rowsPerPage) };
    		this.paramTypes = new Class[]{String.class  ,int.class  ,int.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Thread.currentThread().setContextClassLoader(myClassLoader);
        Class loaderClass = myClassLoader.loadClass("com.sinosoft.claim.bl.facade.BLSwfPathLogStoreFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByConditions",paramTypes);
        return method.invoke(object,params);
    }
}
