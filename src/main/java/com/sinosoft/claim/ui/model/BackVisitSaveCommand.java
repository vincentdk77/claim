package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.custom.BackVisitDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

/**
 * 这是BLBackVisitFacade的UI Command类<br>
 * 创建于 2005-03-26 16:23:01.328<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BackVisitSaveCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个BackVisitSaveCommand对象
     * @param backVisitDto 参数backVisitDto
     * @param workFlowDto 参数workFlowDto
     * @throws Exception
     */
    public BackVisitSaveCommand(BackVisitDto backVisitDto ,WorkFlowDto workFlowDto) throws Exception {
    		this.params = new Object[]{backVisitDto  ,workFlowDto };
    		this.paramTypes = new Class[]{BackVisitDto.class  ,WorkFlowDto.class };
    }
    /**
     *  构造方法,构造一个BackVisitSaveCommand对象
     * @param backVisitDto 参数backVisitDto
     * @throws Exception
     */
    public BackVisitSaveCommand(BackVisitDto backVisitDto) throws Exception {
    		this.params = new Object[]{backVisitDto };
    		this.paramTypes = new Class[]{BackVisitDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLBackVisitFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("save",paramTypes);
        return method.invoke(object,params);
    }
}
