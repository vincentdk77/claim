package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfLogFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.368<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfLogInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��SwfLogInsertCommand����
     * @param wfLogDto ����wfLogDto
     * @throws Exception
     */
    public SwfLogInsertCommand(SwfLogDto wfLogDto) throws Exception {
    		this.params = new Object[]{wfLogDto };
    		this.paramTypes = new Class[]{SwfLogDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfLogFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
