package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfModelUseFacade的UI Command类<br>
 * 创建于 2004-08-10 10:49:39.377<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfModelUseUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个SwfModelUseUpdateCommand对象
     * @param wfModelUseDto 参数wfModelUseDto
     * @throws Exception
     */
    public SwfModelUseUpdateCommand(SwfModelUseDto wfModelUseDto) throws Exception {
    		this.params = new Object[]{wfModelUseDto };
    		this.paramTypes = new Class[]{SwfModelUseDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfModelUseFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
