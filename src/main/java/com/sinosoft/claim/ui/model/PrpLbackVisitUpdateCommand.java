package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLbackVisitDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLbackVisitFacade的UI Command类<br>
 * 创建于 2005-03-25 20:44:51.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLbackVisitUpdateCommand对象
     * @param prpLbackVisitDto 参数prpLbackVisitDto
     * @throws Exception
     */
    public PrpLbackVisitUpdateCommand(PrpLbackVisitDto prpLbackVisitDto) throws Exception {
    		this.params = new Object[]{prpLbackVisitDto };
    		this.paramTypes = new Class[]{PrpLbackVisitDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLbackVisitFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
