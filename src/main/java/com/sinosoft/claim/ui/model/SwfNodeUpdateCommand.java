package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.SwfNodeDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfNodeFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.378<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfNodeUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个SwfNodeUpdateCommand对象
     * @param wfNodeDto 参数wfNodeDto
     * @throws Exception
     */
    public SwfNodeUpdateCommand(SwfNodeDto wfNodeDto) throws Exception {
    		this.params = new Object[]{wfNodeDto };
    		this.paramTypes = new Class[]{SwfNodeDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfNodeFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
