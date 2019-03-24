package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLqualityCheckDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLqualityCheckFacade的UI Command类<br>
 * 创建于 2005-04-14 15:56:49.796<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLqualityCheckInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLqualityCheckInsertCommand对象
     * @param prpLqualityCheckDto 参数prpLqualityCheckDto
     * @throws Exception
     */
    public PrpLqualityCheckInsertCommand(PrpLqualityCheckDto prpLqualityCheckDto) throws Exception {
    		this.params = new Object[]{prpLqualityCheckDto };
    		this.paramTypes = new Class[]{PrpLqualityCheckDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLqualityCheckFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
