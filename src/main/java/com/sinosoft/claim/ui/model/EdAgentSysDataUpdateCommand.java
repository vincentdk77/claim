package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.EdAgentSysDataDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLEdAgentSysDataFacade的UI Command类<br>
 * 创建于 2005-07-19 09:59:09.665<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class EdAgentSysDataUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个EdAgentSysDataUpdateCommand对象
     * @param edAgentSysDataDto 参数edAgentSysDataDto
     * @throws Exception
     */
    public EdAgentSysDataUpdateCommand(EdAgentSysDataDto edAgentSysDataDto) throws Exception {
    		this.params = new Object[]{edAgentSysDataDto };
    		this.paramTypes = new Class[]{EdAgentSysDataDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLEdAgentSysDataFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
