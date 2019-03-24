package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.SwfPackageDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfPackageFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.388<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfPackageInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个SwfPackageInsertCommand对象
     * @param wfPackageDto 参数wfPackageDto
     * @throws Exception
     */
    public SwfPackageInsertCommand(SwfPackageDto wfPackageDto) throws Exception {
    		this.params = new Object[]{wfPackageDto };
    		this.paramTypes = new Class[]{SwfPackageDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfPackageFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
