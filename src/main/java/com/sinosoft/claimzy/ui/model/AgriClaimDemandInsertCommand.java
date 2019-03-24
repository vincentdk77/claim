package com.sinosoft.claimzy.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class AgriClaimDemandInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��AGRICLAIMUPLOADLOGInsertCommand����
     * @param aGRICLAIMUPLOADLOGDto ����aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public AgriClaimDemandInsertCommand(AgriClaimUploadLogDto agriClaimUploadLogDto)
            throws Exception{
    		this.params = new Object[]{agriClaimUploadLogDto };
    		this.paramTypes = new Class[]{AgriClaimUploadLogDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Thread.currentThread().setContextClassLoader(myClassLoader);
        Class loaderClass = myClassLoader.loadClass("com.sinosoft.claimzy.bl.facade.BLAgriClaimDemandFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }

}
