package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLbackVisitTextDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLbackVisitTextFacade的UI Command类<br>
 * 创建于 2005-03-23 09:00:42.640<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitTextUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLbackVisitTextUpdateCommand对象
     * @param prpLbackVisitTextDto 参数prpLbackVisitTextDto
     * @throws Exception
     */
    public PrpLbackVisitTextUpdateCommand(PrpLbackVisitTextDto prpLbackVisitTextDto) throws Exception {
    		this.params = new Object[]{prpLbackVisitTextDto };
    		this.paramTypes = new Class[]{PrpLbackVisitTextDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLbackVisitTextFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
