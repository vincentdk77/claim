package com.sinosoft.function.power.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.function.power.dto.domain.PrpDriskDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpDriskFacade的UI Command类<br>
 * 创建于 2004-11-09 10:40:57.893<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDriskUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpDriskUpdateCommand对象
     * @param prpDriskDto 参数prpDriskDto
     * @throws Exception
     */
    public PrpDriskUpdateCommand(PrpDriskDto prpDriskDto) throws Exception {
    		this.params = new Object[]{prpDriskDto };
    		this.paramTypes = new Class[]{PrpDriskDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.function.power.bl.facade.BLPrpDriskFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
