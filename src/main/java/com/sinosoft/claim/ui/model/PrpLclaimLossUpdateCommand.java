package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLclaimLossFacade的UI Command类<br>
 * 创建于 2004-06-24 14:46:42.929<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLclaimLossUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLclaimLossUpdateCommand对象
     * @param prpLclaimLossDto 参数prpLclaimLossDto
     * @throws Exception
     */
    public PrpLclaimLossUpdateCommand(PrpLclaimLossDto prpLclaimLossDto) throws Exception {
    		this.params = new Object[]{prpLclaimLossDto };
    		this.paramTypes = new Class[]{PrpLclaimLossDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLclaimLossFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
