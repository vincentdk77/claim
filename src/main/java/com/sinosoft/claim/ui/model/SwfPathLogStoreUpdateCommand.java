package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.SwfPathLogStoreDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLSwfPathLogStoreFacade的UI Command类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class SwfPathLogStoreUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个SwfPathLogStoreUpdateCommand对象
     * @param swfPathLogStoreDto 参数swfPathLogStoreDto
     * @throws Exception
     */
    public SwfPathLogStoreUpdateCommand(SwfPathLogStoreDto swfPathLogStoreDto)
            throws Exception{
    		this.params = new Object[]{swfPathLogStoreDto };
    		this.paramTypes = new Class[]{SwfPathLogStoreDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Thread.currentThread().setContextClassLoader(myClassLoader);
        Class loaderClass = myClassLoader.loadClass("com.sinosoft.claim.bl.facade.BLSwfPathLogStoreFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
