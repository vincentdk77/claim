package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLPrpLacciCheckFacade的UI Command类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLacciCheckInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLacciCheckInsertCommand对象
     * @param prpLacciCheckDto 参数prpLacciCheckDto
     * @throws Exception
     */
    public PrpLacciCheckInsertCommand(PrpLacciCheckDto prpLacciCheckDto) throws Exception {
    		this.params = new Object[]{prpLacciCheckDto };
    		this.paramTypes = new Class[]{PrpLacciCheckDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Thread.currentThread().setContextClassLoader(myClassLoader);
        Class loaderClass = myClassLoader.loadClass("com.sinosoft.claim.bl.facade.BLPrpLacciCheckFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
