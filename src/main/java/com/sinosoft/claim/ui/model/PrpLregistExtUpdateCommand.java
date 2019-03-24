package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLregistExtFacade的UI Command类<br>
 * 创建于 2005-03-11 11:11:52.531<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLregistExtUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLregistExtUpdateCommand对象
     * @param prpLregistExtDto 参数prpLregistExtDto
     * @throws Exception
     */
    public PrpLregistExtUpdateCommand(PrpLregistExtDto prpLregistExtDto) throws Exception {
    		this.params = new Object[]{prpLregistExtDto };
    		this.paramTypes = new Class[]{PrpLregistExtDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLregistExtFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
