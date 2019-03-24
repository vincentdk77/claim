package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.ED_AGENT_INFODto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLED_AGENT_INFOFacade的UI Command类<br>
 * 创建于 2005-07-19 09:59:09.675<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class ED_AGENT_INFOUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个ED_AGENT_INFOUpdateCommand对象
     * @param eD_AGENT_INFODto 参数eD_AGENT_INFODto
     * @throws Exception
     */
    public ED_AGENT_INFOUpdateCommand(ED_AGENT_INFODto eD_AGENT_INFODto) throws Exception {
    		this.params = new Object[]{eD_AGENT_INFODto };
    		this.paramTypes = new Class[]{ED_AGENT_INFODto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLED_AGENT_INFOFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
