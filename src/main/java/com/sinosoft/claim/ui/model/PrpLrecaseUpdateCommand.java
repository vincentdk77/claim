package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLclaimGradeFacade的UI Command类<br>
 * 创建于 2005-04-19 09:24:27.562<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLrecaseUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLclaimGradeUpdateCommand对象
     * @param prpLclaimGradeDto 参数prpLclaimGradeDto
     * @throws Exception
     */
    public PrpLrecaseUpdateCommand(PrpLrecaseDto prpLrecaseDto) throws Exception {
    		this.params = new Object[]{prpLrecaseDto };
    		this.paramTypes = new Class[]{PrpLrecaseDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLrecaseFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
