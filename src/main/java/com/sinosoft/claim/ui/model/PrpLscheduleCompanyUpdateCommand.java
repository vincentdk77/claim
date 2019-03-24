package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLscheduleCompanyDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLscheduleCompanyFacade的UI Command类<br>
 * 创建于 2005-08-20 17:56:04.119<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleCompanyUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLscheduleCompanyUpdateCommand对象
     * @param prpLscheduleCompanyDto 参数prpLscheduleCompanyDto
     * @throws Exception
     */
    public PrpLscheduleCompanyUpdateCommand(PrpLscheduleCompanyDto prpLscheduleCompanyDto) throws Exception {
    		this.params = new Object[]{prpLscheduleCompanyDto };
    		this.paramTypes = new Class[]{PrpLscheduleCompanyDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLscheduleCompanyFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
