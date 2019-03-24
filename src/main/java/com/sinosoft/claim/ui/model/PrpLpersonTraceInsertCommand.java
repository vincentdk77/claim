package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLpersonTraceFacade的UI Command类<br>
 * 创建于 2005-02-18 10:47:33.843<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLpersonTraceInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLpersonTraceInsertCommand对象
     * @param prpLpersonTraceDto 参数prpLpersonTraceDto
     * @throws Exception
     */
    public PrpLpersonTraceInsertCommand(PrpLpersonTraceDto prpLpersonTraceDto) throws Exception {
    		this.params = new Object[]{prpLpersonTraceDto };
    		this.paramTypes = new Class[]{PrpLpersonTraceDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLpersonTraceFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
