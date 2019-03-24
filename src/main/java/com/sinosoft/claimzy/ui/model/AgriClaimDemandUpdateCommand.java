package com.sinosoft.claimzy.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class AgriClaimDemandUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个AGRICLAIMUPLOADLOGUpdateCommand对象
     * @param aGRICLAIMUPLOADLOGDto 参数aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public AgriClaimDemandUpdateCommand(AgriClaimUploadLogDto agriClaimUploadDto)
            throws Exception{
    		this.params = new Object[]{agriClaimUploadDto };
    		this.paramTypes = new Class[]{AgriClaimUploadLogDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Thread.currentThread().setContextClassLoader(myClassLoader);
        Class loaderClass = myClassLoader.loadClass("com.sinosoft.claimzy.bl.facade.BLAgriClaimDemandFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }

}
