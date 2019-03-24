package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLbackVisitQueDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLbackVisitQueFacade的UI Command类<br>
 * 创建于 2005-03-23 09:00:29.765<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitQueUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLbackVisitQueUpdateCommand对象
     * @param prpLbackVisitQueDto 参数prpLbackVisitQueDto
     * @throws Exception
     */
    public PrpLbackVisitQueUpdateCommand(PrpLbackVisitQueDto prpLbackVisitQueDto) throws Exception {
    		this.params = new Object[]{prpLbackVisitQueDto };
    		this.paramTypes = new Class[]{PrpLbackVisitQueDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLbackVisitQueFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
