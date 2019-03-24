package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLSwfLogFacade的UI Command类<br>
 * 创建于 2004-08-09 19:54:56.368<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfLogInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个SwfLogInsertCommand对象
     * @param wfLogDto 参数wfLogDto
     * @throws Exception
     */
    public SwfLogInsertCommand(SwfLogDto wfLogDto) throws Exception {
    		this.params = new Object[]{wfLogDto };
    		this.paramTypes = new Class[]{SwfLogDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfLogFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
