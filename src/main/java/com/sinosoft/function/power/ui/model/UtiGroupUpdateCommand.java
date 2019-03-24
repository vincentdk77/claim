package com.sinosoft.function.power.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.function.power.dto.domain.UtiGroupDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLUtiGroupFacade的UI Command类<br>
 * 创建于 2004-11-09 10:41:01.428<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiGroupUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个UtiGroupUpdateCommand对象
     * @param utiGroupDto 参数utiGroupDto
     * @throws Exception
     */
    public UtiGroupUpdateCommand(UtiGroupDto utiGroupDto) throws Exception {
    		this.params = new Object[]{utiGroupDto };
    		this.paramTypes = new Class[]{UtiGroupDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.function.power.bl.facade.BLUtiGroupFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
