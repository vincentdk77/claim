package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLIndemnityReceiptDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLPrpLIndemnityReceiptFacade的UI Command类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLIndemnityReceiptInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLIndemnityReceiptInsertCommand对象
     * @param prpLIndemnityReceiptDto 参数prpLIndemnityReceiptDto
     * @throws Exception
     */
    public PrpLIndemnityReceiptInsertCommand(PrpLIndemnityReceiptDto prpLIndemnityReceiptDto)
            throws Exception{
    		this.params = new Object[]{prpLIndemnityReceiptDto };
    		this.paramTypes = new Class[]{PrpLIndemnityReceiptDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Thread.currentThread().setContextClassLoader(myClassLoader);
        Class loaderClass = myClassLoader.loadClass("com.sinosoft.claim.bl.facade.BLPrpLIndemnityReceiptFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
